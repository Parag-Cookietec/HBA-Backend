package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.entity.DMOSecuirtyMasterEntity;
@Repository
public interface DMOSecuirtyMasterRepository extends JpaRepository<DMOSecuirtyMasterEntity, Long>,
JpaSpecificationExecutor<DMOSecuirtyMasterEntity>{

}
