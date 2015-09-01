package com.yfkey.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(RolePermissionId.class)
@Table(name = "role_permission")

public class RolePermission extends BaseObject implements Traceable {

	/**
	* 
	*/
	private static final long serialVersionUID = -3291803526702181083L;
	private String roleCode; // required
	private String permissionCode; // required
	private PermissionType permissionType; // required
	private String createUser;
	private Timestamp createDate;

	@Id
	@Column(name = "role_code", length = 20, nullable = false)
	public String getRoleCode() {
		return this.roleCode;
	}

	@Id
	@Column(name = "permission_code", length = 50, nullable = false)
	public String getPermissionCode() {
		return this.permissionCode;
	}

	@Id
	@Column(name = "permission_type", length = 1)
	@Enumerated(EnumType.STRING)
	public PermissionType getPermissionType() {
		return this.permissionType;
	}

	@Column(name = "create_user", length = 50, nullable = false, updatable = false)
	public String getCreateUser() {
		return createUser;
	}

	@Column(name = "create_date", nullable = false, updatable = false)
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permissionCode == null) ? 0 : permissionCode.hashCode());
		result = prime * result + ((permissionType == null) ? 0 : permissionType.hashCode());
		result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePermission other = (RolePermission) obj;
		if (permissionCode == null) {
			if (other.permissionCode != null)
				return false;
		} else if (!permissionCode.equals(other.permissionCode))
			return false;
		if (permissionType == null) {
			if (other.permissionType != null)
				return false;
		} else if (!permissionType.equals(other.permissionType))
			return false;
		if (roleCode == null) {
			if (other.roleCode != null)
				return false;
		} else if (!roleCode.equals(other.roleCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RolePermission [roleCode=" + roleCode + ", permissionCode=" + permissionCode + ", permissionType="
				+ permissionType + "]";
	}

}
