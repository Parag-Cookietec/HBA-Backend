package gov.ifms.pvu.service;

import gov.ifms.pvu.dto.PVUEmployeFixPayDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;

/**
 * The Class PVUEmployeFixPayDetailsController.
 * 
 * @version v 1.0
 * @created 2020/01/08 20:46:39
 *
 */
public interface PVUEmployeFixPayDetailsService {
	/**
	 * Retrieves an PVUEmployeFixPayDetailsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeFixPayDetailsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeFixPayDetailsEntity getEmployeFixPayDetails(Long id);

	/**
	 * Saves a given PVUEmployeFixPayDetailsEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeFixPayDetailsEntity
	 */
	public PVUEmployeFixPayDetailsEntity saveOrUpdateEmployeFixPayDetails(PVUEmployeFixPayDetailsEntity entity);

	
	/**
	 * Retrieves an PVUEmployeFixPayDetailsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeFixPayDetailsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeFixPayDetailsDto getEmployeFixPay(Long id);
}
