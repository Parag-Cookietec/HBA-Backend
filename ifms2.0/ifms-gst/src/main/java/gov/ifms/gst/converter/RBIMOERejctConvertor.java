package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIMOERejctCaseAcknwlgeDto;
import gov.ifms.gst.entity.RBIMOERejctCaseAcknwlge;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIMOERejctConvertor implements BaseConverter<RBIMOERejctCaseAcknwlge, RBIMOERejctCaseAcknwlgeDto> {
	@Override
	public RBIMOERejctCaseAcknwlge toEntity(RBIMOERejctCaseAcknwlgeDto dto) {
		RBIMOERejctCaseAcknwlge entity = new RBIMOERejctCaseAcknwlge();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIMOERejctCaseAcknwlgeDto toDTO(RBIMOERejctCaseAcknwlge entity) {
		RBIMOERejctCaseAcknwlgeDto dto = new RBIMOERejctCaseAcknwlgeDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
