package gov.ifms.workflow.service;

import java.sql.SQLException;
import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.workflow.dto.PvuTrnEmpCrWfDto;
import gov.ifms.workflow.entity.PvuTrnEmpCrWfEntity;

/**
 * The Interface PvuTrnEmpCrWfService.
 */
public interface PvuTrnEmpCrWfService {
	
	/**
	 * Gets the trn edp wfs.
	 *
	 * @return list PVU Trn Emp Cr Wf entity
	 */
	List<PvuTrnEmpCrWfEntity> getTrnEdpWfs();	

	/**
	 * Gets the trn edp wf.
	 *
	 * @param id the id
	 * @return the PVU Trn Emp Cr Wf entity
	 */
	PvuTrnEmpCrWfEntity getTrnEdpWf(Long id);
	
	/**
	 * Gets the wf rl cd by rop trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by rop trn id
	 */
	String getWfRlCdByRopTrnId(long trnId);

	/**
	 * Save or update trn edp wf.
	 *
	 * @param entity the entity
	 * @return the PvuTrnEmpCrWfEntity
	 */
	PvuTrnEmpCrWfEntity saveOrUpdateTrnEdpWf(PvuTrnEmpCrWfEntity entity);

	/**
	 * Save trn edp wf.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	List<PvuTrnEmpCrWfEntity> saveTrnEdpWf(List<PvuTrnEmpCrWfEntity> entities);

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
	PagebleDTO<PvuTrnEmpCrWfDto> trnEdpWfAsMethodNameSearch(PageDetails pageDetail);
	
	/**
	 * Save or update trn bud wf sp.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	Long saveOrUpdateTrnEdpWfSp(PvuTrnEmpCrWfDto dto);

	/**
	 * save or update TrnEdpWfSpList
	 *
	 * @param dtos
	 * @return boolean
	 * @throws SQLException
	 */
	boolean saveOrUpdateTrnEdpWfSpList(List<PvuTrnEmpCrWfDto> dtos) throws SQLException;

	/**
	 * get CurrentUserPOUId
	 *
	 * @param dto
	 * @return the long
	 */
	Long getCurrentUserPOUId(PvuTrnEmpCrWfDto dto ,boolean isAssignBy);

	/**
	 * setPOUId
	 *
	 * @param dto
	 * @return PvuTrnEmpCrWfDto
	 */
	PvuTrnEmpCrWfDto setPOUId(PvuTrnEmpCrWfDto dto);
	
	/**
	 * Gets the wf rl cd by inc trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by inc trn id
	 */
	String getWfRlCdByIncTrnId(Long trnId);
}

