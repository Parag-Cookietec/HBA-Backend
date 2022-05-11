package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocAccountOpenReqDivisionItrDto;
import gov.ifms.loc.entity.LocAccountOpenReqDivisionItrEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocAccountOpenReqDivisionItrConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 20:37:23
 *
 */
@Component
public class LocAccountOpenReqDivisionItrConverter
		implements BaseConverter<LocAccountOpenReqDivisionItrEntity, LocAccountOpenReqDivisionItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqDivisionItr entity
	 */
	@Override
	public LocAccountOpenReqDivisionItrEntity toEntity(LocAccountOpenReqDivisionItrDto dto) {
		LocAccountOpenReqDivisionItrEntity entity = new LocAccountOpenReqDivisionItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqDivisionItr dto
	 */
	@Override
	public LocAccountOpenReqDivisionItrDto toDTO(LocAccountOpenReqDivisionItrEntity entity) {
		LocAccountOpenReqDivisionItrDto dto = new LocAccountOpenReqDivisionItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
