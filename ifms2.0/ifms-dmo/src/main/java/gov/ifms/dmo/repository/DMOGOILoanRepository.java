package gov.ifms.dmo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMOGOILoanEntity;

@Repository
@Transactional
public interface DMOGOILoanRepository
		extends JpaRepository<DMOGOILoanEntity, Long>, GenericDao, JpaSpecificationExecutor<DMOGOILoanEntity> {

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_GOI_LOAN_HDR WHERE ADVICE_NO = :loan AND BLOCK_LOAN_STATUS = false "
			+ "AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	Optional<DMOGOILoanEntity> findByAdviceNoAndBlockLoanStatus(String loan, int page, int size);
	Optional<DMOGOILoanEntity> findBySanctionOrderNoAndBlockLoanStatus(String loan, Boolean status);
	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_GOI_LOAN_HDR WHERE ADVICE_DT >= :fromDate AND ADVICE_DT <= :toDate "
			+ "AND BLOCK_LOAN_STATUS = false AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	List<DMOGOILoanEntity> findAllByAdviceDate(LocalDate fromDate, LocalDate toDate, int page, int size);
	List<DMOGOILoanEntity> findAllByLoanFinanceYearIdAndLoanPurposeAndNameOfMinistryAndPlanSchemeName(Long year, Long pur, Long mini, Long sche);
	List<DMOGOILoanEntity> findAllByLoanPurposeAndNameOfMinistryAndPlanSchemeNameAndActiveStatus(Long pur, Long mini, Long sche, int status);
	Optional<DMOGOILoanEntity> findByAdviceNo(String adviceNo);
	Optional<DMOGOILoanEntity> findAllByAdviceNo(String adviceNo);
	Optional<DMOGOILoanEntity> findByAdviceNoAndAdviceDate(String adviceNo, LocalDate fromDate);
	Optional<DMOGOILoanEntity> findAllBySanctionOrderNo(String sanctionNo);
	List<DMOGOILoanEntity> findAllByIdIn(List<Long> ids);
}
