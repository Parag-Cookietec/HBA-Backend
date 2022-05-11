package gov.ifms.pvu.repository;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUInwardEntity;

@Repository
@Transactional
public interface PVUInwardRepository
		extends JpaRepository<PVUInwardEntity, Long>, JpaSpecificationExecutor<PVUInwardEntity>, GenericDao {

	@Modifying(clearAutomatically = true)
	@Query("update PVUInwardEntity entity set entity.outwardFlag =:outwardFlag, entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.pvuEventId = :pvuEventId and entity.trnId= :trnId and entity.activeStatus = :activeStatus")
	void updateOutwardFlag(@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("pvuEventId") long pvuEventId, @Param("trnId") long trnId, @Param("outwardFlag") int outwardFlag,
			@Param("activeStatus") int activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUInwardEntity entity set entity.returnDate = :returnDate , entity.outwardFlag = :outwardFlag, entity.updatedBy = :updatedBy "
			+ " where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
	  void setReturnDateSG(@Param("trnId") long trnId, @Param("eventId") Long pvuEventId,
			@Param("updatedBy") Long updatedBy, @Param("returnDate") LocalDateTime returnDate,
			@Param("outwardFlag") int outwardFlag, @Param("activeStatus") int activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUInwardEntity entity set entity.outwardFlag =:outwardFlag, entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where  entity.pvuEventId = :pvuEventId and entity.trnId= :trnId and entity.activeStatus = :activeStatus")
	void updateCsOutwardFlag(@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("pvuEventId") Long pvuEventId, @Param("trnId") Long trnId, @Param("outwardFlag") int outwardFlag,
			@Param("activeStatus") int activeStatus);
	
	@Modifying(clearAutomatically = true)
    @Query("update PVUInwardEntity entity set entity.returnDate = :returnDate , entity.outwardFlag = :outwardFlag, entity.updatedBy = :updatedBy " +
            " where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
    void setReturnDateAndFlag(@Param("trnId") Long trnId, @Param("eventId") Long pvuEventId, @Param("updatedBy") Long updatedBy,
                       @Param("returnDate") LocalDateTime returnDate, @Param("outwardFlag") int outwardFlag,@Param("activeStatus") int activeStatus);
	
	@Modifying(clearAutomatically = true)
    @Query("update PVUInwardEntity entity set entity.authDate = :authDate , entity.outwardFlag = :outwardFlag, entity.updatedBy = :updatedBy " +
            " where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
    void setAuthorizeDateAndFlag(@Param("trnId") Long trnId, @Param("eventId") Long pvuEventId, @Param("updatedBy") Long updatedBy,
                       @Param("authDate") LocalDateTime authDate, @Param("outwardFlag") int outwardFlag,@Param("activeStatus") int activeStatus);



	@Modifying
	@Query("update PVUInwardEntity entity set entity.postConsignationNo = :postConsignmentNo , entity.updatedBy = :updatedBy " +
			" where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
	void setPostConsignmentNumber(@Param("trnId") long trnId, @Param("eventId") Long eventId, @Param("updatedBy") Long updatedBy,
								  @Param("postConsignmentNo") String postConsignmentNo,@Param("activeStatus") int activeStatus);

	@Modifying
	@Query("update PVUInwardEntity entity set entity.authDate = :authDate , entity.updatedBy = :updatedBy " +
			" where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
	void setAuthDate(@Param("trnId") long trnId, @Param("eventId") Long eventId, @Param("updatedBy") Long updatedBy,
					 @Param("authDate") LocalDateTime authDate, @Param("activeStatus") int activeStatus);

	@Modifying
	@Query("update PVUInwardEntity entity set entity.returnDate = :returnDate , entity.outwardFlag = :outwardFlag, entity.updatedBy = :updatedBy " +
			" where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
	void setReturnDate(@Param("trnId") long trnId, @Param("eventId") Long eventId, @Param("updatedBy") Long updatedBy,
					   @Param("returnDate") LocalDateTime returnDate, @Param("outwardFlag") int outwardFlag,@Param("activeStatus") int activeStatus);

	@Modifying
	@Query("update PVUInwardEntity entity set entity.outwardFlag = :outwardFlag , entity.updatedBy = :updatedBy " +
			" where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
	void setResetOutWardFlag(@Param("trnId") long trnId, @Param("eventId") Long eventId, @Param("updatedBy") Long updatedBy,
							 @Param("outwardFlag") int outwardFlag,@Param("activeStatus") int activeStatus);

	@Modifying
	@Query("update PVUInwardEntity entity set entity.outwardFlag = :outwardFlag, entity.inwardNumber = null,entity.inwardDate= null , entity.updatedBy = :updatedBy " +
			" where entity.pvuEventId = :eventId AND entity.trnId = :trnId AND entity.activeStatus =:activeStatus ")
	void setInwardNumberNull(@Param("trnId") long trnId, @Param("eventId") Long eventId, @Param("updatedBy") Long updatedBy,@Param("activeStatus") int activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUInwardEntity entity set entity.outwardFlag =:outwardFlag, entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where  entity.pvuEventId = :pvuEventId and entity.trnId= :trnId and entity.activeStatus = :activeStatus")
	void updateOutwardFlag(@Param("updatedBy") long updatedBy, @Param("updatedDate") LocalDateTime updatedDate,
			@Param("pvuEventId") Long pvuEventId, @Param("trnId") Long trnId, @Param("outwardFlag") int outwardFlag,
			@Param("activeStatus") int activeStatus);
	
	@Modifying
	@Query("update PVUInwardEntity entity set entity.activeStatus =:activeStatus, entity.updatedBy = :updatedBy , entity.updatedDate= :updatedDate where entity.trnId = :trnId and entity.pvuEventId = :pvuEventId")
	void updateSatus(@Param("activeStatus") int activeStatus, @Param("trnId") Long trnId,
	                    @Param("updatedBy") long updatedBy, @Param("updatedDate")  Date updatedDate, @Param("pvuEventId") Long pvuEventId);
}
