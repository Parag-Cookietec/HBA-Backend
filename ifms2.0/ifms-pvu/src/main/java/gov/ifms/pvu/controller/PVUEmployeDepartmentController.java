package gov.ifms.pvu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.dto.PVUEmployeDepartmentDtos;
import gov.ifms.pvu.service.PVUEmployeDepartmentService;
import gov.ifms.pvu.service.PVUEmployeDeptAndHodService;
import gov.ifms.pvu.service.PVUEmployeHistoryService;

/**
 * The Class PVUEmployeeDepartmentController.
 *
 * @version v 1.0.
 * @created 2019/11/21 14:17:25.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEEDEPARTMENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeDepartmentController {

	/**
	 * The service.
	 */
	@Autowired
	private PVUEmployeDepartmentService service;

	/**
	 * The service.
	 */
	@Autowired
	private PVUEmployeHistoryService serviceHistoryService;

	/** The pvu employe dept and hod service. */
	@Autowired
	private PVUEmployeDeptAndHodService pvuEmployeDeptAndHodService;

	/**
	 * Fetch EmployeeDepartments by given EmployeeDepartments id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeeDepartment(@RequestBody IdDto id) {

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEmployeeDepartment(id.getId()));
	}

	/**
	 * creates a new EmployeeDepartments.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeeDepartment(@RequestBody PVUEmployeDepartmentDtos dto) {
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdateEmployeeDepartment(dto));
	}

	/**
	 * +.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteEmployeHistory(@RequestBody StatusDto statusDto) {
		serviceHistoryService.deleteStatus(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}

	/**
	 * Gets the ho by departments.
	 *
	 * @param id the id
	 * @return the ho by departments
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getHoByDepartments(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				pvuEmployeDeptAndHodService.getEmployeDeptAndHod(id.getId()));
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EMP_DEPT_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getQuerieOfHistoryOfEmpDepartmentByEmpId(@RequestBody IdDto idDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getQuerieOfHistoryOfEmpDepartmentByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_EMP_PRV_HIS_DETAIL_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getQuerieOfHistoryOfEmpPRVHistByEmpId(@RequestBody IdDto idDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getQuerieOfHistoryOfEmpPRVHistByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_ALL_OFFICE_BY_TYPE)
	public ResponseEntity<ApiResponse> ggetOfficeDetailsByCardexAndDDOAndDId(@RequestParam(name = "districtId") long districtId, @RequestParam(name = "dooNo") long dooNo ,@RequestParam(name = "cardexNo") long cardexNo) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getOfficeDetailsByCardexAndDDOAndDId( districtId,  dooNo ,  cardexNo));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
}
