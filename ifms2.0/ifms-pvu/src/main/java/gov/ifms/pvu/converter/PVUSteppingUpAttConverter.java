package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUSteppingUpAttDto;
import gov.ifms.pvu.entity.PVUSteppingUpAttEntity;
import gov.ifms.pvu.entity.PVUSteppingUpEventEntity;

@Component
public class PVUSteppingUpAttConverter extends BasePVUAttachmentConverter<PVUSteppingUpAttEntity, PVUSteppingUpAttDto> {


	@Override
	protected PVUSteppingUpAttEntity toEntity(PVUSteppingUpAttEntity entity, PVUSteppingUpAttDto dto) {
		if (dto.getTransactionId() != null && entity.getEntity() == null) {
            entity.setEntity(new PVUSteppingUpEventEntity(dto.getTransactionId()));
        }
        return entity;
	}

	@Override
	protected PVUSteppingUpAttDto toDTO(PVUSteppingUpAttEntity entity, PVUSteppingUpAttDto dto) {
		   if (entity.getEntity() != null) {
	            dto.setEntityId(entity.getId());
	        }
	        return dto;
	}

	@Override
	public PVUSteppingUpAttEntity createEntity() {
		return new PVUSteppingUpAttEntity();	}

	@Override
	public PVUSteppingUpAttDto createDTO() {
      return new PVUSteppingUpAttDto();
	}
	
}
