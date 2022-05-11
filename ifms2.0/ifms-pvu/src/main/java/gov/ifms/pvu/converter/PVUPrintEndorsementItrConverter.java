package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUPrintEndorsementItrDto;
import gov.ifms.pvu.entity.PVUCommonPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * The Class PVURopPrintEndorsementItrConverter class.
 *
 * @version v 1.0
 * @created 2020/04/15 17:57:19
 */
@Component
public class PVUPrintEndorsementItrConverter
		implements BaseConverter<PVUPrintEndorsementItrEntity, PVUPrintEndorsementItrDto> {

	@Override
	public PVUPrintEndorsementItrEntity toEntity(PVUPrintEndorsementItrDto dto) {
		PVUPrintEndorsementItrEntity entity = new PVUPrintEndorsementItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PVUPrintEndorsementItrDto toDTO(PVUPrintEndorsementItrEntity entity) {
		PVUPrintEndorsementItrDto dto = new PVUPrintEndorsementItrDto();
		BeanUtils.copyProperties(dto, entity);
		return dto;
	}


	public PVUPrintEndorsementItrEntity toEntity(PVUCommonPrintEndorsementEntity printEntity) {
		PVUPrintEndorsementItrEntity entity = new PVUPrintEndorsementItrEntity();
		BeanUtils.copyProperties(printEntity, entity);
		return entity;
	}
	public PVUPrintEndorsementItrEntity toEntity(PVUPrintEndorsementEntity printEntity) {
		PVUPrintEndorsementItrEntity entity = new PVUPrintEndorsementItrEntity();
		BeanUtils.copyProperties(printEntity, entity);
		return entity;
	}
}
