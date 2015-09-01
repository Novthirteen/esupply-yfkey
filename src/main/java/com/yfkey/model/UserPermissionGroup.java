package com.yfkey.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UserPermissionGroupId.class)
@Table(name = "user_permission_group")

public class UserPermissionGroup extends BaseObject {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1449532075190475195L;
		private String username;			                    // required
	    private String permissionGroupCode;							// required
	    private String createUser;
	    private Timestamp createDate;
	
	    @Id
	    @Column(length = 50)
	    public String getUsername() {
	        return this.username;
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

	    public void setUsername(String username) {
	        this.username = username;
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
			UserPermissionGroup other = (UserPermissionGroup) obj;
			if (permissionGroupCode == null) {
				if (other.permissionGroupCode != null)
					return false;
			} else if (!permissionGroupCode.equals(other.permissionGroupCode))
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
			return "RolePermissionGroup [roleCode=" + username + ", permissionGroupCode=" + permissionGroupCode + "]";
		}
	    
	
}


class UserPermissionGroupId {
	 String username;                   
     String permissionGroupCode;	
}
