package com.yfkey.model;

import java.util.ArrayList;
import java.util.List;

public class Asn extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5886491209925044112L;
	private int tt_xasnmstro_seq; // 序号(前端排序条件)
	private String tt_xasnmstro_asnnbr; // 供应商ASN
	private String tt_xasnmstro_shipto; // 收货地址
	private String tt_xasnmstro_startdt; // 创建日期时间(YYYY-MM-DD)
	private String tt_xasnmstro_stat; // 状态
	private String tt_xasnmstro_creator; // 创建人
	private String tt_xasnmstro_xasnmstroid; // xasnmstr唯一标示
	private String tt_xasnmstro_suppcode; // 供应商代码
	private Boolean isDetail; // 明细

	private String tt_xasnmstri_fromdate; // 从日期(YYYYMMDD)
	private String tt_xasnmstri_todate; // 到日期(YYYYMMDD)
	private String tt_xasnmstri_partnbr; // 物料号
	private String tt_xasnmstri_yhdnbr; // 要货单号

	private String tt_xasnmstro_stat_desc; // 状态描述
	
	
	private String tt_xasndeto_vendname;   //供应商名称
	private String tt_xasndeto_vendaddr;   //供应商地址
	private String tt_xasndeto_vendcontact;  //联系人
	private String tt_xasndeto_vendphone;    //供应商电话
	private String tt_xasndeto_vendtax;      //供应商传真
	private String tt_xasndeto_shipname;    //客户名称
	private String tt_xasndeto_shipaddr;    //客户地址


	private List<AsnDetail> asnDetailList;

	public int getTt_xasnmstro_seq() {
		return tt_xasnmstro_seq;
	}

	public void setTt_xasnmstro_seq(int tt_xasnmstri_seq) {
		this.tt_xasnmstro_seq = tt_xasnmstri_seq;
	}

	public String getTt_xasnmstro_asnnbr() {
		return tt_xasnmstro_asnnbr;
	}

	public void setTt_xasnmstro_asnnbr(String tt_xasnmstro_asnnbr) {
		this.tt_xasnmstro_asnnbr = tt_xasnmstro_asnnbr;
	}

	public String getTt_xasnmstro_shipto() {
		return tt_xasnmstro_shipto;
	}

	public void setTt_xasnmstro_shipto(String tt_xasnmstro_shipto) {
		this.tt_xasnmstro_shipto = tt_xasnmstro_shipto;
	}

	public String getTt_xasnmstro_startdt() {
		return tt_xasnmstro_startdt;
	}

	public void setTt_xasnmstro_startdt(String tt_xasnmstro_startdt) {
		this.tt_xasnmstro_startdt = tt_xasnmstro_startdt;
	}

	public String getTt_xasnmstro_stat() {
		return tt_xasnmstro_stat;
	}

	public void setTt_xasnmstro_stat(String tt_xasnmstro_stat) {
		this.tt_xasnmstro_stat = tt_xasnmstro_stat;
	}

	public String getTt_xasnmstro_creator() {
		return tt_xasnmstro_creator;
	}

	public void setTt_xasnmstro_creator(String tt_xasnmstro_creator) {
		this.tt_xasnmstro_creator = tt_xasnmstro_creator;
	}

	public String getTt_xasnmstro_xasnmstroid() {
		return tt_xasnmstro_xasnmstroid;
	}

	public void setTt_xasnmstro_xasnmstroid(String tt_xasnmstro_xasnmstroid) {
		this.tt_xasnmstro_xasnmstroid = tt_xasnmstro_xasnmstroid;
	}

	public List<AsnDetail> getAsnDetailList() {
		return asnDetailList;
	}

	public void setAsnDetailList(List<AsnDetail> asnDetailList) {
		this.asnDetailList = asnDetailList;
	}
		
	public String getTt_xasnmstro_stat_desc() {
		return tt_xasnmstro_stat_desc;
	}

	public void setTt_xasnmstro_stat_desc(String tt_xasnmstro_stat_desc) {
		this.tt_xasnmstro_stat_desc = tt_xasnmstro_stat_desc;
	}

	public String getTt_xasnmstro_suppcode() {
		return tt_xasnmstro_suppcode;
	}

	public void setTt_xasnmstro_suppcode(String tt_xasnmstro_suppcode) {
		this.tt_xasnmstro_suppcode = tt_xasnmstro_suppcode;
	}

	public String getTt_xasnmstri_fromdate() {
		return tt_xasnmstri_fromdate;
	}

	public void setTt_xasnmstri_fromdate(String tt_xasnmstri_fromdate) {
		this.tt_xasnmstri_fromdate = tt_xasnmstri_fromdate;
	}

	public String getTt_xasnmstri_todate() {
		return tt_xasnmstri_todate;
	}

	public void setTt_xasnmstri_todate(String tt_xasnmstri_todate) {
		this.tt_xasnmstri_todate = tt_xasnmstri_todate;
	}

	public String getTt_xasnmstri_partnbr() {
		return tt_xasnmstri_partnbr;
	}

	public void setTt_xasnmstri_partnbr(String tt_xasnmstri_partnbr) {
		this.tt_xasnmstri_partnbr = tt_xasnmstri_partnbr;
	}

	public String getTt_xasnmstri_yhdnbr() {
		return tt_xasnmstri_yhdnbr;
	}

	public void setTt_xasnmstri_yhdnbr(String tt_xasnmstri_yhdnbr) {
		this.tt_xasnmstri_yhdnbr = tt_xasnmstri_yhdnbr;
	}

	public Boolean getIsDetail() {
		return isDetail;
	}

	public void setIsDetail(Boolean isDetail) {
		this.isDetail = isDetail;
	}

	public String getTt_xasndeto_vendname() {
		return tt_xasndeto_vendname;
	}

	public void setTt_xasndeto_vendname(String tt_xasndeto_vendname) {
		this.tt_xasndeto_vendname = tt_xasndeto_vendname;
	}

	public String getTt_xasndeto_vendaddr() {
		return tt_xasndeto_vendaddr;
	}

	public void setTt_xasndeto_vendaddr(String tt_xasndeto_vendaddr) {
		this.tt_xasndeto_vendaddr = tt_xasndeto_vendaddr;
	}

	public String getTt_xasndeto_vendcontact() {
		return tt_xasndeto_vendcontact;
	}

	public void setTt_xasndeto_vendcontact(String tt_xasndeto_vendcontact) {
		this.tt_xasndeto_vendcontact = tt_xasndeto_vendcontact;
	}

	public String getTt_xasndeto_vendphone() {
		return tt_xasndeto_vendphone;
	}

	public void setTt_xasndeto_vendphone(String tt_xasndeto_vendphone) {
		this.tt_xasndeto_vendphone = tt_xasndeto_vendphone;
	}

	public String getTt_xasndeto_vendtax() {
		return tt_xasndeto_vendtax;
	}

	public void setTt_xasndeto_vendtax(String tt_xasndeto_vendtax) {
		this.tt_xasndeto_vendtax = tt_xasndeto_vendtax;
	}

	public String getTt_xasndeto_shipname() {
		return tt_xasndeto_shipname;
	}

	public void setTt_xasndeto_shipname(String tt_xasndeto_shipname) {
		this.tt_xasndeto_shipname = tt_xasndeto_shipname;
	}

	public String getTt_xasndeto_shipaddr() {
		return tt_xasndeto_shipaddr;
	}

	public void setTt_xasndeto_shipaddr(String tt_xasndeto_shipaddr) {
		this.tt_xasndeto_shipaddr = tt_xasndeto_shipaddr;
	}

	@Override
	public String toString() {
		return "Asn [tt_xasnmstro_xasnmstroid=" + tt_xasnmstro_xasnmstroid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_xasnmstro_xasnmstroid == null) ? 0 : tt_xasnmstro_xasnmstroid.hashCode());
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
		Asn other = (Asn) obj;
		if (tt_xasnmstro_xasnmstroid == null) {
			if (other.tt_xasnmstro_xasnmstroid != null)
				return false;
		} else if (!tt_xasnmstro_xasnmstroid.equals(other.tt_xasnmstro_xasnmstroid))
			return false;
		return true;
	}

}
