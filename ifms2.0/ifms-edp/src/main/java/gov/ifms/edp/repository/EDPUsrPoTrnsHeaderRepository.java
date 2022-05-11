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
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Interface EDPUsrPoTrnsHeaderRepository.
 */
@Repository
@Transactional
public interface EDPUsrPoTrnsHeaderRepository extends JpaRepository<EDPUsrPoTrnsHeaderEntity, Long>,
		JpaSpecificationExecutor<EDPUsrPoTrnsHeaderEntity>, GenericDao {
	
	/**
	 * Deletes the EDPUserPoTrnsEntity with the given id.
	 *
	 * @param edpUsrPoTrnsHeaderId the edp usr po trns header id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Modifying
	@Query(value = "update EDPUsrPoTrnsHeaderEntity set activeStatus= :activeStatus, updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where edpUsrPoTrnsHeaderId = :edpUsrPoTrnsHeaderId")
	public int deleteUserPoTrnsHeaderById(@Param("edpUsrPoTrnsHeaderId") Long edpUsrPoTrnsHeaderId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	/**
	 * Find top by order by edp usr po trns header id desc.
	 *
	 * @return the EDP usr po trns header entity
	 */
	public EDPUsrPoTrnsHeaderEntity findTopByOrderByEdpUsrPoTrnsHeaderIdDesc();

	/**
	 * Find by trn no and active status.
	 *
	 * @param trnNo the trn no
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<EDPUsrPoTrnsHeaderEntity> findByTrnNoAndActiveStatus(String trnNo, int activeStatus);

	/**
	 * Update user po trns header status.
	 *
	 * @param edpUsrPoTrnsHeaderId the edp usr po trns header id
	 * @param statusId the status id
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPUsrPoTrnsHeaderEntity hdrEntity set hdrEntity.statusId.lookUpInfoId = :statusId,hdrEntity.updatedBy=:updatedBy , "
			+ "hdrEntity.updatedDate=:updatedDate where hdrEntity.edpUsrPoTrnsHeaderId = :edpUsrPoTrnsHeaderId")
	public int updateUserPoTrnsHeaderStatus(@Param("edpUsrPoTrnsHeaderId") Long edpUsrPoTrnsHeaderId, @Param("statusId") Long statusId,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	/**
	 * Find by edp usr po trns header id and active status.
	 *
	 * @param edpUsrPoTrnsHeaderId the edp usr po trns header id
	 * @return the EDP usr po trns header entity
	 */
	public EDPUsrPoTrnsHeaderEntity findByEdpUsrPoTrnsHeaderIdAndActiveStatus(Long edpUsrPoTrnsHeaderId, int activeStatus);
	
	@Modifying
	@Query(value = "update EDPUsrPoTrnsHeaderEntity set hasObjection.lookUpInfoId = :hasObjection, objectionRemarks = :objectionRemarks where edpUsrPoTrnsHeaderId = :edpUsrPoTrnsHeaderId")
	public int updateObjectionForHeader(@Param("hasObjection") Long hasObjection, @Param("objectionRemarks") String objectionRemarks,@Param("edpUsrPoTrnsHeaderId") Long edpUsrPoTrnsHeaderId);
	
	@Query(value = EDPNativeSQLUtil.GET_WF_TABLE_FOR_MENU ,nativeQuery = true)
	List<String> findWfTableForMenu(@Param("menuId") Long menuId);

}
