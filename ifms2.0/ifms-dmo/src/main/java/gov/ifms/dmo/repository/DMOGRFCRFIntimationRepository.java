package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMOGRFCRFIntimationEntity;

@Repository
@Transactional
public interface DMOGRFCRFIntimationRepository extends JpaRepository<DMOGRFCRFIntimationEntity, Long>,
		CrudRepository<DMOGRFCRFIntimationEntity, Long>, JpaSpecificationExecutor<DMOGRFCRFIntimationEntity> {

	DMOGRFCRFIntimationEntity findByIntimationNo(String intimationNo);

	@Query(value = "SELECT * FROM DMO.TDMO_GRF_CRF_INTIMATION WHERE ACTIVE_STATUS = 1 ORDER BY GRF_CRF_INTIMATION_ID DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	DMOGRFCRFIntimationEntity findOneByActiveStatusOrderByIdDesc();
}
