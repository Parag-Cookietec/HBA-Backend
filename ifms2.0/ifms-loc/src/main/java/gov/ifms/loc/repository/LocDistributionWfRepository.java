package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocDistributionWfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Interface LocChequeBookWfRepository.
 */
@Repository
@Transactional
public interface LocDistributionWfRepository extends JpaRepository<LocDistributionWfEntity, Long>,
        JpaSpecificationExecutor<LocDistributionWfEntity>, GenericDao {

    /**
     * Find by trn id and active status.
     *
     * @param id           the id
     * @param activeStatus the active status
     * @return the loc cheque book wf entity
     */
    LocDistributionWfEntity findByTrnIdAndActiveStatus(Long id, int activeStatus);

}
