package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUMsGradePayDto;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;

/**
 * The Class PVUGradePayService.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:25:42
 *
 */
public interface PVUMsGradePayService {
	/**
	 * Retrieves an PVUMsGradePayEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsGradePayEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUMsGradePayEntity getPVUGradePay(Long id);

	/**
	 * Saves a given PVUMsGradePayEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsGradePayEntity
	 */
	public PVUMsGradePayEntity saveOrUpdatePVUGradePay(PVUMsGradePayEntity entity);

	/**
	 * Fetch all the PVUGradePay items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsGradePayDto>
	 */
	public PagebleDTO<PVUMsGradePayDto> getPVUGradePays(PageDetails pageDetail) throws CustomException;
}
