package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsColumnsEntity;

/**
 * The Interface EDPMsColumnsRepository.
 */
@Repository
@Transactional
public interface EDPMsColumnsRepository extends JpaRepository<EDPMsColumnsEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsColumnsEntity> {
	
}
