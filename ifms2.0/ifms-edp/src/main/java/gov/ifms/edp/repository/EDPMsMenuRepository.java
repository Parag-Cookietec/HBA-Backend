package gov.ifms.edp.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPMsMenuEntity;

/**
 * The Interface EDPMsMenuRepository.
 */
@Repository
@Transactional
public interface EDPMsMenuRepository
		extends JpaRepository<EDPMsMenuEntity, Long>, JpaSpecificationExecutor<EDPMsMenuEntity>,GenericDao {

	/**
	 * Find by active status and menu id.
	 *
	 * @param activeStatus the active status
	 * @param idList the id list
	 * @return the optional
	 */
	Optional<EDPMsMenuEntity> findByActiveStatusAndMenuId(int activeStatus, Long idList);
	
	/**
	 * Find by active status and menu name in.
	 *
	 * @param activeStatus the active status
	 * @param menuNames the menu names
	 * @return the list
	 */
	List<EDPMsMenuEntity> findByActiveStatusAndMenuNameIn(int activeStatus, Set<String> menuNames);
	
	/**
	 * Find by active status and sub module id sub module id.
	 *
	 * @param activeStatus the active status
	 * @param subModuleId the sub module id
	 * @return the list
	 */
	List<EDPMsMenuEntity> findByActiveStatusAndSubModuleIdSubModuleId(int activeStatus, Long subModuleId);

	/**
	 * Find by module id module ID and active status.
	 *
	 * @param subModuleId the sub module id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsMenuEntity> findByModuleIdModuleIDAndActiveStatus(Long subModuleId, int activeStatus);

	List<EDPMsMenuEntity> findByActiveStatusAndLinkMenuId( int activeStatus,Long linkMenuId);

}
