package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIMOEConfCaseAcknwlgeDto;
import gov.ifms.gst.entity.RBIMOEConfCaseAcknwlge;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIMOEConfCaseConvertor implements BaseConverter<RBIMOEConfCaseAcknwlge, RBIMOEConfCaseAcknwlgeDto> {
	@Override
	public RBIMOEConfCaseAcknwlge toEntity(RBIMOEConfCaseAcknwlgeDto dto) {
		RBIMOEConfCaseAcknwlge entity = new RBIMOEConfCaseAcknwlge();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIMOEConfCaseAcknwlgeDto toDTO(RBIMOEConfCaseAcknwlge entity) {
		RBIMOEConfCaseAcknwlgeDto dto = new RBIMOEConfCaseAcknwlgeDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
