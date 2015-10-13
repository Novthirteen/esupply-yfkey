package com.yfkey.model;

import java.math.BigDecimal;
import java.util.List;

import com.progress.open4gl.Parameter;

public class Bill extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4462345545147935486L;
	private int tt_xprcmstro_seq; // 序号(前端排序条件)
	private String tt_xprcmstro_voucher; // 合并RC号
	private String tt_xprcmstro_suppcode; // 供应商代码
	private String tt_xprcmstro_invdate; // 发票日期(YYYY-MM-DD)
	private BigDecimal tt_xprcmstro_totalamt; // 整单金额

	private BigDecimal tt_xprcmstro_claimamt; // 索赔金额
	private String tt_xprcmstro_printed; // 已打印
	private String tt_xprcmstro_stat; // 账单状态
	private String tt_xprcmstro_xprcmstroid; // xprcmstr唯一标示

	// 查询
	private String tt_xprcmstri_fromdate; // 开始日期(YYYYMMDD)
	private String tt_xprcmstri_todate; // 结束日期(YYYYMMDD
    private String tt_suppcodei_suppcode; //供应商代码
	
	private int tt_xprcmstro_qty; // 发票数量
	private BigDecimal tt_xprcmstro_taxamt; // 增值税金额
	private BigDecimal tt_xprcmstro_notaxamt; // 不含税金额
	private String tt_xprcmstro_invnbr; // 发票号
	private String tt_xprcmstro_rmk; // 备注
	private String tt_xprcmstri_indexinvnbr; // 第一張发票号
	private String tt_xprcmstro_claiminv; //索赔发票
	private String tt_xprcmstro_type; //发票类型
	
	private String tt_xprcmstro_stat_desc; // 账单状态描述

	List<BillDetail> billDetailList;

	public int getTt_xprcmstro_seq() {
		return tt_xprcmstro_seq;
	}

	public void setTt_xprcmstro_seq(int tt_xprcmstro_seq) {
		this.tt_xprcmstro_seq = tt_xprcmstro_seq;
	}

	public String getTt_xprcmstro_voucher() {
		return tt_xprcmstro_voucher;
	}

	public void setTt_xprcmstro_voucher(String tt_xprcmstro_voucher) {
		this.tt_xprcmstro_voucher = tt_xprcmstro_voucher;
	}

	public String getTt_xprcmstro_suppcode() {
		return tt_xprcmstro_suppcode;
	}

	public void setTt_xprcmstro_suppcode(String tt_xprcmstro_suppcode) {
		this.tt_xprcmstro_suppcode = tt_xprcmstro_suppcode;
	}

	public String getTt_xprcmstro_invdate() {
		return tt_xprcmstro_invdate;
	}

	public void setTt_xprcmstro_invdate(String tt_xprcmstro_invdate) {
		this.tt_xprcmstro_invdate = tt_xprcmstro_invdate;
	}

	public BigDecimal getTt_xprcmstro_totalamt() {
		return tt_xprcmstro_totalamt;
	}

	public void setTt_xprcmstro_totalamt(BigDecimal tt_xprcmstro_totalamt) {
		this.tt_xprcmstro_totalamt = tt_xprcmstro_totalamt;
	}

	public String getTt_xprcmstro_printed() {
		return tt_xprcmstro_printed;
	}

	public void setTt_xprcmstro_printed(String tt_xprcmstro_printed) {
		this.tt_xprcmstro_printed = tt_xprcmstro_printed;
	}

	public String getTt_xprcmstro_stat() {
		return tt_xprcmstro_stat;
	}

	public void setTt_xprcmstro_stat(String tt_xprcmstro_stat) {
		this.tt_xprcmstro_stat = tt_xprcmstro_stat;
	}

	public String getTt_xprcmstro_xprcmstroid() {
		return tt_xprcmstro_xprcmstroid;
	}

	public void setTt_xprcmstro_xprcmstroid(String tt_xprcmstro_xprcmstroid) {
		this.tt_xprcmstro_xprcmstroid = tt_xprcmstro_xprcmstroid;
	}

	public List<BillDetail> getBillDetailList() {
		return billDetailList;
	}

	public void setBillDetailList(List<BillDetail> billDetailList) {
		this.billDetailList = billDetailList;
	}

	public String getTt_xprcmstri_fromdate() {
		return tt_xprcmstri_fromdate;
	}

	public void setTt_xprcmstri_fromdate(String tt_xprcmstri_fromdate) {
		this.tt_xprcmstri_fromdate = tt_xprcmstri_fromdate;
	}

	public String getTt_xprcmstri_todate() {
		return tt_xprcmstri_todate;
	}

	public void setTt_xprcmstri_todate(String tt_xprcmstri_todate) {
		this.tt_xprcmstri_todate = tt_xprcmstri_todate;
	}

	public BigDecimal getTt_xprcmstro_claimamt() {
		return tt_xprcmstro_claimamt;
	}

	public void setTt_xprcmstro_claimamt(BigDecimal tt_xprcmstro_claimamt) {
		this.tt_xprcmstro_claimamt = tt_xprcmstro_claimamt;
	}

	public int getTt_xprcmstro_qty() {
		return tt_xprcmstro_qty;
	}

	public void setTt_xprcmstro_qty(int tt_xprcmstro_qty) {
		this.tt_xprcmstro_qty = tt_xprcmstro_qty;
	}

	public BigDecimal getTt_xprcmstro_taxamt() {
		return tt_xprcmstro_taxamt;
	}

	public void setTt_xprcmstro_taxamt(BigDecimal tt_xprcmstro_taxamt) {
		this.tt_xprcmstro_taxamt = tt_xprcmstro_taxamt;
	}

	public BigDecimal getTt_xprcmstro_notaxamt() {
		return tt_xprcmstro_notaxamt;
	}

	public void setTt_xprcmstro_notaxamt(BigDecimal tt_xprcmstro_notaxamt) {
		this.tt_xprcmstro_notaxamt = tt_xprcmstro_notaxamt;
	}

	public String getTt_xprcmstro_stat_desc() {
		return tt_xprcmstro_stat_desc;
	}

	public void setTt_xprcmstro_stat_desc(String tt_xprcmstro_stat_desc) {
		this.tt_xprcmstro_stat_desc = tt_xprcmstro_stat_desc;
	}

	public String getTt_suppcodei_suppcode() {
		return tt_suppcodei_suppcode;
	}

	public void setTt_suppcodei_suppcode(String tt_suppcodei_suppcode) {
		this.tt_suppcodei_suppcode = tt_suppcodei_suppcode;
	}

	public String getTt_xprcmstri_indexinvnbr() {
		return tt_xprcmstri_indexinvnbr;
	}

	public void setTt_xprcmstri_indexinvnbr(String tt_xprcmstri_indexinvnbr) {
		this.tt_xprcmstri_indexinvnbr = tt_xprcmstri_indexinvnbr;
	}

	
	
	public String getTt_xprcmstro_rmk() {
		return tt_xprcmstro_rmk;
	}

	public void setTt_xprcmstro_rmk(String tt_xprcmstro_rmk) {
		this.tt_xprcmstro_rmk = tt_xprcmstro_rmk;
	}

	public String getTt_xprcmstro_claiminv() {
		return tt_xprcmstro_claiminv;
	}

	public void setTt_xprcmstro_claiminv(String tt_xprcmstro_claiminv) {
		this.tt_xprcmstro_claiminv = tt_xprcmstro_claiminv;
	}

	public void setTt_xprcmstro_invnbr(String tt_xprcmstro_invnbr) {
		this.tt_xprcmstro_invnbr = tt_xprcmstro_invnbr;
	}

	
	public String getTt_xprcmstro_invnbr() {
		return tt_xprcmstro_invnbr;
	}

	public String getTt_xprcmstro_type() {
		return tt_xprcmstro_type;
	}

	public void setTt_xprcmstro_type(String tt_xprcmstro_type) {
		this.tt_xprcmstro_type = tt_xprcmstro_type;
	}

	@Override
	public String toString() {
		return "Bill [tt_xprcmstro_xprcmstroid=" + tt_xprcmstro_xprcmstroid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_xprcmstro_xprcmstroid == null) ? 0 : tt_xprcmstro_xprcmstroid.hashCode());
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
		Bill other = (Bill) obj;
		if (tt_xprcmstro_xprcmstroid == null) {
			if (other.tt_xprcmstro_xprcmstroid != null)
				return false;
		} else if (!tt_xprcmstro_xprcmstroid.equals(other.tt_xprcmstro_xprcmstroid))
			return false;
		return true;
	}
	
	

}
