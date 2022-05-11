package gov.ifms.workflow.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.workflow.dto.EdpTrnOffModWfDto;
import gov.ifms.workflow.entity.EdpTrnOffModWfEntity;

/**
 * The Interface EdpTrnOffModWfService.
 */
public interface EdpTrnOffModWfService {
	
	/**
	 * Gets the trn edp wfs.
	 *
	 * @return the trn edp wfs
	 */
	List<EdpTrnOffModWfEntity> getTrnEdpWfs();	

	/**
	 * Gets the trn edp wf.
	 *
	 * @param id the id
	 * @return the trn edp wf
	 */
	EdpTrnOffModWfEntity getTrnEdpWf(Long id);

	/**
	 * Save or update trn edp wf.
	 *
	 * @param entity the entity
	 * @return the trn edp wf entity
	 */
	EdpTrnOffModWfEntity saveOrUpdateTrnEdpWf(EdpTrnOffModWfEntity entity);

	/**
	 * Save trn edp wf.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	List<EdpTrnOffModWfEntity> saveTrnEdpWf(List<EdpTrnOffModWfEntity> entities);

	/**
	 * Delete trn edp wf.
	 *
	 * @param id the id
	 */
	void deleteTrnEdpWf(Long id);

	/**
	 * Trn edp wf as method name search.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 */
	PagebleDTO<EdpTrnOffModWfDto> trnEdpWfAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * Save or update trn Edp wf sp.
	 *
	 * @param dto
	 * @return
	 */
	Long saveOrUpdateTrnEdpWfSp(EdpTrnOffModWfDto dto);
}
