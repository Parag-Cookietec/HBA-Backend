package gov.ifms.edp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPAddDesAttachmentItrEntity;

/**
 * The Interface EDPAddDesigAttachmentItrRepository.
 *
 * @author Admin
 */
@Repository
@Transactional
public interface EDPAddDesigAttachmentItrRepository extends JpaRepository<EDPAddDesAttachmentItrEntity, Long>,
		JpaSpecificationExecutor<EDPAddDesAttachmentItrEntity>, GenericDao {

}
