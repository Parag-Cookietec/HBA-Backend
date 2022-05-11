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

import gov.ifms.edp.entity.EDPtusrRgMapWfDtlEntity;
/**
 * The Class EDPtusrRgMapWfDtlController.
 * 
 * @version 1.0
 * @created 2020/07/16 09:34:26
 */

@Repository
@Transactional
public interface EDPtusrRgMapWfDtlRepository extends JpaRepository<EDPtusrRgMapWfDtlEntity,Long> , 
                  JpaSpecificationExecutor<EDPtusrRgMapWfDtlEntity> {
 
	/**
	 * Multipal update active status by dtl id.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedByPost the updated by post
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value="UPDATE EDP.T_USR_RG_MAP_WF_DTL SET ACTIVE_STATUS = :activeStatus, UPDATED_BY =:updatedBy, UPDATED_DATE =:updatedDate,UPDATED_BY_POST = :updatedByPost WHERE T_USR_RG_MAP_DTL_ID in (SELECT T_USR_RG_MAP_DTL_ID FROM edp.T_USR_RG_MAP_DTL WHERE T_USR_RG_MAP_ID  = :tusrRgMapId)", nativeQuery=true)	
	public int multipalUpdateActiveStatusByRgMapId(@Param("tusrRgMapId")Long tusrRgMapId ,@Param("activeStatus") int activeStatus, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate);

	@Modifying
	@Query(value="UPDATE EDP.T_USR_RG_MAP_WF_DTL SET ACTIVE_STATUS = :activeStatus, UPDATED_BY =:updatedBy, UPDATED_DATE =:updatedDate,UPDATED_BY_POST = :updatedByPost WHERE T_USR_RG_MAP_DTL_ID = :tusrRgMapDtlId", nativeQuery=true)	
	public int updateActiveStatusByRgMapDtlId(@Param("tusrRgMapDtlId")Long tusrRgMapDtlId ,@Param("activeStatus") int activeStatus, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Find by tusr rg map dtl id tusr rg map id tusr rg map id.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @return the list
	 */
	List<EDPtusrRgMapWfDtlEntity> findByTusrRgMapDtlIdTusrRgMapIdTusrRgMapId(Long tusrRgMapId);
	
}
