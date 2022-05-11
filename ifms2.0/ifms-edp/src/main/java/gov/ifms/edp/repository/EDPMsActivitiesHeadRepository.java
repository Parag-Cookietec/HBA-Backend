package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsActivitiesHeadEntity;

/**
 * The Interface EDPMsActivitiesHeadRepository.
 */
@Repository
@Transactional
public interface EDPMsActivitiesHeadRepository extends JpaRepository<EDPMsActivitiesHeadEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsActivitiesHeadEntity> {
	
}
