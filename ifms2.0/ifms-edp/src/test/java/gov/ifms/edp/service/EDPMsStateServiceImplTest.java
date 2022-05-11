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
import org.springframework.data.domain.Sort;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsStateConverter;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsStateEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsStateRepository;
import gov.ifms.edp.repository.EDPMsTalukaRepository;

/**
 * The Class EDPMsStateServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsStateServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsStateServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPMsStateRepository repository;
	
	/** The entity. */
	@Mock
	private EDPMsStateEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsStateEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsStateEntity> page;
	
	/** The district repository. */
	@Mock
	private EDPMsDistrictRepository districtRepository;
	
	/** The taluka repository. */
	@Mock
	private EDPMsTalukaRepository talukaRepository;
	
	/** The district entity. */
	@Mock
	private EDPMsDistrictEntity districtEntity;
	
	/** The taluka entity. */
	@Mock
	private EDPMsTalukaEntity talukaEntity;
	
	/** The converter. */
	@Mock
	private EDPMsStateConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms state.
	 */
	@Test
	void testGetMsState() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsState(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms state.
	 */
	@Test
	void testSaveOrUpdateMsState() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsState(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test get ms states.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetMsStates() throws CustomException {
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
		assertNotNull(service.getMsStates(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test get SDT data.
	 */
	@Test
	void testGetSDTData() {
		List<EDPMsStateEntity> states = new ArrayList<EDPMsStateEntity>();
		List<EDPMsDistrictEntity> districs = new ArrayList<EDPMsDistrictEntity>();
		List<EDPMsTalukaEntity> talukas = new ArrayList<EDPMsTalukaEntity>();
		EDPMsStateEntity stateEntity = new EDPMsStateEntity();
		stateEntity.setStateId(JunitConstants.LONG_TYPE);
		states.add(stateEntity);
		when(repository.findByActiveStatus(Mockito.anyInt(),Mockito.any(Sort.class))).thenReturn(states);

		EDPMsDistrictEntity districtEntity1 = new EDPMsDistrictEntity();
		districtEntity1.setStateId(JunitConstants.LONG_TYPE);
		districtEntity1.setDistrictId(JunitConstants.LONG_TYPE);
		districs.add(districtEntity1);
		when(districtRepository.findByActiveStatus(Mockito.anyInt(),Mockito.any(Sort.class))).thenReturn(districs);

		EDPMsTalukaEntity talukaEntity1 = new EDPMsTalukaEntity();
		talukaEntity1.setTalukaId(JunitConstants.LONG_TYPE);
		talukaEntity1.setTalukaName(JunitConstants.STRING_TYPE);
		talukaEntity1.setTalukaCode(JunitConstants.STRING_TYPE);
		talukaEntity1.setDistrictId(JunitConstants.LONG_TYPE);
		talukas.add(talukaEntity1);
		when(talukaRepository.findByActiveStatus(Mockito.anyInt(),Mockito.any(Sort.class))).thenReturn(talukas);

		EDPMsTalukaEntity talukaEntity2 = new EDPMsTalukaEntity();
		talukaEntity2.setTalukaId(JunitConstants.LONG_TYPE);
		talukaEntity2.setTalukaName(JunitConstants.STRING_TYPE);
		talukaEntity2.setTalukaCode(JunitConstants.STRING_TYPE);
		talukaEntity2.setDistrictId(JunitConstants.LONG_TYPE);
		talukas.add(talukaEntity2);

		when(entity.getStateCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(districtEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(districtEntity.getDistrictName()).thenReturn(JunitConstants.STRING_TYPE);
		when(districtEntity.getDistrictCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(talukaEntity.getTalukaId()).thenReturn(JunitConstants.LONG_TYPE);
		when(talukaEntity.getTalukaName()).thenReturn(JunitConstants.STRING_TYPE);
		when(talukaEntity.getTalukaCode()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getSDTData());
	}

}
