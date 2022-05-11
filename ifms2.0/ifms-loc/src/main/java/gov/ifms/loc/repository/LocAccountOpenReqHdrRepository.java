package gov.ifms.loc.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocAccountOpenReqHdrController.
 *
 * @version 1.0
 * @created 2020/12/22 12:52:20
 */
@Repository
@Transactional
public interface LocAccountOpenReqHdrRepository extends JpaRepository<LocAccountOpenReqHdrEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqHdrEntity>, GenericDao {

	/**
	 * Deletes the LocAccountOpenReqHdrEntity with the given id.
	 *
	 * @param departmentId the department id
	 * @param hodId        the hod id
	 * @param officeId     the office id
	 * @param districtId   the district id
	 * @param activeStatus the active status
	 * @param statusId     the status id
	 * @return the loc account open req hdr entity
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	public LocAccountOpenReqHdrEntity findByDeptIdReHdrDepartmentIdAndHodIdAndToOfficeIdOfficeIdAndDistrictIdReHdrDistrictIdAndActiveStatusAndStatusIdLookUpInfoIdNotIn(
			Long departmentId, Long hodId, Long officeId, Long districtId, Integer activeStatus, Set<Long> statusId);

	/**
	 * Gets the open req srch prm.
	 *
	 * @return the open req srch prm
	 */
	@Query(value = LocDBConstants.OPEN_REQ_SRCH_PRM, nativeQuery = true)
	List<Object[]> getOpenReqSrchPrm();

	/**
	 * Gets the all circle.
	 *
	 * @return the all circle
	 */
	@Query(value = LocDBConstants.GET_CIRCLE_LIST, nativeQuery = true)
	List<Object[]> getAllCircle();

	/**
	 * Gets the bank details.
	 *
	 * @param treasuryId   the treasury id
	 * @param activeStatus the active status
	 * @return the bank details
	 */
	@Query(value = LocDBConstants.GET_BANK_DETAILS, nativeQuery = true)
	List<Object[]> getBankDetails(@Param("treasuryId") Long treasuryId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the all circle by departmentId.
	 *
	 * @param departmentId the department id
	 * @param activeStatus the active status
	 * @return the all circle
	 */
	@Query(value = LocDBConstants.GET_CIRCLE_LIST_BY_DEPARTMENT_ID, nativeQuery = true)
	public List<Object[]> getCircleByDepartmentId(@Param("departmentId") Long departmentId,
			@Param("activeStatus") int activeStatus);

	/**
	 * Gets the divsion id from office id.
	 *
	 * @param cardexNo               the cardex no
	 * @param departmentId           the department id
	 * @param ddoNo                  the ddo no
	 * @param districtId             the district id
	 * @param activeStatus           the active status
	 * @param luApprovedLookupInfoId the lu approved lookup info id
	 * @param luActiveLookupInfoId   the lu active lookup info id
	 * @return the divsion id from office id
	 */

	@Query(value = "SELECT mo.DIVISION_ID , mo.CIRCLE_ID FROM MASTER_V1.MS_OFFICE mo WHERE mo.CARDEX_NO =:cardexNo AND mo.DEPARTMENT_ID = :departmentId AND mo.DDO_NO =:ddoNo AND mo.DISTRICT_ID =:districtId AND mo.ACTIVE_STATUS = :activeStatus AND mo.STATUS_ID =:luApprovedLookupInfoId AND mo.OFFICE_STATUS =:luActiveLookupInfoId AND mo.DIVISION_ID IS NOT NULL", nativeQuery = true)
	Object[] getDivsionIdFromOfficeId(@Param("cardexNo") Long cardexNo, @Param("departmentId") Long departmentId,
			@Param("ddoNo") String ddoNo, @Param("districtId") Long districtId, @Param("activeStatus") int activeStatus,
			@Param("luApprovedLookupInfoId") short luApprovedLookupInfoId,
			@Param("luActiveLookupInfoId") long luActiveLookupInfoId);

	/**
	 * Gets the data from grant.
	 *
	 * @param officeId the office id
	 * @return the data from grant
	 */
	@Query(value = LocDBConstants.FETCH_GRANT_LC, nativeQuery = true)
	public List<Object[]> getDataFromGrant(@Param("officeId") Long officeId);

	/**
	 * Gets the div cd from loc sd.
	 *
	 * @param hdrId        the hdr id
	 * @param divisionCd   the division cd
	 * @param activeStatus the active status
	 * @return the div cd from loc sd
	 */
	@Query(value = LocDBConstants.LOC_DIV_CD_CHECK_LOCSD, nativeQuery = true)
	Object getDivCdFromLocSd(@Param("hdrId") Long hdrId, @Param("divisonCd") String divisionCd,
			@Param("activeStatus") int activeStatus);

	/**
	 * Gets the div cd from ms div.
	 *
	 * @param hdrId        the hdr id
	 * @param divisionCd   the division cd
	 * @param activeStatus the active status
	 * @return the div cd from ms div
	 */
	@Query(value = LocDBConstants.LOC_DIV_CD_CHECK_MSDIV, nativeQuery = true)
	Object getDivCdFromMsDiv(@Param("hdrId") Long hdrId, @Param("divisonCd") String divisionCd,
			@Param("activeStatus") int activeStatus);

	/**
	 * Soft delete by id.
	 *
	 * @param hdrId the hdr id
	 */
	@Modifying
	@Query(value = " update LocAccountOpenReqHdrEntity set activeStatus = 0 WHERE  lcOpenReqHdrId =:hdrId")
	void softDeleteById(@Param("hdrId") Long hdrId);

	/**
	 * Gets the users div id.
	 *
	 * @param ddoNo    the ddo no
	 * @param cardexNo the cardex no
	 * @param officeId the office id
	 * @return the users div id
	 */
	@Query(value = LocDBConstants.LOC_OPEN_REQ_USER_DIV, nativeQuery = true)
	Object[] getUsersDivId(@Param("ddoNo") String ddoNo, @Param("cardexNo") Long cardexNo,
			@Param("officeId") Long officeId);

	/**
	 * Check new circle.
	 *
	 * @param trnId        the trn id
	 * @param activeStatus the active status
	 * @return the long
	 */
	@Query(value = LocDBConstants.LOC_OPEN_CIRCLE_CHECK, nativeQuery = true)
	Long checkNewCircle(@Param("hdrId") Long trnId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the circle name code.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the circle name code
	 */
	@Query(value = LocDBConstants.LOC_GET_CIRCLE_NAME_CODE, nativeQuery = true)
	List<Object[]> getCircleNameCode(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Check circle code.
	 *
	 * @param divisionCd   the division cd
	 * @param activeStatus the active status
	 * @return the object
	 */
	@Query(value = LocDBConstants.LOC_CIRCLE_CODE_CHECK, nativeQuery = true)
	Object checkCircleCode(@Param("divCode") String divisionCd, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the exist trn id.
	 *
	 * @param departmentId        the department id
	 * @param districtId          the district id
	 * @param hodId               the hod id
	 * @param toOfficeId          the to office id
	 * @param activeStatus        the active status
	 * @param cancelledLookupName the cancelled lookup name
	 * @param rejectedLookupName  the rejected lookup name
	 * @param approvedByDat 
	 * @return the exist trn id
	 */
	@Query(value = LocDBConstants.GET_EXISTING_ID, nativeQuery = true)
	List<Long> getExistTrnId(@Param("deptId") Long departmentId, @Param("districtId") Long districtId,
			@Param("hodId") Long hodId, @Param("toOfficeId") Long toOfficeId, @Param("activeStatus") int activeStatus,
			@Param("cancel") String cancelledLookupName, @Param("rejected") String rejectedLookupName, @Param("approvedByDat")String approvedByDat);
}
