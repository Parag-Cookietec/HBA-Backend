package gov.ifms.edp.dto;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.util.EDPReportConstant;

public class EDPReportPdfHeaderDto extends PdfPageEventHelper {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/** The font. */
	Font font = FontFactory.getFont(Constant.ARIAL_FONT, 10, BaseColor.BLACK);
	
	/** The body font. */
	Font bodyFont = FontFactory.getFont(EDPReportConstant.ARIAL_FONT, 8, BaseColor.BLACK);
	
	/** The report name. */
	String reportName;

	/** The office name. */
	String officeName;

	/** The taluka with district name. */
	String talukaWithDistrictName;

	/** The total. */
	PdfTemplate total;
	
	Paragraph paragraphFooter ;
	
	/**
	 * @return the paragraphFooter
	 */
	public Paragraph getParagraphFooter() {
		return paragraphFooter;
	}

	
	/**
	 * Gets the report name.
	 *
	 * @return the report name
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Gets the taluka with district name.
	 *
	 * @return the taluka with district name
	 */
	public String getTalukaWithDistrictName() {
		return talukaWithDistrictName;
	}

	/**
	 * @return the total
	 */
	public PdfTemplate getTotal() {
		return total;
	}

	@SuppressWarnings("unused")
	private EDPReportPdfHeaderDto() {
	}
	
	/**
	 * Instantiates a new EDP report pdf header dto.
	 *
	 * @param reportName the report name
	 * @param officeName the office name
	 * @param taluka the taluka
	 * @param district the district
	 */
	public EDPReportPdfHeaderDto(String reportName, String officeName, String taluka, String district, Paragraph paragraphFooter) {
		super();
		this.reportName = reportName;
		this.officeName = officeName;
		this.paragraphFooter = paragraphFooter;
		if(!StringUtils.isEmpty(taluka) && !StringUtils.isEmpty(district)) {			
			this.talukaWithDistrictName = taluka + Constant.COLON + district;
		} else if(!StringUtils.isEmpty(taluka)) {			
			this.talukaWithDistrictName = taluka ;
		} else if(!StringUtils.isEmpty(district)) {			
			this.talukaWithDistrictName = district;
		}
	}

	/**
	 * On close document.
	 *
	 * @param writer the writer
	 * @param document the document
	 */
	@Override
	public void onCloseDocument(PdfWriter writer, Document document) {
		ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(writer.getPageNumber())), 2,
				2, 0);
	}

	/**
	 * On open document.
	 *
	 * @param writer the writer
	 * @param document the document
	 */
	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		total = writer.getDirectContent().createTemplate(30, 16);
	}

	/**
	 * On end page.
	 *
	 * @param writer the writer
	 * @param document the document
	 */
	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		PdfPTable table = new PdfPTable(3);
		try {
			table.setWidths(new int[] { 24, 24, 2 });
			table.setTotalWidth(700);
			table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			table.addCell("");
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(String.format("Page %d of", writer.getPageNumber()));
			PdfPCell cell = new PdfPCell(Image.getInstance(total));
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);
			table.writeSelectedRows(0, -1, 34, 580, writer.getDirectContent());
			table.setKeepTogether(true);
			table.setSplitLate(true);
			PdfContentByte canvas = writer.getDirectContent();
				
			String userName = paragraphFooter.getChunks().get(0).getContent();
			String[] u1 = userName.split(",",2);
			
			if(writer.getPageNumber()==1) {
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,new Phrase(u1[0],bodyFont), 35, 50, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,new Phrase(u1[1],bodyFont), 89, 40, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT,new Phrase(paragraphFooter.getChunks().get(2).getContent(),bodyFont), 780, 50, 0);
			} else { 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,new Phrase(u1[0],bodyFont), 35, 38, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,new Phrase(u1[1],bodyFont), 89, 27, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT,new Phrase(paragraphFooter.getChunks().get(2).getContent(),bodyFont), 780, 38, 0);
			}
			ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(EDPReportConstant.REPORT_ELECTRONICALLY_TEXT,bodyFont), 400, 15, 0);
			if(!StringUtils.isEmpty(reportName))
				ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(reportName), 400, 550, 0);
			if(!StringUtils.isEmpty(officeName))
				ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(officeName,font), 400, 535, 0);
			if(!StringUtils.isEmpty(talukaWithDistrictName))
				ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(talukaWithDistrictName,font), 400, 520, 0);
		} catch (Exception de) {
			logger.error(de.getMessage(),de);
		}
	}

}