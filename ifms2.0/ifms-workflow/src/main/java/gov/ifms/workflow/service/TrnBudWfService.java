package gov.ifms.workflow.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.workflow.dto.TrnBudWfDto;
import gov.ifms.workflow.entity.TrnBudWfEntity;
/**
 * The interface TrnBudWfService.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
public interface TrnBudWfService {
	
     /**
	 * Returns all instances of the TrnBudWfEntity type.
	 * 
	 * @return all TrnBudWfEntity
	 */
	List<TrnBudWfEntity> getTrnBudWfs();	

	/**
	 * Retrieves an TrnBudWfEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the TrnBudWfEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	TrnBudWfEntity getTrnBudWf(Long id);

	/**
	 * Saves a given TrnBudWfEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved TrnBudWfEntity
	 */
	TrnBudWfEntity saveOrUpdateTrnBudWf(TrnBudWfEntity entity);

	/**
	 * Saves all given TrnBudWfEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<TrnBudWfEntity> saveTrnBudWf(List<TrnBudWfEntity> entities);

	/**
	 * Deletes the TrnBudWfEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteTrnBudWf(Long id);

	
	/**
	 * Fetch all the LkScWfUserRoleOffice items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<LkScWfUserRoleOfficeDto>
	 */
	PagebleDTO<TrnBudWfDto> trnBudWfAsMethodNameSearch(PageDetails pageDetail);

	 /**
	 * Save or update trn bud wf sp.
	 *
	 * @param entity the entity
	 * @return the trn bud wf entity
	 */
	List<Object[]> saveOrUpdateTrnBudWfSp(TrnBudWfEntity entity);
	
}
