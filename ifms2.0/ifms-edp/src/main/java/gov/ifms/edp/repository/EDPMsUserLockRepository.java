package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.oauth.entity.EdpMsUserLockEntity;

/**
 * The Interface EDPMsUserRepository.
 */
@Repository
@Transactional
public interface EDPMsUserLockRepository extends JpaRepository<EdpMsUserLockEntity, Long>, JpaSpecificationExecutor<EdpMsUserLockEntity>, GenericDao {



	EdpMsUserLockEntity findByUserIdAndActiveStatus(long userId, int activeStatus);

	
}
