package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.BankCodeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BankCodeMappingRepository
		extends JpaRepository<BankCodeMapping, Long>, JpaSpecificationExecutor<BankCodeMapping>, GenericDao {

	BankCodeMapping findByMsBankId(Long bankId);

}
