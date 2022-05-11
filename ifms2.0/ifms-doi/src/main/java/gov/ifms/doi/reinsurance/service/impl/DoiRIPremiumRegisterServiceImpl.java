package gov.ifms.doi.reinsurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.reinsurance.converter.DoiReInsuranceConverter;
import gov.ifms.doi.reinsurance.dto.DoiRiClaimDtlDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiClaimHdrDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPolicyDtlDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPolicyHdrDTO;
import gov.ifms.doi.reinsurance.dto.DoiRiPremiumRegisterDTO;
import gov.ifms.doi.reinsurance.entity.DoiRiClaimDtlEntity;
import gov.ifms.doi.reinsurance.entity.DoiRiClaimHdrEntity;
import gov.ifms.doi.reinsurance.entity.DoiRiPolicyDtlEntity;
import gov.ifms.doi.reinsurance.entity.DoiRiPolicyHdrEntity;
import gov.ifms.doi.reinsurance.entity.DoiRiPremiumRegisterEntity;
import gov.ifms.doi.reinsurance.repository.DoiRiClaimDtlRepository;
import gov.ifms.doi.reinsurance.repository.DoiRiClaimHdrRepository;
import gov.ifms.doi.reinsurance.repository.DoiRiPolicyDtlRepository;
import gov.ifms.doi.reinsurance.repository.DoiRiPolicyHdrRepository;
import gov.ifms.doi.reinsurance.repository.DoiRiPremiumRegisterRepository;
import gov.ifms.doi.reinsurance.service.DoiRIPremiumRegisterService;

/**
 * @author Rudra
 *
 */
@Service
public class DoiRIPremiumRegisterServiceImpl implements DoiRIPremiumRegisterService {

	@Autowired
	DoiReInsuranceConverter converter;
	
	@Autowired
	DoiRiPremiumRegisterRepository riPremRegiRepo;
	
	@Autowired
	DoiRiClaimDtlRepository riClaimDtlRepo;
	
	@Autowired
	DoiRiPolicyDtlRepository riPolicyDtlRepo;
	
	@Autowired
	DoiRiPolicyHdrRepository riPolicyHdrRepo;
	
	@Autowired
	DoiRiClaimHdrRepository riClaimHdrRepo;
	
	@Override
	public DoiRiPremiumRegisterDTO saveOrUpdateRIPremiumRegister(DoiRiPremiumRegisterDTO dto) {
		DoiRiPremiumRegisterEntity entity = converter.toRiPremiumRegisterEntity(dto);
		entity = riPremRegiRepo.save(entity);
		return dto;
	}

	@Override
	public List<DoiRiClaimDtlDTO> saveOrUpdateRIClaimRecoveryEntry(DoiRiClaimHdrDTO dto) {
		
		DoiRiClaimHdrEntity claimHdrEntity = converter.toRiClaimHdrEntity(dto);
		DoiRiPolicyHdrEntity doiRiPolicyHdrEntity = riPolicyHdrRepo.getByPolicyNo(dto.getPolicyNo());
		claimHdrEntity.setDoiRiPolicyHdrEntity(doiRiPolicyHdrEntity);
		claimHdrEntity = riClaimHdrRepo.save(claimHdrEntity);
		
		List<DoiRiClaimDtlEntity> claimDtlEntityList = converter.toRiClaimDtlEntities(dto.getDoiRiClaimDtl());
		for (DoiRiClaimDtlEntity claimDtlEntity : claimDtlEntityList) {
			claimDtlEntity.setDoiRiClaimHdrEntity(claimHdrEntity);
			riClaimDtlRepo.save(claimDtlEntity);
		}
		
		return dto.getDoiRiClaimDtl();
	}

	@Override
	public List<DoiRiPolicyDtlDTO> saveOrUpdateRIPolicyMaster(DoiRiPolicyHdrDTO dto) {
		
		DoiRiPolicyHdrEntity policyHdrEntity = converter.toRiPolicyHdrEntity(dto);
		policyHdrEntity = riPolicyHdrRepo.save(policyHdrEntity);
		
		List<DoiRiPolicyDtlEntity> policyDtlEntityList = converter.toRiPolicyDtlEntities(dto.getDoiRiPolicyDtl());
		for (DoiRiPolicyDtlEntity policyDtlEntity : policyDtlEntityList) {
			policyDtlEntity.setDoiRiPolicyHdrEntity(policyHdrEntity);
			riPolicyDtlRepo.save(policyDtlEntity);
		}
		
	return dto.getDoiRiPolicyDtl();
	}

	@Override
	public List<DoiRiPolicyHdrDTO> findAllPolicyDtl() {
	List<DoiRiPolicyHdrEntity>  PolicyList= riPolicyHdrRepo.findAll();
	
	List<DoiRiPolicyHdrDTO> policyhdrDTO = converter.toRiPolicyHdrDto(PolicyList);
	
	return policyhdrDTO	;
	
	}
	
}
