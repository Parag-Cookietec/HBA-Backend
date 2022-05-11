/**
 * 
 */
package gov.ifms.doi.hba.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CLAIM_REJECT_ENTRY_DELETE;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CLAIM_REJECT_ENTRY_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CLAIM_REJECT_ENTRY_LISTING_BY_STATUS;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.HBA_CLAIM_REJECT_ENTRY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.hba.dto.TdoiHbaClaimRejectDTO;
import gov.ifms.doi.hba.service.TdoiHbaClaimRejectService;

/**
 * @author Sagar Jadhav
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiHbaClaimRejectController {

	@Autowired
	TdoiHbaClaimRejectService service;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = HBA_CLAIM_REJECT_ENTRY, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiHbaClaimRejectDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}

	/**
	 * Fetch all the schemes
	 * 
	 * @param dto
	 * @return all the schemes
	 */
	@Trace
	@PostMapping(value = CLAIM_REJECT_ENTRY_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAll(@RequestBody TdoiHbaClaimRejectDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByCriteria(dto));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Trace
	@DeleteMapping(value = CLAIM_REJECT_ENTRY_DELETE, produces = CONTENT_TYPE_APP_JSON)
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
	@PostMapping(value = CLAIM_REJECT_ENTRY_LISTING_BY_STATUS, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiHbaClaimRejectDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}

}
