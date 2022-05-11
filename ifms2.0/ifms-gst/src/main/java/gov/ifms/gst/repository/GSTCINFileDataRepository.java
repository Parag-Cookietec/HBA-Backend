package gov.ifms.gst.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.EODCINFileData;

@Transactional
@Repository
public interface GSTCINFileDataRepository
		extends JpaRepository<EODCINFileData, Long>, JpaSpecificationExecutor<EODCINFileData>, GenericDao {

	Optional<EODCINFileData> findByCinNo(String cinNo);

	Optional<EODCINFileData> findByCpinNo(Long cpinNo);

	@Query(nativeQuery = true, value = "SELECT * FROM EPAO.TPAO_EOD_CIN_FILE_DATA WHERE CPIN_DT >= :fromDate And CPIN_DT <= :toDate")
	List<EODCINFileData> findByCpinDtBetween(Date fromDate, Date toDate);

	@Query(nativeQuery = true, value = "SELECT * FROM EPAO.TPAO_EOD_CIN_FILE_DATA WHERE order by created_date desc limit 1")
	long countByCreatedDate();

	short countByBankCd(String bankCd);

	EODCINFileData findByBankCd(String bankCd);

	List<EODCINFileData> findByCpinDt(Date cpinDt);

	@Query(nativeQuery = true, value = "SELECT * FROM EPAO.TPAO_EOD_CIN_FILE_DATA WHERE FILE_TYPE_CD = :string And CPIN_DT >= :fromDate And CPIN_DT <= :fromDate")
	List<EODCINFileData> findByFileTypeCdAndCpinDtBetween(String string, Date fromDate);

	List<EODCINFileData> findByCpinDtOrderByBankCd(Date cpinDt);

}
