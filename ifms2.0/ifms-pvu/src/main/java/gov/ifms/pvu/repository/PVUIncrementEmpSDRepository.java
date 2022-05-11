package gov.ifms.pvu.repository;

import gov.ifms.pvu.entity.PVUIncrementEmpEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUIncrementEmpSDEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The Class PVUIncrementEmpController.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 */

@Repository
@Transactional
public interface PVUIncrementEmpSDRepository extends JpaRepository<PVUIncrementEmpSDEntity, Long>,
		JpaSpecificationExecutor<PVUIncrementEmpSDEntity>, GenericDao {
	/**
	 * Find all by in event id in event id.
	 *
	 * @param inEventId the in event id
	 * @return the list
	 */
	public List<PVUIncrementEmpSDEntity> findAllByInEventIdInEventId(long inEventId);

	/**
	 * Delete increment empt by in event id.
	 *
	 * @param activeStatus the active status
	 * @param id           the id
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUIncrementEmpSDEntity entity set entity.activeStatus = :activeStatus, updatedDate = :updatedDate, "
			+ " updatedBy = :updatedBy, updatedByPost = :updatedByPost " + " where entity.inEventId.inEventId = :id")
	public void deleteIncrementEmptByInEventId(@Param("activeStatus") Integer activeStatus, @Param("id") long id,
											   @Param("updatedDate") Date updatedDate, @Param("updatedBy") long updatedBy,
											   @Param("updatedByPost") long updatedByPost);

	/**
	 * Delete increment empt by in event id.
	 *
	 * @param inEventId the in event id
	 */
	@Modifying
	@Query("delete from PVUIncrementEmpSDEntity entity where entity.inEventId.inEventId = :inEventId")
	public void deleteIncrementEmptByInEventId(@Param("inEventId") Long inEventId);

	// PVUIncrementEmpEntity findByTrnNoAndEmpIdEmpId(@Param("trnNo") String trnNo,
	// @Param("empId") Long empId);

	/*@EntityGraph(value = "PVUIncrementEmpSDEntity.pvuIncrementSTPSDPEntity")
	Optional<PVUIncrementEmpSDEntity> findWithPvuIncrementSTPSDPEntityById(Long aLong);*/

	public List<PVUIncrementEmpSDEntity> findAllByInEventIdInEventIdAndIsEligibleAndIsIncluded(long inEventId,long isEligible,long isIncluded);

}
