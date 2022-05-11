package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPUpdateOfficeTrnDto;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;


/**
 * The Class UpdateOfficeTrnConverter class.
 * 
 * @version 1.0
 * @created 2020/09/21 16:41:54
 *
 */
@Component
public class EDPUpdateOfficeTrnConverter implements BaseConverter<EDPUpdateOfficeTrnEntity,EDPUpdateOfficeTrnDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the UpdateOfficeTrn entity
	 */
	@Override
	public EDPUpdateOfficeTrnEntity toEntity(EDPUpdateOfficeTrnDto dto) {
		EDPUpdateOfficeTrnEntity entity = new EDPUpdateOfficeTrnEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the UpdateOfficeTrn  dto
	 */
	@Override
	public EDPUpdateOfficeTrnDto toDTO(EDPUpdateOfficeTrnEntity entity) {
		EDPUpdateOfficeTrnDto dto = new EDPUpdateOfficeTrnDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
