package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUACPAttachmentDto;
import gov.ifms.pvu.entity.PVUACPAttachmentEntity;
import gov.ifms.pvu.entity.PVUEmployeAssuredCareerProgressionEntity;

/**
 * The Class PVUCsAttachmentsConverter class.
 *
 * @version v 1.0
 * @created 2020/01/11 16:50:08
 *
 */
@Component
public class PVUACPAttachmentConverter extends BasePVUAttachmentConverter<PVUACPAttachmentEntity, PVUACPAttachmentDto> {

	@Override
	public PVUACPAttachmentEntity createEntity() {
		return new PVUACPAttachmentEntity();
	}

	@Override
	public PVUACPAttachmentDto createDTO() {
		return new PVUACPAttachmentDto();
	}

	@Override
	protected PVUACPAttachmentEntity toEntity(PVUACPAttachmentEntity entity, PVUACPAttachmentDto dto) {
		if (dto.getTransactionId() != null && entity.getAcpEntity() == null) {
			entity.setAcpEntity(new PVUEmployeAssuredCareerProgressionEntity(dto.getTransactionId()));
		}
		return entity;
	}

	@Override
	protected PVUACPAttachmentDto toDTO(PVUACPAttachmentEntity entity, PVUACPAttachmentDto dto) {
		if (entity.getAcpEntity() != null) {
			dto.setTikupayEntityId(entity.getAcpEntity().getId());
		}
		return dto;
	}
}
