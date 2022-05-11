package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsMenuConverter;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.repository.EDPMsMenuRepository;

/**
 * The Class EDPMsMenuServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsMenuServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPMsMenuRepository repository;
	
	/** The list entity. */
	@Mock
	private List<EDPMsMenuEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPMsMenuEntity entity;
	
	/** The service. */
	@InjectMocks
	private EDPMsMenuServiceImpl service;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsMenuEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsMenuEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsMenuConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms menus.
	 */
	@Test
	void testGetMsMenus() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getMsMenus());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get ms menu.
	 */
	@Test
	void testGetMsMenu() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsMenu(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms menu.
	 */
	@Test
	void testSaveOrUpdateMsMenu() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsMenu(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete ms menu.
	 */
	@Test
	void testDeleteMsMenu() {
		service.deleteMsMenu(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms menus.
	 */
	@Test
	void testSaveMsMenus() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveMsMenus(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}

	/**
	 * Test edp ms menu as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsMenuAsMethodNameSearch() {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr())).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.edpMsMenuAsMethodNameSearch(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}
	
	/**
	 * Test get ms menu by sub module id.
	 */
	@Test
	void testGetMsMenuBySubModuleId() {
		when(repository.findByActiveStatusAndSubModuleIdSubModuleId(Constant.ACTIVE_STATUS,JunitConstants.LONG_TYPE)).thenReturn(listEntity);
		assertNotNull(service.getMsMenuBySubModuleId(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).findByActiveStatusAndSubModuleIdSubModuleId(Constant.ACTIVE_STATUS,JunitConstants.LONG_TYPE);
	}
	
	/**
	 * Test get permission by menu and post id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPermissionByMenuAndPostId() throws CustomException {
		Object[] object = new Object[4];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_TYPE;
		object[2] = JunitConstants.STRING_TYPE;
		object[3] = JunitConstants.STRING_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects).thenReturn(objects);
		assertNotNull(service.getPermissionByMenuAndPostId(JunitConstants.LONG_TYPE));
	}
	
	/**
	 * Test get ms menu by module id.
	 */
	@Test
	void testGetMsMenuByModuleId() {
		when(repository.findByModuleIdModuleIDAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		assertNotNull(service.getMsMenuByModuleId(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).findByModuleIdModuleIDAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS);
	}
}
