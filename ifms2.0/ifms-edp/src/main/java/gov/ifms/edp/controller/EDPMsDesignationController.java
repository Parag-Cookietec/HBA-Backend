package gov.ifms.edp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPAddDesignationSearchViewDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPTrnUpdDsgnDto;
import gov.ifms.edp.dto.EDPUpdateDesignationSearchViewDto;
import gov.ifms.edp.service.EDPMsDesignationService;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsDesignationController.
 * 
 * @version 1.0.
 * @created 2019/08/29 18:35:30.
 *
 */
/**
 * @author AK20098889
 *
 */
/**
 * @author AK20098889
 *
 */
/**
 * @author AK20098889
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_DESIGNATION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsDesignationController {

	/** The service. */
	@Autowired
	private EDPMsDesignationService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsDesignationConverter converter;

	/** The edp trn upd dsgn converter. */
	@Trace
	@Autowired
	private EDPTrnUpdDsgnConverter edpTrnUpdDsgnConverter;

	/**
	 * Fetch MsDesignations by given MsDesignations id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ADD_GETBYID)
	public ResponseEntity<ApiResponse> getMsDesignation(@RequestBody IdDto id) {
		EDPMsDesignationDto dto = service.getMsDesignation(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,dto);

	}

	/**
	 * Search listfor add designation.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ADD_DESIGNATION_GET_BY_FIELDS)
	public ResponseEntity<ApiResponse> searchListforAddDesignation(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPAddDesignationSearchViewDto> data = service.searchListforAddDesignation(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Adds the designation delete.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ADD_DELETE)
	public ResponseEntity<ApiResponse> addDesignationDelete(@RequestBody IdDto dto) throws CustomException {
		service.deleteMsDesignation(dto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_DESIGNATION_DELETE, true);

	}

	/**
	 * creates a new MsDesignations.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_ADD_SAVE)
	public ResponseEntity<ApiResponse> createMsDesignation(@Valid @RequestBody EDPMsDesignationDto dto) throws CustomException {
		String message = EDPUtility.isMultiSpaceAndCamelCaseAndSpecialCharContine(dto.getDesignationName());
		if(StringUtils.isEmpty(message)) {
			if (dto.getFormAction()!=null && dto.getFormAction() == Status.SUBMITTED) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_DESIGNATION_CREATE,service.saveDesignation(dto));
			} else{
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_DESIGNATION_SAVE,service.saveDesignation(dto));
			}
		}
		else {
			return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR,message,null);
		}
	}

	/**
	 * Gets the update designation details.
	 *
	 * @return the update designation details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_GET_DETAILS)
	public ResponseEntity<ApiResponse> getUpdateDesignationDetails(@RequestBody ClueDto dto) throws CustomException {
		if(dto.getOfficeId()!=null) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getUpdateDesignationDetailsDto(dto.getOfficeId()));
		}
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
	}

	/**
	 * Update designation save.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_UPDATE_DESIGNATION_SAVE)
	public ResponseEntity<ApiResponse> updateDesignationSave(@RequestBody EDPTrnUpdDsgnDto dto) throws CustomException {

		if (dto.getFormAction() == Status.SUBMITTED) {
			dto.validateAll();
		}
		if(dto.getTedpUpdDsgnId() ==null )
		{
			if (dto.getFormAction()!=null && dto.getFormAction() == Status.SUBMITTED) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_UPDDESIGNATION_CREATE,
					service.updateDesignation(true, false, dto));
			}else {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_UPDDESIGNATION_SAVE,
						service.updateDesignation(true, false, dto));
			}		
		} else {
			if (dto.getFormAction()!=null && dto.getFormAction() == Status.SUBMITTED) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_UPDDESIGNATION_CREATE,
					service.updateDesignation(false, true, dto));
			} else {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_UPDDESIGNATION_SAVE,
						service.updateDesignation(false, true, dto));
			}

		}

	}
	/**
	 * Update designation delete.
	 *
	 * @param dto the dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_UPDATE_DESIGNATION_DELETE)
	public ResponseEntity<ApiResponse> updateDesignationDelete(@RequestBody IdDto dto) {
		boolean isDelete = service.updateDsgnDelete(dto.getId());
		if (isDelete)
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_UPDDESIGNATION_DELETE, true);
		else
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INVALID_JSON_FORMAT, null);
	}

	/**
	 * Update designation get byid.
	 *
	 * @param dto the dto
	 * @return the response entity
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_UPDATE_DESIGNATION_GET_BY_ID)
	public ResponseEntity<ApiResponse> updateDesignationGetByid(@RequestBody IdDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE, service.getUpdDsgnById(dto.getId()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Search listfor posts.
	 *
	 * @param pageDetail the page detail
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_UPDATE_DESIGNATION_GET_BY_FIELDS)
	public ResponseEntity<ApiResponse> searchListforPosts(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPUpdateDesignationSearchViewDto> data = service.searchListforUpdDsg(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}
	
	/**
	 * Gets the post details by designation id.
	 *
	 * @param dto the dto
	 * @return the post details by designation id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_DESIGNATION_GET_POST_DETAILS)
	public ResponseEntity<ApiResponse> getPostDetailsByDesignationId(@RequestBody ClueDto dto) throws CustomException {
		if(dto.getDesignationId()!=null && dto.getOfficeId()!=null) {
			ClueDto data = service.getPostDetailsByDesigntionId(dto);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
		}
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
	} 
	
	@Trace
	@PostMapping(URLConstant.URL_EDP_CHECK_PT_WF)
	public ResponseEntity<ApiResponse> getIsWorkflowRequired() {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.isWorkflowRequired());			
	}
	
	/**
	 * Gets the listing filter data api.
	 *
	 * @return the listing filter data api
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_PT_SEARCHSTATUS)
	public ResponseEntity<ApiResponse> getListingFilterDataApi() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getListingFilterData());
	}

	
	@Trace
	@PostMapping(URLConstant.URL_EDP_CHECK_UD_WF)
	public ResponseEntity<ApiResponse> getIsWorkflowRequiredForUpdate() {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.isWorkflowRequiredForUpdate());					
	}
	
	@Trace
	@PostMapping(URLConstant.URL_EDP_UPD_SEARCHSTATUS)
	public ResponseEntity<ApiResponse> getListingFilterDataApiForUpdate() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getListingFilterDataForUpd());
	}
	

	@Trace
	@PostMapping(URLConstant.URL_EMP_POST_FOR_OFFICE)
	public ResponseEntity<ApiResponse> getActivePostForEmpInOffice(@RequestBody EDPIdDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getActivePostForEmpInOffice(dto.getOfficeId(), dto.getUserCode()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	
	}
	
	@Trace
	@PostMapping(URLConstant.URL_UPD_REQUEST_EXISTS)
	public ResponseEntity<ApiResponse> checkForUpdRequest(@RequestBody EDPIdDto dto) throws CustomException {
		if(dto.getId() != 0) {
			service.checkUpdateDesignationRequestExists(dto.getId());		
			return ResponseUtil.getResponse(HttpStatus.OK, "");
		} else {
		throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}

	}
}
