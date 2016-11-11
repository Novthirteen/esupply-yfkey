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
import com.yfkey.model.Invoice;

import com.yfkey.webapp.util.QADUtil;

/**
 * Action for facilitating Role Management feature.
 */
public class InvoiceAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1036404418958777838L;
	private List<Invoice> invoices;
	private Invoice invoice;


	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * Fetch all invoices from database and put into local "invoices" variable
	 * for retrieval in the UI.
	 *
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		if (invoice == null) {
			invoice = new Invoice();
		
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Date date=new Date();
			
			Calendar fca=Calendar.getInstance();
			fca.setTime(date);
			fca.add(Calendar.MONTH, -12);
			fca.set(Calendar.DAY_OF_MONTH, 1);  
			String fromDate = sdf.format(fca.getTime());
			
			Calendar tca=Calendar.getInstance();
			tca.setTime(date);
			tca.add(Calendar.MONTH, 1);
			tca.set(Calendar.DAY_OF_MONTH, 0);  
			String toDate = sdf.format(tca.getTime());
			
			invoice.setTt_cinvoice_fromdate(fromDate);
			invoice.setTt_cinvoice_todate(toDate);
		}
		
		
		if(invoice.getTt_cinvoice_sp() != null && !invoice.getTt_cinvoice_sp().equals("")){
			String suppcode = invoice.getTt_cinvoice_sp();
			if(suppcode.contains("(")){
				invoice.setTt_cinvoice_sp(suppcode.substring(0,suppcode.indexOf("(")));
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
						invoice != null ? invoice.getTt_cinvoice_sp() : "");
				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_cinvoice_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_cinvoice_in");
					if (invoice != null) {
						objectMstr.setString(0,
								invoice.getTt_cinvoice_sp() == null ? "" : invoice.getTt_cinvoice_sp().trim());
						objectMstr.setString(1,
								invoice.getTt_cinvoice_fromdate() == null ? "" : invoice.getTt_cinvoice_fromdate().trim());
						objectMstr.setString(2,
								invoice.getTt_cinvoice_todate() == null ? "" : invoice.getTt_cinvoice_todate().trim());
						objectMstr.setString(3,
								invoice.getTt_cinvoice_rf() == null ? "" : invoice.getTt_cinvoice_rf().trim());
						objectMstr.setString(4,
								invoice.getTt_cinvoice_curr() == null ? "" : invoice.getTt_cinvoice_curr().trim());
						objectMstr.setString(5,
								invoice.getTt_cinvoice_type() == null ? "" : invoice.getTt_cinvoice_type().trim());
						objectMstr.setString(6, 
								invoice.getTt_cinvoice_term() == null ? "" : invoice.getTt_cinvoice_term().trim());
						objectMstr.setString(7, 
								invoice.getTt_cinvoice_duedate() == null ? "" : invoice.getTt_cinvoice_duedate().trim());

					}

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_cinvoice(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tt_cinvoice_out");

					invoices = QADUtil.ConvertToInvoice(outDataList);
				} catch (Exception e) {
					e.printStackTrace();
				}


	}

	}

}
