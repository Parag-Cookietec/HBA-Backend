package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmpBankDetailDto;
import gov.ifms.pvu.entity.PVUEmpBankDetailEntity;

/**
 * The Class PVUEmpBankDetailController.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:22:19
 *
 */
public interface PVUEmpBankDetailService {
	/**
	 * Retrieves an PVUEmpBankDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmpBankDetailEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmpBankDetailEntity getEmpBankDetail(Long id);

	/**
	 * Saves a given PVUEmpBankDetailEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmpBankDetailEntity
	 */
	public PVUEmpBankDetailEntity saveOrUpdateEmpBankDetail(PVUEmpBankDetailEntity entity);

	/**
	 * Fetch all the PVUEmpBankDetail items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmpBankDetailDto>
	 */
	public PagebleDTO<PVUEmpBankDetailDto> getEmpBankDetails(PageDetails pageDetail) throws CustomException;
}
