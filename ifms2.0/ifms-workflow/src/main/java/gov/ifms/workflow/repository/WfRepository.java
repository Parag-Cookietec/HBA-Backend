package gov.ifms.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.workflow.entity.EdpLkTrnOffModWfEntity;

/**
 * The Class WfRepository.
 *
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
public interface WfRepository
		extends JpaRepository<EdpLkTrnOffModWfEntity, Long>, JpaSpecificationExecutor<EdpLkTrnOffModWfEntity>, GenericDao{

	/**
	 * findByTrnIdAndActiveStatus
	 *
	 * @param trnId
	 * @param activeStatus
	 * @return long
	 */
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_RP_WF ropWf JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON ropwf.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and ropwf.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByRopTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);

	/**
	 * Find wf rl cd by inc trn id.
	 *
	 * @param trnId the trn id
	 * @param activeStatus the active status
	 * @return the string
	 */
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_IN_WF incWf JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON incwf.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and incwf.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByIncTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);

	/**
	 * findWfRlCdBySSPTrnId:: For Senior Scale PVU
	 *
	 * @param trnId trnId
	 * @param activeStatus activeStatus
	 * @return long
	 */
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_SS_PVU_WF ssp JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON ssp.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and ssp.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdBySSPTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);

	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_TK_WF tkwf JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON tkwf.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and tkwf.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByTikuPayTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);
	
	
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_ST_WF wf JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON wf.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and wf.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdBySteppingUpTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);

	
	/**
	 * findWfRlCdByCSPTrnId:: For Change of Scale PVU
	 *
	 * @param trnId trnId
	 * @param activeStatus activeStatus
	 * @return long
	 */
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_CSPVU_WF csp JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON csp.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and csp.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByCSPTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);
	
	/**
	 * Find wf rl cd by shetty pay trn id.
	 *
	 * @param trnId the trn id
	 * @param activeStatus the active status
	 * @return the string
	 */
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_SP_WF SP JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON SP.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and SP.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByShettyPayTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);
	
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_SG_WF SG JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON SG.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and SG.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdBySelectionGradeTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);
	
	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_AP_WF tkwf JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON tkwf.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and tkwf.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByAcpPayTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);

	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_CA_WF cap JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON cap.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and cap.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByCATrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);

	@Query(value = "select WR.WF_ROLE_CODE from PVU.T_PVU_HP_WF SP JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON SP.ASSIGN_TO_WF_ROLE_ID = wr.WF_ROLE_ID where TRN_ID = :trnId and SP.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	String findWfRlCdByHigherPayTrnId(@Param("trnId") long trnId,@Param("activeStatus") int activeStatus);
}
