package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.LoadBalancerHADto;
import gov.ifms.gst.entity.LoadBalancerHA;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LoadBalancerHAConvertor implements BaseConverter<LoadBalancerHA, LoadBalancerHADto> {
	@Override
	public LoadBalancerHA toEntity(LoadBalancerHADto dto) {
		LoadBalancerHA entity = new LoadBalancerHA();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public LoadBalancerHADto toDTO(LoadBalancerHA entity) {
		LoadBalancerHADto dto = new LoadBalancerHADto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
