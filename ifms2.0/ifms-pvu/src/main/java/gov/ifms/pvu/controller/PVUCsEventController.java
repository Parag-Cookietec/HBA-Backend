package gov.ifms.pvu.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.dto.PVUCsAttachmentDto;
import gov.ifms.pvu.dto.PVUCsEventDto;
import gov.ifms.pvu.dto.PVUCsPrintEndorsementView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUCsAttachmentsEntity;
import gov.ifms.pvu.service.PVUCsAttachmentService;
import gov.ifms.pvu.service.PVUCsEventService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUCsEventController.
 *
 * @version v 1.0.
 * @created 2020/01/06 15:19:21.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_CSEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUCsEventController extends BasePVUAttachmentController<PVUCsAttachmentsEntity, PVUCsAttachmentDto> {

	/**
	 * The logger.
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The service.
	 */
	@Autowired
	private PVUCsEventService service;

	@Autowired
	private PVUCsAttachmentService csAttachmentsService;

	@Override
	public BasePVUAttachmentService<PVUCsAttachmentsEntity, PVUCsAttachmentDto> getAttachmentService() {
		return csAttachmentsService;
	}

	/**
	 * Fetch CsEvents by given CsEvents id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getCsEvent(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getCsEvent(id.getId()));
	}

	/**
	 * creates a new CsEvents.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createCsEvent(@Valid @RequestBody PVUCsEventDto dto) throws CustomException {
			if (dto.isSubmit()) {
				dto.validateAll();
			} else {
				dto.draftFieldValidate();
			}
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
					service.saveOrUpdateCsEvent(dto));
	}

	/**
	 * Gets details Change of Scale DDO List
	 *
	 * @param details the details
	 * @return the details pf events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_COMMON_DETAILS_CSPVU_DDO)
	public ResponseEntity<ApiResponse> getDetailsPFEvents(@RequestBody PageDetails details) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getCommonDetailsCspvuddolist(details));
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Update the CsEvents.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateCsEvent(@RequestBody PVUCsEventDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE, service.saveOrUpdateCsEvent(dto));
	}

	/**
	 * Deletes the CsEvents for the given id.
	 *
	 * @param pageDetail the page detail
	 * @return the api response
	 * @throws CustomException the custom exception
	 */

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getCsEvents(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUCsEventDto> data = service.getCsEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ALL_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Insert cs itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
	public ResponseEntity<ApiResponse> insertCsItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK,
					MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()),
					service.insertCsItr(pvuWFWrapperDto));
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
	}

	/**
	 * CSP :: get PVU Office details.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
	public ResponseEntity<ApiResponse> getEmployeeCSPOfficeDetails(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeName(idDto));
	}

	/**
	 * Generate inward number.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_GENERATE_INWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.generateInwardNumber(dto));
	}

	/**
	 * Submit CSP event.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submitCSPInward(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,
				service.submitCSPInward(wrapperDto));
	}

	/**
	 * Submit CSP distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
	public ResponseEntity<ApiResponse> submitCSPDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,
				service.submitCSPDistributor(wrapperDto));
	}

	/**
	 * Gets the CSP inwards List.
	 *
	 * @param pageDetail the page detail
	 * @return the rop inwards
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_CSP_INWARD_LIST)
	public ResponseEntity<ApiResponse> getCSPInwardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getCSPInwardList(pageDetail));
	}

	/**
	 * Gets the trn edp wf.
	 *
	 * @param id the id
	 * @return the trn edp wf
	 */
	@Trace
	@PostMapping(URLConstant.URL_WF_RL_CD_CSP_TRN_ID)
	public ResponseEntity<ApiResponse> getWfRoleCodeByTrnId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,
				service.getWfRlCdByCSPTrnId(id.getId()));
	}

	/**
	 * delete the CsEvents.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteCsEvent(@RequestBody IdDto id) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteCsEvent(id.getId()));
	}

	/**
	 * Pvu office CSP employee search.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
	public ResponseEntity<ApiResponse> pvuOfficeCSPEmployeeSearch(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getPVUOfficeCSPEmployeeSearch(pageDetail));
	}

	/**
	 * Pvu office CSP reasons.
	 *
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_PVU_REASONS)
	public ResponseEntity<ApiResponse> pvuOfficeSSPReasonCode() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPvuOfficeCSPReasonCode());
	}

	/**
	 * Pvu office CSP reasons.
	 *
	 * @return the response entity
	 */
	@Trace
	@PostMapping(PvuConstant.URL_PVU_RESPONSE)
	public ResponseEntity<ApiResponse> getPVUResponse(@RequestBody IdDto dto) throws CustomException {
		if (dto.getId() == null) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUResponse(dto));
	}

	/**
	 * PVU return reason by trans no.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_POST_RETURN_REMARKS)
	public ResponseEntity<ApiResponse> csReturnReasonByTransNo(@RequestBody IdDto idDto) throws CustomException {
		List<PVUEventRemarksDto> lstRemarksDto = service.getReturnReasonByTransactionId(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRemarksDto);
	}

	/**
	 * Update remarks.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_POST_UPDATE_REMARKS)
	public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUCsEventDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.updateCsRemarks(dto));
	}

	/**
	 * Gets the CSP inwards List.
	 *
	 * @param pageDetail the page detail
	 * @return the rop inwards
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_CSP_OUTWARD_LIST)
	public ResponseEntity<ApiResponse> getCSPOutwardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getCSPOutwardList(pageDetail));
	}

	/**
	 * Generate outward number.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_GENERATE_OUTWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateOutwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.generateOutwardNumber(dto));
	}

	/**
	 * Submit CSP event.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_POST_OUTWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submitCSPOutward(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED,
				service.submitCSPOutward(wrapperDto));
	}

	/**
	 * Deletes the PVUPrintEndorsements for the given id
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.GET_PVU_PRINT_ENDORSEMENT_LIST)
	public ResponseEntity<ApiResponse> getRopPrintEndorsements(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUCsPrintEndorsementView> data = service.getCSPrintEndorsements(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT) // While Click on Print Button Remarks updated..
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto)
			throws CustomException {
		String result = service.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, result);
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT_LIST) // While Click on Multiple Print Button Remarks
	public ResponseEntity<ApiResponse> generatePrintEndorsementList(@RequestBody List<PvuPrintStickerReportDto> dto)
			throws CustomException {
		String result = service.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, result);
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_PRINTENDORSEMENT_REMARK)
	public ResponseEntity<ApiResponse> getReprintEndorsementRemarks(@RequestBody IdDto dto) throws CustomException {
		List<PVUPrintEndorsementRemarkHistoryDto> result = service.getPrintEndorsementHistory(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);
	}
	
	@Trace  // 8 No.Screen
	@PostMapping("/payfixation/" +URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)  
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException, IOException {
		
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}
	
	
	
	
	
}
