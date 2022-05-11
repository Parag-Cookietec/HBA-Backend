package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.dto.LocAccOpenReqDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqDtlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class LocAccountOpenReqDtlController.
 *
 * @version 1.0
 * @created 2020/12/23 11:53:12
 */
@Repository
@Transactional
public interface LocAccountOpenReqDtlRepository extends JpaRepository<LocAccountOpenReqDtlEntity, Long>,
        JpaSpecificationExecutor<LocAccountOpenReqDtlEntity>, GenericDao {


    /**
     * Gets the account open req dtl by hdr id and active status.
     *
     * @param lcOpenReqHdrId the lc open req hdr id
     * @param activeStatus   the active status
     * @return the account open req dtl by hdr id and active status
     */
    @Query(value = "SELECT hdr.LC_OPEN_REQ_HDR_ID AS hdrID,sd.LC_OPEN_REQUEST_ID as dtlId,hdr.REFERENCE_NO AS refNo,hdr.REFERENCE_DT AS refDt,hdr.DIVISION_OFFICE_ADDRESS AS divOffAdd,"
            + "hdr.DEPARTMENT_ID AS dptId,dpt.DEPARTMENT_NAME AS dptName,hdr.HOD_ID AS hodId,hod.OFFICE_NAME AS hodName,hdr.TO_OFFICE_ID AS toOffId,tof.OFFICE_NAME AS toOffName,"
            + "hdr.DISTRICT_ID AS disId,dis.DISTRICT_NAME AS disName,hdr.CARDEX_NO AS cardexNo,hdr.DDO_NO AS ddoNo,hdr.CREATED_BY AS createdBy,hdr.CREATED_DATE AS createdDate,"
            + "sd.CIRCLE_CODE AS circleCode,sd.CIRCLE_ID AS circleId,SD.CIRCLE_NAME AS circleName,sd.DIVISION_NAME AS divisionName,sd.REMARKS AS remarks,"
            + "hdr.OFFICE_NAME_ID AS offId,off.OFFICE_NAME AS offName "
            + "FROM LOC.TLOC_LC_OPEN_REQ_HDR hdr LEFT JOIN LOC.TLOC_LC_OPEN_REQ_DTL sd ON hdr.LC_OPEN_REQ_HDR_ID = sd.LC_OPEN_REQ_HDR_ID "
            + "LEFT JOIN  MASTER_V1.MS_DEPARTMENT dpt ON hdr.DEPARTMENT_ID = dpt.DEPARTMENT_ID LEFT JOIN MASTER_V1.MS_DISTRICT dis ON hdr.DISTRICT_ID = dis.DISTRICT_ID "
            + "LEFT JOIN MASTER_V1.MS_OFFICE tof ON hdr.TO_OFFICE_ID = tof.OFFICE_ID LEFT JOIN MASTER_V1.MS_OFFICE hod ON hdr.HOD_ID = hod.OFFICE_ID "
            + "LEFT JOIN MASTER_V1.MS_CIRCLE mc ON mc.CIRCLE_ID = sd.CIRCLE_ID LEFT JOIN MASTER_V1.LU_LOOKUP_INFO ll ON sd.CIRCLE_ID = ll.LOOKUP_INFO_ID  AND sd.CIRCLE_ID = 1490 "
            + "LEFT JOIN MASTER_V1.MS_OFFICE off ON hdr.OFFICE_NAME_ID = off.OFFICE_ID "
            + "WHERE hdr.ACTIVE_STATUS = :activeStatus AND hdr.LC_OPEN_REQ_HDR_ID = :lcOpenReqHdrId", nativeQuery = true)
    public LocAccOpenReqDtlDto getAccountOpenReqDtlByHdrIdAndActiveStatus(@Param("lcOpenReqHdrId") Long lcOpenReqHdrId,
                                                                          @Param("activeStatus") Integer activeStatus);

    @Modifying
    @Query("Update LocAccountOpenReqDtlEntity set circleId =:circleId where lcOpenReqHdrId.lcOpenReqHdrId =:hdrId and activeStatus =:activeStatus")
    int updateCircleId(@Param("hdrId") Long hdrId,@Param("circleId") Long circleId, @Param("activeStatus") int activeStatus);
}
