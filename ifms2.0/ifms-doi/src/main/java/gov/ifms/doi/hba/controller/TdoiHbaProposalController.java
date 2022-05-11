/**
 * 
 */
package gov.ifms.doi.hba.controller;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
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
import gov.ifms.doi.hba.dto.TdoiHbaProposalDTO;
import gov.ifms.doi.hba.service.TdoiHbaProposalService;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.*;

/**
 * @author Sagar Jadhav
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiHbaProposalController {

	@Autowired
	TdoiHbaProposalService service;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = HBA_POLICY_PROPOSAL_ENTRY, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiHbaProposalDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}

	/**
	 * Fetch all the schemes
	 * 
	 *
	 * @return all the schemes
	 */
	@Trace
	@GetMapping(value = POLICY_PROPOSAL_LISTING)
	public ResponseEntity<ApiResponse> getPolicyProposalListing(@RequestBody PageDetails pageDetail) throws CustomException {
		try {
			PagebleDTO<TdoiHbaProposalListingDTO> data = service.getPolicyProposalListing(pageDetail);
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, data);
		}catch (Exception ex){
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Fetch all the schemes
	 *
	 *
	 * @return all the schemes
	 */
	@Trace
	@GetMapping(value = "findAll")
	public ResponseEntity<ApiResponse> findAll() throws CustomException {
		try {
			List<TdoiHbaProposalDTO> data = service.findAllByCriteria();
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
	@DeleteMapping(value = POLICY_PROPOSAL_DELETE, produces = CONTENT_TYPE_APP_JSON)
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
	@PostMapping(value = POLICY_PROPOSAL_LISTING_BY_STATUS, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiHbaProposalDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}

	/**
	 * Fetch all the schemes
	 *
	 * @param loanAccountNo
	 * @return all the schemes
	 */
	@Trace
	@GetMapping(value = POLICY_PROPOSAL_EMPLOYEE_DETAILS)
	public ResponseEntity<ApiResponse> getEmployeeDetails(@RequestParam(name = "loanAccountNo") String loanAccountNo) throws CustomException {
		TdoiHbaProposalDTO proposalDto = service.getEmployeeDetails(loanAccountNo);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, proposalDto);
	}
}
