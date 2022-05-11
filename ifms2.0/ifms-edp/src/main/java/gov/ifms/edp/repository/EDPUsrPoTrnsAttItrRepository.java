package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPUsrPoTrnsAttItrEntity;

/**
 * The Interface EDPUsrPoTrnsAttItrRepository.
 */
@Repository
@Transactional
public interface EDPUsrPoTrnsAttItrRepository
		extends JpaRepository<EDPUsrPoTrnsAttItrEntity, Long>, JpaSpecificationExecutor<EDPUsrPoTrnsAttItrEntity> {

}
