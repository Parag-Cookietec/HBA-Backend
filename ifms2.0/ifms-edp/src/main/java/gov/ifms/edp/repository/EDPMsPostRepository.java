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

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsPostEntity;

/**
 * The Interface EDPMsPostRepository.
 */
@Repository
@Transactional
public interface EDPMsPostRepository
		extends JpaRepository<EDPMsPostEntity, Long>, JpaSpecificationExecutor<EDPMsPostEntity>, GenericDao {
	
	/**
	 * Find by post id in.
	 *
	 * @param idList the id list
	 * @return the list
	 */
	List<EDPMsPostEntity> findByPostIdIn(Set<Long> idList);
	
	
	/**
	 * Find by post name.
	 *
	 * @param postName the post name
	 * @return the EDP ms post entity
	 */
	List<EDPMsPostEntity> findByPostName(String postName); 
	
	
	/**
	 * Find top by order by post id desc.
	 *
	 * @return the optional
	 */
	@Query(value = "SELECT pst.TRN_NO FROM "+Constant.EDP_MASTER_SCHEMA+".MS_POST AS pst WHERE pst.TRN_NO IS NOT NULL ORDER BY pst.POST_ID DESC  FETCH FIRST 1 ROWS ONLY",nativeQuery = true)
	Optional<String> findTopByPostIdAndTransactionNoIsNotNullOrderByPostIdDesc();
	
	
	/**
	 * Find by transaction no.
	 *
	 * @param trnNo the trn no
	 * @return the optional
	 */
	Optional<EDPMsPostEntity> findByTransactionNo(String trnNo);
	
	/**
	 * Find post count.
	 *
	 * @param officeId the office id
	 * @param designationId the designation id
	 * @return the optional
	 */
	@Query(value = "SELECT PST.POST_NAME FROM "+Constant.EDP_MASTER_SCHEMA+".MS_POST PST JOIN "+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE OFF ON off.POST_ID=pst.POST_ID WHERE off.OFFICE_ID=?1 AND pst.DESIGNATION_ID=?2 AND pst.POST_NAME NOT LIKE '%:%'  AND pst.POST_NAME LIKE '%-%'  ORDER BY LENGTH(pst.POST_NAME) DESC,pst.POST_NAME DESC FETCH FIRST ROWS ONLY",nativeQuery = true)
	Optional<String> findPostCountBasedOnPost(Long  officeId,Long designationId);
	
	/**
	 * Find post count.
	 *
	 * @param officeId the office id
	 * @param designationId the designation id
	 * @return the optional
	 */
	@Query(value = "SELECT PSTITR.POST_NAME FROM "+Constant.EDP_MASTER_SCHEMA+".T_POST_ITR PSTITR JOIN "+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE lkpostoffice ON lkpostoffice.POST_ID=pstitr.POST_ID WHERE lkpostoffice.OFFICE_ID=?1 AND PSTITR.DESIGNATION_ID=?2  ORDER BY LENGTH(PSTITR.POST_NAME) DESC,PSTITR.POST_NAME DESC FETCH FIRST ROWS ONLY",nativeQuery = true)
	Optional<String> findPostCountBasedOnPostItr(Long  officeId,Long designationId);
	
	
	/**
	 * Find post cound in itr by three digit.
	 *
	 * @param designationId the designation id
	 * @param officeId the office id
	 * @param designationName the designation name
	 * @return the long
	 */
	@Query(value = "SELECT MAX(CAST((CASE WHEN right(POST_NAME,1) = 'D' THEN replace(right(POST_NAME ,5),'D','') ELSE right(POST_NAME ,3) END) AS BIGINT)) AS sss FROM "+Constant.EDP_MASTER_SCHEMA+".T_POST_ITR PST JOIN "+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE OFF " 
            + " ON off.POST_ID=pst.POST_ID WHERE pst.DESIGNATION_ID=?1  AND off.OFFICE_ID =?2 "
		     + " AND PST.POST_NAME LIKE ?3",nativeQuery = true)
	Long findPostCoundInItrByThreeDigit(@Param("designationId")Long designationId,@Param("officeId")Long officeId,@Param("designationName")String designationName);

	/**
	 * Find post cound in itr by two digit.
	 *
	 * @param designationId the designation id
	 * @param officeId the office id
	 * @param designationName the designation name
	 * @return the long
	 */
	@Query(value = "SELECT MAX(CAST((CASE WHEN right(POST_NAME,1) = 'D' THEN replace(right(POST_NAME ,4),'D','') ELSE right(POST_NAME ,2) END) AS BIGINT)) AS sss FROM "+Constant.EDP_MASTER_SCHEMA+".T_POST_ITR PST JOIN "+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE OFF " 
            + " ON off.POST_ID=pst.POST_ID WHERE pst.DESIGNATION_ID=?1  AND off.OFFICE_ID =?2 "
            + "AND PST.POST_NAME LIKE ?3 ",nativeQuery = true)
	Long findPostCoundInItrByTwoDigit(@Param("designationId")Long designationId,@Param("officeId")Long officeId,@Param("designationName")String designationName);

	/**
	 * Find post name in itr.
	 *
	 * @param designationId the designation id
	 * @param officeId the office id
	 * @param designationName the designation name
	 * @return the string
	 */
	@Query(value = "SELECT  mp.POST_NAME FROM "+Constant.EDP_MASTER_SCHEMA+".T_POST_ITR mp,"+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE lpo WHERE lpo.OFFICE_ID = ?2 " 
                 + "AND mp.POST_ID = lpo.POST_ID AND mp.DESIGNATION_ID =?1 AND mp.POST_NAME = ?3 FETCH FIRST ROW ONLY " , nativeQuery = true)
	String findPostNameInItr(@Param("designationId")Long designationId,@Param("officeId")Long officeId,@Param("designationName")String designationName);

	
	
	/**
	 * Find post cound in itr by three digit.
	 *
	 * @param designationId the designation id
	 * @param officeId the office id
	 * @param designationName the designation name
	 * @return the long
	 */
	@Query(value = "SELECT MAX(CAST((CASE WHEN right(POST_NAME,1) = 'D' THEN replace(right(POST_NAME ,5),'D','') ELSE right(POST_NAME ,3) END) AS BIGINT)) AS sss FROM "+Constant.EDP_MASTER_SCHEMA+".MS_POST PST JOIN "+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE OFF " 
            + " ON off.POST_ID=pst.POST_ID WHERE pst.DESIGNATION_ID=?1  AND off.OFFICE_ID =?2 "
		     + " AND PST.POST_NAME LIKE ?3",nativeQuery = true)

	Long findPostCoundInByThreeDigit(@Param("designationId")Long designationId,@Param("officeId")Long officeId,@Param("designationName")String designationName);

	/**
	 * Find post cound in itr by two digit.
	 *
	 * @param designationId the designation id
	 * @param officeId the office id
	 * @param designationName the designation name
	 * @return the long
	 */
	@Query(value = "SELECT MAX(CAST((CASE WHEN right(POST_NAME,1) = 'D' THEN replace(right(POST_NAME ,4),'D','') ELSE right(POST_NAME ,2) END) AS BIGINT)) AS sss FROM "+Constant.EDP_MASTER_SCHEMA+".MS_POST PST JOIN "+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE OFF " 
            + " ON off.POST_ID=pst.POST_ID WHERE pst.DESIGNATION_ID=?1  AND off.OFFICE_ID =?2 "
            + "AND PST.POST_NAME LIKE ?3 ",nativeQuery = true)
	Long findPostCoundInByTwoDigit(@Param("designationId")Long designationId,@Param("officeId")Long officeId,@Param("designationName")String designationName);

	/**
	 * Find post name in itr.
	 *
	 * @param designationId the designation id
	 * @param officeId the office id
	 * @param designationName the designation name
	 * @return the string
	 */
	@Query(value = "SELECT  mp.POST_NAME FROM "+Constant.EDP_MASTER_SCHEMA+".MS_POST mp,"+Constant.EDP_MASTER_SCHEMA+".LK_POST_OFFICE lpo WHERE lpo.OFFICE_ID = ?2 " 
                 + "AND mp.POST_ID = lpo.POST_ID AND mp.DESIGNATION_ID =?1 AND mp.POST_NAME = ?3 FETCH FIRST ROW ONLY " , nativeQuery = true)
	String findPostNameIn(@Param("designationId")Long designationId,@Param("officeId")Long officeId,@Param("designationName")String designationName);


	@Modifying
	@Query(value = "update EDPMsPostEntity hdrEntity set hdrEntity.statusId.lookUpInfoId = :statusId,hdrEntity.updatedBy=:updatedBy , "
			+ "hdrEntity.updatedDate=:updatedDate where hdrEntity.postId = :postId")
	public int updateUserPostStatus(@Param("postId") Long postId, @Param("statusId") Long statusId,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	@Modifying
	@Query(value = "update EDPMsPostEntity set hasObjection.lookUpInfoId = :hasObjection, objectionRemarks = :objectionRemarks where postId = :postId")
	public int updateObjectionForHeader(@Param("hasObjection") Long hasObjection, @Param("objectionRemarks") String objectionRemarks,@Param("postId") Long postId);}
