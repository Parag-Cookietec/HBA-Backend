package gov.ifms.pvu.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
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

/**
 * The Class PVUMISReportsService.
 * 
 * @version v 1.0
 * @created 2020/07/29 15:45:41
 *
 */
public interface PVUMISReportsService {

	
	/**
	 * Gets the all lu look up info as map.
	 *
	 * @param procedureName the procedure name
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<EmpCreationLookUpView>> getLookUpInfoAsMap(String procedureName) throws CustomException;

	public List<EmpCreationLookUpView> getLookUpInfo(String procedureName) throws CustomException;

	
	public List<MISStatusLookUpView> getStatusLookUpInfoAsMap(String procedureName) throws CustomException;

	public List<MISInwardCaseLookupView> getInwardCaseLookUpInfoAsMap(String procedureName) throws CustomException;

	public List<MISInwardCaseLookupView> getDdoForwardLookUpInfoAsMap(String procedureName) throws CustomException;

	/**
	 * Fetch all the PVUStEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUStEventDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUMISCaseInqReportsVIew> getCaseInquiryReport(PageDetails pageDetail) throws CustomException;

	public PagebleDTO<PVUMISEmployeeCreationReportsView> getEmployeeCreationReport(PageDetails pageDetail) throws CustomException;
	
	public PagebleDTO<PVUMISEmployeeCreationReportsView> getDdoForwardCaseReport(PageDetails pageDetail) throws CustomException;
	

	public PagebleDTO<MISInwardCaseReportView> getInwardCaseReport(PageDetails pageDetail) throws CustomException;

	public PagebleDTO<MISInwardCaseEventCountReportView> getInwardCaseRopReport(PageDetails pageDetail) throws CustomException;

	public  String inwardListReport(PageDetails pageDetail) throws CustomException;
	
	public  String employeeCreationReport(PageDetails pageDetail) throws CustomException;
	
	public  String caseInquiryReportPDF(PageDetails pageDetail) throws CustomException ;
	
	public  String ddoForwardCaseReportPDF(PageDetails pageDetail) throws CustomException ;
	
	
	public PagebleDTO<MISInwardCaseEventCountReportView> getInwardCaseForEventCountReport(PageDetails pageDetail) throws CustomException;

	public PagebleDTO<MISInwardCaseReportView> getInwardCaseForEventDetailReport(PageDetails pageDetail) throws CustomException;
	
	public Map<String, List<MISCommonScreenLookUpView>> getOutwardLookUpInfoAsMap(String procedureName) throws CustomException ;
	
	public PagebleDTO<PVUMISOutwardCaseReportsView> getOutwardReport(PageDetails pageDetail) throws CustomException ;

	public PagebleDTO<MISOutwardCaseForEventCountView> getOutwardCaseForEventCountReport(PageDetails pageDetail) throws CustomException;

	public Map<String, List<MISCommonScreenLookUpView>> getCommonScreenLookUp(String procedureName) throws CustomException ;


	public PagebleDTO<MISInwardCaseReportView> getForwardCaseDdoWiseDetailReport(PageDetails pageDetail) throws CustomException;
	public PagebleDTO<MISForwardCaseDdoCountReportView> getForwardCaseDdoWiseCountReport(PageDetails pageDetail) throws CustomException;

	public PagebleDTO<MISReturnCaseCountReportView> getReturnCaseEventCountReport(PageDetails pageDetail) throws CustomException;
	public PagebleDTO<MISReturnCaseReportView> getReturnCaseEventDetailReport(PageDetails pageDetail) throws CustomException;
	
	public PagebleDTO<MISDistrictCaseReportView> getDistrictWiseEventReport(PageDetails pageDetail) throws CustomException;

	public PagebleDTO<PVUMISEmployeeCreationReportsView> getDdoEventStatusReport(PageDetails pageDetail) throws CustomException;
	
	
	public  String forwardCaseDDOWiseReportPDF(PageDetails pageDetail) throws CustomException ;
	
	public  String returnCaseReportPDF(PageDetails pageDetail) throws CustomException;
	
	public  String inwardCaseDetailsReportPDF(PageDetails pageDetail) throws CustomException ;
	
	public  String outwardCaseEventReportPDF(PageDetails pageDetail) throws CustomException ;

	public PagebleDTO<MISDistrictWisePendingStatusReportView> getDistrictWisePendingStatusReport(PageDetails pageDetail) throws CustomException;
	public PagebleDTO<MISReturnCaseCountReportView> getDistrictWisePendingStatusCountReport(PageDetails pageDetail) throws CustomException;

	public PagebleDTO<MISReturnCaseCountReportView> getDepartWisePendingStatusCountReport(PageDetails pageDetail) throws CustomException;
	public PagebleDTO<MISDistrictWisePendingStatusReportView> getDepartmentWisePendingEventReport(PageDetails pageDetail)
			throws CustomException ;

	public  String departmentWisePendingStatusReportPDF(PageDetails pageDetail) throws CustomException ;
	
	public  String districtWisePendingStatusReportPDF(PageDetails pageDetail) throws CustomException ;
	
	public PagebleDTO<MISTranRemarksView> getTrnRemarks(PageDetails pageDetail) throws CustomException;

	PagebleDTO<MISInwardCaseReportView> getEmployeeWiseMonthlyProgressEventReport(PageDetails pageDetail)
			throws CustomException;

	public  String ddoEventsStatusReportPDF(PageDetails pageDetail) throws CustomException ;

	public List<MISEmpWiseMonthlyProgressLookUpView> getEmpWiseLookUp(String procedureName) throws CustomException;

	
	public PagebleDTO<MISInwardCaseReportView> getPvuEventStatusReport(PageDetails pageDetail) throws CustomException;
	public PagebleDTO<MISPvuEventStatusReportView> getPvuEventStatusCountReport(PageDetails pageDetail) throws CustomException;
	
	public PagebleDTO<MISEmployeeMonthlyProgressCountReportView> getEmployeeMonthlyProgressCountReport(PageDetails pageDetail) throws CustomException;


	public  String getEmployeeWiseMonthlyProgressEventPDFReport(PageDetails pageDetail) throws CustomException ;
	
	public PagebleDTO<MISDistrictCaseReportView> getDepWiseVerificationReport(PageDetails pageDetail) throws CustomException;
	
	public  String departmentWiseVerificationPDFReport(PageDetails pageDetail) throws CustomException ;
	
	public  String districtWiseVerificationPDFReport(PageDetails pageDetail) throws CustomException ;


	public PagebleDTO<MISEventWisePendingStatusReportView> getEventWisePendingStatusCountReport(PageDetails pageDetail) throws CustomException;
	public PagebleDTO<MISInwardCaseReportView> getEventWisePendingStatusReport(PageDetails pageDetail) throws CustomException;

	public String eventWisePendingStatusPDFReport(PageDetails pageDetail) throws CustomException ;
	
	public String eventStatusPDFReport(PageDetails pageDetail) throws CustomException ;
	
	
	public PagebleDTO<MISEmpWiseWorkdoneReportView> getEmpWiseWorkdoneCountWiseReport(PageDetails pageDetail) throws CustomException;
	public PagebleDTO<MISEmpWiseWorkdoneDetailReportView> getEmpWiseWorkdoneReport(PageDetails pageDetail) throws CustomException;

	public String durationWisePendingStatusPDFReport(PageDetails pageDetail) throws CustomException ;
	
	public String employeeWiseWorkDonePDFReport(PageDetails pageDetail) throws CustomException ;
	
	public PagebleDTO<MISEmpWiseAllocationReportView> getEmpWiseAllocationReport(PageDetails pageDetail) throws CustomException;


	public PagebleDTO<MISPvuEmpMonthlyProgressCountTempReportView> tempCountReport(PageDetails pageDetail)
			throws CustomException ;
	
	public List<MISDurationPendingEnumOneReport> getDurationWisePendingStatusCombinationOneReportListing(PageDetails pageDetail) throws CustomException;
	public List<MISDurationPendingEnumOneReport> getDurationWisePendingStatusCombinationTwoReportListing(PageDetails pageDetail) throws CustomException;
	public List<MISDurationPendingEnumTwoReport> getDurationWisePendingStatusCombinationThreeReportListing(PageDetails pageDetail) throws CustomException;
	public List<MISInwardCaseReportView> getDurationWisePendingStatusCombinationFourReportListing(PageDetails pageDetail) throws CustomException;

	public String getEmpWiseAllocationPDFReport(PageDetails pageDetail) throws CustomException ;

}
