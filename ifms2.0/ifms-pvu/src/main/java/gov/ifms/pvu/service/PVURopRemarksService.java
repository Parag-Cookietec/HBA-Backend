package gov.ifms.pvu.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.entity.PVURopRemarksEntity;

/**
 * The Class PVURopRemarksEntityController.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 *
 */
public interface PVURopRemarksService {
	/**
	 * Retrieves an PVURopRemarksEntityEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopRemarksEntityEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVURopRemarksEntity getRopRemarks(Long id);

	/**
	 * Saves a given PVURopRemarksEntityEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopRemarksEntityEntity
	 */
	public PVURopRemarksEntity saveOrUpdateRopRemarks(PVURopRemarksEntity entity);

	/**
	 * Fetch all the PVURopRemarksEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopRemarksEntityDto>
	 */
	public PagebleDTO<PVURopRemarksDto> getRopRemarks(PageDetails pageDetail) throws CustomException;

	public void deactiveOldReason(Long id, int inActiveStatus);

	public void saveOrUpdateRopRemarksAll(List<PVURopRemarksEntity> lstRopRemarks);

}
