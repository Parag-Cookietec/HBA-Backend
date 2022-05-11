package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPMsDesignationEntity;

/**
 * The Interface EDPMsDesignationRepository.
 */
@Repository
@Transactional
public interface EDPMsDesignationRepository extends JpaRepository<EDPMsDesignationEntity, Long>,
		JpaSpecificationExecutor<EDPMsDesignationEntity>, GenericDao,PagingAndSortingRepository<EDPMsDesignationEntity, Long> {


	/**
	 * Find by designation name ignore case.
	 *
	 * @param designationName the designation name
	 * @param activeStatus the active status
	 * @return the list
	 */
	 public List<EDPMsDesignationEntity> findByDesignationNameIgnoreCaseAndActiveStatus(String designationName,int activeStatus);

	/**
	 * Find top by order by designation id desc.
	 *
	 * @return the EDP ms designation entity
	 */
	public EDPMsDesignationEntity findTopByOrderByDesignationIdDesc();

	/**
	 * Find by active status equals.
	 *
	 * @param active the active
	 * @return the list
	 */
	public List<EDPMsDesignationEntity> findByActiveStatusEquals(int active);

	/**
	 * Find by active status equals with Sorting.
	 *
	 * @param active the active
	 * @param sort the sort
	 * @return the list
	 */
	public List<EDPMsDesignationEntity> findByActiveStatusEquals(int active,Sort sort);
	public List<EDPMsDesignationEntity> findByActiveStatusEqualsOrderByDesignationNameAsc(int active);

	/**
	 * Find by active status and status id look up info id.
	 *
	 * @param status the status
	 * @param activeStatus the active status
	 * @param sort the sort
	 * @return the list
	 */
	public List<EDPMsDesignationEntity> findByStatusIdLookUpInfoNameOrStatusIdIsNullAndActiveStatus(String status ,int activeStatus,Sort sort);

	/**
	 * Update active status by designation id.
	 *
	 * @param designationId the designation id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 * @throws CustomException the custom exception
	 */
	@Modifying
	@Query(value = "update EDPMsDesignationEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where designationId = :designationId")
	public int updateActiveStatusByDesignationId(@Param("designationId") long designationId,
			@Param("activeStatus") int activeStatus, @Param("updatedBy") long updatedBy,
			@Param("updatedDate") Date updatedDate) throws CustomException;
	
	/**
	 * Find by active status order by designation name asc.
	 *
	 * @param activeStatus the active status
	 * @param sort the sort
	 * @return the list
	 */
	public List<EDPMsDesignationEntity> findByActiveStatus(Integer activeStatus, Sort sort);

	/**
	 * Find by active status and designation id.
	 *
	 * @param activeStatus the active status
	 * @param designationId the designation id
	 * @return the optional
	 */
	public Optional<EDPMsDesignationEntity> findByActiveStatusAndDesignationId(Integer activeStatus, Long designationId);

	/**
	 * Gets the only id and name.
	 *
	 * @param id the id
	 * @return the only id and name
	 */
	@Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.designationId,e.designationName) from EDPMsDesignationEntity e where e.designationId = :id")
	IdNameDto getOnlyIdAndName(@Param("id") Long id);
	
	/**
	 * Update objection for header.
	 *
	 * @param hasObjection the has objection
	 * @param objectionRemarks the objection remarks
	 * @param designationId the designation id
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsDesignationEntity set hasObjection.lookUpInfoId = :hasObjection, objectionRemarks = :objectionRemarks where designationId = :designationId")
	public int updateObjectionForHeader(@Param("hasObjection") Long hasObjection, @Param("objectionRemarks") String objectionRemarks,@Param("designationId") Long designationId);

	/**
	 * Update status for header.
	 *
	 * @param designationId the designation id
	 * @param statusId the status id
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPMsDesignationEntity hdrEntity set hdrEntity.statusId.lookUpInfoId = :statusId,hdrEntity.updatedBy=:updatedBy , "
			+ "hdrEntity.updatedDate=:updatedDate where hdrEntity.designationId = :designationId")
	public int updateStatusForHeader(@Param("designationId") Long designationId, @Param("statusId") Long statusId,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	/**
	 * Gets the only id and name.
	 *
	 * @return the only id and name
	 */
	@Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.designationId,e.designationName) from EDPMsDesignationEntity e where e.activeStatus = 1 and e.statusId.lookUpInfoId=327")
	List<IdNameDto> getOnlyIdAndName();

	int countByDesignationNameIgnoreCaseAndActiveStatus(String designationName,int activeStatus);
}
