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
import gov.ifms.edp.converter.EDPOfficeBillMapConverter;
import gov.ifms.edp.dto.EDPOfficeBillMapDto;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;
import gov.ifms.edp.service.EDPOfficeBillMapService;


/**
 * The Class EDPOfficeBillMapController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_OFFICEBILLMAP)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPOfficeBillMapController {
	
	/** The service. */
	@Autowired
	private EDPOfficeBillMapService service;
	
	/** The  converter. */
	@Autowired
	private EDPOfficeBillMapConverter converter;
	
	/**
	 * Fetch officeBillMaps by given officeBillMaps id .
	 *
	 * @param id the id
	 * @return  dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getofficeBillMap(@RequestBody IdDto id) {
        EDPOfficeBillMapEntity entity = service.getofficeBillMap(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
    }
	
	
	/**
	 * creates a new officeBillMaps.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createofficeBillMap( @RequestBody EDPOfficeBillMapDto dto) {
		EDPOfficeBillMapEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateofficeBillMap(entity)));
    }
	
	/**
	 * Update the officeBillMaps.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateofficeBillMap(@RequestBody EDPOfficeBillMapDto dto) {
        EDPOfficeBillMapEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateofficeBillMap(entity)));
	}
	
	/**
	 * Deletes the officeBillMaps for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteofficeBillMap(@RequestBody StatusDto statusDto) {
		service.deleteofficeBillMap(statusDto.getId() ,statusDto.getActiveStatus());	
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE,null);
	}
	
	/**
	 * Fetch all the officeBillMaps items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPofficeBillMapDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getofficeBillMaps(@RequestBody PageDetails pageDetail)throws CustomException {
		PagebleDTO<EDPOfficeBillMapDto> data = service.getofficeBillMaps(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}
	
}
