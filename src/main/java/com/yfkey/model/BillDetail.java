package com.yfkey.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.progress.open4gl.Parameter;



public class BillDetail extends BaseObject {

	
	
	private String tt_xpyhddeto_voucher; 					// 合并RC号
	private String tt_xpyhddeto_partnbr; 					// 物料号
	private String tt_xpyhddeto_receiver; 					// 收货单号
	private int tt_xpyhddeto_seq; 						// 序号(前端排序条件)
	private BigDecimal tt_xpyhddeto_poprice; 					//采购单价
	private String tt_xpyhddeto_uom; 						// 单位
	private BigDecimal tt_xpyhddeto_invprice; 					// 发票单价
	private BigDecimal tt_xpyhddeto_invamt; 					// 发票金额
	private String tt_xpyhddeto_partdesc; 					// 物料描述
	private String tt_xpyhddeto_rcdate; 					// 收货日期(YYYY-MM-DD)

	private BigDecimal tt_xpyhddeto_claiminv; 					// 索赔发票
	private BigDecimal tt_xpyhddeto_claimamt; 					// 索赔金额
	private String tt_xpyhddeto_xpyhddetoid;               // xprcdetr唯一标示

	private BigDecimal tt_xpyhddeto_rcqty;                 //入库数量
	
	
	public String getTt_xpyhddeto_xpyhddetoid() {
		return tt_xpyhddeto_xpyhddetoid;
	}
	public void setTt_xpyhddeto_xpyhddetoid(String tt_xpyhddeto_xpyhddetoid) {
		this.tt_xpyhddeto_xpyhddetoid = tt_xpyhddeto_xpyhddetoid;
	}
	public String getTt_xpyhddeto_voucher() {
		return tt_xpyhddeto_voucher;
	}
	public void setTt_xpyhddeto_voucher(String tt_xpyhddeto_voucher) {
		this.tt_xpyhddeto_voucher = tt_xpyhddeto_voucher;
	}
	public String getTt_xpyhddeto_partnbr() {
		return tt_xpyhddeto_partnbr;
	}
	public void setTt_xpyhddeto_partnbr(String tt_xpyhddeto_partnbr) {
		this.tt_xpyhddeto_partnbr = tt_xpyhddeto_partnbr;
	}
	public String getTt_xpyhddeto_receiver() {
		return tt_xpyhddeto_receiver;
	}
	public void setTt_xpyhddeto_receiver(String tt_xpyhddeto_receiver) {
		this.tt_xpyhddeto_receiver = tt_xpyhddeto_receiver;
	}
	public int getTt_xpyhddeto_seq() {
		return tt_xpyhddeto_seq;
	}
	public void setTt_xpyhddeto_seq(int tt_xpyhddeto_seq) {
		this.tt_xpyhddeto_seq = tt_xpyhddeto_seq;
	}
	public BigDecimal getTt_xpyhddeto_poprice() {
		return tt_xpyhddeto_poprice;
	}
	public void setTt_xpyhddeto_poprice(BigDecimal tt_xpyhddeto_poprice) {
		this.tt_xpyhddeto_poprice = tt_xpyhddeto_poprice;
	}
	public String getTt_xpyhddeto_uom() {
		return tt_xpyhddeto_uom;
	}
	public void setTt_xpyhddeto_uom(String tt_xpyhddeto_uom) {
		this.tt_xpyhddeto_uom = tt_xpyhddeto_uom;
	}
	public BigDecimal getTt_xpyhddeto_invprice() {
		return tt_xpyhddeto_invprice;
	}
	public void setTt_xpyhddeto_invprice(BigDecimal tt_xpyhddeto_invprice) {
		this.tt_xpyhddeto_invprice = tt_xpyhddeto_invprice;
	}
	public BigDecimal getTt_xpyhddeto_invamt() {
		return tt_xpyhddeto_invamt;
	}
	public void setTt_xpyhddeto_invamt(BigDecimal tt_xpyhddeto_invamt) {
		this.tt_xpyhddeto_invamt = tt_xpyhddeto_invamt;
	}
	public String getTt_xpyhddeto_partdesc() {
		return tt_xpyhddeto_partdesc;
	}
	public void setTt_xpyhddeto_partdesc(String tt_xpyhddeto_partdesc) {
		this.tt_xpyhddeto_partdesc = tt_xpyhddeto_partdesc;
	}
	public String getTt_xpyhddeto_rcdate() {
		return tt_xpyhddeto_rcdate;
	}
	public void setTt_xpyhddeto_rcdate(String tt_xpyhddeto_rcdate) {
		this.tt_xpyhddeto_rcdate = tt_xpyhddeto_rcdate;
	}
	
	public BigDecimal getTt_xpyhddeto_claiminv() {
		return tt_xpyhddeto_claiminv;
	}
	public void setTt_xpyhddeto_claiminv(BigDecimal tt_xpyhddeto_claiminv) {
		this.tt_xpyhddeto_claiminv = tt_xpyhddeto_claiminv;
	}
	public BigDecimal getTt_xpyhddeto_claimamt() {
		return tt_xpyhddeto_claimamt;
	}
	public void setTt_xpyhddeto_claimamt(BigDecimal tt_xpyhddeto_claimamt) {
		this.tt_xpyhddeto_claimamt = tt_xpyhddeto_claimamt;
	}
	
	public BigDecimal getTt_xpyhddeto_rcqty() {
		return tt_xpyhddeto_rcqty;
	}
	
	public void setTt_xpyhddeto_rcqty(BigDecimal tt_xpyhddeto_rcqty) {
		this.tt_xpyhddeto_rcqty = tt_xpyhddeto_rcqty;
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
		BillDetail other = (BillDetail) obj;
		if (tt_xpyhddeto_xpyhddetoid != other.tt_xpyhddeto_xpyhddetoid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BillDetail [tt_xpyhddeto_xpyhddetoid=" + tt_xpyhddeto_xpyhddetoid + "]";
	}
	
	
	

	
}
