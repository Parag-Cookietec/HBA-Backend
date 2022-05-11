package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIMoeResHdrDto;
import gov.ifms.gst.entity.RBIMoeResHdr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIMoeResHdrConvertor implements BaseConverter<RBIMoeResHdr, RBIMoeResHdrDto> {
	@Override
	public RBIMoeResHdr toEntity(RBIMoeResHdrDto dto) {
		RBIMoeResHdr entity = new RBIMoeResHdr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIMoeResHdrDto toDTO(RBIMoeResHdr entity) {
		RBIMoeResHdrDto dto = new RBIMoeResHdrDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
