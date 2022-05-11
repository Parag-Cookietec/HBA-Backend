package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUSteppingUpAttEntity;

@Repository
@Transactional
public interface PVUSteppingUpAttRepository extends BasePVUAttachmentRepository<PVUSteppingUpAttEntity> {

    List<PVUSteppingUpAttEntity> findAllByEntityStEventIdAndActiveStatus(Long referenceId, int activeStatus);


    /**
     * Update status id for PVUSteppingUpAttEntity   .
     *
     * @param id           the id
     * @param activeStatus the status id
     */
    @Modifying(clearAutomatically = true)
    @Query("update PVUSteppingUpAttEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
    void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);

}
