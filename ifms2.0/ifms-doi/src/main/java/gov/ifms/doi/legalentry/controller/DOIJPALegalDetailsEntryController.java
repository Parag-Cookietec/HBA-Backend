/**
 * 
 */
package gov.ifms.doi.legalentry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.constant.DoiJPAUrlConstants;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.legalentry.dto.DOIJPALegalDetailEntryDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalEntryForRequestDTO;
import gov.ifms.doi.legalentry.service.DOIJPALegalDetailsEntryService;


/**
 * @author Rudra
 *
 */
@RestController
@RequestMapping(DoiJPAUrlConstants.DOI_JPA_LEGAL_ENTRY_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DOIJPALegalDetailsEntryController {
	
	@Autowired
	DOIJPALegalDetailsEntryService service;
	
	/**
	 * creates a JPA Legal Entry Record
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(DoiJPAUrlConstants.DOI_JPA_LEGAL_ENTRY)
	public ResponseEntity<ApiResponse> saveOrUpdateDOIJPALegalEntry(@RequestBody DOIJPALegalDetailEntryDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdateDOIJPALegalEntry(dto));
	}
	
	@Trace
	@GetMapping(DoiJPAUrlConstants.DOI_GET_JPA_LEGAL_ENTRY)
	public ResponseEntity<ApiResponse> getDOIJPALegalEntry(@PathVariable ("legalEntryId") Long legalEntryId) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getDOIJPALegalEntry(legalEntryId));
	}
	
	@Trace
	@PostMapping(DoiJPAUrlConstants.DOI_JPA_LEGAL_ENTRY_LISTING)
	public ResponseEntity<ApiResponse> getJpaLegalEntryListingTest(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getJpaLegalEntryListing(pageDetail));
	}
	
	@Trace
	@PostMapping(DoiJPAUrlConstants.DOI_JPA_LEGAL_ENTRY_FOR_REQUEST)
	public ResponseEntity<ApiResponse> makeJpaLegalEntryforRequest(@RequestBody DOIJPALegalEntryForRequestDTO dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.makeJpaLegalEntryforRequest(dto));
	}
	
	@Trace
	@DeleteMapping(DoiJPAUrlConstants.DOI_JPA_DELETE_LEGAL_ENTRY_FOR_REQUEST)
	public ResponseEntity<ApiResponse> deleteJpaLegalEntryforRequest(@PathVariable ("legalDtlsId") Long legalDtlsId) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Record has been deleted", service.deleteJpaLegalEntryforRequest(legalDtlsId));
	}
	
	@Trace
	@PostMapping(DoiJPAUrlConstants.DOI_JPA_LEGAL_ENTRY_FOR_REQUEST_LISTING)
	public ResponseEntity<ApiResponse> makeJpaLegalEntryforRequestListing(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.makeJpaLegalEntryforRequestListing(pageDetail));
	}
	
	@Trace
	@PostMapping(DoiJPAUrlConstants.DOI_JPA_LEGAL_CLAIM_LISTING)
	public ResponseEntity<ApiResponse> getJPAReceivedApplicationListingPage(@RequestBody PageDetails pageDetail) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.getJPALegalClaimListingPage(pageDetail));
	}
}
