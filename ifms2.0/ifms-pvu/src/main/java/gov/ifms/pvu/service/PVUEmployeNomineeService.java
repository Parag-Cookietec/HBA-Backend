package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeNomineeDto;
import gov.ifms.pvu.entity.PVUEmployeNomineeEntity;
/**
 * The Class PVUEmployeNomineeService.
 * 
 * @version v 1.0
 * @created 2019/11/27 03:02:40
 *
 */
public interface PVUEmployeNomineeService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeNomineeEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeNomineeEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeNomineeEntity getEmployeNominee(Long id);

	/**
	 * Saves a given PVUEmployeNomineeEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeNomineeEntity
	 */
	public PVUEmployeNomineeEntity saveOrUpdateEmployeNominee(PVUEmployeNomineeEntity entity);

	/**
	 * Fetch all the PVUEmployeNominee items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeNomineeDto>
	 */
	public PagebleDTO<PVUEmployeNomineeDto> getEmployeNominees(PageDetails pageDetail) throws CustomException;
}
