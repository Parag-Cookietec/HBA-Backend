package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeBookWfLayDto;
import gov.ifms.loc.entity.LocChequeBookWfLayEntity;

/**
 * The Class LocChqDtlWfLayConvertor class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocChequeBookWfLayConvertor implements BaseConverter<LocChequeBookWfLayEntity, LocChequeBookWfLayDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChqDtlDtl entity
	 */
	@Override
	public LocChequeBookWfLayEntity toEntity(LocChequeBookWfLayDto dto) {
		LocChequeBookWfLayEntity entity = new LocChequeBookWfLayEntity();
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
	public LocChequeBookWfLayDto toDTO(LocChequeBookWfLayEntity entity) {
		LocChequeBookWfLayDto dto = new LocChequeBookWfLayDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
