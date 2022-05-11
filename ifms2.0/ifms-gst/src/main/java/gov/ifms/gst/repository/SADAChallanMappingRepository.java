package gov.ifms.gst.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.SADAChallanMapping;

@Transactional
@Repository
public interface SADAChallanMappingRepository
		extends JpaRepository<SADAChallanMapping, Long>, JpaSpecificationExecutor<SADAChallanMapping>, GenericDao {

	List<SADAChallanMapping> findByfileProcessIdAndBankId(long fileProcessId, Long bankId);

	List<SADAChallanMapping> findByfileProcessIdAndBankIdAndSaDaId(long fileProcessId, long bankId, long l);

	boolean findByBankIdAndSaDaIdAndFileProcessId(long fileProcessId, Long saDaId, Long bankId);

}
