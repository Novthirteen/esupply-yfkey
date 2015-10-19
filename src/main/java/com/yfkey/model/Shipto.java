package com.yfkey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "shipto")
public class Shipto extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1389110748673716785L;
	private String shcode; // 收货地址
	private String shname; // 收货地址名称
	private String shdomain; // 域

	@Id
	@Column(length = 50)
	public String getShcode() {
		return shcode;
	}

	public void setShcode(String shcode) {
		this.shcode = shcode;
	}

	@Column(length = 200)
	public String getShname() {
		return shname;
	}

	public void setShname(String shname) {
		this.shname = shname;
	}

	@Column(length = 20)
	public String getShdomain() {
		return shdomain;
	}

	public void setShdomain(String shdomain) {
		this.shdomain = shdomain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shcode == null) ? 0 : shcode.hashCode());
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
		Shipto other = (Shipto) obj;
		if (shcode == null) {
			if (other.shcode != null)
				return false;
		} else if (!shcode.equals(other.shcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shipto [shcode=" + shcode + "]";
	}

	

}
