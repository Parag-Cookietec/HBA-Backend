package gov.ifms.pvu.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.attachment.service.AttachmentServiceImpl;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class BasePVUAttachmentService.
 *
 * @param <E> the element type
 * @param <D> the generic type
 */
public abstract class BasePVUAttachmentService<E extends BasePVUAttachmentEntity, D extends BasePVUAttachmentDto> {

	
	/**
	 * Gets the repository.
	 *
	 * @return the repository
	 */
	public abstract BasePVUAttachmentRepository<E> getRepository();

	/**
	 * Gets the converter.
	 *
	 * @return the converter
	 */
	public abstract BasePVUAttachmentConverter<E, D> getConverter();

	/**
	 * Gets the attachment by reference id.
	 *
	 * @param dto the dto
	 * @return the attachment by reference id
	 */
	public abstract List<E> getAttachmentByReferenceId(IdDto dto);

	/**
	 * Update status as delete.
	 *
	 * @param dto the dto
	 */
	public abstract void updateStatusAsDelete(IdDto dto);

	/** The attachment service. */
	@Autowired
	private AttachmentServiceImpl attachmentService;

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<E> findById(Long id) {
		if (id == null) {
			return Optional.empty();
		}
		return getRepository().findById(id);
	}

	/**
	 * Gets the one by id.
	 *
	 * @param id the id
	 * @return the one by id
	 * @throws CustomException the custom exception
	 */
	public E getOneById(Long id) throws CustomException {
		if (id == null) {
			return null;
		}
		Optional<E> one = getRepository().findById(id);
		if (one.isPresent()) {
			return one.get();
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	/**
	 * Save.
	 *
	 * @param dto the dto
	 * @return the d
	 */
	public D save(D dto) {
		E entity;
		if (dto == null) {
			return null;
		} else if (dto.getId() != null) {
			entity = getRepository().getOne(dto.getId());
		} else {
			entity = getConverter().createEntity();
		}
		getConverter().toEntity(entity, dto);
		return getConverter().toDTO(getRepository().save(entity));
	}

	/**
	 * Upload.
	 *
	 * @param dto the dto
	 * @return the file upload response dto
	 * @throws CustomException the custom exception
	 */
	public FileUploadResponseDto upload(D dto) throws CustomException {
		AttachmentMasterDto request = BasePVUAttachmentDto.createAttachment(dto);
		List<FileUploadResponseDto> postAttachment = this.attachmentService.createPostAttachment(request);
		if (CollectionUtils.isNotEmpty(postAttachment)) {
			FileUploadResponseDto response = postAttachment.get(0);
			E entity;
			dto.setUploadFileName(response.getFilename());
			dto.setUploadFilePath(response.getUploadDirPath());
			dto.setDocumentId(response.getDocumentId());
			dto.setUploadFileSize(EDPUtility.getFileSizeinKB(request.getAttachment().get(0)));
			dto.setRolePrmId(dto.getRolePrmId());
			dto.setVersionId(0);
			dto.setActiveStatus(1);
			dto.setAttachmentTypeId(dto.getAttachmentTypeId());
			dto.setTransactionId(request.getTransactionId());
			entity = getConverter().toEntity(dto);
			EDPMsUserEntity uploadedBy = new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
			entity.setUploadedBy(uploadedBy);
			getRepository().save(entity);
			return postAttachment.get(0);
		}
		return null;
	}

	/**
	 * Gets the all attachment by id.
	 *
	 * @param dto the dto
	 * @return the all attachment by id
	 */
	public List<D> getAllAttachmentById(IdDto dto) {
		if (dto.getId() != null) {
			List<E> all = getAttachmentByReferenceId(dto);
			return getConverter().toDTO(all);
		}
		return Collections.emptyList();
	}

	/**
	 * Upload.
	 *
	 * @param uploadDto the upload dto
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<FileUploadResponseDto> upload(List<D> uploadDto) throws CustomException {
		List<FileUploadResponseDto> collect = new ArrayList<>();
		for (D d : uploadDto) {
			FileUploadResponseDto upload = upload(d);
			collect.add(upload);
		}
		return collect;
	}

}
