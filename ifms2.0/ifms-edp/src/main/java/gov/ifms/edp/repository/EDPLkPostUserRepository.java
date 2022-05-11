package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPLkPostUserEntity;

/**
 * The Interface EDPLkPostUserRepository.
 */
@Repository
@Transactional
public interface EDPLkPostUserRepository extends JpaRepository<EDPLkPostUserEntity,Long> , 
                  JpaSpecificationExecutor<EDPLkPostUserEntity>,GenericDao {
	
	/**
	 * Find by edp ms posts post id.
	 *
	 * @param postId the post id
	 * @return the list
	 */
	List<EDPLkPostUserEntity> findByEdpMsPostsPostId(Long postId);
	
	/**
	 * Find post details.
	 *
	 * @param userCode the user code
	 * @return the list
	 */
	@Query(value = "SELECT poOffUser.lkPoOffUserId, poOffUser.userId.userId, msUser.userName, poOffUser.isPrimaryPost.lookUpInfoId, po.postId, po.postName,office.officeId,office.officeName," + 
			"loInfo.lookUpInfoValue,poOff.postOfficeId,msUser.userCode,office.districtId.districtId FROM EDPLkPoOffUserEntity poOffUser " +  
			"LEFT JOIN EDPLuLookUpInfoEntity loInfo ON poOffUser.isPrimaryPost.lookUpInfoId = loInfo.lookUpInfoId " + 
			"LEFT JOIN EDPMsUserEntity msUser ON msUser.userId = poOffUser.userId.userId  AND msUser.activeStatus = 1 " + 
			"LEFT JOIN EDPLkPostOfficeEntity poOff ON poOff.postOfficeId = poOffUser.lkPostOfficeId.postOfficeId " + 
			"LEFT JOIN EDPMsPostEntity po ON po.postId = poOff.postEntity.postId " + 
			"LEFT JOIN EDPMsOfficeEntity office ON office.officeId = poOff.officeEntity.officeId " + 
			"WHERE msUser.userCode =:userCode AND poOffUser.activeStatus=1")
	List<Object[]> findPostDetails(@Param("userCode") long userCode);
	
	
	/**
	 * Find vacant post.
	 *
	 * @param officeId the office id
	 * @param lookUpInfoName the look up info name
	 * @param active the active
	 * @param statusName the status name
	 * @return the list
	 */
	@Query(nativeQuery = true ,value = "SELECT lpo.LK_POST_OFFICE_ID , po.POST_ID , po.POST_NAME , lpo.OFFICE_ID , usr.USER_ID , usr.USER_NAME " + 
			"FROM master_v1.LK_POST_OFFICE lpo LEFT JOIN MASTER_V1.LK_PO_OFF_USER lpou ON lpo.LK_POST_OFFICE_ID = lpou.LK_POST_OFFICE_ID " + 
			"INNER JOIN MASTER_V1.MS_POST po ON po.post_id = lpo.post_id LEFT JOIN MASTER_V1.MS_USER USR ON USR.USER_ID = lpou.USER_ID "+
			"WHERE lpo.OFFICE_ID = :officeId AND lpo.IS_VACANT_POST =:isVacant AND lpo.ACTIVE_STATUS =:active AND po.ACTIVE_STATUS=:active AND "+
			"po.STATUS_ID =:statusId ORDER BY po.POST_NAME ASC")
		public List<Object[]> findVacantPost(@Param("officeId") Long officeId,@Param("isVacant") Long isVacant,@Param("active")Integer active,@Param("statusId")Short statusId);
}
