package gov.ifms.gst.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.LoadBalancerAO;

@Transactional
@Repository
public interface LoadBalancerAORepository
		extends JpaRepository<LoadBalancerAO, Long>, JpaSpecificationExecutor<LoadBalancerAO>, GenericDao {

	LoadBalancerAO findByFromSaDaNameAndBankName(String fromSaDaName, String bankName);

	LoadBalancerAO findByFromSaDaNameAndBankNameAndToBranchId(String fromSaDaName, String bankName, long toBranchId);

	LoadBalancerAO findByFromSaDaIdAndBankId(long fromSaDaId, long bankId);

	LoadBalancerAO findByFromSaDaIdAndBankIdAndToSaDaId(long fromSaDaId, long bankId, long toSaDaId);

	@Query(nativeQuery = true, value = "SELECT MAX(REFERENCE_NO)  FROM EPAO.TPAO_LOAD_BALANCER_AO  ")
	String findByReferenceNo();
}
