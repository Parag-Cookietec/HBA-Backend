package gov.ifms.gst.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.ChallanDistributionSADA;

@Transactional
@Repository
public interface ChallanDistruSADARepository extends JpaRepository<ChallanDistributionSADA, Long>,
		JpaSpecificationExecutor<ChallanDistributionSADA>, GenericDao {

	List<ChallanDistributionSADA> findByFileProcessIdAndBankName(long fileProcessId, String bankName);

	ChallanDistributionSADA findByBankName(String bankName);

	ChallanDistributionSADA findByBankIdAndSaDaId(long fromSaDaId, long bankId);

	Optional<ChallanDistributionSADA> findByBankIdAndSaDaIdAndFileProcessId(Long bankId, Long saDaId,
			long fileProcessId);

	Optional<ChallanDistributionSADA> findByBankIdAndFileProcessId(Long bankId, long fileProcessId);

	@Query(nativeQuery = true, value = "SELECT MAX(REFERENCE_NO)  FROM EPAO.TPAO_CHALLAN_DISTRIBUTE_SA_DA  ")
	String findByReferenceNo();
}
