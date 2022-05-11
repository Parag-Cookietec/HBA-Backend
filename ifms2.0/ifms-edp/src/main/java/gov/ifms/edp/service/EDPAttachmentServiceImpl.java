package gov.ifms.edp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsAttachmentConverter;
import gov.ifms.edp.converter.EDPOfficeAttachementConverter;
import gov.ifms.edp.converter.EDPOfficeAttachementItrConverter;
import gov.ifms.edp.converter.EDPPostAttachementConverter;
import gov.ifms.edp.converter.EDPTrnUserMpAttConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsAttachmentDto;
import gov.ifms.edp.dto.EDPOfficeAttachmentDto;
import gov.ifms.edp.dto.EDPPostAttachmentDto;
import gov.ifms.edp.dto.EDPTrnUserMpAttDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPOfficeAttachmentEntity;
import gov.ifms.edp.entity.EDPOfficeAttachmentItrEntity;
import gov.ifms.edp.entity.EDPPostAttachmentEntity;
import gov.ifms.edp.entity.EDPPostAttachmentItrEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttItrEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsAttachmentRepository;
import gov.ifms.edp.repository.EDPOfficeAttachmentItrRepository;
import gov.ifms.edp.repository.EDPOfficeAttachmentRepository;
import gov.ifms.edp.repository.EDPPostAttachmentItrRepository;
import gov.ifms.edp.repository.EDPPostAttachmentRepository;
import gov.ifms.edp.repository.EDPTrnUserMpAttItrRepository;
import gov.ifms.edp.repository.EDPTrnUserMpAttRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPAttachmentServiceImpl.
 */
@Service
public class EDPAttachmentServiceImpl implements EDPAttachmentService {

	/** The ofc attachment repository. */
	@Autowired
	private EDPOfficeAttachmentRepository ofcAttachmentRepository;

	/** The ofc attachment itr repository. */
	@Autowired
	private EDPOfficeAttachmentItrRepository ofcAttachmentItrRepository;

	/** The post attachment repository. */
	@Autowired
	private EDPPostAttachmentRepository postAttachmentRepository;

	/** The edp ms attachment repository. */
	@Autowired
	private EDPMsAttachmentRepository edpMsAttachmentRepository;

	/** The edp ms attachment converter. */
	@Autowired
	private EDPMsAttachmentConverter edpMsAttachmentConverter;

	/** The edp ms attachment converter. */
	@Autowired
	private EDPOfficeAttachementItrConverter edpOfficeAttachmentItrConverter;

	/** The edp lu look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The post attachment itr repository. */
	@Autowired
	private EDPPostAttachmentItrRepository postAttachmentItrRepository;

	/** The edp post attachement converter. */
	@Autowired
	private EDPPostAttachementConverter edpPostAttachementConverter;

	/** The edp trn user mp att repository. */
	@Autowired
	private EDPTrnUserMpAttRepository edpTrnUserMpAttRepository;

	/** The edp trn user mp att converter. */
	@Autowired
	private EDPTrnUserMpAttConverter edpTrnUserMpAttConverter;

	/** The edp trn user mp att itr repository. */
	@Autowired
	private EDPTrnUserMpAttItrRepository edpTrnUserMpAttItrRepository;

	/** */
	@Autowired
	private EDPOfficeAttachementConverter edpAttachmentConverter;

	@Autowired
	private EntityManager entityManager;

	/**
	 * Createoffice attachment.
	 *
	 * @param ofcAttachmentEntity the ofc attachment entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = CustomException.class)
	public List<EDPOfficeAttachmentEntity> createofficeAttachment(List<EDPOfficeAttachmentEntity> ofcAttachmentEntity)
			throws CustomException {
		try {
			EDPMsUserEntity user = new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
			String uploadLocation = null;
			if (!CollectionUtils.isEmpty(ofcAttachmentEntity) && null != ofcAttachmentEntity.get(0)) {
				uploadLocation = EDPUtility.checkUploadLocationExists(ofcAttachmentEntity.get(0).getOfficeId(),
						EDPConstant.CREATE_OFFICE_MENU_ID);
			}
			for (EDPOfficeAttachmentEntity entity : ofcAttachmentEntity) {
				MultipartFile multipartFile = entity.getFile();
				/** invalidateOldFile(entity.getFileName(), entity.getOfficeId()); */
				entity.setUploadedFileSize(EDPUtility.getFileSizeinKB(multipartFile));
				entity.setUploadedBy(user);
				entity.setUploadedFileName(multipartFile.getOriginalFilename());
				ClueDto response = EDPUtility.uploadAttachmentInFileNet(multipartFile, uploadLocation);
				entity.setPathUploadFile(response.getDocumentId());
			}
			List<EDPOfficeAttachmentEntity> ofcAttachmentEntityResult = ofcAttachmentRepository
					.saveAll(ofcAttachmentEntity);
			ofcAttachmentItrRepository.saveAll(edpOfficeAttachmentItrConverter.toListEntity(ofcAttachmentEntityResult));
			ofcAttachmentEntityResult.forEach(entity -> entity.setFile(null));

			return ofcAttachmentEntityResult;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Invalidate old file.
	 *
	 * @param id the id
	 * @return the EDP office attachment entity
	 * @throws CustomException the custom exception
	 */

	/**
	 * private void invalidateOldFile(String fileName, long officeId) throws
	 * CustomException {
	 * 
	 * List<EDPOfficeAttachmentEntity> list =
	 * ofcAttachmentRepository.findByFileNameAndOfficeId(fileName, officeId); for
	 * (EDPOfficeAttachmentEntity entity : list) {
	 * this.deleteOfficeAttachment(entity.getOfcAttactmentId()); } }
	 */

	/**
	 * Find attachment by id.
	 *
	 * @param id the id
	 * @return the EDP office attachment entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPOfficeAttachmentEntity findAttachmentById(Long id) throws CustomException {

		EDPOfficeAttachmentEntity entity = null;
		try {
			entity = ofcAttachmentRepository.getOne(id);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return entity;
	}

	/**
	 * Find by sce header id.
	 *
	 * @param officeId the office id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPOfficeAttachmentEntity> findByOfficeIdAndActiveStatus(Long officeId) throws CustomException {
		try {
			return ofcAttachmentRepository.findByOfficeIdAndActiveStatus(officeId, Constant.ACTIVE_STATUS);
		} catch (DataIntegrityViolationException e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Delete sc attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteOfficeAttachment(Long id) throws CustomException {
		try {
			Optional<EDPOfficeAttachmentEntity> optionalAttachment = ofcAttachmentRepository.findById(id);
			if (!optionalAttachment.isPresent()) {
				return;
			}

			EDPOfficeAttachmentEntity entity = optionalAttachment.get();
			entity.setActiveStatus(EDPConstant.INACTIVE_STATUS);
			ofcAttachmentRepository.save(entity);

			EDPOfficeAttachmentItrEntity itrAttachment = ofcAttachmentItrRepository
					.findByAttachmentId(entity.getOfcAttactmentId());
			if (itrAttachment == null) {
				return;
			}

			itrAttachment.setActiveStatus(EDPConstant.INACTIVE_STATUS);
			ofcAttachmentItrRepository.save(itrAttachment);
		} catch (DataIntegrityViolationException e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	/**
	 * Download files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	@Override
	public ClueDto downloadFiles(Long id) throws CustomException {
		try {
			Optional<EDPOfficeAttachmentEntity> edpOfficeAttachmentEntity = ofcAttachmentRepository.findById(id);
			if(edpOfficeAttachmentEntity.isPresent()) {
				String documentId = edpOfficeAttachmentEntity.get().getPathUploadFile();
				return EDPUtility.downloadFileNetFile(documentId,edpOfficeAttachmentEntity.get().getUploadedFileName());
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
			}
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Creates the post attachment.
	 *
	 * @param postAttachmentEntity the post attachment entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<EDPPostAttachmentEntity> createPostAttachment(List<EDPPostAttachmentEntity> postAttachmentEntity)
			throws CustomException {
		try {
			EDPMsUserEntity user = new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
			String uploadLocation = null;
			if (!CollectionUtils.isEmpty(postAttachmentEntity) && null != postAttachmentEntity.get(0)
					&& null != postAttachmentEntity.get(0).getPostId()) {
				uploadLocation = EDPUtility.checkUploadLocationExists(postAttachmentEntity.get(0).getPostId().getPostId(),
						EDPConstant.POST_CREATION_MENU_ID);
			}
			for (EDPPostAttachmentEntity entity : postAttachmentEntity) {
				MultipartFile multipartFile = entity.getFile();
				entity.setUploadedBy(user);
				entity.setUploadedFileSize(EDPUtility.getFileSizeinKB(multipartFile));
				entity.setUploadedFileName(multipartFile.getOriginalFilename());
				ClueDto response = EDPUtility.uploadAttachmentInFileNet(multipartFile, uploadLocation);
				entity.setUploadedFilePath(response.getDocumentId());
			}
			postAttachmentEntity = postAttachmentRepository.saveAll(postAttachmentEntity);
			List<EDPPostAttachmentItrEntity> listItr = postAttachmentEntity.stream()
					.map(entity -> edpPostAttachementConverter.toEntity(entity)).collect(Collectors.toList());
			postAttachmentItrRepository.saveAll(listItr);
			return postAttachmentEntity;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Find post attachment by id.
	 *
	 * @param id the id
	 * @return the EDP post attachment entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPPostAttachmentEntity findPostAttachmentById(Long id) throws CustomException {

		EDPPostAttachmentEntity entity = null;
		try {
			entity = postAttachmentRepository.getOne(id);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return entity;
	}

	/**
	 * Find by post id and active status.
	 *
	 * @param postId the post id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPPostAttachmentEntity> findByPostIdAndActiveStatus(Long postId) throws CustomException {
		try {
			return postAttachmentRepository.findByPostIdPostIdAndActiveStatus(postId, Constant.ACTIVE_STATUS);
		} catch (DataIntegrityViolationException e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Delete post attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deletePostAttachment(Long id) throws CustomException {
		try {
			Optional<EDPPostAttachmentEntity> edpPostAttachmentEntity = postAttachmentRepository.findById(id);
			int activeStatus = edpPostAttachmentEntity.isPresent() ? edpPostAttachmentEntity.get().getActiveStatus()
					: 0;
			if (activeStatus == 1) {
				edpPostAttachmentEntity.get().setActiveStatus(0);
				postAttachmentRepository.save(edpPostAttachmentEntity.get());
			}
		} catch (DataIntegrityViolationException ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}

	}

	/**
	 * Download post files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	@Override
	public ClueDto downloadPostFiles(Long id) throws CustomException {
		try {
			Optional<EDPPostAttachmentEntity> edpOfficeAttachmentEntity = postAttachmentRepository.findById(id);
			if(edpOfficeAttachmentEntity.isPresent()) {
				String documentId = edpOfficeAttachmentEntity.get().getUploadedFilePath();
				return EDPUtility.downloadFileNetFile(documentId,edpOfficeAttachmentEntity.get().getUploadedFileName());
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
			}
		}  catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Gets the attachment by post id and att type.
	 *
	 * @param postId         the post id
	 * @param attachmentType the attachment type
	 * @return the attachment by post id and att type
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPPostAttachmentDto> getAttachmentByPostIdAndAttType(long postId, long attachmentType)
			throws CustomException {
		try {
			return postAttachmentRepository.getAttachmentByPostIdAndAttTypeQuery(postId, attachmentType);
		} catch (Exception ex) {
			logger.error(ex.toString());
			logger.error(MsgConstant.ERROR_WHILE_FATCHING, ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the attachment by ofc id and att type.
	 *
	 * @param officeId       the office id
	 * @param attachmentType the attachment type
	 * @return the attachment by ofc id and att type
	 * @throws CustomException the custom exception
	 */
	public List<Object[]> getAttachmentByOfcIdAndAttType(long officeId, String attchTblName) throws CustomException {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(EDPConstant.ARG_OFFICE_ID, officeId);
			return ofcAttachmentRepository.executeSQLQuery(EDPNativeSQLUtil.getOfficeAttachment(attchTblName), map);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the attachment by att type.
	 *
	 * @param attachmentType the attachment type
	 * @return the attachment by att type
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPMsAttachmentDto> getAttachmentByAttType(List<ClueDto> attachmentType) throws CustomException {
		try {
			Set<String> attachmentTypes = attachmentType.stream().filter(dto -> !StringUtils.isEmpty(dto.getName()))
					.map(ClueDto::getName).collect(Collectors.toSet());
			if (CollectionUtils.isEmpty(attachmentTypes)) {
				attachmentTypes.add(Constant.COMMON_ATTACHMENT);
			}

			List<EDPLuLookUpInfoEntity> lookUpInfos = edpLuLookUpInfoRepository.findByLookUpInfoNameIn(attachmentTypes);
			if (CollectionUtils.isEmpty(lookUpInfos)) {
				throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
			}
			Set<Long> ids = lookUpInfos.stream().map(EDPLuLookUpInfoEntity::getLookUpInfoId)
					.collect(Collectors.toSet());

			List<EDPMsAttachmentEntity> edpMsAttachmentEnties = edpMsAttachmentRepository
					.findByAttahcmentTypeLookUpInfoIdIn(ids);
			return edpMsAttachmentConverter.toDTO(edpMsAttachmentEnties);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Find by user rg map id and active status.
	 *
	 * @param id the id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPTrnUserMpAttEntity> findByUserRgMapIdAndActiveStatus(Long id) throws CustomException {
		try {
			return edpTrnUserMpAttRepository.findByUserRgMapIdTusrRgMapIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
		} catch (DataIntegrityViolationException e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Creates the user role map attachment.
	 *
	 * @param edpUserMpEntity the edp user mp entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPTrnUserMpAttEntity> createUserRoleMapAttachment(List<EDPTrnUserMpAttEntity> edpUserMpEntity)
			throws CustomException {
		try {
			String uploadLocation = null;
			if (!CollectionUtils.isEmpty(edpUserMpEntity) && null != edpUserMpEntity.get(0)
					&& null != edpUserMpEntity.get(0).getUserRgMapId()) {
				uploadLocation = EDPUtility.checkUploadLocationExists(edpUserMpEntity.get(0).getUserRgMapId().getTusrRgMapId(),
						EDPConstant.POST_RIGHTS_MAPPING_MENU_ID);
			}
			for (EDPTrnUserMpAttEntity entity : edpUserMpEntity) {
				MultipartFile multipartFile = entity.getFile();
				entity.setUploadedBy(new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId()));
				entity.setUploadFileSize(EDPUtility.getFileSizeinKB(multipartFile));
				entity.setUploadFileName(multipartFile.getOriginalFilename());
				ClueDto response = EDPUtility.uploadAttachmentInFileNet(multipartFile, uploadLocation);
				entity.setUploadFilePath(response.getDocumentId());
			}
			edpUserMpEntity = edpTrnUserMpAttRepository.saveAll(edpUserMpEntity);
			List<EDPTrnUserMpAttItrEntity> listItr = edpUserMpEntity.stream()
					.map(entity -> edpTrnUserMpAttConverter.toEntity(entity)).collect(Collectors.toList());
			edpTrnUserMpAttItrRepository.saveAll(listItr);

			return edpUserMpEntity;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Delete user role map attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteUserRoleMapAttachment(Long id) throws CustomException {
		try {
			Optional<EDPTrnUserMpAttEntity> edpUserMpAttchEntity = edpTrnUserMpAttRepository.findById(id);
			int activeStatus = edpUserMpAttchEntity.isPresent() ? edpUserMpAttchEntity.get().getActiveStatus() : 0;
			if (activeStatus == 1) {
				edpUserMpAttchEntity.get().setActiveStatus(0);
				edpTrnUserMpAttRepository.save(edpUserMpAttchEntity.get());
			}
		} catch (DataIntegrityViolationException ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}

	}

	/**
	 * Download user role map files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	@Override
	public ClueDto downloadUserRoleMapFiles(Long id) throws CustomException {
		try {
			Optional<EDPTrnUserMpAttEntity> edpUserMpAttchEntity = edpTrnUserMpAttRepository.findById(id);
			if(edpUserMpAttchEntity.isPresent()) {
				String documentId = edpUserMpAttchEntity.get().getUploadFilePath();
				return EDPUtility.downloadFileNetFile(documentId,edpUserMpAttchEntity.get().getUploadFileName());
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
			}
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Gets the attachment by user role map id and att type.
	 *
	 * @param userRoleMapId  the user role map id
	 * @param attachmentType the attachment type
	 * @return the attachment by user role map id and att type
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPTrnUserMpAttDto> getAttachmentByUserRoleMapIdAndAttType(Long userRoleMapId, Long attachmentType)
			throws CustomException {
		try {
			return edpTrnUserMpAttRepository.getAttachmentByUserRoleMapIdAndAttTypeQuery(userRoleMapId, attachmentType);
		} catch (Exception ex) {
			logger.error(ex.toString());
			logger.error(MsgConstant.ERROR_WHILE_FATCHING, ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the attachment by att type rights mapping.
	 *
	 * @param attachmentTypes the attachment types
	 * @return the attachment by att type rights mapping
	 * @throws CustomException the custom exception
	 */
	public List<EDPMsAttachmentDto> getAttachmentByAttTypeRightsMapping(List<String> attachmentTypes)
			throws CustomException {
		try {
			if (CollectionUtils.isEmpty(attachmentTypes)) {
				attachmentTypes.add(Constant.COMMON_ATTACHMENT);
			}

			List<EDPLuLookUpInfoEntity> lookUpInfos = edpLuLookUpInfoRepository.findByLookUpInfoNameIn(attachmentTypes);
			if (CollectionUtils.isEmpty(lookUpInfos)) {
				throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
			}
			Set<Long> ids = lookUpInfos.stream().map(EDPLuLookUpInfoEntity::getLookUpInfoId)
					.collect(Collectors.toSet());

			List<EDPMsAttachmentEntity> edpMsAttachmentEnties = edpMsAttachmentRepository
					.findByAttahcmentTypeLookUpInfoIdIn(ids);
			List<EDPMsAttachmentEntity> commonAtts = edpMsAttachmentEnties.stream()
					.filter(att -> att.getAttahcmentType().getLookUpInfoName().equals(Constant.COMMON_ATTACHMENT))
					.collect(Collectors.toList());
			edpMsAttachmentEnties.removeAll(commonAtts);
			edpMsAttachmentEnties.addAll(commonAtts);

			return edpMsAttachmentConverter.toDTO(edpMsAttachmentEnties);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Upload Update Office Attachments
	 * 
	 * @param attachment list
	 * @return list
	 * 
	 * @throws IOException
	 */
	@Override
	public List<EDPOfficeAttachmentEntity> uploadOfficeAttach(List<EDPOfficeAttachmentDto> attch) throws IOException {
		List<EDPOfficeAttachmentEntity> result = new ArrayList<>();
		List<EDPOfficeAttachmentItrEntity> attachItrList = new ArrayList<>();

		EDPMsUserEntity user = new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
		
		String uploadLocation = null;
		if (!CollectionUtils.isEmpty(attch) && null != attch.get(0)) {
			uploadLocation = EDPUtility.checkUploadLocationExists(attch.get(0).getOfficeId(),EDPConstant.DETAIL_OFFICE_SUMM_MENU_ID);
		}
		
		for (EDPOfficeAttachmentDto dto : attch) {
			EDPOfficeAttachmentEntity entity = getAttachmentEntity(dto, user,uploadLocation);

			entity = ofcAttachmentRepository.save(entity);
			entity.setFile(null);
			result.add(entity);

			EDPOfficeAttachmentItrEntity itrEntity = edpOfficeAttachmentItrConverter.toEntity(entity);

			EDPUpdateOfficeTrnEntity officeTrnEntity = getLastOfficeTrn(entity.getOfficeId(),
					EDPConstant.ACTIVE_STATUS_TRUE);
			itrEntity.setOfficeTrnEntity(officeTrnEntity);
			attachItrList.add(itrEntity);
		}

		ofcAttachmentItrRepository.saveAll(attachItrList);

		return result;
	}

	private EDPOfficeAttachmentEntity getAttachmentEntity(EDPOfficeAttachmentDto dto, EDPMsUserEntity user, String uploadLocation)
			throws IOException {
		EDPOfficeAttachmentEntity entity = edpAttachmentConverter.toEntity(dto);
		MultipartFile multipartFile = dto.getFile();
		entity.setUploadedFileSize(EDPUtility.getFileSizeinKB(multipartFile));
		entity.setUploadedBy(user);
		entity.setOfficeId(dto.getOfficeId());
		entity.setUploadedFileName(multipartFile.getOriginalFilename());
		ClueDto response = EDPUtility.uploadAttachmentInFileNet(multipartFile, uploadLocation);
		entity.setPathUploadFile(response.getDocumentId());
		return entity;
	}

	@Override
	public List<Object[]> getOfficeAttachment(Long officeId) throws CustomException {
		Map<String, Object> args = new HashMap<>();

		try {
			EDPUpdateOfficeTrnEntity officeTrnEntity = getLastOfficeTrn(officeId, EDPConstant.ACTIVE_STATUS_TRUE);
			if (officeTrnEntity == null) {
				return new ArrayList<>();
			}
			args.put(EDPConstant.ARG_OFFICE_TRN_ID, officeTrnEntity.getUpdOffcTrnId());
			return ofcAttachmentRepository.executeSQLQuery(EDPNativeSQLUtil.getOfficeItrAttachment(), args);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Fetch last submitted transaction based on office id and active status
	 * 
	 * @param officeId
	 * @param activeStatus
	 * @return
	 */
	private EDPUpdateOfficeTrnEntity getLastOfficeTrn(Long officeId, int activeStatus) {
		TypedQuery<EDPUpdateOfficeTrnEntity> query = entityManager.createQuery(
				"SELECT trn FROM EDPUpdateOfficeTrnEntity trn WHERE trn.msOfficeEntity.officeId = :officeId "
						+ "AND trn.activeStatus = :activeStatus ORDER BY trn.updOffcTrnId DESC",
				EDPUpdateOfficeTrnEntity.class);

		query.setParameter("officeId", officeId);
		query.setParameter("activeStatus", activeStatus);
		query.setMaxResults(1);

		List<EDPUpdateOfficeTrnEntity> result = query.getResultList();

		return result != null && !result.isEmpty() ? result.get(0) : null;
	}
}
