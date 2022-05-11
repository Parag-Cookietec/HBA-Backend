package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPOfficeModuleConverter;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.edp.repository.EDPOfficeModuleRepository;

/**
 * The Class EDPOfficeModuleServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPOfficeModuleServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPOfficeModuleServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPOfficeModuleRepository repository;
	
	/** The entity. */
	@Mock
	private EDPOfficeModuleEntity entity;
	
	/** The dto. */
	@Mock
	private EDPMsOfficeDto dto;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPOfficeModuleEntity> page;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPOfficeModuleEntity> spec;
	
	/** The converter. */
	@Mock
	private EDPOfficeModuleConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get office module.
	 */
	@Test
	void testGetOfficeModule() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getOfficeModule(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update office module.
	 */
	@Test
	void testSaveOrUpdateOfficeModule() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateOfficeModule(entity));
		verify(repository).save(entity);
	}

/**
 * Test delete office module.
 */
//	@Test
	void testDeleteOfficeModule() {
	}

	/**
	 * Test get office modules.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetOfficeModules() throws Exception {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getOfficeModules(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test save office id and module id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveOfficeIdAndModuleId() throws CustomException {
		List<Long> longList = new ArrayList<>();
		longList.add(JunitConstants.LONG_TYPE);
		when(dto.getModuleId()).thenReturn(longList);
		when(dto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.updateActiveStatusByOfficeId(Mockito.any(Long.class), Mockito.any(Integer.class),
				Mockito.any(Long.class), Mockito.any(Date.class))).thenReturn(JunitConstants.INTEGER_TYPE);
		List<EDPOfficeModuleEntity> edpOfficeModuleEntityList=new ArrayList<>();
		edpOfficeModuleEntityList.add(entity);
		when(repository.saveAll(edpOfficeModuleEntityList)).thenReturn(edpOfficeModuleEntityList);
		service.saveOfficeIdAndModuleId(dto);
		verify(repository).saveAll(Mockito.anyList());
		when(dto.getModuleId()).thenReturn(null);
		service.saveOfficeIdAndModuleId(dto);
		
	}

}