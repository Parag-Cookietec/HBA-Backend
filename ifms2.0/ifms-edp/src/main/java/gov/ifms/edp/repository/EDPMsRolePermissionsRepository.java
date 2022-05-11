package gov.ifms.edp.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;

/**
 * The Interface EDPMsRolePermissionsRepository.
 */
@Repository
@Transactional
public interface EDPMsRolePermissionsRepository
		extends JpaRepository<EDPMsRolePermissionsEntity, Long>, JpaSpecificationExecutor<EDPMsRolePermissionsEntity> {

	/**
	 * Find by role activity id in.
	 *
	 * @param idList the id list
	 * @return the list
	 */
	List<EDPMsRolePermissionsEntity> findByRolePrmIdIn(Set<Long> idList);

	/**
	 * Find by role prm name.
	 *
	 * @param rolePrmName the role prm name
	 * @return the EDP ms role permissions entity
	 */
	EDPMsRolePermissionsEntity findByRolePrmName(String rolePrmName);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsRolePermissionsEntity> findByActiveStatus(int activeStatus);
	
	/**
	 * Find by role prm name.
	 *
	 * @param rolePrmName the role prm name
	 * @return the EDP ms role permissions entity
	 */
	List<EDPMsRolePermissionsEntity> findByRolePrmNameIn(Set<String> rolePrmName);

}
