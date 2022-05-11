package gov.ifms.loc.repository;


import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAccountCloseWfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * The Interface LocAdvicePrepWfRepository.
 */
public interface LocAccountCloseWfRepository extends JpaRepository<LocAccountCloseWfEntity, Long>,
        JpaSpecificationExecutor<LocAccountCloseWfEntity>, GenericDao {

    /**
     * Find by trn id id and active status.
     *
     * @param id the id
     * @param activeStatus the active status
     * @return the loc advice prep wf entity
     */
    LocAccountCloseWfEntity findByTrnIdIdAndActiveStatus(Long id, int activeStatus);
}
