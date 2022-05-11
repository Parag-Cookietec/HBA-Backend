package gov.ifms.pvu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUEmployeQualificationConverter;
import gov.ifms.pvu.dto.PVUEmployeeQualificationDtos;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;
import gov.ifms.pvu.service.PVUEmployeQualificationService;


/**
 * The Class PVUEmployeQualificationController.
 * 
 * @version v 1.0.
 * @created 2019/11/27 06:11:13.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEQUALIFICATION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeQualificationController {
	
	/** The service. */
	@Autowired
	private PVUEmployeQualificationService service;
	
	/** The  converter. */
	@Autowired
	private PVUEmployeQualificationConverter converter;
	
	/**
	 * Fetch EmployeQualifications by given EmployeQualifications id .
	 *
	 * @param id the id
	 * @return  dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeQualification(@RequestBody IdDto id) {
        PVUEmployeQualificationEntity entity = service.getEmployeQualification(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
    }
	
	/**
	 * creates a new EmployeQualifications.
	 *
	 * @param dtos the dtos
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeQualification(@RequestBody PVUEmployeeQualificationDtos dtos) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,service.saveOrUpdateEmployeQualification(dtos));
    }
	
	/**
	 * Update the EmployeQualifications.
	 *
	 * @param dtos the dtos
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmployeQualification(@RequestBody PVUEmployeeQualificationDtos dtos) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,service.saveOrUpdateEmployeQualification(dtos));
	}

	
	/**
	 * Gets the employe qualification by emp id.
	 *
	 * @param id the id
	 * @return the employe qualification by emp id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_QUALIFICATION_BY_EMPID)
	public ResponseEntity<ApiResponse> getEmployeQualificationByEmpId(@RequestBody IdDto id) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,service.getEmployeQualificationByEmpId(id.getId()));
	}

	/**
	 * Update qualification active status.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_UPDATE_QUALIFINCATION_ACTIVESTATUS)
	public ResponseEntity<ApiResponse> updateQualificationActiveStatus(@RequestBody StatusDto statusDto) throws CustomException {
		service.updateQualificationActiveStatus(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}
	
	/**
	 * Update dept exam active status.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_UPDATE_DEPT_EXAM_ACTIVESTATUS)
	public ResponseEntity<ApiResponse> updateDeptExamActiveStatus(@RequestBody StatusDto statusDto) throws CustomException {
		service.updateDeptExamActiveStatus(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}
	
	/**
	 * Update ccc exam active status.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_UPDATE_CCC_EXAM_ACTIVESTATUS)
	public ResponseEntity<ApiResponse> updateCccExamActiveStatus(@RequestBody StatusDto statusDto) throws CustomException {
		service.updateCccExamActiveStatus(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}
	
	/**
	 * Update lang exam active status.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_UPDATE_LANG_EXAM_ACTIVESTATUS)
	public ResponseEntity<ApiResponse> updateLangExamActiveStatus(@RequestBody StatusDto statusDto) throws CustomException {
		service.updateLangExamActiveStatus(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EMPL_QUALIFICATION_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getHistoryOfEmpQulifictionByEmpId(@RequestBody IdDto idDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getHistoryOfEmpQulifictionByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPL_EXAM_DETAIL_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getHistoryOfEmpDeptExamDetailsByEmpId(@RequestBody IdDto idDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getHistoryOfEmpDeptExamDetailsByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	@Trace
	@PostMapping(URLConstant.URL_EMPL_CCE_EXAM_DETAIL_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getHistoryOfEmpCseDeptExamDetailsByEmpId(@RequestBody IdDto idDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getHistoryOfEmpCceDeptExamDetailsByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EMPL_LANG_EXAM_DETAIL_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getHistoryOfEmpLnagDeptExamDetailsByEmpId(@RequestBody IdDto idDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getHistoryOfEmpLngDeptExamDetailsByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	
}
