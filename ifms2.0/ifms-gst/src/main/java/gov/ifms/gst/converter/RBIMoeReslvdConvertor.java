package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIMoeReslvdCaseDto;
import gov.ifms.gst.entity.RBIMoeReslvdCase;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIMoeReslvdConvertor implements BaseConverter<RBIMoeReslvdCase, RBIMoeReslvdCaseDto> {
	@Override
	public RBIMoeReslvdCase toEntity(RBIMoeReslvdCaseDto dto) {
		RBIMoeReslvdCase entity = new RBIMoeReslvdCase();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIMoeReslvdCaseDto toDTO(RBIMoeReslvdCase entity) {
		RBIMoeReslvdCaseDto dto = new RBIMoeReslvdCaseDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
