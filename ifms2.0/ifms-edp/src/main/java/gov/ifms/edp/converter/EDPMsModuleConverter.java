package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsModuleDto;
import gov.ifms.edp.entity.EDPMsModuleEntity;


/**
 * The Class EDPMsModuleConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 17:17:15
 *
 */
@Component
public class EDPMsModuleConverter implements BaseConverter<EDPMsModuleEntity,EDPMsModuleDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsModule entity
	 */
	@Override
	public EDPMsModuleEntity toEntity(EDPMsModuleDto dto) {
		EDPMsModuleEntity entity = new EDPMsModuleEntity();
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
	public EDPMsModuleDto toDTO(EDPMsModuleEntity entity) {
		EDPMsModuleDto dto = new EDPMsModuleDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param moduleEntityList the module entity list
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsModuleEntity> moduleEntityList) {
		return moduleEntityList.stream()
				.map(entityInList -> new ClueDto(entityInList.getModuleID(),entityInList.getModuleName(),null,null))
				.collect(Collectors.toList());
	}
	
}
