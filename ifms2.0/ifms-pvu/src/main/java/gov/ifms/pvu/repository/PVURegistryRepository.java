package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVURegistryEntity;

/**
 * The Class PVURegistryController.
 * 
 * @version v 1.0
 * @created 2020/01/12 12:05:26
 */

@Repository
@Transactional
public interface PVURegistryRepository
		extends JpaRepository<PVURegistryEntity, Long>, JpaSpecificationExecutor<PVURegistryEntity> {

}
