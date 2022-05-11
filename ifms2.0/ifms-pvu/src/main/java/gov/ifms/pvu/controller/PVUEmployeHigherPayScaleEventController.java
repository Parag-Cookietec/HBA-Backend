package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import gov.ifms.pvu.dto.request.PVUOptAvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import gov.ifms.pvu.converter.PVUEmployeHigherPayScaleEventConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeHigherPayScaleEventDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUHigherPayScaleAttDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;
import gov.ifms.pvu.entity.PVUHigherPayScaleAttEntity;
import gov.ifms.pvu.service.PVUEmployeHigherPayScaleEventService;
import gov.ifms.pvu.service.PVUHigherPayScaleAttService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeHigherPayScaleEventController.
 *
 * @version v 1.0.
 * @created 2020/01/07 16:13:21.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEHIGHERPAYSCALEEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeHigherPayScaleEventController
		extends BasePVUAttachmentController<PVUHigherPayScaleAttEntity, PVUHigherPayScaleAttDto> {



	/** The service. */
	@Autowired
	private PVUEmployeHigherPayScaleEventService service;

	/** The converter. */
	@Autowired
	private PVUEmployeHigherPayScaleEventConverter converter;

	@Autowired
	private PVUHigherPayScaleAttService attService;

	@Override
	public BasePVUAttachmentService<PVUHigherPayScaleAttEntity, PVUHigherPayScaleAttDto> getAttachmentService() {
		return attService;
	}

	/**
	 * Fetch EmployeHigherPayScaleEvents by given EmployeHigherPayScaleEvents id
	 *
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeHigherPayScaleEvent(@RequestBody IdDto id) {
		PVUEmployeHigherPayScaleEventEntity entity = service.getEmployeHigherPayScaleEvent(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new EmployeHigherPayScaleEvents
	 *
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeHigherPayScaleEvent(
			@RequestBody PVUEmployeHigherPayScaleEventDto dto) throws CustomException {
		if (dto.getFormAction() == Status.DRAFT) {
			dto.draftFieldValidate();
		}
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdateEmployeHigherPayScaleEvent(dto));
	}

	/**
	 * Update the EmployeHigherPayScaleEvents
	 *
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmployeHigherPayScaleEvent(
			@RequestBody PVUEmployeHigherPayScaleEventDto dto) throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				service.saveOrUpdateEmployeHigherPayScaleEvent(dto));
	}

	/*
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 *
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_ALL_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	@Trace
	@PostMapping(PvuConstant.URL_GET_HIGHER_PAY_ELIGIBLE)
	public ResponseEntity<ApiResponse> checkEligibleHigherPay(@RequestBody PvuCommonRequest request)
			throws CustomException,ParseException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getValidEligleEmployeeForHigherPayScale(request));
	}

	/**
	 * Use for ddo office Higher Pay Scale.
	 *
	 * @param pageDetails page details
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.DDO_WF_LISTING)
	public ResponseEntity<ApiResponse> ddoWFListing(@RequestBody PageDetails pageDetails) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
					service.ddoWFListing(pageDetails));
		} catch (CustomException e) {

			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
	}

	@Trace
	@PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
	public ResponseEntity<ApiResponse> insertInITR(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
		try {
			PVUEmployeHigherPayScaleEventDto pvuEmployeHigherPayScaleEventDto = service.insertHigherPayItr(wrapperDto);
			return ResponseUtil.getResponse(HttpStatus.OK,  MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()),
					pvuEmployeHigherPayScaleEventDto);
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
	public ResponseEntity<ApiResponse> getEmployeeHPSOfficeDetails(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeName(idDto));
	}

	@Trace // While login with Inward,showing Inward Listing
	@PostMapping("/higherpay-inward/" + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getHigherpayInwardList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getHigherPayInwardList(pageDetail));
	}

	@Trace // Received the Record from Inward login with select record throw checkBox
	@PostMapping(PvuConstant.URL_GENERATE_INWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.generateInwardNumber(dto));
	}

	@Trace
	@PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submiHigherPayInward(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,
				service.submiHigherPayInward(wrapperDto));
	}

	// Distributer
	@Trace
	@PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
	public ResponseEntity<ApiResponse> submitHPSDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,
				service.submitHigherpayDistributor(wrapperDto));
	}

	@Trace // Get PVU office list data with search details
	@PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
	public ResponseEntity<ApiResponse> pvuOfficeEmployeeSearch(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.pvuOfficeEmployeeSearch(pageDetail));
	}

	@Trace // While click on edit open page with reason
	@PostMapping(URLConstant.URL_ROP_REASON)
	public ResponseEntity<ApiResponse> returnReasonList() {
		List<PVUMsReasonDto> lstRopReason = service.getHigherpayReasons();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRopReason);
	}

	@Trace // Submit data with select recommendation and Remarks
	@PostMapping(URLConstant.HPG_HPG_RETURN_REASON)
	public ResponseEntity<ApiResponse> ropReturnReasonByTransNo(@RequestBody IdDto idDto) throws CustomException {
		List<PVUEventRemarksDto> lstRemarksDto = service.getReturnReasonByTransactionId(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRemarksDto);
	}

	@Trace // WorkFlow Submit...
	@PostMapping(URLConstant.URL_HPG_CREATE_UPDATE_REMARKS)
	public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUSSPRemarkRequest dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.updateHigherpayRemarks(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_WFR_CODE_HIGHERPAY)
	public ResponseEntity<ApiResponse> getWfCodeByHigherPayTrnId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,
				service.getWfCodeByHigherPayTrnId(id.getId()));
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
	@PostMapping("/hps-outward-list/" + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getHPSOutWardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getHPSOutWardList(pageDetail));
	}

	@Trace
	@PostMapping(PvuConstant.URL_GENERATE_OUTWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateOutWardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.generateOutWardNumber(dto));
	}

	@Trace
	@PostMapping("/submit-outward")
	public ResponseEntity<ApiResponse> submitHPSOutWard(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED,
				service.submitHPSOutWard(wrapperDto));
	}
	/**
	 * Gets the SSP outward List.
	 *
	 * @param pageDetail the page detail
	 * @return the out ward
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping("/hps-endorsement-list")
	public ResponseEntity<ApiResponse> getSSPPrintEndorsementList(@RequestBody PageDetails pageDetail) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getHPGPrintEndorsementList(pageDetail));
		} catch (Exception ex) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT) // While Click on Print Button Remarks updated..
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto) throws CustomException {
		String result = service.generateHPSPrintEndorsement(dto);
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
		List<PrintEndorsementRemarkHistoryDto> result = service.getReprintEndorsementRemarks(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);
	}

	@Trace // Delete from DDO Listing API
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteHigherPayEventById(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteHigherPayEventById(idDto));
	}

}
