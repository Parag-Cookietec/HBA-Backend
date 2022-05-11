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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUIncrementEmpConverter;
import gov.ifms.pvu.dto.PVUIncrementEmpDto;
import gov.ifms.pvu.entity.PVUIncrementEmpEntity;
import gov.ifms.pvu.service.PVUIncrementEmpService;

/**
 * The Class PVUIncrementEmpController.
 * 
 * @version v 1.0.
 * @created 2020/01/12 19:19:14.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_INCREMENTEMP)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUIncrementEmpController {

	/** The service. */
	@Autowired
	private PVUIncrementEmpService service;

	/** The converter. */
	@Autowired
	private PVUIncrementEmpConverter converter;

	/**
	 * Fetch IncrementEmps by given IncrementEmps id
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getIncrementEmp(@RequestBody IdDto id) {
		PVUIncrementEmpEntity entity = service.getIncrementEmp(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new IncrementEmps
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createIncrementEmp(@RequestBody PVUIncrementEmpDto dto) {
		PVUIncrementEmpEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateIncrementEmp(entity)));
	}

	/**
	 * Update the IncrementEmps
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateIncrementEmp(@RequestBody PVUIncrementEmpDto dto) {
		PVUIncrementEmpEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateIncrementEmp(entity)));
	}
	
	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)  
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException {
        try {
    			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
        } catch (Exception e) {
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
	}
	
	
}
