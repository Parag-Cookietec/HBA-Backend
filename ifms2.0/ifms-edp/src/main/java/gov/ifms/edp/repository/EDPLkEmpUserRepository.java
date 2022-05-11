package gov.ifms.edp.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkEmpUserEntity;

/**
 * The Interface EDPLkEmpUserRepository.
 */
@Transactional
@Repository
public interface EDPLkEmpUserRepository
		extends JpaRepository<EDPLkEmpUserEntity, Long>, JpaSpecificationExecutor<EDPLkEmpUserEntity> {
	
	/**
	 * Find by user id user id in.
	 *
	 * @param userId the user id
	 * @return the sets the
	 */
	Set<EDPLkEmpUserEntity> findByUserIdUserIdIn(Set<Long> userId);
	
	/**
	 * Find by emp id emp id.
	 *
	 * @param empId the emp id
	 * @return the EDP lk emp user entity
	 */
	EDPLkEmpUserEntity findByEmpIdEmpId(Long empId);
	
	EDPLkEmpUserEntity findByUserIdUserCode(Long userId);
	
	Optional<EDPLkEmpUserEntity> findByUserIdUserCodeAndActiveStatus(Long userCode,int activeStatus);
	
	/**
	 * Find by user id user id and active status.
	 *
	 * @return the EDP lk emp user entity
	 */
	EDPLkEmpUserEntity findByUserIdUserIdAndActiveStatus(long userId,int activeStatus);
	
}
