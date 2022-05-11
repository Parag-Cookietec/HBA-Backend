package gov.ifms.pvu.converter;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.entity.PVUDeemedDateEntity;

import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUDeemedDateAttDto;
import gov.ifms.pvu.entity.PVUDeemedDateAttEntity;


/**
 * The Class PVUDeemedDateAttConverter class.
 * 
 * @version v 1.0
 * @created 2020/03/21 11:30:34
 *
 */
@Component
public class PVUDeemedDateAttConverter extends BasePVUAttachmentConverter<PVUDeemedDateAttEntity,PVUDeemedDateAttDto> {


	@Override
	public PVUDeemedDateAttEntity createEntity() {
		return new PVUDeemedDateAttEntity();
	}

	@Override
	public PVUDeemedDateAttDto createDTO() {
		return new PVUDeemedDateAttDto();
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUDeemedDateAtt entity
	 */
	@Override
	protected PVUDeemedDateAttEntity toEntity(PVUDeemedDateAttEntity entity, PVUDeemedDateAttDto dto) {
		if (dto.getTransactionId() != null && dto.getEntityId() == null) {
			entity.setEntity(new PVUDeemedDateEntity(dto.getTransactionId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUDeemedDateAtt  dto
	 */
	@Override
	protected PVUDeemedDateAttDto toDTO(PVUDeemedDateAttEntity entity,PVUDeemedDateAttDto dto) {
		if (entity.getEntity() != null) {
			dto.setEntityId(entity.getId());
		}
		return dto;
	}

}
