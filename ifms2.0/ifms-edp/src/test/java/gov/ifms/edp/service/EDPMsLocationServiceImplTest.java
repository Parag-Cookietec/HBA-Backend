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
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsLocationConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsLocationEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsLocationRepository;

/**
 * The Class EDPMsLocationServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsLocationServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsLocationServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPMsLocationRepository repository;
	
	/** The entity. */
	@Mock
	private EDPMsLocationEntity entity;
	
	/** The entities. */
	@Mock
	private List<EDPMsLocationEntity> entities;
	
	/** The edp lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;
	
	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsLocationEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsLocationEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsLocationConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms locations.
	 */
	@Test
	void testGetMsLocations() {
		when(repository.findAll()).thenReturn(entities);
		assertNotNull(service.getMsLocations());
		verify(repository).findAll();
	}

	/**
	 * Test get ms location.
	 */
	@Test
	void testGetMsLocation() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsLocation(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms location.
	 */
	@Test
	void testSaveOrUpdateMsLocation() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsLocation(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test delete ms location.
	 */
	@Test
	void testDeleteMsLocation() {
		service.deleteMsLocation(JunitConstants.LONG_TYPE);
		verify(repository).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms locations.
	 */
	@Test
	void testSaveMsLocations() {
		when(repository.saveAll(entities)).thenReturn(entities);
		assertNotNull(service.saveMsLocations(entities));
		verify(repository).saveAll(entities);
	}

	/**
	 * Test edp ms location as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsLocationAsMethodNameSearch() {
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
		assertNotNull(service.edpMsLocationAsMethodNameSearch(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test find district.
	 */
	@Test
	void testFindDistrict() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NAME_DISTRICT))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByLocationTypeIdLookUpInfoIdAndActiveStatusAndLocationCodeNotInOrderByLocationNameAsc(
				JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS, Constant.DEFAULT_LOCATION_CODE)).thenReturn(entities);
		assertNotNull(service.findDistrict());
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NAME_DISTRICT)).thenReturn(null);
		assertNotNull(service.findDistrict());
		verify(repository, times(1))
				.findByLocationTypeIdLookUpInfoIdAndActiveStatusAndLocationCodeNotInOrderByLocationNameAsc(
						JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS, Constant.DEFAULT_LOCATION_CODE);
	}

	/**
	 * Test find taluka.
	 */
	@Test
	void testFindTaluka() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NAME_TALUKA))
				.thenReturn(edpLuLookUpInfoEntity);
		when(repository.findByLocationTypeIdLookUpInfoIdAndActiveStatusOrderByLocationNameAsc(
				edpLuLookUpInfoEntity.getLookUpInfoId(), Constant.ACTIVE_STATUS)).thenReturn(entities);
		assertNotNull(service.findTaluka());
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NAME_TALUKA)).thenReturn(null);
		assertNotNull(service.findTaluka());
		verify(repository).findByLocationTypeIdLookUpInfoIdAndActiveStatusOrderByLocationNameAsc(
				edpLuLookUpInfoEntity.getLookUpInfoId(), Constant.ACTIVE_STATUS);
	}

}
