package gov.ifms.gst.workflow.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.workflow.entity.GstWfRlBrTypeMenuAuthEntity;

/**
 * The Interface GstWfRlBrTypeMenuAuthRepository.
 */
@Repository
public interface GstWfRlBrTypeMenuAuthRepository extends JpaRepository<GstWfRlBrTypeMenuAuthEntity,Long> ,
                  JpaSpecificationExecutor<GstWfRlBrTypeMenuAuthEntity> , GenericDao {

    /**
     * Find top 1 by menu id and active status.
     *
     * @param menuId the menu id
     * @param activeStatus the active status
     * @return the optional
     */
    Optional<GstWfRlBrTypeMenuAuthEntity> findTop1ByMenuIdAndActiveStatus(long menuId, int activeStatus);
}
