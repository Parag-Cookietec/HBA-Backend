package gov.ifms.edp.service;

import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.dto.EDPLkPostOfficeDto;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;

/**
 * The Interface EDPLkPostOfficeService.
 */
public interface EDPLkPostOfficeService {
	/**
	 * Retrieves an EDPLkPostOfficeEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkPostOfficeEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPLkPostOfficeEntity getLkPostOffice(Long id);

	/**
	 * Saves a given EDPLkPostOfficeEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkPostOfficeEntity
	 */
	public EDPLkPostOfficeEntity saveOrUpdateLkPostOffice(EDPLkPostOfficeEntity entity);

	/**
	 * Saves all given EDPLkPostOfficeEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteLkPostOffice(long id,int isDelete);
	
	/**
	 * Fetch all the EDPLkPostOffice items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPostOfficeDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPLkPostOfficeDto> getLkPostOffices(PageDetails pageDetail) throws CustomException;
}