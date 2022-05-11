/**
 * 
 */
package gov.ifms.doi.coinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.doi.coinsurance.entity.DoiCoinsPremiumRefundEntity;

/**
 * @author Rudra
 *
 */
public interface DoiCoinsPremiumRefundRepository extends JpaRepository<DoiCoinsPremiumRefundEntity, Long>, JpaSpecificationExecutor<DoiCoinsPremiumRefundEntity>{

}
