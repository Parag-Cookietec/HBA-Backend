package gov.ifms.edp.service;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPReportFileResponseDto;
import gov.ifms.edp.dto.EDPReportPageDetails;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.util.EDPReportConstant;
import gov.ifms.edp.util.EDPUtility;

@Service
public class EDPReporstExcelServiceImpl {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public EDPReportFileResponseDto getReportExcel(EDPReportPageDetails pageDetail, List<Object[]> response) throws CustomException {
		try(XSSFWorkbook workbook = new XSSFWorkbook()){
			String reportName = EDPUtility.getReportName(pageDetail.getMenuId());
			// Create a blank sheet
			XSSFSheet sheet = workbook.createSheet(reportName);
			int totalColoumn = EDPUtility.getReportColumnNamesList(pageDetail.getMenuId()).size();
			
			// This data needs to be written (Object[])
			Map<String, Object[]> data = new LinkedHashMap<>();
			EDPMsOfficeDto dto = OAuthUtility.getCurrentUserOfficeFromToken();
			data.put(EDPReportConstant.REPORT_DDO, new Object[] { reportName });
			data.put(EDPReportConstant.OFFICE_NAME_DDO, new Object[] { dto.getOfficeNameDisp() });
			String talukaDis ="";
			if(!StringUtils.isEmpty(dto.getTalukaName()) && !StringUtils.isEmpty(dto.getDistrictName())) {			
				talukaDis = dto.getTalukaName() + Constant.COLON + dto.getDistrictName();
			} else if(!StringUtils.isEmpty(dto.getTalukaName())) {			
				talukaDis = dto.getTalukaName() ;
			} else if(!StringUtils.isEmpty(dto.getDistrictName())) {			
				talukaDis = dto.getDistrictName();
			}
			data.put(EDPReportConstant.OFFICE_ADD_DDO, new Object[] { talukaDis });
			data.put(EDPReportConstant.SELECTOR_DDO, new Object[] { EDPUtility.getUserSearchFilterData(pageDetail) });
			data.put(EDPReportConstant.COLOUMN_DDO, EDPUtility.getReportColumnNamesArray(pageDetail.getMenuId()));
			int count = 1;
			for(Object[] obj : response){
				Object[] dataObj = new Object[obj.length];
				dataObj[0] = count ;
				for(int i =0;i<obj.length-1;i++) {
					dataObj[i+1] = obj[i];
				}
				data.put(String.valueOf(count),dataObj);
				count++;
			}
			data.put(EDPReportConstant.BLANK1_NO_BORDER_DDO, new Object[] { StringUtils.EMPTY });
			data.put(EDPReportConstant.BLANK2_NO_BORDER_DDO, new Object[] { StringUtils.EMPTY });
			data.put(EDPReportConstant.USER_NAME_NO_BORDER_DDO, new Object[] { EDPReportConstant.REPORT_GENERATED_BY + EDPUtility.getUserNameForEdpReport()});
			data.put(EDPReportConstant.CREATE_DATA_NO_BORDER_DDO, new Object[] { EDPReportConstant.REPORT_GENERATED_DATETIME + Utils.getCurrentDateTime()});
			
			this.iterateWorkbookData(workbook, sheet, data, totalColoumn, new int[] { 0, 1, 3 });

			// Write the workbook in file system
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			workbook.write(out);
			out.flush();
			out.close();

			HttpHeaders header = new HttpHeaders();
			header.set(HttpHeaders.CONTENT_DISPOSITION, EDPReportConstant.ATTACHMENT_FILENAME + reportName + EDPReportConstant.XLSX_EXTENSION);
			EDPReportFileResponseDto responsedto = new EDPReportFileResponseDto();
			responsedto.setBase64String(EDPUtility.convertByteToBase64String(out.toByteArray()));
			responsedto.setFileName(EDPUtility.getReportFileName(reportName,EDPReportConstant.XLSX_EXTENSION));
			return responsedto;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Iterate workbook data.
	 *
	 * @param workbook the workbook
	 * @param sheet the sheet
	 * @param data the data
	 * @param totColoumn the tot coloumn
	 * @param colIndex the col index
	 */
	public void iterateWorkbookData(Workbook workbook, XSSFSheet sheet, Map<String, Object[]> data, int totColoumn,
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
				if (!key.contains(EDPReportConstant.NO_BORDER)) {
					cell.setCellStyle(cs);
				}
				// merge cell for username and date time footer cell
				if (key.contains(EDPReportConstant.USER_NAME_NO_BORDER)) {
					CellRangeAddress cellRange1 = new CellRangeAddress(rownum - 1, rownum - 1, 0, 3);
					sheet.addMergedRegion(cellRange1);
				}
				setValue(obj, cell);
			}
		}

		// set column Alignment Center for each column Index pass
		doCenterAlignColumn(workbook, sheet, colIndex,totColoumn);

		// Merges the cells
		CellRangeAddress cellRange1 = new CellRangeAddress(0, 0, 0, totColoumn-1);
		sheet.addMergedRegion(cellRange1);
		CellRangeAddress cellRange2 = new CellRangeAddress(1, 1, 0, totColoumn-1);
		sheet.addMergedRegion(cellRange2);
		CellRangeAddress cellRange3 = new CellRangeAddress(2, 2, 0, totColoumn-1);
		sheet.addMergedRegion(cellRange3);
		CellRangeAddress cellRange4 = new CellRangeAddress(3, 3, 0, totColoumn-1);
		sheet.addMergedRegion(cellRange4);

		makeRowBold(workbook, sheet.getRow(0), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(1), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(2), 14, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(3), 12, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(4), 12, IndexedColors.GREY_25_PERCENT.getIndex());

	}

	/**
	 * Sets the value.
	 *
	 * @param obj the obj
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
		    BigInteger value = (BigInteger)obj;
			cell.setCellValue(value.longValue());
		} else {
			cell.setCellValue((String)obj);
		}
	}

	private CellStyle getCellStyle(Workbook workbook) {
		CellStyle cs = workbook.createCellStyle();
		cs.setBorderTop(BorderStyle.THIN);
		cs.setBorderRight(EDPReportConstant.BORDER_THIN);
		cs.setBorderBottom(EDPReportConstant.BORDER_THIN);
		cs.setBorderLeft(EDPReportConstant.BORDER_THIN);
		return cs;
	}
	
	/**
	 * Set Center Alignment for passed column index
	 *
	 * @param Workbook ,XSSFSheet , colIndex
	 * @return
	 * @throws CustomException
	 */
	public void doCenterAlignColumn(Workbook workbook, XSSFSheet sheet, int[] colIndex,int totColoumn) {
		int colSpace=0;
		for (int i = 0; i < colIndex.length; i++) {

			Row rowCenter;
			CellStyle cen = workbook.createCellStyle();
			cen.setAlignment(EDPReportConstant.CENTER);
			cen.setBorderTop(EDPReportConstant.BORDER_THIN);
			cen.setBorderRight(EDPReportConstant.BORDER_THIN);
			cen.setBorderBottom(EDPReportConstant.BORDER_THIN);
			cen.setBorderLeft(EDPReportConstant.BORDER_THIN);
			
			/* not set cellStyle for report which has column size < 8  */
			if(totColoumn < 8 ) {
				colSpace=4;
			}else{
				colSpace=3;
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
	 * @param wb the wb
	 * @param row the row
	 * @param fontSize the font size
	 * @param color the color
	 */
	public static void makeRowBold(Workbook wb, Row row, int fontSize, short color) {
		CellStyle style = wb.createCellStyle();// Create style
		XSSFFont font = (XSSFFont) wb.createFont();// Create font
		font.setFontHeightInPoints((short) fontSize);
		font.setBold(true);// Make font bold
		style.setFont(font);// set it to bold
		style.setFillForegroundColor(color);
		style.setFillPattern(EDPReportConstant.SOLID_FOREGROUND);
		style.setAlignment(EDPReportConstant.CENTER);
		if (color == IndexedColors.GREY_25_PERCENT.getIndex()) {
			style.setBorderBottom(EDPReportConstant.BORDER_THIN);
			style.setBorderTop(EDPReportConstant.BORDER_THIN);
			style.setBorderRight(EDPReportConstant.BORDER_THIN);
			style.setBorderLeft(EDPReportConstant.BORDER_THIN);
		}
		for (int i = 0; i < row.getLastCellNum(); i++) {// For each cell in the row
			row.getCell(i).setCellStyle(style);// Set the style
		}
	}
}
