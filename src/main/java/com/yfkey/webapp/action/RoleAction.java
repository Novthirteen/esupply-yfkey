package com.yfkey.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.util.StringHelper;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;

import com.yfkey.model.LabelValue;
import com.yfkey.model.Permission;
import com.yfkey.model.PermissionType;
import com.yfkey.model.Role;
import com.yfkey.model.Supply;
import com.yfkey.model.User;
import com.yfkey.service.RoleManager;
import com.yfkey.service.UniversalManager;

/**
 * Action for facilitating Role Management feature.
 */
public class RoleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4453515369924540643L;

	private List<Role> roles;
	private Role role;
	private String code;
	private String permissionType;
	private List<LabelValue> availablePermissions;
	private List<String> assignedPermissions;
	private List<LabelValue> availableUsers;
	private List<String> assignedUsers;
	private RoleManager roleManager;
	private UniversalManager universalManager;

	/**
	 * Holder for roles to display on list screen
	 *
	 * @return list of roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<LabelValue> getAvailablePermissions() {
		return availablePermissions;
	}

	public void setAvailablePermissions(List<LabelValue> availablePermissions) {
		this.availablePermissions = availablePermissions;
	}

	public List<String> getAssignedPermissions() {
		return assignedPermissions;
	}

	public void setAssignedPermissions(List<String> assignedPermissions) {
		this.assignedPermissions = assignedPermissions;
	}

	public List<LabelValue> getAvailableUsers() {
		return availableUsers;
	}

	public void setAvailableUsers(List<LabelValue> availableUsers) {
		this.availableUsers = availableUsers;
	}

	public List<String> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(List<String> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public void setUniversalManager(UniversalManager universalManager) {
		this.universalManager = universalManager;
	}

	public List<LabelValue> getPermissionTypeList() {
		List<LabelValue> permissionTypeList = new ArrayList<LabelValue>();
		permissionTypeList.add(new LabelValue(PermissionType.U.toString(), getText("permission.url")));
		permissionTypeList.add(new LabelValue(PermissionType.B.toString(), getText("permission.button")));
		permissionTypeList.add(new LabelValue(PermissionType.S.toString(), getText("permission.supplier")));
		permissionTypeList.add(new LabelValue(PermissionType.P.toString(), getText("permission.plant")));

		return permissionTypeList;
	}

	/**
	 * Delete the role passed in.
	 *
	 * @return success
	 */
	public String delete() {
		try {
			this.roleManager.deleteRole(role.getCode());
			List<Object> args = new ArrayList<Object>();
			args.add(role.getCode());
			saveMessage(getText("role.deleted", args));
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			prepare();
			return INPUT;
		}

		return CANCEL;
	}

	/**
	 * Grab the role from the database based on the "roleName" passed in.
	 *
	 * @return success if role found
	 * @throws IOException
	 *             can happen when sending a "forbidden" from
	 *             response.sendError()
	 */
	public String edit() throws IOException {

		// if a roleCode is passed in
		if (code != null) {
			prepare();
		} else {
			role = new Role();
		}

		return SUCCESS;
	}

	/**
	 * Default: just returns "success"
	 *
	 * @return "success"
	 */
	public String execute() {
		return SUCCESS;
	}

	/**
	 * Sends roles to "mainMenu" when !from.equals("list"). Sends everyone else
	 * to "cancel"
	 *
	 * @return "mainMenu" or "cancel"
	 */
	public String cancel() {
		return CANCEL;
	}

	/**
	 * Save role
	 *
	 * @return success if everything worked, otherwise input
	 * @throws Exception
	 *             when setting "access denied" fails on response
	 */
	public String save() throws Exception {
		try {
			List<Object> args = new ArrayList<Object>();
			args.add(role.getCode());
			if (role.getVersion() == 0) {
				if (!universalManager.exists(Role.class, role.getCode())) {
					universalManager.save(role);
					saveMessage(getText("role.created", args));
				} else {
					return showRoleExistsException();
				}
			} else {
				universalManager.update(role);
				saveMessage(getText("role.updated", args));
			}
		} catch (HibernateOptimisticLockingFailureException ex) {
			saveErrorForStaleObjectStateException();
			prepare();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			prepare();
			return INPUT;
		}

		prepare();
		return SUCCESS;
	}

	/**
	 * Fetch all roles from database and put into local "roles" variable for
	 * retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		query();
		return SUCCESS;
	}

	public String saveRolePermission() {
		try {
			this.roleManager.saveRolePermission(code, PermissionType.valueOf(permissionType), assignedPermissions);
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			prepare();
			return INPUT;
		}

		prepare();
		List<Object> args = new ArrayList<Object>();
		args.add(role.getCode());
		saveMessage(getText("role.assignPermissionSuccess", args));
		return SUCCESS;
	}

	public String saveRoleUser() {
		try {
			this.roleManager.saveRoleUser(code, assignedUsers);
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			prepare();
			return INPUT;
		}

		prepare();
		List<Object> args = new ArrayList<Object>();
		args.add(role.getCode());
		saveMessage(getText("role.assignUserSuccess", args));
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	private void query() {
		String hql = "from Role where 1=1 ";
		List<Object> args = new ArrayList<Object>();

		if (role != null) {
			if (role.getCode() != null && role.getCode().trim().length() != 0) {
				hql += "and code like ? ";
				args.add("%" + role.getCode() + "%");
			}

			if (role.getName() != null && role.getName().trim().length() != 0) {
				hql += "and name like ? ";
				args.add("%" + role.getName() + "%");
			}
		}

		roles = universalManager.findByHql(hql, args.toArray());
	}

	private void prepare() {
		if (role == null && StringHelper.isNotEmpty(code)) {
			role = (Role) this.universalManager.get(Role.class, code);
		}

		if (role != null && role.getVersion() != 0) {
			prepareAssignPermission();
			prepareAssignUser();
		}
	}

	private void prepareAssignPermission() {

		List<Permission> availablePermissionList = universalManager.findByHql("from Permission where type = ?",
				new Object[] { permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U });

		this.availablePermissions = transferPermissionToLabelValue(availablePermissionList);

		List<String> assignedPermissionList = universalManager
				.findByHql("select permissionCode from RolePermission where permissionType = ? and roleCode = ?",
						new Object[] {
								permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U,
								code });

		this.assignedPermissions = assignedPermissionList;
	}

	private void prepareAssignUser() {
		List<User> availableUserList = universalManager.getAll(User.class);

		List<String> assignedUserList = universalManager.findByHql("select username from UserRole where roleCode = ?",
				new Object[] { code });

		this.assignedUsers = assignedUserList;
		this.availableUsers = transferUserToLabelValue(availableUserList);
	}

	private List<LabelValue> transferPermissionToLabelValue(List<Permission> permissionList) {
		List<LabelValue> lvList = new ArrayList<LabelValue>();
		if (permissionList != null && permissionList.size() > 0) {
			for (Permission permission : permissionList) {
				lvList.add(new LabelValue(permission.getName(), permission.getCode()));
			}
		}

		return lvList;
	}

	private List<LabelValue> transferUserToLabelValue(List<User> userList) {
		List<LabelValue> lvList = new ArrayList<LabelValue>();
		if (userList != null && userList.size() > 0) {
			for (User user : userList) {
				lvList.add(new LabelValue(user.getFullName(), user.getUsername()));
			}
		}

		return lvList;
	}

	private String showRoleExistsException() {
		List<Object> args = new ArrayList<Object>();
		args.add(role.getCode());
		addActionError(getText("role.errors.existingRole", args));

		return INPUT;
	}

}
