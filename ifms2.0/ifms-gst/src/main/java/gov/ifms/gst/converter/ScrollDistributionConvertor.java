package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.ScrollDistributeDto;
import gov.ifms.gst.entity.ScrollDistribute;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ScrollDistributionConvertor implements BaseConverter<ScrollDistribute, ScrollDistributeDto> {
	@Override
	public ScrollDistribute toEntity(ScrollDistributeDto dto) {
		ScrollDistribute entity = new ScrollDistribute();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public ScrollDistributeDto toDTO(ScrollDistribute entity) {
		ScrollDistributeDto dto = new ScrollDistributeDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}

