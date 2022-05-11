package gov.ifms.loc.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocDistributionHdrEntity;
import gov.ifms.loc.util.LocDBConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * The Class LocDistributionHdrController.
 *
 * @version v 1.0
 * @created 2021/02/11 14:33:34
 */

@Repository
@Transactional
public interface LocDistributionHdrRepository extends JpaRepository<LocDistributionHdrEntity, Long>,
        JpaSpecificationExecutor<LocDistributionHdrEntity>, GenericDao {
    /**
     * Gets the srch param.
     *
     * @return the srch param
     */
    @Query(value = LocDBConstants.LOC_DIST_SRCH_PARAM, nativeQuery = true)
    List<Object[]> getSrchParam();

    /**
     * Find by id and active status.
     *
     * @param id           the id
     * @param activeStatus the active status
     * @return the loc distribution hdr entity
     */
    LocDistributionHdrEntity findByIdAndActiveStatus(Long id, int activeStatus);

    /**
     * Gets the hdr edit view.
     *
     * @param hdrId        the hdr id
     * @param activeStatus the active status
     * @return the hdr edit view
     */
    @Query(value = LocDBConstants.LOC_DISTRIBUTION_HDR_VIEW, nativeQuery = true)
    List<Object[]> getHdrEditView(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

    /**
     * Gets the dtl edit view.
     *
     * @param hdrId        the hdr id
     * @param activeStatus the active status
     * @return the dtl edit view
     */
    @Query(value = LocDBConstants.LOC_DISTRIBUTION_DTL_VIEW, nativeQuery = true)
    List<Object[]> getDtlEditView(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

    /**
     * Update loc distribution.
     *
     * @param hdrId         the hdr id
     * @param inwardNo      the inward no
     * @param inwardDate    the inward date
     * @param partyRefNo    the party ref no
     * @param partyRefDate  the party ref date
     * @param raiseObjFlag  the raise obj flag
     * @param objRemarks    the obj remarks
     * @param officeId      the office id
     * @param cardexNo      the cardex no
     * @param ddoNo         the ddo no
     * @param refNo         the ref no
     * @param refDate       the ref date
     * @param updatedBy     the updated by
     * @param updatedByPost the updated by post
     * @param updatedDate   the updated date
     * @param l 
     * @return the int
     */
    @Modifying
    @Query(value = "update LocDistributionHdrEntity set refNo=:refNo, refDate=:refDate,inwardNo= :inwardNo,inwardDate=:inwardDate, partyRefNo=:partyRefNo,partyRefDate =:partyRefDate, raiseObjFlag = :raiseObjFlag, objRemarks=:objRemarks,"
            + " updatedBy=:updatedBy ,updatedByPost=:updatedByPost, updatedDate=:updatedDate , statusId = :statusId where id = :hdrId")
    public int updateLocDistribution(@Param("hdrId") Long hdrId, @Param("inwardNo") String inwardNo,
                                     @Param("inwardDate") Date inwardDate, @Param("partyRefNo") String partyRefNo,
                                     @Param("partyRefDate") Date partyRefDate, @Param("raiseObjFlag") String raiseObjFlag,
                                     @Param("objRemarks") String objRemarks,
                                     @Param("refNo") String refNo,
                                     @Param("refDate") Date refDate, @Param("updatedBy") Long updatedBy,
                                     @Param("updatedByPost") Long updatedByPost, @Param("updatedDate") Date updatedDate,  @Param("statusId") Long statusId);


    /**
     * Gets the grant distribution list.
     *
     * @param cardexNo the cardex no
     * @param ddoNo the ddo no
     * @param officeId the office id
     * @param finYear the fin year
     * @return the grant distribution list
     */
    @Query(value = LocDBConstants.LOC_DIST_GRANT_LIST, nativeQuery = true)
    List<Object[]> getGrantDistributionList(@Param("cardexNo") Long cardexNo, @Param("ddoNo") Long ddoNo, @Param("officeId") Long officeId, @Param("finYear") Long finYear);

	/**
	 * Gets the dtl view data.
	 *
	 * @param hdrId the hdr id
	 * @param activeStatus the active status
	 * @return the dtl view data
	 */
	@Query(value = LocDBConstants.LOC_DISTRIBUTION_DTL_VIEW_DATA, nativeQuery = true)
    List<Object[]> getDtlViewData(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

    @Modifying
    @Query(value = LocDBConstants.LOC_ADVICE_UPDATE,nativeQuery = true)
	void updateFlagInAdviceHdr(@Param("ddoNo") String ddoNo,@Param("cardexNo") String cardexNo, @Param("officeId") Long officeId);
}
