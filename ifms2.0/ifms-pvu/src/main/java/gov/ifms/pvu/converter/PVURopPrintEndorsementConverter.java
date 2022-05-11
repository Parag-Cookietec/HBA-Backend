package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVURopPrintEndorsementDto;
import gov.ifms.pvu.entity.PVURevisionOfPayEntity;
import gov.ifms.pvu.entity.PVURopPrintEndorsementEntity;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVURopPrintEndorsementConverter class.
 * 
 * @version v 1.0
 * @created 2020/04/06 16:00:01
 *
 */
@Component
public class PVURopPrintEndorsementConverter
		implements BaseConverter<PVURopPrintEndorsementEntity, PVURopPrintEndorsementDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURopPrintEndorsement entity
	 */
	@Override
	public PVURopPrintEndorsementEntity toEntity(PVURopPrintEndorsementDto dto) {
		PVURopPrintEndorsementEntity entity = new PVURopPrintEndorsementEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getTrnId() != null && dto.getTrnId() != 0) {
			entity.setPvuRevisionOfPayEntity(new PVURevisionOfPayEntity(dto.getTrnId()));
		}
		if (dto.getStatus() != null && dto.getStatus() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatus()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVURopPrintEndorsement dto
	 */
	@Override
	public PVURopPrintEndorsementDto toDTO(PVURopPrintEndorsementEntity entity) {
		PVURopPrintEndorsementDto dto = new PVURopPrintEndorsementDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getPvuRevisionOfPayEntity() != null) {
			dto.setTrnId(entity.getPvuRevisionOfPayEntity().getId());
		}
		if (entity.getStatusId() != null) {
			dto.setStatus(entity.getStatusId().getLookUpInfoId());
		}
		return dto;
	}

}
