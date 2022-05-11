/**
 * 
 */
package gov.ifms.doi.reinsurance.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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

/**
 * @author Rudra
 *
 */
@Component
public class DoiReInsuranceConverter {

	public DoiRiPremiumRegisterEntity toRiPremiumRegisterEntity(DoiRiPremiumRegisterDTO dto) {
		DoiRiPremiumRegisterEntity entity = new DoiRiPremiumRegisterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public DoiRiClaimDtlEntity toRiClaimDtlEntity(DoiRiClaimDtlDTO dto) {
		DoiRiClaimDtlEntity entity = new DoiRiClaimDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public DoiRiClaimHdrEntity toRiClaimHdrEntity(DoiRiClaimHdrDTO dto) {
		DoiRiClaimHdrEntity entity = new DoiRiClaimHdrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DoiRiClaimDtlEntity> toRiClaimDtlEntities(List<DoiRiClaimDtlDTO> doiRiClaimDtllist) {
		List<DoiRiClaimDtlEntity> entityList = new ArrayList<>();
		doiRiClaimDtllist.forEach(dto -> entityList.add(toRiClaimDtlEntity(dto)) );
		return entityList;
	}
	
	public List<DoiRiPolicyDtlEntity> toRiPolicyDtlEntities(List<DoiRiPolicyDtlDTO> dtoList) {
		List<DoiRiPolicyDtlEntity> entityList = new ArrayList<>();
		dtoList.forEach(dto -> entityList.add(toRiPolicyDtlEntity(dto)) );
		return entityList;
	}
	
	public DoiRiPolicyDtlEntity toRiPolicyDtlEntity(DoiRiPolicyDtlDTO dto) {
		DoiRiPolicyDtlEntity entity = new DoiRiPolicyDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public DoiRiPolicyHdrEntity toRiPolicyHdrEntity(DoiRiPolicyHdrDTO doiRiPolicyHdrDTO) {
		DoiRiPolicyHdrEntity entity = new DoiRiPolicyHdrEntity();
		BeanUtils.copyProperties(doiRiPolicyHdrDTO, entity);
		return entity;
	}
	
	public DoiRiPolicyHdrDTO toRiPolicyHdrDto(DoiRiPolicyHdrEntity entity) {
		DoiRiPolicyHdrDTO dto = new DoiRiPolicyHdrDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	
	
	public List<DoiRiPolicyHdrDTO> toRiPolicyHdrDto(List<DoiRiPolicyHdrEntity> policyList) {
		List<DoiRiPolicyHdrDTO> policyHdrEntity = new ArrayList<>();
		policyList.forEach(entity -> policyHdrEntity.add(toRiPolicyHdrDto(entity)));
		return policyHdrEntity;
	}
}
