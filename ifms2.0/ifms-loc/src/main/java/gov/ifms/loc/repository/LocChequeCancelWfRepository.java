package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocChequeCancelWfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class LocChequeCancelWfController.
 *
 * @version v 1.0
 * @created 2021/03/05 18:24:32
 */

@Repository
@Transactional
public interface LocChequeCancelWfRepository extends JpaRepository<LocChequeCancelWfEntity, Long>,
        JpaSpecificationExecutor<LocChequeCancelWfEntity>, GenericDao {

    /**
     * Find by trn id hdr id and active status.
     *
     * @param id the id
     * @param activeStatus the active status
     * @return the loc cheque cancel wf entity
     */
    LocChequeCancelWfEntity findByTrnIdHdrIdAndActiveStatus(Long id, int activeStatus);

}
