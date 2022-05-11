package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsCountryEntity;

/**
 * The Interface EDPMsCountryRepository.
 */
@Repository
@Transactional
public interface EDPMsCountryRepository extends JpaRepository<EDPMsCountryEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsCountryEntity> {
  
}
