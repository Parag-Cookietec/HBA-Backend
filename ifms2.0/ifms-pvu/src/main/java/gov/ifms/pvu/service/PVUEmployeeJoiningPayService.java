package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeeJoiningPayDto;
import gov.ifms.pvu.entity.PVUEmployeeJoiningPayEntity;

/**
 * The Class PVUEmployeeJoiningPayController.
 * 
 * @version v 1.0
 * @created 2020/05/15 11:25:19
 *
 */
public interface PVUEmployeeJoiningPayService {
	/**
	 * Retrieves an PVUEmployeeJoiningPayEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeeJoiningPayEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeeJoiningPayEntity getEmployeeJoiningPay(Long id);

	/**
	 * Saves a given PVUEmployeeJoiningPayEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeeJoiningPayEntity
	 */
	public PVUEmployeeJoiningPayEntity saveOrUpdateEmployeeJoiningPay(PVUEmployeeJoiningPayEntity entity);

	/**
	 * Fetch all the PVUEmployeeJoiningPay items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeeJoiningPayDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUEmployeeJoiningPayDto> getEmployeeJoiningPays(PageDetails pageDetail) throws CustomException;
}
