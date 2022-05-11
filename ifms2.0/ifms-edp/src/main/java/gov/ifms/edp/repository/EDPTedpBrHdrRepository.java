package gov.ifms.edp.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPTedpBrHdrEntity;


/**
 * The Interface EDPTedpBrHdrRepository.
 */
@Repository
@Transactional
public interface EDPTedpBrHdrRepository
		extends JpaRepository<EDPTedpBrHdrEntity, Long>, JpaSpecificationExecutor<EDPTedpBrHdrEntity>, GenericDao {

	/**
	 * Update hdr status.
	 *
	 * @param statusId the status id
	 * @param tedpBrHdrId the tedp br hdr id
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPTedpBrHdrEntity hdrEntity set hdrEntity.statusId.lookUpInfoId = :statusId, hdrEntity.updatedBy=:updatedBy, " 
			  + "hdrEntity.updatedDate=:updatedDate,hdrEntity.updatedByPost = :updatedByPost where hdrEntity.tedpBrHdrId = :tedpBrHdrId")
	public int updateHdrStatus(@Param("statusId") Long statusId, @Param("tedpBrHdrId") Long tedpBrHdrId,  @Param("updatedBy") Long updatedBy,
			 @Param("updatedDate") Date updatedDate,  @Param("updatedByPost") Long updatedByPost);
	
	/**
	 * Update hdr active status.
	 *
	 * @param activeStatus the active status
	 * @param tedpBrHdrId the tedp br hdr id
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPTedpBrHdrEntity hdrEntity set hdrEntity.activeStatus = :activeStatus, hdrEntity.updatedBy=:updatedBy,"+ 
			"hdrEntity.updatedDate=:updatedDate,hdrEntity.updatedByPost = :updatedByPost where hdrEntity.tedpBrHdrId = :tedpBrHdrId")
	public int updateHdrActiveStatus(@Param("activeStatus") int activeStatus, @Param("tedpBrHdrId") Long tedpBrHdrId, @Param("updatedBy") Long updatedBy,
			 @Param("updatedDate") Date updatedDate,  @Param("updatedByPost") Long updatedByPost);
	
	
	/**
	 * Update hdr updated date.
	 *
	 * @param tedpBrHdrId the tedp br hdr id
	 * @param date the date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPTedpBrHdrEntity hdrEntity set hdrEntity.updatedDate=:updatedDate where hdrEntity.tedpBrHdrId = :tedpBrHdrId")
	public int updateHdrUpdatedDate(@Param("tedpBrHdrId") Long tedpBrHdrId, @Param("updatedDate") Date updatedDate);	
	
}