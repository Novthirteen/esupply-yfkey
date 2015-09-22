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
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.model.Receipt;
import com.yfkey.model.ReceiptDetail;
import com.yfkey.webapp.util.QADUtil;

/**
 * Action for facilitating Role Management feature.
 */
public class ReceiptAction extends BaseAction {

	private List<Receipt> receipts;
	private  List<ReceiptDetail> receiptDetails;
	private Receipt receipt;
	private String tt_prhmstri_receiver;
	private InputStream inputStream;
	private String fileName;

	public List<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}

	public  List<ReceiptDetail> getReceiptDetails() {
		return receiptDetails;
	}

	public  void setReceiptDetails(List<ReceiptDetail> receiptDetails) {
		this.receiptDetails = receiptDetails;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public String getTt_prhmstri_receiver() {
		return tt_prhmstri_receiver;
	}

	public void setTt_prhmstri_receiver(String tt_prhmstri_receiver) {
		this.tt_prhmstri_receiver = tt_prhmstri_receiver;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	/**
	 * Grab the receipt from the database based on the "receiptName" passed in.
	 *
	 * @return success if receipt found
	 * @throws IOException
	 *             can happen when sending a "forbidden" from
	 *             response.sendError()
	 */
	@SuppressWarnings("unchecked")
	public String edit() throws IOException {

		try {

			if (tt_prhmstri_receiver != null) {

				if (ConnectQAD()) {

					// 先清空一下
					if (receipt != null) {
						receipt = new Receipt();
					}
					if (receiptDetails != null) {
						receiptDetails.clear();
					}

					String userCode = this.getRequest().getRemoteUser();
					@SuppressWarnings("unchecked")
					List<String> supplierCodeList = getSupplierCodeList(
							receipt != null ? receipt.getTt_prhmstro_suppcode() : "");

					String domain = getCurrentDomain();
					ProDataGraph exDataGraph; // 输入参数
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinqury_prhdet_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject object = exDataGraph.createProDataObject("tt_prhdet_in");

					object.setString(0, tt_prhmstri_receiver);
					object.setString(1, "");
					object.setString(2, "");
					object.setString(3, "");
					object.setString(4, "");
					

					exDataGraph.addProDataObject(object);

					yfkssScp.xxinqury_prhdet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_prhdet_out");
					List<Object> objList = QADUtil.ConvertToReceiptAndDetail(outDataList);
					receipt = (Receipt) objList.get(0);
					receiptDetails = (List<ReceiptDetail>) objList.get(1);

				}
			} else {
				receipt = new Receipt();
				receiptDetails = new ArrayList<ReceiptDetail>();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * Fetch all receipts from database and put into local "receipts" variable
	 * for retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		if (receipt != null) {
			query();
		}
		return SUCCESS;
	}

	public String cancel() {
		return CANCEL;
	}

	private void query() {
		if (receipt != null && receipt.getIsDetail()) {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						receipt != null ? receipt.getTt_prhmstro_suppcode() : "");

				String domain = getCurrentDomain();
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {
					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinqury_prhdet_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_prhdet_in");

					if (receipt != null) {

						objectMstr.setString(0,
								receipt.getTt_prhmstro_receiver() == null ? "" : receipt.getTt_prhmstro_receiver());
						objectMstr.setString(1,
								receipt.getTt_prhmstri_fromdate() == null ? "" : receipt.getTt_prhmstri_fromdate());
						objectMstr.setString(2,
								receipt.getTt_prhmstri_todate() == null ? "" : receipt.getTt_prhmstri_todate());
						objectMstr.setString(3,
								receipt.getTt_prhmstri_yhdnbr() == null ? "" : receipt.getTt_prhmstri_yhdnbr());
						objectMstr.setString(4,
								receipt.getTt_prhmstri_partnbr() == null ? "" : receipt.getTt_prhmstri_partnbr());
					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinqury_prhdet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xpyhddet_out");

					receiptDetails = QADUtil.ConverToReceiptDetail(outDataList);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else {

			if (ConnectQAD()) {

				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						receipt != null ? receipt.getTt_prhmstro_suppcode() : "");
				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinqury_prhmstr_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_prhmstr_in");
					if (receipt != null) {
						objectMstr.setString(0,
								receipt.getTt_prhmstro_receiver() == null ? "" : receipt.getTt_prhmstro_receiver());
						objectMstr.setString(1,
								receipt.getTt_prhmstri_fromdate() == null ? "" : receipt.getTt_prhmstri_fromdate());
						objectMstr.setString(2,
								receipt.getTt_prhmstri_todate() == null ? "" : receipt.getTt_prhmstri_todate());
						objectMstr.setString(3,
								receipt.getTt_prhmstri_yhdnbr() == null ? "" : receipt.getTt_prhmstri_yhdnbr());
						objectMstr.setString(4,
								receipt.getTt_prhmstri_partnbr() == null ? "" : receipt.getTt_prhmstri_partnbr());

					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinqury_prhmstr(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_prhmstr_out");

					receipts = QADUtil.ConverToReceipt(outDataList);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// receipts = new ArrayList<Receipt>();
			// Receipt r = new Receipt();
			// r.setTt_prhmstro_receiver("REC000001");
			//
			// receipts.add(r);
		}

	}

	public String print() throws Exception {

		return SUCCESS;
	}

}
