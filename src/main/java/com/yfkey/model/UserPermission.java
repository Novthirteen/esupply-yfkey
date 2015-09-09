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
@IdClass(UserPermissionId.class)
@Table(name = "user_permission")
public class UserPermission extends BaseObject implements Traceable {

	/**
	* 
	*/
	private static final long serialVersionUID = 9053423844348595443L;
	private String username; // required
	private String permissionCode; // required
	private PermissionType permissionType; // required
	private String createUser;
	private Timestamp createDate;

	@Id
	@Column(length = 50)
	public String getUsername() {
		return this.username;
	}

	@Id
	@Column(name = "permission_code", length = 50, nullable = false)
	public String getPermissionCode() {
		return this.permissionCode;
	}

	@Id
	@Column(name = "permission_type", length = 1, nullable = false)
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

	public void setUsername(String username) {
		this.username = username;
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
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserPermission other = (UserPermission) obj;
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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RolePermission [username=" + username + ", permissionCode=" + permissionCode + ", permissionType="
				+ permissionType + "]";
	}
}
