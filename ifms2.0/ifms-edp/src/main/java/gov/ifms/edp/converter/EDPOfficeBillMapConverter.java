package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPOfficeBillMapDto;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;

/**
 * The Class EDPOfficeBillMapConverter.
 */
@Component
public class EDPOfficeBillMapConverter implements BaseConverter<EDPOfficeBillMapEntity, EDPOfficeBillMapDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPofficeBillMap entity
	 */
	@Override
	public EDPOfficeBillMapEntity toEntity(EDPOfficeBillMapDto dto) {
		EDPOfficeBillMapEntity entity = new EDPOfficeBillMapEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPofficeBillMap dto
	 */
	@Override
	public EDPOfficeBillMapDto toDTO(EDPOfficeBillMapEntity entity) {
		EDPOfficeBillMapDto dto = new EDPOfficeBillMapDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
