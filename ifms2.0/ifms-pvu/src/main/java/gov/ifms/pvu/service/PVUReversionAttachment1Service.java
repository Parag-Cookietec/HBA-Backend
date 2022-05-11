package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUReversionAttachmentDto;
import gov.ifms.pvu.entity.PVUReversionAttachmentEntity;

/**
 * The Class PVUReversionAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 *
 */
public interface PVUReversionAttachment1Service  {
	/**
	 * Retrieves an PVUReversionAttachmentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUReversionAttachmentEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUReversionAttachmentEntity getReversionAttachment(Long id);

	/**
	 * Saves a given PVUReversionAttachmentEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUReversionAttachmentEntity
	 */
	public PVUReversionAttachmentEntity saveOrUpdateReversionAttachment(PVUReversionAttachmentEntity entity);

	/**
	 * Saves all given PVUReversionAttachmentEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	// public void deleteReversionAttachment(long id,int isDelete); // uncomment
	// method when require delete api

	/**
	 * Fetch all the PVUReversionAttachment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUReversionAttachmentDto>
	 */
	public PagebleDTO<PVUReversionAttachmentDto> getReversionAttachments(PageDetails pageDetail) throws CustomException;
}
