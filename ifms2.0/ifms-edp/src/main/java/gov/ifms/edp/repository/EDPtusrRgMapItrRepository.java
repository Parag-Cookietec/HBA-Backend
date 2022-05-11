package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPtusrRgMapItrEntity;
/**
 * The Class EDPtusrRgMapItrController.
 * 
 * @version 1.0
 * @created 2020/07/16 09:28:25
 */

@Repository
@Transactional
public interface EDPtusrRgMapItrRepository extends JpaRepository<EDPtusrRgMapItrEntity,Long> , 
                  JpaSpecificationExecutor<EDPtusrRgMapItrEntity> {
	
}
