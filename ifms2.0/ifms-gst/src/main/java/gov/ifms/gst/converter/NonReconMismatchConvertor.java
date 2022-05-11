package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.NonReconMismatchDataDto;
import gov.ifms.gst.entity.NonReconMismatchData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NonReconMismatchConvertor implements BaseConverter<NonReconMismatchData, NonReconMismatchDataDto> {
	@Override
	public NonReconMismatchData toEntity(NonReconMismatchDataDto dto) {
		NonReconMismatchData entity = new NonReconMismatchData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public NonReconMismatchDataDto toDTO(NonReconMismatchData entity) {
		NonReconMismatchDataDto dto = new NonReconMismatchDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
