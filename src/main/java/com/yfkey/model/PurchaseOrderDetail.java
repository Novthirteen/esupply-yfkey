package com.yfkey.model;

import java.math.BigDecimal;


public class PurchaseOrderDetail extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7409249741178402255L;
	private BigDecimal xpyhddeto_seq;                        //序号(前端排序条件)
	private String xpyhddeto_yhdnbr;						 //要货单号
	private String xpyhddeto_partnbr;						 //物料号
	private String xpyhddeto_partdesc;						 //物料描述
	private String xpyhddeto_supppart;						 //供应商物料号
	private String xpyhddeto_suppcode;						 //供应商代码
	private String xpyhddeto_shipto;						 //收货地址
	private String xpyhddeto_startdt;						 //开始日期时间
	private String xpyhddeto_receptdt;						 //窗口日期时间
	private String xpyhddeto_priority;						 //优先级
	private String xpyhddeto_currcy;						 //货币
	private String xpyhddeto_uom;							 //单位
	private BigDecimal xpyhddeto_spq;						 //单包装
	private int xpyhddeto_stat;								 //状态
	private BigDecimal xpyhddeto_reqqty;					 //需求数
	private BigDecimal xpyhddeto_ordqty;					 //订单数	
	private String xpyhddeto_creator;						 //创建人	
	private String xpyhddeto_xpyhmstroid;					 //xpyhmstr唯一标示(隐含，用户不可见)
	private String xpyhddeto_xpyhddetoid;	                 //xpyhddet唯一标示(隐含，用户不可见)
	
	public BigDecimal getXpyhddeto_seq() {
		return xpyhddeto_seq;
	}
	public void setXpyhddeto_seq(BigDecimal xpyhddeto_seq) {
		this.xpyhddeto_seq = xpyhddeto_seq;
	}
	public String getXpyhddeto_yhdnbr() {
		return xpyhddeto_yhdnbr;
	}
	public void setXpyhddeto_yhdnbr(String xpyhddeto_yhdnbr) {
		this.xpyhddeto_yhdnbr = xpyhddeto_yhdnbr;
	}
	public String getXpyhddeto_partnbr() {
		return xpyhddeto_partnbr;
	}
	public void setXpyhddeto_partnbr(String xpyhddeto_partnbr) {
		this.xpyhddeto_partnbr = xpyhddeto_partnbr;
	}
	public String getXpyhddeto_partdesc() {
		return xpyhddeto_partdesc;
	}
	public void setXpyhddeto_partdesc(String xpyhddeto_partdesc) {
		this.xpyhddeto_partdesc = xpyhddeto_partdesc;
	}
	public String getXpyhddeto_supppart() {
		return xpyhddeto_supppart;
	}
	public void setXpyhddeto_supppart(String xpyhddeto_supppart) {
		this.xpyhddeto_supppart = xpyhddeto_supppart;
	}
	public String getXpyhddeto_suppcode() {
		return xpyhddeto_suppcode;
	}
	public void setXpyhddeto_suppcode(String xpyhddeto_suppcode) {
		this.xpyhddeto_suppcode = xpyhddeto_suppcode;
	}
	public String getXpyhddeto_shipto() {
		return xpyhddeto_shipto;
	}
	public void setXpyhddeto_shipto(String xpyhddeto_shipto) {
		this.xpyhddeto_shipto = xpyhddeto_shipto;
	}
	public String getXpyhddeto_startdt() {
		return xpyhddeto_startdt;
	}
	public void setXpyhddeto_startdt(String xpyhddeto_startdt) {
		this.xpyhddeto_startdt = xpyhddeto_startdt;
	}
	public String getXpyhddeto_receptdt() {
		return xpyhddeto_receptdt;
	}
	public void setXpyhddeto_receptdt(String xpyhddeto_receptdt) {
		this.xpyhddeto_receptdt = xpyhddeto_receptdt;
	}
	public String getXpyhddeto_priority() {
		return xpyhddeto_priority;
	}
	public void setXpyhddeto_priority(String xpyhddeto_priority) {
		this.xpyhddeto_priority = xpyhddeto_priority;
	}
	public String getXpyhddeto_currcy() {
		return xpyhddeto_currcy;
	}
	public void setXpyhddeto_currcy(String xpyhddeto_currcy) {
		this.xpyhddeto_currcy = xpyhddeto_currcy;
	}
	public String getXpyhddeto_uom() {
		return xpyhddeto_uom;
	}
	public void setXpyhddeto_uom(String xpyhddeto_uom) {
		this.xpyhddeto_uom = xpyhddeto_uom;
	}
	public BigDecimal getXpyhddeto_spq() {
		return xpyhddeto_spq;
	}
	public void setXpyhddeto_spq(BigDecimal xpyhddeto_spq) {
		this.xpyhddeto_spq = xpyhddeto_spq;
	}
	public int getXpyhddeto_stat() {
		return xpyhddeto_stat;
	}
	public void setXpyhddeto_stat(int xpyhddeto_stat) {
		this.xpyhddeto_stat = xpyhddeto_stat;
	}
	public BigDecimal getXpyhddeto_reqqty() {
		return xpyhddeto_reqqty;
	}
	public void setXpyhddeto_reqqty(BigDecimal xpyhddeto_reqqty) {
		this.xpyhddeto_reqqty = xpyhddeto_reqqty;
	}
	public BigDecimal getXpyhddeto_ordqty() {
		return xpyhddeto_ordqty;
	}
	public void setXpyhddeto_ordqty(BigDecimal xpyhddeto_ordqty) {
		this.xpyhddeto_ordqty = xpyhddeto_ordqty;
	}
	public String getXpyhddeto_creator() {
		return xpyhddeto_creator;
	}
	public void setXpyhddeto_creator(String xpyhddeto_creator) {
		this.xpyhddeto_creator = xpyhddeto_creator;
	}
	public String getXpyhddeto_xpyhmstroid() {
		return xpyhddeto_xpyhmstroid;
	}
	public void setXpyhddeto_xpyhmstroid(String xpyhddeto_xpyhmstroid) {
		this.xpyhddeto_xpyhmstroid = xpyhddeto_xpyhmstroid;
	}
	public String getXpyhddeto_xpyhddetoid() {
		return xpyhddeto_xpyhddetoid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((xpyhddeto_xpyhddetoid == null) ? 0 : xpyhddeto_xpyhddetoid.hashCode());
		result = prime * result + ((xpyhddeto_xpyhmstroid == null) ? 0 : xpyhddeto_xpyhmstroid.hashCode());
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
		PurchaseOrderDetail other = (PurchaseOrderDetail) obj;
		if (xpyhddeto_xpyhddetoid == null) {
			if (other.xpyhddeto_xpyhddetoid != null)
				return false;
		} else if (!xpyhddeto_xpyhddetoid.equals(other.xpyhddeto_xpyhddetoid))
			return false;
		if (xpyhddeto_xpyhmstroid == null) {
			if (other.xpyhddeto_xpyhmstroid != null)
				return false;
		} else if (!xpyhddeto_xpyhmstroid.equals(other.xpyhddeto_xpyhmstroid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PurchaseOrderDetail [xpyhddeto_xpyhmstroid=" + xpyhddeto_xpyhmstroid + ", xpyhddeto_xpyhddetoid="
				+ xpyhddeto_xpyhddetoid + "]";
	}
	public void setXpyhddeto_xpyhddetoid(String xpyhddeto_xpyhddetoid) {
		this.xpyhddeto_xpyhddetoid = xpyhddeto_xpyhddetoid;
	}

	
	

}
