package com.yfkey.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class AsnDetail extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5381804062748689684L;
	private int tt_xasndeto_seq;                           //序号(前端排序条件)
	private String tt_xasndeto_asnnbr;         			   //供应商ASN
	private String tt_xasndeto_shipto;     				   //收货地址
	private String tt_xasndeto_startdt;        			   //创建日期时间(YYYY-MM-DD)
	private int tt_xasndeto_stat;   				       //状态  
	private String tt_xasndeto_creator;                    //创建人
	private String tt_xasndeto_partnbr;           		   //物料号
	private String tt_xasndeto_partdesc;       			   //物料描述
	private String tt_xasndeto_supppart;       			   //供应商物料号
	private String tt_xasndeto_uom;       			       //单位
	private BigDecimal tt_xasndeto_spq;       			   //单包装
	private BigDecimal tt_xasndeto_asnqty;       		   //ASN发货数量
	private String tt_xasndeto_xasnmstroid;       		   //xasnmstr唯一标示
	private String tt_xasndeto_xasndetoid;       		   //xasndet唯一标示
	private String tt_xasndeto_yhdnbr;                     //要货单号
	
	public int getTt_xasndeto_seq() {
		return tt_xasndeto_seq;
	}
	public void setTt_xasndeto_seq(int tt_xasndeto_seq) {
		this.tt_xasndeto_seq = tt_xasndeto_seq;
	}
	public String getTt_xasndeto_asnnbr() {
		return tt_xasndeto_asnnbr;
	}
	public void setTt_xasndeto_asnnbr(String tt_xasndeto_asnnbr) {
		this.tt_xasndeto_asnnbr = tt_xasndeto_asnnbr;
	}
	public String getTt_xasndeto_shipto() {
		return tt_xasndeto_shipto;
	}
	public void setTt_xasndeto_shipto(String tt_xasndeto_shipto) {
		this.tt_xasndeto_shipto = tt_xasndeto_shipto;
	}
	public String getTt_xasndeto_startdt() {
		return tt_xasndeto_startdt;
	}
	public void setTt_xasndeto_startdt(String tt_xasndeto_startdt) {
		this.tt_xasndeto_startdt = tt_xasndeto_startdt;
	}
	public int getTt_xasndeto_stat() {
		return tt_xasndeto_stat;
	}
	public void setTt_xasndeto_stat(int tt_xasndeto_stat) {
		this.tt_xasndeto_stat = tt_xasndeto_stat;
	}
	public String getTt_xasndeto_creator() {
		return tt_xasndeto_creator;
	}
	public void setTt_xasndeto_creator(String tt_xasndeto_creator) {
		this.tt_xasndeto_creator = tt_xasndeto_creator;
	}
	public String getTt_xasndeto_partnbr() {
		return tt_xasndeto_partnbr;
	}
	public void setTt_xasndeto_partnbr(String tt_xasndeto_partnbr) {
		this.tt_xasndeto_partnbr = tt_xasndeto_partnbr;
	}
	public String getTt_xasndeto_partdesc() {
		return tt_xasndeto_partdesc;
	}
	public void setTt_xasndeto_partdesc(String tt_xasndeto_partdesc) {
		this.tt_xasndeto_partdesc = tt_xasndeto_partdesc;
	}
	public String getTt_xasndeto_supppart() {
		return tt_xasndeto_supppart;
	}
	public void setTt_xasndeto_supppart(String tt_xasndeto_supppart) {
		this.tt_xasndeto_supppart = tt_xasndeto_supppart;
	}
	public String getTt_xasndeto_uom() {
		return tt_xasndeto_uom;
	}
	public void setTt_xasndeto_uom(String tt_xasndeto_uom) {
		this.tt_xasndeto_uom = tt_xasndeto_uom;
	}
	public BigDecimal getTt_xasndeto_spq() {
		return tt_xasndeto_spq;
	}
	public void setTt_xasndeto_spq(BigDecimal tt_xasndeto_spq) {
		this.tt_xasndeto_spq = tt_xasndeto_spq;
	}
	public BigDecimal getTt_xasndeto_asnqty() {
		return tt_xasndeto_asnqty;
	}
	public void setTt_xasndeto_asnqty(BigDecimal tt_xasndeto_asnqty) {
		this.tt_xasndeto_asnqty = tt_xasndeto_asnqty;
	}
	public String getTt_xasndeto_xasnmstroid() {
		return tt_xasndeto_xasnmstroid;
	}
	public void setTt_xasndeto_xasnmstroid(String tt_xasndeto_xasnmstroid) {
		this.tt_xasndeto_xasnmstroid = tt_xasndeto_xasnmstroid;
	}
	public String getTt_xasndeto_xasndetoid() {
		return tt_xasndeto_xasndetoid;
	}
	public void setTt_xasndeto_xasndetoid(String tt_xasndeto_xasndetoid) {
		this.tt_xasndeto_xasndetoid = tt_xasndeto_xasndetoid;
	}
	
	
	public String getTt_xasndeto_yhdnbr() {
		return tt_xasndeto_yhdnbr;
	}
	public void setTt_xasndeto_yhdnbr(String tt_xasndeto_yhdnbr) {
		this.tt_xasndeto_yhdnbr = tt_xasndeto_yhdnbr;
	}
	@Override
	public String toString() {
		return "AsnDetail [tt_xasndeto_xasnmstroid=" + tt_xasndeto_xasnmstroid + ", tt_xasndeto_xasndetoid="
				+ tt_xasndeto_xasndetoid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_xasndeto_xasndetoid == null) ? 0 : tt_xasndeto_xasndetoid.hashCode());
		result = prime * result + ((tt_xasndeto_xasnmstroid == null) ? 0 : tt_xasndeto_xasnmstroid.hashCode());
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
		AsnDetail other = (AsnDetail) obj;
		if (tt_xasndeto_xasndetoid == null) {
			if (other.tt_xasndeto_xasndetoid != null)
				return false;
		} else if (!tt_xasndeto_xasndetoid.equals(other.tt_xasndeto_xasndetoid))
			return false;
		if (tt_xasndeto_xasnmstroid == null) {
			if (other.tt_xasndeto_xasnmstroid != null)
				return false;
		} else if (!tt_xasndeto_xasnmstroid.equals(other.tt_xasndeto_xasnmstroid))
			return false;
		return true;
	}
	
	
	
}
