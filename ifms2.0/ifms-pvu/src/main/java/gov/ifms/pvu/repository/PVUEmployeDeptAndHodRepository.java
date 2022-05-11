package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeDeptAndHodEntity;

/**
 * The Class PVUEmployeDeptAndHodController.
 * 
 * @version v 1.0
 * @created 2020/01/10 16:26:19
 */

@Repository
@Transactional
public interface PVUEmployeDeptAndHodRepository extends JpaRepository<PVUEmployeDeptAndHodEntity,Long> , 
                  JpaSpecificationExecutor<PVUEmployeDeptAndHodEntity> {
	
	List<PVUEmployeDeptAndHodEntity> findAllByDepartmentId(Long id);
	}
 

