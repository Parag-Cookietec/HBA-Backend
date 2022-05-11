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
import gov.ifms.edp.converter.EDPMsBillConverter;
import gov.ifms.edp.dto.EDPMsBillDto;
import gov.ifms.edp.entity.EDPMsBillEntity;
import gov.ifms.edp.service.EDPMsBillService;

/**
 * The Class EDPMsBillController.
 * 
 * @version 1.0.
 * @created 2020/01/29 17:03:45.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MSBILL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsBillController {

	/** The service. */
	@Autowired
	private EDPMsBillService service;

	/** The converter. */
	@Autowired
	private EDPMsBillConverter converter;

	/**
	 * Fetch MsBills by given MsBills id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsBill(@RequestBody IdDto id) {
		EDPMsBillEntity entity = service.getMsBill(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new MsBills
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsBill(@RequestBody EDPMsBillDto dto) {
		EDPMsBillEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsBill(entity)));
	}

	/**
	 * Update the MsBills
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsBill(@RequestBody EDPMsBillDto dto) {
		EDPMsBillEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsBill(entity)));
	}

	/**
	 * Deletes the MsBills for the given id
	 * 
	 * @param statusDto to delete.
	 * @return the api response
	 */
	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteMsBill(@RequestBody StatusDto statusDto) {
		service.deleteMsBill(statusDto.getId(), statusDto.getActiveStatus());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	/**
	 * Fetch all the MsBills items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsBillDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsBills(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<EDPMsBillDto> data = service.getMsBills(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, data);
	}

	/**
	 * Gets the all ms bill.
	 *
	 * @return the all ms bill
	 */
	@Trace
	@PostMapping(URLConstant.URL_ALL_ACTIVE_BILLS)
	public ResponseEntity<ApiResponse> getAllMsBill() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.findAllBills());
	}

}
