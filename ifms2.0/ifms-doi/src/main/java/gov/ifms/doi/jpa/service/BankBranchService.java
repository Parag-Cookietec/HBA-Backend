package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.BankBranchDTO;

/**
 * 
 * @author Sagar Jadhav
 *
 */

public interface BankBranchService {

	/**
	 * 
	 * @return
	 */
	public List<BankBranchDTO> getActiveBankBranchList();

	public List<BankBranchDTO> getActiveBankBranchListByBankId(Long bankId);

}
