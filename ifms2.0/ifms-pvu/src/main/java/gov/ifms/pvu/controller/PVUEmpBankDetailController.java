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
import gov.ifms.pvu.converter.PVUEmpBankDetailConverter;
import gov.ifms.pvu.dto.PVUEmpBankDetailDto;
import gov.ifms.pvu.entity.PVUEmpBankDetailEntity;
import gov.ifms.pvu.service.PVUEmpBankDetailService;

/**
 * The Class PVUEmpBankDetailController.
 * 
 * @version v 1.0.
 * @created 2020/05/28 17:22:19.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPBANKDETAIL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmpBankDetailController {

	/** The service. */
	@Autowired
	private PVUEmpBankDetailService service;

	/** The converter. */
	@Autowired
	private PVUEmpBankDetailConverter converter;

	/**
	 * Fetch EmpBankDetails by given EmpBankDetails id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getEmpBankDetail(@RequestBody IdDto id) {
		PVUEmpBankDetailEntity entity = service.getEmpBankDetail(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, this.converter.toDTO(entity));
	}

	/**
	 * creates a new EmpBankDetails.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createEmpBankDetail(@RequestBody PVUEmpBankDetailDto dto) {
		PVUEmpBankDetailEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateEmpBankDetail(entity)));
	}

	/**
	 * Update the EmpBankDetails.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateEmpBankDetail(@RequestBody PVUEmpBankDetailDto dto) {
		PVUEmpBankDetailEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateEmpBankDetail(entity)));
	}

	/**
	 * Gets the emp bank details.
	 *
	 * @param pageDetail the page detail
	 * @return the emp bank details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getEmpBankDetails(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PVUEmpBankDetailDto> data = service.getEmpBankDetails(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, data);
	}

}
