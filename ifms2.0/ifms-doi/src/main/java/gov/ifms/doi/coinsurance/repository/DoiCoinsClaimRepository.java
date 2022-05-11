/**
 * 
 */
package gov.ifms.doi.coinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.doi.coinsurance.entity.DoiCoinsClaimHdrEntity;

/**
 * @author Rudra
 *
 */
public interface DoiCoinsClaimRepository extends JpaRepository<DoiCoinsClaimHdrEntity, Long>, JpaSpecificationExecutor<DoiCoinsClaimHdrEntity>{

	DoiCoinsClaimHdrEntity findByCoinsClaimId(long coinsClaimId);

}
