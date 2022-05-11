package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.dto.GenerateMoeHdrDto;
import gov.ifms.gst.entity.GenerateMoeHdr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GenerateMoeHdrConvertor implements BaseConverter<GenerateMoeHdr, GenerateMoeHdrDto> {
	@Override
	public GenerateMoeHdr toEntity(GenerateMoeHdrDto dto) {
		GenerateMoeHdr entity = new GenerateMoeHdr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		entity.setMOE_REASON(new EDPLuLookUpInfoEntity(dto.getMOE_REASON_ID()));
		return entity;
	}

	@Override
	public GenerateMoeHdrDto toDTO(GenerateMoeHdr entity) {
		GenerateMoeHdrDto dto = new GenerateMoeHdrDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		dto.setMOE_REASON_ID(entity.getMOE_REASON().getLookUpInfoId());
		dto.setMOE_REASON_NAME(entity.getMOE_REASON().getLookUpInfoName());
		return dto;
	}
}
