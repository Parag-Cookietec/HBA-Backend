package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqDtlEntity;

/**
 * The Class LocAccountOpenReqDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocAccountOpenReqDtlConverter
		implements BaseConverter<LocAccountOpenReqDtlEntity, LocAccountOpenReqDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqDtl entity
	 */
	@Override
	public LocAccountOpenReqDtlEntity toEntity(LocAccountOpenReqDtlDto dto) {
		LocAccountOpenReqDtlEntity entity = new LocAccountOpenReqDtlEntity();
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
	public LocAccountOpenReqDtlDto toDTO(LocAccountOpenReqDtlEntity entity) {
		LocAccountOpenReqDtlDto dto = new LocAccountOpenReqDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
