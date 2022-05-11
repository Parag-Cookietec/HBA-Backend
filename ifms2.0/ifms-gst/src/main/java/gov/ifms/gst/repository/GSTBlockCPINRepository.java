package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GSTBlockCPIN;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GSTBlockCPINRepository
		extends JpaRepository<GSTBlockCPIN, Long>, JpaSpecificationExecutor<GSTBlockCPIN>, GenericDao {

	Optional<GSTBlockCPIN> findByCpinNo(Long cpinNo);

	GSTBlockCPIN findByReferenceNo(String referenceNo);

	GSTBlockCPIN findByCinNo(String cinNo);
	
	@Query(nativeQuery = true, value = "SELECT MAX(REFERENCE_NO)  FROM EPAO.TPAO_BLOCK_CPIN  ")
	String findByReferenceNo();

}
