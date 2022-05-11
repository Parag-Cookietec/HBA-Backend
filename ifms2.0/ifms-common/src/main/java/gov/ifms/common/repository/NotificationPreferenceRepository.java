package gov.ifms.common.repository;

import java.util.List;

import gov.ifms.common.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.entity.NotificationPreferenceEntity;

/**
 * @author IFMS 2.0
 *
 */
@Repository
@Transactional
public interface NotificationPreferenceRepository extends JpaRepository<NotificationPreferenceEntity, Long> , GenericDao {

	/**
	 * @param userId 
	 * @return NotificationPreferenceEntity
	 */
	@Query(value = "SELECT * FROM EDP.TNF_PREFERENCE WHERE USER_ID = :userId", nativeQuery = true)
	public NotificationPreferenceEntity getPreferenceByUserId(@Param("userId") Long userId);
	
	/**
	 * @param userId
	 * @param menuList
	 * @return List Of NotificationPreferenceEntity
	 */
	@Query(value = "SELECT * FROM EDP.TNF_PREFERENCE WHERE USER_ID = :userId AND MENU_ID IN (:menuList)", nativeQuery = true)
	public List<NotificationPreferenceEntity> getPreference(@Param("userId") Long userId,@Param("menuList") List<Long> menuList);
}
