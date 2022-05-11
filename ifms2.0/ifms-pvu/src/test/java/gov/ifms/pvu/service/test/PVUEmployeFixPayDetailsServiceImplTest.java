package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.pvu.converter.PVUEmployeFixPayDetailsConverter;
import gov.ifms.pvu.dto.PVUEmployeFixPayDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;
import gov.ifms.pvu.repository.PVUEmployeFixPayDetailsRepository;
import gov.ifms.pvu.service.PVUEmployeFixPayDetailsServiceImpl;

class PVUEmployeFixPayDetailsServiceImplTest {

	@InjectMocks
	private PVUEmployeFixPayDetailsServiceImpl service;

	@Mock
	private PVUEmployeFixPayDetailsRepository repository;

	@Mock
	private PVUEmployeFixPayDetailsEntity entity;

	@Mock
	private PVUEmployeFixPayDetailsDto dto;

	@Mock
	private PVUEmployeFixPayDetailsConverter converter;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeFixPayDetails() {
		when(repository.getOne(1L)).thenReturn(entity);
		assertNotNull(service.getEmployeFixPayDetails(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateEmployeFixPayDetails() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateEmployeFixPayDetails(entity));
		verify(repository, times(1)).save(entity);
	}

	

	@Test
	void testGetEmployeFixPay() {
		when(repository.findOneByEmpIdEmpId(1l)).thenReturn(Optional.of(entity));
		service.getEmployeFixPay(1l);
	}

}
