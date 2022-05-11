package gov.ifms.edp.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsBankIfscConverter;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.edp.repository.EDPMsBankIfscRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class EDPMsBankIfscServiceImplTest {

	@InjectMocks
	private EDPMsBankIfscServiceImpl service;
	
	@Mock
	private EDPMsBankIfscRepository repository;

	@Mock
	private EDPMsBankIfscEntity entity;

	@Mock
	private Page<EDPMsBankIfscEntity> page;
	
	@Mock
	private PageDetails pageDetail;

	@Mock
	private PageRequest pageable;

	@Mock
	private EDPMsBankIfscConverter converter;

	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetMsBankIfsc() {
		service.getMsBankIfsc(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}
	
	@Test
	void testSaveOrUpdateMsBankIfsc() {
		service.saveOrUpdateMsBankIfsc(entity);
		verify(repository, times(1)).save(entity);
	}
	
	@Test
	void testGetMsBankIfscs() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		List<SearchParam> searchParams = new ArrayList<SearchParam>();
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.TRSN_NO);
		searchParam.setValue(JunitConstants.LONG_STRING_VALUE);
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		when(page.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(page.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(page.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.getMsBankIfscs(pageDetail));
	}
	
}
