package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.NonReconErrorDataDto;
import gov.ifms.gst.entity.NonReconErrorData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NonReconErrorDataConvertor implements BaseConverter<NonReconErrorData, NonReconErrorDataDto> {
	@Override
	public NonReconErrorData toEntity(NonReconErrorDataDto dto) {
		NonReconErrorData entity = new NonReconErrorData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public NonReconErrorDataDto toDTO(NonReconErrorData entity) {
		NonReconErrorDataDto dto = new NonReconErrorDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
