package gov.ifms.pvu.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVURevisionOfPayDto;
import gov.ifms.pvu.dto.PVURevisionOfPaySearchView;
import gov.ifms.pvu.dto.PVURopAttachmentDto;
import gov.ifms.pvu.dto.PVURopDetailRequest;
import gov.ifms.pvu.dto.PVURopEmployeView;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.dto.PVURopView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.RopEmployeeDetailDto;
import gov.ifms.pvu.entity.PVURopAttachmentEntity;
import gov.ifms.pvu.service.PVURevisionOfPayService;
import gov.ifms.pvu.service.PVURopAttachmentService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVURevisionOfPayController.
 *
 * @version v 1.0.
 * @created 2020/01/09 12:59:56.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_REVISIONOFPAY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVURevisionOfPayController
		extends BasePVUAttachmentController<PVURopAttachmentEntity, PVURopAttachmentDto> {

	/** The service. */
	@Autowired
	private PVURevisionOfPayService service;

	/** The pvu common service. */
	@Autowired
	private PVUCommonService pvuCommonService;

	/** The pvu rop attachment service. */
	@Autowired
	private PVURopAttachmentService pvuRopAttachmentService;

	/**
	 * Gets the list look up info as map.
	 *
	 * @return the list look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_FETCH_LOOKUP)
	public ResponseEntity<ApiResponse> getListOfROPLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = pvuCommonService
				.getLookUpInfoAsMap(PvuConstant.PVU_ROP_CREATE_LOOKUP_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}
	
	/**
	 * Rop employee search.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_EMPLOYEE_SEARCH)
	public ResponseEntity<ApiResponse> ropEmployeeSearch(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVURopEmployeView> data = service.getRopSearchEmployes(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}
	
	/**
	 * Rop employee details.
	 *
	 * @param ropEmployeeRequest the rop employee request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_EMPLOYEE_DETAIL)
	public ResponseEntity<ApiResponse> ropEmployeeDetails(@Valid @RequestBody PVURopDetailRequest ropEmployeeRequest)
			throws CustomException, ParseException {
		ropEmployeeRequest.setValidateString(URLConstant.URL_ROP_EMPLOYEE_DETAIL);
		ropEmployeeRequest.validateAll();
		RopEmployeeDetailDto pvuCommonApiDto = service.getRopEmployeeDetails(ropEmployeeRequest);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, pvuCommonApiDto);
	}
		
	/**
	 * Rop post details.
	 *
	 * @param pvuRopDetailRequest the pvu rop detail request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_POST_DETAILS)
	public ResponseEntity<ApiResponse> ropPostDetails(@RequestBody PVURopDetailRequest pvuRopDetailRequest)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.ropPostDetails(pvuRopDetailRequest));
	}
	
	/**
	 * Fetch RevisionOfPays by given RevisionOfPays id.
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getRevisionOfPay(@RequestBody IdDto id) throws CustomException {
		PVURopView ropView = service.getRevisionOfPayView(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, ropView);
	}

	/**
	 * Gets the revision of pays search list.
	 *
	 * @param pageDetail the page detail
	 * @return the revision of pays search list
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getRevisionOfPaysSearchList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVURevisionOfPaySearchView> data = service.getRevisionOfPaysSearchList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}
	
	/**
	 * creates a new RevisionOfPays.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createRevisionOfPay(@Valid @RequestBody PVURevisionOfPayDto dto)
			throws CustomException {
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdateRevisionOfPay(dto));
	}

	/**
	 * Submit rop event.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_SUBMIT)
	public ResponseEntity<ApiResponse> submitRopEvent(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK,  MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()), service.submitRopEvent(wrapperDto));
	}

	/**
	 * Delete rop event.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteRopEvent(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteRopTrns(idDto));
	}
	
	/**
	 * Rop return reason by trans no.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.ROP_ROP_RETURN_REASON)
	public ResponseEntity<ApiResponse> ropReturnReasonByTransNo(@RequestBody IdDto idDto) throws CustomException {
		List<PVURopRemarksDto> lstRemarksDto = service.getReturnReasonByTransactionId(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRemarksDto);
	}

	/**
	 * Return reason list.
	 *
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_REASON)
	public ResponseEntity<ApiResponse> returnReasonList() {
		List<PVUMsReasonDto> lstRopReason = service.getRopReasons();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstRopReason);
	}
	
	/**
	 * Update remarks.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_CREATE_UPDATE_REMARKS)
	public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVURevisionOfPayDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.updateRopRemarks(dto));
	}

	/**
	 * Gets the all rop history remarks.
	 *
	 * @param idDto the id dto
	 * @return the all rop history remarks
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_HST_REMARKS)
	public ResponseEntity<ApiResponse> getAllRopHistoryRemarks(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getRopRemarkHistory(idDto));
	}

	/**
	 * Pvu office ROP employee search.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
	public ResponseEntity<ApiResponse> pvuOfficeROPEmployeeSearch(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVURevisionOfPaySearchView> data = service.getPVURevisionOfPaysSearchList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Rop employee details.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
	public ResponseEntity<ApiResponse> ropEmployeeDetails(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeName(idDto));
	}
	
	/**
	 * Gets the attachment service.
	 *
	 * @return the attachment service
	 */
	@Override
	public BasePVUAttachmentService<PVURopAttachmentEntity, PVURopAttachmentDto> getAttachmentService() {
		return pvuRopAttachmentService;
	}
	
	@Trace
	@PostMapping(URLConstant.DDO_APPROVAL_CERTIFICATE)
	public ResponseEntity<ApiResponse> generateDdoApprovalCertificate(@RequestBody IdDto dto)
			throws CustomException, IOException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED,
					service.generateDdoApprovalCertificate(dto));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}
}
