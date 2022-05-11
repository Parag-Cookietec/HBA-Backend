package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpeningReqHdrDto;
import gov.ifms.loc.entity.LocAccountOpeningRequestHdrEntity;

/**
 * The Class LocAccountOpeningReqHdrConverter.
 */
@Component
public class LocAccountOpeningReqHdrConverter implements BaseConverter<LocAccountOpeningRequestHdrEntity,LocAccountOpeningReqHdrDto>  {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc account opening request hdr entity
	 */
	@Override
	public LocAccountOpeningRequestHdrEntity toEntity(LocAccountOpeningReqHdrDto dto) {
		LocAccountOpeningRequestHdrEntity entity = new LocAccountOpeningRequestHdrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the loc account opening req hdr dto
	 */
	@Override
	public LocAccountOpeningReqHdrDto toDTO(LocAccountOpeningRequestHdrEntity entity) {
		LocAccountOpeningReqHdrDto dto = new LocAccountOpeningReqHdrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
