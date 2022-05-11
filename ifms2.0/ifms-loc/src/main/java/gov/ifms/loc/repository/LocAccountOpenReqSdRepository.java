package gov.ifms.loc.repository;

import gov.ifms.loc.dto.LocAccOpenReqDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqSdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class LocAccountOpenReqSdController.
 *
 * @version 1.0
 * @created 2020/12/22 13:07:09
 */

@Repository
@Transactional
public interface LocAccountOpenReqSdRepository
        extends JpaRepository<LocAccountOpenReqSdEntity, Long>, JpaSpecificationExecutor<LocAccountOpenReqSdEntity> {
    /**
     * Deletes the LocAccountOpenReqSdEntity with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is
     *                                  {@literal null}
     */
    @Modifying
    @Query(value = "UPDATE LOC.TLOC_LC_OPEN_REQ_SD SET DIVISION_NAME = :divisionName, "
            + "CIRCLE_CODE = :circleCode, CIRCLE_ID = :circleId,REMARKS = :remarks , CIRCLE_NAME =:circleName WHERE "
            + "ACTIVE_STATUS = 1 AND LC_OPEN_REQ_HDR_ID = :id", nativeQuery = true)
    public int updateAccountOpenReqSd(@Param("id") Long id, @Param("divisionName") String divisionName,
                                      @Param("circleId") Long circleId, @Param("circleCode") String circleCode,
                                      @Param("remarks") String remarks,@Param("circleName") String circleName);


    /**
     * Gets the account open req dtl by hdr id and active status.
     *
     * @param lcOpenReqHdrId the lc open req hdr id
     * @param activeStatus   the active status
     * @return the account open req dtl by hdr id and active status
     */
    @Query(value = "SELECT hdr.LC_OPEN_REQ_HDR_ID AS hdrID,sd.LC_OPEN_REQUEST_ID as dtlId, hdr.REFERENCE_NO AS refNo,hdr.REFERENCE_DT AS refDt,hdr.DIVISION_OFFICE_ADDRESS AS divOffAdd,"
            + "hdr.DEPARTMENT_ID AS dptId,dpt.DEPARTMENT_NAME AS dptName,hdr.HOD_ID AS hodId,hod.OFFICE_NAME AS hodName,hdr.TO_OFFICE_ID AS toOffId,tof.OFFICE_NAME AS toOffName,"
            + "hdr.DISTRICT_ID AS disId,dis.DISTRICT_NAME AS disName,hdr.CARDEX_NO AS cardexNo,hdr.DDO_NO AS ddoNo,hdr.CREATED_BY AS createdBy,hdr.CREATED_DATE AS createdDate,"
            + "sd.CIRCLE_CODE AS circleCode,sd.CIRCLE_ID AS circleId,sd.CIRCLE_NAME AS circleName,sd.DIVISION_NAME AS divisionName,sd.REMARKS AS remarks,"
            + "hdr.OFFICE_NAME_ID AS offId,off.OFFICE_NAME AS offName "
            + "FROM LOC.TLOC_LC_OPEN_REQ_HDR hdr LEFT JOIN LOC.TLOC_LC_OPEN_REQ_SD sd ON hdr.LC_OPEN_REQ_HDR_ID = sd.LC_OPEN_REQ_HDR_ID "
            + "LEFT JOIN  MASTER_V1.MS_DEPARTMENT dpt ON hdr.DEPARTMENT_ID = dpt.DEPARTMENT_ID LEFT JOIN MASTER_V1.MS_DISTRICT dis ON hdr.DISTRICT_ID = dis.DISTRICT_ID "
            + "LEFT JOIN MASTER_V1.MS_OFFICE tof ON hdr.TO_OFFICE_ID = tof.OFFICE_ID LEFT JOIN MASTER_V1.MS_OFFICE hod ON hdr.HOD_ID = hod.OFFICE_ID "
            + "LEFT JOIN MASTER_V1.MS_CIRCLE mc ON mc.CIRCLE_ID = sd.CIRCLE_ID LEFT JOIN MASTER_V1.LU_LOOKUP_INFO ll ON sd.CIRCLE_ID = ll.LOOKUP_INFO_ID  AND sd.CIRCLE_ID = 1490 "
            + "LEFT JOIN MASTER_V1.MS_OFFICE off ON hdr.OFFICE_NAME_ID = off.OFFICE_ID "
            + "WHERE hdr.ACTIVE_STATUS = :activeStatus AND hdr.LC_OPEN_REQ_HDR_ID = :lcOpenReqHdrId", nativeQuery = true)
    public LocAccOpenReqDtlDto getAccountOpenReqDtlByHdrIdAndActiveStatus(@Param("lcOpenReqHdrId") Long lcOpenReqHdrId,
                                                                          @Param("activeStatus") Integer activeStatus);

}
