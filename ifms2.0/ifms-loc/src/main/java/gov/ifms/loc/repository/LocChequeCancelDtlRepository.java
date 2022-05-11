package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocChequeCancelDtlEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocChequeCancelDtlController.
 *
 * @version v 1.0
 * @created 2021/03/06 17:42:56
 */

@Repository
@Transactional
public interface LocChequeCancelDtlRepository
		extends JpaRepository<LocChequeCancelDtlEntity, Long>, JpaSpecificationExecutor<LocChequeCancelDtlEntity> {

	/**
	 * Find by hdr id hdr id and active status.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<LocChequeCancelDtlEntity> findByHdrIdHdrIdAndActiveStatus(Long hdrId, int activeStatus);

	/**
	 * Gets the chq cncl dtl data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the chq cncl dtl data
	 */
	@Query(value = LocDBConstants.GET_CHECK_CNCL_DTL_DATA, nativeQuery = true)
	List<Object[]> getChqCnclDtlData(Long hdrId, int activeStatus);
}
