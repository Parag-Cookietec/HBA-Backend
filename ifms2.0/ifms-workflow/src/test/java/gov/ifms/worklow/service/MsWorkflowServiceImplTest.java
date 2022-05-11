package gov.ifms.worklow.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gov.ifms.common.util.EncryptDecryptUtil;
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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.workflow.converter.MsWorkflowConverter;
import gov.ifms.workflow.dto.AssignedToTrnDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.entity.MsWorkflowActionEntity;
import gov.ifms.workflow.entity.MsWorkflowEntity;
import gov.ifms.workflow.entity.PvuTrnEmpCrWfEntity;
import gov.ifms.workflow.repository.LkMenuTblInfoRepository;
import gov.ifms.workflow.repository.MsWorkflowActionRepository;
import gov.ifms.workflow.repository.MsWorkflowRepository;
import gov.ifms.workflow.repository.PvuTrnEmpCrWfRepository;
import gov.ifms.workflow.repository.TrnBudWfRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.service.MsWorkflowServiceImpl;
import gov.ifms.workflow.util.WorkFlowConstant;

@TestInstance(Lifecycle.PER_CLASS)
class MsWorkflowServiceImplTest {

	@InjectMocks
	private MsWorkflowServiceImpl msWorklowServiceImp;
	@Mock
	private MsWorkflowRepository repository;
	@Mock
	private EDPMsOfficeRepository officeRepo;
	@Mock
	private TrnBudWfRepository trnBudWfRepo;
	@Mock
	private PvuTrnEmpCrWfRepository trnWfRepo;
	@Mock
	private MsWorkflowActionRepository wfActionRepo;
	@Mock
	private MsWorkflowConverter converter;
	@Mock
	private List<MsWorkflowEntity> entity;
	@Mock
	private MsWorkflowEntity msWorkflowsEntity;
	@Mock
	private SpecificationImpl<MsWorkflowEntity> spec;
	@Mock
	private Page<MsWorkflowEntity> pageDetail;
	@Mock
	private PageDetails pageDetails;
	@Mock
	private Specification<MsWorkflowEntity> empSpec;
	@Mock
	private PageRequest pageable;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private List<EDPSDTDto> edpSdtDto;
	@Mock
	private List<MsWorkflowEntity> workflowStatus;
	@Mock
	private EDPMsOfficeEntity officeTypeId;
	@Mock
	WfRequestDto dto;
	@Mock
	PvuTrnEmpCrWfEntity pvuTrnEmpCrWfEntity;
	@Mock
	EncryptDecryptUtil securityUtil;
	@Mock
	private MsWorkflowActionEntity wfActionId;
	@Mock
	private MsWorkflowActionEntity wfActionId1;
	@Mock
	private EDPLuLookUpInfoEntity ed;
	@Mock
	private List<WfUserDto> dtos;
	@Mock
	private MsWorkflowActionEntity msWorkflowActionEntity;

	@Mock
	private LkMenuTblInfoRepository menuRepository;

	@Mock
	private LkMenuTblInfoEntity lkMenuTblInfoEntity;
	@Mock
	private LkMenuTblInfoEntity lkMenuTblInfoEntity1;
	

	@Mock
	WfRequestDto wfrequestdto;
	@Mock
	WfRequestDto wfrequestDto1;

	@Mock
	WfRepository wfRepo;

	@Mock
	AssignedToTrnDto assigndto;

	@Mock
	List<Long> wfRoleIdList;

	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getMsWorkflowsTest() {
		when(repository.findAll()).thenReturn(entity);
		assertNotNull(msWorklowServiceImp.getMsWorkflows());
		verify(repository, times(1)).findAll();
	}

	@Test
	void getMsWorkflowsByIdTest() {
		when(repository.getOne(1l)).thenReturn(msWorkflowsEntity);
		assertNotNull(msWorklowServiceImp.getMsWorkflow(1l));
		verify(repository, times(1)).getOne(1l);
	}

	@Test
	void saveOrUpdateMsWorkflowTest() {
		when(repository.save(msWorkflowsEntity)).thenReturn(msWorkflowsEntity);
		assertNotNull(msWorklowServiceImp.saveOrUpdateMsWorkflow(msWorkflowsEntity));
		verify(repository, times(1)).save(msWorkflowsEntity);
	}

	@Test
	void deleteMsWorkflowTest() {
		msWorklowServiceImp.deleteMsWorkflow(1l);
		verify(repository, times(1)).deleteById(1l);
	}

	@Test
	void saveMsWorkflowsTest() {
		when(repository.saveAll(entity)).thenReturn(entity);
		assertNotNull(msWorklowServiceImp.saveMsWorkflows(entity));
		verify(repository, times(1)).saveAll(entity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void msWorkflowAsMethodNameSearchTest() {
		when(pageDetails.getPageDetails(pageDetails)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(WorkFlowConstant.STRING);
		searchParam.setValue(WorkFlowConstant.STRING);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetails.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetail(spec, list)).thenReturn(empSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class)))
				.thenReturn(pageDetail);
		when(pageDetail.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(msWorklowServiceImp.msWorkflowAsMethodNameSearch(pageDetails));
	}

	@Test
	void getMsWorkflowStatusTest() {
		when(repository.findDistinctByMenuId(1l)).thenReturn(workflowStatus);
		assertNotNull(msWorklowServiceImp.getMsWorkflowStatus(1l));

	}

	
//	@Test
// TODO fix this test case.	
	void getUsersByWfActionIdTest() throws CustomException {
		when(wfrequestdto.getWfActionId()).thenReturn(1l);
		when(wfrequestdto.getEventId()).thenReturn(2l);
		when(wfrequestdto.getTrnId()).thenReturn(1l);
		when(wfrequestdto.getMenuId()).thenReturn(1l);
		when(wfrequestdto.getNextWfRoleId()).thenReturn(1l);
		when(wfrequestdto.getOfficeId()).thenReturn(1l);
		when(wfrequestdto.getMenuId()).thenReturn(1l);
		when(wfrequestdto.getNextWfRoleId()).thenReturn(1l);
		when(wfrequestdto.getWfActionId()).thenReturn(1l);
		when(wfActionRepo.findByWfActionNameAndValidWfActionId("Rework", 1)).thenReturn(wfActionId);
		when(wfActionRepo.findByWfActionNameAndValidWfActionId("Send Back", 1)).thenReturn(wfActionId);
		when(wfActionRepo.findByWfActionNameAndValidWfActionId("Return", 1)).thenReturn(wfActionId);
		when(menuRepository.findByMenuIdAndActiveStatusAndEventIdIsNull(wfrequestdto.getMenuId(),Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
		when(menuRepository.findByMenuIdAndActiveStatusAndEventId(1l,Constant.ACTIVE_STATUS,2l)).thenReturn(lkMenuTblInfoEntity);
		when(wfActionId.getWfActionId()).thenReturn(1l);
		when(trnWfRepo.findReworkActionUPO(1l, 1l, 1l)).thenReturn(dtos);
		when(lkMenuTblInfoEntity.getSchemaName()).thenReturn("abcd");
		when(lkMenuTblInfoEntity.getTrnWfTblName()).thenReturn("abcdef");
		List<Object[]> objLst = new ArrayList<>();
		Object[] obj= new Object[4];
		obj[0] = 1l;
		obj[1] = "Test";
		obj[2] = 1l;
		obj[3] = 1l;
		objLst.add(obj);
		when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objLst);
		assertNotNull(msWorklowServiceImp.getUsersByWfActionId(wfrequestdto));
		
		when(wfrequestdto.getWfActionId()).thenReturn(2l);

		assertNotNull(msWorklowServiceImp.getUsersByWfActionId(wfrequestdto));

	}

		//@Test
	void getNextWfActionsTest() throws CustomException {
		when(dto.getOfficeId()).thenReturn(1l);
		when(dto.getUserId()).thenReturn("123");
		when(dto.getPostId()).thenReturn(1l);
		when(dto.getOfficeId()).thenReturn(1l);
		when(dto.getMenuId()).thenReturn(1l);
		when(dto.getTrnId()).thenReturn(1l);
		when(dto.getLkPOUId()).thenReturn(25l);
		when(dto.getEventId()).thenReturn(2l);
		when(wfRoleIdList.get(0)).thenReturn(1l);
		when(wfRoleIdList.size()).thenReturn(1);
		when(dto.getWfRoleIds()).thenReturn(wfRoleIdList);
		List<Long> wfRoleIds = dto.getWfRoleIds();
		wfRoleIds.add(1l);
		wfRoleIds.add(2l);
		wfRoleIds.add(3l);
		when(dto.getWfRoleIds()).thenReturn(wfRoleIds);
		ArrayList<Long> arrayList = new ArrayList<>();
		arrayList.add(1L);
		when(dto.getWfRoleIds()).thenReturn(arrayList);
		when(officeRepo.getOne(1l)).thenReturn(officeTypeId);
		when(officeTypeId.getOfficeTypeId()).thenReturn(ed);
		when(ed.getLookUpInfoId()).thenReturn(1l);
		when(trnWfRepo.findByTrnIdAndActiveStatus(1l, Constant.ACTIVE_STATUS))
				.thenReturn(Optional.of(pvuTrnEmpCrWfEntity));
		when(pvuTrnEmpCrWfEntity.getAssignToWfRoleId()).thenReturn(1l);
		when(repository.verifyUserWfRole(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyInt())).thenReturn(1l);
		when(securityUtil.decrypt(String.valueOf(dto.getUserId()))).thenReturn("123");
		when(repository.findWorkflowRuleIdAndWfActions(1l, 1l, 1l, Constant.VALID_WF_ACTION_ID, 0)).thenReturn(entity);
		when(menuRepository.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(), Constant.ACTIVE_STATUS))
				.thenReturn(lkMenuTblInfoEntity);
		when(menuRepository.findByMenuIdAndActiveStatusAndEventId(dto.getMenuId() ,Constant.ACTIVE_STATUS, dto.getEventId())).thenReturn(lkMenuTblInfoEntity);
		Object[] obj = new Object[2];
		obj[0] = 1;
		obj[1] = 1;
		when(wfRepo.executeNativeSQLQuerySingleResult(Mockito.anyString(),Mockito.anyMap())).thenReturn(obj);
		when(repository.findWfInitWfRoleId(dto.getMenuId(), Constant.ACTIVE_STATUS, 71)).thenReturn(1l);
		when(assigndto.getAssignToActionLevel()).thenReturn(1);
		when(assigndto.getAssignToWfRoleId()).thenReturn(1l);
		when(repository.verifyUserWfRole(dto.getMenuId(), assigndto.getAssignToWfRoleId(), Constant.ACTIVE_STATUS, dto.getLkPOUId())).thenReturn(1l);
		msWorklowServiceImp.getNextWfActions(dto);
		when(trnWfRepo.findByTrnIdAndActiveStatus(1l, Constant.ACTIVE_STATUS)).thenReturn(Optional.empty());
		when(repository.findWfInitWfRoleId(1l, Constant.ACTIVE_STATUS, 71)).thenReturn(1l);
		msWorklowServiceImp.getNextWfActions(dto);
		when(pvuTrnEmpCrWfEntity.getAssignToWfRoleId()).thenReturn(2l);
		when(repository.findWfInitWfRoleId(1l, Constant.ACTIVE_STATUS, 71)).thenReturn(2l);
		msWorklowServiceImp.getNextWfActions(dto);
		when(dto.getLkPOUId()).thenReturn(null);
		msWorklowServiceImp.getNextWfActions(dto);

	}

}
