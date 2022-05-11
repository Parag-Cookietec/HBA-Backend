/**
 * 
 */
package gov.ifms.doi.coinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.doi.coinsurance.entity.DoiCoinsPremiumRegisterEntity;

/**
 * @author Rudra
 *
 */
public interface DoiCoinsPremiumRegisterRepository extends JpaRepository<DoiCoinsPremiumRegisterEntity, Long>, JpaSpecificationExecutor<DoiCoinsPremiumRegisterEntity>{

}
