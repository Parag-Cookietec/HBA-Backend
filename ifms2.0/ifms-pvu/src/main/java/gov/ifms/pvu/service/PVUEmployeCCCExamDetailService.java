package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailDto;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
/**
 * The Class PVUEmployeCCCExamDetailService.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:30:53
 *
 */
public interface PVUEmployeCCCExamDetailService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeCCCExamDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeCCCExamDetailEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeCCCExamDetailEntity getEmployeCCCExamDetail(Long id);

	/**
	 * Saves a given PVUEmployeCCCExamDetailEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeCCCExamDetailEntity
	 */
	public PVUEmployeCCCExamDetailEntity saveOrUpdateEmployeCCCExamDetail(PVUEmployeCCCExamDetailEntity entity);

	/**
	 * Fetch all the PVUEmployeCCCExamDetail items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeCCCExamDetailDto>
	 */
	public PagebleDTO<PVUEmployeCCCExamDetailDto> getEmployeCCCExamDetails(PageDetails pageDetail) throws CustomException;
}
