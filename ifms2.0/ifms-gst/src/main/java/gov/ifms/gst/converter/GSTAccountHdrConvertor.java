package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.GSTAccountHdrDto;
import gov.ifms.gst.entity.GSTAccountHdr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GSTAccountHdrConvertor implements BaseConverter<GSTAccountHdr, GSTAccountHdrDto> {
	@Override
	public GSTAccountHdr toEntity(GSTAccountHdrDto dto) {
		GSTAccountHdr entity = new GSTAccountHdr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public GSTAccountHdrDto toDTO(GSTAccountHdr entity) {
		GSTAccountHdrDto dto = new GSTAccountHdrDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
