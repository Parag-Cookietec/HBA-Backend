package gov.ifms.pvu.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUAcpRemarksEntity;
import gov.ifms.pvu.entity.PVURopRemarksEntity;

/**
 * The Class PVURopRemarksEntityController.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 */

@Repository
@Transactional
public interface PVUAcpRemarksRepository
		extends JpaRepository<PVUAcpRemarksEntity, Long>, JpaSpecificationExecutor<PVUAcpRemarksEntity> {

	@Modifying(clearAutomatically = true)
	@Query(value = " UPDATE PVU.PVU_AP_EVNT_REMARKS "
			+ " SET ACTIVE_STATUS = :activeStatus, UPDATED_BY = :updatedBy, "
			+ "	UPDATED_DATE = :updatedDate	WHERE AP_EVNT_ID = :trnId", nativeQuery = true)
	public void deactiveOldReason(@Param("trnId") Long id, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

}
