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
import gov.ifms.edp.converter.EDPOfficeModuleConverter;
import gov.ifms.edp.dto.EDPOfficeModuleDto;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.edp.service.EDPOfficeModuleService;

/**
 * The Class EDPOfficeModuleController.
 * 
 * @version 1.0.
 * @created 2019/12/06 15:00:28.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_OFFICEMODULE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPOfficeModuleController {

	/** The service. */
	@Autowired
	private EDPOfficeModuleService service;

	/** The converter. */
	@Autowired
	private EDPOfficeModuleConverter converter;

	/**
	 * Fetch OfficeModules by given OfficeModules id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getOfficeModule(@RequestBody IdDto id) {
		EDPOfficeModuleEntity entity = service.getOfficeModule(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new OfficeModules.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createOfficeModule(@RequestBody EDPOfficeModuleDto dto) {
		EDPOfficeModuleEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateOfficeModule(entity)));
	}

	/**
	 * Update the OfficeModules.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateOfficeModule(@RequestBody EDPOfficeModuleDto dto) {
		EDPOfficeModuleEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateOfficeModule(entity)));
	}

	/**
	 * Deletes the OfficeModules for the given id.
	 *
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteOfficeModule(@RequestBody StatusDto statusDto) {
		service.deleteOfficeModule(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the OfficeModules items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPOfficeModuleDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getOfficeModules(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPOfficeModuleDto> data = service.getOfficeModules(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

}
