package gov.ifms.loc.workflow.repository;


import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.workflow.entity.LocWfRequestEntity;
import gov.ifms.loc.workflow.entity.LocWfRlBrTypeMenuAuthEntity;

/**
 * The Interface LocWfRequestRepository.
 */
@Repository
public interface LocWfRequestRepository extends JpaRepository<LocWfRequestEntity,Long> ,
                  JpaSpecificationExecutor<LocWfRequestEntity> , GenericDao {

    /**
     * Find by wf request no and active status.
     *
     * @param wfRequestNo the wf request no
     * @param activeStatus the active status
     * @return the optional
     */
    Optional<LocWfRequestEntity> findByWfRequestNoAndActiveStatus(String wfRequestNo, int activeStatus);

    /**
     * Find by wf request no and status id and active status.
     *
     * @param wfRequestNo the wf request no
     * @param statusId the status id
     * @param activeStatus the active status
     * @return the optional
     */
    Optional<LocWfRequestEntity> findByWfRequestNoAndStatusIdAndActiveStatus(String wfRequestNo, long statusId, int activeStatus);

    /**
     * Update wf req sts by wf req id.
     *
     * @param statusId the status id
     * @param wfRequestId the wf request id
     * @param updatedBy the updated by
     * @param updatedByPost the updated by post
     * @param updatedDate the updated date
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE LOC.TLOC_WF_REQUEST wfReq SET wfReq.STATUS_ID =:statusId, wfReq.UPDATED_BY =:updatedBy, wfReq.UPDATED_BY_POST =:updatedByPost, wfReq.UPDATED_DATE =:updatedDate WHERE wfReq.WF_REQUEST_ID =:wfRequestId",nativeQuery = true)
    void updateWfReqStsByWfReqId(@Param("statusId") long statusId, @Param("wfRequestId") long wfRequestId, @Param("updatedBy") long updatedBy, @Param("updatedByPost") long updatedByPost, @Param("updatedDate") Date updatedDate);

    
    /**
     * Find top 1 by menu id and active status.
     *
     * @param menuId the menu id
     * @param activeStatus the active status
     * @return the optional
     */
    Optional<LocWfRlBrTypeMenuAuthEntity> findTop1ByMenuIdAndActiveStatus(long menuId, int activeStatus);
}
