package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
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
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.GenericDaoImpl;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.pvu.dto.EmpCreationLookUpView;
import gov.ifms.pvu.dto.MISCommonScreenLookUpView;
import gov.ifms.pvu.dto.MISDistrictCaseReportView;
import gov.ifms.pvu.dto.MISDistrictWisePendingStatusReportView;
import gov.ifms.pvu.dto.MISDurationPendingEnumOneReport;
import gov.ifms.pvu.dto.MISDurationPendingEnumTwoReport;
import gov.ifms.pvu.dto.MISEmpWiseAllocationReportView;
import gov.ifms.pvu.dto.MISEmpWiseMonthlyProgressLookUpView;
import gov.ifms.pvu.dto.MISEmpWiseWorkdoneDetailReportView;
import gov.ifms.pvu.dto.MISEmpWiseWorkdoneReportView;
import gov.ifms.pvu.dto.MISEmployeeMonthlyProgressCountReportView;
import gov.ifms.pvu.dto.MISEventWisePendingStatusReportView;
import gov.ifms.pvu.dto.MISForwardCaseDdoCountReportView;
import gov.ifms.pvu.dto.MISInwardCaseEventCountReportView;
import gov.ifms.pvu.dto.MISInwardCaseLookupView;
import gov.ifms.pvu.dto.MISInwardCaseReportView;
import gov.ifms.pvu.dto.MISOutwardCaseForEventCountView;
import gov.ifms.pvu.dto.MISPvuEmpMonthlyProgressCountTempReportView;
import gov.ifms.pvu.dto.MISPvuEventStatusReportView;
import gov.ifms.pvu.dto.MISReturnCaseCountReportView;
import gov.ifms.pvu.dto.MISReturnCaseReportView;
import gov.ifms.pvu.dto.MISStatusLookUpView;
import gov.ifms.pvu.dto.MISTranRemarksView;
import gov.ifms.pvu.dto.PVUMISCaseInqReportsVIew;
import gov.ifms.pvu.dto.PVUMISEmployeeCreationReportsView;
import gov.ifms.pvu.dto.PVUMISOutwardCaseReportsView;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUMISReportsServiceImpl.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 */
@Service
public class PVUMISReportsServiceImpl implements PVUMISReportsService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The repository.
	 */
	@Autowired
	private GenericDaoImpl repostiory;

	private static final Font officeFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
	private static final Font bodyFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 8, BaseColor.BLACK);

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<EmpCreationLookUpView>> getLookUpInfoAsMap(String procedureName) throws CustomException {
		try {
			Map<String, List<EmpCreationLookUpView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<EmpCreationLookUpView> lstPVUEmployeCreationDDLView = this.lookupEmpCreationSp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(EmpCreationLookUpView::getLookUpName));
			return resultMap;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup pay comm and status.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EmpCreationLookUpView> lookupEmpCreationSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repostiory.callStoredProcedure(procName);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, EmpCreationLookUpView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the all lu look up info.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EmpCreationLookUpView> getLookUpInfo(String procedureName) throws CustomException {
		try {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			return this.lookupEmpCreationSp(procName);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<PVUMISCaseInqReportsVIew> getCaseInquiryReport(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapCaseInqList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_CASE_INQUIRY_RPT).toString();

			List<PVUMISCaseInqReportsVIew> objStorePro = this.storeProcPvu(procName, map,
					PVUMISCaseInqReportsVIew.class);

			if (Utils.isEmpty(objStorePro)) {
				throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
			}

			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.get(0).getTotalRowCount(), objStorePro);
		} catch (CustomException ex) {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapCaseInqList(PageDetails pageDetail) {
		Map<String, String> collect = getCaseInqSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getCaseInqSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PRAN_NO);
	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repostiory.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	@Override
	public PagebleDTO<PVUMISEmployeeCreationReportsView> getEmployeeCreationReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapEmpCreationList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMPLOYEE_CREATION_RPT).toString();
			List<PVUMISEmployeeCreationReportsView> objStorePro = this.storeProcPvu(procName, map,
					PVUMISEmployeeCreationReportsView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0,
					!Utils.isEmpty(objStorePro) ? objStorePro.get(0).getTotalRowCount() : 0, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapEmpCreationList(PageDetails pageDetail) {
		Map<String, String> collect = getEmpCreationSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getEmpCreationSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_FROM, PVUSearchEnum.PVU_SEARCH_FIELD_TO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_STATUS);
	}

	@Override
	public List<MISStatusLookUpView> getStatusLookUpInfoAsMap(String procedureName) throws CustomException {
		try {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			return this.lookupStatusSp(procName);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup for Event list.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<MISStatusLookUpView> lookupStatusSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repostiory.callStoredProcedure(procName);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, MISStatusLookUpView.class)
				: Collections.emptyList();
	}

	@Override
	public PagebleDTO<MISInwardCaseReportView> getInwardCaseReport(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardCaseList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_INWARD_CASE_ROP_RPT).toString();
			List<MISInwardCaseReportView> objStorePro = this.storeProcPvu(procName, map, MISInwardCaseReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, getTotalCount(pageDetail), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapInwardCaseList(PageDetails pageDetail) {
		Map<String, String> collect = getInwardCaseSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getInwardCaseSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO);
	}

	@Override
	public PagebleDTO<MISInwardCaseEventCountReportView> getInwardCaseRopReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardCaseList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_INWARD_CASE_ROP_RPT).toString();
			List<MISInwardCaseEventCountReportView> objStorePro = this.storeProcPvu(procName, map,
					MISInwardCaseEventCountReportView.class);

			long size = objStorePro.stream()
					.filter(i -> i.getLookUpInfoName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
							&& Utils.isEmpty(i.getInwardCases()))
					.count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<MISInwardCaseLookupView> getInwardCaseLookUpInfoAsMap(String procedureName) throws CustomException {
		try {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			return this.lookupInwardCaseLookUpSp(procName);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<MISInwardCaseLookupView> lookupInwardCaseLookUpSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repostiory.callStoredProcedure(procName);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, MISInwardCaseLookupView.class)
				: Collections.emptyList();
	}

	@Override
	public List<MISInwardCaseLookupView> getDdoForwardLookUpInfoAsMap(String procedureName) throws CustomException {
		try {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			return this.lookupInwardCaseLookUpSp(procName);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String inwardListReport(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return inwardCaseForROPCountWisePDFReport(pageDetail);
		}
		pageDetail.setPageElement(getTotalCount(pageDetail));
		List<MISInwardCaseReportView> inwardList = this.getInwardCaseReport(pageDetail).getResult();

		String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
		String officeAdd = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());
		Document document = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter writer = PdfWriter.getInstance(document, out);
			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PvuConstant.PVU_MIS_INWARDCASE_RPTNAME);
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			document.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			document.add(filterPara);
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(13);
			table.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 35f, 55f, 35f, 55f, 40f, 40f, 40f, 40f, 40f, 40f, 40f, 35f };
			table.setWidths(columnWidths);
			table.setWidthPercentage(100);

			// Add PDF Table Header ->
			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME, "GPF/PPAN No",
					"DDO Office", PvuConstant.PVU_MIS_ENDORSEMENT, PvuConstant.PVU_MIS_STATUS,
					PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE, PvuConstant.PVU_MIS_AUTHDATE,
					PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE, PvuConstant.PVU_MIS_EVENTTYPE)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						table.addCell(header);
					});

			int index = 0;

			for (MISInwardCaseReportView empProgressObj : inwardList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				table.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				table.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				table.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				table.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				table.addCell(officeName);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				table.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				table.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				table.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				table.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				table.addCell(authDate);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				table.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				table.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				table.addCell(eventType);

			}
			document.add(table);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			document.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Inward_case.pdf");
			header.setContentLength(out.toByteArray().length);
			document.close();
		} catch (DocumentException e) {
			e.getMessage();
		}
		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	@Override
	public PagebleDTO<PVUMISEmployeeCreationReportsView> getDdoForwardCaseReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapDdoForwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DDO_FORWARD_CASES_RPT).toString();
			List<PVUMISEmployeeCreationReportsView> objStorePro = this.storeProcPvu(procName, map,
					PVUMISEmployeeCreationReportsView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0,
					!Utils.isEmpty(objStorePro) ? objStorePro.get(0).getTotalRowCount() : 0, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapDdoForwardList(PageDetails pageDetail) {
		Map<String, String> collect = getDdoForwardSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getDdoForwardSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_FROM, PVUSearchEnum.PVU_SEARCH_FIELD_TO,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE);
	}

	public String employeeCreationReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
		List<PVUMISEmployeeCreationReportsView> empCreationList = this.getEmployeeCreationReport(pageDetail)
				.getResult();

		Document empReportDoc = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

		String officeName = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
		String officeAddress = PageDetails.getValue(pageDetail,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

		try {

			PdfWriter writer = PdfWriter.getInstance(empReportDoc, out);
			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Employee Creation Report");
			event.setOfficeName(officeName);
			event.setOfficeAddress(officeAddress);

			empReportDoc.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForEmpCreationReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			empReportDoc.add(filterPara);

			empReportDoc.add(Chunk.NEWLINE);

			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 40f, 65f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			// Add PDF Table Header ->
			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_CASENO, PvuConstant.PVU_MIS_DESIGNATION, PvuConstant.PVU_MIS_CLASS,
					PvuConstant.PVU_MIS_JOININGDATE, "DOB", PvuConstant.PVU_MIS_RETIREMENTDATE,
					PvuConstant.PVU_MIS_DEATHDATE, "PAN Card", PvuConstant.PVU_MIS_OFFICENAME,
					PvuConstant.PVU_MIS_STATUS).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (PVUMISEmployeeCreationReportsView empObj : empCreationList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empObj.getEmployeeNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empObj.getEmployeeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell caseNo = getPDFCell(empObj.getCaseNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(caseNo);

				PdfPCell desg = getPDFCell(empObj.getDesignationName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(desg);

				PdfPCell empClass = getPDFCell(empObj.getEmpClass(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empClass);

				PdfPCell joiningDate = getPDFCell(empObj.getJoiningDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empObj.getJoiningDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(joiningDate);

				PdfPCell dob = getPDFCell(
						empObj.getDob() != null ? PvuUtils.getDateToStringDMYFormatValue(empObj.getDob()) : "",
						Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(dob);

				PdfPCell ret = getPDFCell(empObj.getRetirementDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empObj.getRetirementDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(ret);

				PdfPCell deathDate = getPDFCell(
						empObj.getDeathDate() != null ? PvuUtils.getDateToStringDMYFormatValue(empObj.getDeathDate())
								: "",
						Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(deathDate);

				PdfPCell pan = getPDFCell(empObj.getPanNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pan);

				PdfPCell off = getPDFCell(empObj.getOfficeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(off);

				PdfPCell status = getPDFCell(empObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

			}
			empReportDoc.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			empReportDoc.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Employee_Creation.pdf");
			header.setContentLength(out.toByteArray().length);

			empReportDoc.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String caseInquiryReportPDF(PageDetails pageDetail) throws CustomException {

		Map<String, Object> map = buildPageInMapCaseInqList(pageDetail);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_CASE_INQUIRY_RPT).toString();
		List<PVUMISCaseInqReportsVIew> caseInquiryList = this.storeProcPvu(procName, map,
				PVUMISCaseInqReportsVIew.class);

		Document document = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

		String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
		String officeAdd = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter writer = PdfWriter.getInstance(document, out);
			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Case Inquiry  Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);
			document.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForCaseInqReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			document.add(filterPara);
			document.add(Chunk.NEWLINE);
			PdfPTable table = new PdfPTable(4);

			float[] columnWidths = new float[] { 40f, 40f, 40f, 40f };

			table.setWidths(columnWidths);
			table.setWidthPercentage(100);

			PdfPCell inwardNo = getPDFCellCaseInquiry("Inward No", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(inwardNo);
			PdfPCell inwardNoData = getPDFCell(caseInquiryList.get(0).getInwardNumber(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(inwardNoData);

			PdfPCell inwardDate = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_INWARDDATE, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(inwardDate);
			PdfPCell inwardDateData = getPDFCell(!Utils.isEmpty(caseInquiryList.get(0).getInwardDate())
					? Utils.getDateString(caseInquiryList.get(0).getInwardDate())
					: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(inwardDateData);

			PdfPCell empNo = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_EMPNO, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(empNo);
			PdfPCell empNoData = getPDFCell(caseInquiryList.get(0).getEmployeeNo(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(empNoData);

			PdfPCell empName = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_EMPNAME, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(empName);
			PdfPCell empNameData = getPDFCell(caseInquiryList.get(0).getEmployeeName(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(empNameData);

			PdfPCell retireDate = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_RETIREMENTDATE, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(retireDate);
			PdfPCell retireDateData = getPDFCell(!Utils.isEmpty(caseInquiryList.get(0).getRetirementDate())
					? Utils.getDateString(caseInquiryList.get(0).getRetirementDate())
					: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(retireDateData);

			PdfPCell deathDate = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_DEATHDATE, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(deathDate);
			PdfPCell deathDateData = getPDFCell(!Utils.isEmpty(caseInquiryList.get(0).getDeathDate())
					? Utils.getDateString(caseInquiryList.get(0).getDeathDate())
					: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(deathDateData);

			PdfPCell ddoOffice = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_DDO_OFFICENAME, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(ddoOffice);
			PdfPCell ddoOfficeData = getPDFCell(caseInquiryList.get(0).getOfficeName(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(ddoOfficeData);

			PdfPCell add = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_OFFICE_ADDRESS, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(add);
			PdfPCell addData = getPDFCell(caseInquiryList.get(0).getOfficeAddress(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(addData);

			PdfPCell dep = getPDFCellCaseInquiry("Department Name", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(dep);
			PdfPCell depData = getPDFCell(caseInquiryList.get(0).getDepartmentName(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(depData);

			PdfPCell endorse = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_ENDORSEMENT, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(endorse);
			PdfPCell endorseData = getPDFCell(caseInquiryList.get(0).getEndorsement(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(endorseData);

			PdfPCell eventType = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_EVENTTYPE, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(eventType);
			PdfPCell eventTypeData = getPDFCell(caseInquiryList.get(0).getEventName(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(eventTypeData);

			PdfPCell status = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_STATUS, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(status);
			PdfPCell statusData = getPDFCell(caseInquiryList.get(0).getStatus(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(statusData);

			PdfPCell lying = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_LYINGWITH, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(lying);
			PdfPCell lyingData = getPDFCell(caseInquiryList.get(0).getLyingWith(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(lyingData);

			PdfPCell outwardDate = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_OUTWARDDATE, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(outwardDate);
			PdfPCell outwardDateData = getPDFCell(!Utils.isEmpty(caseInquiryList.get(0).getOutwardDate())
					? Utils.getDateString(caseInquiryList.get(0).getOutwardDate())
					: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(outwardDateData);

			PdfPCell outwardBy = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_OUTWARD_BY, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(outwardBy);
			PdfPCell outwardByData = getPDFCell(caseInquiryList.get(0).getOutwardBy(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(outwardByData);

			PdfPCell outwardNo = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_STATUS, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(outwardNo);
			PdfPCell outwardNoData = getPDFCell(caseInquiryList.get(0).getOutwardNumber(), Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(outwardNoData);

			PdfPCell postTrackingNo = getPDFCellCaseInquiry("Post Tracking Id. Number", Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(postTrackingNo);
			PdfPCell postTrackingNoData = getPDFCell(caseInquiryList.get(0).getPostConsignmentNo(),
					Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(postTrackingNoData);

			PdfPCell authDate = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_AUTHDATE, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(authDate);
			PdfPCell authDateData = getPDFCell(!Utils.isEmpty(caseInquiryList.get(0).getAuthDate())
					? Utils.getDateString(caseInquiryList.get(0).getAuthDate())
					: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(authDateData);

			PdfPCell returnDate = getPDFCellCaseInquiry(PvuConstant.PVU_MIS_RETDATE, Element.ALIGN_MIDDLE,
					Element.ALIGN_CENTER);
			table.addCell(returnDate);
			PdfPCell returnDateData = getPDFCell(!Utils.isEmpty(caseInquiryList.get(0).getReturnDate())
					? Utils.getDateString(caseInquiryList.get(0).getReturnDate())
					: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(returnDateData);

			PdfPCell blankField = getPDFCellCaseInquiry("", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(blankField);
			PdfPCell blankFieldData = getPDFCell("", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
			table.addCell(blankFieldData);

			document.add(table);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			document.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Case_Inquiery.pdf");
			header.setContentLength(out.toByteArray().length);

			document.close();

		} catch (Exception ex) {
			ex.getMessage();
		}
		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public PdfHeader getPDFHeader(PdfWriter writer, String header, String officeName, String officeAddress) {
		PdfHeader pdfHeader = new PdfHeader();
		writer.setPageEvent(pdfHeader);
		pdfHeader.setHeader(header);
		pdfHeader.setOfficeName(officeName);
		pdfHeader.setOfficeAddress(officeAddress);
		return pdfHeader;
	}

	public String ddoForwardCaseReportPDF(PageDetails pageDetail) throws CustomException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<PVUMISEmployeeCreationReportsView> ddoForwardList = this.getDdoForwardCaseReport(pageDetail)
					.getResult();
			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);
			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());
			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);
			String reportName = "DDO Forward Report";
			this.getPDFHeader(writer, reportName, office, officeAdd);
			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForDdoForwardReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 40f, 65f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);
			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_CASENO, PvuConstant.PVU_MIS_DESIGNATION, PvuConstant.PVU_MIS_CLASS,
					PvuConstant.PVU_MIS_JOININGDATE, "DOB", PvuConstant.PVU_MIS_RETIREMENTDATE,
					PvuConstant.PVU_MIS_DEATHDATE, "PAN Card", PvuConstant.PVU_MIS_OFFICE_NAME,
					PvuConstant.PVU_MIS_STATUS).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (PVUMISEmployeeCreationReportsView empObj : ddoForwardList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empObj.getEmployeeNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empObj.getEmployeeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell caseNo = getPDFCell(empObj.getCaseNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(caseNo);

				PdfPCell desg = getPDFCell(empObj.getDesignationName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(desg);

				PdfPCell empClass = getPDFCell(empObj.getEmpClass(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empClass);

				PdfPCell joiningDate = getPDFCell(empObj.getJoiningDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empObj.getJoiningDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(joiningDate);

				PdfPCell dob = getPDFCell(
						empObj.getDob() != null ? PvuUtils.getDateToStringDMYFormatValue(empObj.getDob()) : "",
						Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(dob);

				PdfPCell ret = getPDFCell(empObj.getRetirementDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empObj.getRetirementDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(ret);

				PdfPCell deathDate = getPDFCell(
						empObj.getDeathDate() != null ? PvuUtils.getDateToStringDMYFormatValue(empObj.getDeathDate())
								: "",
						Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(deathDate);

				PdfPCell pan = getPDFCell(empObj.getPanNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pan);

				PdfPCell off = getPDFCell(empObj.getOfficeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(off);

				PdfPCell status = getPDFCell(empObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Ddo_Forward.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

// forward Case DDO wise Report
	public String forwardCaseDDOWiseReportPDF(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return forwardCasesDDOCountWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			pageDetail.setPageElement(getTotalCount(pageDetail));
			List<MISInwardCaseReportView> forwardCaseDDOWiseList = this.getForwardCaseDdoWiseDetailReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Forward DDO Wise Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForForwardCaseDdoEventReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);

			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 45f, 55f, 55f, 65f, 35f, 30f, 55f, 50f, 50f, 50f, 50f, 45f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_OFFICE_NAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETURNED, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseReportView empProgressObj : forwardCaseDDOWiseList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ForwardCase_DDO_Wise_Report.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}
// Return Case Report Start

	public String returnCaseReportPDF(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return returnCasesCountWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			List<MISReturnCaseReportView> returnCaseReportList = this.getReturnCaseEventDetailReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Return Case Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForReturnCaseEventReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);

			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 50f, 65f, 35f, 65f, 35f, 35f, 50f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_OFFICE_NAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISReturnCaseReportView forwardCaseObj : returnCaseReportList) {
				
				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(forwardCaseObj.getEmployeeNo(), Element.ALIGN_MIDDLE,Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);
				
				PdfPCell empName = getPDFCell(forwardCaseObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(forwardCaseObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(forwardCaseObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(forwardCaseObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(forwardCaseObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(forwardCaseObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(forwardCaseObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(forwardCaseObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(forwardCaseObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(forwardCaseObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(forwardCaseObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Return_Case.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String inwardCaseDetailsReportPDF(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return inwardCaseForEventCountWisePDFReport(pageDetail);
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			pageDetail.setPageElement(getTotalCount(pageDetail));
			List<MISInwardCaseReportView> inwardCaseDetailsList = this.getInwardCaseForEventDetailReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PvuConstant.PVU_MIS_INWARDCASE_EVENT_RPTNAME);
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);
			ddoReport.add(Chunk.NEWLINE);

			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 50f, 65f, 50f, 65f, 50f, 50f, 50f, 50f, 50f, 50f, 50f, 55f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_OFFICE_NAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseReportView forwardCaseObj : inwardCaseDetailsList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(forwardCaseObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(forwardCaseObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(forwardCaseObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(forwardCaseObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(forwardCaseObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(forwardCaseObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(forwardCaseObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(forwardCaseObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(forwardCaseObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(forwardCaseObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(forwardCaseObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(forwardCaseObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ForwardCase_DDO_Wise.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String outwardCaseEventReportPDF(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return outwardCaseForEventCountWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			pageDetail.setPageElement(getTotalCount(pageDetail));
			List<PVUMISOutwardCaseReportsView> outwardEventList = this.getOutwardReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Outward Case Event Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);
			ddoReport.open();
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForOutwardCaseEventReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);

			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] width = new float[] { 15f, 40f, 65f, 35f, 65f, 35f, 35f, 35f, 35f, 35f, 35f, 35f, 35F };
			employeeTbl.setWidths(width);
			employeeTbl.setWidthPercentage(100);

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_OFFICE_NAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (PVUMISOutwardCaseReportsView forwardCaseObj : outwardEventList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(forwardCaseObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(forwardCaseObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(forwardCaseObj.getGpfNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(forwardCaseObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(forwardCaseObj.getEndorsment(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(forwardCaseObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(forwardCaseObj.getLyingwith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(forwardCaseObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(forwardCaseObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(forwardCaseObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(forwardCaseObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(forwardCaseObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(forwardCaseObj.getEventName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Outward_Case_Event_Report.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public class PdfHeader extends PdfPageEventHelper {

		String header;

		String officeName;

		String officeAddress;

		PdfTemplate total;

		public void setHeader(String header) {
			this.header = header;
		}

		public void setOfficeName(String officeName) {
			this.officeName = officeName;
		}

		public void setOfficeAddress(String officeAddress) {
			this.officeAddress = officeAddress;
		}

		@Override
		public void onCloseDocument(PdfWriter writer, Document document) {
			ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(writer.getPageNumber())), 2,
					2, 0);
		}

		@Override
		public void onOpenDocument(PdfWriter writer, Document document) {
			total = writer.getDirectContent().createTemplate(30, 16);
		}

		@Override
		public void onEndPage(PdfWriter writer, Document document) {
			PdfPTable table = new PdfPTable(3);
			try {
				table.setWidths(new int[] { 24, 24, 2 });
				table.setTotalWidth(700);
				table.getDefaultCell().setFixedHeight(20);
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

				ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(header), 400, 550, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(officeName), 400, 535, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(officeAddress), 400, 520, 0);

			} catch (Exception de) {
				de.getMessage();
			}
		}

	}

	public String getUserSelectedKeyValueForCaseInqReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME, PVUSearchEnum.PVU_MIS_REPORT_EMPNO,
						PVUSearchEnum.PVU_MIS_REPORT_PANNO, PVUSearchEnum.PVU_MIS_REPORT_CASENO,
						PVUSearchEnum.PVU_MIS_REPORT_REFNO));
	}

	public String getUserSelectedKeyValueForEmpCreationReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail, Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_FROMDATE,
				PVUSearchEnum.PVU_MIS_REPORT_TODATE, PVUSearchEnum.PVU_MIS_REPORT_STATUS));

	}

	public String getUserSelectedKeyValueForInwardCaseROPReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME, PVUSearchEnum.PVU_MIS_REPORT_FROMDATE,
						PVUSearchEnum.PVU_MIS_REPORT_TODATE, PVUSearchEnum.PVU_MIS_REPORT_EMPNO));

	}

	public String getUserSelectedKeyValueForDdoForwardReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_PAYCOMMISION, PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME,
						PVUSearchEnum.PVU_MIS_REPORT_FROMDATE, PVUSearchEnum.PVU_MIS_REPORT_TODATE));

	}

	@Override
	public PagebleDTO<MISInwardCaseEventCountReportView> getInwardCaseForEventCountReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getInwardCaseForEventSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_INWARD_CASE_EVENT_RPT).toString();
			List<MISInwardCaseEventCountReportView> objStorePro = this.storeProcPvu(procName, map,
					MISInwardCaseEventCountReportView.class);

			long size = objStorePro.stream()
					.filter(i -> i.getLookUpInfoName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
							&& Utils.isEmpty(i.getInwardCases()))
					.count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<MISInwardCaseReportView> getInwardCaseForEventDetailReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getInwardCaseForEventSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_INWARD_CASE_EVENT_RPT).toString();
			List<MISInwardCaseReportView> objStorePro = this.storeProcPvu(procName, map, MISInwardCaseReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, getTotalCount(pageDetail), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getInwardCaseForEventSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO);
	}

	@Override
	public PagebleDTO<PVUMISOutwardCaseReportsView> getOutwardReport(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageOutwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_OUTWARD_CASE_EVENT_RPT).toString();
			List<PVUMISOutwardCaseReportsView> outwardList = this.storeProcPvu(procName, map,
					PVUMISOutwardCaseReportsView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, getTotalCount(pageDetail), outwardList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Map<String, List<MISCommonScreenLookUpView>> getOutwardLookUpInfoAsMap(String procedureName)
			throws CustomException {
		try {
			Map<String, List<MISCommonScreenLookUpView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<Object[]> objectPvuSp = repostiory.callStoredProcedure(procName);
			List<MISCommonScreenLookUpView> lstPVUEmployeCreationDDLView = !objectPvuSp.isEmpty()
					? NativeQueryResultsMapper.map(objectPvuSp, MISCommonScreenLookUpView.class)
					: Collections.emptyList();
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(MISCommonScreenLookUpView::getScrrenType));
			return resultMap;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageOutwardList(PageDetails pageDetail) {
		Map<String, String> collect = getOutwardEventSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getOutwardEventSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_IN_CASE_STATUS);
	}

	@Override
	public Map<String, List<MISCommonScreenLookUpView>> getCommonScreenLookUp(String procedureName)
			throws CustomException {
		try {
			Map<String, List<MISCommonScreenLookUpView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<Object[]> objectPvuSp = repostiory.callStoredProcedure(procName);
			List<MISCommonScreenLookUpView> lstPVUEmployeCreationDDLView = !objectPvuSp.isEmpty()
					? NativeQueryResultsMapper.map(objectPvuSp, MISCommonScreenLookUpView.class)
					: Collections.emptyList();
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(MISCommonScreenLookUpView::getScrrenType));
			return resultMap;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<MISOutwardCaseForEventCountView> getOutwardCaseForEventCountReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageOutwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_OUTWARD_CASE_EVENT_RPT).toString();
			List<MISOutwardCaseForEventCountView> objStorePro = this.storeProcPvu(procName, map,
					MISOutwardCaseForEventCountView.class);

			long size = objStorePro.stream().filter(i -> i.getEventName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
					&& Utils.isEmpty(i.getOutwardCases())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getUserSelectedKeyValueForOutwardCaseEventReport(PageDetails pageDetail) {

		StringJoiner joiner = new StringJoiner(" , ");
		String list = getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME, PVUSearchEnum.PVU_MIS_REPORT_FROMDATE,
						PVUSearchEnum.PVU_MIS_REPORT_TODATE, PVUSearchEnum.PVU_MIS_REPORT_EMPNO,
						PVUSearchEnum.PVU_MIS_REPORT_CASESTATUS));
		joiner.add(list);
		if (PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME.getKey()).equalsIgnoreCase("ALL")) {
			String selectedEvent = PVUSearchEnum.PVU_MIS_REPORT_SELECTEDEVENT.getKey() + " : "
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_SELECTEDEVENT.getKey());
			joiner.add(selectedEvent);
		}

		return joiner.toString();
	}

	@Override
	public PagebleDTO<MISInwardCaseReportView> getForwardCaseDdoWiseDetailReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getForwardCaseDdoWiseSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_FORWARD_CASES_DDO_WISE_RPT).toString();
			List<MISInwardCaseReportView> objStorePro = this.storeProcPvu(procName, map, MISInwardCaseReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, getTotalCount(pageDetail), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getForwardCaseDdoWiseSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_ENUM_INDEX, PVUSearchEnum.PVU_SEARCH_DISTRICT,
				PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_FIELD_DDO_CODE,PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE);
	}

	@Override
	public PagebleDTO<MISForwardCaseDdoCountReportView> getForwardCaseDdoWiseCountReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getForwardCaseDdoWiseSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_FORWARD_CASES_DDO_WISE_RPT).toString();
			List<MISForwardCaseDdoCountReportView> objStorePro = this.storeProcPvu(procName, map,
					MISForwardCaseDdoCountReportView.class);

			long size = objStorePro.stream().filter(i -> i.getDistName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
					&& Utils.isEmpty(i.getTotalCases())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<MISReturnCaseCountReportView> getReturnCaseEventCountReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getReturnCaseSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_RETURN_CASE_EVENT_RPT).toString();
			List<MISReturnCaseCountReportView> objStorePro = this.storeProcPvu(procName, map,
					MISReturnCaseCountReportView.class);

			long size = objStorePro.stream()
					.filter(i -> i.getLookUpInfoName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
							&& Utils.isEmpty(i.getLookUpInfo()))
					.count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<MISReturnCaseReportView> getReturnCaseEventDetailReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getReturnCaseSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_RETURN_CASE_EVENT_RPT).toString();
			List<MISReturnCaseReportView> objStorePro = this.storeProcPvu(procName, map, MISReturnCaseReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getReturnCaseSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_DEPEARTMENT, PVUSearchEnum.PVU_SEARCH_DISTRICT);
	}

	public String getUserSelectedKeyValueForReturnCaseEventReport(PageDetails pageDetail) {
		StringJoiner joiner = new StringJoiner(" , ");
		String list = getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME, PVUSearchEnum.PVU_MIS_REPORT_FROMDATE,
						PVUSearchEnum.PVU_MIS_REPORT_TODATE, PVUSearchEnum.PVU_MIS_REPORT_PARENT_DEP,
						PVUSearchEnum.PVU_MIS_REPORT_DISTRICT));
		joiner.add(list);

		if (PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME.getKey()).equalsIgnoreCase("ALL")) {
			String selectedEvent = PVUSearchEnum.PVU_MIS_REPORT_SELECTEDEVENT.getKey() + " : "
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_SELECTEDEVENT.getKey());
			joiner.add(selectedEvent);
		}

		return joiner.toString();
	}

	public String getUserSelectedKeyValueForForwardCaseDdoEventReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_FROMDATE, PVUSearchEnum.PVU_MIS_REPORT_TODATE,
						PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME, PVUSearchEnum.PVU_MIS_REPORT_DISTRICT,
						PVUSearchEnum.PVU_MIS_REPORT_CARDEXNO, PVUSearchEnum.PVU_MIS_REPORT_DDONO,
						PVUSearchEnum.PVU_MIS_REPORT_SELECTEDCASE));
	}

	@Override
	public PagebleDTO<MISDistrictCaseReportView> getDistrictWiseEventReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getDistrictWiseSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DISTRICT_WISE_VERIFICATION_RPT).toString();
			List<MISDistrictCaseReportView> objStorePro = this.storeProcPvu(procName, map,
					MISDistrictCaseReportView.class);

			long size = objStorePro.stream().filter(i -> i.getDistName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
					&& Utils.isEmpty(i.getTotalCases())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getDistrictWiseSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE);
	}

	@Override
	public PagebleDTO<PVUMISEmployeeCreationReportsView> getDdoEventStatusReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getDdoEventStatusSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DDO_EVENT_STATUS_RPT).toString();
			List<PVUMISEmployeeCreationReportsView> objStorePro = this.storeProcPvu(procName, map,
					PVUMISEmployeeCreationReportsView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0,
					!Utils.isEmpty(objStorePro) ? objStorePro.get(0).getTotalRowCount() : 0, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getDdoEventStatusSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE);
	}

	public String getUserSelectedKeyValueForDistrictWiseReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail, Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME));

	}

	public String getUserSelectedKeyValueForDdoEventReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME, PVUSearchEnum.PVU_MIS_REPORT_FROMDATE,
						PVUSearchEnum.PVU_MIS_REPORT_TODATE, PVUSearchEnum.PVU_MIS_REPORT_EMPNO,
						PVUSearchEnum.PVU_MIS_REPORT_PAYCOMMISION));
	}

	@Override
	public PagebleDTO<MISDistrictWisePendingStatusReportView> getDistrictWisePendingStatusReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getDistrictWisePendingSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DISTRICT_WISE_PENDING_STATUS_RPT).toString();
			List<MISDistrictWisePendingStatusReportView> objStorePro = this.storeProcPvu(procName, map,
					MISDistrictWisePendingStatusReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getDistrictWisePendingSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_DISTRICT);
	}

	@Override
	public PagebleDTO<MISReturnCaseCountReportView> getDistrictWisePendingStatusCountReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getDistrictWisePendingSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DISTRICT_WISE_PENDING_STATUS_RPT).toString();
			List<MISReturnCaseCountReportView> objStorePro = this.storeProcPvu(procName, map,
					MISReturnCaseCountReportView.class);

			long size = objStorePro.stream()
					.filter(i -> i.getLookUpInfoName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
							&& Utils.isEmpty(i.getLookUpInfo()))
					.count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<MISTranRemarksView> getTrnRemarks(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, String> collect = getTranRemarksSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_TRN_REMARKS_LIST_RPT).toString();
			List<MISTranRemarksView> objStorePro = this.storeProcPvu(procName, map, MISTranRemarksView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getTranRemarksSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_ID);
	}

	public String getUserSelectedKeyValueForDistrictWisePendingStatusReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_FROMDATE, PVUSearchEnum.PVU_MIS_REPORT_TODATE));
	}

	@Override
	public PagebleDTO<MISDistrictWisePendingStatusReportView> getDepartmentWisePendingEventReport(
			PageDetails pageDetail) throws CustomException {
		try {
			Map<String, String> collect = getDepartmentWisePendingSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DEPARTMENT_WISE_PENDING_STATUS_RPT).toString();
			List<MISDistrictWisePendingStatusReportView> objStorePro = this.storeProcPvu(procName, map,
					MISDistrictWisePendingStatusReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, getTotalCount(pageDetail), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getDepartmentWisePendingSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_FROM,
				PVUSearchEnum.PVU_SEARCH_FIELD_TO, PVUSearchEnum.PVU_SEARCH_DEPARTMENT);
	}

	public PagebleDTO<MISReturnCaseCountReportView> getDepartWisePendingStatusCountReport(PageDetails pageDetail)
			throws CustomException {

		try {
			long size = 0;
			Map<String, String> collect = getDepartmentWisePendingSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DEPARTMENT_WISE_PENDING_STATUS_RPT).toString();
			List<MISReturnCaseCountReportView> objStorePro = this.storeProcPvu(procName, map,
					MISReturnCaseCountReportView.class);

			size = objStorePro.stream().filter(i -> i.getLookUpInfoName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
					&& Utils.isEmpty(i.getLookUpInfo())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public String departmentWisePendingStatusReportPDF(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return departmentWisePendingStatusCountWisePDFReport(pageDetail);
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISDistrictWisePendingStatusReportView> departmentWiseList = this
					.getDepartmentWisePendingEventReport(pageDetail).getResult();
			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(10);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISDistrictWisePendingStatusReportView departmentObj : departmentWiseList) {
				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(departmentObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(departmentObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell gpf = getPDFCell(departmentObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(gpf);

				PdfPCell officeName = getPDFCell(departmentObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(departmentObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(departmentObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(departmentObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(departmentObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(departmentObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell eventType = getPDFCell(departmentObj.getEventName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Department_Pending_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String districtWisePendingStatusReportPDF(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return districtWisePendingStatusCountWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			List<MISDistrictWisePendingStatusReportView> departmentWiseList = this
					.getDistrictWisePendingStatusReport(pageDetail).getResult();
			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("District Wise Pending Status Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(10);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISDistrictWisePendingStatusReportView departmentObj : departmentWiseList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(departmentObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(departmentObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell gpf = getPDFCell(departmentObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(gpf);

				PdfPCell officeName = getPDFCell(departmentObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(departmentObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(departmentObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(departmentObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(departmentObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(departmentObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell eventType = getPDFCell(departmentObj.getEventName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=DepartmentWise_Pending_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	@Override
	public PagebleDTO<MISInwardCaseReportView> getEmployeeWiseMonthlyProgressEventReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getEmployeeWiseMonthlyProgressEventReportSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMP_WISE_MONTHLY_PROGRESS_STATUS_RPT).toString();
			List<MISInwardCaseReportView> objStorePro = this.storeProcPvu(procName, map, MISInwardCaseReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public PagebleDTO<MISEmployeeMonthlyProgressCountReportView> getEmployeeMonthlyProgressCountReport(
			PageDetails pageDetail) throws CustomException {

		try {
			Map<String, String> collect = getEmployeeWiseMonthlyProgressEventReportSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMP_WISE_MONTHLY_PROGRESS_STATUS_RPT).toString();
			List<MISEmployeeMonthlyProgressCountReportView> objStorePro = this.storeProcPvu(procName, map,
					MISEmployeeMonthlyProgressCountReportView.class);

			long size = objStorePro.stream().filter(i -> i.getEmpName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
					&& (Utils.isEmpty(i.getTotalCases()) || i.getTotalCases().equals("0"))).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public List<PVUSearchEnum> getEmployeeWiseMonthlyProgressEventReportSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_IN_MONTH,
				PVUSearchEnum.PVU_SEARCH_IN_YEAR, PVUSearchEnum.PVU_SEARCH_IN_USER_ID,
				PVUSearchEnum.PVU_SEARCH_ENUM_INDEX);
	}

	public String ddoEventsStatusReportPDF(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<PVUMISEmployeeCreationReportsView> ddoEventList = this.getDdoEventStatusReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("DDO Wise Status Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForDdoEventReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME, "Case Number",
					"Designation", "Emp Class", "Joining Date", "DOB", "Retirement Date", "Death Date", "PAN",
					PvuConstant.PVU_MIS_OFFICE_NAME, PvuConstant.PVU_MIS_STATUS).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (PVUMISEmployeeCreationReportsView empObj : ddoEventList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empObj.getEmployeeNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empObj.getEmployeeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell caseNo = getPDFCell(empObj.getCaseNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(caseNo);

				PdfPCell desg = getPDFCell(empObj.getDesignationName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(desg);

				PdfPCell empClass = getPDFCell(empObj.getEmpClass(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empClass);

				PdfPCell joiningDate = getPDFCell(empObj.getJoiningDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empObj.getJoiningDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(joiningDate);

				PdfPCell dob = getPDFCell(
						empObj.getDob() != null ? PvuUtils.getDateToStringDMYFormatValue(empObj.getDob()) : "",
						Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(dob);

				PdfPCell ret = getPDFCell(empObj.getRetirementDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empObj.getRetirementDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(ret);

				PdfPCell deathDate = getPDFCell(
						empObj.getDeathDate() != null ? PvuUtils.getDateToStringDMYFormatValue(empObj.getDeathDate())
								: "",
						Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(deathDate);

				PdfPCell pan = getPDFCell(empObj.getPanNo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pan);

				PdfPCell off = getPDFCell(empObj.getOfficeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(off);

				PdfPCell status = getPDFCell(empObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=DepartmentWise_Pending_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	@Override
	@Cacheable(value = "empWiseLookup" ,key = "#procedureName")
	public List<MISEmpWiseMonthlyProgressLookUpView> getEmpWiseLookUp(String procedureName) throws CustomException {
		try {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<Object[]> objectPvuSp = repostiory.callStoredProcedure(procName);
			return !objectPvuSp.isEmpty()
					? NativeQueryResultsMapper.map(objectPvuSp, MISEmpWiseMonthlyProgressLookUpView.class)
					: Collections.emptyList();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<MISInwardCaseReportView> getPvuEventStatusReport(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, String> collect = getPvuEventStatusSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EVENT_STATUS_RPT).toString();
			List<MISInwardCaseReportView> objStorePro = this.storeProcPvu(procName, map, MISInwardCaseReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getPvuEventStatusSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_ENUM_INDEX);
	}

	public PagebleDTO<MISPvuEmpMonthlyProgressCountTempReportView> tempCountReport(PageDetails pageDetail)
			throws CustomException {
		try {

			Map<String, String> collect = getEmployeeWiseMonthlyProgressEventReportSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);

			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMP_WISE_MONTHLY_PROGRESS_STATUS_RPT).toString();

			List<MISPvuEmpMonthlyProgressCountTempReportView> objStorePro = this.storeProcPvu(procName, map,
					MISPvuEmpMonthlyProgressCountTempReportView.class);

			long size = objStorePro.stream().filter(i -> Utils.isEmpty(i.getTotalCases())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<MISPvuEventStatusReportView> getPvuEventStatusCountReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getPvuEventStatusSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EVENT_STATUS_RPT).toString();
			List<MISPvuEventStatusReportView> objStorePro = this.storeProcPvu(procName, map,
					MISPvuEventStatusReportView.class);

			long size = objStorePro.stream().filter(i -> Utils.isEmpty(i.getTotalCases())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String getEmployeeWiseMonthlyProgressEventPDFReport(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return empWiseMOnthlyProgressCountWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			List<MISInwardCaseReportView> empProgressList = this.getEmployeeWiseMonthlyProgressEventReport(pageDetail)
					.getResult();
			Document ddoReport = new Document(PageSize.A4.rotate(), 36, 106, 110, 60);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Employee Monthly Progress Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForEmpWiseMOnthlyProgressReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_OFFICE_NAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					"Event Type").forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseReportView empProgressObj : empProgressList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=EmployeeMonthly_Progress_Report.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	// Department wise verification Report
	public String departmentWiseVerificationPDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			List<MISDistrictCaseReportView> empProgressList = this.getDepWiseVerificationReport(pageDetail).getResult();
			Document ddoReport = new Document(PageSize.A4.rotate(), 36, 106, 110, 60);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Department Wise Verification Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForDepVeriReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(6);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 55f, 55f, 55f, 55f, 55f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DEPNAME, PvuConstant.PVU_MIS_AUTHORIZED,
					PvuConstant.PVU_MIS_RETURNED, PvuConstant.PVU_MIS_INPROGRESS, PvuConstant.PVU_MIS_TOTAL)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISDistrictCaseReportView empProgressObj : empProgressList) {

				index = index + 1;
				PdfPCell indexCell = new PdfPCell(new Phrase(String.valueOf(index), bodyFont));
				employeeTbl.addCell(indexCell);

				PdfPCell distName = new PdfPCell(
						new Phrase(empProgressObj.getDistName() != null ? empProgressObj.getDistName() : "", bodyFont));
				distName.setPaddingLeft(4);
				distName.setVerticalAlignment(Element.ALIGN_MIDDLE);
				distName.setHorizontalAlignment(Element.ALIGN_CENTER);
				employeeTbl.addCell(distName);

				PdfPCell authCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getAuthCases() != null ? empProgressObj.getAuthCases() : ""),
						bodyFont));
				authCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				authCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				authCases.setPaddingRight(4);
				employeeTbl.addCell(authCases);

				PdfPCell returnCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getReturnCases() != null ? empProgressObj.getReturnCases() : ""),
						bodyFont));
				returnCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				returnCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				returnCases.setPaddingRight(4);
				employeeTbl.addCell(returnCases);

				PdfPCell inProgressCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getInProgress() != null ? empProgressObj.getInProgress() : ""),
						bodyFont));
				inProgressCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				inProgressCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				inProgressCases.setPaddingRight(4);
				employeeTbl.addCell(inProgressCases);

				PdfPCell totalCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getTotalCases() != null ? empProgressObj.getTotalCases() : " "),
						bodyFont));
				totalCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				totalCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				totalCases.setPaddingRight(4);
				employeeTbl.addCell(totalCases);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Department_Wise_Verification_Report.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String districtWiseVerificationPDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			List<MISDistrictCaseReportView> empProgressList = this.getDistrictWiseEventReport(pageDetail).getResult();
			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("District Wise Verification Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForDistrictWiseReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(6);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 55f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DISTRICTNAME, PvuConstant.PVU_MIS_AUTHORIZED,
					PvuConstant.PVU_MIS_RETURNED, PvuConstant.PVU_MIS_INPROGRESS, PvuConstant.PVU_MIS_TOTAL)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISDistrictCaseReportView empProgressObj : empProgressList) {

				index = index + 1;
				PdfPCell indexCell = new PdfPCell(new Phrase(String.valueOf(index), bodyFont));
				employeeTbl.addCell(indexCell);

				PdfPCell distName = new PdfPCell(
						new Phrase(empProgressObj.getDistName() != null ? empProgressObj.getDistName() : "", bodyFont));
				distName.setPaddingLeft(4);
				distName.setVerticalAlignment(Element.ALIGN_MIDDLE);
				distName.setHorizontalAlignment(Element.ALIGN_CENTER);
				employeeTbl.addCell(distName);

				PdfPCell authCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getAuthCases() != null ? empProgressObj.getAuthCases() : ""),
						bodyFont));
				authCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				authCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				authCases.setPaddingRight(4);
				employeeTbl.addCell(authCases);

				PdfPCell returnCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getReturnCases() != null ? empProgressObj.getReturnCases() : ""),
						bodyFont));
				returnCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				returnCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				returnCases.setPaddingRight(4);
				employeeTbl.addCell(returnCases);

				PdfPCell inProgressCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getInProgress() != null ? empProgressObj.getInProgress() : ""),
						bodyFont));
				inProgressCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				inProgressCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				inProgressCases.setPaddingRight(4);
				employeeTbl.addCell(inProgressCases);

				PdfPCell totalCases = new PdfPCell(new Phrase(
						String.valueOf(empProgressObj.getTotalCases() != null ? empProgressObj.getTotalCases() : " "),
						bodyFont));
				totalCases.setVerticalAlignment(Element.ALIGN_MIDDLE);
				totalCases.setHorizontalAlignment(Element.ALIGN_CENTER);
				totalCases.setPaddingRight(4);
				employeeTbl.addCell(totalCases);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Department_Wise_Verification_Report.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String getUserSelectedKeyValueForEmpWiseMOnthlyProgressReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_SELECTEDEMP, PVUSearchEnum.PVU_SEARCH_IN_YEAR,
						PVUSearchEnum.PVU_SEARCH_IN_MONTH, PVUSearchEnum.PVU_MIS_REPORT_SELECTEDCASE));
	}

	@Override
	public PagebleDTO<MISDistrictCaseReportView> getDepWiseVerificationReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getDepWiseSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_DEPT_WISE_VERIFICATION_RPT).toString();
			List<MISDistrictCaseReportView> objStorePro = this.storeProcPvu(procName, map,
					MISDistrictCaseReportView.class);

			long size = objStorePro.stream().filter(i -> i.getDistName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
					&& Utils.isEmpty(i.getTotalCases())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getDepWiseSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_DEPEARTMENT);
	}

	public String getUserSelectedKeyValueForPvuEventStatusReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_FROMDATE, PVUSearchEnum.PVU_MIS_REPORT_TODATE,
						PVUSearchEnum.PVU_MIS_REPORT_PAYCOMMISION, PVUSearchEnum.PVU_MIS_REPORT_EVENTTYPE));

	}

	public String getUserSelectedKeyValueForDepVeriReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail, Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_DEPNAME));
	}

	@Override
	public PagebleDTO<MISInwardCaseReportView> getEventWisePendingStatusReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getEventWisePendingStatusSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EVENTWISE_PENDING_STATUS_RPT).toString();
			List<MISInwardCaseReportView> objStorePro = this.storeProcPvu(procName, map, MISInwardCaseReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getEventWisePendingStatusSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE);
	}

	@Override
	public PagebleDTO<MISEventWisePendingStatusReportView> getEventWisePendingStatusCountReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getEventWisePendingStatusSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EVENTWISE_PENDING_STATUS_RPT).toString();
			List<MISEventWisePendingStatusReportView> objStorePro = this.storeProcPvu(procName, map,
					MISEventWisePendingStatusReportView.class);

			long size = objStorePro.stream().filter(i -> i.getEventName().equalsIgnoreCase(PvuConstant.PVU_MIS_TOTAL)
					&& Utils.isEmpty(i.getPendingCases())).count();

			return size > 0
					? new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList())
					: new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public String eventWisePendingStatusPDFReport(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return eventWisePendingStatusCountWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			List<MISInwardCaseReportView> eventWisePendingList = this.getEventWisePendingStatusReport(pageDetail)
					.getResult();
			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Event Wise Pendig Status Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForEventWisePendingStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 40f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseReportView empProgressObj : eventWisePendingList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					PvuConstant.PVU_MIS_ATT_FILENAME + "Event_Wise_Pendig_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public boolean isDetailRpt(PageDetails pageDetail) {
		return PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey())
				.equalsIgnoreCase(PvuConstant.STR_ONE);
	}

	// Event Status Report
	public String eventStatusPDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			if (!isDetailRpt(pageDetail)) {
				return eventStatusCountWisePDFReport(pageDetail);
			}

			List<MISInwardCaseReportView> eventStatusList = this.getPvuEventStatusReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Event Wise Pendig Status Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForPvuEventStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseReportView empProgressObj : eventStatusList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					PvuConstant.PVU_MIS_ATT_FILENAME + "Event_Wise_Pendig_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String eventStatusCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISPvuEventStatusReportView> eventStatusList = this.getPvuEventStatusCountReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForPvuEventStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(5);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 55f, 55f, 55f, 55f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_AUTH_CASE, PvuConstant.PVU_MIS_RET_CASE,
					PvuConstant.PVU_MIS_PENDING_CASES, PvuConstant.PVU_MIS_TOTAL_CASES).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISPvuEventStatusReportView empProgressObj : eventStatusList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell authCell = getPDFCell(empProgressObj.getAuthCases(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(authCell);

				PdfPCell returnCell = getPDFCell(empProgressObj.getReturnCases(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(returnCell);

				PdfPCell penCell = getPDFCell(empProgressObj.getPendingCases(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(penCell);

				PdfPCell totalCell = getPDFCell(empProgressObj.getTotalCases(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(totalCell);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Event_Wise_Pendig_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public PdfPCell getPDFCell(Object res, int verAlign, int horiAlign) {
		PdfPCell pdfCell = new PdfPCell(new Phrase(!Utils.isEmpty(res) ? res.toString() : "", bodyFont));
		pdfCell.setPaddingLeft(4);
		pdfCell.setVerticalAlignment(verAlign);
		pdfCell.setHorizontalAlignment(horiAlign);

		return pdfCell;
	}

	public PdfPCell getPDFCellCaseInquiry(Object res, int verAlign, int horiAlign) {
		Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
		PdfPCell pdfCell = new PdfPCell(new Phrase(!Utils.isEmpty(res) ? res.toString() : "", headFont));
		pdfCell.setPaddingLeft(4);
		pdfCell.setVerticalAlignment(verAlign);
		pdfCell.setHorizontalAlignment(horiAlign);
		pdfCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pdfCell.setBorderWidth(1);

		return pdfCell;
	}

	
	public List<MISDurationPendingEnumOneReport> getDurationWisePendingStatusCombinationOneReportListing(
			PageDetails pageDetail) throws CustomException {
		Map<String, String> collect = getDurationWisePendingStatusSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_DURATION_WISE_PENDING_CASES_RPT).toString();
		return this.storeProcPvu(procName, map, MISDurationPendingEnumOneReport.class);
	}

	
	public List<MISDurationPendingEnumOneReport> getDurationWisePendingStatusCombinationTwoReportListing(
			PageDetails pageDetail) throws CustomException {
		Map<String, String> collect = getDurationWisePendingStatusSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_DURATION_WISE_PENDING_CASES_RPT).toString();
		return this.storeProcPvu(procName, map, MISDurationPendingEnumOneReport.class);
	}
	

	public List<MISDurationPendingEnumTwoReport> getDurationWisePendingStatusCombinationThreeReportListing(
			PageDetails pageDetail) throws CustomException {
		Map<String, String> collect = getDurationWisePendingStatusSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_DURATION_WISE_PENDING_CASES_RPT).toString();
		return this.storeProcPvu(procName, map, MISDurationPendingEnumTwoReport.class);
	}

	public List<MISInwardCaseReportView> getDurationWisePendingStatusCombinationFourReportListing(
			PageDetails pageDetail) throws CustomException {
		Map<String, String> collect = getDurationWisePendingStatusSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_DURATION_WISE_PENDING_CASES_RPT).toString();
		return this.storeProcPvu(procName, map, MISInwardCaseReportView.class);
	}

	public List<PVUSearchEnum> getDurationWisePendingStatusSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_1,
				PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_2, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_3,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO);
	}

	public String getUserSelectedKeyValueForEventWisePendingStatusReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_FROMDATE, PVUSearchEnum.PVU_MIS_REPORT_TODATE,
						PVUSearchEnum.PVU_MIS_REPORT_PAYCOMMISION, PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME,
						PVUSearchEnum.PVU_MIS_REPORT_SELECTEDEVENT));

	}

	@Override
	public PagebleDTO<MISEmpWiseWorkdoneDetailReportView> getEmpWiseWorkdoneReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getEmpWiseWorkdoneSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMP_WISE_WORKDONE_EVENT_RPT).toString();
			List<MISEmpWiseWorkdoneDetailReportView> objStorePro = this.storeProcPvu(procName, map,
					MISEmpWiseWorkdoneDetailReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0,
					!Utils.isEmpty(objStorePro) ? objStorePro.get(0).getTotalRowCount() : 0, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getEmpWiseWorkdoneSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_MIS_ROLE_LEVEL,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_ENUM_INDEX,PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO);
	}

	@Override
	public PagebleDTO<MISEmpWiseWorkdoneReportView> getEmpWiseWorkdoneCountWiseReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getEmpWiseWorkdoneSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMP_WISE_WORKDONE_EVENT_RPT).toString();
			List<MISEmpWiseWorkdoneReportView> objStorePro = this.storeProcPvu(procName, map,
					MISEmpWiseWorkdoneReportView.class);

			long size = objStorePro.stream()
					.filter(i -> i.getEmpName().equalsIgnoreCase("TOTAL_CASES") && Utils.isEmpty(i.getTotalCases()))
					.count();

			if (size > 0) {
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), Collections.emptyList());
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0,
					!Utils.isEmpty(objStorePro) ? objStorePro.get(0).getTotalRowCount() : 0, objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	
	
	public String durationWisePendingStatusPDFReport(PageDetails pageDetail) throws CustomException {

		String enumIndexOne = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_1.getKey());
		String enumIndexTwo = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_2.getKey());
		String enumIndexThree = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_3.getKey());

		if ((enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0"))
				|| (!enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0"))) {
			return getDurationCountWisePDFReport(pageDetail);
		}
		if (!enumIndexOne.equals("0") && !enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
			return getDurationEmployeeWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISInwardCaseReportView> durationStatusList = this
					.getDurationWisePendingStatusCombinationFourReportListing(pageDetail);

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Duration Wise Pendig Status Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of("Sr. No", "Employee No", "Employee Name", PvuConstant.PVU_MIS_GPFPPAN, "Office Name",
					"Endorsement", "Status", "Lying With", "Inward Date", "Auth Date", "Return Date", "Outward Date",
					"Event Name").forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseReportView empProgressObj : durationStatusList) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Event_Wise_Pendig_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String employeeWiseWorkDonePDFReport(PageDetails pageDetail) throws CustomException {

		if (!isDetailRpt(pageDetail)) {
			return empWiseWorkdoneCountWisePDFReport(pageDetail);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<MISEmpWiseWorkdoneDetailReportView> employeeWiseWorkList = this.getEmpWiseWorkdoneReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader("Employee Wise Work Done Report");
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForEmpWiseWorkdoneReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISEmpWiseWorkdoneDetailReportView empProgressObj : employeeWiseWorkList) {
				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell gpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(gpf);

				PdfPCell offc = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(offc);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell auth = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(auth);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwrdDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwrdDate);

				
				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Employee_Wise_Work_Done_Status.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String getUserSelectedKeyValueForEmpWiseWorkdoneReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_FROMDATE, PVUSearchEnum.PVU_MIS_REPORT_TODATE,
						PVUSearchEnum.PVU_SEARCH_FIELD_MIS_LEVEL, PVUSearchEnum.PVU_MIS_REPORT_EVENTTYPE));

	}

	@Override
	public PagebleDTO<MISEmpWiseAllocationReportView> getEmpWiseAllocationReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = getEmpWiseAllocationSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMPLOYEE_WISE_ALLOCATION_RPT).toString();
			List<MISEmpWiseAllocationReportView> objStorePro = this.storeProcPvu(procName, map,
					MISEmpWiseAllocationReportView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0,
					!Utils.isEmpty(objStorePro) ? objStorePro.get(0).getTotalRowCount() : 0, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getEmpWiseAllocationSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_MIS_SELECT_LEVEL,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_MIS_TO_EMPLOYEE);
	}

	public String getUserSelectedKeyValueForEmpWiseAllocationReport(PageDetails pageDetail) {
		return getSearchFilterData(pageDetail,
				Arrays.asList(PVUSearchEnum.PVU_MIS_REPORT_FROMDATE, PVUSearchEnum.PVU_MIS_REPORT_TODATE,
						PVUSearchEnum.PVU_MIS_REPORT_SELECTEVENT, PVUSearchEnum.PVU_MIS_REPORT_EVENTNAME,
						PVUSearchEnum.PVU_SEARCH_FIELD_MIS_TO_EMP));

	}

	public String getEmpWiseAllocationPDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<MISEmpWiseAllocationReportView> list = this.getEmpWiseAllocationReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForEmpWiseAllocationReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(13);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 35f, 55f, 35f, 55f, 35f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNO, PvuConstant.PVU_MIS_EMPNAME,
					PvuConstant.PVU_MIS_GPFPPAN, PvuConstant.PVU_MIS_DDO_OFFICENAME, PvuConstant.PVU_MIS_ENDORSEMENT,
					PvuConstant.PVU_MIS_STATUS, PvuConstant.PVU_MIS_LYINGWITH, PvuConstant.PVU_MIS_INWARDDATE,
					PvuConstant.PVU_MIS_AUTHDATE, PvuConstant.PVU_MIS_RETDATE, PvuConstant.PVU_MIS_OUTWARDDATE,
					PvuConstant.PVU_MIS_EVENTTYPE).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISEmpWiseAllocationReportView empProgressObj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empNumber = getPDFCell(empProgressObj.getEmployeeNo(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empNumber);

				PdfPCell empName = getPDFCell(empProgressObj.getEmployeeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell pPanGpf = getPDFCell(empProgressObj.getGpf(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pPanGpf);

				PdfPCell officeName = getPDFCell(empProgressObj.getOfficeName(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(officeName);

				PdfPCell endorsement = getPDFCell(empProgressObj.getEndorsement(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(endorsement);

				PdfPCell status = getPDFCell(empProgressObj.getStatus(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(status);

				PdfPCell lyingWith = getPDFCell(empProgressObj.getLyingWith(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(lyingWith);

				PdfPCell inwardDate = getPDFCell(empProgressObj.getInwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getInwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardDate);

				PdfPCell authDate = getPDFCell(empProgressObj.getAuthDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getAuthDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(authDate);

				PdfPCell returnDate = getPDFCell(empProgressObj.getReturnDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getReturnDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(returnDate);

				PdfPCell outwardDate = getPDFCell(empProgressObj.getOutwardDate() != null
						? PvuUtils.getDateToStringDMYFormatValue(empProgressObj.getOutwardDate())
						: "", Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(outwardDate);

				PdfPCell eventType = getPDFCell(empProgressObj.getEventType(), Element.ALIGN_MIDDLE,
						Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());

	}

	public String inwardCaseForROPCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISInwardCaseEventCountReportView> list = this.getInwardCaseRopReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(3);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 55f, 55f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EVENTTYPE, PvuConstant.PVU_MIS_NO_OF_INWARDED_CASES)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseEventCountReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell eventType = getPDFCell(obj.getLookUpInfoName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

				PdfPCell inwardCases = getPDFCell(obj.getInwardCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardCases);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=InwardCaseForROPCountWiseReport.pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String inwardCaseForEventCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISInwardCaseEventCountReportView> list = this.getInwardCaseForEventCountReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForInwardCaseROPReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(3);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 45f, 45f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EVENTTYPE, PvuConstant.PVU_MIS_NO_OF_INWARDED_CASES)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISInwardCaseEventCountReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell eventType = getPDFCell(obj.getLookUpInfoName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

				PdfPCell inwardCases = getPDFCell(obj.getInwardCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardCases);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);

			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String outwardCaseForEventCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISOutwardCaseForEventCountView> list = this.getOutwardCaseForEventCountReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForOutwardCaseEventReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(3);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 45f, 45f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EVENTTYPE, PvuConstant.PVU_MIS_NO_OF_INWARDED_CASES)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISOutwardCaseForEventCountView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell eventType = getPDFCell(obj.getEventName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(eventType);

				PdfPCell inwardCases = getPDFCell(obj.getOutwardCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inwardCases);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String forwardCasesDDOCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISForwardCaseDdoCountReportView> list = this.getForwardCaseDdoWiseCountReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForForwardCaseDdoEventReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(8);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 45f, 45f, 20f, 20f, 20f, 20f, 20f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DISTRICTNAME, PvuConstant.PVU_MIS_OFFICE_NAME,
					PvuConstant.PVU_MIS_AUTHORIZED, PvuConstant.PVU_MIS_RETURNED, PvuConstant.PVU_MIS_INPROGRESS,
					PvuConstant.PVU_MIS_REJECTED, PvuConstant.PVU_MIS_TOTAL).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISForwardCaseDdoCountReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell dist = getPDFCell(obj.getDistName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(dist);

				PdfPCell offce = getPDFCell(obj.getOfficeName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(offce);

				PdfPCell auth = getPDFCell(obj.getAuthCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(auth);

				PdfPCell ret = getPDFCell(obj.getReturnCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(ret);

				PdfPCell inProgress = getPDFCell(obj.getInProgress(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(inProgress);

				PdfPCell rej = getPDFCell(obj.getRejectedCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(rej);

				PdfPCell tot = getPDFCell(obj.getTotalCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(tot);

			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String returnCasesCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISReturnCaseCountReportView> list = this.getReturnCaseEventCountReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForReturnCaseEventReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(3);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 45f, 45f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_PARENT_DEP,
					PvuConstant.PVU_MIS_NO_OF_CASES_RETURNED).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISReturnCaseCountReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell parentDep = getPDFCell(obj.getLookUpInfoName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(parentDep);

				PdfPCell total = getPDFCell(obj.getLookUpInfo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(total);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String eventWisePendingStatusCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISEventWisePendingStatusReportView> list = this.getEventWisePendingStatusCountReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			// Add Text to PDF file ->
			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForEventWisePendingStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(3);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 45f, 45f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EVENT_NAME, PvuConstant.PVU_MIS_PENDING_CASES)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISEventWisePendingStatusReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell eventName = getPDFCell(obj.getEventName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(eventName);

				PdfPCell cases = getPDFCell(obj.getPendingCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(cases);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String districtWisePendingStatusCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISReturnCaseCountReportView> list = this.getDistrictWisePendingStatusCountReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(3);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 45f, 45f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DISTRICTNAME, PvuConstant.PVU_MIS_PENDING_CASES)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISReturnCaseCountReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell dist = getPDFCell(obj.getLookUpInfoName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(dist);

				PdfPCell pendingCases = getPDFCell(obj.getLookUpInfo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pendingCases);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String departmentWisePendingStatusCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISReturnCaseCountReportView> list = this.getDepartWisePendingStatusCountReport(pageDetail)
					.getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForDistrictWisePendingStatusReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(3);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 45f, 45f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_PARENT_DEP, PvuConstant.PVU_MIS_PENDING_CASES)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISReturnCaseCountReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell dist = getPDFCell(obj.getLookUpInfoName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(dist);

				PdfPCell pendingCases = getPDFCell(obj.getLookUpInfo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(pendingCases);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String empWiseMOnthlyProgressCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISEmployeeMonthlyProgressCountReportView> list = this
					.getEmployeeMonthlyProgressCountReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(
					this.getUserSelectedKeyValueForEmpWiseMOnthlyProgressReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(9);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 10f, 55f, 35f, 35f, 35f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNAME, PvuConstant.PVU_MIS_OPENING_BAL,
					PvuConstant.PVU_MIS_RECEIVED_CASES, PvuConstant.PVU_MIS_AUTH_CASE, PvuConstant.PVU_MIS_RET_CASE,
					PvuConstant.PVU_MIS_REJECTED, PvuConstant.PVU_MIS_TOTAL_CASES, PvuConstant.PVU_MIS_CLOSING_BAL)
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISEmployeeMonthlyProgressCountReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empName = getPDFCell(obj.getEmpName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell openingBal = getPDFCell(obj.getOpeningBalance(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(openingBal);

				PdfPCell rec = getPDFCell(obj.getReceivedCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(rec);

				PdfPCell auth = getPDFCell(obj.getAuthorizedCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(auth);

				PdfPCell ret = getPDFCell(obj.getReturnedCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(ret);

				PdfPCell rej = getPDFCell(obj.getRejectedCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(rej);

				PdfPCell tot = getPDFCell(obj.getTotalCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(tot);

				PdfPCell closing = getPDFCell(obj.getClosingBalance(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(closing);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String empWiseWorkdoneCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			pageDetail.setPageElement(PvuConstant.PVU_MIS_MAX_VALUE);
			List<MISEmpWiseWorkdoneReportView> list = this.getEmpWiseWorkdoneCountWiseReport(pageDetail).getResult();

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph(this.getUserSelectedKeyValueForEmpWiseWorkdoneReport(pageDetail));
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(5);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 55f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNAME, PvuConstant.PVU_MIS_AUTH_CASE,
					PvuConstant.PVU_MIS_RET_CASE, PvuConstant.PVU_MIS_TOTAL_CASES).forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(1);
						header.setPhrase(new Phrase(headerTitle, headFont));
						employeeTbl.addCell(header);
					});

			int index = 0;
			for (MISEmpWiseWorkdoneReportView obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empName = getPDFCell(obj.getEmpName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell auth = getPDFCell(obj.getAuthCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(auth);

				PdfPCell ret = getPDFCell(obj.getReturnCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(ret);

				PdfPCell tot = getPDFCell(obj.getTotalCases(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(tot);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String getDurationCountWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			String enumIndexOne = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_1.getKey());
			String enumIndexTwo = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_2.getKey());
			String enumIndexThree = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_3.getKey());
			String[] headerColName = null;
			if (enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
				headerColName = new String[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DUR_7DAYS,
						PvuConstant.PVU_MIS_DUR_BET_7, PvuConstant.PVU_MIS_DUR_BET_15,
						PvuConstant.PVU_MIS_DUR_MORE_THAN_7 };
			}
			if (!enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
				headerColName = new String[] { PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_DUR_CASE_PEN,
						PvuConstant.PVU_MIS_DUR_REG_LVL, PvuConstant.PVU_MIS_DUR_VERI_LVL,
						PvuConstant.PVU_MIS_DUR_APPR_LVL };
			}

			List<MISDurationPendingEnumOneReport> list = this
					.getDurationWisePendingStatusCombinationOneReportListing(pageDetail);

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph("");
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(5);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 35f, 35f, 35f, 35f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(headerColName).forEach(headerTitle -> {
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle, headFont));
				employeeTbl.addCell(header);
			});

			int index = 0;
			for (MISDurationPendingEnumOneReport obj : list) {

				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empName = getPDFCell(obj.getDaysOne(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);

				PdfPCell auth = getPDFCell(obj.getDaysTwo(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(auth);

				PdfPCell ret = getPDFCell(obj.getDaysThree(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(ret);

				PdfPCell tot = getPDFCell(obj.getDaysFour(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(tot);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public String getDurationEmployeeWisePDFReport(PageDetails pageDetail) throws CustomException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			List<MISDurationPendingEnumTwoReport> list = this
					.getDurationWisePendingStatusCombinationThreeReportListing(pageDetail);

			Document ddoReport = new Document(PageSize.A4.rotate(), 60, 30, 110, 30);

			String office = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_NAME.getKey());
			String officeAdd = PageDetails.getValue(pageDetail,
					PVUSearchEnum.PVU_SEARCH_FIELD_IN_OFFICE_ADDRESS.getKey());

			PdfWriter writer = PdfWriter.getInstance(ddoReport, out);

			PdfHeader event = new PdfHeader();
			writer.setPageEvent(event);
			event.setHeader(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()));
			event.setOfficeName(office);
			event.setOfficeAddress(officeAdd);

			ddoReport.open();

			Paragraph filterPara = new Paragraph("");
			filterPara.setAlignment(Element.ALIGN_LEFT);
			ddoReport.add(filterPara);

			ddoReport.add(Chunk.NEWLINE);
			PdfPTable employeeTbl = new PdfPTable(2);
			employeeTbl.setHeaderRows(1);

			float[] columnWidths = new float[] { 15f, 55f };
			employeeTbl.setWidths(columnWidths);
			employeeTbl.setWidthPercentage(100);

			employeeTbl.setTotalWidth(PageSize.A4.getWidth());

			Stream.of(PvuConstant.PVU_MIS_SRNO, PvuConstant.PVU_MIS_EMPNAME).forEach(headerTitle -> {
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(PvuConstant.ARIAL_FONT, 10, BaseColor.BLACK);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle, headFont));
				employeeTbl.addCell(header);
			});

			int index = 0;
			for (MISDurationPendingEnumTwoReport obj : list) {
				index = index + 1;
				PdfPCell indexCell = getPDFCell(String.valueOf(index), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(indexCell);

				PdfPCell empName = getPDFCell(obj.getEmpName(), Element.ALIGN_MIDDLE, Element.ALIGN_CENTER);
				employeeTbl.addCell(empName);
			}

			ddoReport.add(employeeTbl);

			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(new StringBuilder(PvuConstant.PVU_MIS_GEN_BY)
					.append(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_USER_NAME.getKey()))
					.toString(), officeFont);
			p.add(new Chunk(glue));
			p.add(new Phrase(
					new StringBuilder(PvuConstant.PVU_MIS_GEN_DATETIME).append(Utils.getCurrentDateTime()).toString(),
					officeFont));
			ddoReport.add(p);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PVU_MIS_ATT_FILENAME
					+ PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_NAME.getKey()) + ".pdf");
			header.setContentLength(out.toByteArray().length);
			ddoReport.close();
		} catch (DocumentException e) {
			e.getMessage();
		}

		return Base64.getEncoder().encodeToString(out.toByteArray());
	}

	public Integer getTotalCount(PageDetails pageDetail) {
		return Integer.valueOf(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_MIS_REPORT_TOTAL_ELEMENT.getKey()));
	}

	public String getSearchFilterData(PageDetails pageDetail, List<PVUSearchEnum> searchEnum) {
		return searchEnum.stream().filter(param -> !Utils.isEmpty(PageDetails.getValue(pageDetail, param.getKey())))
				.map(param -> param.getKey() + PvuConstant.PVU_MIS_COLON
						+ PageDetails.getValue(pageDetail, param.getKey()))
				.collect(Collectors.joining(PvuConstant.PVU_MIS_COMMA));
	}

}
