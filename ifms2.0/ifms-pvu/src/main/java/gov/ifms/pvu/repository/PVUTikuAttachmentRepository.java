package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gov.ifms.pvu.entity.PVUTikuAttachmentEntity;


@Repository
@Transactional
public interface PVUTikuAttachmentRepository  extends JpaRepository<PVUTikuAttachmentEntity,Long> , 
JpaSpecificationExecutor<PVUTikuAttachmentEntity> {
	  

}