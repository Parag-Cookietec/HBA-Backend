package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import gov.ifms.pvu.converter.PVUEmployeTikuPayConverter;
import gov.ifms.pvu.dto.PVUCsPrintEndorsementView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeTikuPayDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUTikuAttachmentDto;
import gov.ifms.pvu.dto.PVUTikuPayEditListView;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeTikuPayEntity;
import gov.ifms.pvu.entity.PVUTikuAttachmentEntity;
import gov.ifms.pvu.service.PVUEmployeTikuPayService;
import gov.ifms.pvu.service.PVUTikuAttachmentService;
import gov.ifms.pvu.util.PvuConstant;


@RestController
@RequestMapping(URLConstant.URL_PVU_TIKUPAY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeTikuPayController extends BasePVUAttachmentController<PVUTikuAttachmentEntity, PVUTikuAttachmentDto> {


    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private PVUEmployeTikuPayService pvuEmployeTikuPayService;

    @Autowired
    private PVUEmployeTikuPayConverter pvuEmployeTikuPayConverter;

    @Autowired
    private PVUTikuAttachmentService tikuPayattachmentService;


    @Trace  // Fetch all DroupDown values
    @PostMapping(PvuConstant.URL_TIKUPAY_LOOKUP_INFO)
    public ResponseEntity<ApiResponse> getCreateLookUpInfoAsMap() throws CustomException {
        Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = pvuEmployeTikuPayService.getLookUpInfoAsMap(PvuConstant.PVU_TIKUPAY_LOOKUP_SP);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
    }


    /**
     * Fetch EmployeTikuPays by given EmployeTikuPays id @param id,  @return dto
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
    public ResponseEntity<ApiResponse> getEmployeTikuPay(@RequestBody IdDto id) {
        PVUEmployeTikuPayEntity entity = pvuEmployeTikuPayService.getEmployeTikuPay(id.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.pvuEmployeTikuPayConverter.toDTO(entity));
    }

    @Trace
    @PostMapping(URLConstant.URL_PUT_BY_ID)
    public ResponseEntity<ApiResponse> updateEmployeTikuPay(@RequestBody PVUEmployeTikuPayDto dto) throws CustomException {
        try {
        	return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,pvuEmployeTikuPayService.saveOrUpdateEmployeTikuPay(dto));
        } catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
    }

    @Trace  // Get TikuPay common Details
    @PostMapping(PvuConstant.TIKU_PAY_EMPLOYEE_CURRENT_DETAIL)  // 
    public ResponseEntity<ApiResponse> getEmployeeCurrentDetails(@RequestBody PageDetails pageDetails) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, pvuEmployeTikuPayService.getEmployeeCurrentDetails(pageDetails));
        } catch (DataIntegrityViolationException ex) {
        	logger.error(ex.getMessage(), ex);
            return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        } catch (CustomException ex) {
            throw new CustomException(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    // Attachment Start
    @Override
    public BasePVUAttachmentService<PVUTikuAttachmentEntity, PVUTikuAttachmentDto> getAttachmentService() {
        return tikuPayattachmentService;
    }
    // Attachment End
    @Trace
    @PostMapping(URLConstant.URL_POST) // Save As Draft or Submit
	public ResponseEntity<ApiResponse> saveOrUpdateEmployeTikuPay(@RequestBody PVUEmployeTikuPayDto dto)throws CustomException {
		if (dto.isSubmit()) {
			this.pvuEmployeTikuPayService.postDetailvalidate(dto);
			dto.validateAll();
		} else {
			this.pvuEmployeTikuPayService.postDetailvalidate(dto);
			dto.draftFieldValidate();
		}
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,pvuEmployeTikuPayService.saveOrUpdateEmployeTikuPay(dto));
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getErrorMsg());
		}
	}

    @Trace
    @PostMapping(URLConstant.URL_GET_ALL) // Fetch TikuPay page details while click on edit and fill page details 
    public ResponseEntity<ApiResponse> getTikuPayDetails(@RequestBody PageDetails pageDetail) throws CustomException {
        PagebleDTO<PVUEmployeTikuPayDto> data = pvuEmployeTikuPayService.getTikuPayDetails(pageDetail);
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
    }

    @Trace   // Workflow Submit
    @PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
    public ResponseEntity<ApiResponse> insertWorkFlowData(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
        try {
            PVUEmployeTikuPayDto tikuPayDto = pvuEmployeTikuPayService.insertWorkFlowData(wrapperDto);
            return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), tikuPayDto);
        } catch (CustomException e) {
            throw new CustomException(e.getErrorCode(), e.getMessage());
        }
    }
	
    @Trace  // DDO Listing
	@PostMapping(URLConstant.URL_TIKU_PAY_DDO_LIST)
	public ResponseEntity<ApiResponse> getTikuPayDDOList(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUTikuPayEditListView> data = pvuEmployeTikuPayService.getTikuPayDDOList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}
	
	@Trace // Delete from DDO Listing API
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteTikuPayEventById(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, pvuEmployeTikuPayService.deleteTikuPayEventById(idDto));
	}
	
	@Trace
    @PostMapping(URLConstant.URL_WF_RL_CD_TIKUPAY_TRN_ID) // URL_WF_RL_CD_SSP_TRN_ID
    public ResponseEntity<ApiResponse> getWfRoleCodeByTrnId(@RequestBody IdDto id) {
        return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.WORKFLOW_MSG_FETCH,pvuEmployeTikuPayService.getWfRoleCodeByTrnId(id.getId()));
    }

	// Forward to PVU Office
    @Trace  // Get PVU Office Name
    @PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
    public ResponseEntity<ApiResponse> getTikuPayEmpOfficeName(@RequestBody IdDto idDto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, pvuEmployeTikuPayService.getTikuPayEmpOfficeName(idDto));
    }

    // Start Inward Login
    @Trace // While login with Inward,showing Inward Listing
    @PostMapping("/tikupay-inward/" + URLConstant.URL_GET_ALL)
    public ResponseEntity<ApiResponse> getTikypayInwardList(@RequestBody PageDetails pageDetail) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, pvuEmployeTikuPayService.getTikypayInwardList(pageDetail));
    }

    @Trace  // Received the Record from Inward login with select record throw checkBox
    @PostMapping(PvuConstant.URL_GENERATE_INWARD_NUMBER)
    public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, pvuEmployeTikuPayService.generateInwardNumber(dto));
    }

    @Trace
    @PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
    public ResponseEntity<ApiResponse> submiTikuPayInward(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR, pvuEmployeTikuPayService.submiTikuPayInward(wrapperDto));
    }

    // Distributer
    @Trace
    @PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
    public ResponseEntity<ApiResponse> submitTikupayDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR, pvuEmployeTikuPayService.submitTikupayDistributor(wrapperDto));
    }

    // In Auditor
    @Trace // Get PVU Auditor list data 
    @PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
    public ResponseEntity<ApiResponse> pvuAuditorList(@RequestBody PageDetails pageDetail) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, pvuEmployeTikuPayService.pvuAuditorList(pageDetail));
    }
    
    @Trace // While click on edit open page with reason 
    @PostMapping(PvuConstant.URL_PVU_RESPONSE)
    public ResponseEntity<ApiResponse> getPVUResponse(@RequestBody IdDto dto) throws CustomException {
        if (dto.getId() == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, pvuEmployeTikuPayService.getPVUResponse(dto));
    }
    
    @Trace
    @PostMapping(PvuConstant.URL_PVU_REASONS)  // Get Event ReasonList in droupDown
    public ResponseEntity<ApiResponse> getTikupayReasons() {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, pvuEmployeTikuPayService.getTikupayReasons());
    }
    
    @Trace
    @PostMapping(PvuConstant.URL_POST_RETURN_REMARKS)   // Auditor Remarks as return
    public ResponseEntity<ApiResponse> returnReasonByTransNo(@RequestBody IdDto idDto) throws CustomException {
        List<PVUEventRemarksDto> lstRemarksDto = pvuEmployeTikuPayService.getReturnReasonByTransactionId(idDto.getId());
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRemarksDto);
    }
    
 // Submit data with select recommendation and Remarks
    @Trace  // WorkFlow Submit...
    @PostMapping(URLConstant.PVU_CREATE_UPDATE_REMARKS) 
    public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUEmployeTikuPayDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, pvuEmployeTikuPayService.updateTikupayRemarks(dto));
    }

    @Trace
	@PostMapping(URLConstant.URL_PVU_OUTWARD_LIST)
	public ResponseEntity<ApiResponse> getOutwardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,pvuEmployeTikuPayService.getOutwardList(pageDetail));
	}
	
	@Trace
	@PostMapping(PvuConstant.URL_GENERATE_OUTWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateOutwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,	pvuEmployeTikuPayService.generateOutwardNumber(dto));
	}
	
	@Trace
	@PostMapping(PvuConstant.URL_POST_OUTWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submitOutward(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto)	throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED,pvuEmployeTikuPayService.submitOutward(wrapperDto));
	} 
	
	// Print 
	@Trace
	@PostMapping(URLConstant.GET_PVU_PRINT_ENDORSEMENT_LIST)
	public ResponseEntity<ApiResponse> getPrintEndorsements(@RequestBody PageDetails pageDetail)	throws CustomException {
		PagebleDTO<PVUCsPrintEndorsementView> data = pvuEmployeTikuPayService.getPrintEndorsementsList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)// Print Remarks
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto)throws CustomException {
		String result = pvuEmployeTikuPayService.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, result);
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT_LIST)
	public ResponseEntity<ApiResponse> generatePrintEndorsementList(@RequestBody List<PvuPrintStickerReportDto> dto)throws CustomException {
		String result = pvuEmployeTikuPayService.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,	result);
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_PRINTENDORSEMENT_REMARK)
	public ResponseEntity<ApiResponse> getReprintEndorsementRemarks(@RequestBody IdDto dto) throws CustomException {
		List<PVUPrintEndorsementRemarkHistoryDto> result = pvuEmployeTikuPayService.getPrintEndorsementHistory(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.IFMS_MSG_FETCH_LIST,result);
	}
    
}
