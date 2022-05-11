package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPLkPoOffUserItrEntity;


/**
 * The Interface EDPLkPoOffUserItrRepository.
 */
@Transactional
@Repository
public interface EDPLkPoOffUserItrRepository
		extends JpaRepository<EDPLkPoOffUserItrEntity, Long>, JpaSpecificationExecutor<EDPLkPoOffUserItrEntity>,GenericDao {

	
}
