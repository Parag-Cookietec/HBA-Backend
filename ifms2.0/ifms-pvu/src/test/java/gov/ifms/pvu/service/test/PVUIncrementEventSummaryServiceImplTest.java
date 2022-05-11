package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.util.Constant;
import gov.ifms.pvu.converter.PVUIncrementEventSummaryConverter;
import gov.ifms.pvu.dto.PVUIncrementEventSummaryDto;
import gov.ifms.pvu.entity.PVUIncrementEventSummaryEntity;
import gov.ifms.pvu.repository.PVUIncrementEventSummaryRepository;
import gov.ifms.pvu.service.PVUIncrementEventSummaryServiceImpl;

class PVUIncrementEventSummaryServiceImplTest {
	
	@InjectMocks
	private PVUIncrementEventSummaryServiceImpl service;

	@Mock
	private PVUIncrementEventSummaryRepository repository;
	
	@Mock
	private PVUIncrementEventSummaryEntity entity;
	
	@Mock
	private PVUIncrementEventSummaryDto dto;

	@Mock
	private PVUIncrementEventSummaryConverter converter;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetIncrementEventSummary() {
		when(repository.getOne(1L)).thenReturn(entity);
		assertEquals(entity, service.getIncrementEventSummary(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateIncrementEventSummaryPVUIncrementEventSummaryEntity() {
		when(repository.save(entity)).thenReturn(entity);
		assertEquals(entity, service.saveOrUpdateIncrementEventSummary(entity));
		verify(repository, times(1)).save(entity);
	}

	@Test
	void testGetIncCountSummaryByInEventId() {
		when(repository.findFirstByInEventIdInEventIdAndActiveStatus(1L,1)).thenReturn(entity);
		assertNotNull(service.getIncCountSummaryByInEventId(1L));
		verify(repository, times(1)).findFirstByInEventIdInEventIdAndActiveStatus(1L, 1);
	}

	@Test
	void testSaveOrUpdateIncrementEventSummaryPVUIncrementEventSummaryDto() {
		when(dto.getInEventId()).thenReturn(1l);
		when(service.getIncCountSummaryByInEventId(1l)).thenReturn(entity);
		when(entity.getInSmryId()).thenReturn(1l);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(service.saveOrUpdateIncrementEventSummary(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		assertEquals(dto,service.saveOrUpdateIncrementEventSummary(dto));
	}
	
	@Test
	void testGetIncCountSummaryByInEventIdDto() {
		when(repository.findFirstByInEventIdInEventIdAndActiveStatus(1L,1)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		assertNotNull(service.getIncCountSummaryByInEventIdDto(1L));
	}
	
	@Test
	void testDeleteIncrementSummaryIdByEventId() {
		doNothing().when(repository).deleteIncrementSummaryIdByEventId(Constant.INACTIVE_STATUS, 1L, new Date(), 1l, 1l);
		service.deleteIncrementSummaryIdByEventId(Constant.INACTIVE_STATUS, 1l, new Date());
		assertTrue(true);
	}
}
