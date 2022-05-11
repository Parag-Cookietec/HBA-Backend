package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsActivitiesHeadConverter;
import gov.ifms.edp.entity.EDPMsActivitiesHeadEntity;
import gov.ifms.edp.repository.EDPMsActivitiesHeadRepository;

/**
 * The Class EDPMsActivitiesHeadServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class EDPMsActivitiesHeadServiceImplTest {
	
	/** The service. */
	@InjectMocks
	private EDPMsActivitiesHeadServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPMsActivitiesHeadRepository repository;
	
	/** The activities head entity list. */
	@Mock
	private List<EDPMsActivitiesHeadEntity> activitiesHeadEntityList;
	
	/** The edp ms activities head entity. */
	@Mock
	private EDPMsActivitiesHeadEntity edpMsActivitiesHeadEntity; 
	
	/** The entities. */
	@Mock
	private List<EDPMsActivitiesHeadEntity> entities;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsActivitiesHeadEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsActivitiesHeadEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsActivitiesHeadConverter converter;
	
	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test get ms activities heads.
	 */
	@Test
	public void testGetMsActivitiesHeads() {
		when(repository.findAll()).thenReturn(activitiesHeadEntityList);
		assertNotNull(service.getMsActivitiesHeads());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get ms activities head.
	 */
	@Test
	public void testGetMsActivitiesHead() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpMsActivitiesHeadEntity);
		assertNotNull(service.getMsActivitiesHead(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms activities head.
	 */
	@Test
	public void testSaveOrUpdateMsActivitiesHead() {
		when(repository.save(edpMsActivitiesHeadEntity)).thenReturn(edpMsActivitiesHeadEntity);
		assertNotNull(service.saveOrUpdateMsActivitiesHead(edpMsActivitiesHeadEntity));
		verify(repository).save(edpMsActivitiesHeadEntity);
	}

	/**
	 * Test delete ms activities head.
	 */
	@Test
	public void testDeleteMsActivitiesHead() {
		service.deleteMsActivitiesHead(JunitConstants.LONG_TYPE);
		verify(repository).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms activities heads.
	 */
	@Test
	public void testSaveMsActivitiesHeads() {
		when(repository.saveAll(entities)).thenReturn(entities);
		assertNotNull(service.saveMsActivitiesHeads(entities));
		verify(repository).saveAll(entities);
	}
	
	/**
	 * Test edp ms activities head as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEdpMsActivitiesHeadAsMethodNameSearch() {
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
		assertNotNull(service.edpMsActivitiesHeadAsMethodNameSearch(pageDetail));
	}

}