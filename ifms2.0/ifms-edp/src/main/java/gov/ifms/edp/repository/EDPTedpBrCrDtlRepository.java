package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPTedpBrCrDtlEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;


/**
 * The Interface EDPTedpBrCrDtlRepository.
 */
@Repository
@Transactional
public interface EDPTedpBrCrDtlRepository
		extends JpaRepository<EDPTedpBrCrDtlEntity, Long>, JpaSpecificationExecutor<EDPTedpBrCrDtlEntity>, GenericDao {

	/**
	 * Gets the branch data from office and branch type and branch name.
	 *
	 * @param statusId the status id
	 * @param activeStatus the active status
	 * @param officeId the office id
	 * @param branchType the branch type
	 * @param branchName the branch name
	 * @return the branch data from office and branch type and branch name
	 */
	@Query(value= EDPNativeSQLUtil.GET_BRANCH_NAME_FROM_DTL , nativeQuery = true)
	List<Object[]> getBranchDataFromOfficeAndBranchTypeAndBranchName(@Param("statusId") Long statusId,@Param("activeStatus") int activeStatus,
			@Param("officeId") Long officeId,@Param("branchName") String branchName,@Param("requestType") Long requestType); 
	
	/**
	 * Find by tedp br hdr id tedp br hdr id and active status.
	 *
	 * @param hdrId the hdr id
	 * @param activeStatus the active status
	 * @return the EDP tedp br cr dtl entity
	 */
	EDPTedpBrCrDtlEntity findByTedpBrHdrIdTedpBrHdrIdAndActiveStatus(Long hdrId, int activeStatus);
	
	/**
	 * Update dtl entity active status by hdr id.
	 *
	 * @param activeStatus the active status
	 * @param tedpBrHdrId the tedp br hdr id
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPTedpBrCrDtlEntity dtlEntity set dtlEntity.activeStatus = :activeStatus, dtlEntity.updatedBy=:updatedBy," + 
			"dtlEntity.updatedDate=:updatedDate,dtlEntity.updatedByPost = :updatedByPost where dtlEntity.tedpBrHdrId.tedpBrHdrId = :tedpBrHdrId")
	public int updateDtlEntityActiveStatusByHdrId(@Param("activeStatus") int activeStatus, @Param("tedpBrHdrId") Long tedpBrHdrId, @Param("updatedBy") Long updatedBy,
			 @Param("updatedDate") Date updatedDate,  @Param("updatedByPost") Long updatedByPost);	
	
	
}