package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPTrnUserMnuRolePrmEntity;

/**
 * The Interface EDPTrnUserMnuRolePrmRepository.
 */
@Repository
@Transactional
public interface EDPTrnUserMnuRolePrmRepository
		extends JpaRepository<EDPTrnUserMnuRolePrmEntity, Long>, JpaSpecificationExecutor<EDPTrnUserMnuRolePrmEntity> {

	/**
	 * Find by lk user menu id lk user menu id and active status.
	 *
	 * @param lkUserMenuId the lk user menu id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPTrnUserMnuRolePrmEntity> findByLkUserMenuIdLkUserMenuIdAndActiveStatus(Long lkUserMenuId, int activeStatus);
	
	/**
	 * Find by lk user menu id lk user menu id and active status.
	 *
	 * @param lkUserMenuId the lk user menu id
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value="SELECT tumrp.rolePrmId FROM EDPTrnUserMnuRolePrmEntity tumrp WHERE tumrp.lkUserMenuId.lkUserMenuId = :lkUserMenuId AND tumrp.activeStatus = :activeStatus ")
	Set<Long> getRolePerFromLkUserMenuId(@Param("lkUserMenuId")Long lkUserMenuId,@Param("activeStatus") int activeStatus);
	/**
	 * Update active status by trn usr role prm id.
	 *
	 * @param trnUsrRolePrmId the trn usr role prm id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param date the date
	 */
	@Modifying
	@Query(value = "update EDPTrnUserMnuRolePrmEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where trnUsrRolePrmId IN (:trnUsrRolePrmId)")
	void updateActiveStatusByTrnUsrRolePrmId(@Param("trnUsrRolePrmId") List<Long> trnUsrRolePrmId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date date);
	
	/**
	 * Update active status and role prm id by trn usr role prm id.
	 *
	 * @param trnUsrRolePrmId the trn usr role prm id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param date the date
	 * @param rolePrmId the role prm id
	 */
	@Modifying
	@Query(value = "update EDPTrnUserMnuRolePrmEntity set activeStatus= :activeStatus, rolePrmId = :rolePrmId , updatedBy=:updatedBy , updatedDate=:updatedDate where trnUsrRolePrmId = :trnUsrRolePrmId")
	void updateActiveStatusAndRolePrmIdByTrnUsrRolePrmId(@Param("trnUsrRolePrmId") Long trnUsrRolePrmId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date date, @Param("rolePrmId")Long rolePrmId);
	
	/**
	 * Update active status by trn usr role prm id.
	 *
	 * @param trnUsrRolePrmId the trn usr role prm id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param date the date
	 */
	@Modifying
	@Query(value = "update EDPTrnUserMnuRolePrmEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where trnUsrRolePrmId = :trnUsrRolePrmId")
	void updateActiveStatusByTrnUsrRolePrmId(@Param("trnUsrRolePrmId") Long trnUsrRolePrmId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date date);
	
	
}
