package gov.ifms.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.workflow.dao.WfSpRepo;
import gov.ifms.workflow.entity.TrnBudWfEntity;

/**
 * The Class TrnBudWfRepository.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface TrnBudWfRepository
		extends JpaRepository<TrnBudWfEntity, Long>, JpaSpecificationExecutor<TrnBudWfEntity>, WfSpRepo {
	/**
	 * findByTrnBudSceHeaderId
	 *
	 * @param trnBudSceHeaderId
	 * @return the list
	 */
	List<TrnBudWfEntity> findByTrnBudSceHeaderId(long trnBudSceHeaderId);

	/**
	 * countByTrnBudSceHeaderIdAndAssignedUserId
	 *
	 * @param trnBudSceHeaderId
	 * @param userId
	 * @return the long
	 */
	Long countByTrnBudSceHeaderIdAndAssignedUserId(long trnBudSceHeaderId, long userId);

	/**
	 * findTrnBudWf
	 *
	 * @param trnBudSceHeaderId
	 * @param assignedPostId
	 * @param assignedUserId
	 * @param wfActionId
	 * @return the entity
	 */
	@Query(value = "select trnBudWf from TrnBudWfEntity trnBudWf where trnBudWf.trnBudSceHeaderId = :trnBudSceHeaderId and trnBudWf.assignedPostId = :assignedPostId and trnBudWf.assignedUserId = :assignedUserId and trnBudWf.wfActionId != :wfActionId")
	TrnBudWfEntity findTrnBudWf(@Param("trnBudSceHeaderId") long trnBudSceHeaderId,
			@Param("assignedPostId") long assignedPostId, @Param("assignedUserId") long assignedUserId,
			@Param("wfActionId") long wfActionId);

	/**
	 * findWfRuleIdTrnBudWf
	 *
	 * @param trnBudSceHeaderId
	 * @param assignedByPostId
	 * @param assignedByUserId
	 * @param assignedByOfficeId
	 * @return the entity
	 */
	@Query(value = "select trnBudWf from TrnBudWfEntity trnBudWf where trnBudWf.trnBudSceHeaderId = :trnBudSceHeaderId and trnBudWf.assignedByPostId = :assignedByPostId and trnBudWf.assignedByUserId = :assignedByUserId and trnBudWf.assignedByOfficeId = :assignedByOfficeId")
	TrnBudWfEntity findWfRuleIdTrnBudWf(@Param("trnBudSceHeaderId") long trnBudSceHeaderId,
			@Param("assignedByPostId") long assignedByPostId, @Param("assignedByUserId") long assignedByUserId,
			@Param("assignedByOfficeId") long assignedByOfficeId);
}
