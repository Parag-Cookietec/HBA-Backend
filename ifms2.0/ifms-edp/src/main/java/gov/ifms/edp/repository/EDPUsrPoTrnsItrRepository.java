package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPUsrPoTrnsItrEntity;

/**
 * The Interface EDPUsrPoTrnsItrRepository.
 */
@Repository
@Transactional
public interface EDPUsrPoTrnsItrRepository
		extends JpaRepository<EDPUsrPoTrnsItrEntity, Long>, JpaSpecificationExecutor<EDPUsrPoTrnsItrEntity> {

}
