package gov.ifms.workflow.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.workflow.dto.AssignedToTrnDto;
import gov.ifms.workflow.dto.MsWorkflowDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.MsWorkflowEntity;

/**
 * The Class MsWorkflowService.
 * 
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 *
 */
public interface MsWorkflowService {

	/**
	 * get Ms WorkFlows.
	 *
	 * @return all MsWorkflowEntity
	 */
	List<MsWorkflowEntity> getMsWorkflows();

	/**
	 * Retrieves MsWorkflowEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the MsWorkflowEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	MsWorkflowEntity getMsWorkflow(Long id);

	/**
	 * Saves a given MsWorkflowEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved MsWorkflowEntity
	 */
	MsWorkflowEntity saveOrUpdateMsWorkflow(MsWorkflowEntity entity);

	/**
	 * Saves all given MsWorkflowEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<MsWorkflowEntity> saveMsWorkflows(List<MsWorkflowEntity> entities);

	/**
	 * Deletes the MsWorkFlow with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsWorkflow(Long id);

	/**
	 * Fetch all the msWorkflowAsMethodNameSearch items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<MsWorkflowDto>
	 */
	PagebleDTO<MsWorkflowDto> msWorkflowAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * get Users By WfActionId
	 *
	 * @param dto
	 * @return  List<WfUserDto>
	 * @throws CustomException
	 */
	List<WfUserDto> getUsersByWfActionId(WfRequestDto dto) throws CustomException;

	/**
	 * get Next WfActions
	 *
	 * @param dto
	 * @return List<MsWorkflowEntity>
	 * @throws CustomException
	 */
	List<MsWorkflowEntity> getNextWfActions(WfRequestDto dto) throws CustomException;

	/**
	 * get WfRoleIdByPostIdAndMenuId
	 *
	 * @param postId
	 * @param menuId
	 * @return the long
	 */
	long getWfRoleIdByPostIdAndMenuId(long postId, long menuId);

	/**
	 * isEditableScHeader
	 *
	 * @param id
	 * @return boolean
	 */
	Boolean isEditableScHeader(Long id);

	/**
	 * get MsWorkflowStatus
	 *
	 * @param menuId
	 * @return List<EDPSDTDto>
	 */
	List<EDPSDTDto> getMsWorkflowStatus(long menuId);

	List<EDPSDTDto> getMsWorkflowStatusV2(long menuId);

	List<EDPSDTDto> getMsWorkflowTrnStatus(Long id);

	AssignedToTrnDto findActualWfRoleId(List<Long> wfRoleIds, long trnId, long menuId, Long eventId , long officeTypeId) throws CustomException;

	AssignedToTrnDto findActualWfRoleIdForPVUHistory(List<Long> wfRoleIds, long trnId, long menuId, Long eventId , long officeTypeId) throws CustomException;
}
