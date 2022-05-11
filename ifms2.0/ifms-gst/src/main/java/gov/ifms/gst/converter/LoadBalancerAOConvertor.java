package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.LoadBalancerAODto;
import gov.ifms.gst.entity.LoadBalancerAO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LoadBalancerAOConvertor implements BaseConverter<LoadBalancerAO, LoadBalancerAODto> {
	@Override
	public LoadBalancerAO toEntity(LoadBalancerAODto dto) {
		LoadBalancerAO entity = new LoadBalancerAO();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public LoadBalancerAODto toDTO(LoadBalancerAO entity) {
		LoadBalancerAODto dto = new LoadBalancerAODto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
