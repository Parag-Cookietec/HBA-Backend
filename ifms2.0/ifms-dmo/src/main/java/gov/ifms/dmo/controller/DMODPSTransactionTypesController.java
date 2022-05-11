package gov.ifms.dmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMODPSMainTransactionDto;
import gov.ifms.dmo.service.DMODPSTransactionTypesService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMODPSTransactionTypesController.
 * 
 * @version v 2.0.
 * @created 2021/07/10 15:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.MAIN_TRANSACTION_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODPSTransactionTypesController {
	

	@Autowired
	DMODPSTransactionTypesService transactionTypesService;
	
	/**
	 * Fetch all the MainTransactions.
	 *
	 * @param pageDetail the page detail
	 * @return List<MainTransactionDto> include all subType of transactions
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getTransactionsById(@RequestBody IdDto id) {
		DMODPSMainTransactionDto data = transactionTypesService.getTransactionsById(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH, data);
	}


	/**
	 * Gets the all Transactions.
	 *
	 * @return the all Transactions
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_ALL_ACTIVE_TRANSACTION)
	public ResponseEntity<ApiResponse> getAllTransactions() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, transactionTypesService.getAllTransactions());
	}
	
	@Trace
	@PostMapping(DMOURLConstant.URL_ALL_ACTIVE_TRANSACTION_TYPES)
	public ResponseEntity<ApiResponse> getAllTransactionsTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH,
				transactionTypesService.getAllTransactionsTypes());
	}

}
