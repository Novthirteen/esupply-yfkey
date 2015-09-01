package com.yfkey.model;

import java.util.ArrayList;
import java.util.List;



public class PurchaseOrder extends BaseObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7886126588988285842L;
	private int xpyhmstro_seq;                            //序号(前端排序条件)
	private String xpyhmstro_yhdnbr;         			  //要货单号
	private String xpyhmstro_suppcode;     				  //供应商代码 
	private String xpyhmstro_shipto;        			  //收货地址
	private String xpyhmstro_startdt;   				  //开始日期时间   
	private String xpyhmstro_receptdt;                    //窗口日期时间
	private int xpyhmstro_stat;           				  //状态
	private String xpyhmstro_priority;       			  //优先级
	private String xpyhmstro_creator;        			  //创建人
	private String xpyhmstro_xpyhmstroid;   			  //xpyhmstr唯一标示(隐含，用户不可见)
	private String xpyhmstro_conf;          			  //是否已确认
	private String supplierContactPerson;    			  //是否已打印
	private Boolean isDetail;                  			  //明细
	private String remark;    				     		  //备注
	private List<PurchaseOrderDetail> purchaseOrderDetailList;
	

	public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
		return purchaseOrderDetailList;
	}

	public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
		this.purchaseOrderDetailList = purchaseOrderDetailList;
	}

	public void addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		if (purchaseOrderDetailList == null) {
			purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();
		}

		purchaseOrderDetailList.add(purchaseOrderDetail);
	}

	public int getXpyhmstro_seq() {
		return xpyhmstro_seq;
	}

	public void setXpyhmstro_seq(int xpyhmstro_seq) {
		this.xpyhmstro_seq = xpyhmstro_seq;
	}

	public String getXpyhmstro_yhdnbr() {
		return xpyhmstro_yhdnbr;
	}

	public void setXpyhmstro_yhdnbr(String xpyhmstro_yhdnbr) {
		this.xpyhmstro_yhdnbr = xpyhmstro_yhdnbr;
	}

	public String getXpyhmstro_suppcode() {
		return xpyhmstro_suppcode;
	}

	public void setXpyhmstro_suppcode(String xpyhmstro_suppcode) {
		this.xpyhmstro_suppcode = xpyhmstro_suppcode;
	}

	public String getXpyhmstro_shipto() {
		return xpyhmstro_shipto;
	}

	public void setXpyhmstro_shipto(String xpyhmstro_shipto) {
		this.xpyhmstro_shipto = xpyhmstro_shipto;
	}

	public String getXpyhmstro_startdt() {
		return xpyhmstro_startdt;
	}

	public void setXpyhmstro_startdt(String xpyhmstro_startdt) {
		this.xpyhmstro_startdt = xpyhmstro_startdt;
	}

	public String getXpyhmstro_receptdt() {
		return xpyhmstro_receptdt;
	}

	public void setXpyhmstro_receptdt(String xpyhmstro_receptdt) {
		this.xpyhmstro_receptdt = xpyhmstro_receptdt;
	}

	public int getXpyhmstro_stat() {
		return xpyhmstro_stat;
	}

	public void setXpyhmstro_stat(int xpyhmstro_stat) {
		this.xpyhmstro_stat = xpyhmstro_stat;
	}

	public String getXpyhmstro_priority() {
		return xpyhmstro_priority;
	}

	public void setXpyhmstro_priority(String xpyhmstro_priority) {
		this.xpyhmstro_priority = xpyhmstro_priority;
	}

	public String getXpyhmstro_creator() {
		return xpyhmstro_creator;
	}

	public void setXpyhmstro_creator(String xpyhmstro_creator) {
		this.xpyhmstro_creator = xpyhmstro_creator;
	}

	public String getXpyhmstro_xpyhmstroid() {
		return xpyhmstro_xpyhmstroid;
	}

	public void setXpyhmstro_xpyhmstroid(String xpyhmstro_xpyhmstroid) {
		this.xpyhmstro_xpyhmstroid = xpyhmstro_xpyhmstroid;
	}

	public String getXpyhmstro_conf() {
		return xpyhmstro_conf;
	}

	public void setXpyhmstro_conf(String xpyhmstro_conf) {
		this.xpyhmstro_conf = xpyhmstro_conf;
	}

	public String getSupplierContactPerson() {
		return supplierContactPerson;
	}

	public void setSupplierContactPerson(String supplierContactPerson) {
		this.supplierContactPerson = supplierContactPerson;
	}
	
	

	public Boolean getIsDetail() {
		return isDetail;
	}

	public void setIsDetail(Boolean isDetail) {
		this.isDetail = isDetail;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((xpyhmstro_xpyhmstroid == null) ? 0 : xpyhmstro_xpyhmstroid.hashCode());
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (xpyhmstro_xpyhmstroid == null) {
			if (other.xpyhmstro_xpyhmstroid != null)
				return false;
		} else if (!xpyhmstro_xpyhmstroid.equals(other.xpyhmstro_xpyhmstroid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [xpyhmstro_xpyhmstroid=" + xpyhmstro_xpyhmstroid + "]";
	}

	
}
