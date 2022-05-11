package gov.ifms.workflow.repository;


import gov.ifms.common.dao.GenericDao;
import gov.ifms.workflow.entity.WfRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface WfRequestRepository extends JpaRepository<WfRequestEntity,Long> ,
                  JpaSpecificationExecutor<WfRequestEntity> , GenericDao {

    Optional<WfRequestEntity> findByWfRequestNoAndActiveStatus(String wfRequestNo, int activeStatus);

    Optional<WfRequestEntity> findByWfRequestNoAndStatusIdAndActiveStatus(String wfRequestNo, long statusId, int activeStatus);

    @Modifying(clearAutomatically = true)
    @Query("update WfRequestEntity wfReq set wfReq.statusId =:statusId,wfReq.updatedBy=:updatedBy,wfReq.updatedByPost=:updatedByPost,wfReq.updatedDate=:updatedDate where wfReq.wfRequestId =:wfRequestId")
    void updateWfReqStsByWfReqId(@Param("statusId") long statusId, @Param("wfRequestId") long wfRequestId, @Param("updatedBy") long updatedBy, @Param("updatedByPost") long updatedByPost, @Param("updatedDate") Date updatedDate);

    @Modifying(clearAutomatically = true)
    @Query("update WfRequestEntity wfReq set wfReq.statusId =:statusId where wfReq.wfRequestId =:wfRequestId")
    void updateWfReqStsByWfReqId(@Param("statusId") long statusId, @Param("wfRequestId") long wfRequestId);
}
