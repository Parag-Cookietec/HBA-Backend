package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.RBIAccHdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RBIAccHdrRepository
		extends JpaRepository<RBIAccHdr, Long>, JpaSpecificationExecutor<RBIAccHdr>, GenericDao {

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM EPAO.TPAO_RBI_ACC_HDR_WF RBI_ACC_WF INNER JOIN EPAO.TPAO_RBI_ACC_HDR RBI_ACC ON RBI_ACC.RBI_ACC_HDR_ID = RBI_ACC_WF.TRN_ID WHERE RBI_ACC_WF.TRN_ID = :id AND RBI_ACC_WF.ACTIVE_STATUS = :status")
	int getWFdata(long id,int status);
}
