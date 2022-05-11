package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPLkDistrictGiaDto;
import gov.ifms.edp.entity.EDPLkDistrictGiaEntity;
/**
 * The Class EDPLkDistrictGiaController.
 * 
 * @version v 1.0
 * @created 2020/07/07 11:40:45
 *
 */
public interface EDPLkDistrictGiaService {
	/**
	 * Retrieves an EDPLkDistrictGiaEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkDistrictGiaEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPLkDistrictGiaEntity getLkDistrictGia(Long id);

	/**
	 * Saves a given EDPLkDistrictGiaEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkDistrictGiaEntity
	 */
	public EDPLkDistrictGiaEntity saveOrUpdateLkDistrictGia(EDPLkDistrictGiaEntity entity);

	/**
	 * Saves all given EDPLkDistrictGiaEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	//public void deleteLkDistrictGia(long id,int isDelete);  // uncomment method when require  delete api 
	
	/**
	 * Fetch all the EDPLkDistrictGia items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkDistrictGiaDto>
	 */
	public PagebleDTO<EDPLkDistrictGiaDto> getLkDistrictGias(PageDetails pageDetail) throws CustomException;
}
