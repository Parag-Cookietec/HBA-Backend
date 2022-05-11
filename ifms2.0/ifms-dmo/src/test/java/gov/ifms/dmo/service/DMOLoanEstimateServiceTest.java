package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMOLoanEstimateConverter;
import gov.ifms.dmo.dto.DMOLoanEstimateDto;
import gov.ifms.dmo.entity.DMOLoanEstimateEntity;
import gov.ifms.dmo.repository.DMOLoanEstimateRepository;
import gov.ifms.dmo.service.impl.DMOLoanEstimateServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class DMOLoanEstimateServiceTest {

	@InjectMocks
	private DMOLoanEstimateServiceImpl dmoLoanEstimateServiceImpl;

	@Mock
	private DMOLoanEstimateRepository repository;

	@Mock
	private DMOLoanEstimateConverter convert;

	@Mock
	private DMOLoanEstimateEntity entity;

	@Mock
	private DMOLoanEstimateDto basePostDto;

	@Mock
	private PageDetails pageDetail;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private Page<DMOLoanEstimateEntity> dtlPage;
	@Mock
	private SpecificationImpl<DMOLoanEstimateEntity> dtlSpec;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test Advice Agency save success.")
	void testSaveAdvice() throws CustomException {
		basePostDto.setFinancialYearId(1l);
		basePostDto.setNssfLoanAmt(10d);
		basePostDto.setGoiLoanAmt(10d);
		basePostDto.setInstituteLoanAmt(10d);
		basePostDto.setMarketLoanAmt(10d);
		when(convert.toEntity(basePostDto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(convert.toDTO(entity)).thenReturn(basePostDto);
		basePostDto.setId(1l);
		assertNotNull(dmoLoanEstimateServiceImpl.save(basePostDto));
	}

	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test Advice Agency Get All success.")
	void getAllAdviceAgency() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageRequest);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(searchCriteria.getSpecificationDetails(dtlSpec, searchParams)).thenReturn(dtlSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class)))
				.thenReturn(dtlPage);
		when(dtlPage.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		List<DMOLoanEstimateEntity> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<DMOLoanEstimateDto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convert.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(dmoLoanEstimateServiceImpl.loanEstimateListing(pageDetail));
	}
}
