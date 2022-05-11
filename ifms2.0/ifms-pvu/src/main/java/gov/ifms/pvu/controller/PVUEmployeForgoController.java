package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.attachment.service.AttachmentService;
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
import gov.ifms.common.util.Utils;
import gov.ifms.pvu.converter.PVUEmployeForgoConverter;
import gov.ifms.pvu.dto.PVUCommonAttachmentsDto;
import gov.ifms.pvu.dto.PVUCommonResponse;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeForgoDto;
import gov.ifms.pvu.dto.PVUForgoView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;
import gov.ifms.pvu.service.PVUEmployeForgoService;
import gov.ifms.pvu.service.PVUForgoAttachmentService;

/**
 * The Class PVUForgoEventController.
 * 
 * @version v 1.0.
 * @created 2019/12/23 11:00:23.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_FORGOEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeForgoController {

	/** The service. */
	@Autowired
	private PVUEmployeForgoService service;

	/** The converter. */
	@Autowired
	private PVUEmployeForgoConverter converter;

	/** The attachment service. */
	@Autowired
	private AttachmentService attachmentService;

	/** The cs attachment service. */
	@Autowired
	private PVUForgoAttachmentService fgAttachmentService;

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * Fetch ForgoEvents by given ForgoEvents id.
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getForgoEvent(@RequestBody IdDto id) throws CustomException {
		PVUEmployeForgoEntity entity = service.getForgoEvent(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new ForgoEvents.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createForgoEvent(@RequestBody PVUEmployeForgoDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdateForgoEvent(dto));
	}

	/**
	 * Update the ForgoEvents.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateForgoEvent(@RequestBody PVUEmployeForgoDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				(service.saveOrUpdateForgoEvent(dto)));
	}

	/**
	 * Gets the forgo events.
	 *
	 * @param pageDetail the page detail
	 * @return the forgo events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getForgoEvents(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUForgoView> data = service.getForgoEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_ALL_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getAllLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Creates the ca attachment.
	 *
	 * @param dto the dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_ATTACHMENT)
	public ResponseEntity<ApiResponse> createForgoAttachment(@Valid @ModelAttribute PVUCommonAttachmentsDto dto)
			throws CustomException {
		dto.setCreatedDate(new Date());
		dto.setUpdatedDate(new Date());
		if (!Utils.isEmpty(dto.getFileAttachment()) && !Utils.isEmpty(dto.getFileAttachment().get(0))) {
			dto.getFileAttachment().forEach(fileDto -> {
				fileDto.setTransactionId(1l);
				List<FileUploadResponseDto> uploadAttachment = null;
				try {
					uploadAttachment = attachmentService.createPostAttachment(fileDto);
				} catch (Exception ex) {
					LOGGER.info("Exception in Uploading File:" + ex.getMessage());
				}
				fgAttachmentService
						.saveOrUpdateForgoAttachment(converter.prepareAttachmentEntity(dto, uploadAttachment.get(0)));
			});

		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, "Attachment save successfully.");
	}

	/**
	 * Insert employee itr.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_INSERT_EMPLOYEE_ITR)
	public ResponseEntity<ApiResponse> insertEmployeeItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		try {
			PVUEmployeForgoDto data = service.insertEmployeeItr(pvuWFWrapperDto);
			return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()), data);
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getErrorMsg());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
