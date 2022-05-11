package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.entity.EDPDesignationItrEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;

/**
 * The Class EDPDesignationItrConverter.
 */
@Component
public class EDPDesignationItrConverter implements BaseConverter<EDPDesignationItrEntity, EDPMsDesignationDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsDesignation entity
	 */
	@Override
	public EDPDesignationItrEntity toEntity(EDPMsDesignationDto dto) {
		EDPDesignationItrEntity entity = new EDPDesignationItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsDesignation dto
	 */
	@Override
	public EDPMsDesignationDto toDTO(EDPDesignationItrEntity entity) {
		EDPMsDesignationDto dto = new EDPMsDesignationDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * To entity.
	 *
	 * @param officeEntity the office entity
	 * @return the EDP designation itr entity
	 */
	public EDPDesignationItrEntity toEntity(EDPMsDesignationEntity officeEntity) {
		EDPDesignationItrEntity entity = new EDPDesignationItrEntity();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setDesignationId(officeEntity.getDesignationId());
		entity.setStatusId(officeEntity.getStatusId());
		BeanUtils.copyProperties(officeEntity, entity);
		return entity;
	}


}
