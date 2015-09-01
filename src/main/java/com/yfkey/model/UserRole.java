package com.yfkey.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UserRoleId.class)
@Table(name = "user_role")
public class UserRole extends BaseObject implements Traceable {

	/**
	* 
	*/
	private static final long serialVersionUID = 2577359255023747822L;
	private String username; // required
	private String roleCode; // required
	private String createUser;
	private Timestamp createDate;

	@Id
	@Column(name = "username", length = 50, nullable = false)
	public String getUsername() {
		return this.username;
	}

	@Id
	@Column(name = "role_code", length = 20, nullable = false)
	public String getRoleCode() {
		return this.roleCode;
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

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UserRole [username=" + username + ", roleCode=" + roleCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
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
		UserRole other = (UserRole) obj;
		if (roleCode == null) {
			if (other.roleCode != null)
				return false;
		} else if (!roleCode.equals(other.roleCode))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
