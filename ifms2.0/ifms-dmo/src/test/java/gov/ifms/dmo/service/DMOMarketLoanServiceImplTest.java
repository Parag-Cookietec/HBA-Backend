package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMOMarketLoanConverter;
import gov.ifms.dmo.converter.DMOMarketLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.dto.DMOMarketLoanRePaymentDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.entity.DMOMarketLoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMOMarketLoanRePaymentServiceImpl;
import gov.ifms.dmo.service.impl.DMOMarketLoanServiceImpl;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

@TestInstance(Lifecycle.PER_METHOD)
class DMOMarketLoanServiceImplTest {

	@InjectMocks
	DMOMarketLoanServiceImpl dmoMarketLoanServiceImpl;

	@Mock
	DMOMarketLoanDto dmoMarketLoanDto;

	@Mock
	DMOMarketLoanEntity dmoMarketLoanEntity;

	@Mock
	DMOMarketLoanRepository repository;

	@Mock
	DMOMarketLoanRePaymentRepository loanRePaymentRepository;

	@Mock
	DMOMarketLoanConverter converter;

	@Mock
	DMOMarketLoanRePaymentConverter loanRePaymentConverter;

	@Mock
	DMODPSheetEntryRepository dpSheetRepository;

	@Mock
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	@Mock
	DMOMarketLoanRePaymentServiceImpl loanRePaymentServiceImpl;

	@Mock
	DMOMarketLoanEntity marketLoanEntity;

	@Mock
	DMONSSFLoanRepository nssfLoanRepository;

	@Mock
	DMONSSFLoanRePaymentRepository rePaymentRepository;

	@Mock
	DMOMarketLoanRePaymentEntity dmoMarketLoanRePaymentEntity;

	@Mock
	DMODPSheetEntryEntity dpDmodpSheetEntryEntity;

	@Mock
	SerachApprovedDto searchApprovedDto;

	@Mock
	DMOGOISearchDto goiSearchDto;
	@Mock
	DMOMarketLoanRePaymentDto dmoMarketLoanRePaymentDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void saveOrUpdate_success() throws CustomException {
		dmoMarketLoanEntity = new DMOMarketLoanEntity();
		dmoMarketLoanDto = new DMOMarketLoanDto();
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanDto> dmoMarketLoanDtos = new ArrayList<DMOMarketLoanDto>();
		dmoMarketLoanDtos.add(dmoMarketLoanDto);
		List<DMOMarketLoanEntity> dmonssfLoanEntities = null;
		when(repository.findAllByAdviceNo(dmoMarketLoanDto.getAdviceNo()))
				.thenReturn(Optional.ofNullable(dmonssfLoanEntities));
		when(converter.toEntity(dmoMarketLoanDto)).thenReturn(marketLoanEntity);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, DMOConstant.MML_SCREEN);
		when(repository.callStoredProcedure(JunitConstants.PROC_NAME, argMap))
				.thenReturn(JunitConstants.getRefNoSPResult(JunitConstants.MML_REF_NO));
		marketLoanEntity.setReferenceNo(JunitConstants.generateTrnNo(JunitConstants.MML_REF_NO));
		when(repository.save(marketLoanEntity)).thenReturn(marketLoanEntity);
		when(converter.toDTO(marketLoanEntity)).thenReturn(dmoMarketLoanDto);
		when(loanRePaymentServiceImpl.save(dmoMarketLoanDto)).thenReturn(dmoMarketLoanDtos);
		assertNotNull(dmoMarketLoanServiceImpl.saveOrUpdate(dmoMarketLoanDto));
	}

	@Test
	void saveOrUpdate_fail() throws CustomException {
		try {
			dmoMarketLoanEntity = new DMOMarketLoanEntity();
			dmoMarketLoanDto = new DMOMarketLoanDto();
			marketLoanEntity = new DMOMarketLoanEntity();
			List<DMOMarketLoanDto> dmoMarketLoanDtos = new ArrayList<DMOMarketLoanDto>();
			dmoMarketLoanDtos.add(dmoMarketLoanDto);
			List<DMOMarketLoanEntity> dmonssfLoanEntities = new ArrayList<DMOMarketLoanEntity>();
			dmonssfLoanEntities.add(marketLoanEntity);
			when(repository.findAllByAdviceNo(dmoMarketLoanDto.getAdviceNo()))
					.thenReturn(Optional.ofNullable(dmonssfLoanEntities));
			dmoMarketLoanServiceImpl.saveOrUpdate(dmoMarketLoanDto);
		} catch (CustomException e) {
			assertEquals("Advice No Is Already Present !!", e.getErrorMsg());
		}
	}

	@Test
	void testUpdateMarketLoanReceived_success() throws CustomException {
		dmoMarketLoanDto = new DMOMarketLoanDto();
		marketLoanEntity = new DMOMarketLoanEntity();
		dmoMarketLoanDto.setId(JunitConstants.LONG_TYPE);
		when(repository.findById(dmoMarketLoanDto.getId())).thenReturn(Optional.ofNullable(dmoMarketLoanEntity));
		when(converter.toEntity(dmoMarketLoanDto)).thenReturn(marketLoanEntity);
		when(repository.save(marketLoanEntity)).thenReturn(marketLoanEntity);
		when(converter.toDTO(marketLoanEntity)).thenReturn(dmoMarketLoanDto);
		assertNotNull(dmoMarketLoanServiceImpl.updateMarketLoanReceived(dmoMarketLoanDto));
	}

	@Test
	void testUpdateMarketLoanReceived_fail() throws CustomException {
		try {

			dmoMarketLoanDto = new DMOMarketLoanDto();
			marketLoanEntity = new DMOMarketLoanEntity();
			dmoMarketLoanDto.setId(JunitConstants.LONG_TYPE);
			marketLoanEntity = null;
			when(repository.findById(dmoMarketLoanDto.getId())).thenReturn(Optional.ofNullable(marketLoanEntity));
			when(converter.toEntity(dmoMarketLoanDto)).thenReturn(marketLoanEntity);
			when(repository.save(marketLoanEntity)).thenReturn(marketLoanEntity);
			when(converter.toDTO(marketLoanEntity)).thenReturn(dmoMarketLoanDto);
			dmoMarketLoanServiceImpl.updateMarketLoanReceived(dmoMarketLoanDto);
		} catch (CustomException e) {
			assertEquals("Market Is Not Present !!", e.getErrorMsg());
		}
	}

	@Test
	void testGetMarketLoanReceived() {
		dmoMarketLoanDto = new DMOMarketLoanDto();
		marketLoanEntity = new DMOMarketLoanEntity();
		dmoMarketLoanDto.setId(JunitConstants.LONG_TYPE);
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(marketLoanEntity);
		when(converter.toDTO(marketLoanEntity)).thenReturn(dmoMarketLoanDto);
		assertNotNull(dmoMarketLoanServiceImpl.getMarketLoanReceived(JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetApprovedList_sceanrio1() throws CustomException {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setAdviceNo(JunitConstants.STRING_TYPE);
		searchApprovedDto.setFromDate(LocalDate.now());
		searchApprovedDto.setToDate(LocalDate.now());
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanDto> dmoMarketLoanDtos = new ArrayList<DMOMarketLoanDto>();
		dmoMarketLoanDtos.add(dmoMarketLoanDto);
		List<DMOMarketLoanEntity> dmoMarketLoanEntities = new ArrayList<DMOMarketLoanEntity>();
		dmoMarketLoanEntities.add(marketLoanEntity);
		when(repository.findByAdviceNo(searchApprovedDto.getAdviceNo()))
				.thenReturn(Optional.ofNullable(marketLoanEntity));
		when(repository.findAllByAdviceDate(searchApprovedDto.getFromDate(), searchApprovedDto.getToDate(), 1, 10))
				.thenReturn(dmoMarketLoanEntities);
		when(converter.toDTO(dmoMarketLoanEntities)).thenReturn(dmoMarketLoanDtos);
		assertNotNull(dmoMarketLoanServiceImpl.getApprovedList(searchApprovedDto));
	}

	@Test
	void testGetApprovedList_sceanrio2() throws CustomException {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setFromDate(LocalDate.now());
		searchApprovedDto.setToDate(LocalDate.now());
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanDto> dmoMarketLoanDtos = new ArrayList<DMOMarketLoanDto>();
		dmoMarketLoanDtos.add(dmoMarketLoanDto);
		List<DMOMarketLoanEntity> dmoMarketLoanEntities = new ArrayList<DMOMarketLoanEntity>();
		dmoMarketLoanEntities.add(marketLoanEntity);
		when(repository.findByAdviceNo(searchApprovedDto.getAdviceNo()))
				.thenReturn(Optional.ofNullable(marketLoanEntity));
		when(repository.findAllByAdviceDate(searchApprovedDto.getFromDate(), searchApprovedDto.getToDate(), 1, 10))
				.thenReturn(dmoMarketLoanEntities);
		when(converter.toDTO(dmoMarketLoanEntities)).thenReturn(dmoMarketLoanDtos);
		assertNotNull(dmoMarketLoanServiceImpl.getApprovedList(searchApprovedDto));
	}

	@Test
	void testSearchMarket() throws CustomException {
		goiSearchDto = new DMOGOISearchDto();
		goiSearchDto.setFromDate(LocalDate.now());
		goiSearchDto.setToDate(LocalDate.now());
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanDto> dmoMarketLoanDtos = new ArrayList<DMOMarketLoanDto>();
		dmoMarketLoanDtos.add(dmoMarketLoanDto);
		List<DMOMarketLoanEntity> dmoMarketLoanEntities = new ArrayList<DMOMarketLoanEntity>();
		dmoMarketLoanEntities.add(marketLoanEntity);
		when(repository.findAllByAdviceDate(searchApprovedDto.getFromDate(), searchApprovedDto.getToDate(), 1, 10))
				.thenReturn(dmoMarketLoanEntities);
		when(converter.toDTO(dmoMarketLoanEntities)).thenReturn(dmoMarketLoanDtos);
		assertNotNull(dmoMarketLoanServiceImpl.searchMarket(goiSearchDto));
	}

	@Test
	void testGetAllRepayments_success() throws CustomException {
		searchApprovedDto = new SerachApprovedDto();
		searchApprovedDto.setFromDate(LocalDate.now());
		searchApprovedDto.setToDate(LocalDate.now());
		searchApprovedDto.setAdviceNo(JunitConstants.STRING_TYPE);
		marketLoanEntity = new DMOMarketLoanEntity();
		List<DMOMarketLoanRePaymentDto> dtos = new ArrayList<DMOMarketLoanRePaymentDto>();
		dtos.add(dmoMarketLoanRePaymentDto);
		when(repository.findByAdviceNo(searchApprovedDto.getAdviceNo()))
				.thenReturn(Optional.ofNullable(marketLoanEntity));
		when(loanRePaymentConverter.toRePaymentDTO(marketLoanEntity)).thenReturn(dmoMarketLoanDto);
		when(loanRePaymentConverter.toRePaymentDTO(marketLoanEntity.getRepayments())).thenReturn(dtos);
		assertNotNull(dmoMarketLoanServiceImpl.getAllRepayments(searchApprovedDto));
	}

	@Test
	void testGetAll_fail() throws CustomException {
		try {
			searchApprovedDto = new SerachApprovedDto();
			searchApprovedDto.setFromDate(LocalDate.now());
			searchApprovedDto.setToDate(LocalDate.now());
			searchApprovedDto.setAdviceNo(JunitConstants.STRING_TYPE);
			marketLoanEntity = null;
			List<DMOMarketLoanRePaymentDto> dtos = new ArrayList<DMOMarketLoanRePaymentDto>();
			dtos.add(dmoMarketLoanRePaymentDto);
			when(repository.findByAdviceNo(searchApprovedDto.getAdviceNo()))
					.thenReturn(Optional.ofNullable(marketLoanEntity));
			dmoMarketLoanServiceImpl.getAllRepayments(searchApprovedDto);
		} catch (CustomException e) {
			assertEquals("Advice No Is Not Present !!", e.getErrorMsg());
		}
	}

	@Test
	void testSearchRepay_scenario01() throws CustomException {
		goiSearchDto = new DMOGOISearchDto();
		goiSearchDto.setFromDate(LocalDate.now());
		goiSearchDto.setToDate(LocalDate.now());
		dmoMarketLoanRePaymentEntity = new DMOMarketLoanRePaymentEntity();
		dmoMarketLoanRePaymentEntity.setInstallDueDt(LocalDate.now());

		List<DMOMarketLoanRePaymentEntity> repay = new ArrayList<DMOMarketLoanRePaymentEntity>();
		repay.add(dmoMarketLoanRePaymentEntity);
		when(loanRePaymentRepository.findAllByAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(repay);
		List<DMODPSheetEntryEntity> dmodpSheetEntryEntities = new ArrayList<DMODPSheetEntryEntity>();
		dmodpSheetEntryEntities.add(dpDmodpSheetEntryEntity);
		when(dpSheetRepository.findAllByAndAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(dmodpSheetEntryEntities);
		assertNotNull(dmoMarketLoanServiceImpl.searchRepay(goiSearchDto));
	}

	@Test
	void testSearchRepay_scenario02() throws CustomException {
		goiSearchDto = new DMOGOISearchDto();
		goiSearchDto.setFromDate(LocalDate.now());
		goiSearchDto.setToDate(LocalDate.now());
		goiSearchDto.setToDate(LocalDate.of(2021, 10, 25));
		dmoMarketLoanRePaymentEntity = new DMOMarketLoanRePaymentEntity();
		dmoMarketLoanRePaymentEntity.setInstallDueDt(LocalDate.now());
		marketLoanEntity = new DMOMarketLoanEntity();
		marketLoanEntity.setLoanRoi(10.05);
		marketLoanEntity.setLoanAmount(100000.00);
		dmoMarketLoanRePaymentEntity.setInstallDueDt(LocalDate.now());
		dmoMarketLoanRePaymentEntity.setIsInstallPaid(1);
		dmoMarketLoanRePaymentEntity.setPrincipalAmount(100000.00);
		dmoMarketLoanRePaymentEntity.setInterstAmount(10.25);
		dmoMarketLoanRePaymentEntity.setMarketLoanHdrId(marketLoanEntity);
		List<DMOMarketLoanRePaymentEntity> repay = new ArrayList<DMOMarketLoanRePaymentEntity>();
		repay.add(dmoMarketLoanRePaymentEntity);
		when(loanRePaymentRepository.findAllByAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(repay);
		List<DMODPSheetEntryEntity> dmodpSheetEntryEntities = new ArrayList<DMODPSheetEntryEntity>();
		dmodpSheetEntryEntities.add(dpDmodpSheetEntryEntity);
		when(dpSheetRepository.findAllByAndAdviceDate(goiSearchDto.getFromDate(), goiSearchDto.getToDate()))
				.thenReturn(dmodpSheetEntryEntities);
		assertNotNull(dmoMarketLoanServiceImpl.searchRepay(goiSearchDto));
	}
}
