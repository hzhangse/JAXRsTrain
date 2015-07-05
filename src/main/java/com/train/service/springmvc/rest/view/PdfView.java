package com.train.service.springmvc.rest.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	public PdfView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Paragraph header = new Paragraph(new Chunk("PDF 输出测试"));
		document.add(header);
		document.add(new Paragraph("测试"));

	}

}
