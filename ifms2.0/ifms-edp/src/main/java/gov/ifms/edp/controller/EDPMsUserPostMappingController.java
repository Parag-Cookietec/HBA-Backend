package gov.ifms.edp.controller;

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
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsHeaderDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsSearchViewDto;
import gov.ifms.edp.service.EDPMsUserPostMappingService;

/**
 * The Class EDPMsUserPostMappingController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_POMAPPING_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EDPMsUserPostMappingController {

	/** The service. */
	@Autowired
	private EDPMsUserPostMappingService service;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/**
	 * Fetch EdpOfficeItrs by given EdpOfficeItrs id.
	 *
	 * @param json the json
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_GETBYID)
	public ResponseEntity<ApiResponse> getPostUserMappingByHeaderId(@RequestBody EDPIdDto dto) throws CustomException {
		if (null != dto.getEdpUsrTrnHeaderId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getPostUserMappingByHeaderId(dto.getEdpUsrTrnHeaderId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * creates a new EdpOfficeItrs.
	 *
	 * @param edpUsrPoTrnsDto the edp usr po trns dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_SAVE)
	public ResponseEntity<ApiResponse> createPostUserMapping(@RequestBody EDPUsrPoTrnsHeaderDto edpUsrPoTrnsDto)
			throws CustomException {
		return edpUsrPoTrnsDto.getFormAction() == Status.SUBMITTED ?
				ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_TRANSFER_SUBMIT_REQUEST,service.createUserPostMapping(edpUsrPoTrnsDto)):
				ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_TRANSFER_SAVE_REQUEST,service.createUserPostMapping(edpUsrPoTrnsDto));

	}

	/**
	 * Deletes the EdpOfficeItrs for the given id.
	 *
	 * @param json the json
	 * @return the api response
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_DELETE)
	public ResponseEntity<ApiResponse> deletePostUserMapping(@RequestBody IdDto id)
			throws CustomException {
		service.deleteUPMapping(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_TRANSFER_DELETE_REQUST, null);
	}

	/**
	 * List edp offices.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_LIST)
	public ResponseEntity<ApiResponse> listPostUserMappings(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPUsrPoTrnsSearchViewDto> data = service.searchListforUpdDsg(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the post details by emp no.
	 *
	 * @param id the id
	 * @return the post details by emp no
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_EMP_DETAIL_GETBYEMPNO)
	public ResponseEntity<ApiResponse> getPostDetailsByEmpNo(@RequestBody EDPIdDto id) throws CustomException {
		try {
			if( null != id.getUserCode()) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,service.getPostDetailsByEmpNo(id));				
			} else {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
		} catch (CustomException ce) {
			CustomException ce1 = ce;
			logger.error(ce1.getMessage(),ce1);
			throw ce1;
		}
		catch (DataIntegrityViolationException ex) {
			logger.error(ex.getMessage(),ex);
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Change post.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_CHANGE_POST)
	public ResponseEntity<ApiResponse> changePost(@RequestBody EDPIdDto id) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_TRANSFER_CHANGE_POST, service.changePost(id));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Gets the vacant post.
	 *
	 * @return the vacant post
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_VACANT_POST)
	public ResponseEntity<ApiResponse> getVacantPost(@RequestBody EDPIdDto idDto ) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getVacantPost(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}
	
	/**
	 * Gets the approve post user mapping by header id.
	 *
	 * @param dto the dto
	 * @return the approve post user mapping by header id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_GET_APPROVE_BYID)
	public ResponseEntity<ApiResponse> getApprovePostUserMappingByHeaderId(@RequestBody EDPIdDto dto) throws CustomException {
		if (null != dto.getEdpUsrTrnHeaderId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getApprovePostUserMappingByHeaderId(dto.getEdpUsrTrnHeaderId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EDP_SUBMIT_POPUP)
	public ResponseEntity<ApiResponse> getSubmitAPIPopupDetails(@RequestBody EDPIdDto dto) throws CustomException{
		if (null != dto.getEdpUsrTrnHeaderId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getSubmitPopupDetails(dto.getEdpUsrTrnHeaderId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}		
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EDP_CHECK_PT_WF)
	public ResponseEntity<ApiResponse> getIsWorkflowRequired(@RequestBody EDPIdDto dto) throws CustomException{
		if(null != dto.getOfficeId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.isWorkflowRequired(dto.getOfficeId(), dto.getUserId()));			
		}
		 else {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
	}
	
	/**
	 * Gets the listing filter data api.
	 *
	 * @return the listing filter data api
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_PT_SEARCHSTATUS)
	public ResponseEntity<ApiResponse> getListingFilterDataApi() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getListingFilterData());
	}
}
