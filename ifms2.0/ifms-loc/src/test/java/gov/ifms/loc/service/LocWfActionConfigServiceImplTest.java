package gov.ifms.loc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsBranchRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.loc.constant.JunitConstants;
import gov.ifms.loc.workflow.dto.AssignedToTrnDto;
import gov.ifms.loc.workflow.dto.MenuTblInfoDto;
import gov.ifms.loc.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.loc.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.loc.workflow.dto.WfActionConfigTrnDto;
import gov.ifms.loc.workflow.dto.WfRequestDto;
import gov.ifms.loc.workflow.dto.WfRlandPrDto;
import gov.ifms.loc.workflow.dto.WfUserDetails;
import gov.ifms.loc.workflow.dto.WfUserDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.entity.LocWfActionConfigEntity;
import gov.ifms.loc.workflow.repository.LocWfActionConfigRepository;
import gov.ifms.loc.workflow.service.LocWfActionConfigServiceImpl;
import gov.ifms.loc.workflow.util.LocWorkFlowConstant;

@TestInstance(Lifecycle.PER_CLASS)
class LocWfActionConfigServiceImplTest {

	/**
	 * The service.
	 */
	@InjectMocks
	private LocWfActionConfigServiceImpl serviceImpl;

	@Mock
	private LocWfActionConfigRepository repository;

	/**
	 * The office repo.
	 */
	@Mock
	private EDPMsOfficeRepository officeRepo;

	/**
	 *
	 */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/**
	 * The security util.
	 */
	@Mock
	private EncryptDecryptUtil securityUtil;

	@Mock
	private EDPMsBranchRepository branchRepository;

	@Mock
	private EDPLkPoOffUserRepository pouRepository;

	@Mock
	private EDPMsOfficeEntity office;

	@Mock
	private MenuTblInfoDto menuTblInfo;

	@Mock
	WfActConfUserRequestDto wfrequestdto;

	@Mock
	private WfRequestDto wfReqDto;

	@Mock
	private LocWfActionConfigEntity wfActConf;

	@Mock
	private WfUserDto userDto;

	@Mock
	private EDPMsMenuEntity edpMsMenuEntity;

	@Mock
	private List<WfUserDto> wfUserList;

	@Mock
	private WfUserReqSDDto sdDto;

	@Mock
	private WfRlandPrDto wfPrDto;

	@Mock
	private WfActionConfigSubmitTrnDto wfActionConfigSubmitTrnDto;

	@Mock
	private WfUserReqSDDto dto;

	@Mock
	private MenuTblInfoDto menuTblInfoDto;

	@Mock
	private EDPMsOfficeEntity officeTypeId;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	@Mock
	private AssignedToTrnDto assignedToTrnDto;

	@Mock
	private WfActionConfigTrnDto wfActionConfigTrnDto;

	@Mock
	private WfUserDetails assignedTo;

	@Mock
	private WfUserDetails assignedBy;

	@Mock
	private LocWfActionConfigEntity locWfActionConfigEntity;
	@Mock
	private WfActionConfigTrnDto configDto;

	@Mock
	private WfUserDetails userDtls;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetNextWfActions() throws CustomException {
		EDPMsOfficeEntity office = new EDPMsOfficeEntity();
		when(officeRepo.getOne(JunitConstants.LONG_TYPE)).thenReturn(office);
		office.setStatusId((short) 327);
		office.setOfficeStatus(LocWorkFlowConstant.LU_ACTIVE_LOOKUP_INFO_ID);
		office.setActiveStatus(JunitConstants.INTEGER_TYPE);
		office.setIsCo(LocWorkFlowConstant.LU_YES_LOOKUP_INFO_ID);
		EDPLuLookUpInfoEntity officeTypeId = new EDPLuLookUpInfoEntity();
		officeTypeId.setLookUpInfoId(JunitConstants.LONG_TYPE);
		office.setOfficeTypeId(officeTypeId);
		wfReqDto.setLkPOUId(JunitConstants.LONG_TYPE);
		when(repository.verifyUserWfRole(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LONG_TYPE);
		WfRequestDto wfReqDto = new WfRequestDto();
		wfReqDto.setOfficeId(JunitConstants.LONG_TYPE);
		wfReqDto.setTrnId(JunitConstants.LONG_TYPE);
		wfReqDto.setMenuId(JunitConstants.LONG_TYPE);
		wfReqDto.setLkPOUId(JunitConstants.LONG_TYPE);
		wfReqDto.setBranchId(JunitConstants.LONG_TYPE);
		List<WfRlandPrDto> wfPrDtoList = new ArrayList<>();
		wfPrDtoList.add(wfPrDto);
		when(repository.findWfInitWfRolesAndPrWithSubTypeNull(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt(),
				Mockito.anyInt(), Mockito.anyInt())).thenReturn(wfPrDtoList);

		when(repository.executeSQLQuerySingle(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class)))
				.thenReturn(menuTblInfo);
		when(repository.verifyUserWfRole(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong()))
				.thenReturn(1L);

		List<Object[]> objLst = new ArrayList<>();
		Object[] obj = new Object[4];
		obj[0] = 1l;
		obj[1] = "Test";
		obj[2] = 1l;
		obj[3] = 1l;
		objLst.add(obj);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objLst);

		assertNotNull(serviceImpl.getNextWfActions(wfReqDto));

	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetTblInfo() throws CustomException {
		when(repository.executeSQLQuerySingle(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class)))
				.thenReturn(menuTblInfo);
		assertNotNull(serviceImpl.getTblInfo(JunitConstants.LONG_TYPE));

	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetTblInfoByWfActionConfigId() throws CustomException {
		when(repository.executeSQLQuerySingle(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class)))
				.thenReturn(menuTblInfo);
		assertNotNull(serviceImpl.getTblInfoByWfActionConfigId(JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetUsersForInitiateWf() throws CustomException {

		when(serviceImpl.getTblInfo(JunitConstants.LONG_TYPE)).thenReturn(menuTblInfo);
		List<Object[]> objLst = new ArrayList<>();
		Object[] obj = new Object[4];
		obj[0] = 1l;
		obj[1] = "Test";
		obj[2] = 1l;
		obj[3] = 1l;
		objLst.add(obj);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objLst);

		LocWfActionConfigEntity wfActConf = new LocWfActionConfigEntity();
		EDPMsMenuEntity edpMsMenuEntity = new EDPMsMenuEntity();
		edpMsMenuEntity.setMenuId(JunitConstants.LONG_TYPE);
		wfActConf.setEdpMsMenuEntity(edpMsMenuEntity);

		assertNotNull(serviceImpl.getUsersForInitiateWf(wfrequestdto, wfActConf));
	}

	@Test
	void testGetUsersForForwardWf() {
		wfActConf.setIsToBranchSelReq(JunitConstants.INTEGER_TYPE);
		when(repository.findUserByNextWfRoleAndBTId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS))
						.thenReturn(wfUserList);
		assertNotNull(serviceImpl.getUsersForForwardWf(wfrequestdto, wfActConf));

	}

	@Test
	void testGetUsersForForwardWf1() {
		when(repository.findUserByNextWfRole(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.ACTIVE_STATUS)).thenReturn(wfUserList);
		when(wfActConf.getToBranchTypeId()).thenReturn(null);
		assertNotNull(serviceImpl.getUsersForForwardWf(wfrequestdto, wfActConf));

	}

	@Test
	void testGetUsersForPreviousWf() throws CustomException {

		when(serviceImpl.getTblInfo(JunitConstants.LONG_TYPE)).thenReturn(menuTblInfo);
		List<Object[]> objLst = new ArrayList<>();
		Object[] obj = new Object[4];
		obj[0] = 1l;
		obj[1] = "Test";
		obj[2] = 1l;
		obj[3] = 1l;
		objLst.add(obj);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objLst);

		LocWfActionConfigEntity wfActConf = new LocWfActionConfigEntity();
		EDPMsMenuEntity edpMsMenuEntity = new EDPMsMenuEntity();
		edpMsMenuEntity.setMenuId(JunitConstants.LONG_TYPE);
		wfActConf.setEdpMsMenuEntity(edpMsMenuEntity);

		assertNotNull(serviceImpl.getUsersForPreviousWf(wfrequestdto, wfActConf));
	}

	@Test
	void testGetUsersForReworkWf() throws CustomException {

		when(serviceImpl.getTblInfo(JunitConstants.LONG_TYPE)).thenReturn(menuTblInfo);
		List<Object[]> objLst = new ArrayList<>();
		Object[] obj = new Object[4];
		obj[0] = 1l;
		obj[1] = "Test";
		obj[2] = 1l;
		obj[3] = 1l;
		objLst.add(obj);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objLst);

		LocWfActionConfigEntity wfActConf = new LocWfActionConfigEntity();
		EDPMsMenuEntity edpMsMenuEntity = new EDPMsMenuEntity();
		edpMsMenuEntity.setMenuId(JunitConstants.LONG_TYPE);
		wfActConf.setEdpMsMenuEntity(edpMsMenuEntity);

		assertNotNull(serviceImpl.getUsersForReworkWf(wfrequestdto, wfActConf));
	}

//	@SuppressWarnings("unchecked")
//	@Test
//	void testgetUsersByWfActConfigId() throws CustomException {
	/*
	 * when(repository.findByActionConfigIdAndActiveStatus(Mockito.anyLong(),
	 * Mockito.anyInt())).thenReturn(wfActConf);
	 * assertNotNull(serviceImpl.getUsersByWfActConfigId(wfrequestdto));
	 * when(wfActConf.getSendBackFlag()).thenReturn(SendBack.DEFUALT.getValue());
	 * when(wfrequestdto.getOfficeId()).thenReturn(Mockito.anyLong());
	 * when(wfrequestdto.getMenuId()).thenReturn(Mockito.anyLong());
	 * when(wfActConf.getToWorkFlowRoleId()).thenReturn(Mockito.anyLong());
	 * when(wfActConf.getToBranchTypeId()).thenReturn(Mockito.anyLong());
	 * when(repository.findUserByNextWfRoleAndBTId(wfrequestdto.getMenuId(),
	 * wfrequestdto.getOfficeId(),
	 * wfActConf.getToWorkFlowRoleId(),wfActConf.getToBranchTypeId(),Constant.
	 * ACTIVE_STATUS)).thenReturn(wfUserList);
	 * 
	 * when(wfrequestdto.getWfActionConfigId()).thenReturn(Mockito.anyLong());
	 * when(repository.findByActionConfigIdAndActiveStatus(wfrequestdto.
	 * getWfActionConfigId(),Constant.ACTIVE_STATUS)) .thenReturn(wfActConf);
	 * 
	 * when(wfActConf.getSendBackFlag()).thenReturn(SendBack.PRIVIOUS.getValue());
	 * when(wfrequestdto.getOfficeId()).thenReturn(Mockito.anyLong());
	 * when(wfrequestdto.getMenuId()).thenReturn(Mockito.anyLong());
	 * when(wfActConf.getToWorkFlowRoleId()).thenReturn(Mockito.anyLong());
	 * when(repository.executeSQLQuery(Mockito.anyString(),
	 * Mockito.anyMap(),Mockito.any(Class.class))).thenReturn(wfUserList);
	 * when(repository.findUserByNextWfRoleAndBTId(wfrequestdto.getOfficeId(),
	 * wfrequestdto.getMenuId(), wfActConf.getToWorkFlowRoleId(),
	 * wfActConf.getToBranchTypeId(),
	 * Constant.ACTIVE_STATUS)).thenReturn(wfUserList);
	 * 
	 * when(wfActConf.getSendBackFlag()).thenReturn(SendBack.REWORK.getValue());
	 * when(wfrequestdto.getOfficeId()).thenReturn(Mockito.anyLong());
	 * when(wfrequestdto.getMenuId()).thenReturn(Mockito.anyLong());
	 * when(wfActConf.getToWorkFlowRoleId()).thenReturn(Mockito.anyLong());
	 * when(wfActConf.getToBranchTypeId()).thenReturn(Mockito.anyLong());
	 * when(repository.findUserByNextWfRoleAndBTId(wfrequestdto.getOfficeId(),
	 * wfrequestdto.getMenuId(), wfActConf.getToWorkFlowRoleId(),
	 * wfActConf.getToBranchTypeId(),
	 * Constant.ACTIVE_STATUS)).thenReturn(wfUserList);
	 * 
	 * 
	 * when(wfActConf.getSendBackFlag()).thenReturn(SendBack.RETURN_INITIATOR.
	 * getValue()); when(wfrequestdto.getOfficeId()).thenReturn(Mockito.anyLong());
	 * when(wfrequestdto.getMenuId()).thenReturn(Mockito.anyLong());
	 * when(wfActConf.getToWorkFlowRoleId()).thenReturn(Mockito.anyLong());
	 * when(wfActConf.getToBranchTypeId()).thenReturn(Mockito.anyLong());
	 * when(repository.findUserByNextWfRoleAndBTId(wfrequestdto.getOfficeId(),
	 * wfrequestdto.getMenuId(), wfActConf.getToWorkFlowRoleId(),
	 * wfActConf.getToBranchTypeId(),
	 * Constant.ACTIVE_STATUS)).thenReturn(wfUserList);
	 * 
	 * assertNotNull(serviceImpl.getUsersByWfActConfigId(wfrequestdto));
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
//	@Test
	void testSubmitWfActConfigTrn() throws CustomException {
//        Object[] chqObject = new Object[3];
//        chqObject[0] = JunitConstants.DATE;
//        chqObject[1] = JunitConstants.STRING_TYPE;
//        chqObject[2] = JunitConstants.LONG_TYPE;
//        List<Object[]> objList = new ArrayList<Object[]>();
//        objList.add(chqObject);
		List<WfActionConfigTrnDto> dtoList = new ArrayList<>();
		dtoList.add(configDto);
		when(configDto.getActionConfigId()).thenReturn(JunitConstants.LONG_TYPE);
		when(wfActionConfigSubmitTrnDto.getWfDetails()).thenReturn(dtoList);
		when(repository.executeSQLQuerySingle(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class)))
				.thenReturn(menuTblInfo);
		when(repository.findByActionConfigIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(wfActConf);
		when(configDto.getAssignedTo()).thenReturn(userDtls);
		when(userDtls.getUserId()).thenReturn(new Object());
		when(configDto.getAssignedBy()).thenReturn(userDtls);
		when(menuTblInfo.getSchemaName()).thenReturn(JunitConstants.STRING_ABC);
		when(menuTblInfo.getWfTblName()).thenReturn(JunitConstants.STRING_ABC);
		when(repository.callWfSPLong(Mockito.anyString(), Mockito.anyMap())).thenReturn(JunitConstants.LONG_TYPE);
//		Object[] chqObject = new Object[21];
//		chqObject[0] = JunitConstants.LONG_TYPE;
//		chqObject[1] = JunitConstants.LONG_TYPE;
//		chqObject[2] = JunitConstants.LONG_TYPE;
//		chqObject[3] = JunitConstants.LONG_TYPE;
//		chqObject[4] = JunitConstants.LONG_TYPE;
//		chqObject[5] = JunitConstants.LONG_TYPE;
//		chqObject[6] = JunitConstants.LONG_TYPE;
//		chqObject[7] = JunitConstants.DATE;
//		chqObject[8] = JunitConstants.LONG_TYPE;
//		chqObject[9] = JunitConstants.LONG_TYPE;
//		chqObject[10] = JunitConstants.LONG_TYPE;
//		chqObject[11] = JunitConstants.STRING_ABC;
//		chqObject[12] = JunitConstants.STRING_TYPE;
//		chqObject[13] = JunitConstants.LONG_TYPE;
//		chqObject[14] = JunitConstants.LONG_TYPE;
//		chqObject[15] = JunitConstants.LONG_TYPE;
//		chqObject[16] = JunitConstants.LONG_TYPE;
//		chqObject[17] = JunitConstants.LONG_TYPE;
//		chqObject[18] = JunitConstants.LONG_TYPE;
//		chqObject[19] = JunitConstants.LONG_TYPE;
//		chqObject[20] = JunitConstants.STRING_ABC;
//		chqObject[21] = JunitConstants.STRING_ABC;
//		List<Object[]> objList = new ArrayList<Object[]>();
//		objList.add(chqObject);
//		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objList);
		// assertNotNull(serviceImpl.submitWfActConfigTrn(wfActionConfigSubmitTrnDto));

		// when(repository.executeSQLQuery(Mockito.anyString(),
		// Mockito.anyMap())).thenReturn(objList);
		// assertNotNull(serviceImpl.submitWfActConfigTrn(wfActionConfigSubmitTrnDto));

		// assertNotNull(serviceImpl.submitWfActConfigTrn(menuTblInfo));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testsaveWfActConfigTrn() throws CustomException {
		when(repository.executeSQLQuerySingle(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class)))
				.thenReturn(menuTblInfo);
		when(dto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getPouId()).thenReturn(2l);
		when(menuTblInfoDto.getSchemaName()).thenReturn(JunitConstants.STRING_TYPE);
		when(menuTblInfoDto.getWfAttTblName()).thenReturn(JunitConstants.STRING_TYPE);
		when(officeRepo.getOne(JunitConstants.LONG_TYPE)).thenReturn(officeTypeId);
		when(officeTypeId.getOfficeTypeId()).thenReturn(edpLuLookUpInfoEntity);
		List<MenuTblInfoDto> assignedToTrnDtoList = new ArrayList<>();
		assignedToTrnDtoList.add(menuTblInfoDto);

		when(officeTypeId.getStatusId()).thenReturn((short) LocWorkFlowConstant.LU_APPROVED_LOOKUP_INFO_ID);
		when(officeTypeId.getActiveStatus()).thenReturn(Constant.ACTIVE_STATUS);
		when(officeTypeId.getOfficeStatus()).thenReturn(Constant.LU_ACTIVE_LOOKUP_INFO_ID);

		List<AssignedToTrnDto> assignedToList = new ArrayList<>();
		assignedToList.add(assignedToTrnDto);

		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class)))
				.thenReturn(assignedToList);
		serviceImpl.saveWfActConfigTrn(dto);
		when(dto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getTrnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);

		when(dto.getPouId()).thenReturn(JunitConstants.LONG_TYPE_ZER);
		serviceImpl.saveWfActConfigTrn(dto);
	}

	@Test
	void testsubmitWfActConfigTrn_Valid() throws CustomException, SQLException {
		/*
		 * List<WfActionConfigTrnDto> list = new ArrayList<>();
		 * when(wfActionConfigTrnDto.getActionConfigId()).thenReturn(20l);
		 * when(locWfActionConfigEntity.getWfActionId()).thenReturn(JunitConstants.
		 * LONG_TYPE);
		 * when(wfActionConfigTrnDto.getAssignedTo()).thenReturn(assignedTo);
		 * when(assignedTo.getUserId()).thenReturn(new Object());
		 * when(wfActionConfigTrnDto.getAssignedBy()).thenReturn(assignedBy);
		 * when(assignedTo.getWfRoleId()).thenReturn(JunitConstants.LONG_TYPE);
		 * when(wfActionConfigTrnDto.getAssignedTo().getUserId()).thenReturn(
		 * JunitConstants.LONG_TYPE);
		 * when(wfActionConfigTrnDto.getAssignedBy().getUserId()).thenReturn(
		 * JunitConstants.LONG_TYPE); list.add(wfActionConfigTrnDto);
		 * when(wfActionConfigSubmitTrnDto.getWfDetails()).thenReturn(list);
		 * when(menuTblInfoDto.getWfAttTblName()).thenReturn("attached Table");
		 * when(repository.executeSQLQuerySingle(Mockito.anyString(), Mockito.anyMap(),
		 * Mockito.eq(MenuTblInfoDto.class))).thenReturn(menuTblInfoDto);
		 * when(repository.findByActionConfigIdAndActiveStatus(JunitConstants.LONG_TYPE,
		 * Constant.ACTIVE_STATUS)).thenReturn(locWfActionConfigEntity,
		 * locWfActionConfigEntity); //
		 * when(repository.executeNativeSQLQuerySingle(Mockito.anyString(),Mockito.
		 * anyMap(), // Mockito.eq(MenuTblInfoDto.class)).
		 * //when(repository.findByActionconfigIdAndActiveStatus(wfActionConfigTrnDto.
		 * getActionConfigId(), //
		 * Constant.ACTIVE_STATUS)).thenReturn(locWfActionConfigEntity);
		 * 
		 * assertNotNull(serviceImpl.submitWfActConfigTrn(wfActionConfigSubmitTrnDto));
		 * 
		 * 
		 * 
		 */}
}
