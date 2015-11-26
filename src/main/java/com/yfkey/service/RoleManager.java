package com.yfkey.service;

import com.yfkey.model.PermissionType;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.Role;

import java.util.List;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface RoleManager extends GenericManager<Role, String> {
	void saveRolePermission(String roleCode,String domain, PermissionType permissionType, List<String> assignedPermissions)
			throws PrincipalNullException;

	void saveRoleUser(String roleCode, List<String> assignedUsers) throws PrincipalNullException;

	void deleteRole(String roleCode);
}
