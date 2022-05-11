package gov.ifms.workflow.service;


import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsBranchRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.util.EDPConstant;

import gov.ifms.workflow.dto.AssignedToTrnDto;
import gov.ifms.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.workflow.dto.WfActionConfigTrnDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfUserDetails;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.entity.MsWorkflowRoleEntity;
import gov.ifms.workflow.entity.WfActionConfigEntity;
import gov.ifms.workflow.repository.LkMenuTblInfoRepository;


import gov.ifms.workflow.repository.WfActionConfigRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.util.SendBack;
import gov.ifms.workflow.util.WorkFlowConstant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WfActionConfigServiceImplTest {

    @InjectMocks
    private WfActionConfigServiceImpl wfActionConfigService;

    @Mock
    private EDPMsOfficeRepository officeRepo;

    @Mock
    private EDPMsOfficeEntity officeTypeId;

    @Mock
    WfRequestDto dto;

    @Mock
    private EDPLuLookUpInfoEntity ed;


    @Mock
    private EDPMsBranchEntity edpMsBranchEntity;

    @Mock
    private LkMenuTblInfoRepository menuRepository;

    @Mock
    private LkMenuTblInfoEntity lkMenuTblInfoEntity;
    @Mock
    private LkMenuTblInfoEntity lkMenuTblInfoEntity1;

    @Mock
    private MsWorkflowRoleEntity msWorkflowRoleFromEntity;

    @Mock
    private WfActionConfigSubmitTrnDto wfActionConfigSubmitTrnDto;

    @Mock
    private List<WfActionConfigTrnDto> wfActionConfigTrnDtos;

    @Mock
    private WfActionConfigTrnDto wfActionConfigTrnDto;

    @Mock
    WfRequestDto wfrequestdto;
    @Mock
    WfRequestDto wfrequestDto1;

    @Mock
    WfRepository wfRepo;

    @Mock
    AssignedToTrnDto assigndto;

    @Mock
    private List<AssignedToTrnDto> assignedToTrnDtoList;

    @Mock
    private EDPMsBranchRepository branchRepository;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

    @Mock
    private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

    @Mock
    private EDPLuLookUpInfoEntity yesInfoEntity;

    @Mock
    private WfActionConfigRepository wfActionConfigRepository;

    @Mock
    private EDPLuLookUpInfoEntity activeStatus;

    @Mock
    private EDPLuLookUpInfoEntity branchLookUp;

    @Mock
    List<WfActionConfigEntity> wfActionConfigEntities;

    @Mock
    List<Object[]> objarray;

    @Mock
    private WfActConfUserRequestDto wfActConfUserRequestDto;

    @Mock
    private WfActionConfigEntity wfActionConfigEntity;

    @Mock
    private WfActionConfigEntity wfActionConfigEntity2;

    @Mock
    private List<WfUserDto> lstWfUserDto;

    @Mock
    private Set<Object[]> stWfUserDto;

  //  @Test
    void getNextWfActions() throws CustomException {
        when(dto.getOfficeId()).thenReturn(38L);
        when(dto.getUserId()).thenReturn("123");
        when(dto.getPostId()).thenReturn(1l);
        when(dto.getMenuId()).thenReturn(1l);
        when(dto.getTrnId()).thenReturn(1l);
        when(dto.getLkPOUId()).thenReturn(25l);
        when(dto.getBranchId()).thenReturn(4l);
        when(dto.getEventId()).thenReturn(2l);
        List<Long> wfRoleIds = dto.getWfRoleIds();
        wfRoleIds.add(1l);
        wfRoleIds.add(2l);
        wfRoleIds.add(3l);
        when(dto.getWfRoleIds()).thenReturn(wfRoleIds);
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        when(dto.getWfRoleIds()).thenReturn(arrayList);
        when(officeRepo.getOne(dto.getOfficeId())).thenReturn(officeTypeId);
        when(officeTypeId.getOfficeTypeId()).thenReturn(ed);
        when(ed.getLookUpInfoId()).thenReturn(71L);
        when(menuRepository.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(), Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
        when(menuRepository.findByMenuIdAndActiveStatusAndEventId(dto.getMenuId(), Constant.ACTIVE_STATUS, dto.getEventId())).thenReturn(lkMenuTblInfoEntity);
        List<AssignedToTrnDto> assignedToTrnDtoList = new ArrayList<>();
        AssignedToTrnDto assignedToTrnDto = new AssignedToTrnDto();
        assignedToTrnDto.setAssignToActionLevel(1);
        assignedToTrnDto.setAssignToBranchId(4);
        assignedToTrnDto.setAssignToWfRoleId(1);
        assignedToTrnDto.setAssignToOfficeId(38);
        assignedToTrnDtoList.add(assignedToTrnDto);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class))).thenReturn(assignedToTrnDtoList);

        when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED)).thenReturn(edpLuLookUpInfoEntity);
        when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(1L);
        when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED)).thenReturn(activeStatus);
        when(activeStatus.getLookUpInfoId()).thenReturn(1L);
        when(edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES)).thenReturn(yesInfoEntity);
        when(yesInfoEntity.getLookUpInfoId()).thenReturn(5L);
        when(wfActionConfigRepository.verifyUserWfRole(dto.getMenuId(), assignedToTrnDto.getAssignToWfRoleId(), Constant.ACTIVE_STATUS, dto.getLkPOUId())).thenReturn(1L);
        when(wfActionConfigRepository.findWorkflowRuleIdAndWfActions(ed.getLookUpInfoId(), assignedToTrnDto.getAssignToWfRoleId(), dto.getMenuId(), Constant.VALID_WF_ACTION_ID, assignedToTrnDto.getAssignToActionLevel(), 0, WorkFlowConstant.DEFAULT_IS_CO, 0, WorkFlowConstant.DEFAULT_IS_FD,Mockito.anyInt(),WorkFlowConstant.DEFAULT_IS_DISPLAY_IN_POPUP)).thenReturn(wfActionConfigEntities);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class))).thenReturn(assignedToTrnDtoList);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class))).thenReturn(assignedToTrnDtoList);
        wfActionConfigService.getNextWfActions(dto);
    }

    @Test
    void getTblInfo() {
        when(dto.getMenuId()).thenReturn(1l);
        when(menuRepository.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(), Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
        when(dto.getEventId()).thenReturn(1l);
        when(menuRepository.findByMenuIdAndActiveStatusAndEventId(dto.getMenuId(), Constant.ACTIVE_STATUS, dto.getEventId())).thenReturn(lkMenuTblInfoEntity);
        assertNotNull(wfActionConfigService.getTblInfo(dto.getMenuId(),dto.getEventId()));
    }

    @Test
    void getUsersByWfActConfigId() throws CustomException {
        when(wfActConfUserRequestDto.getWfActionConfigId()).thenReturn(1001L);
        when(wfActionConfigRepository.findByActionconfigIdAndActiveStatus(wfActConfUserRequestDto.getWfActionConfigId(), Constant.ACTIVE_STATUS)).thenReturn(wfActionConfigEntity);
        when(wfActionConfigEntity.getSendBackFlag()).thenReturn(SendBack.DEFUALT.getValue());
        when(wfActConfUserRequestDto.getOfficeId()).thenReturn(38l);
        when(wfActConfUserRequestDto.getMenuId()).thenReturn(5l);
        when(wfActionConfigEntity.getToWorkFlowRoleId()).thenReturn(2L);
        when(wfActionConfigEntity.getToBranchTypeId()).thenReturn(507L);
        when(wfActionConfigRepository.findUserByNextWfRoleAndBTId(wfActConfUserRequestDto.getOfficeId(), wfActConfUserRequestDto.getMenuId(), wfActionConfigEntity.getToWorkFlowRoleId(), wfActionConfigEntity.getToBranchTypeId(), Constant.ACTIVE_STATUS)).thenReturn(stWfUserDto);
        wfActionConfigService.getUsersByWfActConfigId(wfActConfUserRequestDto);

        when(wfActConfUserRequestDto.getWfActionConfigId()).thenReturn(1002L);
        when(wfActionConfigRepository.findByActionconfigIdAndActiveStatus(wfActConfUserRequestDto.getWfActionConfigId(), Constant.ACTIVE_STATUS)).thenReturn(wfActionConfigEntity2);
        when(wfActionConfigEntity.getSendBackFlag()).thenReturn(SendBack.PRIVIOUS.getValue());
        when(menuRepository.getTableAndSchemaByWfActConfig(wfActionConfigEntity2.getActionconfigId(), Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
        when(wfActConfUserRequestDto.getOfficeId()).thenReturn(38l);
        when(wfActConfUserRequestDto.getMenuId()).thenReturn(5l);
        when(wfActionConfigEntity.getToWorkFlowRoleId()).thenReturn(2L);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class))).thenReturn(lstWfUserDto);
        when(wfActionConfigRepository.findUserByNextWfRoleAndBTId(wfActConfUserRequestDto.getOfficeId(), wfActConfUserRequestDto.getMenuId(), wfActionConfigEntity.getToWorkFlowRoleId(), wfActionConfigEntity.getToBranchTypeId(), Constant.ACTIVE_STATUS)).thenReturn(stWfUserDto);
        wfActionConfigService.getUsersByWfActConfigId(wfActConfUserRequestDto);
        when(wfActionConfigEntity.getSendBackFlag()).thenReturn(SendBack.REWORK.getValue());
        when(wfActConfUserRequestDto.getOfficeId()).thenReturn(38l);
        when(wfActConfUserRequestDto.getMenuId()).thenReturn(5l);
        when(wfActionConfigEntity.getToWorkFlowRoleId()).thenReturn(2L);
        when(wfActionConfigEntity.getToBranchTypeId()).thenReturn(507L);
        when(wfActionConfigRepository.findUserByNextWfRoleAndBTId(wfActConfUserRequestDto.getOfficeId(), wfActConfUserRequestDto.getMenuId(), wfActionConfigEntity.getToWorkFlowRoleId(), wfActionConfigEntity.getToBranchTypeId(), Constant.ACTIVE_STATUS)).thenReturn(stWfUserDto);
        assertNotNull(wfActionConfigService.getUsersByWfActConfigId(wfActConfUserRequestDto));
    }
    @Test
    void submitWfActConfigTrn() throws SQLException {
        when(wfActionConfigSubmitTrnDto.getWfDetails()).thenReturn(wfActionConfigTrnDtos);
        when(wfActionConfigSubmitTrnDto.getWfDetails().get(0)).thenReturn(wfActionConfigTrnDto);
        when(wfActionConfigSubmitTrnDto.getWfDetails().get(0).getActionConfigId()).thenReturn(1003l);
        when(menuRepository.getTableAndSchemaByWfActConfig(wfActionConfigSubmitTrnDto.getWfDetails().get(0).getActionConfigId(), Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
        when(wfActionConfigSubmitTrnDto.getWfDetails().get(0).getTrnId()).thenReturn(35l);
        when(wfRepo.executeNativeUpdateSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(1);
        List<WfActionConfigTrnDto> wfDetails = wfActionConfigSubmitTrnDto.getWfDetails();
        WfActionConfigTrnDto wfActionConfigTrnDto = new WfActionConfigTrnDto();
        wfActionConfigTrnDto.setActionConfigId(1003l);
        WfUserDetails wfUserDetails = new WfUserDetails();
        wfUserDetails.setOfficeId(38L);
        wfUserDetails.setPostId(14L);
        wfUserDetails.setPouId(14L);
        wfUserDetails.setUserId(23);
        wfActionConfigTrnDto.setAssignedBy(wfUserDetails);
        wfActionConfigTrnDto.setAssignedTo(wfUserDetails);
        when(wfActionConfigSubmitTrnDto.getWfDetails()).thenReturn(wfDetails);
        assertNotNull(wfActionConfigService.submitWfActConfigTrn(wfActionConfigSubmitTrnDto));
        
    }
    @Test
    void getCurrentTrnStatus() throws CustomException {
        when(dto.getMenuId()).thenReturn(1l);
        when(menuRepository.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(), Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
        when(dto.getEventId()).thenReturn(1l);
        when(menuRepository.findByMenuIdAndActiveStatusAndEventId(dto.getMenuId(), Constant.ACTIVE_STATUS, dto.getEventId())).thenReturn(lkMenuTblInfoEntity);
        dto.setTrnId(1L);
        objarray = new ArrayList<>();
        Object[] obj = new Object[15];
        obj[0] = 15;
        obj[1] = "Test";
        objarray.add(obj);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objarray);
        assertNotNull(wfActionConfigService.getCurrentTrnStatus(dto));
    }
    @Test
    void getUsersForForwardWf() throws CustomException {
        when(wfActConfUserRequestDto.getMenuId()).thenReturn(5l);
        when(wfActConfUserRequestDto.getOfficeId()).thenReturn(5l);
        when(wfActConfUserRequestDto.getWfActionConfigId()).thenReturn(1001l);
        when(wfActConfUserRequestDto.getWfActionConfigId()).thenReturn(1001l);
        when(wfActionConfigEntity.getToBranchTypeId()).thenReturn(1L);
        when(wfActionConfigEntity.getToWorkFlowRoleId()).thenReturn(1l);
        assertNotNull(wfActionConfigService.getUsersForForwardWf(wfActConfUserRequestDto, wfActionConfigEntity));

    }
    @Test
    void getUsersForPreviousWf() throws CustomException {
        when(wfActConfUserRequestDto.getMenuId()).thenReturn(5l);
        when(wfActConfUserRequestDto.getOfficeId()).thenReturn(5l);
        when(wfActConfUserRequestDto.getWfActionConfigId()).thenReturn(1001l);
        when(wfActConfUserRequestDto.getPouId()).thenReturn(1l);
        MsWorkflowRoleEntity msWorkflowRoleEntity = new MsWorkflowRoleEntity();
        msWorkflowRoleEntity.setWfRoleId(2);
        when(wfActConfUserRequestDto.getTrnId()).thenReturn(1l);
        when(wfActConfUserRequestDto.getWfActionConfigId()).thenReturn(1001l);
        when(wfActionConfigEntity.getToBranchTypeId()).thenReturn(1L);
        when(wfActionConfigEntity.getToWorkFlowRoleId()).thenReturn(1l);
        when(wfActionConfigEntity.getFromWorkFlowRoleEntity()).thenReturn(msWorkflowRoleFromEntity);
        when(msWorkflowRoleFromEntity.getWfRoleId()).thenReturn(1l);
        when(menuRepository.getTableAndSchemaByWfActConfig(wfActionConfigEntity.getActionconfigId(), Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
        List<WfUserDto> users = new ArrayList<>();
        WfUserDto userDto = new WfUserDto();
        userDto.setBranchId(1l);
        userDto.setOfficeId(1l);
        userDto.setPouId(1l);
        userDto.setUserId(1l);
        userDto.setPostId(1l);
        users.add(userDto);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap(), Mockito.any(Class.class))).thenReturn(users);
        assertNotNull(wfActionConfigService.getUsersForPreviousWf(wfActConfUserRequestDto, wfActionConfigEntity));

    }
}