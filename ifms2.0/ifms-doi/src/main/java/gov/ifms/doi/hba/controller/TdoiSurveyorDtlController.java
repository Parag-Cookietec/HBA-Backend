package gov.ifms.doi.hba.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_HBA_SURVEYOR_MASTER_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_HBA_SURVEYOR_MASTER_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_HBA_TDOISURVEYORDTL_LISTING_BY_STATUS;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_HBA_TDOISURVEYORDTL_DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.hba.dto.TdoiSurveyorDtlDTO;
import gov.ifms.doi.hba.service.TdoiSurveyorDtlService;


@RestController
//@RequestMapping(DOI_JPA_HBA_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiSurveyorDtlController{

	@Autowired
	TdoiSurveyorDtlService service;


	@Trace
	@PostMapping(value = DOI_HBA_SURVEYOR_MASTER_ENTRY, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiSurveyorDtlDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}


	@Trace
	@PostMapping(value = DOI_HBA_SURVEYOR_MASTER_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByFilter(@RequestBody TdoiSurveyorDtlDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByCriteria(dto));
	}

	@Trace
	@GetMapping(value = DOI_HBA_SURVEYOR_MASTER_LISTING)
	public ResponseEntity<ApiResponse> getAll() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByCriteria());
	}

	@Trace
	@DeleteMapping(value = DOI_JPA_HBA_TDOISURVEYORDTL_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> softDeleteById(@RequestParam(name = "id") Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, service.softDeleteById(id));
	}


	@Trace
	@PostMapping(value = DOI_JPA_HBA_TDOISURVEYORDTL_LISTING_BY_STATUS, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiSurveyorDtlDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}

}

