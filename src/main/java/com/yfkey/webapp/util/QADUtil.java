package com.yfkey.webapp.util;

import java.util.ArrayList;
import java.util.List;

import com.progress.open4gl.Parameter;
import com.progress.open4gl.ProDataObject;
import com.yfkey.Constants;
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;
import com.yfkey.model.Barcode;
import com.yfkey.model.Bill;
import com.yfkey.model.BillDetail;
import com.yfkey.model.Gender;
import com.yfkey.model.LabelValue;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.model.Receipt;
import com.yfkey.model.ReceiptDetail;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

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
				purchaseOrderDetailList.add(pod);
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
				pod.setTt_xpyhddeto_xpyhddetoid(o.getString("tt_xpyhddeto_xpyhddetoid"));

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
				bc.setTt_bcdeto_bcnon(o.getString("tt_bcdeto_bcnon"));
				barcodeList.add(bc);
			}
		}
		return barcodeList;

	}

	// ship
	public static List<Object> ConvertToShipPurchaseOrderAndDetail(List<ProDataObject> proDataObjectList) {
		PurchaseOrder po = new PurchaseOrder();
		List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();
		List<Object> poList = new ArrayList<Object>();

		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			ProDataObject poDataObject = proDataObjectList.get(0);
			po.setTt_xpyhmstro_yhdnbr(poDataObject.getString("tt_xpyhddeto_yhdnbr"));
			po.setTt_xpyhmstro_suppcode(poDataObject.getString("tt_xpyhddeto_suppcode"));
			po.setTt_xpyhmstro_suppname(poDataObject.getString("tt_xpyhddeto_suppname"));
			po.setTt_xpyhmstro_shipfrom(poDataObject.getString("tt_xpyhddeto_shipfrom"));
			po.setTt_xpyhmstro_shipto(poDataObject.getString("tt_xpyhddeto_shipto"));
			po.setTt_xpyhmstro_carrier(poDataObject.getString("tt_xpyhddeto_carrier"));
			po.setTt_xpyhmstro_dock(poDataObject.getString("tt_xpyhddeto_dock"));
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
				pod.setTt_xpyhddeto_openqty(o.getBigDecimal("tt_xpyhddeto_openqty"));
				pod.setTt_xpyhddeto_xpyhmstroid(o.getString("tt_xpyhddeto_xpyhmstroid"));
				pod.setTt_xpyhddeto_xpyhddetoid(o.getString("tt_xpyhddeto_xpyhddetoid"));

				purchaseOrderDetailList.add(pod);

			}
			poList.add(purchaseOrderDetailList);
		}

		return poList;

	}

	// asn
	public static List<Asn> ConverToAsn(List<ProDataObject> proDataObjectList) {

		List<Asn> asnList = new ArrayList<Asn>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1; // qad的序号让我们自动生成
			for (ProDataObject o : proDataObjectList) {
				Asn asn = new Asn();

				asn.setTt_xasnmstro_seq(i);
				asn.setTt_xasnmstro_asnnbr(o.getString("tt_xasnmstro_asnnbr"));
				asn.setTt_xasnmstro_shipto(o.getString("tt_xasnmstro_shipto"));
				asn.setTt_xasnmstro_startdt(o.getString("tt_xasnmstro_startdt"));
				asn.setTt_xasnmstro_stat(o.getString("tt_xasnmstro_stat"));
				asn.setTt_xasnmstro_creator(o.getString("tt_xasnmstro_creator"));
				asn.setTt_xasnmstro_xasnmstroid(o.getString("tt_xasnmstro_xasnmstroid"));

				asnList.add(asn);
				i++;
			}
		}
		return asnList;
	}

	// asn detail
	public static List<AsnDetail> ConverToAsnDetail(List<ProDataObject> proDataObjectList) {

		List<AsnDetail> asnDetailList = new ArrayList<AsnDetail>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1; // qad的序号让我们自动生成
			for (ProDataObject o : proDataObjectList) {
				AsnDetail asnDetail = new AsnDetail();
				asnDetail.setTt_xasndeto_seq(i);
				asnDetail.setTt_xasndeto_asnnbr(o.getString("tt_xasndeto_asnnbr"));
				asnDetail.setTt_xasndeto_shipto(o.getString("tt_xasndeto_shipto"));
				asnDetail.setTt_xasndeto_startdt(o.getString("tt_xasndeto_startdt"));
				asnDetail.setTt_xasndeto_stat(o.getInt("tt_xasndeto_stat"));
				asnDetail.setTt_xasndeto_creator(o.getString("tt_xasndeto_creator"));
				asnDetail.setTt_xasndeto_partnbr(o.getString("tt_xasndeto_partnbr"));
				asnDetail.setTt_xasndeto_partdesc(o.getString("tt_xasndeto_partdesc"));
				asnDetail.setTt_xasndeto_supppart(o.getString("tt_xasndeto_supppart"));
				asnDetail.setTt_xasndeto_uom(o.getString("tt_xasndeto_uom"));
				asnDetail.setTt_xasndeto_spq(o.getBigDecimal("tt_xasndeto_spq"));
				asnDetail.setTt_xasndeto_asnqty(o.getBigDecimal("tt_xasndeto_asnqty"));
				asnDetail.setTt_xasndeto_xasnmstroid(o.getString("tt_xasndeto_xasnmstroid"));
				asnDetail.setTt_xasndeto_xasndetoid(o.getString("tt_xasndeto_xasndetoid"));
                asnDetail.setTt_xasndeto_yhdnbr(o.getString("tt_xasndeto_yhdnbr"));
				asnDetailList.add(asnDetail);
				i++;
			}
		}
		return asnDetailList;
	}

	// asn master and detail
	public static List<Object> ConvertToAsnAndDetail(List<ProDataObject> proDataObjectList) {
		Asn asn = new Asn();
		List<AsnDetail> asnDetailList = new ArrayList<AsnDetail>();
		List<Object> asnList = new ArrayList<Object>();

		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			ProDataObject om = proDataObjectList.get(0);

			asn.setTt_xasnmstro_asnnbr(om.getString("tt_xasndeto_asnnbr"));
			asn.setTt_xasnmstro_shipto(om.getString("tt_xasndeto_shipto"));
			asn.setTt_xasnmstro_startdt(om.getString("tt_xasndeto_startdt"));
			asn.setTt_xasnmstro_stat(om.getString("tt_xasndeto_stat"));
			asn.setTt_xasnmstro_creator(om.getString("tt_xasndeto_creator"));
			asn.setTt_xasnmstro_suppcode(om.getString("tt_xasndeto_vend"));
			asnList.add(asn);

			int i = 1;
			for (ProDataObject o : proDataObjectList) {

				AsnDetail asnDetail = new AsnDetail();
				asnDetail.setTt_xasndeto_seq(i);
				asnDetail.setTt_xasndeto_asnnbr(o.getString("tt_xasndeto_asnnbr"));
				asnDetail.setTt_xasndeto_shipto(o.getString("tt_xasndeto_shipto"));
				asnDetail.setTt_xasndeto_startdt(o.getString("tt_xasndeto_startdt"));
				asnDetail.setTt_xasndeto_stat(o.getInt("tt_xasndeto_stat"));
				asnDetail.setTt_xasndeto_creator(o.getString("tt_xasndeto_creator"));
				asnDetail.setTt_xasndeto_partnbr(o.getString("tt_xasndeto_partnbr"));
				asnDetail.setTt_xasndeto_partdesc(o.getString("tt_xasndeto_partdesc"));
				asnDetail.setTt_xasndeto_supppart(o.getString("tt_xasndeto_supppart"));
				asnDetail.setTt_xasndeto_uom(o.getString("tt_xasndeto_uom"));
				asnDetail.setTt_xasndeto_spq(o.getBigDecimal("tt_xasndeto_spq"));
				asnDetail.setTt_xasndeto_asnqty(o.getBigDecimal("tt_xasndeto_asnqty"));
				asnDetail.setTt_xasndeto_xasndetoid(o.getString("tt_xasndeto_xasndetoid"));
				asnDetail.setTt_xasndeto_yhdnbr(o.getString("tt_xasndeto_yhdnbr"));
				asnDetailList.add(asnDetail);

			}
			asnList.add(asnDetailList);
		}

		return asnList;

	}

	// receipt mstr
		public static List<Receipt> ConverToReceipt(List<ProDataObject> proDataObjectList) {

			List<Receipt> receiptList = new ArrayList<Receipt>();
			if (proDataObjectList != null && proDataObjectList.size() > 0) {
				int i = 1; // qad的序号让我们自动生成
				for (ProDataObject o : proDataObjectList) {
					Receipt receipt = new Receipt();
					receipt.setTt_prhmstro_seq(i);
					receipt.setTt_prhmstro_receiver(o.getString("tt_prhmstro_receiver"));
					receipt.setTt_prhmstro_suppcode(o.getString("tt_prhmstro_suppcode"));
					receipt.setTt_prhmstro_asnnbr(o.getString("tt_prhmstro_asnnbr"));
					receipt.setTt_prhmstro_suppcode(o.getString("tt_prhmstro_suppcode"));
					receipt.setTt_prhmstro_rcdate(o.getString("tt_prhmstro_rcdate"));
					receipt.setTt_prhmstro_rcuserid(o.getString("tt_prhmstro_rcuserid"));
					receipt.setTt_prhmstro_prhmstroid(o.getString("tt_prhmstro_prhmstroid"));
					
					receiptList.add(receipt);
				}
			}
			return receiptList;
		}
		
	// receipt detail
	public static List<ReceiptDetail> ConverToReceiptDetail(List<ProDataObject> proDataObjectList) {

		List<ReceiptDetail> receiptDetailList = new ArrayList<ReceiptDetail>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1; // qad的序号让我们自动生成
			for (ProDataObject o : proDataObjectList) {
				ReceiptDetail receiptDetail = new ReceiptDetail();
				receiptDetail.setTt_prhdeto_seq(i);
				receiptDetail.setTt_prhdeto_receiver(o.getString("tt_prhdeto_receiver"));
				receiptDetail.setTt_prhdeto_yhdnbr(o.getString("tt_prhdeto_yhdnbr"));
				receiptDetail.setTt_prhdeto_partnbr(o.getString("tt_prhdeto_partnbr"));
				receiptDetail.setTt_prhdeto_partdesc(o.getString("tt_prhdeto_partdesc"));
				receiptDetail.setTt_prhdeto_supppart(o.getString("tt_prhdeto_supppart"));
				receiptDetail.setTt_prhdeto_uom(o.getString("tt_prhdeto_uom"));
				receiptDetail.setTt_prhdeto_spq(o.getBigDecimal("tt_prhdeto_spq"));
				receiptDetail.setTt_prhdeto_toloc(o.getString("tt_prhdeto_toloc"));
				receiptDetail.setTt_prhdeto_delvqty(o.getBigDecimal("tt_prhdeto_delvqty"));
			    receiptDetail.setTt_prhdeto_revdqty(o.getBigDecimal("tt_prhdeto_revdqty"));
			    receiptDetailList.add(receiptDetail);
			    i++;
			}
		}
		return receiptDetailList;
	}
	
	
	
	// asn receipt and detail
		public static List<Object> ConvertToReceiptAndDetail(List<ProDataObject> proDataObjectList) {
			Receipt receipt = new Receipt();
			List<ReceiptDetail> receiptDetailList = new ArrayList<ReceiptDetail>();
			List<Object> receiptList = new ArrayList<Object>();

			if (proDataObjectList != null && proDataObjectList.size() > 0) {
				ProDataObject om = proDataObjectList.get(0);

				receipt.setTt_prhmstro_receiver(om.getString("tt_prhdeto_receiver"));
				receipt.setTt_prhmstro_suppcode(om.getString("tt_prhdeto_suppcode"));
				receipt.setTt_prhmstro_asnnbr(om.getString("tt_prhdeto_asnnbr"));
				receipt.setTt_prhmstro_suppcode(om.getString("tt_prhdeto_suppcode"));
				receipt.setTt_prhmstro_rcdate(om.getString("tt_prhdeto_rcdate"));
				receipt.setTt_prhmstro_rcuserid(om.getString("tt_prhdeto_rcuserid"));
				receipt.setTt_prhmstro_prhmstroid(om.getString("tt_prhdeto_prhmstroid"));
				receipt.setTt_prhmstro_shipto(om.getString("tt_prhdeto_shipto"));
				receiptList.add(receipt);

				int i = 1;
				for (ProDataObject o : proDataObjectList) {

					ReceiptDetail receiptDetail = new ReceiptDetail();
					receiptDetail.setTt_prhdeto_seq(i);
					receiptDetail.setTt_prhdeto_yhdnbr(o.getString("tt_prhdeto_yhdnbr"));
					receiptDetail.setTt_prhdeto_partnbr(o.getString("tt_prhdeto_partnbr"));
					receiptDetail.setTt_prhdeto_partdesc(o.getString("tt_prhdeto_partdesc"));
					receiptDetail.setTt_prhdeto_supppart(o.getString("tt_prhdeto_supppart"));
					receiptDetail.setTt_prhdeto_uom(o.getString("tt_prhdeto_uom"));
					receiptDetail.setTt_prhdeto_spq(o.getBigDecimal("tt_prhdeto_spq"));
					receiptDetail.setTt_prhdeto_toloc(o.getString("tt_prhdeto_toloc"));
					receiptDetail.setTt_prhdeto_delvqty(o.getBigDecimal("tt_prhdeto_delvqty"));
				    receiptDetail.setTt_prhdeto_revdqty(o.getBigDecimal("tt_prhdeto_revdqty"));
				    receiptDetailList.add(receiptDetail);
				}
				receiptList.add(receiptDetailList);
			}

			return receiptList;

		}

		
		
		//bill mstr
		public static List<Bill> ConverToBill(List<ProDataObject> proDataObjectList) {

			List<Bill> billList = new ArrayList<Bill>();
			if (proDataObjectList != null && proDataObjectList.size() > 0) {
				int i = 1; // qad的序号让我们自动生成
				for (ProDataObject o : proDataObjectList) {
					Bill bill = new Bill();
					bill.setTt_xprcmstro_seq(i);
					bill.setTt_xprcmstro_voucher(o.getString("tt_xprcmstro_voucher"));
					bill.setTt_xprcmstro_suppcode(o.getString("tt_xprcmstro_suppcode"));
					bill.setTt_xprcmstro_invdate(o.getString("tt_xprcmstro_invdate"));
					bill.setTt_xprcmstro_totalamt(o.getBigDecimal("tt_xprcmstro_totalamt"));
					bill.setTt_xprcmstro_printed(o.getString("tt_xprcmstro_printed"));
					bill.setTt_xprcmstro_stat(o.getString("tt_xprcmstro_stat"));
					bill.setTt_xprcmstro_xprcmstroid(o.getString("tt_xprcmstro_xprcmstroid"));
				    bill.setTt_xprcmstro_type(o.getString("tt_xprcmstro_type"));

					billList.add(bill);
					i++;
				}
			}
			return billList;
		}

		//bill det
		public static List<Object> ConvertToBillAndDetail(List<ProDataObject> proDataObjectList) {
			Bill bill = new Bill();
			List<BillDetail> billDetailList = new ArrayList<BillDetail>();
			List<Object> billList = new ArrayList<Object>();

			if (proDataObjectList != null && proDataObjectList.size() > 0) {
				ProDataObject om = proDataObjectList.get(0);
				
				bill.setTt_xprcmstro_voucher(om.getString("tt_xpyhddeto_voucher"));
				bill.setTt_xprcmstro_suppcode(om.getString("tt_xpyhddeto_suppcode"));
				bill.setTt_xprcmstro_invdate(om.getString("tt_xpyhddeto_invdate"));
				bill.setTt_xprcmstro_totalamt(om.getBigDecimal("tt_xpyhddeto_totalamt"));
				bill.setTt_xprcmstro_stat(om.getString("tt_xpyhddeto_stat"));
				
				bill.setTt_xprcmstro_qty(om.getInt("tt_xpyhddeto_qty"));
				bill.setTt_xprcmstro_taxamt(om.getBigDecimal("tt_xpyhddeto_taxamt"));
				bill.setTt_xprcmstro_notaxamt(om.getBigDecimal("tt_xpyhddeto_notaxamt"));
				bill.setTt_xprcmstro_invnbr(om.getString("tt_xpyhddeto_invnbr"));
				bill.setTt_xprcmstro_rmk(om.getString("tt_xpyhddeto_rmk"));
				bill.setTt_xprcmstro_claiminv(om.getString("tt_xpyhddeto_claiminv"));
				bill.setTt_xprcmstro_claimamt(om.getBigDecimal("tt_xpyhddeto_claimamt"));
				bill.setTt_xprcmstro_xprcmstroid(om.getString("tt_xpyhddeto_voucher"));
				bill.setTt_xprcmstro_xprcmstroid(om.getString("tt_xpyhddeto_xprcmstroid"));
			
				billList.add(bill);

				int i = 1;
				for (ProDataObject o : proDataObjectList) {
					BillDetail pod = new BillDetail();
					pod.setTt_xpyhddeto_seq(i);
					pod.setTt_xpyhddeto_voucher(o.getString("tt_xpyhddeto_voucher"));
					pod.setTt_xpyhddeto_partnbr(o.getString("tt_xpyhddeto_partnbr"));
					pod.setTt_xpyhddeto_receiver(o.getString("tt_xpyhddeto_receiver"));
					pod.setTt_xpyhddeto_poprice(o.getBigDecimal("tt_xpyhddeto_poprice"));
					pod.setTt_xpyhddeto_uom(o.getString("tt_xpyhddeto_uom"));
					pod.setTt_xpyhddeto_invprice(o.getBigDecimal("tt_xpyhddeto_invprice"));
					pod.setTt_xpyhddeto_invamt(o.getBigDecimal("tt_xpyhddeto_invamt"));
					pod.setTt_xpyhddeto_partdesc(o.getString("tt_xpyhddeto_partdesc"));
					pod.setTt_xpyhddeto_rcdate(o.getString("tt_xpyhddeto_rcdate"));
					
					billDetailList.add(pod);


				}
				billList.add(billDetailList);
			}

			return billList;
		}
		
		
//		public  String getBillStatus(String status)
//		{
//		
//			
//		
//			
//		}

	
}
