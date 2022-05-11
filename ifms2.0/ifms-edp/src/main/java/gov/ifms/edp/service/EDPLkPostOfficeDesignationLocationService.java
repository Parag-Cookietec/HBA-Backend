package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPLkPostOfficeDesignationLocationDto;
import gov.ifms.edp.entity.EDPLkPostOfficeDesignationLocationEntity;

/**
 * The Interface EDPLkPostOfficeDesignationLocationService.
 */
public interface EDPLkPostOfficeDesignationLocationService {
	
     /**
	 * Returns all instances of the EDPLkPostOfficeDesignationLocationEntity type.
	 * 
	 * @return all EDPLkPostOfficeDesignationLocationEntity
	 */
	List<EDPLkPostOfficeDesignationLocationEntity> getLkPostOfficeDesignationLocations();	

	/**
	 * Retrieves an EDPLkPostOfficeDesignationLocationEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkPostOfficeDesignationLocationEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPLkPostOfficeDesignationLocationEntity getLkPostOfficeDesignationLocation(Long id);

	/**
	 * Saves a given EDPLkPostOfficeDesignationLocationEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkPostOfficeDesignationLocationEntity
	 */
	EDPLkPostOfficeDesignationLocationEntity saveOrUpdateLkPostOfficeDesignationLocation(EDPLkPostOfficeDesignationLocationEntity entity);

	/**
	 * Saves all given EDPLkPostOfficeDesignationLocationEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPLkPostOfficeDesignationLocationEntity> saveLkPostOfficeDesignationLocations(List<EDPLkPostOfficeDesignationLocationEntity> entities);

	/**
	 * Deletes the EDPLkPostOfficeDesignationLocationEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteLkPostOfficeDesignationLocation(Long id);

	
	/**
	 * Fetch all the EDPLkPostOfficeDesignationLocation items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPostOfficeDesignationLocationDto>
	 */
	PagebleDTO<EDPLkPostOfficeDesignationLocationDto> edpLkPostOfficeDesignationLocationAsMethodNameSearch(PageDetails pageDetail);

}
