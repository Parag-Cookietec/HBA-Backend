package gov.ifms.doi.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ifms.doi.workflow.entity.DoiJpaClaimEntryWF;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface DoiJPAclaimEntryWFRepository extends JpaRepository<DoiJpaClaimEntryWF, Long> {
	

}
