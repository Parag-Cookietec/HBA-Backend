package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAdvicePrepWfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * The Interface LocAdvicePrepWfRepository.
 */
public interface LocAdvicePrepWfRepository extends JpaRepository<LocAdvicePrepWfEntity, Long>,
        JpaSpecificationExecutor<LocAdvicePrepWfEntity>, GenericDao {

    /**
     * Find by trn id id and active status.
     *
     * @param id the id
     * @param activeStatus the active status
     * @return the loc advice prep wf entity
     */
    LocAdvicePrepWfEntity findByTrnIdIdAndActiveStatus(Long id, int activeStatus);
}
