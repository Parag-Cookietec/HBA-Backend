package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUCareerAdvanceAttachmentsDto;
import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;
import gov.ifms.pvu.entity.PVUCareerAdvancementEntity;

@Component
public class PVUCareerAdvancementAttConverter extends BasePVUAttachmentConverter<PVUCareerAdvanceAttachmentsEntity, PVUCareerAdvanceAttachmentsDto> {

	@Override
    protected PVUCareerAdvanceAttachmentsEntity toEntity(PVUCareerAdvanceAttachmentsEntity entity, PVUCareerAdvanceAttachmentsDto dto) {
        if (dto.getTransactionId() != null && entity.getEntity() == null) {
            entity.setEntity(new PVUCareerAdvancementEntity(dto.getTransactionId()));
        }
        return entity;
    }

    @Override
    protected PVUCareerAdvanceAttachmentsDto toDTO(PVUCareerAdvanceAttachmentsEntity entity, PVUCareerAdvanceAttachmentsDto dto) {
        if (entity.getEntity() != null) {
            dto.setEntityId(entity.getId());
        }
        return dto;
    }

    @Override
    public PVUCareerAdvanceAttachmentsEntity createEntity() {
        return new PVUCareerAdvanceAttachmentsEntity();
    }

    @Override
    public PVUCareerAdvanceAttachmentsDto createDTO() {
        return new PVUCareerAdvanceAttachmentsDto();
    }
}
