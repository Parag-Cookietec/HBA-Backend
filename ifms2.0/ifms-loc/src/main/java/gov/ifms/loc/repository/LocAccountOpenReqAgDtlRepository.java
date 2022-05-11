package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAccountOpenReqAgDtlEntity;

/**
 * The Class LocAccountOpenReqAgDtlController.
 * 
 * @version 1.0
 * @created 2021/01/01 21:17:12
 */
@Repository
@Transactional
public interface LocAccountOpenReqAgDtlRepository extends JpaRepository<LocAccountOpenReqAgDtlEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqAgDtlEntity>, GenericDao {

	/**
	 * Find by lc open req hdr id lc open req hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus   the active status
	 * @return the loc account open req ag dtl entity
	 */
	LocAccountOpenReqAgDtlEntity findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(Long lcOpenReqHdrId,
			Integer activeStatus);

	/**
	 * Gets the ag req dtl by hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus   the active status
	 * @return the ag req dtl by hdr id and active status
	 */
	@Query(value = "SELECT ag.LC_OPEN_REQ_AG_ID agId, ag.LC_OPEN_REQ_HDR_ID hdrId, ag.LC_OPEN_REQ_AG_ID dtlId, ag.AG_AUTHORIZATION_NO authorizationNo , ag.AG_AUTHORIZATION_DT authorizationDt, ag.MAJORHEAD_ID majorHeadId, mm.MAJORHEAD_NAME majorHeadName, ag.SUBMAJORHEAD_ID subMajorHeadId, msm.SUBMAJORHEAD_NAME subMajorHeadName, ag.MINORHEAD_ID minorHeadId, mmh.MINORHEAD_NAME minorHeadName, ag.SUBHEAD_ID subHeadId, msh.SUBHEAD_NAME subHeadName, ag.DETAILHEAD_ID detailHeadId, md.DETAILHEAD_NAME detailHeadName, ag.AG_REMARKS agRemarks, ag.CREATED_BY createdBy, ag.CREATED_BY_POST createdByPost, ag.STATUS_ID statusId, ag.WF_ID wfId, ag.WF_ROLE_ID wfRoleId, mm.MAJORHEAD_CODE majorHeadCode, msm.SUBMAJORHEAD_CODE subMajorHeadCode, mmh.MINORHEAD_CODE minorHeadCode, msh.SUBHEAD_CODE subHeadCode, md.DETAILHEAD_CODE detailHeadCode FROM LOC.TLOC_OPEN_REQ_AG_DTL ag  LEFT JOIN LOC.TLOC_LC_OPEN_REQ_HDR hdr ON HDR.LC_OPEN_REQ_HDR_ID = AG.LC_OPEN_REQ_HDR_ID AND HDR.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_MAJORHEAD mm ON MM.MAJORHEAD_ID = AG.MAJORHEAD_ID AND MM.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_SUBMAJORHEAD MSM ON MSM.SUBMAJORHEAD_ID = AG.SUBMAJORHEAD_ID AND MSM.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_SUBHEAD msh ON MSH.SUBHEAD_ID = AG.SUBHEAD_ID AND MSH.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_DETAILHEAD md ON MD.DETAILHEAD_ID = AG.DETAILHEAD_ID AND MD.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_MINORHEAD mmh ON MMH.MINORHEAD_ID = AG.MINORHEAD_ID AND MMH.ACTIVE_STATUS = 1 WHERE ag.LC_OPEN_REQ_HDR_ID = :lcOpenReqHdrId AND ag.ACTIVE_STATUS = :activeStatus", nativeQuery = true)
	List<Object[]> getEditViewData(@Param("lcOpenReqHdrId") Long lcOpenReqHdrId,
			@Param("activeStatus") int activeStatus);

}
