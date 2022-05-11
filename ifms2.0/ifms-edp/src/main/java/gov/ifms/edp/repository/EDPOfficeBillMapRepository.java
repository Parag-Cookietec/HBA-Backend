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

import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;

/**
 * The Interface EDPOfficeBillMapRepository.
 */
@Repository
@Transactional
public interface EDPOfficeBillMapRepository extends JpaRepository<EDPOfficeBillMapEntity,Long> , 
                  JpaSpecificationExecutor<EDPOfficeBillMapEntity> {
	
	/**
	 * Find by office id and active status.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPOfficeBillMapEntity> findByOfficeIdAndActiveStatus(Long officeId,Integer activeStatus);
	
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
	@Query(value = "update EDPOfficeBillMapEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where officeId = :officeId")
	public int updateActiveStatusByOfficeId(@Param("officeId") long officeBillMapItrId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	
	/**
	 * Find by office id and bill list id and active status.
	 *
	 * @param officeId the office id
	 * @param billListId the bill list id
	 * @param activeStatus the active status
	 * @return the EDP office bill map entity
	 */
	EDPOfficeBillMapEntity findByOfficeIdAndBillListIdAndActiveStatus(Long officeId,Long billListId,Integer activeStatus);
	
	Optional<EDPOfficeBillMapEntity> findFirstByOfficeIdAndBillSubmittedToAndActiveStatus(Long id, Long billSubTo, int activeStatus);
	
	@Query("SELECT o.officeId FROM EDPOfficeBillMapEntity o WHERE o.billSubmittedTo=:officeId AND o.activeStatus=:activeStatus")
	List<Long> getSubmitedOfficeIdByOfficeId(@Param("officeId") Long officeId,@Param("activeStatus") int activeStatus);
}
