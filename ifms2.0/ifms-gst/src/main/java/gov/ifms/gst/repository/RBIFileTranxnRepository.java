package gov.ifms.gst.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.RBIFileTranxn;

@Transactional
@Repository
public interface RBIFileTranxnRepository
		extends JpaRepository<RBIFileTranxn, Long>, JpaSpecificationExecutor<RBIFileTranxn>, GenericDao {

	List<RBIFileTranxn> findByTransactionDttmBetween(LocalDateTime fromDate, LocalDateTime toDate);

	List<RBIFileTranxn> findByTransactionDttm(LocalDateTime transactionDttm);

	List<RBIFileTranxn> findByRbiFileHdrId(Long rbiFileHdrId);

}
