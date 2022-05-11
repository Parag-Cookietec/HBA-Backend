/**
 * 
 */
package gov.ifms.doi.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingRequestDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.service.DoiJpaClaimListingService;

/**
 * @author Rudra
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoiJpaClaimListingController {
	
	@Autowired
	DoiJpaClaimListingService service;
	
	@Trace
	@PostMapping(DoiJPAConstants.DOI_JPA_CLAIM_LISTING_BASE_URL)
	public ResponseEntity<ApiResponse> getJPAReceivedApplicationListing(@RequestBody DoiJpaClaimListingRequestDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getJPAClaimListing(dto));
	}
	
	@Trace
	@PostMapping(DoiJPAConstants.DOI_JPA_CLAIM_LISTING)
	public ResponseEntity<ApiResponse> getJPAReceivedApplicationListingPage(@RequestBody PageDetails pageDetail) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getJPAClaimListingPage(pageDetail));
	}
}
