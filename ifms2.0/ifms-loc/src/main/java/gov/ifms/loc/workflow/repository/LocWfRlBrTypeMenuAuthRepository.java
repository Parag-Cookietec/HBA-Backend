package gov.ifms.loc.workflow.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.workflow.entity.LocWfRlBrTypeMenuAuthEntity;

/**
 * The Interface LocWfRlBrTypeMenuAuthRepository.
 */
@Repository
public interface LocWfRlBrTypeMenuAuthRepository extends JpaRepository<LocWfRlBrTypeMenuAuthEntity,Long> ,
                  JpaSpecificationExecutor<LocWfRlBrTypeMenuAuthEntity> , GenericDao {

    /**
     * Find top 1 by menu id and active status.
     *
     * @param menuId the menu id
     * @param activeStatus the active status
     * @return the optional
     */
    Optional<LocWfRlBrTypeMenuAuthEntity> findTop1ByMenuIdAndActiveStatus(long menuId, int activeStatus);
}
