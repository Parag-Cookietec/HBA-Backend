package gov.ifms.loc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAccountCloseReqHdrEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Interface LocAccountCloseReqHdrRepository.
 */
@Repository
@Transactional
public interface LocAccountCloseReqHdrRepository extends JpaRepository<LocAccountCloseReqHdrEntity, Long>,
		JpaSpecificationExecutor<LocAccountCloseReqHdrEntity>, GenericDao {

	/**
	 * Find by hdr id and active status.
	 *
	 * @param trnId        the trn id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<LocAccountCloseReqHdrEntity> findByLcCloseReqHdrIdAndActiveStatus(Long trnId, int activeStatus);

	/**
	 * Gets the srch param.
	 *
	 * @return the srch param
	 */
	@Query(value = LocDBConstants.LOC_ACC_CLOSE_SRCH_PRM, nativeQuery = true)
	List<Object[]> getSrchParam();

	/**
	 * Soft delete.
	 *
	 * @param dto the dto
	 */
	@Modifying
	@Query(value = " UPDATE LocAccountCloseReqHdrEntity SET activeStatus = 0 where lcCloseReqHdrId = :hdrId")
	void softDelete(@Param("hdrId") Long dto);

	/**
	 * Gets the div id.
	 *
	 * @param officeId the office id
	 * @return the div id
	 */
	@Query(value = LocDBConstants.GET_DIV_ID_FROM_OFFICE, nativeQuery = true)
	Long getDivId(@Param("officeId") Long officeId);

	/**
	 * Check div chq active inactive.
	 *
	 * @param divId the div id
	 * @return the long
	 */
	@Query(value = LocDBConstants.ACC_CLOSE_CHQ_ACT_INACT_CHECK, nativeQuery = true)
	Long checkDivChqActiveInactive(@Param("divisionId") Long divId);

	/**
	 * Check div distribution.
	 *
	 * @param divId the div id
	 * @return the long
	 */
	@Query(value = LocDBConstants.ACC_CLOSE_DIST_CHECK, nativeQuery = true)
	Long checkDivDistribution(@Param("divisionId") Long divId);

	/**
	 * Check div advice prep.
	 *
	 * @param divId the div id
	 * @return the long
	 */
	@Query(value = LocDBConstants.ACC_CLOSE_ADVICE_CHECK, nativeQuery = true)
	Long checkDivAdvicePrep(@Param("divisionId") Long divId);

	/**
	 * Gets the closing req office data.
	 *
	 * @param hdrId the hdr id
	 * @return the closing req office data
	 */
	@Query(value = LocDBConstants.GET_CLOSING_REQ_OFFICE_DATA, nativeQuery = true)
	List<Object[]> getClosingReqOfficeData(@Param("hdrId") Long hdrId);

	/**
	 * Update open req hdr.
	 *
	 * @param districtId the district id
	 * @param cardexNo   the cardex no
	 * @param ddoNo      the ddo no
	 * @param statusId   the status id
	 * @return the int
	 */
	@Modifying
	@Query(value = LocDBConstants.UPDATE_OPEN_REQ_HDR, nativeQuery = true)
	public int updateOpenReqHdr(@Param("districtId") Long districtId, @Param("cardexNo") Long cardexNo,
			@Param("ddoNo") Long ddoNo, @Param("statusId") Long statusId);

	/**
	 * Update open request hdr.
	 *
	 * @param districtId the district id
	 * @param cardexNo   the cardex no
	 * @param ddoNo      the ddo no
	 * @param statusId   the status id
	 * @return the int
	 */
	@Modifying
	@Query(value = LocDBConstants.UPDATE_OPEN_REQUEST_HDR, nativeQuery = true)
	public int updateOpenRequestHdr(@Param("districtId") Long districtId, @Param("cardexNo") Long cardexNo,
			@Param("ddoNo") Long ddoNo, @Param("statusId") Long statusId);

	/**
	 * Update ms office.
	 *
	 * @param districtId the district id
	 * @param cardexNo   the cardex no
	 * @param ddoNo      the ddo no
	 * @return the int
	 */
	@Modifying
	@Query(value = LocDBConstants.UPDATE_MASTER_MS_OFFICE, nativeQuery = true)
	public int updateMsOffice(@Param("districtId") Long districtId, @Param("cardexNo") Long cardexNo,
			@Param("ddoNo") String ddoNo);

	LocAccountCloseReqHdrEntity findByActiveStatusAndLcCloseReqHdrId(int activeStatus,Long hdrId);

}
