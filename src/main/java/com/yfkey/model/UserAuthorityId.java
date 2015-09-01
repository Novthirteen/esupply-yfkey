package com.yfkey.model;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserAuthorityId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7287237518968952241L;
	private String username;
	private String authority;
	private PermissionType permissionType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Enumerated(EnumType.STRING)
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
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
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
		UserAuthorityId other = (UserAuthorityId) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
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
		return "UserAuthorityId [username=" + username + ", authority=" + authority + ", permissionType="
				+ permissionType + "]";
	}
}
