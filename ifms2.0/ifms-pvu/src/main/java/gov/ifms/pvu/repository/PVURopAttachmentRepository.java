package gov.ifms.pvu.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVURopAttachmentEntity;

/**
 * The Class PVURopAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/03/17 11:14:39
 */

@Repository
@Transactional
public interface PVURopAttachmentRepository
		extends BasePVUAttachmentRepository<PVURopAttachmentEntity>, JpaSpecificationExecutor<PVURopAttachmentEntity> {

	/**
	 * Delete attchment.
	 *
	 * @param id the id
	 * @param inActiveStatus the in active status
	 * @param currentUserUserId the current user user id
	 * @param date the date
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVURopAttachmentEntity entity set entity.activeStatus = :inActiveStatus, entity.updatedBy = :currentUserUserId, entity.updatedDate = :date where entity.id = :id")
	void deleteAttchment(Long id, int inActiveStatus, long currentUserUserId, Date date);

	/**
	 * Find all by pvu revision of pay entity id and active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<PVURopAttachmentEntity> findAllByPvuRevisionOfPayEntityIdAndActiveStatus(Long id, int activeStatus);
}
