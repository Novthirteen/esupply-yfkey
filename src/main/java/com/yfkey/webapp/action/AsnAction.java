package com.yfkey.webapp.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.progress.open4gl.Parameter;
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.webapp.util.QADUtil;
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;

/**
 * Action for facilitating Role Management feature.
 */
public class AsnAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7707143528903966154L;

	private List<Asn> asns;
	private static List<AsnDetail> asnDetails;
	private Asn asn;
	private String tt_xasnmstro_asnnbr;
	private InputStream inputStream;
	private String fileName;
	private String tt_xasnmstro_xasnmstroid;

	/**
	 * Holder for asns to display on list screen
	 *
	 * @return list of asns
	 */
	public List<Asn> getAsns() {
		return asns;
	}

	public List<AsnDetail> getAsnDetails() {
		return asnDetails;
	}

	public Asn getAsn() {
		return asn;
	}

	public void setAsn(Asn asn) {
		this.asn = asn;
	}

	public String getTt_xasnmstro_asnnbr() {
		return tt_xasnmstro_asnnbr;
	}

	public void setTt_xasnmstro_asnnbr(String tt_xasnmstro_asnnbr) {
		this.tt_xasnmstro_asnnbr = tt_xasnmstro_asnnbr;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}
	
	

	public String getTt_xasnmstro_xasnmstroid() {
		return tt_xasnmstro_xasnmstroid;
	}

	public void setTt_xasnmstro_xasnmstroid(String tt_xasnmstro_xasnmstroid) {
		this.tt_xasnmstro_xasnmstroid = tt_xasnmstro_xasnmstroid;
	}

	/**
	 * Grab the asn from the database based on the "asnName" passed in.
	 *
	 * @return success if asn found
	 * @throws IOException
	 *             can happen when sending a "forbidden" from
	 *             response.sendError()
	 */
	@SuppressWarnings("unchecked")
	public String edit() throws IOException {

		// try {
		// if (ConnectQAD()) {
		// String userCode = this.getRequest().getRemoteUser();
		//
		// String domain = "YFKSH";
		// ProDataGraph exDataGraph; // 输入参数
		// ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
		//
		// exDataGraph = new
		// ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xasnddet_DSMetaData1());
		//
		// ProDataObject object =
		// exDataGraph.createProDataObject("tt_xasnddet_in");
		//
		// object.setString(0, tt_xasnddeti_xasnmstroid);
		//
		// exDataGraph.addProDataObject(object);
		//
		// yfkssScp.xxview_xasnddet(exDataGraph, outputData);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return SUCCESS;

		// if a asnCode is passed in
		try {

			
			if (tt_xasnmstro_xasnmstroid != null) {

				asn = new Asn();
				asnDetails = new ArrayList<AsnDetail>();
				
				if (ConnectQAD()) {
					ProDataGraph exDataGraph; // 输入参数
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xasndet_DSMetaData1());

					ProDataObject object = exDataGraph.createProDataObject("tt_xasndet_in");

					object.setString(0, tt_xasnmstro_xasnmstroid);

					exDataGraph.addProDataObject(object);

					yfkssScp.xxview_xasndet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xasndet_out");

					List<Object> objList = QADUtil.ConvertToAsnAndDetail(outDataList);
					asn = (Asn) objList.get(0);
					asnDetails = (List<AsnDetail>) objList.get(1);
				}
			} else {
				asn = new Asn();
				asnDetails = new ArrayList<AsnDetail>();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * Fetch all asns from database and put into local "asns" variable for
	 * retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		query();
		return SUCCESS;
	}

	public String cancel() {
		return CANCEL;
	}

	private void query() {
		if (asn != null && asn.getIsDetail()) {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(asn != null ? asn.getTt_xasnmstro_suppcode() : "");

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {
					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxexport_xasndet_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xasndet_in");

					if (asn != null) {

						
						objectMstr.setString(0,
								asn.getTt_xasnmstro_asnnbr() == null ? "" : asn.getTt_xasnmstro_asnnbr());
						objectMstr.setString(1, asn.getTt_xasnmstro_stat() == null ? "" : asn.getTt_xasnmstro_stat());
						objectMstr.setString(2,
								asn.getTt_xasnmstri_fromdate() == null ? "" : asn.getTt_xasnmstri_fromdate());
						objectMstr.setString(3,
								asn.getTt_xasnmstri_todate() == null ? "" : asn.getTt_xasnmstri_todate());
						objectMstr.setString(4,
								asn.getTt_xasnmstro_shipto() == null ? "" : asn.getTt_xasnmstro_shipto());
						objectMstr.setString(5,
								asn.getTt_xasnmstri_yhdnbr() == null ? "" : asn.getTt_xasnmstri_yhdnbr());
						objectMstr.setString(6,
								asn.getTt_xasnmstri_partnbr() == null ? "" : asn.getTt_xasnmstri_partnbr());

					}

					exDataGraph.addProDataObject(objectMstr);
					yfkssScp.xxexport_xasndet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xasndet_out");

					asnDetails = QADUtil.ConverToAsnDetail(outDataList);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else {

			if (ConnectQAD()) {

				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(asn != null ? asn.getTt_xasnmstro_suppcode() : "");

				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinqury_xasnmstr_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xasnmstr_in");
					if (asn != null) {
						objectMstr.setString(0,
								asn.getTt_xasnmstro_asnnbr() == null ? "" : asn.getTt_xasnmstro_asnnbr());
						objectMstr.setString(1, asn.getTt_xasnmstro_stat() == null ? "" : asn.getTt_xasnmstro_stat());
						objectMstr.setString(2,
								asn.getTt_xasnmstri_fromdate() == null ? "" : asn.getTt_xasnmstri_fromdate());
						objectMstr.setString(3,
								asn.getTt_xasnmstri_todate() == null ? "" : asn.getTt_xasnmstri_todate());
						objectMstr.setString(4,
								asn.getTt_xasnmstro_shipto() == null ? "" : asn.getTt_xasnmstro_shipto());
						objectMstr.setString(5,
								asn.getTt_xasnmstri_yhdnbr() == null ? "" : asn.getTt_xasnmstri_yhdnbr());
						objectMstr.setString(6,
								asn.getTt_xasnmstri_partnbr() == null ? "" : asn.getTt_xasnmstri_partnbr());

					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinqury_xasnmstr(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xasnmstr_out");

					asns = QADUtil.ConverToAsn(outDataList);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		//
		// if (asn != null && asn.getIsDetail()) {
		// asnDetails = new ArrayList<AsnDetail>();
		// // AsnDetail podet = new AsnDetail();
		// // podet.setTt_xasnddeto_seq(new BigDecimal(20));
		// // podet.setTt_xasnddeto_yhdnbr("ORD000001");
		// // podet.setTt_xasnddeto_partnbr("1000002");
		// // podet.setTt_xasnddeto_partdesc("螺母");
		// // podet.setTt_xasnddeto_spq(new BigDecimal(100));
		// // podet.setTt_xasnddeto_uom("件");
		// // podet.setTt_xasnddeto_reqqty(new BigDecimal(2000));
		// // podet.setTt_xasnddeto_ordqty(new BigDecimal(2000));
		// // asnDetails.add(podet);
		//
		// // if (ConnectQAD()) {
		// // String userCode = this.getRequest().getRemoteUser();
		// // @SuppressWarnings("unchecked")
		// // List<String> supplierCodeList = universalManager.findByNativeSql(
		// // "select permission_code from permission_view where
		// // permission_type = ? and username = ?",
		// // new Object[] { PermissionType.S.toString(), userCode });
		// //
		// // String domain = "YFKSH";
		// // ProDataGraph exDataGraph; // 输入参数
		// // ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
		// // try {
		// // exDataGraph = new
		// //
		// ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxexport_xasnddet_DSMetaData1());
		// // for (int i = 0; i < supplierCodeList.size(); i++) {
		// // ProDataObject object =
		// // exDataGraph.createProDataObject("tt_suppcode_in");
		// // String supCode = supplierCodeList.get(i);
		// // object.setString(0, domain);
		// // object.setString(1, supCode);
		// //
		// // exDataGraph.addProDataObject(object);
		// // }
		// //
		// // ProDataObject objectMstr =
		// // exDataGraph.createProDataObject("tt_xasnddet_in");
		// //
		// // if (asn != null) {
		// // objectMstr.setString(0, asn.getTt_xasnmstro_yhdnbr());
		// // objectMstr.setString(1,
		// // String.valueOf(asn.getTt_xasnmstro_stat()));
		// // objectMstr.setString(2, asn.getTt_xasnmstro_startdt());
		// // objectMstr.setString(3, asn.getTt_xasnmstro_priority());
		// // objectMstr.setString(4, asn.getTt_xasnmstro_creator());
		// // objectMstr.setString(5, asn.getTt_xasnmstro_shipto());
		// // objectMstr.setString(6, asn.getTt_xasnmstro_receptdt());
		// // objectMstr.setString(7, asn.getTt_xasnmstro_partnbr());
		// // objectMstr.setString(8, asn.getTt_xasnmstro_userauth());
		// // }
		// // objectMstr.setString(0, domain);
		// //
		// // exDataGraph.addProDataObject(objectMstr);
		// //
		// // yfkssScp.xxexport_xasnddet(exDataGraph, outputData);
		// // } catch (Exception e) {
		// // e.printStackTrace();
		// // }
		// //
		// // }
		//
		// } else {
		// asns = new ArrayList<Asn>();
		// Asn asn1 = new Asn();
		// asn1.setTt_xasnmstro_asnnbr("ASN000001");
		// asn1.setTt_xasnmstro_seq(10);
		// asn1.setTt_xasnmstro_creator("admin");
		// asn1.setTt_xasnmstro_startdt("20150831");
		// asn1.setTt_xasnmstro_suppcode("ADKJ");
		// asn1.setTt_xasnmstro_stat("2");
		// asns.add(asn1);
		//
		// // if (ConnectQAD()) {
		// // String userCode = this.getRequest().getRemoteUser();
		// // @SuppressWarnings("unchecked")
		// // List<String> supplierCodeList = universalManager.findByNativeSql(
		// // "select permission_code from permission_view where
		// // permission_type = ? and username = ?",
		// // new Object[] { PermissionType.S.toString(), userCode });
		// //
		// // String domain = "YFKSH";
		// // ProDataGraph exDataGraph; // 输入参数
		// // ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
		// // try {
		// //
		// // exDataGraph = new
		// //
		// ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xasnmstr_DSMetaData1());
		// // for (int i = 0; i < supplierCodeList.size(); i++) {
		// // ProDataObject object =
		// // exDataGraph.createProDataObject("tt_suppcode_in");
		// // String supCode = supplierCodeList.get(i);
		// // object.setString(0, domain);
		// // object.setString(1, supCode);
		// //
		// // exDataGraph.addProDataObject(object);
		// // }
		// //
		// // ProDataObject objectMstr =
		// // exDataGraph.createProDataObject("tt_xasnmstr_in");
		// // if (asn != null) {
		// // objectMstr.setString(0, asn.getTt_xasnmstro_yhdnbr());
		// // objectMstr.setString(1,
		// // String.valueOf(asn.getTt_xasnmstro_stat()));
		// // objectMstr.setGregorianCalendar(2, new
		// // GregorianCalendar(2015,9,1));
		// // objectMstr.setString(3, asn.getTt_xasnmstro_priority());
		// // objectMstr.setString(4, asn.getTt_xasnmstro_creator());
		// // objectMstr.setString(5, asn.getTt_xasnmstro_shipto());
		// // objectMstr.setGregorianCalendar(6, new
		// // GregorianCalendar(2015,9,1));
		// // objectMstr.setString(7, asn.getTt_xasnmstro_partnbr());
		// // objectMstr.setString(8, asn.getTt_xasnmstro_userauth());
		// // }
		// // objectMstr.setString(0, domain);
		// //
		// // exDataGraph.addProDataObject(objectMstr);
		// //
		// // yfkssScp.xxinquiry_xasnmstr(exDataGraph, outputData);
		// // } catch (Exception e) {
		// // e.printStackTrace();
		// // }
		// //
		// // }
		// }
	}

	public String print() throws Exception {
		String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");

		// 测试
		asn = new Asn();
		asn.setTt_xasnmstro_asnnbr("ASN000001");
		asn.setTt_xasnmstro_seq(10);
		asn.setTt_xasnmstro_creator("admin");
		asn.setTt_xasnmstro_startdt("20150831");
		asn.setTt_xasnmstro_shipto("秀浦路426号");
		asn.setTt_xasnmstro_suppcode("ADKJ");
		asn.setTt_xasnmstro_stat("2");

		asnDetails = new ArrayList<AsnDetail>();
		AsnDetail asndet = new AsnDetail();
		asndet.setTt_xasndeto_seq(10);
		asndet.setTt_xasndeto_yhdnbr("ORD000001");
		asndet.setTt_xasndeto_partnbr("1000001");
		asndet.setTt_xasndeto_partdesc("螺丝");
		asndet.setTt_xasndeto_spq(new BigDecimal(100));
		asndet.setTt_xasndeto_uom("件");
		asndet.setTt_xasndeto_asnqty(new BigDecimal(2000));
		asnDetails.add(asndet);

		AsnDetail asndet1 = new AsnDetail();
		asndet1.setTt_xasndeto_seq(20);
		asndet1.setTt_xasndeto_yhdnbr("ORD000001");
		asndet1.setTt_xasndeto_partnbr("1000002");
		asndet1.setTt_xasndeto_partdesc("螺母");
		asndet1.setTt_xasndeto_spq(new BigDecimal(100));
		asndet1.setTt_xasndeto_uom("件");
		asndet1.setTt_xasndeto_asnqty(new BigDecimal(2000));
		asnDetails.add(asndet1);

		asn.setAsnDetailList(asnDetails);

		inputStream = export(localAbsolutPath, "", asn);

		fileName = "asn_" + asn.getTt_xasnmstro_asnnbr() + ".pdf";
		return SUCCESS;
	}

	@SuppressWarnings("finally")
	public static InputStream export(String localAbsolutPath, String backGroupImageName, Asn asn)
			throws MalformedURLException, IOException, DocumentException {

		// String backGroupImageUrl = localAbsolutPath + "WEB-INF" +
		// File.separator + "classes" + File.separator + "template" +
		// File.separator
		// + backGroupImageName;

		// ByteArrayOutputStream outputStream = new
		// FileOutputStream("c:/hello.pdf")

		// Image backGroupImage = Image.getInstance();
		// backGroupImage.setAbsolutePosition(0, 0);
		// backGroupImage.scaleAbsolute(600, 847);

		String templateUrl = localAbsolutPath + "WEB-INF" + File.separator + "classes" + File.separator + "template"
				+ File.separator;

		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		BaseFont dinBf = BaseFont.createFont("c:\\windows\\fonts\\arial.ttf", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);
		BaseFont simBf = BaseFont.createFont("c:\\windows\\fonts\\simsun.ttc,1,Bold", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);
		BaseFont barCodeBf = BaseFont.createFont("c:\\windows\\fonts\\simsun.ttc,1,Bold", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);

		NumberFormat numberFormat = new DecimalFormat("#.#");

		try {

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			PdfReader asnReader = new PdfReader(templateUrl + "asn.pdf");
			document.open();

			PdfContentByte underPdfContentByte = writer.getDirectContentUnder();
			PdfContentByte cb = writer.getDirectContent();
			PdfImportedPage page = writer.getImportedPage(asnReader, 1);

			int rowPix = 535;

			for (int i = 0; i < asn.getAsnDetailList().size(); i++) {
				AsnDetail asnDetail = asn.getAsnDetailList().get(i);

				if (i % 22 == 0) {
					if (i > 0) {
						document.newPage();
					}
					rowPix = 535;
					exportHead(underPdfContentByte, cb, asn, dinBf, simBf, barCodeBf);
				}

				int seq = asnDetail.getTt_xasndeto_seq();

				cb.beginText();
				cb.setFontAndSize(dinBf, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_CENTER, asnDetail.getTt_xasndeto_asnnbr(), 82, rowPix, 0);
				cb.endText();

				PdfTemplate tp2 = cb.createTemplate(100, 50);
				tp2.beginText();
				tp2.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL_CLIP);
				tp2.setFontAndSize(simBf, 8);
				// tp2.moveText(6, -6);
				// tp2.showText(asnDetail.getTt_xasnddeto_partdesc());
				tp2.endText();
				cb.addTemplate(tp2, 122, rowPix);

				rowPix -= 17;
				if (i % 5 == 0) {
					rowPix -= 1;
				}
			}

		} finally {
			document.close();
			return new ByteArrayInputStream(outputStream.toByteArray());
		}
	}

	private static void exportHead(PdfContentByte underPdfContentByte, PdfContentByte cb, Asn asn, BaseFont dinBf,
			BaseFont simBf, BaseFont barCodeBf) throws DocumentException, IOException {
		// underPdfContentByte.addImage(backGroupImage);

		cb.beginText();
		cb.setFontAndSize(barCodeBf, 28);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "*"
		// + (asn.getTt_xasnmstro_yhdnbr() != null ?
		// asn.getTt_xasnmstro_yhdnbr() : "") + "*",
		// 442, 767, 0);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "123456" , 442, 767,
		// 0);
		cb.endText();

		// cb.beginText();
		// cb.setFontAndSize(dinBf, 10);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
		// deliveryOrder.getExternalDoNo() != null ?
		// deliveryOrder.getExternalDoNo() : "", 442, 759, 0);
		// cb.endText();
		//
		// cb.beginText();
		// cb.setFontAndSize(simBf, 10);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
		// deliveryOrder.getSupplierName() != null ?
		// deliveryOrder.getSupplierName() : "", 206, 732, 0);
		// cb.endText();
		//
		// cb.beginText();
		// cb.setFontAndSize(dinBf, 20);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
		// deliveryOrder.getSupplierCode() != null ?
		// deliveryOrder.getSupplierCode() : "", 489, 728, 0);
		// cb.endText();
		//
		// cb.beginText();
		// cb.setFontAndSize(simBf, 11);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
		// deliveryOrder.getSupplierContactPerson() != null ?
		// deliveryOrder.getSupplierContactPerson()
		// : "", 120, 700, 0);
		// cb.endText();
		//
		// cb.beginText();
		// cb.setFontAndSize(dinBf, 9);
		// cb
		// .showTextAligned(PdfContentByte.ALIGN_CENTER,
		// deliveryOrder.getSupplierPhone() != null ?
		// deliveryOrder.getSupplierPhone() : "", 250,
		// 700, 0);
		// cb.endText();
		//
		// cb.beginText();
		// cb.setFontAndSize(simBf, 11);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
		// deliveryOrder.getPlantContactPerson() != null ?
		// deliveryOrder.getPlantContactPerson() : "",
		// 393, 700, 0);
		// cb.endText();
		//
		// cb.beginText();
		// cb.setFontAndSize(dinBf, 9);
		// cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
		// deliveryOrder.getPlantPhone() != null ? deliveryOrder.getPlantPhone()
		// : "", 536, 700, 0);
		// cb.endText();
	}

}
