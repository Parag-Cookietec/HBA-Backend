package gov.ifms.gst.controller;

import static gov.ifms.common.util.Constant.REPORT_TYPE;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.service.GSTReportService;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

@RestController
@RequestMapping(GstURLConstant.URL_GST_REPORT_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSTReportController {

	@Autowired
	private GSTReportService service;

	/**
	 * Fetch the GST Detail report
	 * @param pageNumber
	 * @param pageSize
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws CustomException
	 * @throws ParseException
	 */

	@Trace
	@PostMapping(GstURLConstant.URL_GST_REPORT_DTL)
	public ResponseEntity<ApiResponse> getGstReportDetails(
			@RequestParam String reportType,
			@RequestBody PageDetails pageDetail) throws CustomException, ParseException {
		return resolveReportTypeAndGetResponse(reportType, pageDetail);
	}

	private ResponseEntity<ApiResponse> resolveReportTypeAndGetResponse(final String reportType, final PageDetails pageDetail) throws CustomException, ParseException {
		switch(reportType) {
		case "EODCIN":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForEodCin(pageDetail));
		case "CIN":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCin(pageDetail));
		case "EODCPIN":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForEodCpin(pageDetail));
		case "CPIN":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCpin(pageDetail));
		case "CHALLAN_STATUS":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForChallanStatus(pageDetail));
		case "CHALLAN_STATUS_CONSOLIDATED":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForChallanStatusConsolidated(pageDetail));
		case "FILE_SUMMARY":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForFileSummary(pageDetail));
		case "VOUCHER_DETAILS":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForVoucherDetails(pageDetail));
		case "BLOCK_CPIN":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForBlockCPin(pageDetail));
		case "GSTN_VS_RBI_CHALLAN_COUNT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForGstnVsRbiChallanCount(pageDetail));
		case "GSTN_DAYWISE_CHALLAN_COUNT_AMOUNT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForGstnDaywiseChallanCount(pageDetail));
		case "MANUAL_ACCOUNTING":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForManualAccounting(pageDetail));
		case "RBI_DAYWISE_CHALLAN_COUNT_AMOUNT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiDaywiseChallanCount(pageDetail));
		case "CIN_MODEWISE_TAXPAYER":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCinModewiseTaxpayer(pageDetail));
		case "FILE_RECEIVED_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForFileReceivedReport(pageDetail));
		case "CIN_VS_EODCIN":
			return resolveCinVsEodcinResponse(pageDetail);
		case "CPIN_VS_EODCPIN":
			return resolveCpinVsEodCpinResponse(pageDetail);
		case "SUMMARY_PENAL_INTEREST":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForSummaryPenalInterest(pageDetail));
		case "RBI_SCROLL_DETAILS":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiScrollDetails(pageDetail));
		case "RBI_SCROLL_STMNT_DATEWISE_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiScrollStmntDatewiseReport(pageDetail));
		case "RBI_SCROLL_STMNT_MONTHWISE_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiScrollStmntMonthwiseReport(pageDetail));
		case "RBI_SCROLL_STMNT_TXN_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiScrollStmntTxnReport(pageDetail));
		case "RBI_SCROLL_STMNT_DAYWISE_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiScrollStmntDaywiseReport(pageDetail));
		case "GSTN_FILE_SUMMARY_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForGstnFileSummaryReport(pageDetail));
		case "MOE_TRACKING_GENERATE_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForMoeTrackingGenerateReport(pageDetail));
		case "MOE_TRACKING_GENERATE_SUB_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForMoeTrackingGenerateSubReport(pageDetail));
		case "JOTTING_VS_POSTING_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForJottingVsPostingReport(pageDetail));
		case "RBI_DAYWISE_SCROLL_MONITORING":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiDaywiseScrollMonitoringReport(pageDetail));			
		case "RBI_PENDING_SCROLLSWISE_STATUS_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiPendingScrollwiseStatusReport(pageDetail));
		case "RBI_INPROCESS_SCROLLSWISE_STATUS_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiInProcessScrollwiseStatusReport(pageDetail));
		case "PENDING_SCROLLSWISE_TRANS_DETAILS_STATUS_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForRbiPendingScrollwiseTransDetailsStatusReport(pageDetail));
		case "PERFORMANCE_MONITORING_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForPerformanceMonitoringReport(pageDetail));
		case "BAL_MONTRNG_BANKWISE_PENDING_TRANSACTION_COUNT_8658":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForBalMontrngBankwisePendingTransCount8658Report(pageDetail));
		case "BAL_MONTRNG_MONTHWISE_PENDING_TRANSACTION_COUNT_8658":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForBalMontrngMonthwisePendingTransCount8658Report(pageDetail));
		case "BAL_MONTRNG_TRNSWISE_PENDING_TRANSACTION_COUNT_8658":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForBalMontrngTrnswisePendingTransCount8658Report(pageDetail));
		default : 
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					null);
		}
	}

	private ResponseEntity<ApiResponse> resolveCinVsEodcinResponse(final PageDetails pageDetail) throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String subReportType = (String) map.get(REPORT_TYPE);
		switch(subReportType){
		case "EODCIN_VS_CIN":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCinVsEodcinMaster(pageDetail));
		case "DAYWISE_EODCIN_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCinVsEodcinDaywiseEodCin(pageDetail));
		case "DAYWISE_CIN_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCinVsEodcinDaywiseCin(pageDetail));
		case "DAYWISE_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCinVsEodcinDaywise(pageDetail));
		case "DIFF_DRILL_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCinVsEodcinDifferenceDrill(pageDetail));
		case "DETAILED_CIN_TXN_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCinVsEodcinTransaction(pageDetail));
		default :
			return null;
		}
	}

	private ResponseEntity<ApiResponse> resolveCpinVsEodCpinResponse(final PageDetails pageDetail) throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String subReportType = (String) map.get(REPORT_TYPE);
		switch(subReportType){
		case "EODCPIN_VS_CPIN":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCpinVsEodCpinMaster(pageDetail));
		case "DAYWISE_EODCPIN_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCpinVsEodCpinDaywiseEodCpin(pageDetail));
		case "DAYWISE_CPIN_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCpinVsEodCpinDaywiseCpin(pageDetail));
		case "DAYWISE_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCpinVsEodCpinDaywise(pageDetail));
		case "DIFF_DRILL_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCpinVsEodCpinDifferenceDrill(pageDetail));
		case "DETAILED_TXN_REPORT":
			return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST,
					service.getGstReportDetailsForCpinVsEodCpinTransaction(pageDetail));
		default :
			return null;
		}
	}

}
