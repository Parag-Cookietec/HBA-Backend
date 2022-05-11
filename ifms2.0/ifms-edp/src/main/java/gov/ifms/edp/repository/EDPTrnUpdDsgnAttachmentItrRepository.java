package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentItrEntity;

/**
 * The Interface EDPTrnUpdDsgnAttachmentItrRepository.
 */
@Repository
@Transactional
public interface EDPTrnUpdDsgnAttachmentItrRepository  extends JpaRepository<EDPTrnUpdDsgnAttachmentItrEntity,Long> , 
JpaSpecificationExecutor<EDPTrnUpdDsgnAttachmentItrEntity>{
	
}
