package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeBookWfMoveDto;
import gov.ifms.loc.entity.LocChequeBookWfMoveEntity;

/**
 * The Class LocChqDtlWfMoveConvertor class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocChequeBookWfMoveConvertor implements BaseConverter<LocChequeBookWfMoveEntity, LocChequeBookWfMoveDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChqDtlDtl entity
	 */
	@Override
	public LocChequeBookWfMoveEntity toEntity(LocChequeBookWfMoveDto dto) {
		LocChequeBookWfMoveEntity entity = new LocChequeBookWfMoveEntity();
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
	public LocChequeBookWfMoveDto toDTO(LocChequeBookWfMoveEntity entity) {
		LocChequeBookWfMoveDto dto = new LocChequeBookWfMoveDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
