package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class PVUMsPayCellConverter class.
 * 
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 *
 */
@Component
public class PVUMsPayCellConverter implements BaseConverter<PVUMsPayCellEntity, PVUMsPayCellDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUMsPayCell entity
	 */
	@Override
	public PVUMsPayCellEntity toEntity(PVUMsPayCellDto dto) {
		PVUMsPayCellEntity entity = new PVUMsPayCellEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUMsPayCell  dto
	 */
	@Override
	public PVUMsPayCellDto toDTO(PVUMsPayCellEntity entity) {
		PVUMsPayCellDto dto = new PVUMsPayCellDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
