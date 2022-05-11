package gov.ifms.loc.workflow.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.workflow.dto.WfReqNoGenDto;
import gov.ifms.loc.workflow.entity.LocWfRequestEntity;


/**
 * The Class MsWorkflowConverter.
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 *
 */
@Component
public class LocWfRequestConverter implements BaseConverter<LocWfRequestEntity, WfReqNoGenDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc wf request entity
	 */
	@Override
	public LocWfRequestEntity toEntity(WfReqNoGenDto dto) {
		LocWfRequestEntity entity = new LocWfRequestEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the wf req no gen dto
	 */
	@Override
	public WfReqNoGenDto toDTO(LocWfRequestEntity entity) {
		WfReqNoGenDto dto = new WfReqNoGenDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
