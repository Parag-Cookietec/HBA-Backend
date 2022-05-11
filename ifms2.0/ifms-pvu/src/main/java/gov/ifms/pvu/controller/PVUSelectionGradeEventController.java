
package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.util.List;

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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUSelectionGradeEventConverter;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUSGPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSelectionGradPayLelevView;
import gov.ifms.pvu.dto.PVUSelectionGradeEventDto;
import gov.ifms.pvu.dto.PVUSelectionGradenwardView;
import gov.ifms.pvu.dto.PVUSgAttachmentDto;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUSelectionGradeEventEntity;
import gov.ifms.pvu.entity.PVUSgAttachmentEntity;
import gov.ifms.pvu.service.PVUSelectionGradeEventService;
import gov.ifms.pvu.service.PVUSgAttachmentService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUSelectionGradeEventController.
 * 
 * @version v 1.0.
 * @created 2019/12/18 11:56:47.
 *
 */

@RestController
@RequestMapping(URLConstant.URL_PVU_SELECTIONGRADEEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUSelectionGradeEventController  extends BasePVUAttachmentController<PVUSgAttachmentEntity, PVUSgAttachmentDto> {

	/** The logger. */

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The service. */

	@Autowired
	private PVUSelectionGradeEventService service;

	/** The converter. */

	@Autowired
	private PVUSelectionGradeEventConverter converter;

	/** The SgAttachmentService service. */
	@Autowired
	private PVUSgAttachmentService pvuSgAttachmentService;

	
	
	@Override
	public BasePVUAttachmentService<PVUSgAttachmentEntity, PVUSgAttachmentDto> getAttachmentService() {
		return pvuSgAttachmentService;
	}
	
	
	
	/**
	 * Fetch SelectionGradeEvents by given SelectionGradeEvents id.
	 *
	 * @param id the id
	 * @return dto
	 */

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getSelectionGradeEvent(@RequestBody IdDto id) {
		PVUSelectionGradeEventEntity entity = service.getSelectionGradeEvent(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new SelectionGradeEvents.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createSelectionGradeEvent(@RequestBody PVUSelectionGradeEventDto dto) throws CustomException {
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
					converter.toDTO(service.saveOrUpdateSelectionGradeEvent(dto)));

	}

	/**
	 * Update the SelectionGradeEvents.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */

	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateSelectionGradeEvent(@RequestBody PVUSelectionGradeEventDto dto) {
		PVUSelectionGradeEventDto dbDto = null;
		try {
			dbDto = converter.toDTO(service.saveOrUpdateSelectionGradeEvent(dto));
		} catch (Exception e) {
			logger.info( e.getMessage());
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE, dbDto);
	}

	/**
	 * Fetch all the SelectionGradeEvents items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUSelectionGradeEventDto>
	 * @throws CustomException the custom exception
	 */

	@Trace
	@PostMapping("/selection-inward/" + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getSelectionGradeInwerdLists(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUSelectionGradenwardView> data = service.getSelectionGradeEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	
	@Trace
	@PostMapping(PvuConstant.URL_GET_SEVEN_PAY_BASIC_CELL)
	public ResponseEntity<ApiResponse> getSevenBasicByPlevelAndPk(@RequestBody PvuCommonRequest request)
			throws CustomException {
		PVUSelectionGradPayLelevView result = service.getEmployeeCheckPayLevelByPaylevelId(request);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, result);
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_INSERT_SG_ITR)
	public ResponseEntity<ApiResponse> insertSelectionGradeItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()),
					service.insertSelectionGradeItr(pvuWFWrapperDto));
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
	}

	  @Trace
	    @PostMapping(PvuConstant.DDO_WF_LISTING)
	    public ResponseEntity<ApiResponse> ddoWFListing(@RequestBody PageDetails pageDetails) throws CustomException {
	        try {
	            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.ddoWFListingSg(pageDetails));
	        } catch (Exception e) {
	            logger.error(e.toString(), e);
	            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
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
		public ResponseEntity<ApiResponse> getEmployeeSSPOfficeDetails(@RequestBody IdDto idDto) {
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
		 * Submit SG event.
		 *
		 * @param wrapperDto the wrapper dto
		 * @return the response entity
		 * @throws CustomException the custom exception
		 */
		@Trace
		@PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
		public ResponseEntity<ApiResponse> submitSSPInward(@RequestBody List<PvuWFWrapperDto> wrapperDto)
				throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,
					service.submitSelectionGradeInward(wrapperDto));
		}

		/**
		 * Update the deleteSGEvent.
		 *
		 * @param dto the dto
		 * @return the updated entity in dto type
		 * @throws CustomException the custom exception
		 */
		@Trace
		@PostMapping(URLConstant.URL_DELETE_BY_ID)
		public ResponseEntity<ApiResponse> deleteSgEvent(@RequestBody IdDto id) throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteSgEvent(id.getId()));
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
		public ResponseEntity<ApiResponse> submitSelectionGradeDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto)
				throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,
					service.submitSelectionGradDistributor(wrapperDto));
		}
		
	// In Auditor
	@Trace // Get PVU office list data with search details
	@PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
	public ResponseEntity<ApiResponse> pvuOfficeEmployeeSearchByAuditor(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.pvuOfficeEmployeeSearch(pageDetail));
	}
		
	@Trace // While click on edit open page with reason
	@PostMapping(URLConstant.URL_ROP_REASON)
	public ResponseEntity<ApiResponse> returnReasonList() {
		List<PVUMsReasonDto> lstRopReason = service.getSelectionGradReasons();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRopReason);
	}
	
	 @Trace // Submit data with select recommendation and Remarks
	    @PostMapping(PvuConstant.URL_POST_RETURN_REMARKS)
	    public ResponseEntity<ApiResponse> ropReturnReasonByTransNo(@RequestBody IdDto idDto) throws CustomException {
	        List<PVUEventRemarksDto> lstRemarksDto = service.getReturnReasonByTransactionId(idDto.getId());
	        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRemarksDto);
	    }
	
	 @Trace
		@PostMapping(PvuConstant.URL_PVU_RESPONSE)
		public ResponseEntity<ApiResponse> getPVUResponse(@RequestBody IdDto dto) throws CustomException {
			if (dto.getId() == null) {
				throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
			}
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUResponse(dto));
		}
	 
	 @Trace
		@PostMapping(PvuConstant.URL_PVU_GET_REMARKS_RESPONSE)
		public ResponseEntity<ApiResponse> getPVURemarksResponse(@RequestBody IdDto dto) throws CustomException {
			if (dto.getId() == null) {
				throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
			}
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getRemarkByeventId(dto.getId()));
		} 
	 
	 @Trace
		@PostMapping(URLConstant.URL_WFR_CODE_SELECTIONGRAD)
		public ResponseEntity<ApiResponse> getWfCodeBySelectionGradeTrnId(@RequestBody IdDto id) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,service.getWfCodeBySelectionGradeTrnId(id.getId()));
		}
	 
	 /**
		 * Update remarks.
		 *
		 * @param dto the dto
		 * @return the response entity
		 * @throws CustomException the custom exception
		 */
		@Trace
		@PostMapping(URLConstant.URL_SHP_CREATE_UPDATE_REMARKS)
		public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUSelectionGradeEventDto dto) throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.updateSGRemarks(dto));
		}
		
		/**
		 * Gets the SP outward list.
		 *
		 * @param pageDetail the page detail
		 * @return the SP outward list
		 * @throws CustomException the custom exception
		 */
		@Trace
		@PostMapping(URLConstant.URL_SG_OUTWARD_LIST)
		public ResponseEntity<ApiResponse> getSGOutwardList(@RequestBody PageDetails pageDetail) throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
					service.getSGOutwardList(pageDetail));
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
		 * Submit SP outward.
		 *
		 * @param wrapperDto the wrapper dto
		 * @return the response entity
		 * @throws CustomException the custom exception
		 */
		@Trace
		@PostMapping(PvuConstant.URL_POST_OUTWARD_SUBMIT)
		public ResponseEntity<ApiResponse> submitSPOutward(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto)
				throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED,
					service.submitSGOutward(wrapperDto));
		}
		
		@Trace
		@PostMapping(URLConstant.GET_PVU_PRINT_ENDORSEMENT_LIST)
		public ResponseEntity<ApiResponse> getRopPrintEndorsements(@RequestBody PageDetails pageDetail)
				throws CustomException {
			PagebleDTO<PVUSGPrintEndorsementView> data = service.getPrintEndorsementsList(pageDetail);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
		}
		
		@Trace
		@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)  // While Click on Print Button Remarks updated..
		public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto) throws CustomException {
			return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.IFMS_MSG_SUBMITTED , service.generatePrintEndorsement(dto));
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
			List<PrintEndorsementRemarkHistoryDto> result = service.getReprintEndorsementRemarks(dto.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);
		}
		
}
