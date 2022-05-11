package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsAttachmentConverter;
import gov.ifms.edp.converter.EDPOfficeAttachementConverter;
import gov.ifms.edp.converter.EDPOfficeAttachementItrConverter;
import gov.ifms.edp.converter.EDPPostAttachementConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPOfficeAttachmentDto;
import gov.ifms.edp.dto.EDPTrnUserMpAttDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPOfficeAttachmentEntity;
import gov.ifms.edp.entity.EDPPostAttachmentEntity;
import gov.ifms.edp.entity.EDPPostAttachmentItrEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttItrEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsAttachmentRepository;
import gov.ifms.edp.repository.EDPOfficeAttachmentItrRepository;
import gov.ifms.edp.repository.EDPOfficeAttachmentRepository;
import gov.ifms.edp.repository.EDPPostAttachmentItrRepository;
import gov.ifms.edp.repository.EDPPostAttachmentRepository;
import gov.ifms.edp.repository.EDPTrnUserMpAttItrRepository;
import gov.ifms.edp.repository.EDPTrnUserMpAttRepository;

/**
 * The Class EDPAttachmentServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class EDPAttachmentServiceImplTest {

	/** The edp lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The edp ms attachment converter. */
	@Mock
	private EDPMsAttachmentConverter edpMsAttachmentConverter;

	/** The edp ms attachment repository. */
	@Mock
	private EDPMsAttachmentRepository edpMsAttachmentRepository;

	/** The edp office attachement converter. */
	@Mock
	private EDPOfficeAttachementConverter edpOfficeAttachementConverter;

	/** The edp office attachment itr converter. */
	@Mock
	private EDPOfficeAttachementItrConverter edpOfficeAttachmentItrConverter;

	/** The edp post attachement converter. */
	@Mock
	private EDPPostAttachementConverter edpPostAttachementConverter;

	/** The ofc attachment repository. */
	@Mock
	private EDPOfficeAttachmentRepository ofcAttachmentRepository;

	/** The edp post attachment entity. */
	@Mock
	EDPPostAttachmentEntity edpPostAttachmentEntity;

	/** The postitr attachment entity. */
	@Mock
	List<EDPPostAttachmentItrEntity> postitrAttachmentEntity;

	/** The att entity. */
	@Mock
	EDPPostAttachmentItrEntity attEntity;

	/** The post attachment itr repository. */
	@Mock
	private EDPPostAttachmentItrRepository postAttachmentItrRepository;

	/** The post attachment repository. */
	@Mock
	private EDPPostAttachmentRepository postAttachmentRepository;

	/** The ofc attachment itr repository. */
	@Mock
	private EDPOfficeAttachmentItrRepository ofcAttachmentItrRepository;

	/** The e DP attachment service impl. */
	@InjectMocks
	private EDPAttachmentServiceImpl eDPAttachmentServiceImpl;

	/** The edp office attachment entity. */
	@Mock
	private EDPOfficeAttachmentEntity edpOfficeAttachmentEntity;

	/** The edp ms attachment entity. */
	@Mock
	private EDPMsAttachmentEntity edpMsAttachmentEntity;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The ms post entity. */
	@Mock
	private EDPMsPostEntity msPostEntity;

	/** The multipart file. */
	@Mock
	private MultipartFile multipartFile;

	/** The edp trn user mp att dtos. */
	@Mock
	private List<EDPTrnUserMpAttDto> edpTrnUserMpAttDtos;

	/** The edp trn user mp att entity. */
	@Mock
	private EDPTrnUserMpAttEntity edpTrnUserMpAttEntity;

	/** The edp trn user mp att entity list. */
	@Mock
	private List<EDPTrnUserMpAttEntity> edpTrnUserMpAttEntityList;

	/** The edp trn user mp att repository. */
	@Mock
	private EDPTrnUserMpAttRepository edpTrnUserMpAttRepository;

	/** The dto. */
	@Mock
	private EDPOfficeAttachmentDto dto;

	/** The uploaded file path. */
	@Mock
	private Map<String, String> uploadedFilePath;

	/** The edp ms role permissions entity. */
	@Mock
	private EDPMsRolePermissionsEntity edpMsRolePermissionsEntity;

	/** The edp trn user mp att itr repository. */
	@Mock
	private EDPTrnUserMpAttItrRepository edpTrnUserMpAttItrRepository;

	/** The edp trn user mp att itr entities. */
	@Mock
	private List<EDPTrnUserMpAttItrEntity> edpTrnUserMpAttItrEntities;

	/** The clue dto. */
	@Mock
	private ClueDto clueDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test createoffice attachment ioexcption.
	 *
	 * @throws Exception the exception
	 */
	// @Test
	public void testCreateofficeAttachment_ioexcption() throws Exception {
		Assertions.assertThrows(ExceptionInInitializerError.class, () -> {
			List<EDPOfficeAttachmentEntity> ofcAttachmentEntity = new ArrayList<EDPOfficeAttachmentEntity>();
			ofcAttachmentEntity.add(edpOfficeAttachmentEntity);
			when(edpOfficeAttachmentEntity.getFile()).thenReturn(multipartFile);
			when(edpOfficeAttachmentEntity.getFileName()).thenReturn("filename");
			when(edpOfficeAttachmentEntity.getOfficeId()).thenReturn(1l);
			when(ofcAttachmentRepository.findByFileNameAndOfficeId("filename", JunitConstants.LONG_TYPE))
					.thenReturn(ofcAttachmentEntity);
			when(edpOfficeAttachmentEntity.getOfcAttactmentId()).thenReturn(JunitConstants.LONG_TYPE);
			when(ofcAttachmentRepository.findById(JunitConstants.LONG_TYPE))
					.thenReturn(Optional.of(edpOfficeAttachmentEntity));
			when(edpOfficeAttachmentEntity.getActiveStatus()).thenReturn(1);
			when(multipartFile.getOriginalFilename()).thenReturn("abcd.jpg");
			when(multipartFile.getBytes()).thenThrow(new IOException());
			when(ofcAttachmentRepository.saveAll(ofcAttachmentEntity)).thenReturn(ofcAttachmentEntity);
			eDPAttachmentServiceImpl.createofficeAttachment(ofcAttachmentEntity);
		});

	}

	/**
	 * Test createoffice attachment.
	 *
	 * @throws Exception the exception
	 */
	public void testCreateofficeAttachment() throws Exception {
		List<EDPOfficeAttachmentEntity> ofcAttachmentEntity = new ArrayList<EDPOfficeAttachmentEntity>();
		ofcAttachmentEntity.add(edpOfficeAttachmentEntity);
		when(edpOfficeAttachmentEntity.getFile()).thenReturn(multipartFile);
		when(edpOfficeAttachmentEntity.getFileName()).thenReturn(JunitConstants.FILENAME);
		when(edpOfficeAttachmentEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(ofcAttachmentRepository.findByFileNameAndOfficeId(JunitConstants.FILENAME, JunitConstants.LONG_TYPE))
				.thenReturn(ofcAttachmentEntity);
		when(edpOfficeAttachmentEntity.getOfcAttactmentId()).thenReturn(JunitConstants.LONG_TYPE);
		when(ofcAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpOfficeAttachmentEntity));
		when(edpOfficeAttachmentEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(multipartFile.getOriginalFilename()).thenReturn(JunitConstants.FILENAME);
		when(multipartFile.getBytes()).thenReturn(JunitConstants.STRING_TYPE.getBytes());
		assertNotNull(eDPAttachmentServiceImpl.createofficeAttachment(ofcAttachmentEntity));
		when(edpOfficeAttachmentEntity.getFileName()).thenReturn(JunitConstants.STRING_NULL);
		assertNotNull(eDPAttachmentServiceImpl.createofficeAttachment(ofcAttachmentEntity));
	}

	/**
	 * Test find attachment by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testFindAttachmentById() throws Exception {
		when(ofcAttachmentRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpOfficeAttachmentEntity);
		assertNotNull(eDPAttachmentServiceImpl.findAttachmentById(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test find by office id and active status.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testFindByOfficeIdAndActiveStatus() throws Exception {
		when(ofcAttachmentRepository.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(new ArrayList<EDPOfficeAttachmentEntity>());
		assertNotNull(eDPAttachmentServiceImpl.findByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test delete office attachment.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testDeleteOfficeAttachment() throws Exception {
		when(ofcAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpOfficeAttachmentEntity));
		when(edpOfficeAttachmentEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		eDPAttachmentServiceImpl.deleteOfficeAttachment(JunitConstants.LONG_TYPE);
		when(ofcAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		eDPAttachmentServiceImpl.deleteOfficeAttachment(JunitConstants.LONG_TYPE);
		verify(ofcAttachmentRepository, times(2)).findById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test download files.
	 *
	 * @throws Exception the exception
	 */
	public void testDownloadFiles() throws Exception {
		when(ofcAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpOfficeAttachmentEntity));
		when(edpOfficeAttachmentEntity.getPathUploadFile()).thenReturn(JunitConstants.FILEPATH);
		assertNotNull(eDPAttachmentServiceImpl.downloadFiles(JunitConstants.LONG_TYPE));
		when(ofcAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(eDPAttachmentServiceImpl.downloadFiles(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test create post attachment.
	 *
	 * @throws Exception the exception
	 */
	public void testCreatePostAttachment() throws Exception {
		List<EDPPostAttachmentEntity> postAttachmentEntity = new ArrayList<>();
		postAttachmentEntity.add(edpPostAttachmentEntity);
		when(edpPostAttachmentEntity.getFile()).thenReturn(multipartFile);
		when(multipartFile.getOriginalFilename()).thenReturn(JunitConstants.FILENAME);
		when(msPostEntity.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpPostAttachmentEntity.getPostId()).thenReturn(msPostEntity);
		when(multipartFile.getBytes()).thenReturn(JunitConstants.STRING_TYPE.getBytes());
		when(postAttachmentRepository.saveAll(postAttachmentEntity)).thenReturn(postAttachmentEntity);
		assertNotNull(eDPAttachmentServiceImpl.createPostAttachment(postAttachmentEntity));
	}

	/**
	 * Test find post attachment by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testFindPostAttachmentById() throws Exception {
		when(postAttachmentRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpPostAttachmentEntity);
		assertNotNull(eDPAttachmentServiceImpl.findPostAttachmentById(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test find by post id and active status.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testFindByPostIdAndActiveStatus() throws Exception {
		assertNotNull(eDPAttachmentServiceImpl.findByPostIdAndActiveStatus(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test delete post attachment.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testDeletePostAttachment() throws Exception {
		when(postAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpPostAttachmentEntity));
		when(edpPostAttachmentEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		eDPAttachmentServiceImpl.deletePostAttachment(JunitConstants.LONG_TYPE);
		when(postAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		eDPAttachmentServiceImpl.deletePostAttachment(JunitConstants.LONG_TYPE);
		verify(postAttachmentRepository).save(edpPostAttachmentEntity);
	}

	/**
	 * Test download post files.
	 *
	 * @throws Exception the exception
	 */
	public void testDownloadPostFiles() throws Exception {
		when(postAttachmentRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpPostAttachmentEntity));
		when(edpPostAttachmentEntity.getUploadedFilePath()).thenReturn(JunitConstants.FILEPATH);
		assertNotNull(eDPAttachmentServiceImpl.downloadPostFiles(JunitConstants.LONG_TYPE));
		when(postAttachmentRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(eDPAttachmentServiceImpl.downloadPostFiles(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get attachment by post id and att type.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetAttachmentByPostIdAndAttType() throws Exception {
		assertNotNull(eDPAttachmentServiceImpl.getAttachmentByPostIdAndAttType(JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get attachment by ofc id and att type.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetAttachmentByOfcIdAndAttType() throws Exception {
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.COMMON_ATTACHMENT))
				.thenReturn(edpLuLookUpInfoEntity);
		List<EDPOfficeAttachmentEntity> officeAttachmentEntity = new ArrayList<EDPOfficeAttachmentEntity>();
		officeAttachmentEntity.add(edpOfficeAttachmentEntity);
		when(ofcAttachmentRepository.getOfficeAttachmentsByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(officeAttachmentEntity);
		when(edpOfficeAttachmentEntity.getAttachmentId()).thenReturn(edpMsAttachmentEntity);
		when(edpMsAttachmentEntity.getAttahcmentType()).thenReturn(edpLuLookUpInfoEntity);
		when(ofcAttachmentRepository.getOfficeAttachmentsByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(officeAttachmentEntity);
		when(edpOfficeAttachementConverter.toDTO(edpOfficeAttachmentEntity)).thenReturn(dto);
		when(edpMsAttachmentEntity.getAttahcmentType()).thenReturn(edpLuLookUpInfoEntity);
		when(ofcAttachmentRepository.getOfficeAttachmentsByOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(officeAttachmentEntity);
		when(edpOfficeAttachementConverter.toDTO(edpOfficeAttachmentEntity)).thenReturn(dto);
		when(edpOfficeAttachmentEntity.getAttachmentId()).thenReturn(edpMsAttachmentEntity);
		assertNotNull(eDPAttachmentServiceImpl.getAttachmentByOfcIdAndAttType(JunitConstants.LONG_TYPE,JunitConstants.STRING_NULL));
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(eDPAttachmentServiceImpl.getAttachmentByOfcIdAndAttType(JunitConstants.LONG_TYPE,JunitConstants.STRING_NULL));
	}

	/**
	 * Test get attachment by att type.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAttachmentByAttType() throws Exception {
		List<EDPLuLookUpInfoEntity> lookUpInfos = new ArrayList<EDPLuLookUpInfoEntity>();
		lookUpInfos.add(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoRepository.findByLookUpInfoNameIn(Mockito.any(Set.class))).thenReturn(lookUpInfos);
		/*when(edpMsAttachmentRepository.findByAttahcmentTypeLookUpInfoIdIn(Mockito.any(Set.class)))
				.thenReturn(lookUpInfos);*/
		List<ClueDto> attachmentType1 = new ArrayList<>();
		attachmentType1.add(clueDto);
		when(clueDto.getName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(eDPAttachmentServiceImpl.getAttachmentByAttType(attachmentType1));
		
		List<ClueDto> attachmentType2 = new ArrayList<>();
		assertNotNull(eDPAttachmentServiceImpl.getAttachmentByAttType(attachmentType2));
	}

	/**
	 * Test find by user rg map id and active status.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testFindByUserRgMapIdAndActiveStatus() throws CustomException {
		// when(edpTrnUserMpAttRepository.findByUserRgMapIdAndActiveStatus(1l,
		// Constant.ACTIVE_STATUS)).thenThrow();
		assertNotNull(eDPAttachmentServiceImpl.findByUserRgMapIdAndActiveStatus(1l));
	}

	/**
	 * Test create user role map attachment.
	 *
	 * @throws Exception the exception
	 */
	void testCreateUserRoleMapAttachment() throws Exception {
		List<EDPTrnUserMpAttEntity> edpUserMpEntity = new ArrayList<>();
		edpUserMpEntity.add(edpTrnUserMpAttEntity);
		when(edpTrnUserMpAttEntity.getFile()).thenReturn(multipartFile);
		when(multipartFile.getOriginalFilename()).thenReturn("abcd.jpg");
		when(multipartFile.getBytes()).thenReturn("abcd".getBytes());
		when(edpTrnUserMpAttEntity.getRolePrmID()).thenReturn(edpMsRolePermissionsEntity);
		when(edpMsRolePermissionsEntity.getRoleActivityId()).thenReturn(1l);
		assertNotNull(eDPAttachmentServiceImpl.createUserRoleMapAttachment(edpUserMpEntity));
	}

	/**
	 * Test delete user role map attachment.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testDeleteUserRoleMapAttachment() throws Exception {
		when(edpTrnUserMpAttRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpTrnUserMpAttEntity));
		when(edpTrnUserMpAttEntity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		eDPAttachmentServiceImpl.deleteUserRoleMapAttachment(JunitConstants.LONG_TYPE);
		when(edpTrnUserMpAttRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		eDPAttachmentServiceImpl.deleteUserRoleMapAttachment(JunitConstants.LONG_TYPE);
		verify(edpTrnUserMpAttRepository, times(2)).findById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test get attachment by user role map id and att type.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAttachmentByUserRoleMapIdAndAttType() throws CustomException {
		when(edpTrnUserMpAttRepository.getAttachmentByUserRoleMapIdAndAttTypeQuery(JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE)).thenReturn(edpTrnUserMpAttDtos);
		assertNotNull(eDPAttachmentServiceImpl.getAttachmentByUserRoleMapIdAndAttType(JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE));
	}

	/**
	 * Test download user role map files.
	 *
	 * @throws CustomException the custom exception
	 */
	void testDownloadUserRoleMapFiles() throws CustomException {
		when(edpTrnUserMpAttRepository.findById(JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(edpTrnUserMpAttEntity));
		when(Optional.of(edpTrnUserMpAttEntity).get().getUploadFilePath()).thenReturn(Mockito.anyString());
		assertNotNull(eDPAttachmentServiceImpl.downloadUserRoleMapFiles(JunitConstants.LONG_TYPE));
		when(edpTrnUserMpAttRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(eDPAttachmentServiceImpl.downloadUserRoleMapFiles(JunitConstants.LONG_TYPE));

	}
}