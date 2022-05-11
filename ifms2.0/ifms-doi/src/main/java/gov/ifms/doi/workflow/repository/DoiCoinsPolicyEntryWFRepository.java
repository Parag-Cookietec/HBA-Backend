package gov.ifms.doi.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ifms.doi.workflow.entity.DoiCoinsPolicyHdrWfEntity;

/**
 * 
 * @author Rudra
 *
 */
public interface DoiCoinsPolicyEntryWFRepository extends JpaRepository<DoiCoinsPolicyHdrWfEntity, Long> {
	

}
