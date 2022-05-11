package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocChequeBookDtlEntity;

/**
 * The Class LOCChequeBookDtlController.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 */

@Repository
@Transactional
public interface LocChequeBookDtlRepository extends JpaRepository<LocChequeBookDtlEntity, Long>,
		JpaSpecificationExecutor<LocChequeBookDtlEntity>, GenericDao {

	/**
	 * Find by hdr id id and active status.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<LocChequeBookDtlEntity> findByHdrIdIdAndActiveStatus(Long hdrId, int activeStatus);

	/**
	 * Find by id and active status.
	 *
	 * @param i            the i
	 * @param activeStatus the active status
	 * @return the loc cheque book dtl entity
	 */
	LocChequeBookDtlEntity findByIdAndActiveStatus(Long i, int activeStatus);
}
