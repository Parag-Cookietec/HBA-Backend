package gov.ifms.edp.controller;

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
import gov.ifms.common.dto.StatusDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPOfficeBillMapItrConverter;
import gov.ifms.edp.dto.EDPOfficeBillMapItrDto;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.service.EDPOfficeBillMapItrService;

/**
 * The Class EDPOfficeBillMapItrController.
 * 
 * @version 1.0.
 * @created 2019/12/06 15:16:23.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_OFFICEBILLMAPITR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPOfficeBillMapItrController {

	/** The service. */
	@Autowired
	private EDPOfficeBillMapItrService service;

	/** The converter. */
	@Autowired
	private EDPOfficeBillMapItrConverter converter;

	/**
	 * Fetch OfficeBillMapItrs by given OfficeBillMapItrs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getOfficeBillMapItr(@RequestBody IdDto id) {
		EDPOfficeBillMapItrEntity entity = service.getOfficeBillMapItr(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new OfficeBillMapItrs.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createOfficeBillMapItr(@RequestBody EDPOfficeBillMapItrDto dto) {
		EDPOfficeBillMapItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateOfficeBillMapItr(entity)));
	}

	/**
	 * Update the OfficeBillMapItrs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateOfficeBillMapItr(@RequestBody EDPOfficeBillMapItrDto dto) {
		EDPOfficeBillMapItrEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateOfficeBillMapItr(entity)));
	}

	/**
	 * Deletes the OfficeBillMapItrs for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteOfficeBillMapItr(@RequestBody StatusDto statusDto) {
		service.deleteOfficeBillMapItr(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the OfficeBillMapItrs items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPOfficeBillMapItrDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getOfficeBillMapItrs(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<EDPOfficeBillMapItrDto> data = service.getOfficeBillMapItrs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

}
