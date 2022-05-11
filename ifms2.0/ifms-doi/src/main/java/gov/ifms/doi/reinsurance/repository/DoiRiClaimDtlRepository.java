package gov.ifms.doi.reinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.legalentry.entity.DOIJPALegalDetailEntryEntity;
import gov.ifms.doi.reinsurance.entity.DoiRiClaimDtlEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DoiRiClaimDtlRepository extends JpaRepository<DoiRiClaimDtlEntity, Long>, JpaSpecificationExecutor<DOIJPALegalDetailEntryEntity>{
	
}