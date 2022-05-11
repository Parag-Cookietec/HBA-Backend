package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPDesignationItrEntity;

/**
 * The Interface EDPDesignationItrRepository.
 */
@Repository
@Transactional
public interface EDPDesignationItrRepository
		extends JpaRepository<EDPDesignationItrEntity, Long>, JpaSpecificationExecutor<EDPDesignationItrEntity> {

	/**
	 * Find by active status equals.
	 *
	 * @param active the active
	 * @return the list
	 */
	public List<EDPDesignationItrEntity> findByActiveStatusEquals(int active);

}
