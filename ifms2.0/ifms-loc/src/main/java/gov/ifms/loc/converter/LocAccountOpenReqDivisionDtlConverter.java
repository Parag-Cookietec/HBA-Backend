package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqDivisionDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqDivisionDtlEntity;

/**
 * The Class LocAccountOpenReqDivisionDtlConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 20:16:25
 *
 */
@Component
public class LocAccountOpenReqDivisionDtlConverter
		implements BaseConverter<LocAccountOpenReqDivisionDtlEntity, LocAccountOpenReqDivisionDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqDivisionDtl entity
	 */
	@Override
	public LocAccountOpenReqDivisionDtlEntity toEntity(LocAccountOpenReqDivisionDtlDto dto) {
		LocAccountOpenReqDivisionDtlEntity entity = new LocAccountOpenReqDivisionDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqDivisionDtl dto
	 */
	@Override
	public LocAccountOpenReqDivisionDtlDto toDTO(LocAccountOpenReqDivisionDtlEntity entity) {
		LocAccountOpenReqDivisionDtlDto dto = new LocAccountOpenReqDivisionDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
