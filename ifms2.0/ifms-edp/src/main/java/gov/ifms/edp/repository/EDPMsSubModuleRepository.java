package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.entity.EDPMsSubModuleEntity;

/**
 * The Interface EDPMsSubModuleRepository.
 */
@Repository
@Transactional
public interface EDPMsSubModuleRepository extends JpaRepository<EDPMsSubModuleEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsSubModuleEntity> {

	
	/**
	 * Find by module id module ID and active status.
	 *
	 * @param moduleId the module id
	 * @param activeStatus the active status
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	List<EDPMsSubModuleEntity> findByModuleIdModuleIDAndActiveStatus(long moduleId , int activeStatus) throws CustomException;
}
