package gov.ifms.edp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPPostCountDTO;
import gov.ifms.edp.dto.EDPPostSearchView;
import gov.ifms.edp.service.EDPMsPostService;

/**
 * The Class EDPMsPostController.
 * 
 * @version 1.0.
 * @created 2019/08/29 17:22:45.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_POST)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsPostController {

	/** The service. */
	@Autowired
	private EDPMsPostService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsPostConverter converter;

	/**
	 * Fetch MsPosts by given MsPosts id.
	 *
	 * @param idDto the id dto
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsPost(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getMsPost(idDto));

	}

	/**
	 * creates a new MsPosts.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsPost(@Valid @RequestBody EDPMsPostDto dto) throws CustomException {
		try {
			if (dto.getFormAction() == Status.SUBMITTED) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_CREATE, service.saveMsPost(dto));
			} else {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_SAVE, service.saveMsPost(dto));
			}

		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		}
	}

	/**
	 * Update the MsPosts.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsPost(@Valid @RequestBody EDPMsPostDto dto) throws CustomException {
		try {
			if (dto.getFormAction() == Status.SUBMITTED) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_CREATE, service.updateMsPost(dto));
			} else {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_SAVE, service.updateMsPost(dto));
			}
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Fetch all the MsPosts items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsPostDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsPosts(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPMsPostDto> data = service.edpMsPostAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, data);
	}

	/**
	 * Gets the all ms posts.
	 *
	 * @return the all ms posts
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_POST)
	public ResponseEntity<ApiResponse> getAllMsPosts() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				converter.toDTO(service.getMsPosts()));
	}

	/**
	 * Gets the all ms posts.
	 *
	 * @return the all ms posts
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICEDETAILS)
	public ResponseEntity<ApiResponse> getpostAndofficedetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getpostAndofficedetails());
	}

	/**
	 * Delete ms post.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteMsPost(@Valid @RequestBody IdDto idDto) throws CustomException {
		service.deleteMsPost(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_POST_DELETE, Boolean.TRUE);
	}

	/**
	 * List edp offices.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_FIELDS)
	public ResponseEntity<ApiResponse> searchListforPosts(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPPostSearchView> data = service.searchListforPosts(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the post count.
	 *
	 * @param countDto the count dto
	 * @return the post count
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_COUNT)
	public ResponseEntity<ApiResponse> getPostCount(@RequestBody EDPPostCountDTO countDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getPostCount(countDto));
	}

	/**
	 * Avilable vacant post.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_AVILABLEVACANTPOST)
	public ResponseEntity<ApiResponse> avilableVacantPost(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.avilableVacantPost(idDto));
	}

	/**
	 * Post history report.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_POST_HISTORY_REPORT)
	public ResponseEntity<ApiResponse> postHistoryReport(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.searchForPostHistoryReport(pageDetail));
	}

	/**
	 * Gets the checks if is workflow required.
	 *
	 * @return the checks if is workflow required
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_CHECK_PC_WF)
	public ResponseEntity<ApiResponse> getIsWorkflowRequired() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.isWorkflowRequired());
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
