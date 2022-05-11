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
import gov.ifms.loc.entity.LocChequeBookHdrEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocChequeBookHdrController.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:03:50
 */

@Repository
@Transactional
public interface LocChequeBookHdrRepository extends JpaRepository<LocChequeBookHdrEntity, Long>,
		JpaSpecificationExecutor<LocChequeBookHdrEntity>, GenericDao {

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 */
	@Query(value = LocDBConstants.CHEQUEBOOK_SRCH_PRM, nativeQuery = true)
	List<Object[]> getSearchParam();

	/**
	 * Gets the cheque book data.
	 *
	 * @param deptId       the dept id
	 * @param cradexNo     the cradex no
	 * @param ddoNo        the ddo no
	 * @param officeNameId the office name id
	 * @param activeStatus the active status
	 * @return the cheque book data
	 */
	@Query(value = LocDBConstants.GET_CHEQUE_BOOK_DATA, nativeQuery = true)
	List<Object[]> getChequeBookData(@Param("deptId") Long deptId, @Param("cardexNo") Long cradexNo,
			@Param("ddoNo") Long ddoNo, @Param("officeId") Long officeNameId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the lookup idand name.
	 *
	 * @param parentLookupId the parent lookup id
	 * @param activeStatus   the active status
	 * @return the lookup idand name
	 */
	@Query(value = LocDBConstants.GET_LOOKUP_NAME_ID, nativeQuery = true)
	List<Object[]> getLookupIdandName(@Param("parentLookupId") Long parentLookupId,
			@Param("activeStatus") int activeStatus);

	/**
	 * Gets the cheque book list.
	 *
	 * @param bankAccNo    the bank acc no
	 * @param divId        the div id
	 * @param chqType      the chq type
	 * @param activeStatus the active status
	 * @return the cheque book list
	 */
	@Query(value = LocDBConstants.GET_CHEQUE_BOOK_LIST, nativeQuery = true)
	List<Object[]> getChequeBookList(@Param("bankAccNo") String bankAccNo, @Param("divId") Long divId,
			@Param("chqType") Long chqType, @Param("activeStatus") int activeStatus);

	/**
	 * Find by hdr id and active status.
	 *
	 * @param trnId        the trn id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<LocChequeBookHdrEntity> findByIdAndActiveStatus(Long trnId, int activeStatus);

	/**
	 * Gets the chq book act inact list.
	 *
	 * @param bankAccNo    the bank acc no
	 * @param divId        the div id
	 * @param chqType      the chq type
	 * @param bankId       the bank id
	 * @param activeStatus the active status
	 * @param isActive     the is active
	 * @param authorized   the authorized
	 * @return the chq book act inact list
	 */
	@Query(value = LocDBConstants.GET_CHEQUE_INACTIVE_ACTIVE_LIST, nativeQuery = true)
	List<Object[]> getChqBookActInactList(@Param("bankAccNo") String bankAccNo, @Param("divId") Long divId,
			@Param("chqType") Long chqType, @Param("bankId") Long bankId, @Param("activeStatus") int activeStatus,
			@Param("isActive") String isActive, @Param("authorized") String authorized);

	/**
	 * Find by active status and id.
	 *
	 * @param activeStatus the active status
	 * @param hdrId        the hdr id
	 * @return the loc cheque book hdr entity
	 */
	LocChequeBookHdrEntity findByActiveStatusAndId(int activeStatus, Long hdrId);

	/**
	 * Gets the header info.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the header info
	 */
	@Query(value = LocDBConstants.GET_CHQ_BOOK_HDR_INFO, nativeQuery = true)
	List<Object[]> getHeaderInfo(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the chq book act inact sd list.
	 *
	 * @param activeStatus the active status
	 * @param isActive     the is active
	 * @param isActive1    the is active 1
	 * @param cancel       the cancel
	 * @param reject       the reject
	 * @return the chq book act inact sd list
	 */
	@Query(value = LocDBConstants.GET_CHQ_BOOK_SD_LIST, nativeQuery = true)
	List<Object[]> getChqBookActInactSdList(@Param("activeStatus") int activeStatus, @Param("isActive") String isActive,
			@Param("isActive1") String isActive1, @Param("cancel") String cancel, @Param("rejected") String reject);

	/**
	 * Gets the bank name.
	 *
	 * @param bankId       the bank id
	 * @param activeStatus the active status
	 * @return the bank name
	 */
	@Query(value = LocDBConstants.GET_BANK_NAME, nativeQuery = true)
	Object[] getBankName(@Param("bankId") Long bankId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the div code and name.
	 *
	 * @param divId        the div id
	 * @param activeStatus the active status
	 * @return the div code and name
	 */
	@Query(value = LocDBConstants.GET_DIV_DTL, nativeQuery = true)
	List<Object[]> getDivCodeAndName(@Param("divId") Long divId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the chq book inact sd list.
	 *
	 * @param activeStatus        the active status
	 * @param chqIsInactive       the chq is inactive
	 * @param cancelledLookupName the cancelled lookup name
	 * @param rejected            the rejected
	 * @param authorized          the authorized
	 * @return the chq book inact sd list
	 */
	@Query(value = LocDBConstants.LOC_CHEQUEBOOK_INACTIVE_SD_LIST, nativeQuery = true)
	List<Object[]> getChqBookInactSdList(@Param("activeStatus") int activeStatus,
			@Param("isActive") String chqIsInactive, @Param("cancel") String cancelledLookupName,
			@Param("rejected") String rejected, @Param("authorized") String authorized);

	/**
	 * Gets the dtl data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the dtl data
	 */
	@Query(value = LocDBConstants.LOC_CHEQUEBOOK_DTL_DATA, nativeQuery = true)
	List<Object[]> getDtlData(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the sd inactive list.
	 *
	 * @param activeStatus        the active status
	 * @param authorized          the authorized
	 * @param chqIsInactive       the chq is inactive
	 * @param cancelledLookupName the cancelled lookup name
	 * @param rejected            the rejected
	 * @return the sd inactive list
	 */
	@Query(value = LocDBConstants.LOC_SD_INACTIVE_LIST, nativeQuery = true)
	List<Object[]> getSdInactiveList(@Param("activeStatus") int activeStatus, @Param("authorized") String authorized,
			@Param("isActive") String chqIsInactive, @Param("cancel") String cancelledLookupName,
			@Param("rejected") String rejected);

	/**
	 * Gets the old hdr id.
	 *
	 * @param trnId        the trn id
	 * @param activeStatus the active status
	 * @param authorized   the authorized
	 * @return the old hdr id
	 */
	@Query(value = LocDBConstants.LOC_INACTIVE_FLAG_LIST, nativeQuery = true)
	List<Long> getOldHdrId(@Param("hdrId") Long trnId, @Param("activeStatus") int activeStatus,
			@Param("authorized") String authorized);

	/**
	 * Uesd cheque advice prep test.
	 *
	 * @param chqNo the chq no
	 * @return the list
	 */
	@Query(value = LocDBConstants.LOC_USED_CHEQUE_ADVICE_PREP, nativeQuery = true)
	List<Long> uesdChequeAdvicePrepTest(@Param("chequeNumber") String chqNo);

	/**
	 * Uesd cheque chq to chq test.
	 *
	 * @param chqNo the chq no
	 * @return the list
	 */
	@Query(value = LocDBConstants.LOC_USED_CHEQUE_TO_CHEQUE, nativeQuery = true)
	List<Long> uesdChequeChqToChqTest(@Param("chequeNumber") String chqNo);

	/**
	 * Gets the cheque start ser.
	 *
	 * @param hdrId the hdr id
	 * @return the cheque start ser
	 */
	@Query(value = LocDBConstants.GET_START_CHQ_SERIES, nativeQuery = true)
	List<String> getChequeStartSer(@Param("hdrId") Long hdrId);

	/**
	 * Gets the low series.
	 *
	 * @param hdrId      the hdr id
	 * @param divisionId the division id
	 * @return the low series
	 */
	@Query(value = LocDBConstants.CHECK_LOWER_CHEQUEBOOK, nativeQuery = true)
	List<String> getLowSeries(@Param("hdrId") Long hdrId, @Param("divisionId") Long divisionId);

	/**
	 * Gets the loc advice chq list.
	 *
	 * @param divisonId    the divison id
	 * @param activeStatus the active status
	 * @return the loc advice chq list
	 */
	@Query(value = LocDBConstants.GET_ADVC_CHEQUE_DATA, nativeQuery = true)
	List<Object[]> getLocAdviceChqList(@Param("divisionId") Long divisonId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the sdactive list.
	 *
	 * @param activeStatus        the active status
	 * @param chqIsInactive       the chq is inactive
	 * @param cancelledLookupName the cancelled lookup name
	 * @param rejected            the rejected
	 * @return the sdactive list
	 */
	@Query(value = LocDBConstants.GET_ACTIVE_CHQ_LIST, nativeQuery = true)
	List<Object[]> getSdactiveList(@Param("activeStatus") int activeStatus, @Param("isActive") String chqIsInactive,
			@Param("cancel") String cancelledLookupName, @Param("rejected") String rejected);
}
