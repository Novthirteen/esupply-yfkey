package com.yfkey.webapp.util;

import java.awt.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.yfkey.model.Bill;
import com.yfkey.model.BillDetail;

public class PrintBillUtil {
	public static ByteArrayInputStream PrintBill(String localAbsolutPath, String template,Bill bill) throws IOException, DocumentException 
	{
		String templateUrl = localAbsolutPath + File.separator + "template" + File.separator + "pdf" + File.separator;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			PdfReader reader = new PdfReader(templateUrl+template); 
			Document document = new Document(reader.getPageSize(1));
			//ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			PdfImportedPage tempPage = writer.getImportedPage(reader, 1);	
			
	
			BaseFont baseFont = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",BaseFont.EMBEDDED);  
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			int max= bill.getBillDetailList().size();
			int lineCount = 26;
	        int pageCount = (int)Math.ceil((double)max/lineCount);
	        int pageNum = 1;
			fillHeader(cb,baseFont,tempPage,pageNum,pageCount,bill);
	        
	        float height = 14.7f;
	        float baseDetailHeight = 411;
	        for(int i=0; i<max;i++)
	        {
	        	BillDetail billDetail = bill.getBillDetailList().get(i);
	        	cb.beginText();
	        	cb.setFontAndSize(baseFont, 8);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, bill.getTt_suppcodei_suppcode()== null?"":bill.getTt_suppcodei_suppcode(), 26, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, billDetail.getTt_xpyhddeto_partnbr() == null?"":billDetail.getTt_xpyhddeto_partnbr(), 93, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, billDetail.getTt_xpyhddeto_voucher() == null?"": billDetail.getTt_xpyhddeto_voucher(), 165, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(billDetail.getTt_xpyhddeto_seq()), 232, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(billDetail.getTt_xpyhddeto_rcqty()), 260, baseDetailHeight-height*(i%lineCount), 0);
	        	//cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(i+1), 345, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(billDetail.getTt_xpyhddeto_poprice()), 298, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, billDetail.getTt_xpyhddeto_uom()== null?"":billDetail.getTt_xpyhddeto_uom(), 355, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(billDetail.getTt_xpyhddeto_invprice()), 414, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(billDetail.getTt_xpyhddeto_invamt()), 474, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, billDetail.getTt_xpyhddeto_partdesc()== null?"":billDetail.getTt_xpyhddeto_partdesc(), 504, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, billDetail.getTt_xpyhddeto_receiver()== null?"": billDetail.getTt_xpyhddeto_receiver(), 686, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_LEFT, billDetail.getTt_xpyhddeto_rcdate()== null?"":billDetail.getTt_xpyhddeto_rcdate(), 765, baseDetailHeight-height*(i%lineCount), 0);
	        	
	        	
	        	cb.endText();
	        	
	        	if((i+1)%lineCount == 0 && i != max-1)
	        	{
	                document.newPage();
	                pageNum++;
	                fillHeader(cb,baseFont,tempPage,pageNum,pageCount,bill);
	        	}

	        }
			document.close();
			

			return new ByteArrayInputStream(outputStream.toByteArray());
	    }
	
		public static PdfContentByte fillHeader(PdfContentByte cb,BaseFont baseFont,PdfImportedPage tempPage, int pageNum, int pageCount,Bill bill)throws DocumentException, IOException
		{
		
			cb.addTemplate(tempPage,0,0);
			cb.beginText();
			cb.setFontAndSize(baseFont, 9);
			cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "No/Nb: "+String.valueOf(pageNum)+"/"+String.valueOf(pageCount), 780, 570, 0);
			if(pageNum == pageCount)
			{
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "采购员:", 135, 28.8f, 0);
				cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "主管:", 363, 28.8f, 0);
				cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "合计发票金额:", 644, 28.8f, 0);
				cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(bill.getTt_xprcmstro_totalamt()), 704, 28.8f, 0);
			}
			/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			cb.beginText();
			cb.setFontAndSize(baseFont, 11);
			cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(pageNum)+"/"+String.valueOf(pageCount), 300, 820, 0);
			cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Print Date: "+df.format(new Date()), 300, 20, 0);
			
			cb.setFontAndSize(baseFont, 7.5f);
			Barcode128 code128 = new Barcode128();
	        code128.setCode("ASN00000001");
	        code128.setSize(8f);
	        code128.setTextAlignment(Element.ALIGN_CENTER);
	        code128.setBaseline(10f);
	        //code128.setBarHeight(26f);
	        Image img = code128.createImageWithBarcode(cb, null, null);
	        cb.addImage(img, 120, 0, 0, 36, 420, 758);
	        //cb.stroke();
	        
	        //外部单据号
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "EXTNO00000001", 140, 727, 0);
	        //ASN
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "ASNNO00000001", 422, 727, 0);
	        //供应商代码
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUP0000000001", 140, 713, 0);
	        //收货日期
	        
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 422, 713, 0);
	        //供应商名称
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUPPLIER SAMPLE", 140, 699, 0);
	        //收货部门
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "采购部", 422, 699, 0);
	        //承运商			
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "CYS01", 140, 685, 0);
	        //收货地点
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "上海市浦东康桥工业区秀浦路426号", 422, 685, 0);
	        
	        //供应商名称
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "XXXXXXXXXXXX", 140, 671, 0);
	        //收货部门
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "XXXXXXXXXXXX部", 422, 671, 0);
	        //供应商名称
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "XXXXXXXXXXXX", 140, 657, 0);
	        //收货部门
	        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "XXXXXXXXXXXX部", 422, 657, 0);
	        cb.endText();*/
			cb.endText();
	        return cb;
		}
}
