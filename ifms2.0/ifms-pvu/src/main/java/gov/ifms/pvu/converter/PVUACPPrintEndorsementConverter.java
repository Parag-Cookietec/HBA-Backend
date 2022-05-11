package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.dto.PVURopPrintEndorsementDto;
import gov.ifms.pvu.entity.PVUCommonPrintEndorsementEntity;

/**
 * The Class PVURopPrintEndorsementConverter class.
 * 
 * @version v 1.0
 * @created 2020/04/06 16:00:01
 *
 */
@Component
public class PVUACPPrintEndorsementConverter
		implements BaseConverter<PVUCommonPrintEndorsementEntity, PVURopPrintEndorsementDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURopPrintEndorsement entity
	 */
	@Override
	public PVUCommonPrintEndorsementEntity toEntity(PVURopPrintEndorsementDto dto) {
		PVUCommonPrintEndorsementEntity entity = new PVUCommonPrintEndorsementEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getTrnId() != null && dto.getTrnId() != 0) {
			entity.setPvuTrnEventId(dto.getTrnId());
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
	public PVURopPrintEndorsementDto toDTO(PVUCommonPrintEndorsementEntity entity) {
		PVURopPrintEndorsementDto dto = new PVURopPrintEndorsementDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getStatusId() != null) {
			dto.setStatus(entity.getStatusId().getLookUpInfoId());
		}
		return dto;
	}

}
