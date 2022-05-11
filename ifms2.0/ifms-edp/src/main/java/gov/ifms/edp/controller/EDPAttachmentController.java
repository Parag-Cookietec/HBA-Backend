package gov.ifms.edp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPOfficeAttachementConverter;
import gov.ifms.edp.converter.EDPPostAttachementConverter;
import gov.ifms.edp.converter.EDPTrnUserMpAttConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsAttachmentDto;
import gov.ifms.edp.dto.EDPOfficeAttachmentDto;
import gov.ifms.edp.dto.EDPOfficeAttachmentForm;
import gov.ifms.edp.dto.EDPPostAttachmentDto;
import gov.ifms.edp.dto.EDPPostAttachmentForm;
import gov.ifms.edp.dto.EDPTrnUserMpAttDto;
import gov.ifms.edp.dto.EDPUserRoleMpAttachmentForm;
import gov.ifms.edp.dto.EdpUserRightsRequestDto;
import gov.ifms.edp.entity.EDPOfficeAttachmentEntity;
import gov.ifms.edp.entity.EDPPostAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.service.EDPAttachmentService;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPAttachmentController.
 */
@Validated
@RestController
@RequestMapping(URLConstant.URL_EDP_ATTACHMENT_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPAttachmentController {

	/** The service. */
	@Autowired
	private EDPAttachmentService edpAttachmentService;

	/** The service. */
	@Autowired
	private EDPPostAttachementConverter postAttachmentConverter;
	/** The service. */
	@Autowired
	private EDPOfficeAttachementConverter edpAttachmentConverter;

	/** The edp trn user mp att converter. */
	@Autowired
	private EDPTrnUserMpAttConverter edpTrnUserMpAttConverter;
	

	/** The edp office attachement converter. */
	@Autowired
	private EDPOfficeAttachementConverter edpOfficeAttachementConverter;

	/**
	 * Gets the by EDP office attachment id.
	 *
	 * @param id the id
	 * @return the by EDP office attachment id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POSTATTACHMENT_GETBYOFCATTACHMENTID)
	public ResponseEntity<ApiResponse> getByEDPOfficeAttachmentId(@RequestBody IdDto id) throws CustomException {
		EDPPostAttachmentEntity edpAttachmentEntity = edpAttachmentService.findPostAttachmentById(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				this.postAttachmentConverter.toDTO(edpAttachmentEntity));
	}

	/**
	 * Gets the by office ID.
	 *
	 * @param officeId the office id
	 * @return the by office ID
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POSTATTACHMENT_GETBYOFFICEID)
	public ResponseEntity<ApiResponse> getByPostID(@Valid @RequestBody IdDto officeId) throws CustomException {
		List<EDPPostAttachmentEntity> ofcAttachmentEntities = edpAttachmentService
				.findByPostIdAndActiveStatus(officeId.getId());
		return CollectionUtils.isEmpty(ofcAttachmentEntities)
				? ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH)
				: ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
						this.postAttachmentConverter.toDTO(ofcAttachmentEntities));
	}

	/**
	 * Store file.
	 *
	 * @param attachments the attachments
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POSTATTACHMENT_SAVEFILE)
	public ResponseEntity<ApiResponse> storeFilePostAttachment(@Valid @ModelAttribute EDPPostAttachmentForm attachments)
			throws CustomException {
		String errorMsg = EDPUtility.isValidFile(attachments.getAttch());
		if (!StringUtils.isEmpty(errorMsg)) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg, null);
		}
		try {
			List<EDPPostAttachmentDto> dto = postAttachmentConverter.toDTO(edpAttachmentService
					.createPostAttachment(postAttachmentConverter.toEntity(attachments.getAttch())));
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, dto);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Delete sc attachment by id.
	 *
	 * @param attachmentId the attachment id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POSTATTACHMENT_UPDATEACTIVESTATUS)
	public ResponseEntity<ApiResponse> deletePostAttachmentById(@Valid @RequestBody IdDto attachmentId)
			throws CustomException {
		edpAttachmentService.deletePostAttachment(attachmentId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, Boolean.TRUE);
	}

	/**
	 * Download sc sh attachment by id.
	 *
	 * @param fileId  the file id
	 * @param request the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException     Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POSTATTACHMENT_DOWNLOADATTACHMENT)
	public ResponseEntity<Resource> downloadPostAttachmentById(@Valid @RequestBody IdDto fileId,
			final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (null != fileId && null != fileId.getId()) {
				ClueDto resource = edpAttachmentService.downloadPostFiles(fileId.getId());
				String contentType = request.getServletContext().getMimeType(resource.getName());
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, EDPConstant.ATTACHMENT_FILENAME_USER_PHOTO 
								+ resource.getName() + EDPConstant.STRING_DOUBLE_QUOTES)
						.body(resource.getDocument());
			} else {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Gets the attachment by post id and att type.
	 *
	 * @param json the json
	 * @return the attachment by postid and att type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POSTATTACHMENT_OFCIDANDATTTYPE)
	public ResponseEntity<ApiResponse> getAttachmentByPostIdAndAttType(@Valid @RequestBody Map<String, Long> json)
			throws CustomException {

		List<EDPPostAttachmentDto> attachmentEntities = edpAttachmentService
				.getAttachmentByPostIdAndAttType(json.get("postId"), json.get("attachmentType"));
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE, attachmentEntities);

	}

	/**
	 * Gets the by EDP office attachment id.
	 *
	 * @param id the id
	 * @return the by EDP office attachment id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFCATTACHMENT_GETBYOFCATTACHMENTID)
	public ResponseEntity<ApiResponse> getByEDPPostAttachmentId(@RequestBody IdDto id) throws CustomException {
		EDPOfficeAttachmentEntity edpAttachmentEntity = edpAttachmentService.findAttachmentById(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				this.edpAttachmentConverter.toDTO(edpAttachmentEntity));
	}

	/**
	 * Gets the by office ID.
	 *
	 * @param officeId the office id
	 * @return the by office ID
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFCATTACHMENT_GETBYOFFICEID)
	public ResponseEntity<ApiResponse> getByOfficeID(@Valid @RequestBody IdDto officeId) throws CustomException {
		List<EDPOfficeAttachmentEntity> ofcAttachmentEntities = edpAttachmentService
				.findByOfficeIdAndActiveStatus(officeId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				this.edpAttachmentConverter.toDTO(ofcAttachmentEntities));
	}

	/**
	 * Store file.
	 *
	 * @param attachments the attachments
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFCATTACHMENT_SAVEFILE)
	public ResponseEntity<ApiResponse> storeFileOfficeAttachment(
			@Valid @ModelAttribute gov.ifms.edp.dto.EDPOfficeAttachmentForm attachments) throws CustomException {
		String errorMsg = EDPUtility.isValidFile(attachments.getAttch());
		if (!StringUtils.isEmpty(errorMsg)) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg, null);
		}
		/**
		 * List<EDPOfficeAttachmentEntity> entitylist =
		 * edpAttachmentConverter.toEntity(attachments.getAttch()); Set<String>
		 * filterlist = entitylist.stream().map(p ->
		 * p.getFileName()).collect(Collectors.toSet()); if (entitylist.size() !=
		 * filterlist.size()) { return
		 * ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY,
		 * ErrorResponse.DUPLICATE_ROWS_FOUND.getMessage(), null); }
		 */
		try {
			List<EDPOfficeAttachmentDto> dto = edpAttachmentConverter.toDTO(edpAttachmentService
					.createofficeAttachment(edpAttachmentConverter.toEntity(attachments.getAttch())));
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, dto);

		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Delete sc attachment by id.
	 *
	 * @param attachmentId the attachment id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFCATTACHMENT_UPDATEACTIVESTATUS)
	public ResponseEntity<ApiResponse> deleteScAttachmentById(@Valid @RequestBody IdDto attachmentId)
			throws CustomException {
		edpAttachmentService.deleteOfficeAttachment(attachmentId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, Boolean.TRUE);
	}

	/**
	 * Download sc sh attachment by id.
	 *
	 * @param fileId  the file id
	 * @param request the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException     Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFCATTACHMENT_DOWNLOADATTACHMENT)
	public ResponseEntity<Resource> downloadScShAttachmentById(@Valid @RequestBody IdDto fileId,
			final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (null != fileId && null != fileId.getId()) {
				ClueDto resource = edpAttachmentService.downloadFiles(fileId.getId());
				String contentType = request.getServletContext().getMimeType(resource.getName());
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, EDPConstant.ATTACHMENT_FILENAME_USER_PHOTO 
								+ resource.getName() + EDPConstant.STRING_DOUBLE_QUOTES)
						.body(resource.getDocument());
			} else {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Gets the attachment by ofc id and att type.
	 *
	 * @param json the json
	 * @return the attachment by ofc id and att type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFCATTACHMENT_OFCIDANDATTTYPE)
	public ResponseEntity<ApiResponse> getAttachmentByOfcIdAndAttType(@Valid @RequestBody Map<String, Long> json)
			throws CustomException {
		if (null != json.get(EDPConstant.ARG_OFFICE_ID) && null != json.get(EDPConstant.ARG_ATTTYPE)) {
			List<EDPOfficeAttachmentDto> attachmentEntities = edpOfficeAttachementConverter.toListView(edpAttachmentService.getAttachmentByOfcIdAndAttType(
					json.get(EDPConstant.ARG_OFFICE_ID),EDPConstant.EDP_CNO_ATTCH_TBL_NAME));
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, attachmentEntities);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}

	}

	/**
	 * Gets the attachment by att type.
	 *
	 * @param clueDto the clue dto
	 * @return the attachment by att type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_OFCATTACHMENT_TYPE)
	public ResponseEntity<ApiResponse> getAttachmentByAttType(@Valid @RequestBody List<ClueDto> clueDto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				edpAttachmentService.getAttachmentByAttType(clueDto));

	}

	/**
	 * Gets the by office ID.
	 *
	 * @param userRoleMpId the user role mp id
	 * @return the by office ID
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_USER_ROLE_MAPPING_ATT_GETBYOFFICEID)
	public ResponseEntity<ApiResponse> getByUserRoleMapId(@Valid @RequestBody IdDto userRoleMpId)
			throws CustomException {
		List<EDPTrnUserMpAttEntity> ofcAttachmentEntities = edpAttachmentService
				.findByUserRgMapIdAndActiveStatus(userRoleMpId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				this.edpTrnUserMpAttConverter.toDTO(ofcAttachmentEntities));
	}

	/**
	 * Store file.
	 *
	 * @param attachments the attachments
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_USER_ROLE_MAPPING_ATT_SAVEFILE)
	public ResponseEntity<ApiResponse> storeFileUserRoleMapAttachment(
			@Valid @ModelAttribute EDPUserRoleMpAttachmentForm attachments) throws CustomException {
		String errorMsg = EDPUtility.isValidFile(attachments.getAttch());
		if (!StringUtils.isEmpty(errorMsg)) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg, null);
		}
		try {
			List<EDPTrnUserMpAttDto> dto = edpTrnUserMpAttConverter.toDTO(edpAttachmentService
					.createUserRoleMapAttachment(edpTrnUserMpAttConverter.toEntity(attachments.getAttch())));
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, dto);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Delete sc attachment by id.
	 *
	 * @param attachmentId the attachment id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_USER_ROLE_MAPPING_ATT_UPDATEACTIVESTATUS)
	public ResponseEntity<ApiResponse> deleteUserRoleMapAttachmentById(@Valid @RequestBody IdDto attachmentId)
			throws CustomException {
		edpAttachmentService.deleteUserRoleMapAttachment(attachmentId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, Boolean.TRUE);
	}

	/**
	 * Download sc sh attachment by id.
	 *
	 * @param fileId  the file id
	 * @param request the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException     Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_USER_ROLE_MAPPING_ATT_DOWNLOADATTACHMENT)
	public ResponseEntity<Resource> downloadUserRoleMapAttachmentById(@Valid @RequestBody IdDto fileId,
			final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (null != fileId && null != fileId.getId()) {
				ClueDto resource = edpAttachmentService.downloadUserRoleMapFiles(fileId.getId());
				String contentType = request.getServletContext().getMimeType(resource.getName());
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, EDPConstant.ATTACHMENT_FILENAME_USER_PHOTO 
								+ resource.getName() + EDPConstant.STRING_DOUBLE_QUOTES)
						.body(resource.getDocument());
			} else {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
		}catch (Exception e) {
			 throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Gets the attachment by post id and att type.
	 *
	 * @param json the json
	 * @return the attachment by postid and att type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_USER_ROLE_MAPPING_ATT_OFCIDANDATTTYPE)
	public ResponseEntity<ApiResponse> getAttachmentByUserRoleMapIdAndAttType(
			@Valid @RequestBody Map<String, Long> json) throws CustomException {

		List<EDPTrnUserMpAttDto> attachmentEntities = edpAttachmentService
				.getAttachmentByUserRoleMapIdAndAttType(json.get("rolePrmID"), json.get("attachmentType"));
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, attachmentEntities);

	}
	
	/**
	 * Gets the attachment by att type.
	 *
	 * @param clueDto the clue dto
	 * @return the attachment by att type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_USER_ROLE_MAPPING_ATT_BY_TYPE)
	public ResponseEntity<ApiResponse> getAttachmentUserRoleMapByAttType(@Valid @RequestBody EdpUserRightsRequestDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				edpAttachmentService.getAttachmentByAttTypeRightsMapping(dto.getAttTypes()));

	}
	
	/**
	 * Gets the attachment by att type.
	 *
	 * @param clueDto the clue dto
	 * @return the attachment by att type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_ANDATTACHMENT_TYPE)
	public ResponseEntity<ApiResponse> getAttachmentByAttTypeForDesignation(@Valid @RequestBody List<ClueDto> clueDto)
			throws CustomException {
		List<EDPMsAttachmentDto> msAttDto=edpAttachmentService.getAttachmentByAttType(clueDto);
		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(EDPConstant.ADD_NEW_DESIGNATION_MENU_ID);
		if(!OAuthUtility.isCurrentUserIsDAT() || roleIds.contains(123L))
			msAttDto.get(0).setMandatoryFlag(Boolean.TRUE);
		else
			msAttDto.get(0).setMandatoryFlag(Boolean.FALSE);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				msAttDto);

	}

	@Trace
	@PostMapping(URLConstant.URL_EDP_OFFICE_ATTACH_UPLOAD)
	public ResponseEntity<ApiResponse> uploadUpdateOfficeAttachment(
			@Valid @ModelAttribute EDPOfficeAttachmentForm attachments) throws CustomException {
		String errorMsg = EDPUtility.isValidFile(attachments.getAttch());
		if (errorMsg != null && !errorMsg.isEmpty()) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg, null);
		}

		try {
			List<EDPOfficeAttachmentDto> dto = edpAttachmentConverter
					.toDTO(edpAttachmentService.uploadOfficeAttach(attachments.getAttch()));

			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, dto);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_EDP_OFFICE_ATTACH)
	public ResponseEntity<ApiResponse> getOfficeAttachment(@Valid @RequestBody Map<String, Long> request) throws CustomException {
		Long officeId = request.get(EDPConstant.ARG_OFFICE_ID);
		Long attchType = request.get(EDPConstant.ARG_ATTTYPE);

		if (officeId != null && attchType != null) {
			List<EDPOfficeAttachmentDto> attachmentEntities = edpOfficeAttachementConverter.convertToView(edpAttachmentService.getOfficeAttachment(officeId));

			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, attachmentEntities);
		}

		return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, MsgConstant.INVALID_JSON_FORMAT);
	}
}