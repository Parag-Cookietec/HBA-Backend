package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import gov.ifms.dmo.dto.DMOLoanRepayListReportDto;
import gov.ifms.dmo.dto.DMOLoanRepayReportDto;
import gov.ifms.dmo.dto.DMOLoanRepayReportSearchDto;
import gov.ifms.dmo.entity.DMOGOILoanEntity;
import gov.ifms.dmo.entity.DMOInstitutionalLoanEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.repository.DMOInstitutionLoanRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMOLoanRepayReportService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMODBConstants;

@TestInstance(Lifecycle.PER_CLASS)
public class DMOLoanRepayReportServiceTest {

	@InjectMocks
	DMOLoanRepayReportService dmoReportService;

	@Mock
	EntityManager entityManager;

	@Mock
	StoredProcedureQuery query;

	@Mock
	DMOInstitutionLoanRepository institutionLoanRepository;
	@Mock
	DMOGOILoanRepository dmogoiLoanRepository;
	@Mock
	DMONSSFLoanRepository dmonssfLoanRepository;
	@Mock
	DMOMarketLoanRepository dmoMarketLoanRepository;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Test Loan Repay Report ")
	void dmoLoanRepayReport() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_LOAN_REPAYMENT_SCHEDULE_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		// Declare the parameters in the same order
		createINOUTQuery(8, 1, query);

		// Pass the parameter values
		DMOLoanRepayReportSearchDto pageDetail = setInputParameter();
		pageDetail.setTypeOfLoan("1");
		pageDetail.setSanctionNo("123");
		pageDetail.setLoanPurpose("3");
		pageDetail.setSchemeName("72");
		pageDetail.setMinistryName("72");
		pageDetail.setLoanDescription("test");
		pageDetail.setInstituteId("72");
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getTypeOfLoan());
		query.setParameter(6, pageDetail.getSanctionNo());
		query.setParameter(7, pageDetail.getLoanPurpose());
		query.setParameter(8, pageDetail.getSchemeName());
		query.setParameter(9, pageDetail.getMinistryName());
		query.setParameter(10, pageDetail.getLoanDescription());
		query.setParameter(11, pageDetail.getInstituteId());
		
		// Execute query
		query.execute();
		List<DMOLoanRepayReportDto> list = new ArrayList<>();
		// Get output parameters
		Object[] argsd = { "1","123","2021-01-10", "4","1", "100000", "9.5" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMOLoanRepayReportDto dto = new DMOLoanRepayReportDto();
			dto.setId(Long.valueOf(String.valueOf(ar[0])));
			if(pageDetail.getTypeOfLoan().equals("1") || pageDetail.getTypeOfLoan().equals("2")) {
				dto.setSanctionNo(String.valueOf(ar[1]));
			}else if(pageDetail.getTypeOfLoan().equals("3")) {
				dto.setLoanDescription(String.valueOf(ar[1]));
			}else {
				dto.setAccountNo(String.valueOf(ar[1]));
			}
			dto.setLoanStartDt(LocalDate.parse(String.valueOf(ar[2])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[3])));
			dto.setMoratoriumPeriod(Integer.valueOf(String.valueOf(ar[4])));
			dto.setLoanAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[6])));
			list.add(dto);
		});
		assertNotNull(dmoReportService.dmoLoanRepayReport(pageDetail));
	}

	@Test
	@DisplayName("Test Loan Repay Detail Report ")
	void loanRepayDetailReport() throws CustomException {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_LOAN_REPAYMENT_REPORT));
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		// Declare the parameters in the same order
		createINOUTQuery(8, 1, query);
		
		// Pass the parameter values
		DMOLoanRepayReportSearchDto pageDetail = setInputParameter();
		pageDetail.setNssfId("12");
		pageDetail.setGoiId("123");
		pageDetail.setMarketId("3");
		pageDetail.setInstitutionId("72");

		query.setParameter(1, pageDetail.getNssfId());
		query.setParameter(2, pageDetail.getGoiId());
		query.setParameter(3, pageDetail.getMarketId());
		query.setParameter(4, pageDetail.getInstitutionId());
		
		// Execute query
		query.execute();
		DMOLoanRepayReportDto reportDto = setHdrData(pageDetail);
		List<DMOLoanRepayListReportDto> list = new ArrayList<>();
		// Get output parameters
		Object[] argsd = { "2019-2020","2021-01-10", "12345", "4000","1000", "4000", "1000", "9.5", "10900" };
		List<Object[]> arraStrings = new ArrayList<>();
		arraStrings.add(argsd);
		when(query.getResultList()).thenReturn(arraStrings);
		arraStrings.forEach(ar -> {
			DMOLoanRepayListReportDto dto = new DMOLoanRepayListReportDto();
			dto.setFinancialYr(String.valueOf(ar[0]));
			dto.setInstallmentDt(LocalDate.parse(String.valueOf(ar[1])));
			dto.setOpeningBalance(Double.valueOf(String.valueOf(ar[2])));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[3])));
			dto.setInterestAmount(Double.valueOf(String.valueOf(ar[4])));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setPrincipalPaidAmount(Double.valueOf(String.valueOf(ar[6])));
			if(!pageDetail.getGoiId().equals("")) {
				dto.setInterestPaidAmount(Double.valueOf(String.valueOf(ar[7])));
				dto.setClosingBalance(Double.valueOf(String.valueOf(ar[8])));
			}else {
				dto.setInterestPaidAmount(Double.valueOf(String.valueOf(ar[7])));
				dto.setClosingBalance(Double.valueOf(String.valueOf(ar[8])));
			}
			dto.setLoanROI(reportDto.getLoanROI());
			list.add(dto);
		});
		reportDto.setLoanRepay(list);
		assertNotNull(dmoReportService.loanRepayDetailReport(pageDetail));
	}
	
	private DMOLoanRepayReportSearchDto setInputParameter() {
		DMOLoanRepayReportSearchDto pageDetail = new DMOLoanRepayReportSearchDto();
		pageDetail.setFromDate("2016-01-01");
		pageDetail.setToDate("2021-01-01");
		pageDetail.setPageIndex("0");
		pageDetail.setPageSize("10");
		return pageDetail;
	}
	private void setParameter(DMOLoanRepayReportSearchDto pageDetail, StoredProcedureQuery query) {
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
	
	private DMOLoanRepayReportDto setHdrData(DMOLoanRepayReportSearchDto pageDetail) {
		DMOLoanRepayReportDto dto = new DMOLoanRepayReportDto();
		if(!pageDetail.getNssfId().equals("")) {
			DMONSSFLoanEntity dmonssfLoanEntity = new DMONSSFLoanEntity();
			dmonssfLoanEntity.setSanctionOrderNo("123");
			dmonssfLoanEntity.setLoanStartDate(LocalDate.now());
			dmonssfLoanEntity.setLoanTenure(1);
			dmonssfLoanEntity.setMoratariumPeriod(1);
			dmonssfLoanEntity.setLoanAmount(10.0);
			dmonssfLoanEntity.setLoanROI(1.0);
			when(dmonssfLoanRepository.findById(Long.valueOf(pageDetail.getNssfId()))).thenReturn(Optional.of(dmonssfLoanEntity));
			Optional.of(dmonssfLoanEntity).ifPresent(nssf->{
				dto.setSanctionNo(nssf.getSanctionOrderNo());
				dto.setLoanStartDt(nssf.getLoanStartDate());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratariumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanROI());
			});
		} 
		if(!pageDetail.getGoiId().equals("")) {
			DMOGOILoanEntity dmonssfLoanEntity = new DMOGOILoanEntity();
			dmonssfLoanEntity.setSanctionOrderNo("123");
			dmonssfLoanEntity.setLoanStartDate(LocalDate.now());
			dmonssfLoanEntity.setLoanTenure(1);
			dmonssfLoanEntity.setMoratariumPeriod(1);
			dmonssfLoanEntity.setLoanAmount(10.0);
			dmonssfLoanEntity.setLoanROI(1.0);
			when(dmogoiLoanRepository.findById(Long.valueOf(pageDetail.getGoiId()))).thenReturn(Optional.of(dmonssfLoanEntity));
			Optional.of(dmonssfLoanEntity).ifPresent(nssf->{
				dto.setSanctionNo(nssf.getSanctionOrderNo());
				dto.setLoanStartDt(nssf.getLoanStartDate());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratariumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanROI());
			});
		}
		if(!pageDetail.getMarketId().equals("")) {
			DMOMarketLoanEntity dmonssfLoanEntity = new DMOMarketLoanEntity();
			dmonssfLoanEntity.setTransactionDesc("123");
			dmonssfLoanEntity.setLoanStartDt(LocalDate.now());
			dmonssfLoanEntity.setLoanTenure(1);
			dmonssfLoanEntity.setMoratoriumPeriod(1);
			dmonssfLoanEntity.setLoanAmount(10.0);
			dmonssfLoanEntity.setLoanRoi(1.0);
			when(dmoMarketLoanRepository.findById(Long.valueOf(pageDetail.getMarketId()))).thenReturn(Optional.of(dmonssfLoanEntity));
			Optional.of(dmonssfLoanEntity).ifPresent(nssf->{
				dto.setLoanDescription(nssf.getTransactionDesc());
				dto.setLoanStartDt(nssf.getLoanStartDt());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratoriumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanRoi());
			});
		}
		if(!pageDetail.getInstitutionId().equals("")) {
			DMOInstitutionalLoanEntity dmonssfLoanEntity = new DMOInstitutionalLoanEntity();
			dmonssfLoanEntity.setLoanAccNumber("123");
			dmonssfLoanEntity.setLoanStartDate(LocalDate.now());
			dmonssfLoanEntity.setLoanTenure(1);
			dmonssfLoanEntity.setMoratariumPeriod(1);
			dmonssfLoanEntity.setLoanAmount(10.0);
			dmonssfLoanEntity.setLoanROI(1.0);
			when(institutionLoanRepository.findById(Long.valueOf(pageDetail.getInstitutionId()))).thenReturn(Optional.of(dmonssfLoanEntity));
			Optional.of(dmonssfLoanEntity).ifPresent(nssf->{
				dto.setAccountNo(nssf.getLoanAccNumber());
				dto.setLoanStartDt(nssf.getLoanStartDate());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratariumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanROI());
			});
		}
		return dto;
	}
}
