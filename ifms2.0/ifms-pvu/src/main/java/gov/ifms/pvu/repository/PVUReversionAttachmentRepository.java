package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUReversionAttachmentEntity;

/**
 * The Class PVUReversionAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 */

@Repository
@Transactional
public interface PVUReversionAttachmentRepository extends BasePVUAttachmentRepository<PVUReversionAttachmentEntity> {
	
    List<PVUReversionAttachmentEntity> findAllByReversionIdAndActiveStatus(Long referenceId, int activeStatus);
    
    @Modifying(clearAutomatically = true)
    @Query("update PVUReversionAttachmentEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
    void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);
}
