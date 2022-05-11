package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIFileTranxnDto;
import gov.ifms.gst.entity.RBIFileTranxn;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIFileTranxnConvertor implements BaseConverter<RBIFileTranxn, RBIFileTranxnDto> {
	@Override
	public RBIFileTranxn toEntity(RBIFileTranxnDto dto) {
		RBIFileTranxn entity = new RBIFileTranxn();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIFileTranxnDto toDTO(RBIFileTranxn entity) {
		RBIFileTranxnDto dto = new RBIFileTranxnDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
