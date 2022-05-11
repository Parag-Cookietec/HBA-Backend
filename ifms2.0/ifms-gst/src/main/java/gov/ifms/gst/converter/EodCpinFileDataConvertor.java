package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.EodCPINFileDataDto;
import gov.ifms.gst.entity.GSTCPINFileData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EodCpinFileDataConvertor implements BaseConverter<GSTCPINFileData, EodCPINFileDataDto> {
	@Override
	public GSTCPINFileData toEntity(EodCPINFileDataDto dto) {
		GSTCPINFileData entity = new GSTCPINFileData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public EodCPINFileDataDto toDTO(GSTCPINFileData entity) {
		EodCPINFileDataDto dto = new EodCPINFileDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
