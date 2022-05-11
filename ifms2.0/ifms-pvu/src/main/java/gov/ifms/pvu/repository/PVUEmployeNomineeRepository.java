package gov.ifms.pvu.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeNomineeEntity;

/**
 * The Class PVUEmployeNomineeController.
 * 
 * @version v 1.0
 * @created 2019/11/27 03:02:40
 */

@Repository
@Transactional
public interface PVUEmployeNomineeRepository
		extends JpaRepository<PVUEmployeNomineeEntity, Long>, JpaSpecificationExecutor<PVUEmployeNomineeEntity> {

	/**
	 * Find PVU employe nominee entity bypvu employe entity emp id.
	 *
	 * @param id the id
	 * @param activeStatus 
	 * @return the list
	 */
	public List<PVUEmployeNomineeEntity> findPVUEmployeNomineeEntityBypvuEmployeEntityEmpIdAndActiveStatus(Long id, int activeStatus);

	/**
	 * Update active status by office id.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update PVUEmployeNomineeEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where empNomineeId = :empNomineeId")
	public int updateActiveStatusByNomineeId(@Param("empNomineeId") long empNomineeId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	/**
	 * Find one by emp nominee id and active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	public Optional<PVUEmployeNomineeEntity> findOneByEmpNomineeIdAndActiveStatus(Long id, int activeStatus);
}
