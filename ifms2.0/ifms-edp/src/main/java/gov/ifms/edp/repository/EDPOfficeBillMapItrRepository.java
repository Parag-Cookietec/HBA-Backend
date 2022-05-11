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

import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;

/**
 * The Interface EDPOfficeBillMapItrRepository.
 */
@Repository
@Transactional
public interface EDPOfficeBillMapItrRepository extends JpaRepository<EDPOfficeBillMapItrEntity,Long> , 
                  JpaSpecificationExecutor<EDPOfficeBillMapItrEntity> {
	
	/**
	 * Update active status by office id.
	 *
	 * @param officeBillMapItrId the office bill map itr id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPOfficeBillMapItrEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where officeId = :officeId")
	public int updateActiveStatusByOfficeId(@Param("officeId") long officeBillMapItrId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	/**
	 * Find by office id and active status.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPOfficeBillMapItrEntity> findByOfficeIdAndActiveStatus(Long officeId,Integer activeStatus);

}
