package gov.ifms.loc.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAccountCloseReqSdEntity;

/**
 * The Interface LocAccountCloseReqSdRepository.
 */
@Repository
@Transactional
public interface LocAccountCloseReqSdRepository
		extends JpaRepository<LocAccountCloseReqSdEntity, Long>, JpaSpecificationExecutor<LocAccountCloseReqSdEntity> {

	/**
	 * Deletes the LocAccountOpenReqSdEntity with the given id.
	 *
	 * @param id              must not be {@literal null}.
	 * @param lcclosingDt     the lcclosing dt
	 * @param closureRemark   the closure remark
	 * @param agClosureRemark the ag closure remark
	 * @param approvalDt      the approval dt
	 * @return the int
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Modifying
	@Query(value = "UPDATE LOC.TLOC_LC_CLOSING_REQUEST_HDR_SD SET LC_CLOSING_DT = :lcclosingDt, "
			+ "CLOSURE_REMARK = :closureRemark, AG_CLOSURE_REMARK = :agClosureRemark,APPROVAL_DT = :approvalDt WHERE "
			+ "ACTIVE_STATUS = 1 AND LC_CLOSING_REQUEST_HDR_ID = :id", nativeQuery = true)
	public int updateAccountCloseReqSd(@Param("id") Long id, @Param("lcclosingDt") Date lcclosingDt,
			@Param("closureRemark") String closureRemark, @Param("agClosureRemark") String agClosureRemark,
			@Param("approvalDt") Date approvalDt);

	/**
	 * Find by lc close req hdr id lc close req hdr id and active status.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the loc account close req sd entity
	 */
	LocAccountCloseReqSdEntity findByLcCloseReqHdrIdLcCloseReqHdrIdAndActiveStatus(Long hdrId, int activeStatus);

}
