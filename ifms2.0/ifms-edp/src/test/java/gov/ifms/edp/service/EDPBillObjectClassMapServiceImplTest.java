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
import gov.ifms.edp.converter.EDPBillObjectClassMapConverter;
import gov.ifms.edp.dto.EDPBillObjectClassMapDto;
import gov.ifms.edp.entity.EDPBillObjectClassMapEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPBillObjectClassMapRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPBillObjectClassMapServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPBillObjectClassMapServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPBillObjectClassMapRepository repository;
	
	/** The edp bill object class map entity. */
	@Mock
	private EDPBillObjectClassMapEntity edpBillObjectClassMapEntity;
	
	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;
	
	/** The lookupinfoservice. */
	@Mock
	private EDPLuLookUpInfoService lookupinfoservice;
	
	/** The list data. */
	@Mock
	private List<EDPBillObjectClassMapEntity> listData;
	
	/** The converter. */
	@Mock
	private EDPBillObjectClassMapConverter converter;
	
	/** The dtos. */
	@Mock
	private List<EDPBillObjectClassMapDto> dtos;
	
	/** The dto. */
	@Mock
	private EDPBillObjectClassMapDto dto;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPBillObjectClassMapEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPBillObjectClassMapEntity> page;
	
	/** The service. */
	@InjectMocks
	private EDPBillObjectClassMapServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get bill object class map.
	 */
	@Test
	void testGetBillObjectClassMap() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpBillObjectClassMapEntity);
		assertNotNull(service.getBillObjectClassMap(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update bill object class map EDP bill object class map entity.
	 */
	@Test
	void testSaveOrUpdateBillObjectClassMapEDPBillObjectClassMapEntity() {
		when(repository.save(edpBillObjectClassMapEntity)).thenReturn(edpBillObjectClassMapEntity);
		assertNotNull(service.saveOrUpdateBillObjectClassMap(edpBillObjectClassMapEntity));
		verify(repository, times(1)).save(edpBillObjectClassMapEntity);
	}

	/**
	 * Test delete bill object class map.
	 */
	@Test
	void testDeleteBillObjectClassMap() {
		service.deleteBillObjectClassMap(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository,times(2)).deleteBillObjectClassMap(Mockito.any(Long.class), Mockito.any(Integer.class), Mockito.any(Long.class),Mockito.any(java.util.Date.class));
	}
	
	/**
	 * Test get bill object class maps.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetBillObjectClassMaps() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		assertNotNull(service.getBillObjectClassMaps(pageDetail));
	}

	/**
	 * Test ge bill object class type details.
	 */
	@Test
	void testGeBillObjectClassTypeDetails() {
		List<EDPLuLookUpInfoEntity> lookUpEntities = new ArrayList<>();
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TYPE);
		lookUpEntities.add(edpLuLookUpInfoEntity);
		when(lookupinfoservice.findByLookUpName(EDPConstant.LIST_OF_BILLS)).thenReturn(lookUpEntities);
		List<Object[]> objList = new ArrayList<Object[]>();
		Object[] obj = new Object[2];
		obj[0] = JunitConstants.INTEGER_TYPE;
		obj[1] = JunitConstants.INTEGER_TYPE;
		objList.add(obj);
		when(repository.getObjectClassData()).thenReturn(objList);
		assertNotNull(service.geBillObjectClassTypeDetails());
	}

	/**
	 * Test save or update bill object class map EDP bill object class map dto.
	 */
	@Test
	void testSaveOrUpdateBillObjectClassMapEDPBillObjectClassMapDto() {
		EDPBillObjectClassMapEntity edpBillObjectClassMapEntity = new EDPBillObjectClassMapEntity();
		edpBillObjectClassMapEntity.setBillObjmapId(JunitConstants.LONG_TYPE);
		List<EDPBillObjectClassMapEntity> listData = new ArrayList<EDPBillObjectClassMapEntity>();
		listData.add(edpBillObjectClassMapEntity);
		when(converter.toListOfEntity(dto)).thenReturn(listData);
		when(dto.getBillTypeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByBillTypeIdLookUpInfoIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(listData);
		when(converter.listToDTO(listData)).thenReturn(dto);
		assertNotNull(service.saveOrUpdateBillObjectClassMap(dto));
		List<EDPBillObjectClassMapEntity> listData1 = new ArrayList<EDPBillObjectClassMapEntity>();
		when(repository.findByBillTypeIdLookUpInfoIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(listData1);
		assertNotNull(service.saveOrUpdateBillObjectClassMap(dto));
	}

	/**
	 * Test get object class.
	 */
	@Test
	void testGetObjectClass() {
		List<EDPBillObjectClassMapEntity> listData1 = new ArrayList<>();
		listData1.add(edpBillObjectClassMapEntity);
		when(repository.findByBillTypeIdLookUpInfoIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(listData1);
		when(edpBillObjectClassMapEntity.getObjectClassId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.getObjectClass(JunitConstants.LONG_TYPE));
	}

}
