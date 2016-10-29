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
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.exception.SupplierAuthorityException;
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;
import com.yfkey.model.PermissionType;
import com.yfkey.model.PurchaseOrder;
import com.yfkey.model.PurchaseOrderDetail;
import com.yfkey.model.Payment;

import com.yfkey.webapp.util.QADUtil;

/**
 * Action for facilitating Role Management feature.
 */
public class PaymentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4394103711224042955L;
	private List<Payment> payments;
	private Payment payment;

	
	
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * Fetch all payments from database and put into local "payments" variable
	 * for retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		if (payment == null) {
			payment = new Payment();
		
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Date date=new Date();
			
			Calendar fca=Calendar.getInstance();
			fca.setTime(date);
			fca.add(Calendar.MONTH, 0);
			fca.set(Calendar.DAY_OF_MONTH, 1);  
			String fromDate = sdf.format(fca.getTime());
			
			Calendar tca=Calendar.getInstance();
			tca.setTime(date);
			tca.add(Calendar.MONTH, 1);
			tca.set(Calendar.DAY_OF_MONTH, 0);  
			String toDate = sdf.format(tca.getTime());
			
			payment.setTt_payment_fromdate(fromDate);
			payment.setTt_payment_todate(toDate);
		}
		
		
		if(payment.getTt_payment_sp() != null && !payment.getTt_payment_sp().equals("")){
			String suppcode = payment.getTt_payment_sp();
			if(suppcode.contains("(")){
				payment.setTt_payment_sp(suppcode.substring(0,suppcode.indexOf("(")));
			}
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
				List<String> supplierCodeList = getSupplierCodeList(
						payment != null ? payment.getTt_payment_sp() : "");
				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_payment_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_payment_in");
					if (payment != null) {
						objectMstr.setString(0,
								payment.getTt_payment_payrf() == null ? "" : payment.getTt_payment_payrf().trim());
						objectMstr.setString(1,
								payment.getTt_payment_rf() == null ? "" : payment.getTt_payment_rf().trim());
						objectMstr.setString(2,
								payment.getTt_payment_curr() == null ? "" : payment.getTt_payment_curr().trim());
						objectMstr.setString(3,
								payment.getTt_payment_status() == null ? "" : payment.getTt_payment_status().trim());
						objectMstr.setString(4,
								payment.getTt_payment_entity() == null ? "" : payment.getTt_payment_entity().trim());
						objectMstr.setString(5,
								payment.getTt_payment_sp() == null ? "" : payment.getTt_payment_sp().trim());
						objectMstr.setString(6, 
								payment.getTt_payment_fromdate() == null ? "" : payment.getTt_payment_fromdate().trim());
						objectMstr.setString(7, 
								payment.getTt_payment_todate() == null ? "" : payment.getTt_payment_todate().trim());

					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_payment(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_prhmstr_out");

					payments = QADUtil.ConvertToPayment(outDataList);
				} catch (Exception e) {
					e.printStackTrace();
				}


		}

	}

}
