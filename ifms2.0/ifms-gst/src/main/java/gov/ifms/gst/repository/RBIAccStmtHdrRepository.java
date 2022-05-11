package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.RBIAccStmtHdr;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RBIAccStmtHdrRepository
		extends JpaRepository<RBIAccStmtHdr, Long>, JpaSpecificationExecutor<RBIAccStmtHdr>, GenericDao {

	Optional<RBIAccStmtHdr> findByFileRecvDt(LocalDateTime distributionDt);

}
