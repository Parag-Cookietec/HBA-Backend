/**
 * 
 */
package gov.ifms.doi.reinsurance.service;

import java.util.List;

import gov.ifms.doi.reinsurance.dto.DoiRiClaimDtlDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiClaimHdrDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPolicyDtlDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPolicyHdrDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPremiumRegisterDTO;
import gov.ifms.doi.reinsurance.entity.DoiRiPolicyHdrEntity;

/**
 * @author Rudra
 *
 */
public interface DoiRIPremiumRegisterService {

	DoiRiPremiumRegisterDTO saveOrUpdateRIPremiumRegister(DoiRiPremiumRegisterDTO dto);

	List<DoiRiClaimDtlDTO> saveOrUpdateRIClaimRecoveryEntry(DoiRiClaimHdrDTO dto);

	List<DoiRiPolicyDtlDTO> saveOrUpdateRIPolicyMaster(DoiRiPolicyHdrDTO dto);

	List<DoiRiPolicyHdrDTO> findAllPolicyDtl();

	

}
