package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVURopPrintEndorsementItrEntity;
/**
 * The Class PVUPVURopPrintEndorsementItrController.
 * 
 * @version v 1.0
 * @created 2020/04/15 17:57:19
 */

@Repository
@Transactional
public interface PVURopPrintEndorsementItrRepository extends JpaRepository<PVURopPrintEndorsementItrEntity,Long> , 
                  JpaSpecificationExecutor<PVURopPrintEndorsementItrEntity> {
}
