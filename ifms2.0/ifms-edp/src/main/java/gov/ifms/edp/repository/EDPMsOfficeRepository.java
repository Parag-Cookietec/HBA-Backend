package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.util.EDPConstant;

// TODO: Auto-generated Javadoc
/**
 * The Interface EDPMsOfficeRepository.
 */
@Repository
@Transactional
public interface EDPMsOfficeRepository
		extends JpaRepository<EDPMsOfficeEntity, Long>, JpaSpecificationExecutor<EDPMsOfficeEntity>, GenericDao {

	/**
	 * Find by office type id look up info id in.
	 *
	 * @param lookUpInfoIds the look up info ids
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByOfficeTypeIdLookUpInfoIdIn(Set<Long> lookUpInfoIds);

	/**
	 * Find max cardex no using district id.
	 *
	 * @param id the id
	 * @return the long
	 */
	@Query("SELECT coalesce(max(office.cardexno), 0) FROM EDPMsOfficeEntity office WHERE office.districtId.districtId=?1 ")
	public Long findMaxCardexNoUsingDistrictId(Long id);

	/**
	 * Find by is co and active status.
	 *
	 * @param isco     the isco
	 * @param active   the active
	 * @param statusId the status id
	 * @param sort     the sort
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByIsCoAndActiveStatusAndStatusId(Long isco, int active, short statusId, Sort sort);

	/**
	 * Update active status by office id.
	 *
	 * @param officeId     the office id
	 * @param activeStatus the active status
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsOfficeEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where officeId = :officeId")
	public int updateActiveStatusByOfficeId(@Param("officeId") long officeId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	/**
	 * Find top by order by office id desc.
	 *
	 * @return the EDP ms office entity
	 */
	public EDPMsOfficeEntity findTopByOrderByOfficeIdDesc();

	/**
	 * Find by district id district id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByDistrictIdDistrictIdAndActiveStatus(Long id, int activeStatus);

	/**
	 * Find by active status and status id or status id is null.
	 *
	 * @param statusId     the status id
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = "from EDPMsOfficeEntity office where (office.statusId=:statusId or office.statusId is null) and office.activeStatus=:activeStatus")
	List<EDPMsOfficeEntity> findByStatusIdOrStatusIdIsNullAndActiveStatus(@Param("statusId") Short statusId,
			@Param("activeStatus") int activeStatus);

	/**
	 * Find all hod office.
	 *
	 * @param statusList   the status list
	 * @param isHod        the is hod
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query("FROM EDPMsOfficeEntity office WHERE (office.statusId IS NULL OR office.statusId In (:statusList)) AND office.isHod = :isHod AND office.activeStatus = :activeStatus")
	List<EDPMsOfficeEntity> findAllHodOffice(@Param("statusList") Set<Short> statusList, @Param("isHod") Long isHod,
			@Param("activeStatus") int activeStatus);

	/**
	 * Find by office id and active status.
	 *
	 * @param officeId     the office id
	 * @param activeStatus the active status
	 * @return the EDP ms office entity
	 */
	EDPMsOfficeEntity findByOfficeIdAndActiveStatus(Long officeId, int activeStatus);

	/**
	 * Find by district id district id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @param isVerified   the is verified
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByDistrictIdDistrictIdAndActiveStatusAndIsVerified(Long id, int activeStatus,
			long isVerified);

	/**
	 * Find by office PVU and active status.
	 *
	 * @param officePVU    the office PVU
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByOfficePVUAndActiveStatus(String officePVU, int activeStatus);

	/**
	 * Find last transaction number.
	 *
	 * @param trnNumber the trn number
	 * @return the long
	 */
	@Query(value = "SELECT MAX(CAST(RIGHT(TRN_NO, 5) AS BIGINT)) AS sss FROM " + Constant.EDP_MASTER_SCHEMA
			+ ".MS_OFFICE WHERE TRN_NO LIKE '%'||?||'%' ", nativeQuery = true)
	public Long findLastTransactionNumber(String trnNumber);

	/**
	 * Update PVU id by office id.
	 *
	 * @param officeId the office id
	 * @param pvuId    the pvu id
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsOfficeEntity set pvuId= :pvuId where officeId = :officeId")
	public int updatePVUIdByOfficeId(@Param("officeId") long officeId, @Param("pvuId") Long pvuId);

	/**
	 * Find by status id or status id is null and active status.
	 *
	 * @param statusId     the status id
	 * @param officeStatus the office status
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = "from EDPMsOfficeEntity office where (office.statusId=:statusId or office.statusId is null) and (office.officeStatus=:officeStatus or office.officeStatus is null) and office.activeStatus=:activeStatus")
	List<EDPMsOfficeEntity> findByStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(
			@Param("statusId") Short statusId, @Param("officeStatus") Long officeStatus,
			@Param("activeStatus") int activeStatus);

	/**
	 * Find by pvu id and status id or status id is null and office status or office
	 * status is null and active status.
	 *
	 * @param pvuId          the pvu id
	 * @param lookupId       the lookup id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByPvuIdAndStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(
			Long pvuId, Short lookupId, Long officeStatusId, int activeStatus);

	/**
	 * Find by district id district id and pvu id and status id or status id is null
	 * and office status or office status is null and active status.
	 *
	 * @param districtId     the district id
	 * @param pvuId          the pvu id
	 * @param lookupId       the lookup id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByDistrictIdDistrictIdAndPvuIdAndStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(
			Long districtId, Long pvuId, Short lookupId, Long officeStatusId, int activeStatus);

	/**
	 * This method is used to find offices by district id and status.
	 *
	 * @param districtId     the district id
	 * @param pvuId          the pvu id
	 * @param lookupId       the lookup id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByDistrictIdDistrictIdAndPvuIdAndStatusIdAndOfficeStatusAndActiveStatus(Long districtId,
			Long pvuId, Short lookupId, Long officeStatusId, int activeStatus);

	/**
	 * This method is used to find offices by district id and status.
	 *
	 * @param districtId     the district id
	 * @param lookupId       the lookup id
	 * @param officeStatusId the office status id
	 * @param activeStatus the active status
	 * @return list of office entity
	 */
	List<EDPMsOfficeEntity> findByDistrictIdDistrictIdAndStatusIdAndOfficeStatusAndActiveStatus(Long districtId,
			Short lookupId, Long officeStatusId, int activeStatus);

	/**
	 * This method is used to find offices by district id and status.
	 *
	 * @param officeTypeId   the office type id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @param sort           the sort
	 * @return list of office entity
	 */
	List<EDPMsOfficeEntity> findByOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatus(Long officeTypeId,
			Short statusId, Long officeStatusId, int activeStatus, Sort sort);

	/**
	 * Find by parent office id and status id and office status or office status is
	 * null and active status.
	 *
	 * @param parentOfficeId the parent office id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByParentOfficeIdAndStatusIdAndOfficeStatusAndActiveStatus(Long parentOfficeId,
			Short statusId, Long officeStatusId, int activeStatus);

	/**
	 * Find by parent office id and status id and office status or office status is
	 * null and active status.
	 *
	 * @param isHodId        the is hod id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByIsHodAndStatusIdAndOfficeStatusAndActiveStatus(Long isHodId, Short statusId,
			Long officeStatusId, int activeStatus);

	/**
	 * Find by parent office id and status id and office status and active status.
	 *
	 * @param parentOfficeId the parent office id
	 * @param isHodId        the is hod id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByParentOfficeIdAndIsHodAndStatusIdAndOfficeStatusAndActiveStatus(Long parentOfficeId,
			Long isHodId, Short statusId, Long officeStatusId, int activeStatus);

	/**
	 * Find by parent office id and status id and office status and active status.
	 *
	 * @param parentOfficeId the parent office id
	 * @param isCoId         the is co id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByParentOfficeIdAndIsCoAndStatusIdAndOfficeStatusAndActiveStatus(Long parentOfficeId,
			Long isCoId, Short statusId, Long officeStatusId, int activeStatus);

	/**
	 * Find by parent office id and status id and office status and active status.
	 *
	 * @param pvuOff         the pvu off
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	EDPMsOfficeEntity findByOfficePVUAndStatusIdAndOfficeStatusAndActiveStatus(String pvuOff, Short statusId,
			Long officeStatusId, int activeStatus);

	/**
	 * Find by parent office id and status id and office status and active status.
	 *
	 * @param offDiv         the off div
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	EDPMsOfficeEntity findByOfficeDivisionAndStatusIdAndOfficeStatusAndActiveStatus(String offDiv, Short statusId,
			Long officeStatusId, int activeStatus);

	/**
	 * Find by office type id look up info id and is fd and cardexno and status id
	 * and office status and active status.
	 *
	 * @param officeTypeId   the office type id
	 * @param isFdId         the is fd id
	 * @param cardexNo       the cardex no
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByOfficeTypeIdLookUpInfoIdAndIsFdAndCardexnoAndStatusIdAndOfficeStatusAndActiveStatus(
			Long officeTypeId, Long isFdId, Long cardexNo, Short statusId, Long officeStatusId, int activeStatus);

	/**
	 * Find by office name and active status.
	 *
	 * @param string the string
	 * @param activeStatus the active status
	 * @return the EDP ms office entity
	 */
	EDPMsOfficeEntity findByOfficeNameAndActiveStatus(String string, int activeStatus);

	/**
	 * Gets the offices.
	 *
	 * @param deptOffice the dept office
	 * @return the offices
	 */
	@Query(value = "SELECT OFF.OFFICE_ID, OFF.OFFICE_TYPE_ID FROM MASTER_V1.MS_OFFICE OFF WHERE OFF.DEPARTMENT_ID = :deptOffice AND OFF.OFFICE_STATUS = 283 AND OFF.STATUS_ID = 327 AND OFF.OFFICE_TYPE_ID IN (54, 52) AND OFF.DISTRICT_ID IN (625,627) ", nativeQuery = true)
	List<Object[]> getOffices(@Param("deptOffice") Long deptOffice);

	/**
	 * Find by district id district id and office sub type and active status.
	 *
	 * @param districtId    the district id
	 * @param officeSubType the office sub type
	 * @param activeStatus  the active status
	 * @return the EDP ms office entity
	 */
	EDPMsOfficeEntity findByDistrictIdDistrictIdAndOfficeSubTypeAndActiveStatus(Long districtId, Long officeSubType,
			int activeStatus);

	/**
	 * Find by office division and active status.
	 *
	 * @param offDiv       the off div
	 * @param activeStatus the active status
	 * @return the EDP ms office entity
	 */
	EDPMsOfficeEntity findByOfficeDivisionAndActiveStatus(String offDiv, int activeStatus);

	/**
	 * Find by office code and active status.
	 *
	 * @param offCode      the off code
	 * @param activeStatus the active status
	 * @return the EDP ms office entity
	 */
	EDPMsOfficeEntity findByOfficeCodeAndActiveStatus(String offCode, int activeStatus);

	/**
	 * Find ddo no by district id district id and active status.
	 *
	 * @param districtId the district id
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = "SELECT lpo.DDO_NO FROM MASTER_V1.MS_OFFICE lpo WHERE lpo.DISTRICT_ID =:districtId AND lpo.ACTIVE_STATUS =:activeStatus ", nativeQuery = true)
	List<String> findDdoNoByDistrictIdDistrictIdAndActiveStatus(@Param("districtId") Long districtId,
			@Param("activeStatus") int activeStatus);

	/**
	 * Update status to reject or cancel by office id.
	 *
	 * @param officeId the office id
	 * @param wfStatus the wf status
	 */
	@Procedure(procedureName = Constant.EDP_SCHEMA
			+ (Constant.DOT + (EDPConstant.SP_SET_OFFICE_STATUS_CANCEL_REJECTED)))
	void updateStatusToRejectOrCancelByOfficeId(@Param(EDPConstant.IN_OFFICE_ID_VALUE) Long officeId,
			@Param(EDPConstant.IN_STATUS) String wfStatus);

	/**
	 * Update dept id by office id.
	 *
	 * @param officeId the office id
	 * @param departmentId the department id
	 */
	@Transactional
	@Modifying
	@Query(value = "update MASTER_V1.MS_OFFICE set DEPARTMENT_ID= :departmentId where OFFICE_ID = :officeId", nativeQuery = true)
	void updateDeptIdByOfficeId(@Param("officeId") Long officeId, @Param("departmentId") long departmentId);

	/**
	 * Find by district id district id and is treasury and active status.
	 *
	 * @param districtId the district id
	 * @param officeSubType the office sub type
	 * @param activeStatus the active status
	 * @return the EDP ms office entity
	 */
	EDPMsOfficeEntity findByDistrictIdDistrictIdAndIsTreasuryAndActiveStatus(Long districtId, Short officeSubType,
			int activeStatus);

	/**
	 * Find by parent office id and status id and office status and active status.
	 *
	 * @param parentOfficeId the parent office id
	 * @param isHodId        the is hod id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @param districtId the district id
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByParentOfficeIdAndIsHodAndStatusIdAndOfficeStatusAndActiveStatusAndDistrictIdDistrictIdInOrderByOfficeNameAsc(
			Long parentOfficeId, Long isHodId, Short statusId, Long officeStatusId, int activeStatus,
			List<Long> districtId);

	/**
	 * Find by office type id look up info id and status id and office status and active status and is fd not and district id district id in order by office name asc.
	 *
	 * @param l the l
	 * @param valueOf the value of
	 * @param m the m
	 * @param activeStatus the active status
	 * @param lookupYes the lookup yes
	 * @param districtId the district id
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatusAndIsFdNotAndDistrictIdDistrictIdInOrderByOfficeNameAsc(
			long l, Short valueOf, long m, int activeStatus, long lookupYes, List<Long> districtId);

	/**
	 * Find trs pao offices by dist.
	 *
	 * @param distIds the dist ids
	 * @param statusId the status id
	 * @param val the val
	 * @param officeSubTypes the office sub types
	 * @param officeStatus the office status
	 * @return the list
	 */
	@Query("SELECT o FROM EDPMsOfficeEntity o WHERE o.districtId.districtId IN (:distIds) AND"
			+ " (o.isSubTreasury = :val OR isTreasury = :val OR o.officeSubType IN (:officeSubTypes))"
			+ " AND o.statusId = :status AND o.officeStatus = :officeStatus AND o.activeStatus = 1 ORDER BY o.officeName")
	List<EDPMsOfficeEntity> findTrsPaoOfficesByDist(@Param("distIds") Set<Long> distIds, @Param("status") Short statusId,
			@Param("val") Short val, @Param("officeSubTypes") Set<Long> officeSubTypes, @Param("officeStatus") Long officeStatus);

	/**
	 * Find by cardex no.
	 *
	 * @param cardexNo the cardex no
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = "SELECT o.cardexno FROM EDPMsOfficeEntity o WHERE o.cardexno =:cardexno AND o.activeStatus =:activeStatus")
	List<Long> findByCardexNo(@Param("cardexno") Long cardexNo,@Param("activeStatus") int activeStatus);
	
	/**
	 * This method is used to find offices by district id and status.
	 *
	 * @param officeTypeId   the office type id
	 * @param subTypeId the sub type id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @param sort           the sort
	 * @return list of office entity
	 */
	List<EDPMsOfficeEntity> findByOfficeTypeIdLookUpInfoIdAndSubTypeSubTypeIdAndStatusIdAndOfficeStatusAndActiveStatus(Long officeTypeId,Long subTypeId,
																									Short statusId, Long officeStatusId, int activeStatus, Sort sort);

	/**
	 * Find by district id district id and office sub type and active status.
	 *
	 * @param districtId    the district id
	 * @param officeSubType the office sub type
	 * @param isTreasury the is treasury
	 * @param statusApprovedId the status approved id
	 * @param officeStatusId the office status id
	 * @param activeStatus  the active status
	 * @return the EDP ms office entity
	 */
	@Query(value = "SELECT o FROM EDPMsOfficeEntity o WHERE o.districtId.districtId=:districtId AND (o.officeSubType = :officeSubType OR o.isTreasury =:isTreasury) AND o.statusId=:statusApprovedId AND o.officeStatus=:officeStatusId AND o.activeStatus = :activeStatus ORDER BY o.officeName")
	List<EDPMsOfficeEntity> findTreasuryOfficeByDistriceId(@Param("districtId") Long districtId,@Param("officeSubType") long officeSubType,@Param("isTreasury") Short isTreasury,@Param("statusApprovedId") Short statusApprovedId,@Param("officeStatusId")  Long officeStatusId,@Param("activeStatus") int activeStatus);

	/**
	 * Find by parent office id and is sub treasury and active status.
	 *
	 * @param officeId the office id
	 * @param intTwoValue the int two value
	 * @param intOneValue the int one value
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByParentOfficeIdAndIsSubTreasuryAndActiveStatus(Long officeId, short intTwoValue,
			int intOneValue);
	
	/**
	 * Find by parent office id and is treasury and active status.
	 *
	 * @param officeId the office id
	 * @param intTwoValue the int two value
	 * @param intOneValue the int one value
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByParentOfficeIdAndIsTreasuryAndActiveStatus(Long officeId, short intTwoValue,
			int intOneValue);
	
	/**
	 * Find off by ddo no cardex no and dist.
	 *
	 * @param ddoNo the ddo no
	 * @param cardexNo the cardex no
	 * @param districtId the district id
	 * @param activeStatus the active status
	 * @param statusId the status id
	 * @param officeStatus the office status
	 * @return the optional
	 */
	@Query(value = "SELECT o FROM EDPMsOfficeEntity o WHERE o.ddoNo=:ddoNo AND o.cardexno =:cardexno AND o.districtId.districtId = :districtId AND o.activeStatus =:activeStatus AND o.statusId = :statusId AND o.officeStatus = :officeStatus")
	Optional<EDPMsOfficeEntity> findOffByDdoNoCardexNoAndDist(@Param("ddoNo") String ddoNo, @Param("cardexno") Long cardexNo, @Param("districtId") Long districtId, @Param("activeStatus") int activeStatus, @Param("statusId") Short statusId, @Param("officeStatus") Long officeStatus);

	/**
	 * Gets the bill submit to by office.
	 *
	 * @param officeId the office id
	 * @param statusApprovedId the status approved id
	 * @param officeStatusId the office status id
	 * @param activeStatus the active status
	 * @return the bill submit to by office
	 */
	@Query(value = "SELECT o FROM EDPMsOfficeEntity o WHERE o.statusId=:statusApprovedId AND o.officeStatus=:officeStatusId AND o.activeStatus = :activeStatus AND o.officeId IN (SELECT bill.billSubmittedTo from EDPOfficeBillMapEntity bill WHERE bill.officeId = :officeId AND bill.activeStatus = :activeStatus) ")
	List<EDPMsOfficeEntity> getBillSubmitToByOffice(@Param("officeId") Long officeId,@Param("statusApprovedId") Short statusApprovedId,@Param("officeStatusId")  Long officeStatusId,@Param("activeStatus") int activeStatus);

	/**
	 * Find by district id district id and office sub type and active status.
	 *
	 * @param districtId    the district id
	 * @param officeSubType the office sub type
	 * @param isTreasury the is treasury
	 * @param statusApprovedId the status approved id
	 * @param officeStatusId the office status id
	 * @param activeStatus  the active status
	 * @return the EDP ms office entity
	 */
	@Query(value = "SELECT o FROM EDPMsOfficeEntity o WHERE o.districtId.districtId=:districtId AND (o.officeSubType = :officeSubType OR o.isTreasury =:isTreasury) AND o.statusId=:statusApprovedId AND o.officeStatus=:officeStatusId AND o.activeStatus = :activeStatus ORDER BY o.officeName")
	List<EDPMsOfficeEntity> findTreasuryOfficeByDistriceId(@Param("districtId") Long districtId,@Param("officeSubType") long officeSubType,@Param("isTreasury") Long isTreasury,@Param("statusApprovedId") Short statusApprovedId,@Param("officeStatusId")  Long officeStatusId,@Param("activeStatus") int activeStatus);

	/**
	 * Find to sto offices.
	 *
	 * @param distId the dist id
	 * @param statusId the status id
	 * @param val the val
	 * @param officeStatus the office status
	 * @return the list
	 */
	@Query("SELECT o FROM EDPMsOfficeEntity o WHERE o.districtId.districtId = :distId AND"
			+ " (o.isSubTreasury = :val OR isTreasury = :val)"
			+ " AND o.statusId = :status AND o.activeStatus = 1 and o.officeStatus= :offStatus ORDER BY o.officeName")
	List<EDPMsOfficeEntity> findToStoOffices(@Param("distId") Long distId, @Param("status") Short statusId,
			@Param("val") Short val, @Param("offStatus") Long officeStatus);

	/**
	 * Find by office type id look up info id and status id and office status and active status and is fd not.
	 *
	 * @param lookupInfoAdminiDept the lookup info admini dept
	 * @param statusApprovedId the status approved id
	 * @param officeStatusId the office status id
	 * @param activeStatus the active status
	 * @param lookupInfoYes the lookup info yes
	 * @param jpaSort the jpa sort
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatusAndIsFdNot(
			Long lookupInfoAdminiDept, Short statusApprovedId, Long officeStatusId, int activeStatus,
			Long lookupInfoYes, Sort jpaSort);

	


    /**
     * Validate cardex no and ddo no by pou id.
     *
     * @param officeId the office id
     * @param activeStatus the active status
     * @return the list
     */
    @Query("SELECT o FROM EDPMsOfficeEntity o WHERE o.officeId IN(:officeId) AND o.activeStatus=:activeStatus")
	List<EDPMsOfficeEntity> validateCardexNoAndDdoNoByPouId(@Param("officeId")List<Long> officeId, @Param("activeStatus")int activeStatus);

	/**
	 * Find by parent office id and status id and office status and active status.
	 *
	 * @param departmentId the parent office id
	 * @param subTypeName         the is co id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByDepartmentIdDepartmentIdAndSubTypeSubTypeNameAndStatusIdAndOfficeStatusAndActiveStatus(Long departmentId,
			String subTypeName, Short statusId, Long officeStatusId, int activeStatus);


	/**
	 * Find by parent office id and status id and office status and active status.
	 *
	 * @param departmentId the parent office id
	 * @param officeTypeId        the is hod id
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param activeStatus   the active status
	 * @return the list
	 */
	List<EDPMsOfficeEntity> findByDepartmentIdDepartmentIdAndOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatus(Long departmentId,
																															   Long officeTypeId, Short statusId, Long officeStatusId, int activeStatus);

	/**
	 * Gets the to pao sto offices.
	 *
	 * @param officeSubTypes the office sub types
	 * @param lookupYes the lookup yes
	 * @param statusApprovedId the status approved id
	 * @param activeStatus the active status
	 * @return the to pao sto offices
	 */
	@Query(value = "SELECT new gov.ifms.edp.dto.ClueDto(o.officeId, o.districtId.districtId, o.officeName, o.districtId.districtName) FROM EDPMsOfficeEntity o WHERE o.officeSubType IN (:officeSubTypes)  AND o.statusId=:statusApprovedId AND o.activeStatus = :activeStatus")
	List<ClueDto> getToPaoStoOffices(@Param("officeSubTypes")List<Long> officeSubTypes,@Param("statusApprovedId")short statusApprovedId, @Param("activeStatus")int activeStatus);


	List<EDPMsOfficeEntity> findByParentOfficeIdAndIsTreasuryAndActiveStatusAndOfficeStatusAndStatusId(Long officeId, short intTwoValue,
            int intOneValue, Long offcieStatusId, short statusId);

 

    List<EDPMsOfficeEntity> findByParentOfficeIdAndIsSubTreasuryAndActiveStatusAndOfficeStatusAndStatusId(Long officeId, short intTwoValue,
            int intOneValue,  Long offcieStatusId, short statusId);
    

    EDPMsOfficeEntity findByOfficeIdAndOfficeStatusAndStatusIdAndActiveStatus(Long officeId, Long officeStatus, Short valueOf,
            int activeStatus);
   
    @Query("FROM EDPMsOfficeEntity office WHERE (office.statusId IS NULL OR office.statusId = :statusList) AND office.isHod = :isHod AND office.activeStatus = :activeStatus AND office.departmentId.departmentId = :deptId Order By office.officeName Asc")
    List<EDPMsOfficeEntity> findAllHodOfficeByDeptId(@Param("statusList") Short statusList, @Param("isHod") Long isHod,
            @Param("activeStatus") int activeStatus, @Param("deptId") Long deptId);

}
