package gov.ifms.edp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsSubTreasuryEntity;


/**
 * The Class EDPMsSubTreasuryController.
 * 
 * @version 1.0
 * @created 2020/01/20 10:59:54
 */
@Repository
@Transactional
public interface EDPMsSubTreasuryRepository
		extends JpaRepository<EDPMsSubTreasuryEntity, Long>, JpaSpecificationExecutor<EDPMsSubTreasuryEntity> {

	Optional<EDPMsSubTreasuryEntity> findBySubTreasuryNameAndActiveStatus(Long officeId, int activeStatus);
	
	Optional<EDPMsSubTreasuryEntity> findBySubTreasuryNameAndActiveStatus(String officeName, int activeStatus);
}
