package gov.ifms.workflow.converter;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.workflow.dto.TrnBudWfDto;
import gov.ifms.workflow.entity.TrnBudWfEntity;


/**
 * The Class TrnBudWfConverter.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
@Component
public class TrnBudWfConverter implements BaseConverter<TrnBudWfEntity,TrnBudWfDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LkScWfUserRoleOffice entity
	 */
	@Override
	public TrnBudWfEntity toEntity(TrnBudWfDto dto) {
		TrnBudWfEntity entity = new TrnBudWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LkScWfUserRoleOffice  dto
	 */
	@Override
	public TrnBudWfDto toDTO(TrnBudWfEntity entity) {
		TrnBudWfDto dto = new TrnBudWfDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 *
	 * @param lstObjects
	 * @return TrnBudWfDto
	 */
	public TrnBudWfDto toView(Object[] lstObjects) {
		TrnBudWfDto dto = new TrnBudWfDto();
		dto.setTrnBudWfId(Long.parseLong(lstObjects[0].toString()));
		return dto; 
	}
	
}
