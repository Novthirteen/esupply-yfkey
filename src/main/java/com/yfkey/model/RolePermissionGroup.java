package com.yfkey.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(RolePermissionGroupId.class)
@Table(name = "role_permission_group")

public class RolePermissionGroup extends BaseObject {


		/**
	 * 
	 */
	private static final long serialVersionUID = -1799221237122011806L;
		private String roleCode;			                    // required
	    private String permissionGroupCode;							// required
	    private String createUser;
	    private Timestamp createDate;
	
	    @Id
	    @Column(name = "role_code",length = 20, nullable = false)
	    public String getRoleCode() {
	        return this.roleCode;
	    }
	    
	    @Id
	    @Column(name = "permission_group_code",length = 20, nullable = false)
	    public String getPermissionGroupCode() {
	        return this.permissionGroupCode;
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

	    public void setPermissionGroupCode(String permissionGroupCode) {
	        this.permissionGroupCode = permissionGroupCode;
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
			result = prime * result + ((permissionGroupCode == null) ? 0 : permissionGroupCode.hashCode());
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
			RolePermissionGroup other = (RolePermissionGroup) obj;
			if (permissionGroupCode == null) {
				if (other.permissionGroupCode != null)
					return false;
			} else if (!permissionGroupCode.equals(other.permissionGroupCode))
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
			return "RolePermissionGroup [roleCode=" + roleCode + ", permissionGroupCode=" + permissionGroupCode + "]";
		}
	    
	
}


class RolePermissionGroupId {
	 String roleCode;                   
     String permissionGroupCode;	
}
