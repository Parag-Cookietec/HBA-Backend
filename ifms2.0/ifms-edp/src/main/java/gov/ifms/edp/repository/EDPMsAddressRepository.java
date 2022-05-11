package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsAddressEntity;

/**
 * The Interface EDPMsAddressRepository.
 */
@Repository
@Transactional
public interface EDPMsAddressRepository extends JpaRepository<EDPMsAddressEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsAddressEntity> {
	
}
