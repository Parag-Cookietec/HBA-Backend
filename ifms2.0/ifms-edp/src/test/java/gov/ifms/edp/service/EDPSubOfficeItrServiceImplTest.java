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
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPSubOfficeItrConverter;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.repository.EDPSubOfficeItrRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPSubOfficeItrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPSubOfficeItrServiceImplTest {

	/** The repository. */
	@Mock
	private EDPSubOfficeItrRepository repository;

	/** The service. */
	@InjectMocks
	private EDPSubOfficeItrServiceImpl service;

	/** The entity. */
	@Mock
	private EDPSubOfficeItrEntity entity;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPSubOfficeItrEntity> spec;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPSubOfficeItrEntity> page;

	/** The converter. */
	@Mock
	private EDPSubOfficeItrConverter converter;

	/** The office service. */
	@Mock
	private EDPMsOfficeService officeService;

	/** The trn entity. */
	@Mock
	private EDPUpdateOfficeTrnEntity trnEntity;

	/** The data spec. */
	@Mock
	private Specification<EDPSubOfficeItrEntity> dataSpec;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test getsub office itr.
	 */
	@Test
	void testGetsubOfficeItr() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getsubOfficeItr(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or updatesub office itr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveOrUpdatesubOfficeItr() throws CustomException {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdatesubOfficeItr(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete sub office itr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteSubOfficeItr() throws CustomException {
		when(repository.updateActiveStatusByOfficeId(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong(),
				Mockito.any(Date.class))).thenReturn(JunitConstants.INTEGER_TYPE);
		service.deletesubOfficeItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
	}

	/**
	 * Test getsub office itrs.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetsubOfficeItrs() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(EDPConstant.OFFICE_ID_OFFICE_ID);
		searchParam.setValue(JunitConstants.LONG_STRING_VALUE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		SearchParam searchParam1 = new SearchParam();
		searchParam.setKey("officeTrnEntity.updOffcTrnId");
		searchParam.setValue(JunitConstants.LONG_STRING_VALUE);
		List<SearchParam> list1 = new ArrayList<>();
		list1.add(searchParam1);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(officeService.getLastOfficeTrn(Long.parseLong(JunitConstants.LONG_STRING_VALUE), Constant.ACTIVE_STATUS))
				.thenReturn(trnEntity);
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getsubOfficeItrs(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

}