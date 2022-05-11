package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqSdDto;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocAccountOpenReqSdEntity;

/**
 * The Class LocAccountOpenReqSdConverter class.
 * 
 * @version 1.0
 * @created 2020/12/22 13:07:09
 *
 */
@Component
public class LocAccountOpenReqSdConverter implements BaseConverter<LocAccountOpenReqSdEntity, LocAccountOpenReqSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqSd entity
	 */
	@Override
	public LocAccountOpenReqSdEntity toEntity(LocAccountOpenReqSdDto dto) {
		LocAccountOpenReqSdEntity entity = new LocAccountOpenReqSdEntity();
		BeanUtils.copyProperties(dto, entity);
		setDtoToEntity(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqSd dto
	 */
	@Override
	public LocAccountOpenReqSdDto toDTO(LocAccountOpenReqSdEntity entity) {
		LocAccountOpenReqSdDto dto = new LocAccountOpenReqSdDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Sets the dto to entity.
	 *
	 * @param dto the dto
	 * @param entity the entity
	 */
	private void setDtoToEntity(LocAccountOpenReqSdDto dto, LocAccountOpenReqSdEntity entity) {
		if (null != dto.getLcOpenReqHdrId()) {
			entity.setLcOpenReqHdrId(new LocAccountOpenReqHdrEntity(dto.getLcOpenReqHdrId()));
		}
	}

}
