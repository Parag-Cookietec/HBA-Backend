package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;
/**
 * The Class PVUCareerAdvanceAttachmentsController.
 * 
 * @version v 1.0
 * @created 2020/01/17 11:30:23
 */

@Repository
@Transactional
public interface PVUCareerAdvanceAttachmentsRepository extends BasePVUAttachmentRepository<PVUCareerAdvanceAttachmentsEntity> {
	
	 List<PVUCareerAdvanceAttachmentsEntity> findAllByEntityIdAndActiveStatus(Long referenceId, int activeStatus);


	    /**
	     * Update status id for PVUCareerAdvanceAttachmentsEntity   .
	     *
	     * @param id           the id
	     * @param activeStatus the status id
	     */
	    @Modifying(clearAutomatically = true)
	    @Query("update PVUCareerAdvanceAttachmentsEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
	    void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);
}
