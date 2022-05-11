package gov.ifms.dmo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMOMarketLoanRePaymentEntity;

/**
 * The Class DMOGOILoanRePaymentRepository.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Repository
@Transactional
public interface DMOMarketLoanRePaymentRepository extends JpaRepository<DMOMarketLoanRePaymentEntity, Long>, GenericDao,
JpaSpecificationExecutor<DMOMarketLoanRePaymentEntity>{
	
	/**
	 * Find by marketLoanHdrId and active status.
	 *
	 * @param marketLoanHdrId the marketLoanHdrId 
	 * @param activeStatus the activeStatus
	 * @return the optional
	 */
	Optional<DMOMarketLoanRePaymentEntity> findByMarketLoanHdrIdAndActiveStatus(Long marketLoanHdrId, int activeStatus);
	
	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_MARKET_LOAN_REPAYMENT WHERE INSTALL_DUE_DT >= :fromDate AND INSTALL_DUE_DT <= :toDate")
	List<DMOMarketLoanRePaymentEntity> findAllByAdviceDate(LocalDate fromDate, LocalDate toDate);
}
