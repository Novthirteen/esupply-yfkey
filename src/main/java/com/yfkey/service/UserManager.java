package com.yfkey.service;

import java.util.List;

import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.PermissionType;
import com.yfkey.model.User;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface UserManager extends GenericManager<User, String> {
	void saveUserPermission(String username, PermissionType permissionType, List<String> assignedPermissions)
			throws PrincipalNullException;
	
	void saveUser(User user) throws PrincipalNullException;

	void updateUser(User user, boolean passwordChange) throws PrincipalNullException;

	void saveUserRole(String username, List<String> assignedRoles) throws PrincipalNullException;

	void deleteUser(String username);
	
	void saveUserPassword(String username, String password) throws PrincipalNullException;
}
