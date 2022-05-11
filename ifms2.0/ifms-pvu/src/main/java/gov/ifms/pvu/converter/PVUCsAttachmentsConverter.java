package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUCsAttachmentDto;
import gov.ifms.pvu.entity.PVUCsAttachmentsEntity;
import gov.ifms.pvu.entity.PVUCsEventEntity;

/**
 * The Class PVUCsAttachmentsConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/11 16:50:08
 *
 */
@Component
public class PVUCsAttachmentsConverter extends BasePVUAttachmentConverter<PVUCsAttachmentsEntity, PVUCsAttachmentDto> {

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
