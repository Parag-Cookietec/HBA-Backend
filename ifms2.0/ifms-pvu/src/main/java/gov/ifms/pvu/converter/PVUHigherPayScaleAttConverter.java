package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUHigherPayScaleAttDto;
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;
import gov.ifms.pvu.entity.PVUHigherPayScaleAttEntity;

@Component
public class PVUHigherPayScaleAttConverter
		extends BasePVUAttachmentConverter<PVUHigherPayScaleAttEntity, PVUHigherPayScaleAttDto> {

	@Override
	public PVUHigherPayScaleAttEntity createEntity() {
		return new PVUHigherPayScaleAttEntity();
	}

	@Override
	public PVUHigherPayScaleAttDto createDTO() {
		return new PVUHigherPayScaleAttDto();
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUDeemedDateAtt entity
	 */
	@Override
	protected PVUHigherPayScaleAttEntity toEntity(PVUHigherPayScaleAttEntity entity, PVUHigherPayScaleAttDto dto) {
		if (dto.getTransactionId() != null && dto.getEntityId() == null) {
			entity.setEntity(new PVUEmployeHigherPayScaleEventEntity(dto.getTransactionId()));
		}
		return entity;
	}

	@Override
	protected PVUHigherPayScaleAttDto toDTO(PVUHigherPayScaleAttEntity entity, PVUHigherPayScaleAttDto dto) {
		if (entity.getEntity() != null) {
			dto.setEntityId(entity.getId());
		}
		return dto;
	}

}
