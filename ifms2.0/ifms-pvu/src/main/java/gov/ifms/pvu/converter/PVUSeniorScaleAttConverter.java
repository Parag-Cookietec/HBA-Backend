package gov.ifms.pvu.converter;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUSeniorScaleAttDto;
import gov.ifms.pvu.entity.PVUSeniorScaleAttEntity;
import gov.ifms.pvu.entity.PVUSeniorScaleEntity;
import org.springframework.stereotype.Component;

@Component
public class PVUSeniorScaleAttConverter extends BasePVUAttachmentConverter<PVUSeniorScaleAttEntity, PVUSeniorScaleAttDto> {


    @Override
    protected PVUSeniorScaleAttEntity toEntity(PVUSeniorScaleAttEntity entity, PVUSeniorScaleAttDto dto) {
        if (dto.getTransactionId() != null && entity.getEntity() == null) {
            entity.setEntity(new PVUSeniorScaleEntity(dto.getTransactionId()));
        }
        return entity;
    }

    @Override
    protected PVUSeniorScaleAttDto toDTO(PVUSeniorScaleAttEntity entity, PVUSeniorScaleAttDto dto) {
        if (entity.getEntity() != null) {
            dto.setEntityId(entity.getId());
        }
        return dto;
    }

    @Override
    public PVUSeniorScaleAttEntity createEntity() {
        return new PVUSeniorScaleAttEntity();
    }

    @Override
    public PVUSeniorScaleAttDto createDTO() {
        return new PVUSeniorScaleAttDto();
    }
}
