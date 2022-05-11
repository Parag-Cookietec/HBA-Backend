package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUTikuAttachmentDto;
import gov.ifms.pvu.entity.PVUEmployeTikuPayEntity;
import gov.ifms.pvu.entity.PVUTikuAttachmentEntity;

@Component
public class PVUTikuAttachmentConverter extends BasePVUAttachmentConverter<PVUTikuAttachmentEntity, PVUTikuAttachmentDto> {

	@Override
	public PVUTikuAttachmentEntity createEntity() {
		return new PVUTikuAttachmentEntity();
	}

	@Override
	public PVUTikuAttachmentDto createDTO() {
		return new PVUTikuAttachmentDto();
	}

	@Override
	protected PVUTikuAttachmentEntity toEntity(PVUTikuAttachmentEntity entity, PVUTikuAttachmentDto dto) {
		if (dto.getTransactionId() != null && entity.getTikuPayEntity() == null) {
			entity.setTikuPayEntity(new PVUEmployeTikuPayEntity(dto.getTransactionId()));
		}
		return entity;
	}

	@Override
	protected PVUTikuAttachmentDto toDTO(PVUTikuAttachmentEntity entity, PVUTikuAttachmentDto dto) {
		if (entity.getTikuPayEntity() != null) {
			dto.setTikupayEntityId(entity.getTikuPayEntity().getId());
		}
		return dto;
	}
	

}
