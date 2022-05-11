package gov.ifms.pvu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;

/**
 * The Class PVUEmployeEventsRepository.
 */

@Repository
@Transactional
public interface PVUEmployeEventsRepository extends JpaRepository<PVUEmployeEventsEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeEventsEntity>, GenericDao {

	/**
	 * Find all by emp id and event date between and event name in.
	 *
	 * @param employeeId    the employee id
	 * @param to            the to
	 * @param from          the from
	 * @param excludeEvents the exclude events
	 * @return the list
	 */
	List<PVUEmployeEventsEntity> findAllByEmpIdAndEventDateBetweenAndEventNameIn(Long employeeId, LocalDateTime to,
			LocalDateTime from, List<String> excludeEvents);

	/**
	 * Find top 1 by emp id and event date and event name order by emp event id
	 * desc.
	 *
	 * @param empNo         the emp no
	 * @param effectiveDate the effective date
	 * @param event         the event
	 * @return the PVU employe events entity
	 */
	PVUEmployeEventsEntity findTop1ByEmpIdAndEventDateAndEventNameOrderByEmpEventIdDesc(Long empNo,
			LocalDateTime effectiveDate, String event);

	/**
	 * Find all by emp id and event id in and event date is after.
	 *
	 * @param employeeId the employee id
	 * @param eventIds   the event ids
	 * @param after      the after
	 * @return the list
	 */
	List<PVUEmployeEventsEntity> findAllByEmpIdAndEventIdInAndEventDateIsAfter(Long employeeId, List<Long> eventIds,
			LocalDateTime after);

	/**
	 * Find all by emp id and event date is after.
	 *
	 * @param employeeId the employee id
	 * @param after      the after
	 * @return the list
	 */
	List<PVUEmployeEventsEntity> findAllByEmpIdAndEventDateIsAfter(Long employeeId, LocalDateTime after);

	/**
	 * Find one by emp id and event name and active status.
	 *
	 * @param employeeId   the employee id
	 * @param eventName    the event name
	 * @param activeStatus the active status
	 * @return the PVU employe events entity
	 */
	PVUEmployeEventsEntity findOneByEmpIdAndEventNameAndActiveStatus(Long employeeId, String eventName,
			int activeStatus);

	/**
	 * Exists by emp id and event name and event date is between.
	 *
	 * @param employeeId     the employee id
	 * @param eventCodeForgo the event code forgo
	 * @param from           the from
	 * @param to             the to
	 * @return true, if successful
	 */
	boolean existsByEmpIdAndEventNameAndEventDateIsBetween(Long employeeId, String eventCodeForgo, LocalDateTime from,
			LocalDateTime to);

	boolean existsByEmpIdAndEventName(Long employeeId, String eventCodeForgo);

	PVUEmployeEventsEntity findOneByEmpIdAndTrnNo(Long employeeId, String trnNo);

	PVUEmployeEventsEntity findTopByEmpIdAndPayCommissionAndActiveStatusOrderByEmpIdDesc(Long employeeId, Long comm,
			int activeStatus);

	List<PVUEmployeEventsEntity> findAllByEmpIdAndEventName(Long employeeId, String eventCodeHigherPayScale);

	List<PVUEmployeEventsEntity> findAllByEmpIdAndPayCommissionAndActiveStatus(Long employeeId, Long comm,
			int activeStatus);

	PVUEmployeEventsEntity findFirstByEmpIdAndEventDateLessThanEqualOrderByEmpEventIdAsc(Long empId,
			LocalDateTime effectiveDate);

	PVUEmployeEventsEntity findTopByEmpIdAndPayCommissionAndActiveStatusAndEventDateLessThanEqualOrderByEmpEventIdDesc(
			Long employeeId, Long comm, int activeStatus, LocalDateTime effectiveDate);

	PVUEmployeEventsEntity findFirstByEmpIdOrderByEmpEventIdDesc(Long employeeId);

	@Query(value = "select entity from PVUEmployeEventsEntity entity  where entity.empId = :empId and entity.eventId in (:eventId) and entity.activeStatus= :activeStatus and entity.payCommission = :payComm")
	List<PVUEmployeEventsEntity> findFirstByPVUEmployeEventsEntityByEmpIdAndEventIdAndActiveStatusAndPayCommission(
			@Param("empId") Long empId, @Param("eventId") List<Long> eventId, @Param("payComm") Long payComm,
			@Param("activeStatus") int activeStatus);

	List<PVUEmployeEventsEntity> findAllByEmpIdAndEventNameAndActiveStatus(Long employeeId, String eventName,
																	 int activeStatus);
}
