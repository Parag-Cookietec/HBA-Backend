package gov.ifms.edp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;

/**
 * The Interface EDPLkUserMenuRepository.
 */
@Repository
@Transactional
public interface EDPLkUserMenuRepository extends JpaRepository<EDPLkUserMenuEntity, Long>, JpaSpecificationExecutor<EDPLkUserMenuEntity> , GenericDao {

	/**
	 * Find by po off user id lk po off user id and active status.
	 *
	 * @param poOffUserId the po off user id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPLkUserMenuEntity> findByPoOffUserIdLkPoOffUserIdAndActiveStatus(Long poOffUserId, int activeStatus);

	/**
	 * Find by po off user id lk po off user id and menu ID and active status.
	 *
	 * @param poOfficeUserId the po office user id
	 * @param menudId the menud id
	 * @param activeStatus the active status
	 * @return the EDP lk user menu entity
	 */
	EDPLkUserMenuEntity findByPoOffUserIdLkPoOffUserIdAndMenuIDAndActiveStatus(long poOfficeUserId, long menudId, int activeStatus);
	
	
	/**
	 * Find by po off user id lk po off user id and menu ID.
	 *
	 * @param poOffUserId the po off user id
	 * @param menudId the menud id
	 * @return the optional
	 */
	Optional<EDPLkUserMenuEntity> findByPoOffUserIdLkPoOffUserIdAndMenuID(Long poOffUserId, long menudId);
	
}
