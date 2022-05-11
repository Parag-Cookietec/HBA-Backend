package gov.ifms.pvu.repository;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUSuspensionAttachmentEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PVUSuspensionAttachmentRepository extends BasePVUAttachmentRepository<PVUSuspensionAttachmentEntity> {

    List<PVUSuspensionAttachmentEntity> findAllBySuspensionIdAndActiveStatus(Long referenceId, int activeStatus);


    /**
     * Update status id for PVUSuspensionAttachmentEntity   .
     *
     * @param id           the id
     * @param activeStatus the status id
     */
    @Modifying(clearAutomatically = true)
    @Query("update PVUSuspensionAttachmentEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
    void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);

}
