package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUReversionAttachmentDto;
import gov.ifms.pvu.entity.PVUEmployeReversionEntity;
import gov.ifms.pvu.entity.PVUReversionAttachmentEntity;

/**
 * The Class PVUReversionAttachmentConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 *
 */
@Component
public class PVUReversionAttachmentConverter
extends BasePVUAttachmentConverter<PVUReversionAttachmentEntity, PVUReversionAttachmentDto> {

	@Override
	public PVUReversionAttachmentEntity createEntity() {
		return new PVUReversionAttachmentEntity();
	}

	@Override
	public PVUReversionAttachmentDto createDTO() {
		return new PVUReversionAttachmentDto();
	}

	@Override
	protected PVUReversionAttachmentEntity toEntity(PVUReversionAttachmentEntity entity,
			PVUReversionAttachmentDto dto) {
		if (dto.getTransactionId() != null && entity.getReversion() == null) {
			entity.setReversion(new PVUEmployeReversionEntity(dto.getTransactionId()));
		}
		return entity;
	}

	@Override
	protected PVUReversionAttachmentDto toDTO(PVUReversionAttachmentEntity entity, PVUReversionAttachmentDto dto) {
		if (entity.getReversion() != null) {
			dto.setReversionId(entity.getReversion().getId());
		}
		return dto;
	}

}
