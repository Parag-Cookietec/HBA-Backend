package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import gov.ifms.pvu.converter.PVUEmployeeEventStatusConverter;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUEmployeeEventStatusRepository;
import gov.ifms.pvu.service.PVUEmployeeEventStatusServiceImpl;

class PVUEmployeeEventStatusServiceImplTest {
	@InjectMocks
	private PVUEmployeeEventStatusServiceImpl  service;
	
	@Mock
	private PVUEmployeeEventStatusRepository repository;
	
	@Mock
	private PVUEmployeeEventStatusEntity entity;
	@Mock
	private PVUEmployeeEventStatusDto dto;
	
	@Mock
	Page<PVUEmployeeEventStatusEntity> page;
	
	@Mock
	List<PVUEmployeeEventStatusEntity> lst;
	
	@Mock
	List<PVUEmployeeEventStatusDto> list;
	
	@Mock
	PVUEmployeeEventStatusConverter converter;
	
	@Mock
	List<Long> lstEmpIncludeList;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testGetEmployeeEventStatus() {
		when(repository.getOne(1L)).thenReturn(entity);
		service.getEmployeeEventStatus(1l);
		verify(repository,times(1)).getOne(1l);
	}

	@Test
	void testSaveOrUpdateEmployeeEventStatus() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateEmployeeEventStatus(entity));
		verify(repository,times(1)).save(entity);
	}

	@Test
	void testFindByEmpId() {
		when(repository.findByEmpIdEmpId(1l)).thenReturn(Optional.of(entity));
		assertNotNull(service.findByEmpId(1l));
	}

	@Test
	void testGetEventStatus() {
		when(converter.toDTO(entity)).thenReturn(dto);
		when(dto.getEol()).thenReturn(1l);
		assertNotNull(service.getEventStatus(entity));
	}

	@Test
	void testResetIncEmployeeEventStatus() {
		service.resetIncEmployeeEventStatus(1l, new Date());
		assertTrue(true);
	}

	@Test
	void testGetEmployeeInProcessByEmpIds() {
		when(repository.findEmployeeInProgress(lstEmpIncludeList)).thenReturn(list);
		assertNotNull(service.getEmployeeInProcessByEmpIds(lstEmpIncludeList));
	}

	@Test
	void testUpdateEmployeeIncEventStatus() {
		service.updateEmployeeIncEventStatus("sa", lstEmpIncludeList);
		assertTrue(true);
	}

}
