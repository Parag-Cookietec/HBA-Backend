package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsHodDto;
import gov.ifms.edp.entity.EDPMsHodEntity;

/**
 * The Class EDPMsHodConverter class.
 * 
 * @version 1.0
 * @created 2020/01/16 15:36:07
 *
 */
@Component
public class EDPMsHodConverter implements BaseConverter<EDPMsHodEntity, EDPMsHodDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsHod entity
	 */
	@Override
	public EDPMsHodEntity toEntity(EDPMsHodDto dto) {
		EDPMsHodEntity entity = new EDPMsHodEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsHod dto
	 */
	@Override
	public EDPMsHodDto toDTO(EDPMsHodEntity entity) {
		EDPMsHodDto dto = new EDPMsHodDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<ClueDto> toClueDTO(List<EDPMsHodEntity> list) {
		return list.stream().map(this::convertEntityToClueDTO).collect(Collectors.toList());
	}

	private ClueDto convertEntityToClueDTO(EDPMsHodEntity entity) {
		if (entity.getDepartmentId() != null) {
			return new ClueDto(entity.getHodId(), entity.getHodName(), null, null,
					entity.getDepartmentId().getDepartmentId());
		} else {
			return new ClueDto(entity.getHodId(), entity.getHodName());
		}
	}

}
