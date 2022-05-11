package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.pvu.dto.MISDistrictCaseReportView;
import gov.ifms.pvu.dto.MISDistrictWisePendingStatusReportView;
import gov.ifms.pvu.dto.MISDurationPendingEnumOneReport;
import gov.ifms.pvu.dto.MISDurationPendingEnumTwoReport;
import gov.ifms.pvu.dto.MISEmpWiseAllocationReportView;
import gov.ifms.pvu.dto.MISEmpWiseWorkdoneDetailReportView;
import gov.ifms.pvu.dto.MISEmpWiseWorkdoneReportView;
import gov.ifms.pvu.dto.MISEmployeeMonthlyProgressCountReportView;
import gov.ifms.pvu.dto.MISEventWisePendingStatusReportView;
import gov.ifms.pvu.dto.MISForwardCaseDdoCountReportView;
import gov.ifms.pvu.dto.MISInwardCaseEventCountReportView;
import gov.ifms.pvu.dto.MISInwardCaseReportView;
import gov.ifms.pvu.dto.MISOutwardCaseForEventCountView;
import gov.ifms.pvu.dto.MISPvuEventStatusReportView;
import gov.ifms.pvu.dto.MISReturnCaseCountReportView;
import gov.ifms.pvu.dto.MISReturnCaseReportView;
import gov.ifms.pvu.dto.PVUMISCaseInqReportsVIew;
import gov.ifms.pvu.dto.PVUMISEmployeeCreationReportsView;
import gov.ifms.pvu.dto.PVUMISOutwardCaseReportsView;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUMISExcelReportsServiceImpl.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 */
@Service
public class PVUMISExcelReportsServiceImpl implements PVUMISExcelReportService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PVUMISReportsServiceImpl misService;

	public String generateExcel(PageDetails pageDetail, String rptName, Map<String, Object[]> rptData, int listSize,
			int totCol, int[] colIndex) throws CustomException {

		try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			// Create a blank sheet
			XSSFSheet sheet = workbook.createSheet(rptName);
			// This data needs to be written (Object[])
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_OFFICE_NAME, new Object[] {
					PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_OFFICE_ADDRESS, new Object[] {
					PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey()) });
			data.put(PvuConstant.PVU_MIS_REPORT_NAME, new Object[] { rptName });
			data.put(PvuConstant.PVU_MIS_FILTER, rptData.get(PvuConstant.PVU_MIS_CONS_FILTER));
			data.put(PvuConstant.PVU_MIS_COLOUMN_HEADER, rptData.get(PvuConstant.PVU_MIS_HEADER));

			for (int i = 0; i < listSize; i++) {
				data.put(String.valueOf(i + 1), rptData.get(String.valueOf(i + 1)));
			}

			data.put(PvuConstant.PVU_MIS_EMPTY_ROW1, new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_EMPTY_ROW2, new Object[] { "" });

			data.put(PvuConstant.PVU_MIS_USERNAME_DATETIME, rptData.get(PvuConstant.PVU_MIS_FOOTER));

			// If number of column < 8, than need to set date time in another row
			if (!Utils.isEmpty(rptData.get(PvuConstant.PVU_MIS_DATE_TIME))) {
				data.put(PvuConstant.PVU_MIS_DATETIME, rptData.get(PvuConstant.PVU_MIS_DATE_TIME));
			}

			this.iterateWorkbookData(workbook, sheet, data, totCol, colIndex);
			// Write the workbook in file system

			/* Set auto size column */
			for (int i = 0; i <= totCol; i++) {
				sheet.autoSizeColumn(i);
			}

			workbook.write(out);
			HttpHeaders header = new HttpHeaders();
			header.setContentLength(out.toByteArray().length);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					PvuConstant.PVU_MIS_ATT_FILENAME + rptName + PvuConstant.PVU_MIS_EX_XLS);
			return Base64.getEncoder().encodeToString(out.toByteArray());

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public void iterateWorkbookData(Workbook workbook, XSSFSheet sheet, Map<String, Object[]> data, int totColoumn,
			int[] colIndex) {

		CellStyle cs = workbook.createCellStyle();
		cs.setBorderTop(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				// border not set for this cell
				if (!key.contains("_NoBorder")) {
					cell.setCellStyle(cs);
				}
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		// set column Alignment Center for each column Index pass
		doCenterAlignColumn(workbook, sheet, colIndex, totColoumn);

		// Merges the cells
		CellRangeAddress cellRange1 = new CellRangeAddress(0, 0, 0, totColoumn);
		sheet.addMergedRegion(cellRange1);
		CellRangeAddress cellRange2 = new CellRangeAddress(1, 1, 0, totColoumn);
		sheet.addMergedRegion(cellRange2);
		CellRangeAddress cellRange3 = new CellRangeAddress(2, 2, 0, totColoumn);
		sheet.addMergedRegion(cellRange3);
		CellRangeAddress cellRange4 = new CellRangeAddress(3, 3, 0, totColoumn);
		sheet.addMergedRegion(cellRange4);

		/* Start merge cell for user name and date time footer cell */
		int totalRow = sheet.getLastRowNum();
		if (totColoumn < 3) {
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, 0, totColoumn));
			sheet.addMergedRegion(new CellRangeAddress(totalRow - 1, totalRow - 1, 0, totColoumn));
		} else if (totColoumn < 8) {
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, 0, 3));
			sheet.addMergedRegion(new CellRangeAddress(totalRow - 1, totalRow - 1, 0, 3));
		} else {
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, 0, 3));
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, totColoumn - 3, totColoumn));
		}
		/* End merge cell for user name and date time footer cell */

		makeRowBold(workbook, sheet.getRow(0), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(1), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(2), 14, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(3), 12, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(4), 12, IndexedColors.GREY_25_PERCENT.getIndex());

	}

	public CellStyle getExcelCellStyleForCaseInquiry(Workbook workbook) {
		CellStyle cs = workbook.createCellStyle();
		cs.setBorderTop(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setAlignment(CellStyle.ALIGN_LEFT);
		return cs;
	}

	public void iterateWorkbookDataForCaseInquiry(Workbook workbook, XSSFSheet sheet, Map<String, Object[]> data,
			int totColoumn, int[] colIndex) {

		CellStyle cs = this.getExcelCellStyleForCaseInquiry(workbook);
		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				// border not set for this cell
				if (!key.contains("_NoBorder")) {
					cell.setCellStyle(cs);
				}
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		// set column Alignment Center for each column Index pass
		doCenterAlignColumnForCaseInquiry(workbook, sheet, colIndex, totColoumn);

		// Merges the cells
		CellRangeAddress cellRange1 = new CellRangeAddress(0, 0, 0, totColoumn);
		sheet.addMergedRegion(cellRange1);
		CellRangeAddress cellRange2 = new CellRangeAddress(1, 1, 0, totColoumn);
		sheet.addMergedRegion(cellRange2);
		CellRangeAddress cellRange3 = new CellRangeAddress(2, 2, 0, totColoumn);
		sheet.addMergedRegion(cellRange3);
		CellRangeAddress cellRange4 = new CellRangeAddress(3, 3, 0, totColoumn);
		sheet.addMergedRegion(cellRange4);

		/* Start merge cell for user name and date time footer cell */
		int totalRow = sheet.getLastRowNum();
		if (totColoumn < 3) {
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, 0, totColoumn));
			sheet.addMergedRegion(new CellRangeAddress(totalRow - 1, totalRow - 1, 0, totColoumn));
		} else if (totColoumn < 8) {
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, 0, 3));
			sheet.addMergedRegion(new CellRangeAddress(totalRow - 1, totalRow - 1, 0, 3));
		} else {
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, 0, 3));
			sheet.addMergedRegion(new CellRangeAddress(totalRow, totalRow, totColoumn - 3, totColoumn));
		}
		/* End merge cell for user name and date time footer cell */

		makeRowBold(workbook, sheet.getRow(0), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(1), 13, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(2), 14, IndexedColors.WHITE.getIndex());
		makeRowBold(workbook, sheet.getRow(3), 12, IndexedColors.WHITE.getIndex());

	}

	public void doCenterAlignColumnForCaseInquiry(Workbook workbook, XSSFSheet sheet, int[] colIndex, int totColoumn) {
		int colSpace = 0;
		for (int i = 0; i < colIndex.length; i++) {

			Row rowCenter;
			XSSFFont font = (XSSFFont) workbook.createFont();// Create font
			font.setFontHeightInPoints((short) 12);
			font.setBold(true);// Make font bold
			CellStyle cen = workbook.createCellStyle();
			cen.setFont(font);// set it to bold
			cen.setAlignment(CellStyle.ALIGN_CENTER);
			cen.setBorderTop(CellStyle.BORDER_THIN);
			cen.setBorderRight(CellStyle.BORDER_THIN);
			cen.setBorderBottom(CellStyle.BORDER_THIN);
			cen.setBorderLeft(CellStyle.BORDER_THIN);
			cen.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cen.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

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

	@SuppressWarnings("deprecation")
	public static void makeRowBold(Workbook wb, Row row, int fontSize, short color) {
		CellStyle style = wb.createCellStyle();// Create style
		XSSFFont font = (XSSFFont) wb.createFont();// Create font
		font.setFontHeightInPoints((short) fontSize);
		font.setBold(true);// Make font bold
		style.setFont(font);// set it to bold
		style.setFillForegroundColor(color);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		if (color == IndexedColors.GREY_25_PERCENT.getIndex()) {
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
		}
		for (int i = 0; i < row.getLastCellNum(); i++) {// For each cell in the row
			row.getCell(i).setCellStyle(style);// Set the style
		}
	}

	/**
	 * Set Center Alignment for passed column index
	 *
	 * @param Workbook ,XSSFSheet , colIndex
	 * @return
	 * @throws CustomException
	 */
	public void doCenterAlignColumn(Workbook workbook, XSSFSheet sheet, int[] colIndex, int totColoumn) {
		int colSpace = 0;
		for (int i = 0; i < colIndex.length; i++) {

			Row rowCenter;
			CellStyle cen = workbook.createCellStyle();
			cen.setAlignment(CellStyle.ALIGN_CENTER);
			cen.setBorderTop(CellStyle.BORDER_THIN);
			cen.setBorderRight(CellStyle.BORDER_THIN);
			cen.setBorderBottom(CellStyle.BORDER_THIN);
			cen.setBorderLeft(CellStyle.BORDER_THIN);

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

	@Override
	public String getExcelDdoForwardCaseReport(PageDetails pageDetail) throws CustomException {

		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<PVUMISEmployeeCreationReportsView> objStorePro = misService.getDdoForwardCaseReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDdoForwardReport(pageDetail) });

			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							"Case No.", PvuConstant.PVU_MIS_DESIGNATION, "Class", PvuConstant.PVU_MIS_JOININGDATE,
							"Birth Date", PvuConstant.PVU_MIS_RETIREMENTDATE, PvuConstant.PVU_MIS_DEATHDATE, "PAN Card",
							"Office Name", PvuConstant.PVU_MIS_STATUS });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getCaseNo(),
								objStorePro.get(i).getDesignationName(), objStorePro.get(i).getEmpClass(),
								!Utils.isEmpty(objStorePro.get(i).getJoiningDate())
										? Utils.getDateString(objStorePro.get(i).getJoiningDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getDob())
										? Utils.getDateString(objStorePro.get(i).getDob())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getRetirementDate())
										? Utils.getDateString(objStorePro.get(i).getRetirementDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getDeathDate())
										? Utils.getDateString(objStorePro.get(i).getDeathDate())
										: "",
								objStorePro.get(i).getPanNo(), objStorePro.get(i).getOfficeName(),
								objStorePro.get(i).getStatus() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });
			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1, 3 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getExcelEmployeeCreationReport(PageDetails pageDetail) throws CustomException {
		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<PVUMISEmployeeCreationReportsView> objStorePro = misService.getEmployeeCreationReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			// This data needs to be written (Object[])
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEmpCreationReport(pageDetail) });

			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							"Case No.", PvuConstant.PVU_MIS_DESIGNATION, "Class", PvuConstant.PVU_MIS_JOININGDATE,
							"Birth Date", PvuConstant.PVU_MIS_RETIREMENTDATE, PvuConstant.PVU_MIS_DEATHDATE, "PAN Card",
							PvuConstant.PVU_MIS_OFFICENAME, PvuConstant.PVU_MIS_STATUS });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getCaseNo(),
								objStorePro.get(i).getDesignationName(), objStorePro.get(i).getEmpClass(),
								!Utils.isEmpty(objStorePro.get(i).getJoiningDate())
										? Utils.getDateString(objStorePro.get(i).getJoiningDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getDob())
										? Utils.getDateString(objStorePro.get(i).getDob())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getRetirementDate())
										? Utils.getDateString(objStorePro.get(i).getRetirementDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getDeathDate())
										? Utils.getDateString(objStorePro.get(i).getDeathDate())
										: "",
								objStorePro.get(i).getPanNo(), objStorePro.get(i).getOfficeName(),
								objStorePro.get(i).getStatus() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1, 3 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getExcelInwardCaseReport(PageDetails pageDetail) throws CustomException {

		try {
			if (!isDetailRpt(pageDetail)) {
				return getInwardCaseForROPCountWiseReportExcel(pageDetail);
			}
			pageDetail.setPageElement(getTotalCount(pageDetail));
			List<MISInwardCaseReportView> objStorePro = misService.getInwardCaseReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail) });

			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							"GPF/PPAN No", "DDO Office Name", "Endorsment", PvuConstant.PVU_MIS_STATUS,
							PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE,
							PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
							PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });
			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getExcelCaseInquiryReport(PageDetails pageDetail) throws CustomException {
		try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			List<PVUMISCaseInqReportsVIew> objStorePro = misService.getCaseInquiryReport(pageDetail).getResult();

			// Create a blank sheet
			XSSFSheet sheet = workbook.createSheet(PvuConstant.PVU_MIS_CASEINQ_RPTNAME);
			int totColoumn = 3;
			// This data needs to be written (Object[])
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put("OfficeName_Caseinq", new Object[] {
					PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey()) });
			data.put("OfficeAdd_Caseinq", new Object[] {
					PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey()) });
			data.put("Report_Caseinq", new Object[] { PvuConstant.PVU_MIS_CASEINQ_RPTNAME });
			data.put("selector_Caseinq",
					new Object[] { misService.getUserSelectedKeyValueForCaseInqReport(pageDetail) });

			data.put("1",
					new Object[] { "Inward No.", objStorePro.get(0).getInwardNumber(), PvuConstant.PVU_MIS_INWARDDATE,
							!Utils.isEmpty(objStorePro.get(0).getInwardDate())
									? Utils.getDateString(objStorePro.get(0).getInwardDate())
									: "" });

			data.put("2", new Object[] { PvuConstant.PVU_MIS_EMPNO, objStorePro.get(0).getEmployeeNo(),
					PvuConstant.PVU_MIS_EMPNAME, objStorePro.get(0).getEmployeeName() });

			data.put("3",
					new Object[] { PvuConstant.PVU_MIS_RETIREMENTDATE,
							!Utils.isEmpty(objStorePro.get(0).getRetirementDate())
									? Utils.getDateString(objStorePro.get(0).getRetirementDate())
									: "",
							PvuConstant.PVU_MIS_DEATHDATE,
							!Utils.isEmpty(objStorePro.get(0).getDeathDate())
									? Utils.getDateString(objStorePro.get(0).getDeathDate())
									: "" });

			data.put("4", new Object[] { "DDO Office Name", objStorePro.get(0).getOfficeName(), "DDO Office Address",
					objStorePro.get(0).getOfficeAddress() });

			data.put("5", new Object[] { "Department Name", objStorePro.get(0).getDepartmentName(), "Endorsment",
					objStorePro.get(0).getEndorsement() });

			data.put("6", new Object[] { PvuConstant.PVU_MIS_EVENTTYPE, objStorePro.get(0).getEventName(),
					PvuConstant.PVU_MIS_STATUS, objStorePro.get(0).getStatus() });

			data.put("7",
					new Object[] { PvuConstant.PVU_MIS_LYINGWITH, objStorePro.get(0).getLyingWith(),
							PvuConstant.PVU_MIS_OUTWARDDATE,
							!Utils.isEmpty(objStorePro.get(0).getOutwardDate())
									? Utils.getDateString(objStorePro.get(0).getOutwardDate())
									: "" });

			data.put("8", new Object[] { "Outwarded By", objStorePro.get(0).getOutwardBy(), "Outward Number",
					objStorePro.get(0).getOutwardNumber() });

			data.put("9",
					new Object[] { "Post Tracking Id. Number", objStorePro.get(0).getPostConsignmentNo(),
							PvuConstant.PVU_MIS_AUTHDATE,
							!Utils.isEmpty(objStorePro.get(0).getAuthDate())
									? Utils.getDateString(objStorePro.get(0).getAuthDate())
									: "" });

			data.put("10",
					new Object[] { PvuConstant.PVU_MIS_RETDATE,
							!Utils.isEmpty(objStorePro.get(0).getReturnDate())
									? Utils.getDateString(objStorePro.get(0).getReturnDate())
									: "" });

			data.put("blank1_NoBorder_Caseinq", new Object[] { "" });
			data.put("blank2_NoBorder_Caseinq", new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_USERNAME_DATETIME, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATETIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			this.iterateWorkbookDataForCaseInquiry(workbook, sheet, data, totColoumn, new int[] { 0, 2 });
			workbook.write(out);
			HttpHeaders header = new HttpHeaders();
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Case_Inquiry.xlsx");

			return Base64.getEncoder().encodeToString(out.toByteArray());
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getInwardCaseEventExcel(PageDetails pageDetail) throws CustomException {
		try {

			if (!isDetailRpt(pageDetail)) {
				return getInwardCaseForEventCountWiseReportExcel(pageDetail);
			}
			pageDetail.setPageElement(getTotalCount(pageDetail));
			List<MISInwardCaseReportView> objStorePro = misService.getInwardCaseForEventDetailReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail) });

			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });
			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getOutwardCaseEventExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getOutwardCaseForEventCountWiseReportExcel(pageDetail);
			}
			pageDetail.setPageElement(getTotalCount(pageDetail));
			List<PVUMISOutwardCaseReportsView> objStorePro = misService.getOutwardReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForOutwardCaseEventReport(pageDetail) });

			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpfNo(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsment(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingwith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventName() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getForwardCaseDdoWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getForwardCasesDDOCountWiseReportExcel(pageDetail);
			}
						pageDetail.setPageElement(getTotalCount(pageDetail));
			List<MISInwardCaseReportView> objStorePro = misService.getForwardCaseDdoWiseDetailReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForForwardCaseDdoEventReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getReturnCaseDdoWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {

			if (!isDetailRpt(pageDetail)) {
				return getReturnCasesCountWiseReportExcel(pageDetail);
			}

			List<MISReturnCaseReportView> objStorePro = misService.getReturnCaseEventDetailReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForReturnCaseEventReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getDistrictWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISDistrictCaseReportView> objStorePro = misService.getDistrictWiseEventReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 5;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDistrictWiseReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DISTRICTNAME,
							PvuConstant.PVU_MIS_AUTHORIZED, PvuConstant.PVU_MIS_RETURNED,
							PvuConstant.PVU_MIS_INPROGRESS, PvuConstant.PVU_MIS_TOTAL });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getDistName(),
								objStorePro.get(i).getAuthCases(), objStorePro.get(i).getReturnCases(),
								objStorePro.get(i).getInProgress(), objStorePro.get(i).getTotalCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put("DATE_TIME", new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getDdoEventStatusReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<PVUMISEmployeeCreationReportsView> objStorePro = misService.getDdoEventStatusReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDdoEventReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_CASENO, PvuConstant.PVU_MIS_DESIGNATION, PvuConstant.PVU_MIS_CLASS,
							PvuConstant.PVU_MIS_JOININGDATE, PvuConstant.PVU_MIS_BIRTHDATE,
							PvuConstant.PVU_MIS_RETIREMENTDATE, PvuConstant.PVU_MIS_DEATHDATE, PvuConstant.PVU_MIS_PAN,
							PvuConstant.PVU_MIS_DDO_OFFICENAME, PvuConstant.PVU_MIS_STATUS });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getCaseNo(),
								objStorePro.get(i).getDesignationName(), objStorePro.get(i).getEmpClass(),
								!Utils.isEmpty(objStorePro.get(i).getJoiningDate())
										? Utils.getDateString(objStorePro.get(i).getJoiningDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getDob())
										? Utils.getDateString(objStorePro.get(i).getDob())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getRetirementDate())
										? Utils.getDateString(objStorePro.get(i).getRetirementDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getDeathDate())
										? Utils.getDateString(objStorePro.get(i).getDeathDate())
										: "",
								objStorePro.get(i).getPanNo(), objStorePro.get(i).getOfficeName(),
								objStorePro.get(i).getStatus() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1, 3 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	@Override
	public String getDistrictWisePendingStatusReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getDistrictWisePendingStatusCountWiseReportExcel(pageDetail);
			}

			List<MISDistrictWisePendingStatusReportView> objStorePro = misService
					.getDistrictWisePendingStatusReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 9;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								objStorePro.get(i).getEventName() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getDepartmentWisePendingStatusReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getDepartmentWisePendingStatusCountWiseReportExcel(pageDetail);
			}

			List<MISDistrictWisePendingStatusReportView> objStorePro = misService
					.getDepartmentWisePendingEventReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 9;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								objStorePro.get(i).getEventName() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getEmpWiseMOnthlyProgressReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getEmpWiseMOnthlyProgressCountWiseReportExcel(pageDetail);
			}

			List<MISInwardCaseReportView> objStorePro = misService.getEmployeeWiseMonthlyProgressEventReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEmpWiseMOnthlyProgressReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getPvuEventStatusReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getPvuEventStatusCountWiseReportExcel(pageDetail);
			}

			List<MISInwardCaseReportView> objStorePro = misService.getPvuEventStatusReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForPvuEventStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public String getPvuEventStatusCountWiseReportExcel(PageDetails pageDetail) throws CustomException {

		try {
			List<MISPvuEventStatusReportView> objStorePro = misService.getPvuEventStatusCountReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 4;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForPvuEventStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_AUTH_CASE,
					PvuConstant.PVU_MIS_RET_CASE, PvuConstant.PVU_MIS_PENDING_CASES, PvuConstant.PVU_MIS_TOTAL_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getAuthCases(),
								objStorePro.get(i).getReturnCases(), objStorePro.get(i).getPendingCases(),
								objStorePro.get(i).getTotalCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	@Override
	public String getDeptVerificationReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISDistrictCaseReportView> objStorePro = misService.getDepWiseVerificationReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 5;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDepVeriReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DEPNAME,
							PvuConstant.PVU_MIS_AUTHORIZED, PvuConstant.PVU_MIS_RETURNED,
							PvuConstant.PVU_MIS_INPROGRESS, PvuConstant.PVU_MIS_TOTAL });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getDistName(),
								objStorePro.get(i).getAuthCases(), objStorePro.get(i).getReturnCases(),
								objStorePro.get(i).getInProgress(), objStorePro.get(i).getTotalCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put("DATE_TIME", new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getEventWisePendingStatusReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getEventWisePendingStatusCountWiseReportExcel(pageDetail);
			}

			List<MISInwardCaseReportView> objStorePro = misService.getEventWisePendingStatusReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEventWisePendingStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getEmpWiseWorkdoneReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			if (!isDetailRpt(pageDetail)) {
				return getEmpWiseWorkdoneCountWiseReportExcel(pageDetail);
			}
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<MISEmpWiseWorkdoneDetailReportView> objStorePro = misService.getEmpWiseWorkdoneReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEmpWiseWorkdoneReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getEmpWiseAllocationReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<MISEmpWiseAllocationReportView> objStorePro = misService.getEmpWiseAllocationReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEmpWiseAllocationReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public String getDurationWisePendingReportExcel(PageDetails pageDetail) throws CustomException {
		try {

			String enumIndexOne = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_1.getKey());
			String enumIndexTwo = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_2.getKey());
			String enumIndexThree = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_3.getKey());

			if (enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
				return getDurationCountWiseReportExcel(pageDetail);
			}
			if (!enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
				return getDurationLevelWiseReportExcel(pageDetail);
			}
			if (!enumIndexOne.equals("0") && !enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
				return getDurationEmployeeWiseReportExcel(pageDetail);
			}

			List<MISInwardCaseReportView> objStorePro = misService
					.getDurationWisePendingStatusCombinationFourReportListing(pageDetail);
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 12;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER, new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME,
							PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH,
							PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE,
							PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE });

			for (int i = 0; i < objStorePro.size(); i++) {

				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmployeeNo(),
								objStorePro.get(i).getEmployeeName(), objStorePro.get(i).getGpf(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getEndorsement(),
								objStorePro.get(i).getStatus(), objStorePro.get(i).getLyingWith(),
								!Utils.isEmpty(objStorePro.get(i).getInwardDate())
										? Utils.getDateString(objStorePro.get(i).getInwardDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getAuthDate())
										? Utils.getDateString(objStorePro.get(i).getAuthDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getReturnDate())
										? Utils.getDateString(objStorePro.get(i).getReturnDate())
										: "",
								!Utils.isEmpty(objStorePro.get(i).getOutwardDate())
										? Utils.getDateString(objStorePro.get(i).getOutwardDate())
										: "",
								objStorePro.get(i).getEventType() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", "", "", "", "",
							PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0, 1 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public boolean isDetailRpt(PageDetails pageDetail) {
		return PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey())
				.equalsIgnoreCase(PvuConstant.STR_ONE);
	}

	public String getInwardCaseForROPCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISInwardCaseEventCountReportView> objStorePro = misService.getInwardCaseRopReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 2;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EVENTTYPE,
					PvuConstant.PVU_MIS_NO_OF_INWARDED_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1), new Object[] { String.valueOf(i + 1),
						objStorePro.get(i).getLookUpInfoName(), objStorePro.get(i).getInwardCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getInwardCaseForEventCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISInwardCaseEventCountReportView> objStorePro = misService
					.getInwardCaseForEventCountReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 2;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EVENTTYPE,
					PvuConstant.PVU_MIS_NO_OF_INWARDED_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1), new Object[] { String.valueOf(i + 1),
						objStorePro.get(i).getLookUpInfoName(), objStorePro.get(i).getInwardCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getOutwardCaseForEventCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISOutwardCaseForEventCountView> objStorePro = misService.getOutwardCaseForEventCountReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 2;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForOutwardCaseEventReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EVENTTYPE,
					PvuConstant.PVU_MIS_NO_OF_INWARDED_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1), new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEventName(),
						objStorePro.get(i).getOutwardCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getForwardCasesDDOCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISForwardCaseDdoCountReportView> objStorePro = misService.getForwardCaseDdoWiseCountReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 7;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForForwardCaseDdoEventReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DISTRICTNAME,
							PvuConstant.PVU_MIS_OFFICE_NAME, PvuConstant.PVU_MIS_AUTHORIZED,
							PvuConstant.PVU_MIS_RETURNED, PvuConstant.PVU_MIS_INPROGRESS, PvuConstant.PVU_MIS_REJECTED,
							PvuConstant.PVU_MIS_TOTAL });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getDistName(),
								objStorePro.get(i).getOfficeName(), objStorePro.get(i).getAuthCases(),
								objStorePro.get(i).getReturnCases(), objStorePro.get(i).getInProgress(),
								objStorePro.get(i).getRejectedCases(), objStorePro.get(i).getTotalCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getReturnCasesCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISReturnCaseCountReportView> objStorePro = misService.getReturnCaseEventCountReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 2;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForReturnCaseEventReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO,
					PvuConstant.PVU_MIS_PARENT_DEP, PvuConstant.PVU_MIS_NO_OF_CASES_RETURNED });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1), new Object[] { String.valueOf(i + 1),
						objStorePro.get(i).getLookUpInfoName(), objStorePro.get(i).getLookUpInfo() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getEventWisePendingStatusCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISEventWisePendingStatusReportView> objStorePro = misService
					.getEventWisePendingStatusCountReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 2;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEventWisePendingStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO,
					PvuConstant.PVU_MIS_EVENT_NAME, PvuConstant.PVU_MIS_PENDING_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1), new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEventName(),
						objStorePro.get(i).getPendingCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getDistrictWisePendingStatusCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISReturnCaseCountReportView> objStorePro = misService
					.getDistrictWisePendingStatusCountReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 2;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO,
					PvuConstant.PVU_MIS_DISTRICTNAME, PvuConstant.PVU_MIS_PENDING_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1), new Object[] { String.valueOf(i + 1),
						objStorePro.get(i).getLookUpInfoName(), objStorePro.get(i).getLookUpInfo() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getDepartmentWisePendingStatusCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISReturnCaseCountReportView> objStorePro = misService
					.getDepartWisePendingStatusCountReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 2;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO,
					PvuConstant.PVU_MIS_PARENT_DEP, PvuConstant.PVU_MIS_PENDING_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1), new Object[] { String.valueOf(i + 1),
						objStorePro.get(i).getLookUpInfoName(), objStorePro.get(i).getLookUpInfo() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getEmpWiseMOnthlyProgressCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISEmployeeMonthlyProgressCountReportView> objStorePro = misService
					.getEmployeeMonthlyProgressCountReport(pageDetail).getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 8;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEmpWiseMOnthlyProgressReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNAME,
							PvuConstant.PVU_MIS_OPENING_BAL, PvuConstant.PVU_MIS_RECEIVED_CASES,
							PvuConstant.PVU_MIS_AUTH_CASE, PvuConstant.PVU_MIS_RET_CASE, PvuConstant.PVU_MIS_REJECTED,
							PvuConstant.PVU_MIS_TOTAL_CASES, PvuConstant.PVU_MIS_CLOSING_BAL });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmpName(),
								objStorePro.get(i).getOpeningBalance(), objStorePro.get(i).getReceivedCases(),
								objStorePro.get(i).getAuthorizedCases(), objStorePro.get(i).getReturnedCases(),
								objStorePro.get(i).getRejectedCases(), objStorePro.get(i).getTotalCases(),
								objStorePro.get(i).getClosingBalance() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER,
					new Object[] {
							PvuConstant.PVU_MIS_GEN_BY + PageDetails.getValue(pageDetail,
									PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()),
							"", "", "", "", PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Integer getTotalCount(PageDetails pageDetail) {
		return Integer.valueOf(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_TOTAL_ELEMENT.getKey()));
	}

	public String getEmpWiseWorkdoneCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<MISEmpWiseWorkdoneReportView> objStorePro = misService.getEmpWiseWorkdoneCountWiseReport(pageDetail)
					.getResult();
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 4;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER,
					new Object[] { misService.getUserSelectedKeyValueForEmpWiseWorkdoneReport(pageDetail) });
			data.put(PvuConstant.PVU_MIS_HEADER, new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_AUTH_CASE, PvuConstant.PVU_MIS_RET_CASE, PvuConstant.PVU_MIS_TOTAL_CASES });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmpName(),
								objStorePro.get(i).getAuthCases(), objStorePro.get(i).getReturnCases(),
								objStorePro.get(i).getTotalCases() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getDurationCountWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISDurationPendingEnumOneReport> objStorePro = misService
					.getDurationWisePendingStatusCombinationOneReportListing(pageDetail);
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 4;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER, new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DUR_7DAYS,
							PvuConstant.PVU_MIS_DUR_BET_7, PvuConstant.PVU_MIS_DUR_BET_15,
							PvuConstant.PVU_MIS_DUR_MORE_THAN_7 });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getDaysOne(),
								objStorePro.get(i).getDaysTwo(), objStorePro.get(i).getDaysThree(),
								objStorePro.get(i).getDaysFour() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getDurationLevelWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISDurationPendingEnumOneReport> objStorePro = misService
					.getDurationWisePendingStatusCombinationOneReportListing(pageDetail);
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 4;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER, new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DUR_CASE_PEN,
							PvuConstant.PVU_MIS_DUR_REG_LVL, PvuConstant.PVU_MIS_DUR_VERI_LVL,
							PvuConstant.PVU_MIS_DUR_APPR_LVL });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getDaysOne(),
								objStorePro.get(i).getDaysTwo(), objStorePro.get(i).getDaysThree(),
								objStorePro.get(i).getDaysFour() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getDurationEmployeeWiseReportExcel(PageDetails pageDetail) throws CustomException {
		try {
			List<MISDurationPendingEnumTwoReport> objStorePro = misService
					.getDurationWisePendingStatusCombinationThreeReportListing(pageDetail);
			String rptName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey());
			int totColoumn = 1;
			Map<String, Object[]> data = new LinkedHashMap<>();
			data.put(PvuConstant.PVU_MIS_CONS_FILTER, new Object[] { "" });
			data.put(PvuConstant.PVU_MIS_HEADER,
					new Object[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNAME });

			for (int i = 0; i < objStorePro.size(); i++) {
				data.put(String.valueOf(i + 1),
						new Object[] { String.valueOf(i + 1), objStorePro.get(i).getEmpName() });
			}

			data.put(PvuConstant.PVU_MIS_FOOTER, new Object[] { PvuConstant.PVU_MIS_GEN_BY
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()) });
			data.put(PvuConstant.PVU_MIS_DATE_TIME,
					new Object[] { PvuConstant.PVU_MIS_GEN_DATETIME + Utils.getCurrentDateTime() });

			return generateExcel(pageDetail, rptName, data, objStorePro.size(), totColoumn, new int[] { 0 });
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
