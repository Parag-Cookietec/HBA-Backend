package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.exception.CustomException;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPAddDesigAttachementItrConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnAttachmentItrConverter;
import gov.ifms.edp.entity.EDPAddDesAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentItrEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.repository.EDPAddDesigAttachmentItrRepository;
import gov.ifms.edp.repository.EDPAddDesigAttachmentRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnAttachmentItrRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnAttachmentRepository;

/**
 * The Class EDPMsDesignationAttachmentServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsDesignationAttachmentServiceImplTest {
	
	/** The edp trn upd dsgn attachment repository. */
	@Mock
	private EDPTrnUpdDsgnAttachmentRepository edpTrnUpdDsgnAttachmentRepository;
	
	/** The edp trn upd dsgn attachment entity. */
	@Mock
	private EDPTrnUpdDsgnAttachmentEntity edpTrnUpdDsgnAttachmentEntity;
	
	/** The edp add des attachment entity. */
	@Mock
	private EDPAddDesAttachmentEntity edpAddDesAttachmentEntity;
	
	/** The edp trn upd dsgn entity. */
	@Mock
	private EDPTrnUpdDsgnEntity edpTrnUpdDsgnEntity;
	
	/** The edp add desig attachment repository. */
	@Mock
	private EDPAddDesigAttachmentRepository edpAddDesigAttachmentRepository;
	
	/** The edp trn upd dsgn attachment itr repository. */
	@Mock
	private EDPTrnUpdDsgnAttachmentItrRepository edpTrnUpdDsgnAttachmentItrRepository;
	
	/** The edp add desig attachment itr repository. */
	@Mock
	private EDPAddDesigAttachmentItrRepository edpAddDesigAttachmentItrRepository;
	
	/** The edp add desig attachement itr converter. */
	@Mock
	private EDPAddDesigAttachementItrConverter edpAddDesigAttachementItrConverter;
	
	/** The edp trn upd dsgn attachment itr converter. */
	@Mock
	private EDPTrnUpdDsgnAttachmentItrConverter edpTrnUpdDsgnAttachmentItrConverter;
	
	/** The trn upd dsgn attachment itr entities. */
	@Mock
	private List<EDPTrnUpdDsgnAttachmentItrEntity> trnUpdDsgnAttachmentItrEntities;
	
	/** The edp add des attachment entitylist. */
	@Mock
	List<EDPAddDesAttachmentEntity> edpAddDesAttachmentEntitylist;
	
	/** The entities. */
	@Mock
	private List<EDPTrnUpdDsgnAttachmentEntity> entities;
	
	/** The multipart file. */
	@Mock
	private MultipartFile multipartFile;
	
	/** The service. */
	@InjectMocks
	private EDPMsDesignationAttachmentServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test find update dsg attachment by id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testFindUpdateDsgAttachmentById() throws CustomException {
		when(edpTrnUpdDsgnAttachmentRepository.getOne(JunitConstants.LONG_TYPE))
				.thenReturn(edpTrnUpdDsgnAttachmentEntity);
		assertNotNull(service.findUpdateDsgAttachmentById(JunitConstants.LONG_TYPE));
		verify(edpTrnUpdDsgnAttachmentRepository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test find by tedp upd dsgn id and active status.
	 */
	@Test
	void testFindByTedpUpdDsgnIdAndActiveStatus() {
		when(edpTrnUpdDsgnAttachmentRepository.findByTrnUpdDsgnEntityTedpUpdDsgnIdAndActiveStatus(1l,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(entities);
		assertNotNull(service.findByTedpUpdDsgnIdAndActiveStatus(JunitConstants.LONG_TYPE));
		verify(edpTrnUpdDsgnAttachmentRepository, times(1)).findByTrnUpdDsgnEntityTedpUpdDsgnIdAndActiveStatus(
				JunitConstants.LONG_TYPE, OAuthConstant.ACTIVE_STATUS);
	}

	/**
	 * Test create add designation attachment.
	 *
	 * @throws Exception the exception
	 */
	void testCreateAddDesignationAttachment() throws Exception {
		List<EDPAddDesAttachmentEntity> edpAddDesAttachmentEntityList = new ArrayList<>();
		edpAddDesAttachmentEntityList.add(edpAddDesAttachmentEntity);
		when(edpAddDesAttachmentEntity.getFile()).thenReturn(multipartFile);
		when(multipartFile.getOriginalFilename()).thenReturn(JunitConstants.FILENAME);
		when(multipartFile.getBytes()).thenReturn(JunitConstants.STRING_TYPE.getBytes());
		when(edpAddDesAttachmentEntity.getFileName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpAddDesAttachmentEntity.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.createAddDesignationAttachment(edpAddDesAttachmentEntityList));
		when(edpAddDesAttachmentEntity.getFileName()).thenReturn(JunitConstants.STRING_NULL);
		assertNotNull(service.createAddDesignationAttachment(edpAddDesAttachmentEntityList));
	}

	/**
	 * Test delete add designation attachment.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteAddDesignationAttachment() throws CustomException {
		when(edpAddDesigAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpAddDesAttachmentEntity));
		when(Optional.of(edpAddDesAttachmentEntity).get().getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(edpAddDesigAttachmentRepository.save(Optional.of(edpAddDesAttachmentEntity).get()))
				.thenReturn(edpAddDesAttachmentEntity);
		service.deleteAddDesignationAttachment(JunitConstants.LONG_TYPE);
		verify(edpAddDesigAttachmentRepository, times(1)).findById(JunitConstants.LONG_TYPE);
		verify(edpAddDesigAttachmentRepository, times(1)).save(Optional.of(edpAddDesAttachmentEntity).get());
		when(edpAddDesigAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		when(Optional.of(edpAddDesAttachmentEntity).get().getActiveStatus()).thenReturn(0);
		service.deleteAddDesignationAttachment(JunitConstants.LONG_TYPE);
		verify(edpAddDesigAttachmentRepository, times(2)).findById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test download add designation files.
	 *
	 * @throws Exception the exception
	 */
	void testDownloadAddDesignationFiles() throws Exception {
		when(edpAddDesigAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpAddDesAttachmentEntity));
		when(edpAddDesAttachmentEntity.getUploadedFilePath()).thenReturn(JunitConstants.FILEPATH);
		assertNotNull(service.downloadAddDesignationFiles(JunitConstants.LONG_TYPE));
		when(edpAddDesigAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(service.downloadAddDesignationFiles(JunitConstants.LONG_TYPE));
		verify(edpAddDesigAttachmentRepository, times(2)).findById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test create post attachment.
	 *
	 * @throws Exception the exception
	 */
	void testCreatePostAttachment() throws Exception {
		List<EDPTrnUpdDsgnAttachmentEntity> trnUpdDsgnAttachmentEntityList = new ArrayList<>();
		trnUpdDsgnAttachmentEntityList.add(edpTrnUpdDsgnAttachmentEntity);
		when(edpTrnUpdDsgnAttachmentEntity.getFile()).thenReturn(multipartFile);
		when(edpTrnUpdDsgnAttachmentEntity.getTrnUpdDsgnEntity()).thenReturn(edpTrnUpdDsgnEntity);
		when(edpTrnUpdDsgnEntity.getTedpUpdDsgnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(multipartFile.getOriginalFilename()).thenReturn(JunitConstants.FILENAME);
		when(multipartFile.getBytes()).thenReturn(JunitConstants.STRING_TYPE.getBytes());
		assertNotNull(service.createUpdDsgnAttachment(trnUpdDsgnAttachmentEntityList));
	}

	/**
	 * Test delete upd dsgn attachment.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteUpdDsgnAttachment() throws CustomException {
		when(edpTrnUpdDsgnAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpTrnUpdDsgnAttachmentEntity));
		when(edpTrnUpdDsgnAttachmentEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		service.deleteUpdDsgnAttachment(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		service.deleteUpdDsgnAttachment(JunitConstants.LONG_TYPE);
		verify(edpTrnUpdDsgnAttachmentRepository, times(2)).findById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test download upd dsgn files.
	 *
	 * @throws Exception the exception
	 */
	void testDownloadUpdDsgnFiles() throws Exception {
		when(edpTrnUpdDsgnAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpTrnUpdDsgnAttachmentEntity));
		when(Optional.of(edpTrnUpdDsgnAttachmentEntity).get().getUploadedFilePath())
				.thenReturn(JunitConstants.FILEPATH);
		assertNotNull(service.downloadUpdDsgnFiles(JunitConstants.LONG_TYPE));
		when(edpTrnUpdDsgnAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(service.downloadUpdDsgnFiles(JunitConstants.LONG_TYPE));
		verify(edpTrnUpdDsgnAttachmentRepository, times(2)).findById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test get attachment list by designation id.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAttachmentListByDesignationId() throws CustomException {
		when(edpAddDesigAttachmentRepository.findAllByDesignationIdAndActiveStatus(JunitConstants.LONG_TYPE,1))
				.thenReturn(edpAddDesAttachmentEntitylist);
		assertNotNull(service.getAttachmentListByDesignationId(JunitConstants.LONG_TYPE));
		verify(edpAddDesigAttachmentRepository, times(1)).findAllByDesignationIdAndActiveStatus(JunitConstants.LONG_TYPE,1);
	}

}
