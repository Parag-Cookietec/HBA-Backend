package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;

/**
 * The Interface EDPSubOfficeItrService.
 */
public interface EDPSubOfficeItrService {
	/**
	 * Retrieves an EDPsubOfficeItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPsubOfficeItrEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPSubOfficeItrEntity getsubOfficeItr(Long id);

	/**
	 * Saves a given EDPsubOfficeItrEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPsubOfficeItrEntity
	 * @throws CustomException the custom exception
	 */
	public EDPSubOfficeItrEntity saveOrUpdatesubOfficeItr(EDPSubOfficeItrEntity entity) throws CustomException;

	/**
	 * Saves all given EDPsubOfficeItrEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deletesubOfficeItr(long id,int isDelete) throws CustomException;
	
	/**
	 * Fetch all the EDPsubOfficeItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPsubOfficeItrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPMsSubOfficeDto> getsubOfficeItrs(PageDetails pageDetail) throws CustomException;
}
