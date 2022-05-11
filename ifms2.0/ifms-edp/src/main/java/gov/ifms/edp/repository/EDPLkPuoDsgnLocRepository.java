package gov.ifms.edp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkPuoDsgnLocEntity;

/**
 * The Class EDPLkPuoDsgnLocController.
 * 
 * @version 1.0
 * @created 2019/12/11 16:14:51
 */

@Repository
@Transactional
public interface EDPLkPuoDsgnLocRepository
		extends JpaRepository<EDPLkPuoDsgnLocEntity, Long>, JpaSpecificationExecutor<EDPLkPuoDsgnLocEntity> {
	
	Optional<EDPLkPuoDsgnLocEntity> findByPostUserOfficeId(Long postUserOfficeId);
}
