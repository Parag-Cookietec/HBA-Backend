package gov.ifms.edp.report.service;

import java.io.ByteArrayOutputStream;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.report.dto.CommonReportFileResponseDto;
import gov.ifms.edp.report.dto.CommonReportPageDetails;
import gov.ifms.edp.report.dto.CommonReportPdfHeaderDto;
import gov.ifms.edp.report.dto.CommonReportSearchParamDto;
import gov.ifms.edp.report.entity.CommonDesignMasterEntity;
import gov.ifms.edp.report.entity.CommonFieldMasterEntity;
import gov.ifms.edp.report.entity.CommonReportMasterEntity;
import gov.ifms.edp.report.util.CommonReportConstant;
import gov.ifms.edp.report.util.CommonReportUtil;

/**
 * The Class CommonReportPdfServiceImpl.
 */
@Service
public class CommonReportPdfServiceImpl {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CommonReportPdfServiceImpl.class);
	
	/**
	 * Gets the pdf report.
	 *
	 * @param pageDetails the page details
	 * @param response the response
	 * @param reportMasterEntity the report master entity
	 * @param designMasterEntityList the design master entity list
	 * @param fieldMasterEntityList the field master entity list
	 * @return the pdf report
	 * @throws CustomException the custom exception
	 */
	public CommonReportFileResponseDto getPdfReport(CommonReportPageDetails pageDetails, List<Object[]> response, 
			CommonReportMasterEntity reportMasterEntity, List<CommonDesignMasterEntity> designMasterEntityList, 
			List<CommonFieldMasterEntity> fieldMasterEntityList) throws CustomException {
		Font bodyFont = FontFactory.getFont(CommonReportConstant.ARIAL, 8, BaseColor.BLACK);
		Font font = FontFactory.getFont(CommonReportConstant.ARIAL, 12, BaseColor.BLACK);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			Document report = new Document(PageSize.A4.rotate(), 36, 60, 110, 60);
			PdfWriter writer = PdfWriter.getInstance(report, out);

			CommonReportPdfHeaderDto event = getReportPdfHeaderDto(font, designMasterEntityList);
			writer.setPageEvent(event);
			report.open();

			// Add Text to PDF file ->
			getUserSelectedValueForReport(fieldMasterEntityList, pageDetails, report);
			report.add(Chunk.NEWLINE);

			float[] columnWidths = getReportColumnWidths(fieldMasterEntityList);
			PdfPTable reportTbl = new PdfPTable(columnWidths.length);
			reportTbl.setHeaderRows(1);

			reportTbl.setWidths(columnWidths);
			reportTbl.setWidthPercentage(100);

			reportTbl.setTotalWidth(PageSize.A4.getWidth());

			List<String> columnHeadingNames = getReportColumnHeading(fieldMasterEntityList);
			columnHeadingNames.forEach(columnHeadingName -> {
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(CommonReportConstant.ARIAL, 10, BaseColor.BLACK);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(columnHeadingName, headFont));
				reportTbl.addCell(header);
			});

			int index = 0;
			for (Object[] object : response) {
				index = index + 1;
				PdfPCell indexCell = new PdfPCell(new Phrase(String.valueOf(index), bodyFont));
				indexCell.setPaddingLeft(4);
				indexCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				indexCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				reportTbl.addCell(indexCell);
				for (int i = 0; i < (object.length); i++) {
					PdfPCell empName = new PdfPCell(
							new Phrase(object[i] != null ? CommonReportUtil.convertObjectToString(object[i]) : "", bodyFont));
					empName.setPaddingLeft(4);
					empName.setVerticalAlignment(Element.ALIGN_MIDDLE);
					empName.setHorizontalAlignment(Element.ALIGN_CENTER);
					reportTbl.addCell(empName);
				}
			}

			report.add(reportTbl);
			report.add(Chunk.NEWLINE);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, CommonReportConstant.ATTACHMENT_FILENAME
					+ reportMasterEntity.getName() + CommonReportConstant.PDF_EXTENSION);
			header.setContentLength(out.toByteArray().length);
			report.close();

			String re = CommonReportUtil.convertByteToBase64String(out.toByteArray());
			CommonReportFileResponseDto responseDto = new CommonReportFileResponseDto();
			responseDto.setBase64String(re);
			responseDto.setFileName(CommonReportUtil.getReportFileName(reportMasterEntity.getName(),
					CommonReportConstant.PDF_EXTENSION));
			return responseDto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}
	
	public void getUserSelectedValueForReport(List<CommonFieldMasterEntity> fieldMasterEntityList, CommonReportPageDetails pageDetails, 
				Document report) throws DocumentException {
		Paragraph filterPara = new Paragraph(getUserSearchFilterData(fieldMasterEntityList, pageDetails));
		filterPara.setAlignment(Element.ALIGN_CENTER);
		report.add(filterPara);
	}
	
	public static String getUserSearchFilterData(List<CommonFieldMasterEntity> fieldMasterEntityList, CommonReportPageDetails pageDetails) {
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().filter(entity -> null != entity.getOrderNo()).
					collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
				sorted(Comparator.comparing(CommonFieldMasterEntity::getOrderNo)).collect(Collectors.toList());
		Map<String, String> labels = new LinkedHashMap<>();
		fmEntityList1.forEach(entity -> labels.put(entity.getParamUiName(), entity.getParamDispName()));
		List<CommonReportSearchParamDto> jsonArray = pageDetails.getJsonArr();
		List<String> reportString = jsonArray.stream().filter(param->!StringUtils.isEmpty(param.getPrintValue()) && 
				!param.getPrintValue().equals("0") && labels.containsKey(param.getKey())).map(param-> labels.get(param.getKey()) + 
				CommonReportConstant.REPORT_STRING_COLON + param.getPrintValue()).collect(Collectors.toList());
		return reportString.stream().collect(Collectors.joining(CommonReportConstant.REPORT_STRING_COMMA));
	}
	
	/**
	 * Gets the report column widths.
	 *
	 * @param fieldMasterEntityList the field master entity list
	 * @return the report column widths
	 */
	private float[] getReportColumnWidths(List<CommonFieldMasterEntity> fieldMasterEntityList) {
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().filter(entity -> 
				null != entity.getDispOrderNo()).collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
				sorted(Comparator.comparing(CommonFieldMasterEntity::getDispOrderNo)).collect(Collectors.toList());
		float[] reportColWidths = new float[fmEntityList1.size()];
		int i = 0;
		for (CommonFieldMasterEntity entity: fmEntityList1) {
			if (entity.getType().equals(CommonReportConstant.OUTPUT) || entity.getType().equals(CommonReportConstant.BOTH)) {
				reportColWidths[i++] = entity.getColumnSize().floatValue();
			}	
		}
		return reportColWidths;
	}
	
	/**
	 * Gets the report column heading.
	 *
	 * @param fieldMasterEntityList the field master entity list
	 * @return the report column heading
	 */
	private List<String> getReportColumnHeading(List<CommonFieldMasterEntity> fieldMasterEntityList) {
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().filter(entity -> 
				null != entity.getDispOrderNo()).collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
				sorted(Comparator.comparing(CommonFieldMasterEntity::getDispOrderNo)).collect(Collectors.toList());
		return fmEntityList1.stream().map(entity -> (entity.getType().equals(CommonReportConstant.OUTPUT) || 
				entity.getType().equals(CommonReportConstant.BOTH)) ? entity.getParamDispName() : CommonReportConstant.EMPTY_STRING).
				collect(Collectors.toList());
	}
	
	/**
	 * Gets the report pdf header dto.
	 *
	 * @param reportName the report name
	 * @param font the font
	 * @return the report pdf header dto
	 */
	private CommonReportPdfHeaderDto getReportPdfHeaderDto(Font font, List<CommonDesignMasterEntity> designMasterEntityList) {
		EDPMsOfficeDto dto = OAuthUtility.getCurrentUserOfficeFromToken();
		Chunk glue = new Chunk(new VerticalPositionMark());
		Paragraph p = new Paragraph();
		CommonReportPdfHeaderDto pdfHeaderDto = new CommonReportPdfHeaderDto();
		designMasterEntityList.forEach(designEntity -> {
			if (designEntity.getDisplayKey().equals(CommonReportConstant.REPORT_NAME) && 
					designEntity.getType().equals(CommonReportConstant.HEADER)) {
				pdfHeaderDto.setReportName(designEntity.getReportId().getName());
			} else if (designEntity.getDisplayKey().equals(CommonReportConstant.OFFICE_DISP_NAME) && 
					designEntity.getType().equals(CommonReportConstant.HEADER)) {
				pdfHeaderDto.setOfficeName(dto.getOfficeNameDisp());
			} else if (designEntity.getDisplayKey().equals(CommonReportConstant.DISTRICT_NAME) && 
					designEntity.getType().equals(CommonReportConstant.HEADER)) {
				pdfHeaderDto.setDistrict(dto.getDistrictName());
			} else if (designEntity.getDisplayKey().equals(CommonReportConstant.TALUKA_NAME) && 
					designEntity.getType().equals(CommonReportConstant.HEADER)) {
				pdfHeaderDto.setTaluka(dto.getTalukaName());
			} else if (designEntity.getDisplayKey().equals(CommonReportConstant.GENERATED_BY) && 
					designEntity.getType().equals(CommonReportConstant.FOOTER)) {
				p.add(designEntity.getDisplayName().concat(Constant.COLON).concat(Constant.SINGLE_SPACE) + 
						CommonReportUtil.getUserNameForCommonReport());
				p.add(new Chunk(glue));
			} else if (designEntity.getDisplayKey().equals(CommonReportConstant.GENERATED_DATE_TIME) && 
					designEntity.getType().equals(CommonReportConstant.FOOTER)) {
				p.add(new Phrase(designEntity.getDisplayName().concat(Constant.COLON).concat(Constant.SINGLE_SPACE) + 
						Utils.getCurrentDateTime(), font));
			}
		});
		if(!StringUtils.isEmpty(pdfHeaderDto.getTaluka()) && !StringUtils.isEmpty(pdfHeaderDto.getDistrict())) {			
			pdfHeaderDto.setTalukaWithDistrictName(pdfHeaderDto.getTaluka() + Constant.COLON + pdfHeaderDto.getDistrict());
		} else if(!StringUtils.isEmpty(pdfHeaderDto.getTaluka())) {			
			pdfHeaderDto.setTalukaWithDistrictName(pdfHeaderDto.getTaluka());
		} else if(!StringUtils.isEmpty(pdfHeaderDto.getDistrict())) {			
			pdfHeaderDto.setTalukaWithDistrictName(pdfHeaderDto.getDistrict());
		}
		pdfHeaderDto.setParagraphFooter(p);
		return pdfHeaderDto;
	}
}
