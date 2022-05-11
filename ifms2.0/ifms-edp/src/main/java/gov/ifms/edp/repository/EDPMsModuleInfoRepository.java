package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsModuleInfoEntity;

/**
 * The Interface EDPMsModuleInfoRepository.
 */
@Repository
@Transactional
public interface EDPMsModuleInfoRepository extends JpaRepository<EDPMsModuleInfoEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsModuleInfoEntity> {
	
	/**
	 * Find by parent module id module ID.
	 *
	 * @param moduleID the module ID
	 * @return the list
	 */
	List<EDPMsModuleInfoEntity> findByParentModuleIdModuleID(Long moduleID);
}
