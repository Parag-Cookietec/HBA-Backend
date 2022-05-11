package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsTalukaEntity;

/**
 * The Interface EDPMsTalukaRepository.
 */
@Repository
@Transactional
public interface EDPMsTalukaRepository
		extends JpaRepository<EDPMsTalukaEntity, Long>, JpaSpecificationExecutor<EDPMsTalukaEntity> {
	
	/**
	 * Deletes the EDPMsTalukaEntity with the given id.
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
	@Query(value = "update EDPMsTalukaEntity set isDelete= :isDelete , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int deleteMsTaluka(@Param("id") long id, @Param("isDelete") int isDelete, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<EDPMsTalukaEntity> findByActiveStatus(int activeStatus);
	
	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @param sort the sort
	 * @return the list
	 */
	public List<EDPMsTalukaEntity> findByActiveStatus(int activeStatus,Sort sort);
	
	/**
	 * Find by taluka id and active status.
	 *
	 * @param talukaId the taluka id
	 * @param activeStatus the active status
	 * @return the EDP ms taluka entity
	 */
	EDPMsTalukaEntity findByTalukaIdAndActiveStatus(Long talukaId, int activeStatus);
	
	/**
	 * Find by district id and active status.
	 *
	 * @param districtId the district id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsTalukaEntity> findByDistrictIdAndActiveStatus(Long districtId, int activeStatus);

}
