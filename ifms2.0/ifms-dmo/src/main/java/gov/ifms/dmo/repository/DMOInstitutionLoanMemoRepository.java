package gov.ifms.dmo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMOInstitutionalLoanMemoEntity;

@Repository
@Transactional
public interface DMOInstitutionLoanMemoRepository
		extends JpaRepository<DMOInstitutionalLoanMemoEntity, Long>, GenericDao, JpaSpecificationExecutor<DMOInstitutionalLoanMemoEntity> {

	Optional<DMOInstitutionalLoanMemoEntity> findByRefrenceNo(String memo);
	Optional<DMOInstitutionalLoanMemoEntity> findByMemoNo(String memo);
	Optional<DMOInstitutionalLoanMemoEntity> findByChequeNo(Long memo);
	@Query(nativeQuery = true, value = "SELECT MEMO_NO FROM DMO.TDMO_INST_LOAN_MEMO WHERE CHEQUE_NO = NULL "
			+ "AND CHEQUE_DT = NULL order by ADVICE_DT asc")
	List<String> findAllMemo();
	@Query(nativeQuery = true, value = "SELECT CHEQUE_NO FROM DMO.TDMO_INST_LOAN_MEMO WHERE CHEQUE_NO != NULL "
			+ "AND CHEQUE_DT != NULL order by ADVICE_DT asc")
	List<Long> findAllCheque();
}
