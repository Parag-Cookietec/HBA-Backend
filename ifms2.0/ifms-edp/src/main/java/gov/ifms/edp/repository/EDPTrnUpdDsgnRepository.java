package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;

/**
 * The Interface EDPTrnUpdDsgnRepository.
 */
@Repository
@Transactional
public interface EDPTrnUpdDsgnRepository
		extends JpaRepository<EDPTrnUpdDsgnEntity, Long>, JpaSpecificationExecutor<EDPTrnUpdDsgnEntity>, GenericDao {

	/**
	 * Find top by order by tedp upd dsgn id desc.
	 *
	 * @return the EDP trn upd dsgn entity
	 */
	EDPTrnUpdDsgnEntity findTopByOrderByTedpUpdDsgnIdDesc();

}
