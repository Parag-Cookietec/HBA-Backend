package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAdvcPrepCheqPaySdEntity;
import gov.ifms.loc.util.LocDBConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Interface LocAdvcPrepCheqPaySdRepository.
 */
@Repository
@Transactional
public interface LocAdvcPrepCheqPaySdRepository extends JpaRepository<LocAdvcPrepCheqPaySdEntity, Long>,
        JpaSpecificationExecutor<LocAdvcPrepCheqPaySdEntity>, GenericDao {

    /**
     * Soft delete by id.
     *
     * @param sdId the sd id
     */
    @Modifying
    @Query(value = " update LocAdvcPrepCheqPaySdEntity set activeStatus = 0 WHERE  sdId =:sdId")
    void softDeleteById(@Param("sdId") Long sdId);

    /**
     * Gets the posting dtl view data.
     *
     * @param hdrId        the hdr id
     * @param activeStatus the active status
     * @return the posting dtl view data
     */
    @Query(value = LocDBConstants.GET_CHECK_PAY_EDIT_DATA, nativeQuery = true)
    List<Object[]> getPostingDtlViewData(Long hdrId, int activeStatus);

}