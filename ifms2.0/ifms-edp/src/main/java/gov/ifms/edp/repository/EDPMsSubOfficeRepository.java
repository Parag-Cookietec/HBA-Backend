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

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;

/**
 * The Interface EDPMsSubOfficeRepository.
 */
@Repository
@Transactional
public interface EDPMsSubOfficeRepository extends JpaRepository<EDPMsSubOfficeEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsSubOfficeEntity> {
	
	/**
	 * Update active status by office id.
	 *
	 * @param subOfficeId the sub office id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsSubOfficeEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where subOfficeId = :subOfficeId")
	public int updateActiveStatusByOfficeId(@Param("subOfficeId") long subOfficeId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate); 
	
	
	
	/**
	 * Find by office id office id.
	 *
	 * @param officeId the office id
	 * @return the list
	 */
	List<EDPMsSubOfficeEntity> findByOfficeIdOfficeId(Long officeId);
	
	/**
	 * Find by active status.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsSubOfficeEntity> findByOfficeIdOfficeIdAndActiveStatus(Long officeId,int activeStatus);
	
	/**
	 * Approve all sub office by office id.
	 *
	 * @param officeId the office id
	 * @param status the status
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsSubOfficeEntity set status= :status where officeId.officeId = :officeId")
	public int approveAllSubOfficeByOfficeId(@Param("officeId") long officeId,@Param("status") long status);
	
	/**
	 * Find sub office by office and status.
	 *
	 * @param statusList the status list
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query("FROM EDPMsSubOfficeEntity subOffice WHERE (subOffice.status IS NULL OR subOffice.status In (:statusList)) AND subOffice.officeId.officeId = :officeId AND subOffice.activeStatus = :activeStatus")
	List<EDPMsSubOfficeEntity> findSubOfficeByOfficeAndStatus(Set<Long> statusList,Long officeId,int activeStatus);
	
	/**
	 * Find by sub office code and active status.
	 *
	 * @param subOfficeCode the sub office code
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsSubOfficeEntity> findBySubOfficeCodeAndActiveStatus(String subOfficeCode, int activeStatus);
	

	/**
	 * Find by sub office code and active status.
	 *
	 * @param subOfficeCode the sub office code
	 * @param activeStatus the active status
	 * @return the list
	 */
	EDPMsSubOfficeEntity findBySubOfficeIdAndActiveStatus(Long subOfficeId, int activeStatus);



		/**
	 * Find last sub office code.
	 *
	 * @param subOfficeCode the sub office code
	 * @return the long
	 */
	@Query(value = "SELECT MAX(CAST(RIGHT(S_OFFICE_CODE , 2) AS VARCHAR)) AS sss FROM " + Constant.EDP_MASTER_SCHEMA
			+ ".MS_SUB_OFFICE WHERE OFFICE_ID  =:subOfficeCode AND ACTIVE_STATUS = 1", nativeQuery = true)
	public Optional<Long>findLastSubOfficeCode(@Param("subOfficeCode") Long subOfficeCode);

	@Query("SELECT s FROM EDPSubOfficeItrEntity s WHERE s.officeTrnEntity.updOffcTrnId = :officeTrnId AND s.activeStatus = :activeStatus")
	public List<EDPSubOfficeItrEntity> findByOfficeTrnId(@Param("officeTrnId") long officeTrnId, @Param("activeStatus") int activeStatus);
}


