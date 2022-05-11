package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.util.Constant;
import gov.ifms.pvu.converter.PVUIncrementEmpConverter;
import gov.ifms.pvu.dto.PVUIncrementEmpDto;
import gov.ifms.pvu.entity.PVUIncrementEmpEntity;
import gov.ifms.pvu.repository.PVUIncrementEmpRepository;
import gov.ifms.pvu.service.PVUIncrementEmpServiceImpl;

class PVUIncrementEmpServiceImplTest {
	
	@InjectMocks
	private PVUIncrementEmpServiceImpl service;
	
	@Mock
	private PVUIncrementEmpRepository repository;


	@Mock
	private PVUIncrementEmpConverter converter;
	
	@Mock
	private PVUIncrementEmpEntity entity;
	
	@Mock
	private List<PVUIncrementEmpEntity> lstEntity;
	
	@Mock
	private List<PVUIncrementEmpDto> lstPVUIncrementEmpDto;


	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetIncrementEmp() {
		when(repository.getOne(1l)).thenReturn(entity);
		assertNotNull(service.getIncrementEmp(1l));
		
	}

	@Test
	public void testSaveOrUpdateIncrementEmpPVUIncrementEmpEntity() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateIncrementEmp(entity));
	}



	@Test
	public  void testSaveOrUpdateIncrementEmpListOfPVUIncrementEmpEntity() {
		when(repository.saveAll(lstEntity)).thenReturn(lstEntity);
		assertNotNull(service.saveOrUpdateIncrementEmp(lstEntity));
	}

	@Test
	public void testSaveOrUpdateIncrementEmpListOfPVUIncrementEmpDtoLong() {
		when(converter.toEntity(lstPVUIncrementEmpDto)).thenReturn(lstEntity);
		assertNotNull(service.saveOrUpdateIncrementEmpDto(lstPVUIncrementEmpDto));
	}

	@Test
	public void testGetIncrementEmpByEventId() {
		when(repository.findAllByInEventIdInEventId(1l)).thenReturn(lstEntity);
		when(lstEntity.isEmpty()).thenReturn(false);
		when(converter.toDTO(lstEntity)).thenReturn(lstPVUIncrementEmpDto);
		assertNotNull(service.getIncrementEmpByEventId(1l));
	}
	
	@Test
	public void deleteIncrementEmpIdByEventId() {
		doNothing().when(repository).deleteIncrementEmptByInEventId(Constant.ACTIVE_STATUS, 1l, new Date(), 1l, 1l);
		service.deleteIncrementEmpIdByEventId(Constant.ACTIVE_STATUS, 1l, new Date());
		assertTrue(true);
	}

	@Test
	public void testDeleteIrrelevantEmployeeFromTransaction() {
		doNothing().when(repository).deleteIncrementEmptByInEventId(1l);
		service.deleteIrrelevantEmployeeFromTransaction(1l);
		verify(repository, times(1)).deleteIncrementEmptByInEventId(1L);
		assertTrue(true);
	}
}
