package com.yfkey.webapp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.itextpdf.text.pdf.PdfWriter;
import com.yfkey.model.Asn;
import com.yfkey.model.AsnDetail;

public class PrintASNUtil {
	public static ByteArrayInputStream PrintASN(String localAbsolutPath, String template,Asn asn) throws IOException, DocumentException 
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
			
			int max= asn.getAsnDetailList().size();
			int lineCount = 35;
	        int pageCount = (int)Math.ceil((double)max/lineCount);
	        int pageNum = 1;
			fillHeader(cb,baseFont,tempPage,pageNum,pageCount,asn);
	        
	        float height = 16f;
	        float baseDetailHeight = 615;
	        for(int i=0; i<max;i++)
	        {
	        	AsnDetail asnDetail = asn.getAsnDetailList().get(i);
	        	cb.beginText();
	        	cb.setFontAndSize(baseFont, 8);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, asnDetail.getTt_xasndeto_yhdnbr() == null?"":asnDetail.getTt_xasndeto_yhdnbr(), 36, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(asnDetail.getTt_xasndeto_seq() == 0?i+1:asnDetail.getTt_xasndeto_seq() ), 84, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, asnDetail.getTt_xasndeto_partnbr() == null?"": asnDetail.getTt_xasndeto_partnbr(), 120, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, asnDetail.getTt_xasndeto_supppart() == null?"":asnDetail.getTt_xasndeto_supppart(), 165, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, asnDetail.getTt_xasndeto_partdesc() == null?"":asnDetail.getTt_xasndeto_partdesc(), 230, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, asnDetail.getTt_xasndeto_uom() == null?"":asnDetail.getTt_xasndeto_uom(), 308, baseDetailHeight-height*(i%lineCount), 0);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(asnDetail.getTt_xasndeto_spq()), 344, baseDetailHeight-height*(i%lineCount), 0);
	        	
	        	BigDecimal box = asnDetail.getTt_xasndeto_spq() == BigDecimal.ZERO?BigDecimal.ZERO:asnDetail.getTt_xasndeto_asnqty().divide(asnDetail.getTt_xasndeto_spq(),0,BigDecimal.ROUND_CEILING);
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(box), 394, baseDetailHeight-height*(i%lineCount), 0);
	        	
	        	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(asnDetail.getTt_xasndeto_asnqty()), 450, baseDetailHeight-height*(i%lineCount), 0);
	        	
	        	
	        	cb.endText();
	        	
	        	if((i+1)%lineCount == 0 && i != max-1)
	        	{
	                document.newPage();
	                pageNum++;
	                fillHeader(cb,baseFont,tempPage,pageNum,pageCount,asn);
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
	
	public static PdfContentByte fillHeader(PdfContentByte cb,BaseFont baseFont,PdfImportedPage tempPage, int pageNum, int pageCount,Asn asn)throws DocumentException, IOException
	{
		cb.addTemplate(tempPage,0,0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		cb.beginText();
		cb.setFontAndSize(baseFont, 11);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, String.valueOf(pageNum)+"/"+String.valueOf(pageCount), 300, 820, 0);
		cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Print Date: "+df.format(new Date()), 300, 20, 0);
		
		cb.setFontAndSize(baseFont, 7.5f);
		Barcode128 code128 = new Barcode128();
        code128.setCode(asn.getTt_xasnmstro_asnnbr());
        code128.setSize(8f);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        code128.setBaseline(10f);
        //code128.setBarHeight(26f);
        Image img = code128.createImageWithBarcode(cb, null, null);
        cb.addImage(img, 120, 0, 0, 36, 420, 758);
        //cb.stroke();
        
        cb.showTextAligned(PdfContentByte.ALIGN_CENTER, asn.getTt_xasnmstro_startdt(), 490, 747, 0);
        
        //供应商代码
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasnmstro_suppcode() == null?"":asn.getTt_xasnmstro_suppcode(), 140, 727, 0);
        //客户代码
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasnmstro_shipto() == null?"":asn.getTt_xasnmstro_shipto(), 422, 727, 0);
        //供应商名称
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasndeto_vendname() == null?"":asn.getTt_xasndeto_vendname(), 140, 713, 0);
        //客户名称
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasndeto_shipname() == null?"":asn.getTt_xasndeto_shipname(), 422, 713, 0);
        //供应商地址
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasndeto_vendaddr() == null?"":asn.getTt_xasndeto_vendaddr(), 140, 699, 0);
        //客户地址
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasndeto_shipaddr() == null?"":asn.getTt_xasndeto_shipaddr(), 422, 699, 0);
        //供应商联系人		
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasndeto_vendcontact() == null?"":asn.getTt_xasndeto_vendcontact(), 140, 685, 0);
        //交货道口
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "", 422, 685, 0);
        
        //供应商电话
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasndeto_vendphone() == null?"":asn.getTt_xasndeto_vendphone(), 140, 671, 0);
        //物流协调员
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "", 422, 671, 0);
        //供应商传真
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, asn.getTt_xasndeto_vendtax() == null?"":asn.getTt_xasndeto_vendtax(), 140, 657, 0);
        //客户电话
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "", 422, 657, 0);
        cb.endText();
		
        return cb;
	}
}
