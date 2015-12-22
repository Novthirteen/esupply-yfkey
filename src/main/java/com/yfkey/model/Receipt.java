package com.yfkey.model;

import java.util.List;



public class Receipt extends BaseObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7167272709236112782L;
	private int tt_prhmstro_seq;                           //序号(前端排序条件)
	private String tt_prhmstro_receiver;         			//YFKSS收货单号
	private String tt_prhmstro_suppcode;     				  	//供应商代码
	private String tt_prhmstro_asnnbr;   				    //供应商ASN
	private String tt_prhmstro_shipto;                           //收货地址
	private String tt_prhmstro_rcdate;           		    //收货日期(YYYY-MM-DD)
	private String tt_prhmstro_rcuserid;     				//收货人 
	private String tt_prhmstro_prhmstroid;                    //prhmstr唯一标示(隐含，用户不可见)

	private Boolean isDetail;                               //明细
	
	private String tt_prhmstri_yhdnbr;                        //要货单号
	private String tt_prhmstri_partnbr;                        //物料号
	private String tt_prhmstri_fromdate;					  //从日期(YYYYMMDD)
	private String tt_prhmstri_todate;	                   //到日期(YYYYMMDD)
	
	 
	private String tt_prhdeto_vendname;              //供应商名称
	private String tt_prhdeto_shipaddr;              //收货地点

	
	private List<ReceiptDetail> receiptDetailList;

	public int getTt_prhmstro_seq() {
		return tt_prhmstro_seq;
	}

	public void setTt_prhmstro_seq(int tt_prhmstro_seq) {
		this.tt_prhmstro_seq = tt_prhmstro_seq;
	}

	public String getTt_prhmstro_receiver() {
		return tt_prhmstro_receiver;
	}

	public void setTt_prhmstro_receiver(String tt_prhmstro_receiver) {
		this.tt_prhmstro_receiver = tt_prhmstro_receiver;
	}

	public String getTt_prhmstro_suppcode() {
		return tt_prhmstro_suppcode;
	}

	public void setTt_prhmstro_suppcode(String tt_prhmstro_suppcode) {
		this.tt_prhmstro_suppcode = tt_prhmstro_suppcode;
	}

	public String getTt_prhmstro_asnnbr() {
		return tt_prhmstro_asnnbr;
	}

	public void setTt_prhmstro_asnnbr(String tt_prhmstro_asnnbr) {
		this.tt_prhmstro_asnnbr = tt_prhmstro_asnnbr;
	}

	public String getTt_prhmstro_shipto() {
		return tt_prhmstro_shipto;
	}

	public void setTt_prhmstro_shipto(String tt_prhmstro_shipto) {
		this.tt_prhmstro_shipto = tt_prhmstro_shipto;
	}

	public String getTt_prhmstro_rcdate() {
		return tt_prhmstro_rcdate;
	}

	public void setTt_prhmstro_rcdate(String tt_prhmstro_rcdate) {
		this.tt_prhmstro_rcdate = tt_prhmstro_rcdate;
	}

	public String getTt_prhmstro_rcuserid() {
		return tt_prhmstro_rcuserid;
	}

	public void setTt_prhmstro_rcuserid(String tt_prhmstro_rcuserid) {
		this.tt_prhmstro_rcuserid = tt_prhmstro_rcuserid;
	}

	public String getTt_prhmstro_prhmstroid() {
		return tt_prhmstro_prhmstroid;
	}

	public void setTt_prhmstro_prhmstroid(String tt_prhmstro_prhmstroid) {
		this.tt_prhmstro_prhmstroid = tt_prhmstro_prhmstroid;
	}

	public Boolean getIsDetail() {
		return isDetail;
	}

	public void setIsDetail(Boolean isDetail) {
		this.isDetail = isDetail;
	}
	
	public String getTt_prhmstri_yhdnbr() {
		return tt_prhmstri_yhdnbr;
	}

	public void setTt_prhmstri_yhdnbr(String tt_prhmstri_yhdnbr) {
		this.tt_prhmstri_yhdnbr = tt_prhmstri_yhdnbr;
	}

	public String getTt_prhmstri_partnbr() {
		return tt_prhmstri_partnbr;
	}

	public void setTt_prhmstri_partnbr(String tt_prhmstri_partnbr) {
		this.tt_prhmstri_partnbr = tt_prhmstri_partnbr;
	}

	public String getTt_prhmstri_fromdate() {
		return tt_prhmstri_fromdate;
	}

	public void setTt_prhmstri_fromdate(String tt_prhmstri_fromdate) {
		this.tt_prhmstri_fromdate = tt_prhmstri_fromdate;
	}

	public String getTt_prhmstri_todate() {
		return tt_prhmstri_todate;
	}

	public void setTt_prhmstri_todate(String tt_prhmstri_todate) {
		this.tt_prhmstri_todate = tt_prhmstri_todate;
	}

	public List<ReceiptDetail> getReceiptDetailList() {
		return receiptDetailList;
	}

	public void setReceiptDetailList(List<ReceiptDetail> receiptDetailList) {
		this.receiptDetailList = receiptDetailList;
	}
	
	public String getTt_prhdeto_vendname() {
		return tt_prhdeto_vendname;
	}

	public void setTt_prhdeto_vendname(String tt_prhdeto_vendname) {
		this.tt_prhdeto_vendname = tt_prhdeto_vendname;
	}

	public String getTt_prhdeto_shipaddr() {
		return tt_prhdeto_shipaddr;
	}

	public void setTt_prhdeto_shipaddr(String tt_prhdeto_shipaddr) {
		this.tt_prhdeto_shipaddr = tt_prhdeto_shipaddr;
	}

	@Override
	public String toString() {
		return "Receipt [tt_prhmstro_prhmstroid=" + tt_prhmstro_prhmstroid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_prhmstro_prhmstroid == null) ? 0 : tt_prhmstro_prhmstroid.hashCode());
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
		Receipt other = (Receipt) obj;
		if (tt_prhmstro_prhmstroid == null) {
			if (other.tt_prhmstro_prhmstroid != null)
				return false;
		} else if (!tt_prhmstro_prhmstroid.equals(other.tt_prhmstro_prhmstroid))
			return false;
		return true;
	}


	

	
	

	
}
