package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.exception.CustomException;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPUsrPoTrnsAttItrConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsAttachmentRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsAttItrRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsAttRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsUPMappingAttachmentServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsUPMappingAttachmentServiceImplTest {
	
	/** The edp usr po trns att repository. */
	@Mock
	private EDPUsrPoTrnsAttRepository edpUsrPoTrnsAttRepository;
	
	/** The edp lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;
	
	/** The edp usr po trns att itr repository. */
	@Mock
	private EDPUsrPoTrnsAttItrRepository edpUsrPoTrnsAttItrRepository;
	
	/** The edp ms attachment repository. */
	@Mock
	private EDPMsAttachmentRepository edpMsAttachmentRepository;
	
	/** The list entity. */
	@Mock
	private List<EDPUsrPoTrnsAttEntity> listEntity;
	
	/** The look up info list. */
	@Mock
	private List<EDPLuLookUpInfoEntity> lookUpInfoList;
	
	/** The edp usr po trns att entity. */
	@Mock
	private EDPUsrPoTrnsAttEntity edpUsrPoTrnsAttEntity;
	
	/** The edp usr po trns entity. */
	@Mock
	private EDPUsrPoTrnsEntity edpUsrPoTrnsEntity;
	
	/** The edp usr po trns header entity. */
	@Mock
	private EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHeaderEntity;
	
	/** The edp usr po trns att itr converter. */
	@Mock
	private EDPUsrPoTrnsAttItrConverter edpUsrPoTrnsAttItrConverter;
	
	/** The multipart file. */
	@Mock
	private MultipartFile multipartFile;
	
	/** The service. */
	@InjectMocks
	private EDPMsUPMappingAttachmentServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test find attachment by attachment type.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testFindAttachmentByAttachmentType() throws CustomException {
		when(edpUsrPoTrnsAttRepository.findAllByEdpUsrPoTranAttIdAndEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE))
						.thenReturn(listEntity);
		assertNotNull(service.findAttachmentByAttachmentType(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE));
		verify(edpUsrPoTrnsAttRepository, times(1))
				.findAllByEdpUsrPoTranAttIdAndEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(JunitConstants.LONG_TYPE,
						JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE);
	}

	/**
	 * Test find attachment by user post transfer id.
	 */
	@Test
	void testFindAttachmentByUserPostTransferId() {
		when(edpUsrPoTrnsAttRepository.findAllByEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(JunitConstants.LONG_TYPE,
				EDPConstant.ACTIVE_STATUS_TRUE)).thenReturn(listEntity);
		assertNotNull(service.findAttachmentByUserPostTransferId(JunitConstants.LONG_TYPE));
		verify(edpUsrPoTrnsAttRepository, times(1)).findAllByEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(
				JunitConstants.LONG_TYPE, EDPConstant.ACTIVE_STATUS_TRUE);
	}

	/**
	 * Test create UP mapping attachment.
	 *
	 * @throws Exception the exception
	 */
	void testCreateUPMappingAttachment() throws Exception {
		List<EDPUsrPoTrnsAttEntity> listEntity1 = new ArrayList<>();
		listEntity1.add(edpUsrPoTrnsAttEntity);
		when(edpUsrPoTrnsAttEntity.getFile()).thenReturn(multipartFile);
		edpUsrPoTrnsHeaderEntity.setEdpUsrPoTrnsHeaderId(null);
		when(edpUsrPoTrnsAttEntity.getEdpUsrPoTrnsHeadrId()).thenReturn(edpUsrPoTrnsHeaderEntity);
		when(edpUsrPoTrnsEntity.getEdpUsrPoTrnsId()).thenReturn(JunitConstants.LONG_TYPE);
		when(multipartFile.getOriginalFilename()).thenReturn(JunitConstants.FILENAME);
		when(multipartFile.getBytes()).thenReturn(JunitConstants.STRING_TYPE.getBytes());
		assertNotNull(service.createUPMappingAttachment(listEntity1));
	}

	/**
	 * Test delete UP mapping attachment.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteUPMappingAttachment() throws CustomException {
		when(edpUsrPoTrnsAttRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpUsrPoTrnsAttEntity));
		when(edpUsrPoTrnsAttEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		service.deleteUPMappingAttachment(JunitConstants.LONG_TYPE);
		when(edpUsrPoTrnsAttRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		when(edpUsrPoTrnsAttEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE_68);
		service.deleteUPMappingAttachment(JunitConstants.LONG_TYPE);
		verify(edpUsrPoTrnsAttRepository).save(edpUsrPoTrnsAttEntity);
	}

	/**
	 * Test downloadcreate UP mapping attachment files.
	 *
	 * @throws CustomException the custom exception
	 */
	void testDownloadcreateUPMappingAttachmentFiles() throws CustomException {
		when(edpUsrPoTrnsAttRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpUsrPoTrnsAttEntity));
		when(edpUsrPoTrnsAttEntity.getUploadedFilePath()).thenReturn(JunitConstants.FILEPATH);
		assertNotNull(service.downloadcreateUPMappingAttachmentFiles(JunitConstants.LONG_TYPE));
		when(edpUsrPoTrnsAttRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(service.downloadcreateUPMappingAttachmentFiles(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get all attechments for post transfer.
	 */
	@Test
	void testGetAllAttechmentsForPostTransfer() {
		when(edpLuLookUpInfoRepository.findByLookUpInfoNameIn(Mockito.anySet())).thenReturn(lookUpInfoList);
		assertNotNull(service.getAllAttechmentsForPostTransfer());
	}

}
