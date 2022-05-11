package gov.ifms.edp.repository;

import java.util.Date;
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
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Interface EDPLkPuoMenuRLWFRepository.
 */
@Repository
@Transactional
public interface EDPLkPuoMenuRLWFRepository extends JpaRepository<EDPTrnUsrMnuWfRole, Long>, JpaSpecificationExecutor<EDPTrnUsrMnuWfRole> , GenericDao {

	/**
	 * Find by lk user menu id lk user menu id and active status.
	 *
	 * @param lkUserMenuId the lk user menu id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPTrnUsrMnuWfRole> findByLkUserMenuIdLkUserMenuIdAndActiveStatus(long lkUserMenuId, int activeStatus);

	@Query(value="SELECT wf.TRN_USR_WF_ROLE_ID, wf.LK_USER_MENU_ID, wf.WF_ROLE_ID, wf.CREATED_BY, wf.CREATED_DATE,wf.CREATED_BY_POST,wf.UPDATED_BY,wf.UPDATED_DATE,wf.UPDATED_BY_POST,wf.ACTIVE_STATUS,wf.BRANCH_ID,wf.T_USR_RG_MAP_ID,wf.IS_REMOVED"
			+ " FROM	MASTER_V1.TRN_USR_MNU_WF_ROLE AS wf"
			+ " WHERE wf.LK_USER_MENU_ID IN (:userMenuId) "
			+ "AND wf.ACTIVE_STATUS = 1 "
			+ "AND wf.T_USR_RG_MAP_ID = :oldUserRoleMappingId ",
			nativeQuery = true)
	List<EDPTrnUsrMnuWfRole> findUnCommonPrmsn(@Param("userMenuId") List<Long> userMenuId, @Param("oldUserRoleMappingId")long oldUserRoleMappingId);
	
	@Modifying
	@Query(value = "update EDPTrnUsrMnuWfRole set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where trnUsrWfRoleId IN (:trnUsrWfRoleId)")
	void updateActiveStatusByTrnUsrWfRoleId(@Param("trnUsrWfRoleId") List<Long> trnUsrWfRoleId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date date);
	
	
	// find User_RG_map ForeignKey
	@Query(value = "SELECT * FROM MASTER_V1.TRN_USR_MNU_WF_ROLE tbl WHERE tbl.TRN_USR_WF_ROLE_ID IN (:trnUsrWfRoleId)",nativeQuery = true)
	List<EDPTrnUsrMnuWfRole> findByTrnUsrWfRoleId(@Param("trnUsrWfRoleId") List<Long> trnUsrWfRoleId);
	
	/**
	 * Update active status by lk menu id and wf role.
	 *
	 * @param lkUserMenuId the lk user menu id
	 * @param activeStatus the active status
	 * @param wfRoleId the wf role id
	 * @param updatedBy the updated by
	 * @param date the date
	 */
	@Modifying
	@Query(value = "update EDPTrnUsrMnuWfRole trnWfRole set trnWfRole.activeStatus= :activeStatus , trnWfRole.updatedBy=:updatedBy , "
			+ "trnWfRole.updatedDate=:updatedDate where trnWfRole.lkUserMenuId.lkUserMenuId = :lkUserMenuId AND trnWfRole.workflowRoleId = :wfRoleId")
	void updateActiveStatusByLkMenuIdAndWfRole(@Param("lkUserMenuId") Long lkUserMenuId, @Param("activeStatus") int activeStatus,
			@Param("wfRoleId") long wfRoleId,@Param("updatedBy") long updatedBy, @Param("updatedDate") Date date);
	
	/**
	 * Find by lk user menu id lk user menu id and workflow role id and active status.
	 *
	 * @param lkUserMenuId the lk user menu id
	 * @param wfRoleId the wf role id
	 * @param activeStatus the active status
	 * @return the EDP trn usr mnu wf role
	 */
	Optional<EDPTrnUsrMnuWfRole> findByLkUserMenuIdLkUserMenuIdAndWorkflowRoleId(Long lkUserMenuId,Long wfRoleId);
	
	@Query(value = EDPNativeSQLUtil.GET_WFROLES_FOR_OFFICE_USER_AND_MENU ,nativeQuery = true)
	List<String> findWfRolesForOfficeUserAndMenu(@Param("officeId")Long officeId,@Param("menuId") Long menuId, @Param("userId") Long userId);
	
}
	