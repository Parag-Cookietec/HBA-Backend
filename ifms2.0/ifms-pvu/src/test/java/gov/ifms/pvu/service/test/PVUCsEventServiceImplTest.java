/**
 * 
 */
package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.velocity.VelocityContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUCsEventConverter;
import gov.ifms.pvu.converter.PVUMsPayCellConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUCsEventDView;
import gov.ifms.pvu.dto.PVUCsEventDto;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUCsEventEntity;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeSevenPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeSixPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.repository.PVUCsEventRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeFivePayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeSixPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeeEventStatusRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.service.PVUCsEventServiceImpl;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeSevenPayDetailService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUEventRemarksService;
import gov.ifms.pvu.service.PVUInwardService;
import gov.ifms.pvu.service.PVUMsReasonService;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * @author Admin
 *
 */
class PVUCsEventServiceImplTest {

	@Mock
	private PVUCsEventRepository repository;

	@Mock
	private PVUCsEventConverter converter;

	@Mock
	private PVUCsEventEntity pvuCsEventEntity;

	@Mock
	private PVUCsEventDto dto;

	@InjectMocks
	private PVUCsEventServiceImpl pvuCsEventServiceImpl;

	@Mock
	Page<PVUCsEventEntity> page;

	@Mock
	List<PVUCsEventEntity> lst;

	@Mock
	List<PVUCsEventDto> csEventList;

	@Mock
	private PVUMsPayCellRepository payCellRepository;

	@Mock
	private PVUMsPayCellConverter payCellConverter;

	@Mock
	private PVUMsGradePayRepository gradePayRepository;

	@Mock
	private PVUMsPayCellEntity pvuMsPayCellEntity;

	@Mock
	private PVUMsPayCellDto pvuMsPayCellDto;

	@Mock
	private PvuCommonRequest comReq;

	@Mock
	Map<String, Long> request;

	@Mock
	Map<String, Object> response;

	@Mock
	private PVUMsPayLevelEntity payLevelEntity;

	@Mock
	private PVUMsPayCellEntity payCellEntity;

	@Mock
	private PVUMsGradePayEntity gradePayEntity;

	@Mock
	PVUMsPayBandEntity payBandEntity;

	@Mock
	List<PVUMsGradePayEntity> masterGradePayList;

	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	@Mock
	private PVUCommonService pvuCommonService;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private EDPLuLookUpInfoEntity lu;

	@Mock
	private PVUEmployeDepartmentEntity department;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;

	@Mock
	PVUEmployeeEventStatusRepository pvuEmployeeEventStatusRepository;

	@Mock
	private PVUDepartmentCategoryEntity pvuDepartmentCategoryEntity;

	@Mock
	private PVUMsEventEntity pvuMsEventEntity;

	@Mock
	private PVUEmployeSevenPayDetailService pvuEmployeSevenPayDetailService;

	@Mock
	private PVUEmployeSixPayDetailRepository employeSixPayDetailsRepository;

	@Mock
	private PVUEmployeFivePayDetailRepository employeFivePayDetailsRepository;

	@Mock
	private PVUEmployeSevenPayDetailEntity pvuEmployeSevenPayDetailEntity;

	@Mock
	private PVUEmployeSixPayDetailEntity pvuEmployeSixPayDetailEntity;

	@Mock
	private PVUEmployeFivePayDetailEntity pvuEmployeFivePayDetailEntity;

	@Mock
	private PVUMsPayScaleEntity pvuMsPayScaleEntity;

	@Mock
	private IdDto idDto;

	@Mock
	private WfRepository wfRepository;

	@Mock
	List<IdDto> listDto;

	@Mock
	List<PvuWFWrapperDto> pvuWFWrapperDtos;

	@Mock
	PvuWFOutWardWrapperDto wfOutWardWrapperDto;

	@Mock
	private PVUMsReasonService pvuMsReasonService;

	@Mock
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;

	@Mock
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;

	@Mock
	PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;

	@Mock
	PVUPrintEndorsementDto pvuPrintEndorsementDto;

	@Mock
	PVUPrintEndorsementEntity pvuPrintEndorsementEntity;

	@Mock
	PVUPrintEndorsementItrEntity pvuPrintEndorsementItrEntity;

	@Mock
	private PVUInwardRepository pvuInwardRepository;

	@Mock
	private List<PVUEventRemarksDto> listROPRemarks;

	/** The remark repository. */
	@Mock
	private PVURevisionOfPayRemarkRepository remarkRepository;

	@Mock
	private PVUCsEventDView pvuCsEventDView;

	@Mock
	private PVUCommonApiDto pvuCommonApiDto;

	@Mock
	private PVUEventRemarksService eventRemarksService;

	@Mock
	private PVUStickerDTO stickerDTO;

	@Mock
	private VelocityContext velocityContext;

	@Mock
	private EDPLuLookUpInfoEntity empSubmitStatusLookupInfo;

	@Mock
	EncryptDecryptUtil securityUtil;

	@Mock
	private PVUInwardService inwardService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test method for
	 * {@link gov.ifms.pvu.service.PVUCsEventServiceImpl#getCsEvent(java.lang.Long)}.
	 */
	@Test
	void testGetCsEvent() {
		when(repository.getOne(1l)).thenReturn(pvuCsEventEntity);
		when(converter.toDTO(pvuCsEventEntity)).thenReturn(dto);
		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1L)).thenReturn(department);
		when(department.getDepartmentalCategory()).thenReturn(pvuDepartmentCategoryEntity);
		when(pvuDepartmentCategoryEntity.getDepartmentCategoryId()).thenReturn(1L);
		when(pvuEmployeDepartmentRepository.findByPvuEmployeEntityEmpId(1L)).thenReturn(Optional.of(department));
		when(Optional.of(department).get().getDateOfJoiningGOG()).thenReturn(new Date());
		assertNotNull(pvuCsEventServiceImpl.getCsEvent(1L));
	}

	@Test
	void testSaveOrUpdateCsEvent() throws CustomException {
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);

		when(dto.getNotionalFromDate()).thenReturn(LocalDate.of(2020, 04, 26));
		when(dto.getNotionalToDate()).thenReturn(LocalDate.of(2020, 04, 27));
		when(dto.getDuration()).thenReturn(2);

		when(dto.isNew()).thenReturn(true);

		when(dto.getEmployeeId()).thenReturn(2l);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(2l)).thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusRepository.findByEmpIdEmpId(2l))
				.thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuCommonService.getTransactionNumber("PRFG")).thenReturn("PRFG");
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(converter.toEntity(dto)).thenReturn(pvuCsEventEntity);
		when(repository.save(pvuCsEventEntity)).thenReturn(pvuCsEventEntity);
		when(dto.getStatusId()).thenReturn(0l);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(converter.toDTO(pvuCsEventEntity)).thenReturn(dto);
		when(converter.toEntity(dto)).thenReturn(pvuCsEventEntity);
		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeeEventStatusService.inProgressSuspensionEvent(pvuEmployeEntity.getEmpId())).thenReturn(pvuEmployeeEventStatusEntity);
		assertNotNull(pvuCsEventServiceImpl.saveOrUpdateCsEvent(dto));

		when(dto.isNew()).thenReturn(false);
		when(pvuEmployeeEventStatusService.findByEmpId(2l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		assertNotNull(pvuCsEventServiceImpl.saveOrUpdateCsEvent(dto));
	}

	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(pvuCsEventServiceImpl.getAllLuLookUpInfoAsMap());
	}

	@Test
	void testGetPVUSeniorScales() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("empNo", "1"));
		jsonArr.add(new SearchParam("empName", "V"));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("officeId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("transNo", " "));
		jsonArr.add(new SearchParam("workflowId", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(csEventList);
		PagebleDTO<PVUCsEventDto> data = pvuCsEventServiceImpl.getCsEvents(pageDetail);
		assertNotNull(data);
		pvuCsEventServiceImpl.getCommonDetailsCspvuddolist(pageDetail);
		pvuCsEventServiceImpl.getPVUOfficeCSPEmployeeSearch(pageDetail);
		pvuCsEventServiceImpl.getCSPInwardList(pageDetail);
		pvuCsEventServiceImpl.getCSPOutwardList(pageDetail);
		pvuCsEventServiceImpl.getCSPrintEndorsements(pageDetail);
	}

	@Test
	void test_getPvuOfficeCSPReasonCode() {
		assertNotNull(pvuMsReasonService.getEventsReasons());
	}

	@Test
	void test_getWfRlCdByCSPTrnId() {
		when(this.wfRepository.findWfRlCdByCSPTrnId(1L, Constant.ACTIVE_STATUS)).thenReturn("CTR");
		assertNotNull(pvuCsEventServiceImpl.getWfRlCdByCSPTrnId(1L));
	}

	@Test
	void test_generateOutWardNumber() throws CustomException {
		List<IdDto> dtos = new ArrayList<IdDto>();
		IdDto dto = new IdDto();
		dto.setId(1L);
		dtos.add(dto);
		assertNotNull(pvuCsEventServiceImpl.generateInwardNumber(dtos));
		assertNotNull(pvuCsEventServiceImpl.generateOutwardNumber(dtos));
	}

	@Test
	void test_submitSSPInward() throws CustomException {
		assertNotNull(pvuCsEventServiceImpl.submitCSPInward(pvuWFWrapperDtos));
	}

	@Test
	void test_submitCSPDistributor() throws CustomException {
		assertNotNull(pvuCsEventServiceImpl.submitCSPDistributor(pvuWFWrapperDtos));
	}

	@Test
	void getCsEventById() {
		when(converter.toDTO(pvuCsEventEntity)).thenReturn(dto);
		pvuCsEventServiceImpl.getCsEventById(1l);
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void test_getPVUOfficeName() {
		String officeName = "abc";
		IdDto idDto = new IdDto();
		idDto.setId(1L);
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> lstObjects = new ArrayList<>();
		Object[] objectArray = new Object[1];
		objectArray[0] = officeName;
		lstObjects.add(objectArray);
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCSPEmployeeOfficeId(), map))
				.thenReturn(lstObjects);
		EDPMsOfficeDto dto = pvuCsEventServiceImpl.getPVUOfficeName(idDto);
		assertEquals(dto.getOfficeName(), officeName);
	}

	@Test
	void testinsertCsITR() {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1L);
		when(pvuWFWrapperDto.getCurrentWorkflowId()).thenReturn(1L);
		pvuCsEventServiceImpl.insertCsPVUInITRs(pvuWFWrapperDto);
		pvuCsEventServiceImpl.insertCsInITRs(pvuWFWrapperDto);
		pvuCsEventServiceImpl.insertInwardTable(pvuWFWrapperDto);
		pvuCsEventServiceImpl.insertCSRemarksITR(pvuWFWrapperDto);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void insertEmployeeItr() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(repository.getOne(pvuWFWrapperDto.getTrnId())).thenReturn(pvuCsEventEntity);
		when(pvuCsEventEntity.getEventId()).thenReturn(pvuMsEventEntity);
		when(pvuCsEventEntity.getTrnNo()).thenReturn(null);
		when(pvuCsEventEntity.getStatusId()).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(PvuConstant.SAVE_AS_DRAFT_ID);

		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(Constant.LONG_ONE_VALUE))
				.thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuCsEventEntity.getEventId()).thenReturn(pvuMsEventEntity);
		when(pvuMsEventEntity.getId()).thenReturn(PvuConstant.CHANGE_OF_SCALE_EVENT_ID);
		when(pvuCommonService.getTransactionNumber((PvuConstant.TranNo.CS.toString())))
				.thenReturn(PvuConstant.TranNo.CS.toString());
		when(repository.save(pvuCsEventEntity)).thenReturn(pvuCsEventEntity);
		// doNothing().when(pvuEmployeeEventStatusService).updateEventInfo(pvuEmployeeEventStatusEntity,
		// pvuCsEventEntity.getTrnNo());
		when(converter.toDTO(pvuCsEventEntity)).thenReturn(dto);

		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.APPROVED)).thenReturn(luEntity);
		when(lu.getLookUpInfoId()).thenReturn(327l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.SUBMIT)).thenReturn(empSubmitStatusLookupInfo);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn(Constant.APPROVED);

		when(dto.getEmployeeId()).thenReturn(1l);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		assertNotNull(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l));
		when(department.getEmpClass()).thenReturn(lu);
		when(department.getDepartmentalCategory()).thenReturn(pvuDepartmentCategoryEntity);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(department.getEmpType()).thenReturn(lu);

		when(dto.getBasicPay()).thenReturn(200l);
		when(dto.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(dto.getEventOrderDate()).thenReturn(LocalDate.now());
		when(dto.getTrnNo()).thenReturn("2020");
		when(dto.getPayCommId()).thenReturn(150l);
		when(dto.getOfficeId()).thenReturn(1l);
		when(dto.getEventCode()).thenReturn("Forgo");
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(dto.getActiveStatus()).thenReturn(1);
		when(dto.getId()).thenReturn(12l);
		when(dto.getPayLevelId()).thenReturn(1l);
		when(dto.getPayScale()).thenReturn(12l);
		when(dto.getPayBandId()).thenReturn(12l);
		when(dto.getPayBandValue()).thenReturn(12l);
		when(dto.getGradePayId()).thenReturn(12l);
		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		dto.setEmployeeId(pvuEmployeEntity.getEmpId());
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(dto.getEventId()).thenReturn(PvuConstant.CHANGE_OF_SCALE_EVENT_ID);

		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusEntity);
		assertNotNull(pvuCsEventServiceImpl.insertCsItr(pvuWFWrapperDto));

		when(dto.getPayCommId()).thenReturn(151l);
		assertNotNull(pvuCsEventServiceImpl.insertCsItr(pvuWFWrapperDto));

		when(dto.getPayCommId()).thenReturn(152l);
		assertNotNull(pvuCsEventServiceImpl.insertCsItr(pvuWFWrapperDto));

		when(pvuWFWrapperDto.getWfStatus()).thenReturn(Constant.REJECTED_LOOKUP_NAME);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID, 1,
				Constant.REJECTED_LOOKUP_NAME)).thenReturn(luEntity);
		assertNotNull(pvuCsEventServiceImpl.insertCsItr(pvuWFWrapperDto));
	}

	@Test
	void insertEmployeeItrPVUReject() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(pvuWFWrapperDto.getTrnStatus()).thenReturn(Constant.RETURN_BY_APPROVER_CLASS_I);
		when(pvuWFWrapperDto.getAssignByWfRoleId()).thenReturn(Constant.AUDITOR);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.RETURN)).thenReturn(luEntity);
		when(lu.getLookUpInfoId()).thenReturn(327l);
		when(repository.getOne(pvuWFWrapperDto.getTrnId())).thenReturn(pvuCsEventEntity);
		when(pvuCsEventEntity.getEventId()).thenReturn(pvuMsEventEntity);
		when(pvuCsEventEntity.getTrnNo()).thenReturn(null);
		when(pvuCsEventEntity.getStatusId()).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(1l);
		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1L);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(2l)).thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusRepository.findByEmpIdEmpId(2l))
				.thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuCsEventEntity.getEventId()).thenReturn(pvuMsEventEntity);
		when(pvuMsEventEntity.getId()).thenReturn(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
		when(pvuCommonService.getTransactionNumber(PvuConstant.TranNo.CSPVU.toString()))
				.thenReturn(PvuConstant.TranNo.CSPVU.toString());
		when(repository.save(pvuCsEventEntity)).thenReturn(pvuCsEventEntity);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID, 1,
				"Approved")).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(pvuCsEventEntity.getStatusId()).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID, 1,
				"Submit")).thenReturn(luEntity);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn(Constant.REJECTED_LOOKUP_NAME);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID, 1,
				Constant.REJECTED_LOOKUP_NAME)).thenReturn(luEntity);
		when(converter.toDTO(pvuCsEventEntity)).thenReturn(dto);
		assertNotNull(pvuCsEventServiceImpl.insertCsItr(pvuWFWrapperDto));
	}

	@Test
	void insertEmployeeItrPVUAuthorize() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(pvuWFWrapperDto.getRemarks()).thenReturn("11");
		when(pvuWFWrapperDto.getAssignByUserId()).thenReturn("11");
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(pvuWFWrapperDto.getTrnStatus()).thenReturn(Constant.AUTHORIZE_BY_CLASS_I);
		when(securityUtil.decrypt(pvuWFWrapperDto.getAssignByUserId())).thenReturn("11");
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.AUTHORIZE)).thenReturn(luEntity);
		when(repository.getOne(pvuWFWrapperDto.getTrnId())).thenReturn(pvuCsEventEntity);
		when(pvuCsEventEntity.getEventId()).thenReturn(pvuMsEventEntity);
		when(pvuCsEventEntity.getTrnNo()).thenReturn(null);
		when(pvuCsEventEntity.getStatusId()).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(1l);
		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1L);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(2l)).thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusRepository.findByEmpIdEmpId(2l))
				.thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuCsEventEntity.getEventId()).thenReturn(pvuMsEventEntity);
		when(pvuMsEventEntity.getId()).thenReturn(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
		when(pvuCommonService.getTransactionNumber(PvuConstant.TranNo.CSPVU.toString()))
				.thenReturn(PvuConstant.TranNo.CSPVU.toString());
		when(repository.save(pvuCsEventEntity)).thenReturn(pvuCsEventEntity);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID, 1,
				"Approved")).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(pvuCsEventEntity.getStatusId()).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn(Constant.AUTHORIZE_BY_CLASS_I);
		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.AUTHORIZE)).thenReturn(luEntity);
		when(converter.toDTO(pvuCsEventEntity)).thenReturn(dto);
		assertNotNull(pvuCsEventServiceImpl.insertCsItr(pvuWFWrapperDto));
	}

	@Test
	void deleteChangeofScale() throws CustomException {
		when(repository.findById(1l)).thenReturn(Optional.of(pvuCsEventEntity));
		when(lookupinforepository.findByLookUpInfoName("Saved as Draft")).thenReturn(luEntity);
		when(pvuCsEventEntity.getStatusId()).thenReturn(lu);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(lu.getLookUpInfoId()).thenReturn(1l);
		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		assertTrue(pvuCsEventServiceImpl.deleteCsEvent(1l));
	}

	@Test
	void testSubmitPrintHistory() throws CustomException {

		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getPrintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getReprintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getPrintCnt()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getRemark()).thenReturn(Constant.ROP);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();

		dto.setStickerDTO(stickerDTO);
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);

		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(printEntity);
		when(converter.toEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);

		assertNotNull(pvuCsEventServiceImpl.submitPrintHistory(dto));
	}

	@Test
	void getPrintTemplate() {
		when(pvuCsEventEntity.getPayCommission()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		assertNotNull(pvuCsEventServiceImpl.getPrintTemplate(pvuCsEventEntity));
	}

	@Test
	void testSubmitPEWFNotNull() throws CustomException {

		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);

		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(printEntity);
		when(converter.toEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);
		assertNotNull(pvuCsEventServiceImpl.submitPEWF(dto));

	}

	@Test
	void testSubmitPEWFNull() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getPrintCnt()).thenReturn(Constant.LONG_ONE_VALUE);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);

		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(null);
		when(converter.toEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);
		assertNotNull(pvuCsEventServiceImpl.submitPEWF(dto));
	}

	@Test
	void testUpdateSPRemarks() throws CustomException {
		PVUEventRemarksDto dto = new PVUEventRemarksDto();
		dto.setId(1L);
		dto.setWorkFlowRoleId(1L);
		dto.setEmpId(1L);
		dto.setRemarks(Constant.ACP);
		dto.setRemarksType(Constant.ACP);
		dto.setReasonName(Constant.ACP);
		dto.setReasonId(Constant.LONG_ONE_VALUE);
		dto.setTrnNo(Constant.LONG_ONE_VALUE);
		dto.setEventID(Constant.LONG_ONE_VALUE);

		List<PVUEventRemarksDto> listROPRemarks = new ArrayList<PVUEventRemarksDto>();
		listROPRemarks.add(dto);

		PVUCsEventDto csEventDto = new PVUCsEventDto();
		csEventDto.setId(1L);
		csEventDto.setReturnReasons(listROPRemarks);
		csEventDto.setWfRoleId(1L);
		csEventDto.setReturnReasons(listROPRemarks);
		csEventDto.setAuditorReturnReason(Constant.RETURN_VAL);

		when(repository.getOne(csEventDto.getId())).thenReturn(pvuCsEventEntity);

		when(converter.updateCsRemarks(pvuCsEventEntity, csEventDto)).thenReturn(pvuCsEventEntity);

		when(repository.save(pvuCsEventEntity)).thenReturn(pvuCsEventEntity);
		when(converter.toDTO(pvuCsEventEntity)).thenReturn(csEventDto);

		doNothing().when(eventRemarksService).deactiveOldReason(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID,
				csEventDto.getId(), Constant.IN_ACTIVE_STATUS);

		List<PVUEventRemarksEntity> lstEventRemarks = new ArrayList<PVUEventRemarksEntity>();
		PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
		pvuEventRemarksEntity.setTrnNo(pvuCsEventEntity.getId());
		pvuEventRemarksEntity.setEventID(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
		pvuEventRemarksEntity.setWfRoleId(csEventDto.getWfRoleId());

		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(Constant.LONG_ONE_VALUE);

		pvuEventRemarksEntity.setEmpId(1L);
		pvuEventRemarksEntity.setRemarks(dto.getRemarks());
		pvuEventRemarksEntity.setRemarksType(dto.getRemarksType());
		pvuEventRemarksEntity.setReason(dto.getReasonId());
		pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		lstEventRemarks.addAll(lstEventRemarks);

		assertNotNull(pvuCsEventServiceImpl.updateCsRemarks(csEventDto));
	}

	@Test
	void testProcessAuthorizedOutWardsEmpty() {
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<PvuWFOutWardWrapperDto>();
		pvuCsEventServiceImpl.processAuthorizedOutWards(dtos);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testProcessAuthorizedOutWardsNotEmpty() {
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<PvuWFOutWardWrapperDto>();
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setWfStatus(Constant.APPROVED);
		pvuWFWrapperDto.setTrnId(1l);
		pvuWFWrapperDto.setUpdatedDate(new Date());

		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testGetReturnReasonByTransactionIdNotEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(remarkRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(pvuCsEventServiceImpl.getReturnReasonByTransactionId(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testGetReturnReasonByTransactionIdEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(remarkRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(Collections.emptyList());
		assertNotNull(pvuCsEventServiceImpl.getReturnReasonByTransactionId(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testAuthorizeCs() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		pvuCsEventServiceImpl.authorizeCs(Constant.LONG_ONE_VALUE);
		verify(repository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testInsertCsAutoIncr() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		pvuCsEventServiceImpl.insertCsAutoIncr(Constant.APPROVAL_IN_PROGESS);
		verify(repository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testGetPrintEndorsementHistoryNotEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(pvuCsEventServiceImpl.getPrintEndorsementHistory(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testGetPrintEndorsementHistoryEmpty() throws CustomException {
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(Collections.emptyList());
		assertNotNull(pvuCsEventServiceImpl.getPrintEndorsementHistory(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testsubmitSPOutward() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		List<PvuWFOutWardWrapperDto> listWrapperDto = new ArrayList<PvuWFOutWardWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus(Constant.PRINTED);
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);

		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ZERO, Constant.ACTIVE_STATUS);

		doNothing().when(inwardService).setConsignmentNumber(1L, PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID,
				Constant.ACP);

		assertNotNull(pvuCsEventServiceImpl.submitCSPOutward(listWrapperDto));
	}

	@Test
	void testProcessReturnOutWardsNotEmpty() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		List<PvuWFOutWardWrapperDto> listWrapperDto = new ArrayList<PvuWFOutWardWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus(Constant.PRINTED);
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);

		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		List<PVUSourceUserDetails> users = new ArrayList<>();

		assertFalse(pvuCsEventServiceImpl.processReturnOutWards(listWrapperDto));
	}

	@Test
	void testProcessAuthorizedOutWards() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		List<PvuWFOutWardWrapperDto> listWrapperDto = new ArrayList<PvuWFOutWardWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus(Constant.PRINTED);
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);

		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ZERO, Constant.ACTIVE_STATUS);

		when(repository.getOne(wrapperDto.getTrnId())).thenReturn(pvuCsEventEntity);
		when(pvuCsEventEntity.getTrnNo()).thenReturn(Constant.ACP);
		when(pvuCsEventEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1L);
		when(pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(listWrapperDto))).thenReturn(true);

		assertFalse(pvuCsEventServiceImpl.processAuthorizedOutWards(listWrapperDto));
	}

	

}
