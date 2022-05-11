package gov.ifms.gst.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.RBIAccStmtTranxn;

@Transactional
@Repository
public interface RBIAccStmtTranxnRepository
		extends JpaRepository<RBIAccStmtTranxn, Long>, JpaSpecificationExecutor<RBIAccStmtTranxn>, GenericDao {

}
