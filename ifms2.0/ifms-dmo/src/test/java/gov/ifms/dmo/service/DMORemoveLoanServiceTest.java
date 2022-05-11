package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.entity.DMOGOILoanEntity;
import gov.ifms.dmo.entity.DMOInstituteMstEntity;
import gov.ifms.dmo.entity.DMOInstitutionalLoanEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.repository.DMOInstituteMstRespository;
import gov.ifms.dmo.repository.DMOInstitutionLoanRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMORemoveLoanService;

@TestInstance(Lifecycle.PER_METHOD)
class DMORemoveLoanServiceTest {

	@Mock
	DMOInstitutionLoanRepository repository;
	@Mock
	DMONSSFLoanRepository dmonssfLoanRepository;
	@Mock
	DMOGOILoanRepository dmogoiLoanRepository;
	@Mock
	DMOMarketLoanRepository dmoMarketLoanRepository;
	@Mock
	DMOInstituteMstRespository instituteMstRespository;
	@InjectMocks
	DMORemoveLoanService dmoLoanService;
	@Mock
	SerachApprovedDto searchApprovedDto;
	@Mock
	DMONSSFLoanEntity dmonssfLoanEntity;
	@Mock
	DMOMarketLoanEntity marketLoanEntity;
	@Mock
	DMOGOILoanEntity dmoGoiLoanEntity;
	@Mock
	DMOInstitutionalLoanEntity dmoInstitutionalLoanEntity;
	@Mock
	DMOInstituteMstEntity dmoInstituteMstEntity;
	@Mock
	DMOLookUpDto lookUpDto;
	@Mock
	IdDto idDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testRemoveLoan_nssf() {
		searchApprovedDto = new SerachApprovedDto();
		dmonssfLoanEntity = new DMONSSFLoanEntity();
		searchApprovedDto.setTypeOfLoan("NSSF");
		List<DMONSSFLoanEntity> dmonssfLoanEntities = new ArrayList<DMONSSFLoanEntity>();
		dmonssfLoanEntities.add(dmonssfLoanEntity);
		when(dmonssfLoanRepository.findAllByIdIn(searchApprovedDto.getIds())).thenReturn(dmonssfLoanEntities);
		when(dmonssfLoanRepository.save(dmonssfLoanEntity)).thenReturn(dmonssfLoanEntity);
		assertNotNull(dmoLoanService.removeLoan(searchApprovedDto));
	}

	@Test
	void testRemoveLoan_goi() {
		searchApprovedDto = new SerachApprovedDto();
		dmoGoiLoanEntity = new DMOGOILoanEntity();
		searchApprovedDto.setTypeOfLoan("GOI");
		List<DMOGOILoanEntity> dmonssfLoanEntities = new ArrayList<DMOGOILoanEntity>();
		dmonssfLoanEntities.add(dmoGoiLoanEntity);
		when(dmogoiLoanRepository.findAllByIdIn(searchApprovedDto.getIds())).thenReturn(dmonssfLoanEntities);
		when(dmogoiLoanRepository.save(dmoGoiLoanEntity)).thenReturn(dmoGoiLoanEntity);
		assertNotNull(dmoLoanService.removeLoan(searchApprovedDto));
	}

	@Test
	void testRemoveLoan_market() {
		searchApprovedDto = new SerachApprovedDto();
		marketLoanEntity = new DMOMarketLoanEntity();
		searchApprovedDto.setTypeOfLoan("Market");
		List<DMOMarketLoanEntity> dmonssfLoanEntities = new ArrayList<DMOMarketLoanEntity>();
		dmonssfLoanEntities.add(marketLoanEntity);
		when(dmoMarketLoanRepository.findAllByIdIn(searchApprovedDto.getIds())).thenReturn(dmonssfLoanEntities);
		when(dmoMarketLoanRepository.save(marketLoanEntity)).thenReturn(marketLoanEntity);
		assertNotNull(dmoLoanService.removeLoan(searchApprovedDto));
	}

	@Test
	void testRemoveLoan_institution() {
		searchApprovedDto = new SerachApprovedDto();
		dmoInstitutionalLoanEntity = new DMOInstitutionalLoanEntity();
		searchApprovedDto.setTypeOfLoan("Institution");
		List<DMOInstitutionalLoanEntity> dmonssfLoanEntities = new ArrayList<DMOInstitutionalLoanEntity>();
		dmonssfLoanEntities.add(dmoInstitutionalLoanEntity);
		when(repository.findAllByIdIn(searchApprovedDto.getIds())).thenReturn(dmonssfLoanEntities);
		when(repository.save(dmoInstitutionalLoanEntity)).thenReturn(dmoInstitutionalLoanEntity);
		assertNotNull(dmoLoanService.removeLoan(searchApprovedDto));
	}

	@Test
	void testLoanDesc() {
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanEntity> dmonssfLoanEntities = new ArrayList<DMOMarketLoanEntity>();
		dmonssfLoanEntities.add(marketLoanEntity);
		when(dmoMarketLoanRepository.findAllByActiveStatus(JunitConstants.INTEGER_TYPE))
				.thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.loanDesc());
	}

	@Test
	void testInstitute() throws CustomException {
		lookUpDto = new DMOLookUpDto();
		dmoInstituteMstEntity = new DMOInstituteMstEntity();
		dmoInstituteMstEntity.setInstituteName(JunitConstants.STRING_TYPE);
		dmoInstitutionalLoanEntity = new DMOInstitutionalLoanEntity();
		dmoInstitutionalLoanEntity.setInstituteId(JunitConstants.LONG_TYPE);
		dmoInstitutionalLoanEntity.setInstituteName(JunitConstants.STRING_TYPE);
		List<DMOLookUpDto> dmoLookUpDtos = new ArrayList<DMOLookUpDto>();
		dmoLookUpDtos.add(lookUpDto);
		List<DMOInstitutionalLoanEntity> dmonssfLoanEntities = new ArrayList<DMOInstitutionalLoanEntity>();
		dmonssfLoanEntities.add(dmoInstitutionalLoanEntity);
		when(repository.findAllByActiveStatus(JunitConstants.INTEGER_TYPE)).thenReturn(dmonssfLoanEntities);
		when(instituteMstRespository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(dmoInstituteMstEntity));
		List<DMOLookUpDto> dmoLookUpDtosResp = dmoLoanService.institute();
		assertEquals(JunitConstants.STRING_TYPE, dmoLookUpDtosResp.get(0).getName());
	}

	@Test
	void testTenche() throws CustomException {
		idDto = new IdDto();
		idDto.setId(JunitConstants.LONG_TYPE);
		dmoInstitutionalLoanEntity = new DMOInstitutionalLoanEntity();
		dmoInstitutionalLoanEntity.setInstituteId(JunitConstants.LONG_TYPE);
		dmoInstitutionalLoanEntity.setInstituteName(JunitConstants.STRING_TYPE);
		dmoInstitutionalLoanEntity.setTransactionDesc(JunitConstants.STRING_TYPE);
		List<DMOInstitutionalLoanEntity> dmonssfLoanEntities = new ArrayList<DMOInstitutionalLoanEntity>();
		dmonssfLoanEntities.add(dmoInstitutionalLoanEntity);
		when(repository.findAllByInstituteIdAndActiveStatus(idDto.getId(), JunitConstants.INTEGER_TYPE))
				.thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.tenche(idDto));
	}

	@Test
	void testSanctionNo() throws CustomException {
		dmonssfLoanEntity = new DMONSSFLoanEntity();
		dmonssfLoanEntity.setSanctionOrderNo(JunitConstants.STRING_TYPE);
		List<DMONSSFLoanEntity> dmonssfLoanEntities = new ArrayList<DMONSSFLoanEntity>();
		dmonssfLoanEntities.add(dmonssfLoanEntity);
		when(dmonssfLoanRepository.findAllByActiveStatus(JunitConstants.INTEGER_TYPE)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.sanctionNo());
	}

	@Test
	void testSearchLoan_nssf() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("NSSF");
		searchApprovedDto.setSanctionNo(JunitConstants.STRING_TYPE);
		dmonssfLoanEntity = new DMONSSFLoanEntity();
		List<DMONSSFLoanEntity> dmonssfLoanEntities = new ArrayList<DMONSSFLoanEntity>();
		dmonssfLoanEntities.add(dmonssfLoanEntity);
		when(dmonssfLoanRepository.findAllBySanctionOrderNoAndActiveStatus(searchApprovedDto.getSanctionNo(),
				JunitConstants.INTEGER_TYPE)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}

	@Test
	void testSearchLoan_nssf_from_date() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("NSSF");
		searchApprovedDto.setFromDate(LocalDate.now());
		searchApprovedDto.setToDate(LocalDate.now());
		dmonssfLoanEntity = new DMONSSFLoanEntity();
		List<DMONSSFLoanEntity> dmonssfLoanEntities = new ArrayList<DMONSSFLoanEntity>();
		dmonssfLoanEntities.add(dmonssfLoanEntity);
		when(dmonssfLoanRepository.findAllByAdviceDate(searchApprovedDto.getFromDate(), searchApprovedDto.getToDate(),
				1, 10)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}

	@Test
	void testSearchLoan_goi() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("GOI");
		searchApprovedDto.setLoanPurpose(JunitConstants.LONG_TYPE);
		searchApprovedDto.setMinistryId(JunitConstants.LONG_TYPE);
		searchApprovedDto.setSchemeId(JunitConstants.LONG_TYPE);
		dmoGoiLoanEntity = new DMOGOILoanEntity();
		List<DMOGOILoanEntity> dmonssfLoanEntities = new ArrayList<DMOGOILoanEntity>();
		dmonssfLoanEntities.add(dmoGoiLoanEntity);
		when(dmogoiLoanRepository.findAllByLoanPurposeAndNameOfMinistryAndPlanSchemeNameAndActiveStatus(
				searchApprovedDto.getLoanPurpose(), searchApprovedDto.getMinistryId(), searchApprovedDto.getSchemeId(),
				JunitConstants.INTEGER_TYPE)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}

	@Test
	void testSearchLoan_goi_from_date() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("GOI");
		searchApprovedDto.setFromDate(LocalDate.now());
		searchApprovedDto.setToDate(LocalDate.now());
		searchApprovedDto.setLoanPurpose(JunitConstants.LONG_TYPE);
		searchApprovedDto.setMinistryId(JunitConstants.LONG_TYPE);
		searchApprovedDto.setSchemeId(JunitConstants.LONG_TYPE);
		dmoGoiLoanEntity = new DMOGOILoanEntity();
		List<DMOGOILoanEntity> dmonssfLoanEntities = new ArrayList<DMOGOILoanEntity>();
		dmonssfLoanEntities.add(dmoGoiLoanEntity);
		when(dmogoiLoanRepository.findAllByAdviceDate(searchApprovedDto.getFromDate(), searchApprovedDto.getToDate(), 1,
				10)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}

	@Test
	void testSearchLoan_market() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("Market");
		searchApprovedDto.setTransDesc(JunitConstants.STRING_TYPE);
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanEntity> dmonssfLoanEntities = new ArrayList<DMOMarketLoanEntity>();
		dmonssfLoanEntities.add(marketLoanEntity);
		when(dmoMarketLoanRepository.findAllByTransactionDescAndActiveStatus(searchApprovedDto.getTransDesc(),
				JunitConstants.INTEGER_TYPE)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}

	@Test
	void testSearchLoan_market_from_date() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("Market");
		searchApprovedDto.setTransDesc(JunitConstants.STRING_TYPE);
		searchApprovedDto.setFromDate(LocalDate.now());
		searchApprovedDto.setToDate(LocalDate.now());
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanEntity> dmonssfLoanEntities = new ArrayList<DMOMarketLoanEntity>();
		dmonssfLoanEntities.add(marketLoanEntity);
		when(dmoMarketLoanRepository.findAllByAdviceDate(searchApprovedDto.getFromDate(), searchApprovedDto.getToDate(),
				1, 10)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}

	@Test
	void testSearchLoan_institution() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("Institution");
		searchApprovedDto.setTransDesc(JunitConstants.STRING_TYPE);
		dmoInstitutionalLoanEntity = new DMOInstitutionalLoanEntity();
		List<DMOInstitutionalLoanEntity> dmonssfLoanEntities = new ArrayList<DMOInstitutionalLoanEntity>();
		dmonssfLoanEntities.add(dmoInstitutionalLoanEntity);
		when(repository.findAllByTransactionDescAndActiveStatus(searchApprovedDto.getTransDesc(),
				JunitConstants.INTEGER_TYPE)).thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}

	@Test
	void testSearchLoan_institution_from_date() {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setTypeOfLoan("Institution");
		searchApprovedDto.setTransDesc(JunitConstants.STRING_TYPE);
		searchApprovedDto.setFromDate(LocalDate.now());
		searchApprovedDto.setToDate(LocalDate.now());
		dmoInstitutionalLoanEntity = new DMOInstitutionalLoanEntity();
		List<DMOInstitutionalLoanEntity> dmonssfLoanEntities = new ArrayList<DMOInstitutionalLoanEntity>();
		dmonssfLoanEntities.add(dmoInstitutionalLoanEntity);
		when(repository.findAllByAdviceDate(searchApprovedDto.getFromDate(), searchApprovedDto.getToDate(), 1, 10))
				.thenReturn(dmonssfLoanEntities);
		assertNotNull(dmoLoanService.searchLoan(searchApprovedDto));
	}
}
