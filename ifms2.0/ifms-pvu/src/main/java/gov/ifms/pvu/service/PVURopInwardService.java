package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeDetailsDto;
import gov.ifms.pvu.dto.PVURopInwardView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVURopInwardEntity;

/**
 * The Class PVURopInwardController.
 * 
 * @version v 1.0
 * @created 2020/03/12 14:42:25
 *
 */
public interface PVURopInwardService {
	/**
	 * Retrieves an PVURopInwardEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopInwardEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVURopInwardEntity getRopInward(Long id);

	/**
	 * Saves a given PVURopInwardEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopInwardEntity
	 */
	public PVURopInwardEntity saveOrUpdateRopInward(PVURopInwardEntity entity);

	/**
	 * Fetch all the PVURopInward items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopInwardDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVURopInwardView> getRopInwards(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	List<PVUSearchEnum> getPvuSearchFields();

	/**
	 * Gets the inward lu look up info as map.
	 *
	 * @return the inward lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeDetailsDto getInwardLuLookUpInfo() throws CustomException;

	/**
	 * Generate inward number.
	 *
	 * @param dto the field value
	 * @return 
	 * @throws CustomException 
	 */
	public Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;

	/**
	 * Submit rop inward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean submitRopInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

	/**
	 * Submit rop distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException 
	 */
	public Boolean submitRopDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

}
