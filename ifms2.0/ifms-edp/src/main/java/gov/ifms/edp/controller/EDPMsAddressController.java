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
import gov.ifms.edp.converter.EDPMsAddressConverter;
import gov.ifms.edp.dto.EDPMsAddressDto;
import gov.ifms.edp.entity.EDPMsAddressEntity;
import gov.ifms.edp.service.EDPMsAddressService;

/**
 * The Class EDPMsAddressController.
 * 
 * @version 1.0.
 * @created 2019/08/29 18:45:37.
 *
 */

@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_ADDRESS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsAddressController {


	/** The service. */
	@Autowired
	private EDPMsAddressService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsAddressConverter converter;

	
	/**
	 * Fetch MsAddresss by given MsAddresss id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsAddress(@RequestBody IdDto id) {
		EDPMsAddressEntity entity = service.getMsAddress(id.getId());
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));

	}

	/**
	 * creates a new MsAddresss
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsAddress(@RequestBody EDPMsAddressDto dto) {

		EDPMsAddressEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsAddress(entity)));

	}

	/**
	 * Update the MsAddresss
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsAddress(@RequestBody EDPMsAddressDto dto) {

		EDPMsAddressEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsAddress(entity)));
	}


	/**
	 * Fetch all the MsAddresss items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsAddressDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse>  getMsAddresss(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPMsAddressDto> data = service.edpMsAddressAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,data);
	}

}
