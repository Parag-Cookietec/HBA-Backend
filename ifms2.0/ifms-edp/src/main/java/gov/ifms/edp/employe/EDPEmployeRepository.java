package gov.ifms.edp.employe;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Interface EDPEmployeRepository.
 */
@Repository
@Transactional
public interface EDPEmployeRepository
		extends JpaRepository<EDPEmployeEntity, Long>, JpaSpecificationExecutor<EDPEmployeEntity>, GenericDao {

	/**
	 * Find by employee code.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<EDPEmployeEntity> findByEmployeeCode(Long id);

	/**
	 * Find by employee code and active status.
	 *
	 * @param employeeCode the employee code
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<EDPEmployeEntity> findByEmployeeCodeAndActiveStatus(Long employeeCode, int activeStatus);

	/**
	 * Find by emp id.
	 *
	 * @param empId the emp id
	 * @return the optional
	 */
	Optional<EDPEmployeEntity> findByEmpId(Long empId);
	
	/**
	 * Find by user id.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	@Query(value = "FROM EDPEmployeEntity me,EDPLkEmpUserEntity leu "
			+ "WHERE me.empId = leu.empId AND leu.userId.userId = :userId")
	EDPEmployeEntity findByUserId(@Param("userId") Long userId);
	
	/**
	 * Gets the employee info for login.
	 *
	 * @return the employee info for login
	 */
	@Query(value = EDPNativeSQLUtil.GET_EMPLOYEE_INFO_FOR_LOGIN_BY_USER_CODE ,nativeQuery = true)
	List<Object[]> getEmployeeInfoForLogin(@Param("userCode") Long userCode);
	
	@Query(value = EDPNativeSQLUtil.GET_EMP_PHOTO_BY_EMPNO ,nativeQuery = true)
	List<Object[]> getEmployeePhoto(@Param("empNo")Long empNo);

	Optional<EDPEmployeEntity> findByPanNoAndActiveStatus(String panNo,int activeStatus);

	Optional<EDPEmployeEntity> findByCaseNoAndActiveStatus(String caseNo,int activeStatus);
}
