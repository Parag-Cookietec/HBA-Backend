package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUMsReasonEntity;

/**
 * The Class PVUMsReasonController.
 * 
 * @version v 1.0
 * @created 2020/04/14 02:50:39
 */

@Repository
@Transactional
public interface PVUMsReasonRepository
		extends JpaRepository<PVUMsReasonEntity, Long>, JpaSpecificationExecutor<PVUMsReasonEntity> {

	List<PVUMsReasonEntity> findByReasonTypeAndActiveStatus(String ropReasonType, int activeStatus);

}
