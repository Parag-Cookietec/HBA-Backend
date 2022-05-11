package gov.ifms.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.workflow.entity.MsWorkflowActionEntity;

/**
 * The Class MsWorkflowActionRepository.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface MsWorkflowActionRepository
		extends JpaRepository<MsWorkflowActionEntity, Long>, JpaSpecificationExecutor<MsWorkflowActionEntity> {
	/**
	 * Find By WfActionName And ValidWfActionId
	 *
	 * @param wfActionName
	 * @param validWfActionId
	 * @return the entity
	 */
	MsWorkflowActionEntity findByWfActionNameAndValidWfActionId(String wfActionName ,int validWfActionId);

	MsWorkflowActionEntity findByWfActionCodeAndValidWfActionId(String wfActionCode ,int validWfActionId);
}
