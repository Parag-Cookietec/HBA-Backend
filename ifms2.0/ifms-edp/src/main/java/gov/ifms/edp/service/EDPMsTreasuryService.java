package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsTreasuryDto;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;

/**
 * The Interface EDPMsTreasuryService.
 */
public interface EDPMsTreasuryService {
	
	/**
	 * Retrieves an EDPMsTreasuryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsTreasuryEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPMsTreasuryEntity getMsTreasury(Long id);

	/**
	 * Saves a given EDPMsTreasuryEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsTreasuryEntity
	 */
	public EDPMsTreasuryEntity saveOrUpdateMsTreasury(EDPMsTreasuryEntity entity);

	/**
	 * Saves all given EDPMsTreasuryEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteMsTreasury(long id, int isDelete);

	/**
	 * Fetch all the EDPMsTreasury items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsTreasuryDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPMsTreasuryDto> getMsTreasurys(PageDetails pageDetail) throws CustomException;
	
	/**
	 * This method is used to get treasury by district id
	 * 
	 * @param districtId
	 * @return List<ClueDto>
	 */
	public List<ClueDto> getMsTreasurysByDistrictId(Long districtId);
	
	
	/**
	 * This method is used to check treasury off name 
	 * 
	 * @param districtId
	 * @return List<ClueDto>
	 */
	public List<EDPMsTreasuryEntity> checkToNameByDistrictId(ClueDto clueDto);
}
