package gov.ifms.pvu.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import gov.ifms.pvu.dto.PVUCommonAttachmentsDto;
import gov.ifms.pvu.dto.PVUEmployeTypeChangeDto;
import gov.ifms.pvu.dto.PVUEmployeePayTypeAttachmentDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeListingSPDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeSPDto;
import gov.ifms.pvu.entity.PVUEmployeePayTypeAttachmentEntity;
import gov.ifms.pvu.service.PVUEmployeTypeChangeService;
import gov.ifms.pvu.service.PVUEmployeePayTypeAttachmentService;

/**
 * The Class PVUEmployeController.
 * 
 * @version v 2.0.
 * @created 2021/04/20 12:05:07.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYE_TYPE_CHANGE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeTypeChangeController
		extends BasePVUAttachmentController<PVUEmployeePayTypeAttachmentEntity, PVUEmployeePayTypeAttachmentDto> {

	/**
	 * The logger.
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The service. */
	@Autowired
	private PVUEmployeTypeChangeService service;

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
	private PVUEmployeePayTypeAttachmentService revAttachmentService;

	/**
	 * Fetch Employes by given Employes id.
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_EMP_DETAILS)
	public ResponseEntity<ApiResponse> getEmploye(@RequestBody PVUEmployeTypeChangeDto dto) throws CustomException {
		try {
			List<PVUEmployeeTypeSPDto> employeeData = service.getEmployeeDetails(dto);
			if (CollectionUtils.isEmpty(employeeData)) {
				String message;
				if(dto.getEmpPaytype() == 161)
					message=MsgConstant.PVU_EMPLOYEE_ERROR_TO_OFFICE_PROB;
				else
					message=MsgConstant.PVU_EMPLOYEE_ERROR_TO_OFFICE_ADHOC;
				if (Objects.nonNull(dto.getEmpNo())) {
					PVUEmployeeTypeDto res = service.findEmployeeOfficedetails(dto.getEmpNo());
					if (!res.getOfficeId().equals(dto.getOfficeId())) {
						return ResponseUtil.getResponse(HttpStatus.NOT_FOUND, message,
								employeeData);
					}
				}
				return ResponseUtil.getResponse(HttpStatus.NOT_FOUND, message,
						employeeData);
			}
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, employeeData);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * creates a new Employee type change request.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(value = URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeTypeChange(@RequestBody PVUEmployeTypeChangeDto dto)
			throws CustomException {
		try {
			PVUEmployeTypeChangeDto result = service.saveOrUpdateEmploye(dto);
			if (Objects.isNull(result)) {
				return ResponseUtil.getResponse(HttpStatus.FORBIDDEN, MsgConstant.PVU_EMPLOYEE_ERROR_ALREADY_EXSIST,
						result);
			}
			if (StringUtils.isNotEmpty(result.getErrorCode()))
				return ResponseUtil.getResponse(HttpStatus.FORBIDDEN,
						"Employee is in " + result.getErrorCode() + " With " + result.getErrortransNo(), result);
			if(dto.getStatusId()==327)
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_EMPLOYEE_SAVED_SUCCESS, result);
			else
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_EMPLOYEE_DRAFT_SUCCESS, result);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	@Trace
	@PostMapping(value = URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeTypeChange(@RequestBody PVUEmployeTypeChangeDto id)
			throws CustomException {
		try {
			PVUEmployeTypeChangeDto result = service.getEmployeTypeChange(id);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, result);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace
	@PostMapping(value = URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteEmployeTypeChange(@RequestBody IdDto id) throws CustomException {
		try {
			service.deleteEmployeTypeChange(id);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.PVU_EMPLOYEE_SAVED_DELETED);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	@Trace
	@PostMapping(value = URLConstant.URL_EMP_PAY_TYPE_LISTING)
	public ResponseEntity<ApiResponse> fetchEmpTypeChange(@RequestBody PVUEmployeTypeChangeDto dto)
			throws CustomException {
		try {
			List<PVUEmployeeTypeListingSPDto> result = service.fetchEmpTypeChange(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, result);
		} catch (Exception ex) {
			logger.info(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public BasePVUAttachmentService<PVUEmployeePayTypeAttachmentEntity, PVUEmployeePayTypeAttachmentDto> getAttachmentService() {
		return revAttachmentService;
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
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, MsgConstant.ATTACHMENT_MSG_CREATE);
	}

}
