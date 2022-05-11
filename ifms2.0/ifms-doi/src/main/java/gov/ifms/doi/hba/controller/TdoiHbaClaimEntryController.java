/**
 * 
 */
package gov.ifms.doi.hba.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryListingDTO;
import gov.ifms.doi.hba.dto.TdoiHbaProposalListingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryDTO;
import gov.ifms.doi.hba.service.TdoiHbaClaimEntryService;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.*;

/**
 * @author Sagar Jadhav
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiHbaClaimEntryController {

	@Autowired
	TdoiHbaClaimEntryService service;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = HBA_CLAIM_ENTRY, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiHbaClaimEntryDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}

	/**
	 * Fetch all the schemes
	 *
	 *
	 * @return all the schemes
	 */
	@Trace
	@GetMapping(value = CLAIM_ENTRY_LISTING)
	public ResponseEntity<ApiResponse> getClaimEntryListing(@RequestBody PageDetails pageDetail) throws CustomException {
		try {
			PagebleDTO<TdoiHbaClaimEntryListingDTO> data = service.getClaimEntryListing(pageDetail);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, data);
		}catch (Exception ex){
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Trace
	@DeleteMapping(value = CLAIM_ENTRY_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> softDeleteById(@RequestParam(name = "id") Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE,
				service.softDeleteById(id));
	}

	/**
	 * 
	 * @param dto
	 * @return
	 */
	@Trace
	@PostMapping(value = CLAIM_ENTRY_SEND_FOR_PAYMENT, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiHbaClaimEntryDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}

}
