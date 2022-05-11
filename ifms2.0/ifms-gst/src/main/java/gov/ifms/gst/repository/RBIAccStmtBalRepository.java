package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.RBIAccStmtBal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RBIAccStmtBalRepository
		extends JpaRepository<RBIAccStmtBal, Long>, JpaSpecificationExecutor<RBIAccStmtBal>, GenericDao {

}
