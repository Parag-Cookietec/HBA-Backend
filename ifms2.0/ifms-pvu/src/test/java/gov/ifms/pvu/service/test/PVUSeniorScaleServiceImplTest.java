package gov.ifms.pvu.service.test;

import com.itextpdf.text.DocumentException;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUSeniorScaleConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.response.PVUCASPrintDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUSSPPrintDto;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVUSeniorScaleRepository;
import gov.ifms.pvu.service.*;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class PVUSeniorScaleServiceImplTest {

    @InjectMocks
    private PVUSeniorScaleServiceImpl service;

    @Mock
    private PVUSeniorScaleRepository repository;

    @Mock
    private PvuPrintStickerReportDto pvuPrintStickerDto;

    @Mock
    private PVUStickerDTO stickerDTO;

    @Mock
    private PVUWfTableInfo wfTableInfo;

    @Mock
    private PVUSSPPrintDto print;

    @Mock
    private EDPMsOfficeDto edpMsOfficeDto;

    @Mock
    private PVUSeniorScaleEntity entity;

    @Mock
    private OAuthService authService;

    @Mock
    private EDPMsOfficeEntity edpMsOfficeEntity;

    @Mock
    private PVUEventsRemarkDto eventsRemarkDto;

    @Mock
    private PVUSeniorScaleConverter converter;

    /**
     * The PVUSeniorScaleRepository repository.
     */
    @Mock
    private PVUInwardService inwardService;

    @Mock
    private PVUEventRemarksService remarkService;

    @Mock
    private PVUMsReasonService pvuMsReasonService;

    @Mock
    private WfRepository wfRepository;

    @Mock
    private PVUEmployeEntity employeEntity;

    @Mock
    private GenericDao genericDao;

    @Mock
    private PVUSeniorScaleDto dto;

    @Mock
    Page<PVUSeniorScaleEntity> page;

    @Mock
    List<PVUSeniorScaleEntity> lst;

    @Mock
    List<PVUSeniorScaleDto> list;

    @Mock
    List<IdDto> listDto;

    @Mock
    List<PvuWFWrapperDto> pvuWFWrapperDtos;

    @Mock
    PvuWFOutWardWrapperDto wfOutWardWrapperDto;

    @Mock
    private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

    @Mock
    PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;

    @Mock
    private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

    @Mock
    private PVUCommonService pvuCommonService;

    @Mock
    private EDPLuLookUpInfoRepository edpRepository;

    @Mock
    private EDPLuLookUpInfoEntity luEntity;

    @Mock
    private PvuWFWrapperDto pvuWFWrapperDto;

    @Mock
    private EDPLuLookUpInfoEntity lu;

    @Mock
    private PVYFacade pvuFacade;

    @Mock
    private IdDto idDto;

    @Mock
    private PVUSSPRemarkRequest remarkRequest;

    @Mock
    private PVUEventRemarksEntity remarkEntity;

    @Mock
    private Map<String, Object> map;

    @Mock
    private PVUEmployeEventsService pvuEmployeEventsService;

    @Mock
    private PVUPrintEndorsementRepository printRepository;

    @Mock
    private PVUEmployeEventsEntity employeEventsEntity;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPVUSeniorScale() {
        entity.setId(1L);
        when(repository.getOne(1L)).thenReturn(entity);
        assertNotNull(service.getPVUSeniorScale(1L));
    }

//    @Test
    void testRepo() {
        when(service.getRepository()).thenReturn(genericDao);
    }

    @SuppressWarnings("unchecked")
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
        when(converter.toDTO(lst)).thenReturn(list);
        PagebleDTO<PVUSeniorScaleDto> data = service.getPVUSeniorScales(pageDetail);
        assertNotNull(data);
        service.ddoWFListing(pageDetail);
        service.getPVUOfficeSSPEmployeeSearch(pageDetail);
        service.getSSPInwardList(pageDetail);
        service.getSSPOutWardList(pageDetail);
        service.getSSPPrintEndorsementList(pageDetail);
    }

    @Test
    void test_getPvuOfficeSSPReasonCode() {
        assertNotNull(service.getPvuOfficeSSPReasonCode());
    }

    @Test
    void test_getWfRlCdBySSPTrnId() {
        when(this.wfRepository.findWfRlCdBySSPTrnId(1L, Constant.ACTIVE_STATUS)).thenReturn("STR");
        assertNotNull(service.getWfRlCdBySSPTrnId(1L));
    }

    @Test
    void test_generateInwardNumber() throws CustomException {
        assertNotNull(service.generateInwardNumber(listDto));
    }

    @Test
    void test_generateOutWardNumber() throws CustomException {
        assertNotNull(service.generateOutWardNumber(listDto));
    }

    @Test
    void test_getReturnRemarks() throws CustomException {
        assertNotNull(service.getReturnRemarks(1L));
    }

    @Test
    void test_submitSSPInward() {
        assertNotNull(service.submitSSPInward(pvuWFWrapperDtos));
    }

    @Test
    void test_submitSSPOutWard() throws CustomException {
        PvuWFOutWardWrapperDto dto = new PvuWFOutWardWrapperDto();
        dto.setStatus(Constant.RETURN);
        List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
        when(wfOutWardWrapperDto.getStatus()).thenReturn(Constant.AUTHORIZE);
        when(wfOutWardWrapperDto.getTrnId()).thenReturn(1L);
        dtos.add(wfOutWardWrapperDto);
        when(wfOutWardWrapperDto.getStatus()).thenReturn(Constant.RETURN);
        dtos.add(wfOutWardWrapperDto);
        assertNotNull(service.submitSSPOutWard(dtos));
        when(wfOutWardWrapperDto.getStatus()).thenReturn(Constant.AUTHORIZE);
        when(repository.getEmpId(1L)).thenReturn(1L);
        when(pvuEmployeeEventStatusService.findOneByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
        dtos.add(wfOutWardWrapperDto);
        assertNotNull(service.submitSSPOutWard(dtos));
    }

    @Test
    void test_submitSSPDistributor() {
        assertNotNull(service.submitSSPDistributor(pvuWFWrapperDtos));
    }

    @Test
    void test_getPVUResponse() throws CustomException {
        when(idDto.getId()).thenReturn(1L);
        when(entity.getCurrentDetailsEventId()).thenReturn(1L);
        when(service.getPVUSeniorScale(1L)).thenReturn(entity);
        assertNotNull(service.getPVUResponse(idDto));
    }

    @Test
    void test_saveOrUpdateRemarks() {
        when(idDto.getId()).thenReturn(1L);
        when(service.getPVUSeniorScale(1L)).thenReturn(entity);
        when(converter.setRemarks(entity, remarkRequest)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(eventsRemarkDto.getReasonId()).thenReturn(1L);
        when(eventsRemarkDto.getWfRoleId()).thenReturn(PvuConstant.AUDITOR_ROLE_ID);
        when(remarkRequest.getAuditorReturnReason()).thenReturn(Constant.RETURN_VAL);
        when(remarkRequest.getEmpId()).thenReturn(1L);
        when(remarkRequest.getId()).thenReturn(1L);
        when(remarkRequest.getWfRoleId()).thenReturn(14L);
        when(remarkRequest.getReturnReasons()).thenReturn(Collections.singletonList(eventsRemarkDto));
        when(repository.save(entity)).thenReturn(entity);
        when(converter.toDTO(entity)).thenReturn(dto);

        when(remarkService.saveAll(Collections.singletonList(remarkEntity))).thenReturn(Collections.singletonList(remarkEntity));

        assertNotNull(service.saveOrUpdateRemarks(remarkRequest));
/*


        List<PVURopRemarksEntity> lstRopRemarks = new ArrayList<>();
        List<PVURopRemarksDto> lstPVURopRemarksDto = new ArrayList<>();
        PVURopRemarksDto pvuRopRemarksDto = new PVURopRemarksDto();
        pvuRopRemarksDto.setId(1l);
        lstPVURopRemarksDto.add(pvuRopRemarksDto);

        PVUSeniorScaleEntity entity = new PVUSeniorScaleEntity();
        PVUSeniorScaleDto dto = new PVUSeniorScaleDto();
        dto.setId(1L);
        dto.setWfRoleId(14l);
        dto.setAuditorReturnReason(Constant.RETURN_VAL);
        dto.setReturnReasons(lstPVURopRemarksDto);
        when(repository.findById(1l)).thenReturn(Optional.of(entity));
        when(converter.setRemarks(entity, dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(converter.toDTO(entity)).thenReturn(dto);
        doNothing().when(pvuRopRemarksService).deactiveOldReason(dto.getId(), Constant.IN_ACTIVE_STATUS);
        doNothing().when(pvuRopRemarksService).saveOrUpdateRopRemarksAll(lstRopRemarks);
        assertEquals(dto, service.updateRopRemarks(dto));
*/

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
        when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSSPEmployeeOfficeId(), map)).thenReturn(lstObjects);
        EDPMsOfficeDto dto = service.getPVUOfficeName(idDto);
        assertEquals(dto.getOfficeName(), officeName);
    }

    @Test
    void test_insertSSPITR() {
        when(pvuWFWrapperDto.getTrnId()).thenReturn(1L);
        when(pvuWFWrapperDto.getCurrentWorkflowId()).thenReturn(1L);
        service.insertSSPITR(pvuWFWrapperDto);
        service.insertITR(pvuWFWrapperDto, "");
        service.insertSSRemarksITR(pvuWFWrapperDto);
    }
/*

    @Test
    void testSaveOrUpdatePVUSeniorScale() throws CustomException {
        Object[] object = new Object[1];
        object[0] = "";
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(object);
        when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
                .thenReturn(objects);
        when(converter.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
                .thenReturn(pvuEmployeeEventStatusDto);
        when(pvuCommonService.getTransactionNumber("PRFG")).thenReturn("PRFG");
        when(dto.isNew()).thenReturn(true);
        when(dto.getEventCode()).thenReturn("Senior_Scale");
        when(edpRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
        when(converter.toDTO(entity)).thenReturn(dto);
        when(dto.getEmployeeId()).thenReturn(1l);
        when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
        when(dto.getStatusId()).thenReturn(0l);
        when(dto.getEmployeeId()).thenReturn(2l);
        when(pvuEmployeeEventStatusService.inProgressAnyEvent(2l)).thenReturn(pvuEmployeeEventStatusEntity);

//        assertEquals(dto, service.save(dto));
        verify(repository, times(1)).save(entity);

        when(dto.isNew()).thenReturn(false);
        when(dto.isSame()).thenReturn(false);
        when(dto.getEmployeeId()).thenReturn(1L);
        when(dto.getId()).thenReturn(1L);
        when(repository.getOne(1L)).thenReturn(entity);
        when(entity.getEmployee()).thenReturn(employeEntity);
        when(entity.getEmployee().getEmpId()).thenReturn(1L);

        when(pvuEmployeeEventStatusService.findOneByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
        pvuEmployeeEventStatusEntity.setPromotion(0);
        pvuEmployeeEventStatusEntity.setTransId(null);
        when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity)).thenReturn(pvuEmployeeEventStatusEntity);
        when(pvuEmployeeEventStatusService.inProgressAnyEvent(1L)).thenReturn(pvuEmployeeEventStatusEntity);
//        assertEquals(dto, service.save(dto));

        when(dto.isNew()).thenReturn(false);
        when(dto.getTrnNo()).thenReturn(null);
        when(dto.isSame()).thenReturn(true);
        when(dto.getEmployeeId()).thenReturn(1L);
        when(converter.toEntity(dto)).thenReturn(entity);
        when(dto.getEmployeeNo()).thenReturn(10000000L);
        when(repository.save(entity)).thenReturn(entity);
        when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
                .thenReturn(pvuEmployeeEventStatusDto);
        when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
        when(converter.toDTO(entity)).thenReturn(dto);
//        assertEquals(dto, service.save(dto));

        when(repository.findById(1L)).thenReturn(Optional.empty());
//        assertEquals(dto, service.save(dto));
    }
*/

    @Test
    void testsaveOrUpdatePVUSeniorScale() throws CustomException {
        dto.setStatusId(0L);
        dto.setEmployeeNo(1L);
        when(converter.toEntity(dto)).thenReturn(entity);
        when(edpRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(lu);
        when(repository.save(entity)).thenReturn(entity);
        when(converter.toDTO(entity)).thenReturn(dto);
        when(entity.getEmployee()).thenReturn(employeEntity);
        when(pvuEmployeeEventStatusService.inProgressSuspensionEvent(employeEntity.getEmpId())).thenReturn(pvuEmployeeEventStatusEntity);
        service.saveOrUpdatePVUSeniorScale(dto);
    }

//    @Test
    void testInsertInITR() throws CustomException {
        when(pvuWFWrapperDto.getTrnId()).thenReturn(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Approved")).thenReturn(luEntity);
        when(luEntity.getLookUpInfoId()).thenReturn(2L);
        when(entity.getStatus()).thenReturn(lu);
        when(lu.getLookUpInfoId()).thenReturn(1L);
        when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
        when(converter.toDTO(entity)).thenReturn(dto);
        when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
        when(dto.getEmployeeId()).thenReturn(1L);
        when(dto.getEventOrderDate()).thenReturn(LocalDate.now());
        when(dto.getTrnNo()).thenReturn("2020");
        when(dto.getEventCode()).thenReturn("Senior_Scale");
        when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
        when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Submit")).thenReturn(luEntity);
        when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
        when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
        when(entity.getEmployee()).thenReturn(employeEntity);
        when(employeEntity.getEmpId()).thenReturn(1L);
        when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
                PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
        when(dto.getEventEffectiveDate()).thenReturn(LocalDate.now());
        when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
        when(dto.getPayCommId()).thenReturn(150L);
        when(pvuEmployeeEventStatusService.findByEmpId(1L)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
        when(pvuEmployeeEventStatusService.findOneByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
        when(dto.getCurrentDetailsEventId()).thenReturn(1L);

        when(this.pvuEmployeEventsService.getEmployeEvents(dto.getCurrentDetailsEventId())).thenReturn(employeEventsEntity);
        when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
        when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Approved")).thenReturn(luEntity);
        assertNotNull(service.insertInITR(pvuWFWrapperDto));

        when(dto.getEventCode()).thenReturn("PROMOTION");
        when(dto.getPayCommId()).thenReturn(152L);
        assertNotNull(service.insertInITR(pvuWFWrapperDto));

        when(dto.getEventCode()).thenReturn("PROMOTION");
        when(dto.getPayCommId()).thenReturn(151L);
        assertNotNull(service.insertInITR(pvuWFWrapperDto));

        when(pvuWFWrapperDto.getWfStatus()).thenReturn("Rejected");
        when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Rejected")).thenReturn(luEntity);
        assertNotNull(service.insertInITR(pvuWFWrapperDto));

    }

//    @Test
    void testGeneratePrintEndorsementList_5th() throws IOException, DocumentException, CustomException {
        when(pvuPrintStickerDto.getStickerDTO()).thenReturn(stickerDTO);
        when(stickerDTO.getId()).thenReturn(1L);
        when(stickerDTO.getEmployeeNo()).thenReturn("11000001");
        when(stickerDTO.getEmployeeName()).thenReturn("11000001");
        when(stickerDTO.getDesignation()).thenReturn("11000001");
        when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
        when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

        when(stickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
        when(stickerDTO.getCellValue()).thenReturn("11");
        when(stickerDTO.getLevelValue()).thenReturn("11");
        when(repository.getOne(pvuPrintStickerDto.getStickerDTO().getId())).thenReturn(entity);
        entity.setId(1L);

        entity.setCurrentDetailsEventId(1L);
        PVUMsPayScaleEntity scaleEntity = new PVUMsPayScaleEntity();
        when(entity.getScale()).thenReturn(new PVUMsPayScaleEntity(12L));
        print.setScaleName(entity.getScale().getPayScaleDispVal());
        when(entity.getGradePay()).thenReturn(new PVUMsGradePayEntity(12L));
        when(entity.getPayLevel()).thenReturn(new PVUMsPayLevelEntity(12L));
        PVUCommonApiDto common = new PVUCommonApiDto();
        when(this.pvuEmployeEventsService.getCommonApiResponse(entity.getCurrentDetailsEventId())).thenReturn(common);
        common.setDesignationName("Helo");
        when(printRepository.getPrintDateReprintDatePrintCount(entity.getId(),
                PvuConstant.SENIOR_SCALE_PVU_EVENT_ID, Constant.ACTIVE_STATUS)).thenReturn(print);
        when(converter.print(entity, print,common)).thenReturn(print);
        when(entity.getOffice()).thenReturn(edpMsOfficeEntity);
        when(edpMsOfficeEntity.getOfficeId()).thenReturn(1L);
        when(entity.getAuthorizeBy()).thenReturn(1L);
        IdNameDto idNameDto = new IdNameDto();
        when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
        idNameDto.setName("TEST");
        common.setPayCommId(150L);
        List<PvuPrintStickerReportDto> list = new ArrayList<>();
        list.add(pvuPrintStickerDto);
        assertNotNull(service.generatePrintOrders(list));
    }



}
