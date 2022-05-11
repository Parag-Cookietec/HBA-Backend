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
import gov.ifms.pvu.entity.PVUDeemedDateEntity;

/**
 * The Class PVUDeemedDateRepository.
 */
@Repository
@Transactional
public interface PVUDeemedDateRepository extends JpaRepository<PVUDeemedDateEntity, Long>, JpaSpecificationExecutor<PVUDeemedDateEntity>, GenericDao {


    /**
     * Update status id for PVU increment event entity.
     *
     * @param statusId  the status id
     * @param id the in event id
     */
    @Modifying
    @Query("update PVUDeemedDateEntity entity set entity.status.lookUpInfoId = :statusId,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
    void updateStatusId(@Param("statusId") long statusId, @Param("id") long id,@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

    PVUDeemedDateEntity findByIdAndActiveStatus(Long id, int activeStatus);

    @Modifying
    @Query("update PVUDeemedDateEntity entity set entity.activeStatus = :activeStatus ,entity.updatedBy= :updatedBy , entity.updatedDate= :updatedDate where entity.id = :id")
    void deleteDeemedDateEventIdBy(@Param("activeStatus") Integer activeStatus, @Param("id") long id, @Param("updatedBy") long updatedBy,@Param("updatedDate") Date updatedDate);

    PVUDeemedDateEntity findByTrnNo(@Param("trnNo") String trnNo);

}
