package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.FileAccountingProcessedDto;
import gov.ifms.gst.entity.FileAccountingProcessed;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FileAccountingProcessedConvertor
		implements BaseConverter<FileAccountingProcessed, FileAccountingProcessedDto> {
	@Override
	public FileAccountingProcessed toEntity(FileAccountingProcessedDto dto) {
		FileAccountingProcessed entity = new FileAccountingProcessed();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public FileAccountingProcessedDto toDTO(FileAccountingProcessed entity) {
		FileAccountingProcessedDto dto = new FileAccountingProcessedDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
