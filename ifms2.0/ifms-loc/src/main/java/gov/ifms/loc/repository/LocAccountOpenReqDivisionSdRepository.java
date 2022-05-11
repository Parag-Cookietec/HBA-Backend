package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.dto.LocDiviReqDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqDivisionSdEntity;

/**
 * The Class LocAccountOpenReqDivisionSdController.
 * 
 * @version 1.0
 * @created 2021/01/01 20:46:45
 */
@Repository
@Transactional
public interface LocAccountOpenReqDivisionSdRepository extends JpaRepository<LocAccountOpenReqDivisionSdEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqDivisionSdEntity> {
	
	/**
	 * Gets the divi req dtl by hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus the active status
	 * @return the divi req dtl by hdr id and active status
	 */
	@Query(value = "Select sd.LC_OPEN_REQ_HDR_ID hdrId, sd.LC_OPEN_REQ_DIVI_SD_ID dtlId, sd.DIVISION_CD divisionCode, sd.DIVISION_REMARKS divisionRemarks "
			+ "from LOC.TLOC_OPEN_REQ_DIVI_SD sd, LOC.TLOC_LC_OPEN_REQ_HDR hdr "
			+ "where sd.LC_OPEN_REQ_HDR_ID = hdr.LC_OPEN_REQ_HDR_ID and sd.LC_OPEN_REQ_HDR_ID=:lcOpenReqHdrId and sd.ACTIVE_STATUS=:activeStatus",nativeQuery = true)
	public LocDiviReqDtlDto getDiviReqDtlByHdrIdAndActiveStatus(@Param("lcOpenReqHdrId") Long lcOpenReqHdrId,
			@Param("activeStatus") Integer activeStatus);
	
	/**
	 * Find by lc open req hdr id lc open req hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus the active status
	 * @return the loc account open req division sd entity
	 */
	public LocAccountOpenReqDivisionSdEntity findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(Long lcOpenReqHdrId, int activeStatus);

	/**
	 * Update account open req divi sd.
	 *
	 * @param hdrId the hdr id
	 * @param activeStatus the active status
	 * @param divisionCode the division code
	 * @param divisionRemarks the division remarks
	 */
	@Modifying
	@Query(value = "Update LOC.TLOC_OPEN_REQ_DIVI_SD SD set SD.DIVISION_CD=:divisionCode, SD.DIVISION_REMARKS=:divisionRemarks "
		+ "where SD.LC_OPEN_REQ_HDR_ID=:hdrId and SD.ACTIVE_STATUS=:activeStatus",  nativeQuery = true)
	public void updateAccountOpenReqDiviSd(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus, 
			@Param("divisionCode") String divisionCode, @Param("divisionRemarks") String divisionRemarks);
}
