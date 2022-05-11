package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Interface EDPMsOfficeRepository.
 */
@Repository
@Transactional
public interface LocMsOfficeRepository
        extends JpaRepository<EDPMsOfficeEntity, Long>, JpaSpecificationExecutor<EDPMsOfficeEntity>, GenericDao {

    /**
     * @param id
     * @param ddoNo
     * @param cardexno
     * @param districtId
     * @param activeStatus
     * @param activeStatus2
     * @param luApprovedLookupInfoId
     * @param luActiveLookupInfoId
     * @param divsionSubType
     * @return
     */
    @Query(value = "select edp from EDPMsOfficeEntity edp where edp.officeId=:id and edp.ddoNo=:ddoNo and edp.cardexno=:cardexno and edp.districtId.districtId=:districtId"
            + " and edp.activeStatus=:activeStatus and edp.statusId=:luApprovedLookupInfoId and edp.officeStatus = :luActiveLookupInfoId "
            + " and edp.subType.subTypeId = :divsionSubType")
    List<EDPMsOfficeEntity> getDivisionList(@Param("id") Long id, @Param("ddoNo") String ddoNo, @Param("cardexno") Long cardexno,
                                            @Param("districtId") Long districtId, @Param("activeStatus") int activeStatus, @Param("luApprovedLookupInfoId") short luApprovedLookupInfoId,
                                            @Param("luActiveLookupInfoId") long luActiveLookupInfoId, @Param("divsionSubType") Long divsionSubType);


}
