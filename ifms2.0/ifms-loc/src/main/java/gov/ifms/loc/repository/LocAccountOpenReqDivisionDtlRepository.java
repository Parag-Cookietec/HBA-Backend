package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.dto.LocDiviReqDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqDivisionDtlEntity;

/**
 * The Class LocAccountOpenReqDivisionDtlController.
 * 
 * @version 1.0
 * @created 2021/01/01 20:16:25
 */

@Repository
@Transactional
public interface LocAccountOpenReqDivisionDtlRepository extends JpaRepository<LocAccountOpenReqDivisionDtlEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqDivisionDtlEntity>,GenericDao {
	
	/**
	 * Gets the divi req dtl by hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus the active status
	 * @return the divi req dtl by hdr id and active status
	 */
	@Query(value = "Select dtl.LC_OPEN_REQ_HDR_ID hdrId, dtl.LC_OPEN_REQ_DIVI_DTL_ID dtlId,dtl.DIVISION_CD divisionCode, dtl.DIVISION_REMARKS divisionRemarks "
			+ "from LOC.TLOC_OPEN_REQ_DIVI_DTL dtl, LOC.TLOC_LC_OPEN_REQ_HDR hdr "
			+ "where dtl.LC_OPEN_REQ_HDR_ID = hdr.LC_OPEN_REQ_HDR_ID and dtl.LC_OPEN_REQ_HDR_ID=:lcOpenReqHdrId and dtl.ACTIVE_STATUS=:activeStatus",nativeQuery = true)
	public LocDiviReqDtlDto getDiviReqDtlByHdrIdAndActiveStatus(@Param("lcOpenReqHdrId") Long lcOpenReqHdrId,
			@Param("activeStatus") Integer activeStatus);
	
}
