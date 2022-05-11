package gov.ifms.edp.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;

/**
 * The Interface EDPMsSubOfficeService.
 */
public interface EDPMsSubOfficeService {
	/**
	 * Retrieves an EDPMsSubOfficeEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsSubOfficeEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsSubOfficeEntity getMsSubOffice(Long id);

	/**
	 * Saves a given EDPMsSubOfficeEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsSubOfficeEntity
	 * @throws CustomException the custom exception
	 */
	public EDPMsSubOfficeEntity saveOrUpdateMsSubOffice(EDPMsSubOfficeEntity entity, EDPMsSubOfficeDto dto) throws CustomException;

	/**
	 * Saves all given EDPMsSubOfficeEntity entities.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @return the saved entities
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteMsSubOffice(Long id, int activeStatus)  throws CustomException ;
	
	/**
	 * Fetch all the EDPMsSubOffice items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsSubOfficeDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPMsSubOfficeDto> getMsSubOffices(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Gets the sub office code.
	 *
	 * @param officeId the office id
	 * @return the sub office code
	 * @throws CustomException the custom exception
	 */
	public String getSubOfficeCode(Long officeId) throws CustomException;
	
	public void updateSubOfficeItr(Long id, int activeStatus) throws CustomException;

	/**
	 * Save Sub Office Details
	 * 
	 * @param EDPMsOfficeEntity
	 */
	public void updateAllSubOfficeData(EDPMsOfficeEntity officeEntity);

	/**
	 * Updates sub offices request of particular office based on office details.
	 * 
	 * @param EDPMsOfficeEntity
	 */
	public void updateSubOfficeItr(EDPMsOfficeEntity officeEntity);

	public void copyMsSubOffice(EDPMsOfficeEntity newOfficeEntity, EDPUpdateOfficeTrnEntity officeTrnEntity);

	/**
	 * Approve all Sub Office of Update Request
	 * 
	 * @param officeId
	 * @param officeTrnId 
	 * @throws CustomException 
	 */
	public void approveAllSubOfficeUpdate(Long officeId, Long officeTrnId) throws CustomException;
}
