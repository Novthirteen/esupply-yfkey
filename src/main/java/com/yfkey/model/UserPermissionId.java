package com.yfkey.model;

import java.io.Serializable;

public class UserPermissionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4637451062755956043L;
	/**
	 * 
	 */
	private String username;
	private String permissionCode;
	private PermissionType permissionType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public PermissionType getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
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
		UserPermissionId other = (UserPermissionId) obj;
		if (permissionCode == null) {
			if (other.permissionCode != null)
				return false;
		} else if (!permissionCode.equals(other.permissionCode))
			return false;
		if (permissionType != other.permissionType)
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
		return "UserPermissionId [username=" + username + ", permissionCode=" + permissionCode + ", permissionType="
				+ permissionType + "]";
	}

}