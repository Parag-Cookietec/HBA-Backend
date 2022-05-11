package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.dto.PVUEmployeFixPayDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;

/**
 * The Class PVUEmployeFixPayDetailsConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/08 20:46:39
 *
 */
@Component
public class PVUEmployeFixPayDetailsConverter implements BaseConverter<PVUEmployeFixPayDetailsEntity,PVUEmployeFixPayDetailsDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeFixPayDetails entity
	 */
	@Override
	public PVUEmployeFixPayDetailsEntity toEntity(PVUEmployeFixPayDetailsDto dto) {
		PVUEmployeFixPayDetailsEntity entity = new PVUEmployeFixPayDetailsEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId()!=0) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getFixPayValue() != 0) {
			entity.setFixPayValue(new EDPLuLookUpInfoEntity(dto.getFixPayValue()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeFixPayDetails  dto
	 */
	@Override
	public PVUEmployeFixPayDetailsDto toDTO(PVUEmployeFixPayDetailsEntity entity) {
		PVUEmployeFixPayDetailsDto dto = new PVUEmployeFixPayDetailsDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getEmpId()!=null) {
			dto.setEmpId(entity.getEmpId().getEmpId());
		}
		if(entity.getFixPayValue() != null) {
			dto.setFixPayValue(entity.getFixPayValue().getLookUpInfoId());
			dto.setFixPayValueName(entity.getFixPayValue().getLookUpInfoName());
		}
		return dto;
	}
	
}
