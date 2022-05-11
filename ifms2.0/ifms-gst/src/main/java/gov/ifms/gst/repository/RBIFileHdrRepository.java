package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.RBIFileHdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RBIFileHdrRepository
		extends JpaRepository<RBIFileHdr, Long>, JpaSpecificationExecutor<RBIFileHdr>, GenericDao {

	List<RBIFileHdr>findByFileRecvDt(LocalDateTime scrollDate);

	Optional<RBIFileHdr> findByFileName(String fileName);

}
