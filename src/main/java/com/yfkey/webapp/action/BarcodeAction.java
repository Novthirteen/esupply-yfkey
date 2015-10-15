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
import com.yfkey.model.Barcode;
import com.yfkey.model.Gender;
import com.yfkey.model.LabelValue;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrderDetail;
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

	/**
	 * Fetch all purchaseOrders from database and put into local
	 * "purchaseOrders" variable for retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		query();
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
					objectMstr.setString(0, purchaseOrderDetail.getTt_xpyhddeto_yhdnbr());
					objectMstr.setString(1, purchaseOrderDetail.getTt_xpyhddeto_shipto());
					objectMstr.setString(2, purchaseOrderDetail.getTt_xpyhddeto_partnbr());
					objectMstr.setString(3, purchaseOrderDetail.getTt_xpyhddeto_suppcode());
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

		// purchaseOrderDetails.size();
		// List<Barcode> barcodeList = new ArrayList<Barcode>();
		// Barcode bc = new Barcode();
		// bc.setTt_bcdeto_bcnon("47000009320250F427100025");
		// bc.setTt_bcdeto_serial("47000009320250F427100025");
		// bc.setTt_bcdeto_partnbr("100001");
		// bc.setTt_bcdeto_lots("AC12");
		// bc.setTt_bcdeto_qty(new BigDecimal(100));
		// bc.setTt_bcdeto_partdesc("螺丝");
		// barcodeList.add(bc);
		//
		// Barcode bc1 = new Barcode();
		// bc1.setTt_bcdeto_bcnon("47000009320250F427100026");
		// bc1.setTt_bcdeto_serial("47000009320250F427100026");
		// bc1.setTt_bcdeto_partnbr("100002");
		// bc1.setTt_bcdeto_lots("AC12");
		// bc1.setTt_bcdeto_qty(new BigDecimal(200));
		// bc1.setTt_bcdeto_partdesc("螺母");
		// barcodeList.add(bc1);
		//
		// try {
		// printBarcode(barcodeList);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		if (ConnectQAD()) {

			String userCode = this.getRequest().getRemoteUser();
			@SuppressWarnings("unchecked")
			List<String> supplierCodeList = getSupplierCodeList(
					purchaseOrderDetail != null ? purchaseOrderDetail.getTt_xpyhddeto_suppcode() : "");

			String domain = getCurrentDomain();
			ProDataGraph exDataGraph; // 输入参数
			ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
			try {
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

						if (pod.getTt_xpyhddeto_lots() != null && pod.getTt_xpyhddeto_lots() != ""
								&& pod.getTt_xpyhddeto_qty() != null
								&& !pod.getTt_xpyhddeto_qty().equals(BigDecimal.ZERO)) {

							ProDataObject objectMstr = exDataGraph.createProDataObject("tt_bcdet_in");
							objectMstr.setString(0, pod.getTt_xpyhddeto_partnbr());
							objectMstr.setString(1, pod.getTt_xpyhddeto_lots());
							objectMstr.setBigDecimal(2, pod.getTt_xpyhddeto_qty());
							objectMstr.setString(3, currDate);
							// objectMstr.setString("tt_bcdeti_domain",
							// value);
							objectMstr.setString(4, pod.getTt_xpyhddeto_xpyhddetoid());
							objectMstr.setString(5, purchaseOrderDetail.getIsexternal());

							exDataGraph.addProDataObject(objectMstr);
						}

					}
				}

				yfkssScp.xxprint_barcode(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_bcdet_out");

				List<Barcode> barcodeList = QADUtil.ConvertToBarcode(outDataList);

				printBarcode(barcodeList);

			} catch (Exception e) {
				// catch
			}
		}
		return SUCCESS;
	}

	public void printBarcode(List<Barcode> barcodeList) throws Exception {

		String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");
		Rectangle pagesize = new Rectangle(226.771653f, 170.078740f);
		Document document = new Document(pagesize, 2f, 5f, 10f, 1f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			// step 2
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			// step 3
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			int i = 0;

			for (Barcode barcode : barcodeList) {
				if (i != 0) {
					document.newPage();
				}
				BaseFont baseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
				// Font font = FontFactory.getFont("Times-Roman");
				Barcode128 code128 = new Barcode128();
				code128.setCode(barcode.getTt_bcdeto_bcinfo1());
				// code128.setX(0.75f);
				// code128.setN(1.5f);
				code128.setSize(0.0001f);
				code128.setTextAlignment(Element.ALIGN_LEFT);
				// code128.setBaseline(1);
				// code128.setBarHeight(26f);
				Image img = code128.createImageWithBarcode(cb, null, null);
				cb.addImage(img, 150, 0, 0, 35, 50, 120);
				cb.stroke();
				// document.add(img);
				
				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
			    cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_bcnon(), 80, 120, 0);
				cb.endText();
				
				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PART NO.", 10, 110, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_partnbr(), 35, 100, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "LOT/SERIAL NO.", 10, 90, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_lots(), 35, 80, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "QUANTITY", 145, 90, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(barcode.getTt_bcdeto_qty()), 145, 80, 0);
				cb.endText();

				// QRCODE
				if (barcode.getTt_bcdeto_bcinfo2() != null && !barcode.getTt_bcdeto_bcinfo2().trim().equals("")) {
					BarcodeQRCode qrcode = new BarcodeQRCode(barcode.getTt_bcdeto_bcinfo2(), 1, 1, null);
					Image img1 = qrcode.getImage();
					cb.addImage(img1, 40, 0, 0, 40, 140, 50);
					cb.stroke();
				}

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "DESCRIPTION ", 10, 70, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_partdesc(), 35, 60, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUPPLIER ", 10, 50, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
						barcode.getTt_bcdeto_suppname() == null ? "" : barcode.getTt_bcdeto_suppname(), 35, 40, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PRINTED DATE: " + barcode.getTt_bcdeto_date(), 10, 10,
						0);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PRINTED USER: " + this.getRequest().getRemoteUser(), 110,
						10, 0);
				cb.endText();

				i++;
			}

		} catch (Exception e) {
			// catch
		} finally {
			document.close();
			HttpServletResponse response = this.getResponse();
			ServletOutputStream outputStream = response.getOutputStream();
			baos.writeTo(outputStream);
			response.setHeader("Content-Disposition", "attachment; filename=\"barcode.pdf\"");
			response.setContentType("application/pdf");
			outputStream.flush();
			outputStream.close();
		}

	}
	
	public List<LabelValue> getPackageList() {
		List<LabelValue> packageList = new ArrayList<LabelValue>();
		packageList.add(new LabelValue("0", getText("package.inner")));
		packageList.add(new LabelValue("1", getText("package.external")));

		return packageList;
	}

}
