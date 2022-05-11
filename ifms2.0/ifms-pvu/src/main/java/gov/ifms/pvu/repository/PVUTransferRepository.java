package gov.ifms.pvu.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUTransferEntity;

/**
 * The Class PVUTransferController.
 * 
 * @version v 1.0
 * @created 2019/12/21 22:53:07
 */

@Repository
@Transactional
public interface PVUTransferRepository
		extends JpaRepository<PVUTransferEntity, Long>, JpaSpecificationExecutor<PVUTransferEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVUTransferEntity entity set entity.status.lookUpInfoId = :statusId, updatedBy= :updatedBy , updatedDate= :updatedDate where entity.id = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id,
						@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);


	@Modifying
	@Query(value = "update PVUTransferEntity set activeStatus = :activeStatus , updatedBy = :updatedBy , "
			+ "updatedDate = :updatedDate where id = :stEventId")
	public int updateActiveStatus(@Param("stEventId") long stEventId, @Param("activeStatus") int activeStatus,
								  @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	PVUTransferEntity findByTrnNo(@Param("trnNo") String trnNo);
}
