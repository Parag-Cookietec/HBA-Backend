package gov.ifms.doi.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ifms.doi.workflow.entity.DOIJpaLegalEntryWFEntity;

/**
 * 
 * @author Rudra
 *
 */
public interface DoiJPALegalEntryWFRepository extends JpaRepository<DOIJpaLegalEntryWFEntity, Long> {
	

}
