package com.yfkey.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yfkey.dao.UserDao;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.PermissionType;
import com.yfkey.model.User;
import com.yfkey.model.UserPasswordLog;
import com.yfkey.model.UserPermission;
import com.yfkey.model.UserRole;
import com.yfkey.service.UniversalManager;
import com.yfkey.service.UserManager;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("userManager")
@WebService(serviceName = "UserService", endpointInterface = "com.yfkey.service.UserService")
public class UserManagerImpl extends GenericManagerImpl<User, String>implements UserManager {
	@Autowired
	private UniversalManager universalManager;

	@Autowired
	private UserDao userDao;
	
	public void saveUser(User user) throws PrincipalNullException {
		this.universalManager.save(user);
		
		if (user.isEnforcePassword()) {
			UserPasswordLog userPasswordLog = new UserPasswordLog();
			userPasswordLog.setUsername(user.getUsername());
			userPasswordLog.setPassword(user.getPassword());
			userPasswordLog.setCreateDate(new Timestamp((new Date()).getTime()));
			this.universalManager.save(userPasswordLog);
		}
	}
	
	public void updateUser(User user, boolean passwordChange) throws PrincipalNullException {
		this.universalManager.update(user);
		
		if (passwordChange && user.isEnforcePassword()) {
			UserPasswordLog userPasswordLog = new UserPasswordLog();
			userPasswordLog.setUsername(user.getUsername());
			userPasswordLog.setPassword(user.getPassword());
			userPasswordLog.setCreateDate(new Timestamp((new Date()).getTime()));
			this.universalManager.save(userPasswordLog);
		}
	}
	
	@Override
	public void saveUserPermission(String username, PermissionType permissionType, List<String> assignedPermissions)
			throws PrincipalNullException {
		this.universalManager.executeByHql("delete from UserPermission where username = ? and permissionType = ?",
				new Object[] { username, permissionType });

		if (!CollectionHelper.isEmpty(assignedPermissions)) {
			for (String assignedPermission : assignedPermissions) {
				UserPermission userPermission = new UserPermission();

				userPermission.setUsername(username);
				userPermission.setPermissionType(permissionType);
				userPermission.setPermissionCode(assignedPermission);

				this.universalManager.save(userPermission);
			}
		}
	}

	@Override
	public void saveUserRole(String username, List<String> assignedRoles) throws PrincipalNullException {
		this.universalManager.executeByHql("delete from UserRole where username = ?", new Object[] { username });

		if (!CollectionHelper.isEmpty(assignedRoles)) {
			for (String assignedRole : assignedRoles) {
				UserRole userRole = new UserRole();

				userRole.setRoleCode(assignedRole);
				userRole.setUsername(username);

				this.universalManager.save(userRole);
			}
		}

	}

	public void deleteUser(String username) {
		this.universalManager.executeByHql("delete from UserPermission where username = ?", new Object[] { username });
		this.universalManager.executeByHql("delete from UserRole where username = ?", new Object[] { username });
		this.universalManager.executeByHql("delete from UserPasswordLog where username = ?", new Object[] { username });

		this.universalManager.remove(User.class, username);
	}
	
	
	public void saveUserPassword(String username, String password) throws PrincipalNullException {
		User user = this.userDao.get(username);
		user.setPassword(password);
		this.universalManager.update(user);
		
		UserPasswordLog userPasswordLog = new UserPasswordLog();
		userPasswordLog.setUsername(username);
		userPasswordLog.setPassword(password);
		userPasswordLog.setCreateDate(new Timestamp((new Date()).getTime()));
		this.universalManager.save(userPasswordLog);
	}
}
