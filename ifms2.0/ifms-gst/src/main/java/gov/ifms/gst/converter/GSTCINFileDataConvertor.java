package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.EODCINFileDataDto;
import gov.ifms.gst.entity.EODCINFileData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GSTCINFileDataConvertor implements BaseConverter<EODCINFileData, EODCINFileDataDto> {
	@Override
	public EODCINFileData toEntity(EODCINFileDataDto dto) {
		EODCINFileData entity = new EODCINFileData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public EODCINFileDataDto toDTO(EODCINFileData entity) {
		EODCINFileDataDto dto = new EODCINFileDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
