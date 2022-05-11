package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;

/**
 * The Interface EDPMsDepartmentRepository.
 */
@Repository
@Transactional
public interface EDPMsDepartmentRepository
		extends JpaRepository<EDPMsDepartmentEntity, Long>, JpaSpecificationExecutor<EDPMsDepartmentEntity>, GenericDao {

	
	/**
	 * Find by active status.
	 *
	 * @param activeCode the active code
	 * @return the list
	 */
	List<EDPMsDepartmentEntity> findByActiveStatus(int activeCode);
	
	/**
	 * Find by active status.
	 *
	 * @param activeCode the active code
	 * @param sort the sort
	 * @return the list
	 */
	List<EDPMsDepartmentEntity> findByActiveStatus(int activeCode,Sort sort);

	/**
	 * Find by department name and active status.
	 *
	 * @param string the string
	 * @param activeStatus the active status
	 * @return the EDP ms department entity
	 */
	EDPMsDepartmentEntity findByDepartmentNameAndActiveStatus(String string, int activeStatus);
	/**
	 * Find by department id active status.
	 *
	 * @param deptId the dept id
	 * @param activeStatus the active status
	 * @param jpaSort the jpa sort
	 * @return the list
	 */
	List<EDPMsDepartmentEntity> findByDepartmentIdAndActiveStatus(Long deptId, int activeStatus, Sort jpaSort);
	
	/**
	 * Find by active status and lk dept demand.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = "SELECT DISTINCT(DPT.DEPARTMENT_ID), DPT.DEPARTMENT_NAME, DPT.DEPARTMENT_CODE "
			+ "FROM MASTER_V1.MS_DEPARTMENT DPT RIGHT JOIN MASTER_V1.LK_DEPT_DEMAND LK "
			+ "ON DPT.DEPARTMENT_ID = LK.DEPARTMENT_ID ORDER BY DPT.DEPARTMENT_NAME", nativeQuery = true)
	List<Object[]> findByActiveStatusAndLkDeptDemand(int activeStatus);
}
