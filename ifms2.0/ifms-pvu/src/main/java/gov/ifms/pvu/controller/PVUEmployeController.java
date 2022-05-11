package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

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

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.FieldDto;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SearchDto;
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.pvu.dto.PVUCommonEmployeView;
import gov.ifms.pvu.dto.PVUCommonResponse;
import gov.ifms.pvu.dto.PVUEmpDeptQualifiUpdate;
import gov.ifms.pvu.dto.PVUEmployeAddressView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeeDtos;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuLookupInfoDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.service.PVUEmployeService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeController.
 * 
 * @version v 1.0.
 * @created 2019/11/20 12:05:07.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeController {

	/** The service. */
	@Autowired
	private PVUEmployeService service;

	/**
	 * Fetch Employes by given Employes id.
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmploye(@RequestBody IdDto id) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,service.getEmployeeDetails(id.getId()));
	}

	/**
	 * creates a new Employes.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(value = URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmploye(@ModelAttribute PVUEmployeeDtos dto) throws CustomException {
		try {
			if (dto.getFormAction() == Status.SUBMITTED) {
				dto.validateAll();
			}
			PVUEmployeeDtos result = service.saveOrUpdateEmploye(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, result);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Update the Employes.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmploye(@RequestBody PVUEmployeeDtos dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE, service.saveOrUpdateEmploye(dto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
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
		try {
			Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getAllLuLookUpInfoAsMap();
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Gets the employes.
	 *
	 * @param pageDetail the page detail
	 * @return the employes
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getEmployes(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUEmployeAddressView> data = service.getEmployes(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the all employe events.
	 *
	 * @param pageDetail the page detail
	 * @return the all employe events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_COMMON_EMP)
	public ResponseEntity<ApiResponse> getAllCommonEmploye(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUCommonEmployeView> data = service.getAllCommonEmploye(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);
	}

	/**
	 * Gets the employe details.
	 *
	 * @return the employe details
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_EMPLOYE_LOOKUPINFO)
	@Deprecated
	public ResponseEntity<ApiResponse> getEmployeDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getEmployeLookUpInfo());
	}

	/**
	 * Gets the pvu lookup and master info
	 *
	 * @return the employe details
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_LOOKUPINFO)
	public ResponseEntity<ApiResponse> getPvuLookupInfo() {
		PvuLookupInfoDto pvuLookupInfoDto = service.getPvuLookupInfoDto();
		pvuLookupInfoDto.setHodDepartment(service.getHODDepartments());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, pvuLookupInfoDto);
	}

	/**
	 * Gets the employe details.
	 *
	 * @param fieldDto the field dto
	 * @return the employe details
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_DUBLICATE_PAN_NUMBER)
	public ResponseEntity<ApiResponse> isDuplicatePanNumber(@RequestBody FieldDto fieldDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.validatePanNumber(fieldDto.getFieldValue()));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Gets the employee common details.
	 *
	 * @param dto the dto
	 * @return the employe details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_COMMON_RESPONSE_BY_ID)
	public ResponseEntity<ApiResponse> getCommonResponseById(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getCommonResponseById(dto));
	}
	
	/**
	 * Gets the employee by employee number.
	 *
	 * @param idDto the id dto
	 * @return the employee by employee number
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_EMPLOYEE_BY_EMPLOYEE_NUMBER)
	public ResponseEntity<ApiResponse> getEmployeeByEmployeeNumber(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getEmpByEmpNumber(idDto.getId()));		
	}
	
	/**
	 * Gets the employee common details.
	 *
	 * @return the employe details
	 * @throws CustomException the custom exception
	 */
	
	@Trace
	@PostMapping(URLConstant.URL_All_DDL_EMP)
	public ResponseEntity<ApiResponse> getDDLLuLookUpInfoAsMap() throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service.getDDLLuLookUpInfoAsMap();
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}
	
	/**
	 * Gets the employee common details.
	 *
	 * @param dto the dto
	 * @return the employe details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_OFFICE_BY_ID)
	public ResponseEntity<ApiResponse> getOfficeTypeFromEdpById(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getOfficeTypeByEdpId(dto.getId()));
	}
	
	/**
	 * Update active status.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_UPDATE_NOMINEE_ACTIVESTATUS)
	public ResponseEntity<ApiResponse> updateNomineeActiveStatus(@RequestBody StatusDto statusDto) throws CustomException {
		service.updateActiveStatus(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}
	
	/**
	 * Gets the duplicate pan no detail.
	 *
	 * @param fieldDto the field dto
	 * @return the duplicate pan no detail
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GET_DUBLICATE_PAN_NO_DETAIL)
	public ResponseEntity<ApiResponse> getDuplicatePanNoDetail(@RequestBody FieldDto fieldDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getDuplicatePanNoDetail(fieldDto.getFieldValue()));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}
	
	/**
	 * Gets the employee WF history.
	 *
	 * @param idDto the id dto
	 * @return the employee WF history
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_GET_EMP_WF_HST_BY_EMP_ID)
	public ResponseEntity<ApiResponse> getEmployeeWFHistory(@RequestBody IdDto idDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getEmployeeWFHistoryByEmpId(idDto.getId()));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
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
	public ResponseEntity<ApiResponse> insertEmployeeItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		try {
			PVUCommonResponse data = service.insertEmployeeItr(pvuWFWrapperDto);
			return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()), data);
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(),e.getErrorMsg());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * Gets the employee no.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the employee no
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EMP_NO)
	public ResponseEntity<ApiResponse> getEmployeeNo(@RequestBody PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.getAutoEmployeeNumber(pvuWFWrapperDto));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * Delete employee.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_EMP)
	public ResponseEntity<ApiResponse> deleteEmployee(@RequestBody IdDto idDto) throws CustomException {
		service.updateActiveStatusByEmpId(idDto.getId(), Constant.IN_ACTIVE_STATUS);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, null);
	}
	
	/**
	 * Gets the employee photo.
	 *
	 * @param idDto the id dto
	 * @return the employee photo
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_EMPLOYEE_PHOTO)
	public ResponseEntity<ApiResponse> getEmployeePhoto(@RequestBody IdDto idDto) throws CustomException {
		try {
			service.deleteEmployeePhotoByEmpId(idDto.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, null);
		} catch (Exception ex) {
			return ResponseUtil.getResponse(HttpStatus.OK, ErrorResponse.ERROR_WHILE_DELETE.getMessage());
		}
	}
	
	/**
	 * Gets the employee nominee photos.
	 *
	 * @param idDto the id dto
	 * @return the employee nominee photos
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_PHOTOS)
	public ResponseEntity<ApiResponse> getAttachments(@RequestBody FieldDto fieldDto) throws CustomException {
		try {
			ClueDto clueDto = service.getAttachments(fieldDto.getFieldValue());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, clueDto);
		} catch (Exception ex) {
			return ResponseUtil.getResponse(HttpStatus.OK, ErrorResponse.ERROR_WHILE_DOWNLOAD.getMessage());
		}
	}
	
	/**
	 * Delete nominee attachements.
	 *
	 * @param pvuCommonRequest the pvu common request
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_ATTACHMENT)
	public ResponseEntity<ApiResponse> deleteNomineeAttachements(@RequestBody PvuCommonRequest pvuCommonRequest) {
		try {
			service.deleteNomineeAttachementsByNomineeId(pvuCommonRequest);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.ATTACHMENT_DELETE, null);
		} catch (Exception ex) {
			return ResponseUtil.getResponse(HttpStatus.OK, ErrorResponse.ERROR_WHILE_DELETE.getMessage());
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_EMPLOYEE_BY_EMPLOYEE_NO)
	public ResponseEntity<ApiResponse> getEmployeeByEmployeeNo(@RequestBody SearchDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getEmpByEmpNo(dto));
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_EMPLOYEE_APPROVERNAME_DESIGNATIONNAME)
	public ResponseEntity<ApiResponse> getEmployeeApproverNameAndDesignation(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getEmployeeApproverNameAndDesignation(idDto.getId()));
	}
	
	@Trace
	@PostMapping(URLConstant.URL_ENTRY_PAY)
	public ResponseEntity<ApiResponse> getEntryPaySearchEmployes(@RequestBody PageDetails pageDetail)
			throws CustomException {
		if (service.getEntryPaySearchEmployes(pageDetail) == null
				|| service.getEntryPaySearchEmployes(pageDetail) == 0) {
			return ResponseUtil.getResponse(HttpStatus.NOT_FOUND, PvuConstant.MSG_PAY_BAND,
					service.getEntryPaySearchEmployes(pageDetail));
		} else {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getEntryPaySearchEmployes(pageDetail));
		}
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_UPDATE_PUT_BY_ID)
	public ResponseEntity<ApiResponse> employeUpdateAllfiled(@ModelAttribute PVUEmpDeptQualifiUpdate dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE, 
					service.employeUpdateAllfiled(dto));
		}  catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	} 
     
	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getHistoryPersonDetails(@RequestBody IdDto idDto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getHistoryOfEmpDetailsByItrTabel(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EMPL_NOMINI_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getHistoryNomineeDetailByEmpId(@RequestBody IdDto idDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getHistoryOfEmpNominiByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EMPL_ADDRESS_HISTORY_BY_ID)
	public ResponseEntity<ApiResponse> getHistoryAddressDetailByEmpId(@RequestBody IdDto idDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getHistoryOfEmpAddressByEmpId(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_ALL_OFFICE_BY_TYPE)
	public ResponseEntity<ApiResponse> getOfficeNameByOfficeType(@RequestBody IdDto idDto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
					service.getOfficeNameByOfficeType(idDto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
