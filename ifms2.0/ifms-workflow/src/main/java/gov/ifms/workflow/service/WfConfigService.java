package gov.ifms.workflow.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.workflow.dto.WfConfigDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.WfConfigEntity;

/**
 * The Class MsWorkflowService.
 * 
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 *
 */
public interface WfConfigService {

	/**
	 * Gets the ms workflows.
	 *
	 * @return the ms workflows
	 */
	List<WfConfigEntity> getMsWorkflows();

	/**
	 * Gets the ms workflow.
	 *
	 * @param id the id
	 * @return the ms workflow
	 */
	WfConfigEntity getMsWorkflow(Long id);

	/**
	 * Save or update ms workflow.
	 *
	 * @param entity the entity
	 * @return the wf config entity
	 */
	WfConfigEntity saveOrUpdateMsWorkflow(WfConfigEntity entity);

	/**
	 * Save ms workflows.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	List<WfConfigEntity> saveMsWorkflows(List<WfConfigEntity> entities);

	/**
	 * Delete ms workflow.
	 *
	 * @param id the id
	 */
	void deleteMsWorkflow(Long id);

	/**
	 * Ms workflow as method name search.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 */
	PagebleDTO<WfConfigDto> msWorkflowAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * Gets the users by wf action id.
	 *
	 * @param dto the dto
	 * @return the users by wf action id
	 * @throws CustomException the custom exception
	 */
	List<WfUserDto> getUsersByWfActionId(WfRequestDto dto) throws CustomException;

	/**
	 * Gets the next wf actions.
	 *
	 * @param dto the dto
	 * @return the next wf actions
	 * @throws CustomException the custom exception
	 */
	List<WfConfigEntity> getNextWfActions(WfRequestDto dto) throws CustomException;

	/**
	 * Gets the wf role id by post id and menu id.
	 *
	 * @param postId the post id
	 * @param menuId the menu id
	 * @return the wf role id by post id and menu id
	 */
	long getWfRoleIdByPostIdAndMenuId(long postId, long menuId);

	/**
	 * Checks if is editable sc header.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean isEditableScHeader(Long id);

	/**
	 * Gets the ms workflow status.
	 *
	 * @param menuId the menu id
	 * @return the ms workflow status
	 */
	List<EDPSDTDto> getMsWorkflowStatus(long menuId);

	/**
	 * Gets the ms workflow trn status.
	 *
	 * @param id the id
	 * @return the ms workflow trn status
	 */
	List<EDPSDTDto> getMsWorkflowTrnStatus(Long id);
}
