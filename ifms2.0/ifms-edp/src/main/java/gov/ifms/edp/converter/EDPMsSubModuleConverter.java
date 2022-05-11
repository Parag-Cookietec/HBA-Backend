package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsSubModuleDto;
import gov.ifms.edp.entity.EDPMsSubModuleEntity;


/**
 * The Class EDPMsSubModuleConverter.
 */
@Component
public class EDPMsSubModuleConverter implements BaseConverter<EDPMsSubModuleEntity,EDPMsSubModuleDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsModule entity
	 */
	@Override
	public EDPMsSubModuleEntity toEntity(EDPMsSubModuleDto dto) {
		EDPMsSubModuleEntity entity = new EDPMsSubModuleEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsModule  dto
	 */
	@Override
	public EDPMsSubModuleDto toDTO(EDPMsSubModuleEntity entity) {
		EDPMsSubModuleDto dto = new EDPMsSubModuleDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param moduleEntityList the module entity list
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsSubModuleEntity> moduleEntityList) {
		return moduleEntityList.stream()
				.map(entityInList -> new ClueDto(entityInList.getSubModuleId(),entityInList.getSubModuleName(),null,null))
				.collect(Collectors.toList());
	}
	
}
