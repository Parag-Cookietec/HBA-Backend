package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;

/**
 * The Class PVUEmployeDeptExamDetailsService.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:15:41
 *
 */
public interface PVUEmployeDeptExamDetailsService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeDeptExamDetailsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeDeptExamDetailsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeDeptExamDetailsEntity getEmployeDeptExamDetails(Long id);

	/**
	 * Saves a given PVUEmployeDeptExamDetailsEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeDeptExamDetailsEntity
	 */
	public PVUEmployeDeptExamDetailsEntity saveOrUpdateEmployeDeptExamDetails(PVUEmployeDeptExamDetailsEntity entity);

	/**
	 * Fetch all the PVUEmployeDeptExamDetails items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeDeptExamDetailsDto>
	 */
	public PagebleDTO<PVUEmployeDeptExamDetailsDto> getEmployeDeptExamDetailss(PageDetails pageDetail)
			throws CustomException;
}
