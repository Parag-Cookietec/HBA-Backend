package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsAccountHeadEntity;

/**
 * The Interface EDPMsAccountHeadRepository.
 */
@Repository
@Transactional
public interface EDPMsAccountHeadRepository extends JpaRepository<EDPMsAccountHeadEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsAccountHeadEntity> {
	
}
