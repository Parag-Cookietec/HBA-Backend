package gov.ifms.workflow.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.workflow.dto.WfReqNoGenDto;
import gov.ifms.workflow.entity.WfRequestEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * The Class MsWorkflowConverter.
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 *
 */
@Component
public class WfRequestConverter implements BaseConverter<WfRequestEntity, WfReqNoGenDto> {

	@Override
	public WfRequestEntity toEntity(WfReqNoGenDto dto) {
		WfRequestEntity entity = new WfRequestEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public WfReqNoGenDto toDTO(WfRequestEntity entity) {
		WfReqNoGenDto dto = new WfReqNoGenDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
