package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLuLookUpEntity;

/**
 * The Interface EDPLuLookUpRepository.
 */
@Repository
@Transactional
public interface EDPLuLookUpRepository extends JpaRepository<EDPLuLookUpEntity,Long> , 
                  JpaSpecificationExecutor<EDPLuLookUpEntity> {
	
	/**
	 * This method is used to find look up by name.
	 *
	 * @param lookUpName the look up name
	 * @return EDPLuLookUpEntity
	 */
	EDPLuLookUpEntity findByLookUpName(String lookUpName);
}

