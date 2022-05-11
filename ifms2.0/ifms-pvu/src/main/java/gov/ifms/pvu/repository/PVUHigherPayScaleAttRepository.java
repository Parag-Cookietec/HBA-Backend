package gov.ifms.pvu.repository;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUDeemedDateAttEntity;
import gov.ifms.pvu.entity.PVUHigherPayScaleAttEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PVUHigherPayScaleAttRepository extends BasePVUAttachmentRepository<PVUHigherPayScaleAttEntity> {

    List<PVUHigherPayScaleAttEntity> findAllByEntityIdAndActiveStatus(Long referenceId, int activeStatus);


    @Modifying(clearAutomatically = true)
    @Query("update PVUHigherPayScaleAttEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
    void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);
}
