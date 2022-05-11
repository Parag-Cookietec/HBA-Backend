package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.RBIAccStmtHdrDto;
import gov.ifms.gst.entity.RBIAccStmtHdr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RBIAccStmtHdrConvertor implements BaseConverter<RBIAccStmtHdr, RBIAccStmtHdrDto> {
	@Override
	public RBIAccStmtHdr toEntity(RBIAccStmtHdrDto dto) {
		RBIAccStmtHdr entity = new RBIAccStmtHdr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public RBIAccStmtHdrDto toDTO(RBIAccStmtHdr entity) {
		RBIAccStmtHdrDto dto = new RBIAccStmtHdrDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
