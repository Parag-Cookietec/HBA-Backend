package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUEmployeeEOLeaveConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeEOLeaveView;
import gov.ifms.pvu.dto.PVUEmployeeEOLeaveDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.service.PVUEmployeeEOLeaveService;

/**
 * The Class roller.
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEEEOLEAVE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeeEOLeaveController {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(PVUEmployeeEOLeaveController.class);

	/**
	 * The service.
	 */
	@Autowired
	private PVUEmployeeEOLeaveService service;

	/**
	 * The converter.
	 */
	@Autowired
	private PVUEmployeeEOLeaveConverter converter;

	/**
	 * Gets the PVU employee EO leave.
	 *
	 * @param id the id
	 * @return the PVU employee EO leave
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getPVUEmployeeEOLeave(@RequestBody IdDto id) throws CustomException {
		Optional<PVUEmployeeEOLeaveEntity> entity = service.getPVUEmployeeEOLeave(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				this.converter.toDTO(entity.isPresent() ? entity.get() : null));
	}

	/**
	 * Creates the PVU employee EO leave.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createPVUEmployeeEOLeave(@RequestBody PVUEmployeeEOLeaveDto dto)
			throws CustomException {
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		if (dto.getEmployeeNo() != 0) {
			dto.setEmployeeNo(dto.getEmployeeNo());
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdatePVUEmployeeEOLeave(dto));
	}

	/**
	 * Update PVU employee EO leave.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updatePVUEmployeeEOLeave(@RequestBody PVUEmployeeEOLeaveDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				service.saveOrUpdatePVUEmployeeEOLeave(dto));
	}

	/**
	 * Gets the PVU employee EO leaves.
	 *
	 * @param pageDetail the page detail
	 * @return the PVU employee EO leaves
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getPVUEmployeeEOLeaves(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeEOLeaveView> data = service.getPVUEmployeeEOLeaves(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the employee WF history.
	 *
	 * @param idDto the id dto
	 * @return the employee WF history
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GET_EOL_EMP_WF_HST_BY_EMP_ID)
	public ResponseEntity<ApiResponse> getEmployeeWFHistory(@RequestBody IdDto idDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getEmployeeWFHistoryByEmpId(idDto.getId()));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Insert employee itr.
	 *
	 * @param pvuWFWrapperDto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_INSERT_EOL_ITR)
	public ResponseEntity<ApiResponse> insertEmployeeItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		try {
			PVUEmployeeEOLeaveDto data = service.insertWfEolItr(pvuWFWrapperDto);
			return ResponseUtil.getResponse(HttpStatus.OK,
					MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()),
					data);
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getErrorMsg());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
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
	 * Update employee eol active status.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_EOL)
	public ResponseEntity<ApiResponse> updateEmployeeEolActiveStatus(@RequestBody StatusDto statusDto)
			throws CustomException {
		service.updateActiveStatusByEmpEolId(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}

	/**
	 * Generate Print Endorsement
	 *
	 * @param IdDto dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException {

		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED,
					service.generatePrintEndorsement(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}

	/**
	 * Generate Print Endorsement
	 *
	 * @param IdDto dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_EOL_COMMENTS_PRINT)
	public ResponseEntity<ApiResponse> generateEOLPrintComments(@RequestBody IdDto dto) throws CustomException {

		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED,
					service.generateEOLPrintComments(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_VALIDATION)
	public ResponseEntity<ApiResponse> pvuEmployeeEOLeaveValidation(@RequestBody PVUEmployeeEOLeaveDto dto)
			throws CustomException {

		service.getPvuEmployeeEOLeaveValidation(dto);

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.RECORD_NOT_FOUND, null);
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_VALIDATION_CREATE)
	public ResponseEntity<ApiResponse> pvuEmployeeEOLeaveValidationCreate(@RequestBody PVUEmployeeEOLeaveDto dto)
			throws CustomException {

		service.getPvuEmployeeEOLeaveValidationCreate(dto);

		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.RECORD_NOT_FOUND, null);
	}

}