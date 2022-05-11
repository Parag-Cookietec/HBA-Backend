package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUForgoAttachmentDto;
import gov.ifms.pvu.entity.PVUForgoAttachmentEntity;

/**
 * The Class PVUForgoAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/01/13 11:47:13
 *
 */
public interface PVUForgoAttachmentService {
	/**
	 * Retrieves an PVUForgoAttachmentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUForgoAttachmentEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUForgoAttachmentEntity getForgoAttachment(Long id);

	/**
	 * Saves a given PVUForgoAttachmentEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUForgoAttachmentEntity
	 */
	public PVUForgoAttachmentEntity saveOrUpdateForgoAttachment(PVUForgoAttachmentEntity entity);

	/**
	 * Fetch all the PVUForgoAttachment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUForgoAttachmentDto>
	 */
	public PagebleDTO<PVUForgoAttachmentDto> getForgoAttachments(PageDetails pageDetail) throws CustomException;
}
