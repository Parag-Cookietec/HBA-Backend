package gov.ifms.pvu.repository;

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

import gov.ifms.common.dao.GenericDao;
import gov.ifms.pvu.entity.PVUEmployeEntity;

/**
 * The Class PVUEmployeController.
 * 
 * @version v 1.0
 * @created 2019/11/20 12:05:07
 */

@Repository
@Transactional
public interface PVUEmployeRepository
		extends JpaRepository<PVUEmployeEntity, Long>, JpaSpecificationExecutor<PVUEmployeEntity>, GenericDao {

	/**
	 * Find by employee code.
	 *
	 * @param id the field value
	 * @return the optional
	 */
	Optional<PVUEmployeEntity> findByEmployeeCodeAndActiveStatus(Long id, int activeStatus);

	/**
	 * Find by emp id and active status.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<PVUEmployeEntity> findByEmpIdAndActiveStatus(Long id, int activeStatus);

	/**
	 * Find by pan no ignore case and status id look up info id.
	 *
	 * @param fieldValue the field value
	 * @param statusId the status id
	 * @return the list
	 */
	List<PVUEmployeEntity> findByPanNoIgnoreCaseAndStatusIdLookUpInfoId(String fieldValue, long statusId);
	
	/**
	 * Update status id for PVU employe entity.
	 *
	 * @param statusId the status id
	 * @param empId the emp id
	 */
	@Modifying(clearAutomatically = true)
	@Query("update PVUEmployeEntity pVUEmployeEntity set pVUEmployeEntity.statusId.lookUpInfoId = :statusId where pVUEmployeEntity.empId = :empId")
	void updateStatusIdForPVUEmployeEntity(@Param("statusId") long statusId, @Param("empId") long empId);

	/**
	 * Update active status by emp id.
	 *
	 * @param empId the emp id
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying(clearAutomatically = true)
	@Query(value = "update PVUEmployeEntity set activeStatus=:activeStatus , updatedBy=:updatedBy , updatedDate=:updatedDate where empId = :empId")
	public int updateActiveStatusByEmpId(@Param("empId") long empId, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	/**
	 * Update employee photo by emp id.
	 *
	 * @param empId the emp id
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 */
	@Modifying(clearAutomatically = true)
	@Query(value = "update PVUEmployeEntity set employeePhoto=:null , employeePhotoName=:null, updatedBy=:updatedBy , updatedDate=:updatedDate where empId = :empId")
	public int updateEmployeePhotoByEmpId(@Param("empId") long empId, @Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);

	@Query(value = "select emp from PVUEmployeEntity emp where emp.panNo = :panNo AND (emp.employeeCode IS NOT NULL or emp.employeeCode<>0) AND emp.statusId.lookUpInfoId = :statusId AND emp.activeStatus = :activeStatus order by emp.empId desc")
	List<PVUEmployeEntity> findExpEmpByPanNoStatusIdActiveStatus(@Param("panNo") String panNo, @Param("statusId") long statusId, @Param("activeStatus")int activeStatus);

	@Query(value = "select emp from PVUEmployeEntity emp where emp.caseNo = :caseNo AND emp.officeId.officeId = :officeId AND (emp.employeeCode IS NULL or emp.employeeCode=0) AND emp.statusId.lookUpInfoId = :statusId AND emp.activeStatus = :activeStatus order by emp.empId desc")
	List<PVUEmployeEntity> getExpEmpByCaseNo(@Param("caseNo") String caseNo,@Param("officeId") long officeId, @Param("statusId") long statusId, @Param("activeStatus") int activeStatus);

	@Query(value = "select emp from PVUEmployeEntity emp JOIN PVUEmployeDepartmentEntity dpt ON emp.empId=dpt.pvuEmployeEntity.empId where emp.caseNo = :caseNo AND dpt.empPayType.lookUpInfoId = :payTypeId AND (emp.employeeCode IS NULL or emp.employeeCode=0) AND emp.statusId.lookUpInfoId = :statusId AND emp.activeStatus = :activeStatus order by emp.empId desc")
	List<PVUEmployeEntity> getExpEmpByCaseNoFromAllOffice(@Param("caseNo") String caseNo, @Param("payTypeId") long payTypeId, @Param("statusId") long statusId, @Param("activeStatus") int activeStatus);

	@Query(value = "select emp from PVUEmployeEntity emp where emp.caseNo = :caseNo AND (emp.employeeCode IS NOT NULL or emp.employeeCode<>0) AND emp.statusId.lookUpInfoId = :statusId AND emp.activeStatus = :activeStatus order by emp.empId desc")
	List<PVUEmployeEntity> findExpEmpByCaseNoStatusIdActiveStatus(@Param("caseNo") String caseNo, @Param("statusId") long statusId, @Param("activeStatus")int activeStatus);
}