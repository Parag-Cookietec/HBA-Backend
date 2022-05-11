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

import gov.ifms.edp.entity.EDPtusrRgMapDtlEntity;
/**
 * The Class EDPtusrRgMapDtlController.
 * 
 * @version 1.0
 * @created 2020/07/16 09:31:33
 */

@Repository
@Transactional
public interface EDPtusrRgMapDtlRepository extends JpaRepository<EDPtusrRgMapDtlEntity,Long> , 
                  JpaSpecificationExecutor<EDPtusrRgMapDtlEntity> {
   		
	/**
	 * Find by tusr rg map id tusr rg map id.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @return the list
	 */
	List<EDPtusrRgMapDtlEntity> findByTusrRgMapIdTusrRgMapId(Long tusrRgMapId);
	
	/**
	 * Multipal update active status.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedByPost the updated by post
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPtusrRgMapDtlEntity dtlEntity set activeStatus= :activeStatus,updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate,updatedByPost = :updatedByPost where dtlEntity.tusrRgMapId.tusrRgMapId = :tusrRgMapId")
	public int multipalUpdateActiveStatusByRgMapId(@Param("tusrRgMapId")Long tusrRgMapId ,@Param("activeStatus") int activeStatus, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate);

	@Modifying
	@Query(value = "update EDPtusrRgMapDtlEntity dtlEntity set activeStatus= :activeStatus,updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate,updatedByPost = :updatedByPost where dtlEntity.tusrRgMapDtlId = :tusrRgMapDtlId")
	public int updateActiveStatusByRgMapDtlId(@Param("tusrRgMapDtlId")Long tusrRgMapDtlId ,@Param("activeStatus") int activeStatus, 
			@Param("updatedBy") Long updatedBy, @Param("updatedByPost") Long updatedByPost,
			@Param("updatedDate") Date updatedDate);

}
