package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVUShettyPayAttachmentDto;
import gov.ifms.pvu.entity.PVUEmployeShettyPayEntity;
import gov.ifms.pvu.entity.PVUShettyPayAttachmentEntity;

/**
 * The Class PVUShettyPayAttachmentConverter class.
 *
 * @version v 1.0
 * @created 2020/01/15 15:00:11
 *
 */
@Component
public class PVUShettyPayAttachmentConverter
		extends BasePVUAttachmentConverter<PVUShettyPayAttachmentEntity, PVUShettyPayAttachmentDto> {

	@Override
	public PVUShettyPayAttachmentEntity createEntity() {
		return new PVUShettyPayAttachmentEntity();
	}

	@Override
	public PVUShettyPayAttachmentDto createDTO() {
		return new PVUShettyPayAttachmentDto();
	}

	@Override
	protected PVUShettyPayAttachmentEntity toEntity(PVUShettyPayAttachmentEntity e, PVUShettyPayAttachmentDto d) {
		if (d.getTransactionId() != null && e.getSpId() == null) {
			e.setSpId(new PVUEmployeShettyPayEntity(d.getTransactionId()));
		}
		return e;
	}

	@Override
	protected PVUShettyPayAttachmentDto toDTO(PVUShettyPayAttachmentEntity e, PVUShettyPayAttachmentDto d) {
		if (e.getSpId() != null) {
			d.setSpId(e.getSpId().getId());
		}
		return d;
	}

}
