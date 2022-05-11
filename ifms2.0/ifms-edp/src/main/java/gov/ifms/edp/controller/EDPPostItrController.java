package gov.ifms.edp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPPostItrConverter;
import gov.ifms.edp.dto.EDPPostItrDto;
import gov.ifms.edp.entity.EDPPostItrEntity;
import gov.ifms.edp.service.EDPPostItrService;

/**
 * The Class EDPPostItrController.
 * 
 * @version 1.0.
 * @created 2019/12/09 12:27:17.
 *
 */
@Validated
@RestController
@RequestMapping(URLConstant.URL_EDP_POSTITR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPPostItrController {

	/** The service. */
	@Autowired
	private EDPPostItrService service;

	/** The converter. */
	@Autowired
	private EDPPostItrConverter converter;

	/**
	 * Fetch PostItrs by given PostItrs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getPostItr(@RequestBody IdDto id) {
		EDPPostItrEntity entity = service.getPostItr(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new PostItrs.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createPostItr(@Valid @RequestBody EDPPostItrDto dto) {
		EDPPostItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdatePostItr(entity)));
	}

	/**
	 * Update the PostItrs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updatePostItr(@RequestBody EDPPostItrDto dto) {
		EDPPostItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdatePostItr(entity)));
	}

	/**
	 * Deletes the PostItrs for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deletePostItr(@RequestBody StatusDto statusDto) {
		service.deletePostItr(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the PostItrs items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPPostItrDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getPostItrs(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPPostItrDto> data = service.getPostItrs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

}