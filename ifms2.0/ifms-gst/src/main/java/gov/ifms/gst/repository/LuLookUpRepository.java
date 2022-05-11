package gov.ifms.gst.repository;

import gov.ifms.edp.entity.EDPLuLookUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Interface LuLookUpRepository.
 */
@Repository
@Transactional
public interface LuLookUpRepository extends JpaRepository<EDPLuLookUpEntity,Long> ,
                  JpaSpecificationExecutor<EDPLuLookUpEntity> {
	
	/**
	 * This method is used to find look up by name.
	 *
	 * @param lookUpName the look up name
	 * @return EDPLuLookUpEntity
	 */
	EDPLuLookUpEntity findByLookUpName(String lookUpName);
}

