package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsAddressDto;
import gov.ifms.edp.entity.EDPMsAddressEntity;

/**
 * The Class EDPMsAddressConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 18:45:37
 *
 */
@Component
public class EDPMsAddressConverter implements BaseConverter<EDPMsAddressEntity, EDPMsAddressDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsAddress entity
	 */
	@Override
	public EDPMsAddressEntity toEntity(EDPMsAddressDto dto) {
		EDPMsAddressEntity entity = new EDPMsAddressEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsAddress dto
	 */
	@Override
	public EDPMsAddressDto toDTO(EDPMsAddressEntity entity) {
		EDPMsAddressDto dto = new EDPMsAddressDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
