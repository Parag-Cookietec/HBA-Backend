package gov.ifms.edp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPUsrPoTrnsAttItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsAttachmentRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsAttItrRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsAttRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsUPMappingAttachmentServiceImpl.
 */
@Service
public class EDPMsUPMappingAttachmentServiceImpl implements EDPMsUPMappingAttachmentService {

	/** The edp usr po trns att repository. */
	@Autowired
	EDPUsrPoTrnsAttRepository edpUsrPoTrnsAttRepository;

	/** The edp usr po trns att itr repository. */
	@Autowired
	EDPUsrPoTrnsAttItrRepository edpUsrPoTrnsAttItrRepository;

	/** The edp usr po trns att itr converter. */
	@Autowired
	EDPUsrPoTrnsAttItrConverter edpUsrPoTrnsAttItrConverter;

	/** The edp ms attachment repository. */
	@Autowired
	EDPMsAttachmentRepository edpMsAttachmentRepository;

	/** The edp lu look up info repository. */
	@Autowired
	EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/**
	 * Find attachment by attachment type.
	 *
	 * @param attechemntId the attechemnt id
	 * @param tedpUptId the tedp upt id
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPUsrPoTrnsAttEntity> findAttachmentByAttachmentType(Long attechemntId, Long tedpUptId)
			throws CustomException {
		return edpUsrPoTrnsAttRepository
				.findAllByEdpUsrPoTranAttIdAndEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(attechemntId,
						tedpUptId, EDPConstant.ACTIVE_STATUS_TRUE);
	}

	/**
	 * Find attachment by user post transfer id.
	 *
	 * @param id the id
	 * @return the list
	 */
	@Override
	public List<EDPUsrPoTrnsAttEntity> findAttachmentByUserPostTransferId(Long id) {
		return edpUsrPoTrnsAttRepository.findAllByEdpUsrPoTrnsHeadrIdEdpUsrPoTrnsHeaderIdAndActiveStatus(id,
				EDPConstant.ACTIVE_STATUS_TRUE);
	}

	/**
	 * Creates the UP mapping attachment.
	 *
	 * @param entityList the entity list
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPUsrPoTrnsAttEntity> createUPMappingAttachment(List<EDPUsrPoTrnsAttEntity> entityList)
			throws CustomException {
		try {
			EDPMsUserEntity user =new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
			String uploadLocation = null;
			if (!CollectionUtils.isEmpty(entityList) && null != entityList.get(0)
					&& null != entityList.get(0).getEdpUsrPoTrnsHeadrId()) {
				uploadLocation = EDPUtility.checkUploadLocationExists(entityList.get(0).getEdpUsrPoTrnsHeadrId().getEdpUsrPoTrnsHeaderId(),
						EDPConstant.POST_TRANSFER_MENU_ID);
			}
			for (EDPUsrPoTrnsAttEntity entity : entityList) {
				MultipartFile multipartFile = entity.getFile();
				entity.setUploadedBy(user);
				entity.setUploadedFileSize(EDPUtility.getFileSizeinKB(multipartFile));
				entity.setUploadedFileName(multipartFile.getOriginalFilename());
				ClueDto response = EDPUtility.uploadAttachmentInFileNet(multipartFile, uploadLocation);
				entity.setUploadedFilePath(response.getDocumentId());
			}
			entityList = edpUsrPoTrnsAttRepository.saveAll(entityList);
			List<EDPUsrPoTrnsAttItrEntity> listItr = edpUsrPoTrnsAttItrConverter.toItrEntity(entityList);
			edpUsrPoTrnsAttItrRepository.saveAll(listItr);
			return entityList;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Delete UP mapping attachment.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteUPMappingAttachment(Long id) throws CustomException {
		try {
			Optional<EDPUsrPoTrnsAttEntity> edpUsrPoTrnsAttEntity = edpUsrPoTrnsAttRepository.findById(id);
			int activeStatus = edpUsrPoTrnsAttEntity.isPresent() ? edpUsrPoTrnsAttEntity.get().getActiveStatus() : 0;
			if (activeStatus == 1) {
				edpUsrPoTrnsAttEntity.get().setActiveStatus(0);
				edpUsrPoTrnsAttRepository.save(edpUsrPoTrnsAttEntity.get());
			}
		} catch (DataIntegrityViolationException e) {
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	/**
	 * Downloadcreate UP mapping attachment files.
	 *
	 * @param id the id
	 * @return the resource
	 * @throws CustomException the custom exception
	 */
	@Override
	public ClueDto downloadcreateUPMappingAttachmentFiles(Long id) throws CustomException {
		try {
			Optional<EDPUsrPoTrnsAttEntity> edpOfficeAttachmentEntity = edpUsrPoTrnsAttRepository.findById(id);
			if(edpOfficeAttachmentEntity.isPresent()) {
				String documentId = edpOfficeAttachmentEntity.get().getUploadedFilePath();
				return EDPUtility.downloadFileNetFile(documentId,edpOfficeAttachmentEntity.get().getUploadedFileName());
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
			}
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DOWNLOAD);
		}
	}

	/**
	 * Gets the all attechments for post transfer.
	 *
	 * @return the all attechments for post transfer
	 */
	@Override
	public List<EDPMsAttachmentEntity> getAllAttechmentsForPostTransfer() {
		Set<String> attachmentTypes = new HashSet<>();
		attachmentTypes.add(EDPConstant.POST_MAPPING_ATTACHMENT);
		attachmentTypes.add(Constant.COMMON_ATTACHMENT);
		List<EDPLuLookUpInfoEntity> lookUpInfoList = edpLuLookUpInfoRepository.findByLookUpInfoNameIn(attachmentTypes);
		return edpMsAttachmentRepository.findByAttahcmentTypeLookUpInfoIdIn(
				lookUpInfoList.stream().map(EDPLuLookUpInfoEntity::getLookUpInfoId).collect(Collectors.toSet()));
	}

}
