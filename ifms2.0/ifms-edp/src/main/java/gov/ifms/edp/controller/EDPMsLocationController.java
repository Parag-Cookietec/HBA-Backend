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
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsLocationConverter;
import gov.ifms.edp.dto.EDPMsLocationDto;
import gov.ifms.edp.entity.EDPMsLocationEntity;
import gov.ifms.edp.service.EDPMsLocationService;

/**
 * The Class EDPMsLocationController.
 * 
 * @version 1.0.
 * @created 2019/08/29 17:49:36.
 *
 */

@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_LOCATION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsLocationController {

	/** The service. */
	@Autowired
	private EDPMsLocationService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsLocationConverter converter;

	/**
	 * Fetch MsLocations by given MsLocations id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsLocation(@RequestBody IdDto id) {
		EDPMsLocationEntity entity = service.getMsLocation(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));

	}

	/**
	 * creates a new MsLocations
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsLocation(@RequestBody EDPMsLocationDto dto) {

		EDPMsLocationEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE, converter.toDTO(service.saveOrUpdateMsLocation(entity)));

	}

	/**
	 * Update the MsLocations
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsLocation(@RequestBody EDPMsLocationDto dto) {

		EDPMsLocationEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE, converter.toDTO(service.saveOrUpdateMsLocation(entity)));
	}

	/**
	 * Fetch all the MsLocations items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsLocationDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsLocations(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPMsLocationDto> data = service.edpMsLocationAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, data);
	}

	/**
	 * Fetch all District.
	 *
	 * @return List<EDPMsLocationDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_FIND_DISTRICT)
	public ResponseEntity<ApiResponse> findDistrict() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.findDistrict());
	}

}
