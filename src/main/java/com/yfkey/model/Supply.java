package com.yfkey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "supply")
public class Supply extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -474629538708362973L;
	private String spcode; // 供应商代码
	private String spname; // 供应商描述
	private String spdomain; // 域

	@Id
	@Column(length = 50)
	public String getSpcode() {
		return spcode;
	}

	public void setSpcode(String spcode) {
		this.spcode = spcode;
	}

	@Column(length = 200)
	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	@Column(length = 20)
	public String getSpdomain() {
		return spdomain;
	}

	public void setSpdomain(String spdomain) {
		this.spdomain = spdomain;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((spcode == null) ? 0 : spcode.hashCode());
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
		Supply other = (Supply) obj;
		if (spcode == null) {
			if (other.spcode != null)
				return false;
		} else if (!spcode.equals(other.spcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supply [spcode=" + spcode + "]";
	}
}
