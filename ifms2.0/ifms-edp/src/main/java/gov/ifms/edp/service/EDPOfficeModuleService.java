package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeModuleDto;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;

/**
 * The Interface EDPOfficeModuleService.
 */
public interface EDPOfficeModuleService {
	/**
	 * Retrieves an EDPOfficeModuleEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPOfficeModuleEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPOfficeModuleEntity getOfficeModule(Long id);

	/**
	 * Saves a given EDPOfficeModuleEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPOfficeModuleEntity
	 */
	public EDPOfficeModuleEntity saveOrUpdateOfficeModule(EDPOfficeModuleEntity entity);

	/**
	 * Saves all given EDPOfficeModuleEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteOfficeModule(long id,int isDelete);
	
	/**
	 * Fetch all the EDPOfficeModule items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPOfficeModuleDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeModuleDto> getOfficeModules(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Save office id and module id.
	 *
	 * @param dto the dto
	 */
	public void saveOfficeIdAndModuleId(EDPMsOfficeDto dto);
}
