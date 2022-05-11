package gov.ifms.pvu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeSixPayDetailEntity;

/**
 * The Class PVUEmploye6PayDetailController.
 *
 * @version v 1.0
 * @created 2019/11/26 12:51:22
 */

@Repository
@Transactional
public interface PVUEmployeSixPayDetailRepository extends JpaRepository<PVUEmployeSixPayDetailEntity, Long>,
		JpaSpecificationExecutor<PVUEmployeSixPayDetailEntity>, GenericDao {

	/**
	 * Find one by sixpay id.
	 *
	 * @param id the id
	 * @return the PVU employe six pay detail entity
	 */
	PVUEmployeSixPayDetailEntity findOneBySixpayId(Long id);

	/**
	 * Find one by pvu employe entity emp id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<PVUEmployeSixPayDetailEntity> findOneByPvuEmployeEntityEmpId(Long id);
	
	Optional<PVUEmployeSixPayDetailEntity> findOneByPvuEmployeEntityEmpIdAndActiveStatus(Long id, int activeStatus);

	PVUEmployeSixPayDetailEntity  findFirstByPvuEmployeEntityEmpId(Long id);

}
