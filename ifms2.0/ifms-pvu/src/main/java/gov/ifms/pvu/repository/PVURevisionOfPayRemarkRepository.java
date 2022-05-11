package gov.ifms.pvu.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVURevisionOfPayRemarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * The Class PVUDeemedDateRepository.
 */
@Repository
@Transactional
public interface PVURevisionOfPayRemarkRepository extends JpaRepository<PVURevisionOfPayRemarkEntity, Long>, JpaSpecificationExecutor<PVURevisionOfPayRemarkEntity>, GenericDao {


}
