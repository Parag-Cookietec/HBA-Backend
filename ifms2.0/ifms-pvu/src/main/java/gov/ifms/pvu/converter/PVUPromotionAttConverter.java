package gov.ifms.pvu.converter;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUPromotionAttDto;
import gov.ifms.pvu.entity.PVUPromotionAttEntity;
import gov.ifms.pvu.entity.PVUPromotionEntity;
import org.springframework.stereotype.Component;

@Component
public class PVUPromotionAttConverter extends BasePVUAttachmentConverter<PVUPromotionAttEntity, PVUPromotionAttDto> {


    @Override
    protected PVUPromotionAttEntity toEntity(PVUPromotionAttEntity entity, PVUPromotionAttDto dto) {
        if (dto.getTransactionId() != null && entity.getEntity() == null) {
            entity.setEntity(new PVUPromotionEntity(dto.getTransactionId()));
        }
        return entity;
    }

    @Override
    protected PVUPromotionAttDto toDTO(PVUPromotionAttEntity entity, PVUPromotionAttDto dto) {
        if (entity.getEntity() != null) {
            dto.setEntityId(entity.getId());
        }
        return dto;
    }

    @Override
    public PVUPromotionAttEntity createEntity() {
        return new PVUPromotionAttEntity();
    }

    @Override
    public PVUPromotionAttDto createDTO() {
        return new PVUPromotionAttDto();
    }
}
