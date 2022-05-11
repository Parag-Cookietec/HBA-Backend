package gov.ifms.pvu.common;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.converter.PVUMsEventConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVURopDetailRequest;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.request.PVUOptAvDto;
import gov.ifms.pvu.dto.response.PVUInwardLookupResponse;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.service.PVUMsEventService;
import gov.ifms.pvu.service.PVURevisionOfPayService;
import gov.ifms.pvu.util.PvuConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class PVUMasterController.
 */
@RestController
@RequestMapping(value = PvuConstant.MASTER_URL)
public class PVUMasterController {

    /**
     * The  logger.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * The service.
     */
    @Autowired
    private PVUMsEventService service;

    /**
     * The common service.
     */
    @Autowired
    private PVUCommonService commonService;

    /**
     * The converter.
     */
    @Autowired
    private PVUMsEventConverter converter;

    @Autowired
    private PVURevisionOfPayService pvuRevisionOfPayService;


    /**
     * Fetch all designations.
     *
     * @return the designation masters
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_ALL_DESIGNATION)
    public ResponseEntity<ApiResponse> getDesignationMasters() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getAllActiveDesignations());
    }

    /**
     * Fetch by id the PVUMsEventDto.
     *
     * @param dto the dto
     * @return PVUMsEventDto master event by id
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.GET_MASTER_EVENT_BY_ID)
    public ResponseEntity<ApiResponse> getMasterEventById(@RequestBody IdDto dto) throws CustomException {
        PVUMsEventEntity eventById = service.getEventById(dto.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, converter.toDTO(eventById));
    }

    /**
     * Fetch all active the PVUMsEventEntity.
     *
     * @return PVUMsEventDto all pay commission
     */
    @Trace
    @PostMapping(PvuConstant.GET_ALL_PAY_COMMISSION)
    public ResponseEntity<ApiResponse> getAllPayCommission() {
        List<EDPLuLookUpInfoEntity> events = commonService.getAllPayCommission();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.toMap(events));
    }

    /**
     * Fetch all active the pvu events.
     *
     * @return List<PVUMsEventDto> all active events
     */
    @Trace
    @PostMapping(PvuConstant.GET_ALL_MASTER_EVENT)
    public ResponseEntity<ApiResponse> getAllActiveEvents() {
        List<PVUMsEventEntity> events = service.getAllEvents();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, converter.toDTO(events));
    }

    /**
     * Gets the pay fixation events.
     *
     * @return the pay fixation events
     */
    @Trace
    @PostMapping(PvuConstant.GET_PAY_FIXATION_EVENT)
    public ResponseEntity<ApiResponse> getPayFixationEvents() {
        List<PVUMsEventEntity> events = service.getPayFixationEvents();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, converter.toDTO(events));
    }

    /**
     * Gets the pvu events.
     *
     * @return the pvu events
     */
    @Trace
    @PostMapping(PvuConstant.GET_PVU_EVENT)
    public ResponseEntity<ApiResponse> getPvuEvents() {
        List<PVUMsEventEntity> events = service.getPvuEvents();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, converter.toDTO(events));
    }

    /**
     * Fetch all active the pay commission master.
     *
     * @return Map<String, Object> pay master
     */
    @Trace
    @PostMapping(PvuConstant.URL_PAY_MASTER)
    public ResponseEntity<ApiResponse> getPayMaster(@RequestBody PvuCommonRequest request) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getPayMaster(request));
    }
    
    
    @Trace
    @PostMapping(PvuConstant.URL_PAY_MASTER_COMMISSION)
    public ResponseEntity<ApiResponse> getPayMasterCommission(@RequestBody PvuCommonRequest request) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getPayMasterCommission(request));
    }

    /**
     * Gets the common detail.
     *
     * @param pageDetails the pageDetails dto
     * @return the duplicate pan no detail
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_COMMON_DETAIL)
    public ResponseEntity<ApiResponse> getCommonDetails(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getSearchCommonDetails(pageDetails));
        } catch (DataIntegrityViolationException ex) {
            return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        } catch (CustomException ex) {
            throw new CustomException(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Gets the common detail ::: Use for 8 no. Screen.
     *
     * @param pageDetails the pageDetails dto
     * @return the duplicate pan no detail
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_COMMON_DETAIL_WITH_REGULAR)
    public ResponseEntity<ApiResponse> getCommonDetailsForRegularEmployee(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getCommonDetailsForRegularEmployee(pageDetails));
        } catch (DataIntegrityViolationException ex) {
            return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        } catch (CustomException ex) {
            
            throw new CustomException(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
            
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }


    /**
     * Gets the sub office.
     *
     * @param id the id
     * @return the sub office
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_ALL_SUBOFFICE)
    public ResponseEntity<ApiResponse> getSubOffice(@RequestBody IdDto id) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
                commonService.getAllSubOffice(id.getId()));
    }


    /**
     * Gets the all category.
     *
     * @return the all category
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_ALL_DEPT_CAT)
    public ResponseEntity<ApiResponse> getAllCategory() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
                commonService.getAllDeptCategory());
    }


    @Trace
    @PostMapping(PvuConstant.URL_ALL_LOOKUP_INFO)
    public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
        Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = commonService.getAllLuLookUpInfoAsMap();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
    }


    /**
     * Search GET details For PVU events details
     *
     * @param details JSON Will be
     *                {
     *                "pageIndex":0,
     *                "pageElement":10,
     *                "jsonArr":[
     *                {
     *                "key":	"empNo",
     *                "value":1000000116
     *                },
     *                {
     *                "key":	"eventCode",
     *                "value":"Tiku_Panch"
     *                },
     *                {
     *                "key":	"startDate",
     *                "value":""
     *                },
     *                {
     *                "key":	"endDate",
     *                "value":""
     *                },
     *                {
     *                "key":	"empName",
     *                "value":""
     *                },
     *                {
     *                "key":	"designationId",
     *                "value":0
     *                },
     *                {
     *                "key":	"gpfNo",
     *                "value":""
     *                },
     *                {
     *                "key":	"pPan",
     *                "value":""
     *                },
     *                {
     *                "key":	"retirementDate",
     *                "value":""
     *                },
     *                {
     *                "key":	"caseNo",
     *                "value":""
     *                },
     *                {
     *                "key":	"classId",
     *                "value":0
     *                },
     *                {
     *                "key":	"officeId",
     *                "value":0
     *                },
     *                {
     *                "key":	"empType",
     *                "value":0
     *                }
     *                ]
     *                }
     * @return JSON Will be
     * {
     * "status": 200,
     * "message": "record fetch successfully.",
     * "result": [
     * {
     * "id": "8",
     * "trnNo": "string",
     * "eventName": "Tiku-Panch",
     * "employeeNo": "1000000116",
     * "employeeName": "Ketan",
     * "designationName": "Auditor",
     * "employeeClass": "NO",
     * "empType": "YES",
     * "panNo": "DGEPB3460A",
     * "officeName": "0",
     * "status": "Pending",
     * "retirementDate": "2019-12-10 15:23:55.306",
     * "count": 5
     * }
     * ]
     * }
     */
    @Trace
    @PostMapping(PvuConstant.URL_COMMON_DETAILS_PVU)
    public ResponseEntity<ApiResponse> getDetailsPVUEvents(@RequestBody PageDetails details) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
                    commonService.getCommonDetailsPVUEventList(details));
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Gets details pf events.
     *
     * @param details the details
     * @return the details pf events
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_COMMON_DETAILS_PF)
    public ResponseEntity<ApiResponse> getDetailsPFEvents(@RequestBody PageDetails details) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
                    commonService.getCommonDetailsPFEventList(details));
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }


    /**
     * Gets promotion.
     *
     * @param details the details
     * @return the promotion
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_ALL_PROMOTION)
    public ResponseEntity<ApiResponse> getPromotion(@RequestBody PageDetails details) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
                commonService.getAllPromotionDetail(details));
    }


    /**
     * Gets basic pay detail. JSON Will be
     * {
     * "request": {
     * "oldPayLevelId": 1,
     * "oldCellValue": 45700,
     * "payLevelId": 6,
     * "optionalAvail": 0
     * }
     * }
     *
     * @param request the request
     * @return the basic pay detail
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_SEVEN_PAY_BASIC_PAY)
    public ResponseEntity<ApiResponse> getBasicPayDetail(@RequestBody PvuCommonRequest request) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getSevenBasicAndCell(request));
    }

    /**
     * Gets the basic pay detail PVU.
     *
     * @param request the request
     * @return the basic pay detail PVU
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_SEVEN_PAY_BASIC_PAY_PVU)
    public ResponseEntity<ApiResponse> getBasicPayDetailPVU(@RequestBody PvuCommonRequest request) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getSevenBasicAndCellPVU(request));
    }


    /**
     * Gets six basic pay detail. JSON Will be
     * <p>
     * {
     * "request": {
     * "oldPayBandValue": 8800,//50000
     * "oldGradePay": 2800, //10000
     * "newGradePay": 4200,
     * "selectedPayBandId": 0,
     * "oldBasic": 11600, // 60000
     * "optionalAvail": 0
     * }
     * }
     *
     * @param request the request
     * @return the six basic pay detail
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_SIX_PAY_BASIC_PAY)
    public ResponseEntity<ApiResponse> getSixBasicPayDetail(@RequestBody PvuCommonRequest request) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getSixBasicAndPayBandValue(request));

    }


    @Trace
    @PostMapping(PvuConstant.CHECK_EMPLOYEE_ELIGIBLE)
    public ResponseEntity<ApiResponse> checkEmployeeEligible(@RequestBody PvuCommonRequest request) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.checkEligible(request));
        } catch (CustomException ex) {
            throw new CustomException(ex.getErrorCode(), ex.getErrorMsg());
        }
    }

    //  validatePaylevel
    @Trace
    @PostMapping(URLConstant.URL_ROP_CONFIGURATION)
    public ResponseEntity<ApiResponse> ropConfigurationList() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
                pvuRevisionOfPayService.ropConfigurationList());
    }

    @Trace
    @PostMapping(URLConstant.URL_ROP_VALID)
    public ResponseEntity<ApiResponse> notRopGivenPrevious(@RequestBody PVURopDetailRequest pvuRopDetailRequest) throws CustomException, ParseException {
        pvuRopDetailRequest.setValidateString(URLConstant.URL_ROP_VALID);
        pvuRopDetailRequest.validateAll();
        Map<String, Boolean> map = new HashMap<>();
        map.put("isValid", pvuRevisionOfPayService.ropGivenPrevious(pvuRopDetailRequest));
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, map);
    }

    @Trace
    @PostMapping(PvuConstant.URL_GET_DEEMED_DATE_ELIGIBLE)
    public ResponseEntity<ApiResponse> checkEligibleDeemeddate(@RequestBody PvuCommonRequest request) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getValidEligleEmployeeForDeemedDate(request));
    }


    @Trace
    @PostMapping(PvuConstant.URL_GET_PAY_COMMISION)
    public ResponseEntity<ApiResponse> getPayCommisionDetails() throws CustomException {
        Map<String, List<PVUEmployeCreationDDLView>> resultMap = commonService.getPayCommisionDetails();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, resultMap);
    }

    //getPayCommisionDetails
    @Trace
    @PostMapping(PvuConstant.URL_PVU_COMMON_DETAILS)
    public ResponseEntity<ApiResponse> getCommonDetailsOfEmployee(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getSearchCommonDetailsEmployee(pageDetails));
        } catch (DataIntegrityViolationException ex) {
            return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        } catch (CustomException ex) {
            
            throw new CustomException(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
           
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Gets details regular employee
     *
     * @param pageDetails the details
     * @return the details regular employee
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_REGULAR_COMMON_DETAIL)
    public ResponseEntity<ApiResponse> getRegularEmployeeCommonDetails(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getRegularEmployeeCommonDetails(pageDetails));
        } catch (DataIntegrityViolationException ex) {
            return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        } catch (CustomException ex) {
            throw new CustomException(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Gets the all lu look up info as map.
     *
     * @return the all lu look up info as map
     */
    @Trace
    @PostMapping(PvuConstant.URL_CURRENT_DETAILS)
    public ResponseEntity<ApiResponse> getCurrentDetailsById(@RequestBody IdDto eventId) throws CustomException {
        if (eventId.getId() == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, PvuConstant.PVU_ID_MUST_BE_NOT_NULL);
        }
        Map<String, Object> lstLuLookUp = commonService.getCurrentDetailsById(eventId, true);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
    }

    /**
     * Gets the basic pay detail change of scale PVU.
     *
     * @param request the request
     * @return the basic pay detail PVU
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_GET_SEVEN_PAY_HIGHER_BASIC_PAY_PVU)
    public ResponseEntity<ApiResponse> getBasicPayDetailCSPVU(@RequestBody PvuCommonRequest request) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getSevenHigherBasicAndCellPVU(request));
    }

    /**
     * Gets the all lu look up info as map.
     *
     * @return the all lu look up info as map
     */
    @Trace
    @PostMapping(URLConstant.URL_PVU_INWARD_LOOKUP_INFO)
    public ResponseEntity<ApiResponse> getInwardLuLookUpInfo() {
        PVUInwardLookupResponse lstLuLookUp = commonService.getInwardLuLookUpInfo();
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
    }


    /**
     * Gets the all lu look up info as map.
     *
     * @return the all lu look up info as map
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_LOOKUP_AUD_VER)
    public ResponseEntity<ApiResponse> getPvuLookupAudVerApprover() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, commonService.getAuditorEditLookups());
    }

    @Trace
    @PostMapping(URLConstant.URL_PVU_OUTWARD_LOOKUP_INFO)
    public ResponseEntity<ApiResponse> getOutwardLuLookUpInfo() throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, commonService.getOutwardLuLookUpInfo());
    }

    @Trace
    @PostMapping(PvuConstant.URL_EXAM_DETAILS)
    public ResponseEntity<ApiResponse> getEmployeeExams(@RequestBody PvuCommonRequest dto) throws CustomException {
        if (Utils.isNonEmpty(dto) && Utils.isNonEmpty(dto.getRequest())) {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, commonService.getEmployeeExams(dto.getRequest()));
        }
        throw new CustomException(HttpStatus.BAD_REQUEST, PvuConstant.PVU_ID_MUST_BE_NOT_NULL);
    }

    @Trace
    @PostMapping(PvuConstant.PVU_EVENT_WF_STATUS)
    public ResponseEntity<ApiResponse> getPvuEventWfStatus(@RequestBody IdDto dto) throws CustomException {
        if (Utils.isNonEmpty(dto) && Utils.isNonEmpty(dto.getId())) {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, commonService.getPvuEventWfStatus(dto.getId()));
        }
        throw new CustomException(HttpStatus.BAD_REQUEST, PvuConstant.PVU_ID_MUST_BE_NOT_NULL);
    }

    /**
     * Roll back reprint count common.
     *
     * @param requestMap the request map
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
	@PostMapping(PvuConstant.ROLLBACK_REPRINT_CMN)
	public ResponseEntity<ApiResponse> rollBackReprintCountCommon(@RequestBody List<Map<String, String>> requestMapList)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				commonService.rollBackReprintCountCommon(requestMapList));
	}
    
    @Trace
    @PostMapping(PvuConstant.URL_GET_DESIGNATION)
    public ResponseEntity<ApiResponse> getDesignationMastersByStatus() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getAllActiveDesignationsByStatus());
    }
    
    /**
     * Gets details regular employee
     *
     * @param pageDetails the details
     * @return the details regular employee
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_SHP_PVU_REGULAR_COMMON_DETAIL)
    public ResponseEntity<ApiResponse> getRegularEmployeeCommonDetailsForSHP(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getRegularEmployeeCommonDetailsForSHP(pageDetails));
        } catch (DataIntegrityViolationException ex) {
            return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        } catch (CustomException ex) {
            throw new CustomException(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }
    
    
    
    
    /**
     * Gets details FIX employee
     *
     * @param pageDetails the details
     * @return the details regular employee
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_PVU_FIX_PAY_EMP_COMMON_DETAIL)
    public ResponseEntity<ApiResponse> getFixPayEmployyeeCommonDetails(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.getSearchCommonDetailsForFixPayEmployee(pageDetails));
        } catch (DataIntegrityViolationException ex) {
            return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        } catch (CustomException ex) {
            throw new CustomException(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    @Trace
    @PostMapping(URLConstant.URL_OA_YES_CAL+ URLConstant.URL_GET_BY_FIELDS)
    public ResponseEntity<ApiResponse> optionAvailedCalculations(@RequestBody PVUOptAvDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, commonService.calcOptAvail(dto));
    }
}
