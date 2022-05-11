package gov.ifms.pvu.converter;

import gov.ifms.edp.entity.EDPMsBankBranchEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.pvu.dto.PVUEmpBankDetailDto;
import gov.ifms.pvu.entity.PVUEmpBankDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;

/**
 * The Class PVUEmpBankDetailConverter class.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:22:19
 *
 */
@Component
public class PVUEmpBankDetailConverter implements BaseConverter<PVUEmpBankDetailEntity, PVUEmpBankDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmpBankDetail entity
	 */
	@Override
	public PVUEmpBankDetailEntity toEntity(PVUEmpBankDetailDto dto) {
		PVUEmpBankDetailEntity entity = new PVUEmpBankDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId() != null) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getAccountType() != null) {
			entity.setAccountType(new EDPLuLookUpInfoEntity(dto.getAccountType()));
		}
		if(dto.getIfscCode() != null) {
			entity.setIfscCode(new EDPMsBankBranchEntity(dto.getIfscCode()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmpBankDetail dto
	 */
	@Override
	public PVUEmpBankDetailDto toDTO(PVUEmpBankDetailEntity entity) {
		PVUEmpBankDetailDto dto = new PVUEmpBankDetailDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getAccountType() != null) {
			dto.setAccountType(entity.getAccountType().getLookUpInfoId());
			dto.setAccountTypeName(entity.getAccountType().getLookUpInfoName());
		}
		if(entity.getIfscCode() != null) {
			dto.setIfscCode(entity.getIfscCode().getBankBranchId());
			dto.setIfscCodeName(entity.getIfscCode().getIfscCode());
		}
		return dto;
	}

}
