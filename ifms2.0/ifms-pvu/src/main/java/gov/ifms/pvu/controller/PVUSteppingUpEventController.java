package gov.ifms.pvu.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUSteppingUpEventConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUSteppingUpAttDto;
import gov.ifms.pvu.dto.PVUSteppingUpEventDto;
import gov.ifms.pvu.dto.PVUSteppingUpEventView;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUSteppingUpAttEntity;
import gov.ifms.pvu.entity.PVUSteppingUpEventEntity;
import gov.ifms.pvu.service.PVUSteppingUpAttService;
import gov.ifms.pvu.service.PVUSteppingUpEventService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUStEventController.
 * 
 * @version v 1.0.
 * @created 2019/12/17 18:44:21.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_STEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUSteppingUpEventController extends BasePVUAttachmentController<PVUSteppingUpAttEntity, PVUSteppingUpAttDto>{

	
    /**
     * The logger.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/** The service. */
	@Autowired
	private PVUSteppingUpEventService service;

	/** The converter. */
	@Autowired
	private PVUSteppingUpEventConverter converter;

	/** Lookup repository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;
	
	/** attService. */
	@Autowired
	PVUSteppingUpAttService attService;

	@Autowired
	PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	
	@Override
	public BasePVUAttachmentService<PVUSteppingUpAttEntity, PVUSteppingUpAttDto> getAttachmentService() {
		return attService;
	}

	
	/**
	 * Fetch StEvents by given StEvents id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getStEvent(@RequestBody IdDto id) {
		PVUSteppingUpEventEntity entity = service.getStEvent(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, converter.toDTO(entity));
	}

	/**
	 * creates a new StEvents.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createStEvent(@Valid @RequestBody PVUSteppingUpEventDto dto) throws CustomException {
		PVUSteppingUpEventEntity entity = converter.toEntity(dto);
        if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getCurEmpId().getEmpId());
        	entity.setStatusId(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT ));
        }

		if (dto.isSubmit()) {
			dto.validateAll();
			service.submitValidation(dto);
		}else {
			dto.draftFieldValidate();
		}

		
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, converter.toDTO(service.saveOrUpdateStEvent(entity)));
	}

	/**
	 * Update the StEvents.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateStEvent(@RequestBody PVUSteppingUpEventDto dto) throws CustomException {
		
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
			service.submitValidation(dto);
		}
		PVUSteppingUpEventEntity entity = converter.toEntity(dto);
		entity.setStatusId(lookupinforepository.findBylookUpInfoId(
				dto.getFormAction() == Status.SUBMITTED ?   PvuConstant.SUBMIT : PvuConstant.SAVE_AS_DRAFT_ID  ));
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,	converter.toDTO(service.saveOrUpdateStEvent(entity)));
	}

	/**
	 * Gets the st events.
	 *
	 * @param pageDetail the page detail
	 * @return the st events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getStEvents(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUSteppingUpEventView> data = service.getStEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Delete st events details.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteStEventsDetails(@RequestBody StatusDto statusDto) throws CustomException {
		service.deleteStEventsDetails(statusDto.getId(), Constant.INACTIVE_STATUS);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}

	/**
	 * Gets the creation look up info as map.
	 *
	 * @return the creation look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_CREATION_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getCreationLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service
				.getLookUpInfoAsMap(PvuConstant.PVU_STEPPING_UP_CREATION_LOOKUPS_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

    /**
     * Checks Senior&Junior employee validations
     *
     * @param PageDetails pageDetail
     * @return error msg 
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(URLConstant.URL_PVU_STPUP_CHK_CONDITION)
    public ResponseEntity<ApiResponse> chkSrJrValidation(@RequestBody PageDetails pageDetail) throws CustomException {
        try {
        	return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.chkSrJrValidation(pageDetail));
        } catch (CustomException ex) {
            logger.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse. VALIDATIONS_FAILED);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
    }

    /**
     * Use for DDO office Listing Stepping Up.
     *
     * @param pageDetails page details
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.DDO_WF_LISTING)
    public ResponseEntity<ApiResponse> ddoWFListing(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.ddoWFListing(pageDetails));
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Insert in itr response entity.(Workflow Submit)
     *
     * @param wrapperDto the wrapper dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
    public ResponseEntity<ApiResponse> insertInITR(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK,  MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), service.insertInITR(wrapperDto));
        } catch (CustomException e) {
            throw new CustomException(e.getErrorCode(), e.getMessage());
        }
    }
    
    /**
     * Get PVU office name(Forward to PVU Office)
     *
     * @param IdDto the IdDto dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace
	@PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
	public ResponseEntity<ApiResponse> getSteppingUpEmpOfficeName(@RequestBody IdDto idDto) {
	     return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getSteppingUpOfficeName(idDto));
	}

    /**
     * Get Inward Listing(Start Inward)
     *
     * @param PageDetails pageDetail
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace 
    @PostMapping("/steppingup-inward/" + URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getSteppingUpInwardList(@RequestBody PageDetails pageDetail) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,service.getSteppingUpInwardList(pageDetail));
    }
	
    /**
     * Generate Inward Number
     *
     * @param List<IdDto> dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace  
    @PostMapping(PvuConstant.URL_GENERATE_INWARD_NUMBER)
    public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.generateInwardNumber(dto));
    }
	
    /**
     * Submit Inward
     *
     * @param List<PvuWFWrapperDto> wrapperDto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace
    @PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
    public ResponseEntity<ApiResponse> submiSteppingUpInward(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,service.submiSteppingUpInward(wrapperDto));
    }
	
	
    /**
     * Submit Distributer
     *
     * @param List<PvuWFWrapperDto> wrapperDto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace
    @PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
    public ResponseEntity<ApiResponse> submitSteppingUpDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,service.submitSteppingUpDistributor(wrapperDto));
    }

    /**
     * Get Listing for Auditor	
     *
     * @param PageDetails pageDetail
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace 
    @PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
    public ResponseEntity<ApiResponse> pvuOfficeEmployeeSearch(@RequestBody PageDetails pageDetail) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.pvuOfficeEmployeeSearch(pageDetail));
    }	
	
    /**
     * Get Reasons	
     *
     * @param IdDto dto
     * @return the response entity
     * @throws CustomException the custom exception
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
     * Get Reason List	
     *
     * @param 
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace  
    @PostMapping(PvuConstant.URL_PVU_REASONS)  
    public ResponseEntity<ApiResponse> pvuOfficeSSPReasonCode() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getSteppingUpReasons());
    }
	
    /**
     * Get Remarks as return	(Auditor Remarks as return)
     *
     * @param IdDto idDto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace 
	@PostMapping(PvuConstant.URL_POST_RETURN_REMARKS)
	public ResponseEntity<ApiResponse> ropReturnReasonByTransNo(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getReturnReasonByTransactionId(idDto.getId()));
	}
	
    /**
     * Get Remarks as return (WorkFlow Submit...Submit data with select recommendation and Remarks)
     *
     * @param IdDto idDto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace  
	@PostMapping(URLConstant.PVU_CREATE_UPDATE_REMARKS)
	public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUSteppingUpEventDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.updateRemarks(dto));
	}

	
	
    /**
     * Get Outward Listing(Start Outward)
     *
     * @param PageDetails pageDetail
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace
    @PostMapping("/steppingup-outward/" + URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getSteppingUpOutwardList(@RequestBody PageDetails pageDetail) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,service.getSteppingUpOutwardList(pageDetail));
    }

	
    /**
     * Generate Outward Number (Received the Record from Inward login with select record throw checkBox )
     *
     * @param List<IdDto> dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace  
    @PostMapping(PvuConstant.URL_GENERATE_OUTWARD_NUMBER)
    public ResponseEntity<ApiResponse> generateOutwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.generateOutwardNumber(dto));
    }

    /**
     * Submit Outward
     *
     * @param List<PvuWFWrapperDto> wrapperDto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace
    @PostMapping(PvuConstant.URL_POST_OUTWARD_SUBMIT)
    public ResponseEntity<ApiResponse> submiSteppingUpOutward(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED,service.submiSteppingUpOutward(wrapperDto));
    }

	
	
    /**
     * Get Print Endorsement List
     *
     * @param PageDetails pageDetail
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace 
    @PostMapping("/steppingup-printendorsement/" + URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getSteppingUpPrintEndorsementList(@RequestBody PageDetails pageDetail) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,service.getSteppingUpPrintEndorsement(pageDetail));
    }


    /**
     * Generate Print Endorsement
     *
     * @param PageDetails pageDetail
     * @return the response entity
     * @throws CustomException the custom exception
     * @throws IOException 
     */
	@Trace
	@PostMapping(value=URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)  
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto) throws CustomException, IOException {
		
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}
	
    /**
     * Generate Multiple Print Endorsement 
     *
     * @param PageDetails pageDetail
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace
	@PostMapping(value=URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT_LIST) 
	public ResponseEntity<ApiResponse> generatePrintEndorsementList(@RequestBody List<PvuPrintStickerReportDto> dto) throws CustomException {
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsementList(dto));
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }

	}

	
	
	
    /**
     * Get Print Endorsement Remarks
     *
     * @param PageDetails pageDetail
     * @return the response entity
     * @throws CustomException the custom exception
     */
	@Trace
	@PostMapping(URLConstant.URL_PVU_PRINTENDORSEMENT_REMARK)
	public ResponseEntity<ApiResponse> getReprintEndorsementRemarks(@RequestBody IdDto dto) throws CustomException {
		List<PVUPrintEndorsementRemarkHistoryDto> result = service.getReprintEndorsementRemarks(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.IFMS_MSG_FETCH_LIST,result);
	}
	
    /**
     * Get Wf role by trn id
     *
     * @param IdDto id
     * @return the response entity
     * @throws 
     */
	@Trace
    @PostMapping(URLConstant.URL_WF_RL_CD_STEPPINGUP_TRN_ID) // URL_WF_RL_CD_STEPPINGUP_TRN_ID
    public ResponseEntity<ApiResponse> getWfRoleCodeByTrnId(@RequestBody IdDto id) {
        return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.WORKFLOW_MSG_FETCH,service.getWfRoleCodeByTrnId(id.getId()));
    }

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 * @throws IOException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_COMPARISION_REPORT)
	public ResponseEntity<ApiResponse> generateComparisionReport(@RequestBody IdDto dto) throws CustomException, IOException {
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generateComparisionReport(dto));
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}

	
	

}
