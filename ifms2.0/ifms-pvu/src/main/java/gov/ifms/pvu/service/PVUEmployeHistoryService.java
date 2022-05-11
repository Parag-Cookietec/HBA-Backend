package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeHistoryDto;
import gov.ifms.pvu.entity.PVUEmployeHistoryEntity;

/**
 * The Class PVUEmployeHistoryService.
 * 
 * @version v 1.0
 * @created 2019/11/29 17:29:29
 *
 */
public interface PVUEmployeHistoryService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeHistoryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeHistoryEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeHistoryEntity getEmployeHistory(Long id);

	/**
	 * Saves a given PVUEmployeHistoryEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeHistoryEntity
	 */
	public PVUEmployeHistoryEntity saveOrUpdateEmployeHistory(List<PVUEmployeHistoryEntity> entity);

	/**
	 * Saves all given PVUEmployeHistoryEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	/**
	 * Fetch all the PVUEmployeHistory items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeHistoryDto>
	 */
	public PagebleDTO<PVUEmployeHistoryDto> getEmployeHistorys(PageDetails pageDetail) throws CustomException;

	/**
	 *
	 * @param id
	 * @param activeStatus
	 */
	public void deleteStatus(Long id, Integer activeStatus);

}
