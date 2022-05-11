package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.converter.PVUMsEventConverter;
import gov.ifms.pvu.dto.PVUMsEventDto;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.repository.PVUMsEventRepository;
import gov.ifms.pvu.service.PVUMsEventServiceImpl;

class PVUMsEventServiceImplTest {
	@InjectMocks
	private PVUMsEventServiceImpl  service;
	
	@Mock
	private PVUMsEventRepository repository;
	
	@Mock
	private PVUMsEventEntity entity;
	
	@Mock
	Page<PVUMsEventEntity> page;
	
	@Mock
	List<PVUMsEventEntity> lst;
	
	@Mock
	List<PVUMsEventDto> list;
	
	@Mock
	PVUMsEventConverter converter;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testGetEventById() throws CustomException {
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		assertNotNull(service.getEventById(1L));
		verify(repository,times(1)).findById(1l);
	}

	@Test
	void testSaveOrUpdateMasterEvent() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMasterEvent(entity));
		verify(repository,times(1)).save(entity);
	}

	@Test
	void testGetAllEvents() {
		when(repository.findAllByActiveStatus(1)).thenReturn(lst);
		assertNotNull(service.getAllEvents());
		
	}

	@Test
	void testGetPayFixationEvents() {
		when(repository.findAllByScreenTypeAndActiveStatus(8,1)).thenReturn(lst);
		assertNotNull(service.getPayFixationEvents());
	}

	@Test
	void testGetPvuEvents() {
		when(repository.findAllByScreenTypeAndActiveStatus(9,1)).thenReturn(lst);
		assertNotNull(service.getPvuEvents());
	}

}
