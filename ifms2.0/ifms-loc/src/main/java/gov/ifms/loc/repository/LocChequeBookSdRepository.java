package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocChequeBookSdEntity;

/**
 * The Class LOCChequeBookDtlController.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 */

@Repository
@Transactional
public interface LocChequeBookSdRepository extends JpaRepository<LocChequeBookSdEntity, Long>,
		JpaSpecificationExecutor<LocChequeBookSdEntity>, GenericDao {

	/**
	 * Find by hdr id id and active status.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<LocChequeBookSdEntity> findByHdrIdIdAndActiveStatus(Long hdrId, int activeStatus);

	/**
	 * Find by hdr id id.
	 *
	 * @param hdrId the hdr id
	 * @return the list
	 */
	List<LocChequeBookSdEntity> findByHdrIdId(Long hdrId);

}
