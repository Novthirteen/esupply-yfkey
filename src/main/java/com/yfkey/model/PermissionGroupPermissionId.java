package com.yfkey.model;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PermissionGroupPermissionId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4403737482278764509L;

	private String permissionGroupCode;
	private String permissionCode;
	private PermissionType type;
	
     
	public PermissionGroupPermissionId() {
		
	}
	public PermissionGroupPermissionId(String permissionGroupCode, String permissionCode,PermissionType type) {
		this.permissionGroupCode = permissionGroupCode;
		this.permissionCode = permissionCode;
		this.type = type;
	}

	public String getPermissionGroupCode() {
		return permissionGroupCode;
	}
	public void setPermissionGroupCode(String permissionGroupCode) {
		this.permissionGroupCode = permissionGroupCode;
	}
	public String getPermissionCode() {
		return permissionCode;
	}
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
	@Enumerated(EnumType.STRING)
	public PermissionType getType() {
		return type;
	}
	public void setType(PermissionType type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permissionCode == null) ? 0 : permissionCode.hashCode());
		result = prime * result + ((permissionGroupCode == null) ? 0 : permissionGroupCode.hashCode());
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
		PermissionGroupPermissionId other = (PermissionGroupPermissionId) obj;
		if (permissionCode == null) {
			if (other.permissionCode != null)
				return false;
		} else if (!permissionCode.equals(other.permissionCode))
			return false;
		if (permissionGroupCode == null) {
			if (other.permissionGroupCode != null)
				return false;
		} else if (!permissionGroupCode.equals(other.permissionGroupCode))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PermissionGroupPermissionId [permissionGroupCode=" + permissionGroupCode + ", permissionCode="
				+ permissionCode + ", type=" + type + "]";
	}
	
	
}