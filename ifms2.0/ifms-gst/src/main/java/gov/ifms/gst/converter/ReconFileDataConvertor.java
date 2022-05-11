package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.ReconFileDataDto;
import gov.ifms.gst.entity.ReconFileData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ReconFileDataConvertor implements BaseConverter<ReconFileData, ReconFileDataDto> {
	@Override
	public ReconFileData toEntity(ReconFileDataDto dto) {
		ReconFileData entity = new ReconFileData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public ReconFileDataDto toDTO(ReconFileData entity) {
		ReconFileDataDto dto = new ReconFileDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
