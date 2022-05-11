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
import gov.ifms.edp.converter.EDPMsBankIfscConverter;
import gov.ifms.edp.dto.EDPMsBankIfscDto;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.edp.service.EDPMsBankIfscService;

/**
 * The Class EDPMsBankIfscController.
 * 
 * @version v 1.0.
 * @created 2020/05/28 17:17:24.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSBANKIFSC)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsBankIfscController {

	/** The service. */
	@Autowired
	private EDPMsBankIfscService service;

	/** The converter. */
	@Autowired
	private EDPMsBankIfscConverter converter;

	/**
	 * Fetch MsBankIfscs by given MsBankIfscs id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsBankIfsc(@RequestBody IdDto id) {
		EDPMsBankIfscEntity entity = service.getMsBankIfsc(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsBankIfscs.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsBankIfsc(@RequestBody EDPMsBankIfscDto dto) {
		EDPMsBankIfscEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsBankIfsc(entity)));
	}

	/**
	 * Update the MsBankIfscs.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsBankIfsc(@RequestBody EDPMsBankIfscDto dto) {
		EDPMsBankIfscEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsBankIfsc(entity)));
	}

	
	/**
	 * Gets the ms bank ifscs.
	 *
	 * @param pageDetail the page detail
	 * @return the ms bank ifscs
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsBankIfscs(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsBankIfscDto> data = service.getMsBankIfscs(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, data);
	}

}
