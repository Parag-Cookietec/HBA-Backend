package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeBookWfDto;
import gov.ifms.loc.entity.LocChequeBookWfEntity;

/**
 * The Class LocChqDtlWfConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocChequeBookWfConverter implements BaseConverter<LocChequeBookWfEntity, LocChequeBookWfDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChqDtlDtl entity
	 */
	@Override
	public LocChequeBookWfEntity toEntity(LocChequeBookWfDto dto) {
		LocChequeBookWfEntity entity = new LocChequeBookWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChqDtlDtl dto
	 */
	@Override
	public LocChequeBookWfDto toDTO(LocChequeBookWfEntity entity) {
		LocChequeBookWfDto dto = new LocChequeBookWfDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
