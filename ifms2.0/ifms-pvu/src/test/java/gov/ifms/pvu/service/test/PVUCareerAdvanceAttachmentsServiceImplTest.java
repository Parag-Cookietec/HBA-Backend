package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.pvu.dto.PVUCareerAdvanceAttachmentsDto;
import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;
import gov.ifms.pvu.repository.PVUCareerAdvanceAttachmentsRepository;
import gov.ifms.pvu.service.PVUCareerAdvanceAttachmentsServiceImpl;


class PVUCareerAdvanceAttachmentsServiceImplTest {

	@Mock
	private PVUCareerAdvanceAttachmentsRepository repository;

	@InjectMocks
	private PVUCareerAdvanceAttachmentsServiceImpl pvuCareerAdvanceAttachmentsServiceImpl;

	@Mock
	private PVUCareerAdvanceAttachmentsEntity PVUCareerAdvanceAttachmentsEntity;

	@Mock
	private PVUCareerAdvanceAttachmentsDto dto;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetCareerAdvanceAttachments() {
		when(repository.getOne(1l)).thenReturn(PVUCareerAdvanceAttachmentsEntity);
		assertNotNull(pvuCareerAdvanceAttachmentsServiceImpl.getCareerAdvanceAttachments(1l));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateCareerAdvanceAttachments() {
		when(repository.save(PVUCareerAdvanceAttachmentsEntity)).thenReturn(PVUCareerAdvanceAttachmentsEntity);
		assertEquals(PVUCareerAdvanceAttachmentsEntity, pvuCareerAdvanceAttachmentsServiceImpl
				.saveOrUpdateCareerAdvanceAttachments(PVUCareerAdvanceAttachmentsEntity));
	}

}
