package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIAccStmtTranxnDto;
import gov.ifms.gst.entity.RBIAccStmtTranxn;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIAccStmtTranxnConvertor implements BaseConverter<RBIAccStmtTranxn, RBIAccStmtTranxnDto> {
	@Override
	public RBIAccStmtTranxn toEntity(RBIAccStmtTranxnDto dto) {
		RBIAccStmtTranxn entity = new RBIAccStmtTranxn();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIAccStmtTranxnDto toDTO(RBIAccStmtTranxn entity) {
		RBIAccStmtTranxnDto dto = new RBIAccStmtTranxnDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
