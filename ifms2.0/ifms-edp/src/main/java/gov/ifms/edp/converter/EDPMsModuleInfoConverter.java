package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsModuleInfoDto;
import gov.ifms.edp.entity.EDPMsModuleInfoEntity;


/**
 * The Class EDPMsModuleInfoConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 17:19:17
 *
 */
@Component
public class EDPMsModuleInfoConverter implements BaseConverter<EDPMsModuleInfoEntity,EDPMsModuleInfoDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsModuleInfo entity
	 */
	@Override
	public EDPMsModuleInfoEntity toEntity(EDPMsModuleInfoDto dto) {
		EDPMsModuleInfoEntity entity = new EDPMsModuleInfoEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsModuleInfo  dto
	 */
	@Override
	public EDPMsModuleInfoDto toDTO(EDPMsModuleInfoEntity entity) {
		EDPMsModuleInfoDto dto = new EDPMsModuleInfoDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
