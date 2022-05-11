package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPUserRoleMappingItrDto;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingItrEntity;

/**
 * The Class EDPUserRoleMappingItrConverter class.
 * 
 * @version 1.0
 * @created 2019/12/30 11:43:18
 *
 */
@Component
public class EDPUserRoleMappingItrConverter implements BaseConverter<EDPUserRoleMappingItrEntity,EDPUserRoleMappingItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPUserRoleMappingItr entity
	 */

	public EDPUserRoleMappingItrEntity toEntity(EDPUserRoleMappingEntity rgMapEntity) {
		EDPUserRoleMappingItrEntity entity = new EDPUserRoleMappingItrEntity();
		entity.setUserRoleMappingId(rgMapEntity.getUserRoleMappingId());
		BeanUtils.copyProperties(rgMapEntity, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPUserRoleMappingItr  dto
	 */
	@Override
	public EDPUserRoleMappingItrDto toDTO(EDPUserRoleMappingItrEntity entity) {
		EDPUserRoleMappingItrDto dto = new EDPUserRoleMappingItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public EDPUserRoleMappingItrEntity toEntity(EDPUserRoleMappingItrDto dto) {
		return null;
	}
	
}
