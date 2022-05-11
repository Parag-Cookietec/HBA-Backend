package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPOfficeItrConverter;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.entity.EDPOfficeItrEntity;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapRepository;
import gov.ifms.edp.repository.EDPOfficeItrRepository;
import gov.ifms.edp.repository.EDPOfficeModuleRepository;
import gov.ifms.edp.repository.EDPSubOfficeItrRepository;
import gov.ifms.edp.repository.EDPUpdateOfficeTrnRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPOfficeItrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPOfficeItrServiceImplTest {

	/** The entity. */
	@Mock
	private EDPOfficeItrEntity entity;

	/** The repository. */
	@Mock
	private EDPOfficeItrRepository repository;

	/** The edp ms office repository. */
	@Mock
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/** The edp ms district repository. */
	@Mock
	private EDPMsDistrictRepository edpMsDistrictRepository;

	/** The page details. */
	@Mock
	private PageDetails pageDetails;

	/** The edp lu look up info service. */
	@Mock
	private EDPLuLookUpInfoService edpLuLookUpInfoService;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The search criteria. */
	@Mock
	SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPOfficeItrEntity> spec;

	/** The emp spec. */
	@Mock
	private Specification<EDPOfficeItrEntity> empSpec;

	/** The page. */
	@Mock
	private Page<EDPOfficeItrEntity> page;

	/** The office bill map entity list. */
	@Mock
	private List<EDPOfficeItrEntity> officeBillMapEntityList;

	/** The converter. */
	@Mock
	private EDPOfficeItrConverter converter;

	/** The district obj. */
	@Mock
	private EDPMsDistrictEntity districtObj;

	/** The lookup entity. */
	@Mock
	private EDPLuLookUpInfoEntity lookupEntity;

	/** The office entity. */
	@Mock
	private EDPMsOfficeEntity officeEntity;

	/** The edp ms user service. */
	@Mock
	private EDPMsUserService edpMsUserService;

	/** The dto. */
	@Mock
	private IdDto dto;

	/** The service. */
	@InjectMocks
	private EDPOfficeItrServiceImpl service;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The edp ms office dto. */
	@Mock
	private EDPMsOfficeDto edpMsOfficeDto;

	/** The office bill map repository. */
	@Mock
	private EDPOfficeBillMapRepository officeBillMapRepository;

	/** The edp office bill map entity. */
	@Mock
	private EDPOfficeBillMapEntity edpOfficeBillMapEntity;

	/** The office module repository. */
	@Mock
	private EDPOfficeModuleRepository officeModuleRepository;

	/** The edp office module entity. */
	@Mock
	private EDPOfficeModuleEntity edpOfficeModuleEntity;

	/** The edp ms office service impl. */
	@Mock
	private EDPMsOfficeServiceImpl edpMsOfficeServiceImpl;

	/** The office bill map itr repository. */
	@Mock
	private EDPOfficeBillMapItrRepository officeBillMapItrRepository;

	/** The edp office bill map itr entity. */
	@Mock
	private EDPOfficeBillMapItrEntity edpOfficeBillMapItrEntity;

	/** The edp office bill map itr entity list. */
	@Mock
	private List<EDPOfficeBillMapItrEntity> edpOfficeBillMapItrEntityList;

	/** The office module entity list. */
	@Mock
	private List<EDPOfficeModuleEntity> officeModuleEntityList;

	/** The look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/** The office trn entity. */
	@Mock
	private EDPUpdateOfficeTrnEntity officeTrnEntity;

	/** The sub office itr repository. */
	@Mock
	private EDPSubOfficeItrRepository subOfficeItrRepository;

	/** The edp office trn repository. */
	@Mock
	private EDPUpdateOfficeTrnRepository edpOfficeTrnRepository;

	/**
	 * Setup.
	 */
	@BeforeAll
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get edp office itr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetEdpOfficeItr() throws CustomException {
		when(repository.findTopByTransactionNo(JunitConstants.SET_TRSN_NO,
				EDPUtility.getJpaSort("officeItrId", EDPConstant.ORDER_DESC))).thenReturn(entity);
		when(converter.toOfficeDto(entity)).thenReturn(edpMsOfficeDto);
		when(edpMsOfficeDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPOfficeBillMapItrEntity> edpOfficeBillMapItrEntityList = new ArrayList<>();
		edpOfficeBillMapItrEntityList.add(edpOfficeBillMapItrEntity);
		when(officeBillMapItrRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpOfficeBillMapItrEntityList);
		when(edpOfficeBillMapItrEntity.getBillSubmittedTo()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpOfficeBillMapItrEntity.getBillType()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpOfficeBillMapItrEntity.getBillListId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPOfficeModuleEntity> edpOfficeModuleEntityList = new ArrayList<>();
		edpOfficeModuleEntityList.add(edpOfficeModuleEntity);
		when(officeModuleRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpOfficeModuleEntityList);
		when(edpOfficeModuleEntity.getModuleId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getLevelId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getDdoType()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(entity.getNonDdo()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getHodId()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(edpMsOfficeRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(officeEntity);
		when(officeEntity.getOfficeName()).thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findLastApprovedOfficeStatus(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoRepository.findBylookUpInfoId(JunitConstants.LONG_TYPE)).thenReturn(lookupEntity);
		when(lookupEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TYPE);
		when(officeEntity.getCreatedDate()).thenReturn(new Date());
		when(entity.getOfficeTransferId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				EDPConstant.ACTIVE_STATUS_TRUE)).thenReturn(officeEntity);
		assertNotNull(service.getEdpOfficeItr(JunitConstants.SET_TRSN_NO));
		when(entity.getIsCo()).thenReturn(null);
		assertNotNull(service.getEdpOfficeItr(JunitConstants.SET_TRSN_NO));
	}

	/**
	 * Test save or update edp office itr.
	 *
	 * @throws Exception the exception
	 */
	@Test()
	void testSaveOrUpdateEdpOfficeItr() throws Exception {
		try {
			when(repository.save(entity)).thenReturn(entity);
			assertNotNull(service.saveOrUpdateEdpOfficeItr(entity));
			verify(repository, times(1)).save(entity);
		} catch (Exception e) {
			// handle exception
		}
	}

	/**
	 * Test delete edp office itr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteEdpOfficeItr() throws CustomException {
		when(repository.findTopByTransactionNo(JunitConstants.SET_TRSN_NO,
				EDPUtility.getJpaSort("officeItrId", EDPConstant.ORDER_DESC))).thenReturn(entity);
		when(entity.getOfficeTrnEntity()).thenReturn(officeTrnEntity);
		when(entity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		service.deleteEdpOfficeItr(JunitConstants.SET_TRSN_NO);
		verify(repository, times(1)).updateActiveStatusByTransactionNo(Mockito.any(String.class),
				Mockito.any(Integer.class), Mockito.any(Long.class), Mockito.any(java.util.Date.class));
	}

	/**
	 * Test get edp office itrs.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetEdpOfficeItrs() throws Exception {
		when(pageDetails.getPageDetails(pageDetails)).thenReturn(pageable);
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		SearchParam sp = new SearchParam();
		sp.setKey(JunitConstants.STRING_TYPE);
		sp.setValue(JunitConstants.STRING_TYPE);
		jsonArr.add(sp);
		when(pageDetails.getJsonArr()).thenReturn(jsonArr);
		when(searchCriteria.getSpecificationDetails(spec, jsonArr)).thenReturn(empSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());

		assertNotNull(service.getEdpOfficeItrs(pageDetails));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test list edp offices.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testListEdpOffices() throws CustomException {
		List<IdDto> list = new ArrayList<IdDto>();
		StringBuilder stringBuilder = new StringBuilder();
		when(edpMsUserService.getDependentUerIdByUserId(JunitConstants.LONG_TYPE)).thenReturn(list);
		when(dto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		list.add(dto);
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, JunitConstants.INTEGER_TYPE);
		argsMap.put(Constant.IN_PAGE_SIZE, JunitConstants.INTEGER_TYPE);
		argsMap.put(Constant.IN_USER_LIST, stringBuilder);
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		SearchParam sp = new SearchParam();
		sp.setKey(JunitConstants.STRING_TYPE);
		sp.setValue(JunitConstants.STRING_TYPE);
		jsonArr.add(sp);
		List<Object[]> listObject = new ArrayList<Object[]>();
		when(pageDetails.getJsonArr()).thenReturn(jsonArr);
		Object ooo[] = new Object[11];
		ooo[0] = JunitConstants.INTEGER_TYPE;
		ooo[1] = JunitConstants.STRING_TYPE;
		ooo[10] = JunitConstants.INTEGER_TYPE_69;
		ooo[3] = JunitConstants.STRING_TYPE;
		ooo[4] = JunitConstants.STRING_TYPE;
		listObject.add(ooo);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		assertNotNull(service.listEdpOffices(pageDetails));
		when(pageDetails.getJsonArr()).thenReturn(null);
		assertNotNull(service.listEdpOffices(pageDetails));
	}

	/**
	 * Test summary list edp office.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSummaryListEdpOffice() throws CustomException {
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INTEGER_TYPE);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> searchParams = new ArrayList<SearchParam>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);

		List<Object[]> listObject = new ArrayList<Object[]>();

		Object o[] = new Object[10];
		o[0] = JunitConstants.INTEGER_TYPE;
		o[1] = JunitConstants.STRING_TYPE;
		o[2] = JunitConstants.INTEGER_TYPE;
		o[3] = JunitConstants.STRING_TYPE;
		o[4] = JunitConstants.STRING_TYPE;
		listObject.add(o);

		Object oo[] = new Object[10];
		oo[0] = JunitConstants.INTEGER_TYPE;
		oo[1] = JunitConstants.STRING_TYPE;
		oo[2] = JunitConstants.INTEGER_TYPE_68;
		oo[3] = JunitConstants.STRING_TYPE;
		oo[4] = JunitConstants.STRING_TYPE;
		listObject.add(oo);

		Object ooo[] = new Object[10];
		ooo[0] = JunitConstants.INTEGER_TYPE;
		ooo[1] = JunitConstants.STRING_TYPE;
		ooo[2] = JunitConstants.INTEGER_TYPE_69;
		ooo[3] = JunitConstants.STRING_TYPE;
		ooo[4] = JunitConstants.STRING_TYPE;
		listObject.add(ooo);

		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		assertNotNull(service.summaryListEdpOffice(pageDetail));
	}

	/**
	 * Test search summary list DDO office.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSearchSummaryListDDOOffice() throws CustomException {
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INTEGER_TYPE);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> searchParams = new ArrayList<SearchParam>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);

		List<Object[]> listObject = new ArrayList<Object[]>();
		Object o[] = new Object[12];
		o[0] = JunitConstants.INTEGER_TYPE;
		o[1] = JunitConstants.STRING_TYPE;
		o[2] = JunitConstants.INTEGER_TYPE;
		o[3] = JunitConstants.STRING_TYPE;
		o[4] = JunitConstants.STRING_TYPE;
		o[11] = JunitConstants.INTEGER_TYPE;
		listObject.add(o);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		assertNotNull(service.searchSummaryListDDOOffice(pageDetail));
	}

	/**
	 * Test search summary list DDO office detail.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSearchSummaryListDDOOfficeDetail() throws CustomException {
		when(pageDetails.getPageDetails(pageDetails)).thenReturn(pageable);
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		SearchParam sp = new SearchParam();
		sp.setKey(JunitConstants.STRING_TYPE);
		sp.setValue(JunitConstants.STRING_TYPE);
		jsonArr.add(sp);
		when(pageDetails.getJsonArr()).thenReturn(jsonArr);
		Object[] object = new Object[13];
		object[11] = JunitConstants.LONG_STRING;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.searchSummaryListDDOOfficeDetail(pageDetails));
	}

	/**
	 * Test get edp office itr long.
	 */
	@Test
	void testGetEdpOfficeItrLong() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getEdpOfficeItr(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test list edp update offices.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testListEdpUpdateOffices() throws CustomException {
		Object[] object = new Object[13];
		object[10] = JunitConstants.LONG_STRING;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.any(Map.class))).thenReturn(objects);
		assertNotNull(service.listEdpUpdateOffices(pageDetails));
		verify(repository, times(2)).callStoredProcedure(Mockito.anyString(), Mockito.any(Map.class));
	}
}