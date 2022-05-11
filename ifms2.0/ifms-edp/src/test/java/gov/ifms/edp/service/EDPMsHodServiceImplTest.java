package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
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
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsHodConverter;
import gov.ifms.edp.entity.EDPMsHodEntity;
import gov.ifms.edp.repository.EDPMsHodRepository;

/**
 * The Class EDPMsHodServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsHodServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsHodServiceImpl service;

	/** The repository. */
	@Mock
	private EDPMsHodRepository repository;

	/** The entity. */
	@Mock
	private EDPMsHodEntity entity;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsHodEntity> spec;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPMsHodEntity> page;

	/** The converter. */
	@Mock
	private EDPMsHodConverter converter;

	/** The entity list. */
	@Mock
	private List<EDPMsHodEntity> entityList;

	/** The edp ms office service impl. */
	@Mock
	private EDPMsOfficeServiceImpl edpMsOfficeServiceImpl;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms hod.
	 */
	@Test
	void testGetMsHod() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsHod(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms hod.
	 */
	@Test
	void testSaveOrUpdateMsHod() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsHod(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete ms hod.
	 */
	@Test
	void testDeleteMsHod() {
		service.deleteMsHod(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository, times(1)).deleteMsHod(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong(),
				Mockito.any(Date.class));
	}

	/**
	 * Test get ms hods.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetMsHods() throws CustomException {
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
		assertNotNull(service.getMsHods(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test get hod by department id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetHodByDepartmentId() throws Exception {
		assertNotNull(service.getHodByDepartmentId(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get hods clue dto.
	 */
	@Test
	void testGetHodsClueDto() {
		List<EDPMsHodEntity> entityList = new ArrayList<>();
		entityList.add(entity);
		assertNotNull(service.getHodsClueDto(entityList));
	}

}
