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
import gov.ifms.edp.converter.EDPUserRoleMappingItrConverter;
import gov.ifms.edp.entity.EDPUserRoleMappingItrEntity;
import gov.ifms.edp.repository.EDPUserRoleMappingItrRepository;

/**
 * The Class EDPUserRoleMappingItrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPUserRoleMappingItrServiceImplTest {
	
	/** The service. */
	@InjectMocks
	private EDPUserRoleMappingItrServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPUserRoleMappingItrRepository repository;
	
	/** The edp user role mapping itr entity. */
	@Mock
	private EDPUserRoleMappingItrEntity edpUserRoleMappingItrEntity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPUserRoleMappingItrEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPUserRoleMappingItrEntity> page;
	
	/** The converter. */
	@Mock
	private EDPUserRoleMappingItrConverter converter;
	
	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get user role mapping itr.
	 */
	@Test
	void testGetUserRoleMappingItr() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpUserRoleMappingItrEntity);
		assertNotNull(service.getUserRoleMappingItr(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update user role mapping itr.
	 */
	@Test
	void testSaveOrUpdateUserRoleMappingItr() {
		when(repository.save(edpUserRoleMappingItrEntity)).thenReturn(edpUserRoleMappingItrEntity);
		assertNotNull(service.saveOrUpdateUserRoleMappingItr(edpUserRoleMappingItrEntity));
		verify(repository, times(1)).save(edpUserRoleMappingItrEntity);
	}

	/**
	 * Test delete user role mapping itr.
	 */
	@Test
	void testDeleteUserRoleMappingItr() {
		service.deleteUserRoleMappingItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository, times(1)).deleteUserRoleMappingItr(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong(), Mockito.any(Date.class));
	}
	
	/**
	 * Test get user role mapping itrs.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetUserRoleMappingItrs() throws CustomException {
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
		assertNotNull(service.getUserRoleMappingItrs(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

}
