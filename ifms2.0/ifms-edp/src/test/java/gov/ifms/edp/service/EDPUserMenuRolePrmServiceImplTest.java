package gov.ifms.edp.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPUserRoleMappingConverter;
import gov.ifms.edp.dto.EDPMenuWfDto;
import gov.ifms.edp.dto.EDPTrnUserMnuRolePrmDto;
import gov.ifms.edp.dto.EDPUserRightsAssignDto;
import gov.ifms.edp.dto.EDPUserRightsGivenRemovalDto;
import gov.ifms.edp.dto.EDPUserRoleMappingDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPTrnUserMnuRolePrmEntity;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingItrEntity;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;
import gov.ifms.edp.repository.EDPLkUserMenuRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPTrnUserMnuRolePrmRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingItrRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPUserMenuRolePrmServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPUserMenuRolePrmServiceImplTest {

	/** The edp user rights assign dto. */
	@Mock
	private EDPUserRightsAssignDto edpUserRightsAssignDto;

	/** The edp user role mapping repository. */
	@Mock
	private EDPUserRoleMappingRepository edpUserRoleMappingRepository;

	/** The edp user role mapping entity. */
	@Mock
	private EDPUserRoleMappingEntity edpUserRoleMappingEntity;


	/** The edp user role mapping dto. */
	@Mock
	private EDPUserRoleMappingDto edpUserRoleMappingDto;

	/** The edp user role mapping converter. */
	@Mock
	private EDPUserRoleMappingConverter edpUserRoleMappingConverter;

	/** The edp trn user mnu role prm dto. */
	@Mock
	private EDPTrnUserMnuRolePrmDto edpTrnUserMnuRolePrmDto;

	/** The edp lk user menu repository. */
	@Mock
	private EDPLkUserMenuRepository edpLkUserMenuRepository;

	/** The edp lk user menu entity. */
	@Mock
	private EDPLkUserMenuEntity edpLkUserMenuEntity;

	/** The edp trn user mnu role prm entity. */
	@Mock
	private EDPTrnUserMnuRolePrmEntity edpTrnUserMnuRolePrmEntity;

	/** The edp trn user mnu role prm entity 2. */
	@Mock
	private EDPTrnUserMnuRolePrmEntity edpTrnUserMnuRolePrmEntity2;

	/** The edp trn user mnu role prm repository. */
	@Mock
	private EDPTrnUserMnuRolePrmRepository edpTrnUserMnuRolePrmRepository;

	/** The edp lk puo menu RLWF repository. */
	@Mock
	private EDPLkPuoMenuRLWFRepository edpLkPuoMenuRLWFRepository;

	/** The edp trn usr mnu wf role. */
	@Mock
	private EDPTrnUsrMnuWfRole edpTrnUsrMnuWfRole;

	/** The edp trn usr mnu wf role 2. */
	@Mock
	private EDPTrnUsrMnuWfRole edpTrnUsrMnuWfRole2;

	/** The lookupinforepository. */
	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The edp ms financial year entity. */
	@Mock
	private EDPMsFinancialYearEntity edpMsFinancialYearEntity;

	/** The edp ms financial year repository. */
	@Mock
	private EDPMsFinancialYearRepository edpMsFinancialYearRepository;

	/** The return assign dto. */
	@Mock
	private EDPUserRightsAssignDto returnAssignDto;

	/** The edp user rights given removal dto. */
	@Mock
	private EDPUserRightsGivenRemovalDto edpUserRightsGivenRemovalDto;

	/** The edp lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity edpLkPoOffUserEntity;

	/** The edp user role mapping itr repository. */
	@Mock
	private EDPUserRoleMappingItrRepository edpUserRoleMappingItrRepository;

	/** The edp user role mapping itr entity. */
	@Mock
	private EDPUserRoleMappingItrEntity edpUserRoleMappingItrEntity;

	/** The edp user role mapping service. */
	@Mock
	private EDPUserRoleMappingService edpUserRoleMappingService;

	/** The user rights dtos. */
	@Mock
	List<EDPUserRightsGivenRemovalDto> userRightsDtos;

	/** The edp menu wf dto. */
	@Mock
	EDPMenuWfDto edpMenuWfDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test save assign post rights.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveAssignPostRights() throws CustomException {
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_SAVAS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntity);
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpUserRightsAssignDto.getEdpUserRoleMappingDto()).thenReturn(edpUserRoleMappingDto);
		List<EDPUserRoleMappingEntity> edpUserRoleMapping = new ArrayList<>();
		edpUserRoleMapping.add(edpUserRoleMappingEntity);
		when(edpUserRightsAssignDto.getEmpId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpUserRightsAssignDto.getPostOfficeUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpUserRoleMappingRepository.findByEmployeeIdAndPostOfficeUserIdLkPoOffUserIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
			.thenReturn(edpUserRoleMapping);
		when(edpUserRoleMappingEntity.getSubmissionStatus()).thenReturn(edpLuLookUpInfoEntity);
		when(edpUserRightsAssignDto.getEdpUserRoleMappingDto()).thenReturn(edpUserRoleMappingDto);
		when(edpUserRoleMappingDto.getUserRoleMappingId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpUserRoleMappingRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpUserRoleMappingEntity));
		when(returnAssignDto.getEdpUserRoleMappingDto()).thenReturn(edpUserRoleMappingDto);
		when(edpUserRoleMappingDto.getSubmissionStatus()).thenReturn(JunitConstants.LONG_TYPE);
		when(returnAssignDto.getEdpUserRoleMappingDto()).thenReturn(edpUserRoleMappingDto);
		when(edpUserRoleMappingConverter.toDTO(edpUserRoleMappingEntity)).thenReturn(edpUserRoleMappingDto);
		when(edpMsFinancialYearRepository.findByIsCurrentYearLookUpInfoName(Constant.LOOKUP_YES))
				.thenReturn(edpMsFinancialYearEntity);
		when(edpMsFinancialYearEntity.getFyShort()).thenReturn(JunitConstants.FYSHORT);
		when(edpUserRoleMappingRepository.save(Mockito.any(EDPUserRoleMappingEntity.class)))
				.thenReturn(edpUserRoleMappingEntity);
		when(edpUserRoleMappingConverter.toEntity(Mockito.any(EDPUserRoleMappingDto.class)))
				.thenReturn(edpUserRoleMappingEntity);
		when(edpUserRoleMappingEntity.getUserRoleMappingId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPTrnUserMnuRolePrmDto> lstEdpTrnUserMenuRolePerDtos = new ArrayList<>();
		lstEdpTrnUserMenuRolePerDtos.add(edpTrnUserMnuRolePrmDto);
		when(edpUserRightsAssignDto.getLstEdpTrnUserMenuRolePerDtos()).thenReturn(lstEdpTrnUserMenuRolePerDtos);

		when(edpTrnUserMnuRolePrmDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkUserMenuRepository.findByPoOffUserIdLkPoOffUserIdAndMenuIDAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(edpLkUserMenuEntity);
		when(edpLkUserMenuEntity.getLkUserMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPUserRoleMappingEntity> submissionStatus = new ArrayList<>();
		submissionStatus.add(edpUserRoleMappingEntity);
		when(edpUserRoleMappingRepository.findByUserRoleMappingId(JunitConstants.LONG_TYPE))
				.thenReturn(submissionStatus);
		when(edpTrnUserMnuRolePrmRepository.save(Mockito.any(EDPTrnUserMnuRolePrmEntity.class)))
				.thenReturn(edpTrnUserMnuRolePrmEntity);
		when(edpTrnUserMnuRolePrmEntity.getTrnUsrRolePrmId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUserMnuRolePrmRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpTrnUserMnuRolePrmEntity);
		List<Object[]> objList = new ArrayList<Object[]>();
		Object[] obj = new Object[3];
		objList.add(obj);
		when(edpUserRoleMappingRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objList);
		List<EDPTrnUserMnuRolePrmEntity> edpTrnUserMnuRolePrmEntityList = new ArrayList<>();
		edpTrnUserMnuRolePrmEntityList.add(edpTrnUserMnuRolePrmEntity);
		
		when(edpUserRoleMappingDto.getUserRoleMappingId()).thenReturn(JunitConstants.LONG_ZERO);
		when(edpLkUserMenuRepository.save(Mockito.any(EDPLkUserMenuEntity.class))).thenReturn(edpLkUserMenuEntity);
		when(edpLkPuoMenuRLWFRepository.save(Mockito.any(EDPTrnUsrMnuWfRole.class))).thenReturn(edpTrnUsrMnuWfRole);
		when(edpLkUserMenuRepository.findByPoOffUserIdLkPoOffUserIdAndMenuIDAndActiveStatus(JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(null);
		List<EDPUserRoleMappingEntity> edpUserRoleMappingEntities = new ArrayList<>();
		edpUserRoleMappingEntities.add(edpUserRoleMappingEntity);
		when(edpUserRoleMappingRepository.checkIfApprovedTrnExist(JunitConstants.LONG_TYPE)).thenReturn(edpUserRoleMappingEntities);
		
		List<EDPUserRightsGivenRemovalDto> edpUserRightsGivenRemovalDtos = new ArrayList<>();
		edpUserRightsGivenRemovalDtos.add(edpUserRightsGivenRemovalDto);
		Object[] object = new Object[27];
		object[0] = JunitConstants.LONG_STRING;
		object[1] = JunitConstants.LONG_STRING;
		object[2] = JunitConstants.LONG_STRING;
		object[3] = JunitConstants.LONG_STRING;
		object[4] = JunitConstants.LONG_STRING;
		object[5] = JunitConstants.LONG_STRING;
		object[6] = JunitConstants.LONG_STRING;
		object[7] = JunitConstants.LONG_STRING;
		object[8] = JunitConstants.LONG_STRING;
		object[9] = JunitConstants.LONG_TYPE;
		object[10] = JunitConstants.LONG_STRING;
		object[11] = JunitConstants.LONG_STRING;
		object[12] = JunitConstants.LONG_STRING;
		object[13] = JunitConstants.LONG_STRING;
		object[14] = JunitConstants.LONG_STRING;
		object[15] = JunitConstants.LONG_STRING;
		object[16] = JunitConstants.LONG_STRING;
		object[17] = JunitConstants.LONG_STRING;
		object[18] = JunitConstants.LONG_STRING;
		object[19] = JunitConstants.LONG_STRING;
		object[20] = JunitConstants.DATE;
		object[21] = JunitConstants.LONG_STRING;
		object[22] = JunitConstants.LONG_STRING;
		object[23] = JunitConstants.LONG_STRING;
		object[24] = JunitConstants.LONG_STRING;
		object[25] = JunitConstants.LONG_STRING;
		object[26] = JunitConstants.LONG_STRING;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(edpUserRoleMappingRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(edpUserRoleMappingEntity.getUserRoleMappingId()).thenReturn(JunitConstants.LONG_TYPE);
		List<Long> list = new ArrayList<>();
		list.add(JunitConstants.LONG_TYPE);
		when(edpUserRoleMappingRepository.getPreviousApprovedPerm(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, list)).thenReturn(JunitConstants.LONG_STRING);
		
		when(edpUserRightsGivenRemovalDto.getIsRightsRemoved()).thenReturn("1");
		
		List<EDPTrnUsrMnuWfRole> oldEntities = new ArrayList<>();
		oldEntities.add(edpTrnUsrMnuWfRole);
		when(edpTrnUsrMnuWfRole.getLkUserMenuId()).thenReturn(edpLkUserMenuEntity);
		List<EDPMenuWfDto> edpMenuWfDtoList = new ArrayList<EDPMenuWfDto>();
		edpMenuWfDtoList.add(edpMenuWfDto);
		when(edpUserRightsAssignDto.getLstEDPMenuWfDto()).thenReturn(edpMenuWfDtoList);
		when(edpMenuWfDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUserMnuRolePrmEntity.getLkUserMenuId()).thenReturn(edpLkUserMenuEntity);
		when(edpLkUserMenuEntity.getMenuID()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkUserMenuEntity.getLkUserMenuId()).thenReturn(JunitConstants.LONG_ZERO);
		when(edpTrnUsrMnuWfRole.getWorkflowRoleId()).thenReturn(JunitConstants.LONG_ZERO);
		when(edpUserRightsAssignDto.getLstEdpTrnUserMenuRolePerDtos()).thenReturn(null);
		List<EDPTrnUsrMnuWfRole> oldEntities1 = new ArrayList<>();
		oldEntities1.add(edpTrnUsrMnuWfRole);
		when(edpTrnUsrMnuWfRole.getLkUserMenuId()).thenReturn(edpLkUserMenuEntity);

	}

	/**
	 * Test update submission status transaction id.
	 */
	@Test
	void testUpdateSubmissionStatus_transactionId() {
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpUserRoleMappingRepository.updateSubmitStatus(Mockito.any(Long.class),
				Mockito.any(EDPLuLookUpInfoEntity.class), Mockito.any(Long.class), Mockito.any(Date.class)))
						.thenReturn(JunitConstants.INTEGER_TYPE);
//		verify(lookupinforepository, times(1)).findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
//		verify(edpUserRoleMappingRepository, times(1)).updateSubmitStatus(Mockito.any(Long.class),
//				Mockito.any(EDPLuLookUpInfoEntity.class), Mockito.any(Long.class), Mockito.any(Date.class));
	}

	/**
	 * Test find by trn usr role prm id.
	 */
	@Test
	void testFindByTrnUsrRolePrmId() {
		Map<String, String> map = new HashMap<>();
		map.put(EDPConstant.EDP_TRN_USR_ROLE_PRM_ID, "1,2");
		map.put(EDPConstant.EDP_TRN_USR_WF_ROLE_ID, "1,2");
		List<EDPTrnUserMnuRolePrmEntity> edpTrnUserMnuRolePrmEntityList1 = new ArrayList<>();
		edpTrnUserMnuRolePrmEntityList1.add(edpTrnUserMnuRolePrmEntity);
		List<EDPTrnUserMnuRolePrmEntity> edpTrnUserMnuRolePrmEntityList2 = new ArrayList<>();
		edpTrnUserMnuRolePrmEntityList2.add(edpTrnUserMnuRolePrmEntity);
		edpTrnUserMnuRolePrmEntityList2.add(edpTrnUserMnuRolePrmEntity);
		when(edpTrnUserMnuRolePrmEntity.getTrnUsrRolePrmId()).thenReturn(JunitConstants.LONG_TYPE);
		
		List<Long> list = new ArrayList<Long>();
		
		when(edpUserRoleMappingRepository.getActiveObjectsFromTrn(JunitConstants.LONG_TYPE)).thenReturn(list);
	}
}
