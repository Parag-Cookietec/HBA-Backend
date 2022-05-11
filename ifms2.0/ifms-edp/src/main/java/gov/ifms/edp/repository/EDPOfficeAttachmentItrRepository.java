package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPOfficeAttachmentItrEntity;

/**
 * The Interface EDPOfficeAttachmentItrRepository.
 *
 * @author Admin
 */
@Repository
@Transactional
public interface EDPOfficeAttachmentItrRepository extends JpaRepository<EDPOfficeAttachmentItrEntity, Long>,
		JpaSpecificationExecutor<EDPOfficeAttachmentItrEntity>, GenericDao {

	@Query("SELECT itr from EDPOfficeAttachmentItrEntity itr WHERE itr.ofcAttactmentId = :atchId")
	EDPOfficeAttachmentItrEntity findByAttachmentId(@Param("atchId") Long atchId);

}

