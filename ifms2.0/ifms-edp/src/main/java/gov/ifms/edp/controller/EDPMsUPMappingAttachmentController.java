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
import gov.ifms.edp.converter.EDPMsAttachmentConverter;
import gov.ifms.edp.converter.EDPUsrPoTrnsAttConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsAttDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsAttFormDto;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttEntity;
import gov.ifms.edp.service.EDPMsUPMappingAttachmentService;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;


/**
 * The Class EDPMsUPMappingAttachmentController.
 */
@Validated
@RestController
@RequestMapping(URLConstant.URL_EDP_POMAPPING_ATT_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EDPMsUPMappingAttachmentController {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The edp ms UP mapping attachment service. */
	@Autowired
	private EDPMsUPMappingAttachmentService edpMsUPMappingAttachmentService;

	/** The edp usr po trns att converter. */
	@Autowired
	private EDPUsrPoTrnsAttConverter edpUsrPoTrnsAttConverter;
	
	/** The edp ms attachment converter. */
	@Autowired
	private EDPMsAttachmentConverter edpMsAttachmentConverter; 

	/**
	 * Find attachment by attachment type.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_GETBYATTTYPE_TEDP_UPT_ID)
	public ResponseEntity<ApiResponse> findAttachmentByAttachmentType(@RequestBody ClueDto id) throws CustomException {
		List<EDPUsrPoTrnsAttEntity> edpUsrPoTrnsAttEntityList = edpMsUPMappingAttachmentService
				.findAttachmentByAttachmentType(id.getAttachmentType(),id.getTedpUptId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				edpUsrPoTrnsAttConverter.toDTO(edpUsrPoTrnsAttEntityList));
	}

	/**
	 * Store file upd dsgn attachment.
	 *
	 * @param attachments the attachments
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_SAVE)
	public ResponseEntity<ApiResponse> storeFileUpdDsgnAttachment(
			@Valid @ModelAttribute EDPUsrPoTrnsAttFormDto attachments) throws CustomException {

		String errorMsg = EDPUtility.isValidFile(attachments.getAttch());
		if (!StringUtils.isEmpty(errorMsg)) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg, null);
		}
		try {
			List<EDPUsrPoTrnsAttDto> dto = edpUsrPoTrnsAttConverter.toDTO(edpMsUPMappingAttachmentService
					.createUPMappingAttachment(edpUsrPoTrnsAttConverter.toEntity(attachments.getAttch())));
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, dto);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Delete UP mapping attachment.
	 *
	 * @param attachmentId the attachment id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_DELETE)
	public ResponseEntity<ApiResponse> deleteUPMappingAttachment(@Valid @RequestBody IdDto attachmentId)
			throws CustomException {
		edpMsUPMappingAttachmentService.deleteUPMappingAttachment(attachmentId.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, Boolean.TRUE);
	}

	/**
	 * Downloadcreate UP mapping attachment files.
	 *
	 * @param fileId the file id
	 * @param request the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_DOWNLOAD)
	public ResponseEntity<Resource> downloadcreateUPMappingAttachmentFiles(@Valid @RequestBody IdDto fileId,
			final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (null != fileId && null != fileId.getId()) {
				ClueDto resource = edpMsUPMappingAttachmentService.downloadcreateUPMappingAttachmentFiles(fileId.getId());
				String contentType = null;
				contentType = request.getServletContext().getMimeType(resource.getName());
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
	 * Find attachment by user post transfer id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_GETBYID)
	public ResponseEntity<ApiResponse> findAttachmentByUserPostTransferId(@Valid @RequestBody IdDto id){

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,edpUsrPoTrnsAttConverter.toDTO(
				edpMsUPMappingAttachmentService.findAttachmentByUserPostTransferId(id.getId())));
	}
	
	/**
	 * Gets the attachment types.
	 *
	 * @return the attachment types
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_POMAPPING_GETATT)
	public ResponseEntity<ApiResponse> getAttachmentTypes() {
		List<EDPMsAttachmentEntity> edpMsAttachmentEntityList = edpMsUPMappingAttachmentService
				.getAllAttechmentsForPostTransfer();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				edpMsAttachmentConverter.toDTO(edpMsAttachmentEntityList));
	}

}
