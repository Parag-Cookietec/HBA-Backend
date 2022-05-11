/**
 * 
 */
package gov.ifms.doi.coinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.doi.coinsurance.entity.DoiCoinsChequeRegisterEntity;

/**
 * @author Rudra
 *
 */
public interface DoiCoinsChequeRegisterRepository extends JpaRepository<DoiCoinsChequeRegisterEntity, Long>, JpaSpecificationExecutor<DoiCoinsChequeRegisterEntity>{

}
