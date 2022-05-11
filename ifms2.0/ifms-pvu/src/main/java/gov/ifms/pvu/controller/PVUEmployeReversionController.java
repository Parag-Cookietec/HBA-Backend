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

import gov.ifms.common.attachment.service.AttachmentService;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.common.util.Utils;
import gov.ifms.pvu.common.BasePVUAttachmentController;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUEmployeReversionConverter;
import gov.ifms.pvu.dto.PVUCommonAttachmentsDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeReversionDto;
import gov.ifms.pvu.dto.PVUReversionAttachmentDto;
import gov.ifms.pvu.dto.PVUReversionPayLelevView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeReversionEntity;
import gov.ifms.pvu.entity.PVUReversionAttachmentEntity;
import gov.ifms.pvu.service.PVUEmployeReversionService;
import gov.ifms.pvu.service.PVUReversionAttachmentService;

/**
 * The Class PVUEmployeReversionController.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_PVUEMPLOYEREVERSIONEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeReversionController
		extends BasePVUAttachmentController<PVUReversionAttachmentEntity, PVUReversionAttachmentDto> { 

	/**
	 * The logger.
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The service.
	 */
	@Autowired
	private PVUEmployeReversionService service;

	/**
	 * The converter.
	 */
	@Autowired
	private PVUEmployeReversionConverter converter;

	/**
	 * The attachment service.
	 *
	 * @param id the id
	 * @return the PVU employe reversion event
	 * @throws CustomException the custom exception
	 */
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * The cs attachment service.
	 */
	@Autowired
	private PVUReversionAttachmentService revAttachmentService;

	@Override
	public BasePVUAttachmentService<PVUReversionAttachmentEntity, PVUReversionAttachmentDto> getAttachmentService() {
		return revAttachmentService;
	}
	
	/**
	 * Fetch PVUEmployeReversionEvents by given PVUEmployeReversionEvents id .
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getPVUEmployeReversionEvent(@RequestBody IdDto id) throws CustomException {
		PVUEmployeReversionEntity entity;
		entity = service.getPVUEmployeReversionEvent(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new PVUEmployeReversionEvents.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createPVUEmployeReversionEvent(@RequestBody PVUEmployeReversionDto dto)
			throws CustomException {
		PVUEmployeReversionDto resDto = null;
		try {
			resDto = converter.toDTO(service.saveOrUpdatePVUEmployeReversionEvent(dto));
			if (dto.getEmployeeNo() != 0) {
				resDto.setEmployeeNo(dto.getEmployeeNo());
			}
		} catch (DataIntegrityViolationException e) {
			logger.info(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, resDto);

	}

	/**
	 * Update the PVUEmployeReversionEvents.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updatePVUEmployeReversionEvent(@RequestBody PVUEmployeReversionDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				converter.toDTO(service.saveOrUpdatePVUEmployeReversionEvent(dto)));

	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_FIELDS)
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
	public ResponseEntity<ApiResponse> createReversionAttachment(@Valid @ModelAttribute PVUCommonAttachmentsDto dto) {
		dto.setCreatedDate(new Date());
		dto.setUpdatedDate(new Date());
		if (!Utils.isEmpty(dto.getFileAttachment()) && !Utils.isEmpty(dto.getFileAttachment().get(0))) {
			dto.getFileAttachment().forEach(fileDto -> {
				fileDto.setTransactionId(1l);
				try {
					attachmentService.createPostAttachment(fileDto);
				} catch (Exception ex) {
					logger.info(ex.getMessage(), ex);
				}
			});
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, "Attachment save successfully.");
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_INSERT_REVERSION_ITR)
	public ResponseEntity<ApiResponse> insertReversiontItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()),
					service.insertReversionItr(pvuWFWrapperDto));
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getMessage());
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_PAYlEVEL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeEvents(@RequestBody Map<String, Object> param) {
		PVUReversionPayLelevView lelevView = service.getPayCommitionDetails(param);
		if (lelevView != null) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, lelevView);
		} else {
			return ResponseUtil.getResponse(HttpStatus.NOT_FOUND, MsgConstant.RECORD_NOT_FOUND, lelevView);
		}
	}

	/**
	 * delete the PVUReversion
	 *
	 * @param dto dto
	 * @return the delete by id
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto dto) {
		service.deleteById(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}
	
	
	@Trace   // 8 No. Screen
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)  
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException {
        try {
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_EMP_CLASS)
	public ResponseEntity<ApiResponse> getAvailableClassForEmp(@RequestBody IdDto dto) throws CustomException {
		if(null != dto.getId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getAvailableClassForEmp(dto.getId()));
		}else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

}
