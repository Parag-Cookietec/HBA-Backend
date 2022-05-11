package gov.ifms.pvu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;
import gov.ifms.pvu.repository.PVUCareerAdvanceAttachmentsRepository;

/**
 * The Class PVUCareerAdvanceAttachmentsController.
 * 
 * @version v 1.0
 * @created 2020/01/17 11:30:23
 */
@Service
public class PVUCareerAdvanceAttachmentsServiceImpl implements PVUCareerAdvanceAttachmentsService {

	/** The PVUCareerAdvanceAttachmentsAsMethodName repository. */
	@Autowired
	private PVUCareerAdvanceAttachmentsRepository repository;

	/**
	 * Retrieves an PVUCareerAdvanceAttachmentsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUCareerAdvanceAttachmentsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUCareerAdvanceAttachmentsEntity getCareerAdvanceAttachments(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUCareerAdvanceAttachmentsEntity. Use the returned instance
	 * for further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUCareerAdvanceAttachmentsEntity
	 */
	@Override
	public PVUCareerAdvanceAttachmentsEntity saveOrUpdateCareerAdvanceAttachments(
			PVUCareerAdvanceAttachmentsEntity entity) {
		return repository.save(entity);
	}

	
}
