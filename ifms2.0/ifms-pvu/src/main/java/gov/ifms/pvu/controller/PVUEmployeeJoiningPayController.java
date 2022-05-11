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
import gov.ifms.pvu.converter.PVUEmployeeJoiningPayConverter;
import gov.ifms.pvu.dto.PVUEmployeeJoiningPayDto;
import gov.ifms.pvu.entity.PVUEmployeeJoiningPayEntity;
import gov.ifms.pvu.service.PVUEmployeeJoiningPayService;

/**
 * The Class PVUEmployeeJoiningPayController.
 * 
 * @version v 1.0.
 * @created 2020/05/15 11:25:19.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEEJOININGPAY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeeJoiningPayController {

	/** The service. */
	@Autowired
	private PVUEmployeeJoiningPayService service;

	/** The converter. */
	@Autowired
	private PVUEmployeeJoiningPayConverter converter;

	/**
	 * Fetch EmployeeJoiningPays by given EmployeeJoiningPays id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmployeeJoiningPay(@RequestBody IdDto id) {
		PVUEmployeeJoiningPayEntity entity = service.getEmployeeJoiningPay(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new EmployeeJoiningPays.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmployeeJoiningPay(@RequestBody PVUEmployeeJoiningPayDto dto) {
		PVUEmployeeJoiningPayEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateEmployeeJoiningPay(entity)));
	}

	/**
	 * Update the EmployeeJoiningPays.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmployeeJoiningPay(@RequestBody PVUEmployeeJoiningPayDto dto) {
		PVUEmployeeJoiningPayEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateEmployeeJoiningPay(entity)));
	}

	/**
	 * Gets the employee joining pays.
	 *
	 * @param pageDetail the page detail
	 * @return the employee joining pays
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getEmployeeJoiningPays(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeeJoiningPayDto> data = service.getEmployeeJoiningPays(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, data);
	}

}
