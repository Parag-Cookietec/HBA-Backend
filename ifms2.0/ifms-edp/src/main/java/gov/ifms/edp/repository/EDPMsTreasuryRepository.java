package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsTreasuryEntity;

/**
 * The Interface EDPMsTreasuryRepository.
 */
@Repository
@Transactional
public interface EDPMsTreasuryRepository
		extends JpaRepository<EDPMsTreasuryEntity, Long>, JpaSpecificationExecutor<EDPMsTreasuryEntity> {
	
	/**
	 * Deletes the EDPMsTreasuryEntity with the given id.
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
	@Query(value = "update EDPMsTreasuryEntity set isDelete= :isDelete , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int deleteMsTreasury(@Param("id") long id, @Param("isDelete") int isDelete,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	/**
	 * Find by active status.
	 *
	 * @param active the active
	 * @return the list
	 */
	public List<EDPMsTreasuryEntity> findByActiveStatus(int active);
	
	/**
	 * This method is used to find treasury and sub treasury by district id 
	 * @param districtId
	 * @param activeStatus
	 * @return List<EDPMsTreasuryEntity>
	 */
	public List<EDPMsTreasuryEntity> findByDistrictIdAndActiveStatus(Long districtId, int activeStatus);
	
	public Optional<EDPMsTreasuryEntity> findByTreasuryNameAndActiveStatus(String officeName, int activeStatus);

	public List<EDPMsTreasuryEntity> findByActiveStatusEqualsOrderByTreasuryNameAsc(int i);
}
