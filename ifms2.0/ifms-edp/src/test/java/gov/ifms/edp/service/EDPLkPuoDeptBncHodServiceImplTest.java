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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPLkPuoDeptBncHodConverter;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLkPuoDeptBncHodEntity;
import gov.ifms.edp.repository.EDPLkPuoDeptBncHodRepository;

/**
 * The Class EDPLkPuoDeptBncHodServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPLkPuoDeptBncHodServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPLkPuoDeptBncHodRepository repository;
	
	/** The entity. */
	@Mock
	private EDPLkPuoDeptBncHodEntity entity;
	
	/** The emp entity. */
	@Mock
	private EDPEmployeEntity empEntity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPLkPuoDeptBncHodEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPLkPuoDeptBncHodEntity> page;
	
	/** The converter. */
	@Mock
	private EDPLkPuoDeptBncHodConverter converter;
	
	/** The service. */
	@InjectMocks
	private EDPLkPuoDeptBncHodServiceImpl service;
	
	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test get lk puo dept bnc hod.
	 */
	@Test
	void testGetLkPuoDeptBncHod() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getLkPuoDeptBncHod(JunitConstants.LONG_TYPE));
		verify(repository,times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update lk puo dept bnc hod.
	 */
	@Test
	void testSaveOrUpdateLkPuoDeptBncHod() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateLkPuoDeptBncHod(entity));
		verify(repository,times(1)).save(entity);
	}

	/**
	 * Test delete lk puo dept bnc hod.
	 */
	//@Test
	void testDeleteLkPuoDeptBncHod() {
		
	}
	
	/**
	 * Test get lk puo dept bnc hods.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetLkPuoDeptBncHods() throws CustomException {
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
		assertNotNull(service.getLkPuoDeptBncHods(pageDetail));
	}
	
	/**
	 * Test get hod by department id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetHodByDepartmentId() throws CustomException{
		List<EDPLkPuoDeptBncHodEntity> entityList=new ArrayList<>();
		EDPLkPuoDeptBncHodEntity entity=new EDPLkPuoDeptBncHodEntity();
		entity.setHodNameId(empEntity);
		when(empEntity.getEmpId()).thenReturn(JunitConstants.LONG_TYPE);
		when(empEntity.getEmployeeName()).thenReturn(JunitConstants.STRING_TYPE);
		entityList.add(entity);
		when(repository.findByDepartmentIdDepartmentId(JunitConstants.LONG_TYPE)).thenReturn(entityList);
		assertNotNull(service.getHodByDepartmentId(JunitConstants.LONG_TYPE));
	}
}
