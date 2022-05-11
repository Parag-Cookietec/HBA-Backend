/**
 * 
 */
package gov.ifms.doi.coinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.doi.coinsurance.entity.DoiCoinsPolicyRiEntity;

/**
 * @author Rudra
 *
 */
public interface DoiCoinsPolicyRiDtlsRepository extends JpaRepository<DoiCoinsPolicyRiEntity, Long>, JpaSpecificationExecutor<DoiCoinsPolicyRiEntity>{

}
