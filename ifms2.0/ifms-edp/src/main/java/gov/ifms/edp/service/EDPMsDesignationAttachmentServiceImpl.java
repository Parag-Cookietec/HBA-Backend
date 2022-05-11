package gov.ifms.edp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPAddDesigAttachementItrConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnAttachmentItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.entity.EDPAddDesAttachmentEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentItrEntity;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPAddDesigAttachmentItrRepository;
import gov.ifms.edp.repository.EDPAddDesigAttachmentRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnAttachmentItrRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnAttachmentRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsDesignationAttachmentServiceImpl.
 */
@Service
public class EDPMsDesignationAttachmentServiceImpl implements EDPMsDesignationAttachmentService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The edp add desig attachment repository. */
	@Autowired
	private EDPAddDesigAttachmentRepository edpAddDesigAttachmentRepository;

	/** The edp trn upd dsgn attachment itr converter. */
	@Autowired
	private EDPTrnUpdDsgnAttachmentItrConverter edpTrnUpdDsgnAttachmentItrConverter;
	
	/** The edp add desig attachement itr converter. */
	@Autowired
	private EDPAddDesigAttachementItrConverter edpAddDesigAttachementItrConverter;

	/** The edp add desig attachment itr repository. */
	@Autowired
	private EDPAddDesigAttachmentItrRepository edpAddDesigAttachmentItrRepository;

	/** The edp trn upd dsgn attachment repository. */
	@Autowired
	private EDPTrnUpdDsgnAttachmentRepository edpTrnUpdDsgnAttachmentRepository;

	/** The edp trn upd dsgn attachment itr repository. */
	@Autowired
	private EDPTrnUpdDsgnAttachmentItrRepository edpTrnUpdDsgnAttachmentItrRepository;

	/**
	 * Find update dsg attachment by id.
	 *
	 * @param attechemntId the attechemnt id
	 * @return the EDP trn upd dsgn attachment entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPTrnUpdDsgnAttachmentEntity findUpdateDsgAttachmentById(Long attechemntId) throws CustomException {
		try {
			return edpTrnUpdDsgnAttachmentRepository.getOne(attechemntId);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Find by tedp upd dsgn id and active status.
	 *
	 * @param id the id
	 * @return the list
	 */
	@Override
	public List<EDPTrnUpdDsgnAttachmentEntity> findByTedpUpdDsgnIdAndActiveStatus(Long id) {
		return edpTrnUpdDsgnAttachmentRepository.findByTrnUpdDsgnEntityTedpUpdDsgnIdAndActiveStatus(id,
				OAuthConstant.ACTIVE_STATUS);
	}

	/**
	 * Creates the add designation attachment.
	 *
	 * @param edpAddDesAttachmentEntity the edp add des attachment entity
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = CustomException.class)
	public List<EDPAddDesAttachmentEntity> createAddDesignationAttachment(
			List<EDPAddDesAttachmentEntity> edpAddDesAttachmentEntity) throws CustomException {
		try {
			EDPMsUserEntity user  =new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
			String uploadLocation = null;
			if (!CollectionUtils.isEmpty(edpAddDesAttachmentEntity) && null != edpAddDesAttachmentEntity.get(0)
					&& null != edpAddDesAttachmentEntity.get(0).getDesignationId()) {
				uploadLocation = EDPUtility.checkUploadLocationExists(edpAddDesAttachmentEntity.get(0).getDesignationId(),
						EDPConstant.ADD_NEW_DESIGNATION_MENU_ID);
			}
			for (EDPAddDesAttachmentEntity entity : edpAddDesAttachmentEntity) {
				MultipartFile multipartFile = entity.getFile();
				entity.setUploadedFileSize(EDPUtility.getFileSizeinKB(multipartFile));
				entity.setUploadedBy(user);
				entity.setUploadedFileName(multipartFile.getOriginalFilename());
				ClueDto response = EDPUtility.uploadAttachmentInFileNet(multipartFile, uploadLocation);
				entity.setUploadedFilePath(response.getDocumentId());
			}
			List<EDPAddDesAttachmentEntity> desigAttachmentEntityResult = edpAddDesigAttachmentRepository
					.saveAll(edpAddDesAttachmentEntity);

			edpAddDesigAttachmentItrRepository.saveAll(desigAttachmentEntityResult.stream()
					.map(p -> edpAddDesigAttachementItrConverter.toEntity(p)).collect(Collectors.toList()));
			desigAttachmentEntityResult.forEach(entity -> entity.setFile(null));

			return desigAttachmentEntityResult;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	
	/**
	 * Delete add designation attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteAddDesignationAttachment(Long id) throws CustomException {
		try {
			Optional<EDPAddDesAttachmentEntity> edpOfficeAttachmentEntity = edpAddDesigAttachmentRepository
					.findById(id);
			int activeStatus = edpOfficeAttachmentEntity.isPresent() ? edpOfficeAttachmentEntity.get().getActiveStatus()
					: 0;
			if (activeStatus == 1) {
				edpOfficeAttachmentEntity.get().setActiveStatus(0);
				edpAddDesigAttachmentRepository.save(edpOfficeAttachmentEntity.get());
			}
		} catch (DataIntegrityViolationException e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	/**
	 * Download add designation files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	@Override
	public ClueDto downloadAddDesignationFiles(Long id) throws CustomException {
		try {
			Optional<EDPAddDesAttachmentEntity> edpOfficeAttachmentEntity = edpAddDesigAttachmentRepository
					.findById(id);
			if(edpOfficeAttachmentEntity.isPresent()) {
				String documentId = edpOfficeAttachmentEntity.get().getUploadedFilePath();
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
	 * @param entityList the entity list
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPTrnUpdDsgnAttachmentEntity> createUpdDsgnAttachment(List<EDPTrnUpdDsgnAttachmentEntity> entityList)
			throws CustomException {
		try {
			EDPMsUserEntity user  =new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
			String uploadLocation = null;
			if (!CollectionUtils.isEmpty(entityList) && null != entityList.get(0)
					&& null != entityList.get(0).getTrnUpdDsgnEntity()) {
				uploadLocation = EDPUtility.checkUploadLocationExists(entityList.get(0).getTrnUpdDsgnEntity().getTedpUpdDsgnId(),
						EDPConstant.UPDATE_DESIGNATION_MENU_ID);
			}
			for (EDPTrnUpdDsgnAttachmentEntity entity : entityList) {
				MultipartFile multipartFile = entity.getFile();
				entity.setUploadedBy(user);
				entity.setUploadedFileSize(EDPUtility.getFileSizeinKB(multipartFile));
				entity.setUploadedFileName(multipartFile.getOriginalFilename());
				ClueDto response = EDPUtility.uploadAttachmentInFileNet(multipartFile, uploadLocation);
				entity.setUploadedFilePath(response.getDocumentId());
			}
			entityList = edpTrnUpdDsgnAttachmentRepository.saveAll(entityList);
			List<EDPTrnUpdDsgnAttachmentItrEntity> listItr = edpTrnUpdDsgnAttachmentItrConverter
					.updDsgnAttachmentToItr(entityList);
			edpTrnUpdDsgnAttachmentItrRepository.saveAll(listItr);
			return entityList;
		} catch (Exception e) {
			logger.error(e.toString(),e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Delete upd dsgn attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteUpdDsgnAttachment(Long id) throws CustomException {
		try {
			Optional<EDPTrnUpdDsgnAttachmentEntity> edpTrnUpdDsgnAttachmentEntity = edpTrnUpdDsgnAttachmentRepository
					.findById(id);
			int activeStatus = edpTrnUpdDsgnAttachmentEntity.isPresent()
					? edpTrnUpdDsgnAttachmentEntity.get().getActiveStatus()
					: 0;
			if (activeStatus == 1) {
				EDPMsPostDto dDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
				edpTrnUpdDsgnAttachmentEntity.get().setActiveStatus(0);
				edpTrnUpdDsgnAttachmentEntity.get().setUpdatedBy(OAuthUtility.getCurrentUserUserId());
				edpTrnUpdDsgnAttachmentEntity.get().setUpdatedByPost(dDPMsPostDto.getPostId());
				edpTrnUpdDsgnAttachmentEntity.get().setUpdatedDate(new Date());
				edpTrnUpdDsgnAttachmentRepository.save(edpTrnUpdDsgnAttachmentEntity.get());
			}
		} catch (DataIntegrityViolationException e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}

	}

	/**
	 * Download upd dsgn files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	@Override
	public ClueDto downloadUpdDsgnFiles(Long id) throws CustomException {
		try {
			Optional<EDPTrnUpdDsgnAttachmentEntity> edpTrnUpdDsgnAttachmentEntity = edpTrnUpdDsgnAttachmentRepository
					.findById(id);
			if(edpTrnUpdDsgnAttachmentEntity.isPresent()) {
				String documentId = edpTrnUpdDsgnAttachmentEntity.get().getUploadedFilePath();
				return EDPUtility.downloadFileNetFile(documentId,edpTrnUpdDsgnAttachmentEntity.get().getUploadedFileName());
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
			}
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Gets the attachment list by designation id.
	 *
	 * @param designationId the designation id
	 * @return the attachment list by designation id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPAddDesAttachmentEntity> getAttachmentListByDesignationId(Long designationId) throws CustomException {
		try {
			return edpAddDesigAttachmentRepository.findAllByDesignationIdAndActiveStatus(designationId,OAuthConstant.ACTIVE_STATUS);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
} 