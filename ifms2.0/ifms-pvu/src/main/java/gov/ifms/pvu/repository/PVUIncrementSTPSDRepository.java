package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUIncrementSTPSDEntity;

import java.util.List;

/**
 * The Interface PVUIncrementSTPSDRepository.
 */
@Repository
@Transactional
public interface PVUIncrementSTPSDRepository extends JpaRepository<PVUIncrementSTPSDEntity, Long>,
		JpaSpecificationExecutor<PVUIncrementSTPSDEntity>, GenericDao {

	/*@Modifying
	@Query(value = "DELETE FROM PVU.T_PVU_IN_STP_SD s "
			+ " WHERE s.T_PVU_IN_EMP_SD_ID IN (:empIds) ", nativeQuery = true)
	public void deleteEmployeeIncEventStatus(@Param("trnNo") String trnNo,
											 @Param("empIds") List<Long> empIds, @Param("updatedBy") long updatedBy, @Param("updatedByPost") long updatedByPost);
*/
	@Modifying
	@Query(value = "DELETE FROM PVU.T_PVU_IN_STP_SD s "
			+ " WHERE s.T_PVU_IN_EMP_SD_ID IN (:empIds) ", nativeQuery = true)
	public void deleteAllByEmployeeSdid(List<Long> empIds);

	@Modifying
	@Query(value = "DELETE FROM PVU.T_PVU_IN_STP_SD s "
			+ " WHERE s.T_PVU_IN_EVNT_ID =(:empIds) ", nativeQuery = true)
	public void deleteByEmployeeSdid(Long empIds);
}
