package com.yfkey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu extends BaseObject  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2556637617544139689L;
	
	private String code;		// required
	private String name;
	private String parent;
	private String pageUrl;
	private Integer sequence;
	private String description;
	private String imageUrl;
	private String permissionCode;
	private boolean active; 
	
    @Id
    @Column(length = 50)
	public String getCode() {
		return code;
	}

    @Column(length = 100)
	public String getName() {
		return name;
	}
	
    @Column(length = 50)
	public String getParent() {
		return parent;
	}
    
    @Column(name="page_url", length = 255)
	public String getPageUrl() {
		return pageUrl;
	}

    @Column
	public Integer getSequence() {
		return sequence;
	}
	
    @Column(length = 255)
	public String getDescription() {
		return description;
	}
    
    @Column(name="image_url", length = 255)
	public String getImageUrl() {
		return imageUrl;
	}
	
    @Column(name="permission_code", length = 50)
	public String getPermissionCode() {
		return permissionCode;
	}

    @Column(name="is_active")
	public boolean isActive() {
		return active;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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
		Menu other = (Menu) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [code=" + code + "]";
	}




}
