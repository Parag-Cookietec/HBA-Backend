package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GSTFileSummery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface GSTFileSummeryRepository
		extends JpaRepository<GSTFileSummery, Long>, JpaSpecificationExecutor<GSTFileSummery>, GenericDao {

	@Query(nativeQuery = true, value = "SELECT * FROM EPAO.TPAO_GST_FILE_SUMMRY WHERE FILE_NAME LIKE :fileName OR FILE_DATE >= :fromDate AND FILE_DATE <= :toDate")
	List<GSTFileSummery> findByFileName(String fileName, LocalDate fromDate, LocalDate toDate);

	List<GSTFileSummery> findByFileNameIn(List<String> fileName);

	@Query(nativeQuery = true, value = "SELECT * FROM EPAO.TPAO_GST_FILE_SUMMRY WHERE FILE_DATE >= :fromDate AND FILE_DATE <= :toDate")
	List<GSTFileSummery> findByFileDate(LocalDate fromDate, LocalDate toDate);

	List<GSTFileSummery> findByFileDate(Date fileDate);

	Optional<GSTFileSummery> findByFileDateAndFileType(Date fileDt, String fileType);
	
	Optional<GSTFileSummery> findByFileName(String fileName);
	

}
