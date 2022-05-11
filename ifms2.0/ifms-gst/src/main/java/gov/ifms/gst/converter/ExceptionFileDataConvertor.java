package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.ExceptionFileDataDto;
import gov.ifms.gst.entity.ExceptionFileData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFileDataConvertor implements BaseConverter<ExceptionFileData, ExceptionFileDataDto> {
	@Override
	public ExceptionFileData toEntity(ExceptionFileDataDto dto) {
		ExceptionFileData entity = new ExceptionFileData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public ExceptionFileDataDto toDTO(ExceptionFileData entity) {
		ExceptionFileDataDto dto = new ExceptionFileDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
