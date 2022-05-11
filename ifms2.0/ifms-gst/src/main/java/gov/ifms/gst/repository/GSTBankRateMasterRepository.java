/**
 * 
 */
package gov.ifms.gst.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GSTBankRateMaster;

@Transactional
@Repository
public interface GSTBankRateMasterRepository extends JpaRepository<GSTBankRateMaster,Long> , 
JpaSpecificationExecutor<GSTBankRateMaster>,GenericDao {
	
	GSTBankRateMaster findTopByOrderByIdDesc();
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM EPAO.MPAO_BANK_RATE_MASTER_WF MASTER_WF INNER JOIN EPAO.MPAO_BANK_RATE_MASTER MASTER ON MASTER.BANK_RATE_ID = MASTER_WF.TRN_ID WHERE MASTER_WF.UPDATED_DATE = (SELECT MAX(MASTER_WF1.UPDATED_DATE) FROM EPAO.MPAO_BANK_RATE_MASTER_WF MASTER_WF1 WHERE MASTER_WF1.TRN_ID = MASTER_WF.TRN_ID) AND MASTER_WF.TRN_STATUS <> 'Approved'")
	long countNotApprovedBankRates();
	
}

