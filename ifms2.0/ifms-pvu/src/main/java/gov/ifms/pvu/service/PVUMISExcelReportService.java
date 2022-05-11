package gov.ifms.pvu.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;

/**
 * The Class PVUMISExcelReportService.
 * 
 * @version v 1.0
 * @created 2020/07/29 15:45:41
 *
 */
public interface PVUMISExcelReportService {

	public String getExcelDdoForwardCaseReport(PageDetails pageDetail) throws CustomException;

	public String getExcelEmployeeCreationReport(PageDetails pageDetail) throws CustomException;

	public String getExcelInwardCaseReport(PageDetails pageDetail) throws CustomException;

	public String getExcelCaseInquiryReport(PageDetails pageDetail) throws CustomException;

	public String getInwardCaseEventExcel(PageDetails pageDetail) throws CustomException;

	public String getOutwardCaseEventExcel(PageDetails pageDetail) throws CustomException;

	public String getForwardCaseDdoWiseReportExcel(PageDetails pageDetail) throws CustomException;

	public String getReturnCaseDdoWiseReportExcel(PageDetails pageDetail) throws CustomException;

	public String getDistrictWiseReportExcel(PageDetails pageDetail) throws CustomException;

	public String getDdoEventStatusReportExcel(PageDetails pageDetail) throws CustomException;

	public String getDistrictWisePendingStatusReportExcel(PageDetails pageDetail) throws CustomException;

	public String getDepartmentWisePendingStatusReportExcel(PageDetails pageDetail) throws CustomException;

	public String getEmpWiseMOnthlyProgressReportExcel(PageDetails pageDetail) throws CustomException;

	public String getPvuEventStatusReportExcel(PageDetails pageDetail) throws CustomException;

	public String getDeptVerificationReportExcel(PageDetails pageDetail) throws CustomException;

	public String getEventWisePendingStatusReportExcel(PageDetails pageDetail) throws CustomException;
	
	public String getEmpWiseWorkdoneReportExcel(PageDetails pageDetail) throws CustomException;
	public String getEmpWiseAllocationReportExcel(PageDetails pageDetail) throws CustomException;
	public String getDurationWisePendingReportExcel(PageDetails pageDetail) throws CustomException;

}
