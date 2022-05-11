package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GSTCPINFileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface EodCpinFileDataRepository
		extends JpaRepository<GSTCPINFileData, Long>, JpaSpecificationExecutor<GSTCPINFileData>, GenericDao {

	Optional<GSTCPINFileData> findByCpinNo(Long cpinNo);

}
