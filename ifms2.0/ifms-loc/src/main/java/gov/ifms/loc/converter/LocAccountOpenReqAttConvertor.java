package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqAttDto;
import gov.ifms.loc.entity.LocAccountOpenReqAttEntity;

/**
 * The Class LocAccountOpenReqDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocAccountOpenReqAttConvertor
		implements BaseConverter<LocAccountOpenReqAttEntity, LocAccountOpenReqAttDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc account open req att entity
	 */
	@Override
	public LocAccountOpenReqAttEntity toEntity(LocAccountOpenReqAttDto dto) {
		LocAccountOpenReqAttEntity entity = new LocAccountOpenReqAttEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the loc account open req att dto
	 */
	@Override
	public LocAccountOpenReqAttDto toDTO(LocAccountOpenReqAttEntity entity) {
		LocAccountOpenReqAttDto dto = new LocAccountOpenReqAttDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
