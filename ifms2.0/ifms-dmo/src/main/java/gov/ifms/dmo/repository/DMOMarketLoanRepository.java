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
import gov.ifms.dmo.entity.DMOMarketLoanEntity;

@Repository
@Transactional
public interface DMOMarketLoanRepository extends JpaRepository<DMOMarketLoanEntity, Long>, GenericDao,
JpaSpecificationExecutor<DMOMarketLoanEntity>{

	Optional<DMOMarketLoanEntity> findByLoanNumber(String loanNumber);

	Optional<DMOMarketLoanEntity> findByAdviceNo(String adviceNo);

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_INSTITUT_LOAN_HDR WHERE ADVICE_NO = :advice "
			+ "AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	Optional<DMOMarketLoanEntity>findByAdviceNoAndStatus(String advice, int page, int size);
	
	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_MARKET_LOAN_HDR WHERE ADVICE_DT >= :fromDate AND "
			+ "ADVICE_DT <= :toDate AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	List<DMOMarketLoanEntity> findAllByAdviceDate(LocalDate fromDate, LocalDate toDate, int page, int size);

	Optional<List<DMOMarketLoanEntity>> findAllByAdviceNo(String adviceNo);

	List<DMOMarketLoanEntity> findAllByActiveStatus(int i);
	List<DMOMarketLoanEntity> findAllByTransactionDescAndActiveStatus(String desc, int i);

	List<DMOMarketLoanEntity> findAllByIdIn(List<Long> ids);
}
