package gov.ifms.gst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.entity.AccManualEntryCr;

@Repository
@Transactional
@Trace
public interface TPAOAccManualEntryCrRepository extends JpaRepository<AccManualEntryCr, Long>,
JpaSpecificationExecutor<AccManualEntryCr>, GenericDao{
	
}
