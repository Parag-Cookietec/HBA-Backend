package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUSgAttachmentDto;
import gov.ifms.pvu.entity.PVUSelectionGradeEventEntity;
import gov.ifms.pvu.entity.PVUSgAttachmentEntity;

/**
 * The Class PVUSgAttachmentConverter class.
 *
 * @version v 1.0
 * @created 2019/12/19 18:51:39
 *
 */
@Component
public class PVUSgAttachmentConverter extends BasePVUAttachmentConverter<PVUSgAttachmentEntity, PVUSgAttachmentDto> {

	@Override
	public PVUSgAttachmentEntity createEntity() {
		return new PVUSgAttachmentEntity();
	}

	@Override
	public PVUSgAttachmentDto createDTO() {
		return new PVUSgAttachmentDto();
	}

	@Override
	protected PVUSgAttachmentEntity toEntity(PVUSgAttachmentEntity entity, PVUSgAttachmentDto d) {
		if (d.getTransactionId() != null && entity.getSgEntity() == null) {
			entity.setSgEntity(new PVUSelectionGradeEventEntity(d.getTransactionId()));
		}
		return entity;
	}

	@Override
	protected PVUSgAttachmentDto toDTO(PVUSgAttachmentEntity entity, PVUSgAttachmentDto dto) {
		if (entity.getSgEntity() != null) {
			dto.setSgEmpId(entity.getSgEntity().getId());
		}
		return dto;
	}

}
