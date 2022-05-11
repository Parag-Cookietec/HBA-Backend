package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeLangExamDto;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
/**
 * The Class PVUEmployeLangExamService.
 * 
 * @version v 1.0
 * @created 2019/11/27 23:55:09
 *
 */
public interface PVUEmployeLangExamService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployeLangExamEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeLangExamEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeLangExamEntity getEmployeLangExam(Long id);

	/**
	 * Saves a given PVUEmployeLangExamEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeLangExamEntity
	 */
	public PVUEmployeLangExamEntity saveOrUpdateEmployeLangExam(PVUEmployeLangExamEntity entity);

	/**
	 * Fetch all the PVUEmployeLangExam items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeLangExamDto>
	 */
	public PagebleDTO<PVUEmployeLangExamDto> getEmployeLangExams(PageDetails pageDetail) throws CustomException;
}
