package gov.ifms.doi.jpa.controller;


import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_CLAIM_ENTERY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_CLAIM_ENTERY_BY_ID;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_CLAIM_ENTERY_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_CLAIM_ENTERY_LISTING_BY_STATUS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.dto.DoiJPAClaimEntryDTO;
import gov.ifms.doi.jpa.service.DoiJPAClaimEntryService;
import javassist.NotFoundException;

/**
 * 
 * @author Sagar Patil
 *
 */
@RestController
public class DoiJpaClaimEntryController {

	@Autowired
	DoiJPAClaimEntryService doiJPAClaimEntryService;

	/**
	 * creates a new claim entry
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(value = JPA_CLAIM_ENTERY, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdateMasterPolicy(@RequestBody DoiJPAClaimEntryDTO dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Record added Successfully", doiJPAClaimEntryService.saveOrUpdate(dto));
	}
	
	@Trace
	@PostMapping(value = JPA_CLAIM_ENTERY_LISTING, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> findAllByCriteria(@RequestBody DoiJPAClaimEntryDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, doiJPAClaimEntryService.findAllByCriteria(dto));
	}
	
	@Trace
	@GetMapping(value = JPA_CLAIM_ENTERY_LISTING_BY_STATUS)
	public ResponseEntity<ApiResponse> findAllByClaimStatus(@RequestParam(value="claimStatus") String claimStatus) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, doiJPAClaimEntryService.findAllByClaimStatus(claimStatus));
	}
	@Trace
	@GetMapping(value = JPA_CLAIM_ENTERY_BY_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> findClaimById(@PathVariable("claimId") Long claimId) throws NotFoundException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, doiJPAClaimEntryService.findClaimById(claimId));
	}
	
}
