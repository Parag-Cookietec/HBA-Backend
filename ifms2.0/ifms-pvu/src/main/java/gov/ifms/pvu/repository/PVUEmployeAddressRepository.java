package gov.ifms.pvu.repository;

import gov.ifms.common.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUEmployeAddressEntity;

/**
 * The Class PVUEmployeAddressController.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 */

@Repository
@Transactional
public interface PVUEmployeAddressRepository extends JpaRepository<PVUEmployeAddressEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeAddressEntity>, GenericDao {

	/**
	 * Find PVU employe address entity bypvu employe entity emp id.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @return the PVU employe address entity
	 */
	public PVUEmployeAddressEntity findPVUEmployeAddressEntityBypvuEmployeEntityEmpIdAndActiveStatus(Long id, int activeStatus);

}
