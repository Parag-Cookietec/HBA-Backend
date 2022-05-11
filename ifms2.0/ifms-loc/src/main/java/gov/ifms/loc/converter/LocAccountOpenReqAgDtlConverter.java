package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqAgDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqAgDtlEntity;

/**
 * The Class LocAccountOpenReqAgDtlConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 21:17:12
 *
 */
@Component
public class LocAccountOpenReqAgDtlConverter
		implements BaseConverter<LocAccountOpenReqAgDtlEntity, LocAccountOpenReqAgDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc account open req ag dtl entity
	 */
	@Override
	public LocAccountOpenReqAgDtlEntity toEntity(LocAccountOpenReqAgDtlDto dto) {
		LocAccountOpenReqAgDtlEntity entity = new LocAccountOpenReqAgDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the loc account open req ag dtl dto
	 */
	@Override
	public LocAccountOpenReqAgDtlDto toDTO(LocAccountOpenReqAgDtlEntity entity) {
		LocAccountOpenReqAgDtlDto dto = new LocAccountOpenReqAgDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
