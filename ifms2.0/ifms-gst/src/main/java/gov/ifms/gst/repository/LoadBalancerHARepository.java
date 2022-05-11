package gov.ifms.gst.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.LoadBalancerHA;

@Transactional
@Repository
public interface LoadBalancerHARepository
		extends JpaRepository<LoadBalancerHA, Long>, JpaSpecificationExecutor<LoadBalancerHA>, GenericDao {

	LoadBalancerHA findByFromSaDaIdAndBankIdAndToSaDaId(long fromSaDaId, long bankId, long l);
	@Query(nativeQuery = true, value = "SELECT MAX(REFERENCE_NO)  FROM EPAO.MPAO_BANK_RATE_MASTER ")
	String findByReferenceNo();

}
