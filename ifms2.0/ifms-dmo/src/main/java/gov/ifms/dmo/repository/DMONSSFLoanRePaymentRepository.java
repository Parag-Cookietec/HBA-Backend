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
import gov.ifms.dmo.entity.DMONSSFLoanRePaymentEntity;

/**
 * The Class DMONSSFLoanRePaymentRepository.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Repository
@Transactional
public interface DMONSSFLoanRePaymentRepository extends JpaRepository<DMONSSFLoanRePaymentEntity, Long>, GenericDao,
JpaSpecificationExecutor<DMONSSFLoanRePaymentEntity>{
	
	/**
	 * Find by nssfLoanId and active status.
	 *
	 * @param nssfLoanId the nssfLoanId 
	 * @param activeStatus the activeStatus
	 * @return the optional
	 */
	Optional<DMONSSFLoanRePaymentEntity> findByNssfLoanIdAndActiveStatus(Long nssfLoanId, int activeStatus);
	
	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_NSSF_LOAN_REPAYMENT WHERE INSTALL_DUE_DT >= :fromDate AND INSTALL_DUE_DT <= :toDate ORDER BY INSTALL_DUE_DT ASC ")
	List<DMONSSFLoanRePaymentEntity> findAllByAdviceDate(LocalDate fromDate, LocalDate toDate);
}
