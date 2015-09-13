package com.yfkey.model;

import java.math.BigDecimal;

public class Barcode extends BaseObject {
	
	private String tt_bcdeto_date;         			  	  //打印日期(YYYY-MM-DD)
	private String tt_bcdeto_partnbr;     				  //物料号
	private String tt_bcdeto_partdesc;        			  //物料描述
	private String tt_bcdeto_lots;   				  	  //批号
	private BigDecimal tt_bcdeto_qty;   				  	  //数量
	private String tt_bcdeto_bcinfo1;   				  //条码1(1维码)
	private String tt_bcdeto_suppname;   				  //供应商名称
	private String tt_bcdeto_bcinfo2;   				  //条码2(2维码)
	private String tt_bcdeto_serial;   				  	  //条码序列号
	private String tt_bcdeto_bcdetoid;   				  //bcdet唯一标示
	
	
	public String getTt_bcdeto_date() {
		return tt_bcdeto_date;
	}
	public void setTt_bcdeto_date(String tt_bcdeto_date) {
		this.tt_bcdeto_date = tt_bcdeto_date;
	}
	public String getTt_bcdeto_partnbr() {
		return tt_bcdeto_partnbr;
	}
	public void setTt_bcdeto_partnbr(String tt_bcdeto_partnbr) {
		this.tt_bcdeto_partnbr = tt_bcdeto_partnbr;
	}
	public String getTt_bcdeto_partdesc() {
		return tt_bcdeto_partdesc;
	}
	public void setTt_bcdeto_partdesc(String tt_bcdeto_partdesc) {
		this.tt_bcdeto_partdesc = tt_bcdeto_partdesc;
	}
	public String getTt_bcdeto_lots() {
		return tt_bcdeto_lots;
	}
	public void setTt_bcdeto_lots(String tt_bcdeto_lots) {
		this.tt_bcdeto_lots = tt_bcdeto_lots;
	}
	public BigDecimal getTt_bcdeto_qty() {
		return tt_bcdeto_qty;
	}
	public void setTt_bcdeto_qty(BigDecimal tt_bcdeto_qty) {
		this.tt_bcdeto_qty = tt_bcdeto_qty;
	}
	public String getTt_bcdeto_bcinfo1() {
		return tt_bcdeto_bcinfo1;
	}
	public void setTt_bcdeto_bcinfo1(String tt_bcdeto_bcinfo1) {
		this.tt_bcdeto_bcinfo1 = tt_bcdeto_bcinfo1;
	}
	public String getTt_bcdeto_suppname() {
		return tt_bcdeto_suppname;
	}
	public void setTt_bcdeto_suppname(String tt_bcdeto_suppname) {
		this.tt_bcdeto_suppname = tt_bcdeto_suppname;
	}
	public String getTt_bcdeto_bcinfo2() {
		return tt_bcdeto_bcinfo2;
	}
	public void setTt_bcdeto_bcinfo2(String tt_bcdeto_bcinfo2) {
		this.tt_bcdeto_bcinfo2 = tt_bcdeto_bcinfo2;
	}
	public String getTt_bcdeto_serial() {
		return tt_bcdeto_serial;
	}
	public void setTt_bcdeto_serial(String tt_bcdeto_serial) {
		this.tt_bcdeto_serial = tt_bcdeto_serial;
	}
	public String getTt_bcdeto_bcdetoid() {
		return tt_bcdeto_bcdetoid;
	}
	public void setTt_bcdeto_bcdetoid(String tt_bcdeto_bcdetoid) {
		this.tt_bcdeto_bcdetoid = tt_bcdeto_bcdetoid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tt_bcdeto_bcdetoid == null) ? 0 : tt_bcdeto_bcdetoid.hashCode());
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
		Barcode other = (Barcode) obj;
		if (tt_bcdeto_bcdetoid == null) {
			if (other.tt_bcdeto_bcdetoid != null)
				return false;
		} else if (!tt_bcdeto_bcdetoid.equals(other.tt_bcdeto_bcdetoid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Barcode [tt_bcdeto_bcdetoid=" + tt_bcdeto_bcdetoid + "]";
	}
	
	
}