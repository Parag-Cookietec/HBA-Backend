package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.ChallanDistributionSADADto;
import gov.ifms.gst.entity.ChallanDistributionSADA;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChallanDistrubutionConvertor
		implements BaseConverter<ChallanDistributionSADA, ChallanDistributionSADADto> {
	@Override
	public ChallanDistributionSADA toEntity(ChallanDistributionSADADto dto) {
		ChallanDistributionSADA entity = new ChallanDistributionSADA();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public ChallanDistributionSADADto toDTO(ChallanDistributionSADA entity) {
		ChallanDistributionSADADto dto = new ChallanDistributionSADADto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
