package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsSubOfficeConverter;
import gov.ifms.edp.converter.EDPSubOfficeItrConverter;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsSubOfficeRepository;
import gov.ifms.edp.repository.EDPSubOfficeItrRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsSubOfficeServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsSubOfficeServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsSubOfficeServiceImpl service;

	/** The repository. */
	@Mock
	private EDPMsSubOfficeRepository repository;

	/** The edp ms office repository. */
	@Mock
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/** The sub office entity. */
	@Mock
	private EDPMsSubOfficeEntity subOfficeEntity;

	/** The edp ms office entity. */
	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;

	/** The edp ms district entity. */
	@Mock
	private EDPMsDistrictEntity edpMsDistrictEntity;

	/** The sub office itr converter. */
	@Mock
	private EDPSubOfficeItrConverter subOfficeItrConverter;

	/** The sub office itr entity. */
	@Mock
	private EDPSubOfficeItrEntity subOfficeItrEntity;

	/** The sub office itr repository. */
	@Mock
	private EDPSubOfficeItrRepository subOfficeItrRepository;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsSubOfficeEntity> spec;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPMsSubOfficeEntity> page;

	/** The converter. */
	@Mock
	private EDPMsSubOfficeConverter converter;

	/** The lookupinforepository. */
	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The edp ms department entity. */
	@Mock
	private EDPMsDepartmentEntity edpMsDepartmentEntity;

	/** The edp lu look up info entity list. */
	@Mock
	private List<EDPLuLookUpInfoEntity> edpLuLookUpInfoEntityList;

	/** The sub office entity list. */
	@Mock
	private List<EDPMsSubOfficeEntity> subOfficeEntityList;

	/** The edp lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The itr service. */
	@Mock
	private EDPSubOfficeItrService itrService;

	/** The edp ms sub office dto. */
	@Mock
	private EDPMsSubOfficeDto edpMsSubOfficeDto;

	/** The edp ms sub office pageble dto. */
	@Mock
	private PagebleDTO<EDPMsSubOfficeDto> edpMsSubOfficePagebleDto;

	/** The office trn entity. */
	@Mock
	private EDPUpdateOfficeTrnEntity officeTrnEntity;

	/** The edp ms office service. */
	@Mock
	private EDPMsOfficeService edpMsOfficeService;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms sub office.
	 */
	@Test
	void testGetMsSubOffice() {
		when(repository.findBySubOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(subOfficeEntity);
		assertNotNull(service.getMsSubOffice(JunitConstants.LONG_TYPE));
		verify(repository).findBySubOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS);
	}

	/**
	 * Test save or update ms sub office try.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveOrUpdateMsSubOffice_try() throws CustomException {
		when(subOfficeEntity.getSubOfficeCode()).thenReturn(null);
		when(subOfficeEntity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_SAVAS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpMsOfficeRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				EDPConstant.ACTIVE_STATUS_TRUE)).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(subOfficeItrRepository.getSubOfficeCodeCount(JunitConstants.LONG_TYPE))
				.thenReturn(JunitConstants.INTEGER_TYPE);
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getCardexno()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsSubOfficeDto.getIsUpdate()).thenReturn(JunitConstants.FALSE);
		when(repository.save(Mockito.any(EDPMsSubOfficeEntity.class))).thenReturn(subOfficeEntity);
		when(subOfficeItrConverter.toEntity(subOfficeEntity)).thenReturn(subOfficeItrEntity);
		when(subOfficeItrRepository.save(subOfficeItrEntity)).thenReturn(subOfficeItrEntity);
//		assertNotNull(service.saveOrUpdateMsSubOffice(subOfficeEntity, edpMsSubOfficeDto));
		List<EDPSubOfficeItrEntity> previousEntity = new ArrayList<>();
		previousEntity.add(subOfficeItrEntity);
		when(edpMsSubOfficeDto.getIsUpdate()).thenReturn(JunitConstants.FALSE);
		when(subOfficeEntity.getSubOfficeCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(subOfficeItrRepository.findBySubOfficeCodeAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(previousEntity);
//		when(edpMsOfficeService
//						.getLastOfficeTrn(JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE)).then
		assertNotNull(service.saveOrUpdateMsSubOffice(subOfficeEntity, edpMsSubOfficeDto));

		when(edpMsSubOfficeDto.getIsUpdate()).thenReturn(JunitConstants.TRUE);

		List<EDPSubOfficeItrEntity> edpSubOfficeItrEntityList = new ArrayList<>();
		edpSubOfficeItrEntityList.add(subOfficeItrEntity);
		when(subOfficeItrRepository.findBySubOfficeCodeAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(edpSubOfficeItrEntityList);
		assertNotNull(service.saveOrUpdateMsSubOffice(subOfficeEntity, edpMsSubOfficeDto));
	}

	/**
	 * Test save or update ms sub office catch.
	 *
	 * @throws CustomException the custom exception
	 */
//	@Test
	void testSaveOrUpdateMsSubOffice_catch() throws CustomException {
		try {
			when(repository.save(subOfficeEntity)).thenThrow(new Exception(JunitConstants.STRING_TYPE));
			when(subOfficeItrConverter.toEntity(subOfficeEntity)).thenReturn(subOfficeItrEntity);
			when(subOfficeItrRepository.save(subOfficeItrEntity)).thenReturn(subOfficeItrEntity);
//			assertNotNull(service.saveOrUpdateMsSubOffice(subOfficeEntity));
		} catch (Exception e) {

		}

	}

	/**
	 * Test delete ms sub office.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteMsSubOffice() throws CustomException {
		when(subOfficeEntity.getSubOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findBySubOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(subOfficeEntity);
		when(subOfficeEntity.getSubOfficeCode()).thenReturn(JunitConstants.STRING_TYPE);
		List<EDPSubOfficeItrEntity> edpSubOfficeItrEntityList = new ArrayList<>();
		edpSubOfficeItrEntityList.add(subOfficeItrEntity);
		when(subOfficeItrRepository.findBySubOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpSubOfficeItrEntityList);
		when(subOfficeItrEntity.getSubOfficeItrId()).thenReturn(JunitConstants.LONG_TYPE);
		when(subOfficeItrRepository.updateActiveStatusBySubOfficeId(Mockito.anyLong(), Mockito.anyInt(),
				Mockito.anyLong(), Mockito.any(Date.class))).thenReturn(JunitConstants.INTEGER_TYPE);
		when(repository.updateActiveStatusByOfficeId(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong(),
				Mockito.any(Date.class))).thenReturn(JunitConstants.INTEGER_TYPE);
		service.deleteMsSubOffice(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository, times(1)).updateActiveStatusByOfficeId(Mockito.any(Long.class), Mockito.any(Integer.class),
				Mockito.any(Long.class), Mockito.any(Date.class));
	}

	/**
	 * Test get ms sub offices.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetMsSubOffices() throws Exception {
		SearchParam searchParam1 = new SearchParam();
		searchParam1.setKey(JunitConstants.IS_UPDATE);
		searchParam1.setValue(JunitConstants.STRING_TRUE);
		SearchParam searchParam2 = new SearchParam();
		searchParam2.setKey(JunitConstants.FLAG);
		searchParam2.setValue(JunitConstants.STRING_TRUE);
		SearchParam searchParam8 = new SearchParam();
		searchParam8.setKey(EDPConstant.DISPLAY_SUB_OFFICE);
		searchParam8.setValue(JunitConstants.STRING_TRUE);
		List<SearchParam> list1 = new ArrayList<>();
		list1.add(searchParam1);
		list1.add(searchParam2);
		list1.add(searchParam8);
		when(pageDetail.getJsonArr()).thenReturn(list1);
		when(itrService.getsubOfficeItrs(pageDetail)).thenReturn(edpMsSubOfficePagebleDto);
		assertNotNull(service.getMsSubOffices(pageDetail));

		SearchParam searchParam3 = new SearchParam();
		searchParam3.setKey(JunitConstants.IS_UPDATE);
		searchParam3.setValue(JunitConstants.STRING_TRUE);
		SearchParam searchParam4 = new SearchParam();
		searchParam4.setKey(JunitConstants.FLAG);
		searchParam4.setValue(JunitConstants.STRING_FALSE);
		List<SearchParam> list2 = new ArrayList<>();
		list2.add(searchParam3);
		list2.add(searchParam4);
		when(pageDetail.getJsonArr()).thenReturn(list2);
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam5 = new SearchParam();
		searchParam5.setKey(JunitConstants.STRING_TYPE);
		searchParam5.setValue(JunitConstants.STRING_TYPE);
		SearchParam searchParam9 = new SearchParam();
		searchParam9.setKey(EDPConstant.DISPLAY_SUB_OFFICE);
		searchParam9.setValue(JunitConstants.STRING_FALSE);
		List<SearchParam> list3 = new ArrayList<>();
		list3.add(searchParam3);
		list3.add(searchParam4);
		list3.add(searchParam5);
		list3.add(searchParam9);
		when(pageDetail.getJsonArr()).thenReturn(list3);
		when(searchCriteria.getSpecificationDetails(spec, list3)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getMsSubOffices(pageDetail));

		SearchParam searchParam6 = new SearchParam();
		searchParam6.setKey(JunitConstants.STRING_TYPE);
		searchParam6.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list4 = new ArrayList<>();
		list4.add(searchParam6);
		when(pageDetail.getJsonArr()).thenReturn(list4);
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam7 = new SearchParam();
		searchParam7.setKey(JunitConstants.STRING_TYPE);
		searchParam7.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list5 = new ArrayList<>();
		list5.add(searchParam7);
		when(pageDetail.getJsonArr()).thenReturn(list5);
		when(searchCriteria.getSpecificationDetails(spec, list5)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getMsSubOffices(pageDetail));
	}

	/**
	 * Test get sub office code.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSubOfficeCode() throws CustomException {
		List<EDPMsSubOfficeEntity> subofficeList = new ArrayList<>();
		subofficeList.add(subOfficeEntity);
		when(edpMsOfficeRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				EDPConstant.ACTIVE_STATUS_TRUE)).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByOfficeIdOfficeId(JunitConstants.LONG_TYPE)).thenReturn(subofficeList);
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getCardexno()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.getSubOfficeCode(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test approve all sub office by office id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testApproveAllSubOfficeByOfficeId() throws CustomException {
		List<EDPMsSubOfficeEntity> edpSubOfficeEntityList = new ArrayList<>();
		edpSubOfficeEntityList.add(subOfficeEntity);
		when(subOfficeItrEntity.getSubOfficeCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findByOfficeIdOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpSubOfficeEntityList);
		when(subOfficeItrConverter.toItrEntity(subOfficeItrEntity)).thenReturn(subOfficeEntity);
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.save(subOfficeEntity)).thenReturn(subOfficeEntity);
		when(subOfficeEntity.getSubOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(subOfficeEntity);
		when(subOfficeItrRepository.save(subOfficeItrEntity)).thenReturn(subOfficeItrEntity);
		when(edpMsOfficeRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				EDPConstant.ACTIVE_STATUS_TRUE)).thenReturn(edpMsOfficeEntity);
		when(repository.findLastSubOfficeCode(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.LONG_TYPE));
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		service.approveAllSubOfficeByOfficeId(JunitConstants.LONG_TYPE);
		when(repository.findBySubOfficeCodeAndActiveStatus(JunitConstants.STRING_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(null);
		List<EDPSubOfficeItrEntity> edpSubOfficeItrEntityList1 = new ArrayList<>();
		edpSubOfficeItrEntityList1.add(subOfficeItrEntity);
		when(subOfficeItrRepository.findBySubOfficeCodeAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(edpSubOfficeItrEntityList1);
		service.approveAllSubOfficeByOfficeId(JunitConstants.LONG_TYPE);
		verify(repository, times(2)).findByOfficeIdOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS);
	}

	/**
	 * Test update all sub office data.
	 */
	@Test
	void testUpdateAllSubOfficeData() {
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPMsSubOfficeEntity> subOfficeList = new ArrayList<>();
		subOfficeList.add(subOfficeEntity);
		when(repository.findByOfficeIdOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(subOfficeList);
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDepartmentId()).thenReturn(edpMsDepartmentEntity);
		when(edpMsOfficeEntity.getHodId()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(repository.saveAll(subOfficeEntityList)).thenReturn(subOfficeEntityList);
		List<EDPSubOfficeItrEntity> edpSubOfficeItrEntityList = new ArrayList<>();
		edpSubOfficeItrEntityList.add(subOfficeItrEntity);
		when(subOfficeItrRepository.findByOfficeIdOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(edpSubOfficeItrEntityList);
		when(subOfficeEntity.getDistrict()).thenReturn(edpMsDistrictEntity);
		when(subOfficeItrRepository.saveAll(edpSubOfficeItrEntityList)).thenReturn(edpSubOfficeItrEntityList);
		when(subOfficeEntity.getSubOfficeCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getCardexno()).thenReturn(JunitConstants.LONG_TYPE);
		when(subOfficeItrEntity.getSubOfficeCode()).thenReturn("10/20");
		when(subOfficeItrEntity.getDistrict()).thenReturn(edpMsDistrictEntity);
		service.updateAllSubOfficeData(edpMsOfficeEntity);
		verify(repository, times(1)).findByOfficeIdOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS);

	}

	/**
	 * Test update sub office code.
	 */
	@Test
	void testUpdateSubOfficeCode() {
		when(subOfficeEntity.getSubOfficeCode()).thenReturn(JunitConstants.SET_TRSN_NO);
		service.updateSubOfficeCode(subOfficeEntity, edpMsOfficeEntity);
		when(subOfficeItrEntity.getSubOfficeCode()).thenReturn(JunitConstants.SET_TRSN_NO);
		service.updateSubOfficeItrCode(subOfficeItrEntity, edpMsOfficeEntity);
	}

	/**
	 * Test update sub office itr.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testUpdateSubOfficeItr() throws CustomException {
		when(repository.findBySubOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(subOfficeEntity);
		List<EDPSubOfficeItrEntity> subOfficeItrEntities = new ArrayList<>();
		subOfficeItrEntities.add(subOfficeItrEntity);
		when(subOfficeItrRepository.findBySubOfficeCodeAndActiveStatus(subOfficeEntity.getSubOfficeCode(),
				Constant.ACTIVE_STATUS)).thenReturn(subOfficeItrEntities);
		service.updateSubOfficeItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(null);
		service.updateSubOfficeItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository, times(2)).findBySubOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS);
	}

	/**
	 * Test update sub office itr 2.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testUpdateSubOfficeItr2() throws CustomException {
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(edpMsOfficeEntity.getDepartmentId()).thenReturn(edpMsDepartmentEntity);
		List<EDPSubOfficeItrEntity> subOfficeItrEntities = new ArrayList<>();
		subOfficeItrEntities.add(subOfficeItrEntity);
		when(subOfficeItrRepository.findByOfficeIdOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(subOfficeItrEntities);
		when(subOfficeItrRepository.findBySubOfficeCodeAndActiveStatus(subOfficeEntity.getSubOfficeCode(),
				Constant.ACTIVE_STATUS)).thenReturn(subOfficeItrEntities);
		service.updateSubOfficeItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(null);
		service.updateSubOfficeItr(edpMsOfficeEntity);
	}

	/**
	 * Test copy ms sub office.
	 */
	@Test
	void testCopyMsSubOffice() {
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPMsSubOfficeEntity> edpSubOfficeEntityList = new ArrayList<>();
		edpSubOfficeEntityList.add(subOfficeEntity);
		when(repository.findByOfficeIdOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE))
				.thenReturn(edpSubOfficeEntityList);
		when(subOfficeItrConverter.toEntity(subOfficeEntity)).thenReturn(subOfficeItrEntity);
		service.copyMsSubOffice(edpMsOfficeEntity, officeTrnEntity);
	}
}