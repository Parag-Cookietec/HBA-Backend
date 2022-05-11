package gov.ifms.pvu.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;

/**
 * The Class PVUEmployeQualificationController.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:11:13
 */

@Repository
@Transactional
public interface PVUEmployeQualificationRepository extends JpaRepository<PVUEmployeQualificationEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeQualificationEntity> , GenericDao {

	/**
	 * Find PVU employe qualification entity bypvu employe entity emp id and active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<PVUEmployeQualificationEntity> findPVUEmployeQualificationEntityBypvuEmployeEntityEmpIdAndActiveStatus(Long id, int activeStatus);

	/**
	 * Update active status by qualification id.
	 *
	 * @param empQualiId the emp quali id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update PVUEmployeQualificationEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where empQualiId = :empQualiId")
	public int updateActiveStatusByQualificationId(@Param("empQualiId") long empQualiId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
}
