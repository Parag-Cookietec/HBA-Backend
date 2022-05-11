package gov.ifms.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import gov.ifms.workflow.entity.LkPostWfPermWfRoleMenuEntity;
/**
 * The Class EDPLkPostWfPermWfRoleMenuController.
 * 
 * @version 1.0
 * @created 2019/08/31 14:08:39
 */
public interface LkPostWfPermWfRoleMenuRepository extends JpaRepository<LkPostWfPermWfRoleMenuEntity,Long>, 
                  JpaSpecificationExecutor<LkPostWfPermWfRoleMenuEntity> {
	List<LkPostWfPermWfRoleMenuEntity> findByWfRoleIdWfRoleId(Long wfRoleId);
	List<LkPostWfPermWfRoleMenuEntity> findByPostIdAndWfRoleIdWfRoleId(Long postId, Long wfRoleId);
	LkPostWfPermWfRoleMenuEntity findByPostId(Long postId);
	LkPostWfPermWfRoleMenuEntity findByPostIdAndMenuEntityMenuId(Long postId, Long menuId);
	List<LkPostWfPermWfRoleMenuEntity> findByWfRoleIdWfRoleIdAndMenuEntityMenuId(Long wfRoleId, Long menuId);
}
