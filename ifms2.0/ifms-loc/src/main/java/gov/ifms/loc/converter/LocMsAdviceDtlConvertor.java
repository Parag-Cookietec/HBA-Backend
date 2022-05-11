package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocMsAdviceDtlDto;
import gov.ifms.loc.entity.LocMsAdviceDtlEntity;

@Component
public class LocMsAdviceDtlConvertor implements BaseConverter<LocMsAdviceDtlEntity, LocMsAdviceDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc ms advice dtl entity
	 */
	@Override
	public LocMsAdviceDtlEntity toEntity(LocMsAdviceDtlDto dto) {
		LocMsAdviceDtlEntity entity = new LocMsAdviceDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the loc ms advice dtl dto
	 */
	@Override
	public LocMsAdviceDtlDto toDTO(LocMsAdviceDtlEntity entity) {
		LocMsAdviceDtlDto dto = new LocMsAdviceDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
