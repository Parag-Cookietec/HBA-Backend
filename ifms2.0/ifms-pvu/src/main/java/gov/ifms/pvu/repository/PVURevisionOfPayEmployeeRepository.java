package gov.ifms.pvu.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVURevisionOfPayEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * The Class PVURevisionOfPayEmployeeRepository.
 */
@Repository
public interface PVURevisionOfPayEmployeeRepository extends JpaRepository<PVURevisionOfPayEmployeeEntity, Long>, JpaSpecificationExecutor<PVURevisionOfPayEmployeeEntity>, GenericDao {

}
