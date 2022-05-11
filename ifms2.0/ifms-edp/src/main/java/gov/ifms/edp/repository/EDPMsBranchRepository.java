package gov.ifms.edp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Interface EDPMsBranchRepository.
 */
@Repository
@Transactional
public interface EDPMsBranchRepository extends JpaRepository<EDPMsBranchEntity,Long> , JpaSpecificationExecutor<EDPMsBranchEntity>,GenericDao{
	
	/**
	 * Find by edp ms department entity department id.
	 *
	 * @param branchTypeId the branch type id
	 * @param activeStatus the active status
	 * @return the list
	 * 
	 * List<EDPMsBranchEntity> findByEdpMsDepartmentEntityDepartmentId(Long departmentId); 
	 */
	
	List<EDPMsBranchEntity> findByBranchTypeIdLookUpInfoIdAndActiveStatus(Long branchTypeId, int activeStatus);
	
	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsBranchEntity> findByActiveStatus(int activeStatus);

	/**
	 * Find by branch id and active status.
	 *
	 * @param branchId the branch id
	 * @param activeStatus the active status
	 * @return the EDP ms branch entity
	 */
	EDPMsBranchEntity findByBranchIdAndActiveStatus(Long branchId,int activeStatus);
	
	/**
	 * Find by branch name and branch type id look up info id and edp ms office office id and active status.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the EDP ms branch entity
	 */
	@Query(value= EDPNativeSQLUtil.GET_BRANCH_BRANCHTYPE_BY_OFFICE_ID , nativeQuery = true)
	List<Object[]> getBranchAndBranchTypeByOfficeId(@Param("officeId")Long officeId,@Param("activeStatus")int activeStatus);
	
	/**
	 * Find by edp ms office office id and active status.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the list
	 */
	List<EDPMsBranchEntity> findByEdpMsOfficeOfficeIdAndActiveStatus(Long officeId,int activeStatus);
	
	/**
	 * Find by edp ms department entity department id.
	 *
	 * @param branchTypeId the branch type id
	 * @param activeStatus the active status
	 * @return the list
	 *
	 * List<EDPMsBranchEntity> findByEdpMsDepartmentEntityDepartmentId(Long departmentId);
	 */
	@Query(value= "SELECT br FROM EDPMsBranchEntity br WHERE br.branchTypeId.lookUpInfoId=:branchTypeId and br.edpMsOffice.officeId=:officeId and br.activeStatus = :activeStatus")
	List<EDPMsBranchEntity> findBranchByBranchTypeIdAndOfficeId(@Param("branchTypeId") Long branchTypeId,@Param("officeId") Long officeId,@Param("activeStatus") int activeStatus);
	
	Optional<EDPMsBranchEntity> findByBranchId(long parseLong);
}
