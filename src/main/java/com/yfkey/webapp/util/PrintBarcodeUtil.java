package com.yfkey.webapp.util;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.yfkey.model.Barcode;

public class PrintBarcodeUtil {
	public static ByteArrayInputStream printBarcode(String localAbsolutPath, List<Barcode> barcodeList, String userCode)
			throws Exception {

		Rectangle pagesize = new Rectangle(226.771653f, 170.078740f);
		Document document = new Document(pagesize, 2f, 5f, 10f, 1f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			// step 2
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			// step 3
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			int i = 0;

			for (Barcode barcode : barcodeList) {
				if (i != 0) {
					document.newPage();
				}
				BaseFont baseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
				// Font font = FontFactory.getFont("Times-Roman");
				// Barcode128 code128 = new Barcode128();
				// code128.setCode(barcode.getTt_bcdeto_bcinfo1());
				// code128.setX(0.75f);
				// code128.setN(1.5f);
				// code128.setSize(0.0001f);
				// code128.setTextAlignment(Element.ALIGN_LEFT);
				// code128.setBaseline(1);
				// code128.setBarHeight(26f);
				// Image img = code128.createImageWithBarcode(cb, null, null);

				Barcode128 code128 = new Barcode128();
				code128.setCodeType(com.itextpdf.text.pdf.Barcode.CODE128);
				code128.setCode(barcode.getTt_bcdeto_bcinfo1());

				java.awt.Image img = code128.createAwtImage(Color.BLACK, Color.WHITE);
				Image itextImg = Image.getInstance(img, null);
				cb.addImage(itextImg, 150, 0, 0, 35, 50, 130);
				cb.stroke();
				// document.add(img);

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_bcnon(), 80, 120, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PART NO.", 10, 110, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_partnbr(), 35, 100, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "LOT/SERIAL NO.", 10, 90, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_lots(), 35, 80, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "QUANTITY", 145, 90, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(barcode.getTt_bcdeto_qty()), 145, 80, 0);
				cb.endText();

				// QRCODE
				if (barcode.getTt_bcdeto_bcinfo2() != null && !barcode.getTt_bcdeto_bcinfo2().trim().equals("")) {
					BarcodeQRCode qrcode = new BarcodeQRCode(barcode.getTt_bcdeto_bcinfo2(), 1, 1, null);
					Image img1 = qrcode.getImage();
					cb.addImage(img1, 40, 0, 0, 40, 140, 50);
					cb.stroke();
				}

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "DESCRIPTION ", 10, 70, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, barcode.getTt_bcdeto_partdesc(), 35, 60, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 7);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "SUPPLIER ", 10, 50, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
						barcode.getTt_bcdeto_suppname() == null ? "" : barcode.getTt_bcdeto_suppname(), 35, 40, 0);
				cb.endText();

				cb.beginText();
				cb.setFontAndSize(baseFont, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PRINTED DATE: " + barcode.getTt_bcdeto_date(), 10, 10,
						0);
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "PRINTED USER: " + userCode, 110, 10, 0);
				cb.endText();

				i++;
			}

		} catch (Exception e) {
			throw e;
		} finally {
			document.close();
			return new ByteArrayInputStream(baos.toByteArray());
		}

	}
}
