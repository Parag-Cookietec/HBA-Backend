package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import gov.ifms.edp.converter.EDPMsDepartmentConverter;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPMsDepartmentRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsDepartmentServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsDepartmentServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsDepartmentServiceImpl service;

	/** The repository. */
	@Mock
	private EDPMsDepartmentRepository repository;

	/** The list. */
	@Mock
	private List<EDPMsDepartmentEntity> list;

	/** The entity. */
	@Mock
	private EDPMsDepartmentEntity entity;

	/** The office repo. */
	@Mock
	private EDPMsOfficeRepository officeRepo;

	/** The lst office. */
	@Mock
	private List<EDPMsOfficeEntity> lstOffice;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsDepartmentEntity> spec;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPMsDepartmentEntity> page;

	/** The converter. */
	@Mock
	private EDPMsDepartmentConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms departments.
	 */
	@Test
	void testGetMsDepartments() {
		when(repository.findAll()).thenReturn(list);
		assertNotNull(service.getMsDepartments());
		verify(repository).findAll();
	}

	/**
	 * Test get ms department.
	 */
	@Test
	void testGetMsDepartment() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsDepartment(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms department.
	 */
	@Test
	void testSaveOrUpdateMsDepartment() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsDepartment(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test delete ms department.
	 */
	@Test
	void testDeleteMsDepartment() {
		service.deleteMsDepartment(JunitConstants.LONG_TYPE);
		verify(repository).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms departments.
	 */
	@Test
	void testSaveMsDepartments() {
		when(repository.saveAll(list)).thenReturn(list);
		assertNotNull(service.saveMsDepartments(list));
		verify(repository).saveAll(list);
	}

	/**
	 * Test edp ms department as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsDepartmentAsMethodNameSearch() {
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
		assertNotNull(service.edpMsDepartmentAsMethodNameSearch(pageDetail));
	}

	/**
	 * Test get department by user id.
	 * @throws CustomException 
	 */
	@Test
	void testGetDepartmentByUserId() throws CustomException {
		assertNotNull(service.getDepartmentByPostId(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test find by office type id.
	 */
	@Test
	void testFindByOfficeTypeId() {
		Set<Long> lookUpInfoIds = new HashSet<>();
		lookUpInfoIds.add(1L);
		when(officeRepo.findByOfficeTypeIdLookUpInfoIdIn(lookUpInfoIds)).thenReturn(lstOffice);
		assertNotNull(service.findByOfficeTypeId(1L));
		verify(officeRepo).findByOfficeTypeIdLookUpInfoIdIn(lookUpInfoIds);
	}

	/**
	 * Test get all code and id.
	 */
	@Test
	void testGetAllCodeAndId() {
		List<EDPMsDepartmentEntity> allActiveEntity = new ArrayList<>();
		when(repository.findByActiveStatus(EDPConstant.ACTIVE_STATUS_TRUE,
				EDPUtility.getJpaSort(EDPConstant.DEPARTMENT_NAME, EDPConstant.ORDER_ASC))).thenReturn(allActiveEntity);
		entity.setDepartmentId(JunitConstants.LONG_TYPE);
		entity.setDepartmentCode(JunitConstants.STRING_TYPE);
		entity.setDepartmentCode(JunitConstants.STRING_TYPE);
		allActiveEntity.add(entity);
		assertNotNull(service.getAllCodeAndId());
		verify(repository).findByActiveStatus(EDPConstant.ACTIVE_STATUS_TRUE,
				EDPUtility.getJpaSort(EDPConstant.DEPARTMENT_NAME, EDPConstant.ORDER_ASC));
	}

}
