package gov.ifms.pvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVURopInwardEntity;
/**
 * The Class PVURopInwardController.
 * 
 * @version v 1.0
 * @created 2020/03/12 14:42:25
 */

@Repository
@Transactional
public interface PVURopInwardRepository extends JpaRepository<PVURopInwardEntity,Long> , 
                  JpaSpecificationExecutor<PVURopInwardEntity>, GenericDao {
	  
}
