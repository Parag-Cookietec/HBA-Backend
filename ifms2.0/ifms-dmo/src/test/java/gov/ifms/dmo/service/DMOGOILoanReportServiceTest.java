package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGOILoanReportDto;
import gov.ifms.dmo.dto.DMOGOILoanReportSearchDto;
import gov.ifms.dmo.service.impl.DMOGOILoanReportService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMODBConstants;

@TestInstance(Lifecycle.PER_CLASS)
public class DMOGOILoanReportServiceTest {

	@InjectMocks
	DMOGOILoanReportService dmoReportService;

	@Mock
	EntityManager entityManager;

	@Mock
	StoredProcedureQuery query;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Test GOI Ministry Report ")
	void goiMinistryReport() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_GOI_MINISTRY_WISE_LOAN_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		// Declare the parameters in the same order
		createINOUTQuery(8, 1, query);

		// Pass the parameter values
		DMOGOILoanReportSearchDto pageDetail = setInputParameter();
		pageDetail.setLoanROI("9.5");
		pageDetail.setLoanAmount("100000");
		pageDetail.setLoanTenure("3");
		pageDetail.setFinancialYr("72");
		pageDetail.setMinistryName("72");
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getFinancialYr());
		query.setParameter(6, pageDetail.getLoanROI());
		query.setParameter(7, pageDetail.getLoanTenure());
		query.setParameter(8, pageDetail.getLoanAmount());
		query.setParameter(9, pageDetail.getMinistryName());
		
		// Execute query
		query.execute();
		List<DMOGOILoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		Object[] argsd = { "test", "20-21/DMO/GOI/001","2021-01-10", "4","1", "100000", "9.5" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMOGOILoanReportDto dto = new DMOGOILoanReportDto();
			dto.setDepartmentName(String.valueOf(ar[0]));
			dto.setSanctionOrderNo(String.valueOf(ar[1]));
			dto.setLoanStartDt(LocalDate.parse(String.valueOf(ar[2])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[3])));
			dto.setMoratoriumPeriod(Integer.valueOf(String.valueOf(ar[4])));
			dto.setLoanAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[6])));
			fy.add(dto.getDepartmentName());
			list.add(dto);
		});
		Map<String, List<DMOGOILoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getDepartmentName().equals(fyr)).collect(Collectors.toList()));
		}
		assertNotNull(dmoReportService.goiMinistryReport(pageDetail));
	}
	
	@Test
	@DisplayName("Test GOI Central Report ")
	void goiCentralReport() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_GOI_CENTRAL_LOAN_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);

		// Declare the parameters in the same order
		createINOUTQuery(4, 1, query);
		DMOGOILoanReportSearchDto pageDetail = setInputParameter();
		
		// Pass the parameter values
		setParameter(pageDetail, query);
		// Execute query
		query.execute();
		List<DMOGOILoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		Object[] argsd = { "test", "June","2021-01-10","100000", "4000", "1000", "5000" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMOGOILoanReportDto dto = new DMOGOILoanReportDto();
			dto.setDepartmentName(String.valueOf(ar[0]));
			dto.setMonthName(String.valueOf(ar[1]));
			dto.setPaymentDt(LocalDate.parse(String.valueOf(ar[2])));
			dto.setLoanAmount(Double.valueOf(String.valueOf(ar[3])));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[4])));
			dto.setInterestAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setTotalAmount(Double.valueOf(String.valueOf(ar[6])));
			fy.add(dto.getMonthName());
			list.add(dto);
		});
		Map<String, List<DMOGOILoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getMonthName().equals(fyr)).collect(Collectors.toList()));
		}
		assertNotNull(dmoReportService.goiCentralReport(pageDetail));
	}
	
	@Test
	@DisplayName("Test GOI SchemeWise Central Report Report ")
	void goiSchemeWiseCentralReport() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_GOI_SCHEME_WISE_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		
		// Declare the parameters in the same order
		createINOUTQuery(9, 1, query);
		DMOGOILoanReportSearchDto pageDetail = setInputParameter();
		pageDetail.setLoanROI("9.5");
		pageDetail.setLoanAmount("100000");
		pageDetail.setLoanPurpose("12");
		pageDetail.setMinistryName("test");
		pageDetail.setSchemeName("123");
		
		// Pass the parameter values
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getLoanROI());
		query.setParameter(6, pageDetail.getLoanPurpose());
		query.setParameter(7, pageDetail.getLoanAmount());
		query.setParameter(8, pageDetail.getMinistryName());
		query.setParameter(9, pageDetail.getSchemeName());
		// Execute query
		query.execute();
		List<DMOGOILoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		Object[] argsd = { "2019-2020", "test","1000", "4000", "5000" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMOGOILoanReportDto dto = new DMOGOILoanReportDto();
			dto.setFinancialYr(String.valueOf(ar[0]));
			dto.setSchemeName(String.valueOf(ar[1]));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[2])));
			dto.setInterestAmount(Double.valueOf(String.valueOf(ar[3])));
			dto.setTotalAmount(Double.valueOf(String.valueOf(ar[4])));
			fy.add(dto.getFinancialYr());
			list.add(dto);
		});
		assertNotNull(dmoReportService.goiSchemeWiseCentralReport(pageDetail));
	}

	private DMOGOILoanReportSearchDto setInputParameter() {
		DMOGOILoanReportSearchDto pageDetail = new DMOGOILoanReportSearchDto();
		pageDetail.setFromDate("2016-01-01");
		pageDetail.setToDate("2021-01-01");
		pageDetail.setPageIndex("0");
		pageDetail.setPageSize("10");
		return pageDetail;
	}
	private void setParameter(DMOGOILoanReportSearchDto pageDetail, StoredProcedureQuery query) {
		query.setParameter(1, pageDetail.getPageIndex());
		query.setParameter(2, pageDetail.getPageSize());
		query.setParameter(3, pageDetail.getFromDate());
		query.setParameter(4, pageDetail.getToDate());
		
	}

	private void createINOUTQuery(int countin, int countout, StoredProcedureQuery query) {
		for (int i = 1; i <= countin; i++) {
			query.registerStoredProcedureParameter(i, String.class, ParameterMode.IN);
		}
		for (int i = 1; i <= countout; i++) {
			query.registerStoredProcedureParameter(i, String.class, ParameterMode.OUT);
		}
	}
}
