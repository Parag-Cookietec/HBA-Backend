package gov.ifms.pvu.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUIncrementEventConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUIncrementCreateListView;
import gov.ifms.pvu.dto.PVUIncrementEditListView;
import gov.ifms.pvu.dto.PVUIncrementEventDto;
import gov.ifms.pvu.dto.PVUIncrementListView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.service.PVUIncrementEventService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUIncrementEventController.
 * 
 * @version v 1.0.
 * @created 2020/01/09 19:28:39.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_INCREMENTEVENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUIncrementEventController {

	/** The service. */
	@Autowired
	private PVUIncrementEventService service;

	/** The converter. */
	@Autowired
	private PVUIncrementEventConverter converter;

	/**
	 * Fetch IncrementEvents by given IncrementEvents id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getIncrementEvent(@RequestBody IdDto id) {
		PVUIncrementEventDto dto = service.getIncrementEventEmpSummary(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, dto);
	}

	/**
	 * creates a new IncrementEvents.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createIncrementEvent(@RequestBody PVUIncrementEventDto dto) throws CustomException {
		dto.validateAll();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				service.saveOrUpdateIncrementEventEmpSummary(dto));
	}

	/**
	 * Update the IncrementEvents.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateIncrementEvent(@RequestBody PVUIncrementEventDto dto) throws CustomException {
		PVUIncrementEventEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateIncrementEvent(entity)));
	}

	/**
	 * Gets the increment create include exclude list events.
	 *
	 * @param pageDetail the page detail
	 * @return the increment create include exclude list events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_CREATE_INCLUDE_EXCLUDE_LIST)
	public ResponseEntity<ApiResponse> getIncrementCreateIncludeExcludeListEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUIncrementCreateListView> data = service.getIncrementCreateIncludeExcludeEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the increment edit list events.
	 *
	 * @param pageDetail the page detail
	 * @return the increment edit list events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDIT_LIST)
	public ResponseEntity<ApiResponse> getIncrementEditListEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUIncrementEditListView> data = service.getIncrementEditEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the increment list events.
	 *
	 * @param pageDetail the page detail
	 * @return the increment list events
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_INCREMENT_LIST)
	public ResponseEntity<ApiResponse> getIncrementListEvents(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUIncrementListView> data = service.getIncrementListEvents(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the creates the look up info as map.
	 *
	 * @return the creates the look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_CREATION_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getCreateLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service
				.getLookUpInfoAsMap(PvuConstant.PVU_INCREMENT_CREATE_LOOKUPS_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Gets the list look up info as map.
	 *
	 * @return the list look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_LIST_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getListLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service
				.getLookUpInfoAsMap(PvuConstant.PVU_INCREMENT_LIST_LOOKUPS_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Insert increment itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_PVU_INSERT_INCREMENT_ITR)
	public ResponseEntity<ApiResponse> insertIncrementItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		try {
			PVUIncrementEventDto pvuIncrementEventDto = service.insertIncrementItr(pvuWFWrapperDto);
			 return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()), pvuIncrementEventDto);
		} catch (CustomException e) {
			throw new CustomException(e.getErrorCode(), e.getErrorMsg());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * Delete increment event.
	 *
	 * @param idDto the id dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteIncrementEvent(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteIncrementTrns(idDto));
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_VALIDATE_INCREMENT_SUBMIT)
	public ResponseEntity<ApiResponse> validateSubmit(@RequestBody PVUIncrementEventDto dto) throws CustomException {
		dto.validateAll();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				service.validateIncrementSubmit(dto));
	}
}
