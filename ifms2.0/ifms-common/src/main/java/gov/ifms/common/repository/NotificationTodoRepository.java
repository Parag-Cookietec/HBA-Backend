package gov.ifms.common.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.dto.CountBaseOnMenuDTO;
import gov.ifms.common.entity.NotificationTodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author IFMS 2.0
 *
 */
@Repository
@Transactional
public interface NotificationTodoRepository extends JpaRepository<NotificationTodoEntity, Long> , GenericDao {

	/**
	 * @param menuList
	 * @param pouList
	 * @return List Of Todo Counts base Menu Id
	 */
	@Query(value = "SELECT COUNT(TNF_TODO_ID) as count,LISTING_MENU_ID as menuId "
			+ "FROM EDP.TNF_TODO WHERE ASSIGN_TO_POU_ID = :pouId "
			+ "GROUP BY LISTING_MENU_ID HAVING LISTING_MENU_ID IN (:menuList)", nativeQuery = true)
	public List<CountBaseOnMenuDTO> getCountBaseOnMenu(@Param("menuList") List<Long> menuList,
			@Param("pouId") Long pouId);

	NotificationTodoEntity findByTrnIdAndListingMenuIdAndActiveStatus(Long trnId, Long menuId, int activeStatus);

    NotificationTodoEntity findByListingMenuIdAndTrnIdAndActiveStatus(Long listingMenuId, Long trnId, int activeStatus);
}
