package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsSubTreasuryDto;
import gov.ifms.edp.entity.EDPMsSubTreasuryEntity;

/**
 * The Class EDPMsSubTreasuryConverter class.
 * 
 * @version 1.0
 * @created 2020/01/20 10:59:54
 *
 */
@Component
public class EDPMsSubTreasuryConverter implements BaseConverter<EDPMsSubTreasuryEntity, EDPMsSubTreasuryDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsSubTreasury entity
	 */
	@Override
	public EDPMsSubTreasuryEntity toEntity(EDPMsSubTreasuryDto dto) {
		EDPMsSubTreasuryEntity entity = new EDPMsSubTreasuryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsSubTreasury dto
	 */
	@Override
	public EDPMsSubTreasuryDto toDTO(EDPMsSubTreasuryEntity entity) {
		EDPMsSubTreasuryDto dto = new EDPMsSubTreasuryDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
