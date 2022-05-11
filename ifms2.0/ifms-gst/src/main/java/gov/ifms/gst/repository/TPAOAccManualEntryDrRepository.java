package gov.ifms.gst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.entity.AccManualEntryDr;

@Repository
@Transactional
public interface TPAOAccManualEntryDrRepository extends JpaRepository<AccManualEntryDr, Long>,
JpaSpecificationExecutor<AccManualEntryDr>, GenericDao{
	
}
