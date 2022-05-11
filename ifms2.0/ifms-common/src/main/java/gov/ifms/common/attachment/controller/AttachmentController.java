package gov.ifms.common.attachment.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filenet.api.core.Document;
import com.filenet.api.util.Id;

import gov.ifms.common.attachment.converter.AttachmentMasterConverter;
import gov.ifms.common.attachment.dto.AttachmentDownloadDto;
import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.attachment.dto.MasterAttachmentDto;
import gov.ifms.common.attachment.dto.MultipleAtcmDownloadDto;
import gov.ifms.common.attachment.entity.AttachmentMasterEntity;
import gov.ifms.common.attachment.service.AttachmentMasterService;
import gov.ifms.common.attachment.service.AttachmentService;
import gov.ifms.common.attachment.util.WorkflowUtility;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.ViewFileDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.FilenetUtility;
import gov.ifms.common.util.ResponseUtil;

@RestController
@RequestMapping(URLConstant.URL_ATTACHMENT_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttachmentController {

	Logger logger = LoggerFactory.getLogger(AttachmentController.class);

	/** The service. */
	@Autowired
	private AttachmentService attachmentService;

	/** The service. */
	@Autowired
	private AttachmentMasterService attachmentMasterService;

	/** The converter. */
	@Autowired
	private AttachmentMasterConverter converter;

	/**
	 * Fetch AttachmentMasters by given AttachmentMasters id
	 *
	 * @param id
	 * @return APIResponse
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getAttachmentMaster(@RequestBody final IdDto id) {
		List<AttachmentMasterEntity> entity = attachmentMasterService.getAttachmentMasterByMenuId(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new AttachmentMasters
	 *
	 * @param dto
	 * @return newly created entity in APIResponse
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_ALL)
	public ResponseEntity<ApiResponse> createAttachmentMaster(@RequestBody final AttachmentMasterDto dto) {
		AttachmentMasterEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_CREATE,
				converter.toDTO(attachmentMasterService.saveOrUpdateAttachmentMaster(entity)));
	}

	/**
	 * Download attachment Filenet.
	 *
	 * @param dto
	 * @param request               the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException     Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_FILENET_DOWNLOADATTACHMENT)
	public ResponseEntity<Resource> downloadAttachmentFilenet(@Valid @RequestBody final AttachmentDownloadDto dto,
															  final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (!StringUtils.isBlank(dto.getDocumentDataKey()) && !StringUtils.isBlank(dto.getFileName())) {
				Id id = new Id(dto.getDocumentDataKey());

				final Document document = FilenetUtility.retrieveDocument(id);
				final InputStreamResource inputStreamResource = new InputStreamResource(
						document.accessContentStream(0));
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(Constant.FILE_CONTENT_TYPE))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dto.getFileName() + "\"")
						.body(inputStreamResource);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
		return ResponseEntity.badRequest().body(null);
	}

	/**
	 * Upload attachment Filenet.
	 *
	 * @param uploadDto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POSTATTACHMENT_SAVEFILE_MULTIPLE)
	public ResponseEntity<ApiResponse> storeFileByFilenet(@ModelAttribute final AttachmentMasterDto uploadDto)
			throws CustomException {
		List<FileUploadResponseDto> fileUploadResponseDto = null;
		if (WorkflowUtility.validateFileExtensionPost(uploadDto)) {
			try {
				fileUploadResponseDto = attachmentService.createPostAttachment(uploadDto);
			} catch (DataIntegrityViolationException ex) {
				logger.error(ex.getMessage(), ex);
				return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
			}
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, fileUploadResponseDto);
		} else {
			return ResponseUtil.getResponse(HttpStatus.BAD_REQUEST, MsgConstant.ATTACHMENT_MSG_UPLOAD_ERROR);
		}
	}

	/**
	 * Upload attachment Disk.
	 *
	 * @param uploadDto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POSTATTACHMENT_FILEUPLOAD)
	public ResponseEntity<ApiResponse> storeFile(@ModelAttribute final AttachmentMasterDto uploadDto)
			throws CustomException {
		List<FileUploadResponseDto> fileUploadResponseDtos = null;
		if (WorkflowUtility.validateFileExtensionPost(uploadDto)) {
			try {
				fileUploadResponseDtos = attachmentService.uploadAttachment(uploadDto);
			} catch (DataIntegrityViolationException ex) {
				logger.error(ex.getMessage(), ex);
				return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
			}
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD, fileUploadResponseDtos);
		} else {
			return ResponseUtil.getResponse(HttpStatus.BAD_REQUEST, MsgConstant.ATTACHMENT_MSG_UPLOAD_ERROR);
		}
	}

	/**
	 * Download attachment From Disk.
	 *
	 * @param request,dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException     Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_DISK_DOWNLOADATTACHMENT)
	public ResponseEntity<Resource> downloadAttachmentByName(@Valid @RequestBody final AttachmentDownloadDto dto,
															 final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (!StringUtils.isBlank(dto.getDocumentDataKey())) {
				final Resource resource = attachmentService.downloadFiles(dto);
				String contentType = null;
				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

				if (contentType == null) {
					contentType = Constant.FILE_CONTENT_TYPE;
				}
				String filename = resource.getFilename();
				if (dto.getFileName() != null) {
					filename = dto.getFileName();
				}
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
						.body(resource);
			}
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
		return ResponseEntity.badRequest().body(null);
	}

	/**
	 * @param dto
	 * @param request
	 * @return
	 * @throws CustomException
	 * @throws IOException
	 */
	@Trace
	@PostMapping(URLConstant. URL_FILENET_DOWNLOAD_IMAGE_ATTACHMENT)
	public ResponseEntity<ApiResponse> viewAttachmentFilenet(@Valid @RequestBody final AttachmentDownloadDto dto,
															 final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (!StringUtils.isBlank(dto.getDocumentDataKey()) && !StringUtils.isBlank(dto.getFileName())) {
				Id id = new Id(dto.getDocumentDataKey());

				final Document document = FilenetUtility.retrieveDocument(id);
				String base64String = FilenetUtility.convertFilenetDocumentIntoBase64String(document.accessContentStream(0));
				ViewFileDto viewDto = new ViewFileDto();
				viewDto.setFileName(dto.getFileName());
				viewDto.setFileSrc(base64String);
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, viewDto);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
		return ResponseEntity.badRequest().body(null);
	}

	/**
	 * Commmon Attachment upload CATEGORY for divide is Transaction or workflow
	 * @param masterAttachmentDto
	 * @return
	 * @throws CustomException
	 */

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> fileUploadFile(@ModelAttribute final MasterAttachmentDto masterAttachmentDto)
			throws CustomException {
		if(masterAttachmentDto.getAttachmentCommonDtoList().isEmpty()){
			throw new CustomException(ErrorResponse.VALIDATIONS_FAILED);
		}
		if(masterAttachmentDto.getAttachmentCommonDtoList().size() == Constant.MAX_FILE_UPLOAD_LIMIT){
			throw new CustomException(ErrorResponse.VALIDATIONS_FAILED);
		}
		if (WorkflowUtility.validateFileMultipleExtensionPost(masterAttachmentDto.getAttachmentCommonDtoList())) {
			try {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_UPLOAD,attachmentService.uploadCommonAttachment(masterAttachmentDto.getAttachmentCommonDtoList()));
			} catch (DataIntegrityViolationException ex) {
				logger.error(ex.getMessage(), ex);
				return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
			}
		}else {
			return ResponseUtil.getResponse(HttpStatus.BAD_REQUEST, MsgConstant.VALIDATIONS_FAILED);
		}
	}

	/**
	 * @param masterAttachmentDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteUploadFile(@RequestBody MasterAttachmentDto masterAttachmentDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE,attachmentService.deleteAttachment(masterAttachmentDto));
	}

	/**
	 * @param masterAttachmentDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_FIELDS)
	public ResponseEntity<ApiResponse> getAttachmentTypeByMenuIdAndCategory(@RequestBody final MasterAttachmentDto masterAttachmentDto) throws CustomException {
		List<AttachmentMasterEntity> entity = attachmentMasterService.getAttachmentMasterByMenuIdAndCategory(masterAttachmentDto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * @param masterAttachmentDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAllAttachmentByTrnId(@RequestBody final MasterAttachmentDto masterAttachmentDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, attachmentMasterService.getAllAttachmentByMenuIdAndTrnIdAndCategory(masterAttachmentDto));
	}
	
	/**
	 * Download Multiple attachment from Filenet.
	 *
	 * @param dto
	 * @param request               the request
	 * @return the response entity
	 * @throws CustomException the custom exception
	 * @throws IOException     Signals that an I/O exception has occurred.
	 */
	@Trace
	@PostMapping(URLConstant.URL_MULTIPLE_DOWNLOADATTACHMENT)
	public ResponseEntity<Resource> downloadMultipleAttachment(@Valid @RequestBody final MultipleAtcmDownloadDto dto,
															  final HttpServletRequest request) throws CustomException, IOException {
		try {
			if (dto != null && dto.getDocumentDataKey() != null) {
				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		        ZipOutputStream zipOutputStream = new ZipOutputStream(byteOutputStream);
		        int i = 0;
				for(String documentDataKey : dto.getDocumentDataKey()) {
					Id id = new Id(documentDataKey);
					final Document document = FilenetUtility.retrieveDocument(id);
					final InputStream inputStream = document.accessContentStream(0);
					zipOutputStream.putNextEntry(new ZipEntry(dto.getFileName()[i]));
					IOUtils.copy(inputStream, zipOutputStream);
					zipOutputStream.closeEntry();
					i++;
				}
				zipOutputStream.close();
				byteOutputStream.toByteArray();
				
				final InputStreamResource inputStreamResource = new InputStreamResource(
						new ByteArrayInputStream(byteOutputStream.toByteArray()));
				
				return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/zip"))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dto.getFileName() + "\"")
						.body(inputStreamResource);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
		return ResponseEntity.badRequest().body(null);
	}

}
