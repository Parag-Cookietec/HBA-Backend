package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUForgoAttachmentEntity;
/**
 * The Class PVUForgoAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/01/13 11:47:13
 */

@Repository
@Transactional
public interface PVUForgoAttachmentRepository extends JpaRepository<PVUForgoAttachmentEntity,Long> , 
                  JpaSpecificationExecutor<PVUForgoAttachmentEntity> {
	  
}
