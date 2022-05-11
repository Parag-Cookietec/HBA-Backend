package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.GSTCPINStatusDto;
import gov.ifms.gst.entity.GSTCPINStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
@Component
public class GSTCPINStatusConvertor implements BaseConverter<GSTCPINStatus, GSTCPINStatusDto> {
	@Override
	public GSTCPINStatus toEntity(GSTCPINStatusDto dto) {
		GSTCPINStatus entity = new GSTCPINStatus();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public GSTCPINStatusDto toDTO(GSTCPINStatus entity) {
		GSTCPINStatusDto dto = new GSTCPINStatusDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
