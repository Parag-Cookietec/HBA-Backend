package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPOfficeBillMapItrDto;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;

/**
 * The Class EDPOfficeBillMapItrConverter class.
 * 
 * @version 1.0
 * @created 2019/12/06 15:16:23
 *
 */
@Component
public class EDPOfficeBillMapItrConverter implements BaseConverter<EDPOfficeBillMapItrEntity,EDPOfficeBillMapItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPOfficeBillMapItr entity
	 */
	@Override
	public EDPOfficeBillMapItrEntity toEntity(EDPOfficeBillMapItrDto dto) {
		EDPOfficeBillMapItrEntity entity = new EDPOfficeBillMapItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPOfficeBillMapItr  dto
	 */
	@Override
	public EDPOfficeBillMapItrDto toDTO(EDPOfficeBillMapItrEntity entity) {
		EDPOfficeBillMapItrDto dto = new EDPOfficeBillMapItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * To entity.
	 *
	 * @param billMapEntity the bill map entity
	 * @return the EDP office bill map itr entity
	 */
	public EDPOfficeBillMapItrEntity toEntity(EDPOfficeBillMapEntity billMapEntity) {
		EDPOfficeBillMapItrEntity entity = new EDPOfficeBillMapItrEntity();
		BeanUtils.copyProperties(billMapEntity, entity);
		return entity;
	}
	
}
