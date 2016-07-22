package com.yfkey.webapp.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.hibernate.internal.util.StringHelper;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.opensymphony.xwork2.Preparable;
import com.yfkey.Constants;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.exception.UserPasswordNotValidException;
import com.yfkey.model.Gender;
import com.yfkey.model.LabelValue;
import com.yfkey.model.LabelValueComparator;
import com.yfkey.model.Permission;
import com.yfkey.model.PermissionType;
import com.yfkey.model.Role;
import com.yfkey.model.User;
import com.yfkey.model.UserAuthority;
import com.yfkey.model.UserPasswordLog;
import com.yfkey.service.UniversalManager;
import com.yfkey.service.UserManager;
import com.yfkey.util.NativeSqlRepository;
import com.yfkey.webapp.util.SecurityContextHelper;

/**
 * Action for facilitating User Management feature.
 */
public class UserAction extends BaseAction implements Preparable {
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
	private Boolean canSave;
	private Boolean canDelete;
	private Boolean canAssignUserPermission;
	private Boolean canAssignUserRole;

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

	public Boolean getCanSave() {
		return canSave;
	}

	public void setCanSave(Boolean canSave) {
		this.canSave = canSave;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

	public Boolean getCanAssignUserPermission() {
		return canAssignUserPermission;
	}

	public void setCanAssignUserPermission(Boolean canAssignUserPermission) {
		this.canAssignUserPermission = canAssignUserPermission;
	}

	public Boolean getCanAssignUserRole() {
		return canAssignUserRole;
	}

	public void setCanAssignUserRole(Boolean canAssignUserRole) {
		this.canAssignUserRole = canAssignUserRole;
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

	public String home() throws PrincipalNullException {
		HttpSession session = this.getRequest().getSession();

		try {
			user = SecurityContextHelper.getRemoteUser();
			session.setAttribute(Constants.FORCE_CHANGE_PASSWORD, false);
			
		} catch (PrincipalNullException e) {
			return ERROR;
		}

		if (user.isNeedUpdatePassword()) {
			session.setAttribute(Constants.FORCE_CHANGE_PASSWORD, true);
		}
		if (user.isEnforcePassword()) {
			List<UserPasswordLog> userPasswordLogList = this.universalManager.findByHql(
					"from UserPasswordLog where username = ? order by createDate desc", user.getUsername(), 1);

			if (userPasswordLogList != null && userPasswordLogList.size() > 0) {
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, -3);

				if (userPasswordLogList.get(0).getCreateDate().compareTo(cal.getTime()) < 0) {
					user.setConfirmPassword(user.getPassword());
					session.setAttribute(Constants.FORCE_CHANGE_PASSWORD, true);
				}
			} else {
				UserPasswordLog userPasswordLog = new UserPasswordLog();
				userPasswordLog.setUsername(user.getUsername());
				userPasswordLog.setPassword(user.getPassword());
				userPasswordLog.setCreateDate(new Timestamp((new Date()).getTime()));

				this.universalManager.save(userPasswordLog);
			}
		}
//		if (session.getAttribute(Constants.FORCE_CHANGE_PASSWORD_CHECK) == null) {
//			session.setAttribute(Constants.FORCE_CHANGE_PASSWORD_CHECK, false);
//		}

		if (session.getAttribute(Constants.SELECTED_USER_PLANT) == null) {
			Collection<UserAuthority> userPlants = SecurityContextHelper.getRemoteUserPlants();

			if (CollectionHelper.isEmpty(userPlants)) {
				addActionError(getText("user.noAvailablePlant"));
				return ERROR;
			} else {
				// if (userPlants.size() == 1) {
				session.setAttribute(Constants.SELECTED_USER_PLANT, userPlants.iterator().next().getAuthority());
				// }

				if (session.getAttribute(Constants.AVAILABLE_USER_PLANTS) == null) {
					List<LabelValue> availableUserPlants = new ArrayList<LabelValue>();
					for (UserAuthority userAuthority : userPlants) {
						availableUserPlants
								.add(new LabelValue(userAuthority.getAuthorityName(), userAuthority.getAuthority()));
					}

					// availableUserPlants.sort(labelValueComparator);

					session.setAttribute(Constants.AVAILABLE_USER_PLANTS, availableUserPlants);
				}

				if (user.getDomain() != null && !"".equals(user.getDomain())) {
					session.setAttribute(Constants.SELECTED_USER_PLANT, user.getDomain());
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
	public String saveUser() throws Exception {
		try {
			List<Object> args = new ArrayList<Object>();
			args.add(user.getUsername());
			if (user.getVersion() == 0) {
				if (!universalManager.exists(User.class, user.getUsername())) {
					this.encodePassword(user);
					this.userManager.saveUser(user);
					saveMessage(getText("user.added", args));
				} else {
					return showUserExistsException();
				}
			} else {

				final String currentPassword = (String) this.universalManager
						.findByNativeSql(NativeSqlRepository.SELECT_USER_PASSWORD_STATEMENT, user.getUsername()).get(0);
				if (!currentPassword.equals(user.getPassword())) {
					this.encodePassword(user);
					this.userManager.updateUser(user, true);
				} else {
					this.userManager.updateUser(user, false);
				}

				saveMessage(getText("user.updated", args));
			}
		} catch (UserPasswordNotValidException ex) {
			addActionError(ex.getMessage());
			prepare();
			return INPUT;
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

	public String saveUserProfile() throws Exception {
		try {
			List<Object> args = new ArrayList<Object>();
			args.add(user.getUsername());
			final String currentPassword = (String) this.universalManager
					.findByNativeSql(NativeSqlRepository.SELECT_USER_PASSWORD_STATEMENT, user.getUsername()).get(0);
			if (!currentPassword.equals(user.getPassword())) {
				this.encodePassword(user);
				this.userManager.updateUser(user, true);
			} else {
				this.userManager.updateUser(user, false);
			}

			saveMessage(getText("user.updated", args));
		} catch (UserPasswordNotValidException ex) {
			addActionError(ex.getMessage());
			prepare();
			return INPUT;
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
			if (getRequest().getParameter("assignedPermissions") == null) {
				assignedPermissions = null;
			}
			String domain = this.getCurrentDomain();
			this.userManager.saveUserPermission(username, domain, PermissionType.valueOf(permissionType),
					assignedPermissions);
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
			if (getRequest().getParameter("assignedRoles") == null) {
				assignedRoles = null;
			}
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

	public String savePassword() {
		try {
			user.setUsername(username);
			List<Object> args = new ArrayList<Object>();
			args.add(user.getUsername());
			user.setEnforcePassword(true);
			encodePassword(user);
			this.userManager.saveUserPassword(user.getUsername(), user.getPassword());
			saveMessage(getText("user.passwordChanged", args));
		} catch (UserPasswordNotValidException ex) {
			addActionError(ex.getMessage());
			return ERROR;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return ERROR;
		}

		this.getRequest().getSession().removeAttribute(Constants.FORCE_CHANGE_PASSWORD);
		prepare();
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

			// if (user.getLastName() != null &&
			// user.getLastName().trim().length() != 0) {
			// hql += "and lastName like ? ";
			// args.add("%" + user.getLastName() + "%");
			// }
		}

		users = universalManager.findByHql(hql, args.toArray());
	}

	@SuppressWarnings("unused")
	public void prepare() {

		if (StringHelper.isEmpty(username)) {
			username = this.getRequest().getParameter("username");
		}

		if (user == null && StringHelper.isNotEmpty(username)) {
			user = (User) this.universalManager.get(User.class, username);
		}

		if (user != null && user.getVersion() != 0) {
			user.setConfirmPassword(user.getPassword());
			prepareAssignPermission();
			prepareAssignRole();
		}

		// 按钮权限
		canSave = false;
		canDelete = false;
		canAssignUserPermission = false;
		canAssignUserRole = false;

		List<UserAuthority> userButtons = (List<UserAuthority>) SecurityContextHelper.getRemoteUserButtons();
		if (userButtons != null && userButtons.size() > 0) {
			for (UserAuthority u : userButtons) {
				if (!canSave && u.getAuthority().equals("SaveUser")) {
					canSave = true;
				}
				if (!canDelete && u.getAuthority().equals("DeleteUser")) {
					canDelete = true;
				}
				if (!canAssignUserPermission && u.getAuthority().equals("AssignUserPermission")) {
					canAssignUserPermission = true;
				}
				if (!canAssignUserRole && u.getAuthority().equals("AssignUserRole")) {
					canAssignUserRole = true;
				}
			}
		}
	}

	public String logout() {
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	private void prepareAssignPermission() {

		if (permissionType != null && PermissionType.valueOf(permissionType) == PermissionType.S) {
			String domain = this.getCurrentDomain();
			List<Permission> availablePermissionList = universalManager
					.findByHql("from Permission where type = ? and code like ?",
							new Object[] {
									permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U,
									domain + "%" });
			this.availablePermissions = transferPermissionToLabelValue(availablePermissionList);

			List<String> assignedPermissionList = universalManager
					.findByHql(
							"select permissionCode from UserPermission where permissionType = ? and username = ? and permissionCode like ?",
							new Object[] {
									permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U,
									username, domain + "%" });
			this.assignedPermissions = assignedPermissionList;

		} else {

			List<Permission> availablePermissionList = universalManager.findByHql("from Permission where type = ?",
					new Object[] {
							permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U });
			this.availablePermissions = transferPermissionToLabelValue(availablePermissionList);

			List<String> assignedPermissionList = universalManager
					.findByHql("select permissionCode from UserPermission where permissionType = ? and username = ?",
							new Object[] {
									permissionType != null ? PermissionType.valueOf(permissionType) : PermissionType.U,
									username });

			this.assignedPermissions = assignedPermissionList;
		}
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

	private void encodePassword(User user) throws UserPasswordNotValidException {
		String password = user.getPassword().trim();
		if (user.isEnforcePassword()) {
			if (password.length() < 8) {
				throw new UserPasswordNotValidException(getText("user.password.error.minlength"));
			}

			if (containLetterTypes(password) < 3) {
				throw new UserPasswordNotValidException(getText("user.password.error.letterTypes"));
			}

			List<UserPasswordLog> userPasswordLogList = this.universalManager.findByHql(
					"from UserPasswordLog where username = ? order by createDate desc", user.getUsername(), 3);

			if (userPasswordLogList != null && userPasswordLogList.size() > 0) {
				for (UserPasswordLog userPasswordLog : userPasswordLogList) {
					if (passwordEncoder.matches(password, userPasswordLog.getPassword())) {
						throw new UserPasswordNotValidException(getText("user.password.error.passwordAge"));
					}
				}
			}
		}

		user.setPassword(passwordEncoder.encode(password));
	}

	private int containLetterTypes(String str) {
		int letterTypes = 0;
		if (containDigit(str)) {
			letterTypes++;
		}

		if (containSmallLetter(str)) {
			letterTypes++;
		}

		if (containCapitalLetter(str)) {
			letterTypes++;
		}

		if (containSpecialLetter(str)) {
			letterTypes++;
		}

		return letterTypes;
	}

	private boolean containDigit(String str) {
		String regex = ".*[0-9]+.*";
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}

	private boolean containSmallLetter(String str) {
		String regex = ".*[a-z]+.*";
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}

	private boolean containCapitalLetter(String str) {
		String regex = ".*[A-Z]+.*";
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}

	private boolean containSpecialLetter(String str) {
		String regex = ".*[^a-zA-Z0-9]+.*";
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}
}
