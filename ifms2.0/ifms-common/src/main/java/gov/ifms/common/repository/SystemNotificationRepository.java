package gov.ifms.common.repository;

import gov.ifms.common.entity.SystemNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
public interface SystemNotificationRepository extends JpaRepository<SystemNotificationEntity, Long> , JpaSpecificationExecutor<SystemNotificationEntity> {
	
	/**
	 * @param menuList
	 * @param pouId
	 * @return List of SystemNotificationEntity
	 */
	@Query(value = "SELECT * FROM EDP.TNF_SN WHERE MENU_ID IN (:menuList) AND ASSIGN_TO_POU_ID  = :pouId ORDER BY CREATED_BY DESC  ", nativeQuery = true)
	public List<SystemNotificationEntity> getSNByPOUList(@Param("menuList") List<Long> menuList, @Param("pouId") long pouId);

	int countByAssignToPouIdAndStatusAndOfficeIdAndActiveStatus(long pouId,String status ,long officeId,int activeStatus);

}
