package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkPuoDeptBncHodEntity;

/**
 * The Interface EDPLkPuoDeptBncHodRepository.
 */
@Repository
@Transactional
public interface EDPLkPuoDeptBncHodRepository
		extends JpaRepository<EDPLkPuoDeptBncHodEntity, Long>, JpaSpecificationExecutor<EDPLkPuoDeptBncHodEntity> {

	/**
	 * Find by department id department id.
	 *
	 * @param departmentId the department id
	 * @return the list
	 */
	List<EDPLkPuoDeptBncHodEntity> findByDepartmentIdDepartmentId(Long departmentId);
}
