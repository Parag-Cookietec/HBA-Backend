package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocAccountOpenReqDivisionSdDto;
import gov.ifms.loc.entity.LocAccountOpenReqDivisionSdEntity;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocAccountOpenReqDivisionSdConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 20:46:45
 *
 */
@Component
public class LocAccountOpenReqDivisionSdConverter
		implements BaseConverter<LocAccountOpenReqDivisionSdEntity, LocAccountOpenReqDivisionSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqDivisionSd entity
	 */
	@Override
	public LocAccountOpenReqDivisionSdEntity toEntity(LocAccountOpenReqDivisionSdDto dto) {
		LocAccountOpenReqDivisionSdEntity entity = new LocAccountOpenReqDivisionSdEntity();
		BeanUtils.copyProperties(dto, entity);
		if (null != dto.getLcOpenReqHdrId()) {
			entity.setLcOpenReqHdrId(new LocAccountOpenReqHdrEntity(dto.getLcOpenReqHdrId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqDivisionSd dto
	 */
	@Override
	public LocAccountOpenReqDivisionSdDto toDTO(LocAccountOpenReqDivisionSdEntity entity) {
		LocAccountOpenReqDivisionSdDto dto = new LocAccountOpenReqDivisionSdDto();
		BeanUtils.copyProperties(entity, dto);
		if (null != entity.getLcOpenReqHdrId()) {
			dto.setLcOpenReqHdrId(entity.getLcOpenReqHdrId().getLcOpenReqHdrId());
		}
		return dto;
	}

}
