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

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;

/**
 * The Interface EDPSubOfficeItrRepository.
 */
@Repository
@Transactional
public interface EDPSubOfficeItrRepository
		extends JpaRepository<EDPSubOfficeItrEntity, Long>, JpaSpecificationExecutor<EDPSubOfficeItrEntity> {

	/**
	 * Find by sub office code and active status.
	 *
	 * @param subOfficeCode the sub office code
	 * @param activeStatus  the active status
	 * @return the list
	 */
	List<EDPSubOfficeItrEntity> findBySubOfficeCodeAndActiveStatus(String subOfficeCode, int activeStatus);

	/**
	 * Find by office id office id and active status.
	 *
	 * @param officeId     the office id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPSubOfficeItrEntity> findByOfficeIdOfficeIdAndActiveStatus(Long officeId, int activeStatus);

	/**
	 * Update active status by office id.
	 *
	 * @param subOfficeId  the sub office id
	 * @param activeStatus the active status
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPSubOfficeItrEntity set activeStatus= :activeStatus, isUpdate=2, updatedBy=:updatedBy , updatedDate=:updatedDate where subOfficeItrId = :subOfficeItrId")
	public int updateActiveStatusBySubOfficeId(@Param("subOfficeItrId") long subOfficeId,
			@Param("activeStatus") int activeStatus, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate);

	/**
	 * Gets the sub office code count.
	 *
	 * @param officeId the office id
	 * @return the sub office code count
	 */
	@Query(value = "SELECT COUNT(DISTINCT subOff.subOfficeCode) FROM EDPSubOfficeItrEntity subOff INNER JOIN EDPMsOfficeEntity off ON subOff.officeId.officeId = off.officeId WHERE off.officeId = :officeId")
	public int getSubOfficeCodeCount(@Param("officeId") Long officeId);

	/**
	 * Find last sub office code.
	 *
	 * @param subOfficeCode the sub office code
	 * @return the long
	 */
	@Query(value = "SELECT MAX(CAST(RIGHT(S_OFFICE_CODE , 2) AS VARCHAR)) AS sss FROM " + Constant.EDP_MASTER_SCHEMA
			+ " .T_SUB_OFF_ITR WHERE OFFICE_ID  =:subOfficeCode", nativeQuery = true)
	public Long findLastSubOfficeCode(@Param("subOfficeCode") Long subOfficeCode);

	/**
	 * Gets the sub office id.
	 *
	 * @param officeId the office id
	 * @return the sub office id
	 */
	@Query(value = "SELECT DISTINCT subOff.subOfficeId FROM EDPSubOfficeItrEntity subOff INNER JOIN EDPMsOfficeEntity off ON subOff.officeId.officeId = off.officeId WHERE off.officeId = :officeId AND subOff.activeStatus=0 AND subOff.isUpdate=2 AND subOff.subOfficeId IS NOT NULL")
	public List<Long> getSubOfficeId(@Param("officeId") Long officeId);

	/**
	 * Find by sub office code and active status.
	 *
	 * @param subOfficeCode the sub office code
	 * @param activeStatus  the active status
	 * @return the list
	 */
	List<EDPSubOfficeItrEntity> findBySubOfficeCode(String subOfficeCode);

	/**
	 * Update active status by office id.
	 *
	 * @param officeId     the office id
	 * @param activeStatus the active status
	 * @param updatedBy    the updated by
	 * @param updatedDate  the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPSubOfficeItrEntity set activeStatus= :activeStatus, isUpdate=2, updatedBy=:updatedBy , updatedDate=:updatedDate where officeId.officeId = :officeId and subOfficeId is null")
	public int updateActiveStatusByOfficeId(@Param("officeId") long officeId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	@Modifying
	@Query("UPDATE EDPSubOfficeItrEntity subItr "
			+ "SET subItr.activeStatus=:activeStatus, subItr.isUpdate=2, "
			+ "subItr.updatedBy=:updatedBy, subItr.updatedDate=:updatedDate "
			+ "WHERE subItr.officeTrnEntity.updOffcTrnId=:officeTrnId AND subItr.subOfficeCode IS NULL")
	int updateActiveStatusByOfficeTrnId(@Param("officeTrnId") long officeTrnId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	List<EDPSubOfficeItrEntity> findBySubOfficeIdAndActiveStatus(Long subOfficeId, int activeStatus);

}
