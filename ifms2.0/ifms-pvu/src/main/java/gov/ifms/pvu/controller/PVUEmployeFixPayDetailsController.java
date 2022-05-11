package gov.ifms.pvu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUEmployeFixPayDetailsConverter;
import gov.ifms.pvu.dto.PVUEmployeFixPayDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;
import gov.ifms.pvu.service.PVUEmployeFixPayDetailsService;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeFixPayDetailsController.
 * 
 * @version v 1.0.
 * @created 2020/01/08 20:46:39.
 *
 */
@RestController
@RequestMapping(PvuConstant.URL_PVU_EMPLOYEFIXPAYDETAILS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeFixPayDetailsController {

	/** The service. */
	@Autowired
	private PVUEmployeFixPayDetailsService service;

	/** The converter. */
	@Autowired
	private PVUEmployeFixPayDetailsConverter converter;

	/**
	 * Fetch EmployeFixPayDetailss by given EmployeFixPayDetailss id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeFixPayDetails(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				service.getEmployeFixPay(id.getId()));
	}

	/**
	 * creates a new EmployeFixPayDetailss
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeFixPayDetails(@RequestBody PVUEmployeFixPayDetailsDto dto) {
		PVUEmployeFixPayDetailsEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateEmployeFixPayDetails(entity)));
	}

	/**
	 * Update the EmployeFixPayDetailss
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmployeFixPayDetails(@RequestBody PVUEmployeFixPayDetailsDto dto) {
		PVUEmployeFixPayDetailsEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateEmployeFixPayDetails(entity)));
	}



}
