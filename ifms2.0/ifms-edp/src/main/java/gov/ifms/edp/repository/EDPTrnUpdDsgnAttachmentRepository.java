package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentEntity;

/**
 * The Interface EDPTrnUpdDsgnAttachmentRepository.
 */
@Repository
@Transactional
public interface EDPTrnUpdDsgnAttachmentRepository extends JpaRepository<EDPTrnUpdDsgnAttachmentEntity, Long>,
		JpaSpecificationExecutor<EDPTrnUpdDsgnAttachmentEntity> {

	/**
	 * Find by trn upd dsgn entity tedp upd dsgn id and active status.
	 *
	 * @param tedpUpdDsgnId the tedp upd dsgn id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPTrnUpdDsgnAttachmentEntity> findByTrnUpdDsgnEntityTedpUpdDsgnIdAndActiveStatus(Long tedpUpdDsgnId,int activeStatus);
}
