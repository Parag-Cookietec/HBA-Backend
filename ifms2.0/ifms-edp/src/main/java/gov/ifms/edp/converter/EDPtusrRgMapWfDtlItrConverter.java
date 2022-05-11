package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPtusrRgMapWfDtlItrDto;
import gov.ifms.edp.entity.EDPtusrRgMapWfDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapWfDtlItrEntity;

/**
 * The Class EDPtusrRgMapWfDtlItrConverter class.
 * 
 * @version 1.0
 * @created 2020/07/16 09:35:32
 *
 */
@Component
public class EDPtusrRgMapWfDtlItrConverter implements BaseConverter<EDPtusrRgMapWfDtlItrEntity,EDPtusrRgMapWfDtlItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPtusrRgMapWfDtlItr entity
	 */
	@Override
	public EDPtusrRgMapWfDtlItrEntity toEntity(EDPtusrRgMapWfDtlItrDto dto) {
		EDPtusrRgMapWfDtlItrEntity entity = new EDPtusrRgMapWfDtlItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPtusrRgMapWfDtlItr  dto
	 */
	@Override
	public EDPtusrRgMapWfDtlItrDto toDTO(EDPtusrRgMapWfDtlItrEntity entity) {
		EDPtusrRgMapWfDtlItrDto dto = new EDPtusrRgMapWfDtlItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * Tusr rg map wf dtl entity to entity.
	 *
	 * @param entity the entity
	 * @return the list
	 */
	public List<EDPtusrRgMapWfDtlItrEntity> tusrRgMapWfDtlEntityToEntity(List<EDPtusrRgMapWfDtlEntity> entity) {
		return entity.stream().map(this::tusrRgMapWfDtlEntityToEntity).collect(Collectors.toList());
	}
	
	/**
	 * Tusr rg map wf dtl entity to entity.
	 *
	 * @param entity the entity
	 * @return the ED ptusr rg map wf dtl itr entity
	 */
	public EDPtusrRgMapWfDtlItrEntity tusrRgMapWfDtlEntityToEntity(EDPtusrRgMapWfDtlEntity entity) {
		EDPtusrRgMapWfDtlItrEntity itrEntity = new EDPtusrRgMapWfDtlItrEntity();
		BeanUtils.copyProperties(entity, itrEntity);
		itrEntity.setTusrRgMapWfDtlId(entity);
		return itrEntity;
	}
	
	
}
