package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.NonReconHeadsDataDto;
import gov.ifms.gst.entity.NonReconHeadsData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NonReconHeadsConvertor implements BaseConverter<NonReconHeadsData, NonReconHeadsDataDto> {
	@Override
	public NonReconHeadsData toEntity(NonReconHeadsDataDto dto) {
		NonReconHeadsData entity = new NonReconHeadsData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public NonReconHeadsDataDto toDTO(NonReconHeadsData entity) {
		NonReconHeadsDataDto dto = new NonReconHeadsDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
