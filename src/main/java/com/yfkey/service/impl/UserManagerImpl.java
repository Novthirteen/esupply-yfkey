package com.yfkey.service.impl;

import java.util.ArrayList;
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
import com.yfkey.model.UserPermission;
import com.yfkey.model.UserRole;
import com.yfkey.service.UniversalManager;
import com.yfkey.service.UserManager;
import com.yfkey.service.UserService;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("userManager")
@WebService(serviceName = "UserService", endpointInterface = "com.yfkey.service.UserService")
public class UserManagerImpl extends GenericManagerImpl<User, String>implements UserManager, UserService {
	@Autowired
	private UniversalManager universalManager;

	@Autowired
	private UserDao userDao;
	
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

		this.universalManager.remove(User.class, username);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<User> getUsers() {
		return userDao.getAllDistinct();
	}
	
	public User getUser(String username) {
		return (User) userDao.loadUserByUsername(username);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param username
	 *            the login name of the human
	 * @return User the populated user object
	 * @throws UsernameNotFoundException
	 *             thrown when username not found
	 */
	public User getUserByUsername(String username) throws UsernameNotFoundException {
		return (User) userDao.loadUserByUsername(username);
	}
	
	public List<String> getData(String query)
	{
		List<String> data = new ArrayList<String>();
		
		data.add("chinese");
		data.add("american");
		data.add("janpenes");
		data.add("korea");
		data.add("sigapo");
		return data;
	}

}
