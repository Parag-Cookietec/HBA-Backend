package gov.ifms.common.repository;

import gov.ifms.common.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.common.entity.NotificationTemplate;

import java.util.Optional;

/**
 * @author IFMS 2.0
 *
 */
public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> , GenericDao {

	/**
	 * @param menuId
	 * @param eventCategory
	 * @param eventName
	 * @return NotificationTemplate
	 */
	@Query(value = "SELECT * FROM EDP.TNF_TEMPLATE WHERE "
			+ "MENU_ID = :menuId AND EVENT_CATEGORY = :eventCategory AND EVENT_NAME = :eventName", nativeQuery = true)
	public NotificationTemplate getTemplate(@Param("menuId") Long menuId, @Param("eventCategory") String eventCategory,
			@Param("eventName") String eventName);

	Optional<NotificationTemplate> findByMenuIdAndEventCategoryAndEventNameAndActiveStatus(Long menuId, String eventCategory, String eventName, int activeStatus);

}
