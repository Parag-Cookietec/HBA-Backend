package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.annotation.Order;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PowerMockIgnore;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.ifms.common.base.Status;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.converter.EDPMsDepartmentConverter;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsLocationConverter;
import gov.ifms.edp.converter.EDPMsModuleConverter;
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.converter.EDPMsTalukaConverter;
import gov.ifms.edp.converter.EDPMsTreasuryConverter;
import gov.ifms.edp.converter.EDPMsUserConverter;
import gov.ifms.edp.converter.EDPOfficeItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPOfficeDetailsDto;
import gov.ifms.edp.employe.EDPEmployeConverter;
import gov.ifms.edp.employe.EDPEmployeDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLkEmpUserEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsLocationEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.entity.EDPMsModuleEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.entity.EDPOfficeItrEntity;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.edp.entity.EDPTrnUserMnuRolePrmEntity;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostUserOfficeRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRolesRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPMsMenuRepository;
import gov.ifms.edp.repository.EDPMsModuleRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.repository.EDPMsRolePermissionsRepository;
import gov.ifms.edp.repository.EDPMsTalukaRepository;
import gov.ifms.edp.repository.EDPMsTreasuryRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapRepository;
import gov.ifms.edp.repository.EDPOfficeItrRepository;
import gov.ifms.edp.repository.EDPOfficeModuleRepository;
import gov.ifms.edp.repository.EDPTrnUserMnuRolePrmRepository;
import gov.ifms.edp.repository.EDPUpdateOfficeTrnRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsHeaderRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsOfficeServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsOfficeServiceImplTest {

	/** The officedetailsdto. */
	@Mock
	private EDPOfficeDetailsDto officedetailsdto;

	/** The look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/** The repository. */
	@Mock
	private EDPMsOfficeRepository repository;

	/** The office module repository. */
	@Mock
	private EDPOfficeModuleRepository officeModuleRepository;

	/** The edp lk post user office repository. */
	@Mock
	private EDPLkPostUserOfficeRepository edpLkPostUserOfficeRepository;

	/** The office itr repository. */
	@Mock
	private EDPOfficeItrRepository officeItrRepository;

	/** The edp lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The edp ms designation repository. */
	@Mock
	private EDPMsDesignationRepository edpMsDesignationRepository;

	/** The office bill map repository. */
	@Mock
	private EDPOfficeBillMapRepository officeBillMapRepository;

	/** The post repository. */
	@Mock
	private EDPMsPostRepository postRepository;

	/** The edp office itr entity. */
	@Mock
	private EDPOfficeItrEntity edpOfficeItrEntity;

	/** The edp ms office entity. */
	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;

	/** The edp ms district entity. */
	@Mock
	private EDPMsDistrictEntity edpMsDistrictEntity;

	/** The bill map entity. */
	@Mock
	private EDPOfficeBillMapEntity billMapEntity;

	/** The look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity lookUpInfoEntity;

	/** The edp lk post user office entity. */
	@Mock
	private EDPLkPostOfficeEntity edpLkPostOfficeEntity;

	/** The edp ms designation entity. */
	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	/** The office module entity. */
	@Mock
	private EDPOfficeModuleEntity officeModuleEntity;

	/** The edp ms location entities. */
	@Mock
	private List<EDPMsLocationEntity> edpMsLocationEntities;

	/** The office itr converter. */
	@Mock
	private EDPOfficeItrConverter officeItrConverter;

	/** The edp ms location converter. */
	@Mock
	private EDPMsLocationConverter edpMsLocationConverter;

	/** The stream. */
	@Mock
	private Stream<EDPLuLookUpInfoEntity> stream;

	/** The page. */
	@Mock
	private Page<EDPMsOfficeEntity> page;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page details. */
	@Mock
	private PageDetails pageDetails;

	/** The edp ms location service. */
	@Mock
	private EDPMsLocationService edpMsLocationService;

	/** The emp spec. */
	@Mock
	private Specification<EDPMsOfficeEntity> empSpec;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The custom exception. */
	@Mock
	private CustomException customException;

	/** The edp ms office service impl. */
	@InjectMocks
	private EDPMsOfficeServiceImpl edpMsOfficeServiceImpl;

	/** The converter. */
	@Mock
	private EDPMsOfficeConverter converter;

	/** The id dto. */
	@Mock
	private IdDto idDto;

	/** The request to dto. */
	@Mock
	private ClueDto requestToDto;

	/** The edp ms office dto. */
	@Mock
	private EDPMsOfficeDto edpMsOfficeDto;

	/** The post dto. */
	@Mock
	private EDPMsPostDto postDto;

	/** The edp ms treasury repository. */
	@Mock
	private EDPMsTreasuryRepository edpMsTreasuryRepository;

	/** The edp ms district repository. */
	@Mock
	private EDPMsDistrictRepository edpMsDistrictRepository;

	/** The edp ms taluka repository. */
	@Mock
	private EDPMsTalukaRepository edpMsTalukaRepository;

	/** The edp ms module repository. */
	@Mock
	private EDPMsModuleRepository edpMsModuleRepository;

	/** The edpmsdepartmentservice. */
	@Mock
	private EDPMsDepartmentService edpmsdepartmentservice;

	/** The lookupinfoservice. */
	@Mock
	private EDPLuLookUpInfoService lookupinfoservice;

	/** The edp ms designation service. */
	@Mock
	private EDPMsDesignationService edpMsDesignationService;

	/** The district converter. */
	@Mock
	private EDPMsDistrictConverter districtConverter;

	/** The taluka converter. */
	@Mock
	private EDPMsTalukaConverter talukaConverter;

	/** The lookupinfoconverter. */
	@Mock
	private EDPLuLookUpInfoConverter lookupinfoconverter;

	/** The designationconveter. */
	@Mock
	private EDPMsDesignationConverter designationconveter;

	/** The edp ms treasury converter. */
	@Mock
	private EDPMsTreasuryConverter edpMsTreasuryConverter;

	/** The edp ms module converter. */
	@Mock
	private EDPMsModuleConverter edpMsModuleConverter;

	/** The edp ms department converter. */
	@Mock
	private EDPMsDepartmentConverter edpMsDepartmentConverter;

	/** The edp ms office converter. */
	@Mock
	private EDPMsOfficeConverter edpMsOfficeConverter;

	/** The office entity list. */
	@Mock
	private List<EDPMsOfficeEntity> officeEntityList;

	/** The designation entity list. */
	@Mock
	private List<EDPMsDesignationEntity> designationEntityList;

	/** The location entity list. */
	@Mock
	private List<EDPMsLocationEntity> locationEntityList;

	/** The lu look up info entity list. */
	@Mock
	private List<EDPLuLookUpInfoEntity> luLookUpInfoEntityList;

	/** The treasury entity list. */
	@Mock
	private List<EDPMsTreasuryEntity> treasuryEntityList;

	/** The module entity list. */
	@Mock
	private List<EDPMsModuleEntity> moduleEntityList;

	/** The edp ms department entity. */
	@Mock
	private EDPMsDepartmentEntity edpMsDepartmentEntity;

	/** The edp ms location entity. */
	@Mock
	private EDPMsLocationEntity edpMsLocationEntity;

	/** The base entity. */
	@Mock
	private BaseEntity baseEntity;

	/** The district entity list. */
	@Mock
	private List<EDPMsDistrictEntity> districtEntityList;

	/** The taluka entity list. */
	@Mock
	private List<EDPMsTalukaEntity> talukaEntityList;

	/** The clue dto list. */
	@Mock
	private List<ClueDto> clueDtoList;

	/** The oauth token post DTO. */
	@Mock
	private OAuthTokenPostDTO oauthTokenPostDTO;

	/** The postdto. */
	@Mock
	private EDPMsPostDto postdto;

	/** The financial year repository. */
	@Mock
	private EDPMsFinancialYearRepository financialYearRepository;

	/** The financial year entity. */
	@Mock
	EDPMsFinancialYearEntity financialYearEntity;

	/** The post user office repository. */
	@Mock
	private EDPLkPostUserOfficeRepository postUserOfficeRepository;

	/** The mspostentity. */
	@Mock
	private EDPMsPostEntity mspostentity;

	/** The menu repository. */
	@Mock
	private EDPMsMenuRepository menuRepository;

	/** The role permissions repository. */
	@Mock
	private EDPMsRolePermissionsRepository rolePermissionsRepository;

	/** The edp ms role permissions entity. */
	@Mock
	private EDPMsRolePermissionsEntity edpMsRolePermissionsEntity;

	/** The edp lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity edpLkPoOffUserEntity;

	/** The menu roles repository. */
	@Mock
	private EDPLkPuoMenuRolesRepository menuRolesRepository;

	/** The lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity lkPoOffUserEntity;

	/** The user repository. */
	@Mock
	private EDPMsUserRepository userRepository;

	/** The pvu employe converter. */
	@Mock
	private EDPEmployeConverter pvuEmployeConverter;

	/** The employe repository. */
	@Mock
	private EDPEmployeRepository employeRepository;

	/** The edp employe entity. */
	@Mock
	private EDPEmployeEntity edpEmployeEntity;

	/** The edp employe dto. */
	@Mock
	private EDPEmployeDto edpEmployeDto;

	/** The user converter. */
	@Mock
	private EDPMsUserConverter userConverter;

	/** The lk po off user repository. */
	@Mock
	private EDPLkPoOffUserRepository lkPoOffUserRepository;

	/** The trn user mnu role prm repository. */
	@Mock
	private EDPTrnUserMnuRolePrmRepository trnUserMnuRolePrmRepository;

	/** The office bill map service. */
	@Mock
	private EDPOfficeBillMapService officeBillMapService;

	/** The office module service. */
	@Mock
	private EDPOfficeModuleService officeModuleService;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsOfficeEntity> spec;

	/** The dto. */
	@Mock
	private ClueDto dto;

	/** The mapper. */
	private ObjectMapper mapper = new ObjectMapper();

	/** The sort. */
	@Mock
	private Sort sort;

	/** The designation repository. */
	@Mock
	private EDPMsDesignationRepository designationRepository;

	/** The edp ms post converter. */
	@Mock
	private EDPMsPostConverter edpMsPostConverter;

	/** The district repository. */
	@Mock
	private EDPMsDistrictRepository districtRepository;

	/** The edp ms user entity. */
	@Mock
	private EDPMsUserEntity edpMsUserEntity;

	/** The edp lk emp user repository. */
	@Mock
	private EDPLkEmpUserRepository edpLkEmpUserRepository;

	/** The edp lk emp user entity. */
	@Mock
	private EDPLkEmpUserEntity edpLkEmpUserEntity;

	/** The edp office bill map itr entity. */
	@Mock
	private EDPOfficeBillMapItrEntity edpOfficeBillMapItrEntity;

	/** The office bill map itr repository. */
	@Mock
	private EDPOfficeBillMapItrRepository officeBillMapItrRepository;

	/** The edp ms menu entity. */
	@Mock
	private EDPMsMenuEntity edpMsMenuEntity;

	/** The edp user role mapping repository. */
	@Mock
	private EDPUserRoleMappingRepository edpUserRoleMappingRepository;

	/** The edp user role mapping entity. */
	@Mock
	private EDPUserRoleMappingEntity edpUserRoleMappingEntity;

	/** The edp lk user menu entity. */
	@Mock
	private EDPLkUserMenuEntity edpLkUserMenuEntity;

	/** The edp trn user mnu role prm entity. */
	@Mock
	private EDPTrnUserMnuRolePrmEntity edpTrnUserMnuRolePrmEntity;

	/** The lk puo menu RLWF repository. */
	@Mock
	private EDPLkPuoMenuRLWFRepository lkPuoMenuRLWFRepository;

	/** The edp trn usr mnu wf role. */
	@Mock
	private EDPTrnUsrMnuWfRole edpTrnUsrMnuWfRole;

	/** The wf request handler. */
	@Mock
	private EDPWorkflowRequestHandler wfRequestHandler;

	/** The edp usr po trns header repository. */
	@Mock
	private EDPUsrPoTrnsHeaderRepository edpUsrPoTrnsHeaderRepository;

	/** The edp ms sub office service. */
	@Mock
	private EDPMsSubOfficeService edpMsSubOfficeService;

	/** The edp ms sub office service impl. */
	@Mock
	private EDPMsSubOfficeServiceImpl edpMsSubOfficeServiceImpl;

	/** The edp ms treasury service impl. */
	@Mock
	private EDPMsTreasuryServiceImpl edpMsTreasuryServiceImpl;

	/** The entity manager. */
	@Mock
	private EntityManager entityManager;

	/** The query. */
	@Mock
	private TypedQuery<EDPUpdateOfficeTrnEntity> query;

	/** The trn entity. */
	@Mock
	private EDPUpdateOfficeTrnEntity trnEntity;

	/** The edp office trn repository. */
	@Mock
	private EDPUpdateOfficeTrnRepository edpOfficeTrnRepository;

	/** The edp id dto. */
	@Mock
	private EDPIdDto edpIdDto;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms offices.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	@Test
	void testGetMsOffices() throws JsonParseException, JsonMappingException, IOException {

//		getEntityFromJson(JunitConstants.OfficeDetails);
		List<EDPMsOfficeEntity> entity = new ArrayList<EDPMsOfficeEntity>();
		entity.add(edpMsOfficeEntity);
		when(repository.findAll()).thenReturn(entity);
		assertEquals(entity, edpMsOfficeServiceImpl.getMsOffices());
		verify(repository, times(1)).findAll();

	}

	/**
	 * Gets the entity from json.
	 *
	 * @param jsonName the json name
	 * @return the entity from json
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	private void getEntityFromJson(String jsonName) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		File file = new File(JunitConstants.RELATIVE_PATH.concat(jsonName));
		edpMsOfficeEntity = mapper.readValue(file, EDPMsOfficeEntity.class);

	}

	/**
	 * Test save or update ms office.
	 *
	 * @throws CustomException      the custom exception
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testSaveOrUpdateMsOffice() throws CustomException, JsonParseException, JsonMappingException, IOException {
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(Constant.LOOKUP_TRUE_VALUE))
				.thenReturn(financialYearEntity);
		when(edpMsOfficeDto.getMenuShName()).thenReturn(JunitConstants.STRING_MENU_SH_NAME);
		when(repository.findLastTransactionNumber(JunitConstants.STRING_MENU_SH_NAME))
				.thenReturn(JunitConstants.LONG_TYPE);
		when(postDto.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeDto.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findMaxCardexNoUsingDistrictId(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeDto.getCardexno()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(districtRepository.findByDistrictIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpMsDistrictEntity);
		when(edpMsDistrictEntity.getDistrictCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeDto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_OFFICE_ID);
		when(repository.findById(JunitConstants.LONG_OFFICE_ID)).thenReturn(Optional.of(edpMsOfficeEntity));
		when(repository.save(edpMsOfficeEntity)).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getPvuId()).thenReturn(JunitConstants.LONG_ZERO);
		when(officeItrConverter.toEntity(edpMsOfficeEntity)).thenReturn(edpOfficeItrEntity);
		when(officeItrRepository.save(edpOfficeItrEntity)).thenReturn(edpOfficeItrEntity);
		when(edpMsOfficeDto.getIsNewOffice()).thenReturn(JunitConstants.TRUE);

		when(edpMsOfficeEntity.getDesgDdoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(designationRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(edpMsDesignationEntity));
		when(edpMsDesignationEntity.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		when(postRepository.save(Mockito.any(EDPMsPostEntity.class))).thenReturn(mspostentity);
		when(postUserOfficeRepository.save(Mockito.any(EDPLkPostOfficeEntity.class))).thenReturn(edpLkPostOfficeEntity);
		when(edpMsOfficeEntity.getEmployeeNo()).thenReturn(JunitConstants.LONG_STRING);
		when(userRepository.findByUserCodeAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpMsUserEntity);
		when(employeRepository.findByEmployeeCodeAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(Optional.of(edpEmployeEntity));
		when(pvuEmployeConverter.toDTO(edpEmployeEntity)).thenReturn(edpEmployeDto);
		when(userRepository.save(edpMsUserEntity)).thenReturn(edpMsUserEntity);
		when(edpLkEmpUserRepository.findByUserIdUserCodeAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(Optional.empty());
		when(edpMsUserEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList = new ArrayList<>();
		edpLkPoOffUserEntityList.add(edpLkPoOffUserEntity);
		when(lkPoOffUserRepository.findByUserIdUserIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpLkPoOffUserEntityList);
		when(lkPoOffUserRepository.save(Mockito.any(EDPLkPoOffUserEntity.class))).thenReturn(edpLkPoOffUserEntity);
		List<EDPMsMenuEntity> edpMsMenuEntityList = new ArrayList<>();
		edpMsMenuEntityList.add(edpMsMenuEntity);
		when(menuRepository.findByActiveStatusAndMenuNameIn(Mockito.anyInt(), Mockito.anySet()))
				.thenReturn(edpMsMenuEntityList);
		List<EDPMsRolePermissionsEntity> edpMsRolePermissionsEntityList = new ArrayList<>();
		edpMsRolePermissionsEntityList.add(edpMsRolePermissionsEntity);
		when(rolePermissionsRepository.findByRolePrmNameIn(Mockito.anySet()))
				.thenReturn(edpMsRolePermissionsEntityList);
		when(edpLkPoOffUserEntity.getUserId()).thenReturn(edpMsUserEntity);
		when(edpMsUserEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkEmpUserRepository.findByUserIdUserIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpLkEmpUserEntity);
		when(edpLkEmpUserEntity.getEmpId()).thenReturn(edpEmployeEntity);
		when(edpEmployeEntity.getEmpId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpUserRoleMappingRepository.save(Mockito.any(EDPUserRoleMappingEntity.class)))
				.thenReturn(edpUserRoleMappingEntity);
		when(financialYearRepository.findByIsCurrentYearLookUpInfoName(Constant.LOOKUP_YES))
				.thenReturn(financialYearEntity);
		when(edpUserRoleMappingEntity.getUserRoleMappingId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsMenuEntity.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(menuRolesRepository.save(Mockito.any(EDPLkUserMenuEntity.class))).thenReturn(edpLkUserMenuEntity);
		when(edpMsRolePermissionsEntity.getRoleActivityId()).thenReturn(JunitConstants.LONG_TYPE);
		when(trnUserMnuRolePrmRepository.save(Mockito.any(EDPTrnUserMnuRolePrmEntity.class)))
				.thenReturn(edpTrnUserMnuRolePrmEntity);
		when(lkPuoMenuRLWFRepository.save(Mockito.any(EDPTrnUsrMnuWfRole.class))).thenReturn(edpTrnUsrMnuWfRole);
		when(edpMsOfficeEntity.getOfficeStatus()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getOfficeTypeId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(EDPConstant.HOD_ID);
		when(edpMsOfficeDto.getWfInRequest()).thenReturn(EDPConstant.LOOKUP_INFO_YES);
		when(edpOfficeItrEntity.getWfInRequest()).thenReturn(EDPConstant.LOOKUP_INFO_YES);
		when(edpMsOfficeDto.getWfFinalSubmit()).thenReturn(EDPConstant.LOOKUP_INFO_YES);
		when(edpMsOfficeDto.getIsNewOffice()).thenReturn(JunitConstants.TRUE);
		List<Object[]> responseList1 = new ArrayList<>();
		Object[] obj1 = new Object[1];
		obj1[0] = JunitConstants.STRING_TYPE;
		responseList1.add(obj1);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.any(Map.class))).thenReturn(responseList1);
		when(edpMsOfficeDto.getTransactionNo()).thenReturn(JunitConstants.STRING_NULL);
		assertNotNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity, JunitConstants.TRUE,
				JunitConstants.TRUE, edpMsOfficeDto));
		when(userRepository.findByUserCodeAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(null);
		when(edpMsUserEntity.getUserCode()).thenReturn(JunitConstants.LONG_TYPE);
		when(officeItrRepository.findLastTransactionNumber(JunitConstants.STRING_TYPE))
				.thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_OFFICE_ID1);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(userConverter.employeeToUserDto(pvuEmployeConverter.toClueDto(edpEmployeEntity)))
				.thenReturn(edpMsUserEntity);
		when(userRepository.save(edpMsUserEntity)).thenReturn(edpMsUserEntity);
		when(edpMsUserEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeDto.getWfInRequest()).thenReturn(EDPConstant.LOOKUP_INFO_NO);
		when(edpMsOfficeDto.getWfFinalSubmit()).thenReturn(EDPConstant.LOOKUP_INFO_NO);
		assertNotNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity, JunitConstants.TRUE,
				JunitConstants.TRUE, edpMsOfficeDto));
		when(edpMsOfficeDto.getIsNewOffice()).thenReturn(JunitConstants.FALSE);
		when(edpMsOfficeDto.getMenuShName()).thenReturn(JunitConstants.STRING_MENU_SH_NAME);
		assertNotNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity, JunitConstants.TRUE,
				JunitConstants.TRUE, edpMsOfficeDto));
		when(edpMsOfficeDto.getMenuShName()).thenReturn(JunitConstants.STRING_TYPE);
		List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList1 = new ArrayList<>();
		when(lkPoOffUserRepository.findByUserIdUserIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpLkPoOffUserEntityList1);
		assertNotNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity, JunitConstants.TRUE,
				JunitConstants.TRUE, edpMsOfficeDto));
		when(edpMsOfficeDto.getWfInRequest()).thenReturn(EDPConstant.LOOKUP_INFO_YES);
		when(edpMsOfficeDto.getWfFinalSubmit()).thenReturn(EDPConstant.LOOKUP_INFO_YES);
		when(edpMsOfficeDto.getIsNewOffice()).thenReturn(JunitConstants.TRUE);
		List<Object[]> responseList = new ArrayList<>();
		Object[] obj = new Object[1];
		obj[0] = JunitConstants.STRING_TYPE;
		responseList.add(obj);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.any(Map.class))).thenReturn(responseList);
		assertNotNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity, JunitConstants.TRUE,
				JunitConstants.FALSE, edpMsOfficeDto));
		when(edpMsOfficeDto.getWfInRequest()).thenReturn(EDPConstant.LOOKUP_INFO_NO);
		when(edpMsOfficeDto.getWfStatus()).thenReturn(EDPConstant.LK_STATUS_VAL_REJECTED);
		assertNotNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity, JunitConstants.TRUE,
				JunitConstants.FALSE, edpMsOfficeDto));
		when(edpMsOfficeDto.getWfStatus()).thenReturn(EDPConstant.LK_STATUS_VAL_CANCELLED);
		assertNotNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity, JunitConstants.TRUE,
				JunitConstants.FALSE, edpMsOfficeDto));
	}

	/**
	 * Test save or update ms office excption.
	 *
	 * @throws Exception            the exception
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	// @Test
	public void testSaveOrUpdateMsOffice_Excption()
			throws Exception, JsonParseException, JsonMappingException, IOException {
		try {
			getEntityFromJson(JunitConstants.OfficeDetails);
			ObjectMapper mapper = new ObjectMapper();
			File file1 = new File(JunitConstants.RELATIVE_PATH.concat(JunitConstants.getDesignationDetails));
			edpMsDesignationEntity = mapper.readValue(file1, EDPMsDesignationEntity.class);
			List<EDPMsOfficeEntity> entity = new ArrayList<EDPMsOfficeEntity>();
			edpMsOfficeEntity.setDistrictId(null);
			entity.add(edpMsOfficeEntity);
			when(repository.save(edpMsOfficeEntity)).thenReturn(edpMsOfficeEntity);
			// when(MessageUtil.getMsg("ERRORRESP.ERROR_WHILE_CREATE")).thenReturn("Error");
			when(edpMsDesignationRepository.findById(edpMsOfficeEntity.getDesgDdoId()))
					.thenReturn(Optional.of(edpMsDesignationEntity));
			// edpMsOfficeEntity.setTransactionNo(null);
			// when(logger.error(e.getMessage(), e))
			// assertNull(edpMsOfficeServiceImpl.saveOrUpdateMsOffice(edpMsOfficeEntity,
			// true, false, "NOC"));
		} catch (Exception e) {
		}
	}

	/**
	 * Test edp ms office as method name search.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsOfficeAsMethodNameSearch() throws Exception {
		when(pageDetails.getPageDetails(pageDetails)).thenReturn(pageable);
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		SearchParam sp = new SearchParam();
		sp.setKey(JunitConstants.STRING_TYPE);
		sp.setValue(JunitConstants.STRING_TYPE);
		jsonArr.add(sp);
		when(pageDetails.getJsonArr()).thenReturn(jsonArr);
		when(searchCriteria.getSpecificationDetails(spec, jsonArr)).thenReturn(empSpec);
		when(repository.findAll(empSpec, pageable)).thenReturn(page);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(edpMsOfficeServiceImpl.edpMsOfficeAsMethodNameSearch(pageDetails));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test find office by post id.
	 */
	@Test
	void testFindOfficeByPostId() {
		List<EDPLkPoOffUserEntity> listPostId = new ArrayList<>();
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeTypeId()).thenReturn(lookUpInfoEntity);
		when(lookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TYPE);
		listPostId.add(edpLkPoOffUserEntity);
		when(lkPoOffUserRepository.findByUserIdUserIdAndLkPostOfficeIdPostEntityPostIdAndActiveStatus(
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(listPostId);
		assertNotNull(edpMsOfficeServiceImpl.findOfficeByPostId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE));

	}

	/**
	 * Test find id code estimation from.
	 */
	@Test
	void testFindIdCodeEstimationFrom() {
		List<EDPLuLookUpInfoEntity> lookUpInfoEnties = new ArrayList<EDPLuLookUpInfoEntity>();
		lookUpInfoEnties.add(lookUpInfoEntity);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Constant.LOOKUP_NAME_OFFICE_TYPE,
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_ASC)))
						.thenReturn(lookUpInfoEnties);
		when(lookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(edpMsOfficeServiceImpl.findIdCodeEstimationFrom());
	}

	/**
	 * Test get next cardex no.
	 */
	@Test
	void testGetNextCardexNo() {
		when(repository.findMaxCardexNoUsingDistrictId(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LONG_TYPE);
		ClueDto dto = edpMsOfficeServiceImpl.getNextCardexNo(JunitConstants.LONG_TYPE);
		assertEquals(JunitConstants.CARDEX_NO, dto.getId());
		when(repository.findMaxCardexNoUsingDistrictId(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LONG_NULL);
		ClueDto dto1 = edpMsOfficeServiceImpl.getNextCardexNo(JunitConstants.LONG_TYPE);
		assertEquals(JunitConstants.LONG_TYPE, dto1.getId());

	}

	/**
	 * Test update active status.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testUpdateActiveStatus() throws Exception {
		edpMsOfficeServiceImpl.updateActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository).updateActiveStatusByOfficeId(Mockito.any(Long.class), Mockito.any(Integer.class),
				Mockito.any(Long.class), Mockito.any(java.util.Date.class));
	}

	/**
	 * Test get office details.
	 *
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 */
	@Test
	@Disabled
	void testGetOfficeDetails() throws IOException, JsonParseException, JsonMappingException {
		File file1 = new File(JunitConstants.RELATIVE_PATH.concat(JunitConstants.GetDistrictDetails));
		File file2 = new File(JunitConstants.RELATIVE_PATH.concat(JunitConstants.GetTalukaDetails));
		List<ClueDto> list1 = new ArrayList<ClueDto>();
		List<ClueDto> list2 = new ArrayList<ClueDto>();
		list1.add(mapper.readValue(file1, ClueDto.class));
		list2.add(mapper.readValue(file2, ClueDto.class));
		when(edpMsDistrictRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
				EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC)))
						.thenReturn(districtEntityList);
		when(edpMsTalukaRepository.findByActiveStatus(Constant.ACTIVE_STATUS,
				EDPUtility.getJpaSort(EDPConstant.TALUKA_NAME, EDPConstant.ORDER_ASC))).thenReturn(talukaEntityList);
		when(districtConverter.toClueDTO(districtEntityList)).thenReturn(list1);
		when(talukaConverter.toClueDTO(talukaEntityList)).thenReturn(list2);

		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);

		when(lookupinfoservice.findByLookUpName(EDPConstant.FIND_LEVEL)).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(lookupinfoservice.findByLookUpName(EDPConstant.FIND_OFFICE_TYPE)).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(lookupinfoservice.findByLookUpName(EDPConstant.FIND_PVU)).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_CONDITIONCHECK))
				.thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(lookupinfoservice.findByLookUpName(EDPConstant.FIND_REQUESTTO)).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoservice.findByLookUpName(requestToDto.getName())).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(designationconveter.toClueDTO(designationEntityList)).thenReturn(clueDtoList);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(OAuthConstant.LOOK_UP_INFO_NAME_YES))
				.thenReturn(edpLuLookUpInfoEntity);
		when(postdto.getOauthTokenPostDTO()).thenReturn(oauthTokenPostDTO);
		when(oauthTokenPostDTO.getEdpMsOfficeDto()).thenReturn(edpMsOfficeDto);
		when(edpMsOfficeDto.getDepartmentId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpmsdepartmentservice.getMsDepartment(JunitConstants.LONG_TYPE)).thenReturn(edpMsDepartmentEntity);
		when(edpMsDepartmentConverter.toClueDTO(edpMsDepartmentEntity)).thenReturn(requestToDto);
		when(edpMsOfficeDto.getIsHod()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeConverter.toClueDTO(edpMsOfficeDto)).thenReturn(requestToDto);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(designationRepository.findByStatusIdLookUpInfoNameOrStatusIdIsNullAndActiveStatus(Mockito.anyString(),
				Mockito.anyInt(), Mockito.any(Sort.class))).thenReturn(designationEntityList);
		when(repository.findByIsCoAndActiveStatusAndStatusId(edpLuLookUpInfoEntity.getLookUpInfoId(),
				Constant.ACTIVE_STATUS, (short) edpLuLookUpInfoEntity.getLookUpInfoId(),
				EDPUtility.getJpaSort(EDPConstant.OFFICE_NAME, EDPConstant.ORDER_ASC))).thenReturn(officeEntityList);
		when(converter.toClueDTO(officeEntityList)).thenReturn(clueDtoList);
		when(edpMsTreasuryRepository.findAll()).thenReturn(treasuryEntityList);
		when(edpMsTreasuryConverter.toClueDTO(treasuryEntityList)).thenReturn(clueDtoList);
		when(edpMsModuleRepository.findAll()).thenReturn(moduleEntityList);
		when(edpMsModuleConverter.toClueDTO(moduleEntityList)).thenReturn(clueDtoList);
		when(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_BILLTYPE)).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_STATUSID)).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_LISTOFBILL)).thenReturn(luLookUpInfoEntityList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(clueDtoList);
		when(lookupinfoconverter.toClueDTO(luLookUpInfoEntityList)).thenReturn(list2);
		EDPOfficeDetailsDto officedetailsdto = edpMsOfficeServiceImpl.getOfficeDetails();
		assertNotNull(officedetailsdto.getDistricts());
		assertNotNull(officedetailsdto.getLevel());
		assertNotNull(officedetailsdto.getOfficeType());
		assertNotNull(officedetailsdto.getPvu());
		assertNotNull(officedetailsdto.getControllingOffice());
		assertNotNull(officedetailsdto.getRequestTos());
		assertNotNull(officedetailsdto.getDesignationOfDdo());
		assertNotNull(officedetailsdto.getCoOffice());
	}

	/**
	 * Test find office by id.
	 */
	@Test
	@Order(1)
	void testFindOfficeById() {
		List<EDPLkPoOffUserEntity> listPostId = new ArrayList<>();
		listPostId.add(edpLkPoOffUserEntity);
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(lkPoOffUserRepository
				.findByUserIdUserIdAndLkPostOfficeIdPostEntityPostIdAndLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(
						JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
						Constant.ACTIVE_STATUS)).thenReturn(listPostId);
		assertNotNull(edpMsOfficeServiceImpl.findOfficeById(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE));
	}

	/**
	 * Test save ms offices.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	@Test
	void testSaveMsOffices() throws JsonParseException, JsonMappingException, IOException {
		List<EDPMsOfficeEntity> entities = new ArrayList<>();
		when(repository.saveAll(entities)).thenReturn((List<EDPMsOfficeEntity>) entities);
		assertEquals(entities, edpMsOfficeServiceImpl.saveMsOffices(entities));
		verify(repository, times(1)).saveAll(entities);
	}

	/**
	 * Test get ms office.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	@Test
	void testGetMsOffice() throws JsonParseException, JsonMappingException, IOException {
		when(repository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE))
				.thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeConverter.toDTO(edpMsOfficeEntity)).thenReturn(edpMsOfficeDto);
		when(edpMsOfficeEntity.getIsUpdate()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(EDPConstant.LOOKUP_INFO_YES);
		List<EDPOfficeBillMapItrEntity> billMapEntitiesItr = new ArrayList<>();
		billMapEntitiesItr.add(edpOfficeBillMapItrEntity);
		when(officeBillMapItrRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(billMapEntitiesItr);
		List<EDPOfficeBillMapEntity> billMapEntities = new ArrayList<>();
		billMapEntities.add(billMapEntity);
		when(officeBillMapRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(billMapEntities);
		List<EDPOfficeModuleEntity> officeModuleEntities = new ArrayList<>();
		officeModuleEntities.add(officeModuleEntity);
		when(officeModuleRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(officeModuleEntities);
		when(edpMsOfficeEntity.getIsCo()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookUpInfoRepository.findBylookUpInfoId(JunitConstants.LONG_TYPE)).thenReturn(edpLuLookUpInfoEntity);
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getHodId()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(edpMsOfficeEntity.getCoId()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(designationRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(edpMsDesignationEntity));
		when(edpMsOfficeEntity.getDesgDdoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getOfficeName()).thenReturn(JunitConstants.STRING_TYPE);
		when(officeItrRepository.findLastApprovedOfficeStatus(JunitConstants.LONG_TYPE))
				.thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(edpMsOfficeServiceImpl.getMsOffice(JunitConstants.LONG_TYPE));
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getIsCo()).thenReturn(JunitConstants.LONG_NULL);
		when(designationRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNotNull(edpMsOfficeServiceImpl.getMsOffice(JunitConstants.LONG_TYPE));
		verify(repository, times(2)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test delete ms office.
	 *
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 */
	@Test
	void testDeleteMsOffice() throws IOException, JsonParseException, JsonMappingException {
//		getIdFromJson(JunitConstants.GetId);
		edpMsOfficeServiceImpl.deleteMsOffice(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Update active status.
	 *
	 * @throws Exception the exception
	 */
	// @Test(expected = CustomException.class)
	public void updateActiveStatus_() throws Exception {
		when(OAuthUtility.getCurrentUserUserId()).thenReturn(10l);
		when(repository.updateActiveStatusByOfficeId(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE,
				JunitConstants.LONG_TYPE, Mockito.spy(new Date())))
						.thenThrow(new Exception(JunitConstants.STRING_TYPE));
		edpMsOfficeServiceImpl.updateActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
	}

	/**
	 * Test get district wise office details.
	 */
	@Test
	void testGetDistrictWiseOfficeDetails() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPMsOfficeEntity> msOfficeEntityList = new ArrayList<>();
		msOfficeEntityList.add(edpMsOfficeEntity);
		when(repository.findByStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(
				JunitConstants.SHORT_TYPE, JunitConstants.LONG_ZERO, OAuthConstant.ACTIVE_STATUS))
						.thenReturn(msOfficeEntityList);
		List<EDPMsDistrictEntity> allDistrictEntity = new ArrayList<>();
		allDistrictEntity.add(edpMsDistrictEntity);
		when(edpMsDistrictRepository.findByActiveStatusAndStateId(OAuthConstant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
				EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))).thenReturn(allDistrictEntity);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsDistrictEntity.getDistrictName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		assertNotNull(edpMsOfficeServiceImpl.getDistrictWiseOfficeDetails());
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED)).thenReturn(null);
		assertNotNull(edpMsOfficeServiceImpl.getDistrictWiseOfficeDetails());
	}

	/**
	 * Test get all departments with hod.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAllDepartmentsWithHod() throws CustomException {
		List<EDPLuLookUpInfoEntity> approveLookUpInfo = new ArrayList<>();
		approveLookUpInfo.add(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoRepository.findByLookUpInfoNameIn(Mockito.anySet())).thenReturn(approveLookUpInfo);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES))
				.thenReturn(edpLuLookUpInfoEntity);
		List<EDPMsOfficeEntity> listMsOffices = new ArrayList<>();
		listMsOffices.add(edpMsOfficeEntity);
		when(repository.findAllHodOffice(Mockito.anySet(), Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(listMsOffices);
		List<ClueDto> departmentClueDtoList = new ArrayList<>();
		departmentClueDtoList.add(dto);
		when(edpmsdepartmentservice.getAllCodeAndId()).thenReturn(departmentClueDtoList);
		when(dto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDepartmentId()).thenReturn(edpMsDepartmentEntity);
		when(edpMsDepartmentEntity.getDepartmentId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(edpMsOfficeServiceImpl.getAllDepartmentsWithHod());
	}

	/**
	 * Test get by departments with hod.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetByDepartmentsWithHod() throws CustomException {
		List<EDPLuLookUpInfoEntity> luLookUpInfoEntityList = new ArrayList<>();
		luLookUpInfoEntityList.add(lookUpInfoEntity);
		when(edpLuLookUpInfoRepository.findByLookUpInfoNameIn(Mockito.anySet())).thenReturn(luLookUpInfoEntityList);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES)).thenReturn(lookUpInfoEntity);
		when(lookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPMsOfficeEntity> edpMsOfficeEntityList = new ArrayList<>();
		edpMsOfficeEntityList.add(edpMsOfficeEntity);
		when(repository.findAllHodOffice(Mockito.anySet(), Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(edpMsOfficeEntityList);
		when(edpMsOfficeEntity.getDepartmentId()).thenReturn(edpMsDepartmentEntity);
		when(edpMsDepartmentEntity.getDepartmentId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(edpMsOfficeServiceImpl.getByDepartmentsWithHod(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test to look up info clue DTO.
	 */
	@Test
	void testToLookUpInfoClueDTO() {
		List<EDPLuLookUpInfoEntity> edpLuLookUpInfoEntityList = new ArrayList<>();
		edpLuLookUpInfoEntityList.add(lookUpInfoEntity);
		when(lookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_SAVE_AS_DRAFT);
		when(lookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(edpMsOfficeServiceImpl.toLookUpInfoClueDTO(edpLuLookUpInfoEntityList));
	}

	/**
	 * Test get offices by flag list.
	 */
	@Test
	void testGetOfficesByFlagList() {
		ClueDto name = new ClueDto();
		name.setName(EDPConstant.FL_PVU);

		ClueDto name1 = new ClueDto();
		name1.setName(EDPConstant.FL_PVU);
		ClueDto name2 = new ClueDto();
		name2.setName(EDPConstant.FL_PVU);
		ClueDto name3 = new ClueDto();
		name3.setName(EDPConstant.FL_PVU);
		ClueDto name4 = new ClueDto();
		name4.setName(EDPConstant.FL_PVU);
		ClueDto name5 = new ClueDto();
		name5.setName(EDPConstant.FL_PVU);
		ClueDto name6 = new ClueDto();
		name6.setName(EDPConstant.FL_PVU);
		List<ClueDto> names = new ArrayList<>();
		names.add(name6);
		names.add(name5);
		names.add(name4);
		names.add(name3);
		names.add(name2);
		names.add(name1);

		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Mockito.anyString())).thenReturn(lookUpInfoEntity);
		when(repository.findByOfficePVUAndStatusIdAndOfficeStatusAndActiveStatus(Mockito.anyString(),
				Mockito.anyShort(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(edpMsOfficeEntity);
		assertNotNull(edpMsOfficeServiceImpl.getOfficesByFlagList(names));
	}

	/**
	 * Test get offices by district.
	 */
	@Test
	void testGetOfficesByDistrict() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Mockito.anyString())).thenReturn(edpLuLookUpInfoEntity);
		List<EDPMsOfficeEntity> officesEntity = new ArrayList<>();
		officesEntity.add(edpMsOfficeEntity);
		when(repository.findByDistrictIdDistrictIdAndStatusIdAndOfficeStatusAndActiveStatus(Mockito.anyLong(),
				Mockito.anyShort(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(officesEntity);
		assertNotNull(edpMsOfficeServiceImpl.getOfficesByDistrict(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get CO list by hod office id.
	 */
	@Test
	void testGetCOListByHodOfficeId() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Mockito.anyString())).thenReturn(edpLuLookUpInfoEntity);
		List<EDPMsOfficeEntity> officesEntity = new ArrayList<>();
		officesEntity.add(edpMsOfficeEntity);
		when(repository.findByParentOfficeIdAndIsCoAndStatusIdAndOfficeStatusAndActiveStatus(Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyShort(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(officesEntity);
		assertNotNull(edpMsOfficeServiceImpl.getCOListByHodOfficeId(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get by office type by office type id.
	 */
	@Test
	void testGetByOfficeTypeByOfficeTypeId() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Mockito.anyString())).thenReturn(edpLuLookUpInfoEntity);
		List<EDPMsOfficeEntity> officesEntity = new ArrayList<>();
		officesEntity.add(edpMsOfficeEntity);
		when(repository.findByOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatus(Mockito.anyLong(),
				Mockito.anyShort(), Mockito.anyLong(), Mockito.anyInt(), Mockito.any(Sort.class)))
						.thenReturn(officesEntity);
		assertNotNull(edpMsOfficeServiceImpl.getByOfficeTypeByOfficeTypeId(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get fd office.
	 */
	@Test
	void testGetFdOffice() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Mockito.anyString())).thenReturn(edpLuLookUpInfoEntity);
		List<EDPMsOfficeEntity> officesEntity = new ArrayList<>();
		officesEntity.add(edpMsOfficeEntity);
		when(repository.findByOfficeTypeIdLookUpInfoIdAndIsFdAndCardexnoAndStatusIdAndOfficeStatusAndActiveStatus(
				Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyShort(), Mockito.anyLong(),
				Mockito.anyInt())).thenReturn(officesEntity);
		assertNotNull(edpMsOfficeServiceImpl.getFdOffice());
	}

	/**
	 * Test get parent office.
	 */
	@Test
	void testGetParentOffice() {
		when(repository.findByOfficeIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getParentOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(converter.toDTO(Mockito.any(EDPMsOfficeEntity.class))).thenReturn(edpMsOfficeDto);
		assertNotNull(edpMsOfficeServiceImpl.getParentOffice(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get child office list.
	 */
	@Test
	void testGetChildOfficeList() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Mockito.anyString())).thenReturn(edpLuLookUpInfoEntity);
		List<EDPMsOfficeEntity> officesEntity = new ArrayList<>();
		officesEntity.add(edpMsOfficeEntity);
		when(repository.findByParentOfficeIdAndStatusIdAndOfficeStatusAndActiveStatus(Mockito.anyLong(),
				Mockito.anyShort(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(officesEntity);
		assertNotNull(edpMsOfficeServiceImpl.getChildOfficeList(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get HOD list basedon department office.
	 */
	@Test
	void testGetHODListBasedonDepartmentOffice() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Mockito.anyString())).thenReturn(edpLuLookUpInfoEntity);
		List<EDPMsOfficeEntity> officesEntity = new ArrayList<>();
		officesEntity.add(edpMsOfficeEntity);
		when(repository.findByParentOfficeIdAndIsHodAndStatusIdAndOfficeStatusAndActiveStatus(Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyShort(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(officesEntity);
		assertNotNull(edpMsOfficeServiceImpl.getHODListBasedonDepartmentOffice(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get office by district dto.
	 */
	@Test
	void testGetOfficeByDistrictDto() {
		Object[] object = new Object[6];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_TYPE;
		object[2] = JunitConstants.STRING_TYPE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_TYPE;
		Long districtId = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		assertNotNull(edpMsOfficeServiceImpl.getOfficeByDistrictDto(objects, districtId));
	}

	/**
	 * Test get office by district and pvu id.
	 */
	@Test
	void testGetOfficeByDistrictAndPvuId() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpMsOfficeDto.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeDto.getPvuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByDistrictIdDistrictIdAndPvuIdAndStatusIdAndOfficeStatusAndActiveStatus(
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.SHORT_TYPE, JunitConstants.LONG_TYPE,
				1)).thenReturn(officeEntityList);
		when(edpMsOfficeDto.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(edpMsOfficeServiceImpl.getOfficeByDistrictAndPvuId(edpMsOfficeDto));

		when(edpMsOfficeDto.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByDistrictIdDistrictIdAndStatusIdAndOfficeStatusAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.SHORT_TYPE, JunitConstants.LONG_TYPE, 1)).thenReturn(officeEntityList);
		assertNotNull(edpMsOfficeServiceImpl.getOfficeByDistrictAndPvuId(edpMsOfficeDto));

		when(edpMsOfficeDto.getPvuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeDto.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByPvuIdAndStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(
				JunitConstants.LONG_TYPE, JunitConstants.SHORT_TYPE, JunitConstants.LONG_TYPE, 1))
						.thenReturn(officeEntityList);
		assertNotNull(edpMsOfficeServiceImpl.getOfficeByDistrictAndPvuId(edpMsOfficeDto));
		when(edpMsOfficeDto.getPvuId()).thenReturn(JunitConstants.LONG_NULL);
		when(repository.findByStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(
				JunitConstants.SHORT_TYPE, JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
						.thenReturn(officeEntityList);
		assertNotNull(edpMsOfficeServiceImpl.getOfficeByDistrictAndPvuId(edpMsOfficeDto));
		when(edpMsOfficeDto.getDistrictId()).thenReturn(JunitConstants.LONG_NULL);
		assertNotNull(edpMsOfficeServiceImpl.getOfficeByDistrictAndPvuId(edpMsOfficeDto));
		when(edpMsOfficeDto.getPvuId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(edpMsOfficeServiceImpl.getOfficeByDistrictAndPvuId(edpMsOfficeDto));
	}

	/**
	 * Test search for office history report.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSearchForOfficeHistoryReport() throws CustomException {
		StringBuilder stringBuilder = new StringBuilder();
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
		assertNotNull(edpMsOfficeServiceImpl.searchForOfficeHistoryReport(pageDetails));
		when(pageDetails.getJsonArr()).thenReturn(null);
		assertNotNull(edpMsOfficeServiceImpl.searchForOfficeHistoryReport(pageDetails));
	}

	/**
	 * Test update ms office.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testUpdateMsOffice() throws CustomException {
		when(converter.toEntity(edpMsOfficeDto)).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPUpdateOfficeTrnEntity> result = new ArrayList<>();
		result.add(trnEntity);
		when(entityManager.createQuery(
				"SELECT trn FROM EDPUpdateOfficeTrnEntity trn WHERE trn.msOfficeEntity.officeId = :officeId "
						+ "AND trn.activeStatus = :activeStatus ORDER BY trn.updOffcTrnId DESC",
				EDPUpdateOfficeTrnEntity.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(result);
		when(edpMsOfficeDto.getTransactionNo()).thenReturn(JunitConstants.STRING_NULL);
		List<Object[]> responseList = new ArrayList<>();
		Object[] obj = new Object[1];
		obj[0] = JunitConstants.STRING_TYPE;
		responseList.add(obj);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.any(Map.class))).thenReturn(responseList);
		when(edpMsOfficeDto.getHodId()).thenReturn((int) EDPConstant.HOD_ID);
		when(edpMsOfficeDto.getOfficeTypeId()).thenReturn(EDPConstant.DDO_TYPE_ID);
		when(edpMsOfficeDto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(EDPConstant.DAT_OFFICE_ID);
		when(officeItrConverter.toEntity(edpMsOfficeEntity)).thenReturn(edpOfficeItrEntity);
		when(officeItrRepository.save(edpOfficeItrEntity)).thenReturn(edpOfficeItrEntity);
		when(edpOfficeItrEntity.getOfficeTrnEntity()).thenReturn(trnEntity);
		assertNotNull(edpMsOfficeServiceImpl.updateMsOffice(edpMsOfficeDto));
		when(edpMsOfficeEntity.getOfficeTypeId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(EDPConstant.HOD_ID);
		when(edpMsOfficeDto.getOfficeId()).thenReturn(JunitConstants.LONG_ZERO);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_OFFICE_ID1);
		assertNotNull(edpMsOfficeServiceImpl.updateMsOffice(edpMsOfficeDto));
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getCardexno()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeDto.getWfStatus()).thenReturn(EDPConstant.LK_STATUS_VAL_APPROVED);
		when(edpMsOfficeDto.getWfInRequest()).thenReturn(EDPConstant.LOOKUP_INFO_YES);
		when(districtRepository.findByDistrictIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(edpMsDistrictEntity);
		when(repository.save(edpMsOfficeEntity)).thenReturn(edpMsOfficeEntity);
		edpMsOfficeServiceImpl.approveOfficeUpdate(edpMsOfficeDto);
		when(edpMsOfficeDto.getWfInRequest()).thenReturn(EDPConstant.LOOKUP_INFO_NO);
		edpMsOfficeServiceImpl.approveOfficeUpdate(edpMsOfficeDto);
		when(edpMsOfficeDto.getWfStatus()).thenReturn(EDPConstant.LK_STATUS_VAL_REJECTED);
		edpMsOfficeServiceImpl.approveOfficeUpdate(edpMsOfficeDto);
		when(edpMsOfficeDto.getWfStatus()).thenReturn(EDPConstant.LK_STATUS_VAL_CANCELLED);
		edpMsOfficeServiceImpl.approveOfficeUpdate(edpMsOfficeDto);
		assertNotNull(edpMsOfficeServiceImpl.getBillsByOfficeId(JunitConstants.LONG_TYPE));
		assertNotNull(edpMsOfficeServiceImpl.getOfficesAndStatusByDistrict(JunitConstants.LONG_TYPE,
				JunitConstants.STRING_TYPE, JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE));
		assertNotNull(edpMsOfficeServiceImpl.checkWfStatus(edpIdDto));
	}

	/**
	 * Test check ddo no by district id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testCheckDdoNoByDistrictId() throws CustomException {
		List<String> ddoNos = new ArrayList<>();
		ddoNos.add(JunitConstants.STRING_TYPE);
		when(repository.findDdoNoByDistrictIdDistrictIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(ddoNos);
		assertNotNull(
				edpMsOfficeServiceImpl.checkDdoNoByDistrictId(JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE));
	}

	/**
	 * Test get master office details.
	 */
	@Test
	void testGetMasterOfficeDetails() {
		when(repository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE))
				.thenReturn(edpMsOfficeEntity);
		List<EDPOfficeBillMapEntity> billMapEntitiesItr = new ArrayList<>();
		billMapEntitiesItr.add(billMapEntity);
		when(edpMsOfficeConverter.toDTO(edpMsOfficeEntity)).thenReturn(edpMsOfficeDto);
		when(officeBillMapRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(billMapEntitiesItr);
		when(billMapEntity.getBillSubmittedTo()).thenReturn(JunitConstants.LONG_TYPE);
		when(billMapEntity.getBillType()).thenReturn(JunitConstants.LONG_TYPE);
		when(billMapEntity.getBillListId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getHodId()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(repository.getOne(JunitConstants.INTEGER_TYPE.longValue())).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeTransferId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE))
				.thenReturn(edpMsOfficeEntity);
		assertNotNull(edpMsOfficeServiceImpl.getMasterOfficeDetails(JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetTrsPaoOffices() {
		List<EDPMsOfficeEntity> trsOffices = new ArrayList<>();

		when(idDto.getId()).thenReturn(EDPConstant.DISTRICT_AHMEDABAD_PAO_ID);
		when(repository.findTrsPaoOfficesByDist(Mockito.anySet(), Mockito.anyShort(), Mockito.anyShort(), Mockito.anySet(), Mockito.anyLong()))
				.thenReturn(null);
		assertNotNull(edpMsOfficeServiceImpl.getTrsPaoOffices(idDto));

		when(idDto.getId()).thenReturn(EDPConstant.DISTRICT_AHMEDABAD_ID);
		trsOffices.add(new EDPMsOfficeEntity());
		when(repository.findTrsPaoOfficesByDist(Mockito.anySet(), Mockito.anyShort(), Mockito.anyShort(), Mockito.anySet(), Mockito.anyLong()))
				.thenReturn(trsOffices);
		assertNotNull(edpMsOfficeServiceImpl.getTrsPaoOffices(idDto));

		when(idDto.getId()).thenReturn(EDPConstant.DISTRICT_GANDHINAGAR_ID);
		when(repository.findTrsPaoOfficesByDist(Mockito.anySet(), Mockito.anyShort(), Mockito.anyShort(), Mockito.anySet(), Mockito.anyLong()))
				.thenReturn(trsOffices);
		assertNotNull(edpMsOfficeServiceImpl.getTrsPaoOffices(idDto));

		when(idDto.getId()).thenReturn(EDPConstant.DISTRICT_GANDHINAGAR_PAO_ID);
		when(repository.findTrsPaoOfficesByDist(Mockito.anySet(), Mockito.anyShort(), Mockito.anyShort(), Mockito.anySet(), Mockito.anyLong()))
				.thenReturn(trsOffices);
		assertNotNull(edpMsOfficeServiceImpl.getTrsPaoOffices(idDto));

		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE - 1);
		when(repository.findTrsPaoOfficesByDist(Mockito.anySet(), Mockito.anyShort(), Mockito.anyShort(), Mockito.anySet(), Mockito.anyLong()))
				.thenReturn(trsOffices);
		assertNotNull(edpMsOfficeServiceImpl.getTrsPaoOffices(idDto));
	}
}
