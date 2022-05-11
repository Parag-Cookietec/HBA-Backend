package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import gov.ifms.pvu.dto.*;
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
import gov.ifms.pvu.converter.PVUCareerAdvancementConverter;
import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;
import gov.ifms.pvu.entity.PVUCareerAdvancementEntity;
import gov.ifms.pvu.service.PVUCareerAdvanceAttachmentService;
import gov.ifms.pvu.service.PVUCareerAdvancementService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUCarrearAdvancementController.
 *
 * @version v 1.0.
 * @created 2020/01/09 11:46:59.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_CAREERADVANCEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUCareerAdvancementController extends BasePVUAttachmentController<PVUCareerAdvanceAttachmentsEntity, PVUCareerAdvanceAttachmentsDto>{

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The service. */
	@Autowired
	private PVUCareerAdvancementService service;

	/** The converter. */
	@Autowired
	private PVUCareerAdvancementConverter converter;

	/**
	 * The converter.
	 */
	@Autowired
	private PVUCareerAdvanceAttachmentService attService;

	@Override
	public BasePVUAttachmentService<PVUCareerAdvanceAttachmentsEntity, PVUCareerAdvanceAttachmentsDto> getAttachmentService() {
		return attService;
	}


	/**
	 * Fetch CarrearAdvancements by given CarrearAdvancements id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getCarrearAdvancement(@RequestBody IdDto id) {
		PVUCareerAdvancementEntity entity = service.getCarrearAdvancement(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new CarrearAdvancements.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createCarrearAdvancement(@RequestBody PVUCareerAdvancementDto dto) throws CustomException {
		logger.info("Start createCarrearAdvancement");
		if (dto.getFormAction() == Status.DRAFT) {
			dto.draftFieldValidate();
		}
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdateCarrearAdvancement(dto));
	}

	/**
	 * Update the CarrearAdvancements.
	 *
	 * @param dto the dto
	 *
	 * @return the updated entity in dto type
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateCarrearAdvancement(@RequestBody PVUCareerAdvancementDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				service.saveOrUpdateCarrearAdvancement(dto));
	}

	/**
	 * getCarrearAdvancements return result with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getCarrearAdvancements(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUCareerAdvancementDto> data = service.getCarrearAdvancements(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}


	/**
	 * Gets the DDL lu look up info as map.
	 *
	 * @return the DDL lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_All_DDL_CA)
	public ResponseEntity<ApiResponse> getDDLLuLookUpInfoAsMap() throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getDDLLuLookUpInfoAsMap();
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_CAS_CURRENT_DETAILS)
	public ResponseEntity<ApiResponse> getEmployeeCurrentDetail(@RequestBody PVUCareerAdvanceCurDetailDto careerAdvanceCurDetailDto) throws CustomException, ParseException {
		Map<String, Object> map = service.getEmployeeCurrDetail(careerAdvanceCurDetailDto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, map);
	}

	/**
	 * Insert in itr response entity.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
	public ResponseEntity<ApiResponse> insertInITR(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
		try {
			PVUCareerAdvancementDto dto = service.insertInITR(wrapperDto);
			return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), dto);
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
	}

	/**
	 * Use for ddo office Senior scale PVU.
	 *
	 * @param pageDetails page details
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.DDO_WF_LISTING)
	public ResponseEntity<ApiResponse> getCASDDOList(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUCASDDOView> data = service.getCASDDOList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}
	@Trace // While login with Inward,showing Inward Listing
	@PostMapping("/careerAdvance-inward/" + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getCarrerAdvanceInwardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getCASInwardList(pageDetail));
	}
	/**
	 * Generate inward number.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GENERATE_INWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.generateInwardNumber(dto));
	}

	/**
	 * Submit cas event.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_INWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submitCasInward(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,service.submitCasInward(wrapperDto));
	}

	/**
	 * Submit cas distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
	public ResponseEntity<ApiResponse> submitCasDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,service.submitCasDistributor(wrapperDto));
	}

	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteCasEventById(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteCasEventById(idDto));
	}

	@Trace
	@PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
	public ResponseEntity<ApiResponse> getEmployeeCAOfficeDetails(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeName(idDto));
	}

	@Trace // Get PVU office list data with search details
	@PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
	public ResponseEntity<ApiResponse> pvuOfficeEmployeeSearch(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.pvuOfficeEmployeeSearch(pageDetail));
	}
	@Trace
	@PostMapping(PvuConstant.URL_POST_RETURN_REMARKS)   // Auditor Remarks as return
	public ResponseEntity<ApiResponse> getReturnReasonByTransactionId(@RequestBody IdDto idDto) throws CustomException {
		List<PVUEventRemarksDto> lstRemarksDto = service.getReturnReasonByTransactionId(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRemarksDto);
	}
	@Trace
	@PostMapping(URLConstant.URL_WFR_CODE_SELECTIONGRAD)
	public ResponseEntity<ApiResponse> getWfRoleCodeByTrnId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK,MsgConstant.WORKFLOW_MSG_FETCH,service.getWfRlCdByCATrnId(id.getId()));
	}

	@Trace // While click on edit open page with reason
	@PostMapping(PvuConstant.URL_PVU_RESPONSE)
	public ResponseEntity<ApiResponse> getPVUResponse(@RequestBody IdDto dto) throws CustomException {
		if (dto.getId() == null) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUResponse(dto));
	}
	@Trace
	@PostMapping(PvuConstant.URL_POST_UPDATE_REMARKS)
	public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUSSPRemarkRequest dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.updateCarrierAdvancementRemarks(dto));
	}
	@Trace
	@PostMapping("/careerAdvance-outward-list/" + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getCAOutWardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getCAOutWardList(pageDetail));
	}
	@Trace
	@PostMapping(PvuConstant.URL_GENERATE_OUTWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateOutWardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.generateOutWardNumber(dto));
	}
	@Trace
	@PostMapping("/submit-outward")
	public ResponseEntity<ApiResponse> submitCAOutWard(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED,
				service.submitCAOutWard(wrapperDto));
	}
	@Trace
	@PostMapping("/cas-print-endorsement-list")
	public ResponseEntity<ApiResponse> getCAPrintEndorsementList(@RequestBody PageDetails pageDetail) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getCAPrintEndorsementList(pageDetail));
		} catch (Exception ex) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto)
			throws CustomException {
		try {
			String result = service.generatePrintEndorsement(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, result);
		} catch (Exception e) {
			throw new CustomException(500, e.getMessage());
		}
	}
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT_LIST)// While Click on Multiple Print Button Remarks
	public ResponseEntity<ApiResponse> generatePrintEndorsementList(@RequestBody List<PvuPrintStickerReportDto> dto)
			throws CustomException {
		try {
			String result = service.generatePrintEndorsement(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);
		} catch (Exception e) {
			throw new CustomException(500, e.getMessage());
		}
	}
	@Trace
	@PostMapping(URLConstant.URL_PVU_PRINTENDORSEMENT_REMARK)
	public ResponseEntity<ApiResponse> getReprintEndorsementRemarks(@RequestBody IdDto dto) throws CustomException {
		List<PrintEndorsementRemarkHistoryDto> result = service.getReprintEndorsementRemarks(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);
	}


}
