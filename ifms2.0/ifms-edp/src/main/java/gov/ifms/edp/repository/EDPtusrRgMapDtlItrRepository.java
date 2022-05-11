package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPtusrRgMapDtlItrEntity;
/**
 * The Class EDPtusrRgMapDtlItrController.
 * 
 * @version 1.0
 * @created 2020/07/16 09:32:46
 */

@Repository
@Transactional
public interface EDPtusrRgMapDtlItrRepository extends JpaRepository<EDPtusrRgMapDtlItrEntity,Long> , 
                  JpaSpecificationExecutor<EDPtusrRgMapDtlItrEntity> {
   
}
