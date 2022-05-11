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
import gov.ifms.edp.converter.EDPLuLookUpConverter;
import gov.ifms.edp.dto.EDPLuLookUpDto;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.service.EDPLuLookUpService;

/**
 * The Class EDPLuLookUpController.
 * 
 * @version 1.0.
 * @created 2019/08/29 18:10:47.
 *
 */

@RestController
@RequestMapping(URLConstant.URL_EDP_LOOKUP)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPLuLookUpController {


	/** The service. */
	@Autowired
	private EDPLuLookUpService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPLuLookUpConverter converter;

	
	/**
	 * Fetch LuLookUps by given LuLookUps id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getLuLookUp(@RequestBody IdDto id) {
		EDPLuLookUpEntity entity = service.getLuLookUp(id.getId());
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));

	}

	/**
	 * creates a new LuLookUps
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createLuLookUp(@RequestBody EDPLuLookUpDto dto) {

		EDPLuLookUpEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateLuLookUp(entity)));

	}

	/**
	 * Update the LuLookUps
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateLuLookUp(@RequestBody EDPLuLookUpDto dto) {

		EDPLuLookUpEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateLuLookUp(entity)));
	}

	

	/**
	 * Fetch all the LuLookUps items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLuLookUpDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse>  getLuLookUps(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPLuLookUpDto> data = service.edpLuLookUpAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,data);
	}

}
