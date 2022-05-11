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
import gov.ifms.dmo.entity.DMOInstitutionalLoanEntity;

@Repository
@Transactional
public interface DMOInstitutionLoanRepository
		extends JpaRepository<DMOInstitutionalLoanEntity, Long>, GenericDao, JpaSpecificationExecutor<DMOInstitutionalLoanEntity> {

	Optional<DMOInstitutionalLoanEntity>findByInstituteId(String id);
	Optional<DMOInstitutionalLoanEntity>findByRefrenceNo(String ref);
	Optional<List<DMOInstitutionalLoanEntity>>findAllByRefrenceNo(String ref);
	Optional<List<DMOInstitutionalLoanEntity>>findAllByInstituteId(Long ref);
	Optional<DMOInstitutionalLoanEntity>findByLoanAccNumber(String loan);
	Optional<DMOInstitutionalLoanEntity>findByAdviceNo(String advice);
	
	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_INSTITUT_LOAN_HDR WHERE ADVICE_NO = :advice "
			+ "AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	Optional<DMOInstitutionalLoanEntity>findByAdviceNoAndStatus(String advice, int page, int size);
	
	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_INSTITUT_LOAN_HDR WHERE ADVICE_DT >= :fromDate "
			+ "AND ADVICE_DT <= :toDate AND ACTIVE_STATUS = 1 order by ADVICE_DT ASC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	List<DMOInstitutionalLoanEntity> findAllByAdviceDate(LocalDate fromDate, LocalDate toDate, int page, int size);
	
	@Query(nativeQuery = true, value = "SELECT REFERENCE_NO FROM DMO.TDMO_INSTITUT_LOAN_HDR WHERE CHEQUE_NO = NULL "
			+ "AND CHEQUE_DT = NULL AND ACTIVE_STATUS = 1 order by ADVICE_DT asc")
	List<String> findAllRef();
	List<DMOInstitutionalLoanEntity> findAllByActiveStatus(int i);
	List<DMOInstitutionalLoanEntity> findAllByInstituteIdAndActiveStatus(Long id, int i);
	List<DMOInstitutionalLoanEntity> findAllByTransactionDescAndActiveStatus(String id, int i);
	List<DMOInstitutionalLoanEntity> findAllByIdIn(List<Long> ids);
}
