package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPtusrRgMapDtlItrDto;
import gov.ifms.edp.entity.EDPtusrRgMapDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapDtlItrEntity;

/**
 * The Class EDPtusrRgMapDtlItrConverter class.
 * 
 * @version 1.0
 * @created 2020/07/16 09:32:46
 *
 */
@Component
public class EDPtusrRgMapDtlItrConverter implements BaseConverter<EDPtusrRgMapDtlItrEntity,EDPtusrRgMapDtlItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPtusrRgMapDtlItr entity
	 */
	@Override
	public EDPtusrRgMapDtlItrEntity toEntity(EDPtusrRgMapDtlItrDto dto) {
		EDPtusrRgMapDtlItrEntity entity = new EDPtusrRgMapDtlItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPtusrRgMapDtlItr  dto
	 */
	@Override
	public EDPtusrRgMapDtlItrDto toDTO(EDPtusrRgMapDtlItrEntity entity) {
		EDPtusrRgMapDtlItrDto dto = new EDPtusrRgMapDtlItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Tusr rg map dtl entityto itr entity.
	 *
	 * @param entity the entity
	 * @return the list
	 */
	public List<EDPtusrRgMapDtlItrEntity> tusrRgMapDtlEntitytoItrEntity(List<EDPtusrRgMapDtlEntity> entity) {
		return entity.stream().map(this::tusrRgMapDtlEntitytoItrEntity).collect(Collectors.toList());
	}
	
	/**
	 * Tusr rg map dtl entityto itr entity.
	 *
	 * @param entity the entity
	 * @return the ED ptusr rg map dtl itr entity
	 */
	public EDPtusrRgMapDtlItrEntity tusrRgMapDtlEntitytoItrEntity(EDPtusrRgMapDtlEntity entity) {
		EDPtusrRgMapDtlItrEntity itrEntity = new EDPtusrRgMapDtlItrEntity();
		BeanUtils.copyProperties(entity, itrEntity);
		itrEntity.setTusrRgMapDtlId(entity);
		return itrEntity;
	}
	
}
