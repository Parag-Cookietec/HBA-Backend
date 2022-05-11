package gov.ifms.edp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import gov.ifms.edp.converter.EDPAddDesigAttachementConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnAttachmentConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPAddDesAttachmentDto;
import gov.ifms.edp.dto.EDPDesignationAttachmentForm;
import gov.ifms.edp.dto.EDPTrnUpdDsgnAttachmentDto;
import gov.ifms.edp.dto.EDPTrnUpdDsgnAttachmentFormDto;
import gov.ifms.edp.entity.EDPAddDesAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentEntity;
import gov.ifms.edp.service.EDPMsDesignationAttachmentService;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsDesignationAttachmentController.
 */
@Validated
@RestController
@RequestMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EDPMsDesignationAttachmentController {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/** The service. */
	@Autowired
	private EDPMsDesignationAttachmentService edpMsDesignationAttachmentService;

	/** The service. */
	@Autowired
	private EDPTrnUpdDsgnAttachmentConverter edpTrnUpdDsgnAttachmentConverter;

	/** The edp add desig attachement converter. */
	@Autowired
	private EDPAddDesigAttachementConverter edpAddDesigAttachementConverter;

	/**
	 * Gets the by upd dsgn attachment id.
	 *
	 * @param id the id
	 * @return the by upd dsgn attachment id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_UPDATEDSG_ATTACHMENTBYID)
	public ResponseEntity<ApiResponse> getByUpdDsgnAttachmentId(@RequestBody IdDto id) throws CustomException {
		EDPTrnUpdDsgnAttachmentEntity edpTrnUpdDsgnAttachmentEntity = edpMsDesignationAttachmentService
				.findUpdateDsgAttachmentById(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				edpTrnUpdDsgnAttachmentConverter.toDTO(edpTrnUpdDsgnAttachmentEntity));
	}

	/**
	 * Gets the by upd dsgn id.
	 *
	 * @param updDsgnId the upd dsgn id
	 * @return the by upd dsgn id
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_UPDATEDSG_GET_BY_UPD_DSGN_ID)
	public ResponseEntity<ApiResponse> getByUpdDsgnId(@Valid @RequestBody IdDto updDsgnId) {
		List<EDPTrnUpdDsgnAttachmentEntity> ofcAttachmentEntities = edpMsDesignationAttachmentService
				.findByTedpUpdDsgnIdAndActiveStatus(updDsgnId.getId());
		return CollectionUtils.isEmpty(ofcAttachmentEntities)?ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH)
				:ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				edpTrnUpdDsgnAttachmentConverter.toDTO(ofcAttachmentEntities));
	}

	/**
	 * Store file upd dsgn attachment.
	 *
	 * @param attachments the attachments
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_UPDATEDSG_SAVE)
	public ResponseEntity<ApiResponse> storeFileUpdDsgnAttachment(
			@Valid @ModelAttribute EDPTrnUpdDsgnAttachmentFormDto attachments) throws CustomException {
		String errorMsg = EDPUtility.isValidFile(attachments.getAttch());
		if (!StringUtils.isEmpty(errorMsg)) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg, null);
		}
		try {
			List<EDPTrnUpdDsgnAttachmentDto> dto = edpTrnUpdDsgnAttachmentConverter
					.toDTO(edpMsDesignationAttachmentService
							.createUpdDsgnAttachment(edpTrnUpdDsgnAttachmentConverter.toEntity(attachments.getAttch())));
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, dto);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Delete upd dsgn attachment by id.
	 *
	 * @param attachmentId the attachment id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_UPDATEDSG_DELETE)
	public ResponseEntity<ApiResponse> deleteUpdDsgnAttachmentById(@Valid @RequestBody IdDto attachmentId)
			throws CustomException {
		edpMsDesignationAttachmentService.deleteUpdDsgnAttachment(attachmentId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, Boolean.TRUE);
	}

	/**
	 * Download upd dsgn attachment by id.
	 *
	 * @param fileId the file id
	 * @param request the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_UPDATEDSG_DOWNLOAD)
	public ResponseEntity<Resource> downloadUpdDsgnAttachmentById(@Valid @RequestBody IdDto fileId,
			final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (null != fileId && null != fileId.getId()) {
				ClueDto resource = edpMsDesignationAttachmentService.downloadUpdDsgnFiles(fileId.getId());
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
	 * Store file.
	 *
	 * @param attachments the attachments
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_ADD_SAVE)
	public ResponseEntity<ApiResponse> storeFileAddDesignationAttachment(
			@Valid @ModelAttribute EDPDesignationAttachmentForm attachments) throws CustomException {
		String errorMsg = EDPUtility.isValidFile(attachments.getAttch());
		if (!StringUtils.isEmpty(errorMsg)) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg, null);
		}
		try {
			List<EDPAddDesAttachmentDto> dto = edpAddDesigAttachementConverter.toDTO(edpMsDesignationAttachmentService
					.createAddDesignationAttachment(edpAddDesigAttachementConverter.toEntity(attachments.getAttch())));
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
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_ADD_DELETE)
	public ResponseEntity<ApiResponse> deleteAddDesignationAttachmentById(@Valid @RequestBody IdDto attachmentId)
			throws CustomException {
		edpMsDesignationAttachmentService.deleteAddDesignationAttachment(attachmentId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, Boolean.TRUE);
	}

	/**
	 * Download add attachment by id.
	 *
	 * @param fileId the file id
	 * @param request the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_ADD_DOWNLOAD)
	public ResponseEntity<Resource> downloadAddAttachmentById(@Valid @RequestBody IdDto fileId,
			final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (null != fileId && null != fileId.getId()) {
				ClueDto resource = edpMsDesignationAttachmentService.downloadAddDesignationFiles(fileId.getId());
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
	 * Gets the by attachments add designation id.
	 *
	 * @param desigId the desig id
	 * @return the by attachments add designation id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ATTACHMENT_ADD_GETBYID)
	public ResponseEntity<ApiResponse> getByAttachmentsAddDesignationId(@Valid @RequestBody IdDto desigId)
			throws CustomException {
		List<EDPAddDesAttachmentEntity> attachmentEntities = edpMsDesignationAttachmentService
				.getAttachmentListByDesignationId(desigId.getId());
		return CollectionUtils.isEmpty(attachmentEntities)?ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH)
				:ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				edpAddDesigAttachementConverter.toDTO(attachmentEntities));
		
	}

}
