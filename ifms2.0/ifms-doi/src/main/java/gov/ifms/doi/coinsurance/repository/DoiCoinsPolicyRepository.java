/**
 * 
 */
package gov.ifms.doi.coinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.doi.coinsurance.entity.DoiCoinsPolicyHdrEntity;

/**
 * @author Rudra
 *
 */
public interface DoiCoinsPolicyRepository extends JpaRepository<DoiCoinsPolicyHdrEntity, Long>, JpaSpecificationExecutor<DoiCoinsPolicyHdrEntity>{

	DoiCoinsPolicyHdrEntity findByCoinsPolicyHdrId(long coinsPolicyHdrId);

}
