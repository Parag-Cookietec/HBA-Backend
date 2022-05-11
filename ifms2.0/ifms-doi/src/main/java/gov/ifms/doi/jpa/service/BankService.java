package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.BankDTO;

/**
 * 
 * @author Sagar Jadhav
 *
 */

public interface BankService {

	/**
	 * 
	 * @return
	 */
	public List<BankDTO> getActiveBankList();

}
