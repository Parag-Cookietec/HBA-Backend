package gov.ifms.doi.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ifms.doi.workflow.entity.DoiCoinsClaimHdrWfEntity;

/**
 * 
 * @author Rudra
 *
 */
public interface DoiCoinsClaimEntryWFRepository extends JpaRepository<DoiCoinsClaimHdrWfEntity, Long> {
	

}
