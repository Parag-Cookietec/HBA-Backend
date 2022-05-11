package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsDistrictDto;
import gov.ifms.edp.entity.EDPMsDistrictEntity;

/**
 * The Interface EDPMsDistrictService.
 */
public interface EDPMsDistrictService {
	/**
	 * Retrieves an EDPDistrictNameEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPDistrictNameEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsDistrictEntity getDistrictName(Long id);

	/**
	 * Saves a given EDPDistrictNameEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPDistrictNameEntity
	 */
	public EDPMsDistrictEntity saveOrUpdateDistrictName(EDPMsDistrictEntity entity);

	/**
	 * Fetch all the EDPDistrictName items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPDistrictNameDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPMsDistrictDto> getDistrictNames(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all district.
	 *
	 * @return the all district
	 */
	public List<EDPMsDistrictEntity> getAllDistrict();
}
