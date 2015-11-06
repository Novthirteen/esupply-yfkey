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
import com.progress.open4gl.ProDataException;
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.exception.BillConfirmNotValidException;
import com.yfkey.exception.QadException;
import com.yfkey.exception.ShipQtyNotValidException;
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;
import com.yfkey.model.Bill;
import com.yfkey.model.BillDetail;
import com.yfkey.model.LabelValue;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.model.Receipt;
import com.yfkey.model.ReceiptDetail;
import com.yfkey.model.UserAuthority;
import com.yfkey.webapp.util.PrintBillUtil;
import com.yfkey.webapp.util.PrintPurchaseOrderUtil;
import com.yfkey.webapp.util.QADUtil;
import com.yfkey.webapp.util.SecurityContextHelper;

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
	
	private Boolean canConfirmBill;
	private Boolean canAgreeBill;
	private Boolean canRefuseBill;

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

	public Boolean getCanConfirmBill() {
		return canConfirmBill;
	}

	public void setCanConfirmBill(Boolean canConfirmBill) {
		this.canConfirmBill = canConfirmBill;
	}

	public Boolean getCanAgreeBill() {
		return canAgreeBill;
	}

	public void setCanAgreeBill(Boolean canAgreeBill) {
		this.canAgreeBill = canAgreeBill;
	}

	public Boolean getCanRefuseBill() {
		return canRefuseBill;
	}

	public void setCanRefuseBill(Boolean canRefuseBill) {
		this.canRefuseBill = canRefuseBill;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws IOException {

		try {

			if (tt_xprcmstro_xprcmstroid != null) {

				// 按钮权限
				canConfirmBill = false;
				canAgreeBill = false;
				canRefuseBill = false;
				List<UserAuthority> userButtons = (List<UserAuthority>) SecurityContextHelper.getRemoteUserButtons();
				if (userButtons != null && userButtons.size() > 0) {
					for (UserAuthority u : userButtons) {
						if (!canConfirmBill && u.getAuthority().equals("ConfirmBill")) {
							canConfirmBill = true;
						}
						if (!canAgreeBill && u.getAuthority().equals("AgreeBill")) {
							canAgreeBill = true;
						}
						if(!canRefuseBill && u.getAuthority().equals("RefuseBill"))
						{
							canRefuseBill = true;
						}
					}
				}
				
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

					if (outDataList != null && outDataList.size() > 0) {
						List<Object> objList = QADUtil.ConvertToBillAndDetail(outDataList);
						bill = (Bill) objList.get(0);
						billDetails = (List<BillDetail>) objList.get(1);

						bill.setTt_xprcmstro_stat_desc(getBillStatus(bill.getTt_xprcmstro_stat()));
					}
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

	public String confirm() throws Exception {
		try {
			//checkConfirmBill(bill);
			if (ConnectQAD()) {
				Update(bill, "4", "");
			}
			return SUCCESS;
//		} catch (BillConfirmNotValidException ex) {
//			addActionError(ex.getMessage());
//			edit();
//			return INPUT;
		}  catch (QadException ex) {
			addActionError(ex.getMessage());
			tt_xprcmstro_xprcmstroid = bill.getTt_xprcmstro_xprcmstroid();
			edit();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}
	}

	public String refuse() throws Exception {
		try {
			if (ConnectQAD()) {
				Update(bill, "3", "");
			}
			return SUCCESS;
		} catch (QadException ex) {
			addActionError(ex.getMessage());
			tt_xprcmstro_xprcmstroid = bill.getTt_xprcmstro_xprcmstroid();
			edit();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}
	
	}

	public String agree() throws Exception {
		try {
			if (ConnectQAD()) {
				Update(bill, "6", "");
			}
			return SUCCESS;
		}catch (QadException ex) {
			addActionError(ex.getMessage());
			tt_xprcmstro_xprcmstroid = bill.getTt_xprcmstro_xprcmstroid();
			edit();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}
	
	}


	public String print() {
		try {
			if (ConnectQAD()) {

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xprcdet_DSMetaData1());

				ProDataObject object = exDataGraph.createProDataObject("tt_xprcdet_in");

				object.setString(0, bill.getTt_xprcmstro_xprcmstroid());

				exDataGraph.addProDataObject(object);

				yfkssScp.xxinquiry_xprcdet(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xprcdet_out");

				if (outDataList != null && outDataList.size() > 0) {
					List<Object> objList = QADUtil.ConvertToBillAndDetail(outDataList);
					bill = (Bill) objList.get(0);
					billDetails = (List<BillDetail>) objList.get(1);
					bill.setBillDetailList(billDetails);
				}

				String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");
				inputStream = PrintBillUtil.PrintBill(localAbsolutPath, "Bill.pdf", bill);

				fileName = "bill_" + bill.getTt_xprcmstro_xprcmstroid() + ".pdf";

				Update(bill, bill.getTt_xprcmstro_stat(), "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	private void Update(Bill b, String status, String isPrint) throws ProDataException, Exception {
		String userCode = this.getRequest().getRemoteUser();

		ProDataGraph exDataGraph; // 输入参数
		ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

		
			exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxupdate_xprcmstr_DSMetaData1());

			ProDataObject object = exDataGraph.createProDataObject("tt_xprcmstr_in");

			// 提交状态同时提交信息
			if (status == "4") {
				object.setString(0, b.getTt_xprcmstro_xprcmstroid());
				object.setInt(1, b.getTt_xprcmstro_qty());
				object.setBigDecimal(2, bill.getTt_xprcmstro_taxamt());
				object.setString(3, bill.getTt_xprcmstro_invdate());
				object.setBigDecimal(4, bill.getTt_xprcmstro_notaxamt());
				object.setString(5, bill.getTt_xprcmstro_invnbr());
				object.setString(6, bill.getTt_xprcmstro_rmk());
				object.setString(7, status);
				object.setString(8, bill.getTt_xprcmstro_indexinvnbr());
				object.setString(9, isPrint); // ""为确认，0为打印
				object.setString(10, userCode);
				object.setBigDecimal(11, bill.getTt_xpyhddeto_disamt());
				object.setBigDecimal(12, bill.getTt_xprcmstro_claimamt());
			} 
			else if(status.equals("6"))
			{
				object.setString(0, b.getTt_xprcmstro_xprcmstroid());
				object.setInt(1, 0);
				object.setBigDecimal(2, bill.getTt_xprcmstro_taxamt());
				object.setString(3,"");
				object.setBigDecimal(4, bill.getTt_xprcmstro_notaxamt());
				object.setString(5, "");
				object.setString(6, "");
				object.setString(7, status);
				object.setString(8, "");
				object.setString(9, isPrint); // ""为确认，0为打印
				object.setString(10, userCode);
				object.setBigDecimal(11, bill.getTt_xpyhddeto_disamt());
				object.setBigDecimal(12, bill.getTt_xprcmstro_claimamt());
			}
			else {
				object.setString(0, b.getTt_xprcmstro_xprcmstroid());
				object.setInt(1, 0);
				object.setBigDecimal(2, BigDecimal.ZERO);
				object.setString(3, "");
				object.setBigDecimal(4, BigDecimal.ZERO);
				object.setString(5, "");
				object.setString(6, "");
				object.setString(7, status);
				object.setString(8, "");
				object.setString(9, isPrint); // ""为确认，0为打印
				object.setString(10, userCode);
				object.setBigDecimal(11,  BigDecimal.ZERO);
				object.setBigDecimal(12,  BigDecimal.ZERO);
			}

			exDataGraph.addProDataObject(object);

			yfkssScp.xxupdate_xprcmstr(exDataGraph, outputData);
			
			List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
					.getProDataObjects("tt_err_out");
			if(outDataList != null && outDataList.size()>0)
			{
				if(getRequest().getLocale().toString().equals("zh_CN"))
				{
				throw new QadException((String)outDataList.get(0).get("tt_erro_msg")); 
				}else{
					throw new QadException((String)outDataList.get(1).get("tt_erro_msg")); 
				}
			}
			
		

	}

	public String list() {
		if (bill == null) {
			bill = new Bill();
		}

		if (bill.getTt_xprcmstro_suppcode() != null && !bill.getTt_xprcmstro_suppcode().equals("")) {
			String suppcode = bill.getTt_xprcmstro_suppcode();

			if (suppcode.contains("(")) {
				bill.setTt_xprcmstro_suppcode(suppcode.substring(0, suppcode.indexOf("(")));
			}
		}
		if (bill.getTt_xprcmstro_stat() == null || bill.getTt_xprcmstro_stat().equals("")) {
			bill.setTt_xprcmstro_stat(("3,4,6"));
		}
		query();
		return SUCCESS;
	}

	public String cancel() {
		return CANCEL;
	}

	private void query() {

		if (ConnectQAD()) {

			String userCode = this.getRequest().getRemoteUser();
			@SuppressWarnings("unchecked")
			List<String> supplierCodeList = getSupplierCodeList(bill != null ? bill.getTt_xprcmstro_suppcode() : "");

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
					objectMstr.setString(0,
							bill.getTt_xprcmstro_voucher() == null ? "" : bill.getTt_xprcmstro_voucher().trim());
					objectMstr.setString(1,
							bill.getTt_xprcmstri_fromdate() == null ? "" : bill.getTt_xprcmstri_fromdate().trim());
					objectMstr.setString(2,
							bill.getTt_xprcmstri_todate() == null ? "" : bill.getTt_xprcmstri_todate().trim());
					objectMstr.setString(3, bill.getTt_xprcmstro_stat() == null ? "3,4,6" : bill.getTt_xprcmstro_stat());
				}

				exDataGraph.addProDataObject(objectMstr);

				yfkssScp.xxinquiry_xprcmstr(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tt_xprcmstr_out");

				bills = QADUtil.ConverToBill(outDataList);

				// 转换状态为中文
				for (Bill bill : bills) {
					bill.setTt_xprcmstro_stat_desc(getBillStatus(bill.getTt_xprcmstro_stat()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public List<LabelValue> getBillStatusList() {
		List<LabelValue> billStatusList = new ArrayList<LabelValue>();
		billStatusList.add(new LabelValue("", getText("xprc_status.Empty")));
//		billStatusList.add(new LabelValue("0", getText("xprc_status.Initial")));
//		billStatusList.add(new LabelValue("1", getText("xprc_status.Create")));
//		billStatusList.add(new LabelValue("2", getText("xprc_status.Cancel")));
		billStatusList.add(new LabelValue("3", getText("xprc_status.Submit")));
		billStatusList.add(new LabelValue("4", getText("xprc_status.Confirm")));
		billStatusList.add(new LabelValue("5", getText("xprc_status.Close")));
        billStatusList.add(new LabelValue("6", getText("xprc_status.InProcess")));
		return billStatusList;
	}

	public String getBillStatus(String status) {
		String statusDesc = "";
		switch (status) {
//		case "0":
//			statusDesc = getText("xprc_status.Initial");
//			break;
//		case "1":
//			statusDesc = getText("xprc_status.Create");
//			break;
//		case "2":
//			statusDesc = getText("xprc_status.Cancel");
//			break;
		case "3":
			statusDesc = getText("xprc_status.Submit");
			break;
		case "4":
			statusDesc = getText("xprc_status.Confirm");
			break;
		case "5":
			statusDesc = getText("xprc_status.Close");
			break;
		case "6":
			statusDesc = getText("xprc_status.InProcess");
			break;
		default:
			break;
		}

		return statusDesc;
	}

	
	private void checkConfirmBill(Bill bill) throws BillConfirmNotValidException {
		
		
			List<Object> args = new ArrayList<Object>();
		    if(bill.getTt_xprcmstro_invdate() == null || bill.getTt_xprcmstro_invdate().equals(""))
		    {
		    	throw new BillConfirmNotValidException(getText("bill.invdate_empty"));
		    }
		    
		    if(bill.getTt_xprcmstro_qty()== 0)
		    {
		    	throw new BillConfirmNotValidException(getText("bill.qty_empty"));
		    }
	}
}
