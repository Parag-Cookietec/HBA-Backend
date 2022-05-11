package gov.ifms.edp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.edp.entity.EDPMsBillEntity;

/**
 * The Class EDPMsBillController.
 * 
 * @version 1.0
 * @created 2020/01/29 17:03:45
 */
@Repository 
@Transactional
public interface EDPMsBillRepository
		extends JpaRepository<EDPMsBillEntity, Long>, JpaSpecificationExecutor<EDPMsBillEntity> {
	
	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsBillEntity> findByActiveStatus(int activeStatus);
	
}
