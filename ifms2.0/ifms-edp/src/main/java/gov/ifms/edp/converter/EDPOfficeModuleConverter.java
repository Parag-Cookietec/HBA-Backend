package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPOfficeModuleDto;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPOfficeModuleConverter class.
 * 
 * @version 1.0
 * @created 2019/12/06 15:00:28
 *
 */
@Component
public class EDPOfficeModuleConverter implements BaseConverter<EDPOfficeModuleEntity,EDPOfficeModuleDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPOfficeModule entity
	 */
	@Override
	public EDPOfficeModuleEntity toEntity(EDPOfficeModuleDto dto) {
		EDPOfficeModuleEntity entity = new EDPOfficeModuleEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPOfficeModule  dto
	 */
	@Override
	public EDPOfficeModuleDto toDTO(EDPOfficeModuleEntity entity) {
		EDPOfficeModuleDto dto = new EDPOfficeModuleDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
