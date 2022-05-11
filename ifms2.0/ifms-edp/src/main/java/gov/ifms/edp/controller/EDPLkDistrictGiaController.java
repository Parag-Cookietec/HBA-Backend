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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPLkDistrictGiaConverter;
import gov.ifms.edp.dto.EDPLkDistrictGiaDto;
import gov.ifms.edp.entity.EDPLkDistrictGiaEntity;
import gov.ifms.edp.service.EDPLkDistrictGiaService;

/**
 * The Class EDPLkDistrictGiaController.
 * 
 * @version v 1.0.
 * @created 2020/07/07 11:40:45.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_LKDISTRICTGIA)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPLkDistrictGiaController {

	/** The service. */
	@Autowired
	private EDPLkDistrictGiaService service;

	/** The converter. */
	@Autowired
	private EDPLkDistrictGiaConverter converter;

	/**
	 * Fetch LkDistrictGias by given LkDistrictGias id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getLkDistrictGia(@RequestBody IdDto id) {
		EDPLkDistrictGiaEntity entity = service.getLkDistrictGia(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new LkDistrictGias
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createLkDistrictGia(@RequestBody EDPLkDistrictGiaDto dto) {
		EDPLkDistrictGiaEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateLkDistrictGia(entity)));
	}

	/**
	 * Update the LkDistrictGias
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateLkDistrictGia(@RequestBody EDPLkDistrictGiaDto dto) {
		EDPLkDistrictGiaEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateLkDistrictGia(entity)));
	}

	/**
	 * Gets the lk district gias.
	 *
	 * @param pageDetail the page detail
	 * @return the lk district gias
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getLkDistrictGias(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPLkDistrictGiaDto> data = service.getLkDistrictGias(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, data);
	}

}
