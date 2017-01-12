package com.yfkey.webapp.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.yfkey.model.Invoice;
import com.yfkey.model.LabelValue;
import com.yfkey.model.Payment;
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
				po.setTt_xpyhmstro_recepttm(o.getString("tt_xpyhmstro_recepttm"));

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
				i++;
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
			po.setTt_xpyhmstro_recepttm(poDataObject.getString("tt_xpyhddeto_recepttm"));
			po.setTt_xpyhmstro_receptdt(poDataObject.getString("tt_xpyhddeto_receptdt"));
			po.setTt_xpyhmstro_suppcode(poDataObject.getString("tt_xpyhddeto_suppcode"));
			po.setTt_xpyhmstro_suppname(poDataObject.getString("tt_xpyhddeto_suppname"));
			po.setTt_xpyhmstro_currcy(poDataObject.getString("tt_xpyhddeto_currcy"));
			po.setTt_xpyhmstro_shipto(poDataObject.getString("tt_xpyhddeto_shipto"));
			po.setTt_xpyhmstro_stat(poDataObject.getString("tt_xpyhddeto_stat"));
			po.setRemark(poDataObject.getString("tt_xpyhddeto_remark"));
			po.setTt_xpyhmstro_xpyhmstroid(poDataObject.getString("tt_xpyhddeto_xpyhmstroid"));
			po.setTt_xpyhmstro_recepttm(poDataObject.getString("tt_xpyhddeto_recepttm"));
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
				i++;
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
				pod.setTt_xpyhddeto_qty(String.valueOf(o.getBigDecimal("tt_xpyhddeto_qty")));
				pod.setTt_xpyhddeto_suppcode(o.getString("tt_xpyhddeto_suppcode"));
				pod.setTt_xpyhddeto_xpyhddetoid(o.getString("tt_xpyhddeto_xpyhddetoid"));

				purchaseOrderDetailList.add(pod);
				i++;

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
				i++;
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
				pod.setTt_xpyhddeto_delvqty(String.valueOf(o.getBigDecimal("tt_xpyhddeto_delvqty")));
				pod.setTt_xpyhddeto_openqty(o.getBigDecimal("tt_xpyhddeto_openqty"));
				pod.setTt_xpyhddeto_xpyhmstroid(o.getString("tt_xpyhddeto_xpyhmstroid"));
				pod.setTt_xpyhddeto_xpyhddetoid(o.getString("tt_xpyhddeto_xpyhddetoid"));

				purchaseOrderDetailList.add(pod);
				i++;
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

			asn.setTt_xasndeto_vendname(om.getString("tt_xasndeto_vendname"));
			asn.setTt_xasndeto_vendaddr(om.getString("tt_xasndeto_vendaddr"));
			asn.setTt_xasndeto_vendcontact(om.getString("tt_xasndeto_vendcontact"));
			asn.setTt_xasndeto_vendtax(om.getString("tt_xasndeto_vendtax"));
			asn.setTt_xasndeto_shipname(om.getString("tt_xasndeto_shipname"));
			asn.setTt_xasndeto_shipaddr(om.getString("tt_xasndeto_shipaddr"));

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
				i++;

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
				i++;
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

			receipt.setTt_prhdeto_vendname(om.getString("tt_prhdeto_vendname"));
			receipt.setTt_prhdeto_shipaddr(om.getString("tt_prhdeto_shipaddr"));
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
				i++;
			}
			receiptList.add(receiptDetailList);
		}

		return receiptList;

	}

	// bill mstr
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

	// bill det
	public static List<Object> ConvertToBillAndDetail(List<ProDataObject> proDataObjectList) throws ParseException {
		Bill bill = new Bill();
		List<BillDetail> billDetailList = new ArrayList<BillDetail>();
		List<Object> billList = new ArrayList<Object>();

		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			ProDataObject om = proDataObjectList.get(0);

			bill.setTt_xprcmstro_voucher(om.getString("tt_xpyhddeto_voucher"));
			bill.setTt_xprcmstro_suppcode(om.getString("tt_xpyhddeto_suppcode"));
			bill.setTt_xprcmstro_type("0");
			bill.setTt_xprcmstro_totalamt(om.getBigDecimal("tt_xpyhddeto_totalamt"));
			bill.setTt_xprcmstro_stat(om.getString("tt_xpyhddeto_stat"));

			bill.setTt_xprcmstro_qty(String.valueOf(om.getInt("tt_xpyhddeto_qty")));
			bill.setTt_xprcmstro_taxamt(String.valueOf(om.getBigDecimal("tt_xpyhddeto_taxamt")));
			bill.setTt_xprcmstro_notaxamt(String.valueOf(om.getBigDecimal("tt_xpyhddeto_notaxamt")));
			bill.setTt_xprcmstro_invnbr(om.getString("tt_xpyhddeto_invnbr"));
			bill.setTt_xprcmstro_rmk(om.getString("tt_xpyhddeto_rmk"));
			bill.setTt_xprcmstro_claiminv(om.getString("tt_xpyhddeto_claiminv"));
			bill.setTt_xprcmstro_claimamt(om.getBigDecimal("tt_xpyhddeto_claimamt"));
			bill.setTt_xprcmstro_xprcmstroid(om.getString("tt_xpyhddeto_xprcmstroid"));
			bill.setTt_xprcmstro_indexinvnbr(om.getString("tt_xpyhddeto_indexinvnbr"));
			bill.setTt_xpyhddeto_disamt(String.valueOf(om.getBigDecimal("tt_xpyhddeto_disamt")));

			bill.setTt_xpyhddeto_spname(om.getString("tt_xpyhddeto_spname"));

			BigDecimal notaxamt = om.getBigDecimal("tt_xpyhddeto_notaxamt");
			BigDecimal taxamt = om.getBigDecimal("tt_xpyhddeto_taxamt");

			BigDecimal invoiceAmount = notaxamt.add(taxamt);
			bill.setTt_xpyhddeto_invoiceamt(String.valueOf(invoiceAmount));
			// bill.setTt_xprcmstro_type("0"); //后面要加字段

			// 日期转一下格式,现在存到创建日期，发票日期给供应商维护
			// SimpleDateFormat sdf=new
			// SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			// String dstr=om.getString("tt_xpyhddeto_invdate");
			// if(dstr != null)
			// {
			// java.util.Date invDate=sdf.parse(dstr);
			//
			// SimpleDateFormat sdft=new SimpleDateFormat("yyyyMMdd");
			// String invDateStr=sdft.format(invDate);
			// bill.setTt_xprcmstro_invdate(invDateStr);
			// }

			bill.setTt_xprcmstro_invdate(om.getString("tt_xpyhddeto_invdate"));

			billList.add(bill);

			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				BillDetail bd = new BillDetail();
				bd.setTt_xpyhddeto_seq(i);
				bd.setTt_xpyhddeto_voucher(o.getString("tt_xpyhddeto_voucher"));
				bd.setTt_xpyhddeto_partnbr(o.getString("tt_xpyhddeto_partnbr"));
				bd.setTt_xpyhddeto_receiver(o.getString("tt_xpyhddeto_receiver"));
				bd.setTt_xpyhddeto_poprice(o.getBigDecimal("tt_xpyhddeto_poprice"));
				bd.setTt_xpyhddeto_uom(o.getString("tt_xpyhddeto_uom"));
				bd.setTt_xpyhddeto_invprice(o.getBigDecimal("tt_xpyhddeto_invprice"));
				bd.setTt_xpyhddeto_invamt(o.getBigDecimal("tt_xpyhddeto_invamt"));
				bd.setTt_xpyhddeto_partdesc(o.getString("tt_xpyhddeto_partdesc"));
				bd.setTt_xpyhddeto_rcdate(o.getString("tt_xpyhddeto_rcdate"));
				bd.setTt_xpyhddeto_rcqty(o.getBigDecimal("tt_xpyhddeto_rcqty"));
				bd.setTt_xpyhddeto_suppcode(o.getString("tt_xpyhddeto_suppcode"));

				bd.setTt_xpyhddeto_ponbr(o.getString("tt_xpyhddeto_ponbr"));
				bd.setTt_xpyhddeto_asn(o.getString("tt_xpyhddeto_asn"));
				billDetailList.add(bd);
				i++;

			}
			billList.add(billDetailList);
		}

		return billList;
	}

	// 预测
	public static List<PurchaseOrderDetail> ConvertToForecastPurchaseOrderDetail(
			List<ProDataObject> proDataObjectList) {
		List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setTt_xpyhddeto_seq(i);
				pod.setTt_xpyhddeto_suppcode(o.getString("tt_forecast_suppcode"));
				pod.setTt_xpyhddeto_shipto(o.getString("tt_forecast_shipto"));
				pod.setTt_xpyhddeto_partnbr(o.getString("tt_forecast_partnbr"));
				pod.setTt_xpyhddeto_partdesc(o.getString("tt_forecast_partdesc"));
				pod.setTt_xpyhddeto_supppart(o.getString("tt_forecast_supppart"));
				pod.setTt_xpyhddeto_receptdt(o.getString("tt_forecast_reqdt"));
				pod.setTt_xpyhddeto_currcy(o.getString("tt_forecast_currcy"));
				pod.setTt_xpyhddeto_uom(o.getString("tt_forecast_uom"));
				pod.setTt_xpyhddeto_innnerqty(o.getBigDecimal("tt_forecast_inerpk"));
				pod.setTt_xpyhddeto_externalqty(o.getBigDecimal("tt_forecast_extpk"));
				pod.setTt_forecast_fcastqty(o.getBigDecimal("tt_forecast_fcastqty"));

				purchaseOrderDetailList.add(pod);
				i++;

			}
		}
		return purchaseOrderDetailList;

	}

	// claim billdet
	public static List<Object> ConvertToClaimBillAndDetail(List<ProDataObject> proDataObjectList)
			throws ParseException {
		Bill bill = new Bill();
		List<BillDetail> billDetailList = new ArrayList<BillDetail>();
		List<Object> billList = new ArrayList<Object>();

		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			ProDataObject om = proDataObjectList.get(0);

			bill.setTt_xprcmstro_voucher(om.getString("tt_claimdeto_voucher"));
			bill.setTt_xprcmstro_suppcode(om.getString("tt_claimdeto_suppcode"));
			bill.setTt_xprcmstro_totalamt(om.getBigDecimal("tt_claimdeto_totalamt"));
			bill.setTt_xprcmstro_stat(om.getString("tt_claimdeto_stat"));
			bill.setTt_xprcmstro_xprcmstroid(om.getString("tt_claimdeto_xprcmstroid"));

			bill.setTt_claimdeto_billno(om.getString("tt_claimdeto_billno"));
			bill.setTt_xprcmstro_type("1");

			// 日期转一下格式,现在存到创建日期，发票日期给供应商维护
			// SimpleDateFormat sdf=new
			// SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			// String dstr=om.getString("tt_claimdeto_invdate");
			// if(dstr != null)
			// {
			// java.util.Date invDate=sdf.parse(dstr);
			//
			// SimpleDateFormat sdft=new SimpleDateFormat("yyyyMMdd");
			// String invDateStr=sdft.format(invDate);
			// bill.setTt_xprcmstro_invdate(invDateStr);
			// }

			bill.setTt_xprcmstro_invdate(om.getString("tt_claimdeto_invdate"));

			billList.add(bill);

			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				BillDetail bd = new BillDetail();
				bd.setTt_xpyhddeto_seq(i);
				bd.setTt_xpyhddeto_voucher(o.getString("tt_claimdeto_voucher"));
				bd.setTt_xpyhddeto_partnbr(o.getString("tt_claimdeto_partnbr"));
				bd.setTt_xpyhddeto_receiver(o.getString("tt_claimdeto_receiver"));
				bd.setTt_xpyhddeto_poprice(o.getBigDecimal("tt_claimdeto_poprice"));
				bd.setTt_xpyhddeto_uom(o.getString("tt_claimdeto_uom"));
				bd.setTt_xpyhddeto_invprice(o.getBigDecimal("tt_claimdeto_invprice"));
				bd.setTt_xpyhddeto_invamt(o.getBigDecimal("tt_claimdeto_invamt"));
				bd.setTt_xpyhddeto_partdesc(o.getString("tt_claimdeto_partdesc"));
				bd.setTt_xpyhddeto_rcdate(o.getString("tt_claimdeto_rcdate"));
				bd.setTt_xpyhddeto_rcqty(o.getBigDecimal("tt_claimdeto_rcqty"));
				bd.setTt_xpyhddeto_remark(o.getString("tt_claimdeto_rmk"));
				bd.setTt_xpyhddeto_suppcode(o.getString("tt_claimdeto_suppcode"));
				billDetailList.add(bd);
				i++;

			}
			billList.add(billDetailList);
		}

		return billList;
	}

	// invoice
	public static List<Invoice> ConvertToInvoice(List<ProDataObject> proDataObjectList) {
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				Invoice invoice = new Invoice();
				invoice.setTt_cinvoice_sp(o.getString("tt_cinvoiceout_sp"));
				invoice.setTt_cinvoice_invdate(o.getString("tt_cinvoiceout_invdate"));
				invoice.setTt_cinvoice_br(o.getString("tt_cinvoiceout_br"));
				invoice.setTt_cinvoice_rf(o.getString("tt_cinvoiceout_rf"));
				invoice.setTt_cinvoice_duedate(o.getString("tt_cinvoiceout_duedate"));
				invoice.setTt_cinvoice_tb(o.getBigDecimal("tt_cinvoiceout_tb"));
				invoice.setTt_cinvoice_curr(o.getString("tt_cinvoiceout_curr"));
				invoice.setTt_cinvoice_tbcr(o.getBigDecimal("tt_cinvoiceout_tbcr"));
				invoice.setTt_cinvoice_tbdr(o.getBigDecimal("tt_cinvoiceout_tbdr"));
				invoice.setTt_cinvoice_type(o.getString("tt_cinvoiceout_type"));
				invoice.setTt_cinvoice_hold(o.getBigDecimal("tt_cinvoiceout_hold"));
				invoice.setTt_cinvoice_brname(o.getString("tt_cinvoiceout_brname"));
				invoice.setTt_cinvoice_term(o.getString("tt_cinvoiceout_term"));
				invoice.setTt_cinvoice_id(o.getInt("tt_cinvoiceout_id"));
				invoice.setTt_cinvoice_desc(o.getString("tt_cinvoiceout_desc"));
				
				invoiceList.add(invoice);
				i++;

			}
		}
		return invoiceList;

	}

	// payment
	public static List<Payment> ConvertToPayment(List<ProDataObject> proDataObjectList) {
		List<Payment> paymentList = new ArrayList<Payment>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			int i = 1;
			for (ProDataObject o : proDataObjectList) {
				Payment payment = new Payment();
				payment.setTt_payment_payrf(o.getString("tt_paymentout_payrf"));
				payment.setTt_payment_rf(o.getString("tt_paymentout_rf"));
				payment.setTt_payment_date(o.getString("tt_paymentout_date"));
				payment.setTt_payment_orgTC(o.getBigDecimal("tt_paymentout_orgTC"));
				payment.setTt_payment_curr(o.getString("tt_paymentout_curr"));
				payment.setTt_payment_invno(o.getString("tt_paymentout_invno"));
				payment.setTt_payment_status(o.getString("tt_paymentout_status"));
				payment.setTt_payment_TC(o.getBigDecimal("tt_paymentout_TC"));
				payment.setTt_payment_openTC(o.getBigDecimal("tt_paymentout_openTC"));
				payment.setTt_payment_entity(o.getString("tt_paymentout_entity"));
				payment.setTt_payment_sp(o.getString("tt_paymentout_sp"));
				payment.setTt_payment_id(o.getInt("tt_paymentout_id"));
				payment.setTt_payment_type(o.getString("tt_paymentout_type"));
				
				paymentList.add(payment);
				i++;

			}
		}
		return paymentList;

	}

}
