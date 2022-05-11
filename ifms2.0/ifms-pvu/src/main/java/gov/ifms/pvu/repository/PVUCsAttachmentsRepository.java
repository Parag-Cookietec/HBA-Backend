package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUCsAttachmentsEntity;

/**
 * The Class PVUCsAttachmentsController.
 * 
 * @version v 1.0
 * @created 2020/01/11 16:50:08
 */

@Repository
@Transactional
public interface PVUCsAttachmentsRepository
		extends JpaRepository<PVUCsAttachmentsEntity, Long>, JpaSpecificationExecutor<PVUCsAttachmentsEntity> {
	
}
