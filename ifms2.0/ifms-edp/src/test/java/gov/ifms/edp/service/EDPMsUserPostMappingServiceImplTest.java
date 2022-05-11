package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import gov.ifms.common.base.Status;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsUserConverter;
import gov.ifms.edp.converter.EDPUserPoTrnsConverter;
import gov.ifms.edp.converter.EDPUserPoTrnsHeaderConverter;
import gov.ifms.edp.converter.EDPUserPoTrnsItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPPostMapDto;
import gov.ifms.edp.dto.EDPUserPostDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsDetailDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsHeaderDto;
import gov.ifms.edp.employe.EDPEmployeConverter;
import gov.ifms.edp.employe.EDPEmployeDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPLkEmpUserEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserItrRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostOfficeRepository;
import gov.ifms.edp.repository.EDPLkPostUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPTedpUptTrnDataRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsHeaderRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsItrRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsRepository;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsUserPostMappingServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsUserPostMappingServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsUserPostMappingServiceImpl service;

	/** The edp lk post user repository. */
	@Mock
	private EDPLkPostUserRepository edpLkPostUserRepository;

	/** The edp employe repository. */
	@Mock
	private EDPEmployeRepository edpEmployeRepository;

	/** The edp employe entity. */
	@Mock
	private EDPEmployeEntity edpEmployeEntity;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The edp usr po trns repository. */
	@Mock
	private EDPUsrPoTrnsRepository edpUsrPoTrnsRepository;

	/** The edp lk po off user repository. */
	@Mock
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity edpLkPoOffUserEntity;

	/** The edp usr po trns dto. */
	@Mock
	private EDPUsrPoTrnsDto edpUsrPoTrnsDto;

	/** The edp user post dto. */
	@Mock
	private EDPUserPostDto edpUserPostDto;

	/** The edp post map dto. */
	@Mock
	private EDPPostMapDto edpPostMapDto;

	/** The edp usr po trns itr repository. */
	@Mock
	private EDPUsrPoTrnsItrRepository edpUsrPoTrnsItrRepository;

	/** The edp ms office dto. */
	@Mock
	private EDPMsOfficeDto edpMsOfficeDto;

	/** The edp user po trns itr converter. */
	@Mock
	private EDPUserPoTrnsItrConverter edpUserPoTrnsItrConverter;

	/** The edp user po trns converter. */
	@Mock
	private EDPUserPoTrnsConverter edpUserPoTrnsConverter;

	/** The edp employe converter. */
	@Mock
	private EDPEmployeConverter edpEmployeConverter;

	/** The edp ms user converter. */
	@Mock
	private EDPMsUserConverter edpMsUserConverter;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The edp lk post office entity. */
	@Mock
	private EDPLkPostOfficeEntity edpLkPostOfficeEntity;

	/** The user entity. */
	@Mock
	private EDPMsUserEntity userEntity;

	/** The last desig entity. */
	@Mock
	private EDPUsrPoTrnsEntity lastDesigEntity;

	/** The financial year entity. */
	@Mock
	private EDPMsFinancialYearEntity financialYearEntity;

	/** The lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity lkPoOffUserEntity;

	/** The edp lk post office repository. */
	@Mock
	private EDPLkPostOfficeRepository edpLkPostOfficeRepository;

	/** The edp ms user repository. */
	@Mock
	private EDPMsUserRepository edpMsUserRepository;

	/** The financial year repository. */
	@Mock
	private EDPMsFinancialYearRepository financialYearRepository;

	/** The employe dto. */
	@Mock
	private EDPEmployeDto employeDto;

	/** The edp usr po trns header repository. */
	@Mock
	private EDPUsrPoTrnsHeaderRepository edpUsrPoTrnsHeaderRepository;

	/** The edp usr po trns header dto. */
	@Mock
	private EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto;

	/** The edp usr po trns header dto 2. */
	@Mock
	private EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto2;

	/** The edp usr po trns header entity. */
	@Mock
	EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHeaderEntity;

	/** The edp lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The edp lk emp user repository. */
	@Mock
	private EDPLkEmpUserRepository edpLkEmpUserRepository;

	/** The edp usr po trns header converter. */
	@Mock
	private EDPUserPoTrnsHeaderConverter edpUsrPoTrnsHeaderConverter;

	/** The edp usr po trns detail dto. */
	@Mock
	private EDPUsrPoTrnsDetailDto edpUsrPoTrnsDetailDto;

	/** The edp usr po trns entity. */
	@Mock
	private EDPUsrPoTrnsEntity edpUsrPoTrnsEntity;

	/** The edp usr po trns detail dto 2. */
	@Mock
	private EDPUsrPoTrnsDetailDto edpUsrPoTrnsDetailDto2;

	/** The edp lk emp user entity. */
	@Mock
	private EDPLkEmpUserEntity edpLkEmpUserEntity;

	/** The edp id dto. */
	@Mock
	private EDPIdDto edpIdDto;

	/** The clue dto. */
	@Mock
	private ClueDto clueDto;
	
	@Mock
	private EDPTedpUptTrnDataRepository edpTedpUptTrnDataRepository;
	
	@Mock
	private List<EDPUsrPoTrnsEntity> userPoTrnsEntityList;
	
	@Mock
	private List<EDPUsrPoTrnsDetailDto> edpUsrPoTrnsDetailDtoList;
	
	@Mock
	private EDPLkEmpUserEntity lkUserEmployeeEntit;
	
	@Mock
	private List<EDPLkPoOffUserEntity> lkPoOffUserEntityList;
	
	@Mock
	private EDPLkPoOffUserItrRepository edpLkPoOffUserItrRepository;
	
	@Mock
	private EDPWorkflowRequestHandler wfRequestHandler;
	
	/** The district converter. */
	@Mock
	private EDPMsDistrictConverter districtConverter;
	
	/** The district repository. */
	@Mock
	private EDPMsDistrictRepository districtRepository;
	
	
	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get post user mapping by header id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetPostUserMappingByHeaderId() throws Exception {
			
		List<Object[]> postOfficeUserList = new ArrayList<>();
		Object[] obj = new Object[30];
		obj[1] = JunitConstants.LONG_STRING_VALUE;
		obj[3] = JunitConstants.LONG_TYPE;
		obj[4] = JunitConstants.LONG_STRING_VALUE;
	    obj[11] = JunitConstants.LONG_STRING_VALUE;
	    obj[5] = JunitConstants.LONG_TYPE;
	    obj[6] = JunitConstants.LONG_STRING_VALUE;
	    obj[12] = JunitConstants.LONG_STRING_VALUE;
	    obj[18] = JunitConstants.LONG_TYPE;
	    obj[19] = JunitConstants.LONG_STRING_VALUE;
	    obj[20] = JunitConstants.LONG_STRING_VALUE;
		obj[10] = JunitConstants.STRING_DATE;
		obj[24] = "Rejected";
		obj[25] = 2;
		obj[27] = 2;
		postOfficeUserList.add(obj);
		
		List<Object[]> searchList = new ArrayList<>();
		Object[] serObj = new Object[30];
		serObj[1] = JunitConstants.LONG_STRING_VALUE;
		serObj[2] = JunitConstants.LONG_STRING_VALUE;
		serObj[3] = JunitConstants.LONG_TYPE;
		serObj[4] = JunitConstants.LONG_STRING_VALUE;
	    serObj[11] = JunitConstants.LONG_STRING_VALUE;
	    serObj[5] = JunitConstants.LONG_TYPE;
	    serObj[6] = JunitConstants.LONG_STRING_VALUE;
	    serObj[12] = JunitConstants.LONG_STRING_VALUE;
	    serObj[10] = JunitConstants.STRING_DATE;
	    serObj[18] = JunitConstants.LONG_TYPE;
	    serObj[19] = JunitConstants.LONG_STRING_VALUE;
	    serObj[20] = JunitConstants.LONG_STRING_VALUE;
	    obj[24] = "Rejected";
	    obj[27] = 2;
	    obj[25] = 2;
	    searchList.add(serObj);
	    
 		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(postOfficeUserList);
		when(edpLkPoOffUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(searchList);
		assertNotNull(service.getPostUserMappingByHeaderId(JunitConstants.LONG_TYPE));
	}
	
	/**
	 * Test get post user mapping by header id 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetPostUserMappingByHeaderId1() throws Exception {
		
		List<Object[]> postOfficeUserList = new ArrayList<>();
		Object[] obj = new Object[30];
		obj[1] = JunitConstants.LONG_STRING_VALUE;
		obj[7] = JunitConstants.LONG_TYPE;
		obj[5] = JunitConstants.LONG_TYPE;
		obj[6] = JunitConstants.LONG_STRING_VALUE;
		obj[12] = JunitConstants.LONG_STRING_VALUE;
		obj[18] = JunitConstants.LONG_TYPE;
		obj[19] = JunitConstants.LONG_STRING_VALUE;
		obj[20] = JunitConstants.LONG_STRING_VALUE;
		obj[10] = JunitConstants.STRING_DATE;
		postOfficeUserList.add(obj);
		
		List<Object[]> searchList = new ArrayList<>();
		Object[] serObj = new Object[30];
		serObj[1] = JunitConstants.LONG_STRING_VALUE;
		serObj[2] = JunitConstants.LONG_STRING_VALUE;
		serObj[3] = JunitConstants.LONG_TYPE;
		serObj[4] = JunitConstants.LONG_STRING_VALUE;
	    serObj[11] = JunitConstants.LONG_STRING_VALUE;
	    serObj[5] = JunitConstants.LONG_TYPE;
	    serObj[6] = JunitConstants.LONG_STRING_VALUE;
	    serObj[12] = JunitConstants.LONG_STRING_VALUE;
	    serObj[10] = JunitConstants.STRING_DATE;
	    serObj[18] = JunitConstants.LONG_TYPE;
	    serObj[19] = JunitConstants.LONG_STRING_VALUE;
	    serObj[20] = JunitConstants.LONG_STRING_VALUE;
	    
	    Object[] serObj1 = new Object[30];
		serObj1[1] = JunitConstants.LONG_STRING_VALUE;
		serObj1[2] = JunitConstants.LONG_STRING_VALUE;
		serObj1[3] = JunitConstants.LONG_TYPE;
		serObj1[4] = JunitConstants.LONG_STRING_VALUE;
	    serObj1[11] = JunitConstants.LONG_STRING_VALUE;
	    serObj1[5] = JunitConstants.LONG_TYPE;
	    serObj1[6] = JunitConstants.YES;
	    serObj1[12] = JunitConstants.LONG_STRING_VALUE;
	    serObj1[10] = JunitConstants.STRING_DATE;
	    serObj1[18] = JunitConstants.LONG_TYPE;
	    serObj1[19] = JunitConstants.LONG_STRING_VALUE;
	    serObj1[20] = JunitConstants.LONG_STRING_VALUE;
	    
	    searchList.add(serObj1);
	    
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(postOfficeUserList);
		when(edpLkPoOffUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(searchList);
		assertNotNull(service.getPostUserMappingByHeaderId(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void createUserPostMappingSaveAsDrft() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsHeaderId(1l);
		edpUsrPoTrnsHeaderDto.setFormAction(Status.DRAFT);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_SAVAS_DRAFT);
		listLkEntity.add(entity);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderRepository.save(edpUsrPoTrnsHeaderEntity)).thenReturn(edpUsrPoTrnsHeaderEntity);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}

	@Test
	void createUserPostMappingSubmite() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderRepository.save(edpUsrPoTrnsHeaderEntity)).thenReturn(edpUsrPoTrnsHeaderEntity);
		List<EDPUsrPoTrnsEntity> userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setFromUserId(new EDPMsUserEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		List<EDPUsrPoTrnsDetailDto> edpUsrPoTrnsDetailDto = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDto.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDto);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsHeaderId(1l);
		edpUsrPoTrnsHeaderDto.setCurMenuId(15l);
		edpUsrPoTrnsHeaderDto.setWfSaveDrftApiCall(true);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void createUserPostMappingSubmite1() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_YES));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);

		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(lkUserEmployeeEntit);
		lkUserEmployeeEntit.setActiveStatus(1);
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		
		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
		.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.findByActiveStatusAndLkPostOfficeIdPostOfficeIdIn(Mockito.anyInt(),Mockito.anySet()))
		   .thenReturn(lkPoOffUserEntityList);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void createUserPostMappingSubmite2() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_YES));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);
		
		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(lkUserEmployeeEntit);
		lkUserEmployeeEntit.setActiveStatus(1);
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		
		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
				.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void createUserPostMappingSubmite3() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_YES));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);
		
		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(null);
		
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		edpEmployeEntity = new EDPEmployeEntity();
		when(edpEmployeRepository.getOne(Mockito.anyLong())).thenReturn(edpEmployeEntity);
		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
				.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void createUserPostMappingSubmite4() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_YES));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);
		
		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(null);
		
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		edpEmployeEntity = new EDPEmployeEntity();
		edpEmployeEntity.setEmployeeCode(123l);		
		when(edpEmployeRepository.getOne(Mockito.anyLong())).thenReturn(edpEmployeEntity);
		userEntity = new EDPMsUserEntity();
		when(edpMsUserRepository.findByUserCodeAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(userEntity);

		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
				.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void createUserPostMappingSubmite5() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_YES));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);
		
		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(null);
		
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		edpEmployeEntity = new EDPEmployeEntity();
		edpEmployeEntity.setEmployeeCode(123l);		
		when(edpEmployeRepository.getOne(Mockito.anyLong())).thenReturn(edpEmployeEntity);
		userEntity = new EDPMsUserEntity();
		userEntity.setActiveStatus(0);
		when(edpMsUserRepository.findByUserCodeAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(userEntity);
		
		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
				.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void createUserPostMappingSubmite6() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_YES));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);

		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(lkUserEmployeeEntit);
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		userEntity = new EDPMsUserEntity();
		userEntity.setActiveStatus(0);
		when(edpMsUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(userEntity));
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		
		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
		.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.findByActiveStatusAndLkPostOfficeIdPostOfficeIdIn(Mockito.anyInt(),Mockito.anySet()))
		   .thenReturn(lkPoOffUserEntityList);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void createUserPostMappingSubmite7() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_YES));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);
		
		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(lkUserEmployeeEntit);
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		userEntity = new EDPMsUserEntity();
		userEntity.setActiveStatus(1);
		when(edpMsUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(userEntity));
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		
		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
				.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.findByActiveStatusAndLkPostOfficeIdPostOfficeIdIn(Mockito.anyInt(),Mockito.anySet()))
		.thenReturn(lkPoOffUserEntityList);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	void testDelete() throws CustomException {
		service.deleteUPMapping(JunitConstants.LONG_TYPE);
	}
	
	@Test
	void changePost() throws CustomException {
		edpIdDto = new EDPIdDto();
		edpIdDto.setId(1l);
		
		when(edpLkPoOffUserRepository
		.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(Mockito.anyLong(),Mockito.anyInt(),Mockito.any()))
		.thenReturn(Optional.of(edpLkPoOffUserEntity));
		when(edpLkPoOffUserRepository
				.findByLkPostOfficeIdPostOfficeIdAndUserIdUserIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyInt()))
		        .thenReturn(Optional.of(edpLkPoOffUserEntity));
		
		assertNotNull(service.changePost(edpIdDto));
	}
	
	@Test
	void createUserPostMappingSubmite8() throws Exception {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(JunitConstants.INTEGER_TYPE)).thenReturn(financialYearEntity);
		when(edpUsrPoTrnsHeaderRepository.findTopByOrderByEdpUsrPoTrnsHeaderIdDesc()).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderDto = new EDPUsrPoTrnsHeaderDto();
		edpUsrPoTrnsHeaderDto.setFormAction(Status.SUBMITTED);
		List<EDPLuLookUpInfoEntity> listLkEntity = new ArrayList<EDPLuLookUpInfoEntity>();
		EDPLuLookUpInfoEntity entity = new EDPLuLookUpInfoEntity();
		entity.setLookUpInfoId(JunitConstants.LONG_TYPE);
		entity.setLookUpInfoName(JunitConstants.LK_STATUS_VAL_APPROVED);
		listLkEntity.add(entity);
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listLkEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		when(edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto)).thenReturn(edpUsrPoTrnsHeaderEntity);
		edpUsrPoTrnsHeaderEntity = new EDPUsrPoTrnsHeaderEntity();
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(5l);
		when(edpUsrPoTrnsHeaderRepository.save(Mockito.any())).thenReturn(edpUsrPoTrnsHeaderEntity);
		
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		EDPUsrPoTrnsEntity svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setFromUserId(new EDPMsUserEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Mockito.anyLong())).thenReturn(userPoTrnsEntityList);
		edpUsrPoTrnsDetailDtoList = new ArrayList<EDPUsrPoTrnsDetailDto>();
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		edpUsrPoTrnsDetailDtoList.add(dto);
		edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsDetailDto(edpUsrPoTrnsDetailDtoList);
		userPoTrnsEntityList = new ArrayList<EDPUsrPoTrnsEntity>();
		svEntity = new EDPUsrPoTrnsEntity();
		svEntity.setToEmpId(new EDPEmployeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setFromUserId(new EDPMsUserEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setPostOfficeId(new EDPLkPostOfficeEntity(JunitConstants.LONG_OFFICE_ID));
		svEntity.setWillBePrimary(new EDPLuLookUpInfoEntity(JunitConstants.LOOKUP_INFO_NO));
		userPoTrnsEntityList.add(svEntity);
		when(edpUsrPoTrnsRepository.saveAll(Mockito.any())).thenReturn(userPoTrnsEntityList);
		
		EDPLkEmpUserEntity lkUserEmployeeEntit = new EDPLkEmpUserEntity();
		lkUserEmployeeEntit.setActiveStatus(0);
		lkUserEmployeeEntit.setUserId(new EDPMsUserEntity(1));
		when(edpLkEmpUserRepository.findByEmpIdEmpId(Mockito.anyLong())).thenReturn(lkUserEmployeeEntit);
		when(edpLkEmpUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit);
		userEntity = new EDPMsUserEntity();
		userEntity.setActiveStatus(1);
		when(edpMsUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(userEntity));
		when(edpMsUserRepository.save(Mockito.any())).thenReturn(lkUserEmployeeEntit.getUserId());
		
		
		edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		when(edpLkPoOffUserRepository
				.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt()))
		.thenReturn(edpLkPoOffUserEntity);
		lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		EDPLkPoOffUserEntity lpoEntity = new EDPLkPoOffUserEntity();
		lpoEntity.setLkPostOfficeId(svEntity.getPostOfficeId());
		lkPoOffUserEntityList.add(lpoEntity);
		when(edpLkPoOffUserRepository.findByActiveStatusAndLkPostOfficeIdPostOfficeIdIn(Mockito.anyInt(),Mockito.anySet()))
		.thenReturn(lkPoOffUserEntityList);
		when(edpLkPoOffUserRepository.save(Mockito.any())).thenReturn(lpoEntity);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[2];
		s[0] = JunitConstants.LONG_STRING;
		obje.add(s);
		when(edpUsrPoTrnsHeaderRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		assertNotNull(service.createUserPostMapping(edpUsrPoTrnsHeaderDto));
	}
	
	@Test
	public void getPostDetailsForEmp() throws CustomException {
		EDPIdDto toDto = new EDPIdDto();
		toDto.setUserCode(JunitConstants.LONG_STRING);
		toDto.setFrom(false);
		edpEmployeEntity = new EDPEmployeEntity();
		edpEmployeEntity.setEmpId(1l);
		edpEmployeEntity.setEmployeeCode(1l);
		edpEmployeEntity.setFatherName(JunitConstants.LONG_STRING_VALUE);
		edpEmployeEntity.setEmployeeSurname(JunitConstants.LONG_STRING_VALUE);
		when(edpEmployeRepository.findByEmployeeCodeAndActiveStatus(Mockito.anyLong(),Mockito.anyInt())).thenReturn(Optional.of(edpEmployeEntity));
		service.getPostDetailsByEmpNo(toDto);
	}
	
	@Test
	public void getPostDetailsForEmp1() throws CustomException {
		try {
		EDPIdDto toDto = new EDPIdDto();
		toDto.setUserCode(JunitConstants.LONG_STRING);
		toDto.setFrom(false);
		List<Object[]> obje = new ArrayList<Object[]>();
		Object[] s = new Object[8];
		s[0] = JunitConstants.LONG_STRING;
		s[1] = JunitConstants.LONG_STRING;
		s[2] = JunitConstants.LONG_STRING;
		s[3] = JunitConstants.LONG_STRING;
		s[4] = JunitConstants.LONG_STRING;
		s[5] = JunitConstants.LONG_STRING;
		s[6] = JunitConstants.LONG_STRING;
		obje.add(s);
		
		EDPEmployeEntity emp = new EDPEmployeEntity(1l);
		Optional<EDPEmployeEntity> opEmp = Optional.of(emp);
//		when(edpUsrPoTrnsRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obje);
		when(edpUsrPoTrnsRepository.findUserNameAndPostNameAndOfficeByLkpouId(Mockito.anyLong())).thenReturn(obje);
		when(edpEmployeRepository
				.findByEmployeeCodeAndActiveStatus(Mockito.anyLong(),Mockito.anyInt())).thenReturn(opEmp);
		service.getPostDetailsByEmpNo(toDto);
		}catch (Exception e) {
			
		}
	}
	
	@Test
	public void getApprovePostUserMappingByHeaderId() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		Object object[] = new Object[29];
		object[0] = 1;
		object[10] = JunitConstants.STRING_DATE;
		object[24] = "Rejected";
		object[25] = 2;
		object[27] = 2;
		objectList.add(object);
		List<Object[]> trnobjectList = new ArrayList<Object[]>();
		Object trnObject[] = new Object[20];
		trnObject[0] = 1;
		trnObject[1] = 1;
		trnObject[2] = 1;
		trnObject[3] = 1;
		trnObject[10] = 1;
		trnobjectList.add(trnObject);
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		when(edpTedpUptTrnDataRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(trnobjectList);
		assertNotNull(service.getApprovePostUserMappingByHeaderId(1l));
	}
	
	@Test
	public void getApprovePostUserMappingByHeaderId1() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		Object object[] = new Object[29];
		object[0] = 1;
		object[10] = JunitConstants.STRING_DATE;
		object[24] = "Rejected";
		object[25] = 2;
		object[27] = 2;
		objectList.add(object);
		List<Object[]> trnobjectList = new ArrayList<Object[]>();
		Object trnObject[] = new Object[29];
		trnObject[24] = "Rejected";
		trnObject[25] = 2;
		trnObject[27] = 2;
		trnobjectList.add(trnObject);
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		when(edpTedpUptTrnDataRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(trnobjectList);
		assertNotNull(service.getApprovePostUserMappingByHeaderId(1l));
	}
	
	@Test
	public void getApprovePostUserMappingByHeaderId2() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		Object object[] = new Object[29];
		object[0] = 1;
		object[18] = 1;
		object[5] = 1;
		object[3] = 1;		
		object[20] = 1;		
		object[10] = JunitConstants.STRING_DATE;
		object[24] = "Rejected";
		object[25] = 2;
		object[27] = 2;
		objectList.add(object);
		List<Object[]> trnobjectList = new ArrayList<Object[]>();
		Object trnObject[] = new Object[22];
		trnObject[4] = 4;
		trnObject[1] = 4;
		trnObject[2] = 4;
		trnObject[10] = 4;
		trnObject[9] = "Yes";
		trnObject[3] = 4;
		trnObject[6] = 4;
		trnObject[20] = 4;
		trnobjectList.add(trnObject);
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		when(edpTedpUptTrnDataRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(trnobjectList);
		assertNotNull(service.getApprovePostUserMappingByHeaderId(1l));
	}
	
	@Test
	public void getApprovePostUserMappingByHeaderId3() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		List<Object[]> trnobjectList = new ArrayList<Object[]>();
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		when(edpTedpUptTrnDataRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(trnobjectList);
		assertNotNull(service.getApprovePostUserMappingByHeaderId(1l));
	}
	
	@Test
	public void getApprovePostUserMappingByHeaderId4() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		Object object[] = new Object[29];
		object[0] = 1;
		object[18] = 1;
		object[5] = 1;
		object[3] = 1;		
		object[20] = 1;		
		object[10] = JunitConstants.STRING_DATE;
		object[24] = "Rejected";
		object[25] = 2;
		object[27] = 2;
		objectList.add(object);
		List<Object[]> trnobjectList = new ArrayList<Object[]>();
		Object trnObject[] = new Object[22];
		trnObject[4] = 4;
		trnObject[6] = 4;
		trnobjectList.add(trnObject);
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		when(edpTedpUptTrnDataRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(trnobjectList);
		assertNotNull(service.getApprovePostUserMappingByHeaderId(1l));
	}
	
	@Test
	public void getByHeaderId() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		Object object[] = new Object[29];
		object[0] = 1;
		object[18] = 1;
		object[5] = 1;
		object[3] = 1;		
		object[20] = 1;		
		object[10] = JunitConstants.STRING_DATE;
		object[24] = "Rejected";
		object[25] = 2;
		object[27] = 2;
		objectList.add(object);
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		assertNotNull(service.getSubmitPopupDetails(1l));
	}
	
	@Test
	public void getByHeaderId1() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		Object object[] = new Object[29];
		object[0] = 1;
		object[18] = 1;
		object[20] = 1;		
		object[19] = JunitConstants.STRING_DATE;
		objectList.add(object);
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		assertNotNull(service.getSubmitPopupDetails(1l));
	}
	
	@Test
	public void getByHeaderId2() throws CustomException {
		List<Object[]> objectList = new ArrayList<Object[]>();
		Object object[] = new Object[29];
		object[0] = 1;
		objectList.add(object);
		when(edpLkPostUserRepository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(objectList);
		assertNotNull(service.getSubmitPopupDetails(1l));
	}
	
	@Test
	public void getListingFilterData() throws CustomException {
		List<EDPMsDistrictEntity> objectList = new ArrayList<>();
		List<Object> obj = new ArrayList<>();
		Object[] objes = new Object[5];
		objes[0] = 1;
		objes[2] = 1;
		objes[3] = 1;
		objes[1] = 1;
		obj.add(objes);
		when(districtRepository.findByActiveStatusAndStateId(Mockito.anyInt(),Mockito.anyLong(),Mockito.any())).thenReturn(objectList);
		when(edpUsrPoTrnsRepository.executeNativeSQLQuery(Mockito.any(),Mockito.any())).thenReturn(obj);
		assertNotNull(service.getListingFilterData());
	}
	
	
}
