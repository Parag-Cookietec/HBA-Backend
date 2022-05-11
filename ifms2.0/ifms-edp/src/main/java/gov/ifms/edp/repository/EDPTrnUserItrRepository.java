package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPTrnUserItrEntity;

/**
 * The Interface EDPTrnUserItrRepository.
 */
@Repository
@Transactional
public interface EDPTrnUserItrRepository
		extends JpaRepository<EDPTrnUserItrEntity, Long>, JpaSpecificationExecutor<EDPTrnUserItrEntity> {

}
