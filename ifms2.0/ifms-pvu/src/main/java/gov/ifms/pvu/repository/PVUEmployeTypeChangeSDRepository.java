package gov.ifms.pvu.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeSDEntity;

@Transactional
@Repository
public interface PVUEmployeTypeChangeSDRepository extends JpaRepository<PVUEmployeTypeChangeSDEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeTypeChangeSDEntity>, GenericDao {

	PVUEmployeTypeChangeSDEntity findByEmpId(Long empId);

	PVUEmployeTypeChangeSDEntity findByTransNo(@Param("trnNo") String transNo);

}
