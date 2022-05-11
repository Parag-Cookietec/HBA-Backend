package gov.ifms.gst.service.impl;

import static gov.ifms.common.util.Constant.DOT;
import static gov.ifms.common.util.Constant.IN_FROM_DT;
import static gov.ifms.common.util.Constant.IN_PAGE_INDEX;
import static gov.ifms.common.util.Constant.IN_PAGE_SIZE;
import static gov.ifms.common.util.Constant.IN_TO_DT;
import static gov.ifms.common.util.Constant.IN_FROM_MONTH;
import static gov.ifms.common.util.Constant.IN_FROM_YEAR;
import static gov.ifms.common.util.ErrorResponse.ERROR_WHILE_FATCHING;
import static gov.ifms.common.util.ErrorResponse.RECORD_NOT_FOUND;
import static gov.ifms.gst.util.GSTConstant.GST_SCHEMA;
import static gov.ifms.gst.util.GSTConstant.P_BLOCK_CPIN_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_CHALLAN_STATUS_CONSOLIDATED_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_CHALLAN_STATUS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_CIN_DETAILS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_CIN_FILE_RECEIVED_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_CIN_MODEWISE_TAXPAYER_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_CPIN_DETAILS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_EOD_CIN_DETAILS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_EOD_CIN_VS_CIN_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_EOD_CPIN_DETAILS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_EOD_CPIN_VS_CPIN_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_FILE_SUMMARY_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_GSTN_DAYWISE_CHALLAN_COUNT_AMOUNT;
import static gov.ifms.gst.util.GSTConstant.P_GSTN_VS_RBI_CHALLAN_COUNT;
import static gov.ifms.gst.util.GSTConstant.P_MANUAL_ACCOUNTING_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_DAYWISE_CHALLAN_COUNT_AMOUNT;
import static gov.ifms.gst.util.GSTConstant.P_VOUCHER_DETAILS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_SUMMARY_PENAL_INTEREST_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_SCROLL_FILE_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_SCROLL_STMNT_DATEWISE_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_SCROLL_STMNT_MONTHWISE_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_SCROLL_STMNT_TXN_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_SCROLL_STMNT_DAYWISE_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_GSTN_FILE_RECEIVED_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_MOE_TRACKING_GENERATE_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_MOE_TRACKING_GENERATE_SUB_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_JOTTING_VS_POSTING_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_DAYWISE_SCROLL_MONITORING_PART1_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_DAYWISE_SCROLL_MONITORING_PART2_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_PENDING_SCROLLSWISE_STATUS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_INPROCESS_SCROLLSWISE_STATUS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_RBI_PENDING_SCROLLSWISE_TRANS_DETAILS_STATUS_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_PERFORMANCE_MONITORING_REPORT;
import static gov.ifms.gst.util.GSTConstant.P_BAL_MONTRNG_BANKWISE_PENDING_TRANSACTION_COUNT_8658;
import static gov.ifms.gst.util.GSTConstant.P_BAL_MONTRNG_MONTHWISE_PENDING_TRANSACTION_COUNT_8658;
import static gov.ifms.gst.util.GSTConstant.P_BAL_MONTRNG_TRNSWISE_PENDING_TRANSACTION_COUNT_8658;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.common.util.Utils;
import gov.ifms.gst.dto.GstReportDtlsBalMonBankwisePendingTrans8658ReportDto;
import gov.ifms.gst.dto.GstReportDtlsBalMonMonthwisePendingTrans8658ReportDto;
import gov.ifms.gst.dto.GstReportDtlsBalMonMonthwisePendingTrans8658ReportFinalDto;
import gov.ifms.gst.dto.GstReportDtlsBalTrnsPendingTranswise8658ReportDto;
import gov.ifms.gst.dto.GstReportDtlsBlockCPinDto;
import gov.ifms.gst.dto.GstReportDtlsCinModewiseTaxpayertDto;
import gov.ifms.gst.dto.GstReportDtlsFileSummaryDto;
import gov.ifms.gst.dto.GstReportDtlsGSTNRBIFileSummaryReceivedReportDto;
import gov.ifms.gst.dto.GstReportDtlsGstnDaywiseChallanCountDto;
import gov.ifms.gst.dto.GstReportDtlsGstnVsRbiChallanCountDto;
import gov.ifms.gst.dto.GstReportDtlsJottingVsPostingReportDto;
import gov.ifms.gst.dto.GstReportDtlsMoeTrackingGenerateReportDto;
import gov.ifms.gst.dto.GstReportDtlsMoeTrackingGenerateSubReportDto;
import gov.ifms.gst.dto.GstReportDtlsPerformanceMonitoringReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiDaywiseChallanCountDto;
import gov.ifms.gst.dto.GstReportDtlsRbiDaywiseScrollMonitoringPart1ReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiDaywiseScrollMonitoringPart2ReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiDaywiseScrollMonitoringReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiInProcessScrollwiseStatusReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiPendingScrollwiseStatusReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntDatewiseReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntDaywiseReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntMonthwiseReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntTxnReportDto;
import gov.ifms.gst.dto.GstReportDtlsVoucherDetailsDto;
import gov.ifms.gst.repository.GSTCINFileDataRepository;
import gov.ifms.gst.service.GSTReportService;
import gov.ifms.gst.util.DateUtil;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinStatusConsolidatedDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinStatusDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinVsEodCinDaywiseCinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinVsEodCinDaywiseDrillDownDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinVsEodCinDaywiseEodCinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinVsEodCinDetailedTransactionDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinVsEodCinDifferenceDrillDownDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCinVsEodCinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCpinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCpinVsEodCpinDaywiseCpinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCpinVsEodCpinDaywiseDrillDownDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCpinVsEodCpinDaywiseEodCpinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCpinVsEodCpinDetailedTransactionDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCpinVsEodCpinDifferenceDrillDownDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsCpinVsEodCpinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsEodCpinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsEodcinDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsManualAccountingDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsRbiScrollDetailsDto;
import gov.ifms.gst.workflow.dto.GstReportDtlsSummaryPenalInterestDto;


@Service
public class GSTReportServiceImpl implements GSTReportService {

	@Autowired
	private GSTCINFileDataRepository gstCINFileDataRepository;

	SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public PagebleDTO<GstReportDtlsEodcinDto> getGstReportDetailsForEodCin(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		//map.put(IN_FROM_DT, fromDate);
		//map.put(IN_TO_DT, toDate);
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportEodCinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CIN_DETAILS_REPORT));
		List<GstReportDtlsEodcinDto> eodCinRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsEodcinDto.class);
		if (!Utils.isEmpty(eodCinRepositoryResult)) {
			long totalPages = !eodCinRepositoryResult.isEmpty() ? eodCinRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, eodCinRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinDto> getGstReportDetailsForCin(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_CIN_DETAILS_REPORT));
		List<GstReportDtlsCinDto> cinRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsCinDto.class);

		if (!Utils.isEmpty(cinRepositoryResult)) {
			long totalPages = !cinRepositoryResult.isEmpty() ? cinRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, cinRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsEodCpinDto> getGstReportDetailsForEodCpin(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportEodCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CPIN_DETAILS_REPORT));
		List<GstReportDtlsEodCpinDto> eodCpinRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsEodCpinDto.class);
		if (!Utils.isEmpty(eodCpinRepositoryResult)) {
			long totalPages = !eodCpinRepositoryResult.isEmpty() ? eodCpinRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, eodCpinRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCpinDto> getGstReportDetailsForCpin(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_CPIN_DETAILS_REPORT));
		List<GstReportDtlsCpinDto> cpinRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsCpinDto.class);
		if (!Utils.isEmpty(cpinRepositoryResult)) {
			long totalPages = !cpinRepositoryResult.isEmpty() ? cpinRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, cpinRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinStatusDto> getGstReportDetailsForChallanStatus(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinStatusDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_CHALLAN_STATUS_REPORT));
		List<GstReportDtlsCinStatusDto> cinStatusRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsCinStatusDto.class);
		if (!Utils.isEmpty(cinStatusRepositoryResult)) {
			long totalPages = !cinStatusRepositoryResult.isEmpty() ? cinStatusRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, cinStatusRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinStatusConsolidatedDto> getGstReportDetailsForChallanStatusConsolidated(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinStatusConsolidatedDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_CHALLAN_STATUS_CONSOLIDATED_REPORT));
		List<GstReportDtlsCinStatusConsolidatedDto> cinStatusConsolidatedRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsCinStatusConsolidatedDto.class);
		if (!Utils.isEmpty(cinStatusConsolidatedRepositoryResult)) {
			long totalPages = !cinStatusConsolidatedRepositoryResult.isEmpty() ? cinStatusConsolidatedRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, cinStatusConsolidatedRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsFileSummaryDto> getGstReportDetailsForFileSummary(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportFileSummaryDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_FILE_SUMMARY_REPORT));
		List<GstReportDtlsFileSummaryDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsFileSummaryDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsVoucherDetailsDto> getGstReportDetailsForVoucherDetails(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportVoucherDetailsDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_VOUCHER_DETAILS_REPORT));
		List<GstReportDtlsVoucherDetailsDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsVoucherDetailsDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsBlockCPinDto> getGstReportDetailsForBlockCPin(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportBlockCPinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_BLOCK_CPIN_REPORT));
		List<GstReportDtlsBlockCPinDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsBlockCPinDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsGstnVsRbiChallanCountDto> getGstReportDetailsForGstnVsRbiChallanCount(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportGstnVsRbiChallanCountDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_GSTN_VS_RBI_CHALLAN_COUNT));
		List<GstReportDtlsGstnVsRbiChallanCountDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsGstnVsRbiChallanCountDto.class);

		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsGstnDaywiseChallanCountDto> getGstReportDetailsForGstnDaywiseChallanCount(final PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();

		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForGstnDaywiseChallanCountDtlsListing().get(search.getKey()),
					search.getValue()));
		}

		String procName = GST_SCHEMA.concat(DOT.concat(P_GSTN_DAYWISE_CHALLAN_COUNT_AMOUNT));

		Map<String, Object> mapFromDate = new LinkedHashMap<>();
		mapFromDate.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		mapFromDate.put(IN_PAGE_SIZE, pageDetail.getPageElement());

		List<GstReportDtlsGstnDaywiseChallanCountDto> fileSummaryFinalResult = new ArrayList<>();

		Date fromDate = DateUtil.getDate(String.valueOf(map.get(IN_FROM_DT)), "yyyy-MM-dd");
		Date toDate = DateUtil.getDate(String.valueOf(map.get(IN_TO_DT)), "yyyy-MM-dd");

		//Loop between given dates so that SP can be called with single date, get results, store all the results and send back
	    while (fromDate.before(DateUtil.addDays(toDate, 1))) {
			mapFromDate.put("AS_OF_DATE", DateUtil.ConvertDateToString(fromDate, "yyyy-MM-dd"));
			List<GstReportDtlsGstnDaywiseChallanCountDto> fileSummaryRepositoryResult = this.callStoreProc(procName, mapFromDate, GstReportDtlsGstnDaywiseChallanCountDto.class);
			fileSummaryFinalResult.addAll(fileSummaryRepositoryResult);
			fromDate = DateUtil.addDays(fromDate, 1);
			mapFromDate.remove("AS_OF_DATE");
		}

		if (!Utils.isEmpty(fileSummaryFinalResult)) {
			long totalPages = !fileSummaryFinalResult.isEmpty() ? fileSummaryFinalResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryFinalResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsManualAccountingDto> getGstReportDetailsForManualAccounting(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportManualAccountingDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_MANUAL_ACCOUNTING_REPORT));
		List<GstReportDtlsManualAccountingDto> manualAccountingResult = this.callStoreProc(procName, map, GstReportDtlsManualAccountingDto.class);
		if (!Utils.isEmpty(manualAccountingResult)) {
			long totalPages = !manualAccountingResult.isEmpty() ? manualAccountingResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, manualAccountingResult);
		} else {
			throw new CustomException(ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsRbiDaywiseChallanCountDto> getGstReportDetailsForRbiDaywiseChallanCount(final PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();

		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiDaywiseChallanCountDtlsListing().get(search.getKey()),
					search.getValue()));
		}

		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_DAYWISE_CHALLAN_COUNT_AMOUNT));

		Map<String, Object> mapFromDate = new LinkedHashMap<>();
		mapFromDate.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		mapFromDate.put(IN_PAGE_SIZE, pageDetail.getPageElement());

		List<GstReportDtlsRbiDaywiseChallanCountDto> fileSummaryFinalResult = new ArrayList<>();

		Date fromDate = DateUtil.getDate(String.valueOf(map.get(IN_FROM_DT)), "yyyy-MM-dd");
		Date toDate = DateUtil.getDate(String.valueOf(map.get(IN_TO_DT)), "yyyy-MM-dd");

		//Loop between given dates so that SP can be called with single date, get results, store all the results and send back
	    while (fromDate.before(DateUtil.addDays(toDate, 1))) {
			mapFromDate.put("AS_OF_DATE", DateUtil.ConvertDateToString(fromDate, "yyyy-MM-dd")); //fromDate);
			List<GstReportDtlsRbiDaywiseChallanCountDto> fileSummaryRepositoryResult = this.callStoreProc(procName, mapFromDate, GstReportDtlsRbiDaywiseChallanCountDto.class);
			fileSummaryFinalResult.addAll(fileSummaryRepositoryResult);
			fromDate = DateUtil.addDays(fromDate, 1);
			mapFromDate.remove("AS_OF_DATE");
		}

		if (!Utils.isEmpty(fileSummaryFinalResult)) {
			long totalPages = !fileSummaryFinalResult.isEmpty() ? fileSummaryFinalResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryFinalResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinModewiseTaxpayertDto> getGstReportDetailsForCinModewiseTaxpayer(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinModewiseTaxpayerDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_CIN_MODEWISE_TAXPAYER_REPORT));
		List<GstReportDtlsCinModewiseTaxpayertDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsCinModewiseTaxpayertDto.class);

		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> getGstReportDetailsForFileReceivedReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportFileReceivedReportDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_CIN_FILE_RECEIVED_REPORT));
		List<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsGSTNRBIFileSummaryReceivedReportDto.class);

		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinVsEodCinDto> getGstReportDetailsForCinVsEodcinMaster(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CIN_VS_CIN_REPORT));
		List<GstReportDtlsCinVsEodCinDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCinVsEodCinDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinVsEodCinDaywiseEodCinDto> getGstReportDetailsForCinVsEodcinDaywiseEodCin(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CIN_VS_CIN_REPORT));
		List<GstReportDtlsCinVsEodCinDaywiseEodCinDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCinVsEodCinDaywiseEodCinDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinVsEodCinDaywiseCinDto> getGstReportDetailsForCinVsEodcinDaywiseCin(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CIN_VS_CIN_REPORT));
		List<GstReportDtlsCinVsEodCinDaywiseCinDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCinVsEodCinDaywiseCinDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinVsEodCinDaywiseDrillDownDto> getGstReportDetailsForCinVsEodcinDaywise(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CIN_VS_CIN_REPORT));
		List<GstReportDtlsCinVsEodCinDaywiseDrillDownDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCinVsEodCinDaywiseDrillDownDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinVsEodCinDifferenceDrillDownDto> getGstReportDetailsForCinVsEodcinDifferenceDrill(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CIN_VS_CIN_REPORT));
		List<GstReportDtlsCinVsEodCinDifferenceDrillDownDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCinVsEodCinDifferenceDrillDownDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCinVsEodCinDetailedTransactionDto> getGstReportDetailsForCinVsEodcinTransaction(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCinVsEodcinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CIN_VS_CIN_REPORT));
		List<GstReportDtlsCinVsEodCinDetailedTransactionDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCinVsEodCinDetailedTransactionDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}


	@Override
	public PagebleDTO<GstReportDtlsCpinVsEodCpinDto> getGstReportDetailsForCpinVsEodCpinMaster(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCpinVsEodCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CPIN_VS_CPIN_REPORT));
		List<GstReportDtlsCpinVsEodCpinDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCpinVsEodCpinDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCpinVsEodCpinDaywiseEodCpinDto> getGstReportDetailsForCpinVsEodCpinDaywiseEodCpin(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCpinVsEodCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CPIN_VS_CPIN_REPORT));
		List<GstReportDtlsCpinVsEodCpinDaywiseEodCpinDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCpinVsEodCpinDaywiseEodCpinDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCpinVsEodCpinDaywiseCpinDto> getGstReportDetailsForCpinVsEodCpinDaywiseCpin(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCpinVsEodCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CPIN_VS_CPIN_REPORT));
		List<GstReportDtlsCpinVsEodCpinDaywiseCpinDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCpinVsEodCpinDaywiseCpinDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCpinVsEodCpinDaywiseDrillDownDto> getGstReportDetailsForCpinVsEodCpinDaywise(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCpinVsEodCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CPIN_VS_CPIN_REPORT));
		List<GstReportDtlsCpinVsEodCpinDaywiseDrillDownDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCpinVsEodCpinDaywiseDrillDownDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCpinVsEodCpinDifferenceDrillDownDto> getGstReportDetailsForCpinVsEodCpinDifferenceDrill(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCpinVsEodCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CPIN_VS_CPIN_REPORT));
		List<GstReportDtlsCpinVsEodCpinDifferenceDrillDownDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCpinVsEodCpinDifferenceDrillDownDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsCpinVsEodCpinDetailedTransactionDto> getGstReportDetailsForCpinVsEodCpinTransaction(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportCpinVsEodCpinDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_EOD_CPIN_VS_CPIN_REPORT));
		List<GstReportDtlsCpinVsEodCpinDetailedTransactionDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsCpinVsEodCpinDetailedTransactionDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsSummaryPenalInterestDto> getGstReportDetailsForSummaryPenalInterest(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportSummaryPenalInterestDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_SUMMARY_PENAL_INTEREST_REPORT));
		List<GstReportDtlsSummaryPenalInterestDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsSummaryPenalInterestDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsRbiScrollDetailsDto> getGstReportDetailsForRbiScrollDetails(
			final PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportRbiScrollDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_SCROLL_FILE_REPORT));
		List<GstReportDtlsRbiScrollDetailsDto> storedProcedureResult = this.callStoreProc(procName, map, GstReportDtlsRbiScrollDetailsDto.class);

		if (!Utils.isEmpty(storedProcedureResult)) {
			long totalPages = !storedProcedureResult.isEmpty() ? storedProcedureResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, storedProcedureResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsRbiScrollStmntDatewiseReportDto> getGstReportDetailsForRbiScrollStmntDatewiseReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiScrollStmntDatewiseReport().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_SCROLL_STMNT_DATEWISE_REPORT));
		
		Map<String, Object> mapFromDate = new LinkedHashMap<>();
		mapFromDate.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		mapFromDate.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		
		List<GstReportDtlsRbiScrollStmntDatewiseReportDto> fileSummaryFinalResult = new ArrayList<>();
		
		Integer NumberOfDaysInMonth = 
				 DateUtil.getNumberOfDaysInMonth(Integer.valueOf((String) map.get(IN_FROM_YEAR)), Integer.valueOf((String) map.get(IN_FROM_MONTH)));
		
	    for(int i=1;i<=NumberOfDaysInMonth;i++){  
	    	mapFromDate.put("AS_OF_DATE", map.get(IN_FROM_YEAR) + "-"+map.get(IN_FROM_MONTH)+ "-"+Integer.toString(i));
			List<GstReportDtlsRbiScrollStmntDatewiseReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, mapFromDate, GstReportDtlsRbiScrollStmntDatewiseReportDto.class);
			fileSummaryFinalResult.addAll(fileSummaryRepositoryResult);		
			mapFromDate.remove("AS_OF_DATE");		
	    }	
				
		if (!Utils.isEmpty(fileSummaryFinalResult)) {
			long totalPages = !fileSummaryFinalResult.isEmpty() ? fileSummaryFinalResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryFinalResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsRbiScrollStmntMonthwiseReportDto> getGstReportDetailsForRbiScrollStmntMonthwiseReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiScrollStmntMonthwiseReport().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_SCROLL_STMNT_MONTHWISE_REPORT));
		List<GstReportDtlsRbiScrollStmntMonthwiseReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsRbiScrollStmntMonthwiseReportDto.class);
		
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsRbiScrollStmntTxnReportDto> getGstReportDetailsForRbiScrollStmntTxnReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiScrollStmntTxnReport().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_SCROLL_STMNT_TXN_REPORT));
		List<GstReportDtlsRbiScrollStmntTxnReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsRbiScrollStmntTxnReportDto.class);
		
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsRbiScrollStmntDaywiseReportDto> getGstReportDetailsForRbiScrollStmntDaywiseReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiScrollStmntDaywiseReport().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_SCROLL_STMNT_DAYWISE_REPORT));
		List<GstReportDtlsRbiScrollStmntDaywiseReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsRbiScrollStmntDaywiseReportDto.class);
		
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> getGstReportDetailsForGstnFileSummaryReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportFileSummaryDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		
		List<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> fileSummaryFinalResult = new ArrayList<>();
		
		String procNameCINFileRecvd = GST_SCHEMA.concat(DOT.concat(P_CIN_FILE_RECEIVED_REPORT));
		List<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> fileSummaryRepositoryCINFileRecvdResult = this.callStoreProc(procNameCINFileRecvd, map, GstReportDtlsGSTNRBIFileSummaryReceivedReportDto.class);
		fileSummaryFinalResult.addAll(fileSummaryRepositoryCINFileRecvdResult);
		
		String procNameGSTNFileRecvd = GST_SCHEMA.concat(DOT.concat(P_GSTN_FILE_RECEIVED_REPORT));
		List<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> fileSummaryRepositoryGSTNFileRecvdResult = this.callStoreProc(procNameGSTNFileRecvd, map, GstReportDtlsGSTNRBIFileSummaryReceivedReportDto.class);
		fileSummaryFinalResult.addAll(fileSummaryRepositoryGSTNFileRecvdResult);

		if (!Utils.isEmpty(fileSummaryFinalResult)) {
			long totalPages = !fileSummaryFinalResult.isEmpty() ? fileSummaryFinalResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryFinalResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsMoeTrackingGenerateReportDto> getGstReportDetailsForMoeTrackingGenerateReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportMoeTrackingGenerateReportDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_MOE_TRACKING_GENERATE_REPORT));
		List<GstReportDtlsMoeTrackingGenerateReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsMoeTrackingGenerateReportDto.class);
		
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}

	@Override
	public PagebleDTO<GstReportDtlsMoeTrackingGenerateSubReportDto> getGstReportDetailsForMoeTrackingGenerateSubReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportMoeTrackingGenerateSubReportDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_MOE_TRACKING_GENERATE_SUB_REPORT));
		List<GstReportDtlsMoeTrackingGenerateSubReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsMoeTrackingGenerateSubReportDto.class);
		
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsJottingVsPostingReportDto> getGstReportDetailsForJottingVsPostingReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportJottedVsPostingReportDtlsListing().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_JOTTING_VS_POSTING_REPORT));
		List<GstReportDtlsJottingVsPostingReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsJottingVsPostingReportDto.class);
		
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsRbiDaywiseScrollMonitoringReportDto> getGstReportDetailsForRbiDaywiseScrollMonitoringReport(final PageDetails pageDetail)
			throws CustomException, ParseException {
		
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiDaywiseScrollMonitoringReport().get(search.getKey()),
					search.getValue()));
		}
		
		String procName_1 = GST_SCHEMA.concat(DOT.concat(P_RBI_DAYWISE_SCROLL_MONITORING_PART1_REPORT));
		String procName_2 = GST_SCHEMA.concat(DOT.concat(P_RBI_DAYWISE_SCROLL_MONITORING_PART1_REPORT));

		List<GstReportDtlsRbiDaywiseScrollMonitoringReportDto> fileSummaryFinalResults = new ArrayList<>();

		Integer NumberOfDaysInMonth = 
				 DateUtil.getNumberOfDaysInMonth(Integer.valueOf((String) map.get(IN_FROM_YEAR)), Integer.valueOf((String) map.get(IN_FROM_MONTH)));
		
		Map<String, Object> mapFromDate = new LinkedHashMap<>();
		mapFromDate.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		mapFromDate.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		
		for(int i=1;i<=NumberOfDaysInMonth;i++){  
	    	mapFromDate.put("AS_OF_DATE", map.get(IN_FROM_YEAR) + "-"+map.get(IN_FROM_MONTH)+ "-"+Integer.toString(i));
			List<GstReportDtlsRbiDaywiseScrollMonitoringPart1ReportDto> GstReportDtlsRbiDaywiseScrollMonitoringPart1Reports = this.callStoreProc(procName_1, mapFromDate, GstReportDtlsRbiDaywiseScrollMonitoringPart1ReportDto.class);
			List<GstReportDtlsRbiDaywiseScrollMonitoringPart2ReportDto> GstReportDtlsRbiDaywiseScrollMonitoringPart2Reports = this.callStoreProc(procName_2, mapFromDate, GstReportDtlsRbiDaywiseScrollMonitoringPart2ReportDto.class);

			GstReportDtlsRbiDaywiseScrollMonitoringReportDto fileSummaryFinalResult = new GstReportDtlsRbiDaywiseScrollMonitoringReportDto();			
			fileSummaryFinalResult.setDate(map.get(IN_FROM_YEAR) + "-"+map.get(IN_FROM_MONTH)+ "-"+Integer.toString(i));
			
			if (CollectionUtils.isNotEmpty(GstReportDtlsRbiDaywiseScrollMonitoringPart1Reports)){ 
				GstReportDtlsRbiDaywiseScrollMonitoringPart1ReportDto GstReportDtlsRbiDaywiseScrollMonitoringPart1Report = GstReportDtlsRbiDaywiseScrollMonitoringPart1Reports.get(0);
				fileSummaryFinalResult.setRecvd_No_Of_Scrolls(GstReportDtlsRbiDaywiseScrollMonitoringPart1Report.getJott_No_Of_Scrolls());
				fileSummaryFinalResult.setRecvd_No_Of_Challans(GstReportDtlsRbiDaywiseScrollMonitoringPart1Report.getJott_No_Of_Challans());
				fileSummaryFinalResult.setJotted_Amount(GstReportDtlsRbiDaywiseScrollMonitoringPart1Report.getJotted_Amount());
				fileSummaryFinalResult.setJott_No_Of_Scrolls(GstReportDtlsRbiDaywiseScrollMonitoringPart1Report.getJott_No_Of_Scrolls());
				fileSummaryFinalResult.setJott_No_Of_Scrolls(GstReportDtlsRbiDaywiseScrollMonitoringPart1Report.getJott_No_Of_Challans());
				fileSummaryFinalResult.setJotted_Amount(GstReportDtlsRbiDaywiseScrollMonitoringPart1Report.getJotted_Amount());
			}
			
			if (CollectionUtils.isNotEmpty(GstReportDtlsRbiDaywiseScrollMonitoringPart2Reports)){ 
				GstReportDtlsRbiDaywiseScrollMonitoringPart2ReportDto GstReportDtlsRbiDaywiseScrollMonitoringPart2Report = GstReportDtlsRbiDaywiseScrollMonitoringPart2Reports.get(0);
				fileSummaryFinalResult.setPosted_Scrolls(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getPosted_Scrolls());
				fileSummaryFinalResult.setPosted_Total_Challans(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getPosted_Total_Challans());
				fileSummaryFinalResult.setPosted_Amount(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getPosted_Amount());
				fileSummaryFinalResult.setInprocess_Scrolls(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getInprocess_Scrolls());
				fileSummaryFinalResult.setInprocess_Total_Challans(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getInprocess_Total_Challans());
				fileSummaryFinalResult.setInprocess_Amount(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getInprocess_Amount());
				fileSummaryFinalResult.setPending_Scrolls(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getPending_Scrolls());
				fileSummaryFinalResult.setPending_Total_Challans(GstReportDtlsRbiDaywiseScrollMonitoringPart2Report.getPending_Total_Challans());
				fileSummaryFinalResult.setPending_Amount(fileSummaryFinalResult.getJotted_Amount() - fileSummaryFinalResult.getInprocess_Amount());
			}
			
			fileSummaryFinalResults.add(fileSummaryFinalResult);
			mapFromDate.remove("AS_OF_DATE");		
	    }	

		if (!Utils.isEmpty(fileSummaryFinalResults)) {
			long totalPages = !fileSummaryFinalResults.isEmpty() ? fileSummaryFinalResults.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryFinalResults);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsRbiPendingScrollwiseStatusReportDto> getGstReportDetailsForRbiPendingScrollwiseStatusReport(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiPendingScrollwiseStatusReport().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_PENDING_SCROLLSWISE_STATUS_REPORT));
		List<GstReportDtlsRbiPendingScrollwiseStatusReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsRbiPendingScrollwiseStatusReportDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsRbiInProcessScrollwiseStatusReportDto> getGstReportDetailsForRbiInProcessScrollwiseStatusReport(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());

		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_INPROCESS_SCROLLSWISE_STATUS_REPORT));
		List<GstReportDtlsRbiInProcessScrollwiseStatusReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsRbiInProcessScrollwiseStatusReportDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto> getGstReportDetailsForRbiPendingScrollwiseTransDetailsStatusReport(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForRbiPendingScrollwiseTransDetailsStatusReport().get(search.getKey()),
					search.getValue()));
		}

		String procName = GST_SCHEMA.concat(DOT.concat(P_RBI_PENDING_SCROLLSWISE_TRANS_DETAILS_STATUS_REPORT));
		List<GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsPerformanceMonitoringReportDto> getGstReportDetailsForPerformanceMonitoringReport(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForPerformanceMonitoringReport().get(search.getKey()),
					search.getValue()));
		}

		String procName = GST_SCHEMA.concat(DOT.concat(P_PERFORMANCE_MONITORING_REPORT));
		List<GstReportDtlsPerformanceMonitoringReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsPerformanceMonitoringReportDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsBalMonBankwisePendingTrans8658ReportDto> getGstReportDetailsForBalMontrngBankwisePendingTransCount8658Report(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForBalMontrngBankwisePendingTransCountReport().get(search.getKey()),
					search.getValue()));
		}

		String procName = GST_SCHEMA.concat(DOT.concat(P_BAL_MONTRNG_BANKWISE_PENDING_TRANSACTION_COUNT_8658));
		List<GstReportDtlsBalMonBankwisePendingTrans8658ReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsBalMonBankwisePendingTrans8658ReportDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsBalMonMonthwisePendingTrans8658ReportDto> getGstReportDetailsForBalMontrngMonthwisePendingTransCount8658Report(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForBalMontrngMonthwisePendingTransCountReport().get(search.getKey()),
					search.getValue()));
		}
		
		String procName = GST_SCHEMA.concat(DOT.concat(P_BAL_MONTRNG_MONTHWISE_PENDING_TRANSACTION_COUNT_8658));
		List<GstReportDtlsBalMonMonthwisePendingTrans8658ReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsBalMonMonthwisePendingTrans8658ReportDto.class);
		
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	@Override
	public PagebleDTO<GstReportDtlsBalTrnsPendingTranswise8658ReportDto> getGstReportDetailsForBalMontrngTrnswisePendingTransCount8658Report(final PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getGstReportDetailsForBalMontrngTrnswisePendingTransCount8658Report().get(search.getKey()),
					search.getValue()));
		}

		String procName = GST_SCHEMA.concat(DOT.concat(P_BAL_MONTRNG_TRNSWISE_PENDING_TRANSACTION_COUNT_8658));
		List<GstReportDtlsBalTrnsPendingTranswise8658ReportDto> fileSummaryRepositoryResult = this.callStoreProc(procName, map, GstReportDtlsBalTrnsPendingTranswise8658ReportDto.class);
		if (!Utils.isEmpty(fileSummaryRepositoryResult)) {
			long totalPages = !fileSummaryRepositoryResult.isEmpty() ? fileSummaryRepositoryResult.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, fileSummaryRepositoryResult);
		} else {
			throw new CustomException(RECORD_NOT_FOUND);
		}
	}
	
	/** 
	 * Call store proc. 
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 *
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectSp = gstCINFileDataRepository.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}
}
