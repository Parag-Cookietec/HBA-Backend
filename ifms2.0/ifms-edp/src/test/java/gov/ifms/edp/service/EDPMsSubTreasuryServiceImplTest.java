package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsSubTreasuryConverter;
import gov.ifms.edp.entity.EDPMsSubTreasuryEntity;
import gov.ifms.edp.repository.EDPMsSubTreasuryRepository;

@TestInstance(Lifecycle.PER_CLASS)
class EDPMsSubTreasuryServiceImplTest {

	@Mock
	private EDPMsSubTreasuryRepository repository;
	@Mock
	private EDPMsSubTreasuryConverter converter;
	@Mock
	private EDPMsSubTreasuryEntity entity;
	@Mock
	private PageDetails pageDetail;
	@Mock
	private PageRequest pageable;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	SpecificationImpl<EDPMsSubTreasuryEntity> spec;
	@Mock
	Page<EDPMsSubTreasuryEntity> page;
	@InjectMocks
	private EDPMsSubTreasuryServiceImpl service;

	@BeforeAll
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetMsSubTreasury() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsSubTreasury(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	@Test
	void testSaveOrUpdateMsSubTreasury() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsSubTreasury(entity));
		verify(repository).save(entity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetMsSubTreasurys() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		List<SearchParam> searchList = new ArrayList<>();
		searchList.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchList);
		when(searchCriteria.getSpecificationDetails(spec, searchList)).thenReturn(spec);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		assertNotNull(service.getMsSubTreasurys(pageDetail));
	}

}
