package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.dto.PVUMsPayBandDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class PVUMsPayBandConverter class.
 * 
 * @version v 1.0
 * @created 2019/12/23 14:46:10
 *
 */
@Component
public class PVUMsPayBandConverter implements BaseConverter<PVUMsPayBandEntity,PVUMsPayBandDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUMsPayBand entity
	 */
	@Override
	public PVUMsPayBandEntity toEntity(PVUMsPayBandDto dto) {
		PVUMsPayBandEntity entity = new PVUMsPayBandEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUMsPayBand  dto
	 */
	@Override
	public PVUMsPayBandDto toDTO(PVUMsPayBandEntity entity) {
		PVUMsPayBandDto dto = new PVUMsPayBandDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
