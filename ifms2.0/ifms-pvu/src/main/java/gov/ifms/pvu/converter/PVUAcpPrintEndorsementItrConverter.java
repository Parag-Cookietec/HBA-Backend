package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.dto.PVURopPrintEndorsementItrDto;
import gov.ifms.pvu.entity.PVUACPPrintEndorsementItrEntity;
import gov.ifms.pvu.entity.PVUCommonPrintEndorsementEntity;


/**
 * The Class PVURopPrintEndorsementItrConverter class.
 * 
 * @version v 1.0
 * @created 2020/04/15 17:57:19
 *
 */
@Component
public class PVUAcpPrintEndorsementItrConverter
		implements BaseConverter<PVUACPPrintEndorsementItrEntity, PVURopPrintEndorsementItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURopPrintEndorsementItr entity
	 */
	@Override
	public PVUACPPrintEndorsementItrEntity toEntity(PVURopPrintEndorsementItrDto dto) {
		PVUACPPrintEndorsementItrEntity entity = new PVUACPPrintEndorsementItrEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getStatus() != null || dto.getStatus() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatus()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVURopPrintEndorsementItr dto
	 */
	@Override
	public PVURopPrintEndorsementItrDto toDTO(PVUACPPrintEndorsementItrEntity entity) {
		PVURopPrintEndorsementItrDto dto = new PVURopPrintEndorsementItrDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getStatusId() != null) {
			dto.setStatus(entity.getStatusId().getLookUpInfoId());
		}		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param printEntity the print entity
	 * @return the PVU rop print endorsement itr entity
	 */
	public PVUACPPrintEndorsementItrEntity toEntity(PVUCommonPrintEndorsementEntity printEntity) {
		PVUACPPrintEndorsementItrEntity entity = new PVUACPPrintEndorsementItrEntity();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(printEntity, entity);
	//	entity.setPvuRevisionOfPayEntity(new PVUCommonPrintEndorsementEntity(printEntity.get));
		
		
		return entity;
	}

}
