package com.yfkey.webapp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.yfkey.model.Receipt;
import com.yfkey.model.ReceiptDetail;

public class PrintReceiptUtil {
	
	public static ByteArrayInputStream PrintReceipt(String localAbsolutPath, String template,Receipt receipt) throws IOException, DocumentException 
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
		
		int max= receipt.getReceiptDetailList().size();
		int lineCount = 25;
        int pageCount = (int)Math.ceil((double)max/lineCount);
        int pageNum = 1;
		fillHeader(cb,baseFont,tempPage,pageNum,pageCount,receipt);
        
        float height = 20f;
        for(int i=0; i<max;i++)
        {
        	ReceiptDetail rd =  receipt.getReceiptDetailList().get(i);
        	cb.beginText();
        	cb.setFontAndSize(baseFont, 8);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, rd.getTt_prhdeto_yhdnbr() == null?"":rd.getTt_prhdeto_yhdnbr() , 86, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(rd.getTt_prhdeto_seq()), 126, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, rd.getTt_prhdeto_partnbr() == null?"":rd.getTt_prhdeto_partnbr(), 169, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, rd.getTt_prhdeto_suppcode() == null?"": rd.getTt_prhdeto_suppcode() , 238, 580-height*(i%lineCount), 0);
        	cb.endText();
        	
        	
        	PdfTemplate tp2 = cb.createTemplate(90, 60);
			tp2.beginText();
			tp2.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL_CLIP);
			tp2.setFontAndSize(baseFont, 7);
			tp2.showText(rd.getTt_prhdeto_partdesc() == null?"":rd.getTt_prhdeto_partdesc());
			tp2.endText();
			cb.addTemplate(tp2, 268, 580-height*(i%lineCount));
			
        	cb.beginText();
        	cb.setFontAndSize(baseFont, 8);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, rd.getTt_prhdeto_uom() == null?"":rd.getTt_prhdeto_uom(), 375, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(rd.getTt_prhdeto_spq() == BigDecimal.ZERO?BigDecimal.ZERO:rd.getTt_prhdeto_spq()), 395, 580-height*(i%lineCount), 0);
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(rd.getTt_prhdeto_delvqty() == BigDecimal.ZERO?BigDecimal.ZERO:rd.getTt_prhdeto_delvqty()), 430, 580-height*(i%lineCount), 0);
        	
        	//实收数和包装
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(rd.getTt_prhdeto_revdqty() == BigDecimal.ZERO?BigDecimal.ZERO:rd.getTt_prhdeto_revdqty()), 475, 580-height*(i%lineCount), 0);
        	
        	int pgCount = 0;
        	if(!rd.getTt_prhdeto_spq().equals(BigDecimal.ZERO))
        	{
        		pgCount = rd.getTt_prhdeto_revdqty().divide(rd.getTt_prhdeto_spq(),2).intValue();
        	}
        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(pgCount), 510, 580-height*(i%lineCount), 0);
        	
        	
        	cb.endText();
        	
        	if((i+1)%lineCount == 0 && i != max-1)
        	{
                document.newPage();
                pageNum++;
                fillHeader(cb,baseFont,tempPage,pageNum,pageCount,receipt);
        	}
        }
        //cb.endText();
        
        
		document.close();
		return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	public static PdfContentByte fillHeader(PdfContentByte cb,BaseFont baseFont,PdfImportedPage tempPage, int pageNum, int pageCount,Receipt receipt)throws DocumentException, IOException
	{
		cb.addTemplate(tempPage,0,0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		cb.beginText();
		cb.setFontAndSize(baseFont, 11);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(pageNum)+"/"+String.valueOf(pageCount), 300, 820, 0);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Print Date: "+df.format(new Date()), 300, 20, 0);
		
		cb.setFontAndSize(baseFont, 8);
		Barcode128 code128 = new Barcode128();
        code128.setCode(receipt.getTt_prhmstro_receiver());
        code128.setSize(10f);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        code128.setBaseline(10f);
        //code128.setBarHeight(26f);
        Image img = code128.createImageWithBarcode(cb, null, null);
        cb.addImage(img, 120, 0, 0, 46, 380, 694);
        //cb.stroke();
        
        
        
        //外部单据号
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "", 116, 683, 0);
        //ASN
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, receipt.getTt_prhmstro_asnnbr() == null?"" :receipt.getTt_prhmstro_asnnbr(), 360, 683, 0);
        //供应商代码
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, receipt.getTt_prhmstro_suppcode() == null?"" :receipt.getTt_prhmstro_suppcode(), 116, 668, 0);
        //收货日期
        
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, receipt.getTt_prhmstro_rcdate()== null?"" :receipt.getTt_prhmstro_rcdate(), 360, 668, 0);
        //供应商名称
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, receipt.getTt_prhdeto_vendname() == null?"":receipt.getTt_prhdeto_vendname(), 116, 653, 0);
        //收货部门
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "YFK_PCL", 360, 653, 0);
        //承运商			
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "", 116, 638, 0);
        //收货地点
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, receipt.getTt_prhdeto_shipaddr()== null?"" :receipt.getTt_prhdeto_shipaddr(), 360, 638, 0);
        
        
        
        //bottom
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, receipt.getTt_prhmstro_rcdate()== null?"" :receipt.getTt_prhmstro_rcdate(), 126, 80, 0);
        
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, receipt.getTt_prhmstro_rcuserid()== null?"" :receipt.getTt_prhmstro_rcuserid(), 310, 80, 0);
        
        
        cb.endText();
		
        return cb;
	}
	
}
