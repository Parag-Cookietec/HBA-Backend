package gov.ifms.pvu.repository;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUPromotionAttEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PVUPromotionAttRepository extends BasePVUAttachmentRepository<PVUPromotionAttEntity> {

    List<PVUPromotionAttEntity> findAllByEntityIdAndActiveStatus(Long referenceId, int activeStatus);


    /**
     * Update status id for PVUPromotionAttEntity   .
     *
     * @param id           the id
     * @param activeStatus the status id
     */
    @Modifying(clearAutomatically = true)
    @Query("update PVUPromotionAttEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
    void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);

}
