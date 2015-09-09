package com.yfkey.service.impl;

import java.util.List;

import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.PermissionType;
import com.yfkey.model.Role;
import com.yfkey.model.RolePermission;
import com.yfkey.model.UserRole;
import com.yfkey.service.RoleManager;
import com.yfkey.service.UniversalManager;

/**
 * Implementation of RoleManager interface.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("roleManager")
public class RoleManagerImpl extends GenericManagerImpl<Role, String>implements RoleManager {
	@Autowired
	private UniversalManager universalManager;

	@Override
	public void saveRolePermission(String roleCode, PermissionType permissionType, List<String> assignedPermissions)
			throws PrincipalNullException {
		this.universalManager.executeByHql("delete from RolePermission where roleCode = ? and permissionType = ?",
				new Object[] { roleCode, permissionType });

		if (!CollectionHelper.isEmpty(assignedPermissions)) {
			for (String assignedPermission : assignedPermissions) {
				RolePermission rolePermission = new RolePermission();

				rolePermission.setRoleCode(roleCode);
				rolePermission.setPermissionType(permissionType);
				rolePermission.setPermissionCode(assignedPermission);

				this.universalManager.save(rolePermission);
			}
		}
	}

	@Override
	public void saveRoleUser(String roleCode, List<String> assignedUsers) throws PrincipalNullException {
		this.universalManager.executeByHql("delete from UserRole where roleCode = ?", new Object[] { roleCode });

		if (!CollectionHelper.isEmpty(assignedUsers)) {
			for (String assignedUser : assignedUsers) {
				UserRole userRole = new UserRole();

				userRole.setRoleCode(roleCode);
				userRole.setUsername(assignedUser);

				this.universalManager.save(userRole);
			}
		}

	}

	public void deleteRole(String roleCode) {
		this.universalManager.executeByHql("delete from RolePermission where roleCode = ?", new Object[] { roleCode });

		this.universalManager.remove(Role.class, roleCode);
	}
}