package gov.ifms.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.workflow.entity.MsWorkflowRoleEntity;

/**
 * The Class MsWorkflowRoleRepository.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface MsWorkflowRoleRepository
		extends JpaRepository<MsWorkflowRoleEntity, Long>, JpaSpecificationExecutor<MsWorkflowRoleEntity>{
	/**
	 * findByWfRoleNameAndActiveStatus
	 *
	 * @param wfRoleName
	 * @param activeStatus
	 * @return the entity
	 */
	MsWorkflowRoleEntity findByWfRoleNameAndActiveStatus(String wfRoleName,int activeStatus);
	

	@Query(value = "SELECT wfrl FROM MsWorkflowRoleEntity wfrl WHERE wfrl.wfRoleId in (:deptCoCreatorWfRlId, :coCreatorWfRlId) and wfrl.activeStatus = :activeStatus")
	List<MsWorkflowRoleEntity> findDcoCoCreatorWfRoleForGrant(@Param("deptCoCreatorWfRlId") long deptCoCreatorWfRlId, @Param("coCreatorWfRlId") long coCreatorWfRlId, @Param("activeStatus") int activeStatus);
}
