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
import gov.ifms.dmo.entity.DMOGOILoanRePaymentEntity;

/**
 * The Class DMOGOILoanRePaymentRepository.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Repository
@Transactional
public interface DMOGOILoanRePaymentRepository extends JpaRepository<DMOGOILoanRePaymentEntity, Long>, GenericDao,
JpaSpecificationExecutor<DMOGOILoanRePaymentEntity>{
	
	/**
	 * Find by goiLoanId and active status.
	 *
	 * @param goiLoanId the goiLoanId 
	 * @param activeStatus the activeStatus
	 * @return the optional
	 */
	Optional<DMOGOILoanRePaymentEntity> findByGoiLoanIdAndActiveStatus(Long goiLoanId, int activeStatus);

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_GOI_LOAN_REPAYMENT WHERE INSTALL_DUE_DT >= :fromDate AND INSTALL_DUE_DT <= :toDate AND IS_INSTALL_PAID = 0 ORDER BY INSTALL_DUE_DT ASC ")
	List<DMOGOILoanRePaymentEntity> findAllByAdviceDate(LocalDate fromDate, LocalDate toDate);

	@Query(nativeQuery = true, value = "SELECT tglr.* FROM DMO.TDMO_GOI_LOAN_REPAYMENT tglr LEFT JOIN DMO.TDMO_GOI_LOAN_HDR tglh "
			+ "ON (tglr.GOI_LOAN_HDR_ID = tglh.GOI_LOAN_HDR_ID) WHERE tglr.INSTALL_DUE_DT >= :fromDate AND tglr.INSTALL_DUE_DT <= :toDate "
			+ "AND tglh.ADVICE_NO = :adviceNo AND tglr.IS_INSTALL_PAID = 0 ORDER BY tglr.INSTALL_DUE_DT ASC ")
	List<DMOGOILoanRePaymentEntity> findAllByAdviceDateAndAdviceNo(LocalDate fromDate, LocalDate toDate, String adviceNo);
}
