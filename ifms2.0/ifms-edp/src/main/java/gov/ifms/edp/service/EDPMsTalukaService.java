package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsTalukaDto;
import gov.ifms.edp.entity.EDPMsTalukaEntity;

/**
 * The Interface EDPMsTalukaService.
 */
public interface EDPMsTalukaService {
	/**
	 * Retrieves an EDPMsTalukaEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsTalukaEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsTalukaEntity getMsTaluka(Long id);

	/**
	 * Saves a given EDPMsTalukaEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsTalukaEntity
	 */
	public EDPMsTalukaEntity saveOrUpdateMsTaluka(EDPMsTalukaEntity entity);

	/**
	 * Saves all given EDPMsTalukaEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteMsTaluka(long id,int isDelete);
	
	/**
	 * Fetch all the EDPMsTaluka items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsTalukaDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPMsTalukaDto> getMsTalukas(PageDetails pageDetail) throws CustomException;
}
