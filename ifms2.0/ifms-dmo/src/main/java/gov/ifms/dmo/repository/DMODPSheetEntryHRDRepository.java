package gov.ifms.dmo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;

/**
 * The Class DMODPSheetEntryHRDRepository.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Repository
@Transactional
public interface DMODPSheetEntryHRDRepository extends JpaRepository<DMODPSheetHDREntity, Long>,
JpaSpecificationExecutor<DMODPSheetHDREntity>, GenericDao{
	
	@Query(value = "SELECT * FROM TDMO_DP_SHEET_HDR  WHERE (DP_SHEET_RECV_DT >= :fromDate) AND (DP_SHEET_RECV_DT <= :toDate)", nativeQuery = true)
	Page<DMODPSheetHDREntity> getAllBetweenDates(@Param("fromDate") LocalDate fromDate,
	                                       @Param("toDate") LocalDate toDate, Pageable pageable);

	DMODPSheetHDREntity findByDpSheetReciveDateAndIsProcessed(LocalDate dpSheetReciveDate, int isProcessed);

	Optional<DMODPSheetHDREntity> findByDpSheetReciveDate(LocalDate dpSheetReciveDate);

	@Query(value = "SELECT * FROM DMO.TDMO_DP_SHEET_HDR  WHERE "
			+ "(DP_SHEET_DT = :dpSheetDate) AND (GOG_CODE = :gogCode) AND (ACTIVE_STATUS = :activeStatus)", nativeQuery = true)
	Optional<DMODPSheetHDREntity> findByGogCodeAndDpSheetDate(@Param("dpSheetDate") String dpSheetDate,
			@Param("gogCode") int gogCode, @Param("activeStatus") int isActive);

	@Query(value = "SELECT * FROM DMO.TDMO_DP_SHEET_HDR  WHERE "
			+ "(DP_SHEET_DT = :dpSheetDate) AND (ACTIVE_STATUS = :activeStatus)", nativeQuery = true)
	Optional<DMODPSheetHDREntity> findByDpSheetDate(@Param("dpSheetDate") String dpSheetDate,
			@Param("activeStatus") int isActive);

	@Query(value = "SELECT * FROM DMO.TDMO_DP_SHEET_HDR WHERE ACTIVE_STATUS = 0 ORDER BY DP_SHEET_DT DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	Optional<DMODPSheetHDREntity> findOneByOrderByIdDesc();

}
