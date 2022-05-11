package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.GSTBlockCPINDto;
import gov.ifms.gst.entity.GSTBlockCPIN;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GSTBlockCPINConvertor implements BaseConverter<GSTBlockCPIN, GSTBlockCPINDto> {
	@Override
	public GSTBlockCPIN toEntity(GSTBlockCPINDto dto) {
		GSTBlockCPIN entity = new GSTBlockCPIN();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public GSTBlockCPINDto toDTO(GSTBlockCPIN entity) {
		GSTBlockCPINDto dto = new GSTBlockCPINDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}
