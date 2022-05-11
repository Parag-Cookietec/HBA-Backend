package gov.ifms.doi.reinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.legalentry.entity.DOIJPALegalDetailEntryEntity;
import gov.ifms.doi.reinsurance.entity.DoiRiPolicyDtlEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DoiRiPolicyDtlRepository extends JpaRepository<DoiRiPolicyDtlEntity, Long>, JpaSpecificationExecutor<DOIJPALegalDetailEntryEntity>{
	
}