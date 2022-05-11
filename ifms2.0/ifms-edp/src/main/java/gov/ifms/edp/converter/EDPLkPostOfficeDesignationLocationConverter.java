package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPLkPostOfficeDesignationLocationDto;
import gov.ifms.edp.entity.EDPLkPostOfficeDesignationLocationEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPLkPostOfficeDesignationLocationConverter class.
 * 
 * @version 1.0
 * @created 2019/08/31 14:12:31
 *
 */
@Component
public class EDPLkPostOfficeDesignationLocationConverter
		implements BaseConverter<EDPLkPostOfficeDesignationLocationEntity, EDPLkPostOfficeDesignationLocationDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLkPostOfficeDesignationLocation entity
	 */
	@Override
	public EDPLkPostOfficeDesignationLocationEntity toEntity(EDPLkPostOfficeDesignationLocationDto dto) {
		EDPLkPostOfficeDesignationLocationEntity entity = new EDPLkPostOfficeDesignationLocationEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLkPostOfficeDesignationLocation dto
	 */
	@Override
	public EDPLkPostOfficeDesignationLocationDto toDTO(EDPLkPostOfficeDesignationLocationEntity entity) {
		EDPLkPostOfficeDesignationLocationDto dto = new EDPLkPostOfficeDesignationLocationDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
