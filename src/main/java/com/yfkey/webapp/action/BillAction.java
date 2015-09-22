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
import com.yfkey.model.Bill;
import com.yfkey.model.BillDetail;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.model.Receipt;
import com.yfkey.model.ReceiptDetail;
import com.yfkey.webapp.util.QADUtil;

/**
 * Action for facilitating Role Management feature.
 */
public class BillAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564824979970519304L;
	private List<Bill> bills;
	private List<BillDetail> billDetails;
	private Bill bill;
	private String tt_xprcmstro_xprcmstroid;
	
	private InputStream inputStream;
	private String fileName;
	
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getTt_xprcmstro_xprcmstroid() {
		return tt_xprcmstro_xprcmstroid;
	}

	public void setTt_xprcmstro_xprcmstroid(String tt_xprcmstro_xprcmstroid) {
		this.tt_xprcmstro_xprcmstroid = tt_xprcmstro_xprcmstroid;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}
	
	public List<Bill> getBills() {
		return bills;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}
	
	
	public String edit() throws IOException {

		try {

			if (tt_xprcmstro_xprcmstroid != null) {

				if (ConnectQAD()) {
					String userCode = this.getRequest().getRemoteUser();

					String domain = getCurrentDomain();
					ProDataGraph exDataGraph; // 输入参数
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xprcdet_DSMetaData1());

					ProDataObject object = exDataGraph.createProDataObject("tt_xprcdet_in");

					object.setString(0, tt_xprcmstro_xprcmstroid);

					exDataGraph.addProDataObject(object);

					yfkssScp.xxinquiry_xprcdet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xprcdet_out");

					List<Object> objList = QADUtil.ConvertToBillAndDetail(outDataList);
					bill = (Bill) objList.get(0);
					billDetails = (List<BillDetail>) objList.get(1);
				}
			} else {
				bill = new Bill();
				billDetails = new ArrayList<BillDetail>();
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

				
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xprcmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xprcmstr_in");

				object.setString(0, bill.getTt_xprcmstro_xprcmstroid() );
				object.setInt(1, bill.getTt_xprcmstro_qty());
				object.setBigDecimal(2,bill.getTt_xprcmstro_taxamt());
				object.setString(3,bill.getTt_xprcmstro_invdate());
				object.setBigDecimal(4,bill.getTt_xprcmstro_notaxamt());
			    object.setString(5,bill.getTt_xprcmstro_invnbr());
				object.setString(6, bill.getTt_xprcmstro_rmk());
			    object.setString(7,"0");
				object.setString(8, bill.getTt_xprcmstri_indexinvnbr());
				object.setString(9, ""); //""为确认，0为打印
				object.setString(10, userCode);


				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xprcmstr(exDataGraph, outputData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String refuse() {
		try {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();

				
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xprcmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xprcmstr_in");

				object.setString(0, bill.getTt_xprcmstro_xprcmstroid() );
				object.setInt(1, 0);
				object.setBigDecimal(2,BigDecimal.ZERO);
				object.setString(3,"");
				object.setBigDecimal(4,BigDecimal.ZERO);
			    object.setString(5,"");
				object.setString(6, "");
			    object.setString(7,"2");
				object.setString(8, "");
				object.setString(9, ""); //""为确认，0为打印
				object.setString(10, userCode);


				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xprcmstr(exDataGraph, outputData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String agree() {
		try {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();

				
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xprcmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xprcmstr_in");

				object.setString(0, bill.getTt_xprcmstro_xprcmstroid() );
				object.setInt(1, 0);
				object.setBigDecimal(2,BigDecimal.ZERO);
				object.setString(3,"");
				object.setBigDecimal(4,BigDecimal.ZERO);
			    object.setString(5,"");
				object.setString(6, "");
			    object.setString(7,"1");
				object.setString(8, "");
				object.setString(9, ""); //""为确认，0为打印
				object.setString(10, userCode);


				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xprcmstr(exDataGraph, outputData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String print() {
		try {
			if (ConnectQAD()) {
				String userCode = this.getRequest().getRemoteUser();

				
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xprcmstr_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xprcmstr_in");

				object.setString(0, bill.getTt_xprcmstro_xprcmstroid() );
				object.setInt(1, 0);
				object.setBigDecimal(2,BigDecimal.ZERO);
				object.setString(3,"");
				object.setBigDecimal(4,BigDecimal.ZERO);
			    object.setString(5,"");
				object.setString(6, "");
			    object.setString(7,"1");
				object.setString(8, "");
				object.setString(9, "0"); //""为确认，0为打印
				object.setString(10, userCode);


				exDataGraph.addProDataObject(object);

				yfkssScp.xxupdate_xprcmstr(exDataGraph, outputData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String list() {
		if (bill != null) {
			query();
		}
		return SUCCESS;
	}
	public String cancel() {
		return CANCEL;
	}

	private void query() {

		
			if (ConnectQAD()) {

				String userCode = this.getRequest().getRemoteUser();
				@SuppressWarnings("unchecked")
				List<String> supplierCodeList = getSupplierCodeList(
						bill != null ? bill.getTt_suppcodei_suppcode() : "");

				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xprcmstr_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xprcmstr_in");
					if (bill != null) {
						objectMstr.setString(0, bill.getTt_xprcmstro_voucher() == null?"":bill.getTt_xprcmstro_voucher() );
						objectMstr.setString(1, bill.getTt_xprcmstri_fromdate()== null?"":bill.getTt_xprcmstri_fromdate());
						objectMstr.setString(2, bill.getTt_xprcmstri_todate()== null?"": bill.getTt_xprcmstri_todate());
						
					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_xprcmstr(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_xprcmstr_out");

					bills = QADUtil.ConverToBill(outDataList);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
	}
}
