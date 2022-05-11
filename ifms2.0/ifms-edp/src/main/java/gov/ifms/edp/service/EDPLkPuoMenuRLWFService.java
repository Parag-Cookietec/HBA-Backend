package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPLkPuoMenuRLWFDto;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;

/**
 * The Interface EDPLkPuoMenuRLWFService.
 */
public interface EDPLkPuoMenuRLWFService {
	/**
	 * Retrieves an EDPLkPuoMenuRLWFEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkPuoMenuRLWFEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPTrnUsrMnuWfRole getLkPuoMenuRLWF(Long id);

	/**
	 * Saves a given EDPLkPuoMenuRLWFEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkPuoMenuRLWFEntity
	 */
	public EDPTrnUsrMnuWfRole saveOrUpdateLkPuoMenuRLWF(EDPTrnUsrMnuWfRole entity);

	/**
	 * Saves all given EDPLkPuoMenuRLWFEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteLkPuoMenuRLWF(long id,int isDelete);
	
	/**
	 * Fetch all the EDPLkPuoMenuRLWF items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPuoMenuRLWFDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPLkPuoMenuRLWFDto> getLkPuoMenuRLWFs(PageDetails pageDetail) throws CustomException;
}
