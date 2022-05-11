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
import gov.ifms.edp.converter.EDPTrnUserMpAttItrConverter;
import gov.ifms.edp.dto.EDPTrnUserMpAttItrDto;
import gov.ifms.edp.entity.EDPTrnUserMpAttItrEntity;
import gov.ifms.edp.service.EDPUserRoleMappingAttachmentItrService;

/**
 * The Class EDPUserRoleMappingAttachmentItrController.
 * 
 * @version 1.0.
 * @created 2019/01/02 17:42:52.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_USERROLEMAPPING_ATTACHMENTITR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPUserRoleMappingAttachmentItrController {

	/** The service. */
	@Autowired
	private EDPUserRoleMappingAttachmentItrService service;

	/** The converter. */
	@Autowired
	private EDPTrnUserMpAttItrConverter converter;

	/**
	 * Fetch PostAttachmentItrs by given PostAttachmentItrs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getUserRoleMappingAttachmentItr(@RequestBody IdDto id) {
		EDPTrnUserMpAttItrEntity entity = service.getUserRoleMappingAttachmentItr(id.getId());
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
	public ResponseEntity<ApiResponse> createUserRoleMappingAttachmentItr(@RequestBody EDPTrnUserMpAttItrDto dto) {
		EDPTrnUserMpAttItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateUserRoleMappingAttachmentItr(entity)));
	}

	/**
	 * Update the PostAttachmentItrs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateUserRoleMappingAttachmentItr(@RequestBody EDPTrnUserMpAttItrDto dto) {
		EDPTrnUserMpAttItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateUserRoleMappingAttachmentItr(entity)));
	}

	/**
	 * Deletes the PostAttachmentItrs for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteUserRoleMappingAttachmentItr(@RequestBody StatusDto statusDto) {
		service.deleteUserRoleMappingAttachmentItr(statusDto.getId(), statusDto.getActiveStatus());
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
	public ResponseEntity<ApiResponse> getUserRoleMappingAttachmentItrs(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPTrnUserMpAttItrDto> data = service.getUserRoleMappingAttachmentItrs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, data);
	}

}
