package gov.ifms.gst.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GstSaDaChallanMapping;

@Transactional
@Repository
public interface GstSaDaChallanMappingRepository extends JpaRepository<GstSaDaChallanMapping, Long>,
		JpaSpecificationExecutor<GstSaDaChallanMapping>, GenericDao {

	List<GstSaDaChallanMapping> findByBankIdAndRbiFileTranxnAcceptanceDttmLessThanEqualAndRbiFileTranxnAcceptanceDttmGreaterThanEqual(
			Long bankId, Date toDate, Date fromDate);

}
