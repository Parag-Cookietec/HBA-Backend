package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMONSSFLoanConverter;
import gov.ifms.dmo.converter.DMONSSFLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMOGOIApprovedRepayDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.dto.DMONSSFLoanRePaymentDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.entity.DMONSSFLoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMONSSFLoanRePaymentServiceImpl;
import gov.ifms.dmo.service.impl.DMONSSFLoanServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

@TestInstance(Lifecycle.PER_CLASS)
class DMONSSFLoanServiceTest {

	@InjectMocks
	private DMONSSFLoanServiceImpl service;

	@Mock
	DMONSSFLoanRePaymentServiceImpl loanRePaymentServiceImpl;

	@Mock
	DMONSSFLoanRepository repository;

	@Mock
	DMONSSFLoanConverter converter;

	@Mock
	DMONSSFLoanRePaymentConverter loanRePaymentConverter;

	/** The entity. */
	@Mock
	private DMONSSFLoanEntity entity;

	@Mock
	private DMODPSheetEntryEntity dpSheetEntryEntity;

	@Mock
	private DMONSSFLoanRePaymentEntity loanRePaymentEntity;

	@Mock
	private EDPMsFinancialYearEntity financialYearEntity;

	/** The entities. */
	@Mock
	private List<DMONSSFLoanEntity> entities;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	@Mock
	SerachApprovedDto serachApprovedDto;

	@Mock
	DMOGOIApprovedRepayDto goiApprovedRepayDto;

	@Mock
	DMONSSFLoanPostDto loanPostDto;

	@Mock
	DMONSSFLoanRePaymentDto loanRePaymentDto;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The spec. */
	@Mock
	private SpecificationImpl<DMONSSFLoanEntity> spec;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The page. */
	@Mock
	private Page<DMONSSFLoanEntity> page;

	@Mock
	DMODPSheetEntryRepository dpSheetRepository;

	@Mock
	EDPMsFinancialYearRepository financialYearRepository;

	@Mock
	DMONSSFLoanRePaymentRepository rePaymentRepository;

	@Mock
	DMONSSFLoanDto loanDto;

	@Mock
	DMOGOISearchDto goiSearchDto;

	/** The pageble dto. */
	@Mock
	private PagebleDTO<DMONSSFLoanPostDto> pagebleDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get NSSF Loan findById Success.
	 */
	@Test
	@DisplayName("Test NSSF Loan findById Success")
	void testFindById() {
		DMONSSFLoanPostDto dto = new DMONSSFLoanPostDto();
		dto.setAdviceBy(JunitConstants.STRING_TYPE);
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		DMONSSFLoanPostDto response = service.getNSSFLoanReceived(JunitConstants.LONG_TYPE);
		assertEquals(JunitConstants.STRING_TYPE, response.getAdviceBy());

	}

	/**
	 * Test save NSSF Loan save Success.
	 * 
	 * @throws CustomException
	 */

	@Test
	@DisplayName("Test NSSF Loan save Success")
	void save() throws CustomException {
		loanRePaymentDto = new DMONSSFLoanRePaymentDto();
		loanRePaymentDto.setInstallDueDate(LocalDate.now());
		entity = new DMONSSFLoanEntity();
		financialYearEntity = new EDPMsFinancialYearEntity();
		List<DMONSSFLoanRePaymentDto> dmonssfLoanRePaymentDtos = new ArrayList<DMONSSFLoanRePaymentDto>();
		dmonssfLoanRePaymentDtos.add(loanRePaymentDto);
		List<DMONSSFLoanEntity> entities = null;
		entity.setLoanReceiptDate(LocalDate.now());
		financialYearEntity.setFinancialYearId(JunitConstants.LONG_TYPE);
		Optional<List<DMONSSFLoanEntity>> entitiesOptional = Optional.ofNullable(entities);
		loanPostDto = new DMONSSFLoanPostDto();
		loanPostDto.setAdviceBy(JunitConstants.STRING_TYPE);
		loanPostDto.setAdviceNo(JunitConstants.STRING_TYPE);
		loanPostDto.setId(JunitConstants.LONG_TYPE);
		when(converter.toEntity(loanPostDto)).thenReturn(entity);
		when(repository.findAllByAdviceNo(loanPostDto.getAdviceNo())).thenReturn(entitiesOptional);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.NLR_TRN_SCREEN);
		when(repository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
				.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.NLR_REF_NO));
		entity.setRefrenceDate(LocalDateTime.now());
		entity.setRefrenceNo(JunitConstants.generateTrnNo(JunitConstants.NLR_REF_NO));
		when(financialYearRepository.findByFyStart(entity.getLoanReceiptDate().getYear()))
				.thenReturn(financialYearEntity);
		when(financialYearRepository.findByFyStart(entity.getLoanReceiptDate().getYear()))
				.thenReturn(financialYearEntity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(loanPostDto);
		when(loanRePaymentServiceImpl.save(loanPostDto)).thenReturn(dmonssfLoanRePaymentDtos);
		when(repository.findById(loanPostDto.getId())).thenReturn(Optional.of(entity));
		when(converter.toDTO(entity)).thenReturn(loanPostDto);
		when(financialYearRepository.findByFyStart(loanRePaymentDto.getInstallDueDate().getYear()))
				.thenReturn(financialYearEntity);
		List<DMONSSFLoanRePaymentDto> list = new ArrayList<DMONSSFLoanRePaymentDto>();
		list.add(loanRePaymentDto);
		List<DMONSSFLoanRePaymentEntity> paymentEntities = new ArrayList<DMONSSFLoanRePaymentEntity>();
		paymentEntities.add(loanRePaymentEntity);
		when(loanRePaymentConverter.toRePaymentEntity(dmonssfLoanRePaymentDtos)).thenReturn(paymentEntities);
		when(rePaymentRepository.saveAll(paymentEntities)).thenReturn(paymentEntities);
		when(loanRePaymentConverter.toRePaymentDTO(paymentEntities)).thenReturn(dmonssfLoanRePaymentDtos);
		DMONSSFLoanPostDto response = service.saveOrUpdateNSSFLoanReceived(loanPostDto);
		assertEquals(JunitConstants.STRING_TYPE, response.getAdviceBy());
	}

	@Test
	@DisplayName("Test NSSF Loan save Success")
	void save_AdviceNoExist() throws CustomException {
		try {
			entity = new DMONSSFLoanEntity();
			List<DMONSSFLoanEntity> entities = new ArrayList<DMONSSFLoanEntity>();
			entity.setLoanReceiptDate(LocalDate.now());
			Optional<List<DMONSSFLoanEntity>> entitiesOptional = Optional.ofNullable(entities);
			loanPostDto = new DMONSSFLoanPostDto();
			loanPostDto.setAdviceBy(JunitConstants.STRING_TYPE);
			loanPostDto.setAdviceNo(JunitConstants.STRING_TYPE);
			loanPostDto.setId(JunitConstants.LONG_TYPE);
			when(converter.toEntity(loanPostDto)).thenReturn(entity);
			when(repository.findAllByAdviceNo(loanPostDto.getAdviceNo())).thenReturn(entitiesOptional);
			service.saveOrUpdateNSSFLoanReceived(loanPostDto);
		} catch (CustomException e) {
			assertEquals("Advice No Is Already Present !!", e.getErrorMsg());
		}

	}

	@Test
	@DisplayName("Test NSSF Loan update Success")
	void update() throws CustomException {
		entity = new DMONSSFLoanEntity();
		entity.setLoanReceiptDate(LocalDate.now());
		Optional<DMONSSFLoanEntity> entityOptional = Optional.ofNullable(entity);
		loanPostDto = new DMONSSFLoanPostDto();
		loanPostDto.setAdviceBy(JunitConstants.STRING_TYPE);
		loanPostDto.setAdviceNo(JunitConstants.STRING_TYPE);
		loanPostDto.setId(JunitConstants.LONG_TYPE);
		when(repository.findById(loanPostDto.getId())).thenReturn(entityOptional);
		when(converter.toEntity(loanPostDto)).thenReturn(entity);
		when(repository.findById(loanPostDto.getId())).thenReturn(entityOptional);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(loanPostDto);
		DMONSSFLoanPostDto response = service.updateNSSFLoanReceived(loanPostDto);
		assertEquals(JunitConstants.STRING_TYPE, response.getAdviceBy());
	}

	@Test
	@DisplayName("Test NSSF Loan update Success")
	void update_IdNotPresent() throws CustomException {
		try {
			entity = new DMONSSFLoanEntity();
			entity.setLoanReceiptDate(LocalDate.now());
			Optional<DMONSSFLoanEntity> entityOptional = Optional.ofNullable(null);
			loanPostDto = new DMONSSFLoanPostDto();
			loanPostDto.setAdviceBy(JunitConstants.STRING_TYPE);
			loanPostDto.setAdviceNo(JunitConstants.STRING_TYPE);
			loanPostDto.setId(JunitConstants.LONG_TYPE);
			when(repository.findById(loanPostDto.getId())).thenReturn(entityOptional);
			when(converter.toEntity(loanPostDto)).thenReturn(entity);
			when(repository.findById(loanPostDto.getId())).thenReturn(entityOptional);
			when(repository.save(entity)).thenReturn(entity);
			when(converter.toDTO(entity)).thenReturn(loanPostDto);
			service.updateNSSFLoanReceived(loanPostDto);
		} catch (CustomException e) {
			assertEquals("NSSF Is Not Present !!", e.getErrorMsg());
		}

	}

	/**
	 * Test dmo NSFF module as method name search.
	 *
	 * @throws CustomException the custom exception
	 */

	@Test
	@DisplayName("Test NSSF Loan findAll Success")
	void getNSSFLoanApprovedList_success() throws CustomException {
		serachApprovedDto = new SerachApprovedDto();
		serachApprovedDto.setAdviceNo(JunitConstants.STRING_TYPE);
		serachApprovedDto.setFromDate(LocalDate.now());
		serachApprovedDto.setToDate(LocalDate.now());
		entity = new DMONSSFLoanEntity();
		List<DMONSSFLoanEntity> entities = new ArrayList<DMONSSFLoanEntity>();
		List<DMONSSFLoanPostDto> loanPostDtos = new ArrayList<DMONSSFLoanPostDto>();
		entities.add(entity);
		when(repository.findByAdviceNo(serachApprovedDto.getAdviceNo())).thenReturn(Optional.of(entity));
		when(repository.findAllByAdviceDate(serachApprovedDto.getFromDate(), serachApprovedDto.getToDate(), 1, 10))
				.thenReturn(entities);
		when(converter.toDTO(entities)).thenReturn(loanPostDtos);
		assertNotNull(service.getNSSFLoanApprovedList(serachApprovedDto));
	}

	@Test
	@DisplayName("Test NSSF Loan findAll Success")
	void getNSSFLoanApproved_AdviceNoNull() throws CustomException {
		serachApprovedDto = new SerachApprovedDto();
		serachApprovedDto.setFromDate(LocalDate.now());
		serachApprovedDto.setToDate(LocalDate.now());
		entity = new DMONSSFLoanEntity();
		List<DMONSSFLoanEntity> entities = new ArrayList<DMONSSFLoanEntity>();
		List<DMONSSFLoanPostDto> loanPostDtos = new ArrayList<DMONSSFLoanPostDto>();
		entities.add(entity);
		when(repository.findByAdviceNo(serachApprovedDto.getAdviceNo())).thenReturn(Optional.of(entity));
		when(repository.findAllByAdviceDate(serachApprovedDto.getFromDate(), serachApprovedDto.getToDate(), 1, 10))
				.thenReturn(entities);
		when(converter.toDTO(entities)).thenReturn(loanPostDtos);
		assertNotNull(service.getNSSFLoanApprovedList(serachApprovedDto));
	}

	@Test
	@DisplayName("Test NSSF Loan Get All Repayments Success")
	void testGetAllRepayments_success() throws CustomException {
		loanRePaymentDto = new DMONSSFLoanRePaymentDto();
		serachApprovedDto = new SerachApprovedDto();
		serachApprovedDto.setAdviceNo(JunitConstants.STRING_TYPE);
		serachApprovedDto.setFromDate(LocalDate.now());
		serachApprovedDto.setToDate(LocalDate.now());
		entity = new DMONSSFLoanEntity();
		List<DMONSSFLoanEntity> entities = new ArrayList<DMONSSFLoanEntity>();
		List<DMONSSFLoanPostDto> loanPostDtos = new ArrayList<DMONSSFLoanPostDto>();
		List<DMONSSFLoanRePaymentDto> dmonssfLoanRePaymentDtos = new ArrayList<DMONSSFLoanRePaymentDto>();
		dmonssfLoanRePaymentDtos.add(loanRePaymentDto);
		entities.add(entity);
		when(repository.findByAdviceNo(serachApprovedDto.getAdviceNo())).thenReturn(Optional.of(entity));
		when(loanRePaymentConverter.toRePaymentDTO(entity)).thenReturn(loanDto);
		when(loanRePaymentConverter.toRePaymentDTO(entity.getRepayments())).thenReturn(dmonssfLoanRePaymentDtos);
		when(repository.findAllByAdviceDate(serachApprovedDto.getFromDate(), serachApprovedDto.getToDate(), 1, 10))
				.thenReturn(entities);
		when(converter.toDTO(entities)).thenReturn(loanPostDtos);
		assertNotNull(service.getAllRepayments(serachApprovedDto));
	}

	@Test
	@DisplayName("Test NSSF Loan Get All Repayments")
	void testGetAllRepayments_failed() throws CustomException {
		try {
			loanRePaymentDto = new DMONSSFLoanRePaymentDto();
			serachApprovedDto = new SerachApprovedDto();
			serachApprovedDto.setAdviceNo(JunitConstants.STRING_TYPE);
			serachApprovedDto.setFromDate(LocalDate.now());
			serachApprovedDto.setToDate(LocalDate.now());
			entity = null;
			List<DMONSSFLoanEntity> entities = new ArrayList<DMONSSFLoanEntity>();
			List<DMONSSFLoanRePaymentDto> dmonssfLoanRePaymentDtos = new ArrayList<DMONSSFLoanRePaymentDto>();
			dmonssfLoanRePaymentDtos.add(loanRePaymentDto);
			entities.add(entity);
			when(repository.findByAdviceNo(serachApprovedDto.getAdviceNo())).thenReturn(Optional.ofNullable(entity));
			service.getAllRepayments(serachApprovedDto);
		} catch (CustomException e) {
			assertEquals("Advice No Is Not Present !!", e.getErrorMsg());
		}
	}

	@Test
	@DisplayName("Test NSSF Loan Search Repay Success")
	void searchRepay() throws CustomException {
		goiSearchDto = new DMOGOISearchDto();
		goiSearchDto.setFromDate(LocalDate.now());
		goiSearchDto.setToDate(LocalDate.now());
		loanRePaymentEntity = new DMONSSFLoanRePaymentEntity();
		loanRePaymentEntity.setInstallDueDate(LocalDate.now());
		List<DMONSSFLoanRePaymentEntity> entities = new ArrayList<DMONSSFLoanRePaymentEntity>();
		entities.add(loanRePaymentEntity);
		List<DMODPSheetEntryEntity> dmodpSheetEntryEntities = new ArrayList<DMODPSheetEntryEntity>();
		dmodpSheetEntryEntities.add(dpSheetEntryEntity);
		when(rePaymentRepository.findAllByAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(entities);
		when(dpSheetRepository.findAllByAndAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(dmodpSheetEntryEntities);
		DMOGOIApprovedRepayDto respGoiApprovedRepayDto = service.searchRepay(goiSearchDto);
		assertNotNull(respGoiApprovedRepayDto);

	}

	@Test
	@DisplayName("Test NSSF Loan Search Repay Success")
	void searchRepay_scenaio2() throws CustomException {
		entity = new DMONSSFLoanEntity();
		entity.setLoanROI(10.25);
		entity.setLoanAmount(100000.00);
		goiSearchDto = new DMOGOISearchDto();
		goiSearchDto.setFromDate(LocalDate.now());
		goiSearchDto.setToDate(LocalDate.of(2021, 10, 25));
		loanRePaymentEntity = new DMONSSFLoanRePaymentEntity();
		loanRePaymentEntity.setInstallDueDate(LocalDate.now());
		loanRePaymentEntity.setNssfLoanId(entity);
		loanRePaymentEntity.setIsInstallPaid(1);
		loanRePaymentEntity.setPrincipalAmount(100000.00);
		loanRePaymentEntity.setIntrestAmount(10.25);
		List<DMONSSFLoanRePaymentEntity> entities = new ArrayList<DMONSSFLoanRePaymentEntity>();
		entities.add(loanRePaymentEntity);
		List<DMODPSheetEntryEntity> dmodpSheetEntryEntities = new ArrayList<DMODPSheetEntryEntity>();
		dmodpSheetEntryEntities.add(dpSheetEntryEntity);
		when(rePaymentRepository.findAllByAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(entities);
		when(dpSheetRepository.findAllByAndAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(dmodpSheetEntryEntities);
		DMOGOIApprovedRepayDto respGoiApprovedRepayDto = service.searchRepay(goiSearchDto);
		assertNotNull(respGoiApprovedRepayDto);

	}
}
