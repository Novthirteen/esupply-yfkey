package com.yfkey.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@IdClass(UserAuthorityId.class)
@Table(name = "permission_view")
public class UserAuthority extends BaseObject implements Serializable, GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5827332571609424789L;

	private String username;
	private String authority;
	private PermissionType permissionType;

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Id
	@Column(name = "permission_code")
	public String getAuthority() {
		return authority;
	}

	@Id
	@Column(name = "permission_type")
	@Enumerated(EnumType.STRING)
	public PermissionType getPermissionType() {
		return permissionType;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
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
		UserAuthority other = (UserAuthority) obj;
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
		return "UserAuthority [username=" + username + ", authority=" + authority + ", permissionType=" + permissionType
				+ "]";
	}

}