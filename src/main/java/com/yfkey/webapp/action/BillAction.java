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
import com.yfkey.exception.SupplierAuthorityException;
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

	private String tt_xprcmstro_type;
	private int rowNumber;

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

	public String getTt_xprcmstro_type() {
		return tt_xprcmstro_type;
	}

	public void setTt_xprcmstro_type(String tt_xprcmstro_type) {
		this.tt_xprcmstro_type = tt_xprcmstro_type;
	}

	public int getRowNumber() {
		return rowNumber++;
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
				if (tt_xprcmstro_type.equals("0") && userButtons != null && userButtons.size() > 0) {
					for (UserAuthority u : userButtons) {
						if (!canConfirmBill && u.getAuthority().equals("ConfirmBill")) {
							canConfirmBill = true;
						}
						if (!canAgreeBill && u.getAuthority().equals("AgreeBill")) {
							canAgreeBill = true;
						}
						if (!canRefuseBill && u.getAuthority().equals("RefuseBill")) {
							canRefuseBill = true;
						}
					}
				}

				if (ConnectQAD()) {
					ProDataGraph exDataGraph; // 输入参数
					ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

					if (tt_xprcmstro_type.equals("0")) {

						// 正常
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

							if (bill != null && bill.getHasError() != null && bill.getHasError()) {
								bill.setHasError(false);
							} else {
								bill = (Bill) objList.get(0);
								bill.setTt_xprcmstro_stat_desc(getBillStatus(bill.getTt_xprcmstro_stat()));
							}

							billDetails = (List<BillDetail>) objList.get(1);
							checkSupplier(bill.getTt_xprcmstro_suppcode());
						}
					} else {
						// 索赔
						exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_claimdet_DSMetaData1());
						ProDataObject object = exDataGraph.createProDataObject("tt_claimdet_in");
						object.setString(0, tt_xprcmstro_xprcmstroid);
						exDataGraph.addProDataObject(object);
						yfkssScp.xxinquiry_claimdet(exDataGraph, outputData);

						@SuppressWarnings("unchecked")
						List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
								.getProDataObjects("tt_claimdet_out");

						if (outDataList != null && outDataList.size() > 0) {
							List<Object> objList = QADUtil.ConvertToClaimBillAndDetail(outDataList);

							if (bill != null && bill.getHasError() != null && bill.getHasError()) {
								bill.setHasError(false);
							} else {
								bill = (Bill) objList.get(0);
								bill.setTt_xprcmstro_stat_desc(getBillStatus(bill.getTt_xprcmstro_stat()));
							}

							billDetails = (List<BillDetail>) objList.get(1);
							checkSupplier(bill.getTt_xprcmstro_suppcode());
						}
					}
				}
			} else {
				bill = new Bill();
				billDetails = new ArrayList<BillDetail>();
			}

		} catch (SupplierAuthorityException ex) {
			addActionError(ex.getMessage());

			bill = new Bill();

			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	public String confirm() throws Exception {
		try {
			checkConfirmBill(bill);
			if (ConnectQAD()) {
				Update(bill, "4", "");
			}
			saveMessage(getText("bill.confirm.success"));
			return SUCCESS;
		} catch (QadException ex) {
			addActionError(ex.getMessage());
			tt_xprcmstro_xprcmstroid = bill.getTt_xprcmstro_xprcmstroid();
			tt_xprcmstro_type = bill.getTt_xprcmstro_type();
			bill.setHasError(true);
			edit();
			return INPUT;
		} catch (BillConfirmNotValidException ex) {
			addActionError(ex.getMessage());
			tt_xprcmstro_xprcmstroid = bill.getTt_xprcmstro_xprcmstroid();
			tt_xprcmstro_type = bill.getTt_xprcmstro_type();
			bill.setHasError(true);
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
			saveMessage(getText("bill.refuse.success"));
			return SUCCESS;
		} catch (QadException ex) {
			addActionError(ex.getMessage());
			tt_xprcmstro_xprcmstroid = bill.getTt_xprcmstro_xprcmstroid();
			tt_xprcmstro_type = bill.getTt_xprcmstro_type();
			bill.setHasError(true);
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
			saveMessage(getText("bill.agree.success"));
			return SUCCESS;
		} catch (QadException ex) {
			addActionError(ex.getMessage());
			tt_xprcmstro_xprcmstroid = bill.getTt_xprcmstro_xprcmstroid();
			tt_xprcmstro_type = bill.getTt_xprcmstro_type();
			bill.setHasError(true);
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
			object.setInt(1, Integer.parseInt(b.getTt_xprcmstro_qty()));
			object.setBigDecimal(2, new BigDecimal(bill.getTt_xprcmstro_taxamt()));
			object.setString(3, bill.getTt_xprcmstro_invdate());
			object.setBigDecimal(4, new BigDecimal(bill.getTt_xprcmstro_notaxamt()));
			object.setString(5, bill.getTt_xprcmstro_invnbr());
			object.setString(6, bill.getTt_xprcmstro_rmk());
			object.setString(7, status);
			object.setString(8, bill.getTt_xprcmstro_indexinvnbr());
			object.setString(9, isPrint); // ""为确认，0为打印
			object.setString(10, userCode);
			object.setBigDecimal(11, new BigDecimal(bill.getTt_xpyhddeto_disamt()));
			object.setBigDecimal(12, bill.getTt_xprcmstro_claimamt());
		} else if (status.equals("6")) {
			object.setString(0, b.getTt_xprcmstro_xprcmstroid());
			object.setInt(1, 0);
			object.setBigDecimal(2, new BigDecimal(bill.getTt_xprcmstro_taxamt()));
			object.setString(3, "");
			object.setBigDecimal(4, new BigDecimal(bill.getTt_xprcmstro_notaxamt()));
			object.setString(5, "");
			object.setString(6, "");
			object.setString(7, status);
			object.setString(8, "");
			object.setString(9, isPrint); // ""为确认，0为打印
			object.setString(10, userCode);
			object.setBigDecimal(11, new BigDecimal(bill.getTt_xpyhddeto_disamt()));
			object.setBigDecimal(12, bill.getTt_xprcmstro_claimamt());
		} else {
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
			object.setBigDecimal(11, BigDecimal.ZERO);
			object.setBigDecimal(12, BigDecimal.ZERO);
		}

		exDataGraph.addProDataObject(object);

		yfkssScp.xxupdate_xprcmstr(exDataGraph, outputData);

		List<ProDataObject> errotOutDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
				.getProDataObjects("tt_err_out");
		if (errotOutDataList != null && errotOutDataList.size() > 0) {
			throw new QadException(getQadErrorMessage(errotOutDataList));
		}

	}

	public String list() {
		if (bill == null) {
			bill = new Bill();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();

			Calendar fca = Calendar.getInstance();
			fca.setTime(date);
			fca.add(Calendar.MONTH, -1);
			String fromDate = sdf.format(fca.getTime());

			Calendar tca = Calendar.getInstance();
			tca.setTime(date);
			String toDate = sdf.format(tca.getTime());

			bill.setTt_xprcmstri_fromdate(fromDate);
			bill.setTt_xprcmstri_todate(toDate);
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
					objectMstr.setString(3,
							bill.getTt_xprcmstro_stat() == null ? "3,4,6" : bill.getTt_xprcmstro_stat());
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

	public List<LabelValue> getBillStatusList() {
		List<LabelValue> billStatusList = new ArrayList<LabelValue>();
		billStatusList.add(new LabelValue("", getText("xprc_status.Empty")));
		// billStatusList.add(new LabelValue("0",
		// getText("xprc_status.Initial")));
		// billStatusList.add(new LabelValue("1",
		// getText("xprc_status.Create")));
		// billStatusList.add(new LabelValue("2",
		// getText("xprc_status.Cancel")));
		billStatusList.add(new LabelValue("3", getText("xprc_status.Submit")));
		billStatusList.add(new LabelValue("4", getText("xprc_status.Confirm")));
		billStatusList.add(new LabelValue("5", getText("xprc_status.Close")));
		billStatusList.add(new LabelValue("6", getText("xprc_status.InProcess")));
		return billStatusList;
	}

	public String getBillStatus(String status) {
		String statusDesc = "";
		switch (status) {
		// case "0":
		// statusDesc = getText("xprc_status.Initial");
		// break;
		// case "1":
		// statusDesc = getText("xprc_status.Create");
		// break;
		// case "2":
		// statusDesc = getText("xprc_status.Cancel");
		// break;
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
		if (bill.getTt_xprcmstro_invdate() == null || bill.getTt_xprcmstro_invdate().equals("")) {
			throw new BillConfirmNotValidException(getText("bill.invdate_empty"));
		}

		if (bill.getTt_xprcmstro_indexinvnbr() == null || bill.getTt_xprcmstro_indexinvnbr().equals("")) {
			throw new BillConfirmNotValidException(getText("bill.indexinvnbr_empty"));
		}

		try {
			Integer qty = Integer.parseInt(bill.getTt_xprcmstro_qty());

			if (qty instanceof Integer == false) {
				throw new BillConfirmNotValidException(getText("bill.qty_format_error"));
			}
			if (qty <= 0) {
				throw new BillConfirmNotValidException(getText("bill.qty_less_than_zero"));
			}
		} catch (NumberFormatException e) {
			throw new BillConfirmNotValidException(getText("bill.qty_format_error"));
		}

		try {
			BigDecimal notaxamt = new BigDecimal(bill.getTt_xprcmstro_notaxamt());

			if (notaxamt instanceof BigDecimal == false) {
				throw new BillConfirmNotValidException(getText("bill.notaxamt_format_error"));
			}
			if (notaxamt.compareTo(BigDecimal.ZERO) < 1) {
				throw new BillConfirmNotValidException(getText("bill.notaxamt_less_than_zero"));
			}
			if(!checkStr(bill.getTt_xprcmstro_notaxamt()))
			{
				throw new BillConfirmNotValidException(getText("bill.notaxamt_digits_more_than_two"));
			}
		} catch (NumberFormatException e) {
			throw new BillConfirmNotValidException(getText("bill.notaxamt_format_error"));
		}

		try {
			BigDecimal taxamt = new BigDecimal(bill.getTt_xprcmstro_taxamt());

			if (taxamt instanceof BigDecimal == false) {
				throw new BillConfirmNotValidException(getText("bill.taxamt_format_error"));
			}
			if (taxamt.compareTo(BigDecimal.ZERO) < 0) {
				throw new BillConfirmNotValidException(getText("bill.taxamt_less_than_zero"));
			}
			if(!checkStr(bill.getTt_xprcmstro_taxamt()))
			{
				throw new BillConfirmNotValidException(getText("bill.taxamt_digits_more_than_two"));
			}
		} catch (NumberFormatException e) {
			throw new BillConfirmNotValidException(getText("bill.taxamt_format_error"));
		}

		try {
			BigDecimal disamt = new BigDecimal(bill.getTt_xpyhddeto_disamt());

			if (disamt instanceof BigDecimal == false) {
				throw new BillConfirmNotValidException(getText("bill.disamt_format_error"));
			}
			if (disamt.compareTo(BigDecimal.ZERO) < 0) {
				throw new BillConfirmNotValidException(getText("bill.disamt_less_than_zero"));
			}
			if(!checkStr(bill.getTt_xpyhddeto_disamt()))
			{
				throw new BillConfirmNotValidException(getText("bill.disamt_digits_more_than_two"));
			}
		} catch (NumberFormatException e) {
			throw new BillConfirmNotValidException(getText("bill.disamt_format_error"));
		}

	}

	public static boolean checkStr(String s) {
		boolean isValiad = true;
		int index = s.lastIndexOf(".");// 寻找小数点的索引位置，若不是小数，则为-1
		if (index > -1) {
			int len = s.substring(index + 1).length();// 取得小数点后的数值，不包括小数点
			if (len > 2) {
				isValiad = false;
			}
		}
		return isValiad;

	}
}
