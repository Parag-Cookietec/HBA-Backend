package gov.ifms.pvu.converter;

import org.springframework.stereotype.Component;

import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.dto.PVURopAttachmentDto;
import gov.ifms.pvu.entity.PVURevisionOfPayEntity;
import gov.ifms.pvu.entity.PVURopAttachmentEntity;

/**
 * The Class PVURopAttachmentConverter class.
 * 
 * @version v 1.0
 * @created 2020/03/17 11:14:39
 *
 */
@Component
public class PVURopAttachmentConverter extends BasePVUAttachmentConverter<PVURopAttachmentEntity, PVURopAttachmentDto> {

	/**
	 * Creates the entity.
	 *
	 * @return the PVU rop attachment entity
	 */
	@Override
	public PVURopAttachmentEntity createEntity() {
		return new PVURopAttachmentEntity();
	}

	/**
	 * Creates the DTO.
	 *
	 * @return the PVU rop attachment dto
	 */
	@Override
	public PVURopAttachmentDto createDTO() {
		return new PVURopAttachmentDto();
	}

	/**
	 * To entity.
	 *
	 * @param e the e
	 * @param d the d
	 * @return the PVU rop attachment entity
	 */
	@Override
	protected PVURopAttachmentEntity toEntity(PVURopAttachmentEntity e, PVURopAttachmentDto d) {
		if (d.getTransactionId() != null && e.getPvuRevisionOfPayEntity() == null) {
			e.setPvuRevisionOfPayEntity(new PVURevisionOfPayEntity(d.getTransactionId()));
		}
		return e;
	}

	/**
	 * To DTO.
	 *
	 * @param e the e
	 * @param d the d
	 * @return the PVU rop attachment dto
	 */
	@Override
	protected PVURopAttachmentDto toDTO(PVURopAttachmentEntity e, PVURopAttachmentDto d) {
		if (e.getPvuRevisionOfPayEntity() != null) {
            d.setRolEventId(e.getPvuRevisionOfPayEntity().getId());
        }
		return d;
	}

}
