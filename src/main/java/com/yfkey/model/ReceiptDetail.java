package com.yfkey.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class ReceiptDetail extends BaseObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151085825814562619L;
	private int tt_prhdeto_seq;                           //序号(前端排序条件)
	private String tt_prhdeto_receiver;         		  //YFKSS收货单号
	private String tt_prhdeto_suppcode;     			  //供应商代码
	private String tt_prhdeto_asnnbr;        			   //供应商ASN
	private int tt_prhdeto_shipto;   				       //收货地址
	private String tt_prhdeto_rcdate;                      //收货日期(YYYY-MM-DD)
	private String tt_prhdeto_rcuserid;                    //收货人
	private String tt_prhdeto_prhmstroid;                  //prhmstr唯一标示(隐含，用户不可见)
	private String tt_prhdeto_shipfrom;                    //发货地址
	private String tt_prhdeto_yhdnbr;                      //要货单号
	
	private String tt_prhdeto_partnbr;           		   //物料号
	private String tt_prhdeto_partdesc;       			   //物料描述
	private String tt_prhdeto_supppart;       			   //供应商物料号
	private String tt_prhdeto_uom;       			       //单位
	private BigDecimal tt_prhdeto_spq;       			   //单包装
	private String tt_prhdeto_toloc;       			       //目的库位
	private BigDecimal tt_prhdeto_delvqty;       		   //发货数
	private BigDecimal tt_prhdeto_revdqty;       		   //已收数

	private String tt_prhdeto_prhdetoid;                  //prhdet唯一标示(主键)

	public int getTt_prhdeto_seq() {
		return tt_prhdeto_seq;
	}

	public void setTt_prhdeto_seq(int tt_prhdeto_seq) {
		this.tt_prhdeto_seq = tt_prhdeto_seq;
	}

	public String getTt_prhdeto_receiver() {
		return tt_prhdeto_receiver;
	}

	public void setTt_prhdeto_receiver(String tt_prhdeto_receiver) {
		this.tt_prhdeto_receiver = tt_prhdeto_receiver;
	}

	public String getTt_prhdeto_suppcode() {
		return tt_prhdeto_suppcode;
	}

	public void setTt_prhdeto_suppcode(String tt_prhdeto_suppcode) {
		this.tt_prhdeto_suppcode = tt_prhdeto_suppcode;
	}

	public String getTt_prhdeto_asnnbr() {
		return tt_prhdeto_asnnbr;
	}

	public void setTt_prhdeto_asnnbr(String tt_prhdeto_asnnbr) {
		this.tt_prhdeto_asnnbr = tt_prhdeto_asnnbr;
	}

	public int getTt_prhdeto_shipto() {
		return tt_prhdeto_shipto;
	}

	public void setTt_prhdeto_shipto(int tt_prhdeto_shipto) {
		this.tt_prhdeto_shipto = tt_prhdeto_shipto;
	}

	public String getTt_prhdeto_rcdate() {
		return tt_prhdeto_rcdate;
	}

	public void setTt_prhdeto_rcdate(String tt_prhdeto_rcdate) {
		this.tt_prhdeto_rcdate = tt_prhdeto_rcdate;
	}

	public String getTt_prhdeto_rcuserid() {
		return tt_prhdeto_rcuserid;
	}

	public void setTt_prhdeto_rcuserid(String tt_prhdeto_rcuserid) {
		this.tt_prhdeto_rcuserid = tt_prhdeto_rcuserid;
	}

	public String getTt_prhdeto_prhmstroid() {
		return tt_prhdeto_prhmstroid;
	}

	public void setTt_prhdeto_prhmstroid(String tt_prhdeto_prhmstroid) {
		this.tt_prhdeto_prhmstroid = tt_prhdeto_prhmstroid;
	}

	public String getTt_prhdeto_shipfrom() {
		return tt_prhdeto_shipfrom;
	}

	public void setTt_prhdeto_shipfrom(String tt_prhdeto_shipfrom) {
		this.tt_prhdeto_shipfrom = tt_prhdeto_shipfrom;
	}

	public String getTt_prhdeto_yhdnbr() {
		return tt_prhdeto_yhdnbr;
	}

	public void setTt_prhdeto_yhdnbr(String tt_prhdeto_yhdnbr) {
		this.tt_prhdeto_yhdnbr = tt_prhdeto_yhdnbr;
	}

	public String getTt_prhdeto_partnbr() {
		return tt_prhdeto_partnbr;
	}

	public void setTt_prhdeto_partnbr(String tt_prhdeto_partnbr) {
		this.tt_prhdeto_partnbr = tt_prhdeto_partnbr;
	}

	public String getTt_prhdeto_partdesc() {
		return tt_prhdeto_partdesc;
	}

	public void setTt_prhdeto_partdesc(String tt_prhdeto_partdesc) {
		this.tt_prhdeto_partdesc = tt_prhdeto_partdesc;
	}

	public String getTt_prhdeto_supppart() {
		return tt_prhdeto_supppart;
	}

	public void setTt_prhdeto_supppart(String tt_prhdeto_supppart) {
		this.tt_prhdeto_supppart = tt_prhdeto_supppart;
	}

	public String getTt_prhdeto_uom() {
		return tt_prhdeto_uom;
	}

	public void setTt_prhdeto_uom(String tt_prhdeto_uom) {
		this.tt_prhdeto_uom = tt_prhdeto_uom;
	}

	public BigDecimal getTt_prhdeto_spq() {
		return tt_prhdeto_spq;
	}

	public void setTt_prhdeto_spq(BigDecimal tt_prhdeto_spq) {
		this.tt_prhdeto_spq = tt_prhdeto_spq;
	}

	public String getTt_prhdeto_toloc() {
		return tt_prhdeto_toloc;
	}

	public void setTt_prhdeto_toloc(String tt_prhdeto_toloc) {
		this.tt_prhdeto_toloc = tt_prhdeto_toloc;
	}

	public BigDecimal getTt_prhdeto_delvqty() {
		return tt_prhdeto_delvqty;
	}

	public void setTt_prhdeto_delvqty(BigDecimal tt_prhdeto_delvqty) {
		this.tt_prhdeto_delvqty = tt_prhdeto_delvqty;
	}

	public BigDecimal getTt_prhdeto_revdqty() {
		return tt_prhdeto_revdqty;
	}

	public void setTt_prhdeto_revdqty(BigDecimal tt_prhdeto_revdqty) {
		this.tt_prhdeto_revdqty = tt_prhdeto_revdqty;
	}

	public String getTt_prhdeto_prhdetoid() {
		return tt_prhdeto_prhdetoid;
	}

	public void setTt_prhdeto_prhdetoid(String tt_prhdeto_prhdetoid) {
		this.tt_prhdeto_prhdetoid = tt_prhdeto_prhdetoid;
	}

	@Override
	public String toString() {
		return "ReceiptDetail [tt_prhdeto_prhdetoid=" + tt_prhdeto_prhdetoid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_prhdeto_prhdetoid == null) ? 0 : tt_prhdeto_prhdetoid.hashCode());
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
		ReceiptDetail other = (ReceiptDetail) obj;
		if (tt_prhdeto_prhdetoid == null) {
			if (other.tt_prhdeto_prhdetoid != null)
				return false;
		} else if (!tt_prhdeto_prhdetoid.equals(other.tt_prhdeto_prhdetoid))
			return false;
		return true;
	}
	
	
	

	
}
