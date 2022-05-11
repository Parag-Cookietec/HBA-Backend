package gov.ifms.pvu.service.test;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import gov.ifms.common.dto.IdDto;
import gov.ifms.pvu.converter.PVUSuspensionAttachmentConverter;
import gov.ifms.pvu.dto.PVUSuspensionAttachmentDto;
import gov.ifms.pvu.entity.PVUSuspensionAttachmentEntity;
import gov.ifms.pvu.repository.PVUSuspensionAttachmentRepository;
import gov.ifms.pvu.service.PVUSuspensionAttachmentService;

class PVUSuspensionAttachmentServiceTest {
	@InjectMocks
	private PVUSuspensionAttachmentService  service;
	
	@Mock
	private PVUSuspensionAttachmentRepository repository;
	
	@Mock
	private PVUSuspensionAttachmentEntity entity;
	
	@Mock
	private Page<PVUSuspensionAttachmentEntity> page;
	
	@Mock
	private List<PVUSuspensionAttachmentEntity> lst;
	
	@Mock
	List<PVUSuspensionAttachmentDto> list;
	
	@Mock
	private PVUSuspensionAttachmentConverter converter;
	
	@Mock
	private IdDto dt;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testUpdateStatusAsDelete() {
		service.updateStatusAsDelete(dt);
	}

	@Test
	void testGetRepository() {
		service.getRepository();
	}

	@Test
	void testGetConverter() {
		service.getConverter();
	}

	@Test
	void testGetAttachmentByReferenceIdIdDto() {
		when(dt.getId()).thenReturn(1l);
		when(repository.findAllBySuspensionIdAndActiveStatus(1l, 1)).thenReturn(lst);
		service.getAttachmentByReferenceId(dt);
	}

}
