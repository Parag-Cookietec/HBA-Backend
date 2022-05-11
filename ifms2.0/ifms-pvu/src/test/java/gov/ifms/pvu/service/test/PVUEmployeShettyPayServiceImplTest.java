package gov.ifms.pvu.service.test;

import static gov.ifms.pvu.util.PvuConstant.EVENT_CODE_SHETTY_PAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeShettyPayConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUEmployeShettyPayDto;
import gov.ifms.pvu.dto.PVUEmployeeCurrentDetailDto;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUEmployeePostDetailDto;
import gov.ifms.pvu.dto.PVUEmployeeShettyPayAuditViewDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeShettyPayEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeShettyPayRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUMsEventRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeShettyPayServiceImpl;
import gov.ifms.pvu.service.PVUEmployeSuspensionService;
import gov.ifms.pvu.service.PVUEmployeeEOLeaveService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUEmployeShettyPayServiceImplTest.
 */
class PVUEmployeShettyPayServiceImplTest {

	/** The pvu employe shetty pay service impl. */
	@InjectMocks
	private PVUEmployeShettyPayServiceImpl service;

	/** The pvu employe shetty pay repository. */
	@Mock
	private PVUEmployeShettyPayRepository repository;

	/** The pvu employe shetty pay entity. */
	@Mock
	private PVUEmployeShettyPayEntity entity;

	/** The pvu employe shetty pay dto. */
	@Mock
	private PVUEmployeShettyPayDto dtoSP;

	@Mock
	private PVUEmployeShettyPayConverter converter;

	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;
	@Mock
	private PVUMsEventRepository msRepository;

	@Mock
	private PVUMsEventEntity msEntity;
	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private List<PvuWFWrapperDto> wfWrapperDto;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmpEventStatusEntity;

	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private PVUEmployeDepartmentEntity department;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private PVUCommonService pvuCommonService;

	@Mock
	private List<PVURopRemarksDto> listROPRemarks;

	@Mock
	private PvuCommonRequest request;

	@Mock
	private IdDto idDDto;

	@Mock
	private PVUCommonApiDto pvuCommonApiDto;

	@Mock
	private PVUEmployeeCurrentDetailDto currentDetails;

	@Mock
	private PVUEmployeePostDetailDto postDetails;

	@Mock
	private EDPMsOfficeEntity officeEntity;

	@Mock
	private PVUEmployeeShettyPayAuditViewDto viewDto;

	@Mock
	private PvuPrintStickerReportDto printStickerReportDto;

	@Mock
	private PVUPrintEndorsementEntity pvuPrintEntity;

	@Mock
	private PVUPrintEndorsementItrEntity pvuPrintItrEntity;

	@Mock
	private PVUPrintEndorsementRepository printRepository;

	@Mock
	private PVUPrintEndorsementItrRepository printItrRepository;

	@Mock
	private PVUInwardRepository pvuInwardRepository;

	@Mock
	private PVUPrintEndorsementItrConverter printItrConverter;

	@Mock
	private PVUStickerDTO pvuStickerDTO;

	@Mock
	private OAuthService authService;

	@Mock
	private PVUMsPayScaleEntity pvuMsPayScaleEntity;

	@Mock
	private PVUMsGradePayEntity pvuMsGradePayEntity;

	@Mock
	private IdNameDto idNameDto;

	@Mock
	private EDPMsUserRepository edpMsUserRepository;

	@Mock
	private PVUPrintEndorsementDto pvuPrintEndorsementDto;

	@Mock
	private PVUEmployeEventsService eventsService;

	@Mock
	private PVUEmployeEventsRepository eventRepostory;

	@Mock
	private PVUEmployeeEOLeaveService eoLeaveService;

	@Mock
	private PVUEmployeEventsEntity pvuEmployeEventsEntity;

	@Mock
	private PVUEmployeeEOLeaveEntity pvuEmployeeEOLeaveEntity;

	@Mock
	private PVUEmployeSuspensionService suspensionService;

	@Mock
	private PVUEmployeSuspensionEntity suspensionEntity;

	@Mock
	private PVUEmployeeEventStatusDto pvuEmpEventStatusDto;

	@Mock
	private EDPLuLookUpInfoEntity lEntity;

	@Mock
	private EncryptDecryptUtil securityUtil;

	private String EMPNO = "11000001";

	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get employe shetty pay.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws CustomException      the custom exception
	 */
	@Test
	void testGetEmployeShettyPay() throws CustomException {
		when(repository.getOne(91L)).thenReturn(entity);
		assertEquals(entity, service.getEmployeShettyPay(91L));
		verify(repository, times(1)).getOne(91L);
	}

	@Test
	void testSaveOrUpdatePVUEmployeeShettyPayCase1() throws CustomException {
		PVUEmployeShettyPayDto dto = new PVUEmployeShettyPayDto();
		dto.setEmployeeId(1l);
		dto.setId(1l);
		PVUEmployeShettyPayEntity entitySP = new PVUEmployeShettyPayEntity();
		entitySP.setEmpId(new PVUEmployeEntity(1l));
		entitySP.setId(1l);
		entitySP.setTrnNo("TT");
		when(repository.findById(1l)).thenReturn(Optional.of(entitySP));
		when(repository.save(entitySP)).thenReturn(entitySP);
		when(converter.toEntity(dto)).thenReturn(entitySP);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(service.saveOrUpdateEmployeShettyPay(dto)).thenReturn(dto);
		assertNotNull(when(service.saveOrUpdateEmployeShettyPay(dto)).thenReturn(dto));
	}

	@Test
	void testSaveOrUpdatePVUEmployeeShettyPayCase2() throws CustomException {
		PVUEmployeShettyPayDto dto = new PVUEmployeShettyPayDto();
		dto.setEmployeeId(12);
		dto.setId(1l);
		PVUEmployeShettyPayEntity entitySP = new PVUEmployeShettyPayEntity();
		entitySP.setEmpId(new PVUEmployeEntity(1l));
		entitySP.setId(1l);
		entitySP.setTrnNo("XD");
		PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity = new PVUEmployeeEventStatusEntity();
		pvuEmployeeEventStatusEntity.setShettyPay(1l);
		pvuEmployeeEventStatusEntity.setActiveStatus(1);
		pvuEmpEventStatusDto.setInProgress(false);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		doNothing().when(pvuEmployeeEventStatusService)
				.resetInProgressEmployeeEventStatus(entitySP.getEmpId().getEmpId(), 0l);
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusEntity);
		when(repository.findById(1l)).thenReturn(Optional.of(entitySP));
		when(converter.toDTO(entitySP)).thenReturn(dto);
		when(converter.toEntity(dto)).thenReturn(entitySP);
		when(repository.save(entitySP)).thenReturn(entitySP);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(service.saveOrUpdateEmployeShettyPay(dto)).thenReturn(dto);
		assertNotNull(when(service.saveOrUpdateEmployeShettyPay(dto)).thenReturn(dto));
	}

	@Test
	void testSaveOrUpdatePVUEmployeeShettyPayCase3() throws CustomException {
		PVUEmployeShettyPayDto dto = new PVUEmployeShettyPayDto();
		dto.setEmployeeId(1l);
		PVUEmployeShettyPayEntity entitySP = new PVUEmployeShettyPayEntity();
		entitySP.setEmpId(new PVUEmployeEntity(1l));
		entitySP.setTrnNo("RVS");
		entitySP.setStatusId(new EDPLuLookUpInfoEntity(1l));
		PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity = new PVUEmployeeEventStatusEntity();
		pvuEmployeeEventStatusEntity.setReversion(1l);
		pvuEmployeeEventStatusEntity.setActiveStatus(1);
		PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto = new PVUEmployeeEventStatusDto();
		pvuEmployeeEventStatusDto.setInProgress(false);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(converter.toEntity(dto)).thenReturn(entitySP);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(repository.save(entitySP)).thenReturn(entitySP);
		when(converter.toEntity(dto)).thenReturn(entitySP);
		assertNotNull(when(service.saveOrUpdateEmployeShettyPay(dto)).thenReturn(dto));
	}

	@Test
	void testLookupEmployeeSp() throws CustomException {
		assertNotNull(service.getAllLuLookUpInfoAsMap());
	}

	@Test
	void insertShettyPayItr() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				1, "Approved")).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(entity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dtoSP);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(dtoSP.getEmployeeId()).thenReturn(1l);
		when(dtoSP.getEventOrderDate()).thenReturn(LocalDate.now());
		when(dtoSP.getTrnNo()).thenReturn("2020");
		when(dtoSP.getEventCode()).thenReturn("SP");
		when(dtoSP.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				1, Constant.SUBMIT)).thenReturn(luEntity);
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmpEventStatusEntity)).thenReturn(pvuEmpEventStatusDto);
		when(pvuEmpEventStatusDto.isInProgress()).thenReturn(false);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(entity.getTrnNo()).thenReturn("20-21/PVU/STP/000078");
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmpEventStatusEntity));
		when(pvuCommonService.getTransactionNumber(PvuConstant.TranNo.STP.toString())).thenReturn("STP");
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmpId().getEmpId()))
				.thenReturn(pvuEmpEventStatusEntity);
		when(pvuEmpEventStatusEntity.isEventInProgress()).thenReturn(false);
		EDPLuLookUpInfoEntity lkentity = new EDPLuLookUpInfoEntity();
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.APPROVED)).thenReturn(lkentity);
		assertNotNull(service.insertShettyPayItr(pvuWFWrapperDto));
	}

	@Test
	void testGetSPSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.searchShettyPayEvents(pageDetail));

	}

	@Test
	void testGetSPInwardSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getShettyPayInwardList(pageDetail));

	}

	@Test
	void testGetSPAuditorSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getSPAuditorSearchList(pageDetail));

	}

	@Test
	void testGetSPOutwardList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getSPOutwardList(pageDetail));

	}

	@Test
	void testGenerateOutwardNumber() throws CustomException {
		List<IdDto> dtos = new ArrayList<IdDto>();
		assertNotNull(service.generateOutwardNumber(dtos));

	}

	@Test
	void submitSPOutward() throws CustomException {
		List<PvuWFOutWardWrapperDto> wrapperDto = new ArrayList<>();
		assertNotNull(service.submitSPOutward(wrapperDto));
	}

	@Test
	void testGetSPPrintEndorsements() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getSPPrintEndorsements(pageDetail));

	}

	@Test
	void testUpdateSPRemarks() throws CustomException {
		entity.setId(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(entity);
		when(entity.getStatusId()).thenReturn(luEntity);
		when(entity.getStatusId().getLookUpInfoId()).thenReturn(1l);
		dtoSP.setStatusId(entity.getStatusId().getLookUpInfoId());
		when(converter.updateSPRemarks(entity, dtoSP)).thenReturn(entity);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(edpLuLookUpInfoEntity);
		when(dtoSP.getReturnReasons()).thenReturn(listROPRemarks);
		when(dtoSP.getId()).thenReturn(1l);
		when(service.updateSPRemarks(dtoSP)).thenReturn(dtoSP);
		assertNotNull(service.updateSPRemarks(dtoSP));
	}

	@Test
	void testGetPVUResponse() throws CustomException {
		Map<String, Object> map = new HashMap<>();
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(entity.getEmpId().getEmployeeCode()).thenReturn(1200000122l);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeEntity.getEmployeeCode()).thenReturn(1200000122l);
		when(entity.getOfficeId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(1l);
		when(entity.getPayCommission()).thenReturn(luEntity);
		when(entity.getPayCommission().getLookUpInfoId()).thenReturn(1l);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		map.put(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue(), entity.getEmpId().getEmployeeCode());
		map.put(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue(), entity.getPayCommission().getLookUpInfoId());
		map.put(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue(),
				PvuUtils.getStrOfLocalDateInYMD(entity.getEventEffectiveDate()));
		map.put("IN_OFFICE_ID", entity.getOfficeId().getOfficeId());
		map.put("IN_PAGE_SIZE", 10);
		map.put("IN_PAGE_INDEX", 0);
		map.put("IN_EVENT_ID", 0);
		when(pvuCommonService.getCommonDetailsBasedOnEventDate(map)).thenReturn(pvuCommonApiDto);
		when(converter.toPVUObjCommon(pvuCommonApiDto, entity)).thenReturn(currentDetails);
		when(converter.toPVUObj(entity)).thenReturn(postDetails);
		when(repository.findById(16l)).thenReturn(Optional.of(entity));
		when(idDDto.getId()).thenReturn(16l);
		assertNotNull(service.getPVUResponse(idDDto));
	}

	@Test
	void testGenerateInwardNumber() throws CustomException {
		List<IdDto> dtos = new ArrayList<IdDto>();
		IdDto idto = new IdDto();
		idto.setId(1l);
		dtos.add(idto);
		assertNotNull(service.generateInwardNumber(dtos));
	}

	@Test
	void testCheckEligibleforShettyPay() throws CustomException, ParseException {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put(PvuConstant.EMPLOYEE_ID, 1);
		data.put(PvuConstant.EMPLOYEE_NO, 11222);

		data.put(PvuConstant.DATE_OF_NEXT_INC, "01/01/2006");
		data.put(PvuConstant.EFFECTIVE_DATE, "01/01/2006");
		data.put(PvuConstant.SHP_EVENT_ID, 1l);
		when(request.getData()).thenReturn(data);
		when(eventsService.findOneByEmpIdAndEventName(1l, PvuConstant.EVENT_CODE_EOL))
				.thenReturn(pvuEmployeEventsEntity);
		when(pvuEmployeEventsEntity.getTrnNo()).thenReturn("111");
		when(repository.findByEmpIdEmpIdAndActiveStatus(1l, Constant.ACTIVE_STATUS))
				.thenReturn(new ArrayList<PVUEmployeShettyPayEntity>());
		when(pvuEmployeDepartmentRepository.findOneByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		EDPMsDepartmentEntity parent = new EDPMsDepartmentEntity();
		parent.setDepartmentCode(PvuConstant.SP_HEAD_DEPT_CODE);
		when(department.getParentHeadDept()).thenReturn(parent);
		String sDate1 = "1/1/2006";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		when(department.getDateOfJoiningGOG()).thenReturn(date1);

		when(eoLeaveService.getOneByTrnNo(pvuEmployeEventsEntity.getTrnNo())).thenReturn(pvuEmployeeEOLeaveEntity);
		when(pvuEmployeeEOLeaveEntity.getStartDate()).thenReturn(LocalDate.now());
		when(pvuEmployeeEOLeaveEntity.getEndDate()).thenReturn(LocalDate.now());
		when(suspensionService.getOneByTrnNo(pvuEmployeEventsEntity.getTrnNo())).thenReturn(suspensionEntity);
		when(suspensionEntity.getSusStartDate()).thenReturn(LocalDate.now());
		when(suspensionEntity.getSusEndDate()).thenReturn(LocalDate.now());
		when(eventsService.findOneByEmpIdAndEventName(1l, PvuConstant.EVENT_CODE_SUSPENSION))
				.thenReturn(pvuEmployeEventsEntity);
		when(eventRepostory.findOneByEmpIdAndEventNameAndActiveStatus(1l, PvuConstant.EVENT_NAME_SHETTY_PAY, 1))
				.thenReturn(null);
		assertNotNull(service.checkEligibleforShettyPay(request));
	}

	@Test
	void testdeleteSPEventsDetails() throws CustomException {
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(entity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(idDDto.getId()).thenReturn(1l);

		assertNotNull(service.deleteSPEventsDetails(idDDto));
	}

	@Test
	void testsubmitSPOutward() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		List<PvuWFOutWardWrapperDto> wrapperDtos = new ArrayList<PvuWFOutWardWrapperDto>();
		assertNotNull(service.submitSPOutward(wrapperDtos));
		;
	}

	@Test
	void testSubmitShettyPayInwardOrDistributor() throws CustomException {
		List<PvuWFWrapperDto> wrapperDto = new ArrayList<PvuWFWrapperDto>();
		PvuWFWrapperDto wd = new PvuWFWrapperDto();
		wrapperDto.add(wd);
		assertNotNull(service.submitShettyPayInwardOrDistributor(wrapperDto));
	}

	@Test
	void testgetPVUOfficeName() throws CustomException {
		when(idDDto.getId()).thenReturn(16l);
		assertEquals(null, service.getPVUOfficeName(idDDto));
	}

	@Test
	void testGenPrintEndorsement() throws CustomException {
		when(printStickerReportDto.getPvuWFWrapperDto()).thenReturn(pvuWFWrapperDto);
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(printStickerReportDto.getPvuWFWrapperDto().getTrnId()).thenReturn(1l);
		when(repository.getOne(1l)).thenReturn(entity);

		when(printRepository.findOneByTrnIdAndEventIdAndActiveStatus(
				printStickerReportDto.getPvuWFWrapperDto().getTrnId(), PvuConstant.SHETTY_PAY_PVU_EVENT_ID,
				Constant.ACTIVE_STATUS)).thenReturn(pvuPrintEntity);
		when(printRepository.save(pvuPrintEntity)).thenReturn(pvuPrintEntity);

		when(printItrConverter.toEntity(pvuPrintEntity)).thenReturn(pvuPrintItrEntity);
		when(printItrRepository.save(pvuPrintItrEntity)).thenReturn(pvuPrintItrEntity);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(printStickerReportDto.getStickerDTO()).thenReturn(pvuStickerDTO);
		when(pvuStickerDTO.getEmployeeNo()).thenReturn(EMPNO);
		when(pvuStickerDTO.getEmployeeName()).thenReturn(EMPNO);
		when(pvuStickerDTO.getDesignation()).thenReturn(EMPNO);
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(pvuStickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(pvuStickerDTO.getCellValue()).thenReturn("11");
		when(pvuStickerDTO.getLevelValue()).thenReturn("11");
		when(entity.getAuthorizeBy()).thenReturn(11l);
		when(idNameDto.getName()).thenReturn("test");
		when(edpMsUserRepository.getOnlyIdAndName(11l)).thenReturn(idNameDto);
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy()).getName()).thenReturn("test");
		when(lookupinforepository.findBylookUpInfoId(1l)).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(entity.getEmpId().getSalutation()).thenReturn(luEntity);
		when(entity.getOfficeId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(1l);
		when(entity.getEmpId().getEmployeeName()).thenReturn("TEST");
		when(entity.getEmpId().getGender()).thenReturn(luEntity);
		when(entity.getPayCommission()).thenReturn(luEntity);
		when(entity.getcPayScale()).thenReturn(pvuMsPayScaleEntity);
		when(entity.getcGradePayId()).thenReturn(pvuMsGradePayEntity);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(pvuStickerDTO.getEndorsementReprintDate()).thenReturn(new Date());
		assertNotNull(pvuStickerDTO.getEndorsementReprintDate());
		when(printStickerReportDto.getPrintEndorsementDto()).thenReturn(pvuPrintEndorsementDto);

		assertNotNull(service.generatePrintEndorsement(printStickerReportDto));
	}

	@Test
	void testGenPrintEndorsementcase2() throws CustomException {
		when(printStickerReportDto.getPvuWFWrapperDto()).thenReturn(pvuWFWrapperDto);
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(printStickerReportDto.getPvuWFWrapperDto().getTrnId()).thenReturn(1l);
		when(printRepository.findOneByTrnIdAndEventIdAndActiveStatus(
				printStickerReportDto.getPvuWFWrapperDto().getTrnId(), PvuConstant.SHETTY_PAY_PVU_EVENT_ID,
				Constant.ACTIVE_STATUS)).thenReturn(null);
		when(printRepository.save(pvuPrintEntity)).thenReturn(pvuPrintEntity);

		when(printItrConverter.toEntity(pvuPrintEntity)).thenReturn(pvuPrintItrEntity);
		when(printItrRepository.save(pvuPrintItrEntity)).thenReturn(pvuPrintItrEntity);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(printStickerReportDto.getStickerDTO()).thenReturn(pvuStickerDTO);
		when(pvuStickerDTO.getEmployeeNo()).thenReturn(EMPNO);
		when(pvuStickerDTO.getEmployeeName()).thenReturn(EMPNO);
		when(pvuStickerDTO.getDesignation()).thenReturn(EMPNO);
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(pvuStickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(pvuStickerDTO.getCellValue()).thenReturn("11");
		when(pvuStickerDTO.getLevelValue()).thenReturn("11");
		when(entity.getAuthorizeBy()).thenReturn(11l);
		when(idNameDto.getName()).thenReturn("test");
		when(edpMsUserRepository.getOnlyIdAndName(11l)).thenReturn(idNameDto);
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy()).getName()).thenReturn("test");
		when(lookupinforepository.findBylookUpInfoId(1l)).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(entity.getEmpId().getSalutation()).thenReturn(luEntity);

		when(entity.getEmpId().getEmployeeName()).thenReturn("TEST");
		when(entity.getEmpId().getGender()).thenReturn(luEntity);
		when(entity.getPayCommission()).thenReturn(luEntity);
		when(entity.getOfficeId()).thenReturn(officeEntity);

		when(officeEntity.getOfficeId()).thenReturn(38l);
		when(officeEntity.getPvuId()).thenReturn(38l);
		when(entity.getOfficeId().getOfficeId()).thenReturn(38l);
		when(entity.getOfficeId().getPvuId()).thenReturn(38l);
		when(entity.getcPayScale()).thenReturn(pvuMsPayScaleEntity);
		when(entity.getcGradePayId()).thenReturn(pvuMsGradePayEntity);
		when(pvuStickerDTO.getEndorsementReprintDate()).thenReturn(new Date());
		when(repository.getOne(1l)).thenReturn(entity);
		when(printStickerReportDto.getPrintEndorsementDto()).thenReturn(pvuPrintEndorsementDto);
		List<PvuPrintStickerReportDto> list = new ArrayList<PvuPrintStickerReportDto>();
		list.add(printStickerReportDto);
		assertNotNull(service.generatePrintEndorsement(list));
	}

	@Test
	void testGetReprintEndorsementRemarks() throws CustomException {
		Map<String, Object> map = new HashMap<>();
		List<Object[]> objects = new ArrayList<Object[]>();
		map.put(PvuConstant.TRN_ID, 11l);
		map.put(PvuConstant.EVENT_ID, PvuConstant.SHETTY_PAY_PVU_EVENT_ID);
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(), map))
				.thenReturn(objects);
		assertNotNull(service.getReprintEndorsementRemarks(11l));
	}

	@Test
	void testGetRemarkByeventId() throws CustomException {
		Map<String, Object> map = new HashMap<>();
		List<Object[]> objects = new ArrayList<Object[]>();
		map.put(PvuConstant.SHP_EVENT_ID, 16);
		map.put(PvuConstant.PVU_EVENT_ID, 11l);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		when(msRepository.findByEventCode(EVENT_CODE_SHETTY_PAY)).thenReturn(Optional.of(msEntity));
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getShettyPayReturnRemarks(), map))
				.thenReturn(objects);
		assertNotNull(service.getRemarkByeventId(11l));
	}

	@Test
	void insertShettyPayItr1() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));

		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(entity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dtoSP);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Rejected");
		when(dtoSP.getEmployeeId()).thenReturn(1l);
		when(dtoSP.getEventOrderDate()).thenReturn(LocalDate.now());
		when(dtoSP.getTrnNo()).thenReturn("2020");
		when(dtoSP.getEventCode()).thenReturn("SP");
		when(dtoSP.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				1, Constant.SUBMIT)).thenReturn(luEntity);
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmpEventStatusEntity)).thenReturn(pvuEmpEventStatusDto);
		when(pvuEmpEventStatusDto.isInProgress()).thenReturn(false);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmpEventStatusEntity));
		when(pvuCommonService.getTransactionNumber(PvuConstant.TranNo.STP.toString())).thenReturn("STP");
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmpId().getEmpId()))
				.thenReturn(pvuEmpEventStatusEntity);
		when(pvuEmpEventStatusEntity.isEventInProgress()).thenReturn(false);
		EDPLuLookUpInfoEntity lkentity = new EDPLuLookUpInfoEntity();
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.APPROVED)).thenReturn(lkentity);
		when(entity.getStatusId()).thenReturn(luEntity);

		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.REJECTED)).thenReturn(lEntity);
		assertNotNull(service.insertShettyPayItr(pvuWFWrapperDto));
	}

	@Test
	void insertShettyPayItr2() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn(Constant.AUTHORIZE_BY_CLASS_II);
		when(pvuWFWrapperDto.getTrnStatus()).thenReturn(Constant.AUTHORIZE_BY_CLASS_II);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));

		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(entity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dtoSP);
		when(pvuWFWrapperDto.getAssignByUserId()).thenReturn("MuAtEHdI4AY=");
		when(dtoSP.getEmployeeId()).thenReturn(1l);
		when(dtoSP.getEventOrderDate()).thenReturn(LocalDate.now());
		when(dtoSP.getTrnNo()).thenReturn("2020");
		when(dtoSP.getEventCode()).thenReturn("SP");
		when(dtoSP.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(securityUtil.decrypt(pvuWFWrapperDto.getAssignByUserId())).thenReturn("1");

		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				1, Constant.SUBMIT)).thenReturn(luEntity);
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmpEventStatusEntity)).thenReturn(pvuEmpEventStatusDto);
		when(pvuEmpEventStatusDto.isInProgress()).thenReturn(false);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmpEventStatusEntity));
		when(pvuCommonService.getTransactionNumber(PvuConstant.TranNo.STP.toString())).thenReturn("STP");
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmpId().getEmpId()))
				.thenReturn(pvuEmpEventStatusEntity);
		when(pvuEmpEventStatusEntity.isEventInProgress()).thenReturn(false);
		EDPLuLookUpInfoEntity lkentity = new EDPLuLookUpInfoEntity();
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.APPROVED)).thenReturn(lkentity);
		when(entity.getStatusId()).thenReturn(luEntity);
		when(entity.getClassTwoRemarks()).thenReturn("test");
		when(entity.getPayBandValue()).thenReturn(5000l);
		when(entity.getGradePay()).thenReturn(pvuMsGradePayEntity);
		when(pvuMsGradePayEntity.getGradePayValue()).thenReturn("100000");
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.AUTHORIZE)).thenReturn(lEntity);
		assertNotNull(service.insertShettyPayItr(pvuWFWrapperDto));
	}

}
