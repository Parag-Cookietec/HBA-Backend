package gov.ifms.gst.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GSTCPINStatus;

@Transactional
@Repository
public interface GSTCPINStatusRepository
		extends JpaRepository<GSTCPINStatus, Long>, JpaSpecificationExecutor<GSTCPINStatus>, GenericDao {

	GSTCPINStatus findByCpinNo(Long long1);

	@Query(nativeQuery = true, value = "SELECT MAX(REFERENCE_NO)  FROM EPAO.TPAO_CPIN_STATUS  ")
	String findByReferenceNo();

}
