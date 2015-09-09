package com.yfkey.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission_group")
public class PermissionGroup extends BaseObject implements Auditable  {

	 	/**
	 * 
	 */
	private static final long serialVersionUID = -194873122708757951L;
		private String code;                    // required
	    private String name;
	    private String createUser;
	    private Timestamp createDate;
	    private String updateUser;
	    private Timestamp updateDate;
	    
	    
	    @Id
	    @Column(length = 20)
	    public String getCode() {
	        return this.code;
	    }
	    
	    @Column(length = 100)
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
			PermissionGroup other = (PermissionGroup) obj;
			if (code == null) {
				if (other.code != null)
					return false;
			} else if (!code.equals(other.code))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "PermissionGroup [code=" + code + "]";
		}
	    
	

}
