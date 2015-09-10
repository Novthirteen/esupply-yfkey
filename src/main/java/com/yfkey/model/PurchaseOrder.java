package com.yfkey.model;

import java.util.ArrayList;
import java.util.List;



public class PurchaseOrder extends BaseObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7886126588988285842L;
	private int tt_xpyhmstro_seq;                            //序号(前端排序条件)
	private String tt_xpyhmstro_yhdnbr;         			  //要货单号
	private String tt_xpyhmstro_suppcode;     				  //供应商代码 
	private String tt_xpyhmstro_shipfrom;        			  //发货地址
	private String tt_xpyhmstro_shipto;        			  //收货地址
	private String tt_xpyhmstro_startdt;   				  //开始日期时间   
	private String tt_xpyhmstro_receptdt;                    //窗口日期时间
	private String tt_xpyhmstro_stat;           				  //状态,逗号分隔
	private String tt_xpyhmstro_priority;       			  //优先级
	private String tt_xpyhmstro_creator;        			  //创建人
	private String tt_xpyhmstro_xpyhmstroid;   			  //xpyhmstr唯一标示(隐含，用户不可见)
	private String tt_xpyhmstro_conf;          			  //是否已确认
	private String tt_xpyhmstro_print;    			  //是否已打印
	private Boolean isDetail;                  			  //明细
	private String remark;    				     		  //备注
	private String tt_xpyhmstro_partnbr;                     //零件号
	private String tt_xpyhmstro_currcy;                    //币种
	
	
	private List<PurchaseOrderDetail> purchaseOrderDetailList;

	public int getTt_xpyhmstro_seq() {
		return tt_xpyhmstro_seq;
	}

	public void setTt_xpyhmstro_seq(int tt_xpyhmstro_seq) {
		this.tt_xpyhmstro_seq = tt_xpyhmstro_seq;
	}

	public String getTt_xpyhmstro_yhdnbr() {
		return tt_xpyhmstro_yhdnbr;
	}

	public void setTt_xpyhmstro_yhdnbr(String tt_xpyhmstro_yhdnbr) {
		this.tt_xpyhmstro_yhdnbr = tt_xpyhmstro_yhdnbr;
	}

	public String getTt_xpyhmstro_suppcode() {
		return tt_xpyhmstro_suppcode;
	}

	public void setTt_xpyhmstro_suppcode(String tt_xpyhmstro_suppcode) {
		this.tt_xpyhmstro_suppcode = tt_xpyhmstro_suppcode;
	}

	public String getTt_xpyhmstro_shipfrom() {
		return tt_xpyhmstro_shipfrom;
	}

	public void setTt_xpyhmstro_shipfrom(String tt_xpyhmstro_shipfrom) {
		this.tt_xpyhmstro_shipfrom = tt_xpyhmstro_shipfrom;
	}
	
	public String getTt_xpyhmstro_shipto() {
		return tt_xpyhmstro_shipto;
	}

	public void setTt_xpyhmstro_shipto(String tt_xpyhmstro_shipto) {
		this.tt_xpyhmstro_shipto = tt_xpyhmstro_shipto;
	}

	public String getTt_xpyhmstro_startdt() {
		return tt_xpyhmstro_startdt;
	}

	public void setTt_xpyhmstro_startdt(String tt_xpyhmstro_startdt) {
		this.tt_xpyhmstro_startdt = tt_xpyhmstro_startdt;
	}

	public String getTt_xpyhmstro_receptdt() {
		return tt_xpyhmstro_receptdt;
	}

	public void setTt_xpyhmstro_receptdt(String tt_xpyhmstro_receptdt) {
		this.tt_xpyhmstro_receptdt = tt_xpyhmstro_receptdt;
	}

	public String getTt_xpyhmstro_stat() {
		return tt_xpyhmstro_stat;
	}

	public void setTt_xpyhmstro_stat(String tt_xpyhmstro_stat) {
		this.tt_xpyhmstro_stat = tt_xpyhmstro_stat;
	}

	public String getTt_xpyhmstro_priority() {
		return tt_xpyhmstro_priority;
	}

	public void setTt_xpyhmstro_priority(String tt_xpyhmstro_priority) {
		this.tt_xpyhmstro_priority = tt_xpyhmstro_priority;
	}

	public String getTt_xpyhmstro_creator() {
		return tt_xpyhmstro_creator;
	}

	public void setTt_xpyhmstro_creator(String tt_xpyhmstro_creator) {
		this.tt_xpyhmstro_creator = tt_xpyhmstro_creator;
	}

	public String getTt_xpyhmstro_xpyhmstroid() {
		return tt_xpyhmstro_xpyhmstroid;
	}

	public void setTt_xpyhmstro_xpyhmstroid(String tt_xpyhmstro_xpyhmstroid) {
		this.tt_xpyhmstro_xpyhmstroid = tt_xpyhmstro_xpyhmstroid;
	}

	public String getTt_xpyhmstro_conf() {
		return tt_xpyhmstro_conf;
	}

	public void setTt_xpyhmstro_conf(String tt_xpyhmstro_conf) {
		this.tt_xpyhmstro_conf = tt_xpyhmstro_conf;
	}

	public String getTt_xpyhmstro_print() {
		return tt_xpyhmstro_print;
	}

	public void setTt_xpyhmstro_print(String tt_xpyhmstro_print) {
		this.tt_xpyhmstro_print = tt_xpyhmstro_print;
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

	public String getTt_xpyhmstro_partnbr() {
		return tt_xpyhmstro_partnbr;
	}

	public void setTt_xpyhmstro_partnbr(String tt_xpyhmstro_partnbr) {
		this.tt_xpyhmstro_partnbr = tt_xpyhmstro_partnbr;
	}

	public String getTt_xpyhmstro_currcy() {
		return tt_xpyhmstro_currcy;
	}

	public void setTt_xpyhmstro_currcy(String tt_xpyhmstro_userauth) {
		this.tt_xpyhmstro_currcy = tt_xpyhmstro_userauth;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
		return purchaseOrderDetailList;
	}

	public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
		this.purchaseOrderDetailList = purchaseOrderDetailList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_xpyhmstro_xpyhmstroid == null) ? 0 : tt_xpyhmstro_xpyhmstroid.hashCode());
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
		if (tt_xpyhmstro_xpyhmstroid == null) {
			if (other.tt_xpyhmstro_xpyhmstroid != null)
				return false;
		} else if (!tt_xpyhmstro_xpyhmstroid.equals(other.tt_xpyhmstro_xpyhmstroid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [tt_xpyhmstro_xpyhmstroid=" + tt_xpyhmstro_xpyhmstroid + "]";
	}
	

	

	
}
