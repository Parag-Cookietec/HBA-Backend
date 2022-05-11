package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUEmployeDeptAndHodDto;
import gov.ifms.pvu.entity.PVUEmployeDeptAndHodEntity;

/**
 * The Class PVUEmployeDeptAndHodConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/10 16:26:19
 *
 */
@Component
public class PVUEmployeDeptAndHodConverter
		implements BaseConverter<PVUEmployeDeptAndHodEntity, PVUEmployeDeptAndHodDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeDeptAndHod entity
	 */
	@Override
	public PVUEmployeDeptAndHodEntity toEntity(PVUEmployeDeptAndHodDto dto) {
		PVUEmployeDeptAndHodEntity entity = new PVUEmployeDeptAndHodEntity();
		if (dto.getDepartmentId() != 0) {
			entity.setDepartmentId(dto.getDepartmentId());
		}
		if (dto.getHodId() != 0) {
			entity.setHodId(dto.getHodId());

		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeDeptAndHod dto
	 */
	@Override
	public PVUEmployeDeptAndHodDto toDTO(PVUEmployeDeptAndHodEntity entity) {
		PVUEmployeDeptAndHodDto dto = new PVUEmployeDeptAndHodDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
