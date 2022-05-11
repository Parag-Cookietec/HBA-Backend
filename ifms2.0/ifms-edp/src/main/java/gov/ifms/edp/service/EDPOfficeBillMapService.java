package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeBillMapDto;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;

/**
 * The Interface EDPOfficeBillMapService.
 */
public interface EDPOfficeBillMapService {
	/**
	 * Retrieves an EDPofficeBillMapEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPofficeBillMapEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPOfficeBillMapEntity getofficeBillMap(Long id);

	/**
	 * Saves a given EDPofficeBillMapEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPofficeBillMapEntity
	 */
	public EDPOfficeBillMapEntity saveOrUpdateofficeBillMap(EDPOfficeBillMapEntity entity);

	/**
	 * Saves all given EDPofficeBillMapEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteofficeBillMap(long id, int isDelete);

	/**
	 * Fetch all the EDPofficeBillMap items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPofficeBillMapDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeBillMapDto> getofficeBillMaps(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Save office bill map.
	 *
	 * @param dto the dto
	 * @return the EDP office bill map entity
	 */
	public void saveOfficeBillMap(EDPMsOfficeDto dto, boolean isUpdate);

	/**
	 * Updates Mapped Bills in request table for particular Office based details
	 * provided.
	 *
	 * @param EDPMsOfficeDto
	 */
	public void updateOfficeBillsItr(EDPMsOfficeDto dto);

	/**
	 * Approve Office Bills
	 * 
	 * @param dto
	 */
	public void approveOfficeBillMap(EDPMsOfficeDto dto);

	public List<Long> getSubmitedOfficeIdByOfficeId(Long officeId);
}
