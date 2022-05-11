package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.entity.PVURopRemarksEntity;

/**
 * The Class PVURopRemarksEntityConverter class.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 *
 */
@Component
public class PVURopRemarksConverter implements BaseConverter<PVURopRemarksEntity, PVURopRemarksDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURopRemarksEntity entity
	 */
	@Override
	public PVURopRemarksEntity toEntity(PVURopRemarksDto dto) {
		PVURopRemarksEntity entity = new PVURopRemarksEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVURopRemarksEntity dto
	 */
	@Override
	public PVURopRemarksDto toDTO(PVURopRemarksEntity entity) {
		PVURopRemarksDto dto = new PVURopRemarksDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
