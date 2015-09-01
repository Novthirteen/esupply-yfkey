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
@IdClass(PermissionId.class)
@Table(name = "permission")
public class Permission extends BaseObject implements Auditable {
	/**
	* 
	*/
	private static final long serialVersionUID = 364433575686941032L;
	private String code; // required
	private PermissionType type; // required
	private String name;
	private String createUser;
	private Timestamp createDate;
	private String updateUser;
	private Timestamp updateDate;

	@Id
	@Column(length = 50)
	public String getCode() {
		return this.code;
	}

	@Id
	@Column(length = 1)
	@Enumerated(EnumType.STRING)
	public PermissionType getType() {
		return this.type;
	}

	@Column(length = 50)
	public String getName() {
		return this.name;
	}

	@Column(name = "create_user", length = 50, nullable = false, updatable = false)
	public String getCreateUser() {
		return createUser;
	}

	@Column(name = "create_date", nullable = false, updatable = false)
	public Timestamp getCreateDate() {
		return createDate;
	}

	@Column(name = "update_user", length = 50, nullable = false)
	public String getUpdateUser() {
		return updateUser;
	}

	@Column(name = "update_date", nullable = false)
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(PermissionType type) {
		this.type = type;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Permission other = (Permission) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Permission [code=" + code + ", type=" + type + ", name=" + name + "]";
	}
}
