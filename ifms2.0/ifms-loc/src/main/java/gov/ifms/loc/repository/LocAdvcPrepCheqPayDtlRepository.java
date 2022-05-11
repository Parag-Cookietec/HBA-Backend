package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAdvcPrepCheqPayDtlEntity;
import gov.ifms.loc.util.LocDBConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * The Interface LocAdvcPrepCheqPayDtlRepository.
 */
public interface LocAdvcPrepCheqPayDtlRepository extends JpaRepository<LocAdvcPrepCheqPayDtlEntity, Long>,
        JpaSpecificationExecutor<LocAdvcPrepCheqPayDtlEntity>, GenericDao {

    /**
     * Gets the posting dtl edit data.
     *
     * @param hdrId        the hdr id
     * @param activeStatus the active status
     * @return the posting dtl edit data
     */
    @Query(value = LocDBConstants.GET_CHECK_PAY_VIEW_DATA, nativeQuery = true)
    List<Object[]> getPostingDtlEditData(Long hdrId, int activeStatus);

    
   
}
