package gov.ifms.doi.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ifms.doi.workflow.entity.DoiJPAMasterPolicyWF;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface DoiJPAMasterPolicyWFRepository extends JpaRepository<DoiJPAMasterPolicyWF, Long> {
	

}
