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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMONSSFLoanConverter;
import gov.ifms.dmo.converter.DMONSSFLoanRePaymentConverter;
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
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

@TestInstance(Lifecycle.PER_CLASS)
class DMONSSFLoanRePaymentServiceImplTest {

	@InjectMocks
	private DMONSSFLoanRePaymentServiceImpl service;

	@Mock
	DMONSSFLoanRePaymentRepository repository;

	@Mock
	DMONSSFLoanRepository nssfLoanRepository;

	@Mock
	DMODPSheetEntryRepository dpSheetEntryRepository;

	@Mock
	DMONSSFLoanRePaymentConverter converter;

	@Mock
	DMONSSFLoanConverter dmonssfLoanConverter;

	@Mock
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	@Mock
	DMONSSFLoanEntity entity;

	@Mock
	EDPMsFinancialYearEntity financialYearEntity;

	@Mock
	DMONSSFLoanEntity dmonssfLoanEntity;
	@Mock
	PageDetails pageDetails;

	@InjectMocks
	SearchCriteria searchCriteria;

	@Mock
	PageRequest pageable;

	@Mock
	DMOGOISearchDto goiSearchDto;

	@InjectMocks
	SpecificationImpl<DMONSSFLoanRePaymentEntity> spec;

	@Mock
	DMONSSFLoanDto loanDto;

	@Mock
	DMONSSFLoanRePaymentDto loanRePaymentDto;

	@Mock
	PagebleDTO<DMONSSFLoanDto> pagebleDTO;

	@Mock
	SearchParam searchParam;

	@Mock
	DMONSSFLoanRePaymentEntity loanRePaymentEntity;

	@Mock
	DMONSSFLoanRePaymentConverter loanRePaymentConverter;

	@Mock
	DMODPSheetEntryEntity dpsSheetEntryEntity;
	@Mock
	DMONSSFLoanPostDto loanPostDto;

	@Mock
	Page<DMONSSFLoanRePaymentEntity> page;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		loanDto = new DMONSSFLoanDto();
		loanRePaymentEntity = new DMONSSFLoanRePaymentEntity();
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(loanRePaymentEntity);
		when(converter.toDTO(loanRePaymentEntity)).thenReturn(loanDto);
		assertNotNull(service.findById(JunitConstants.LONG_TYPE));
	}

	@Test
	void save() throws CustomException {
		setLoanPostDto();
		List<DMONSSFLoanRePaymentDto> dmonssfLoanRePaymentDtos = new ArrayList<DMONSSFLoanRePaymentDto>();
		dmonssfLoanRePaymentDtos.add(loanRePaymentDto);
		when(nssfLoanRepository.findById(loanPostDto.getId())).thenReturn(Optional.of(entity));
		when(dmonssfLoanConverter.toDTO(entity)).thenReturn(loanPostDto);
		when(eDPMsFinancialYearRepository.findByFyStart(loanRePaymentDto.getInstallDueDate().getYear()))
				.thenReturn(financialYearEntity);
		List<DMONSSFLoanRePaymentDto> list = new ArrayList<DMONSSFLoanRePaymentDto>();
		list.add(loanRePaymentDto);
		List<DMONSSFLoanRePaymentEntity> paymentEntities = new ArrayList<DMONSSFLoanRePaymentEntity>();
		paymentEntities.add(loanRePaymentEntity);
		when(loanRePaymentConverter.toRePaymentEntity(dmonssfLoanRePaymentDtos)).thenReturn(paymentEntities);
		when(repository.saveAll(paymentEntities)).thenReturn(paymentEntities);
		when(loanRePaymentConverter.toRePaymentDTO(paymentEntities)).thenReturn(dmonssfLoanRePaymentDtos);
		List<DMONSSFLoanRePaymentDto> listDtos = service.save(loanPostDto);
		assertNotNull(listDtos);
	}

	@Test
	void update() {
		loanRePaymentEntity = new DMONSSFLoanRePaymentEntity();
		setLoanPostDto();
		List<DMONSSFLoanRePaymentDto> dmonssfLoanRePaymentDtos = new ArrayList<DMONSSFLoanRePaymentDto>();
		dmonssfLoanRePaymentDtos.add(loanRePaymentDto);
		when(repository.findById(loanRePaymentDto.getId())).thenReturn(Optional.of(loanRePaymentEntity));
		assertEquals("Updated Successfully !!", service.update(loanRePaymentDto));
	}

	@Test
	void testMatchWithPayable() {
		dmonssfLoanEntity = new DMONSSFLoanEntity();
		List<DMONSSFLoanRePaymentEntity> dmonssfLoanRePaymentEntities = new ArrayList<DMONSSFLoanRePaymentEntity>();
		loanRePaymentEntity = new DMONSSFLoanRePaymentEntity();
		loanRePaymentEntity.setInstallDueDate(LocalDate.now());
		loanRePaymentEntity.setInstallPaidAmount(10.00);
		loanRePaymentEntity.setPrincipalAmount(100.00);
		loanRePaymentEntity.setIntrestAmount(10.00);
		dpsSheetEntryEntity = new DMODPSheetEntryEntity();
		dpsSheetEntryEntity.setDebitAmt(100.00);
		dmonssfLoanRePaymentEntities.add(loanRePaymentEntity);
		dmonssfLoanEntity.setLoanAmount(100.00);
		dmonssfLoanEntity.setRepayments(dmonssfLoanRePaymentEntities);
		goiSearchDto = new DMOGOISearchDto();
		setLoanPostDto();
		when(repository.findById(goiSearchDto.getId())).thenReturn(Optional.of(loanRePaymentEntity));
		when(dpSheetEntryRepository.findById(goiSearchDto.getDpId())).thenReturn(Optional.of(dpsSheetEntryEntity));
		when(nssfLoanRepository.findById(goiSearchDto.getParentId())).thenReturn(Optional.of(dmonssfLoanEntity));
		assertNotNull(service.matchWithPayable(goiSearchDto));
	}

	private void setLoanPostDto() {
		loanRePaymentDto = new DMONSSFLoanRePaymentDto();
		loanRePaymentDto.setInstallDueDate(LocalDate.now());
		loanPostDto = new DMONSSFLoanPostDto();
		loanPostDto.setAdviceBy(JunitConstants.STRING_TYPE);
		loanPostDto.setAdviceNo(JunitConstants.STRING_TYPE);
		loanPostDto.setId(JunitConstants.LONG_TYPE);
		loanPostDto.setLoanAmount(1.00);
		loanPostDto.setFirstInstallDate(LocalDate.now());
		loanPostDto.setLoanTenure(JunitConstants.INTEGER_TYPE);
		loanPostDto.setPrncplInstallYear(JunitConstants.INTEGER_TYPE);
		loanPostDto.setLoanAmount(1.00);
		loanPostDto.setLoanROI(10.25);
		loanPostDto.setMoratariumPeriod(JunitConstants.INTEGER_TYPE);
	}
}
