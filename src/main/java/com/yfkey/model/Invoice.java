package com.yfkey.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Invoice extends BaseObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8716950591661077286L;
	private String tt_cinvoice_sp; // 供应商代码
	private String tt_cinvoice_fromdate; // 开始日期(YYYYMMDD)
	private String tt_cinvoice_todate; // 结束日期(YYYYMMDD)
	private String tt_cinvoice_rf; // 参考号
	private String tt_cinvoice_curr; // 币种
	private String tt_cinvoice_type; // 发票类型
	private String tt_cinvoice_term; // 信用期限
	private String tt_cinvoice_duedate; // 到期日期(YYYYMMDD)
	private String tt_cinvoice_invdate; //发票日期(YYYY-MM-DD)
	private String tt_cinvoice_br; // 业务关系代码
	private BigDecimal tt_cinvoice_tb; // 发票金额
	private BigDecimal tt_cinvoice_tbcr; // 发票金额(贷方)
	private BigDecimal tt_cinvoice_tbdr; // 发票金额(借方)
	private BigDecimal tt_cinvoice_hold; // 发票暂留金额
	private String tt_cinvoice_brname;   //业务关系名称
	private int tt_cinvoice_id;  //唯一标示(隐含，用户不可见)

	public String getTt_cinvoice_sp() {
		return tt_cinvoice_sp;
	}

	public void setTt_cinvoice_sp(String tt_cinvoice_sp) {
		this.tt_cinvoice_sp = tt_cinvoice_sp;
	}

	public String getTt_cinvoice_fromdate() {
		return tt_cinvoice_fromdate;
	}

	public void setTt_cinvoice_fromdate(String tt_cinvoice_fromdate) {
		this.tt_cinvoice_fromdate = tt_cinvoice_fromdate;
	}

	public String getTt_cinvoice_todate() {
		return tt_cinvoice_todate;
	}

	public void setTt_cinvoice_todate(String tt_cinvoice_todate) {
		this.tt_cinvoice_todate = tt_cinvoice_todate;
	}

	public String getTt_cinvoice_rf() {
		return tt_cinvoice_rf;
	}

	public void setTt_cinvoice_rf(String tt_cinvoice_rf) {
		this.tt_cinvoice_rf = tt_cinvoice_rf;
	}

	public String getTt_cinvoice_curr() {
		return tt_cinvoice_curr;
	}

	public void setTt_cinvoice_curr(String tt_cinvoice_curr) {
		this.tt_cinvoice_curr = tt_cinvoice_curr;
	}

	public String getTt_cinvoice_type() {
		return tt_cinvoice_type;
	}

	public void setTt_cinvoice_type(String tt_cinvoice_type) {
		this.tt_cinvoice_type = tt_cinvoice_type;
	}

	public String getTt_cinvoice_term() {
		return tt_cinvoice_term;
	}

	public void setTt_cinvoice_term(String tt_cinvoice_term) {
		this.tt_cinvoice_term = tt_cinvoice_term;
	}

	public String getTt_cinvoice_duedate() {
		return tt_cinvoice_duedate;
	}

	public void setTt_cinvoice_duedate(String tt_cinvoice_duedate) {
		this.tt_cinvoice_duedate = tt_cinvoice_duedate;
	}

	public String getTt_cinvoice_invdate() {
		return tt_cinvoice_invdate;
	}

	public void setTt_cinvoice_invdate(String tt_cinvoice_invdate) {
		this.tt_cinvoice_invdate = tt_cinvoice_invdate;
	}

	public String getTt_cinvoice_br() {
		return tt_cinvoice_br;
	}

	public void setTt_cinvoice_br(String tt_cinvoice_br) {
		this.tt_cinvoice_br = tt_cinvoice_br;
	}

	public BigDecimal getTt_cinvoice_tb() {
		return tt_cinvoice_tb;
	}

	public void setTt_cinvoice_tb(BigDecimal tt_cinvoice_tb) {
		this.tt_cinvoice_tb = tt_cinvoice_tb;
	}

	public BigDecimal getTt_cinvoice_tbcr() {
		return tt_cinvoice_tbcr;
	}

	public void setTt_cinvoice_tbcr(BigDecimal tt_cinvoice_tbcr) {
		this.tt_cinvoice_tbcr = tt_cinvoice_tbcr;
	}

	public BigDecimal getTt_cinvoice_tbdr() {
		return tt_cinvoice_tbdr;
	}

	public void setTt_cinvoice_tbdr(BigDecimal tt_cinvoice_tbdr) {
		this.tt_cinvoice_tbdr = tt_cinvoice_tbdr;
	}

	public BigDecimal getTt_cinvoice_hold() {
		return tt_cinvoice_hold;
	}

	public void setTt_cinvoice_hold(BigDecimal tt_cinvoice_hold) {
		this.tt_cinvoice_hold = tt_cinvoice_hold;
	}

	public String getTt_cinvoice_brname() {
		return tt_cinvoice_brname;
	}

	public void setTt_cinvoice_brname(String tt_cinvoice_brname) {
		this.tt_cinvoice_brname = tt_cinvoice_brname;
	}

	public int getTt_cinvoice_id() {
		return tt_cinvoice_id;
	}

	public void setTt_cinvoice_id(int tt_cinvoice_id) {
		this.tt_cinvoice_id = tt_cinvoice_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tt_cinvoice_id;
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
		Invoice other = (Invoice) obj;
		if (tt_cinvoice_id != other.tt_cinvoice_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [tt_cinvoice_id=" + tt_cinvoice_id + "]";
	}

	


}
