package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GSTFileProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface GSTFileProcessRepository
		extends JpaRepository<GSTFileProcess, Long>, JpaSpecificationExecutor<GSTFileProcess>, GenericDao {

	Optional<GSTFileProcess> findByFileNameStartsWith(String fileName);

	Optional<GSTFileProcess> findByFileNameContains(String fileName);

	Optional<GSTFileProcess> findByFileName(String fileName);

}
