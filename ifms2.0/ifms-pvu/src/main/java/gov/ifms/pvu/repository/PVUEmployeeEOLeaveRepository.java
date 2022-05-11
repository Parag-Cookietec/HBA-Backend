package gov.ifms.pvu.repository;

import java.time.LocalDate;
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

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;

/**
 * The Class PVUEmployeeEOLeaveRepository.
 */
@Repository
@Transactional
public interface PVUEmployeeEOLeaveRepository extends JpaRepository<PVUEmployeeEOLeaveEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeeEOLeaveEntity>, GenericDao {

	/**
	 * Find by emp eol id and active status.
	 *
	 * @param trnId        the trn id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	public Optional<PVUEmployeeEOLeaveEntity> findByEmpEolIdAndActiveStatus(Long trnId, int activeStatus);

	/**
	 * Update status id for PVU employe entity.
	 *
	 * @param statusId    the status id
	 * @param empEolId    the emp eol id
	 * @param updatedBy   the updated by
	 * @param updatedDate the updated date
	 */
	@Modifying
	@Query("update PVUEmployeeEOLeaveEntity pvuEmployeeEOLeaveEntity set pvuEmployeeEOLeaveEntity.statusId.lookUpInfoId = :statusId, updatedBy=:updatedBy , updatedDate=:updatedDate where pvuEmployeeEOLeaveEntity.empEolId = :empEolId")
	void updateStatusIdForPVUEmployeEntity(@Param("statusId") long statusId, @Param("empEolId") long empEolId,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	/**
	 * Find all by emp id emp id and status id look up info id and start date
	 * greater than equal and start date less than equal.
	 *
	 * @param empId    the emp id
	 * @param statusId the status id
	 * @param start1   the start 1
	 * @param end1     the end 1
	 * @return the list
	 */
	List<PVUEmployeeEOLeaveEntity> findAllByEmpIdEmpIdAndStatusIdLookUpInfoIdAndStartDateGreaterThanEqualAndStartDateLessThanEqual(
			long empId, long statusId, LocalDate start1, LocalDate end1);

	/**
	 * Find all by emp id emp id and status id look up info id and start date less
	 * than equal and end date less than equal.
	 *
	 * @param empId    the emp id
	 * @param statusId the status id
	 * @param start1   the start 1
	 * @param end1     the end 1
	 * @return the list
	 */
	List<PVUEmployeeEOLeaveEntity> findAllByEmpIdEmpIdAndStatusIdLookUpInfoIdAndStartDateLessThanEqualAndEndDateLessThanEqual(
			long empId, long statusId, LocalDate start1, LocalDate end1);

	/**
	 * Find all by emp id emp id and status id look up info id and start date less
	 * than equal and end date greater than equal.
	 *
	 * @param empId    the emp id
	 * @param statusId the status id
	 * @param start1   the start 1
	 * @param end1     the end 1
	 * @return the list
	 */
	List<PVUEmployeeEOLeaveEntity> findAllByEmpIdEmpIdAndStatusIdLookUpInfoIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
			long empId, long statusId, LocalDate start1, LocalDate end1);

	/**
	 * Find all by emp id emp id and status id look up info id and start date
	 * greater than equal and end date less than equal.
	 *
	 * @param empId    the emp id
	 * @param statusId the status id
	 * @param start1   the start 1
	 * @param end1     the end 1
	 * @return the list
	 */
	List<PVUEmployeeEOLeaveEntity> findAllByEmpIdEmpIdAndStatusIdLookUpInfoIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
			long empId, long statusId, LocalDate start1, LocalDate end1);

	/**
	 * Find one by trans no optional.
	 *
	 * @param transNo the trans no
	 * @return the optional
	 */
	Optional<PVUEmployeeEOLeaveEntity> findOneByTransNo(String transNo);

	/**
	 * Update active status by emp id.
	 *
	 * @param activeStatus the active status
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 * @return the int
	 */
	@Modifying
	@Query("update PVUEmployeeEOLeaveEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where empEolId = :empEolId")
	int updateActiveStatusByEmpEolId(@Param("empEolId") long empEolId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	List<PVUEmployeeEOLeaveEntity> findAllByEmpIdEmpIdAndStartDateLessThanEqualAndEndDateLessThanEqual(long empId,
			LocalDate start1, LocalDate end1);

	@Query(value = "select entity.active_status,entity.created_by,entity.created_by_post,entity.created_date, entity.updated_by, entity.updated_by_post, entity.updated_date ,entity.emp_id,entity.leave_end_date ,	entity.init_date ,	entity.no_of_days ,	entity.office_id,entity.ord_no_date ,entity.post_id,entity.ref_date,entity.remark ,entity.leave_start_date,entity.TRN_NO, entity.STATUS_ID,entity.T_PVU_EOL_CREAT_ID,entity.ACTIVE_STATUS from PVU.T_PVU_EOL_CREAT entity where((:startDate >= entity.LEAVE_START_DATE and :startDate <=entity.LEAVE_END_DATE) "
			+ "or (:endDate >= entity.LEAVE_START_DATE and :endDate <= entity.LEAVE_END_DATE)) and entity.ACTIVE_STATUS=:activeStatus AND entity.TRN_NO is not NULL AND entity.EMP_ID=:empId and entity.STATUS_ID != :statusId ", nativeQuery = true)
	List<PVUEmployeeEOLeaveEntity> findAllByStartDateAndEndDateAndEmpIdEmpId(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate, @Param("empId") long empId, @Param("statusId") long statusId,
			@Param("activeStatus") int activeStatus);
	
	PVUEmployeeEOLeaveEntity findByTransNo(@Param("transNo") String trnNo);
	
	
	 @Query(value = "SELECT * FROM PVU.T_PVU_EOL_CREAT WHERE (LEAVE_START_DATE BETWEEN :startDate AND :endDate \r\n" + 
	 		     "OR LEAVE_END_DATE BETWEEN :startDate AND :endDate ) AND EMP_ID = :empId AND ACTIVE_STATUS = :activeStatus AND STATUS_ID NOT IN (205,267) ",nativeQuery = true)
	 public List<PVUEmployeeEOLeaveEntity> getExistingEOLeaveDate(
				@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
				@Param("empId") long empId, @Param("activeStatus") int activeStatus);
	 
	 @Query(value = "SELECT * FROM PVU.T_PVU_EOL_CREAT WHERE (LEAVE_START_DATE BETWEEN :startDate AND :endDate \r\n" + 
 		     "OR LEAVE_END_DATE BETWEEN :startDate AND :endDate ) AND EMP_ID = :empId AND ACTIVE_STATUS = :activeStatus AND STATUS_ID = :statusId",nativeQuery = true)
 public List<PVUEmployeeEOLeaveEntity> getExistingEOLeaveDateCreate(
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
			@Param("empId") long empId, @Param("activeStatus") int activeStatus, @Param("statusId") long statusId);
	
	
	
}
