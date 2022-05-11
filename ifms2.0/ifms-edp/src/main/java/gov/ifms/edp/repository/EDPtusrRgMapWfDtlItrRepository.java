package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPtusrRgMapWfDtlItrEntity;
/**
 * The Class EDPtusrRgMapWfDtlItrController.
 * 
 * @version 1.0
 * @created 2020/07/16 09:35:32
 */

@Repository
@Transactional
public interface EDPtusrRgMapWfDtlItrRepository extends JpaRepository<EDPtusrRgMapWfDtlItrEntity,Long> , 
                  JpaSpecificationExecutor<EDPtusrRgMapWfDtlItrEntity> {
  
}
