package gov.ifms.gst.workflow.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.gst.workflow.dto.WfReqNoGenDto;
import gov.ifms.gst.workflow.entity.GstWfRequestEntity;


/**
 * The Class MsWorkflowConverter.
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 *
 */
@Component
public class GstWfRequestConverter implements BaseConverter<GstWfRequestEntity, WfReqNoGenDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the Gst wf request entity
	 */
	@Override
	public GstWfRequestEntity toEntity(WfReqNoGenDto dto) {
		GstWfRequestEntity entity = new GstWfRequestEntity();
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
	public WfReqNoGenDto toDTO(GstWfRequestEntity entity) {
		WfReqNoGenDto dto = new WfReqNoGenDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
