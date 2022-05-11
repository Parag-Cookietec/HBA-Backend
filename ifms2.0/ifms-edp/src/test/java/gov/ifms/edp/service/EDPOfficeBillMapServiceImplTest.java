package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
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

import gov.ifms.common.base.Status;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPOfficeBillMapConverter;
import gov.ifms.edp.converter.EDPOfficeBillMapItrConverter;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPOfficeBillMapServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPOfficeBillMapServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPOfficeBillMapServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPOfficeBillMapRepository repository;
	
	/** The entity. */
	@Mock
	private EDPOfficeBillMapEntity entity;
	
	/** The dto. */
	@Mock
	private EDPMsOfficeDto dto;
	
	/** The bill map itr converter. */
	@Mock
	private EDPOfficeBillMapItrConverter billMapItrConverter;
	
	/** The office bill map itr entity. */
	@Mock
	private EDPOfficeBillMapItrEntity officeBillMapItrEntity;
	
	/** The bill map itr repository. */
	@Mock
	private EDPOfficeBillMapItrRepository billMapItrRepository;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPOfficeBillMapEntity> page;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPOfficeBillMapEntity> spec;
	
	/** The converter. */
	@Mock
	private EDPOfficeBillMapConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test getoffice bill map.
	 */
	@Test
	void testGetofficeBillMap() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getofficeBillMap(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or updateoffice bill map.
	 */
	@Test
	void testSaveOrUpdateofficeBillMap() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateofficeBillMap(entity));
		verify(repository).save(entity);
	}

/**
 * Test deleteoffice bill map.
 */
//	@Test
	void testDeleteofficeBillMap() {

	}

	/**
	 * Test getoffice bill maps.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetofficeBillMaps() throws Exception {
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
		assertNotNull(service.getofficeBillMaps(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test save office bill map.
	 */
	@Test
	void testSaveOfficeBillMap() {
		Set<Long> set = new HashSet<>();
		set.add(JunitConstants.LONG_TYPE);
		when(dto.getSelectedBills()).thenReturn(set);
		when(dto.getOfficeStatus()).thenReturn(281l);
		when(dto.getFormAction()).thenReturn(Status.DRAFT);
		when(repository.updateActiveStatusByOfficeId(JunitConstants.LONG_TYPE, EDPConstant.INACTIVE_STATUS,
				OAuthUtility.getCurrentUserUserId(), new Date())).thenReturn(JunitConstants.INTEGER_TYPE);
		when(repository.save(Mockito.any(EDPOfficeBillMapEntity.class))).thenReturn(entity);
		when(billMapItrConverter.toEntity(Mockito.any(EDPOfficeBillMapEntity.class)))
				.thenReturn(officeBillMapItrEntity);
		when(billMapItrRepository.save(officeBillMapItrEntity)).thenReturn(officeBillMapItrEntity);
		List<EDPOfficeBillMapEntity> list = new ArrayList<>();
		list.add(entity);
		when(dto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByOfficeIdAndActiveStatus(dto.getOfficeId(),
				EDPConstant.ACTIVE_STATUS_TRUE)).thenReturn(list);
		when(dto.getIsNewOffice()).thenReturn(true);
		service.saveOfficeBillMap(dto,false);
		service.updateOfficeBillsItr(dto);
		when(dto.getOfficeStatus()).thenReturn(null);
		service.saveOfficeBillMap(dto,false);
		service.updateOfficeBillsItr(dto);
		when(dto.getSelectedBills()).thenReturn(null);
		when(repository.save(Mockito.any(EDPOfficeBillMapEntity.class))).thenReturn(entity);
		when(billMapItrConverter.toEntity(entity)).thenReturn(officeBillMapItrEntity);
		when(billMapItrRepository.save(officeBillMapItrEntity)).thenReturn(officeBillMapItrEntity);
		service.saveOfficeBillMap(dto,true);
		when(dto.getBillType()).thenReturn(JunitConstants.LONG_TYPE);
		when( dto.getBillSubmittedTo()).thenReturn(JunitConstants.LONG_TYPE);
		service.saveOfficeBillMap(dto,false);
		service.updateOfficeBillsItr(dto);
		verify(billMapItrRepository, times(5)).save(officeBillMapItrEntity);
	}
	
	@Test
	void testApproveOfficeBillMap() {
		Set<Long> set=new HashSet<Long>();
		set.add(JunitConstants.LONG_TYPE);
		when(dto.getSelectedBills()).thenReturn(set);
		service.approveOfficeBillMap(dto);
		when(dto.getSelectedBills()).thenReturn(null);
		service.approveOfficeBillMap(dto);
	}

}