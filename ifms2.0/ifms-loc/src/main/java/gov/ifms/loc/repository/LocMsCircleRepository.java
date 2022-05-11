package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocMsCircleEntity;

/**
 * The Interface LocMsCircleRepository.
 */
@Repository
@Transactional
public interface LocMsCircleRepository
		extends JpaRepository<LocMsCircleEntity, Long>, JpaSpecificationExecutor<LocMsCircleEntity>, GenericDao {
}
