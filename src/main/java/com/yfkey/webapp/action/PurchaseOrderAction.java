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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
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
import com.yfkey.exception.BillConfirmNotValidException;
import com.yfkey.exception.QadException;
import com.yfkey.exception.ShipQtyNotValidException;
import com.yfkey.exception.SupplierAuthorityException;
import com.yfkey.exception.UserPasswordNotValidException;
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;
import com.yfkey.model.LabelValue;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.model.User;
import com.yfkey.model.UserAuthority;
import com.yfkey.model.UserPasswordLog;
import com.yfkey.webapp.util.PrintASNUtil;
import com.yfkey.webapp.util.PrintPurchaseOrderUtil;
import com.yfkey.webapp.util.QADUtil;
import com.yfkey.webapp.util.SecurityContextHelper;

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
	private List<PurchaseOrderDetail> forecastPurchaseOrderDetails;
	private PurchaseOrder purchaseOrder;
	private String tt_xpyhmstro_yhdnbr;
	private InputStream inputStream;
	private String fileName;
	private String tt_xpyhmstro_xpyhmstroid;

	private String tt_xpyhddeti_xpyhmstroid;
	private Boolean canConfirmOrder;
	private Boolean canCancelOrder;
	private Boolean canCloseOrder;

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

	public List<PurchaseOrderDetail> getForcastPurchaseOrderDetails() {
		return forecastPurchaseOrderDetails;
	}

	public void setForcastPurchaseOrderDetails(List<PurchaseOrderDetail> forecastPurchaseOrderDetails) {
		this.forecastPurchaseOrderDetails = forecastPurchaseOrderDetails;
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

	public Boolean getCanConfirmOrder() {
		return canConfirmOrder;
	}

	public void setCanConfirmOrder(Boolean canConfirmOrder) {
		this.canConfirmOrder = canConfirmOrder;
	}

	public Boolean getCanCancelOrder() {
		return canCancelOrder;
	}

	public void setCanCancelOrder(Boolean canCancelOrder) {
		this.canCancelOrder = canCancelOrder;
	}

	public Boolean getCanCloseOrder() {
		return canCloseOrder;
	}

	public void setCanCloseOrder(Boolean canCloseOrder) {
		this.canCloseOrder = canCloseOrder;
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

			
			
			PurchaseOrder p  = new PurchaseOrder();
			p.setTt_xpyhmstro_xpyhmstroid("100001");
			p.setTt_xpyhmstro_stat("2");
			p.setTt_xpyhmstro_yhdnbr("100001");
			canConfirmOrder = true;
			canCancelOrder = true;
			canCloseOrder = true;
			
//			if (tt_xpyhmstro_xpyhmstroid != null) {
//
//				// 鎸夐挳鏉冮檺
//				canConfirmOrder = false;
//				canCancelOrder = false;
//				canCloseOrder = false;
//				List<UserAuthority> userButtons = (List<UserAuthority>) SecurityContextHelper.getRemoteUserButtons();
//				if (userButtons != null && userButtons.size() > 0) {
//					for (UserAuthority u : userButtons) {
//						if (!canConfirmOrder && u.getAuthority().equals("ConfirmPurchaseOrder")) {
//							canConfirmOrder = true;
//						}
//						if (!canCancelOrder && u.getAuthority().equals("CancelPurchaseOrder")) {
//							canCancelOrder = true;
//						}
//						if (!canCloseOrder && u.getAuthority().equals("ClosePurchaseOrder")) {
//							canCloseOrder = true;
//						}
//					}
//				}
//
//				if (ConnectQAD()) {
//					String userCode = this.getRequest().getRemoteUser();
//					String domain = getCurrentDomain();
//					ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
//					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟
//
//					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xpyhddet_DSMetaData1());
//
//					ProDataObject object = exDataGraph.createProDataObject("tt_xpyhddet_in");
//
//					object.setString(0, tt_xpyhmstro_xpyhmstroid);
//					object.setString(1, ""); // 0涓烘墦鍗帮紝""涓烘煡璇�
//
//					exDataGraph.addProDataObject(object);
//
//					yfkssScp.xxview_xpyhddet(exDataGraph, outputData);
//
//					@SuppressWarnings("unchecked")
//					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
//							.getProDataObjects("tt_xpyhddet_out");
//					if (outDataList != null && outDataList.size() > 0) {
//						List<Object> objList = QADUtil.ConvertToPurchaseOrderAndDetail(outDataList);
//						purchaseOrder = (PurchaseOrder) objList.get(0);
//						purchaseOrderDetails = (List<PurchaseOrderDetail>) objList.get(1);
//
//						checkSupplier(purchaseOrder.getTt_xpyhmstro_suppcode());
//
//						// 鐘舵�鎻忚堪鍜屼紭鍏堢骇缈昏瘧涓�笅
//						purchaseOrder.setTt_xpyhmstro_stat_desc(
//								getPurchaseOrderStatus(purchaseOrder.getTt_xpyhmstro_stat()));
//						purchaseOrder.setTt_xpyhmstro_priority_desc(
//								getPurchaseOrderPriority(purchaseOrder.getTt_xpyhmstro_priority()));
//					}
//				}
//			} else {
//				purchaseOrder = new PurchaseOrder();
//			}

//		} catch (SupplierAuthorityException ex) {
//			addActionError(ex.getMessage());
//
//			purchaseOrder = new PurchaseOrder();
//			Date date = new Date();
//			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//			purchaseOrder.setTt_xpyhmstro_receptdt(df.format(date));
//			purchaseOrder.setIsDetail(false);
//
//			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	public String shipEdit() throws IOException {

		try {

			
			PurchaseOrder p  = new PurchaseOrder();
			p.setTt_xpyhmstro_xpyhmstroid("100001");
			p.setTt_xpyhmstro_stat("2");
			p.setTt_xpyhmstro_yhdnbr("100001");
		
			
//			if (tt_xpyhddeti_xpyhmstroid != null) {
//
//				if (ConnectQAD()) {
//
//					// // 鍏堟竻绌轰竴涓�
//					// if (purchaseOrder != null) {
//					// purchaseOrder = new PurchaseOrder();
//					// }
//					// if (purchaseOrderDetails != null) {
//					// purchaseOrderDetails.clear();
//					// }
//
//					ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
//					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟
//
//					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinqury_xpyhddet2_DSMetaData1());
//
//					ProDataObject object = exDataGraph.createProDataObject("tt_xpyhddet_in");
//
//					object.setString(0, tt_xpyhddeti_xpyhmstroid);
//
//					exDataGraph.addProDataObject(object);
//
//					yfkssScp.xxinqury_xpyhddet2(exDataGraph, outputData);
//
//					@SuppressWarnings("unchecked")
//					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
//							.getProDataObjects("tt_xpyhddet_out");
//
//					List<Object> objList = QADUtil.ConvertToShipPurchaseOrderAndDetail(outDataList);
//
//					if (purchaseOrder != null && purchaseOrder.getHasShipError() != null
//							&& purchaseOrder.getHasShipError()) {
//						purchaseOrder.setHasShipError(false);
//
//						List<PurchaseOrderDetail> oldPurchaseOrderDetails = (List<PurchaseOrderDetail>) objList.get(1);
//						for (PurchaseOrderDetail d : purchaseOrderDetails) {
//							for (PurchaseOrderDetail o : oldPurchaseOrderDetails) {
//								if (o.getTt_xpyhddeto_xpyhddetoid().equals(d.getTt_xpyhddeto_xpyhddetoid())) {
//									d.setTt_xpyhddeto_seq(o.getTt_xpyhddeto_seq());
//									d.setTt_xpyhddeto_partnbr(o.getTt_xpyhddeto_partnbr());
//									d.setTt_xpyhddeto_partdesc(o.getTt_xpyhddeto_partdesc());
//									d.setTt_xpyhddeto_supppart(o.getTt_xpyhddeto_supppart());
//									d.setTt_xpyhddeto_uom(o.getTt_xpyhddeto_uom());
//									d.setTt_xpyhddeto_spq(o.getTt_xpyhddeto_spq());
//									d.setTt_xpyhddeto_toloc(o.getTt_xpyhddeto_toloc());
//									d.setTt_xpyhddeto_openqty(o.getTt_xpyhddeto_openqty());
//									break;
//								}
//							}
//						}
//					} else {
//						purchaseOrder = (PurchaseOrder) objList.get(0);
//						purchaseOrderDetails = (List<PurchaseOrderDetail>) objList.get(1);
//						checkSupplier(purchaseOrder.getTt_xpyhmstro_suppcode());
//					}
//				}
//			} else {
//				purchaseOrder = new PurchaseOrder();
//			}
//
//		} catch (SupplierAuthorityException ex) {
//			addActionError(ex.getMessage());
//
//			purchaseOrder = new PurchaseOrder();
//			purchaseOrder.setTt_xpyhmstro_shipto("");
//			purchaseOrder.setTt_xpyhmstro_yhdnbr("");
//			purchaseOrder.setTt_xpyhmstro_stat("3");
//
//			return INPUT;
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
				ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xpyhmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhmstr_in");

				object.setString(0, purchaseOrder.getTt_xpyhmstro_xpyhmstroid());
				object.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
				object.setString(2, "6");

				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xpyhmstr(exDataGraph, outputData);
				List<Object> args = new ArrayList<Object>();
				args.add(purchaseOrder.getTt_xpyhmstro_yhdnbr());
				saveMessage(getText("purchaseorder.cancel.success", args));
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
				ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xpyhmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhmstr_in");

				object.setString(0, purchaseOrder.getTt_xpyhmstro_xpyhmstroid());
				object.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
				object.setString(2, "3");

				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xpyhmstr(exDataGraph, outputData);
				List<Object> args = new ArrayList<Object>();
				args.add(purchaseOrder.getTt_xpyhmstro_yhdnbr());
				saveMessage(getText("purchaseorder.confirm.success", args));
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

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xpyhmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhmstr_in");

				object.setString(0, purchaseOrder.getTt_xpyhmstro_xpyhmstroid());
				object.setString(1, String.valueOf(purchaseOrder.getTt_xpyhmstro_stat()));
				object.setString(2, "5");

				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xpyhmstr(exDataGraph, outputData);
				List<Object> args = new ArrayList<Object>();
				args.add(purchaseOrder.getTt_xpyhmstro_yhdnbr());
				saveMessage(getText("purchaseorder.close.success", args));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String ship() throws Exception {
		try {
			checkShipQty(purchaseOrderDetails);
			String userCode = this.getRequest().getRemoteUser();
			if (ConnectQAD()) {

				ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxcreate_xasndet_DSMetaData1());

				if (purchaseOrderDetails != null && purchaseOrderDetails.size() > 0) {
					for (PurchaseOrderDetail pod : purchaseOrderDetails) {
						if (new BigDecimal(pod.getTt_xpyhddeto_delvqty()).compareTo(BigDecimal.ZERO) == 1) {
							ProDataObject object = exDataGraph.createProDataObject("tt_xasndet_in");
							object.setString(0, pod.getTt_xpyhddeto_xpyhddetoid());
							object.setBigDecimal(1, new BigDecimal(pod.getTt_xpyhddeto_delvqty()));
							object.setString(2, purchaseOrder.getRemark());
							object.setString(3, pod.getLine_remark());
							object.setString(4, userCode);
							object.setString(5, "-1");
							object.setString(6, "-1");

							exDataGraph.addProDataObject(object);
						}
					}
				}

				yfkssScp.xxcreate_xasndet(exDataGraph, outputData);

				
				@SuppressWarnings("unchecked")
				List<ProDataObject> errotOutDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_err_out");

				if (errotOutDataList != null && errotOutDataList.size() > 0) {
					throw new QadException(getQadErrorMessage(errotOutDataList));
				}
				
				
				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xasndet_out");

				List<Object> args = new ArrayList<Object>();
				

				if (outDataList != null && outDataList.size() > 0) {
					ProDataObject p = outDataList.get(0);
					String asnNo = p.getString("tt_xasndeto_asnnbr");
					args.add(asnNo);
				}
				saveMessage(getText("ship.success", args));
			} else {
				purchaseOrder = new PurchaseOrder();
				
				
			}

		} catch (ShipQtyNotValidException ex) {
			addActionError(ex.getMessage());
			tt_xpyhddeti_xpyhmstroid = purchaseOrder.getTt_xpyhmstro_xpyhmstroid();
			purchaseOrder.setHasShipError(true);
			shipEdit();
			return INPUT;
		} catch (QadException ex) {
			addActionError(ex.getMessage());
			tt_xpyhddeti_xpyhmstroid = purchaseOrder.getTt_xpyhmstro_xpyhmstroid();
			purchaseOrder.setHasShipError(true);
			shipEdit();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
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
		
		purchaseOrders = new ArrayList<PurchaseOrder>();
		PurchaseOrder p  = new PurchaseOrder();
		p.setTt_xpyhmstro_xpyhmstroid("100001");
		p.setTt_xpyhmstro_yhdnbr("100001");
		p.setTt_xpyhmstro_stat("2");
		purchaseOrders.add(p);
		
//		if (purchaseOrder == null) {
//			purchaseOrder = new PurchaseOrder();
//			// Date date = new Date();
//			// SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//			// purchaseOrder.setTt_xpyhmstro_receptdt(df.format(date));
//			
//			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//			Date date = new Date();
//
//			Calendar fca = Calendar.getInstance();
//			fca.setTime(date);
//			fca.add(Calendar.WEEK_OF_MONTH, -1);
//			String fromDate = sdf.format(fca.getTime());
//
//			Calendar tca = Calendar.getInstance();
//			tca.setTime(date);
//			String toDate = sdf.format(tca.getTime());
//
//			purchaseOrder.setTt_xpyhmstro_startdt(fromDate);
//			purchaseOrder.setTt_xpyhmstri_enddt(toDate);
//			
//
//			purchaseOrder.setIsDetail(false);
//		}
//		// autocomplete瑕佸鐞嗕竴涓�
//		if (purchaseOrder.getTt_xpyhmstro_suppcode() != null && !purchaseOrder.getTt_xpyhmstro_suppcode().equals("")) {
//			String suppcode = purchaseOrder.getTt_xpyhmstro_suppcode();
//			if (suppcode.contains("(")) {
//				purchaseOrder.setTt_xpyhmstro_suppcode(suppcode.substring(0, suppcode.indexOf("(")));
//			}
//		}
//		if (purchaseOrder.getTt_xpyhmstro_shipto() != null && !purchaseOrder.getTt_xpyhmstro_shipto().equals("")) {
//			String shipto = purchaseOrder.getTt_xpyhmstro_shipto();
//
//			if (shipto.contains("(")) {
//				purchaseOrder.setTt_xpyhmstro_shipto(shipto.substring(0, shipto.indexOf("(")));
//			}
//		}
//		if (purchaseOrder.getTt_xpyhmstro_partnbr() != null && !purchaseOrder.getTt_xpyhmstro_partnbr().equals("")) {
//			String itemcode = purchaseOrder.getTt_xpyhmstro_partnbr();
//			if (itemcode.contains("(")) {
//				purchaseOrder.setTt_xpyhmstro_partnbr(itemcode.substring(0, itemcode.indexOf("(")));
//			}
//		}
//
//		// 鍏朵粬鍏ㄩ儴涓虹┖鎵嶇姸鎬佸�璧嬩负2锛�
//
//		if ((purchaseOrder.getTt_xpyhmstro_yhdnbr() == null || purchaseOrder.getTt_xpyhmstro_yhdnbr().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstro_priority() == null
//						|| purchaseOrder.getTt_xpyhmstro_priority().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstro_suppcode() == null
//						|| purchaseOrder.getTt_xpyhmstro_suppcode().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstro_creator() == null
//						|| purchaseOrder.getTt_xpyhmstro_creator().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstro_shipto() == null || purchaseOrder.getTt_xpyhmstro_shipto().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstro_startdt() == null
//						|| purchaseOrder.getTt_xpyhmstro_startdt().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstri_enddt() == null
//						|| purchaseOrder.getTt_xpyhmstri_enddt().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstro_receptdt() == null
//						|| purchaseOrder.getTt_xpyhmstro_receptdt().equals(""))
//				&& (purchaseOrder.getTt_xpyhmstro_partnbr() == null
//						|| purchaseOrder.getTt_xpyhmstro_partnbr().equals(""))) {
//			if (purchaseOrder.getTt_xpyhmstro_stat() == null || purchaseOrder.getTt_xpyhmstro_stat().equals("")) {
//				purchaseOrder.setTt_xpyhmstro_stat("2,3");
//			}
//		}
//
//		query();

		return SUCCESS;
	}

	public String shiplist() {

		purchaseOrders = new ArrayList<PurchaseOrder>();
		
		PurchaseOrder p  = new PurchaseOrder();
		p.setTt_xpyhmstro_xpyhmstroid("100001");
		p.setTt_xpyhmstro_stat("2");
		p.setTt_xpyhmstro_yhdnbr("100001");
	
		purchaseOrders.add(p);
		
//		if (purchaseOrder == null) {
//
//			purchaseOrder = new PurchaseOrder();
//			purchaseOrder.setTt_xpyhmstro_shipto("");
//			purchaseOrder.setTt_xpyhmstro_yhdnbr("");
//		}
//
//		if (purchaseOrder.getTt_xpyhmstro_shipto() != null && !purchaseOrder.getTt_xpyhmstro_shipto().equals("")) {
//			String shipto = purchaseOrder.getTt_xpyhmstro_shipto();
//
//			if (shipto.contains("(")) {
//				purchaseOrder.setTt_xpyhmstro_shipto(shipto.substring(0, shipto.indexOf("(")));
//			}
//		}
//
//		purchaseOrder.setTt_xpyhmstro_stat("3");
//
//		shipQuery();
		return SUCCESS;
	}

	public String cancel() {
		return CANCEL;
	}

	private void query() {

		if (purchaseOrder != null && purchaseOrder.getIsDetail()) {
			try {
				if (ConnectQAD()) {
					String userCode = this.getRequest().getRemoteUser();

					@SuppressWarnings("unchecked")
					List<String> supplierCodeList = getSupplierCodeList(
							purchaseOrder != null ? purchaseOrder.getTt_xpyhmstro_suppcode() : "");

					String domain = getCurrentDomain();
					ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

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
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			try {

				if (ConnectQAD()) {

					String userCode = this.getRequest().getRemoteUser();
					String domain = getCurrentDomain();
					@SuppressWarnings("unchecked")
					List<String> supplierCodeList = getSupplierCodeList(
							purchaseOrder != null ? purchaseOrder.getTt_xpyhmstro_suppcode() : "");

					ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

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
						objectMstr.setString(9, purchaseOrder.getTt_xpyhmstri_enddt() == null ? ""
								: purchaseOrder.getTt_xpyhmstri_enddt().trim());
					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_xpyhmstr(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xpyhmstr_out");

					purchaseOrders = QADUtil.ConverToPurchaseOrder(outDataList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private void shipQuery() {
		if (ConnectQAD()) {

			String userCode = this.getRequest().getRemoteUser();
			@SuppressWarnings("unchecked")
			List<String> supplierCodeList = getSupplierCodeList(
					purchaseOrder != null ? purchaseOrder.getTt_xpyhmstro_suppcode() : "");

			String domain = getCurrentDomain();

			ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
			ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟
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
					objectMstr.setString(9,"");

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

				ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xpyhddet_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xpyhddet_in");

				object.setString(0, purchaseOrder.getTt_xpyhmstro_xpyhmstroid());
				object.setString(1, "0"); // 0涓烘墦鍗帮紝""涓烘煡璇�

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

	public String forecastlist() {

		if (purchaseOrder == null) {

			purchaseOrder = new PurchaseOrder();

			purchaseOrder.setTt_xpyhmstro_shipto("");
			purchaseOrder.setTt_xpyhmstro_yhdnbr("");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();

			Calendar fca = Calendar.getInstance();
			fca.setTime(date);
			String fromDate = sdf.format(fca.getTime());

			Calendar tca = Calendar.getInstance();
			tca.setTime(date);
			tca.add(Calendar.WEEK_OF_MONTH, 2);
			String toDate = sdf.format(tca.getTime());

			purchaseOrder.setTt_xpyhmstro_fromdate(fromDate);
			purchaseOrder.setTt_xpyhmstro_enddate(toDate);

		}

		// 榛樿浼樺厛绾ч娴嬶紝鐘舵�涔熶负棰勬祴
		purchaseOrder.setTt_xpyhmstro_priority("0");
		purchaseOrder.setTt_xpyhmstro_stat("0");

		if (purchaseOrder.getTt_xpyhmstro_suppcode() != null && !purchaseOrder.getTt_xpyhmstro_suppcode().equals("")) {
			String suppcode = purchaseOrder.getTt_xpyhmstro_suppcode();
			if (suppcode.contains("(")) {
				purchaseOrder.setTt_xpyhmstro_suppcode(suppcode.substring(0, suppcode.indexOf("(")));
			}
		}
		if (purchaseOrder.getTt_xpyhmstro_shipto() != null && !purchaseOrder.getTt_xpyhmstro_shipto().equals("")) {
			String shipto = purchaseOrder.getTt_xpyhmstro_shipto();

			if (shipto.contains("(")) {
				purchaseOrder.setTt_xpyhmstro_shipto(shipto.substring(0, shipto.indexOf("(")));
			}
		}
		if (purchaseOrder.getTt_xpyhmstro_partnbr() != null && !purchaseOrder.getTt_xpyhmstro_partnbr().equals("")) {
			String itemcode = purchaseOrder.getTt_xpyhmstro_partnbr();
			if (itemcode.contains("(")) {
				purchaseOrder.setTt_xpyhmstro_partnbr(itemcode.substring(0, itemcode.indexOf("(")));
			}
		}

		forecastQuery();
		return SUCCESS;
	}

	private void forecastQuery() {
		if (ConnectQAD()) {

			String userCode = this.getRequest().getRemoteUser();
			@SuppressWarnings("unchecked")
			List<String> supplierCodeList = getSupplierCodeList(
					purchaseOrder != null ? purchaseOrder.getTt_xpyhmstro_suppcode() : "");

			String domain = getCurrentDomain();

			ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
			ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟
			try {

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_forecast_DSMetaData1());
				for (int i = 0; i < supplierCodeList.size(); i++) {
					ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
					String supCode = supplierCodeList.get(i);
					object.setString(0, domain);
					object.setString(1, supCode);

					exDataGraph.addProDataObject(object);
				}

				ProDataObject objectMstr = exDataGraph.createProDataObject("tt_forecast_in");
				if (purchaseOrder != null) {
					objectMstr.setString(0, purchaseOrder.getTt_xpyhmstro_suppcode() == null ? ""
							: purchaseOrder.getTt_xpyhmstro_suppcode());
					objectMstr.setString(1, purchaseOrder.getTt_xpyhmstro_shipto() == null ? ""
							: purchaseOrder.getTt_xpyhmstro_shipto());
					objectMstr.setString(2, purchaseOrder.getTt_xpyhmstro_fromdate() == null ? ""
							: purchaseOrder.getTt_xpyhmstro_fromdate());
					objectMstr.setString(3, purchaseOrder.getTt_xpyhmstro_partnbr() == null ? ""
							: purchaseOrder.getTt_xpyhmstro_partnbr());
					objectMstr.setString(4, purchaseOrder.getTt_xpyhmstro_enddate() == null ? ""
							: purchaseOrder.getTt_xpyhmstro_enddate());
				}

				exDataGraph.addProDataObject(objectMstr);

				yfkssScp.xxview_forecast(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_forecast_out");

				purchaseOrderDetails = QADUtil.ConvertToForecastPurchaseOrderDetail(outDataList);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public List<LabelValue> getPurchaseOrderStatusList() {
		List<LabelValue> purchaseOrderStatusList = new ArrayList<LabelValue>();
		purchaseOrderStatusList.add(new LabelValue("", getText("xpyh_status.Empty")));
		// purchaseOrderStatusList.add(new LabelValue("0",
		// getText("xpyh_status.Forecast")));
		// purchaseOrderStatusList.add(new LabelValue("1",
		// getText("xpyh_status.Create")));
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
		// case "0":
		// statusDesc = getText("xpyh_status.Forecast");
		// break;
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
		// purchaseOrderPriorityList.add(new LabelValue("0",
		// getText("xpyh_priority.Forecast")));
		purchaseOrderPriorityList.add(new LabelValue("1", getText("xpyh_priority.Normal")));
		purchaseOrderPriorityList.add(new LabelValue("2", getText("xpyh_priority.Urgent")));
		return purchaseOrderPriorityList;
	}

	public String getPurchaseOrderPriority(String priority) {
		String priorityDesc = "";
		switch (priority) {
		// case "0":
		// priorityDesc = getText("xpyh_priority.Forecast");
		// break;
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

	private void checkShipQty(List<PurchaseOrderDetail> purchaseOrderDetailList) throws ShipQtyNotValidException {
		
		Boolean allZero = true;
		for (PurchaseOrderDetail d : purchaseOrderDetailList) {
			List<Object> args = new ArrayList<Object>();

			try {
				BigDecimal delvqty = new BigDecimal(d.getTt_xpyhddeto_delvqty());

				if (delvqty instanceof BigDecimal == false) {
					args.add(String.valueOf(d.getTt_xpyhddeto_seq()));
					throw new ShipQtyNotValidException(getText("purchaseOrder.delvqty_format_error", args));
				}

				if (delvqty.compareTo(BigDecimal.ZERO) < 0) {
					args.add(String.valueOf(d.getTt_xpyhddeto_seq()));
					throw new ShipQtyNotValidException(getText("purchaseOrder.shipqty_less_than_zero", args));
				} 
				if (delvqty.compareTo(d.getTt_xpyhddeto_openqty()) > 0) {
					args.add(String.valueOf(d.getTt_xpyhddeto_seq()));
					throw new ShipQtyNotValidException(getText("purchaseOrder.openqty_less_than_shipqty", args));

				}
				if (delvqty.compareTo(BigDecimal.ZERO) == 1 && allZero) {
					allZero = false;
				}
			} catch (NumberFormatException e) {
				args.add(String.valueOf(d.getTt_xpyhddeto_seq()));
				throw new ShipQtyNotValidException(getText("purchaseOrder.delvqty_format_error", args));
			}

		}
		
		if (allZero) {
			throw new ShipQtyNotValidException(getText("purchaseOrder.delvqty_all_empty"));
		}

	}
}
