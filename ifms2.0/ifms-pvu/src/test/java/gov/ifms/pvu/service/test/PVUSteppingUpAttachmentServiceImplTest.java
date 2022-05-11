package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.converter.PVUSteppingUpAttConverter;
import gov.ifms.pvu.dto.PVUSteppingUpAttDto;
import gov.ifms.pvu.entity.PVUSteppingUpAttEntity;
import gov.ifms.pvu.repository.PVUSteppingUpAttRepository;
import gov.ifms.pvu.service.PVUSteppingUpAttService;

class PVUSteppingUpAttachmentServiceImplTest {

	@InjectMocks
	private PVUSteppingUpAttService service;
	
	@Mock
	private PVUSteppingUpAttRepository repository;
	
	@Mock
	private PVUSteppingUpAttEntity entity;
	
	@Mock
	Page<PVUSteppingUpAttEntity> page;
	
	@Mock
	List<PVUSteppingUpAttEntity> lst;
	
	@Mock
	List<PVUSteppingUpAttDto> list;
	
	@Mock
	PVUSteppingUpAttConverter converter;
	
	@Mock
	List<PVUSteppingUpAttEntity> arrEntity;
	@Mock
	IdDto dto;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetRepository() {
		service.getRepository();
	}

	@Test
	void testGetConverter() {
		service.getConverter();
	}

	
	/**
	 * Test method for
	 * PVUSteppingUpAttService
	 */
	@Test
	void testSaveOrUpdateAttachments() {
		when(repository.save(entity)).thenReturn(entity);
	}

	@Test
	void testGetAttachmentByReferenceId() {
		when(this.repository.findAllByEntityStEventIdAndActiveStatus(1L, 1)).thenReturn(arrEntity );
		assertNotNull(service.getAttachmentByReferenceId(dto));
	}
	
	@Test
	void testUpdateStatusAsDelete() {
		Mockito.doNothing().when(repository).updateStatusAsDelete(1L,1);
		service.updateStatusAsDelete(dto);
	}

}
