package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
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
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.converter.PVUFixToRegularPayConConverter;
import gov.ifms.pvu.dto.FixpayToRegularRequestDto;
import gov.ifms.pvu.dto.IdAndValueDto;
import gov.ifms.pvu.dto.PVUFixToRegularPayConDto;
import gov.ifms.pvu.dto.PVUFixToRegularPayListView;
import gov.ifms.pvu.dto.PayBandIdAndEnteryPayValueDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUFixToRegularPayConEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUFixToRegularPayConRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.service.PVUFixPayToRegularServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class PVUFixPayToRegularServiceImplTest {

	@InjectMocks
	private PVUFixPayToRegularServiceImpl service;

	@Mock
	private PVUFixToRegularPayListView pvuFixToRegularPayListView;

	@Mock
	private PVUFixToRegularPayConRepository pvuFixToRegularPayConRepository;

	@Mock
	private FixpayToRegularRequestDto fixpayToRegularRequestDto;

	@Mock
	private PVUMsPayScaleEntity pvuMsPayScaleEntity;

	@Mock
	private PVUMsPayScaleRepository pvuMsPayScaleRepository;

	@Mock
	private PVUMsPayBandEntity pvuMsPayBandEntity;

	@Mock
	private PVUMsPayBandRepository pvuMsPayBandRepository;

	@Mock
	private IdAndValueDto idAndValueDto;

	@Mock
	private PVUMsGradePayEntity pvuMsGradePayEntity;

	@Mock
	private PVUMsGradePayRepository pvuMsGradePayRepository;

	@Mock
	private PayBandIdAndEnteryPayValueDto payBandIdAndEnteryPayValueDto;

	@Mock
	private PVUMsPayLevelRepository pvuMsPayLevelRepository;

	@Mock
	private PVUMsPayCellEntity pvuMsPayCellEntity;

	@Mock
	private PVUMsPayCellRepository pvuMsPayCellRepository;

	/** The page details. */
	@Mock
	private PageDetails pageDetails;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The page. */
	@Mock
	private Page<PVUFixToRegularPayConEntity> page;

	/** The emp spec. */
	@Mock
	private Specification<PVUFixToRegularPayConEntity> empSpec;

	/** The spec. */
	@Mock
	private SpecificationImpl<PVUFixToRegularPayConEntity> spec;

	@Mock
	private PVUFixToRegularPayConEntity pvuFixToRegularPayConEntity;

	@Mock
	private GenericDao repository;

	@Mock
	private EDPMsFinancialYearEntity edpMsFinancialYearEntity;

	@Mock
	private EDPMsFinancialYearRepository edpMsFinancialYearRepository;

	@Mock
	private EDPUtility edpUtility;

	@Mock
	private PVUEmployeRepository pvuEmployeRepository;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private PVUFixToRegularPayConConverter pvuFixToRegularPayConConverter;

	@Mock
	private PVUFixToRegularPayConDto pvuFixToRegularPayConDto;

	@Mock
	private OAuthUtility oAuthUtility;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Mock
	private EDPLuLookUpInfoConverter edpLuLookUpInfoConverter;

	@Mock
	private EDPLuLookUpInfoDto edpLuLookUpInfoDto;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetFixToRegPayList() throws CustomException {

		when(pageDetails.getPageDetails(pageDetails)).thenReturn(pageable);
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		List<PVUFixToRegularPayListView> list = new ArrayList<>();
		List<Object[]> objects = new ArrayList<Object[]>();
		list.add(pvuFixToRegularPayListView);
		SearchParam sp = new SearchParam();
		sp.setKey("123");
		sp.setValue("123");
		sp.setKey("menuId");
		sp.setValue(String.valueOf(1l));
		jsonArr.add(sp);
		when(pageDetails.getJsonArr()).thenReturn(jsonArr);
		when(searchCriteria.getSpecificationDetails(spec, jsonArr)).thenReturn(empSpec);
		when(pvuFixToRegularPayConRepository.findAll(empSpec, pageable)).thenReturn(page);
		when(pvuFixToRegularPayConRepository.findAll(Mockito.any(SpecificationImpl.class),
				Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		when(pvuFixToRegularPayConRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		assertNotNull(service.getFixToRegPayList(pageDetails));
	}

	@Test
	void testGetFifthPayScale() {
		List<Long> list = new ArrayList<Long>();
		List<PVUMsPayScaleEntity> entities = new ArrayList<PVUMsPayScaleEntity>();
		list.add(Mockito.anyLong());
		when(pvuMsPayScaleRepository.getPayScaleIdByDepartmentCategoryAndFixPay(Mockito.anyLong(),
				Constant.ACTIVE_STATUS, Mockito.anyLong())).thenReturn(list);
		when(pvuMsPayScaleRepository.findAllByPayScaleIdIn(list)).thenReturn(entities);
		assertNotNull(service.getFifthPayScale(fixpayToRegularRequestDto));

	}

	@Test
	void testGetSixthPayBandValue() {
		List<Long> list = new ArrayList<Long>();
		List<PVUMsPayBandEntity> entities = new ArrayList<PVUMsPayBandEntity>();
		when(fixpayToRegularRequestDto.getPayLevel()).thenReturn(1l);
		when(fixpayToRegularRequestDto.getDeptCatId()).thenReturn(1l);
		when(fixpayToRegularRequestDto.getFixPay()).thenReturn(1l);
		when(pvuMsPayBandRepository.getPayBandIdByDepartmentCategoryAndFixPayAndPayLevelId(1l, Constant.ACTIVE_STATUS,
				1l, 1l)).thenReturn(list);
		when(pvuMsPayBandRepository.findAllByIdIn(list,Sort.by("scaleValue"))).thenReturn(entities);
		assertNotNull(service.getSixthPayBandValue(fixpayToRegularRequestDto));
	}

	@Test
	void testGetSixthPayBandValueWithZeroPayLevel() {
		List<Long> list = new ArrayList<Long>();
		List<PVUMsPayBandEntity> entities = new ArrayList<PVUMsPayBandEntity>();
		when(fixpayToRegularRequestDto.getPayLevel()).thenReturn(0l);
		when(fixpayToRegularRequestDto.getDeptCatId()).thenReturn(1l);
		when(fixpayToRegularRequestDto.getFixPay()).thenReturn(1l);
		when(pvuMsPayBandRepository.getPayBandIdByDepartmentCategoryAndFixPay(1l, Constant.ACTIVE_STATUS, 1l))
				.thenReturn(list);
		when(pvuMsPayBandRepository.findAllByIdIn(list,Sort.by("payBandDispVal"))).thenReturn(entities);
		assertNotNull(service.getSixthPayBandValue(fixpayToRegularRequestDto));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetSixthGradePayValueAndEnterypayValue() {
		Map<String, Object> map = new HashedMap();
		List<IdAndValueDto> idDto = new ArrayList<>();
		List<Long> longList = new ArrayList<Long>();
		when(fixpayToRegularRequestDto.getPayBandId()).thenReturn(1l);
		when(fixpayToRegularRequestDto.getDeptCatId()).thenReturn(1l);
		when(fixpayToRegularRequestDto.getFixPay()).thenReturn(1l);
		when(pvuMsPayBandRepository.getGradePayIdByDepartmentCategoryAndFixPay(1l, Constant.ACTIVE_STATUS, 1l, 1l))
				.thenReturn(longList);
		longList.add(1l);
		List<PVUMsGradePayEntity> gradePayList = new ArrayList<PVUMsGradePayEntity>();
		gradePayList.add(pvuMsGradePayEntity);
		when(fixpayToRegularRequestDto.getPayBandId()).thenReturn(1l);
		when(pvuMsGradePayRepository.findAllByIdIn(longList, Sort.by("gradePayValue"))).thenReturn(gradePayList);
		when(pvuMsGradePayEntity.getId()).thenReturn(1l);
		when(pvuMsGradePayEntity.getGradePayValue()).thenReturn("ABC");
		idDto.add(new IdAndValueDto(1l, "ABC"));
		map.put("gradepay", idDto);
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] obj = new Object[4];
		obj[0] = "abc";
		obj[1] = "abc";
		obj[2] = "abc";
		obj[3] = "abc";
		list.add(obj);
		when(pvuMsPayScaleRepository.getEnteryPay(1l, 1l, longList)).thenReturn(list);
		List<PayBandIdAndEnteryPayValueDto> enteryPayList = new ArrayList<>();
		enteryPayList.add(new PayBandIdAndEnteryPayValueDto("abc", "abc", "abc", "abc"));
		map.put("payBandValue", enteryPayList);
		assertNotNull(service.getSixthGradePayValueAndEnterypayValue(fixpayToRegularRequestDto));
	}

	@Test
	void testGetSevenPayLevel() {
		List<IdAndValueDto> idDto = new ArrayList<>();
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] obj = new Object[2];
		obj[0] = 1l;
		obj[1] = "ABC";
		list.add(obj);
		when(fixpayToRegularRequestDto.getDeptCatId()).thenReturn(1l);
		when(fixpayToRegularRequestDto.getFixPay()).thenReturn(1l);
		when(pvuMsPayLevelRepository.getPayLevelByDepartmentCategoryAndFixpay(1l, Constant.ACTIVE_STATUS, 1l))
				.thenReturn(list);
		idDto.add(new IdAndValueDto(1l, "ABC"));
		assertNotNull(service.getSevenPayLevel(fixpayToRegularRequestDto));
	}

	@Test
	void testGetPayCellValue() {
		List<IdAndValueDto> idDto = new ArrayList<>();
		List<PVUMsPayCellEntity> list = new ArrayList<PVUMsPayCellEntity>();
		list.add(pvuMsPayCellEntity);
		when(fixpayToRegularRequestDto.getPayLevel()).thenReturn(1l);
		when(pvuMsPayCellRepository.findAllByPayLevelId(1l)).thenReturn(list);
		when(pvuMsPayCellEntity.getCellId()).thenReturn(1);
		when(pvuMsPayCellEntity.getCellValue()).thenReturn(1l);
		when(pvuMsPayCellEntity.getId()).thenReturn(1l);
		idDto.add(new IdAndValueDto(1l, "1"));
		assertNotNull(service.getPayCellValue(fixpayToRegularRequestDto));
	}

	@Test
	void testSaveOrUpdateFixToRegularPayCon() throws CustomException {
		List<Object[]> objects = new ArrayList<Object[]>();
		Object obj[] = new Object[1];
		obj[0] = "123";
		objects.add(obj);
		when(edpMsFinancialYearRepository.findByIsCurrentYearLookUpInfoName(Constant.LOOKUP_YES))
				.thenReturn(edpMsFinancialYearEntity);
		when(edpMsFinancialYearEntity.getFinancialYearId()).thenReturn(1l);
		when(edpMsFinancialYearEntity.getFyShort()).thenReturn("abc");
		when(pvuFixToRegularPayConEntity.getFyId()).thenReturn(1l);
		when(pvuFixToRegularPayConRepository.save(pvuFixToRegularPayConEntity)).thenReturn(pvuFixToRegularPayConEntity);
		when(pvuFixToRegularPayConRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(pvuFixToRegularPayConEntity.getFixRegDsId()).thenReturn(1l);
		when(pvuFixToRegularPayConEntity.getTrnNo()).thenReturn("abc");
		when(pvuFixToRegularPayConEntity.getRefDate()).thenReturn(new Date());
		when(pvuFixToRegularPayConRepository.saveAndFlush(pvuFixToRegularPayConEntity))
				.thenReturn(pvuFixToRegularPayConEntity);
		when(pvuFixToRegularPayConEntity.getFixRegDsId()).thenReturn(1l);
		when(pvuFixToRegularPayConEntity.getPayComm()).thenReturn(1l);
		when(pvuFixToRegularPayConEntity.getEmpId()).thenReturn(1l);
		pvuFixToRegularPayConRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertNotNull(service.saveOrUpdateFixToRegularPayCon(pvuFixToRegularPayConEntity, "SUBMITTED"));

	}

	@Test
	void testGetFixToRegularPayCon() {
		when(pvuFixToRegularPayConRepository.findByFixRegDsIdAndActiveStatus(1l, Constant.ACTIVE_STATUS))
				.thenReturn(pvuFixToRegularPayConEntity);
		when(pvuFixToRegularPayConEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeRepository.getOne(1l)).thenReturn(pvuEmployeEntity);

		when(pvuEmployeEntity.getEmployeeCode()).thenReturn(1l);
		when(pvuFixToRegularPayConConverter.toCustomDTO(pvuFixToRegularPayConEntity, 1l))
				.thenReturn(pvuFixToRegularPayConDto);
		assertNotNull(service.getFixToRegularPayCon(1l));
	}

	@Test
	void testDeleteFixToRegularPayCon() {
		pvuFixToRegularPayConRepository.deleteFixToRegularPayCon(Mockito.anyLong());
		service.deleteFixToRegularPayCon(Mockito.anyLong());
	}

	@Test
	void testGetStatus() {
		List<EDPLuLookUpInfoDto> dtolist = new ArrayList<EDPLuLookUpInfoDto>();
		Set<Long> statusNameList = new HashSet<>();
		statusNameList.add(EDPConstant.OFFICE_STATUS_DRAFT_ID);
		statusNameList.add(EDPConstant.STATUS_SUBMIT_ID);
		List<EDPLuLookUpInfoEntity> approveLookUpInfo = new ArrayList<EDPLuLookUpInfoEntity>();
		when(edpLuLookUpInfoRepository.findByLookUpInfoIdInAndEdpLuLookUpEntityLookUpId(statusNameList,
				EDPConstant.STATUS_PARENT_LOOKUP_ID)).thenReturn(approveLookUpInfo);
		when(edpLuLookUpInfoConverter.toDTO(approveLookUpInfo)).thenReturn(dtolist);
		assertNotNull(service.getStatus());

	}

	@Test
	void testCheckEmployeeAlreadyinitiated() throws CustomException {
		List<PVUFixToRegularPayConEntity> list = new ArrayList<PVUFixToRegularPayConEntity>();
		when(pvuFixToRegularPayConRepository.findByEmpIdAndCreatedByAndStatusIdAndActiveStatus(1l, 1l,
				Constant.SAVE_AS_DRAFT_STATUS_ID, Constant.ACTIVE_STATUS)).thenReturn(list);
		service.checkEmployeeAlreadyinitiated(1l);

	}
}
