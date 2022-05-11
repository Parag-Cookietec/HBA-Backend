package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.NonReconGstDataDto;
import gov.ifms.gst.entity.NonReconGstData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NonReconGstConvertor implements BaseConverter<NonReconGstData, NonReconGstDataDto> {
	@Override
	public NonReconGstData toEntity(NonReconGstDataDto dto) {
		NonReconGstData entity = new NonReconGstData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public NonReconGstDataDto toDTO(NonReconGstData entity) {
		NonReconGstDataDto dto = new NonReconGstDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
