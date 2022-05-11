package gov.ifms.pvu.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import gov.ifms.pvu.dto.*;
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
import gov.ifms.pvu.converter.PVUEmployeAssuredCareerProgressionConverter;
import gov.ifms.pvu.entity.PVUACPAttachmentEntity;
import gov.ifms.pvu.entity.PVUEmployeAssuredCareerProgressionEntity;
import gov.ifms.pvu.service.PVUACPAttachmentService;
import gov.ifms.pvu.service.PVUEmployeAssuredCareerProgressionService;
import gov.ifms.pvu.util.PvuConstant;

/**
 *
 */
@RestController
@RequestMapping(PvuConstant.URL_PVU_ASSURED_CAREER_PROGRESSION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeAssuredCareerProgressionController
		extends BasePVUAttachmentController<PVUACPAttachmentEntity, PVUACPAttachmentDto> {

	/** The service. */
	@Autowired
	private PVUEmployeAssuredCareerProgressionService service;

	/** The converter. */
	@Autowired
	private PVUEmployeAssuredCareerProgressionConverter converter;

	@Autowired
	private PVUACPAttachmentService pvuACPAttachmentService;

	/**
	 * Get ACP Detils by Id
	 * 
	 * @param id
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeAssuredCareerProgression(@RequestBody IdDto id) {
		PVUEmployeAssuredCareerProgressionEntity entity = service.getEmployeAssuredCareerProgression(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * Save Employee ACP Details
	 * 
	 * @param dto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeAssuredCareerProgression(
			@RequestBody PVUEmployeAssuredCareerProgressionDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateEmployeAssuredCareerProgression(dto)));
	}

	/**
	 * update Employee ACP Details
	 * 
	 * @param dto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmployeAssuredCareerProgression(
			@RequestBody PVUEmployeAssuredCareerProgressionDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateEmployeAssuredCareerProgression(dto)));
	}

	/**
	 * Get All ACP List
	 * 
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getEmployeAssuredCareerProgressions(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeAssuredCareerProgressionDto> data = service
				.getEmployeAssuredCareerProgressions(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Get ACP Lookup data
	 * 
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_ALL_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Get ACP employee Current Details
	 * 
	 * @param acpEmployeeRequest
	 * @return
	 * @throws CustomException
	 * @throws ParseException
	 */
	@Trace
	@PostMapping(URLConstant.URL_ACP_EMPLOYEE_DETAIL)
	public ResponseEntity<ApiResponse> acpEmployeeDetails(@Valid @RequestBody PVUACPDetailRequest acpEmployeeRequest)
			throws CustomException, ParseException {
		acpEmployeeRequest.validateAll();
		AcpEmployeeDetailDto pvuEmployeeApiDto = service.getAcpEmployeeDetails(acpEmployeeRequest);
		Map<String, Object> map = new HashMap<>();
		if (pvuEmployeeApiDto != null) {
			map.put(PvuConstant.EMPLOYEE, pvuEmployeeApiDto);
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, map);
	}

	/**
	 * Delete ACP Event if record on save as draft
	 * 
	 * @param idDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteACPEvent(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteAcpTrns(idDto));
	}

	/**
	 * Get Six pay scale Values.
	 * 
	 * @param request
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_SIXTH_PAY_COMMISSION_SCALE_VALUES)
	public ResponseEntity<ApiResponse> getSixthPayComissionScalValues(@RequestBody PvusixthPayCommissionRequest request)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getSixthPayComissionScale(request));
	}

	/**
	 * Get DDO Side ACP Listing
	 * 
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_ACP_PAY_DDO_LIST)
	public ResponseEntity<ApiResponse> getACPDDOList(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUEmpACPEditListView> data = service.getACPDDOList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * ACP submit event.
	 * 
	 * @param wrapperDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_ITR_INSERT + "/201")
	public ResponseEntity<ApiResponse> insertInITR(@RequestBody PvuWFWrapperDto wrapperDto) throws CustomException {
		try {
			PVUEmployeAssuredCareerProgressionDto pvuEmployeeACPDto = service.insertACPItr(wrapperDto);
			return ResponseUtil.getResponse(HttpStatus.OK,
					MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, wrapperDto.getTrnStatus()),
					pvuEmployeeACPDto);
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
	}

	public BasePVUAttachmentService<PVUACPAttachmentEntity, PVUACPAttachmentDto> getAttachmentService() {
		return pvuACPAttachmentService;
	}

	/**
	 * Get Inward Number For ACP
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_GENERATE_INWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateInwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.generateInwardNumber(dto));
	}

	/**
	 *
	 * @param wrapperDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_POST_INWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submitForInwardTable(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_DISTRIBUTOR,
				service.submiAcpInward(wrapperDto));
	}

	/**
	 * Inward Listing for ACP
	 * 
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping("/acp-inward/" + URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAcpInwardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getAcpInwardList(pageDetail));
	}

	/**
	 * To Insert wf table
	 * 
	 * @param wrapperDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_DISTRIBUTOR_SUBMIT)
	public ResponseEntity<ApiResponse> submitAcpDistributor(@RequestBody List<PvuWFWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_ROP_FORWARD_AUDITOR,
				service.submitAcpDistributor(wrapperDto));
	}

	/**
	 * Update ACP Table For update Remarks For AUDITOR / APPROVER CLASS II /
	 * VERIFIER / APPPROVER CLASS I
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_ACP_CREATE_UPDATE_REMARKS)
	public ResponseEntity<ApiResponse> updateRemarks(@RequestBody PVUEmployeAssuredCareerProgressionDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.updateAcpRemarks(dto));

	}

	/**
	 * Get PVU OFFICE NAME COMMON FOR ALL PVU EVENT.
	 * 
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_ROP_GET_PVU_OFFICE)
	public ResponseEntity<ApiResponse> getEmployeeACPPOfficeDetails(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUOfficeName(idDto));
	}

	/**
	 * GET Data for PVU LEVEL Listing API for ACP
	 * 
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_ROP_EMPLOYEE_SEARCH)
	public ResponseEntity<ApiResponse> pvuAuditorList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.pvuAuditorList(pageDetail));
	}

	/**
	 * pvu response for current details and post details
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 * @throws ParseException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_PVU_RESPONSE)
	public ResponseEntity<ApiResponse> getPVUResponse(@RequestBody IdDto dto) throws CustomException, ParseException {
		if (dto.getId() == null) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPVUResponse(dto));
	}

	/**
	 * Get Current Trn for workflo
	 * 
	 * @param id
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_WF_RL_CD_ACP_TRN_ID)
	public ResponseEntity<ApiResponse> getWfRoleCodeByTrnId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,
				service.getWfRoleCodeByTrnId(id.getId()));
	}

	/**
	 * GET PVU REASON for return any trn
	 * 
	 * @return
	 */
	@Trace
	@PostMapping(PvuConstant.URL_PVU_REASONS)
	public ResponseEntity<ApiResponse> pvuOfficeSSPReasonCode() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getAcpPayReasons());
	}

	/**
	 * Get Remarks
	 * 
	 * @param idDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_PVU_GET_REMARKS_RESPONSE)
	public ResponseEntity<ApiResponse> ropReturnReasonByTransNo(@RequestBody IdDto idDto) throws CustomException {
		if (idDto.getId() == null) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "id must be not null !");
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getRemarkByeventId(idDto.getId()));
	}

	/**
	 * Get Outward Number
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_GENERATE_OUTWARD_NUMBER)
	public ResponseEntity<ApiResponse> generateOutwardNumber(@RequestBody List<IdDto> dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.generateOutwardNumber(dto));
	}

	/**
	 * Get Outward Listing
	 * 
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_CSP_OUTWARD_LIST)
	public ResponseEntity<ApiResponse> getSPOutwardList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getACPOutwardList(pageDetail));
	}

	/**
	 * Outward Submit
	 * 
	 * @param wrapperDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(PvuConstant.URL_POST_OUTWARD_SUBMIT)
	public ResponseEntity<ApiResponse> submitSPOutward(@RequestBody List<PvuWFOutWardWrapperDto> wrapperDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_OUTWARDED,
				service.submitACPOutward(wrapperDto));
	}

	/**
	 * Get Print Endorsement Listing
	 * 
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.GET_PVU_PRINT_ENDORSEMENT_LIST)
	public ResponseEntity<ApiResponse> getACPPrintEndorsements(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUPrintEndorsementView> data = service.getACPPrintEndorsement(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Generate Print For ACP
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody PvuPrintStickerReportDto dto)
			throws CustomException, IOException {

		String result = service.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, result);
	}

	/**
	 * Get Multiple Print /
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT_LIST)
	public ResponseEntity<ApiResponse> generatePrintEndorsementList(@RequestBody List<PvuPrintStickerReportDto> dto)
			throws CustomException, IOException {

		String result = service.generatePrintEndorsement(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, result);

	}

	/**
	 * Get History Of Reprint remarks History.
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_PRINTENDORSEMENT_REMARK)
	public ResponseEntity<ApiResponse> getReprintEndorsementRemarks(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getPrintEndorsementHistory(dto.getId()));
	}

}
