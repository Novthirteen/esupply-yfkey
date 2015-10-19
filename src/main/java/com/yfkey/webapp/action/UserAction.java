package com.yfkey.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.internal.util.StringHelper;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yfkey.model.Gender;
import com.yfkey.Constants;
import com.yfkey.model.LabelValue;
import com.yfkey.model.LabelValueComparator;
import com.yfkey.model.Permission;
import com.yfkey.model.PermissionType;
import com.yfkey.model.Role;
import com.yfkey.model.Supply;
import com.yfkey.model.User;
import com.yfkey.model.UserAuthority;
import com.yfkey.service.UniversalManager;
import com.yfkey.service.UserManager;
import com.yfkey.util.NativeSqlRepository;
import com.yfkey.webapp.util.SecurityContextHelper;

/**
 * Action for facilitating User Management feature.
 */
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 6776558938712115191L;
	private List<User> users;
	private User user;
	private String username;
	private String plantCode;
	private String permissionType;
	private List<LabelValue> availablePermissions;
	private List<String> assignedPermissions;
	private List<LabelValue> availableRoles;
	private List<String> assignedRoles;
	private UserManager userManager;
	private UniversalManager universalManager;
	private PasswordEncoder passwordEncoder;
	private LabelValueComparator labelValueComparator = new LabelValueComparator();

	/**
	 * Holder for users to display on list screen
	 *
	 * @return list of users
	 */
	public List<User> getUsers() {
		return users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPlantCode() {
		return plantCode;
	}

	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
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

	public List<LabelValue> getAvailableRoles() {
		return availableRoles;
	}

	public void setAvailableRoles(List<LabelValue> availableRoles) {
		this.availableRoles = availableRoles;
	}

	public List<String> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<String> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setUniversalManager(UniversalManager universalManager) {
		this.universalManager = universalManager;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public List<LabelValue> getPermissionTypeList() {
		List<LabelValue> permissionTypeList = new ArrayList<LabelValue>();
		permissionTypeList.add(new LabelValue(PermissionType.U.toString(), getText("permission.url")));
		permissionTypeList.add(new LabelValue(PermissionType.B.toString(), getText("permission.button")));
		permissionTypeList.add(new LabelValue(PermissionType.S.toString(), getText("permission.supplier")));
		permissionTypeList.add(new LabelValue(PermissionType.P.toString(), getText("permission.plant")));

		return permissionTypeList;
	}

	public List<LabelValue> getGenderList() {
		List<LabelValue> genderList = new ArrayList<LabelValue>();
		genderList.add(new LabelValue(Gender.M.toString(), getText("gender.male")));
		genderList.add(new LabelValue(Gender.F.toString(), getText("gender.female")));

		return genderList;
	}

	public String home() {
		if (this.getRequest().getSession().getAttribute(Constants.SELECTED_USER_PLANT) == null) {
			Collection<UserAuthority> userPlants = SecurityContextHelper.getRemoteUserPlants();

			if (CollectionHelper.isEmpty(userPlants)) {
				addActionError(getText("user.noAvailablePlant"));
				return ERROR;
			} else {
				if (userPlants.size() == 1) {
					this.getRequest().getSession().setAttribute(Constants.SELECTED_USER_PLANT,
							userPlants.iterator().next().getAuthority());
				}

				if (this.getRequest().getSession().getAttribute(Constants.AVAILABLE_USER_PLANTS) == null) {
					List<LabelValue> availableUserPlants = new ArrayList<LabelValue>();
					for (UserAuthority userAuthority : userPlants) {
						availableUserPlants
								.add(new LabelValue(userAuthority.getAuthorityName(), userAuthority.getAuthority()));
					}

					availableUserPlants.sort(labelValueComparator);

					this.getRequest().getSession().setAttribute(Constants.AVAILABLE_USER_PLANTS, availableUserPlants);
				}
			}
		}

		return SUCCESS;
	}

	public String selectUserPlant() {
		this.getRequest().getSession().setAttribute(Constants.SELECTED_USER_PLANT, plantCode);
		return SUCCESS;
	}

	/**
	 * Delete the user passed in.
	 *
	 * @return success
	 */
	public String delete() {
		try {
			this.userManager.deleteUser(user.getUsername());
			List<Object> args = new ArrayList<Object>();
			args.add(user.getUsername());
			saveMessage(getText("user.deleted", args));
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			prepare();
			return INPUT;
		}

		return CANCEL;
	}

	/**
	 * Grab the user from the database based on the "id" passed in.
	 *
	 * @return success if user found
	 * @throws IOException
	 *             can happen when sending a "forbidden" from
	 *             response.sendError()
	 */
	public String edit() throws IOException {
		if (username != null) {
			prepare();
		} else {
			user = new User();
		}

		return SUCCESS;
	}

	public String editProfile() throws IOException {
		username = this.getRequest().getRemoteUser();
		prepare();

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
	 * Sends users to "home" when !from.equals("list"). Sends everyone else to
	 * "cancel"
	 *
	 * @return "home" or "cancel"
	 */
	public String cancel() {
		return CANCEL;
	}

	/**
	 * Save user
	 *
	 * @return success if everything worked, otherwise input
	 * @throws Exception
	 *             when setting "access denied" fails on response
	 */
	public String save() throws Exception {
		try {
			List<Object> args = new ArrayList<Object>();
			args.add(user.getUsername());
			if (user.getVersion() == 0) {
				if (!universalManager.exists(User.class, user.getUsername())) {
					user.setPassword(passwordEncoder.encode(user.getPassword()));
					universalManager.save(user);
					saveMessage(getText("user.created", args));
				} else {
					return showUserExistsException();
				}
			} else {

				final String currentPassword = (String) this.universalManager
						.findByNativeSql(NativeSqlRepository.SELECT_USER_PASSWORD_STATEMENT, user.getUsername()).get(0);
				if (!currentPassword.equals(user.getPassword())) {
					user.setPassword(passwordEncoder.encode(user.getPassword()));
				}
				universalManager.update(user);
				saveMessage(getText("user.updated", args));
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
	 * Fetch all users from database and put into local "users" variable for
	 * retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		query();
		return SUCCESS;
	}

	public String saveUserPermission() {
		try {
			this.userManager.saveUserPermission(username, PermissionType.valueOf(permissionType), assignedPermissions);
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			prepare();
			return INPUT;
		}

		prepare();
		List<Object> args = new ArrayList<Object>();
		args.add(user.getUsername());
		saveMessage(getText("user.assignPermissionSuccess", args));
		return SUCCESS;
	}

	public String saveUserRole() {
		try {
			this.userManager.saveUserRole(username, assignedRoles);
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			prepare();
			return INPUT;
		}

		prepare();
		List<Object> args = new ArrayList<Object>();
		args.add(user.getUsername());
		saveMessage(getText("user.assignRoleSuccess", args));
		return SUCCESS;
	}

	private void query() {
		String hql = "from User where 1=1 ";
		List<Object> args = new ArrayList<Object>();

		if (user != null) {
			if (user.getUsername() != null && user.getUsername().trim().length() != 0) {
				hql += "and username like ? ";
				args.add("%" + user.getUsername() + "%");
			}

			if (user.getFirstName() != null && user.getFirstName().trim().length() != 0) {
				hql += "and firstName like ? ";
				args.add("%" + user.getFirstName() + "%");
			}

			if (user.getLastName() != null && user.getLastName().trim().length() != 0) {
				hql += "and lastName like ? ";
				args.add("%" + user.getLastName() + "%");
			}
		}

		users = universalManager.findByHql(hql, args.toArray());
	}

	private void prepare() {
		if (user == null && StringHelper.isNotEmpty(username)) {
			user = (User) this.universalManager.get(User.class, username);
		}

		if (user != null && user.getVersion() != 0) {
			user.setConfirmPassword(user.getPassword());
			prepareAssignPermission();
			prepareAssignRole();
		}
	}

	private void prepareAssignPermission() {

		List<Permission> availablePermissionList = universalManager.findByHql("from Permission where type = ?",
				new Object[] { permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U });
		this.availablePermissions = transferPermissionToLabelValue(availablePermissionList);

		List<String> assignedPermissionList = universalManager
				.findByHql("select permissionCode from UserPermission where permissionType = ? and username = ?",
						new Object[] {
								permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U,
								username });

		this.assignedPermissions = assignedPermissionList;

	}

	private void prepareAssignRole() {
		List<Role> availableRoleList = universalManager.getAll(Role.class);

		List<String> assignedRoleList = universalManager.findByHql("select roleCode from UserRole where username = ?",
				new Object[] { username });

		this.assignedRoles = assignedRoleList;
		this.availableRoles = transferRoleToLabelValue(availableRoleList);
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

	private List<LabelValue> transferRoleToLabelValue(List<Role> roleList) {
		List<LabelValue> lvList = new ArrayList<LabelValue>();
		if (roleList != null && roleList.size() > 0) {
			for (Role role : roleList) {
				lvList.add(new LabelValue(role.getName(), role.getCode()));
			}
		}

		return lvList;
	}

	private String showUserExistsException() {
		List<Object> args = new ArrayList<Object>();
		args.add(user.getUsername());
		addActionError(getText("user.errors.existingUser", args));

		return INPUT;
	}
}
