package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAccountOpeningRequestHdrEntity;


@Repository
@Transactional

public interface LocAccountOpeningReqHdrRepository extends JpaRepository<LocAccountOpeningRequestHdrEntity, Long>,
        JpaSpecificationExecutor<LocAccountOpeningRequestHdrEntity>, GenericDao {


    /**
     * Gets the account close req dtl
     *
     * @param officeId
     * @param departmentId
     * @param cardexno
     * @param ddoNo
     * @return the account open req dtl
     */

    @Query(value = "SELECT HDR.LC_OPEN_REQUEST_ID AS hdrID, ( SELECT  MO.OFFICE_NAME FROM  MASTER_V1.MS_OFFICE mo WHERE  mo.ACTIVE_STATUS = 1  AND mo.STATUS_ID = 327  AND mo.OFFICE_STATUS = 283  AND mo.OFFICE_ID IN (  SELECT   TEOBM.BILL_SUB_TO  FROM   EDP.T_EDP_O_BILL_MAP teobm  WHERE   TEOBM.OFFICE_ID =:officeId)) AS toOffName, HDR.DIVISION_OFFICE_ADDRESS AS divOffAdd, DEPT.DEPARTMENT_NAME AS dptName, HDR.HOD_NAME AS hodName, MO1.OFFICE_NAME AS offName, DIST.DISTRICT_NAME AS disName, HDR.CARDEX_NO AS cardexNo, HDR.DDO_NO AS ddoNo, TORDS.DIVISION_CD AS divCode , TLORS.DIVISION_NAME AS divisionName, TLORS.CIRCLE_CODE AS circleCode, CIR.CIRCLE_NAME AS circleName, HDR.AG_AUTHORIZATION_NO AS authNo , HDR.AG_AUTHORIZATION_DT AS authDt, MHEAD.MAJORHEAD_CODE AS majorHead , MHEAD.MAJORHEAD_CODE_NAME AS majorHeadName, SMHEAD.SUBMAJORHEAD_CODE AS subMajor , SMHEAD.SUBMAJORH_CODE_NAME AS subMajorName, MIHEAD.MINORHEAD_CODE AS minorHead, MIHEAD.MINORHEAD_CODE_NAME AS minorHeadName, SHEAD.SUBHEAD_CODE AS subHead, SHEAD.SUBHEAD_CODE_NAME AS subHeadName, DHEAD.DETAILHEAD_CODE AS detailHead, DHEAD.DETAILHEAD_CODE_NAME AS detailHeadName, BANK.BANK_NAME AS bankName, BRANCH.BRANCH_NAME AS branchName , BRANCH.BRANCH_CODE AS branchCode FROM LOC.TLOC_LC_OPEN_REQUEST_HDR HDR LEFT JOIN MASTER_V1.MS_OFFICE MO ON HDR.REQUESTING_OFFICE_ID = MO.OFFICE_ID AND MO.ACTIVE_STATUS = 1 AND MO.STATUS_ID = 327 AND MO.OFFICE_STATUS = 283 LEFT JOIN MASTER_V1.MS_DEPARTMENT DEPT ON DEPT.DEPARTMENT_ID = HDR.DEPARTMENT_ID AND DEPT.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_OFFICE MO1 ON HDR.TO_OFFICE_ID = MO1.OFFICE_ID AND MO1.ACTIVE_STATUS = 1 AND MO1.STATUS_ID = 327 AND MO1.OFFICE_STATUS = 283 LEFT JOIN MASTER_V1.MS_DISTRICT DIST ON HDR.DISTRICT_ID = DIST.DISTRICT_ID AND DIST.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_CIRCLE CIR ON HDR.CIRCLE_ID = CIR.CIRCLE_ID AND CIR.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_MAJORHEAD MHEAD ON HDR.MAJORHEAD_ID = MHEAD.MAJORHEAD_ID AND MHEAD.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_SUBMAJORHEAD SMHEAD ON HDR.SUBMAJORHEAD_ID = SMHEAD.SUBMAJORHEAD_ID AND SMHEAD.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_MINORHEAD MIHEAD ON HDR.MINORHEAD_ID = MIHEAD.MINORHEAD_ID AND MIHEAD.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_SUBHEAD SHEAD ON HDR.SUBHEAD_ID = SHEAD.SUBHEAD_ID AND SHEAD.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_DETAILHEAD DHEAD ON HDR.DETAILHEAD_ID = DHEAD.DETAILHEAD_ID AND DHEAD.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_BANK BANK ON HDR.BANK_ID = BANK.BANK_ID AND BANK.ACTIVE_STATUS = 1 LEFT JOIN MASTER_V1.MS_BANK_BRANCH BRANCH ON HDR.BANK_BRANCH_ID = BRANCH.BANK_BRANCH_ID AND BRANCH.ACTIVE_STATUS = 1 LEFT JOIN LOC.TLOC_LC_OPEN_REQ_SD TLORS ON TLORS.LC_OPEN_REQ_HDR_ID = HDR.LC_OPEN_REQUEST_ID AND TLORS.ACTIVE_STATUS = 1 LEFT JOIN LOC.TLOC_OPEN_REQ_DIVI_SD TORDS ON TORDS.LC_OPEN_REQ_HDR_ID = HDR.LC_OPEN_REQUEST_ID AND TORDS.ACTIVE_STATUS = 1 WHERE HDR.HOD_ID = :officeId AND HDR.DEPARTMENT_ID = :departmentId  AND HDR.CARDEX_NO = :cardexNo AND HDR.DDO_NO = :ddoNo AND HDR.DISTRICT_ID = :districtId", nativeQuery = true)
    public List<Object[]> getAccountCloseRequestData(@Param("officeId") Long officeId,
                                                           @Param("departmentId") Long departmentId, @Param("cardexNo") Long cardexNo, @Param("ddoNo") Long ddoNo,@Param("districtId") Long districtId);

	/**
	 * @param assignToOfficeId
	 * @param assignTowfRoleId
	 * @return
	 */
    @Query(value = "SELECT DISTINCT pou.LK_PO_OFF_USER_ID FROM MASTER_V1.TRN_USR_MNU_WF_ROLE tumwr "
    		+ " JOIN MASTER_V1.LK_USER_MENU um ON um.LK_USER_MENU_ID=tumwr.LK_USER_MENU_ID "
    		+ "	JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON tumwr.WF_ROLE_ID=wr.WF_ROLE_ID "
    		+ "	JOIN MASTER_V1.LK_PO_OFF_USER pou ON POU.LK_PO_OFF_USER_ID=UM.LK_PO_OFF_USER_ID "
    		+ "	JOIN MASTER_V1.LK_POST_OFFICE po ON POU.LK_POST_OFFICE_ID=PO.LK_POST_OFFICE_ID "
    		+ "	JOIN MASTER_V1.MS_OFFICE o ON o.OFFICE_ID = po.OFFICE_ID "
    		+ "	WHERE wr.WF_ROLE_ID = :assignTowfRoleId "
    		+ "	AND o.OFFICE_ID = :assignToOfficeId" ,nativeQuery = true)
	public List<Long> getUSersByWfRoleOfficeId(Long assignToOfficeId, Long assignTowfRoleId);

}
