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
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;

/**
 * Action for facilitating Role Management feature.
 */
public class PurchaseOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -569882426981216104L;
	private List<PurchaseOrder> purchaseOrders;
	private static List<PurchaseOrderDetail> purchaseOrderDetails;
	private PurchaseOrder purchaseOrder;
	private String tt_xpyhmstro_yhdnbr;
	private InputStream inputStream;
	private String fileName;
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

		// try {
		// if (ConnectQAD()) {
		// String userCode = this.getRequest().getRemoteUser();
		//
		// String domain = "YFKSH";
		// ProDataGraph exDataGraph; // 输入参数
		// ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
		//
		// exDataGraph = new
		// ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xpyhddet_DSMetaData1());
		//
		// ProDataObject object =
		// exDataGraph.createProDataObject("tt_xpyhddet_in");
		//
		// object.setString(0, tt_xpyhddeti_xpyhmstroid);
		//
		// exDataGraph.addProDataObject(object);
		//
		// yfkssScp.xxview_xpyhddet(exDataGraph, outputData);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return SUCCESS;

		// if a purchaseOrderCode is passed in
		if (tt_xpyhmstro_yhdnbr != null) {
			// lookup the purchaseOrder using code
			// purchaseOrder = (PurchaseOrder)
			// universalManager.get(PurchaseOrder.class, xpyhmstro_yhdnbr);

			purchaseOrder = new PurchaseOrder();
			purchaseOrder.setTt_xpyhmstro_yhdnbr("ORD000001");
			purchaseOrder.setTt_xpyhmstro_priority("High");
			purchaseOrder.setTt_xpyhmstro_creator("admin");
			purchaseOrder.setTt_xpyhmstro_receptdt("20150901");
			purchaseOrder.setTt_xpyhmstro_startdt("20150831");
			purchaseOrder.setTt_xpyhmstro_seq(1);
			purchaseOrder.setTt_xpyhmstro_suppcode("ADKJ");
			purchaseOrder.setTt_xpyhmstro_shipto("秀浦路426号");
			purchaseOrder.setTt_xpyhmstro_stat(2);

			purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();
			PurchaseOrderDetail podet = new PurchaseOrderDetail();
			podet.setTt_xpyhddeto_seq(new BigDecimal(10));
			podet.setTt_xpyhddeto_yhdnbr("ORD000001");
			podet.setTt_xpyhddeto_partnbr("1000001");
			podet.setTt_xpyhddeto_partdesc("螺丝");
			podet.setTt_xpyhddeto_spq(new BigDecimal(100));
			podet.setTt_xpyhddeto_uom("件");
			podet.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
			podet.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
			purchaseOrderDetails.add(podet);

			PurchaseOrderDetail podet1 = new PurchaseOrderDetail();
			podet1.setTt_xpyhddeto_seq(new BigDecimal(20));
			podet1.setTt_xpyhddeto_yhdnbr("ORD000001");
			podet1.setTt_xpyhddeto_partnbr("1000002");
			podet1.setTt_xpyhddeto_partdesc("螺母");
			podet1.setTt_xpyhddeto_spq(new BigDecimal(100));
			podet1.setTt_xpyhddeto_uom("件");
			podet1.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
			podet1.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
			purchaseOrderDetails.add(podet1);

			purchaseOrder.setPurchaseOrderDetailList(purchaseOrderDetails);

		} else {
			purchaseOrder = new PurchaseOrder();
			// purchaseOrder.addRole(new Role(Constants.USER_ROLE));
		}

		return SUCCESS;
	}

	
	public String shipEdit() throws IOException {
		if (tt_xpyhmstro_yhdnbr != null) {
			// lookup the purchaseOrder using code
			// purchaseOrder = (PurchaseOrder)
			// universalManager.get(PurchaseOrder.class, xpyhmstro_yhdnbr);

			purchaseOrder = new PurchaseOrder();
			purchaseOrder.setTt_xpyhmstro_yhdnbr("ORD000001");
			purchaseOrder.setTt_xpyhmstro_priority("High");
			purchaseOrder.setTt_xpyhmstro_creator("admin");
			purchaseOrder.setTt_xpyhmstro_receptdt("20150901");
			purchaseOrder.setTt_xpyhmstro_startdt("20150831");
			purchaseOrder.setTt_xpyhmstro_seq(1);
			purchaseOrder.setTt_xpyhmstro_suppcode("ADKJ");
			purchaseOrder.setTt_xpyhmstro_shipto("秀浦路426号");
			purchaseOrder.setTt_xpyhmstro_stat(2);

			purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();
			PurchaseOrderDetail podet = new PurchaseOrderDetail();
			podet.setTt_xpyhddeto_seq(new BigDecimal(10));
			podet.setTt_xpyhddeto_yhdnbr("ORD000001");
			podet.setTt_xpyhddeto_partnbr("1000001");
			podet.setTt_xpyhddeto_partdesc("螺丝");
			podet.setTt_xpyhddeto_spq(new BigDecimal(100));
			podet.setTt_xpyhddeto_uom("件");
			podet.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
			podet.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
			purchaseOrderDetails.add(podet);

			PurchaseOrderDetail podet1 = new PurchaseOrderDetail();
			podet1.setTt_xpyhddeto_seq(new BigDecimal(20));
			podet1.setTt_xpyhddeto_yhdnbr("ORD000001");
			podet1.setTt_xpyhddeto_partnbr("1000002");
			podet1.setTt_xpyhddeto_partdesc("螺母");
			podet1.setTt_xpyhddeto_spq(new BigDecimal(100));
			podet1.setTt_xpyhddeto_uom("件");
			podet1.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
			podet1.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
			purchaseOrderDetails.add(podet1);

			purchaseOrder.setPurchaseOrderDetailList(purchaseOrderDetails);

		} else {
			purchaseOrder = new PurchaseOrder();
			// purchaseOrder.addRole(new Role(Constants.USER_ROLE));
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

				String domain = "YFKSH";
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
//			if (ConnectQAD()) {
//				String userCode = this.getRequest().getRemoteUser();
//
//				String domain = "YFKSH";
//				ProDataGraph exDataGraph; // 输入参数
//				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
//
//				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xpyhmstr_DSMetaData1());
//
//				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhmstr_in");
//
//				object.setString(0, "1001");
//				object.setString(1, "2");
//				object.setString(2, "4");
//
//				exDataGraph.addProDataObject(object);
//
//				yfkssScp.xxupdate_xpyhmstr(exDataGraph, outputData);
//			}
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
		query();
		return SUCCESS;
	}
	
	public String shiplist() {
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
				List<String> supplierCodeList = universalManager.findByNativeSql(
						"select permission_code from permission_view where permission_type = ? and username = ?",
						new Object[] { PermissionType.S.toString(), userCode });

				String domain = "YFKSH";
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
						objectMstr.setString(0, purchaseOrder.getTt_xpyhmstro_yhdnbr());
						objectMstr.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
						objectMstr.setString(2, purchaseOrder.getTt_xpyhmstro_startdt());
						objectMstr.setString(3, purchaseOrder.getTt_xpyhmstro_priority());
						objectMstr.setString(4, purchaseOrder.getTt_xpyhmstro_creator());
						objectMstr.setString(5, purchaseOrder.getTt_xpyhmstro_shipto());
						objectMstr.setString(6, purchaseOrder.getTt_xpyhmstro_receptdt());
						objectMstr.setString(7, purchaseOrder.getTt_xpyhmstro_partnbr());
						//objectMstr.setString(8, purchaseOrder.getTt_xpyhmstro_userauth());
					}
				//	objectMstr.setString(0, domain);

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxexport_xpyhddet(exDataGraph, outputData);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else {
//			 purchaseOrders = new ArrayList<PurchaseOrder>();
//			 PurchaseOrder po = new PurchaseOrder();
//			 po.setTt_xpyhmstro_yhdnbr("ORD000001");
//			 po.setTt_xpyhmstro_priority("High");
//			 po.setTt_xpyhmstro_creator("admin");
//			 po.setTt_xpyhmstro_receptdt("20150901");
//			 po.setTt_xpyhmstro_startdt("20150831");
//			 po.setTt_xpyhmstro_seq(1);
//			 po.setTt_xpyhmstro_suppcode("ADKJ");
//			 po.setTt_xpyhmstro_shipto("秀浦路426号");
//			 purchaseOrders.add(po);

			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = universalManager.findByNativeSql(
						"select permission_code from permission_view where permission_type = ? and username = ?",
						new Object[] { PermissionType.S.toString(), userCode });

				String domain = "YFKSH";
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
						objectMstr.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
						objectMstr.setGregorianCalendar(2,  new  GregorianCalendar(2015,9,1));        
						objectMstr.setString(3, purchaseOrder.getTt_xpyhmstro_priority());
						objectMstr.setString(4, purchaseOrder.getTt_xpyhmstro_creator());
						objectMstr.setString(5, purchaseOrder.getTt_xpyhmstro_shipto());
						objectMstr.setGregorianCalendar(6,   new  GregorianCalendar(2015,9,1));                        
						objectMstr.setString(7, purchaseOrder.getTt_xpyhmstro_partnbr());
						objectMstr.setString(8, purchaseOrder.getTt_xpyhmstro_userauth());
					}
					objectMstr.setString(0, domain);

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_xpyhmstr(exDataGraph, outputData);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	
	
	
	private void shipQuery() {

		 purchaseOrders = new ArrayList<PurchaseOrder>();
		 PurchaseOrder po = new PurchaseOrder();
		 po.setTt_xpyhmstro_yhdnbr("ORD000001");
		 po.setTt_xpyhmstro_priority("High");
		 po.setTt_xpyhmstro_creator("admin");
		 po.setTt_xpyhmstro_receptdt("20150901");
		 po.setTt_xpyhmstro_startdt("20150831");
		 po.setTt_xpyhmstro_seq(1);
		 po.setTt_xpyhmstro_suppcode("ADKJ");
		 po.setTt_xpyhmstro_shipto("秀浦路426号");
		 purchaseOrders.add(po);

//		if (ConnectQAD()) {
//			String userCode = this.getRequest().getRemoteUser();
//			@SuppressWarnings("unchecked")
//			List<String> supplierCodeList = universalManager.findByNativeSql(
//					"select permission_code from permission_view where permission_type = ? and username = ?",
//					new Object[] { PermissionType.S.toString(), userCode });
//
//			String domain = "YFKSH";
//			ProDataGraph exDataGraph; // 输入参数
//			ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
//			try {
//
//				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xpyhmstr_DSMetaData1());
//				for (int i = 0; i < supplierCodeList.size(); i++) {
//					ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
//					String supCode = supplierCodeList.get(i);
//					object.setString(0, domain);
//					object.setString(1, supCode);
//
//					exDataGraph.addProDataObject(object);
//				}
//
//				ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xpyhmstr_in");
//				if (purchaseOrder != null) {
//					objectMstr.setString(0, purchaseOrder.getTt_xpyhmstro_yhdnbr());
//					objectMstr.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
//					objectMstr.setGregorianCalendar(2,  new  GregorianCalendar(2015,9,1));        
//					objectMstr.setString(3, purchaseOrder.getTt_xpyhmstro_priority());
//					objectMstr.setString(4, purchaseOrder.getTt_xpyhmstro_creator());
//					objectMstr.setString(5, purchaseOrder.getTt_xpyhmstro_shipto());
//					objectMstr.setGregorianCalendar(6,   new  GregorianCalendar(2015,9,1));                        
//					objectMstr.setString(7, purchaseOrder.getTt_xpyhmstro_partnbr());
//					objectMstr.setString(8, purchaseOrder.getTt_xpyhmstro_userauth());
//				}
//				objectMstr.setString(0, domain);
//
//				exDataGraph.addProDataObject(objectMstr);
//
//				yfkssScp.xxinquiry_xpyhmstr(exDataGraph, outputData);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
		
	}

	public String print() throws Exception {
		String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");

		// 测试
		purchaseOrder = new PurchaseOrder();
		purchaseOrder.setTt_xpyhmstro_yhdnbr("ORD000001");
		purchaseOrder.setTt_xpyhmstro_priority("High");
		purchaseOrder.setTt_xpyhmstro_creator("admin");
		purchaseOrder.setTt_xpyhmstro_receptdt("20150901");
		purchaseOrder.setTt_xpyhmstro_startdt("20150831");
		purchaseOrder.setTt_xpyhmstro_seq(1);
		purchaseOrder.setTt_xpyhmstro_suppcode("ADKJ");
		purchaseOrder.setTt_xpyhmstro_shipto("秀浦路426号");
		purchaseOrder.setTt_xpyhmstro_stat(2);

		purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();
		PurchaseOrderDetail podet = new PurchaseOrderDetail();
		podet.setTt_xpyhddeto_seq(new BigDecimal(10));
		podet.setTt_xpyhddeto_yhdnbr("ORD000001");
		podet.setTt_xpyhddeto_partnbr("1000001");
		podet.setTt_xpyhddeto_partdesc("螺丝");
		podet.setTt_xpyhddeto_spq(new BigDecimal(100));
		podet.setTt_xpyhddeto_uom("件");
		podet.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
		podet.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
		purchaseOrderDetails.add(podet);

		PurchaseOrderDetail podet1 = new PurchaseOrderDetail();
		podet1.setTt_xpyhddeto_seq(new BigDecimal(20));
		podet1.setTt_xpyhddeto_yhdnbr("ORD000001");
		podet1.setTt_xpyhddeto_partnbr("1000002");
		podet1.setTt_xpyhddeto_partdesc("螺母");
		podet1.setTt_xpyhddeto_spq(new BigDecimal(100));
		podet1.setTt_xpyhddeto_uom("件");
		podet1.setTt_xpyhddeto_reqqty(new BigDecimal(2000));
		podet1.setTt_xpyhddeto_ordqty(new BigDecimal(2000));
		purchaseOrderDetails.add(podet1);

		purchaseOrder.setPurchaseOrderDetailList(purchaseOrderDetails);

		inputStream = export(localAbsolutPath, "", purchaseOrder);

		fileName = "purchaseOrder_" + purchaseOrder.getTt_xpyhmstro_yhdnbr() + ".pdf";
		return SUCCESS;
	}

	@SuppressWarnings("finally")
	public static InputStream export(String localAbsolutPath, String backGroupImageName, PurchaseOrder purchaseOrder)
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
			PdfReader purchaseOrderReader = new PdfReader(templateUrl + "purchaseOrder.pdf");
			document.open();

			PdfContentByte underPdfContentByte = writer.getDirectContentUnder();
			PdfContentByte cb = writer.getDirectContent();
			PdfImportedPage page = writer.getImportedPage(purchaseOrderReader, 1);

			int rowPix = 535;

			for (int i = 0; i < purchaseOrder.getPurchaseOrderDetailList().size(); i++) {
				PurchaseOrderDetail purchaseOrderDetail = purchaseOrder.getPurchaseOrderDetailList().get(i);

				if (i % 22 == 0) {
					if (i > 0) {
						document.newPage();
					}
					rowPix = 535;
					exportHead(underPdfContentByte, cb, purchaseOrder, dinBf, simBf, barCodeBf);
				}

				BigDecimal unitCount = purchaseOrderDetail.getTt_xpyhddeto_spq();
				if (unitCount == null) {
					unitCount = new BigDecimal(1);
				}

				cb.beginText();
				cb.setFontAndSize(dinBf, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_CENTER, purchaseOrderDetail.getTt_xpyhddeto_partnbr(), 82,
						rowPix, 0);
				cb.endText();

				PdfTemplate tp2 = cb.createTemplate(100, 50);
				tp2.beginText();
				tp2.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL_CLIP);
				tp2.setFontAndSize(simBf, 8);
				// tp2.moveText(6, -6);
				tp2.showText(purchaseOrderDetail.getTt_xpyhddeto_partdesc());
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

	private static void exportHead(PdfContentByte underPdfContentByte, PdfContentByte cb, PurchaseOrder purchaseOrder,
			BaseFont dinBf, BaseFont simBf, BaseFont barCodeBf) throws DocumentException, IOException {
		// underPdfContentByte.addImage(backGroupImage);

		cb.beginText();
		cb.setFontAndSize(barCodeBf, 28);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "*"
				+ (purchaseOrder.getTt_xpyhmstro_yhdnbr() != null ? purchaseOrder.getTt_xpyhmstro_yhdnbr() : "") + "*",
				442, 767, 0);
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
