package gov.ifms.edp.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsAttachmentEntity;

/**
 * The Interface EDPMsAttachmentRepository.
 */
@Repository
@Transactional
public interface EDPMsAttachmentRepository
		extends JpaRepository<EDPMsAttachmentEntity, Long>, JpaSpecificationExecutor<EDPMsAttachmentEntity> {
	
	/**
	 * Find by attachment type in.
	 *
	 * @param ids the attachment types
	 * @return the list
	 */
	List<EDPMsAttachmentEntity> findByAttahcmentTypeLookUpInfoIdIn(Set<Long> ids);

}
