package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocChequeCancelDtlSdEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocChequeCancelDtlSdController.
 *
 * @version v 1.0
 * @created 2021/03/06 17:39:31
 */

@Repository
@Transactional
public interface LocChequeCancelDtlSdRepository extends JpaRepository<LocChequeCancelDtlSdEntity, Long>,
        JpaSpecificationExecutor<LocChequeCancelDtlSdEntity> {

	List<LocChequeCancelDtlSdEntity> findByHdrIdHdrIdAndActiveStatus(Long hdrId, int activeStatus);
    /**
     * Deletes the LocChequeCancelDtlSdEntity with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is
     *                                  {@literal null}
     */
 
	@Query(value = LocDBConstants.GET_CHECK_CNCL_SD_DATA, nativeQuery = true)
	List<Object[]> getChqCnclSdData(Long hdrId, int activeStatus);
}
