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
import gov.ifms.dmo.entity.DMONSSFLoanEntity;

@Repository
@Transactional
public interface DMONSSFLoanRepository
		extends JpaRepository<DMONSSFLoanEntity, Long>, GenericDao, JpaSpecificationExecutor<DMONSSFLoanEntity> {

	Optional<DMONSSFLoanEntity>findByLoanNumber(String loan);

	Optional<DMONSSFLoanEntity> findByAdviceNo(String adviceNo);

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_NSSF_LOAN_HDR WHERE ADVICE_NO = :advice "
			+ "AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	Optional<DMONSSFLoanEntity>findByAdviceNoAndStatus(String advice, int page, int size);
	
	Optional<DMONSSFLoanEntity> findByRefrenceNo(String refrenceNo);

	Optional<DMONSSFLoanEntity> findAllByRefrenceNo(String refrenceNo);

	Optional<List<DMONSSFLoanEntity>>  findAllByAdviceNo(String adviceNo);
	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_NSSF_LOAN_HDR WHERE ADVICE_DT >= :fromDate AND ADVICE_DT <= :toDate "
			+ "AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	List<DMONSSFLoanEntity> findAllByAdviceDate(LocalDate fromDate, LocalDate toDate, int page, int size);

	List<DMONSSFLoanEntity> findAllByActiveStatus(int i);
	List<DMONSSFLoanEntity> findAllByIdIn(List<Long> ids);
	List<DMONSSFLoanEntity> findAllBySanctionOrderNoAndActiveStatus(String sanc, int i);
}
