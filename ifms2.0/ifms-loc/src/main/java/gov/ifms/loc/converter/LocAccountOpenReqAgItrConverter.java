package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqAgItrDto;
import gov.ifms.loc.entity.LocAccountOpenReqAgItrEntity;

/**
 * The Class LocAccountOpenReqAgDtlConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 21:17:12
 *
 */
@Component
public class LocAccountOpenReqAgItrConverter
		implements BaseConverter<LocAccountOpenReqAgItrEntity, LocAccountOpenReqAgItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc account open req ag itr entity
	 */
	@Override
	public LocAccountOpenReqAgItrEntity toEntity(LocAccountOpenReqAgItrDto dto) {
		LocAccountOpenReqAgItrEntity entity = new LocAccountOpenReqAgItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the loc account open req ag itr dto
	 */
	@Override
	public LocAccountOpenReqAgItrDto toDTO(LocAccountOpenReqAgItrEntity entity) {
		LocAccountOpenReqAgItrDto dto = new LocAccountOpenReqAgItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
