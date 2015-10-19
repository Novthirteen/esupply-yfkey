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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.security.access.AccessDecisionVoter;

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
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;
import com.yfkey.model.LabelValue;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.webapp.util.PrintASNUtil;
import com.yfkey.webapp.util.PrintPurchaseOrderUtil;
import com.yfkey.webapp.util.QADUtil;

/**
 * Action for facilitating Role Management feature.
 */
public class PurchaseOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -569882426981216104L;
	private List<PurchaseOrder> purchaseOrders;
	private List<PurchaseOrderDetail> purchaseOrderDetails;
	private PurchaseOrder purchaseOrder;
	private String tt_xpyhmstro_yhdnbr;
	private InputStream inputStream;
	private String fileName;
	private String tt_xpyhmstro_xpyhmstroid;

	private String tt_xpyhddeti_xpyhmstroid;

	/**
	 * Holder for purchaseOrders to display on list screen
	 *
	 * @return list of purchaseOrders
	 */
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getTt_xpyhmstro_yhdnbr() {
		return tt_xpyhmstro_yhdnbr;
	}

	public void setTt_xpyhmstro_yhdnbr(String xpyhmstro_yhdnbr) {
		this.tt_xpyhmstro_yhdnbr = xpyhmstro_yhdnbr;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public String getTt_xpyhmstro_xpyhmstroid() {
		return tt_xpyhmstro_xpyhmstroid;
	}

	public void setTt_xpyhmstro_xpyhmstroid(String tt_xpyhmstro_xpyhmstroid) {
		this.tt_xpyhmstro_xpyhmstroid = tt_xpyhmstro_xpyhmstroid;
	}

	public String getTt_xpyhddeti_xpyhmstroid() {
		return tt_xpyhddeti_xpyhmstroid;
	}

	public void setTt_xpyhddeti_xpyhmstroid(String tt_xpyhddeti_xpyhmstroid) {
		this.tt_xpyhddeti_xpyhmstroid = tt_xpyhddeti_xpyhmstroid;
	}

	/**
	 * Grab the purchaseOrder from the database based on the "purchaseOrderName"
	 * passed in.
	 *
	 * @return success if purchaseOrder found
	 * @throws IOException
	 *             can happen when sending a "forbidden" from
	 *             response.sendError()
	 */
	public String edit() throws IOException {

		try {

			if (tt_xpyhmstro_xpyhmstroid != null) {

				if (ConnectQAD()) {
					String userCode = this.getRequest().getRemoteUser();
					String domain = getCurrentDomain();
					ProDataGraph exDataGraph; // 输入参数
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xpyhddet_DSMetaData1());

					ProDataObject object = exDataGraph.createProDataObject("tt_xpyhddet_in");

					object.setString(0, tt_xpyhmstro_xpyhmstroid);
					object.setString(1, ""); // 0为打印，""为查询

					exDataGraph.addProDataObject(object);

					yfkssScp.xxview_xpyhddet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xpyhddet_out");
					if (outDataList != null && outDataList.size() > 0) {
						List<Object> objList = QADUtil.ConvertToPurchaseOrderAndDetail(outDataList);
						purchaseOrder = (PurchaseOrder) objList.get(0);
						purchaseOrderDetails = (List<PurchaseOrderDetail>) objList.get(1);

						// 状态描述和优先级翻译一下
						purchaseOrder.setTt_xpyhmstro_stat_desc(
								getPurchaseOrderStatus(purchaseOrder.getTt_xpyhmstro_stat()));
						purchaseOrder.setTt_xpyhmstro_priority_desc(
								getPurchaseOrderPriority(purchaseOrder.getTt_xpyhmstro_priority()));
					}
				}
			} else {
				purchaseOrder = new PurchaseOrder();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	public String shipEdit() throws IOException {

		try {

			if (tt_xpyhddeti_xpyhmstroid != null) {

				if (ConnectQAD()) {

					// 先清空一下
					if (purchaseOrder != null) {
						purchaseOrder = new PurchaseOrder();
					}
					if (purchaseOrderDetails != null) {
						purchaseOrderDetails.clear();
					}

					ProDataGraph exDataGraph; // 输入参数
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinqury_xpyhddet2_DSMetaData1());

					ProDataObject object = exDataGraph.createProDataObject("tt_xpyhddet_in");

					object.setString(0, tt_xpyhddeti_xpyhmstroid);

					exDataGraph.addProDataObject(object);

					yfkssScp.xxinqury_xpyhddet2(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xpyhddet_out");

					List<Object> objList = QADUtil.ConvertToShipPurchaseOrderAndDetail(outDataList);
					purchaseOrder = (PurchaseOrder) objList.get(0);
					purchaseOrderDetails = (List<PurchaseOrderDetail>) objList.get(1);
				}
			} else {
				purchaseOrder = new PurchaseOrder();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();

				String domain = "YFKSH";
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xpyhmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhmstr_in");

				object.setString(0, purchaseOrder.getTt_xpyhmstro_xpyhmstroid());
				object.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
				object.setString(2, "6");

				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xpyhmstr(exDataGraph, outputData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String confirm() {
		try {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xpyhmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhmstr_in");

				object.setString(0, purchaseOrder.getTt_xpyhmstro_xpyhmstroid());
				object.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
				object.setString(2, "3");

				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xpyhmstr(exDataGraph, outputData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String close() {
		try {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();

				String domain = "YFKSH";
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xpyhmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhmstr_in");

				object.setString(0, "1001");
				object.setString(1, "2");
				object.setString(2, "4");

				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xpyhmstr(exDataGraph, outputData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String ship() {
		try {
			String userCode = this.getRequest().getRemoteUser();
			if (ConnectQAD()) {

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxcreate_xasndet_DSMetaData1());

				if (purchaseOrderDetails != null && purchaseOrderDetails.size() > 0) {
					for (PurchaseOrderDetail pod : purchaseOrderDetails) {
						ProDataObject object = exDataGraph.createProDataObject("tt_xasndet_in");
						object.setString(0, pod.getTt_xpyhddeto_xpyhddetoid());
						object.setBigDecimal(1, pod.getTt_xpyhddeto_delvqty());
						object.setString(2, purchaseOrder.getRemark());
						object.setString(3, pod.getLine_remark());
						object.setString(4, userCode);
						object.setString(5, "-1");
						object.setString(6, "-1");

						exDataGraph.addProDataObject(object);
					}
				}

				yfkssScp.xxcreate_xasndet(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xasndet_out");

			} else {
				purchaseOrder = new PurchaseOrder();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * Fetch all purchaseOrders from database and put into local
	 * "purchaseOrders" variable for retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		if (purchaseOrder == null) {
			purchaseOrder = new PurchaseOrder();
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			purchaseOrder.setTt_xpyhmstro_receptdt(df.format(date));
			purchaseOrder.setIsDetail(false);
		}
		//autocomplete要处理一下
		if(purchaseOrder.getTt_xpyhmstro_suppcode() != null && !purchaseOrder.getTt_xpyhmstro_suppcode().equals(""))
		{
			String suppcode= purchaseOrder.getTt_xpyhmstro_suppcode();
			if(suppcode.contains("("))
			{
			purchaseOrder.setTt_xpyhmstro_suppcode(suppcode.substring(0, suppcode.indexOf("(")));
			}
		}
		if(purchaseOrder.getTt_xpyhmstro_shipto() != null && !purchaseOrder.getTt_xpyhmstro_shipto().equals(""))
		{
			String shipto= purchaseOrder.getTt_xpyhmstro_shipto();

			if(shipto.contains("(")){
			purchaseOrder.setTt_xpyhmstro_shipto(shipto.substring(0, shipto.indexOf("(")));
			}
		}
		
		query();
	
		return SUCCESS;
	}

	public String shiplist() {
		
		if(purchaseOrder == null)
		{
			purchaseOrder = new PurchaseOrder();
			
		}
		
		if(purchaseOrder.getTt_xpyhmstro_shipto() != null && !purchaseOrder.getTt_xpyhmstro_shipto().equals(""))
		{
			String shipto= purchaseOrder.getTt_xpyhmstro_shipto();

			if(shipto.contains("(")){
			purchaseOrder.setTt_xpyhmstro_shipto(shipto.substring(0, shipto.indexOf("(")));
			}
		}
		
		purchaseOrder.setTt_xpyhmstro_stat("2,3");
		
		shipQuery();
		return SUCCESS;
	}

	public String cancel() {
		return CANCEL;
	}

	private void query() {

		if (purchaseOrder != null && purchaseOrder.getIsDetail()) {
			// purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();
			// PurchaseOrderDetail podet = new PurchaseOrderDetail();
			// podet.setTt_xpyhddeto_seq(new BigDecimal(20));
			// podet.setTt_xpyhddeto_yhdnbr("ORD000001");
			// podet.setTt_xpyhddeto_partnbr("1000002");
			// podet.setTt_xpyhddeto_partdesc("螺母");
			// podet.setTt_xpyhddeto_spq(new BigDecimal(100));
			// podet.setTt_xpyhddeto_uom("件");
			// podet.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
			// podet.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
			// purchaseOrderDetails.add(podet);

			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();
				
				
				
				
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						purchaseOrder != null ? purchaseOrder.getTt_xpyhmstro_suppcode() : "");

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {
					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxexport_xpyhddet_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xpyhddet_in");

					if (purchaseOrder != null) {
						objectMstr.setString(0, purchaseOrder.getTt_xpyhmstro_yhdnbr() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_yhdnbr().trim());
						objectMstr.setString(1, purchaseOrder.getTt_xpyhmstro_stat() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_stat().trim());
						objectMstr.setString(2, purchaseOrder.getTt_xpyhmstro_startdt() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_startdt().trim());
						objectMstr.setString(3, purchaseOrder.getTt_xpyhmstro_priority() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_priority().trim());
						objectMstr.setString(4, purchaseOrder.getTt_xpyhmstro_creator() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_creator().trim());
						objectMstr.setString(5, purchaseOrder.getTt_xpyhmstro_shipto() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_shipto().trim());
						objectMstr.setString(6, purchaseOrder.getTt_xpyhmstro_receptdt() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_receptdt().trim());
						objectMstr.setString(7, purchaseOrder.getTt_xpyhmstro_partnbr() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_partnbr().trim());
					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxexport_xpyhddet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xpyhddet_out");

					purchaseOrderDetails = QADUtil.ConvertToPurchaseOrderDetail(outDataList);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else {

			// purchaseOrders = new ArrayList<PurchaseOrder>();
			// PurchaseOrder po = new PurchaseOrder();
			// po.setTt_xpyhmstro_yhdnbr("ORD000001");
			// po.setTt_xpyhmstro_priority("High");
			// po.setTt_xpyhmstro_creator("admin");
			// po.setTt_xpyhmstro_receptdt("20150901");
			// po.setTt_xpyhmstro_startdt("20150831");
			// po.setTt_xpyhmstro_seq(1);
			// po.setTt_xpyhmstro_suppcode("ADKJ");
			// po.setTt_xpyhmstro_shipto("秀浦路426号");
			// purchaseOrders.add(po);

			if (ConnectQAD()) {

				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						purchaseOrder != null ? purchaseOrder.getTt_xpyhmstro_suppcode() : "");

				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xpyhmstr_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xpyhmstr_in");
					if (purchaseOrder != null) {
						objectMstr.setString(0, purchaseOrder.getTt_xpyhmstro_yhdnbr() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_yhdnbr().trim());
						objectMstr.setString(1, purchaseOrder.getTt_xpyhmstro_stat() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_stat().trim());
						objectMstr.setString(2, purchaseOrder.getTt_xpyhmstro_startdt() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_startdt().trim());
						objectMstr.setString(3, purchaseOrder.getTt_xpyhmstro_priority() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_priority().trim());
						objectMstr.setString(4, purchaseOrder.getTt_xpyhmstro_creator() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_creator().trim());
						objectMstr.setString(5, purchaseOrder.getTt_xpyhmstro_shipto() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_shipto().trim());
						objectMstr.setString(6, purchaseOrder.getTt_xpyhmstro_receptdt() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_receptdt().trim());
						objectMstr.setString(7, purchaseOrder.getTt_xpyhmstro_partnbr() == null ? ""
								: purchaseOrder.getTt_xpyhmstro_partnbr().trim());
						objectMstr.setString(8, "0");

					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_xpyhmstr(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xpyhmstr_out");

					purchaseOrders = QADUtil.ConverToPurchaseOrder(outDataList);

					// 两个描述字段翻译一下
					for (PurchaseOrder po : purchaseOrders) {
						po.setTt_xpyhmstro_stat_desc(getPurchaseOrderStatus(po.getTt_xpyhmstro_stat()));
						po.setTt_xpyhmstro_priority_desc(getPurchaseOrderPriority(po.getTt_xpyhmstro_priority()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	private void shipQuery() {

		// purchaseOrders = new ArrayList<PurchaseOrder>();
		// PurchaseOrder po = new PurchaseOrder();
		// po.setTt_xpyhmstro_yhdnbr("ORD000001");
		// po.setTt_xpyhmstro_priority("High");
		// po.setTt_xpyhmstro_creator("admin");
		// po.setTt_xpyhmstro_receptdt("20150901");
		// po.setTt_xpyhmstro_startdt("20150831");
		// po.setTt_xpyhmstro_seq(1);
		// po.setTt_xpyhmstro_suppcode("ADKJ");
		// po.setTt_xpyhmstro_shipto("秀浦路426号");
		// purchaseOrders.add(po);

		if (ConnectQAD()) {

			if (purchaseOrder == null) {
				purchaseOrder = new PurchaseOrder();
				purchaseOrder.setTt_xpyhmstro_stat("3");
				purchaseOrder.setTt_xpyhmstro_shipto("");
				purchaseOrder.setTt_xpyhmstro_yhdnbr("");
			}
			String userCode = this.getRequest().getRemoteUser();
			@SuppressWarnings("unchecked")
			List<String> supplierCodeList = getSupplierCodeList(
					purchaseOrder != null ? purchaseOrder.getTt_xpyhmstro_suppcode() : "");

			String domain = getCurrentDomain();

			ProDataGraph exDataGraph; // 输入参数
			ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
			try {

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xpyhmstr_DSMetaData1());
				for (int i = 0; i < supplierCodeList.size(); i++) {
					ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
					String supCode = supplierCodeList.get(i);
					object.setString(0, domain);
					object.setString(1, supCode);

					exDataGraph.addProDataObject(object);
				}

				ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xpyhmstr_in");
				if (purchaseOrder != null) {
					objectMstr.setString(0, purchaseOrder.getTt_xpyhmstro_yhdnbr());
					objectMstr.setString(1, purchaseOrder.getTt_xpyhmstro_stat());
					objectMstr.setString(2, "");
					objectMstr.setString(3, "");
					objectMstr.setString(4, "");
					objectMstr.setString(5, purchaseOrder.getTt_xpyhmstro_shipto());
					objectMstr.setString(6, "");
					objectMstr.setString(7, "");
					objectMstr.setString(8, "1");

				}

				exDataGraph.addProDataObject(objectMstr);

				yfkssScp.xxinquiry_xpyhmstr(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xpyhmstr_out");

				purchaseOrders = QADUtil.ConverToPurchaseOrder(outDataList);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public String print() throws Exception {
		try {

			if (ConnectQAD()) {

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xpyhddet_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhddet_in");

				object.setString(0, purchaseOrder.getTt_xpyhmstro_xpyhmstroid());
				object.setString(1, "0"); // 0为打印，""为查询

				exDataGraph.addProDataObject(object);

				yfkssScp.xxview_xpyhddet(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xpyhddet_out");

				List<Object> objList = QADUtil.ConvertToPurchaseOrderAndDetail(outDataList);
				purchaseOrder = (PurchaseOrder) objList.get(0);
				purchaseOrderDetails = (List<PurchaseOrderDetail>) objList.get(1);

				purchaseOrder.setPurchaseOrderDetailList(purchaseOrderDetails);

				String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");
				inputStream = PrintPurchaseOrderUtil.PrintPurchaseOrderUtil(localAbsolutPath, "PurchaseOrder.pdf",
						purchaseOrder);

				fileName = "purchaseOrder_" + purchaseOrder.getTt_xpyhmstro_yhdnbr() + ".pdf";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<LabelValue> getPurchaseOrderStatusList() {
		List<LabelValue> purchaseOrderStatusList = new ArrayList<LabelValue>();
		purchaseOrderStatusList.add(new LabelValue("", getText("xpyh_status.Empty")));
		purchaseOrderStatusList.add(new LabelValue("0", getText("xpyh_status.Forecast")));
		purchaseOrderStatusList.add(new LabelValue("1", getText("xpyh_status.Create")));
		purchaseOrderStatusList.add(new LabelValue("2", getText("xpyh_status.Submit")));
		purchaseOrderStatusList.add(new LabelValue("3", getText("xpyh_status.InProcess")));
		purchaseOrderStatusList.add(new LabelValue("4", getText("xpyh_status.Complete")));
		purchaseOrderStatusList.add(new LabelValue("5", getText("xpyh_status.Close")));
		purchaseOrderStatusList.add(new LabelValue("6", getText("xpyh_status.Cancel")));

		return purchaseOrderStatusList;
	}

	public String getPurchaseOrderStatus(String status) {
		String statusDesc = "";
		switch (status) {
		case "0":
			statusDesc = getText("xpyh_status.Forecast");
			break;
		case "1":
			statusDesc = getText("xpyh_status.Create");
			break;
		case "2":
			statusDesc = getText("xpyh_status.Submit");
			break;
		case "3":
			statusDesc = getText("xpyh_status.InProcess");
			break;
		case "4":
			statusDesc = getText("xpyh_status.Complete");
			break;
		case "5":
			statusDesc = getText("xpyh_status.Close");
			break;
		case "6":
			statusDesc = getText("xpyh_status.Cancel");
			break;
		default:
			break;
		}

		return statusDesc;
	}

	public List<LabelValue> getPurchaseOrderPriorityList() {
		List<LabelValue> purchaseOrderPriorityList = new ArrayList<LabelValue>();
		purchaseOrderPriorityList.add(new LabelValue("", getText("xpyh_priority.Empty")));
		purchaseOrderPriorityList.add(new LabelValue("0", getText("xpyh_priority.Forecast")));
		purchaseOrderPriorityList.add(new LabelValue("1", getText("xpyh_priority.Normal")));
		purchaseOrderPriorityList.add(new LabelValue("2", getText("xpyh_priority.Urgent")));
		return purchaseOrderPriorityList;
	}

	public String getPurchaseOrderPriority(String priority) {
		String priorityDesc = "";
		switch (priority) {
		case "0":
			priorityDesc = getText("xpyh_priority.Forecast");
			break;
		case "1":
			priorityDesc = getText("xpyh_priority.Normal");
			break;
		case "2":
			priorityDesc = getText("xpyh_priority.Urgent");
			break;
		default:
			break;
		}

		return priorityDesc;
	}
}
