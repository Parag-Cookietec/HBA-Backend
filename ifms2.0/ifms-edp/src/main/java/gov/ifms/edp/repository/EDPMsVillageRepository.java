package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsVillageEntity;

/**
 * The Interface EDPMsVillageRepository.
 */
@Repository
@Transactional
public interface EDPMsVillageRepository extends JpaRepository<EDPMsVillageEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsVillageEntity> {
  
}
