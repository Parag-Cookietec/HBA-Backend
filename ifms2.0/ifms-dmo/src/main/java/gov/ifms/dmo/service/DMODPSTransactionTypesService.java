package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.dmo.dto.DMODPSMainTransactionDto;


/**
 * The Class DMODPSTransactionTypesService.
 * 
 * @version v 2.0.
 * @created 2021/07/10 15:19:32
 *
 */
public interface DMODPSTransactionTypesService {

	/**
	 * Fetch main Transactions with sub Transactions.
	 * 
	 * @param id fetch by transaction bye ID;
	 * @return DMODPSMainTransactionDto with list for corresponding subType Transaction.
	 */
	DMODPSMainTransactionDto getTransactionsById(Long id);

	/**
	 * Fetch list of transactions 
	 * @return list of mainTransactions
	 */
	List<DMODPSMainTransactionDto> getAllTransactions();

	List<DMODPSMainTransactionDto> getAllTransactionsTypes();

	
}
