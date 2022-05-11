package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GenerateMoeHdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GenerateMoeHdrRepository
		extends JpaRepository<GenerateMoeHdr, Long>, JpaSpecificationExecutor<GenerateMoeHdr>, GenericDao {

}
