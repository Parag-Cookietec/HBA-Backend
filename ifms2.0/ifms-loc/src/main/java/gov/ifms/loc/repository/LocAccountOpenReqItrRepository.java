package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAccountOpenReqItrEntity;
/**
 * The Class LocAccountOpenReqItrController.
 * 
 * @version 1.0
 * @created 2020/12/23 12:47:40
 */
@Repository
@Transactional
public interface LocAccountOpenReqItrRepository extends JpaRepository<LocAccountOpenReqItrEntity,Long> , 
                  JpaSpecificationExecutor<LocAccountOpenReqItrEntity> ,GenericDao{

}
