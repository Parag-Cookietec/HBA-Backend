package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dao.GenericDaoImpl;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.dto.PVUMISCaseInqReportsVIew;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.service.PVUMISReportsServiceImpl;
import gov.ifms.pvu.util.PvuConstant;

class PVUMISReportsServiceImplTest {

	@InjectMocks
	private PVUMISReportsServiceImpl service;

	@Mock
	private GenericDaoImpl repostiory;

	@Mock
	List<SearchParam> jsonArr = new ArrayList<SearchParam>();

	@Mock
	PageDetails pageDetail = new PageDetails();

	@Mock
	PVUMISCaseInqReportsVIew pvuMISCaseInqReportsVIew = new PVUMISCaseInqReportsVIew();

	@Mock
	List<PVUMISCaseInqReportsVIew> objStorePro = new ArrayList<PVUMISCaseInqReportsVIew>();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetLookUpInfoAsMap() throws CustomException {

		assertNotNull(service.getLookUpInfoAsMap(PvuConstant.PVU_EMP_CREATION_LOOKUP_SP));
	}

	@Test
	void testGetCaseInquiryReport() throws CustomException {
		Map<String, Object> map = new HashMap<String, Object>();
		when(jsonArr.get(0)).thenReturn(new SearchParam("isSearch", "1"));
		when(jsonArr.get(1)).thenReturn(new SearchParam("empNo", "1"));
		when(jsonArr.get(2)).thenReturn(new SearchParam("empNo", "1"));
		when(jsonArr.get(3)).thenReturn(new SearchParam("empName", "V"));
		when(jsonArr.get(4)).thenReturn(new SearchParam("caseNo", ""));
		when(jsonArr.get(5)).thenReturn(new SearchParam("startDate", ""));
		when(jsonArr.get(6)).thenReturn(new SearchParam("endDate", ""));
		when(jsonArr.get(7)).thenReturn(new SearchParam("officeId", "0"));
		when(jsonArr.get(8)).thenReturn(new SearchParam("designationId", "0"));
		when(jsonArr.get(9)).thenReturn(new SearchParam("transNo", ""));
		when(jsonArr.get(10)).thenReturn(new SearchParam("workflowId", "0"));

		pageDetail.setJsonArr(jsonArr);
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_CASE_INQUIRY_RPT).toString();

		objStorePro.add(pvuMISCaseInqReportsVIew);
		when(service.storeProcPvu(procName, map, PVUMISCaseInqReportsVIew.class)).thenReturn(objStorePro);
		when(objStorePro.get(0)).thenReturn(pvuMISCaseInqReportsVIew);
		// assertNotNull(service.getCaseInquiryReport(pageDetail)); // need to work on
	}

	@Test
	void testGetEmployeeCreationReport() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("empNo", "1"));
		jsonArr.add(new SearchParam("empName", "V"));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("officeId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("transNo", " "));
		jsonArr.add(new SearchParam("workflowId", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getEmployeeCreationReport(pageDetail));
	}

	@Test
	void testGetStatusLookUpInfoAsMap() throws CustomException {

		assertNotNull(service.getStatusLookUpInfoAsMap("test"));
	}

	@Test
	void testGetDurationWisePendingStatusCombinationThreeReportListing() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eunmIndex1", "4"));
		jsonArr.add(new SearchParam("eunmIndex2", "4"));
		jsonArr.add(new SearchParam("eunmIndex3", "0"));
		jsonArr.add(new SearchParam("empNo", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getDurationWisePendingStatusCombinationThreeReportListing(pageDetail));
	}

	@Test
	void testGetOutwardReport() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("eventCode", "Higher_Pay_Scale"));
		jsonArr.add(new SearchParam("outwardFromDate", "2020/12/01"));
		jsonArr.add(new SearchParam("outwardToDate", "2021/01/28"));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("inCaseStatus", "827"));
		jsonArr.add(new SearchParam("officeName", "District Treasury Office, Gandhinagar"));
		jsonArr.add(new SearchParam("officeAddress", "Block-D, ground floor. M S Building, Sector-1"));
		jsonArr.add(new SearchParam("userName", "Mr. VIJAY CREATER GHANSHYAM SONI, Principal"));
		jsonArr.add(new SearchParam("reportName", "Outward Cases for Events"));
		jsonArr.add(new SearchParam("totalElement", "5"));
		jsonArr.add(new SearchParam("Event Name", "All"));
		jsonArr.add(new SearchParam("From Date", "01/12/2020"));
		jsonArr.add(new SearchParam("To Date", "28/01/2021"));
		jsonArr.add(new SearchParam("Employee Number", ""));
		jsonArr.add(new SearchParam("Case Status", "All"));
		jsonArr.add(new SearchParam("Selected Event", "Higher Pay Scale"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getOutwardReport(pageDetail));
	}

	@Test
	void testGetForwardCaseDdoWiseDetailReport() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("inwardFromDate", "2020/01/01"));
		jsonArr.add(new SearchParam("inwardToDate", "2021/01/28"));
		jsonArr.add(new SearchParam("eventCode", "Higher_Pay_Scale"));
		jsonArr.add(new SearchParam("districtId", "25"));
		jsonArr.add(new SearchParam("cardexNo", ""));
		jsonArr.add(new SearchParam("ddoCode", ""));
		jsonArr.add(new SearchParam("enumIndex", "3"));
		jsonArr.add(new SearchParam("officeId", "993"));
		jsonArr.add(new SearchParam("officeName", "District Treasury Office, Gandhinagar"));
		jsonArr.add(new SearchParam("officeAddress", "Block-D, ground floor. M S Building, Sector-1"));
		jsonArr.add(new SearchParam("userName", "Mr. VIJAY CREATER GHANSHYAM SONI, Principal"));
		jsonArr.add(new SearchParam("reportName", "Forward Cases DDO wise Fields Report"));
		jsonArr.add(new SearchParam("totalElement", "7"));
		jsonArr.add(new SearchParam("From Date", "01/01/2020"));
		jsonArr.add(new SearchParam("To Date", "28/01/2021"));
		jsonArr.add(new SearchParam("Event Name", "Higher Pay Scale"));
		jsonArr.add(new SearchParam("District", "Gandhinagar"));
		jsonArr.add(new SearchParam("Cardex No.", ""));
		jsonArr.add(new SearchParam("DDO No.", ""));
		jsonArr.add(new SearchParam("Selected Case", "In Progress Cases"));
		jsonArr.add(new SearchParam("Selected District", "Gandhinagar"));
		
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn(null);
		pageDetail.setSortOrder(null);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.getForwardCaseDdoWiseDetailReport(pageDetail));
	}
	
	@Test
	void testGetForwardCaseDdoWiseSearchFields() {
		List<PVUSearchEnum> searchFields = new ArrayList<PVUSearchEnum>();
		searchFields = Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
					PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
					PVUSearchEnum.PVU_SEARCH_FIELD_ENUM_INDEX, PVUSearchEnum.PVU_SEARCH_DISTRICT,
					PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_FIELD_DDO_CODE,PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE);
	assertEquals(searchFields, service.getForwardCaseDdoWiseSearchFields());
	}
	
	@Test
	void testCaseInquiryReportPDF() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eventCode", "Higher_Pay_Scale"));
		jsonArr.add(new SearchParam("empNo", "1000014838"));
		jsonArr.add(new SearchParam("panNo", ""));
		jsonArr.add(new SearchParam("caseNo", "0"));
		jsonArr.add(new SearchParam("transNo", "0"));
		jsonArr.add(new SearchParam("pPan", ""));
		jsonArr.add(new SearchParam("pPran", ""));
		jsonArr.add(new SearchParam("officeName", "District Treasury Office, Gandhinagar"));
		jsonArr.add(new SearchParam("officeAddress", "Block-D, ground floor. M S Building, Sector-1"));
		jsonArr.add(new SearchParam("userName", "Mr. VIJAY CREATER GHANSHYAM SONI, Principal"));
		jsonArr.add(new SearchParam("reportName", "Case Inquiry"));
		jsonArr.add(new SearchParam("Event Name", "Higher Pay Scale"));
		jsonArr.add(new SearchParam("Employee Number", "1000014838"));
		jsonArr.add(new SearchParam("PAN No.", ""));
		jsonArr.add(new SearchParam("Case No.", ""));
		jsonArr.add(new SearchParam("Reference No.", ""));
		
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		assertNotNull(service.caseInquiryReportPDF(pageDetail));
	}

}
