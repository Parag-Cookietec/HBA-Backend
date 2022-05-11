package gov.ifms.edp.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPReportFileResponseDto;
import gov.ifms.edp.dto.EDPReportPageDetails;
import gov.ifms.edp.dto.EDPReportPdfHeaderDto;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.util.EDPReportConstant;
import gov.ifms.edp.util.EDPUtility;

@Service
public class EDPReporstPdfServiceImpl {

	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public EDPReportFileResponseDto getReportPdf(EDPReportPageDetails pageDetail, List<Object[]> response) throws CustomException {

		Font bodyFont = FontFactory.getFont(EDPReportConstant.ARIAL_FONT, 8, BaseColor.BLACK);
		Font font = FontFactory.getFont(Constant.ARIAL_FONT, 12, BaseColor.BLACK);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Document report = new Document(PageSize.A4.rotate(), 36, 60, 110, 60);
			PdfWriter writer = PdfWriter.getInstance(report, out);

			EDPReportPdfHeaderDto event = getEDPReportPdfHeaderDto(pageDetail.getMenuId(),font);
			writer.setPageEvent(event);
			report.open();

			// Add Text to PDF file ->
			getUserSelectedValueForReport(pageDetail,report);
			report.add(Chunk.NEWLINE);

			PdfPTable reportTbl = new PdfPTable(response.get(0).length);
			reportTbl.setHeaderRows(1);

			float[] columnWidths = getReportColumnWidths(pageDetail.getMenuId());
			reportTbl.setWidths(columnWidths);
			reportTbl.setWidthPercentage(100);

			reportTbl.setTotalWidth(PageSize.A4.getWidth());

			List<String> columnName = EDPUtility.getReportColumnNamesList(pageDetail.getMenuId());
			columnName.forEach(column->{
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(EDPReportConstant.ARIAL_FONT, 10, BaseColor.BLACK);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(column, headFont));
				reportTbl.addCell(header);
			});
			

			int index = 0;
			for(Object[] object : response) {
				index = index + 1;
				PdfPCell indexCell = new PdfPCell(new Phrase(String.valueOf(index), bodyFont));
				indexCell.setPaddingLeft(4);
				indexCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				indexCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				reportTbl.addCell(indexCell);
				for(int i=0;i < (object.length -1);i++){
					PdfPCell empName = new PdfPCell(new Phrase(
							object[i] != null ? EDPUtility.convertObjectToString(object[i]) : "", bodyFont));
					empName.setPaddingLeft(4);
					empName.setVerticalAlignment(Element.ALIGN_MIDDLE);
					empName.setHorizontalAlignment(Element.ALIGN_CENTER);
					reportTbl.addCell(empName);
				}
			}

			report.add(reportTbl);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, EDPReportConstant.ATTACHMENT_FILENAME 
					+ EDPUtility.getReportName(pageDetail.getMenuId()) 
					+ EDPReportConstant.PDF_EXTENSION);
			header.setContentLength(out.toByteArray().length);
			report.close();
			String re = EDPUtility.convertByteToBase64String(out.toByteArray());
			EDPReportFileResponseDto dto = new EDPReportFileResponseDto();
			dto.setBase64String(re);
			dto.setFileName(EDPUtility.getReportFileName(EDPUtility.getReportName(pageDetail.getMenuId()),EDPReportConstant.PDF_EXTENSION));
			return dto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}
	

	/**
	 * Gets the user selected key value for forward case ddo event report.
	 *
	 * @param pageDetail the page detail
	 * @param report the report
	 * @return the user selected key value for forward case ddo event report
	 * @throws DocumentException 
	 */
	public void getUserSelectedValueForReport(EDPReportPageDetails pageDetail, Document report) throws DocumentException {
		 Paragraph filterPara = new Paragraph(EDPUtility.getUserSearchFilterData(pageDetail));
         filterPara.setAlignment(Element.ALIGN_LEFT);
         report.add(filterPara);
	}
	
	/**
	 * Gets the EDP report pdf header dto.
	 *
	 * @param menuId the menu id
	 * @return the EDP report pdf header dto
	 * @throws CustomException 
	 */
	private EDPReportPdfHeaderDto getEDPReportPdfHeaderDto(Long menuId, Font font) throws CustomException {
		EDPMsOfficeDto dto = OAuthUtility.getCurrentUserOfficeFromToken();
		Chunk glue = new Chunk(new VerticalPositionMark());
		Paragraph p = new Paragraph(EDPReportConstant.REPORT_GENERATED_BY + EDPUtility.getUserNameForEdpReport());
		p.add(new Chunk(glue));
		p.add(new Phrase(EDPReportConstant.REPORT_GENERATED_DATETIME + Utils.getCurrentDateTime(),font));
		return new EDPReportPdfHeaderDto(EDPUtility.getReportName(menuId),dto.getOfficeNameDisp(),dto.getTalukaName(),dto.getDistrictName(),p);
	}

	/**
	 * Gets the report column widths.
	 *
	 * @param menuId the menu id
	 * @return the report column widths
	 * @throws CustomException the custom exception
	 */
	private float[] getReportColumnWidths(Long menuId) throws CustomException {
		if(EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_ID.equals(menuId)) {
			return EDPReportConstant.getRightsMappingColumnWidths();
		} else if (EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_MENU_ID.equals(menuId)) {
			return EDPReportConstant.getPostTransferSummaryReportColumnWidths();
		} else if (EDPReportConstant.REPORT_POST_HISTORY_MENU_ID.equals(menuId)) {
			return EDPReportConstant.getReportPostHistoryReportColumnWidths();
		} else if (EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID.equals(menuId)) {
			return EDPReportConstant.getOfficeSummaryReportColumnWidths();
		}
		throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
	}
	
	
}