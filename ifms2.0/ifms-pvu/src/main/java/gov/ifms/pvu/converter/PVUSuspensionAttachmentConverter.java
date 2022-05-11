package gov.ifms.pvu.converter;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUSuspensionAttachmentDto;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUSuspensionAttachmentEntity;
import org.springframework.stereotype.Component;

@Component
public class PVUSuspensionAttachmentConverter extends BasePVUAttachmentConverter<PVUSuspensionAttachmentEntity, PVUSuspensionAttachmentDto> {

    @Override
    protected PVUSuspensionAttachmentEntity toEntity(PVUSuspensionAttachmentEntity entity, PVUSuspensionAttachmentDto dto) {
        if (dto.getTransactionId() != null && entity.getSuspension() == null) {
            entity.setSuspension(new PVUEmployeSuspensionEntity(dto.getTransactionId()));
        }
        return entity;
    }

    @Override
    protected PVUSuspensionAttachmentDto toDTO(PVUSuspensionAttachmentEntity entity, PVUSuspensionAttachmentDto dto) {
        if (entity.getSuspension() != null) {
            dto.setSuspensionId(entity.getSuspension().getId());
        }
        return dto;
    }

    @Override
    public PVUSuspensionAttachmentEntity createEntity() {
        return new PVUSuspensionAttachmentEntity();
    }

    @Override
    public PVUSuspensionAttachmentDto createDTO() {
        return new PVUSuspensionAttachmentDto();
    }

}
