package gov.ifms.doi.reinsurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.legalentry.entity.DOIJPALegalDetailEntryEntity;
import gov.ifms.doi.reinsurance.entity.DoiRiPolicyHdrEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DoiRiPolicyHdrRepository extends JpaRepository<DoiRiPolicyHdrEntity, Long>, JpaSpecificationExecutor<DOIJPALegalDetailEntryEntity>{

	DoiRiPolicyHdrEntity getByPolicyNo(String policyNo);
 
}