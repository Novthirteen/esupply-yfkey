package com.yfkey.model;

import java.math.BigDecimal;

import com.progress.open4gl.Parameter;


public class PurchaseOrderDetail extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7409249741178402255L;
	private int    tt_xpyhddeto_seq;                   //序号(前端排序条件)
	private String tt_xpyhddeto_yhdnbr;						 //要货单号
	private String tt_xpyhddeto_partnbr;						 //物料号
	private String tt_xpyhddeto_partdesc;					 //物料描述
	private String tt_xpyhddeto_supppart;					 //供应商物料号
	private String tt_xpyhddeto_suppcode;					 //供应商代码
	private String tt_xpyhddeto_shipto;						 //收货地址
	private String tt_xpyhddeto_startdt;						 //开始日期时间
	private String tt_xpyhddeto_receptdt;					 //窗口日期时间
	private String tt_xpyhddeto_priority;					 //优先级
	private String tt_xpyhddeto_currcy;						 //货币
	private String tt_xpyhddeto_uom;							 //单位
	private BigDecimal tt_xpyhddeto_spq;						 //单包装
	private String tt_xpyhddeto_stat;							 //状态
	private BigDecimal tt_xpyhddeto_reqqty;					 //需求数
	private BigDecimal tt_xpyhddeto_ordqty;					 //订单数	
	private String tt_xpyhdde_creator;						 //创建人	
	private String tt_xpyhddeto_xpyhmstroid;					 //xpyhmstr唯一标示(隐含，用户不可见)
	private String tt_xpyhddeto_xpyhddetoid;	                 //xpyhddet唯一标示(隐含，用户不可见)
	private String line_remark;	                 				 //备注
	private BigDecimal tt_xpyhddeto_shipedqty;                //已发货数
	
	//这4个给打条码用
	private BigDecimal tt_xpyhddeto_innnerqty;				  //内包装
	private BigDecimal tt_xpyhddeto_externalqty;              //外包装
	private String tt_xpyhddeto_lots;              				//批号
	private BigDecimal tt_xpyhddeto_qty;    					//数量
	private String tt_xpyhddeto_pktype;              			//包装类型
	private String isexternal;              			      //包装类型
	
	
	//发货用
	private String tt_xpyhddeto_toloc;  					//目的库位
	private BigDecimal tt_xpyhddeto_delvqty; 				//发货数
	private BigDecimal tt_xpyhddeto_openqty;                //待发数
	
	
	private String tt_xpyhddeto_recepttm;                   //窗口时间
	private BigDecimal tt_forecast_fcastqty;                //预测数
	
	public int getTt_xpyhddeto_seq() {
		return tt_xpyhddeto_seq;
	}
	public void setTt_xpyhddeto_seq(int tt_xpyhddeto_seq) {
		this.tt_xpyhddeto_seq = tt_xpyhddeto_seq;
	}
	public String getTt_xpyhddeto_yhdnbr() {
		return tt_xpyhddeto_yhdnbr;
	}
	public void setTt_xpyhddeto_yhdnbr(String tt_xpyhddeto_yhdnbr) {
		this.tt_xpyhddeto_yhdnbr = tt_xpyhddeto_yhdnbr;
	}
	public String getTt_xpyhddeto_partnbr() {
		return tt_xpyhddeto_partnbr;
	}
	public void setTt_xpyhddeto_partnbr(String tt_xpyhddeto_partnbr) {
		this.tt_xpyhddeto_partnbr = tt_xpyhddeto_partnbr;
	}
	public String getTt_xpyhddeto_partdesc() {
		return tt_xpyhddeto_partdesc;
	}
	public void setTt_xpyhddeto_partdesc(String tt_xpyhddeto_partdesc) {
		this.tt_xpyhddeto_partdesc = tt_xpyhddeto_partdesc;
	}
	public String getTt_xpyhddeto_supppart() {
		return tt_xpyhddeto_supppart;
	}
	public void setTt_xpyhddeto_supppart(String tt_xpyhddeto_supppart) {
		this.tt_xpyhddeto_supppart = tt_xpyhddeto_supppart;
	}
	public String getTt_xpyhddeto_suppcode() {
		return tt_xpyhddeto_suppcode;
	}
	public void setTt_xpyhddeto_suppcode(String tt_xpyhddeto_suppcode) {
		this.tt_xpyhddeto_suppcode = tt_xpyhddeto_suppcode;
	}
	public String getTt_xpyhddeto_shipto() {
		return tt_xpyhddeto_shipto;
	}
	public void setTt_xpyhddeto_shipto(String tt_xpyhddeto_shipto) {
		this.tt_xpyhddeto_shipto = tt_xpyhddeto_shipto;
	}
	public String getTt_xpyhddeto_startdt() {
		return tt_xpyhddeto_startdt;
	}
	public void setTt_xpyhddeto_startdt(String tt_xpyhddeto_startdt) {
		this.tt_xpyhddeto_startdt = tt_xpyhddeto_startdt;
	}
	public String getTt_xpyhddeto_receptdt() {
		return tt_xpyhddeto_receptdt;
	}
	public void setTt_xpyhddeto_receptdt(String tt_xpyhddeto_receptdt) {
		this.tt_xpyhddeto_receptdt = tt_xpyhddeto_receptdt;
	}
	public String getTt_xpyhddeto_priority() {
		return tt_xpyhddeto_priority;
	}
	public void setTt_xpyhddeto_priority(String tt_xpyhddeto_priority) {
		this.tt_xpyhddeto_priority = tt_xpyhddeto_priority;
	}
	public String getTt_xpyhddeto_currcy() {
		return tt_xpyhddeto_currcy;
	}
	public void setTt_xpyhddeto_currcy(String tt_xpyhddeto_currcy) {
		this.tt_xpyhddeto_currcy = tt_xpyhddeto_currcy;
	}
	public String getTt_xpyhddeto_uom() {
		return tt_xpyhddeto_uom;
	}
	public void setTt_xpyhddeto_uom(String tt_xpyhddeto_uom) {
		this.tt_xpyhddeto_uom = tt_xpyhddeto_uom;
	}
	public BigDecimal getTt_xpyhddeto_spq() {
		return tt_xpyhddeto_spq;
	}
	public void setTt_xpyhddeto_spq(BigDecimal tt_xpyhddeto_spq) {
		this.tt_xpyhddeto_spq = tt_xpyhddeto_spq;
	}
	public String getTt_xpyhddeto_stat() {
		return tt_xpyhddeto_stat;
	}
	public void setTt_xpyhddeto_stat(String tt_xpyhddeto_stat) {
		this.tt_xpyhddeto_stat = tt_xpyhddeto_stat;
	}
	public BigDecimal getTt_xpyhddeto_reqqty() {
		return tt_xpyhddeto_reqqty;
	}
	public void setTt_xpyhddeto_reqqty(BigDecimal tt_xpyhddeto_reqqty) {
		this.tt_xpyhddeto_reqqty = tt_xpyhddeto_reqqty;
	}
	public BigDecimal getTt_xpyhddeto_ordqty() {
		return tt_xpyhddeto_ordqty;
	}
	public void setTt_xpyhddeto_ordqty(BigDecimal tt_xpyhddeto_ordqty) {
		this.tt_xpyhddeto_ordqty = tt_xpyhddeto_ordqty;
	}
	public String getTt_xpyhddeto_xpyhmstroid() {
		return tt_xpyhddeto_xpyhmstroid;
	}
	public void setTt_xpyhddeto_xpyhmstroid(String tt_xpyhddeto_xpyhmstroid) {
		this.tt_xpyhddeto_xpyhmstroid = tt_xpyhddeto_xpyhmstroid;
	}
	public String getTt_xpyhddeto_xpyhddetoid() {
		return tt_xpyhddeto_xpyhddetoid;
	}
	public void setTt_xpyhddeto_xpyhddetoid(String tt_xpyhddeto_xpyhddetoid) {
		this.tt_xpyhddeto_xpyhddetoid = tt_xpyhddeto_xpyhddetoid;
	}
	public String getTt_xpyhdde_creator() {
		return tt_xpyhdde_creator;
	}
	public void setTt_xpyhdde_creator(String tt_xpyhdde_creator) {
		this.tt_xpyhdde_creator = tt_xpyhdde_creator;
	}
	
	
	
	public BigDecimal getTt_xpyhddeto_innnerqty() {
		return tt_xpyhddeto_innnerqty;
	}
	public void setTt_xpyhddeto_innnerqty(BigDecimal tt_xpyhddeto_innnerqty) {
		this.tt_xpyhddeto_innnerqty = tt_xpyhddeto_innnerqty;
	}
	public BigDecimal getTt_xpyhddeto_externalqty() {
		return tt_xpyhddeto_externalqty;
	}
	public void setTt_xpyhddeto_externalqty(BigDecimal tt_xpyhddeto_externalqty) {
		this.tt_xpyhddeto_externalqty = tt_xpyhddeto_externalqty;
	}
	public String getTt_xpyhddeto_lots() {
		return tt_xpyhddeto_lots;
	}
	public void setTt_xpyhddeto_lots(String tt_xpyhddeto_lots) {
		this.tt_xpyhddeto_lots = tt_xpyhddeto_lots;
	}
	public BigDecimal getTt_xpyhddeto_qty() {
		return tt_xpyhddeto_qty;
	}
	public void setTt_xpyhddeto_qty(BigDecimal tt_xpyhddeto_qty) {
		this.tt_xpyhddeto_qty = tt_xpyhddeto_qty;
	}
	public String getLine_remark() {
		return line_remark;
	}
	public void setLine_remark(String line_remark) {
		this.line_remark = line_remark;
	}
	
	
	public String getTt_xpyhddeto_pktype() {
		return tt_xpyhddeto_pktype;
	}
	public void setTt_xpyhddeto_pktype(String tt_xpyhddeto_pktype) {
		this.tt_xpyhddeto_pktype = tt_xpyhddeto_pktype;
	}
	
	public BigDecimal getTt_xpyhddeto_shipedqty() {
		return tt_xpyhddeto_shipedqty;
	}
	public void setTt_xpyhddeto_shipedqty(BigDecimal tt_xpyhddeto_shipedqty) {
		this.tt_xpyhddeto_shipedqty = tt_xpyhddeto_shipedqty;
	}
	
	public String getIsexternal() {
		return isexternal;
	}
	public void setIsexternal(String isexternal) {
		this.isexternal = isexternal;
	}
	
	public String getTt_xpyhddeto_recepttm() {
		return tt_xpyhddeto_recepttm;
	}
	public void setTt_xpyhddeto_recepttm(String tt_xpyhddeto_recepttm) {
		this.tt_xpyhddeto_recepttm = tt_xpyhddeto_recepttm;
	}
	public BigDecimal getTt_xpyhddeto_openqty() {
		return tt_xpyhddeto_openqty;
	}
	public void setTt_xpyhddeto_openqty(BigDecimal tt_xpyhddeto_openqty) {
		this.tt_xpyhddeto_openqty = tt_xpyhddeto_openqty;
	}
	public String getTt_xpyhddeto_toloc() {
		return tt_xpyhddeto_toloc;
	}
	public void setTt_xpyhddeto_toloc(String tt_xpyhddeto_toloc) {
		this.tt_xpyhddeto_toloc = tt_xpyhddeto_toloc;
	}
	
	public BigDecimal getTt_xpyhddeto_delvqty() {
		return tt_xpyhddeto_delvqty;
	}
	public void setTt_xpyhddeto_delvqty(BigDecimal tt_xpyhddeto_delvqty) {
		this.tt_xpyhddeto_delvqty = tt_xpyhddeto_delvqty;
	}
	
	
	
	public BigDecimal getTt_forecast_fcastqty() {
		return tt_forecast_fcastqty;
	}
	public void setTt_forecast_fcastqty(BigDecimal tt_forecast_fcastqty) {
		this.tt_forecast_fcastqty = tt_forecast_fcastqty;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_xpyhddeto_xpyhddetoid == null) ? 0 : tt_xpyhddeto_xpyhddetoid.hashCode());
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
		if (tt_xpyhddeto_xpyhddetoid == null) {
			if (other.tt_xpyhddeto_xpyhddetoid != null)
				return false;
		} else if (!tt_xpyhddeto_xpyhddetoid.equals(other.tt_xpyhddeto_xpyhddetoid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PurchaseOrderDetail [tt_xpyhddeto_xpyhddetoid=" + tt_xpyhddeto_xpyhddetoid + "]";
	}
	
	
	
	
	
	

}
