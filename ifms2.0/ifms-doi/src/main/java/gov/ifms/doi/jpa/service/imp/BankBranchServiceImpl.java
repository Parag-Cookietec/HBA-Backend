package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.BankBranchConverter;
import gov.ifms.doi.jpa.dto.BankBranchDTO;
import gov.ifms.doi.jpa.repository.BankBranchRepository;
import gov.ifms.doi.jpa.service.BankBranchService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class BankBranchServiceImpl implements BankBranchService {

	@Autowired
	BankBranchRepository bankBranchRepository;

	@Autowired
	BankBranchConverter converter;

	@Override
	public List<BankBranchDTO> getActiveBankBranchList() {
		return converter.toDtoListFromEntityList(bankBranchRepository.getActiveBankBranchList());
	}

	@Override
	public List<BankBranchDTO> getActiveBankBranchListByBankId(Long bankId) {
		return converter.toDtoListFromEntityList(bankBranchRepository.getActiveBankBranchListByBankId(bankId));
	}

}
