package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIAccHdrDto;
import gov.ifms.gst.entity.RBIAccHdr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIAccHdrConvertor implements BaseConverter<RBIAccHdr, RBIAccHdrDto> {
	@Override
	public RBIAccHdr toEntity(RBIAccHdrDto dto) {
		RBIAccHdr entity = new RBIAccHdr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIAccHdrDto toDTO(RBIAccHdr entity) {
		RBIAccHdrDto dto = new RBIAccHdrDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
