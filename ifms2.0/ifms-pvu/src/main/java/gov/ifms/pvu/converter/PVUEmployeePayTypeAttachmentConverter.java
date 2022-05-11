package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUEmployeePayTypeAttachmentDto;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeSDEntity;
import gov.ifms.pvu.entity.PVUEmployeePayTypeAttachmentEntity;

/**
 * The Class PVUReversionAttachmentConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 *
 */
@Component
public class PVUEmployeePayTypeAttachmentConverter
extends BasePVUAttachmentConverter<PVUEmployeePayTypeAttachmentEntity, PVUEmployeePayTypeAttachmentDto> {

	@Override
	public PVUEmployeePayTypeAttachmentEntity createEntity() {
		return new PVUEmployeePayTypeAttachmentEntity();
	}

	@Override
	public PVUEmployeePayTypeAttachmentDto createDTO() {
		return new PVUEmployeePayTypeAttachmentDto();
	}

	@Override
	protected PVUEmployeePayTypeAttachmentEntity toEntity(PVUEmployeePayTypeAttachmentEntity entity,
			PVUEmployeePayTypeAttachmentDto dto) {
		if (dto.getTransactionId() != null && entity.getReversion() == null) {
			entity.setReversion(new PVUEmployeTypeChangeSDEntity(dto.getTransactionId()));
		}
		return entity;
	}

	@Override
	protected PVUEmployeePayTypeAttachmentDto toDTO(PVUEmployeePayTypeAttachmentEntity entity, PVUEmployeePayTypeAttachmentDto dto) {
		if (entity.getReversion() != null) {
			dto.setReversionId(entity.getReversion().getTpvuRegPrboSdId());
		}
		return dto;
	}

}
