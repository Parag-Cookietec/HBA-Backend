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
import gov.ifms.edp.entity.EDPtusrRgMapEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Class EDPtusrRgMapController.
 * 
 * @version 1.0
 * @created 2020/07/16 09:23:40
 */

@Repository
@Transactional
public interface EDPtusrRgMapRepository extends JpaRepository<EDPtusrRgMapEntity,Long> , 
                  JpaSpecificationExecutor<EDPtusrRgMapEntity>, GenericDao {
	
	/**
	 * Update status of rg map.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @param statusId the status id
	 * @param updatedBy the updated by
	 * @param updatedByPost the updated by post
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPtusrRgMapEntity rgMap set rgMap.statusId.lookUpInfoId = :statusId,  rgMap.updatedBy=:updatedBy , "
			+ "rgMap.updatedDate=:updatedDate,rgMap.updatedByPost = :updatedByPost where rgMap.tusrRgMapId = :tusrRgMapId")
	public int updateStatusOfRgMap(@Param("tusrRgMapId") Long tusrRgMapId ,@Param("statusId") Long statusId, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Update status and remarks of rg map.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @param statusId the status id
	 * @param updatedBy the updated by
	 * @param updatedByPost the updated by post
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPtusrRgMapEntity rgMap set rgMap.statusId.lookUpInfoId = :statusId,  rgMap.updatedBy=:updatedBy , "
			+ "rgMap.updatedDate=:updatedDate,rgMap.updatedByPost = :updatedByPost,rgMap.hasObjection.lookUpInfoId = :hasObjection, rgMap.objectionRemarks = :objectionRemarks "
			+ "where rgMap.tusrRgMapId = :tusrRgMapId")
	public int updateStatusAndRemarksOfRgMap(@Param("tusrRgMapId") Long tusrRgMapId ,@Param("statusId") Long statusId, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate,@Param("hasObjection") Long hasObjection, @Param("objectionRemarks") String objectionRemarks);
	
	/**
	 * Check rights mapping for post office user with status.
	 *
	 * @param postOfficeUserId the post office user id
	 * @param statusId the status id
	 * @return the list
	 */
	@Query(nativeQuery = true ,value=EDPNativeSQLUtil.CHECK_REQUEST_RIGHTS_MAPPING_WITH_STATUS)
	public List<Object[]> checkRightsMappingForPostOfficeUserWithStatus(@Param("postOfficeUserId")Long postOfficeUserId, @Param("statusId") Long statusId);
	
	@Modifying
	@Query(value = "update EDPtusrRgMapEntity dtlEntity set activeStatus= :activeStatus,updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate,updatedByPost = :updatedByPost where tusrRgMapId = :tusrRgMapId")
	public int updateActiveStatusByRgMapId(@Param("tusrRgMapId")Long tusrRgMapId ,@Param("activeStatus") int activeStatus, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate);

}
