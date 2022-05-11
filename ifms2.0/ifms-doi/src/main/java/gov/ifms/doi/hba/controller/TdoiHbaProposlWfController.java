/**
 * 
 */
package gov.ifms.doi.hba.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.HBA_POLICY_PROPOSAL_ENTRY_WF;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.POLICY_PROPOSAL_DELETE_WF;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.POLICY_PROPOSAL_LISTING_BY_STATUS_WF;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.POLICY_PROPOSAL_LISTING_WF;

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
import gov.ifms.doi.hba.dto.TdoiHbaProposlWfDTO;
import gov.ifms.doi.hba.service.TdoiHbaProposlWfService;

/**
 * @author Sagar Jadhav
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiHbaProposlWfController {

	@Autowired
	TdoiHbaProposlWfService service;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = HBA_POLICY_PROPOSAL_ENTRY_WF, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiHbaProposlWfDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}

	/**
	 * Fetch all the schemes
	 * 
	 * @param dto
	 * @return all the schemes
	 */
	@Trace
	@PostMapping(value = POLICY_PROPOSAL_LISTING_WF, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAll(@RequestBody TdoiHbaProposlWfDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByCriteria(dto));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Trace
	@DeleteMapping(value = POLICY_PROPOSAL_DELETE_WF, produces = CONTENT_TYPE_APP_JSON)
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
	@PostMapping(value = POLICY_PROPOSAL_LISTING_BY_STATUS_WF, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiHbaProposlWfDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}
}
