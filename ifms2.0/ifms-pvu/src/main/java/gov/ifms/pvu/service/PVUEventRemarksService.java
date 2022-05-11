package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;

/**
 * The Class PVUEventRemarksService.
 */
public interface PVUEventRemarksService {
	/**
	 * Retrieves an PVUEventRemarksEntityEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEventRemarksEntityEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	PVUEventRemarksEntity getOne(Long id);

	/**
	 * Saves a given PVUEventRemarksEntityEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEventRemarksEntityEntity
	 */
	PVUEventRemarksEntity saveOrUpdateEventRemarks(PVUEventRemarksEntity entity);

	/**
	 * Fetch all the PVUEventRemarksEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEventRemarksEntityDto>
	 */
	PagebleDTO<PVUEventRemarksDto> getOne(PageDetails pageDetail) throws CustomException;

	void deactiveOldReason(Long eventId, Long id, int inActiveStatus);

	void deActivateOldReason(Long id, Long eventId);

	void saveOrUpdateRemarksAll(List<PVUEventRemarksEntity> lstRopRemarks);

	List<PVUEventRemarksEntity> saveAll(List<PVUEventRemarksEntity> entities);

	List<PVUEventRemarksDto> getReturnRemarks(Long trnId, Long eventId) throws CustomException;


}
