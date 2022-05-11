package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.util.Constant;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMODPSTransactionConverter;
import gov.ifms.dmo.dto.DMODPSMainTransactionDto;
import gov.ifms.dmo.dto.DMODPSTransactionDto;
import gov.ifms.dmo.entity.DMODPSTransactionSubTypeEntity;
import gov.ifms.dmo.entity.DMODPSTransactionTypeEntity;
import gov.ifms.dmo.repository.DMODPSTransactionTypesRepository;
import gov.ifms.dmo.service.impl.DMODPSTransactionTypesServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class DMODPSTransactionTypesServiceTest {

	@InjectMocks
	DMODPSTransactionTypesServiceImpl service;

	@Mock
	DMODPSTransactionTypesRepository repository;

	@Mock
	DMODPSTransactionConverter converter;

	@Mock
	DMODPSTransactionTypeEntity entity;
	@Mock
	DMODPSTransactionSubTypeEntity subTypeEntity;

	@Mock
	DMODPSMainTransactionDto transactionDto;
	@Mock
	DMODPSTransactionDto txnDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get Transaction findById Success.
	 */
	@Test
	@DisplayName("Test NSSF Loan findById Success")
	void testFindById() {
		DMODPSTransactionTypeEntity entity = new DMODPSTransactionTypeEntity();
		entity.setId(1L);
		entity.setTransactionType("NSSF");
		entity.setActiveStatus(1);
		DMODPSMainTransactionDto dto = new DMODPSMainTransactionDto();
		dto.setId(1L);
		dto.setTransactionType("NSSF");
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		dto = service.getTransactionsById(JunitConstants.LONG_TYPE);
		assertEquals("NSSF", dto.getTransactionType());

	}

	@Test
	@DisplayName("Test GetAllTransactions()")
	void testGetAllTransactions() {
		transactionDto = new DMODPSMainTransactionDto();
		transactionDto.setTransactionType("NSSF");
		txnDto = new DMODPSTransactionDto();
		subTypeEntity = new DMODPSTransactionSubTypeEntity();
		entity = new DMODPSTransactionTypeEntity();
		entity.setId(JunitConstants.LONG_TYPE);
		entity.setTransactionType("NSSF");
		entity.setActiveStatus(JunitConstants.INTEGER_TYPE);
		List<DMODPSTransactionSubTypeEntity> subTransactions = new ArrayList<DMODPSTransactionSubTypeEntity>();
		subTransactions.add(subTypeEntity);
		entity.setSubTransactions(subTransactions);
		List<DMODPSTransactionDto> transactionSubType = new ArrayList<DMODPSTransactionDto>();
		transactionSubType.add(txnDto);
		List<DMODPSTransactionTypeEntity> entities = new ArrayList<DMODPSTransactionTypeEntity>();
		entities.add(entity);
		when(repository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(entities);
		when(converter.toDTO(entity)).thenReturn(transactionDto);
		when(converter.toSubTypetransaction(entity.getSubTransactions())).thenReturn(transactionSubType);
		List<DMODPSMainTransactionDto> listMainTransactionDtos = service.getAllTransactions();
		assertEquals("NSSF", listMainTransactionDtos.get(0).getTransactionType());

	}

	@Test
	@DisplayName("Test GetAllTransactionsTypes()")
	void testGetAllTransactionsTypes() {
		transactionDto = new DMODPSMainTransactionDto();
		transactionDto.setTransactionType("NSSF");
		txnDto = new DMODPSTransactionDto();
		entity = new DMODPSTransactionTypeEntity();
		entity.setId(JunitConstants.LONG_TYPE);
		entity.setTransactionType("NSSF");
		entity.setActiveStatus(JunitConstants.INTEGER_TYPE);
		List<DMODPSTransactionDto> transactionSubType = new ArrayList<DMODPSTransactionDto>();
		transactionSubType.add(txnDto);
		List<DMODPSTransactionTypeEntity> entities = new ArrayList<DMODPSTransactionTypeEntity>();
		entities.add(entity);
		when(repository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(entities);
		when(converter.toDTO(entity)).thenReturn(transactionDto);
		List<DMODPSMainTransactionDto> listMainTransactionDtos = service.getAllTransactionsTypes();
		assertEquals("NSSF", listMainTransactionDtos.get(0).getTransactionType());

	}

}
