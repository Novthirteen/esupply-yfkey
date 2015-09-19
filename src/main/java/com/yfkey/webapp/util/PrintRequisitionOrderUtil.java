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

public class PrintRequisitionOrderUtil {
	public static ByteArrayInputStream PrintRequisitionOrder(String localAbsolutPath, String template) throws IOException, DocumentException 
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
		int lineCount = 20;
        int pageCount = (int)Math.ceil((double)max/lineCount);
        int pageNum = 1;
		fillHeader(cb,baseFont,tempPage,pageNum,pageCount);
        
        float height = 24.3f;
        float baseDetailHeight = 584;
        for(int i=0; i<max;i++)
        {
        	cb.beginText();
        	cb.setFontAndSize(baseFont, 8);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(i+1), 51, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Item000000"+String.valueOf(i+1), 91, baseDetailHeight-height*(i%lineCount), 0);
        	//cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "ORD0000001", 156, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "RefItem000"+String.valueOf(i+1), 144, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "零件描述"+String.valueOf(i+1), 204, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "单位", 268, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*10), 294, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*10), 324, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*1000), 354, baseDetailHeight-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf((i+1)*1000), 398, baseDetailHeight-height*(i%lineCount), 0);
        	
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
		cb.setFontAndSize(baseFont, 9);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(pageNum)+"/"+String.valueOf(pageCount), 300, 820, 0);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Print Date: "+df.format(new Date()), 300, 20, 0);
		
		cb.setFontAndSize(baseFont, 8);
		Barcode128 code128 = new Barcode128();
        code128.setCode("ORD00000001");
        code128.setSize(10f);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        code128.setBaseline(10f);
        //code128.setBarHeight(26f);
        Image img = code128.createImageWithBarcode(cb, null, null);
        cb.addImage(img, 120, 0, 0, 46, 380, 748);
        //cb.stroke();
        
        //发出时间
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 412, 737, 0);
        
        //正常/紧急
        cb.setFontAndSize(baseFont, 10);
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "√", 288, 734, 0);
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "√", 288, 750, 0);
        
        
        cb.setFontAndSize(baseFont, 8);
        
        //供应商代码
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUP0000000001", 180, 717, 0);        
        //交货日期
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 380, 717, 0);
        
        //供应商名称
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "供应商11111", 180, 702, 0);        
        //窗口时间
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 380, 702, 0);
        
        //供应商地址
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "供应商11111", 180, 687, 0);        
        //交货道口
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 380, 687, 0);
        
        //供应商联系人
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "供应商11111", 180, 671, 0);        
        //物流协调员
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 380, 671, 0);
        
        //供应商电话
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "供应商11111", 180, 656, 0);        
        //YFK电话
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 380, 656, 0);

        //供应商传真
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "供应商11111", 180, 640, 0);        
        //YFK传真
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, df.format(new Date()), 380, 640, 0);
        
        
        cb.endText();
		
        return cb;
	}
}
