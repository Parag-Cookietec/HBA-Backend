package gov.ifms.pvu.service.test;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVURevisionOfPayConverter;
import gov.ifms.pvu.converter.PVURopEventConfigurationConverter;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVURevisionOfPayDto;
import gov.ifms.pvu.dto.PVURevisionOfPaySearchView;
import gov.ifms.pvu.dto.PVURopDetailRequest;
import gov.ifms.pvu.dto.PVURopEmployeView;
import gov.ifms.pvu.dto.PVURopPostDetailView;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.dto.PVURopView;
import gov.ifms.pvu.dto.PVUSteppingUpEventDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.RopEmployeeDetailDto;
import gov.ifms.pvu.dto.response.RopConfigurationDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVURevisionOfPayEntity;
import gov.ifms.pvu.entity.PVURopEventConfigurationEntity;
import gov.ifms.pvu.entity.PVURopRemarksEntity;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRepository;
import gov.ifms.pvu.repository.PVURopEventConfigurationRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUMsReasonService;
import gov.ifms.pvu.service.PVURevisionOfPayServiceImpl;
import gov.ifms.pvu.service.PVURopRemarksService;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.StringWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PVURevisionOfPayServiceImplTest {

	@InjectMocks
	private PVURevisionOfPayServiceImpl service;

	@Mock
	private PVURevisionOfPayRepository repository;

	@Mock
	private PVURopEventConfigurationRepository pvuRopEventConfigRepository;

	@Mock
	private PVURevisionOfPayConverter converter;

	@Mock
	private PVUCommonService pvuCommonService;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	private PVURopEventConfigurationConverter ropEventConfigConerter;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private PVURevisionOfPayRemarkRepository remarkRepository;

	@Mock
	private PVUEmployeRepository pvuEmployeRepository;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PVUMsReasonService pvuMsReasonService;

	@Mock
	private PVURopRemarksService pvuRopRemarksService;

	@Mock
	private PVURevisionOfPayEntity pvuRevisionOfPayEntity;

	@Mock
	private List<RopConfigurationDto> lstRopConfigurationDto;

	@Mock
	private PVUEmployeEntity employeeEntity;

	@Mock
	private Template template;
	
	@Mock
	private StringWriter writer;
	
	@Mock
	private VelocityContext context; 
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetRevisionOfPayById() {
		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		assertEquals(pvuRevisionOfPayEntity, service.getRevisionOfPayById(1l));
		verify(repository, times(1)).findById(1L);
	}

	@Test
	public void testGetRevisionOfPaysSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		PagebleDTO<PVURevisionOfPaySearchView> data = service.getRevisionOfPaysSearchList(pageDetail);
		assertNotNull(data);
	}

	@Test
	public void testSaveOrUpdateRevisionOfPayOldSameEmployee() throws CustomException {
		PVURevisionOfPayDto dto = new PVURevisionOfPayDto();
		dto.setId(1L);
		dto.setEmpId(1L);

		PVURevisionOfPayEntity ropEntity = new PVURevisionOfPayEntity();
		ropEntity.setEmpId(new PVUEmployeEntity(1L));

		when(repository.findById(1l)).thenReturn(Optional.of(ropEntity));
		when(converter.updateRopEntity(ropEntity, dto)).thenReturn(ropEntity);
		when(repository.save(ropEntity)).thenReturn(ropEntity);
		when(converter.toDTO(ropEntity)).thenReturn(dto);
		assertNotNull(service.saveOrUpdateRevisionOfPay(dto));
	}

	@Test
	public void testSaveOrUpdateRevisionOfPayOldDifferentEmployee() throws CustomException {
		PVURevisionOfPayDto dto = new PVURevisionOfPayDto();
		dto.setId(1L);
		dto.setEmpId(2L);

		PVURevisionOfPayEntity ropEntity = new PVURevisionOfPayEntity();
		ropEntity.setEmpId(new PVUEmployeEntity(1L));
		ropEntity.setTrnNo("ROP");

		PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto = new PVUEmployeeEventStatusDto();
		pvuEmployeeEventStatusDto.setInProgress(false);

		PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity = new PVUEmployeeEventStatusEntity();

		when(repository.findById(1l)).thenReturn(Optional.of(ropEntity));
		when(pvuEmployeeEventStatusService.findPVUEmployeeStatusDto(dto.getEmpId()))
				.thenReturn(pvuEmployeeEventStatusDto);
		doNothing().when(pvuEmployeeEventStatusService)
				.resetInProgressEmployeeEventStatus(ropEntity.getEmpId().getEmpId(), 0l);
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusEntity);
		when(converter.updateRopEntity(ropEntity, dto)).thenReturn(ropEntity);
		when(repository.save(ropEntity)).thenReturn(ropEntity);
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusEntity);
		when(converter.toDTO(ropEntity)).thenReturn(dto);
		assertNotNull(service.saveOrUpdateRevisionOfPay(dto));
	}

	@Test
	public void testSaveOrUpdateRevisionOfPayOldDifferentEmployeeEventNotInSystem() throws CustomException {
		Throwable exception = assertThrows(CustomException.class, () -> {
			PVURevisionOfPayDto dto = new PVURevisionOfPayDto();
			dto.setId(1L);
			dto.setEmpId(2L);

			PVURevisionOfPayEntity ropEntity = new PVURevisionOfPayEntity();
			ropEntity.setEmpId(new PVUEmployeEntity(1L));
			ropEntity.setTrnNo("ROP");

			when(repository.findById(1l)).thenReturn(Optional.of(ropEntity));
			when(pvuEmployeeEventStatusService.findPVUEmployeeStatusDto(dto.getEmpId())).thenReturn(null);
			service.saveOrUpdateRevisionOfPay(dto);
		});
		assertEquals("Employee details not available", exception.getMessage());
	}

	@Test
	public void testSaveOrUpdateRevisionOfPayNewEmployee() throws CustomException {
		PVURevisionOfPayDto dto = new PVURevisionOfPayDto();
		dto.setEmpId(1L);

		PVURevisionOfPayEntity ropEntity = new PVURevisionOfPayEntity();
		ropEntity.setEmpId(new PVUEmployeEntity(1L));
		ropEntity.setTrnNo("ROP");

		PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto = new PVUEmployeeEventStatusDto();
		pvuEmployeeEventStatusDto.setInProgress(false);

		EDPLuLookUpInfoEntity statusId = new EDPLuLookUpInfoEntity(1L);

		when(pvuEmployeeEventStatusService.findPVUEmployeeStatusDto(dto.getEmpId()))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(converter.toEntity(dto)).thenReturn(ropEntity);
		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(statusId);
		when(repository.save(ropEntity)).thenReturn(ropEntity);
		when(converter.toDTO(ropEntity)).thenReturn(dto);
		assertNotNull(service.saveOrUpdateRevisionOfPay(dto));
	}

	@Test
	public void testGetRevisionOfPay() {
		PVURevisionOfPayDto PVURevisionOfPayDto = new PVURevisionOfPayDto();
		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(converter.toDTO(pvuRevisionOfPayEntity)).thenReturn(PVURevisionOfPayDto);
		assertNotNull(service.getRevisionOfPay(1L));
	}

	@Test
	public void testSubmitRopEventForSaveAsDraft() throws CustomException {
		boolean vBool = true;
		EDPLuLookUpInfoEntity saveAsDraft = new EDPLuLookUpInfoEntity(1l);
		EDPLuLookUpInfoEntity submitStatus = new EDPLuLookUpInfoEntity(2l);

		PVURevisionOfPayEntity pvuRevisionOfPayEntity = new PVURevisionOfPayEntity();
		pvuRevisionOfPayEntity.setStatusId(saveAsDraft);

		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setAssignByWfRoleId(12l);

		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(vBool);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(saveAsDraft);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SUBMIT)).thenReturn(submitStatus);
		doNothing().when(repository).updateStatusId(submitStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());

		List<Object[]> lstObject = new ArrayList<>();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());

		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_ITRS));
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject);
		assertTrue(service.submitRopEvent(wrapperDto));
	}

	@Test
	public void testSubmitRopEventForApprover() throws CustomException {
		boolean vBool = true;
		EDPLuLookUpInfoEntity saveAsDraft = new EDPLuLookUpInfoEntity(1l);
		EDPLuLookUpInfoEntity submitStatus = new EDPLuLookUpInfoEntity(2l);
		EDPLuLookUpInfoEntity printEnable = new EDPLuLookUpInfoEntity();
		Object getResult = 0l;
		PVURevisionOfPayEntity pvuRevisionOfPayEntity = new PVURevisionOfPayEntity();
		pvuRevisionOfPayEntity.setStatusId(submitStatus);
		pvuRevisionOfPayEntity.setTrnNo(Constant.ANN1_TAB);

		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setAssignByWfRoleId(12l);
		wrapperDto.setWfStatus(Constant.APPROVED);
		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(vBool);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(saveAsDraft);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.CONDITION_CHECK, Constant.ACTIVE_STATUS, Constant.LOOKUP_YES)).thenReturn(printEnable);
		doNothing().when(repository).updatePrintStatusAndApproveDate(Constant.ACTIVE_STATUS, wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date(), printEnable.getLookUpInfoId(), new Date());

		String procName1 = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.P_PVU_ROP_AUTO_INCR));
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put("IN_TRN_NO", pvuRevisionOfPayEntity.getTrnNo());
		when(repository.callUsingCallableStmt(procName1, map1)).thenReturn(getResult);

		List<Object[]> lstObject = new ArrayList<>();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());

		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_ITRS));
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject);
		assertTrue(service.submitRopEvent(wrapperDto));
	}

	@Test
	public void testSubmitRopEventForReject() throws CustomException {
		boolean vBool = true;
		EDPLuLookUpInfoEntity saveAsDraft = new EDPLuLookUpInfoEntity(1l);
		EDPLuLookUpInfoEntity submitStatus = new EDPLuLookUpInfoEntity(2l);
		EDPLuLookUpInfoEntity rejectedStatus = new EDPLuLookUpInfoEntity();

		PVURevisionOfPayEntity pvuRevisionOfPayEntity = new PVURevisionOfPayEntity();
		pvuRevisionOfPayEntity.setStatusId(submitStatus);
		pvuRevisionOfPayEntity.setEmpId(new PVUEmployeEntity(1L));
		pvuRevisionOfPayEntity.setTrnNo(Constant.ANN1_TAB);

		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setAssignByWfRoleId(12l);
		wrapperDto.setWfStatus(Constant.REJECTED);
		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(vBool);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(saveAsDraft);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.REJECTED)).thenReturn(rejectedStatus);
		doNothing().when(repository).updateStatusId(rejectedStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(
				pvuRevisionOfPayEntity.getEmpId().getEmpId(), OAuthUtility.getCurrentUserLkPOUId());

		List<Object[]> lstObject1 = new ArrayList<>();
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_DDO_REJECTION_CASE));
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_NO", pvuRevisionOfPayEntity.getTrnNo());
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject1);

		List<Object[]> lstObject = new ArrayList<>();
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map1.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());

		String procName1 = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_ITRS));
		when(repository.callStoredProcedure(procName1, map1)).thenReturn(lstObject);
		assertTrue(service.submitRopEvent(wrapperDto));
	}

	@Test
	public void testSubmitRopEventForAuthorize() throws CustomException {
		boolean vBool = true;
		EDPLuLookUpInfoEntity saveAsDraft = new EDPLuLookUpInfoEntity(1l);
		EDPLuLookUpInfoEntity submitStatus = new EDPLuLookUpInfoEntity(2l);
		EDPLuLookUpInfoEntity authorizationStatus = new EDPLuLookUpInfoEntity();

		PVURevisionOfPayEntity pvuRevisionOfPayEntity = new PVURevisionOfPayEntity();
		pvuRevisionOfPayEntity.setStatusId(submitStatus);
		pvuRevisionOfPayEntity.setEmpId(new PVUEmployeEntity(1L));

		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus(Constant.AUTHORIZE_BY_CLASS_II);
		wrapperDto.setAssignByWfRoleId(20l);
		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(vBool);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(saveAsDraft);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.AUTHORIZE))
						.thenReturn(authorizationStatus);
		doNothing().when(repository).updateStatusId(authorizationStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		doNothing().when(repository).updateAutorizedDate(Constant.ACTIVE_STATUS, wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date(), new Date());

		List<Object[]> lstObject = new ArrayList<>();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());

		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_ITRS));
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject);

		assertTrue(service.submitRopEvent(wrapperDto));
	}

	@Test
	public void testSubmitRopEventForReturn() throws CustomException {
		boolean vBool = true;
		EDPLuLookUpInfoEntity saveAsDraft = new EDPLuLookUpInfoEntity(1l);
		EDPLuLookUpInfoEntity submitStatus = new EDPLuLookUpInfoEntity(2l);
		EDPLuLookUpInfoEntity returnStatus = new EDPLuLookUpInfoEntity();

		PVURevisionOfPayEntity pvuRevisionOfPayEntity = new PVURevisionOfPayEntity();
		pvuRevisionOfPayEntity.setStatusId(submitStatus);
		pvuRevisionOfPayEntity.setEmpId(new PVUEmployeEntity(1L));

		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus(Constant.RETURN_BY_APPROVER_CLASS_II);
		wrapperDto.setAssignByWfRoleId(20l);
		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(vBool);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(saveAsDraft);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.RETURN)).thenReturn(returnStatus);
		doNothing().when(repository).updateStatusId(returnStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		doNothing().when(repository).updateAutorizedDate(Constant.ACTIVE_STATUS, wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date(), new Date());
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(
				pvuRevisionOfPayEntity.getEmpId().getEmpId(), OAuthUtility.getCurrentUserLkPOUId());

		List<Object[]> lstObject = new ArrayList<>();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());

		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_ITRS));
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject);

		assertTrue(service.submitRopEvent(wrapperDto));
	}

	@Test
	public void testSubmitRopEventForForwardToPvu() throws CustomException {
		boolean vBool = true;
		EDPLuLookUpInfoEntity saveAsDraft = new EDPLuLookUpInfoEntity(1l);
		EDPLuLookUpInfoEntity submitStatus = new EDPLuLookUpInfoEntity(2l);
		EDPLuLookUpInfoEntity returnStatus = new EDPLuLookUpInfoEntity();

		PVURevisionOfPayEntity pvuRevisionOfPayEntity = new PVURevisionOfPayEntity();
		pvuRevisionOfPayEntity.setStatusId(submitStatus);
		pvuRevisionOfPayEntity.setEmpId(new PVUEmployeEntity(1L));

		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus(Constant.FORWARD_TO_PVU);
		wrapperDto.setTrnStatus("");
		wrapperDto.setAssignByWfRoleId(14l);

		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(vBool);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(saveAsDraft);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.RETURN)).thenReturn(returnStatus);

		List<Object[]> lstObject = new ArrayList<>();
		Map<String, Object> map = new LinkedHashMap<>();
		String procName = Constant.PVU_SCHEMA;
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject);
		assertTrue(service.submitRopEvent(wrapperDto));
	}

	@Test
	public void testInsertRopRemarksITR() {
		List<Object[]> lstObject = new ArrayList<>();

		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, 1L);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_REMARKS_ITRS));
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject);
		service.insertRopRemarksITR(1L);
		verify(repository, times(1)).callStoredProcedure(procName, map);

	}

	@Test
	public void testInsertRopITR() {
		List<Object[]> lstObject = new ArrayList<>();
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setTrnId(1L);
		pvuWFWrapperDto.setCurrentWorkflowId(1L);

		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());

		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_ITRS));
		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObject);
		service.insertRopITR(pvuWFWrapperDto);
		verify(repository, times(1)).callStoredProcedure(procName, map);
	}

	@Test
	public void testSaveOrUpdate() throws CustomException {
		when(repository.save(pvuRevisionOfPayEntity)).thenReturn(pvuRevisionOfPayEntity);
		assertEquals(pvuRevisionOfPayEntity, service.saveOrUpdate(pvuRevisionOfPayEntity));
	}

	@Test
	public void testRopPostDetails() throws CustomException {
		List<PVURopPostDetailView> objStorePro = new ArrayList<>();
		PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_ROP_POST_DETAIL_SP));
		Map<String, Object> map = new HashMap<>();
		map.put("ROP_TYPE", pvuRopDetailRequest.getRopType());

		when(repository.storeProc(procName, map, PVURopPostDetailView.class)).thenReturn(objStorePro);
		assertNotNull(service.ropPostDetails(pvuRopDetailRequest));
	}

	@Test
	public void testUpdateRopRemarks() throws CustomException {
		List<PVURopRemarksEntity> lstRopRemarks = new ArrayList<>();
		List<PVURopRemarksDto> lstPVURopRemarksDto = new ArrayList<>();
		PVURopRemarksDto pvuRopRemarksDto = new PVURopRemarksDto();
		pvuRopRemarksDto.setId(1l);
		lstPVURopRemarksDto.add(pvuRopRemarksDto);

		PVURevisionOfPayEntity entity = new PVURevisionOfPayEntity();
		PVURevisionOfPayDto dto = new PVURevisionOfPayDto();
		dto.setId(1L);
		dto.setWfRoleId(14l);
		dto.setAuditorReturnReason(Constant.RETURN_VAL);
		dto.setReturnReasons(lstPVURopRemarksDto);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(converter.updateRopRemarks(entity, dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		doNothing().when(pvuRopRemarksService).deactiveOldReason(dto.getId(), Constant.IN_ACTIVE_STATUS);
		doNothing().when(pvuRopRemarksService).saveOrUpdateRopRemarksAll(lstRopRemarks);
		assertEquals(dto, service.updateRopRemarks(dto));
	}

	@Test
	public void testGetRevisionOfPayView() throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_PVU_RP_EVNT_ID", 1l);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_ROP_VIEW_DATA));
		List<Object[]> lstObjects = new ArrayList<>();
		Object objectArray[] = new Object[1];
		objectArray[0] = 1L;
		lstObjects.add(objectArray);

		when(repository.callStoredProcedure(procName, map)).thenReturn(lstObjects);
		PVURopView pvuRopView = service.getRevisionOfPayView(1l);
		assertNotNull(pvuRopView);
	}

	@Test
	public void testDeleteRopTrns() throws CustomException {
		IdDto idDto = new IdDto();
		idDto.setId(1l);

		EDPLuLookUpInfoEntity saveAsDraft = new EDPLuLookUpInfoEntity();
		saveAsDraft.setLookUpInfoId(1L);

		PVUEmployeEntity PVUEmployeEntity = new PVUEmployeEntity();
		PVUEmployeEntity.setEmpId(1L);

		PVURevisionOfPayEntity pvuRevisionOfPayEntity = new PVURevisionOfPayEntity();
		pvuRevisionOfPayEntity.setStatusId(saveAsDraft);
		pvuRevisionOfPayEntity.setEmpId(PVUEmployeEntity);

		when(repository.findById(1l)).thenReturn(Optional.of(pvuRevisionOfPayEntity));
		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(saveAsDraft);
		assertTrue(service.deleteRopTrns(idDto));
	}

	@Test
	public void testGetRopSearchEmployes() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		PagebleDTO<PVURopEmployeView> data = service.getRopSearchEmployes(pageDetail);
		assertNotNull(data);
	}

	@Test
	public void getRopRemarkHistory() throws CustomException {
		IdDto idDto = new IdDto();
		idDto.setId(1l);
		assertNotNull(service.getRopRemarkHistory(idDto));
	}

	@Test
	public void testGetRopEmployeeDetails() throws CustomException, ParseException {
		List<RopEmployeeDetailDto> lstRopEmployeeDetailDto = new ArrayList<>();
		RopEmployeeDetailDto ropEmployeeDetailDto = new RopEmployeeDetailDto();

		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

		PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
		pvuRopDetailRequest.setEmpNo(1L);
		pvuRopDetailRequest.setEffectiveDate("2016-01-01");
		pvuRopDetailRequest.setRopType(Constant.ROP_2016);

		Map<String, Object> map = new HashMap<>();
		map.put(Constant.IN_EMPLOYEE_NO, pvuRopDetailRequest.getEmpNo());
		map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
		map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());

		ropEmployeeDetailDto.setEmpType(156l);
		ropEmployeeDetailDto.setOfficeId(1L);
		ropEmployeeDetailDto.setIsSuspended(0L);
		ropEmployeeDetailDto.setDateJoining("2005-01-01");
		ropEmployeeDetailDto.setSuspendedResumeDate("2005-01-01");
		ropEmployeeDetailDto.setIsOldEol(0L);
		ropEmployeeDetailDto.setIsOldSuspended(0l);
		ropEmployeeDetailDto.setRetirementDate("2022-01-01");

		lstRopEmployeeDetailDto.add(ropEmployeeDetailDto);
		when(repository.findRegularConverstionDate(Mockito.anyString())).thenReturn("2006-01-01");
		when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(lstRopEmployeeDetailDto);
		assertEquals(ropEmployeeDetailDto, service.getRopEmployeeDetails(pvuRopDetailRequest));
	}

	@Test
	public void testGetRopEmployeeDetailsRop2009() throws CustomException, ParseException {
		Throwable exception = assertThrows(CustomException.class, () -> {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

			PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
			pvuRopDetailRequest.setEmpNo(1L);
			pvuRopDetailRequest.setEffectiveDate("2006-01-01");
			pvuRopDetailRequest.setRopType(Constant.ROP_2009);

			Map<String, Object> map = new HashMap<>();
			map.put("IN_EMPLOYEE_NO", pvuRopDetailRequest.getEmpNo());
			map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
			map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());
			when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(null);
			service.getRopEmployeeDetails(pvuRopDetailRequest);
		});
		assertEquals(Constant.EMPLOYEE_NOT_EXIST_IN_5TH_PAY_COMMISSION, exception.getMessage());
	}

	@Test
	public void testGetRopEmployeeDetailsRop2016() throws CustomException, ParseException {
		Throwable exception = assertThrows(CustomException.class, () -> {
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

			PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
			pvuRopDetailRequest.setEmpNo(1L);
			pvuRopDetailRequest.setEffectiveDate("2016-01-01");
			pvuRopDetailRequest.setRopType(Constant.ROP_2016);

			Map<String, Object> map = new HashMap<>();
			map.put("IN_EMPLOYEE_NO", pvuRopDetailRequest.getEmpNo());
			map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
			map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());

			when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(null);
			service.getRopEmployeeDetails(pvuRopDetailRequest);
		});
		assertEquals(Constant.EMPLOYEE_NOT_EXIST_IN_6TH_PAY_COMMISSION, exception.getMessage());
	}

	@Test
	public void testGetRopEmployeeDetailsOnlyRegular() throws CustomException, ParseException {
		Throwable exception = assertThrows(CustomException.class, () -> {
			List<RopEmployeeDetailDto> lstRopEmployeeDetailDto = new ArrayList<>();
			RopEmployeeDetailDto ropEmployeeDetailDto = new RopEmployeeDetailDto();

			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

			PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
			pvuRopDetailRequest.setEmpNo(1L);
			pvuRopDetailRequest.setEffectiveDate("2016-01-01");
			pvuRopDetailRequest.setRopType(Constant.ROP_2016);

			Map<String, Object> map = new HashMap<>();
			map.put("IN_EMPLOYEE_NO", pvuRopDetailRequest.getEmpNo());
			map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
			map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());

			ropEmployeeDetailDto.setEmpType(157l);
			ropEmployeeDetailDto.setOfficeId(1L);
			ropEmployeeDetailDto.setIsSuspended(0L);
			ropEmployeeDetailDto.setDateJoining("2005-01-01");
			ropEmployeeDetailDto.setSuspendedResumeDate("2005-01-01");
			ropEmployeeDetailDto.setIsOldEol(0L);
			ropEmployeeDetailDto.setIsOldSuspended(0l);

			lstRopEmployeeDetailDto.add(ropEmployeeDetailDto);

			when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(lstRopEmployeeDetailDto);
			service.getRopEmployeeDetails(pvuRopDetailRequest);
		});
		assertEquals(Constant.ONLY_REGULAR_EMPLOYEE_ELIGABLE_FOR_ROP, exception.getMessage());
	}

	@Test
	public void testGetRopEmployeeDetailsIsSuspended() throws CustomException, ParseException {
		Throwable exception = assertThrows(CustomException.class, () -> {
			List<RopEmployeeDetailDto> lstRopEmployeeDetailDto = new ArrayList<>();
			RopEmployeeDetailDto ropEmployeeDetailDto = new RopEmployeeDetailDto();

			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

			PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
			pvuRopDetailRequest.setEmpNo(1L);
			pvuRopDetailRequest.setEffectiveDate("2016-01-01");
			pvuRopDetailRequest.setRopType(Constant.ROP_2016);

			Map<String, Object> map = new HashMap<>();
			map.put("IN_EMPLOYEE_NO", pvuRopDetailRequest.getEmpNo());
			map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
			map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());

			ropEmployeeDetailDto.setEmployeeNo("1");
			ropEmployeeDetailDto.setEmpType(156l);
			ropEmployeeDetailDto.setOfficeId(1L);
			ropEmployeeDetailDto.setIsSuspended(1L);
			ropEmployeeDetailDto.setDateJoining("2005-01-01");
			ropEmployeeDetailDto.setSuspendedResumeDate("2005-01-01");
			ropEmployeeDetailDto.setIsOldEol(0L);
			ropEmployeeDetailDto.setIsOldSuspended(0l);

			lstRopEmployeeDetailDto.add(ropEmployeeDetailDto);

			when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(lstRopEmployeeDetailDto);
			service.getRopEmployeeDetails(pvuRopDetailRequest);
		});
		assertEquals(Constant.ROP_CAN_NOT_BE_PERFORMED_ON_SUSPENDED_EMPLOYEE, exception.getMessage());
	}

	@Test
	public void testGetRopEmployeeDetailsEffectiveDateMustBeGreaterThenDateOfJoining()
			throws CustomException, ParseException {
		Throwable exception = assertThrows(CustomException.class, () -> {
			List<RopEmployeeDetailDto> lstRopEmployeeDetailDto = new ArrayList<>();
			RopEmployeeDetailDto ropEmployeeDetailDto = new RopEmployeeDetailDto();

			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

			PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
			pvuRopDetailRequest.setEmpNo(1L);
			pvuRopDetailRequest.setEffectiveDate("2016-01-01");
			pvuRopDetailRequest.setRopType(Constant.ROP_2016);

			Map<String, Object> map = new HashMap<>();
			map.put("IN_EMPLOYEE_NO", pvuRopDetailRequest.getEmpNo());
			map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
			map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());

			ropEmployeeDetailDto.setEmployeeNo("1");
			ropEmployeeDetailDto.setEmpType(156l);
			ropEmployeeDetailDto.setOfficeId(1L);
			ropEmployeeDetailDto.setIsSuspended(0L);
			ropEmployeeDetailDto.setDateJoining("2018-01-01");
			ropEmployeeDetailDto.setSuspendedResumeDate("2005-01-01");
			ropEmployeeDetailDto.setIsOldEol(0L);
			ropEmployeeDetailDto.setIsOldSuspended(0l);

			lstRopEmployeeDetailDto.add(ropEmployeeDetailDto);

			when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(lstRopEmployeeDetailDto);
			service.getRopEmployeeDetails(pvuRopDetailRequest);
		});
		assertEquals(Constant.EVENT_EFFECTIVE_DATE_MUST_BE_GREATER_THAN_DATE_OF_JOINING, exception.getMessage());
	}

	@Test
	public void testGetRopEmployeeDetailsIsOldEol() throws CustomException, ParseException {
		assertThrows(CustomException.class, () -> {
			List<RopEmployeeDetailDto> lstRopEmployeeDetailDto = new ArrayList<>();
			RopEmployeeDetailDto ropEmployeeDetailDto = new RopEmployeeDetailDto();

			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

			PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
			pvuRopDetailRequest.setEmpNo(1L);
			pvuRopDetailRequest.setEffectiveDate("2016-01-01");
			pvuRopDetailRequest.setRopType(Constant.ROP_2016);

			Map<String, Object> map = new HashMap<>();
			map.put("IN_EMPLOYEE_NO", pvuRopDetailRequest.getEmpNo());
			map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
			map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());

			ropEmployeeDetailDto.setEmployeeNo("1");
			ropEmployeeDetailDto.setEmpType(156l);
			ropEmployeeDetailDto.setOfficeId(1L);
			ropEmployeeDetailDto.setIsSuspended(0L);
			ropEmployeeDetailDto.setDateJoining("2005-01-01");
			ropEmployeeDetailDto.setSuspendedResumeDate("2005-01-01");
			ropEmployeeDetailDto.setIsOldEol(1L);
			ropEmployeeDetailDto.setEolResumeDate("2016-02-02");
			ropEmployeeDetailDto.setIsOldSuspended(0l);
			ropEmployeeDetailDto.setRetirementDate("2022-01-01");

			lstRopEmployeeDetailDto.add(ropEmployeeDetailDto);

			when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(lstRopEmployeeDetailDto);
			service.getRopEmployeeDetails(pvuRopDetailRequest);
		});
		assertTrue(true);
	}

	@Test
	public void testGetRopEmployeeDetailsIsOldSuspension() throws CustomException, ParseException {
		assertThrows(CustomException.class, () -> {
			List<RopEmployeeDetailDto> lstRopEmployeeDetailDto = new ArrayList<>();
			RopEmployeeDetailDto ropEmployeeDetailDto = new RopEmployeeDetailDto();

			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_EMPLOYEE_DETAIL));

			PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
			pvuRopDetailRequest.setEmpNo(1L);
			pvuRopDetailRequest.setEffectiveDate("2016-01-01");
			pvuRopDetailRequest.setRopType(Constant.ROP_2016);

			Map<String, Object> map = new HashMap<>();
			map.put("IN_EMPLOYEE_NO", pvuRopDetailRequest.getEmpNo());
			map.put("IN_EFFECTIVE_DATE", pvuRopDetailRequest.getEffectiveDate());
			map.put("IN_ROP_TYPE", pvuRopDetailRequest.getRopType());

			ropEmployeeDetailDto.setEmployeeNo("1");
			ropEmployeeDetailDto.setEmpType(156l);
			ropEmployeeDetailDto.setOfficeId(1L);
			ropEmployeeDetailDto.setIsSuspended(0L);
			ropEmployeeDetailDto.setDateJoining("2005-01-01");
			ropEmployeeDetailDto.setSuspendedResumeDate("2016-02-01");
			ropEmployeeDetailDto.setIsOldEol(0L);
			ropEmployeeDetailDto.setEolResumeDate("2016-02-02");
			ropEmployeeDetailDto.setIsOldSuspended(1l);
			ropEmployeeDetailDto.setRetirementDate("2038-01-01");

			lstRopEmployeeDetailDto.add(ropEmployeeDetailDto);

			when(repository.storeProc(procName, map, RopEmployeeDetailDto.class)).thenReturn(lstRopEmployeeDetailDto);
			service.getRopEmployeeDetails(pvuRopDetailRequest);
		});
		assertTrue(true);
	}

	@Test
	public void testGetPVUOfficeName() {
		String officeName = "abc";
		IdDto idDto = new IdDto();
		idDto.setId(1l);

		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.ROP_EVENT_ID, idDto.getId());

		List<Object[]> lstObjects = new ArrayList<>();
		Object objectArray[] = new Object[1];
		objectArray[0] = officeName;
		lstObjects.add(objectArray);

		when(remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getRopEmployeeOfficeId(), map))
				.thenReturn(lstObjects);
		EDPMsOfficeDto dto = service.getPVUOfficeName(idDto);
		assertEquals(dto.getOfficeName(), officeName);
	}

	@Test
	public void testGetPVURevisionOfPaysSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		PagebleDTO<PVURevisionOfPaySearchView> data = service.getPVURevisionOfPaysSearchList(pageDetail);
		assertNotNull(data);
	}

	@Test
	public void testGetReturnReasonByTransactionId() throws CustomException {
		List<PVURopRemarksDto> list = service.getReturnReasonByTransactionId(1l);
		assertNotNull(list);
	}

	@Test
	public void testGetRopReasons() {
		List<PVUMsReasonDto> list = new ArrayList<>();
		when(pvuMsReasonService.getRopReasons()).thenReturn(list);
		assertNotNull(service.getRopReasons());
	}

	@Test
	public void testAuthorizedRop() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, 1l);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_AUTHORIZED_ROP));
		service.authorizedRop(1l);
		verify(repository, times(1)).callStoredProcedure(procName, map);
	}

	@Test
	public void testRopGivenPrevious() throws CustomException, ParseException {
		PVURopDetailRequest pvuRopDetailRequest = new PVURopDetailRequest();
		pvuRopDetailRequest.setEmpNo(1L);
		pvuRopDetailRequest.setEffectiveDate("2016-01-01");
		pvuRopDetailRequest.setRopType(Constant.ROP_2009);
		when(pvuEmployeRepository.findByEmployeeCodeAndActiveStatus(1L,1)).thenReturn(Optional.of(employeeEntity));
		assertFalse(service.ropGivenPrevious(pvuRopDetailRequest));
	}

	@Test
	public void testRopConfigurationList() {
		List<PVURopEventConfigurationEntity> lstRopConfiguration = new ArrayList<>();
		when(pvuRopEventConfigRepository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(lstRopConfiguration);
		when(ropEventConfigConerter.toDTO(lstRopConfiguration)).thenReturn(lstRopConfigurationDto);
		assertEquals(lstRopConfigurationDto, service.ropConfigurationList());
	}

	@Test
	public void testSubmitAutoIncrement() throws CustomException {
		Object getResult = 0l;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, Constant.ANN1_TAB);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.P_PVU_ROP_AUTO_INCR));
		when(repository.callUsingCallableStmt(procName, map)).thenReturn(getResult);
		service.submitAutoIncrement(Constant.ANN1_TAB);
	}

	@Test
	public void testRejectRop() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, Constant.ANN1_TAB);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ROP_DDO_REJECTION_CASE));
		service.rejectROP(Constant.ANN1_TAB);
		verify(repository, times(1)).callStoredProcedure(procName, map);
	}

	@Test
	void testGetPrintTemplate() throws CustomException {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template tempName = new Template();
		service.generateDdoApprovalCertificate();
	}

	@Test
	public void testGeneratePrint() throws CustomException {
		IdDto dto = new IdDto();
		dto.setId(1l);

		when(repository.getOne(dto.getId())).thenReturn(pvuRevisionOfPayEntity);

		Map<String, Object> map = new HashMap<>();

		List<Object[]> lstObjects = new ArrayList<>();
		Object objectArray[] = new Object[5];

		lstObjects.add(objectArray);

		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getDDONameAndDesignationAndLocation(), map))
				.thenReturn(lstObjects);

		Map<String, Object> map1 = new HashMap<>();

		List<Object[]> lstObjects1 = new ArrayList<>();
		Object objectArray1[] = new Object[1];
		lstObjects1.add(objectArray1);
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getRopApprovedDate(), map1)).thenReturn(lstObjects1);
		when(context.get("steppingUpType")).thenReturn("STP");
		template.merge(context, writer);
		//service.generateDdoApprovalCertificatePDF(dto);
	}
	
}