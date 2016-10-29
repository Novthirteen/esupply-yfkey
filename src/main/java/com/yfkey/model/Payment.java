package com.yfkey.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Payment extends BaseObject {

	
	/**
	 * 
	 */
	private String tt_payment_payrf;     //付款参考号
	private String tt_payment_rf;        //参考号
	private String tt_payment_date;      //创建日期(YYYYMMDD)
	private BigDecimal tt_payment_orgTC;     //付款发票金额
	private String tt_payment_curr;      //币种
	private String tt_payment_invno;		//QAD发票号
	private String tt_payment_status;	//状态
	private BigDecimal tt_payment_TC;		//发票金额
	private BigDecimal tt_payment_openTC;	//未结金额
	private String tt_payment_entity;	//会计单位
	private String tt_payment_sp;		//供应商代码
	private int tt_payment_id;		//cinvoice唯一标示
	
	private String tt_payment_fromdate;    //开始日期(YYYYMMDD)
	private String tt_payment_todate;      //结束日期(YYYYMMDD)
	
	public String getTt_payment_payrf() {
		return tt_payment_payrf;
	}
	public void setTt_payment_payrf(String tt_payment_payrf) {
		this.tt_payment_payrf = tt_payment_payrf;
	}
	public String getTt_payment_rf() {
		return tt_payment_rf;
	}
	public void setTt_payment_rf(String tt_payment_rf) {
		this.tt_payment_rf = tt_payment_rf;
	}
	public String getTt_payment_date() {
		return tt_payment_date;
	}
	public void setTt_payment_date(String tt_payment_date) {
		this.tt_payment_date = tt_payment_date;
	}
	public BigDecimal getTt_payment_orgTC() {
		return tt_payment_orgTC;
	}
	public void setTt_payment_orgTC(BigDecimal tt_payment_orgTC) {
		this.tt_payment_orgTC = tt_payment_orgTC;
	}
	public String getTt_payment_curr() {
		return tt_payment_curr;
	}
	public void setTt_payment_curr(String tt_payment_curr) {
		this.tt_payment_curr = tt_payment_curr;
	}
	public String getTt_payment_invno() {
		return tt_payment_invno;
	}
	public void setTt_payment_invno(String tt_payment_invno) {
		this.tt_payment_invno = tt_payment_invno;
	}
	public String getTt_payment_status() {
		return tt_payment_status;
	}
	public void setTt_payment_status(String tt_payment_status) {
		this.tt_payment_status = tt_payment_status;
	}
	public BigDecimal getTt_payment_TC() {
		return tt_payment_TC;
	}
	public void setTt_payment_TC(BigDecimal tt_payment_TC) {
		this.tt_payment_TC = tt_payment_TC;
	}
	public BigDecimal getTt_payment_openTC() {
		return tt_payment_openTC;
	}
	public void setTt_payment_openTC(BigDecimal tt_payment_openTC) {
		this.tt_payment_openTC = tt_payment_openTC;
	}
	public String getTt_payment_entity() {
		return tt_payment_entity;
	}
	public void setTt_payment_entity(String tt_payment_entity) {
		this.tt_payment_entity = tt_payment_entity;
	}
	public String getTt_payment_sp() {
		return tt_payment_sp;
	}
	public void setTt_payment_sp(String tt_payment_sp) {
		this.tt_payment_sp = tt_payment_sp;
	}
	public int getTt_payment_id() {
		return tt_payment_id;
	}
	public void setTt_payment_id(int tt_payment_id) {
		this.tt_payment_id = tt_payment_id;
	}
	
	public String getTt_payment_fromdate() {
		return tt_payment_fromdate;
	}
	public void setTt_payment_fromdate(String tt_payment_fromdate) {
		this.tt_payment_fromdate = tt_payment_fromdate;
	}
	public String getTt_payment_todate() {
		return tt_payment_todate;
	}
	public void setTt_payment_todate(String tt_payment_todate) {
		this.tt_payment_todate = tt_payment_todate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tt_payment_id;
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
		Payment other = (Payment) obj;
		if (tt_payment_id != other.tt_payment_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Payment [tt_payment_id=" + tt_payment_id + "]";
	}

	

}
