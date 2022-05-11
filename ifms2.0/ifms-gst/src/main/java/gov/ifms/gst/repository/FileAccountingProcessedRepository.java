package gov.ifms.gst.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.FileAccountingProcessed;
import gov.ifms.gst.entity.GSTFileProcess;

@Transactional
@Repository
public interface FileAccountingProcessedRepository extends JpaRepository<FileAccountingProcessed, Long>,
		JpaSpecificationExecutor<FileAccountingProcessed>, GenericDao {

	Optional<FileAccountingProcessed> findByVoucherNo(String voucherNo);

	Optional<FileAccountingProcessed> findByFileProcessId(GSTFileProcess file);

	@Query(nativeQuery = true, value = "SELECT MAX(REFERENCE_NO)  FROM EPAO.TPAO_FILE_ACCOUNT_PROCESSED  ")
	String findByReferenceNo();

}
