package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqWfMoveDto;
import gov.ifms.loc.entity.LocAccountOpenReqWfMoveEntity;

/**
 * The Class LocAccountOpenReqDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocAccountOpenReqWfMoveConvertor
		implements BaseConverter<LocAccountOpenReqWfMoveEntity, LocAccountOpenReqWfMoveDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqDtl entity
	 */
	@Override
	public LocAccountOpenReqWfMoveEntity toEntity(LocAccountOpenReqWfMoveDto dto) {
		LocAccountOpenReqWfMoveEntity entity = new LocAccountOpenReqWfMoveEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqDtl dto
	 */
	@Override
	public LocAccountOpenReqWfMoveDto toDTO(LocAccountOpenReqWfMoveEntity entity) {
		LocAccountOpenReqWfMoveDto dto = new LocAccountOpenReqWfMoveDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
