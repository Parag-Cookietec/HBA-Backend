package gov.ifms.pvu.service;

import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;

/**
 * The Class PVUCareerAdvanceAttachmentsController.
 * 
 * @version v 1.0
 * @created 2020/01/17 11:30:23
 *
 */
public interface PVUCareerAdvanceAttachmentsService {
	/**
	 * Retrieves an PVUCareerAdvanceAttachmentsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUCareerAdvanceAttachmentsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUCareerAdvanceAttachmentsEntity getCareerAdvanceAttachments(Long id);

	/**
	 * Saves a given PVUCareerAdvanceAttachmentsEntity. Use the returned instance
	 * for further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUCareerAdvanceAttachmentsEntity
	 */
	public PVUCareerAdvanceAttachmentsEntity saveOrUpdateCareerAdvanceAttachments(
			PVUCareerAdvanceAttachmentsEntity entity);

}
