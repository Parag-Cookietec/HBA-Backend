package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.edp.entity.EDPTrnPouBrMapItrEntity;

public interface EDPTrnPouBrMapItrRepository extends JpaRepository<EDPTrnPouBrMapItrEntity,Long> , JpaSpecificationExecutor<EDPTrnPouBrMapItrEntity>{

}
