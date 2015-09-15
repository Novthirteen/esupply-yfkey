package com.yfkey.webapp.util;

import java.util.ArrayList;
import java.util.List;

import com.progress.open4gl.Parameter;
import com.progress.open4gl.ProDataObject;
import com.yfkey.model.Barcode;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;

/**
 * Convenience class for setting and retrieving cookies.
 */
/**
 * @author druidwang
 *
 */
public final class QADUtil {

	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private QADUtil() {
	}

	/**
	 * @param proDataObjectList
	 * @return 要货单转换
	 */
	public static List<PurchaseOrder> ConverToPurchaseOrder(List<ProDataObject> proDataObjectList) {

		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1; // qad的序号让我们自动生成
			for (ProDataObject o : proDataObjectList) {
				PurchaseOrder po = new PurchaseOrder();
				po.setTt_xpyhmstro_seq(i);
				po.setTt_xpyhmstro_yhdnbr(o.getString("tt_xpyhmstro_yhdnbr"));
				po.setTt_xpyhmstro_suppcode(o.getString("tt_xpyhmstro_suppcode"));
				po.setTt_xpyhmstro_shipto(o.getString("tt_xpyhmstro_shipto"));
				po.setTt_xpyhmstro_startdt(o.getString("tt_xpyhmstro_startdt"));
				po.setTt_xpyhmstro_receptdt(o.getString("tt_xpyhmstro_receptdt"));
				po.setTt_xpyhmstro_stat(o.getString("tt_xpyhmstro_stat"));
				po.setTt_xpyhmstro_priority(o.getString("tt_xpyhmstro_priority"));
				po.setTt_xpyhmstro_creator(o.getString("tt_xpyhmstro_creator"));
				po.setTt_xpyhmstro_xpyhmstroid(o.getString("tt_xpyhmstro_xpyhmstroid"));
				po.setTt_xpyhmstro_conf(o.getString("tt_xpyhmstro_conf"));
				po.setTt_xpyhmstro_print(o.getString("tt_xpyhmstro_print"));
				purchaseOrderList.add(po);
				i++;
			}
		}
		return purchaseOrderList;
	}

	public static List<PurchaseOrderDetail> ConvertToPurchaseOrderDetail(List<ProDataObject> proDataObjectList) {
		List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setTt_xpyhddeto_seq(i);
				pod.setTt_xpyhddeto_yhdnbr(o.getString("tt_xpyhddeto_yhdnbr"));
				pod.setTt_xpyhddeto_partnbr(o.getString("tt_xpyhddeto_partnbr"));
				pod.setTt_xpyhddeto_partdesc(o.getString("tt_xpyhddeto_partdesc"));
				pod.setTt_xpyhddeto_supppart(o.getString("tt_xpyhddeto_supppart"));
				pod.setTt_xpyhddeto_suppcode(o.getString("tt_xpyhddeto_suppcode"));
				pod.setTt_xpyhddeto_shipto(o.getString("tt_xpyhddeto_shipto"));
				pod.setTt_xpyhddeto_startdt(o.getString("tt_xpyhddeto_startdt"));
				pod.setTt_xpyhddeto_receptdt(o.getString("tt_xpyhddeto_receptdt"));
				pod.setTt_xpyhddeto_currcy(o.getString("tt_xpyhddeto_currcy"));

				pod.setTt_xpyhddeto_uom(o.getString("tt_xpyhddeto_uom"));
				pod.setTt_xpyhddeto_spq(o.getBigDecimal("tt_xpyhddeto_spq"));
				pod.setTt_xpyhddeto_reqqty(o.getBigDecimal("tt_xpyhddeto_reqqty"));
				pod.setTt_xpyhddeto_ordqty(o.getBigDecimal("tt_xpyhddeto_ordqty"));
				pod.setTt_xpyhddeto_stat(o.getString("tt_xpyhddeto_stat"));
				pod.setTt_xpyhddeto_priority(o.getString("tt_xpyhddeto_priority"));
				pod.setTt_xpyhdde_creator(o.getString("tt_xpyhddeto_creator"));
				pod.setTt_xpyhddeto_xpyhmstroid(o.getString("tt_xpyhddeto_xpyhmstroid"));
				pod.setTt_xpyhddeto_xpyhddetoid(o.getString("tt_xpyhddeto_xpyhddetoid"));
			}
		}
		return purchaseOrderDetailList;

	}

	public static List<Object> ConvertToPurchaseOrderAndDetail(List<ProDataObject> proDataObjectList) {
		PurchaseOrder po = new PurchaseOrder();
		List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();
		List<Object> poList = new ArrayList<Object>();

		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			ProDataObject poDataObject = proDataObjectList.get(0);
			po.setTt_xpyhmstro_yhdnbr(poDataObject.getString("tt_xpyhddeto_yhdnbr"));
			po.setTt_xpyhmstro_priority(poDataObject.getString("tt_xpyhddeto_priority"));
			po.setTt_xpyhmstro_startdt(poDataObject.getString("tt_xpyhddeto_startdt"));
			po.setTt_xpyhmstro_receptdt(poDataObject.getString("tt_xpyhddeto_receptdt"));
			po.setTt_xpyhmstro_suppcode(poDataObject.getString("tt_xpyhddeto_suppcode"));
			po.setTt_xpyhmstro_currcy(poDataObject.getString("tt_xpyhddeto_currcy"));
			po.setTt_xpyhmstro_shipto(poDataObject.getString("tt_xpyhddeto_shipto"));
			po.setTt_xpyhmstro_stat(poDataObject.getString("tt_xpyhddeto_stat"));
			po.setRemark(poDataObject.getString("tt_xpyhddeto_remark"));
			po.setTt_xpyhmstro_xpyhmstroid(poDataObject.getString("tt_xpyhddeto_xpyhmstroid"));
			poList.add(po);

			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setTt_xpyhddeto_seq(i);
				pod.setTt_xpyhddeto_yhdnbr(o.getString("tt_xpyhddeto_yhdnbr"));
				pod.setTt_xpyhddeto_partnbr(o.getString("tt_xpyhddeto_partnbr"));
				pod.setTt_xpyhddeto_partdesc(o.getString("tt_xpyhddeto_partdesc"));
				pod.setTt_xpyhddeto_supppart(o.getString("tt_xpyhddeto_supppart"));
				pod.setTt_xpyhddeto_suppcode(o.getString("tt_xpyhddeto_suppcode"));
				pod.setTt_xpyhddeto_shipto(o.getString("tt_xpyhddeto_shipto"));
				pod.setTt_xpyhddeto_startdt(o.getString("tt_xpyhddeto_startdt"));
				pod.setTt_xpyhddeto_receptdt(o.getString("tt_xpyhddeto_receptdt"));
				pod.setTt_xpyhddeto_currcy(o.getString("tt_xpyhddeto_currcy"));
				pod.setTt_xpyhddeto_uom(o.getString("tt_xpyhddeto_uom"));
				pod.setTt_xpyhddeto_spq(o.getBigDecimal("tt_xpyhddeto_spq"));
				pod.setTt_xpyhddeto_reqqty(o.getBigDecimal("tt_xpyhddeto_reqqty"));
				pod.setTt_xpyhddeto_ordqty(o.getBigDecimal("tt_xpyhddeto_ordqty"));
				pod.setTt_xpyhddeto_stat(o.getString("tt_xpyhddeto_stat"));
				pod.setTt_xpyhddeto_priority(o.getString("tt_xpyhddeto_priority"));

				pod.setTt_xpyhddeto_xpyhmstroid(o.getString("tt_xpyhddeto_xpyhmstroid"));
				pod.setTt_xpyhddeto_xpyhddetoid(o.getString("tt_xpyhddeto_xpyhddetoid"));
				pod.setTt_xpyhddeto_shipedqty(o.getBigDecimal("tt_xpyhddeto_shipedqty"));
				purchaseOrderDetailList.add(pod);

			}
			poList.add(purchaseOrderDetailList);
		}

		return poList;

	}

	public static List<PurchaseOrderDetail> ConvertToBarcodePurchaseOrderDetail(List<ProDataObject> proDataObjectList) {
		List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setTt_xpyhddeto_seq(i);
				pod.setTt_xpyhddeto_yhdnbr(o.getString("tt_xpyhddeto_yhdnbr"));
				pod.setTt_xpyhddeto_partnbr(o.getString("tt_xpyhddeto_partnbr"));
				pod.setTt_xpyhddeto_partdesc(o.getString("tt_xpyhddeto_partdesc"));
				pod.setTt_xpyhddeto_supppart(o.getString("tt_xpyhddeto_supppart"));
				pod.setTt_xpyhddeto_uom(o.getString("tt_xpyhddeto_uom"));
				pod.setTt_xpyhddeto_innnerqty(o.getBigDecimal("tt_xpyhddeto_innnerqty"));
				pod.setTt_xpyhddeto_externalqty(o.getBigDecimal("tt_xpyhddeto_externalqty"));
				pod.setTt_xpyhddeto_pktype(o.getString("tt_xpyhddeto_pktype"));
				pod.setTt_xpyhddeto_lots(o.getString("tt_xpyhddeto_lots"));
				pod.setTt_xpyhddeto_qty(o.getBigDecimal("tt_xpyhddeto_qty"));
				pod.setTt_xpyhddeto_suppcode(o.getString("tt_xpyhddeto_suppcode"));

				purchaseOrderDetailList.add(pod);

			}
		}
		return purchaseOrderDetailList;
	}

	public static List<Barcode> ConvertToBarcode(List<ProDataObject> proDataObjectList) {
		List<Barcode> barcodeList = new ArrayList<Barcode>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				Barcode bc = new Barcode();
				bc.setTt_bcdeto_date(o.getString("tt_bcdeto_date"));
				bc.setTt_bcdeto_partnbr(o.getString("tt_bcdeto_partnbr"));
				bc.setTt_bcdeto_partdesc(o.getString("tt_bcdeto_partdesc"));
				bc.setTt_bcdeto_lots(o.getString("tt_bcdeto_lots"));
				bc.setTt_bcdeto_qty(o.getBigDecimal("tt_bcdeto_qty"));
				bc.setTt_bcdeto_bcinfo1(o.getString("tt_bcdeto_bcinfo1"));
				bc.setTt_bcdeto_suppname(o.getString("tt_bcdeto_suppname"));
				bc.setTt_bcdeto_bcinfo2(o.getString("tt_bcdeto_bcinfo2"));
				bc.setTt_bcdeto_serial(o.getString("tt_bcdeto_serial"));
				bc.setTt_bcdeto_bcdetoid(o.getString("tt_bcdeto_bcdetoid"));

				barcodeList.add(bc);
			}
		}
		return barcodeList;

	}
	
	
	//ship
	public static List<Object> ConvertToShipPurchaseOrderAndDetail(List<ProDataObject> proDataObjectList) {
		PurchaseOrder po = new PurchaseOrder();
		List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();
		List<Object> poList = new ArrayList<Object>();

		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			ProDataObject poDataObject = proDataObjectList.get(0);
			po.setTt_xpyhmstro_yhdnbr(poDataObject.getString("tt_xpyhddeto_yhdnbr"));
			po.setTt_xpyhmstro_suppcode(poDataObject.getString("tt_xpyhddeto_suppcode"));
			po.setTt_xpyhddeto_suppname(poDataObject.getString("tt_xpyhddeto_suppname"));
			po.setTt_xpyhmstro_shipfrom(poDataObject.getString("tt_xpyhddeto_shipfrom"));
			po.setTt_xpyhmstro_shipto(poDataObject.getString("tt_xpyhddeto_shipto"));
			po.setTt_xpyhddeto_carrier(poDataObject.getString("tt_xpyhddeto_carrier"));
			po.setTt_xpyhddeto_dock(poDataObject.getString("tt_xpyhddeto_dock"));
			po.setTt_xpyhmstro_xpyhmstroid(poDataObject.getString("tt_xpyhddeto_xpyhmstroid"));
		
			poList.add(po);

			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setTt_xpyhddeto_seq(i);
				pod.setTt_xpyhddeto_yhdnbr(o.getString("tt_xpyhddeto_yhdnbr"));
				pod.setTt_xpyhddeto_partnbr(o.getString("tt_xpyhddeto_partnbr"));
				pod.setTt_xpyhddeto_partdesc(o.getString("tt_xpyhddeto_partdesc"));
				pod.setTt_xpyhddeto_supppart(o.getString("tt_xpyhddeto_supppart"));
				pod.setTt_xpyhddeto_suppcode(o.getString("tt_xpyhddeto_suppcode"));
				pod.setTt_xpyhddeto_shipto(o.getString("tt_xpyhddeto_shipto"));
				pod.setTt_xpyhddeto_uom(o.getString("tt_xpyhddeto_uom"));
				pod.setTt_xpyhddeto_spq(o.getBigDecimal("tt_xpyhddeto_spq"));
				pod.setTt_xpyhddeto_toloc(o.getString("tt_xpyhddeto_toloc"));
				pod.setTt_xpyhddeto_delvqty(o.getBigDecimal("tt_xpyhddeto_delvqty"));
				pod.setTt_xpyhddeto_xpyhmstroid(o.getString("tt_xpyhddeto_xpyhmstroid"));
				pod.setTt_xpyhddeto_xpyhddetoid(o.getString("tt_xpyhddeto_xpyhddetoid"));
			
				purchaseOrderDetailList.add(pod);

			}
			poList.add(purchaseOrderDetailList);
		}

		return poList;

	}

}
