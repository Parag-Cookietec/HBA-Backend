package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIAccStmtBalDto;
import gov.ifms.gst.entity.RBIAccStmtBal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIAccStmtBalConvertor implements BaseConverter<RBIAccStmtBal, RBIAccStmtBalDto> {
	@Override
	public RBIAccStmtBal toEntity(RBIAccStmtBalDto dto) {
		RBIAccStmtBal entity = new RBIAccStmtBal();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIAccStmtBalDto toDTO(RBIAccStmtBal entity) {
		RBIAccStmtBalDto dto = new RBIAccStmtBalDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
