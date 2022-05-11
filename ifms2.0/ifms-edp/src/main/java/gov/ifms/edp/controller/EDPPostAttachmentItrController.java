package gov.ifms.edp.controller;

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
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPPostAttachmentItrConverter;
import gov.ifms.edp.dto.EDPPostAttachmentItrDto;
import gov.ifms.edp.entity.EDPPostAttachmentItrEntity;
import gov.ifms.edp.service.EDPPostAttachmentItrService;

/**
 * The Class EDPPostAttachmentItrController.
 * 
 * @version 1.0.
 * @created 2019/12/20 17:42:52.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_POSTATTACHMENTITR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPPostAttachmentItrController {

	/** The service. */
	@Autowired
	private EDPPostAttachmentItrService service;

	/** The converter. */
	@Autowired
	private EDPPostAttachmentItrConverter converter;

	/**
	 * Fetch PostAttachmentItrs by given PostAttachmentItrs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getPostAttachmentItr(@RequestBody IdDto id) {
		EDPPostAttachmentItrEntity entity = service.getPostAttachmentItr(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new PostAttachmentItrs.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createPostAttachmentItr(@RequestBody EDPPostAttachmentItrDto dto) {
		EDPPostAttachmentItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdatePostAttachmentItr(entity)));
	}

	/**
	 * Update the PostAttachmentItrs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updatePostAttachmentItr(@RequestBody EDPPostAttachmentItrDto dto) {
		EDPPostAttachmentItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdatePostAttachmentItr(entity)));
	}

	/**
	 * Deletes the PostAttachmentItrs for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deletePostAttachmentItr(@RequestBody StatusDto statusDto) {
		service.deletePostAttachmentItr(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the PostAttachmentItrs items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPPostAttachmentItrDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getPostAttachmentItrs(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPPostAttachmentItrDto> data = service.getPostAttachmentItrs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, data);
	}

}
