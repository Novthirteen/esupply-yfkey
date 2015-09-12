package com.yfkey.webapp.action;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.progress.open4gl.Parameter;
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.model.PurchaseOrderDetail;

/**
 * Action for facilitating Role Management feature.
 */
public class BarcodeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8920999609104602879L;

	private List<PurchaseOrderDetail> purchaseOrderDetails;
	private PurchaseOrderDetail purchaseOrderDetail;

	private InputStream inputStream;
	private String fileName;

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public InputStream getInputStream() throws FileNotFoundException {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
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

	private void query() {

		// purchaseOrderDetails = new ArrayList<PurchaseOrderDetail>();

		// PurchaseOrderDetail podet = new PurchaseOrderDetail();
		// podet.setTt_xpyhddeto_seq(new BigDecimal(20));
		// podet.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet.setTt_xpyhddeto_partnbr("1000001");
		// podet.setTt_xpyhddeto_partdesc("螺丝");
		// podet.setTt_xpyhddeto_spq(new BigDecimal(100));
		// podet.setTt_xpyhddeto_uom("件");
		// podet.setTt_xpyhddeto_innnerqty(new BigDecimal(100));
		// podet.setTt_xpyhddeto_externalqty(new BigDecimal(200));
		// podet.setTt_xpyhddeto_pktype("纸箱");
		// purchaseOrderDetails.add(podet);
		//
		// PurchaseOrderDetail podet1 = new PurchaseOrderDetail();
		// podet1.setTt_xpyhddeto_seq(new BigDecimal(20));
		// podet1.setTt_xpyhddeto_yhdnbr("ORD000001");
		// podet1.setTt_xpyhddeto_partnbr("1000002");
		// podet1.setTt_xpyhddeto_partdesc("螺母");
		// podet1.setTt_xpyhddeto_spq(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_uom("件");
		// podet1.setTt_xpyhddeto_innnerqty(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_externalqty(new BigDecimal(200));
		// podet1.setTt_xpyhddeto_pktype("纸箱");
		// purchaseOrderDetails.add(podet1);
		if (purchaseOrderDetail != null) {
		if (ConnectQAD()) {

			
				List<String> supplierCodeList = getSupplierCodeList(purchaseOrderDetail.getTt_xpyhddeto_suppcode());

				String domain = "YFKSS";
				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数
				try {
					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinquiry_xpyhddet_DSMetaData1());
					for (int i = 0; i < supplierCodeList.size(); i++) {
						ProDataObject object = exDataGraph.createProDataObject("tt_suppcode_in");
						String supCode = supplierCodeList.get(i);
						object.setString(0, domain);
						object.setString(1, supCode);

						exDataGraph.addProDataObject(object);
					}

					ProDataObject objectMstr = exDataGraph.createProDataObject("tt_xpyhddet_in");
					objectMstr.setString(0, domain);

					if (purchaseOrderDetail != null) {

						objectMstr.setString(1, purchaseOrderDetail.getTt_xpyhddeto_yhdnbr());
						objectMstr.setString(2, purchaseOrderDetail.getTt_xpyhddeto_shipto());
						objectMstr.setString(3, purchaseOrderDetail.getTt_xpyhddeto_partnbr());
						objectMstr.setString(4, purchaseOrderDetail.getTt_xpyhddeto_supppart());

					}
					objectMstr.setString(0, domain);

					exDataGraph.addProDataObject(objectMstr);

					yfkssScp.xxinquiry_xpyhddet(exDataGraph, outputData);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

	public String print() throws Exception {
		String localAbsolutPath = this.getSession().getServletContext().getRealPath("/");

		try 
	    {
	    	Rectangle pagesize = new Rectangle(226.771653f,170.078740f);
	        Document document = new Document(pagesize, 2f, 5f, 10f, 1f);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        
	        // step 2
	        PdfWriter writer = PdfWriter.getInstance(document, baos);
	        // step 3
	        document.open();
	        
			 PdfContentByte cb = writer.getDirectContent();
			 	Font font = FontFactory.getFont("Times-Roman");
		        Barcode128 code128 = new Barcode128();
		        code128.setCode("47000009320250F427100026");
		        //code128.setX(0.75f);
		        //code128.setN(1.5f);
		        code128.setSize(10f);
		        code128.setTextAlignment(Element.ALIGN_LEFT);
		        //code128.setBaseline(1);
		        //code128.setBarHeight(26f);
		        Image img = code128.createImageWithBarcode(cb, null, null);
		        cb.addImage(img, 150, 0, 0, 35, 50, 120);
		        cb.stroke();
		        //document.add(img);
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 7);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PART NO.", 10, 120, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 8);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "47000009320250", 35, 110, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 7);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "LOT/SERIAL NO.", 10, 100, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 8);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "F512", 35, 90, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 7);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "QUANTITY", 145, 100, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 8);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "1000", 145, 90, 0);
		        cb.endText();
		        
		        //QRCODE
		        BarcodeQRCode qrcode = new BarcodeQRCode("yfkey", 1, 1, null);
		        Image img1 = qrcode.getImage();
		        cb.addImage(img1, 40, 0, 0, 40, 150, 50);
		        cb.stroke();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 7);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "DESCRIPTION ", 10, 80, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 8);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "MODEL Z", 35, 70, 0);
		        cb.endText();
		        
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 7);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUPPLIER ", 10, 60, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 8);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "YFKSS KNXOWHILLE", 35, 50, 0);
		        cb.endText();
		        
		        cb.beginText();
		        cb.setFontAndSize(font.getBaseFont(), 8);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PRINTED DATE: 09/12/15", 10, 10, 0);
		        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PRINTED USER:38846", 110, 10, 0);
		        cb.endText();
	        
	        document.close(); 
	        HttpServletResponse response = this.getResponse();
	        ServletOutputStream outputStream = response.getOutputStream() ; 
	        baos.writeTo(outputStream); 
	        response.setHeader("Content-Disposition", "attachment; filename=\"barcode.pdf\""); 
	        response.setContentType("application/pdf"); 
	        outputStream.flush(); 
	        outputStream.close(); 
	    }
	    catch (Exception e) {
	        //catch
	    }

		//fileName = "purchaseOrder_" + purchaseOrderDetail.getTt_xpyhddeto_yhdnbr() + ".pdf";
		return SUCCESS;
	}

}
