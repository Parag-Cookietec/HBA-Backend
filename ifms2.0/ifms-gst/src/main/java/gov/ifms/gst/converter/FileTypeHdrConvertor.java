package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.FileTypeHdrDto;
import gov.ifms.gst.entity.FileTypeHdr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FileTypeHdrConvertor implements BaseConverter<FileTypeHdr, FileTypeHdrDto> {
	@Override
	public FileTypeHdr toEntity(FileTypeHdrDto dto) {
		FileTypeHdr entity = new FileTypeHdr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public FileTypeHdrDto toDTO(FileTypeHdr entity) {
		FileTypeHdrDto dto = new FileTypeHdrDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
