package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkPostOfficeEntity;

/**
 * The Interface EDPLkPostOfficeRepository.
 */
@Repository
@Transactional
public interface EDPLkPostOfficeRepository
		extends JpaRepository<EDPLkPostOfficeEntity, Long>, JpaSpecificationExecutor<EDPLkPostOfficeEntity> {
	
	/**
	 * Deletes the EDPLkPostOfficeEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Modifying
	@Query(value = "update EDPLkPostOfficeEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int deleteLkPostOffice(@Param("id") long id, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	

	/**
	 * Count by office entity office id and post entity designation id designation id.
	 *
	 * @param officeid the officeid
	 * @param designationId the designation id
	 * @return the long
	 */
	public Long countByOfficeEntityOfficeIdAndPostEntityDesignationIdDesignationId(Long officeid, Long designationId);

	/**
	 * Count by office entity office id and post entity designation id designation id and active status.
	 *
	 * @param officeid the officeid
	 * @param designationId the designation id
	 * @param active the active
	 * @return the long
	 */
	public Long countByOfficeEntityOfficeIdAndPostEntityDesignationIdDesignationIdAndActiveStatus(Long officeid, Long designationId,Integer active);
	
	
	/**
	 * Find by post entity post id.
	 *
	 * @param postId the post id
	 * @return the list
	 */
	public List<EDPLkPostOfficeEntity> findByPostEntityPostId(Long postId); 
	
	
	
	
	
	/**
	 * Find by active status and post entity post id.
	 *
	 * @param active the active
	 * @param postId the post id
	 * @return the list
	 */
	public List<EDPLkPostOfficeEntity> findByActiveStatusAndPostEntityPostId(Integer active, Long postId); 
	
	
	/**
	 * Find by post entity post id and office entity office id.
	 *
	 * @param postId the post id
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<EDPLkPostOfficeEntity> findByPostEntityPostIdAndOfficeEntityOfficeIdAndActiveStatus(Long postId,Long officeId, int activeStatus);
	
	
	/**
	 * Find by active status and post entity post name.
	 *
	 * @param postName the post name
	 * @param officeId the office id
	 * @return the list
	 */
	public List<EDPLkPostOfficeEntity> findByPostEntityPostNameAndOfficeEntityOfficeId(String  postName,Long officeId); 
	
	/**
	 * Update lk post office as vacant post.
	 *
	 * @param vacantLookupId the vacant lookup id
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @param postOfficeId the post office id
	 * @param updatedByPost the updated by post
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPLkPostOfficeEntity set isVacant.lookUpInfoId = :vacantLookupId , updatedBy=:updatedBy, " 
			+ "updatedDate=:updatedDate,updatedByPost=:updatedByPost  where postOfficeId IN (:postOfficeId)")
	public int updateLkPostOfficeAsVacantPost(@Param("vacantLookupId") Long vacantLookupId,@Param("updatedBy") Long updatedBy,
			@Param("updatedDate") Date updatedDate, @Param("postOfficeId")Set<Long> postOfficeId,
			@Param("updatedByPost") Long updatedByPost);

	/**
	 * Find by post entity post id and active status.
	 *
	 * @param postId the post id
	 * @param active the active
	 * @return the EDP lk post office entity
	 */
	public EDPLkPostOfficeEntity findByPostEntityPostIdAndActiveStatus(Long postId,Integer active); 

}