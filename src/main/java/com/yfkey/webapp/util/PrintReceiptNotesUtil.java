package com.yfkey.webapp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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

public class PrintReceiptNotesUtil {
	
	public static ByteArrayInputStream PrintReceiptNotes(String localAbsolutPath, String template) throws IOException, DocumentException 
	{
		String templateUrl = localAbsolutPath + File.separator + "template" + File.separator + "pdf" + File.separator;
		
		PdfReader reader = new PdfReader(templateUrl+template); 
		Document document = new Document(reader.getPageSize(1));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		document.open();
		PdfContentByte cb = writer.getDirectContent();
		PdfImportedPage tempPage = writer.getImportedPage(reader, 1);	
		

		BaseFont baseFont = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",BaseFont.EMBEDDED);  
		
		int max= 100;
		int lineCount = 25;
        int pageCount = (int)Math.ceil((double)max/lineCount);
        int pageNum = 1;
		fillHeader(cb,baseFont,tempPage,pageNum,pageCount);
        
        float height = 20f;
        for(int i=0; i<max;i++)
        {
        	cb.beginText();
        	cb.setFontAndSize(baseFont, 8);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "ORD0000001", 86, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(i+1), 126, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Item000000"+String.valueOf(i+1), 169, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "RefItem000"+String.valueOf(i+1), 238, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "零件描述"+String.valueOf(i+1), 288, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "单位", 372, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*10), 394, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*10), 420, 580-height*(i%lineCount), 0);
        	
        	
        	cb.endText();
        	
        	if((i+1)%lineCount == 0 && i != max-1)
        	{
                document.newPage();
                pageNum++;
                fillHeader(cb,baseFont,tempPage,pageNum,pageCount);
        	}
        }
        //cb.endText();
        
        
		document.close();
		return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	public static PdfContentByte fillHeader(PdfContentByte cb,BaseFont baseFont,PdfImportedPage tempPage, int pageNum, int pageCount)throws DocumentException, IOException
	{
		cb.addTemplate(tempPage,0,0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		cb.beginText();
		cb.setFontAndSize(baseFont, 11);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(pageNum)+"/"+String.valueOf(pageCount), 300, 820, 0);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Print Date: "+df.format(new Date()), 300, 20, 0);
		
		cb.setFontAndSize(baseFont, 8);
		Barcode128 code128 = new Barcode128();
        code128.setCode("REC00000001");
        code128.setSize(10f);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        code128.setBaseline(10f);
        //code128.setBarHeight(26f);
        Image img = code128.createImageWithBarcode(cb, null, null);
        cb.addImage(img, 120, 0, 0, 46, 380, 694);
        //cb.stroke();
        
        //外部单据号
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "EXTNO00000001", 116, 683, 0);
        //ASN
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "ASNNO00000001", 360, 683, 0);
        //供应商代码
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUP0000000001", 116, 668, 0);
        //收货日期
        
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 360, 668, 0);
        //供应商名称
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUPPLIER SAMPLE", 116, 653, 0);
        //收货部门
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "采购部", 360, 653, 0);
        //承运商			
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "CYS01", 116, 638, 0);
        //收货地点
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "上海市浦东康桥工业区秀浦路426号", 360, 638, 0);
        cb.endText();
		
        return cb;
	}
	
}
