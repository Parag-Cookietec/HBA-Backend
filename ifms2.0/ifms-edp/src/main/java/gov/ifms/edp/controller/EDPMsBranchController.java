package gov.ifms.edp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
import gov.ifms.edp.converter.EDPMsBranchConverter;
import gov.ifms.edp.dto.EDPBranchCrViewDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPTedpBrDtlDto;
import gov.ifms.edp.dto.EDPTedpBrHdrDto;
import gov.ifms.edp.dto.EDPUsrBrMapSearchView;
import gov.ifms.edp.service.EDPMsBranchService;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsBranchController.
 * 
 * @version 1.0.
 * @created 2019/08/29 18:24:43.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_BRANCH)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsBranchController {

	/** The service. */
	@Autowired
	private EDPMsBranchService service;
	
	/** The service. */
	@Autowired
	private EDPMsBranchConverter converter;
	
	/**
	 * Gets the branch listby branch type.
	 *
	 * @param id the id
	 * @return the branch listby branch type
	 */
	@Trace
	@PostMapping(URLConstant.GET_BRANCH_BY_TYPE_ID)
	public ResponseEntity<ApiResponse> getBranchListbyBranchType(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				converter.toDTO(service.getBranchListbyBranchType(id.getId())));
	}
	
	/**
	 * Gets the branch data.
	 *
	 * @return the branch data
	 */
	@Trace
	@PostMapping(URLConstant.GET_BRANCH_DATA)
	public ResponseEntity<ApiResponse> getBranchData() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,service.getBranchData());
	}

	/**
	 * Save branch.
	 *
	 * @param hdrDto the hdr dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.SAVE_BRANCH)
	public ResponseEntity<ApiResponse> saveBranch(@RequestBody EDPTedpBrHdrDto hdrDto) throws CustomException {
		if(null != hdrDto.getOfficeId() && null != hdrDto.getBranchType() && !StringUtils.isEmpty(hdrDto.getBranchName())) {
			return hdrDto.getFormAction() == Status.DRAFT 
					?ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_BRANCH_CR_SAVE_AS_DRFT,service.saveBranch(hdrDto))
					:ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_BRANCH_CR_SUBMIT,service.saveBranch(hdrDto));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	@Trace
	@PostMapping(URLConstant.GET_BRANCH_REQUEST_TYPE)
	public ResponseEntity<ApiResponse> getBranchRequestType() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.getBranchRequestType());
	}

	@Trace
	@PostMapping(URLConstant.GET_EMP_AND_POST_FOR_OFFICE)
	public ResponseEntity<ApiResponse> getEmpPostInOffice(@RequestBody EDPIdDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
					service.getEmpPostInOffice(dto.getOfficeId()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * List br cr.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	*/
	@Trace
	@PostMapping(URLConstant.URL_EDP_BR_CR_LIST)
	public ResponseEntity<ApiResponse> listBrCr(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPBranchCrViewDto> data = service.searchList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.GET_OFFICE_BRANCHES)
	public ResponseEntity<ApiResponse> getBranchesForOffice() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.getBranchesForOffice());
	}

	@Trace
	@PostMapping(URLConstant.GET_EMP_BRANCHES)
	public ResponseEntity<ApiResponse> getEmpMappedBranches(@RequestBody EDPIdDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
					service.getEmpMappedBranches(dto.getPostOfficeUserId()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	
	/**
	 * Branch cr delete.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_BR_CR_DELETE)
	public ResponseEntity<ApiResponse> branchCrDelete(@RequestBody IdDto id) throws CustomException {
		if(null != id.getId()) {			
			service.deleteBranchCrRequest(id.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_BRANCH_CR_DELET);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}


	@Trace
	@PostMapping(URLConstant.SAVE_BRANCH_MAPPING)
	public ResponseEntity<ApiResponse> saveBranchMapping(@RequestBody EDPTedpBrDtlDto hdrDto) throws CustomException {
			if(!EDPConstant.BRANCH_TRANSFER_REQ_TYPE_ID.equals(hdrDto.getRequestType()))
			{
				if(hdrDto.getFormAction() == Status.SUBMITTED)
					return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_BRANCH_MAP_SUBMIT,service.saveBranchMapping(hdrDto));
				else
					return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_BRANCH_MAP_CREATE,service.saveBranchMapping(hdrDto));
			}
			else {
				if(hdrDto.getFormAction() == Status.SUBMITTED)
					return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_BRANCH_TRANSFER_SUBMIT,service.saveBranchMapping(hdrDto));				
				else
					return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_BRANCH_TRANSFER_CREATE,service.saveBranchMapping(hdrDto));
			}				
	}

	@Trace
	@PostMapping(URLConstant.URL_BRANCH_MAP_SEARCH_FILTER)
	public ResponseEntity<ApiResponse> getSearchFilter(){
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,service.getSearchFilter());
	}
	
	@Trace
	@PostMapping(URLConstant.URL_BR_MAPPING_LIST)
	public ResponseEntity<ApiResponse> getBranchMappingList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPUsrBrMapSearchView> data = service.getBranchMappingList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.GET_BRANCH_MAP_BY_ID)
	public ResponseEntity<ApiResponse> getBrMapDtlByHdr(@RequestBody IdDto id) throws CustomException {
		if(null != id.getId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,service.getBrMapDtlByHdr(id.getId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BR_MAP_BY_HDR_ID)
	public ResponseEntity<ApiResponse> deleteBrMapRequest(@RequestBody IdDto id) throws CustomException {
		if(null != id.getId()) {
			service.deleteBrMapRequest(id.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	@Trace
	@PostMapping(URLConstant.URL_BRMAP_REQUEST_EXISTS)
	public ResponseEntity<ApiResponse> checkForBrMapRequest(@RequestBody EDPIdDto dto) throws CustomException {
		if(dto.getPostOfficeUserId() != 0) {
			service.checkForExistingRequest(dto.getPostOfficeUserId());		
			return ResponseUtil.getResponse(HttpStatus.OK, "");
		} else {
		throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}

	}

	@Trace
	@PostMapping(URLConstant.URL_CHECK_USER_ACCESS_FOR_BRANCH)
	public ResponseEntity<ApiResponse> checkForUserAccess(@RequestBody EDPIdDto dto) throws CustomException {
		if(null != dto.getFromPouId() && null != dto.getToPouId()) {
			Map<String, Object> responseDto = service.checkUserAccess(dto.getFromPouId(), dto.getToPouId());
			if(responseDto.isEmpty())
				return ResponseUtil.getResponse(HttpStatus.OK, "");
			else
				return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, responseDto.get("message").toString(),responseDto.get("response"));
				
		}else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	/**
	 * Gets the branch listby branch type.
	 *
	 * @param id the id
	 * @return the branch listby branch type
	 */
	@Trace
	@PostMapping(URLConstant.GET_BRANCH_BY_TYPE_ID_AND_OFFICE_ID)
	public ResponseEntity<ApiResponse> getBranchListbyBranchTypeAndOfficeId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				converter.toDTO(service.getBranchListbyBranchTypeAndOfficeId(id.getId())));
	}
}
