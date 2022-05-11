package gov.ifms.edp.service;


import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPBillObjectClassMapDto;
import gov.ifms.edp.dto.EDPBillTypeObjectClassMappingDTO;
import gov.ifms.edp.entity.EDPBillObjectClassMapEntity;

/**
 * The Interface EDPBillObjectClassMapService.
 */
public interface EDPBillObjectClassMapService {
	
	/**
	 * Retrieves an EDPBillObjectClassMapEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPBillObjectClassMapEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public EDPBillObjectClassMapEntity getBillObjectClassMap(Long id);

	/**
	 * Saves a given EDPBillObjectClassMapDto. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved EDPBillObjectClassMapDto
	 */
	public EDPBillObjectClassMapDto saveOrUpdateBillObjectClassMap(EDPBillObjectClassMapDto dto);
	
	/**
	 * Saves a given EDPBillObjectClassMapEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved EDPBillObjectClassMapEntity
	 */
	public EDPBillObjectClassMapEntity saveOrUpdateBillObjectClassMap(EDPBillObjectClassMapEntity dto);

	/**
	 * Saves all given EDPBillObjectClassMapEntity entities.
	 *
	 * @param id the id
	 * @param isDelete the is delete
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteBillObjectClassMap(long id, int isDelete);

	/**
	 * Fetch all the EDPBillObjectClassMap items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPBillObjectClassMapDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPBillObjectClassMapDto> getBillObjectClassMaps(PageDetails pageDetail) throws CustomException;
	
	/**
	 * Gets the bill object type details.
	 *
	 * @return the bill object type details
	 */
	public EDPBillTypeObjectClassMappingDTO geBillObjectClassTypeDetails();

	/**
	 * Gets the object class.
	 *
	 * @param id the id
	 * @return the object class
	 */
	public EDPBillTypeObjectClassMappingDTO getObjectClass(Long id);
}
