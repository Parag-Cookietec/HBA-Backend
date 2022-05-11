package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.GSTFileSummeryDto;
import gov.ifms.gst.entity.GSTFileSummery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GSTFileSummeryConvertor implements BaseConverter<GSTFileSummery, GSTFileSummeryDto> {
	
	@Override
	public GSTFileSummery toEntity(GSTFileSummeryDto dto) {
		GSTFileSummery entity = new GSTFileSummery();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public GSTFileSummeryDto toDTO(GSTFileSummery entity) {
		GSTFileSummeryDto dto = new GSTFileSummeryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
