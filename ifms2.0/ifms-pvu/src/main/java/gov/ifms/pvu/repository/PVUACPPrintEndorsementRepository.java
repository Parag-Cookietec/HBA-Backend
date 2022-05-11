package gov.ifms.pvu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUCommonPrintEndorsementEntity;
/**
 * The Class PVURopPrintEndorsementController.
 * 
 * @version v 1.0
 * @created 2020/04/06 16:00:01
 */

@Repository
@Transactional
public interface PVUACPPrintEndorsementRepository extends JpaRepository<PVUCommonPrintEndorsementEntity,Long> , 
                  JpaSpecificationExecutor<PVUCommonPrintEndorsementEntity>, GenericDao{

	PVUCommonPrintEndorsementEntity findByIdAndActiveStatus(Long id ,int activeStatus);
	
	PVUCommonPrintEndorsementEntity findByPvuTrnEventIdAndPvuEntityIdAndActiveStatus(Long pvuTrnEventId ,Long pvuEntityId,int activeStatus);
   		  
}
