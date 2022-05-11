package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsVillageDto;
import gov.ifms.edp.entity.EDPMsVillageEntity;

/**
 * The Class EDPMsVillageConverter.
 */
@Component
public class EDPMsVillageConverter implements BaseConverter<EDPMsVillageEntity,EDPMsVillageDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsVillageEntity entity
	 */
	@Override
	public EDPMsVillageEntity toEntity(EDPMsVillageDto dto) {
		EDPMsVillageEntity entity = new EDPMsVillageEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsVillageEntity  dto
	 */
	@Override
	public EDPMsVillageDto toDTO(EDPMsVillageEntity entity) {
		EDPMsVillageDto dto = new EDPMsVillageDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
