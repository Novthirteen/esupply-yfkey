package com.yfkey.webapp.action;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.progress.open4gl.Parameter;
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.exception.BillConfirmNotValidException;
import com.yfkey.exception.PrintBarcodeNotValidException;
import com.yfkey.exception.QadException;
import com.yfkey.model.Barcode;
import com.yfkey.model.Bill;
import com.yfkey.model.Gender;
import com.yfkey.model.LabelValue;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.webapp.util.PrintBarcodeUtil;
import com.yfkey.webapp.util.PrintPurchaseOrderUtil;
import com.yfkey.webapp.util.QADUtil;

/**
 * Action for facilitating Role Management feature.
 */
public class BarcodeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8920999609104602879L;

	private List<PurchaseOrderDetail> purchaseOrderDetails;
	private PurchaseOrderDetail purchaseOrderDetail;
	private Barcode barcode;

	private InputStream inputStream;
	private String fileName;

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public Barcode getBarcode() {
		return barcode;
	}

	public void setBarcode(Barcode barcode) {
		this.barcode = barcode;
	}

	/**
	 * Fetch all purchaseOrders from database and put into local
	 * "purchaseOrders" variable for retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		if (purchaseOrderDetail == null) {
			purchaseOrderDetail = new PurchaseOrderDetail();

			// 没条件显示空
			purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();
			return SUCCESS;
		}

		if (purchaseOrderDetail.getTt_xpyhddeto_shipto() != null
				&& !purchaseOrderDetail.getTt_xpyhddeto_shipto().equals("")) {
			String shipto = purchaseOrderDetail.getTt_xpyhddeto_shipto();
			if (shipto.contains("(")) {
				purchaseOrderDetail.setTt_xpyhddeto_shipto(shipto.substring(0, shipto.indexOf("(")));
			}
		}
		if (purchaseOrderDetail.getTt_xpyhddeto_partnbr() != null
				&& !purchaseOrderDetail.getTt_xpyhddeto_partnbr().equals("")) {
			String item = purchaseOrderDetail.getTt_xpyhddeto_partnbr();

			if (item.contains("(")) {
				purchaseOrderDetail.setTt_xpyhddeto_partnbr(item.substring(0, item.indexOf("(")));
			}
		}
		if (purchaseOrderDetail.getTt_xpyhddeto_suppcode() != null
				&& !purchaseOrderDetail.getTt_xpyhddeto_suppcode().equals("")) {
			String suppcode = purchaseOrderDetail.getTt_xpyhddeto_suppcode();

			if (suppcode.contains("(")) {
				purchaseOrderDetail.setTt_xpyhddeto_suppcode(suppcode.substring(0, suppcode.indexOf("(")));
			}
		}

		query();
		return SUCCESS;
	}

	public String list2() {

		if (barcode == null) {
			List<String> supplierCodeList = getSupplierCodeList("");
			barcode = new Barcode();
			if (supplierCodeList != null && supplierCodeList.size() > 0) {
				barcode.setTt_bcdeto_suppcode(supplierCodeList.get(0));
			}
		}
		return SUCCESS;
	}

	private void query() {

		// purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();
		//
		// PurchaseOrderDetail podet = new PurchaseOrderDetail();
		// podet.setTt_xpyhddeto_seq(10);
		// podet.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet.setTt_xpyhddeto_partnbr("1000001");
		// podet.setTt_xpyhddeto_partdesc("螺丝");
		// podet.setTt_xpyhddeto_spq(new BigDecimal(100));
		// podet.setTt_xpyhddeto_uom("件");
		// podet.setTt_xpyhddeto_innnerqty(new BigDecimal(100));
		// podet.setTt_xpyhddeto_externalqty(new BigDecimal(200));
		// podet.setTt_xpyhddeto_pktype("纸箱");
		// podet.setTt_xpyhddeto_qty("200");
		// podet.setTt_xpyhddeto_lots("SP170719");
		// purchaseOrderDetails.add(podet);
		//
		// PurchaseOrderDetail podet1 = new PurchaseOrderDetail();
		// podet1.setTt_xpyhddeto_seq(20);
		// podet1.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet1.setTt_xpyhddeto_partnbr("1000002");
		// podet1.setTt_xpyhddeto_partdesc("螺母");
		// podet1.setTt_xpyhddeto_spq(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_uom("件");
		// podet1.setTt_xpyhddeto_innnerqty(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_externalqty(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_pktype("纸箱");
		// podet1.setTt_xpyhddeto_qty("200");
		// podet1.setTt_xpyhddeto_lots("SP170719");
		// purchaseOrderDetails.add(podet1);

		if (ConnectQAD()) {

			String userCode = this.getRequest().getRemoteUser();
			@SuppressWarnings("unchecked")
			List<String> supplierCodeList = getSupplierCodeList(
					purchaseOrderDetail != null ? purchaseOrderDetail.getTt_xpyhddeto_suppcode() : "");

			String domain = getCurrentDomain();

			ProDataGraph exDataGraph; // 输入参数
			ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
			try {

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xpyhddet_DSMetaData1());
				for (int i = 0; i < supplierCodeList.size(); i++) {
					ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
					String supCode = supplierCodeList.get(i);
					object.setString(0, domain);
					object.setString(1, supCode);

					exDataGraph.addProDataObject(object);
				}

				ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xpyhddet_in");
				if (purchaseOrderDetail != null) {
					objectMstr.setString(0, purchaseOrderDetail.getTt_xpyhddeto_yhdnbr() == null ? ""
							: purchaseOrderDetail.getTt_xpyhddeto_yhdnbr().trim());
					objectMstr.setString(1, purchaseOrderDetail.getTt_xpyhddeto_shipto() == null ? ""
							: purchaseOrderDetail.getTt_xpyhddeto_shipto().trim());
					objectMstr.setString(2, purchaseOrderDetail.getTt_xpyhddeto_partnbr() == null ? ""
							: purchaseOrderDetail.getTt_xpyhddeto_partnbr().trim());
					objectMstr.setString(3, purchaseOrderDetail.getTt_xpyhddeto_supppart() == null ? ""
							: purchaseOrderDetail.getTt_xpyhddeto_supppart().trim());
					objectMstr.setString(4, purchaseOrderDetail.getTt_xpyhddeto_asn() == null ? ""
							: purchaseOrderDetail.getTt_xpyhddeto_asn().trim());
				}

				exDataGraph.addProDataObject(objectMstr);

				yfkssScp.xxinquiry_xpyhddet(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xpyhddet_out");

				purchaseOrderDetails = QADUtil.ConvertToBarcodePurchaseOrderDetail(outDataList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public String print() {
		try {

			checkPrintBarcode(purchaseOrderDetails);
			if (ConnectQAD()) {

				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						purchaseOrderDetail != null ? purchaseOrderDetail.getTt_xpyhddeto_suppcode() : "");

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxprint_barcode_DSMetaData1());
				for (int i = 0; i < supplierCodeList.size(); i++) {
					ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
					String supCode = supplierCodeList.get(i);
					object.setString(0, domain);
					object.setString(1, supCode);

					exDataGraph.addProDataObject(object);
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
				String currDate = df.format(new Date());

				if (purchaseOrderDetails != null) {
					for (PurchaseOrderDetail pod : purchaseOrderDetails) {

						if (pod != null && pod.getTt_xpyhddeto_lots() != null && pod.getTt_xpyhddeto_lots() != ""
								&& pod.getTt_xpyhddeto_qty() != null && !pod.getTt_xpyhddeto_qty().equals("0")) {

							ProDataObject objectMstr = exDataGraph.createProDataObject("tt_bcdet_in");
							objectMstr.setString(0, pod.getTt_xpyhddeto_partnbr());
							objectMstr.setString(1, pod.getTt_xpyhddeto_lots());
							objectMstr.setString(2, pod.getTt_xpyhddeto_vend_lots());
							objectMstr.setBigDecimal(3, new BigDecimal(pod.getTt_xpyhddeto_qty()));
							objectMstr.setString(4, currDate);
							// objectMstr.setString("tt_bcdeti_domain",
							// value);
							objectMstr.setString(5, pod.getTt_xpyhddeto_xpyhddetoid());
							objectMstr.setString(6, purchaseOrderDetail.getIsexternal());

							exDataGraph.addProDataObject(objectMstr);
						}

					}
				}

				yfkssScp.xxprint_barcode(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> errotOutDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_err_out");
				if (errotOutDataList != null && errotOutDataList.size() > 0) {
					throw new QadException(getQadErrorMessage(errotOutDataList));
				}

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_bcdet_out");

				List<Barcode> barcodeList = QADUtil.ConvertToBarcode(outDataList);

				// printBarcode(barcodeList);

				String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");
				inputStream = PrintBarcodeUtil.printBarcode(localAbsolutPath, barcodeList, userCode);

				fileName = "barcode.pdf";

			}
		} catch (QadException ex) {
			addActionError(ex.getMessage());
			list();
			return INPUT;
		} catch (PrintBarcodeNotValidException ex) {
			addActionError(ex.getMessage());
			list();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}

		return SUCCESS;
	}

	public String printAll() {
		try {

			checkPrintAllBarcode(purchaseOrderDetails);
			if (ConnectQAD()) {

				// 重新按条件查一遍
				// query();

				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						purchaseOrderDetail != null ? purchaseOrderDetail.getTt_xpyhddeto_suppcode() : "");

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxprint_barcode_DSMetaData1());
				for (int i = 0; i < supplierCodeList.size(); i++) {
					ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
					String supCode = supplierCodeList.get(i);
					object.setString(0, domain);
					object.setString(1, supCode);

					exDataGraph.addProDataObject(object);
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
				String currDate = df.format(new Date());

				if (purchaseOrderDetails != null) {
					for (PurchaseOrderDetail pod : purchaseOrderDetails) {

						if (pod != null && pod.getTt_xpyhddeto_lots() != null && pod.getTt_xpyhddeto_lots() != ""
								&& pod.getTt_xpyhddeto_qty() != null && !pod.getTt_xpyhddeto_qty().equals("0")) {

							ProDataObject objectMstr = exDataGraph.createProDataObject("tt_bcdet_in");
							objectMstr.setString(0, pod.getTt_xpyhddeto_partnbr());
							objectMstr.setString(1, pod.getTt_xpyhddeto_lots());
							objectMstr.setString(2, pod.getTt_xpyhddeto_vend_lots());
							objectMstr.setBigDecimal(3, new BigDecimal(pod.getTt_xpyhddeto_qty()));
							objectMstr.setString(4, currDate);
							// objectMstr.setString("tt_bcdeti_domain",
							// value);
							objectMstr.setString(5, pod.getTt_xpyhddeto_xpyhddetoid());
							objectMstr.setString(6, purchaseOrderDetail.getIsexternal());

							exDataGraph.addProDataObject(objectMstr);
						}

					}
				}

				yfkssScp.xxprint_barcode(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> errotOutDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_err_out");
				if (errotOutDataList != null && errotOutDataList.size() > 0) {
					throw new QadException(getQadErrorMessage(errotOutDataList));
				}

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_bcdet_out");

				List<Barcode> barcodeList = QADUtil.ConvertToBarcode(outDataList);

				// printBarcode(barcodeList);

				String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");
				inputStream = PrintBarcodeUtil.printBarcode(localAbsolutPath, barcodeList, userCode);

				fileName = "barcode.pdf";

			}
		} catch (QadException ex) {
			addActionError(ex.getMessage());
			list();
			return INPUT;
		} catch (PrintBarcodeNotValidException ex) {
			addActionError(ex.getMessage());
			list();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}

		return SUCCESS;
	}

	public String printByItem() {
		try {

			checkPrintBarcode(barcode);
			if (ConnectQAD()) {

				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						barcode != null ? barcode.getTt_bcdeto_suppcode() : "");

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxprint_barcode2_DSMetaData1());
				for (int i = 0; i < supplierCodeList.size(); i++) {
					ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
					String supCode = supplierCodeList.get(i);
					object.setString(0, domain);
					object.setString(1, supCode);

					exDataGraph.addProDataObject(object);
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
				String currDate = df.format(new Date());

				if (barcode != null) {

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_bcdet_in");
					objectMstr.setString(0, barcode.getTt_bcdeto_partnbr());
					objectMstr.setString(1, barcode.getTt_bcdeto_lots());
					objectMstr.setString(2, barcode.getTt_bcdeto_vend_lots());
					objectMstr.setBigDecimal(3, new BigDecimal(barcode.getPrintQty()));
					objectMstr.setString(4, currDate);
					// objectMstr.setString("tt_bcdeti_domain",
					// value);
					objectMstr.setString(5, "");
					objectMstr.setString(6, barcode.getIsexternal());

					exDataGraph.addProDataObject(objectMstr);

				}

				yfkssScp.xxprint_barcode2(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> errotOutDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_err_out");
				if (errotOutDataList != null && errotOutDataList.size() > 0) {
					throw new QadException(getQadErrorMessage(errotOutDataList));
				}

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_bcdet_out");

				List<Barcode> barcodeList = QADUtil.ConvertToBarcode(outDataList);

				// printBarcode(barcodeList);

				if (barcodeList == null || barcodeList.size() == 0) {

					throw new PrintBarcodeNotValidException(getText("barcode.qty_all_empty"));
				}

				String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");
				inputStream = PrintBarcodeUtil.printBarcode(localAbsolutPath, barcodeList, userCode);

				fileName = "barcode.pdf";

			}
		} catch (QadException ex) {
			addActionError(ex.getMessage());

			return INPUT;
		} catch (PrintBarcodeNotValidException ex) {
			addActionError(ex.getMessage());

			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}

		return SUCCESS;
	}

	public List<LabelValue> getPackageList() {
		List<LabelValue> packageList = new ArrayList<LabelValue>();
		packageList.add(new LabelValue("0", getText("package.inner")));
		packageList.add(new LabelValue("1", getText("package.external")));

		return packageList;
	}

	private void checkPrintBarcode(List<PurchaseOrderDetail> purchaseOrderDetails)
			throws PrintBarcodeNotValidException {

		List<Object> args = new ArrayList<Object>();
		Boolean allZero = true;
		if (purchaseOrderDetails != null && purchaseOrderDetails.size() > 0) {
			for (PurchaseOrderDetail d : purchaseOrderDetails) {
				try {
					if (d != null) {
						Integer qty = Integer.parseInt(d.getTt_xpyhddeto_qty());

						if (qty instanceof Integer == false) {
							args.add(qty);
							throw new PrintBarcodeNotValidException(getText("barcode.qty_format_error", args));
						}
						if (qty < 0) {

							args.add(d.getTt_xpyhddeto_partnbr());
							throw new PrintBarcodeNotValidException(getText("barcode.qty_less_than_zero", args));
						}

						if (qty > d.getTt_xpyhddeto_oldQty()) {
							args.add(qty);
							args.add(d.getTt_xpyhddeto_oldQty());
							throw new PrintBarcodeNotValidException(getText("barcode.oldqty_less_than_Qty", args));
						}
						if (qty > 0 && allZero) {
							allZero = false;
						}
					}
				} catch (NumberFormatException e) {
					args.add(d.getTt_xpyhddeto_qty());
					throw new PrintBarcodeNotValidException(getText("barcode.qty_format_error", args));
				}

			}

			if (allZero) {
				throw new PrintBarcodeNotValidException(getText("barcode.qty_all_empty"));
			}
		}
	}

	@SuppressWarnings("unused")
	private void checkPrintBarcode(Barcode barcode) throws PrintBarcodeNotValidException {

		try {
			if (barcode != null) {

				if (barcode.getTt_bcdeto_suppcode() == null || barcode.getTt_bcdeto_suppcode().equals("")) {
					throw new PrintBarcodeNotValidException(getText("barcode.suppcode_empty"));
				} else {

					String suppcode = barcode.getTt_bcdeto_suppcode();
					if (suppcode.contains("(")) {
						barcode.setTt_bcdeto_suppcode(suppcode.substring(0, suppcode.indexOf("(")));
					}
				}
				if (barcode.getTt_bcdeto_partnbr() == null || barcode.getTt_bcdeto_partnbr().equals("")) {
					throw new PrintBarcodeNotValidException(getText("barcode.partnbr_empty"));
				} else {
					String partnbr = barcode.getTt_bcdeto_partnbr();
					if (partnbr.contains("(")) {
						barcode.setTt_bcdeto_partnbr(partnbr.substring(0, partnbr.indexOf("(")));
					}
				}

				if (barcode.getTt_bcdeto_lots() == null || barcode.getTt_bcdeto_lots().equals("")) {
					throw new PrintBarcodeNotValidException(getText("barcode.lots_empty"));
				}

				if (barcode.getPrintQty() == null || barcode.getPrintQty().equals("")) {
					throw new PrintBarcodeNotValidException(getText("barcode.qty_empty"));
				}
				BigDecimal qty = new BigDecimal(barcode.getPrintQty());

				if (qty instanceof BigDecimal == false) {

					throw new PrintBarcodeNotValidException(getText("barcode2.qty_format_error"));
				}
				if (qty.compareTo(BigDecimal.ZERO) < 1) {

					throw new PrintBarcodeNotValidException(getText("barcode2.qty_less_than_zero"));
				}

			}
		} catch (NumberFormatException e) {

			throw new PrintBarcodeNotValidException(getText("barcode2.qty_format_error"));
		}

	}

	private void checkPrintAllBarcode(List<PurchaseOrderDetail> purchaseOrderDetails)
			throws PrintBarcodeNotValidException {

		List<Object> args = new ArrayList<Object>();
		Boolean allZero = true;
		if (purchaseOrderDetails != null && purchaseOrderDetails.size() > 0) {
			for (PurchaseOrderDetail d : purchaseOrderDetails) {
				if (d != null) {
					allZero = false;
					break;
				}
			}
		}
		if (allZero) {
			throw new PrintBarcodeNotValidException(getText("barcode.qty_all_empty"));
		}
	}

}
