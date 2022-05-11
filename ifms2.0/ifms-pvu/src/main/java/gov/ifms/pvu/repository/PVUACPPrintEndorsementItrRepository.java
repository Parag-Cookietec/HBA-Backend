package gov.ifms.pvu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUACPPrintEndorsementItrEntity;
/**
 * The Class PVURopPrintEndorsementController.
 * 
 * @version v 1.0
 * @created 2020/04/06 16:00:01
 */

@Repository
@Transactional
public interface PVUACPPrintEndorsementItrRepository extends JpaRepository<PVUACPPrintEndorsementItrEntity,Long> , 
                  JpaSpecificationExecutor<PVUACPPrintEndorsementItrEntity>, GenericDao{

	PVUACPPrintEndorsementItrEntity findByIdAndActiveStatus(Long id ,int activeStatus);
   		  
}
