package gov.ifms.pvu.service.test;

import gov.ifms.pvu.converter.PVUShettyPayAttachmentConverter;
import gov.ifms.pvu.dto.PVUShettyPayAttachmentDto;
import gov.ifms.pvu.entity.PVUShettyPayAttachmentEntity;
import gov.ifms.pvu.repository.PVUShettyPayAttachmentRepository;
import gov.ifms.pvu.service.PVUShettyPayAttachmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import java.util.List;

class PVUShettyPayAttachmentServiceImplTest {

	@InjectMocks
	private PVUShettyPayAttachmentService service;
	
	@Mock
	private PVUShettyPayAttachmentRepository repository;
	
	@Mock
	private PVUShettyPayAttachmentEntity entity;
	
	@Mock
	Page<PVUShettyPayAttachmentEntity> page;
	
	@Mock
	List<PVUShettyPayAttachmentEntity> lst;
	
	@Mock
	List<PVUShettyPayAttachmentDto> list;
	
	@Mock
	PVUShettyPayAttachmentConverter converter;
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

	@SuppressWarnings("unchecked")
	@Test
	void testGetAttachmentByReferenceIdIdDto() {
//		when(dt.getId()).thenReturn(1l);
//		when(repository.findAllBySpIdIdAndActiveStatus(1l, 1)).thenReturn(lst);
//		service.getAttachmentByReferenceId(dt);
	}

}
