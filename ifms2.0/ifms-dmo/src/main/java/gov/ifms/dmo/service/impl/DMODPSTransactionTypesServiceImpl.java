package gov.ifms.dmo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.util.Constant;
import gov.ifms.dmo.converter.DMODPSTransactionConverter;
import gov.ifms.dmo.dto.DMODPSMainTransactionDto;
import gov.ifms.dmo.entity.DMODPSTransactionSubTypeEntity;
import gov.ifms.dmo.entity.DMODPSTransactionTypeEntity;
import gov.ifms.dmo.repository.DMODPSTransactionTypesRepository;
import gov.ifms.dmo.service.DMODPSTransactionTypesService;

@Service
public class DMODPSTransactionTypesServiceImpl implements DMODPSTransactionTypesService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DMODPSTransactionTypesRepository transactionTypesRepository;

	@Autowired
	DMODPSTransactionConverter converter;

	/**
	 * Fetch main Transactions with sub Transactions.
	 * 
	 * @param id fetch by transaction bye ID;
	 * @return DMODPSMainTransactionDto with list for corresponding subType Transaction.
	 */
	@Override
	public DMODPSMainTransactionDto getTransactionsById(Long id) {
		logger.info("getTransactionsById: start to fetch transaction by given Id: {}", id);
		DMODPSTransactionTypeEntity entity = transactionTypesRepository.getOne(id);
		DMODPSMainTransactionDto transactionDto = converter.toDTO(entity);
		List<DMODPSTransactionSubTypeEntity> activeSubTransactions = entity.getSubTransactions().stream()
				.filter(e -> e.getActiveStatus() == Constant.ACTIVE_STATUS).collect(Collectors.toList());
		transactionDto.setTransactionSubType(converter.toSubTypetransaction(activeSubTransactions));
		logger.info("getTransactionsById: sucessfully fetch transaction by given Id: {}", id);
		return transactionDto;

	}
	
	/**
	 * Fetch list of transactions 
	 * @return list of mainTransactions
	 */
	@Override
	public List<DMODPSMainTransactionDto> getAllTransactions() {
		logger.info("getAllTransactions: start to fetch transactions");
		List<DMODPSTransactionTypeEntity> entities = transactionTypesRepository
				.findByActiveStatus(Constant.ACTIVE_STATUS);
		List<DMODPSMainTransactionDto> transactionDtos = new ArrayList<>();
		entities.stream().forEach(entity -> {
			DMODPSMainTransactionDto transactionDto = converter.toDTO(entity);
			transactionDto.setTransactionSubType(converter.toSubTypetransaction(entity.getSubTransactions()));
			transactionDtos.add(transactionDto);
		});
		logger.info("getAllTransactions: end to fetch transactions");
		return transactionDtos;
	}
	@Override
	public List<DMODPSMainTransactionDto> getAllTransactionsTypes() {
		logger.info("getAllTransactions: start to fetch transactions");
		List<DMODPSTransactionTypeEntity> entities = transactionTypesRepository
				.findByActiveStatus(Constant.ACTIVE_STATUS);
		List<DMODPSMainTransactionDto> transactionDtos = new ArrayList<>();
		entities.stream().forEach(entity -> {
			DMODPSMainTransactionDto transactionDto = converter.toDTO(entity);
			transactionDtos.add(transactionDto);
		});
		logger.info("getAllTransactions: end to fetch transactions");
		return transactionDtos;
	}

}
