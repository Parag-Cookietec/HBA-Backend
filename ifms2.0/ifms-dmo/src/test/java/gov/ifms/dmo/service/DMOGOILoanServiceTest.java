package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.converter.DMOGOILoanConverter;
import gov.ifms.dmo.converter.DMOGOILoanRePaymentConverter;
import gov.ifms.dmo.dto.DMOGOILoanDto;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.entity.DMOGOILoanEntity;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.service.impl.DMOGOILoanRePaymentServiceImpl;
import gov.ifms.dmo.service.impl.DMOGOILoanServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class DMOGOILoanServiceTest {

	@InjectMocks
	DMOGOILoanServiceImpl dmogoiLoanServiceImpl;

	@Mock
	DMOGOILoanRepository dmogoiLoanRepository;

	@Mock
	DMOGOILoanEntity dmogoiLoanEntity;
	@Mock
	EDPMsFinancialYearEntity edpMsFinancialYearEntity;

	@Mock
	DMOGOILoanConverter entryConverter;

	@Mock
	DMOGOILoanRePaymentConverter repaymentConverter;

	@Mock
	DMOGOILoanPostDto basePostDto;

	@Mock
	DMOGOILoanRePaymentServiceImpl loanRePaymentServiceImpl;

	@Mock
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	@Mock
	List<DMOGOILoanEntity> dmogoiLoanEntities;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test GOI save success.")
	void testSaveGuaranteeEntry() throws CustomException {
		basePostDto = getGoi();
		Object[] argsd = { "20-21/DMO/GOI/001" };
		List<Object[]> args = new ArrayList<>();
		args.add(argsd);
		assertEquals(0, 0);
		when(entryConverter.toEntity(basePostDto)).thenReturn(dmogoiLoanEntity);
		when(dmogoiLoanRepository.save(dmogoiLoanEntity)).thenReturn(dmogoiLoanEntity);
		when(entryConverter.toDTO(dmogoiLoanEntity)).thenReturn(basePostDto);
		basePostDto.setId(1l);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.NLR_TRN_SCREEN);
		when(dmogoiLoanRepository.callStoredProcedure(procName, argMap)).thenReturn(args);
		when(eDPMsFinancialYearRepository.findByFyStart(basePostDto.getLoanStartDate().getYear()))
				.thenReturn(edpMsFinancialYearEntity);
		basePostDto.setRefrenceDate(LocalDateTime.now());
		basePostDto.setRefrenceNo(generateTrnNo(DMOConstant.NLR_TRN_SCREEN));
		basePostDto.setBlockLoanStatus(false);
		basePostDto.setLoanFinanceYearId(edpMsFinancialYearEntity.getFinancialYearId());
		loanRePaymentServiceImpl.save(basePostDto);
		assertNotNull(dmogoiLoanServiceImpl.saveOrUpdateGOILoanReceived(basePostDto));
	}

	@Test
	@DisplayName("Test GOI received.")
	void getGOILoanReceived() throws CustomException {
		when(dmogoiLoanRepository.getOne(1l)).thenReturn(dmogoiLoanEntity);
		when(entryConverter.toDTO(dmogoiLoanEntity)).thenReturn(basePostDto);
		assertNotNull(dmogoiLoanServiceImpl.getGOILoanReceived(1l));
	}

//	@Test
//	@DisplayName("Test GOI received.")
//	void getGOILoanRepayments() throws CustomException {
//		DMOGOILoanDto dto = repaymentConverter.toRePaymentDTO(entity);
//		dto.setDtos(repaymentConverter.toRePaymentDTO(entity.getRepayments()));
//		when(dmogoiLoanRepository.getOne(1l)).thenReturn(dmogoiLoanEntity);
//		when(repaymentConverter.toRePaymentDTO(dmogoiLoanEntity)).thenReturn(basePostDto);
//		when(repaymentConverter.toRePaymentDTO(dmogoiLoanEntity.getRepayments())).thenReturn(basePostDto);
//		assertNotNull(dmogoiLoanServiceImpl.getGOILoanReceived(1l));
//	}

	@Test
	@DisplayName("Test GOI Approved List.")
	void getGOILoanApprovedList() throws CustomException {
		List<DMOGOILoanEntity> page = new ArrayList<>();
		List<DMOGOILoanPostDto> loanPostDtos = new ArrayList<>();
		SerachApprovedDto serachApprovedDto = new SerachApprovedDto();
		serachApprovedDto.setAdviceNo("1");
		serachApprovedDto.setPageIndex(0);
		serachApprovedDto.setPageElement(10);
		serachApprovedDto.setFromDate(LocalDate.now());
		if(null != serachApprovedDto.getAdviceNo() && !"".equals(serachApprovedDto.getAdviceNo())) {
			when(dmogoiLoanRepository.findByAdviceNoAndBlockLoanStatus(serachApprovedDto.getAdviceNo(), 
					(serachApprovedDto.getPageIndex() * serachApprovedDto.getPageElement()), 
					serachApprovedDto.getPageElement())).thenReturn(Optional.of(dmogoiLoanEntity));
			if(Optional.of(dmogoiLoanEntity).isPresent()) {
				page.add(dmogoiLoanEntity);
			}
		}else {
			when(dmogoiLoanRepository.findAllByAdviceDate(serachApprovedDto.getFromDate(), serachApprovedDto.getToDate(), 
					(serachApprovedDto.getPageIndex() * serachApprovedDto.getPageElement()),
					serachApprovedDto.getPageElement())).thenReturn(page);
			page.addAll(page);
		}
		when(entryConverter.toDTO(page)).thenReturn(loanPostDtos);
		assertNotNull(dmogoiLoanServiceImpl.getGOILoanApprovedList(serachApprovedDto));
	}

	public String generateTrnNo(String geTrnScreen) {
		return "20-21/DMO/GOI/001";
	}

	private DMOGOILoanPostDto getGoi() {
		DMOGOILoanPostDto dto = new DMOGOILoanPostDto();
		dto.setAdviceBy("test");
		dto.setAdviceDate(LocalDate.parse("2019-03-19"));
		dto.setAdviceNo("JG3OIU8");
		dto.setBackToBackLoan(1949l);
		dto.setDemandDateOfReceipt(LocalDate.parse("2019-03-19"));
		dto.setDpSheetId(74l);
		dto.setDpSheetRecDate(LocalDate.parse("2019-03-19"));
		dto.setFirstInstallDate(LocalDate.parse("2019-04-01"));
		dto.setInterestFirstInstallDate(LocalDate.parse("2019-04-01"));
		dto.setIntrestInstallYear(4);
		dto.setIsLoanOlder(0);
		dto.setLoanAmount(100000d);
		dto.setLoanPurpose(5l);
		dto.setLoanROI(9.5);
		dto.setLoanReceiptDate(LocalDate.parse("2019-04-01"));
		dto.setLoanStartDate(LocalDate.parse("2019-04-01"));
		dto.setLoanTenure(3);
		dto.setMoratariumPeriod(1);
		dto.setMoratriumPricipalPerc(9.5);
		dto.setNameOfMinistry(1l);
		dto.setOrganizationName("2");
		dto.setPanelInterest(9.5);
		dto.setPlanSchemeName(1l);
		dto.setPrincipalFirstInstallDate(LocalDate.parse("2020-04-01"));
		dto.setPrncplInstallYear(2);
		dto.setSanctionOrderNo("123");
		dto.setSanctionOrderDate(
				LocalDateTime.parse("2021-09-14 20:40:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		dto.setSrPageNo(6l);
		dto.setTotalPrncplInstall(12);
		dto.setTransactionDesc("test");
		dto.setTypeOfLoan(1948l);
		return dto;
	}
}
