package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIFileHdrDto;
import gov.ifms.gst.entity.RBIFileHdr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIFileHdrConvertor implements BaseConverter<RBIFileHdr, RBIFileHdrDto> {
	@Override
	public RBIFileHdr toEntity(RBIFileHdrDto dto) {
		RBIFileHdr entity = new RBIFileHdr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIFileHdrDto toDTO(RBIFileHdr entity) {
		RBIFileHdrDto dto = new RBIFileHdrDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
