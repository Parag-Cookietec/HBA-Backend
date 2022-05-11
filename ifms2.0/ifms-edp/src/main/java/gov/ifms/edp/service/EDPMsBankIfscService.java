package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsBankIfscDto;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;

/**
 * The Class EDPMsBankIfscController.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:17:24
 *
 */
public interface EDPMsBankIfscService {
	/**
	 * Retrieves an EDPMsBankIfscEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsBankIfscEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsBankIfscEntity getMsBankIfsc(Long id);

	/**
	 * Saves a given EDPMsBankIfscEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsBankIfscEntity
	 */
	public EDPMsBankIfscEntity saveOrUpdateMsBankIfsc(EDPMsBankIfscEntity entity);

	/**
	 * Fetch all the EDPMsBankIfsc items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsBankIfscDto>
	 */
	public PagebleDTO<EDPMsBankIfscDto> getMsBankIfscs(PageDetails pageDetail) throws CustomException;
}
