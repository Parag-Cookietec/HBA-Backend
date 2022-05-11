package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.entity.GstRbiFilesTranxn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Trace
public interface TPAORbiFilesTranxnRepository extends JpaRepository<GstRbiFilesTranxn, Long>,
JpaSpecificationExecutor<GstRbiFilesTranxn>, GenericDao{
	
}
