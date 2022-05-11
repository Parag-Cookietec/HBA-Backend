package gov.ifms.loc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocChequeToChequeHDREntity;
import gov.ifms.loc.util.LocDBConstants;


/**
 * The Class LocChequeToChequeHDRController.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:27:48
 */

@Repository
@Transactional
public interface LocChequeToChequeHDRRepository extends JpaRepository<LocChequeToChequeHDREntity, Long>,
		JpaSpecificationExecutor<LocChequeToChequeHDREntity>, GenericDao {

	/**
	 * Gets the header cheque to cheque list.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the header cheque to cheque list
	 */
	@Query(value = LocDBConstants.GET_HEDER_CHECK_TO_CHECK_DATA, nativeQuery = true)
	List<Object[]> getHeaderChequeToChequeList(@Param("hdrId") Long id, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the chq to chq srch data.
	 *
	 * @param missingChequeNo the missing cheque no
	 * @param activeStatus    the active status
	 * @return the chq to chq srch data
	 */
	@Query(value = LocDBConstants.GET_CHEQUE_TO_CHEQUE_SEARCH_DATA, nativeQuery = true)
	List<Object[]> getChqToChqSrchData(@Param("chqNo") String missingChequeNo, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the dtl data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the dtl data
	 */
	@Query(value = LocDBConstants.GET_CHQ_TO_CHQ_VIEW, nativeQuery = true)
	List<Object[]> getDtlData(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the sd data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the sd data
	 */
	@Query(value = LocDBConstants.GET_CHQ_TO_CHQ_EDIT, nativeQuery = true)
	List<Object[]> getSdData(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Find by active status and id.
	 *
	 * @param activeStatus the active status
	 * @param id           the id
	 * @return the optional
	 */
	Optional<LocChequeToChequeHDREntity> findByActiveStatusAndId(int activeStatus, Long id);

	/**
	 * Find by id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the loc cheque cancel hdr entity
	 */
	LocChequeToChequeHDREntity findByIdAndActiveStatus(Long id, int activeStatus);

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 */
	@Query(value = LocDBConstants.GET_LOC_CHEQUETOCHEQUE_SRCH_PARAM, nativeQuery = true)
	List<Object[]> getSearchParam();

	/**
	 * Gets the missing chq no.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the missing chq no
	 */
	@Query(value = LocDBConstants.GET_MISSING_CHEQUE_NUMBER, nativeQuery = true)
	String getMissingChqNo(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

/**
 * Gets the chq to chq hdr.
 *
 * @param hdrId the hdr id
 * @param activeStatus the active status
 * @return the chq to chq hdr
 */
	@Query(value = LocDBConstants.GET_CHQ_TO_CHQ_HDR,nativeQuery = true)
	List<Object[]> getChqToChqHdr(Long hdrId, int activeStatus);
	
	/**
	 * Chq auth status.
	 *
	 * @param chqNo the chq no
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = LocDBConstants.GET_CHQ_AUTH, nativeQuery = true)
	List<Object[]> chqAuthStatus (@Param("chqNo") String chqNo, @Param("activeStatus") int activeStatus);
	
	/**
	 * Chq in process.
	 *
	 * @param chqNo the chq no
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = LocDBConstants.GET_CHQ_INPROCESS, nativeQuery = true)
	List<Object[]> chqInProcess (@Param("chqNo") String chqNo, @Param("activeStatus") int activeStatus, @Param(("hdrId")) Long hdrId);
}
