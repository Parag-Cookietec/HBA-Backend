package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsBankEntity;

/**
 * The Interface EDPMsBankRepository.
 */
@Repository
@Transactional
public interface EDPMsBankRepository extends JpaRepository<EDPMsBankEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsBankEntity> {

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsBankEntity> findByActiveStatus(int activeStatus);

}
