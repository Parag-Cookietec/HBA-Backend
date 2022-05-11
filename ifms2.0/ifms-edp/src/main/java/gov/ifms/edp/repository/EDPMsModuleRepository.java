package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsModuleEntity;

/**
 * The Interface EDPMsModuleRepository.
 */
@Repository
@Transactional
public interface EDPMsModuleRepository extends JpaRepository<EDPMsModuleEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsModuleEntity> {
	
	/**
	 * Find by active status.
	 *
	 * @param active the active
	 * @return the list
	 */
	public List<EDPMsModuleEntity> findByActiveStatus(int active);
	
}
