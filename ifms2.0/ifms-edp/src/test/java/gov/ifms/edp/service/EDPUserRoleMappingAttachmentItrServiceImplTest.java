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
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPTrnUserMpAttItrConverter;
import gov.ifms.edp.entity.EDPTrnUserMpAttItrEntity;
import gov.ifms.edp.repository.EDPTrnUserMpAttItrRepository;

/**
 * The Class EDPUserRoleMappingAttachmentItrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPUserRoleMappingAttachmentItrServiceImplTest {
	
	/** The service. */
	@InjectMocks
	private EDPUserRoleMappingAttachmentItrServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPTrnUserMpAttItrRepository repository;
	
	/** The edp trn user mp att itr entity. */
	@Mock
	private EDPTrnUserMpAttItrEntity edpTrnUserMpAttItrEntity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPTrnUserMpAttItrEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPTrnUserMpAttItrEntity> page;
	
	/** The converter. */
	@Mock
	private EDPTrnUserMpAttItrConverter converter;
	
	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test get user role mapping attachment itr.
	 */
	@Test
	void testGetUserRoleMappingAttachmentItr() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpTrnUserMpAttItrEntity);
		assertNotNull(service.getUserRoleMappingAttachmentItr(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update user role mapping attachment itr.
	 */
	@Test
	void testSaveOrUpdateUserRoleMappingAttachmentItr() {
		when(repository.save(edpTrnUserMpAttItrEntity)).thenReturn(edpTrnUserMpAttItrEntity);
		assertNotNull(service.saveOrUpdateUserRoleMappingAttachmentItr(edpTrnUserMpAttItrEntity));
		verify(repository, times(1)).save(edpTrnUserMpAttItrEntity);
	}

	/**
	 * Test delete user role mapping attachment itr.
	 */
	@Test
	void testDeleteUserRoleMappingAttachmentItr() {
		service.deleteUserRoleMappingAttachmentItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository, times(1)).deleteUserRoleMappingAttachmentItr(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong(), Mockito.any(java.util.Date.class));
	}
	
	/**
	 * Test get user role mapping attachment itrs.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetUserRoleMappingAttachmentItrs() throws CustomException {
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
		assertNotNull(service.getUserRoleMappingAttachmentItrs(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

}
