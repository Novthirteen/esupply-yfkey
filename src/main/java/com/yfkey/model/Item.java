package com.yfkey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "item")
public class Item extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5886491209925044112L;

	private String itemcode; // 零件代码
	private String itemdesc; // 零件描述
	private String itemdomain; // 域

	@Id
	@Column(length = 50)
	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	@Column(length = 200)
	public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

	@Column(length = 20)
	public String getItemdomain() {
		return itemdomain;
	}

	public void setItemdomain(String itemdomain) {
		this.itemdomain = itemdomain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemcode == null) ? 0 : itemcode.hashCode());
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
		Item other = (Item) obj;
		if (itemcode == null) {
			if (other.itemcode != null)
				return false;
		} else if (!itemcode.equals(other.itemcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [itemcode=" + itemcode + "]";
	}

}
