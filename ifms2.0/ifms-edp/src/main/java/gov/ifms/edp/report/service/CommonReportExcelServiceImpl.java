package gov.ifms.edp.report.service;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.report.dto.CommonReportFileResponseDto;
import gov.ifms.edp.report.dto.CommonReportPageDetails;
import gov.ifms.edp.report.dto.CommonReportSearchParamDto;
import gov.ifms.edp.report.entity.CommonDesignMasterEntity;
import gov.ifms.edp.report.entity.CommonFieldMasterEntity;
import gov.ifms.edp.report.entity.CommonReportMasterEntity;
import gov.ifms.edp.report.util.CommonReportConstant;
import gov.ifms.edp.report.util.CommonReportUtil;

/**
 * The Class CommonReportExcelServiceImpl.
 */
@Service
public class CommonReportExcelServiceImpl {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CommonReportExcelServiceImpl.class);
	
	/**
	 * Gets the excel report.
	 *
	 * @param pageDetails the page details
	 * @param response the response
	 * @param reportMasterEntity the report master entity
	 * @param designMasterEntityList the design master entity list
	 * @param fieldMasterEntityList the field master entity list
	 * @return the excel report
	 * @throws CustomException the custom exception
	 */
	public CommonReportFileResponseDto getExcelReport(CommonReportPageDetails pageDetails, List<Object[]> response, 
			CommonReportMasterEntity reportMasterEntity, List<CommonDesignMasterEntity> designMasterEntityList, 
			List<CommonFieldMasterEntity> fieldMasterEntityList) throws CustomException {
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			String reportName = reportMasterEntity.getName();
			// Create a blank sheet
			XSSFSheet sheet = workbook.createSheet(reportName);
			int totalColoumn = getReportColumnNamesList(fieldMasterEntityList).size();
			
			// This data needs to be written (Object[])
			Map<String, Object[]> data = new LinkedHashMap<>();
			designMasterEntityList.forEach(designEntity -> {
				if (designEntity.getDisplayKey().equals(CommonReportConstant.REPORT_NAME)) {
					data.put(designEntity.getDisplayValue(), new Object[] {designEntity.getReportId().getName()});
				} else if (designEntity.getDisplayKey().equals(CommonReportConstant.OFFICE_DISP_NAME)) {
					data.put(designEntity.getDisplayValue(), new Object[] {OAuthUtility.getCurrentUserOfficeFromToken().getDeptName()});
				}
			});
			data.put(CommonReportConstant.OFFICE_ADD_DDO, new Object[] {getUserSearchFilterData(fieldMasterEntityList, pageDetails)});
			data.put(CommonReportConstant.SELECTOR_DDO, new Object[] {});
			data.put(CommonReportConstant.COLOUMN_DDO, getReportColumnNamesArray(fieldMasterEntityList));
			int count = 1;
			for (Object[] obj : response) {
				Object[] dataObj = new Object[obj.length + 1];
				dataObj[0] = count;
				for (int i = 0; i < obj.length; i++) {
					dataObj[i + 1] = obj[i];
				}
				data.put(String.valueOf(count), dataObj);
				count++;
			}
			data.put(CommonReportConstant.BLANK1_NO_BORDER_DDO, new Object[] { StringUtils.EMPTY });
			data.put(CommonReportConstant.BLANK2_NO_BORDER_DDO, new Object[] { StringUtils.EMPTY });

			iterateWorkbookData(workbook, sheet, data, totalColoumn, new int[] { 0, 1, 3 });
			setRowData(workbook, sheet);

			// Write the workbook in file system
			 ByteArrayOutputStream out = new ByteArrayOutputStream();
			 workbook.write(out);
			 out.flush();
			 out.close();

//			FileOutputStream fileOut = new FileOutputStream("D:\\1.xlsx");
//			workbook.write(fileOut);
//			fileOut.close();

			HttpHeaders header = new HttpHeaders();
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					CommonReportConstant.ATTACHMENT_FILENAME + reportName + CommonReportConstant.XLSX_EXTENSION);
			CommonReportFileResponseDto responseDto = new CommonReportFileResponseDto();
			responseDto.setBase64String(CommonReportUtil.convertByteToBase64String(out.toByteArray()));
			responseDto.setFileName(CommonReportUtil.getReportFileName(reportName, CommonReportConstant.XLSX_EXTENSION));
			return responseDto;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * Iterate workbook data.
	 *
	 * @param workbook   the workbook
	 * @param sheet      the sheet
	 * @param data       the data
	 * @param totColoumn the tot coloumn
	 * @param colIndex   the col index
	 * @return the int
	 */
	public int iterateWorkbookData(Workbook workbook, XSSFSheet sheet, Map<String, Object[]> data, int totColoumn,
			int[] colIndex) {
		CellStyle cs = getCellStyle(workbook);
		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				sheet.autoSizeColumn(cellnum);
				// border not set for this cell
				if (!key.contains(CommonReportConstant.NO_BORDER)) {
					cell.setCellStyle(cs);
				}

				// merge cell for username and date time footer cell
				if (key.contains(CommonReportConstant.USER_NAME_NO_BORDER)) {
					CellRangeAddress cellRange1 = new CellRangeAddress(rownum - 1, rownum - 1, 0, 3);
					sheet.addMergedRegion(cellRange1);
				}
				setValue(obj, cell);
			}
		}

		// set column Alignment Center for each column Index pass
		doCenterAlignColumn(workbook, sheet, colIndex, totColoumn);

		// Merges the cells
		CellRangeAddress cellRange1 = new CellRangeAddress(0, 0, 0, totColoumn - 1);
		sheet.addMergedRegion(cellRange1);
		CellRangeAddress cellRange2 = new CellRangeAddress(1, 1, 0, totColoumn - 1);
		sheet.addMergedRegion(cellRange2);
		CellRangeAddress cellRange3 = new CellRangeAddress(2, 2, 0, totColoumn - 1);
		sheet.addMergedRegion(cellRange3);

		makeRowBold(workbook, sheet.getRow(0), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(1), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(2), 14, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(4), 12, IndexedColors.GREY_25_PERCENT.getIndex());

		return rownum;
	}

	/**
	 * Sets the row data.
	 *
	 * @param workbook the workbook
	 * @param sheet the sheet
	 */
	public void setRowData(Workbook workbook, XSSFSheet sheet) {
		CellStyle cen = workbook.createCellStyle();
		cen.setAlignment(CommonReportConstant.CENTER);
		Row row = sheet.createRow(3);
		Cell cell = row.createCell(3);
		cell.setCellStyle(cen);
		CellRangeAddress cellRange1 = new CellRangeAddress(3, 3, 3, 5);
		sheet.addMergedRegion(cellRange1);
		RegionUtil.setBorderTop(1, cellRange1, sheet);
		RegionUtil.setBorderRight(1, cellRange1, sheet);
		RegionUtil.setBorderLeft(1, cellRange1, sheet);
		setValue(CommonReportConstant.AD_DEPT, cell);

		Cell cell1 = row.createCell(6);
		cell1.setCellStyle(cen);
		CellRangeAddress cellRange2 = new CellRangeAddress(3, 3, 6, 9);
		sheet.addMergedRegion(cellRange2);
		RegionUtil.setBorderTop(1, cellRange2, sheet);
		RegionUtil.setBorderRight(1, cellRange2, sheet);
		RegionUtil.setBorderLeft(1, cellRange2, sheet);
		setValue(CommonReportConstant.FD_DEPT, cell1);
	}

	/**
	 * Sets the value.
	 *
	 * @param obj  the obj
	 * @param cell the cell
	 */
	private void setValue(Object obj, Cell cell) {
		if (obj instanceof String)
			cell.setCellValue((String) obj);
		else if (obj instanceof Long)
			cell.setCellValue((Long) obj);
		else if (obj instanceof Integer)
			cell.setCellValue((Integer) obj);
		else if (obj instanceof BigInteger) {
			BigInteger value = (BigInteger) obj;
			cell.setCellValue(value.longValue());
		} else if (obj instanceof Double) {
			Double value = (Double) obj;
			cell.setCellValue(value.longValue());
		} else {
			cell.setCellValue((String) obj);
		}
	}

	/**
	 * Gets the cell style.
	 *
	 * @param workbook the workbook
	 * @return the cell style
	 */
	private CellStyle getCellStyle(Workbook workbook) {
		CellStyle cs = workbook.createCellStyle();
		cs.setBorderTop(BorderStyle.THIN);
		cs.setBorderRight(CommonReportConstant.BORDER_THIN);
		cs.setBorderBottom(CommonReportConstant.BORDER_THIN);
		cs.setBorderLeft(CommonReportConstant.BORDER_THIN);
		return cs;
	}

	/**
	 * Set Center Alignment for passed column index.
	 *
	 * @param workbook the workbook
	 * @param sheet the sheet
	 * @param colIndex the col index
	 * @param totColoumn the tot coloumn
	 */
	public void doCenterAlignColumn(Workbook workbook, XSSFSheet sheet, int[] colIndex, int totColoumn) {
		int colSpace = 0;
		for (int i = 0; i < colIndex.length; i++) {

			Row rowCenter;
			CellStyle cen = workbook.createCellStyle();
			cen.setAlignment(CommonReportConstant.CENTER);
			cen.setBorderTop(CommonReportConstant.BORDER_THIN);
			cen.setBorderRight(CommonReportConstant.BORDER_THIN);
			cen.setBorderBottom(CommonReportConstant.BORDER_THIN);
			cen.setBorderLeft(CommonReportConstant.BORDER_THIN);

			/* not set cellStyle for report which has column size < 8 */
			if (totColoumn < 8) {
				colSpace = 4;
			} else {
				colSpace = 3;
			}
			/* need to give border and center till report data only */
			for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum() - colSpace; rowIndex++) {
				rowCenter = sheet.getRow(rowIndex);
				if (rowCenter != null) {
					Cell cell = rowCenter.getCell(colIndex[i]);
					if (cell != null) {
						cell.setCellStyle(cen);
					}
				}
			}
		}
	}

	/**
	 * Make row bold.
	 *
	 * @param wb       the wb
	 * @param row      the row
	 * @param fontSize the font size
	 * @param color    the color
	 */
	public static void makeRowBold(Workbook wb, Row row, int fontSize, short color) {
		CellStyle style = wb.createCellStyle();// Create style
		XSSFFont font = (XSSFFont) wb.createFont();// Create font
		font.setFontHeightInPoints((short) fontSize);
		font.setBold(true);// Make font bold
		style.setFont(font);// set it to bold
		style.setFillForegroundColor(color);
		style.setFillPattern(CommonReportConstant.SOLID_FOREGROUND);
		style.setAlignment(CommonReportConstant.CENTER);
		if (color == IndexedColors.GREY_25_PERCENT.getIndex()) {
			style.setBorderBottom(CommonReportConstant.BORDER_THIN);
			style.setBorderTop(CommonReportConstant.BORDER_THIN);
			style.setBorderRight(CommonReportConstant.BORDER_THIN);
			style.setBorderLeft(CommonReportConstant.BORDER_THIN);
		}
		for (int i = 0; i < row.getLastCellNum(); i++) {// For each cell in the row
			row.getCell(i).setCellStyle(style);// Set the style
		}
	}
	
	/**
	 * Gets the user search filter data.
	 *
	 * @param pageDetails the page details
	 * @return the user search filter data
	 */
	public String getUserSearchFilterData(List<CommonFieldMasterEntity> fieldMasterEntityList, CommonReportPageDetails pageDetails) {
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
	 * Gets the report column names list.
	 *
	 * @param fieldMasterEntityList the field master entity list
	 * @return the report column names list
	 */
	public List<String> getReportColumnNamesList(List<CommonFieldMasterEntity> fieldMasterEntityList) {
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().filter(entity -> 
				null != entity.getDispOrderNo()).collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
				sorted(Comparator.comparing(CommonFieldMasterEntity::getDispOrderNo)).collect(Collectors.toList());
		return fmEntityList1.stream().map(entity -> (entity.getType().equals(CommonReportConstant.OUTPUT) || 
				entity.getType().equals(CommonReportConstant.BOTH)) ? entity.getParamDispName() : CommonReportConstant.EMPTY_STRING).
				collect(Collectors.toList());
	}
	
	/**
	 * Gets the report column names array.
	 *
	 * @param fieldMasterEntityList the field master entity list
	 * @return the report column names array
	 */
	public Object[] getReportColumnNamesArray(List<CommonFieldMasterEntity> fieldMasterEntityList) {
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().filter(entity -> 
				null != entity.getDispOrderNo()).collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
				sorted(Comparator.comparing(CommonFieldMasterEntity::getDispOrderNo)).collect(Collectors.toList());
		Object[] reportColumnNames = new Object[fmEntityList1.size()];
		int i = 0;
		for(CommonFieldMasterEntity entity : fmEntityList1) {
			if (entity.getType().equals(CommonReportConstant.OUTPUT) || entity.getType().equals(CommonReportConstant.BOTH)) {
				reportColumnNames[i++] = entity.getParamDispName();
			}
		}
		return reportColumnNames;
	}
	
}
