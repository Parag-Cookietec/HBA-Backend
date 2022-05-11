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

import gov.ifms.edp.entity.EDPPostItrEntity;

/**
 * The Interface EDPPostItrRepository.
 */
@Repository
@Transactional
public interface EDPPostItrRepository
		extends JpaRepository<EDPPostItrEntity, Long>, JpaSpecificationExecutor<EDPPostItrEntity> {
	
	/**
	 * Deletes the EDPPostItrEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Modifying
	@Query(value = "update EDPPostItrEntity set isDelete= :isDelete , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int deletePostItr(@Param("id") long id, @Param("isDelete") int isDelete, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);
	
	/**
	 * Find top by order by edp po itr id desc.
	 *
	 * @return the EDP post itr entity
	 */
	public EDPPostItrEntity findTopByOrderByEdpPoItrIdDesc();
	
	
	/**
	 * Find by post id.
	 *
	 * @param postId the post id
	 * @return the list
	 */
	public List<EDPPostItrEntity> findByPostId(Long postId);
	
	
	/**
	 * Find by post id and designation id designation id.
	 *
	 * @param postId the post id
	 * @param designationId the designation id
	 * @return the list
	 */
	public List<EDPPostItrEntity> findByPostIdAndDesignationIdDesignationIdAndOfficeId(Long postId,Long designationId,Long officeId);
}
