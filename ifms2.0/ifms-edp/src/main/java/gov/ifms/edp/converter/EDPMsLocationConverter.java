package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsLocationDto;
import gov.ifms.edp.entity.EDPMsLocationEntity;

/**
 * The Class EDPMsLocationConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 17:49:36
 *
 */

@Component
public class EDPMsLocationConverter implements BaseConverter<EDPMsLocationEntity, EDPMsLocationDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsLocation entity
	 */
	@Override
	public EDPMsLocationEntity toEntity(EDPMsLocationDto dto) {
		EDPMsLocationEntity entity = new EDPMsLocationEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsLocation dto
	 */
	@Override
	public EDPMsLocationDto toDTO(EDPMsLocationEntity entity) {
		EDPMsLocationDto dto = new EDPMsLocationDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * To clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsLocationEntity> list){
		return list.stream().map(entityInList->	new ClueDto(entityInList.getLocationId(), 
				entityInList.getLocationName(),entityInList.getLocationCode(),entityInList.getLocationCodeName(),
				entityInList.getParentLocationTypeId())
		).collect(Collectors.toList());
	}

}
