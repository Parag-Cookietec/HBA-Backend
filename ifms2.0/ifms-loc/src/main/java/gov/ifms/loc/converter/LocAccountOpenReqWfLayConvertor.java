package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqWfLayDto;
import gov.ifms.loc.entity.LocAccountOpenReqWfLayEntity;

/**
 * The Class LocAccountOpenReqDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocAccountOpenReqWfLayConvertor
		implements BaseConverter<LocAccountOpenReqWfLayEntity, LocAccountOpenReqWfLayDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqDtl entity
	 */
	@Override
	public LocAccountOpenReqWfLayEntity toEntity(LocAccountOpenReqWfLayDto dto) {
		LocAccountOpenReqWfLayEntity entity = new LocAccountOpenReqWfLayEntity();
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
	public LocAccountOpenReqWfLayDto toDTO(LocAccountOpenReqWfLayEntity entity) {
		LocAccountOpenReqWfLayDto dto = new LocAccountOpenReqWfLayDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
