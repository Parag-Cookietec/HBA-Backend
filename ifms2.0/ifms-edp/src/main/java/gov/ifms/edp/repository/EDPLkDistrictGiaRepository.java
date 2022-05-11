package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkDistrictGiaEntity;
/**
 * The Class EDPLkDistrictGiaController.
 * 
 * @version v 1.0
 * @created 2020/07/07 11:40:45
 */

@Repository
@Transactional
public interface EDPLkDistrictGiaRepository extends JpaRepository<EDPLkDistrictGiaEntity,Long> , 
                  JpaSpecificationExecutor<EDPLkDistrictGiaEntity> {

	List<EDPLkDistrictGiaEntity> findByActiveStatus(int activeStatus);
}
