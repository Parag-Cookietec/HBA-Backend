package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ifms.doi.jpa.entity.DoiJPAMasterPolicy;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Transactional
@Repository
public interface DoiJPAMasterPolicyRepository extends JpaRepository<DoiJPAMasterPolicy, Long>, JpaSpecificationExecutor<DoiJPAMasterPolicy> {
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update DoiJPAMasterPolicy entity SET entity.activeStatus = 0 where entity.policyId = :policyId")
	void softDeleteById(@Param("policyId") Long policyId);
	
	public List<DoiJPAMasterPolicy> findBySchemeId(Long schemeId);
	
	@Query("select entity from DoiJPAMasterPolicy entity where entity.activeStatus = 1")
	List<DoiJPAMasterPolicy> findAllByStatus(); 
	
	@Query("select entity from DoiJPAMasterPolicy entity where entity.policyNum = :policyNumber")
	DoiJPAMasterPolicy findByPolicyNumber(String policyNumber);
}
