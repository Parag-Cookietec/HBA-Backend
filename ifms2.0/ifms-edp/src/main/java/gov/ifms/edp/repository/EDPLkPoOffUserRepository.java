package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Interface EDPLkPoOffUserRepository.
 */
@Transactional
@Repository
public interface EDPLkPoOffUserRepository
		extends JpaRepository<EDPLkPoOffUserEntity, Long>, JpaSpecificationExecutor<EDPLkPoOffUserEntity>,GenericDao {

	/**
	 * Find by user id user id and active status.
	 *
	 * @param userId       the user id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPLkPoOffUserEntity> findByUserIdUserIdAndActiveStatus(Long userId, int activeStatus);

	/**
	 * Find by lk post office id office entity office id and active status.
	 *
	 * @param officeId     the office id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPLkPoOffUserEntity> findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(Long officeId, int activeStatus);

	/**
	 * Find by user id user id and active status and is primary post look up info
	 * name.
	 *
	 * @param userId       the user id
	 * @param activeStatus the active status
	 * @param lookUpName   the look up name
	 * @return the optional
	 */
	Optional<EDPLkPoOffUserEntity> findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(Long userId,
			int activeStatus, String lookUpName);

	/**
	 * Find by lk post office id post office id and active status.
	 *
	 * @param postOfficeId the post office id
	 * @param activeStatus the active status
	 * @return the EDP lk po off user entity
	 */
	EDPLkPoOffUserEntity findByLkPostOfficeIdPostOfficeIdAndActiveStatus(Long postOfficeId, int activeStatus);

	/**
	 * Find by lk post office id post office id.
	 *
	 * @param postOfficeId the post office id
	 * @return the EDP lk po off user entity
	 */
	EDPLkPoOffUserEntity findByLkPostOfficeIdPostOfficeId(Long postOfficeId);

	/**
	 * Find by lk post office id post office id and user id user id and active
	 * status.
	 *
	 * @param poOffId      the po off id
	 * @param userId       the user id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<EDPLkPoOffUserEntity> findByLkPostOfficeIdPostOfficeIdAndUserIdUserIdAndActiveStatus(long poOffId,
			long userId, int activeStatus);

	/**
	 * Find by lk post office id post office id and user id user id.
	 *
	 * @param poOffId the po off id
	 * @param userId  the user id
	 * @return the optional
	 */
	Optional<EDPLkPoOffUserEntity> findByLkPostOfficeIdPostOfficeIdAndUserIdUserId(long poOffId, long userId);

	/**
	 * Find by user id user id and lk post office id post entity post id and lk post
	 * office id office entity office id and active status.
	 *
	 * @param userId   the user id
	 * @param postId   the post id
	 * @param officeId the office id
	 * @param active   the active
	 * @return the list
	 */
	public List<EDPLkPoOffUserEntity> findByUserIdUserIdAndLkPostOfficeIdPostEntityPostIdAndLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(
			Long userId, Long postId, Long officeId, int active);

	/**
	 * Find by user id user id and lk post office id post entity post id and active
	 * status.
	 *
	 * @param userId the user id
	 * @param postId the post id
	 * @param active the active
	 * @return the list
	 */
	public List<EDPLkPoOffUserEntity> findByUserIdUserIdAndLkPostOfficeIdPostEntityPostIdAndActiveStatus(Long userId,
			Long postId, int active);

	/**
	 * Update active status.
	 *
	 * @param lkPostOfficeId the lk post office id
	 * @param userId the user id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPLkPoOffUserEntity pou set pou.activeStatus= :activeStatus,  pou.updatedBy=:updatedBy , "
			+ "pou.updatedDate=:updatedDate where pou.lkPostOfficeId.postOfficeId = :lkPostOfficeId and pou.userId.userId = :userId and pou.activeStatus =1")
	public int updateActiveStatus(@Param("lkPostOfficeId") Long lkPostOfficeId, @Param("userId") Long userId,
			@Param("activeStatus") int activeStatus, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);
	
	/**
	 * Update active status.
	 *
	 * @param lkPoOffUserId the lk po off user id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPLkPoOffUserEntity pou set pou.activeStatus= :activeStatus,  pou.updatedBy=:updatedBy , "
			+ "pou.updatedDate=:updatedDate where pou.lkPoOffUserId = :lkPoOffUserId")
	public int updateActiveStatus(@Param("lkPoOffUserId") Long lkPoOffUserId ,@Param("activeStatus") int activeStatus, 
			@Param("updatedBy") long updatedBy,@Param("updatedDate") Date updatedDate);
	
	/**
	 * Find by lk post office id post entity post id.
	 *
	 * @param postId the post id
	 * @param activeStatus the active status
	 * @return the EDP lk po off user entity
	 */
	EDPLkPoOffUserEntity findByLkPostOfficeIdPostEntityPostIdAndActiveStatus(Long postId,int activeStatus);
	
	/**
	 * Multipal update active status.
	 *
	 * @param lkPoOffUserId the lk po off user id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedByPost the updated by post
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPLkPoOffUserEntity pou set pou.activeStatus= :activeStatus,  pou.updatedBy=:updatedBy , "
			+ "pou.updatedDate=:updatedDate,updatedByPost = :updatedByPost where pou.lkPostOfficeId.postOfficeId IN (:lkPoOffUserId)")
	public int multipalUpdateActiveStatus(@Param("lkPoOffUserId") Set<Long> lkPoOffUserId ,@Param("activeStatus") int activeStatus, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate);
	
	/**
	 * Find by lk post office id post office id.
	 *
	 * @param activeStatus the active status
	 * @param postOfficeId the post office id
	 * @return the EDP lk po off user entity
	 */
	List<EDPLkPoOffUserEntity> findByActiveStatusAndLkPostOfficeIdPostOfficeIdIn(int activeStatus, Set<Long> postOfficeId);
	
	/**
	 * Find by user id user id and is primary post look up info id and active status.
	 *
	 * @param userId the user id
	 * @param lookupId the lookup id
	 * @param activeStatus the active status
	 * @return the EDP lk po off user entity
	 */
	EDPLkPoOffUserEntity findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(Long userId, Long lookupId, int activeStatus);

	/**
	 * Find by lk post office id office entity office id and active status and lk post office id active status.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @param postOfficeactiveStatus the post officeactive status
	 * @return the list
	 */
	List<EDPLkPoOffUserEntity> findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatusAndLkPostOfficeIdActiveStatus(Long officeId, int activeStatus, int postOfficeactiveStatus);

	/**
	 * Gets the all user code by office id.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the all user code by office id
	 */
	@Query(value = EDPNativeSQLUtil.GET_ALL_USER_CODE_BY_OFFICE_ID , nativeQuery = true )
	List<Long> getAllUserCodeByOfficeId(@Param("officeId")Long officeId, @Param("activeStatus") int activeStatus);
	
	@Query("SELECT a FROM EDPLkPoOffUserEntity a WHERE"
			+ " a.lkPoOffUserId = :lkPoOffUserId AND "
			+ " a.activeStatus = :activeStatus")
	EDPLkPoOffUserEntity findByLkPostOfficeUserIdAndActiveStatus(@Param("lkPoOffUserId") Long poOffUserId, @Param("activeStatus") int activeStatus);

	/**
	 * @param postOfficeId
	 * @return
	 */
	@Query(value = "select lpou from EDPLkPoOffUserEntity lpou where lpou.lkPostOfficeId.postOfficeId in (:postOfficeId) order by lpou.lkPoOffUserId desc")
	List<EDPLkPoOffUserEntity> findByLkPostOfficeIdAndUserIdValueAsNull(Set<Long> postOfficeId);

}
