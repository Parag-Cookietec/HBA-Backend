package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUShettyPayAttachmentEntity;

/**
 * The Class PVUShettyPayAttachmentController.
 *
 * @version v 1.0
 * @created 2020/01/15 15:00:11
 */

@Repository
@Transactional
public interface PVUShettyPayAttachmentRepository extends BasePVUAttachmentRepository<PVUShettyPayAttachmentEntity> {

	List<PVUShettyPayAttachmentEntity> findAllBySpIdIdAndActiveStatus(Long referenceId, int activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUShettyPayAttachmentEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
	void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);

}
