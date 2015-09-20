package com.yfkey.webapp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class PrintASNUtil {
	public static ByteArrayInputStream PrintASN(String localAbsolutPath, String template) throws IOException, DocumentException 
	{
		String templateUrl = localAbsolutPath + File.separator + "template" + File.separator + "pdf" + File.separator;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try
		{
			PdfReader reader = new PdfReader(templateUrl+template); 
			Document document = new Document(reader.getPageSize(1));
			//ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			PdfImportedPage tempPage = writer.getImportedPage(reader, 1);	
			
	
			BaseFont baseFont = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",BaseFont.EMBEDDED);  
			
			int max= 100;
			int lineCount = 35;
	        int pageCount = (int)Math.ceil((double)max/lineCount);
	        int pageNum = 1;
			fillHeader(cb,baseFont,tempPage,pageNum,pageCount);
	        
	        float height = 16f;
	        float baseDetailHeight = 615;
	        for(int i=0; i<max;i++)
	        {
	        	cb.beginText();
	        	cb.setFontAndSize(baseFont, 8);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "ORD0000001", 36, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(i+1), 84, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Item000000"+String.valueOf(i+1), 117, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "RefItem000"+String.valueOf(i+1), 165, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "零件描述"+String.valueOf(i+1), 228, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "单位", 308, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*10), 344, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*10), 384, baseDetailHeight-height*(i%lineCount), 0);
	        	
	        	
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
			
		}
		catch(Exception e)
		{
			throw e;
		}
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
        cb.endText();
		
        return cb;
	}
}
