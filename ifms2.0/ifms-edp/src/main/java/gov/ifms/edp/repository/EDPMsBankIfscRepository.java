package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsBankIfscEntity;

/**
 * The Class EDPMsBankIfscController.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:17:24
 */

@Repository
@Transactional
public interface EDPMsBankIfscRepository
		extends JpaRepository<EDPMsBankIfscEntity, Long>, JpaSpecificationExecutor<EDPMsBankIfscEntity> {

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @param sort         the sort
	 * @return the list
	 */
	List<EDPMsBankIfscEntity> findByActiveStatus(int activeStatus, Sort sort);

}
