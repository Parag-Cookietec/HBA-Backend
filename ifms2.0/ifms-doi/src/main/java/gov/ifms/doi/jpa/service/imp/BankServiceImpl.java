package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.BankConverter;
import gov.ifms.doi.jpa.dto.BankDTO;
import gov.ifms.doi.jpa.repository.BankRepository;
import gov.ifms.doi.jpa.service.BankService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepository bankRepository;

	@Autowired
	BankConverter converter;

	@Override
	public List<BankDTO> getActiveBankList() {
		return converter.toDtoListFromEntityList(bankRepository.getActiveBankList());
	}

}
