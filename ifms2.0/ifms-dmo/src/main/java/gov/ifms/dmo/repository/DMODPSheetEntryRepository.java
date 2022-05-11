package gov.ifms.dmo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMODPSheetEntryEntity;

/**
 * The Class DMODPSheetEntryRepository.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Repository
@Transactional
public interface DMODPSheetEntryRepository
		extends JpaRepository<DMODPSheetEntryEntity, Long>, JpaSpecificationExecutor<DMODPSheetEntryEntity> {

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_DP_SHEET_DTL WHERE TRANSACT_TYPE_ID = :trans ORDER BY ADVICE_DT "
			+ "DESC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	List<DMODPSheetEntryEntity> findAllByTransactionId(Long trans, int page, int size);

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_DP_SHEET_DTL \r\n"
			+ "WHERE TRANSACT_TYPE_ID in (:trans) AND ADVICE_DT >= :fromDate AND ADVICE_DT <= :toDate ORDER BY ADVICE_DT "
			+ "DESC OFFSET :page ROWS FETCH NEXT :size ROWS ONLY")
	List<DMODPSheetEntryEntity> findAllByTransactionIdInAndAdviceDate(List<Long> trans, String fromDate, String toDate,
			int page, int size);

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_DP_SHEET_DTL \r\n"
			+ "WHERE TRANSACT_TYPE_ID in (:trans) AND ADVICE_DT >= :fromDate AND ADVICE_DT <= :toDate ")
	List<DMODPSheetEntryEntity> getSizeOfTransactionId(List<Long> trans, String fromDate, String toDate);

	@Query(nativeQuery = true, value = "SELECT * FROM DMO.TDMO_DP_SHEET_DTL WHERE ADVICE_DT >= :fromDate AND ADVICE_DT <= :toDate")
	List<DMODPSheetEntryEntity> findAllByAndAdviceDate(LocalDate fromDate, LocalDate toDate);

	Optional<DMODPSheetEntryEntity> findByAdviceNo(String adviceNo);

	@Query(value = "UPDATE DMO.TDMO_DP_SHEET_DTL SET  ACTIVE_STATUS = :isDeActiveStatus WHERE DP_SHEET_ID = :id", nativeQuery = true)
	void deActivateDpSheetDtl(@Param("isDeActiveStatus") int isDeActiveStatus, @Param("id") Long id);

}