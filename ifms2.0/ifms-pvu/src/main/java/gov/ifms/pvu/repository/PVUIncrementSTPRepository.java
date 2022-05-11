package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUIncrementSTPEntity;

/**
 * The Interface PVUIncrementSTPRepository.
 */
@Repository
@Transactional
public interface PVUIncrementSTPRepository extends JpaRepository<PVUIncrementSTPEntity, Long>,
		JpaSpecificationExecutor<PVUIncrementSTPEntity>, GenericDao {

}
