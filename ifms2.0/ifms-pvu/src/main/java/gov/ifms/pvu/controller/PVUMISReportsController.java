package gov.ifms.pvu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.dto.EmpCreationLookUpView;
import gov.ifms.pvu.dto.MISInwardCaseLookupView;
import gov.ifms.pvu.dto.MISStatusLookUpView;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.service.PVUMISExcelReportService;
import gov.ifms.pvu.service.PVUMISReportsService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUMISReportsController.
 *
 * @version v 1.0.
 * @created 2020/01/06 15:19:21.
 */
@RestController
@RequestMapping(URLConstant.URL_MIS_REPORTS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUMISReportsController {

	/**
	 * The service.
	 */
	@Autowired
	private PVUMISReportsService service;
	/**
	 * The Excel service.
	 */
	@Autowired
	private PVUMISExcelReportService excelService;

	/**
	 * Gets the creation look up info as map.
	 *
	 * @return the creation look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_CREATION_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getCreationLookUpInfoAsMap() throws CustomException {
		Map<String, List<EmpCreationLookUpView>> lstLuLookUp = service
				.getLookUpInfoAsMap(PvuConstant.PVU_EMP_CREATION_LOOKUP_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Gets status look up info as map.
	 *
	 * @return the creation look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_STATUS_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getStatusLookUpInfoAsMap() throws CustomException {
		List<MISStatusLookUpView> lstLuLookUp = service.getStatusLookUpInfoAsMap(PvuConstant.PVU_EVENTS_NAME_LOOKUP_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	@Trace
	@PostMapping(PvuConstant.URL_INWARD_CASE_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getInwardCaseLookUpInfoAsMap() throws CustomException {
		List<MISInwardCaseLookupView> lstLuLookUp = service
				.getInwardCaseLookUpInfoAsMap(PvuConstant.PVU_INWARD_CASE_ROP_RPT_LOOKUP_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	@Trace
	@PostMapping(PvuConstant.URL_DDO_FORWARD_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getDdoForwardLookUpInfoAsMap() throws CustomException {
		List<MISInwardCaseLookupView> lstLuLookUp = service
				.getDdoForwardLookUpInfoAsMap(PvuConstant.PVU_DDO_FORWARD_LOOKUP_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Fetch Case Inquiry Report.
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_CASE_INQ_REPORT)
	public ResponseEntity<ApiResponse> getCaseInquiryReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getCaseInquiryReport(pageDetail));
	}

	/**
	 * Export to Excel Case Inquiry Report.
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_CASE_INQ_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getExcelCaseInquiryReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getExcelCaseInquiryReport(pageDetail));
	}

	/**
	 * Fetch Employee Creation Report
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_EMP_CREATION_REPORT)
	public ResponseEntity<ApiResponse> getEmployeeCreationReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEmployeeCreationReport(pageDetail));
	}

	/**
	 * In Excel Employee Creation Report
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_EMP_CREATION_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getExcelEmployeeCreationReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getExcelEmployeeCreationReport(pageDetail));
	}

	/**
	 * Fetch inward case Report
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_INWARD_CASE_REPORT)
	public ResponseEntity<ApiResponse> getInwardCaseReport(@RequestBody PageDetails pageDetail) throws CustomException {
		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getInwardCaseReport(pageDetail);
		} else {
			res = service.getInwardCaseRopReport(pageDetail);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	/**
	 * In Excel Inward case report
	 *
	 * @param PageDetails pageDetail
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_INWARD_CASE_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getExcelInwardCaseReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getExcelInwardCaseReport(pageDetail));
	}

	/**
	 * Fetch Ddo Forward case Report
	 * 
	 * @param PageDetails pageDetail
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_DDO_FORWARD_CASE_REPORT)
	public ResponseEntity<ApiResponse> getDdoForwardCaseReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getDdoForwardCaseReport(pageDetail));
	}

	/**
	 * Excel Ddo Forward case Report
	 * 
	 * @param PageDetails pageDetail
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_DDO_FORWARD_CASE_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getExcelDdoForwardCaseReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getExcelDdoForwardCaseReport(pageDetail));
	}

	/**
	 * Fetch inward case Report in PDF
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_INWARD_CASE_REPORT_PDF_EXCEL)
	public ResponseEntity<ApiResponse> getInwardCaseReportInPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.inwardListReport(pageDetail));
	}

	/**
	 * Fetch inward case Report in PDF
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_CASE_REPORT_PDF_EXCEL)
	public ResponseEntity<ApiResponse> getEmployeeCreationReportInPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.employeeCreationReport(pageDetail));
	}

	/**
	 * Fetch Case Inquiry Report in PDF
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_CASE_INQUIRY_REPORT_PDF_EXCEL)
	public ResponseEntity<ApiResponse> getCaseInquiryReportInPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.caseInquiryReportPDF(pageDetail));
	}

	/**
	 * Fetch Case Inquiry Report in PDF
	 *
	 * @param PageDetails pageDetail
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_DDO_FORWARD_INQUIRY_REPORT_PDF_EXCEL)
	public ResponseEntity<ApiResponse> getDDOForwardReportInPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.ddoForwardCaseReportPDF(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_FORWARD_DDO_WISE_PDF_REPORT)
	public ResponseEntity<ApiResponse> getForwardWiseDDOReportInPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.forwardCaseDDOWiseReportPDF(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_RETURN_CASE_PDF_REPORT)
	public ResponseEntity<ApiResponse> getReturnCasePDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.returnCaseReportPDF(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_INWARD_CASE_DETAILS_PDF_REPORT)
	public ResponseEntity<ApiResponse> getInwardCaseDetailsPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.inwardCaseDetailsReportPDF(pageDetail));
	}

	/**
	 * Fetch Inward case for Event Report
	 * 
	 * @param PageDetails pageDetail
	 * @return ResponseEntity<ApiResponse>
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_INWARD_CASE_EVENT_REPORT)
	public ResponseEntity<ApiResponse> getInwardCaseForEventReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_DETAIL.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getInwardCaseForEventDetailReport(pageDetail);
		} else {
			res = service.getInwardCaseForEventCountReport(pageDetail);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(PvuConstant.URL_PVU_OUTWARD_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getOutwardLookUpInfoAsMap() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getOutwardLookUpInfoAsMap(PvuConstant.PVU_OUTWARD_EVENT_LOOKUP_SP));
	}

	/**
	 * Fetch Outward Forward case Report
	 * 
	 * @param PageDetails pageDetail
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_OUTWARD_CASE_EVENT_REPORT)
	public ResponseEntity<ApiResponse> getOutwardOutReport(@RequestBody PageDetails pageDetail) throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getOutwardReport(pageDetail);
		} else {
			res = service.getOutwardCaseForEventCountReport(pageDetail);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(PvuConstant.URL_PVU_COMMMON_SCREEN_LOOKUP)
	public ResponseEntity<ApiResponse> getCommonScreenLookUp() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getCommonScreenLookUp(PvuConstant.PVU_EVENT_MULTI_LOOKUP_SP));
	}

	/**
	 * Fetch Inward case for event Excel
	 *
	 * @param PageDetails pageDetail
	 * @return ResponseEntity<ApiResponse>
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_INWARD_CASE_EVENT_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getInwardCaseEventExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getInwardCaseEventExcel(pageDetail));
	}

	/**
	 * Fetch Outward case for event Excel
	 *
	 * @param PageDetails pageDetail
	 * @return ResponseEntity<ApiResponse>
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_OUTWARD_CASE_EVENT_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getOutwardCaseEventExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getOutwardCaseEventExcel(pageDetail));
	}

	/**
	 * Fetch Forward case DDO event Report
	 * 
	 * @param PageDetails pageDetail
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_FORWARD_CASE_DDO_EVENT_REPORT)
	public ResponseEntity<ApiResponse> getForwardCaseDdoWiseReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getForwardCaseDdoWiseDetailReport(pageDetail);
		} else {
			res = service.getForwardCaseDdoWiseCountReport(pageDetail);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	/**
	 * Forward case DDO event Report in Excel
	 *
	 * @param PageDetails pageDetail
	 * @return ResponseEntity<ApiResponse>
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_FORWARD_CASE_DDO_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getForwardCaseDdoWiseReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getForwardCaseDdoWiseReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(PvuConstant.URL_MIS_RPT_DEP_LOOKUP)
	public ResponseEntity<ApiResponse> getDepartmentLookUp() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getLookUpInfo(PvuConstant.PVU_DEPARTMENT_LOOKUP_SP_RPT));
	}

	@Trace
	@PostMapping(PvuConstant.URL_MIS_RPT_DISTRICT_LOOKUP)
	public ResponseEntity<ApiResponse> getDistrictLookUp() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getLookUpInfo(PvuConstant.PVU_DISTRICT_LOOKUP_SP_RPT));
	}

	@Trace
	@PostMapping(URLConstant.URL_RETURN_CASE_EVENT_REPORT)
	public ResponseEntity<ApiResponse> getReturnCaseEventReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getReturnCaseEventDetailReport(pageDetail);
		} else {
			res = service.getReturnCaseEventCountReport(pageDetail);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(URLConstant.URL_OUTWARD_CASE_EVENT_DETAILS_PDF_REPORT)
	public ResponseEntity<ApiResponse> getOutwardCasesEventPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.outwardCaseEventReportPDF(pageDetail));

	}

	// Employee Monthly Progress Report (PDF)
	@Trace
	@PostMapping(URLConstant.URL_EMP_WISE_MONTHLY_PROGRESS_REPORT_PDF)
	public ResponseEntity<ApiResponse> getEmployeeMonthlyProgressPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEmployeeWiseMonthlyProgressEventPDFReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_RETURN_CASE_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getReturnCaseDdoWiseReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getReturnCaseDdoWiseReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DISTRICT_WISE_EVENT_REPORT)
	public ResponseEntity<ApiResponse> getDistrictWiseEventReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getDistrictWiseEventReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DDO_EVENT_STATUS_EVENT_REPORT)
	public ResponseEntity<ApiResponse> getDdoEventStatusReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getDdoEventStatusReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DISTRICT_WISE_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getDistrictWiseReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getDistrictWiseReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DDO_EVENT_STATUS_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getDdoEventStatusReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getDdoEventStatusReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DISTRICT_WISE_PEWNDING_STATUS_REPORT)
	public ResponseEntity<ApiResponse> getDistrictWisePendingStatusReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getDistrictWisePendingStatusReport(pageDetail);
		} else {
			res = service.getDistrictWisePendingStatusCountReport(pageDetail);
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(URLConstant.URL_DEPARTMENT_WISE_PEWNDING_STATUS_REPORT)
	public ResponseEntity<ApiResponse> getDepartmentWisePendingStatusReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getDepartmentWisePendingEventReport(pageDetail);
		} else {
			res = service.getDepartWisePendingStatusCountReport(pageDetail);
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(URLConstant.URL_DEPARTMENT_WISE_PEWNDING_PDF_REPORT)
	public ResponseEntity<ApiResponse> getDepartmentWisePDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.departmentWisePendingStatusReportPDF(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DISTRICT_WISE_PEWNDING_PDF_REPORT)
	public ResponseEntity<ApiResponse> getDistrictWisePDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.districtWisePendingStatusReportPDF(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DISTRICTWISE_PENDING_STATUS_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getDistrictWisePendingStatusReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getDistrictWisePendingStatusReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DEPARTMENT_WISE_PENDING_STATUS_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getDepartmentWisePendingStatusReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getDepartmentWisePendingStatusReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_TRANSACTION_REMARKS)
	public ResponseEntity<ApiResponse> getTrnRemarks(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getTrnRemarks(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMP_WISE_MONTHLY_PROGRESS_REPORT)
	public ResponseEntity<ApiResponse> getEmployeeWiseMonthlyProgressReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getEmployeeWiseMonthlyProgressEventReport(pageDetail);
		} else {
			res = service.getEmployeeMonthlyProgressCountReport(pageDetail);
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	// DDO Events Report (PDF)
	@Trace
	@PostMapping(URLConstant.URL_DDO_EVENTS_PDF_REPORT)
	public ResponseEntity<ApiResponse> getDdoEventPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.ddoEventsStatusReportPDF(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMP_WISE_LOOKUP)
	public ResponseEntity<ApiResponse> getEmpWiseLookUp() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getEmpWiseLookUp(PvuConstant.PVU_EMP_WISE_LOOKUP_SP_RPT));
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_EVENT_STATUS_REPORT)
	public ResponseEntity<ApiResponse> getPvuEventStatusReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getPvuEventStatusReport(pageDetail);
		} else {
			res = service.getPvuEventStatusCountReport(pageDetail);
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(URLConstant.URL_EMP_WISE_MONTHLY_PROGRESS_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getEmpWiseMOnthlyProgressReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getEmpWiseMOnthlyProgressReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DEP_WISE_VERI_REPORT)
	public ResponseEntity<ApiResponse> getDepWiseVerificationReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getDepWiseVerificationReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_EVENT_STATUS_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getPvuEventStatusReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getPvuEventStatusReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DEPT_VERIFICATION_REPORT)
	public ResponseEntity<ApiResponse> getDepWiseVerificationPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.departmentWiseVerificationPDFReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DIST_VERIFICATION_REPORT)
	public ResponseEntity<ApiResponse> getDistWiseVerificationPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.districtWiseVerificationPDFReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EVENT_WISE_PENDING_REPORT)
	public ResponseEntity<ApiResponse> getEventWisePendingPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.eventWisePendingStatusPDFReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DEPT_VERIFICATION_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getDeptVerificationReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getDeptVerificationReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EVENTWISE_PENDING_STATUS_REPORT)
	public ResponseEntity<ApiResponse> getEventWisePendingStatusReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getEventWisePendingStatusReport(pageDetail);
		} else {
			res = service.getEventWisePendingStatusCountReport(pageDetail);
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(URLConstant.URL_DURATION_WISE_PENDING_STATUS_REPORT)
	public ResponseEntity<ApiResponse> getDurationWisePendingStatusReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		Object res = null;
		String enumIndexOne = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_1.getKey());
		String enumIndexTwo = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_2.getKey());
		String enumIndexThree = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_ENUM_INDEX_3.getKey());

		if (enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
			res = service.getDurationWisePendingStatusCombinationOneReportListing(pageDetail);
		}
		if (!enumIndexOne.equals("0") && enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
			res = service.getDurationWisePendingStatusCombinationTwoReportListing(pageDetail);
		}
		if (!enumIndexOne.equals("0") && !enumIndexTwo.equals("0") && enumIndexThree.equals("0")) {
			res = service.getDurationWisePendingStatusCombinationThreeReportListing(pageDetail);
		}
		if (!enumIndexOne.equals("0") && !enumIndexTwo.equals("0") && !enumIndexThree.equals("0")) {
			res = service.getDurationWisePendingStatusCombinationFourReportListing(pageDetail);
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(URLConstant.URL_DURATION_WISE_PENDING_STATUS_PDF_REPORT)
	public ResponseEntity<ApiResponse> getdurationWisePendingPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.durationWisePendingStatusPDFReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EVENT_STATUS__REPORT)
	public ResponseEntity<ApiResponse> getEventStatusPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.eventStatusPDFReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EVENTWISE_PENDING_STATUS_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getEventWisePendingStatusReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getEventWisePendingStatusReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPWISE_WORKDONE_PDF_REPORT)
	public ResponseEntity<ApiResponse> getEmpWiseWorkDonePDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.employeeWiseWorkDonePDFReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPWISE_WORKDONE_EVENT_REPORT)
	public ResponseEntity<ApiResponse> getEmpWiseWorkdoneReport(@RequestBody PageDetails pageDetail)
			throws CustomException {

		String isSearch = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH.getKey());
		Object res = null;
		if (isSearch.equals(PvuConstant.STR_ONE)) {
			res = service.getEmpWiseWorkdoneReport(pageDetail);
		} else {
			res = service.getEmpWiseWorkdoneCountWiseReport(pageDetail);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, res);
	}

	@Trace
	@PostMapping(PvuConstant.URL_MIS_EMP_WISE_WORKDONE_LOOKUP)
	public ResponseEntity<ApiResponse> getEmpWiseWorkdoneLookup() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getCommonScreenLookUp(PvuConstant.PVU_EMP_WISE_WORKDONE_LOOKUP_SP));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMP_WISE_WORKDONE_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getEmpWiseWorkdoneReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getEmpWiseWorkdoneReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPWISE_ALLOCATION_REPORT)
	public ResponseEntity<ApiResponse> getEmpWiseAllocationReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEmpWiseAllocationReport(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_MIS_EMP_WISE_ALLOCATION_LOOKUP)
	public ResponseEntity<ApiResponse> getEmpWiseAllocationLookup() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getCommonScreenLookUp(PvuConstant.PVU_WORKFLOW_ROLE_LOOKUP_SP));
	}

	@Trace
	@PostMapping(URLConstant.URL_MIS_EMP_WISE_ALLOCATION_EMPMASTER_LOOKUP)
	public ResponseEntity<ApiResponse> getEmpWiseAllocationEmpMasterLookup() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getCommonScreenLookUp(PvuConstant.PVU_MASTERUSER_LOOKUP_SP));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMP_WISE_ALLOCATION_EXCEL)
	public ResponseEntity<ApiResponse> getEmpWiseAllocationReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getEmpWiseAllocationReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_DURATION_WISE_PENDING_EXCEL)
	public ResponseEntity<ApiResponse> getDurationWisePendingReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				excelService.getDurationWisePendingReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMP_WISE_ALLOCATION_PDF_REPORT)
	public ResponseEntity<ApiResponse> getEmpWiseAllocationPDFReport(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEmpWiseAllocationPDFReport(pageDetail));
	}

}
