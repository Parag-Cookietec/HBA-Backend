package gov.ifms.edp.controller;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPOffTypeAndSubTypeDto;
import gov.ifms.edp.dto.EDPWorkflowStatusDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.service.EDPAttachmentService;
import gov.ifms.edp.service.EDPMsOfficeService;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsOfficeController.
 * 
 * @version 1.0.
 * @created 2019/08/29 17:31:41.
 *
 */
@Validated
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_OFFICE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsOfficeController {

	/** The service. */
	@Autowired
	private EDPMsOfficeService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsOfficeConverter converter;

	@Autowired
	EDPAttachmentService attachmentService;

	/**
	 * Fetch MsOffices by given MsOffices id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsOffice(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getMsOffice(id.getId()));

	}

	/**
	 * creates a new MsOffices.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsOffice(@RequestBody EDPMsOfficeDto dto) throws CustomException {
		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		setParentId(dto);
		try {
			EDPMsOfficeEntity entity = converter.toEntity(dto);
			EDPMsOfficeDto officeDto = converter.toDTO(service.saveOrUpdateMsOffice(entity, true,
					dto.isUpdateOffice() == null ? Boolean.FALSE : dto.isUpdateOffice(), dto));
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE, officeDto);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	private void setParentId(EDPMsOfficeDto dto) {
		if (dto.getOfficeTypeId() != null && dto.getOfficeTypeId().equals(EDPConstant.HOD_ID)) {
			dto.setParentOfficeId(dto.getDepartmentId());
		}
		/**if (dto.getDepartmentId() != null) {
			EDPMsOfficeEntity entity = repository.findByOfficeIdAndActiveStatus(dto.getOfficeId(),
					EDPConstant.ACTIVE_STATUS_TRUE);
			if (entity.getDepartmentId() != null) {
				dto.setDepartmentId(entity.getDepartmentId().getDepartmentId());
			}
		}*/
	}

	/**
	 * Update the MsOffices.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsOffice(@RequestBody EDPMsOfficeDto dto) throws CustomException {
		try {
			setParentId(dto);
			if (dto.getFormAction() == Status.SUBMITTED && dto.getIsUpdate() != null && !validateAttachment(dto))
				throw new CustomException(ErrorResponse.REQUIRED_MENDATORY_ATTACHMENT);
			EDPMsOfficeEntity entity = converter.toEntity(dto);
			String msgConst = null;
			if (dto.getMsgFlag() == null) {
				msgConst = MsgConstant.EDP_MSG_UPDATE;
			} else if (dto.getMsgFlag()) {
				msgConst = MsgConstant.OFFICE_UPDATION_MSG;
			} else {
				msgConst = MsgConstant.OFFICE_CREATION_MSG;
			}
			return ResponseUtil.getResponse(HttpStatus.OK, msgConst,
					converter.toDTO(service.saveOrUpdateMsOffice(entity, false,
							dto.isUpdateOffice() == null ? Boolean.FALSE : dto.isUpdateOffice(), dto)));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (CustomException exception) {
			throw exception;
		} catch (Exception exception) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Fetch all the MsOffices items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsOfficeDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsOffices(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPMsOfficeDto> data = service.edpMsOfficeAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, data);
	}

	/**
	 * This API is used to estimation from by current user.
	 *
	 * @return List of ClueDto
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_USER_ID)
	public ResponseEntity<ApiResponse> getEstimationFrom() {
		EDPMsPostDto dDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.findOfficeByPostId(OAuthUtility.getCurrentUserUserId(), dDPMsPostDto.getPostId()));
	}

	/**
	 * This API is used to get estimation by by office id.
	 *
	 * @param idDto the id dto
	 * @return List of ClueDto
	 */
	@Trace
	@PostMapping(URLConstant.GET_ESTIMATIONBY_BY_OFFICE_ID)
	public ResponseEntity<ApiResponse> getEstimationFor(@RequestBody IdDto idDto) {
		EDPMsPostDto dDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.findOfficeById(OAuthUtility.getCurrentUserUserId(), dDPMsPostDto.getPostId(), idDto.getId()));
	}

	/**
	 * Ge id code estimation from.
	 *
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_ALL_ESTIMATION_FROM)
	public ResponseEntity<ApiResponse> getIdCodeEstimationFrom() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.findIdCodeEstimationFrom());
	}

	/**
	 * Ge id code estimation from.
	 *
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICEDETAILS)
	public ResponseEntity<ApiResponse> getOfficeDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getOfficeDetails());
	}

	/**
	 * Update active status.
	 *
	 * @param statusDto the status dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_UPDATE_ACTIVESTATUS)
	public ResponseEntity<ApiResponse> updateActiveStatus(@RequestBody StatusDto statusDto) throws CustomException {
		service.updateActiveStatus(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Gets the cardex no.
	 *
	 * @param idDto the id dto
	 * @return the cardex no
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_CARDEX_NO)
	public ResponseEntity<ApiResponse> getCardexNo(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getNextCardexNo(idDto.getId()));
	}

	/**
	 * Gets the district wise office details.
	 *
	 * @return the district wise office details
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_DISTRICT_WISE_OFFICEDETAILS)
	public ResponseEntity<ApiResponse> getDistrictWiseOfficeDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getDistrictWiseOfficeDetails());
	}

	/**
	 * Gets the all department.
	 *
	 * @return the all department
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_ALL_DEPARTMENT_WITH_HOD)
	public ResponseEntity<ApiResponse> getAllDepartmentsWithHod() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.getAllDepartmentsWithHod());
	}

	/**
	 * Office history report.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICE_HISTORY_REPORT)
	public ResponseEntity<ApiResponse> officeHistoryReport(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.searchForOfficeHistoryReport(pageDetail));
	}

	private boolean validateAttachment(EDPMsOfficeDto officeDto) throws CustomException {
		if (officeDto.getOfficeId() != null) {
			List<Object[]> attachmentdtos = attachmentService.getAttachmentByOfcIdAndAttType(officeDto.getOfficeId(),
					EDPConstant.EDP_CNO_ATTCH_TBL_NAME);
			if (CollectionUtils.isEmpty(attachmentdtos) || attachmentdtos.size() < 7) {
				return Boolean.FALSE;
			} else {
				return Boolean.TRUE;
			}
		}
		return Boolean.TRUE;
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICE_BY_DISTRICT_AND_PVUID)
	public ResponseEntity<ApiResponse> getOfficeByDistrictAndPvuId(@RequestBody EDPMsOfficeDto officeDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getOfficeByDistrictAndPvuId(officeDto));
	}

	/**
	 * This API is used to estimation from by current user.
	 *
	 * @return List of ClueDto
	 */
	@Trace
	@PostMapping(URLConstant.GET_ESTIMATION_FROM)
	public ResponseEntity<ApiResponse> getEstimationFromOfficeName() {
		EDPMsOfficeDto edpMsOfficeDto = OAuthUtility.getCurrentUserOfficeOauthToken();
		Map<String, Object> officeMap = new HashMap<>();
		officeMap.put("id", edpMsOfficeDto.getOfficeId());
		officeMap.put("codeName", edpMsOfficeDto.getOfficeName());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, officeMap);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICE_BY_DISTRICT)
	public ResponseEntity<ApiResponse> getOfficesByDistrict(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getOfficesByDistrict(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_AD)
	public ResponseEntity<ApiResponse> getAdOffices() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getByOfficeType(EDPConstant.OFFICE_TYPE_AD));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICES_BY_TYPE)
	public ResponseEntity<ApiResponse> getOfficeListByOfficeType(@RequestBody ClueDto officeType) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getByOfficeType(officeType.getName()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_PARENT_OFFICE)
	public ResponseEntity<ApiResponse> getParentOffice(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getParentOffice(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_CHILD_OFFICE)
	public ResponseEntity<ApiResponse> getChildOfficeList(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getChildOfficeList(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_HOD_BY_DEPT_OFFICE)
	public ResponseEntity<ApiResponse> getHODListBasedonDepartmentOffice(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getHODListBasedonDepartmentOffice(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_CO_BY_HOD_ID)
	public ResponseEntity<ApiResponse> getCOListByHodOfficeId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getCOListByHodOfficeId(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICE_BY_FLAG)
	public ResponseEntity<ApiResponse> getOfficesByFlagList(@RequestBody List<ClueDto> clueDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getOfficesByFlagList(clueDto));
	}

	/**
	 *
	 * @param idDto
	 * @return
	 */

	@Trace
	@PostMapping(URLConstant.URL_GET_OFFICES_BY_TYPE_ID)
	public ResponseEntity<ApiResponse> getOfficeListByOfficeType(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getByOfficeTypeByOfficeTypeId(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_FD_OFFICE)
	public ResponseEntity<ApiResponse> getFdOffice() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getFdOffice());
	}

	/**
	 * given api checks whether workflow is required or not
	 * 
	 * @param menu id
	 * @return boolean
	 */
	@Trace
	@PostMapping(value = URLConstant.URL_EDP_CHECK_CNO_WF)
	public ResponseEntity<ApiResponse> isWorkFlowRequiredCno(@RequestBody EDPIdDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.isWorkflowRequired(EDPConstant.CREATE_OFFICE_MENU_ID));
	}

	@Trace
	@PostMapping(value = URLConstant.URL_EDP_CHECK_UO_WF)
	public ResponseEntity<ApiResponse> isWorkFlowRequiredUo(@RequestBody EDPIdDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.isWorkflowRequired(EDPConstant.DETAIL_OFFICE_SUMM_MENU_ID));
	}

	@Trace
	@PostMapping(value = URLConstant.URL_OFFICE_BY_DISTRICT_FILTER)
	public ResponseEntity<ApiResponse> findOfficesAndStatusByDistrict(@RequestBody EDPIdDto dto)
			throws CustomException {
		try {

			if (null != dto.getDistrictId() && dto.getDistrictId() > 0) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
						service.getOfficesAndStatusByDistrict(dto.getDistrictId(), dto.getDdoNo(), dto.getCardexNo(),
								dto.getOfficeName()));
			} else {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Checks for workflow progress status.
	 * 
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(value = URLConstant.URL_EDP_UO_CHECK_WF_STATUS)
	public ResponseEntity<ApiResponse> checkWfInit(@RequestBody EDPIdDto dto) throws CustomException {
		try {
			List<EDPWorkflowStatusDto> result = service.checkWfStatus(dto);
			if (result != null && !result.isEmpty()) {
				boolean wfInitStatus = result.get(0).getWfInitStatus() != null
						? result.get(0).getWfInitStatus().booleanValue()
						: Boolean.FALSE;
				if (wfInitStatus) {
					return ResponseUtil.getResponse(10001, service.getWfInitErrorMessage(result.get(0)), null);
				}
			}

			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, result);
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Checks ddo no is available for selected district
	 * 
	 * @param idDto
	 * @return
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(value = URLConstant.URL_EDP_CHECK_DDO_NO)
	public ResponseEntity<ApiResponse> checkDDONoByDistrictId(@RequestBody EDPIdDto idDto) {
		boolean isDdoNoAvail = service.checkDdoNoByDistrictId(idDto.getDistrictId(), idDto.getDdoNo());
		if (isDdoNoAvail)
			return ResponseUtil.getResponse(HttpStatus.OK,
					MessageFormat.format(MsgConstant.EDP_DDO_NO_ALREADY_EXISTS_CNO, idDto.getDdoNo()), isDdoNoAvail);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.RECORD_NOT_FOUND, isDdoNoAvail);

	}

	@Trace
	@PostMapping(value = URLConstant.URL_UPDATE_OFFICE)
	public ResponseEntity<ApiResponse> updateMasterOffice(@RequestBody EDPMsOfficeDto dto) throws CustomException {
		try {
			EDPMsOfficeDto officeDto = converter.toDTO(service.updateMsOffice(dto));

			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE, officeDto);
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Gets the office bills.
	 *
	 * @param dto the dto
	 * @return the office bills
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(value = URLConstant.URL_OFFICE_GET_BILLS)
	public ResponseEntity<ApiResponse> getOfficeBills(@RequestBody IdDto dto) throws CustomException {
		if (null != dto.getId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
					service.getBillsByOfficeId(dto.getId()));
		}
		throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);

	}

	@Trace
	@PostMapping(value = URLConstant.URL_APPROVE_OFFICE_UPDATE)
	public ResponseEntity<ApiResponse> approveOfficeUpdate(@RequestBody EDPMsOfficeDto dto) throws CustomException {
		try {
			service.approveOfficeUpdate(dto);

			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE, null);
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	@Trace
	@PostMapping(value = URLConstant.URL_GET_MASTER_OFFICE)
	public ResponseEntity<ApiResponse> getMasterOfficeDetails(@RequestBody IdDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getMasterOfficeDetails(dto.getId()));
	}

	/**
	 * Get treasury office & PAO by district.
	 * 
	 * @param idDto
	 * @return responseEntity
	 */
	@Trace
	@PostMapping(URLConstant.URL_TREASURY_BY_DIST_ID)
	public ResponseEntity<ApiResponse> getTrsPaoOffices(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, service.getTrsPaoOffices(idDto));
	}

	@Trace
	@PostMapping(URLConstant.URL_BILL_SUB_TO_OFFICE_BY_OFFICE)
	public ResponseEntity<ApiResponse> getBillSubmitToByOffice(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getBillSubmitToByOffice(idDto.getId()));
	}

	@Trace
	@PostMapping(value = URLConstant.URL_GET_OFFICES_BY_OFF_TYPE_AND_SUB_TYPE)
	public ResponseEntity<ApiResponse> getOfficeListByOfficeTypeAndSubType(@RequestBody EDPOffTypeAndSubTypeDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getOfficeByOfficeTypeAndSubOfficeType(dto));
	}
	
	@Trace
	@PostMapping(URLConstant.URL_GET_TO_OFFICE_BY_DISTRICT_ID)
	public ResponseEntity<ApiResponse> getTreasuryOfficeByDistrictId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getTreasuryOfficeByDistrictId(idDto.getId()));
	}
	
	
	@Trace
	@PostMapping(URLConstant.GET_CO_OFFICE_BY_DEPARTMENT_ID)
	public ResponseEntity<ApiResponse> getCoListByDepartmentId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getCOListByDepartmentId(idDto.getId()));
	}
	@Trace
	@PostMapping(URLConstant.GET_HOD_OFFICE_BY_DEPARTMENT_ID)
	public ResponseEntity<ApiResponse> getHodListByDepartmentId(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getHODListByDepartmentOffice(idDto.getId()));
	}
	
}
