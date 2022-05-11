package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGRFCRFReportDto;
import gov.ifms.dmo.dto.DMOGRFCRFReportPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFStatementReportDto;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.repository.DMOGRFCRFReportRepository;
import gov.ifms.dmo.service.impl.DMOGRFCRFReportServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;

@TestInstance(Lifecycle.PER_CLASS)
class DMOGRFCRFReportServiceImplTest {

	@InjectMocks
	DMOGRFCRFReportServiceImpl grfCrfReportServiceImpl;

	@Mock
	DMOGRFCRFReportRepository grfcrfReportRepos;

	@Mock
	DMOGRFCRFReportPostDto dto;

	@Mock
	PagebleDTO<DMOGRFCRFReportDto> pagebleDTO;

	@Mock
	DMOGRFCRFLuLookUpService lookupService;

	@Mock
	DMOLookUpDto dmoLookUpDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("The Investment Sale Report - Scenario_01.")
	void testInvestmentSaleReport_1() throws CustomException {
		preapredMockObject();
		dmoLookUpDto = new DMOLookUpDto();
		Object[] objArr = spRespObjectArray();
		List<Object[]> responseList = new ArrayList<>();
		responseList.add(objArr);
		Map<String, Object> spParamMap = new HashMap<>();
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_INVST_SALE_REPORT));
		List<DMOLookUpDto> list = new ArrayList<DMOLookUpDto>();
		dmoLookUpDto.setId(100l);
		dmoLookUpDto.setName("Investment");
		list.add(dmoLookUpDto);
		when(lookupService.fetchLookUpData(dmoLookUpDto)).thenReturn(list);
		when(grfcrfReportRepos.callStoredProcedure(procName, spParamMap)).thenReturn(responseList);
		PagebleDTO<DMOGRFCRFReportDto> pagebleDTO = grfCrfReportServiceImpl.investmentSaleReport(dto);
		assertNotNull(pagebleDTO);
	}

	@Test
	@DisplayName("The Investment Sale Report - Scenario_02")
	void testInvestmentSaleReport_2() throws CustomException {
		preapredMockObject();
		dto.setInvestFromId("1955");
		dto.setFinancialYear("2021-2022");
		Object[] objArr = spRespObjectArray();
		List<Object[]> responseList = new ArrayList<>();
		responseList.add(objArr);
		Map<String, Object> spParamMap = new HashMap<>();
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_INVST_SALE_REPORT));
		when(grfcrfReportRepos.callStoredProcedure(procName, spParamMap)).thenReturn(responseList);
		PagebleDTO<DMOGRFCRFReportDto> pagebleDTO = grfCrfReportServiceImpl.investmentSaleReport(dto);
		assertNotNull(pagebleDTO);
	}

	@Test
	@DisplayName("The Year Wise Maturity Investment Report - Scenario_01")
	void testYrWiseMaturityInvestReport_01() throws CustomException {
		preapredMockObject();
		dto.setFromDate("2020-2021");
		dto.setToDate("2020-2021");
		Object[] objArr = spRespObjectArray();
		List<Object[]> responseList = new ArrayList<>();
		responseList.add(objArr);
		Map<String, Object> spParamMap = new HashMap<>();
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_YR_WISE_MATURITY_INVST_REPORT));
		when(grfcrfReportRepos.callStoredProcedure(procName, spParamMap)).thenReturn(responseList);
		PagebleDTO<DMOGRFCRFReportDto> pagebleDTO = grfCrfReportServiceImpl.yearWiseMaturityInvestmentReport(dto);
		assertNotNull(pagebleDTO);
	}

	@Test
	@DisplayName("The Total Investment Security Report - Scenario_01")
	void testTotalInvestmentSecurityReport_01() throws CustomException {
		preapredMockObject();
		dto.setFinancialYear("2021-2022");
		dto.setTypeOfSecurity("2");
		Object[] objArr = spRespObjectArray();
		List<Object[]> responseList = new ArrayList<>();
		responseList.add(objArr);
		Map<String, Object> spParamMap = new HashMap<>();
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_TOTAL_INVEST_SECURITY_REPORT));
		when(grfcrfReportRepos.callStoredProcedure(procName, spParamMap)).thenReturn(responseList);
		PagebleDTO<DMOGRFCRFReportDto> pagebleDTO = grfCrfReportServiceImpl.totalInvestmentSecurityReport(dto);
		assertNotNull(pagebleDTO);
	}

	@Test
	@DisplayName("The Statement Report - Scenario_01")
	void testStatementReport_01() throws CustomException {
		preapredMockObject();
		Object[] objArr = spRespObjectArray();
		List<Object[]> responseList = new ArrayList<>();
		responseList.add(objArr);
		Map<String, Object> spParamMap = new HashMap<>();
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_STATEMENT_REPORT));
		when(grfcrfReportRepos.callStoredProcedure(procName, spParamMap)).thenReturn(responseList);
		PagebleDTO<DMOGRFCRFStatementReportDto> pagebleDTO = grfCrfReportServiceImpl.statementReport(dto);
		assertNotNull(pagebleDTO);
	}

	private Object[] spRespObjectArray() {
		Object[] objArr = { "24", "1958", "1955", "2021-09-01", "2", "Mr. A.A.Patelaaa", "104.0", "106.0", "107",
				"108.0", 18 };
		return objArr;
	}

	private void preapredMockObject() {
		dto = new DMOGRFCRFReportPostDto();
		dto.setFromDate("2021-09-01");
		dto.setToDate("2021-10-20");
		dto.setInvestFromId("ALL");
		dto.setAccountTypeId("1958");
		dto.setPageIndex(0);
		dto.setPageSize(5);
	}

}
