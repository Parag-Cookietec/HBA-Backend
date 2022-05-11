package gov.ifms.gst.service;

import java.text.ParseException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.dto.GstReportDtlsBalMonBankwisePendingTrans8658ReportDto;
import gov.ifms.gst.dto.GstReportDtlsBalMonMonthwisePendingTrans8658ReportDto;
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
import gov.ifms.gst.dto.GstReportDtlsRbiDaywiseScrollMonitoringReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiInProcessScrollwiseStatusReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiPendingScrollwiseStatusReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntDatewiseReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntDaywiseReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntMonthwiseReportDto;
import gov.ifms.gst.dto.GstReportDtlsRbiScrollStmntTxnReportDto;
import gov.ifms.gst.dto.GstReportDtlsVoucherDetailsDto;
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

public interface GSTReportService {

	// Report detail for EOD CIN details
	PagebleDTO<GstReportDtlsEodcinDto> getGstReportDetailsForEodCin(final PageDetails pageDetail) throws CustomException;
	
	// Report detail for CIN details
	PagebleDTO<GstReportDtlsCinDto> getGstReportDetailsForCin(final PageDetails pageDetail) throws CustomException;
	
	// Report detail for EOD CPIN details
	PagebleDTO<GstReportDtlsEodCpinDto> getGstReportDetailsForEodCpin(final PageDetails pageDetail) throws CustomException;
	
	// Report detail for CPIN details
	PagebleDTO<GstReportDtlsCpinDto> getGstReportDetailsForCpin(final PageDetails pageDetail) throws CustomException;
	
	// Report detail for Challan status
	PagebleDTO<GstReportDtlsCinStatusDto> getGstReportDetailsForChallanStatus(final PageDetails pageDetail) throws CustomException;
	
	// Report detail for Challan status consolidated
	PagebleDTO<GstReportDtlsCinStatusConsolidatedDto> getGstReportDetailsForChallanStatusConsolidated(final PageDetails pageDetail) throws CustomException;

	// Report detail for File summary
	PagebleDTO<GstReportDtlsFileSummaryDto> getGstReportDetailsForFileSummary(final PageDetails pageDetail) throws CustomException;

	// Report detail for Voucher details
	PagebleDTO<GstReportDtlsVoucherDetailsDto> getGstReportDetailsForVoucherDetails(final PageDetails pageDetail) throws CustomException;

	// Report detail for Block CPin
	PagebleDTO<GstReportDtlsBlockCPinDto> getGstReportDetailsForBlockCPin(final PageDetails pageDetail) throws CustomException;

	// Report detail for GSTN Vs RBI Challan Count
	PagebleDTO<GstReportDtlsGstnVsRbiChallanCountDto> getGstReportDetailsForGstnVsRbiChallanCount(final PageDetails pageDetail) throws CustomException;

	// Report detail for GSTN Daywise Challan Count
	PagebleDTO<GstReportDtlsGstnDaywiseChallanCountDto> getGstReportDetailsForGstnDaywiseChallanCount(final PageDetails pageDetail) throws CustomException, ParseException;
	
	// Report detail for Manual accounting
	PagebleDTO<GstReportDtlsManualAccountingDto> getGstReportDetailsForManualAccounting(final PageDetails pageDetail) throws CustomException;

	// Report detail for RBI  Daywise Challan Count
	PagebleDTO<GstReportDtlsRbiDaywiseChallanCountDto> getGstReportDetailsForRbiDaywiseChallanCount(final PageDetails pageDetail) throws CustomException, ParseException;

	// Report detail for CIN Modewise Taxpayer
	PagebleDTO<GstReportDtlsCinModewiseTaxpayertDto> getGstReportDetailsForCinModewiseTaxpayer(final PageDetails pageDetail) throws CustomException, ParseException;

	// Report detail for File Received Report
	PagebleDTO<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> getGstReportDetailsForFileReceivedReport(final PageDetails pageDetail) throws CustomException, ParseException;
	
	//CIN Vs EODCIN Master Report
	PagebleDTO<GstReportDtlsCinVsEodCinDto> getGstReportDetailsForCinVsEodcinMaster(final PageDetails pageDetail) throws CustomException;

	//CIN Vs EODCIN Daywise EODCIN Report
	PagebleDTO<GstReportDtlsCinVsEodCinDaywiseEodCinDto> getGstReportDetailsForCinVsEodcinDaywiseEodCin(final PageDetails pageDetail) throws CustomException;

	//CIN Vs EODCIN Daywise CIN Report
	PagebleDTO<GstReportDtlsCinVsEodCinDaywiseCinDto> getGstReportDetailsForCinVsEodcinDaywiseCin(final PageDetails pageDetail) throws CustomException;
		
	//CIN Vs EODCIN Daywise drill down Report
	PagebleDTO<GstReportDtlsCinVsEodCinDaywiseDrillDownDto> getGstReportDetailsForCinVsEodcinDaywise(final PageDetails pageDetail) throws CustomException;

	//CIN Vs EODCIN Difference drill down Report
	PagebleDTO<GstReportDtlsCinVsEodCinDifferenceDrillDownDto> getGstReportDetailsForCinVsEodcinDifferenceDrill(final PageDetails pageDetail) throws CustomException;

	//CIN Vs EODCIN Transaction Report
	PagebleDTO<GstReportDtlsCinVsEodCinDetailedTransactionDto> getGstReportDetailsForCinVsEodcinTransaction(final PageDetails pageDetail) throws CustomException;

	//CPIN Vs EODCPIN Master Report
	PagebleDTO<GstReportDtlsCpinVsEodCpinDto> getGstReportDetailsForCpinVsEodCpinMaster(final PageDetails pageDetail) throws CustomException;

	//CPIN Vs EODCPIN Daywise EODCIN Report
	PagebleDTO<GstReportDtlsCpinVsEodCpinDaywiseEodCpinDto> getGstReportDetailsForCpinVsEodCpinDaywiseEodCpin(final PageDetails pageDetail) throws CustomException;

	//CPIN Vs EODCPIN Daywise CIN Report
	PagebleDTO<GstReportDtlsCpinVsEodCpinDaywiseCpinDto> getGstReportDetailsForCpinVsEodCpinDaywiseCpin(final PageDetails pageDetail) throws CustomException;
		
	//CPIN Vs EODCPIN Daywise drill down Report
	PagebleDTO<GstReportDtlsCpinVsEodCpinDaywiseDrillDownDto> getGstReportDetailsForCpinVsEodCpinDaywise(final PageDetails pageDetail) throws CustomException;

	//CPIN Vs EODCPIN Difference drill down Report
	PagebleDTO<GstReportDtlsCpinVsEodCpinDifferenceDrillDownDto> getGstReportDetailsForCpinVsEodCpinDifferenceDrill(final PageDetails pageDetail) throws CustomException;

	//CPIN Vs EODCPIN Transaction Report
	PagebleDTO<GstReportDtlsCpinVsEodCpinDetailedTransactionDto> getGstReportDetailsForCpinVsEodCpinTransaction(final PageDetails pageDetail) throws CustomException;

	//Summary Penal Interest Report
	PagebleDTO<GstReportDtlsSummaryPenalInterestDto> getGstReportDetailsForSummaryPenalInterest(final PageDetails pageDetail) throws CustomException;

	//RBI Scroll Details Report
	PagebleDTO<GstReportDtlsRbiScrollDetailsDto> getGstReportDetailsForRbiScrollDetails(final PageDetails pageDetail) throws CustomException;
	
	// Report detail for RBI Scroll Stmnt Datewise Report
	PagebleDTO<GstReportDtlsRbiScrollStmntDatewiseReportDto> getGstReportDetailsForRbiScrollStmntDatewiseReport(final PageDetails pageDetail) throws CustomException, ParseException;

	// Report detail for RBI Scroll Stmnt Monthwise Report
	PagebleDTO<GstReportDtlsRbiScrollStmntMonthwiseReportDto> getGstReportDetailsForRbiScrollStmntMonthwiseReport(final PageDetails pageDetail) throws CustomException, ParseException;

	// Report detail for RBI Scroll Stmnt Transaction Report
	PagebleDTO<GstReportDtlsRbiScrollStmntTxnReportDto> getGstReportDetailsForRbiScrollStmntTxnReport(final PageDetails pageDetail) throws CustomException, ParseException;

	// Report detail for RBI Scroll Stmnt Daywise Report
	PagebleDTO<GstReportDtlsRbiScrollStmntDaywiseReportDto> getGstReportDetailsForRbiScrollStmntDaywiseReport(final PageDetails pageDetail) throws CustomException, ParseException;	
	
	// Report detail for GSTN File summary Report
	PagebleDTO<GstReportDtlsGSTNRBIFileSummaryReceivedReportDto> getGstReportDetailsForGstnFileSummaryReport(final PageDetails pageDetail) throws CustomException, ParseException;
	
	// Report detail for MOE Tracking Generate Report
	PagebleDTO<GstReportDtlsMoeTrackingGenerateReportDto> getGstReportDetailsForMoeTrackingGenerateReport(final PageDetails pageDetail) throws CustomException, ParseException;		

	// Report detail for MOE Tracking Generate sub Report
	PagebleDTO<GstReportDtlsMoeTrackingGenerateSubReportDto> getGstReportDetailsForMoeTrackingGenerateSubReport(final PageDetails pageDetail) throws CustomException, ParseException;		

	// Report detail for Jotting Vs Posting Report
	PagebleDTO<GstReportDtlsJottingVsPostingReportDto> getGstReportDetailsForJottingVsPostingReport(final PageDetails pageDetail) throws CustomException, ParseException;
	
	// Report detail for RBI Daywise Scroll Monitoring Report
	PagebleDTO<GstReportDtlsRbiDaywiseScrollMonitoringReportDto> getGstReportDetailsForRbiDaywiseScrollMonitoringReport(final PageDetails pageDetail) throws CustomException, ParseException;	

	// Report detail for RBI Pending Scrollwise Status Report
	PagebleDTO<GstReportDtlsRbiPendingScrollwiseStatusReportDto> getGstReportDetailsForRbiPendingScrollwiseStatusReport(final PageDetails pageDetail) throws CustomException, ParseException;	

	// Report detail for RBI InProcess Scrollwise Status Report
	PagebleDTO<GstReportDtlsRbiInProcessScrollwiseStatusReportDto> getGstReportDetailsForRbiInProcessScrollwiseStatusReport(final PageDetails pageDetail) throws CustomException, ParseException;	

	// Report detail for RBI Pending Scrollwise TransDetails Status Report
	PagebleDTO<GstReportDtlsRbiPendingScrollwiseTransDetailsStatusReportDto> getGstReportDetailsForRbiPendingScrollwiseTransDetailsStatusReport(final PageDetails pageDetail) throws CustomException, ParseException;	

	// Report detail for Performance Monitoring Report
	PagebleDTO<GstReportDtlsPerformanceMonitoringReportDto> getGstReportDetailsForPerformanceMonitoringReport(final PageDetails pageDetail) throws CustomException, ParseException;	
	
	// Report detail for 8658 Balance monitoring bankwise pending transaction count Report
	PagebleDTO<GstReportDtlsBalMonBankwisePendingTrans8658ReportDto> getGstReportDetailsForBalMontrngBankwisePendingTransCount8658Report(final PageDetails pageDetail) throws CustomException, ParseException;	

	// Report detail for 8658 Balance monitoring monthwise pending transaction count Report
	PagebleDTO<GstReportDtlsBalMonMonthwisePendingTrans8658ReportDto> getGstReportDetailsForBalMontrngMonthwisePendingTransCount8658Report(final PageDetails pageDetail) throws CustomException, ParseException;	

	// Report detail for 8658 Balance monitoring monthwise pending transaction count Report
	PagebleDTO<GstReportDtlsBalTrnsPendingTranswise8658ReportDto> getGstReportDetailsForBalMontrngTrnswisePendingTransCount8658Report(final PageDetails pageDetail) throws CustomException, ParseException;	
}