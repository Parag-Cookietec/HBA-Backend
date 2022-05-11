package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUEmployeShettyPayConverter;
import gov.ifms.pvu.dto.PVUEmployeShettyPayDto;
import gov.ifms.pvu.dto.PVUSPPrintEndorsementView;
import gov.ifms.pvu.dto.PVUShettyPayAttachmentDto;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeShettyPayEntity;
import gov.ifms.pvu.entity.PVUShettyPayAttachmentEntity;
import gov.ifms.pvu.service.PVUEmployeShettyPayService;
import gov.ifms.pvu.service.PVUShettyPayAttachmentService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeShettyPayController.
 * 
 * @version v 1.0.
 * @created 2020/01/06 12:53:37.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYESHETTYPAY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeShettyPayController
		extends BasePVUAttachmentController<PVUShettyPayAttachmentEntity, PVUShettyPayAttachmentDto> {

	/** The service. */
	@Autowired
	private PVUEmployeShettyPayService service;

	/** The converter. */
	@Autowired
	private PVUEmployeShettyPayConverter converter;

	/** The cs attachment service. */
	@Autowired
	private PVUShettyPayAttachmentService spAttachmentService;

	/**
	 * Fetch EmployeShettyPays by given EmployeShettyPays id
	 * 
	 * @param id
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeShettyPay(@RequestBody IdDto id) throws CustomException {
		PVUEmployeShettyPayEntity entity = service.getEmployeShettyPay(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new EmployeShettyPays
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeShettyPay(@RequestBody PVUEmployeShettyPayDto dto)
			throws CustomException {

		if (dto.isSubmit()) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdateEmployeShettyPay(dto));
	}

	/**
	 * Update the EmployeShettyPays
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmployeShettyPay(@RequestBody PVUEmployeShettyPayDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				service.saveOrUpdateEmployeShettyPay(dto));
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.CHECK_EMPLOYEE_ELIGIBLE_SP)
	public ResponseEntity<ApiResponse> checkEmployeeEligible(@RequestBody PvuCommonRequest request)
			throws CustomException {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.checkEligibleforShettyPay(request));

	}

	/**
	 * Gets the attachment service.
	 *
	 * @return the attachment service
	 */
	@Override
	public BasePVUAttachmentService<PVUShettyPayAttachmentEntity, PVUShettyPayAttachmentDto> getAttachmentService() {
		return spAttachmentService;
	}

	/**
	 * Search shetty pay events.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_SP_EVENT_SEARCH)
	public ResponseEntity<ApiResponse> searchShettyPayEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.searchShettyPayEvents(pageDetail));
	}

	/**
	 * Insert shetty pay itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_SP_EVENT_ITR_INSERT)
	public ResponseEntity<ApiResponse> insertShettyPayItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()),
				service.insertShettyPayItr(pvuWFWrapperDto));
	}

	/**
	 * Gets the employee PVU office details.
	 *
	 * @param idDto the id dto
	 * @return the employee PVU office details
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
	public ResponseEntity<ApiResponse> getEmployeePVUOfficeDetails(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeName(idDto));
	}

	/**
	 * Delete SP event.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteSPEvent(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE,
				service.deleteSPEventsDetails(idDto));
	}

	/**
	 * Gets the shetty pay inward list.
	 *
	 * @param pageDetail the page detail
	 * @return the shetty pay inward list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_SP_INWARD_LIST)
	public ResponseEntity<ApiResponse> getShettyPayInwardList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getShettyPayInwardList(pageDetail));
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
	 * Submi shetty pay inward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submiShettyPayInwardAndDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,
				service.submitShettyPayInwardOrDistributor(wrapperDto));
	}

	/**
	 * Submi shetty pay distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
	public ResponseEntity<ApiResponse> submiShettyPayDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,
				service.submitShettyPayInwardOrDistributor(wrapperDto));
	}

	/**
	 * Gets the SP auditor search list.
	 *
	 * @param pageDetail the page detail
	 * @return the SP auditor search list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_SP_AUDITOR_LIST)
	public ResponseEntity<ApiResponse> getSPAuditorSearchList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getSPAuditorSearchList(pageDetail));
	}

	/**
	 * Gets the PVU remarks response.
	 *
	 * @param dto the dto
	 * @return the PVU remarks response
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_PVU_GET_REMARKS_RESPONSE)
	public ResponseEntity<ApiResponse> getPVURemarksResponse(@RequestBody IdDto dto) throws CustomException {
		if (dto.getId() == null) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getRemarkByeventId(dto.getId()));
	}

	/**
	 * Gets the PVU response.
	 *
	 * @param dto the dto
	 * @return the PVU response
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
	 * Gets the wf code by shetty pay trn id.
	 *
	 * @param id the id
	 * @return the wf code by shetty pay trn id
	 */
	@Trace
	@PostMapping(URLConstant.URL_WFR_CODE_SHETTYPAY)
	public ResponseEntity<ApiResponse> getWfCodeByShettyPayTrnId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,
				service.getWfCodeByShettyPayTrnId(id.getId()));
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
	public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUEmployeShettyPayDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.updateSPRemarks(dto));
	}

	/**
	 * Gets the SP outward list.
	 *
	 * @param pageDetail the page detail
	 * @return the SP outward list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_CSP_OUTWARD_LIST)
	public ResponseEntity<ApiResponse> getSPOutwardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getSPOutwardList(pageDetail));
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
				service.submitSPOutward(wrapperDto));
	}

	/**
	 * Gets the SP print endorsements.
	 *
	 * @param pageDetail the page detail
	 * @return the SP print endorsements
	 */
	@Trace
	@PostMapping(URLConstant.GET_PVU_PRINT_ENDORSEMENT_LIST)
	public ResponseEntity<ApiResponse> getSPPrintEndorsements(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUSPPrintEndorsementView> data = service.getSPPrintEndorsements(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto)
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
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT_LIST)
	public ResponseEntity<ApiResponse> generatePrintEndorsementList(@RequestBody List<PvuPrintStickerReportDto> dto)
			throws CustomException {
		String result = service.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				result);
	}
}
