package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
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
import gov.ifms.dmo.dto.DMONSSFLoanReportDto;
import gov.ifms.dmo.dto.DMONSSFLoanReportSearchDto;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMONSSFLoanReportService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMODBConstants;

@TestInstance(Lifecycle.PER_CLASS)
public class DMONSSFLoanReportServiceTest {

	@InjectMocks
	DMONSSFLoanReportService dmoReportService;
	@Mock
	DMONSSFLoanRepository dmoLoanRepository;

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
	@DisplayName("Test Nssf Receipt Report ")
	void nssfReceiptReport() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_LOAN_RECEIPT_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		// Declare the parameters in the same order
		createINOUTQuery(8, 1, query);

		// Pass the parameter values
		DMONSSFLoanReportSearchDto pageDetail = setInputParameter();
		pageDetail.setLoanROI("9.5");
		pageDetail.setLoanAmount("100000");
		pageDetail.setLoanTenure("3");
		pageDetail.setSanctionNo("123");
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getLoanROI());
		query.setParameter(6, pageDetail.getLoanTenure());
		query.setParameter(7, pageDetail.getLoanAmount());
		query.setParameter(8, pageDetail.getSanctionNo());
		
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		Object[] argsd = { "20-21/DMO/GOI/001","2021-01-10", "4", "1", "9.5", "100000", "2021" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setSanctionNo(String.valueOf(ar[0]));
			dto.setLoanStartDt(LocalDate.parse(String.valueOf(ar[1])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[2])));
			dto.setMoratoriumPeriod(Integer.valueOf(String.valueOf(ar[3])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[4])));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[5]))));
			dto.setFinancialYr(String.valueOf(ar[6]));
			fy.add(dto.getFinancialYr());
			list.add(dto);
		});
		Map<String, List<DMONSSFLoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getFinancialYr().equals(fyr)).collect(Collectors.toList()));
		}
		assertNotNull(dmoReportService.nssfReceiptReport(pageDetail));
	}
	
	@Test
	@DisplayName("Test Nssf Monthly Receipt Report ")
	void nssfMonthlyReceipt() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_LOAN_MONTHLY_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);

		// Declare the parameters in the same order
		createINOUTQuery(5, 1, query);
		DMONSSFLoanReportSearchDto pageDetail = setInputParameter();
		pageDetail.setSanctionNo("123");
		
		// Pass the parameter values
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getSanctionNo());
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		Object[] argsd = { "June", "20-21/DMO/GOI/001","100000","2021-01-10", "4000", "1000", "5000" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setMonthName(String.valueOf(ar[0]));
			dto.setSanctionNo(String.valueOf(ar[1]));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setPaymentDt(LocalDate.parse(String.valueOf(ar[3])));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[4]))));
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[5]))));
			dto.setTotalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[6]))));
			fy.add(dto.getMonthName());
			list.add(dto);
		});
		Map<String, List<DMONSSFLoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getMonthName().equals(fyr)).collect(Collectors.toList()));
		}
		assertNotNull(dmoReportService.nssfMonthlyReceipt(pageDetail));
	}
	
	@Test
	@DisplayName("Test Nssf Monthly Receipt Report ")
	void nssfOutstanding() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_TOTAL_OUTSTANDING_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);

		// Declare the parameters in the same order
		createINOUTQuery(5, 1, query);
		DMONSSFLoanReportSearchDto pageDetail = setInputParameter();
		pageDetail.setSanctionNo("123");
		
		// Pass the parameter values
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getSanctionNo());
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		Object[] argsd = { "20-21/DMO/GOI/001","2021-01-10","100000", "4000", "10000" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setSanctionNo(String.valueOf(ar[0]));
			dto.setLoanReceiptDt(LocalDate.parse(String.valueOf(ar[1])));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[3]))));
			dto.setOutstandingAmount(Double.valueOf(String.valueOf(ar[4])));
			list.add(dto);
		});
		assertNotNull(dmoReportService.nssfOutstanding(pageDetail));
	}

	@Test
	@DisplayName("Test Nssf Repaid Yearly Receipt Report ")
	void nssfRepaidYearly() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_REPAID_YEARLY_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		
		// Declare the parameters in the same order
		createINOUTQuery(6, 1, query);
		DMONSSFLoanReportSearchDto pageDetail = setInputParameter();
		pageDetail.setLoanROI("9.5");
		pageDetail.setLoanAmount("100000");
		
		// Pass the parameter values
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getLoanROI());
		query.setParameter(6, pageDetail.getLoanAmount());
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		Object[] argsd = { "2019-2020","100000", "4000" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setFinancialYr(String.valueOf(ar[0]));
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[1]))));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setTotalAmount(BigDecimal.valueOf(dto.getPrincipalAmount().doubleValue() + dto.getInterestAmount().doubleValue()));
			list.add(dto);
		});
		assertNotNull(dmoReportService.nssfRepaidYearly(pageDetail));
	}

	@Test
	@DisplayName("Test Nssf Repaid Monthly Receipt Report ")
	void nssfRepaidMonthly() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_REPAID_MONTHLY_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		
		// Declare the parameters in the same order
		createINOUTQuery(5, 1, query);
		DMONSSFLoanReportSearchDto pageDetail = new DMONSSFLoanReportSearchDto();
		pageDetail.setYearNo("72");
		pageDetail.setPageIndex("0");
		pageDetail.setPageSize("10");
		pageDetail.setLoanROI("9.5");
		pageDetail.setLoanAmount("100000");
		
		// Pass the parameter values
		query.setParameter(1, pageDetail.getPageIndex());
		query.setParameter(2, pageDetail.getPageSize());
		query.setParameter(3, pageDetail.getYearNo());
		query.setParameter(4, pageDetail.getLoanROI());
		query.setParameter(5, pageDetail.getLoanAmount());
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		Object[] argsd = { "1","67","100000", "4000" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setMonthName(Month.of(Integer.valueOf(String.valueOf(ar[0]))).name());
			dto.setMonthNo(String.valueOf(ar[0]));
			dto.setFinancialYr(String.valueOf(ar[1]));
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[3]))));
			dto.setTotalAmount(BigDecimal.valueOf(dto.getPrincipalAmount().doubleValue() + dto.getInterestAmount().doubleValue()));
			list.add(dto);
		});
		assertNotNull(dmoReportService.nssfRepaidMonthly(pageDetail));
	}

	@Test
	@DisplayName("Test Nssf Repaid Date Wise Receipt Report ")
	void nssfRepaidDateWise() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_REPAID_DATE_WISE_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		
		// Declare the parameters in the same order
		createINOUTQuery(6, 1, query);
		DMONSSFLoanReportSearchDto pageDetail = new DMONSSFLoanReportSearchDto();
		pageDetail.setYearNo("72");
		pageDetail.setMonthNo("12");
		pageDetail.setPageIndex("0");
		pageDetail.setPageSize("10");
		pageDetail.setLoanROI("9.5");
		pageDetail.setLoanAmount("100000");
		
		// Pass the parameter values
		query.setParameter(1, pageDetail.getPageIndex());
		query.setParameter(2, pageDetail.getPageSize());
		query.setParameter(3, pageDetail.getYearNo());
		query.setParameter(4, pageDetail.getMonthNo());
		query.setParameter(5, pageDetail.getLoanROI());
		query.setParameter(6, pageDetail.getLoanAmount());
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		Object[] argsd = { "2021-01-01", "20-21/DMO/GOI/001","100000","2021-01-01","4","9.5","2000", "4000", "6000" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setPaymentDt(LocalDate.parse(String.valueOf(ar[0])));
			dto.setSanctionNo(String.valueOf(ar[1]));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setLoanReceiptDt(LocalDate.parse(String.valueOf(ar[3])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[4])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[5])));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[6]))));
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[7]))));
			dto.setTotalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[8]))));
			list.add(dto);
		});
		assertNotNull(dmoReportService.nssfRepaidDateWise(pageDetail));
	}
	
	private DMONSSFLoanReportSearchDto setInputParameter() {
		DMONSSFLoanReportSearchDto pageDetail = new DMONSSFLoanReportSearchDto();
		pageDetail.setFromDate("2016-01-01");
		pageDetail.setToDate("2021-01-01");
		pageDetail.setPageIndex("0");
		pageDetail.setPageSize("10");
		return pageDetail;
	}
	private void setParameter(DMONSSFLoanReportSearchDto pageDetail, StoredProcedureQuery query) {
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
