package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqWfDto;
import gov.ifms.loc.entity.LocAccountOpenReqWfEntity;

/**
 * The Class LocAccountOpenReqDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocAccountOpenReqWfConvertor implements BaseConverter<LocAccountOpenReqWfEntity, LocAccountOpenReqWfDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqDtl entity
	 */
	@Override
	public LocAccountOpenReqWfEntity toEntity(LocAccountOpenReqWfDto dto) {
		LocAccountOpenReqWfEntity entity = new LocAccountOpenReqWfEntity();
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
	public LocAccountOpenReqWfDto toDTO(LocAccountOpenReqWfEntity entity) {
		LocAccountOpenReqWfDto dto = new LocAccountOpenReqWfDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
