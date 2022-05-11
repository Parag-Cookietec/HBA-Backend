package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPBulkEmployeeCreationDto;
import gov.ifms.edp.entity.EDPBulkEmployeeCreationEntity;

@Component
public class EDPBulkEmployeeCreationConverter implements BaseConverter<EDPBulkEmployeeCreationEntity,EDPBulkEmployeeCreationDto> {

	@Override
	public EDPBulkEmployeeCreationEntity toEntity(EDPBulkEmployeeCreationDto dto) {
		EDPBulkEmployeeCreationEntity entity = new EDPBulkEmployeeCreationEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;	
	}

	@Override
	public EDPBulkEmployeeCreationDto toDTO(EDPBulkEmployeeCreationEntity entity) {
		EDPBulkEmployeeCreationDto dto = new EDPBulkEmployeeCreationDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}
