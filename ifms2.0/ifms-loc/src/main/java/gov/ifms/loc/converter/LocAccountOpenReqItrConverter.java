package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocAccountOpenReqItrDto;
import gov.ifms.loc.entity.LocAccountOpenReqItrEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocAccountOpenReqItrConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 12:47:40
 *
 */
@Component
public class LocAccountOpenReqItrConverter implements BaseConverter<LocAccountOpenReqItrEntity,LocAccountOpenReqItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqItr entity
	 */
	@Override
	public LocAccountOpenReqItrEntity toEntity(LocAccountOpenReqItrDto dto) {
		LocAccountOpenReqItrEntity entity = new LocAccountOpenReqItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqItr  dto
	 */
	@Override
	public LocAccountOpenReqItrDto toDTO(LocAccountOpenReqItrEntity entity) {
		LocAccountOpenReqItrDto dto = new LocAccountOpenReqItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
