package gov.ifms.pvu.controller;

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
import gov.ifms.pvu.converter.PVURegistryConverter;
import gov.ifms.pvu.dto.PVURegistryDto;
import gov.ifms.pvu.entity.PVURegistryEntity;
import gov.ifms.pvu.service.PVURegistryService;

/**
 * The Class PVURegistryController.
 * 
 * @version v 1.0.
 * @created 2020/01/12 12:05:26.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_REGISTRY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVURegistryController {

	/** The service. */
	@Autowired
	private PVURegistryService service;

	/** The converter. */
	@Autowired
	private PVURegistryConverter converter;

	/**
	 * Fetch Registrys by given Registrys id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getRegistry(@RequestBody IdDto id) {
		PVURegistryEntity entity = service.getRegistry(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new Registrys
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createRegistry(@RequestBody PVURegistryDto dto) {
		PVURegistryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateRegistry(entity)));
	}

	/**
	 * Update the Registrys
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateRegistry(@RequestBody PVURegistryDto dto) {
		PVURegistryEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateRegistry(entity)));
	}

	
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getRegistrys(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVURegistryDto> data = service.getRegistrys(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, data);
	}

}
