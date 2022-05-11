package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsTalukaDto;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPMsTalukaConverter class.
 * 
 * @version 1.0
 * @created 2019/12/11 11:50:41
 *
 */
@Component
public class EDPMsTalukaConverter implements BaseConverter<EDPMsTalukaEntity,EDPMsTalukaDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsTaluka entity
	 */
	@Override
	public EDPMsTalukaEntity toEntity(EDPMsTalukaDto dto) {
		EDPMsTalukaEntity entity = new EDPMsTalukaEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsTaluka  dto
	 */
	@Override
	public EDPMsTalukaDto toDTO(EDPMsTalukaEntity entity) {
		EDPMsTalukaDto dto = new EDPMsTalukaDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param talukaentity the talukaentity
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsTalukaEntity> talukaentity) {
		return talukaentity.stream().map(entityInList -> new ClueDto(entityInList.getTalukaId(),
				entityInList.getTalukaName(), entityInList.getTalukaCode(), null, entityInList.getDistrictId(), entityInList.getStdCode()))
				.collect(Collectors.toList());
	}
	
}
