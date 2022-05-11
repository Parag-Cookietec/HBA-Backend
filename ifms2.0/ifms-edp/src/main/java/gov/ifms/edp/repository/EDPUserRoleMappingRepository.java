package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;

/**
 * The Interface EDPUserRoleMappingRepository.
 */
@Repository
@Transactional
public interface EDPUserRoleMappingRepository extends JpaRepository<EDPUserRoleMappingEntity, Long>,
		JpaSpecificationExecutor<EDPUserRoleMappingEntity>, GenericDao {

	/**
	 * Deletes the EDPUserRoleMappingEntity with the given id.
	 *
	 * @param id           must not be {@literal null}.
	 * @param activeStatus the active status
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 * @return the int
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Modifying
	@Query(value = "update EDPUserRoleMappingEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int updateActiveStatusByRgMapId(@Param("id") long id, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	/**
	 * Find by transaction number and submission status.
	 *
	 * @param transactionNumber the transaction number
	 * @param submissionStatus  the submission status
	 * @return the list
	 */
	public List<EDPUserRoleMappingEntity> findByTransactionNumberAndSubmissionStatus(
			@Param("transactionNumber") String transactionNumber, @Param("submissionStatus") long submissionStatus);

	/**
	 * Find by user role mapping id and submission status.
	 *
	 * @param userRoleMappingId the user role mapping id
	 * @param submissionStatus  the submission status
	 * @return the list
	 */
	public List<EDPUserRoleMappingEntity> findByUserRoleMappingIdAndSubmissionStatus(
			@Param("userRoleMappingId") long userRoleMappingId, @Param("submissionStatus") long submissionStatus);

	/**
	 * Find by transaction number.
	 *
	 * @param transactionNumber the transaction number
	 * @return the list
	 */
	public List<EDPUserRoleMappingEntity> findByTransactionNumber(@Param("transactionNumber") String transactionNumber);

	/**
	 * Update submit status.
	 *
	 * @param userRoleMappingId the user role mapping id
	 * @param submissionStatus  the submission status
	 * @param updatedBy         the updated by
	 * @param updatedDate       the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPUserRoleMappingEntity set submissionStatus= :submissionStatus , updatedBy=:updatedBy , updatedDate=:updatedDate  where userRoleMappingId = :userRoleMappingId")
	public int updateSubmitStatus(@Param("userRoleMappingId") long userRoleMappingId,
			@Param("submissionStatus") EDPLuLookUpInfoEntity submissionStatus, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Find by employee id and post office user id lk po off user id.
	 *
	 * @param empId            the emp id
	 * @param postOfficeUserId the post office user id
	 * @param activeStatus 
	 * @return the list
	 */
	List<EDPUserRoleMappingEntity> findByEmployeeIdAndPostOfficeUserIdLkPoOffUserIdAndActiveStatus(long empId, long postOfficeUserId, int activeStatus);

	/**
	 * Update active status by trn id.
	 * @param newPoOffUserId 
	 * @param newUserId 
	 * @param idList 
	 * 
	 * @param date
	 * @param 
	 * @param idList
	 * @param date 
	 * @param currUserId 
	 *
	 * @param userRoleMappingId     the user role mapping id
	 * @param activeStatus          the active status
	 * @param updatedBy             the updated by
	 * @param updatedDate           the updated date
	 */
	@Modifying
	@Query(value = "UPDATE " + Constant.EDP_MASTER_SCHEMA + ".T_USR_RG_MAP mp SET mp.EMP_ID = (SELECT EMP_ID FROM " + Constant.EDP_MASTER_SCHEMA + ".LK_EMP_USER eu WHERE eu.USER_ID=:newUserId ), mp.LK_PO_OFF_USER_ID =:newPoOffUserId,mp.UPDATED_BY=:currUserId,mp.UPDATED_DATE=:date WHERE mp.T_USR_RG_MAP_ID IN (:idList)",nativeQuery = true)
	public void updateRgMapByEmpIdAndPoOffId(@Param("idList") List<Integer> idList, @Param("newUserId")long newUserId, @Param("newPoOffUserId")long newPoOffUserId, @Param("currUserId")long currUserId,@Param("date") Date date);

	/**
	 * get active RgMap by Emp id and LkPoOffUser Id
	 * 
	 * @param oldPoOffUserId
	 * @param oldUserId
	 *
	 * @param userRoleMappingId the user role mapping id
	 * @param activeStatus      the active status
	 * @param updatedBy         the updated by
	 * @param updatedDate       the updated date
	 */
	@Modifying
	@Query(value = "SELECT mp.T_USR_RG_MAP_ID FROM  " + Constant.EDP_MASTER_SCHEMA + ".T_USR_RG_MAP mp WHERE mp.EMP_ID=(SELECT EMP_ID FROM " + Constant.EDP_MASTER_SCHEMA + ".LK_EMP_USER eu WHERE eu.USER_ID=:oldUserId) "
			+ " AND  mp.LK_PO_OFF_USER_ID=:oldPoOffUserId AND mp.ACTIVE_STATUS=:activeStatus", nativeQuery = true)
	public List<Integer> getRgMapByEmpIdAndPoOffId(@Param("oldUserId")long oldUserId, @Param("oldPoOffUserId") long oldPoOffUserId,@Param("activeStatus") int activeStatus);

	@Modifying
	@Query(value = "update EDPUserRoleMappingEntity set submissionStatus= :submissionStatus ,activeStatus= :activeStatus, updatedBy=:updatedBy , updatedDate=:updatedDate  where userRoleMappingId = :userRoleMappingId")
	public void updateSubmissionStatusByTrnId(@Param("userRoleMappingId") Long userRoleMappingId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	@Modifying
	@Query(value = "UPDATE " + Constant.EDP_MASTER_SCHEMA + ".T_USR_RG_MAP SET ACTIVE_STATUS = 0 WHERE T_USR_RG_MAP_ID = :rgMapId", nativeQuery = true)
	public void updatePreviousSubmittedTransaction(@Param("rgMapId")long rgMapId);

	@Query(value = "SELECT T_USR_RG_MAP_ID FROM " + Constant.EDP_MASTER_SCHEMA + ".T_USR_RG_MAP WHERE LK_PO_OFF_USER_ID = (SELECT LK_PO_OFF_USER_ID FROM " + Constant.EDP_MASTER_SCHEMA + ".T_USR_RG_MAP WHERE T_USR_RG_MAP_ID = :rgMapId) AND STATUS_ID = (SELECT lli.LOOKUP_INFO_ID FROM MASTER_V1.LU_LOOKUP_INFO lli WHERE lli.LOOKUP_INFO_NAME='Approved') AND ACTIVE_STATUS = 1 AND T_USR_RG_MAP_ID <> :rgMapId ", nativeQuery = true)
	public List<Integer> checkPreviousSubmittedTransactionExist(@Param("rgMapId")long rgMapId);

	@Modifying
	@Query(value = "UPDATE " + Constant.EDP_MASTER_SCHEMA + ".TRN_USR_MNU_ROLE_PRM SET T_USR_RG_MAP_ID = :newUserRoleMappingId WHERE T_USR_RG_MAP_ID = :oldUserRoleMappingId ", nativeQuery = true)
	public void updatePreviousRgMapIdToNew(@Param("newUserRoleMappingId")long newUserRoleMappingId,  @Param("oldUserRoleMappingId")long oldUserRoleMappingId);
	
	public List<EDPUserRoleMappingEntity> findByUserRoleMappingId(long userRoleMappingId);
	
	@Query(value = "SELECT LK_USER_MENU_ID,LISTAGG(TUMRP.ROLE_PRM_ID,',') WITHIN GROUP (ORDER BY TUMRP.ROLE_PRM_ID) AS ROLE_PRM_ID, ACTIVE_STATUS, BRANCH_ID, T_USR_RG_MAP_ID, IS_REMOVED, WORKFLOW_ROLE FROM " + Constant.EDP_MASTER_SCHEMA + ".TRN_USR_MNU_ROLE_PRM AS tumrp WHERE TUMRP.T_USR_RG_MAP_ID = :rgMapId GROUP BY LK_USER_MENU_ID, ACTIVE_STATUS, BRANCH_ID, T_USR_RG_MAP_ID, IS_REMOVED, WORKFLOW_ROLE ", nativeQuery = true)
	public List<Integer> getPermissionByRgMapId(@Param("rgMapId")long rgMapId);
	
	@Query(value= "SELECT TURM.T_USR_RG_MAP_ID FROM " + Constant.EDP_MASTER_SCHEMA + ".T_USR_RG_MAP AS turm WHERE turm.LK_PO_OFF_USER_ID = :lkPostOffUsrId AND turm.STATUS_ID = (SELECT lli.LOOKUP_INFO_ID FROM MASTER_V1.LU_LOOKUP_INFO lli WHERE lli.LOOKUP_INFO_NAME='Approved') AND turm.ACTIVE_STATUS = 1", nativeQuery = true)
	public List<EDPUserRoleMappingEntity> checkIfApprovedTrnExist(@Param("lkPostOffUsrId")long lkPostOffUsrId);

	// fetching records from TRN_PRM & TRN_WORKFLOW Table
	@Query(value = "SELECT tumwr.T_USR_RG_MAP_ID FROM MASTER_V1.TRN_USR_MNU_WF_ROLE AS tumwr WHERE tumwr.T_USR_RG_MAP_ID = :userRoleMappingId AND tumwr.ACTIVE_STATUS = 1 UNION SELECT TUMRP.T_USR_RG_MAP_ID FROM MASTER_V1.TRN_USR_MNU_ROLE_PRM AS tumrp WHERE TUMRP.T_USR_RG_MAP_ID = :userRoleMappingId AND tumrp.ACTIVE_STATUS = 1 ", nativeQuery = true)
	public List<Long> getActiveObjectsFromTrn(@Param("userRoleMappingId")long rgMapId);
	
	@Query(value = "SELECT LISTAGG(prm.ROLE_PRM_ID,',') WITHIN GROUP (ORDER BY prm.ROLE_PRM_ID) AS ROLE_PRM_ID FROM	MASTER_V1.TRN_USR_MNU_ROLE_PRM prm WHERE prm.T_USR_RG_MAP_ID IN (:userRoleMappingId ) AND prm.LK_USER_MENU_ID =:lkuserMenuId AND  prm.ROLE_PRM_ID IN (:idList) AND prm.ACTIVE_STATUS=1 GROUP BY  prm.T_USR_RG_MAP_ID ", nativeQuery = true)
	public String getPreviousApprovedPerm(@Param("userRoleMappingId") Long rgMapId,@Param("lkuserMenuId") Long long1 ,@Param("idList")List<Long> rolePrmId);
	
	@Query(value = "SELECT LISTAGG(prm.WF_ROLE_ID,',') WITHIN GROUP (ORDER BY prm.WF_ROLE_ID) AS WF_ROLE_ID FROM	MASTER_V1.TRN_USR_MNU_WF_ROLE prm WHERE prm.T_USR_RG_MAP_ID IN (:rgMapId ) AND prm.LK_USER_MENU_ID =:lkuserMenuId AND  prm.WF_ROLE_ID IN (:idList) AND prm.ACTIVE_STATUS=1 GROUP BY  prm.T_USR_RG_MAP_ID ", nativeQuery = true)
	public String getPreviousApprovedWf(@Param("rgMapId") Long rgMapId,@Param("lkuserMenuId") Long long1 ,@Param("idList")List<Long> rolePrmId);
	
}
