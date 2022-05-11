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

import gov.ifms.edp.entity.EDPMsHodEntity;

/**
 * The Interface EDPMsHodRepository.
 */
@Repository
@Transactional
public interface EDPMsHodRepository
		extends JpaRepository<EDPMsHodEntity, Long>, JpaSpecificationExecutor<EDPMsHodEntity> {
	
	/**
	 * Deletes the EDPMsHodEntity with the given id.
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
	@Query(value = "update EDPMsHodEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int deleteMsHod(@Param("id") long id, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	/**
	 * Find by department id department id.
	 *
	 * @param departmentId the department id
	 * @return the list
	 */
	public List<EDPMsHodEntity> findByDepartmentIdDepartmentId(Long departmentId);
	
	
	
	

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<EDPMsHodEntity> findByActiveStatus(int activeStatus);
}
