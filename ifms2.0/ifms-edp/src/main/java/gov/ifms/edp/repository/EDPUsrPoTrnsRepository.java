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
import gov.ifms.edp.entity.EDPUsrPoTrnsEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Interface EDPUsrPoTrnsRepository.
 */
@Repository
@Transactional
public interface EDPUsrPoTrnsRepository
		extends JpaRepository<EDPUsrPoTrnsEntity, Long>, JpaSpecificationExecutor<EDPUsrPoTrnsEntity>, GenericDao {

	/**
	 * Find top by order by edp usr po trns id desc.
	 *
	 * @return the EDP usr po trns entity
	 */
	public EDPUsrPoTrnsEntity findTopByOrderByEdpUsrPoTrnsIdDesc();

	/**
	 * Find all by edp usr po trns header id edp usr po trns header id and active
	 * status.
	 *
	 * @param edpUsrPoTrnsHearerId the edp usr po trns hearer id
	 * @param activeStatus         the active status
	 * @return the list
	 */
	public List<EDPUsrPoTrnsEntity> findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Long edpUsrPoTrnsHearerId);

	/**
	 * Find by edp usr po trns header id edp usr po trns header id and post office
	 * id post office id and active status.
	 *
	 * @param edpUsrPoTrnsHearerId the edp usr po trns hearer id
	 * @param edpPostOfficeId      the edp post office id
	 * @param activeStatus         the active status
	 * @return the EDP usr po trns entity
	 */
	public EDPUsrPoTrnsEntity findByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderIdAndPostOfficeIdPostOfficeIdAndActiveStatus(
			Long edpUsrPoTrnsHearerId, Long edpPostOfficeId, int activeStatus);

	@Modifying
	@Query(value = "update EDPUsrPoTrnsEntity trn set trn.activeStatus=:activeStatus , trn.updatedBy=:updatedBy , trn.updatedDate=:updatedDate where trn.edpUsrPoTrnsHeaderId.edpUsrPoTrnsHeaderId = :edpUsrPoTrnsHeaderId")
	public int updateActiveStatus(@Param("edpUsrPoTrnsHeaderId") Long edpUsrPoTrnsHeaderId,
			@Param("activeStatus") int activeStatus, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Find byto user id user code and active status.
	 *
	 * @param userCode     the user code
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPUsrPoTrnsEntity> findBytoUserIdUserCodeAndActiveStatus(Long userCode, int activeStatus);

	/**
	 * Find user name and post name.
	 *
	 * @param userId the user id
	 * @param postId the post id
	 * @return the object[]
	 */
	@Query(nativeQuery = true, value = EDPNativeSQLUtil.GET_USERNAME_POST_OFFICE_FROM_LKPOU_ID)
	List<Object[]> findUserNameAndPostNameAndOfficeByLkpouId(@Param("lkPouId") Long lkPouId);

	/**
	 * Find all by edp usr po trns header id edp usr po trns header id.
	 *
	 * @param edpUsrPoTrnsHearerId the edp usr po trns hearer id
	 * @return the list
	 */
	public List<EDPUsrPoTrnsEntity> findByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(Long edpUsrPoTrnsHearerId);
	
}