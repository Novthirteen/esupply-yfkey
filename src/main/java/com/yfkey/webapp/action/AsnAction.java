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
import com.yfkey.webapp.util.PrintASNUtil;
import com.yfkey.webapp.util.QADUtil;
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;
import com.yfkey.model.Item;
import com.yfkey.model.LabelValue;

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
					if (outDataList != null && outDataList.size() > 0) {
						List<Object> objList = QADUtil.ConvertToAsnAndDetail(outDataList);
						asn = (Asn) objList.get(0);
						asn.setTt_xasnmstro_xasnmstroid(tt_xasnmstro_xasnmstroid);
						asnDetails = (List<AsnDetail>) objList.get(1);
						asn.setTt_xasnmstro_stat_desc(getAsnStatus(asn.getTt_xasnmstro_stat()));
					}
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

		if (asn == null) {
			asn = new Asn();
			asn.setIsDetail(false);
		}
		
		// autocomplete要处理一下
		if (asn.getTt_xasnmstro_shipto() != null && !asn.getTt_xasnmstro_shipto().equals("")) {
			String shipto = asn.getTt_xasnmstro_shipto();
			if (shipto.contains("(")) {
				asn.setTt_xasnmstro_shipto(shipto.substring(0, shipto.indexOf("(")));
			}
		}
		if (asn.getTt_xasnmstri_partnbr() != null && !asn.getTt_xasnmstri_partnbr().equals("")) {

			String item = asn.getTt_xasnmstri_partnbr();
			if (item.contains("(")) {
				asn.setTt_xasnmstri_partnbr(item.substring(0, item.indexOf("(")));
			}
		}
		if (asn.getTt_xasnmstro_suppcode() != null && !asn.getTt_xasnmstro_suppcode().equals("")) {

			String suppcode = asn.getTt_xasnmstro_suppcode();
			if (suppcode.contains("(")) {
				asn.setTt_xasnmstro_suppcode(suppcode.substring(0, suppcode.indexOf("(")));
			}
		}
		
		if(asn.getTt_xasnmstro_stat() == null || asn.getTt_xasnmstro_stat() == "")
		{
			asn.setTt_xasnmstro_stat("1,2");
		}
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
				String domain = getCurrentDomain();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(asn != null ? asn.getTt_xasnmstro_suppcode() : "");

			
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
								asn.getTt_xasnmstro_asnnbr() == null ? "" : asn.getTt_xasnmstro_asnnbr().trim());
						objectMstr.setString(1,
								asn.getTt_xasnmstro_stat() == null ? "" : asn.getTt_xasnmstro_stat().trim());
						objectMstr.setString(2,
								asn.getTt_xasnmstri_fromdate() == null ? "" : asn.getTt_xasnmstri_fromdate().trim());
						objectMstr.setString(3,
								asn.getTt_xasnmstri_todate() == null ? "" : asn.getTt_xasnmstri_todate().trim());
						objectMstr.setString(4,
								asn.getTt_xasnmstro_shipto() == null ? "" : asn.getTt_xasnmstro_shipto().trim());
						objectMstr.setString(5,
								asn.getTt_xasnmstri_yhdnbr() == null ? "" : asn.getTt_xasnmstri_yhdnbr().trim());
						objectMstr.setString(6,
								asn.getTt_xasnmstri_partnbr() == null ? "" : asn.getTt_xasnmstri_partnbr().trim());

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
				String domain = getCurrentDomain();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(asn != null ? asn.getTt_xasnmstro_suppcode() : "");

			

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
								asn.getTt_xasnmstro_asnnbr() == null ? "" : asn.getTt_xasnmstro_asnnbr().trim());
						objectMstr.setString(1,
								asn.getTt_xasnmstro_stat() == null ? "" : asn.getTt_xasnmstro_stat().trim());
						objectMstr.setString(2,
								asn.getTt_xasnmstri_fromdate() == null ? "" : asn.getTt_xasnmstri_fromdate().trim());
						objectMstr.setString(3,
								asn.getTt_xasnmstri_todate() == null ? "" : asn.getTt_xasnmstri_todate().trim());
						objectMstr.setString(4,
								asn.getTt_xasnmstro_shipto() == null ? "" : asn.getTt_xasnmstro_shipto().trim());
						objectMstr.setString(5,
								asn.getTt_xasnmstri_yhdnbr() == null ? "" : asn.getTt_xasnmstri_yhdnbr().trim());
						objectMstr.setString(6,
								asn.getTt_xasnmstri_partnbr() == null ? "" : asn.getTt_xasnmstri_partnbr().trim());

					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinqury_xasnmstr(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xasnmstr_out");

					asns = QADUtil.ConverToAsn(outDataList);

					// asn状态字段
					for (Asn asn : asns) {
						asn.setTt_xasnmstro_stat_desc(getAsnStatus(asn.getTt_xasnmstro_stat()));
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

	public String print() throws Exception {

		try {
			if (ConnectQAD()) {

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xasndet_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xasndet_in");

				object.setString(0, asn.getTt_xasnmstro_xasnmstroid());

				exDataGraph.addProDataObject(object);

				yfkssScp.xxview_xasndet(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xasndet_out");

				List<Object> objList = QADUtil.ConvertToAsnAndDetail(outDataList);
				asn = (Asn) objList.get(0);
				asnDetails = (List<AsnDetail>) objList.get(1);

				asn.setAsnDetailList(asnDetails);

				String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");
				inputStream = PrintASNUtil.PrintASN(localAbsolutPath, "ASN.pdf", asn);

				fileName = "asn_" + asn.getTt_xasnmstro_asnnbr() + ".pdf";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<LabelValue> getAsnStatusList() {
		List<LabelValue> asnStatusList = new ArrayList<LabelValue>();
		asnStatusList.add(new LabelValue("", getText("xasnd_status.Empty")));
		asnStatusList.add(new LabelValue("1", getText("xasnd_status.Create")));
		asnStatusList.add(new LabelValue("2", getText("xasnd_status.InProcess")));
		asnStatusList.add(new LabelValue("3", getText("xasnd_status.Close")));

		return asnStatusList;
	}

	public String getAsnStatus(String status) {
		String statusDesc = "";
		switch (status) {
		case "1":
			statusDesc = getText("xasnd_status.Create");
			break;
		case "2":
			statusDesc = getText("xasnd_status.InProcess");
			break;
		case "3":
			statusDesc = getText("xasnd_status.Close");
			break;
		default:
			break;
		}

		return statusDesc;
	}

}
