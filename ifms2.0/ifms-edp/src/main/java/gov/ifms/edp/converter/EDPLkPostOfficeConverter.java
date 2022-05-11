package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPLkPostOfficeDto;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPLkPostOfficeConverter class.
 * 
 * @version 1.0
 * @created 2019/12/26 11:14:39
 *
 */
@Component
public class EDPLkPostOfficeConverter implements BaseConverter<EDPLkPostOfficeEntity,EDPLkPostOfficeDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLkPostOffice entity
	 */
	@Override
	public EDPLkPostOfficeEntity toEntity(EDPLkPostOfficeDto dto) {
		EDPLkPostOfficeEntity entity = new EDPLkPostOfficeEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLkPostOffice  dto
	 */
	@Override
	public EDPLkPostOfficeDto toDTO(EDPLkPostOfficeEntity entity) {
		EDPLkPostOfficeDto dto = new EDPLkPostOfficeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
