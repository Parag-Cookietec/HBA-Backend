package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUCsAttachmentDto;
import gov.ifms.pvu.entity.PVUCsAttachmentsEntity;
import gov.ifms.pvu.entity.PVUCsEventEntity;


@Component
public class PVUTikuPayAttachmentsConverter extends BasePVUAttachmentConverter<PVUCsAttachmentsEntity, PVUCsAttachmentDto> {

	@Override
	public PVUCsAttachmentsEntity createEntity() {
		return new PVUCsAttachmentsEntity();
	}

	@Override
	public PVUCsAttachmentDto createDTO() {
		return new PVUCsAttachmentDto();
	}

	@Override
	protected PVUCsAttachmentsEntity toEntity(PVUCsAttachmentsEntity entity, PVUCsAttachmentDto dto) {
		if (dto.getTransactionId() != null && entity.getChangeOfScale() == null) {
			entity.setChangeOfScale(new PVUCsEventEntity(dto.getTransactionId()));
		}
		return entity;
	}

	@Override
	protected PVUCsAttachmentDto toDTO(PVUCsAttachmentsEntity entity, PVUCsAttachmentDto dto) {
		if (entity.getChangeOfScale() != null) {
			dto.setChangeOfScaleId(entity.getChangeOfScale().getId());
		}
		return dto;
	}
	

}
