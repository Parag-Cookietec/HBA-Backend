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
import gov.ifms.pvu.entity.PVUSteppingUpEventEntity;

/**
 * The Class PVUStEventController.
 * 
 * @version v 1.0
 * @created 2019/12/17 18:44:21
 */

@Repository
@Transactional
public interface PVUSteppingUpEventRepository
		extends JpaRepository<PVUSteppingUpEventEntity, Long>, JpaSpecificationExecutor<PVUSteppingUpEventEntity>, GenericDao {

	/**
	 * Update active status.
	 *
	 * @param stEventId    the st event id
	 * @param activeStatus the active status
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 * @return the int
	 */
	@Modifying(clearAutomatically = true)
	@Query(value = "update PVUSteppingUpEventEntity set activeStatus = :activeStatus , updatedBy = :updatedBy , "
			+ "updatedDate = :updatedDate where stEventId = :stEventId")
	public int updateActiveStatus(@Param("stEventId") long stEventId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	
	
	@Modifying(clearAutomatically = true)
	@Query("update PVUSteppingUpEventEntity  entity set entity.statusId.lookUpInfoId  = :statusId, entity.updatedBy= :updatedBy "
			+ ", entity.updatedDate= :updatedDate where entity.stEventId = :id")
	void updateStatusId(@Param("statusId") long statusId, @Param("id") long id,
						@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);	

	
    @Modifying
    @Query("update PVUSteppingUpEventEntity entity set entity.statusId.lookUpInfoId = :statusId, entity.authorizeDate = :authDate, " +
            " entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate, entity.authorizeBy =:authorizeBy, "
            + "entity.authorizerRemark = :authorizerRemark  where entity.stEventId = :id")
    void updateStatusIdAndAuthorizer(@Param("statusId") long statusId, @Param("id") long id,
                                     @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate, @Param("authDate") Date authDate,
                                     @Param("authorizeBy") long authorizeBy, @Param("authorizerRemark") String authorizerRemark);

	
	
	
	@Modifying(clearAutomatically = true)
	@Query("update PVUSteppingUpEventEntity entity set activeStatus = :activeStatus ,updatedBy= :updatedBy ,"
			+ " updatedDate= :updatedDate  , authorizeDate = :authorizeDate  where stEventId = :id")
	void updateAutorizedDate(@Param("activeStatus") int activeStatus, @Param("id") long id, @Param("updatedBy") long updatedBy,
							 @Param("updatedDate") Date updatedDate ,@Param("authorizeDate") Date authorizeDate);


	PVUSteppingUpEventEntity findByTrnNo(@Param("trnNo") String trnNo);	
	
}
